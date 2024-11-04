package com.zyz.mybatis.base.audit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zyz
 * @version 1.0
 * @data 2024/10/31 16:40
 * @Description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
    String desc() default "无描述信息";
}

/**
 * @description: 解释说明
 *
 * 1. @Target({ElementType.METHOD})
 *    - 说明：这个注解指定了 LogAnnotation 可以应用的 Java 元素类型。ElementType.METHOD 表示这个注解只能应用于方法。
 *    - 用途：通过限制注解的应用范围，可以确保它只在方法上使用，防止误用在其他类型的元素上（如类、字段等）。
 *
 * 2. @Retention(RetentionPolicy.RUNTIME)
 *    - 说明：这个注解指定了 LogAnnotation 的生命周期。RetentionPolicy.RUNTIME 表示这个注解在运行时可用。
 *    - 用途：注解的保留策略决定了它的可访问性。使用 RUNTIME 表示在程序运行时可以通过反射机制获取该注解的信息，适合用于需要动态处理的场景，如 AOP（面向切面编程）。
 *
 * 3. public @interface LogAnnotation
 *    - 说明：这是 Java 中自定义注解的语法。@interface 表示定义一个注解类型。
 *    - 用途：自定义注解可以用来为代码提供元数据，便于在运行时进行处理或分析。
 *
 * 4. String desc() default "无描述信息";
 *    - 说明：这是注解的一个成员（属性），其类型为 String，名称为 desc。它提供了一个默认值 "无描述信息"。
 *    - 用途：使用这个属性可以为注解提供描述信息，调用这个注解的方法可以通过该属性自定义说明。即使不提供值，也会使用默认的描述。
 **/
