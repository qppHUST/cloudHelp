(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-fc150ffa"],{"0aaf":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("综合信息统计")])},n=[],r={name:"StaAll"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},1937:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("工资表查询")])},n=[],r={name:"SalSearch"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},"21c7":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("工资表管理")])},n=[],r={name:"SalTable"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},"2bc5":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("工资账套管理")])},n=[],r={name:"SalSob"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},5865:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("员工资料")])},n=[],r={name:"PerEmp"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},"58da":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticStyle:{display:"flex","justify-content":"space-between"}},[a("div",[a("el-input",{staticStyle:{width:"300px","margin-right":"10px"},attrs:{placeholder:"请输入员工",clearable:"","prefix-icon":"el-icon-search"},on:{clear:t.initEmps},nativeOn:{keydown:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.initEmps.apply(null,arguments)}},model:{value:t.empName,callback:function(e){t.empName=e},expression:"empName"}}),a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.initEmps}},[t._v("搜索")]),a("el-button",{attrs:{type:"primary"}},[a("i",{staticClass:"fa fa-angle-double-down",attrs:{"aria-hidden":"true"}}),t._v(" 高级搜索 ")])],1),a("div",[a("el-upload",{staticStyle:{display:"inline-flex","margin-right":"8px"},attrs:{action:"/employee/basic/import","before-upload":t.beforeUpload,"on-success":t.onSuccess,"on-error":t.onError,headers:t.headers,disabled:t.importDataBtnDisabled,"show-file-list":!1}},[a("el-button",{attrs:{type:"success",icon:t.importDataBtnIcon,disabled:t.importDataBtnDisabled}},[t._v(" "+t._s(t.importDataBtnText))])],1),a("el-button",{attrs:{type:"success",icon:"el-icon-download",size:"small"},on:{click:t.exportData}},[t._v("导出员工")]),a("el-button",{attrs:{type:"primary",icon:"el-icon-plus","aria-hidden":"true"},on:{click:t.addEmp}},[t._v("添加员工")])],1)]),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],staticStyle:{width:"100%"},attrs:{data:t.emps,"element-loading-text":"拼命加载中","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)","row-class-name":t.tableRowClassName}},[a("el-table-column",{attrs:{type:"selection"}}),a("el-table-column",{attrs:{prop:"id",label:"编号",width:"50"}}),a("el-table-column",{attrs:{prop:"name",label:"姓名",width:"50"}}),a("el-table-column",{attrs:{prop:"gender",label:"性别",width:"40"}}),a("el-table-column",{attrs:{prop:"birthday",label:"生日",width:"90"}}),a("el-table-column",{attrs:{prop:"idCard",label:"证件号码",width:"150"}}),a("el-table-column",{attrs:{prop:"wedlock",label:"婚姻状况"}}),a("el-table-column",{attrs:{prop:"nation.name",label:"国籍",width:"50"}}),a("el-table-column",{attrs:{prop:"nativePlace",label:"籍贯",width:"50"}}),a("el-table-column",{attrs:{prop:"politicsStatus.name",label:"政治信仰",width:"100"}}),a("el-table-column",{attrs:{prop:"email",align:"left",label:"邮箱",width:"170"}}),a("el-table-column",{attrs:{prop:"phone",align:"left",label:"电话号码"}}),a("el-table-column",{attrs:{prop:"department.name",label:"所属部门"}}),a("el-table-column",{attrs:{prop:"position.name",label:"职位"}}),a("el-table-column",{attrs:{prop:"engageForm",label:"聘用形式"}}),a("el-table-column",{attrs:{prop:"tiptopDegree",label:"最高学历"}}),a("el-table-column",{attrs:{prop:"specialty",label:"专业"}}),a("el-table-column",{attrs:{prop:"beginDate",label:"起始日期"}}),a("el-table-column",{attrs:{prop:"workState",label:"在职状况"}}),a("el-table-column",{attrs:{align:"left",width:"100",label:"合同时长"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-tag",[t._v(" "+t._s(e.row.contractTerm)+"年 ")])]}}])}),a("el-table-column",{attrs:{prop:"conversionTime",label:"过期时间"}}),a("el-table-column",{attrs:{prop:"beginContract",label:"合同起始时间"}}),a("el-table-column",{attrs:{prop:"endContract",label:"合同结束时间"}}),a("el-table-column",{attrs:{prop:"workAge",label:"工龄"}}),a("el-table-column",{attrs:{label:"操作",fixed:"right",width:"200"}},[[a("el-button",{staticStyle:{padding:"3px"},attrs:{size:"mini"}},[t._v("编辑")]),a("el-button",{staticStyle:{padding:"3px"},attrs:{type:"primary"}},[t._v("查看高级资料")]),a("el-button",{staticStyle:{padding:"3px"},attrs:{type:"danger"}},[t._v("删除")])]],2)],1),a("div",{staticStyle:{"margin-top":"10px",display:"flex","justify-content":"flex-end"}},[a("el-pagination",{attrs:{background:"",layout:"sizes,prev, pager, next",total:t.total},on:{"current-change":t.currentChange,"size-change":t.sizeChange}})],1)],1),a("el-dialog",{attrs:{title:"插入员工",visible:t.dialogVisible,width:"30%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[a("div",[t._v(" 在此输入数据 ")]),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogVisible=!1}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.dialogVisible=!1}}},[t._v("确 定")])],1)])],1)},n=[],r=a("7c15"),i=a("989b"),o={data:function(){return{emps:[],input:"",loading:!1,total:0,currentPage:1,size:10,empName:"",dialogVisible:!1,importDataBtnText:"导入数据",importDataBtnIcon:"el-icon-upload2",importDataBtnDisabled:!1,headers:{Authorization:window.sessionStorage.getItem("tokenStr")}}},methods:{onSuccess:function(){this.importDataBtnText="导入数据",this.importDataBtnIcon="el-icon-upload2",this.importDataBtnDisabled=!1,this.initEmps()},onError:function(){this.importDataBtnText="导入数据",this.importDataBtnIcon="el-icon-upload2",this.$message.error("导入失败"),this.importDataBtnDisabled=!1},beforeUpload:function(){this.importDataBtnIcon="el-icon-loading",this.importDataBtnText="正在导入",this.importDataBtnDisabled=!0},initEmps:function(){var t=this;this.loading=!0,Object(r["b"])("/employee/basic?currentPage="+this.currentPage+"&size="+this.size+"&name="+this.empName).then((function(e){console.log(t.currentPage),console.log(t.total),t.loading=!1,e&&(t.emps=e.data,t.total=e.total,console.log(e.total),console.log(t.total))}))},currentChange:function(t){this.currentPage=t,this.initEmps()},sizeChange:function(t){this.size=t,this.initEmps()},addEmp:function(){this.dialogVisible=!0},exportData:function(){Object(i["a"])("/employee/basic/export")},tableRowClassName:function(t){t.row;var e=t.rowIndex;return 1===e?"warning-row":3===e?"success-row":""}},mounted:function(){this.initEmps()},name:"EmpBasic"},s=o,c=a("2877"),u=Object(c["a"])(s,l,n,!1,null,null,null);e["default"]=u.exports},"5a4a":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("员工调薪")])},n=[],r={name:"PerSalary"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},"6ac98":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("员工账套设置")])},n=[],r={name:"SalSobCfg"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},"83ed":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("员工培训")])},n=[],r={name:"PerTrain"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},8759:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("高级资料")])},n=[],r={name:"EmpAdv"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},a49a:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("人事记录统计")])},n=[],r={name:"StaRecord"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},b419:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("人事信息统计")])},n=[],r={name:"StaPres"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},c1d3:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("员工积分统计")])},n=[],r={name:"StaScore"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},cfbb:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("员工调动")])},n=[],r={name:"PerMv"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},d9ac:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("员工奖罚")])},n=[],r={name:"PerEc"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},fbac:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("月末处理")])},n=[],r={name:"SalMonth"},i=r,o=a("2877"),s=Object(o["a"])(i,l,n,!1,null,null,null);e["default"]=s.exports},feca:function(t,e,a){var l={"./Home.vue":"bb51","./Login.vue":"a55b","./emp/EmpAdv.vue":"8759","./emp/EmpBasic.vue":"58da","./per/PerEc.vue":"d9ac","./per/PerEmp.vue":"5865","./per/PerMv.vue":"cfbb","./per/PerSalary.vue":"5a4a","./per/PerTrain.vue":"83ed","./sal/SalMonth.vue":"fbac","./sal/SalSearch.vue":"1937","./sal/SalSob.vue":"2bc5","./sal/SalSobCfg.vue":"6ac98","./sal/SalTable.vue":"21c7","./sta/StaAll.vue":"0aaf","./sta/StaPers.vue":"b419","./sta/StaRecord.vue":"a49a","./sta/StaScore.vue":"c1d3","./sys/SysAdmin.vue":"f86b","./sys/SysBasic.vue":"8d67","./sys/SysCfg.vue":"1fe7","./sys/SysData.vue":"d1e3","./sys/SysInit.vue":"8608","./sys/SysLog.vue":"864e"};function n(t){var e=r(t);return a(e)}function r(t){if(!a.o(l,t)){var e=new Error("Cannot find module '"+t+"'");throw e.code="MODULE_NOT_FOUND",e}return l[t]}n.keys=function(){return Object.keys(l)},n.resolve=r,t.exports=n,n.id="feca"}}]);
//# sourceMappingURL=chunk-fc150ffa.b42d9655.js.map