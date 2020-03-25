
<template>
        <div class="bg">
          <div class="all" >
            <header id="topbar">
              <el-row>
                <el-col :span="4" class="topbar-left">
                  <i class="iconfont icon-kaoshi"></i>
                  <span class="title">有害垃圾</span>
                  <el-col>
                    <li>
                      <el-button type="primary" @click="tologin()">登录</el-button>
                      <el-button type="primary" @click="togarbage()">返回</el-button>
                    </li>
                   
                  </el-col>
                </el-col>
              </el-row>
            </header>
            <title>有害垃圾</title>
              <el-table 
              :data="pagination.records" 
              align="center" 
              class="table">
                  <el-table-column   prop="id" label="序号" width="250"></el-table-column>
                <el-table-column  prop="hazname" label="垃圾名称" width="250"></el-table-column>
              </el-table>
              <div class=".pagination">
                  <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="pagination.current"
                  :page-sizes="[10,15,20,50]"
                  :page-size="pagination.size"
                  layout="total, sizes, prev, pager, next, jumper"
                  :total="pagination.total"
                  class="page"
                ></el-pagination>
              </div>   
            </div>
        </div>
</template>

<script>

export default {

  data() {
    return {
        pagination: {
        //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 10 //每页条数
      }
      
    }
  },
  created() {
    this.getAnswerInfo()
    this.loading = true
    
  },
  methods: {
    getAnswerInfo() {
      this.$axios(`/api/hazardous/${this.pagination.current}/${this.pagination.size}`).then(res => {
        //   this.loading = false //数据加载完成去掉遮罩
          this.pagination = res.data.data;
          this.loading = false
      }).catch(error => {});
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getAnswerInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getAnswerInfo();
    } ,
    tologin(){
      this.$router.push({path: '/tologin'})
    },
    togarbage(){
      this.$router.push({path: '/'})
    }  
  }
};

 
</script>

<style lang="scss" scoped>
  .pagination {
    padding: 20px 0px 30px 0px;
    .el-pagination {
      display: flex;
      justify-content: center;
    }
  }
  .all {
    padding: 0px 10px;
    .page {
      margin-top: 50px;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .edit {
      margin-left: 50px;
    }
    .el-table tr {
      background-color: #dd5862 !important;
    }
  }
  .el-table .warning-row {
    background: #000 !important;
  }
  
  .el-table .success-row {
    background: #dd5862;
  }
  
  </style>
  <style scoped>
    .fade-enter-active, .fade-leave-active {
      transition: opacity .5s;
    }
    .fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
      opacity: 0;
    }
    #topbar {
      position: relative;
      z-index: 0;
      background-color: #124280;
      height: 100px;
      line-height: 45px;
      color: #fff;
      box-shadow: 5px 0px 10px rgba(0, 0, 0, 0.5);
    }
    #topbar .topbar-left {
      height: 100px;
      display: flex;
      justify-content: center;
      background: rgba(0, 0, 0, 0.05);
      overflow: hidden;
    }
    .topbar-left .icon-kaoshi {
      font-size: 60px;
    }
    .topbar-left .title {
      font-size: 20px;
      cursor: pointer;
    }
    .topbar-right {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    .topbar-right .user-img {
      width: 50px;
      height: 50px;
      border-radius: 50%;
    }
    .topbar-right .el-icon-menu {
      font-size: 30px;
      margin-left: 100px;
    }
    .topbar-right .user {
      position: relative;
      margin-right: 40px;
      display: flex;
    }
    .topbar-right .user .user-img {
      margin-top: 15px;
      margin-left: 10px;
      cursor: pointer;
    }
    .user .out {
      font-size: 14px;
      position: absolute;
      top: 80px;
      right: 0px;
      background-color: #fff;
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
      padding: 12px;
    }
    .user .out ul {
      list-style: none;
    }
    .user .out ul > li {
      height: 26px;
      line-height: 26px;
    }
    .out a {
      text-decoration: none;
      color: #000;
    }
    .out .exit {
      margin-top: 4px;
      padding-top: 4px;
      border-top: 1px solid #ccc;
    }
    .bg{
  z-index: 1;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  overflow-y: auto;
  height: 100%;
  background: url('../../assets/img/loginbg.png')center top / cover no-repeat;
  background-color: #b6bccdd1 !important;
}
.table{
  
width: 500px;
margin-left: 480px;
}
    </style>
