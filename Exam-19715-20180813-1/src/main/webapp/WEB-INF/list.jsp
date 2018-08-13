<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ljj.entity.*,java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>列表页</title>
    <script src="jquery/jquery.js"></script>
    <link rel="stylesheet"
          href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script
            src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- =================================新增框=========================================-->
<div class="modal fade" id="filmAddModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">电影事项新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">电影名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="filmTitle" class="form-control"
                                   id="filmTitle_add_input" placeholder="输入名称"> <span
                                class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-10">
								<textarea  name="filmDescription" class="form-control"
                                           id="filmDescription_add_input" placeholder="输入描述"></textarea> <span
                                class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">语言</label>
                        <div class="col-sm-4">
                            <!-- 变成4列 -->
                            <select class="form-control" name="language" id="language_add_select">
                                <option value="English">English</option>
                                <option value="Italian">Italian</option>
                                <option value="Japanese">Japanese</option>
                                <option value="Mandarin">Mandarin</option>
                                <option value="French">French</option>
                                <option value="German">German</option>
                            </select>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="film_add_btn">添加</button>
            </div>
        </div>
    </div>
</div>
<!-- =================================编辑框=========================================-->
<div class="modal fade" id="filmUpdateModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">电影事项编辑</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">电影名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="filmTitle" class="form-control"
                                   id="filmTitle_update_input" placeholder="输入名称"> <span
                                class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-10">
								<textarea  name="filmDescription" class="form-control"
                                           id="filmDescription_update_input" placeholder="输入描述"></textarea> <span
                                class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">语言</label>
                        <div class="col-sm-4">
                            <!-- 变成4列 -->
                            <select class="form-control" name="language" id="language_update_select">
                                <option value="English">English</option>
                                <option value="Italian">Italian</option>
                                <option value="Japanese">Japanese</option>
                                <option value="Mandarin">Mandarin</option>
                                <option value="French">French</option>
                                <option value="German">German</option>
                            </select>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="film_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<!-- =================================编辑框=========================================-->

<div class="container">
    <!--按钮-->
    <div class="row">
        <div class="col-md-8">
            <button class="btn btn-primary" id="film_add_modal_btn">新增</button>
            <button class="btn btn-danger" id="film_delete_all" style="margin-left:80px">删除</button>
        </div>
    </div>
    <!--表格数据-->
    <div class="row">

        <table class="table table-hover" id="items_table">
            <thead>
            <tr>
                <th><input type="checkbox" id="check_all"></th>
                <th>id</th>
                <th>电影名称</th>
                <th style="width:300px">描述</th>
                <th>语言</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <c:forEach items="${allFilm}" var="film">
                <tbody>
                <tr>
                    <td><input type='checkbox' class='check_item'/></td>
                    <td>${film.film_id}</td>
                    <td>${film.title}</td>
                    <td>${film.description}</td>
                    <td>${film.name}</td>
                    <td>
                        <button class="btn btn-primary btn-sm edit_btn" edit-id="${film.film_id}" >
                            编辑
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-danger btn-sm delete_btn" delete-id="${film.film_id}" >
                            删除
                        </button>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>

        <!--分页信息-->
        <div class="row">
            <!--分页文字信息-->
            <div class="col-md-3 col-md-offset-2" style="margin-top:25px" id="page_info_area"></div>
            <!--分页条信息-->
            <div class="col-md-4 col-md-offset-2" id="page_nav"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).on("click", ".edit_btn" ,function(){

        var updateId = $(this).attr("edit-id")
        getFilm(updateId)
        $("#film_update_btn").attr("edit-id",updateId)//把相应的事项id传给更新按钮，方便update操作
        $("#filmUpdateModal").modal({ //利用js创建模态框
            backdrop : "static"
        });
    });

    function getFilm(updateId){
        $.ajax({
            url:"getFilm",
            data:{filmId:updateId},
            type:"GET",
            success:function (result) {
                var filmData = eval("("+result+")");
                $("#filmTitle_update_input").val(filmData.title);
                $("#filmDescription_update_input").val(filmData.description);
                $("#language_update_select").find("option[value="+filmData.name+"]").attr("selected","selected");
            }
        })
    }

    $("#film_update_btn").click(function(){
        $.ajax({
            url:"updateFilm",
            type:"POST",
            data:{title:$("#filmTitle_update_input").val(),
                description:$("#filmDescription_update_input").val(),
                language:$("#language_update_select").val(),
                filmId:$(this).attr("edit-id")},
            success:function(result){
                //alert(result.msg);
                //1.关闭对话框
                $("#filmUpdateModal").modal("hide");
                //2.回到本页面
                to_page();//currentPage
            }
        });
    })


    //单个删除
    $(document).on("click", ".delete_btn" ,function(){
        //1.弹出是否确认删除对话框
        var filmTitle = $(this).parents("tr").find("td:eq(2)").text();
        var deleteId = $(this).attr("delete-id");
        if(confirm("确认删除["+filmTitle+"]吗?")){
            //确认.发送ajax请求删除
            $.ajax({
                url:"deleteFilm",
                data:{filmId:deleteId},
                type:"POST",
                success:function(result){
                    //alert(result.msg);
                    to_page();

                }
            })
        }
    })

    //点击全部删除,就批量删除
    $("#film_delete_all").click(function(){
        //$(".check_item:checked")
        var filmTitle = "";
        var deleteId = "";
        $.each($(".check_item:checked"),function(){
            //this
            filmTitle+=($(this).parents("tr").find("td:eq(2)").text())+",";
            //组装员工id字符串
            deleteId+=($(this).parents("tr").find("td:eq(1)").text())+"-";

        });
        //去除多余的,
        filmTitle = filmTitle.substring(0, filmTitle.length-1);
        //去除多余的-
        deleteId =deleteId.substring(0, deleteId.length-1);
        if(confirm("确认删除【"+filmTitle+"】吗")){
            //发送ajax请求删除
            $.ajax({
                url:"deleteFilm",
                data:{filmId:deleteId},
                type:"POST",
                success:function(result){
                    //alert(result.msg);
                    //回到当前页面
                    to_page();
                }
            });
        }
    });

    $("#film_add_modal_btn").click(function() {
        //清除表单数据(表单完整重置(表单的数据，表单的样式))
        //reset_form("#empAddModal form");
        $("#filmAddModal form")[0].reset();
        //弹出模态框
        $("#filmAddModal").modal({ //利用js创建模态框
            backdrop : "static"
        });
    });

    //点击添加
    $("#film_add_btn").click(function(){
        $.ajax({
            url:"addFilm",
            type:"POST",
            data:{title:$("#filmTitle_add_input").val(),
                description:$("#filmDescription_add_input").val(),
                language:$("#language_add_select").val()},
            success:function(result){
                //alert(result.msg);
                    $("#itemAddModal").modal("hide");
                    to_page(); //添加完去到最后一页
            }
        })
    });

    
    function to_page() {
        $.ajax({
            url:"list",
            success:function (result) {
                console.log(result)
            }
        })
        window.location.reload();
    }

    //全选/全不选
    $("#check_all").click(function(){
        //alert($(this).prop("checked"));
        $(".check_item").prop("checked",$(this).prop("checked"));
    });

    //check_item
    $(document). on("click", ".check_item" ,function(){
        //被选数等于组件总数就勾上全选
        var flag = $(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);

    });
</script>
</body>
</html>
