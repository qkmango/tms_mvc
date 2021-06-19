var $ = layui.jquery;
var cocoMessage = window.parent.cocoMessage;
var form;
var table;


$('input[name=teacher]').val(window.parent.GLOBAL.user.id);

layui.use(['form', 'table'], function () {
	
	form = layui.form;
	table = layui.table;
	getFacultyList();

	table.render({
		elem: '#dataGrid',
		url: 'query/getStudentScorePagination.do',
		toolbar: true,
		parseData: function(res){
		    return {
		      "code": res.success==true?0:-1,
		      "msg": res.message,
		      "count": res.count,
		      "data": res.data
		    };
		},
		defaultToolbar: ['filter', 'exports', 'print', {
			title: '单击分数框即可编辑更改分数',
			layEvent: 'LAYTABLE_TIPS',
			icon: 'layui-icon-tips'
		}],
		cols: [[
			{type: "checkbox", width: 50},
			{field: 'id', width: 80, title: 'ID', sort: true},
			{field: 'name', width: 120, title: '姓名'},
			{field: 'course', width: 140, title: '课程'},
			{field: 'teacher', width: 100, title: '任课老师'},
			{field: 'clazz', title: '班级'},
			{field: 'specialized', title: '专业'},
			{field: 'faculty',title: '学院'},
			{field: 'elective',title: '选课表ID',hide:true},
			{field: 'score', width: 80, title: '分数',edit:true,style:'background-color:#5FB878'}
			// ,{title: '操作', minWidth: 100, toolbar: '#currentTableBar', align: "center"}
		]],
		limits: [20, 40, 60, 80, 100, 120],
		limit: 20,
		page: true,
		skin: 'line',
		where:{
			teacher:window.parent.GLOBAL.user.id
		}
	});


	//监听单元格编辑
	  table.on('edit(currentTableFilter)', function(obj){
		var value = obj.value //得到修改后的值
		,data = obj.data //得到所在行所有键值
		,field = obj.field; //得到字段
		console.log("得到修改后的值:"+value)
		console.log(data);
		$.ajax({
			url:'update/updateStudentScore.do',
			data:{
				elective:data.elective,
				score:data.score
			},
			type:'post',
			dataType:'json',
			success:function(data) {
				if(data.success) {
					cocoMessage.success(2000,data.message);
				} else {
					cocoMessage.error(2000,data.message);
				}
			},
			error: function (jqXHR, textStatus, errorThrown) {
				cocoMessage.error(2000,jqXHR.status+'');
			}
		})
	  });

	// 监听搜索操作
	form.on('submit(data-search-btn)', function (data) {
		var queryParamsStr = JSON.stringify(data.field);
		//执行搜索重载
		table.reload('dataGrid', {
			page: {
				curr: 1
			},
			where:data.field
		}, 'data');
	
		return false;
	});
	
	
	//下拉框 院系 值改变时事件监听
	form.on('select(faculty)', function(data){
		if(data.value=='') {
			$('#specialized').html('<option value="">全部</option>');
			form.render('select','queryParams');
		} else{
			console.log(data.value); //得到被选中的值
			getSpecializedListByFaculty(data.value)
		}
		$('#clazz').html('<option value="">全部</option>');
		$('#course').html('<option value="">全部</option>');
		form.render('select','queryParams');
	});
	
	//下拉框 专业 值改变时事件监听
	form.on('select(specialized)', function(data){
		if(data.value=='') {
			$('#clazz').html('<option value="">全部</option>');
			form.render('select','queryParams');
		} else{
			console.log(data.value); //得到被选中的值
			getClazzListBySpecialized(data.value)
		}
		$('#course').html('<option value="">全部</option>');
		form.render('select','queryParams');
	});
	
	form.on('select(clazz)', function(data){
		if(data.value=='') {
			$('#course').html('<option value="">全部</option>');
			form.render('select','queryParams');
		} else{
			console.log(data.value); //得到被选中的值
			let teacher = window.parent.GLOBAL.user.id;
			getCourseListByTeacherAndClazz(teacher,data.value)
		}
	});
});

//获取院系列表并渲染
function getFacultyList() {
	$.ajax({
		url:'query/getFacultyList.do',
		type:'get',
		dataType:'json',
		success:function(data) {
			let html = '<option value="">全部</option>';
			$.each(data.data,function(index, value) {
				html += '<option value='+value.id+'>'+value.name+'</option>';
			});
			
			$('#faculty').html(html);
			form.render('select','queryParams');
		}
	})
}

// 获取某个院系的专业列表并渲染
function getSpecializedListByFaculty(faculty) {
	$.ajax({
		// url:'data/specialized.json',
		url:'query/getSpecializedListByFaculty.do',
		data:{
			'faculty':faculty
		},
		type:'get',
		dataType:'json',
		success:function(data) {
			let html = '<option value="">全部</option>';
			$.each(data.data,function(index, value) {
				html += '<option value='+value.id+'>'+value.name+'</option>';
			});
			
			$('#specialized').html(html);
			form.render('select','queryParams');
		}
	})
}

// 获取指定专业的所有班级列表并渲染
function getClazzListBySpecialized(specialized) {
	$.ajax({
		// url:'data/specialized.json',
		url:'query/getClazzListBySpecialized.do',
		data:{
			'specialized':specialized
		},
		type:'get',
		dataType:'json',
		success:function(data) {
			let html = '<option value="">全部</option>';
			$.each(data.data,function(index, value) {
				html += '<option value='+value.id+'>'+value.name+'</option>';
			});
			
			$('#clazz').html(html);
			form.render('select','queryParams');
		}
	})
}

// 获取指定专业的所有班级列表并渲染
function getCourseListByTeacherAndClazz(teacher,clazz) {
	$.ajax({
		url:'query/getCourseListByTeacherAndClazz.do',
		data:{
			'teacher':teacher,
			'clazz':clazz
		},
		type:'get',
		dataType:'json',
		success:function(data) {
			let html = '<option value="">全部</option>';
			$.each(data.data,function(index, value) {
				html += '<option value='+value.id+'>'+value.name+'</option>';
			});
			
			$('#course').html(html);
			form.render('select','queryParams');
		}
	})
}