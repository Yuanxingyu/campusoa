$().ready(function() {
	loadXyType();
	loadZyType();
    loadfdyType();
    loadbzrType();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/business/bj/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}

function loadXyType(){
    var html = "";
    $.ajax({
        url : '/business/xy/queryByproperties',
        data : {},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].tid + '">' + data[i].xymc + '</option>'
            }
            $(".xy-chosen-select").append(html);
            $(".xy-chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.xy-chosen-select').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function loadZyType(){
    var html = "";
    $.ajax({
        url : '/business/zy/queryByproperties',
        data : {},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].tid + '">' + data[i].zymc + '</option>'
            }
            $(".zy-chosen-select").append(html);
            $(".zy-chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.zy-chosen-select').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function loadfdyType(){
    var html = "";
    $.ajax({
        url : '/business/teacher/queryByproperties',
        data : {},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].tid + '">' + data[i].jsname + '</option>'
            }
            $(".fdy-chosen-select").append(html);
            $(".fdy-chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.fdy-chosen-select').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function loadbzrType(){
    var html = "";
    $.ajax({
        url : '/business/teacher/queryByproperties',
        data : {},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].tid + '">' + data[i].jsname + '</option>'
            }
            $(".bzr-chosen-select").append(html);
            $(".bzr-chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.bzr-chosen-select').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                }
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}