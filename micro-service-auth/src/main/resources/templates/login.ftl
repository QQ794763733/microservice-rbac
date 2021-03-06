<!DOCTYPE html>
<html>
<head>
    <title>微服务鉴权中心</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <script src="https://cdn.jsdelivr.net/npm/vue@2.6.12"></script>
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <style>
        html{
            height: 100%;
        }
        body{
            background-color: #909399;
            height: 100%;
        }
        .content-center{
            text-align: center;
        }
        #app{
            height: 100%;
        }
        .box{
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .card-style{
            width: 30%;
        }
        .title-style{

        }
    </style>
</head>
<body>
<div id="app">
    <div class="box">
        <el-card class="card-style">
            <div class="content-center title-style">
                <h2>微服务鉴权中心</h2>
            </div>
            <el-form label-position="right" ref="login-form" :model="form" label-width="80px">
                <el-form-item label="账号名称:">
                    <el-input v-model="form.username" suffix-icon="el-icon-user"></el-input>
                </el-form-item>
                <el-form-item label="账号密码:">
                    <el-input v-model="form.password" suffix-icon="el-icon-info" show-password></el-input>
                </el-form-item>
                <div class="content-center">
                    <el-button plain v-on:click="login">登录</el-button>
                </div>
            </el-form>
        </el-card>
    </div>
</div>
</body>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            form: {
                username: '',
                password: ''
            }
        },
        methods: {
            login(){
                axios.post("/authentication",this.form)
                    .then(function(response){
                        console.log(response);
                    })
                    .catch(function(error){
                        console.log(error);
                        this.$message.error('错了哦，这是一条错误消息');
                    });
            }
        }
    })
</script>
</html>