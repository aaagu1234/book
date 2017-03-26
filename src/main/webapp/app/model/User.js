Ext.define('ZK.model.User', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'id', type: 'string', remark: '用户id' },
        { name: 'name', type: 'string', remark: '姓名' },
        { name: 'sex', type: 'string', remark: '性别' },
        { name: 'age', type: 'int', remark: '年龄' },
        { name: 'birth', type: 'date', remark: '生日' ,convert:function(v, record) { 
        	if (v == null) {
        		return null;
        		} 
        		var date=new Date(v); 
        		return Ext.Date.format(date,'Y-m-d');
        	 } }
    ]
});  
 