$().ready(function() {
	loadBjType();
	loadZyKcType();
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
		url : "/business/bjKb/update",
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

function loadBjType(){
    var html = "";
    $.ajax({
        url : '/business/bj/queryByproperties',
        data : {},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].tid + '">' + data[i].bjmc + '</option>'
            }
            $(".bj-chosen-select").append(html);
            $(".bj-chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.bj-chosen-select').on('change', function(e, params) {
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

function loadZyKcType(){
    var html = "";
    $.ajax({
        url : '/business/zyKc/queryByproperties',
        data : {},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].tid + '">' + data[i].kcmc + '</option>'
            }
            $(".kc-chosen-select").append(html);
            $(".kc-chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.kc-chosen-select').on('change', function(e, params) {
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