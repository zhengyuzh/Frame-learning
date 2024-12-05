# 1、FreeMark+BootStrap+JS 实现表格内容过长浮动

只需看JS、HTML、CSS部分代码实现即可。每一部分都有详细代码说明、可以参考~

![img](https://i-blog.csdnimg.cn/direct/91504d424ca941fbbee16595ed8ef9c6.png)

## JS部分

```plain
    loadPage: function () {
        devInfoList.table = $('#mainGrid').bootstrapTable({
            url: common.url.service + 'terminalDevInfo/getPage',
            height: devInfoList.getHeight(),
            toolbar:$("#toolbarContainer"),
            showHeader: true,
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                     //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                  //是否显示详细视图和列表视图的切换按钮
            cardView: false,                   //是否显示详细视图
            detailView: false,                 //是否显示父子表
            uniqueId: "id",      //每一行的唯一标识，一般为主键列
            queryParams: function (params) {
                return $.extend({page: params}, common.getDefaultParams(), $("#searchForm").serializeObject(),{deptId: devInfoList.getDeptId()});
            },
            onLoadSuccess: function (data) {
                // 添加悬浮显示完整内容的逻辑
                $('#mainGrid td').each(function () {
                    const cell = $(this);
                    const content = cell.text().trim();
                    if (content.length > 0 && this.scrollWidth > this.clientWidth) {
                        cell.attr('title', content);
                    }
                });
            }
        });
    },
```



这段代码的作用是在加载数据网格（`#mainGrid`）时，为所有单元格（`td`）添加悬浮提示功能，显示单元格的完整内容，尤其是当单元格内容因超出宽度被截断时。以下是逐步的解释说明：

------

### **代码逐步解析**

1. `**onLoadSuccess: function (data)**`

- - 这是一个事件回调函数，通常在数据网格（如 EasyUI、DataGrid 等）加载成功后触发。
  - 参数 `data` 是加载到网格中的数据。

------

1. `**$('#mainGrid td').each(function () { ... })**`

- - 选择器 `#mainGrid td`：选中 ID 为 `mainGrid` 的表格中的所有单元格（`td`）。
  - `.each(function() { ... })`：对每个单元格逐一执行回调函数。

------

1. `**const cell = $(this);**`

- - `this`：当前遍历到的单元格元素。
  - `$(this)`：将当前单元格转换为 jQuery 对象，方便后续操作。
  - `cell`：保存该 jQuery 对象。

------

1. `**const content = cell.text().trim();**`

- - 获取单元格的文本内容并去除首尾空格。
  - `cell.text()`：提取单元格中的纯文本。
  - `.trim()`：去除可能存在的空白字符，确保内容干净。

------

1. `**if (content.length > 0 && this.scrollWidth > this.clientWidth)**`

- - 条件 1：`content.length > 0` 确保单元格内容非空。
  - 条件 2：`this.scrollWidth > this.clientWidth` 检查内容是否溢出：

- - - `scrollWidth` 是元素实际内容的宽度。
    - `clientWidth` 是元素可见区域的宽度（不含滚动条）。
    - 如果 `scrollWidth > clientWidth`，说明内容超出单元格的显示宽度。

------

1. `**cell.attr('title', content);**`

- - 为单元格元素设置 `title` 属性，值为 `content`。
  - 浏览器在用户将鼠标悬停在元素上时，会显示 `title` 内容作为悬浮提示框。
  - 这样，当内容被截断时，用户可以悬停查看完整内容。

------

### **功能总结**

这段逻辑的主要功能是：

- 检测表格的每个单元格是否存在内容溢出（被截断）。
- 如果单元格内容溢出，则设置 `title` 属性，使用户可以通过鼠标悬浮来查看完整内容。

------

### **示例场景**

假设表格的一行如下：

```plain
<tr>
    <td style="width: 50px;">This is a very long text.</td>
    <td style="width: 50px;">Short</td>
</tr>
```

- 对于第一个单元格，由于内容超出宽度，`title` 会被设置为 `"This is a very long text."`。
- 第二个单元格内容未超出宽度，则不会设置 `title`。

------

### **改进建议**

1. **性能优化**：
   如果表格行数较多，可以限制对可见部分单元格的处理，以减少不必要的计算。
2. **更精确的溢出判断**：
   考虑 `padding` 和其他 CSS 样式可能影响 `scrollWidth` 和 `clientWidth` 的差异。
3. **工具提示库**：
   可以使用更友好的工具提示库（如 `Tooltip.js`），提供更美观的悬浮提示效果，而不是原生的 `title`。

## html部分

```plain
<table id="mainGrid">
	<thead>
	<tr>
		<th data-checkbox="true"></th>
		<th data-field="termId"><@spring.message code ="deviceInfo.termNumber" /></th>
		<th data-field="termIp" ><@spring.message code ="deviceInfo.term.info.termIp" /></th>
		<th data-field="sealNum" ><@spring.message code ="deviceInfo.spnmoneyBag" /></th>
		<th data-field="partnerName" ><@spring.message code ="deviceInfo.partnerName" /></th>
		<th data-field="businessName" ><@spring.message code ="deviceInfo.merNumberName" /></th>
		<th data-field="storeName"><@spring.message code ="deviceInfo.storeNumberName" /></th>
		<th data-field="createTime"><@spring.message code ="deviceInfo.createTime" /></th>
		<th data-field="descStr"><@spring.message code ="deviceInfo.descStr" /></th>
	</tr>
	</thead>
</table>
```

这段代码是一个基于 HTML 的表格结构（`<table>`），用来展示数据，同时结合了 Spring 的国际化功能（`<@spring.message>`）动态渲染列的标题（表头）。

------

### **代码解析**

1. `**<table>**` **元素**

- - 表示一个 HTML 表格。
  - `id="mainGrid"` 给表格设置了唯一标识，通常用于 JavaScript 操作，如动态加载数据。

1. `**<thead>**` **元素**

- - 表格的头部，用于定义表头。

1. `**<tr>**` **和** `**<th>**` **元素**

- - `<tr>`：表示表格的一行。
  - `<th>`：表示表头单元格。

1. **表头中的** `**data-\***` **属性**

- - `**data-checkbox**`：

- - - 设置为 `true` 的 `th` 通常用来显示一个复选框列。

- - `**data-field**`：

- - - 用于绑定数据字段名称，数据加载时对应表头和数据的内容。
    - 示例：`data-field="termId"` 表示这一列对应数据中的 `termId` 字段。

1. `**<@spring.message>**` **标签**

- - 用于从 Spring 的国际化资源文件中获取列标题内容。
  - 示例：`<@spring.message code="deviceInfo.termNumber" />` 会根据国际化文件 `messages.properties` 或类似文件中的内容生成列标题。

------

### **表头字段说明**

| **字段**        | **描述**                                   |
| --------------- | ------------------------------------------ |
| `data-checkbox` | 是否显示复选框列，用于多选操作。           |
| `termId`        | 设备编号（从国际化配置文件中获取标题）。   |
| `termIp`        | 设备的 IP 地址。                           |
| `sealNum`       | 密封编号（可能指防伪编码或相关设备标识）。 |
| `partnerName`   | 合作伙伴名称。                             |
| `businessName`  | 商户名称或编号名称。                       |
| `storeName`     | 门店名称。                                 |
| `createTime`    | 创建时间（可能以时间戳或格式化日期显示）。 |
| `descStr`       | 描述信息（可能是设备的附加说明或备注）。   |

------

### **用途**

1. **动态国际化**

- - 通过 `<@spring.message>`，表头文本可以根据用户语言自动切换，提升多语言支持能力。
  - 示例：

- - - 如果用户语言是英文，`deviceInfo.termNumber` 可能会显示为 *"Device Number"*。
    - 如果用户语言是中文，可能会显示为 *"设备编号"*。

1. **数据绑定**

- - 表格与后台数据交互时（例如通过 Ajax 加载数据），`data-field` 会确保每列显示对应的字段内容。
  - 示例：

```plain
{
  "termId": "12345",
  "termIp": "192.168.1.1",
  "sealNum": "ABCD123",
  "partnerName": "XYZ Corp",
  "businessName": "Merchant123",
  "storeName": "Store456",
  "createTime": "2024-12-05 12:00:00",
  "descStr": "Main terminal"
}
```

1. **前端展示与操作**

- - 通常会配合表格插件（如 Bootstrap Table、DataTables）动态渲染数据和功能（如分页、排序、筛选）。

------

### **工作流程**

1. **页面加载**

- - Spring 会解析 `<@spring.message>` 标签，从国际化文件中获取表头文字。

1. **表格初始化**

- - JavaScript 初始化表格（例如使用 `$('#mainGrid').bootstrapTable()`），加载数据到对应的 `data-field` 列。

1. **动态展示数据**

- - 前端通过 Ajax 从后台接口获取 JSON 数据，表格根据 `data-field` 将数据插入相应的列。

------

### **建议改进**

1. **设置默认列宽**

- - 通过 CSS 或表格插件的配置，指定每列的宽度，避免列宽自动调整造成布局问题。

1. **添加数据格式化功能**

- - 对日期列（`createTime`）或其他复杂字段（如 IP 地址、描述信息）增加格式化逻辑。

1. **增强表格功能**

- - 配合插件添加排序、筛选、分页等功能，提升用户体验。

如果需要进一步帮助实现功能（如数据加载、国际化配置），请提供具体需求！

## css部分

```plain
    <style type="text/css">
        /* 表格内容超出时显示省略号 */
        th, td {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            max-width: 150px;
        }

        /* 提示框样式 */
        .tooltip {
            position: absolute;
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            z-index: 9999;
            max-width: 300px;
            word-wrap: break-word;
            white-space: normal;
            font-size: 14px;
            color: #333;
        }

    </style>
```



**ChatGPT 说：**

这段 CSS 样式代码主要为表格单元格内容设置了溢出省略号的显示效果，并自定义了一个用于悬浮提示的提示框样式（`.tooltip`）。以下是详细的解释说明：

------

### **表格样式部分**

```plain
th, td {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    max-width: 150px;
}
```

#### **解析**

1. `**th, td**`

- - 选择表格中的表头单元格（`th`）和表格内容单元格（`td`）。

1. `**white-space: nowrap;**`

- - 设置单元格内容为不换行模式，即即使内容过长，也不会自动换行。

1. `**overflow: hidden;**`

- - 隐藏超出单元格范围的内容。溢出的部分不会显示。

1. `**text-overflow: ellipsis;**`

- - 如果内容超出显示范围，则用省略号 (`...`) 表示被截断的部分。

1. `**max-width: 150px;**`

- - 设置单元格的最大宽度为 150 像素。
  - 当内容宽度超过这个值时，触发省略号效果。

#### **功能**

- 确保表格内容在单元格中保持整齐美观，防止因内容过长影响布局。
- 当单元格内容超出设定宽度时，用省略号代替未显示的内容。

------

### **提示框样式部分**

```plain
.tooltip {
    position: absolute;
    background-color: #fff;
    border: 1px solid #ccc;
    padding: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    z-index: 9999;
    max-width: 300px;
    word-wrap: break-word;
    white-space: normal;
    font-size: 14px;
    color: #333;
}
```

#### **解析**

1. `**position: absolute;**`

- - 设置提示框的定位方式为绝对定位，允许根据鼠标位置或其他触发点动态调整其显示位置。

1. `**background-color: #fff;**`

- - 设置提示框的背景颜色为白色，使其内容清晰可见。

1. `**border: 1px solid #ccc;**`

- - 添加一个浅灰色边框，为提示框提供视觉边界。

1. `**padding: 5px;**`

- - 设置提示框内容与边界之间的内边距，确保文字不贴边。

1. `**box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);**`

- - 为提示框添加阴影效果，增强视觉层次感。
  - 参数解析：

- - - `0`: 水平偏移量为 0。
    - `2px`: 垂直偏移量为 2 像素。
    - `5px`: 模糊半径为 5 像素。
    - `rgba(0, 0, 0, 0.2)`: 半透明黑色，表示阴影颜色。

1. `**z-index: 9999;**`

- - 设置提示框的层级较高，以确保它显示在所有其他元素之上。

1. `**max-width: 300px;**`

- - 限制提示框的最大宽度为 300 像素，防止内容过长时导致提示框太大。

1. `**word-wrap: break-word;**`

- - 允许单词在必要时断行，以防止提示框内容溢出。

1. `**white-space: normal;**`

- - 允许提示框内容正常换行（与表格的 `nowrap` 相对），确保长文本可以显示完整。

1. `**font-size: 14px;**`

- - 设置提示框内文字的大小为 14 像素。

1. `**color: #333;**`

- - 设置提示框文字的颜色为深灰色，易于阅读。

------

### **功能总结**

- 表格样式部分用于控制单元格内容的显示，限制宽度并用省略号处理溢出。
- 提示框样式部分自定义了一个美观的悬浮提示框，用于显示单元格中完整的内容，配合 JavaScript 逻辑可以动态显示提示。

------

### **应用场景**

- **表格中的长内容截断**：当单元格内容超出范围但又需要让用户查看详细内容时（例如列表页面）。
- **鼠标悬浮显示详细信息**：配合 JavaScript 事件（如 `mouseover` 和 `mouseout`）可以动态显示提示框，提升用户体验。

如果您需要完整实现动态提示框的效果，可以结合上述样式和事件处理逻辑进一步开发！