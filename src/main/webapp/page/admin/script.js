// var $ = layui.jquery;
var cocoMessage = window.parent.cocoMessage;
var form;
var table;
var layer;

$('input[name=teacher]').val(window.parent.GLOBAL.user.id);

layui.use(['form', 'table'], function () {
	
	form = layui.form;
	table = layui.table;
	layer = layui.layer;
	
	getFacultyList();
	
	//添加节次按钮事件
	$('#add').click(function() {
		let len = $(".courseInfoItem").length;
		$("#btnArea").before(getHTML(len));
		form.render(null, 'addCourse');
	})
	
	
	//删除节次按钮事件
	$('#del').click(function() {
		
		let len = $(".courseInfoItem").length;
		if(len<=1){
			layer.msg('至少保留一个节次');
			return;
		}
		
		layer.msg('确认删除最后一个节次吗？', {
			icon: 3,
			time: 0,
			btn: ['取消', '确定'],
			yes: function(index) {
				layer.close(index);
			},
			btn2: function(index) {
				layer.close(index);
				$(".courseInfoItem").get(len-1).remove();
				form.render(null, 'addCourse');
			}
		});
		
	})
	
	// 监听搜索操作
	form.on('submit(data-submit-btn)', function (data) {
		console.log(data.field);
		
		layer.msg('确认提交吗？', {
			icon: 3,
			time: 0,
			btn: ['取消', '确定'],
			yes: function(index) {
				layer.close(index);
			},
			btn2: function(index) {
				layer.close(index);
				$.ajax({
					url:'insert/addCourse.do',
					data:data.field,
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
			}
		});
		
		
	
		return false;
	});
	
	
	//下拉框 院系 值改变时事件监听
	form.on('select(faculty)', function(data){
		if(data.value=='') {
			$('#specialized').html('<option value="">全部</option>');
			form.render('select','addCourse');
		} else{
			console.log(data.value); //得到被选中的值
			getSpecializedListByFaculty(data.value)
		}
		$('#clazz').html('<option value="">全部</option>');
		$('#course').html('<option value="">全部</option>');
		form.render('select','addCourse');
	});
	
	//下拉框 专业 值改变时事件监听
	form.on('select(specialized)', function(data){
		if(data.value=='') {
			$('#clazz').html('<option value="">全部</option>');
			form.render('select','addCourse');
		} else{
			console.log(data.value); //得到被选中的值
			getClazzListBySpecialized(data.value)
		}
		$('#course').html('<option value="">全部</option>');
		form.render('select','addCourse');
	});
	
	form.on('select(clazz)', function(data){
		if(data.value=='') {
			$('#course').html('<option value="">全部</option>');
			form.render('select','addCourse');
		} else{
			console.log(data.value); //得到被选中的值
			let teacher = window.parent.GLOBAL.user.id;
			getCourseListByTeacherAndClazz(teacher,data.value)
		}
	});
	
	// 授课老师下拉监听
	//下拉框 院系 值改变时事件监听
	form.on('select(teacher_faculty)', function(data){
		if(data.value=='') {
			$('#teacher').html('<option value="">全部</option>');
			form.render('select','addCourse');
		} else{
			console.log(data.value); //得到被选中的值
			getTeacherList(data.value,$('#teacher_sex').val());
		}
	});
	
	// 性别更改下来监听
	form.on('select(teacher_sex)', function(data){
		console.log('data='+data.value)
		if(data.value=='') {
			$('#teacher').html('<option value="">全部</option>');
			form.render('select','addCourse');
		} else{
			console.log(data.value); //得到被选中的值
			getTeacherList($('#teacher_faculty').val(),data.value);
		}
	});
});


//获取节次的HTML
function getHTML(index) {
	return '<fieldset class="table-search-fieldset courseInfoItem"><legend>节次'+index+'</legend><div class="layui-form-item"><div  class="layui-inline"><label class="layui-form-label">类型</label><div class="layui-input-inline"><select name="courseInfos['+index+'].courseType" lay-verify="required"><option value="">全部</option><option value="theory">理论课</option><option value="practice">实践课</option></select></div></div><div  class="layui-inline"><label class="layui-form-label">单双周</label><div class="layui-input-inline"><select name="courseInfos['+index+'].weekType" lay-verify="required"><option value="all">不限</option><option value="sgl">单周</option><option value="dbl">双周</option></select></div></div><div class="layui-inline"><label class="layui-form-label">起始周</label><div class="layui-input-inline"><input type="number" name="courseInfos['+index+'].startWeek" autocomplete="off" class="layui-input" lay-verify="required"></div></div><div class="layui-inline"><label class="layui-form-label">结束周</label><div class="layui-input-inline"><input type="number" name="courseInfos['+index+'].endWeek" autocomplete="off" class="layui-input" lay-verify="required"></div></div><div class="layui-inline"><label class="layui-form-label">星期</label><div class="layui-input-inline"><select name="courseInfos['+index+'].weekDay" lay-verify="required"><option value="">全部</option><option value="Monday">周一</option><option value="Tuesday">周二</option><option value="Wednesday">周三</option><option value="Thursday">周四</option><option value="Friday">周五</option><option value="Saturday">周六</option><option value="Sunday">周日</option></select></div></div><div class="layui-inline"><label class="layui-form-label">起始节</label><div class="layui-input-inline"><input type="number" name="courseInfos['+index+'].begin" autocomplete="off" class="layui-input" lay-verify="required"></div></div><div class="layui-inline"><label class="layui-form-label">持续节</label><div class="layui-input-inline"><input type="number" name="courseInfos['+index+'].length" autocomplete="off" class="layui-input" lay-verify="required"></div></div><div class="layui-inline"><label class="layui-form-label">上课地点</label><div class="layui-input-inline"><input type="text" name="courseInfos['+index+'].address" autocomplete="off" class="layui-input" lay-verify="required"></div></div></div></fieldset>';
}



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
			$('#teacher_faculty').html(html);
			form.render('select','addCourse');
		}
	})
}

// 获取某个院系的专业列表并渲染
function getSpecializedListByFaculty(faculty) {
	$.ajax({
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
			form.render('select','addCourse');
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
			form.render('select','addCourse');
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
			form.render('select','addCourse');
		}
	})
}

// 获取老师列表并渲染
function getTeacherList(faculty,sex) {
	$.ajax({
		url:'query/getTeacherList.do',
		data:{
			'faculty':faculty,
			'sex':sex
		},
		type:'get',
		dataType:'json',
		success:function(data) {
			let html = '<option value="">全部</option>';
			$.each(data.data,function(index, value) {
				html += '<option value='+value.id+'>'+value.id+' '+value.name+'</option>';
			});
			
			$('#teacher').html(html);
			form.render('select','addCourse');
		}
	})
}