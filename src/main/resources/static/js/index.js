/**
 * 首页脚本内容定义
 * @returns
 */
$(function(){
	//layui 初始化
	layui.use(['layer', 'form'], function(){
		var layer = layui.layer
		,form = layui.form;
	});
	
	//左侧菜单树事件触发
	$("#menuBox>li.layui-nav-item a").click(function(){
		//子元素
		let child = $(this).next()[0];
		//控制下拉元素
		let classDoc = $(this).parent();
		if(child){  //有子元素展开下来
			if(classDoc.hasClass("layui-nav-itemed")){
				classDoc.removeClass("layui-nav-itemed");
			}else{
				classDoc.addClass("layui-nav-itemed");
				classDoc.siblings().removeClass("layui-nav-itemed");
			}
		} else {
			//若无子元素则为跳转页面
			setIframeWindow($(this).attr("data-id"),$(this).attr("data-name"),
					$(this).attr("data-url"));
		}
		
	});
	//顶部tag 内容切换
	$(document).find("#tagBars>a>.tag-bar-text").on("click",function(){
		toggleItem(this);
	});
	//顶部tag 标签关闭
	$(document).find("#tagBars>a>.tag-bar-btn").on("click",function(){
		closeItem(this);
	});
	
	//全部关闭按钮操作的出发
	$("#closeBtns").click(function(){
		$("#closeBtns").find("span").removeClass("layui-icon-right");
		$("#closeBtns").find("span").addClass("layui-icon-down");
	})
	$("#closeBtns").mouseout(function(){
		$("#closeBtns").find("span").removeClass("layui-icon-down");
		$("#closeBtns").find("span").addClass("layui-icon-right");
	})
	/**
	 * 菜单切换内容处理
	 * yangzeng 20191104*/
	function setIframeWindow( id, name, url){
		let doc = $("#tagBars>a[title='"+name+"']");
		if(doc[0]){ //若存在则切换
			doc.siblings().removeClass("tag-bar-itemd");
			doc.addClass("tag-bar-itemd");
		}else{ //不存在则添加
			let _id = "iframe_"+id;
			let tagEle = createTagItem(_id, name, url);
			$("#tagBars>a").removeClass("tag-bar-itemd");
			$("#tagBars").append(tagEle);
			//标签对应事件的添加
			$("#tagBars>.tag-bar-item:last-child>.tag-bar-text").on("click",function(){
				toggleItem(this);
			});
			//关闭按钮对应事件的添加
			$("#tagBars>.tag-bar-item:last-child>.tag-bar-btn").on("click",function(){
				//关闭按钮触发函数
				closeItem(this);
			});
		}
		//iframe 内容切换
		toggleIframeContent();
		//tag元素创建
		function createTagItem(id, name, url){
			let str = '';
			str += '<a class="tag-bar-item layui-anim tag-bar-itemd" href="javascript: void(0)" '+
				'title="'+ name +'" data-id="'+id+'" data-url="'+url+'">';
			str += '	<span class="tag-bar-text" click="addItemClick()">'+name+'</span>';
			str += '	<span class="tag-bar-btn">×</span>';
			str += '</a>';
			return str;
		}
	};
	/**
	 * 顶部tag标签切换触发
	 * yangzeng 20191104*/
	function toggleItem(e){
		let doc = $(e).parent();
		doc.addClass("tag-bar-itemd");
		doc.siblings().removeClass("tag-bar-itemd");
		toggleIframeContent();
	}
	/**
	 * 顶部tag标签关闭按钮的触发
	 * yangzeng 20191104*/
	function closeItem(e){
		let parent = $(e).parent();
		if(parent.hasClass("tag-bar-itemd")){
			if(parent.prev()[0]){
				parent.prev().addClass("tag-bar-itemd");
			}else if(parent.next()[0]){
				parent.next().addClass("tag-bar-itemd");
			}
			//iframe 内容切换
			toggleIframeContent();
		}
		parent.addClass("layui-anim-fadeout");
		setTimeout(function(){
			parent.remove();
			//判断标签内元素是否全部关闭，若全部关闭则刷新页面
			if($("#tagBox .tag-bar-item").length == 0){
				window.location.reload();
			}
		},500);
	}
	/**
	 * iFrame 内容切换 */
	function toggleIframeContent(){
		let showTag = $("#tagBox").find('.tag-bar-itemd');
		$("#tagIframe").attr("src",showTag.attr('data-url'));
	}
})