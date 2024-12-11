$(function (){
    loadTeacherList();

});

function loadTeacherList(){

    $.ajax({
        url:"/api/teacher/tlist"
    }).done(function (data){
        // console.log(data)
        let html="";
        data.forEach((element, index) => {
            html+="<tr>"
            html+="<td>"+element.id+"</td>td>"
            html+="<td>"+element.name+"</td>td>"
            html+="<td>"+element.subject+"</td>td>"
            html+="<td>"+element.sex+"</td>td>"
            html+="<td>"+element.age+"</td>td>"
            html+="<td>"+element.tno+"</td>td>"
            html+="<td> <a href='#' onclick='showTeacherDlg("+element.id+")'>修改</a> " +
                "&nbsp;&nbsp;<a href='#' onclick='deleteById("+element.id+")'>删除</a></td>"
            html+="</tr>"
        })
        $("#teacherTb").html(html)
    });
}
let layerIndex;
/**
 * 弹出学生新增/更新对话框
 */
function showTeacherDlg(id){

    let title = "新增"
    if (id){
        //编辑
        title = "编辑"
        $("#formId").css("display","block");
        //读取信息，赋值
        $.ajax({
            url:"/api/teacher/"+id,
            method:"GET"
        }).done(result=>{

            console.log(result)
            //遍历result对象并将值填充到#studForm表单中
            $.each(result, function(key, value){
                //修改选择器，确保选择的的是#studForm内的字段
                var field = $('#teacForm [name="'+ key +'"]');
                if (field.is(':radio')) {
                    field.filter('[value="' + value + '"]').prop('checked', true);//选中对应的单选按
                }else if (field.is(':checked')){
                    field.prop('checked',value === "yes");//选中复选框
                }else{
                    field.val(value);//填充文本框或其他字段
                }
            });
        })

    }else{
        //新增
        $("#teacForm")[0].reset();
        $("#formId").css("display","none");
    }

    layerIndex = layer.open({
        type:1,
        title:title,
        area:['520px','auto'],
        content:$('#teacForm')//捕获层
    });

}

layui.use(function (){
    //验证表单是否合法
    layui.form.on('submit(teac-dlg)', function(data){

        event.preventDefault();//组织表单默认提交

        commitTeaDlg();
    })
});

function commitTeaDlg(){
    let id = $("#id").val()

    let formData = $("#teacForm").serialize();

    if(id!=null && id!=""){
        //更新学生
        $.ajax({
            url:"/api/teacher/update",
            method:"PUT",
            data:formData
        }).done(result=>{
            console.log(result);
            if (result.id){
                //读取并刷新原来的读学生列表
                loadTeacherList();

                //关闭弹出窗
                console.log("update successfully!")
                if(layerIndex)
                    layer.close(layerIndex)
            }
        }).fail((jqXHR, textStatus, errorThrown) => {
            console.error("request failed:" + textStatus + "-" + errorThrown);
            //处理错误逻辑
            alert("an error occurred,please try it again.");
        });
    }else{
        //新增学生需要进行
        //将表单的数据发送到服务器的insert方法中，提交按钮变灰
        $.ajax({
            url:"/api/teacher/add",
            method:"POST",
            data:formData
        }).done(result=>{
            console.log(result);
            if (result.id){
                //读取并刷新原来的读学生列表
                loadTeacherList();

                //关闭弹出窗
                console.log("add successfully!")
                if(layerIndex)
                    layer.close(layerIndex)
            }
        }).fail((jqXHR, textStatus, errorThrown) => {
            console.error("request failed:" + textStatus + "-" + errorThrown);
            //处理错误逻辑
            alert("an error occurred,please try it again.");
        });
    }

    $("#btnOK").prop("disabled", true).addClass("layui-btn-disabled");//禁用按钮

}

function deleteById(id){
    //删除
    layer.confirm('你确定要删除这条记录', {icon: 3}, function(){
        $.ajax({
            url:"/api/teacher/delete/"+id,
            method:"DELETE"
        }).done(result=>{
            loadTeacherList();
        })
        layer.closeAll();//关闭所有层

    }, function(){

    });
}