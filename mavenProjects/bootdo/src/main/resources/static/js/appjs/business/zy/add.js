var menuIds;
$().ready(function() {
    getXyTreeData();
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
        getAllSelectNodes();
		save();
	}
});

function getAllSelectNodes() {
    var ref = $('#xyTree').jstree(true); // 获得整个树

    menuIds = ref.get_selected(); // 获得所有选中节点的，返回值为数组

    $("#xyTree").find(".jstree-undetermined").each(function(i, element) {
        menuIds.push($(element).closest('.jstree-node').attr("tid"));
    });
}

function getXyTreeData() {
    $.ajax({
        type : "GET",
        url : "/xy/menu/tree",
        success : function(menuTree) {
            loadMenuTree(menuTree);
        }
    });
}

function loadMenuTree(xyTree) {
    $('#xyTree').jstree({
        'core' : {
            'data' : xyTree
        },
        "checkbox" : {
            "three_state" : true,
        },
        "plugins" : [ "wholerow", "checkbox" ]
    });
    //$('#menuTree').jstree("open_all");

}
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/business/zy/save",
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
				required : icon + "请输入姓名"
			}
		}
	})
}