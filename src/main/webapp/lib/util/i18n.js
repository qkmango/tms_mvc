/**
 * 使用此js库，可以很方便的将前端页面进行国际化
 * @author: qkmango
 * @date: 2021-07-04 9:27
 * @version: 1.0
 * 
 * 
 * 如何更改国际化？
 * 		1. 调用 i18nFromAjax({url:'xxxx.json',locale:'zh_CN'}) 时手动指定 locale 属性
 * 		2. 调用 i18nFromAjax({url:'xxxx.json',localeKey:'mycookieKey'}) 时手动指定 localeKey 属性，
 * 			会通过指定的localeKey获取浏览器的此对应的cookie，从cookie中读取到指定的国际化语言
 * 		3. 【推荐】此js库是和后端 springmvc基于cookie的国际化（CookieLocaleResolver） 搭配使用的，
 * 			浏览器发起一个请求带有 locale 的参数指定国际化语言，之后本地会被写入一个cookie，以中文国际化为例，写入的cookie键值对如下：
 * 			org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE=zh_CN
 * 			之后刷新浏览器，再次调用 i18nFromAjax({url:'xxxx.json'}) 仅指定国际化文件的URL，函数会读取这个cookie得到国际化语言，
 * 			然后请求国际化资源，渲染到页面
 * 
 * 国际化对象：指的就是ajax请求回来的json转的对象，如下面json示例，转为js对象后通过点调用访问属性
 * 国际化语言：指的是如 'zh_CN','en_US'这样的字符串，可以是手动指定的，也可以是从cookie中读取到的
 * 
 * 示例国际化文件内容
	{
		"user":{
			"id":"编号",
			"name":"姓名",
			"age":"年龄"
		},
		"class":{
			"id":"班级编号",
			"name":"班级名"
		}
	}
	
 * 国际化标签使用示例
 * <span class="i18n" i18nkey='user.name' i18ntarget='inner'></span>
 * <input class="i18n" type="text" i18nkey='placeholder' i18ntarget='placeholder' />
 * 
 * class='i18n'：必须使用class属性指定需要国际化的标签，并在调用 i18nFromAjax()或i18n()时传入指定的class属性
 * i18nkey='user.name'：获取到的国际化json文件转为js对象，通过点调用的方式
 * i18ntarget='inner'：需要将国际化的文本放在哪里，取值有：
 * 		inner：标签内（innerText）
 * 		其他自定义或标签属性：如 i18ntarget='placeholder'，则将国际化的文本作为输入框的提示信息
 */


//国际化对象，存放已经请求过的国际化数据
var i18nData = null;

/**
 * 通过ajax的形式获取国际化值，并渲染到指定的属性上或标签内，将页面进行国际化
 * @param {Object} url 国际化json文件的URL，如 http://tms/data_{lang}.json
 * @param {Object} locale 语言地区，值格式为 zh_CN、en_US
 * 		当指定其值后，国际化采用指定的语言，
 * 		如果没指定，那么通过本地cookie获取cookie中指定的国际化语言，
 * 		如果cookie没有指定国际化语言，那么就默认采用 zh_CN
 * 		优先级：参数指定 > cookie指定 > 默认
 * @param {Object} asyn ajax方式获取，是否采用异步方式，默认true异步
 * @param {Object} className 需要进行国际化的标签类名，如果不指定则不进行渲染 
 * @param {Object} cacheObj 获取国际化文件后，缓存到哪个对象中
 * @param {Object} localeKey 是获取国际化的key，通过此key获取本地cookie，
 * 		此获取的cookie，其值就是 指定了需要那种语言和地区，如 zh_CN,en_US
 * 
 * 需要进行国际化的标签内部，要使用如 user.name的形式，程序自动查找国际化json文件中对应的字段
 */
function i18nFromAjax({url,locale,asyn=true,className,localeKey='org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE'}) {
	if(locale==undefined) {
		//从cookie中获取 locale 的 key
		let cookieLocale = getCookie(localeKey);
		//判断 locale，当为null时默认赋值为中文，不为null，将-转为_，国际化文件后缀如 zh_CN
		//为什么要将 -转为_ 因为国际化文件命名，语言切换的URL，都是使用_来分隔的，
		//但是 通过cookie进行国际化，cookie存入的值使用的是-，所以要替换一下
		if(cookieLocale!=null) {
			locale = cookieLocale.replaceAll('-', '_');
		} else {
			locale = 'zh_CN';
		}
	}
	// locale = cookieLocale.replaceAll('-', '_');
	url = url.replaceAll("{lang}", locale);

	// ajax 请求国际化文件，并用于页面需要国际化的字段
	var xhr;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let data = JSON.parse(xhr.responseText);
			i18nData  =data;
			//如果传入 需要国际化的类名，那么进行国际化
			if(className != undefined) {
				i18n({data:data,className:className});
			}
		}
	}
	xhr.open("GET", url, false);
	xhr.send();
	return i18nData;
	
}

/**
 * 使用指定的国际化对象将页面进行国际化
 * @param {Object} data 国际化对象
 * @param {Object} className 需要进行国际化的标签类名
 */
function i18n({data, className}) {
	if(data == undefined) {
		return;
	}
	if(className == undefined) {
		return;
	}
	var doms = document.getElementsByClassName(className);
	for (var i = 0; i < doms.length; i++) {
		// var keys = doms[i].innerText.split('.');
		var keys = doms[i].getAttribute('i18nkey').split('.');
		var value = data;
		for (var j = 0; j < keys.length; j++) {
			value = value[keys[j]];
		}
		
		let i18ntarget = doms[i].getAttribute('i18ntarget');
		
		switch(i18ntarget) {
			case 'inner':
				doms[i].innerText = value;break;
			default:
				doms[i].setAttribute(i18ntarget,value);
		}
	}
}

/**
 * 获取国际化对象
 * 如果国际化对象已经存在，那么就返回
 * 如果国际化对象不存在，那么调用 i18nFromAjax() 异步获取国际化对象
 * @param {Object} url 获取国际化文件的URL
 */
function getI18nData(url) {
	if(i18nData != null) {
		return i18nData;
	}
	if(url != undefined) {
		i18nFromAjax({url:url,asyn:false});
		return i18nData;
	}
	return null;
}


/**
 * 获取cookie
 * @param {Object} name cookie名，也即key
 */
function getCookie(name) {
	var strcookie = document.cookie;
	var arrcookie = strcookie.split("; ");
	for (var i = 0; i < arrcookie.length; i++) {
		var arr = arrcookie[i].split("=");
		if (arr[0] == name) {
			return arr[1];
		}
	}
	return null;
}
