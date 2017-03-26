//Ext.define('ZK.view.layout.LayoutWest', {
//    extend: 'Ext.grid.Panel',
//    alias : 'widget.zkwest',
//    title : '左panel',
//    layout: 'fit',
//    autoShow: true,
//    width:'15%',
//    region: 'west',
//    title: '目录',
//    id: 'app_tree',
////    rootVisible: false,
//    lines: false,
//    split: true,
//  //  store: 'layout.WestStore',
//    rootVisible: false,
//    initComponent: function() {
// 
//    },
//    listeners: {
//        select: function (thisView, thisControl) {
//            
//           
//            if (thisControl.data.leaf) {
//            	  Ext.require("ZK.controller.Students", function () {
//		                 var bhcmsController = application.getController('Students');
//		                 console.log(bhcmsController)
//		                 bhcmsController.init(self);
//            	   }, self);                                
//            }
//        }
//    }
//});
 //# sourceURL=ZK.view.layout.LayoutWest.js  
Ext.define('ZK.view.layout.LayoutWest', {
    extend: 'Ext.tree.Panel',
    id:'app_tree',
    alias : 'widget.zkwest',
    title : '目录',
    layout: 'fit',
    autoShow: true,
    width: '10%',
    split: true,
    lines: false,
    //store: treeStore,
    rootVisible: false,
    bodyBorder: false,
    border: false,
    root: {
        expanded: true,
        children: [
            { id:"0", text: "首页", leaf: true },
            { id:"studentlist", text: "学生管理", leaf: true },
            {text: "测试2", expanded: true, children: [
                { id:"teacherlist",text: "教师管理", leaf: true },
                { id:"userlist",text: "用户管理", leaf: true}
            ] },
            { id:"5",text: "测试5", leaf: true }
        ]
    }, 
    initComponent: function() { 
    	
    	var me = this;
        Ext.apply(this, {
            region: 'west'
              
        });
        me.callParent(arguments);
    },
    listeners: {
    	 
      select: function (thisView, thisControl) {
          
         if(thisControl.data.leaf){
        	 if (thisControl.data.id == 'studentlist') {
        		 ZkExtJS.extjs.createTabPage('ZK.controller.Students','studentlist');                              
        	 }else if(thisControl.data.id == 'teacherlist') {
        		 ZkExtJS.extjs.createTabPage('ZK.controller.Teachers','teacherlist');
        	 }else if(thisControl.data.id == 'userlist') {
        		  ZkExtJS.extjs.createTabPage('ZK.controller.Users','userlist');
        	 }
         }    
      }
  }
});
