//菜单json格式。对象-数组-对象-数组......
var menuArray = {
    "menus": [
        {
            "menuID": "01",
            "menuIcon": "fa fa-sitemap",
            "menuName": "树管理",
            "menuIcon2": "fa fa-chevron-down",
            "menus": [
                {
                    "menuID": "0101",
                    "menuIcon": "fa fa-institution",
                    "menuName": "组织机构管理",
                    "menuUrl": "institution.do"
                },
                {
                    "menuID": "0102",
                    "menuIcon": "fa fa-user-plus",
                    "menuName": "用户信息管理",
                    "menuUrl": "user.do"
                },
                {
                    "menuID": "0103",
                    "menuIcon": "fa fa-eye-slash",
                    "menuName": "权限控制管理",
                    "menuUrl": "authority.do"
                },
            ]
        },
        {
            "menuID": "02",
            "menuIcon": "fa fa-folder",
            "menuName": "文件管理",
            "menuIcon2": "fa fa-chevron-down",
            "menus": [
                {
                    "menuID": "0201",
                    "menuIcon": "fa fa-file-excel-o",
                    "menuName": "EXCEL",
                    "menuUrl": "excel.do"
                },
                {
                    "menuID": "0202",
                    "menuIcon": "fa fa-file-powerpoint-o",
                    "menuName": "PPT",
                    "menuUrl": "ppt.do"
                },
                {
                    "menuID": "0203",
                    "menuIcon": "fa fa-file-word-o",
                    "menuName": "WORD",
                    "menuUrl": "word.do"
                },
                {
                    "menuID": "0204",
                    "menuIcon": "fa fa-file-pdf-o",
                    "menuName": "PDF",
                    "menuUrl": "pdf.do"
                },
                {
                    "menuID": "0205",
                    "menuIcon": "fa fa-file-image-o",
                    "menuName": "IMAGE",
                    "menuUrl": "image.do"
                },
                {
                    "menuID": "0206",
                    "menuIcon": "fa fa-file-video-o",
                    "menuName": "VIDEO",
                    "menuUrl": "video.do"
                },
            ]
        },
        {
            "menuID": "03",
            "menuIcon": "fa fa-check-square-o",
            "menuName": "批量管理",
            "menuIcon2": "fa fa-chevron-down",
            "menus": [
                {
                    "menuID": "0301",
                    "menuIcon": "fa fa-table",
                    "menuName": "表格分页排序",
                    "menuUrl": "table.do"
                },
                {
                    "menuID": "0302",
                    "menuIcon": "fa fa-server",
                    "menuName": "瀑布流分页",
                    "menuUrl": "flow.do"
                },
            ]
        },
        {
            "menuID": "04",
            "menuIcon": "fa fa-pencil-square-o",
            "menuName": "表单编辑",
            "menuIcon2": "fa fa-chevron-down",
            "menus": [
                {
                    "menuID": "0401",
                    "menuIcon": "fa fa-align-justify",
                    "menuName": "输入框",
                    "menuUrl": "input.do"
                },
                {
                    "menuID": "0302",
                    "menuIcon": "fa fa-columns",
                    "menuName": "下拉框",
                    "menuUrl": "comboBox.do"
                },
                {
                    "menuID": "0303",
                    "menuIcon": "fa fa-list-alt",
                    "menuName": "富文本",
                    "menuUrl": "richText.do"
                },
            ]
        },
    ]
}