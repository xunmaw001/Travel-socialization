(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/register/register"],{"1a20":function(e,n,t){"use strict";var r;t.d(n,"b",(function(){return u})),t.d(n,"c",(function(){return a})),t.d(n,"a",(function(){return r}));var u=function(){var e=this,n=e.$createElement;e._self._c},a=[]},5373:function(e,n,t){"use strict";var r=t("8afe"),u=t.n(r);u.a},"8afe":function(e,n,t){},"9f05":function(e,n,t){"use strict";(function(e){t("60ea");r(t("66fd"));var n=r(t("b17a"));function r(e){return e&&e.__esModule?e:{default:e}}e(n.default)}).call(this,t("543d")["createPage"])},b17a:function(e,n,t){"use strict";t.r(n);var r=t("1a20"),u=t("e0c4");for(var a in u)"default"!==a&&function(e){t.d(n,e,(function(){return u[e]}))}(a);t("5373");var i,o=t("f0c5"),s=Object(o["a"])(u["default"],r["b"],r["c"],!1,null,"dd527bcc",null,!1,r["a"],i);n["default"]=s.exports},d24c:function(e,n,t){"use strict";(function(e){Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var r=u(t("a34a"));function u(e){return e&&e.__esModule?e:{default:e}}function a(e,n,t,r,u,a,i){try{var o=e[a](i),s=o.value}catch(c){return void t(c)}o.done?n(s):Promise.resolve(s).then(r,u)}function i(e){return function(){var n=this,t=arguments;return new Promise((function(r,u){var i=e.apply(n,t);function o(e){a(i,r,u,o,s,"next",e)}function s(e){a(i,r,u,o,s,"throw",e)}o(void 0)}))}}var o={data:function(){return{yonghuxingbieOptions:[],yonghuxingbieIndex:0,ruleForm:{},tableName:""}},onLoad:function(){var n=this;return i(r.default.mark((function t(){var u;return r.default.wrap((function(t){while(1)switch(t.prev=t.next){case 0:[],u=e.getStorageSync("loginTable"),n.tableName=u,"yonghu"==n.tableName&&(n.yonghuxingbieOptions="男,女".split(","),n.ruleForm.xingbie=n.yonghuxingbieOptions[0]),n.styleChange();case 5:case"end":return t.stop()}}),t)})))()},methods:{yonghuxingbieChange:function(e){this.yonghuxingbieIndex=e.target.value,this.ruleForm.xingbie=this.yonghuxingbieOptions[this.yonghuxingbieIndex]},styleChange:function(){this.$nextTick((function(){}))},getUUID:function(){return(new Date).getTime()},register:function(){var e=this;return i(r.default.mark((function n(){return r.default.wrap((function(n){while(1)switch(n.prev=n.next){case 0:if(e.ruleForm.zhanghao||"yonghu"!=e.tableName){n.next=3;break}return e.$utils.msg("账号不能为空"),n.abrupt("return");case 3:if(e.ruleForm.mima||"yonghu"!=e.tableName){n.next=6;break}return e.$utils.msg("密码不能为空"),n.abrupt("return");case 6:if(e.ruleForm.shouji||"yonghu"!=e.tableName){n.next=9;break}return e.$utils.msg("手机不能为空"),n.abrupt("return");case 9:if("yonghu"!=e.tableName||!e.ruleForm.shouji||e.$validate.isMobile(e.ruleForm.shouji)){n.next=12;break}return e.$utils.msg("手机应输入手机格式"),n.abrupt("return");case 12:if("yonghu"!=e.tableName||!e.ruleForm.youxiang||e.$validate.isEmail(e.ruleForm.youxiang)){n.next=15;break}return e.$utils.msg("邮箱应输入邮件格式"),n.abrupt("return");case 15:if(e.ruleForm.shenfenzheng||"yonghu"!=e.tableName){n.next=18;break}return e.$utils.msg("身份证不能为空"),n.abrupt("return");case 18:if("yonghu"!=e.tableName||!e.ruleForm.shenfenzheng||e.$validate.checkIdCard(e.ruleForm.shenfenzheng)){n.next=21;break}return e.$utils.msg("身份证应输入身份证格式"),n.abrupt("return");case 21:return n.next=23,e.$api.register("".concat(e.tableName),e.ruleForm);case 23:e.$utils.msgBack("注册成功");case 25:case"end":return n.stop()}}),n)})))()}}};n.default=o}).call(this,t("543d")["default"])},e0c4:function(e,n,t){"use strict";t.r(n);var r=t("d24c"),u=t.n(r);for(var a in r)"default"!==a&&function(e){t.d(n,e,(function(){return r[e]}))}(a);n["default"]=u.a}},[["9f05","common/runtime","common/vendor"]]]);