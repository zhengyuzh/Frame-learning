package com.zyz.mybatis.base.audit;

import com.alibaba.fastjson.JSON;
import com.zyz.mybatis.base.entity.SysLog;
import com.zyz.mybatis.utils.DateUtil;
import com.zyz.mybatis.utils.IPUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: zyz.audit
 * @Author: zhengyuzhu
 * @CreateTime: 2024-10-31  16:56
 * @Description: TODO
 * @Version: 1.0
 */
@Aspect
@Component
public class SystemLogAspect {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SystemLogAsyncTask systemLogAsyncTask;


    /**
     * @param
     * @description: Controller层切点 通过注解进行切点 凡是生命了LogAnnotation注解的方法都要进入这个切面
     **/
    @Pointcut("@annotation(com.zyz.mybatis.base.audit.LogAnnotation)")
    public void controllerAspect() {
    }

    /**
     * @param joinPoint
     * @description: 方法操作前 会进入@Before
     **/
    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint) {
    }

    /**
     * @param joinPoint 代表会记录切点的信息 就是代码运行到切点是的变量环境
     *                  可以从joinPoint获取使用的LogAnnotation信息
     *                  切点
     * @description: 方法操作成功 会进入@AfterReturning
     **/
    @AfterReturning(value = "controllerAspect()")
    public void saveOperLog(JoinPoint joinPoint) {
        handleLog(joinPoint, null);
    }

    /**
     * 方法执行中出现了异常 会出现在@AfterThrowing中
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void saveExceptionLog(JoinPoint joinPoint, Exception e) {
        log.debug("方法执行中出现了异常AfterThrowing...");
        handleLog(joinPoint, e);
    }

    /**
     * @description: 记录日志信息到数据库
     * @author: zhengyuzhu
     * @param: joinPoint
     * @param: e
     **/
    private void handleLog(JoinPoint joinPoint, Exception e) {
        try {
            //从joinPoint获得LogAnnotation注解
            LogAnnotation controllerLog = giveController(joinPoint);
            if (controllerLog == null) {
                return;
            }
            //获取request
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //通过request获取session 然后获取用户信息
            String user = (String) request.getSession().getAttribute("user");
            // if (StringUtils.isEmpty(user)) {
            //     return;
            // }

            SysLog info = new SysLog();
            String json = getReqParams(joinPoint);

            if (json.length() > 200) {
                json = json.substring(0, 200);
            }
            info.setId(UUID.randomUUID().toString().replaceAll("-", ""));// 需要id生成-db->redis
            info.setOperation(controllerLog.desc());
            info.setMethod(request.getMethod());
            info.setParams(json);
            info.setIp(IPUtils.getLocalIpAddr());
            info.setCreateTime(DateUtil.getCurrentTimeStamp());

            systemLogAsyncTask.saveOperateLog(info);//异步保存
        } catch (Exception exp) {
            //记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    private String getReqParams(JoinPoint joinPoint) {
        String result = "";
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            if (args[0] instanceof HttpServletRequest) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                result = filterParams(request);
            } else {
                result = args[0].toString();
            }
        }
        return result;
    }

    /**
     * 是否存在注解，如果存在就记录日志
     *
     * @param joinPoint
     * @param
     * @return
     * @throws Exception
     */
    private LogAnnotation giveController(JoinPoint joinPoint) throws Exception {
          /*
           * JoinPoint可以获取什么：
            l java.lang.Object[] getArgs()：获取连接点方法运行时的入参列表；
            l Signature getSignature() ：获取连接点的方法签名对象；
            l java.lang.Object getTarget() ：获取连接点所在的目标对象；
            l java.lang.Object getThis() ：获取代理对象本身；
           */
        Signature signature = joinPoint.getSignature();
           /*
            * MethodSignature可以获取什么：
               Class getReturnType(); 获取方法的返回类型
              Method getMethod(); 获取方法本身
            */
        MethodSignature methodSignature = (MethodSignature) signature;
        /**
         * Method可以获取方法上的各种信息 比如方法名称 方法参数 注解 参数上的注解等。
         */
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(LogAnnotation.class);
        }
        return null;
    }

    private String filterParams(HttpServletRequest request) {
        Map<String, String> pMap = new HashMap<>();
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("password")) {
                pMap.put(entry.getKey(), "***");
            } else {
                pMap.put(entry.getKey(), StringUtils.join(entry.getValue(), ","));
            }
        }
        return JSON.toJSONString(pMap);
    }

}
