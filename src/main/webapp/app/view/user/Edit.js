

Ext.require([
    'Ext.ux.DataTip'
]);  
var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';

Ext.define('ZK.view.user.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.useredit',
    title : '修改用户信息',
    layout: 'fit',
    width:350,
    modal:true,
    autoShow: true,
    initComponent: function() {
        Ext.applyIf(this, {
            items: [Ext.create('ZK.view.user.Form')]
        });
        this.callParent(arguments);
    }
});

Ext.define('ZK.view.user.Form', {
    extend: 'Ext.form.Panel',
    layout: 'form',
    trackResetOnLoad:true,
    bodyPadding: '10 10 10 0',
    autoShow: true,
    constrain: true, // 是否只能在父容器的范围内拖动
    modal: true, // 是否有遮挡层
    fieldDefaults: {
        msgTarget: 'side',
        labelAlign: 'right',
        labelWidth: 75,
        width: 275
    },
    plugins: {
        ptype: 'datatip'
    },
    defaultType: 'textfield',
    items:[{
        fieldLabel: '姓名',
        afterLabelTextTpl: required,
        name: 'name',
        allowBlank: false,
        tooltip: '请输入姓名'
    },{
        fieldLabel: '性别',
        afterLabelTextTpl: required,
        name: 'sex',
        allowBlank: false,
        tooltip: '输入性别'
    }, {
        fieldLabel: '年龄',
        name: 'age',
        xtype: 'numberfield',
        minValue: 0,
        maxValue: 100,
        tooltip: '请输入年龄'
    }, {
          
           xtype: "datefield",
     	   name: "birth",
     	   fieldLabel: "生日",
     	   editable: true,
     	   emptyText: "--请选择--",
     	   format: "Y-m-d",//日期的格式
     	   altFormats: "Y/m/d|Ymd",
     	   tooltip: '请输入生日日期'
    }],

    buttons: [{
        text: '保存',
        action: 'save'
    },{
        text: '取消',
        handler: function(){
        	this.up('form').up('window').close();
        }
    }]
});
