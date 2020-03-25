// 我的试卷页面
<template>
  <div class="bg">
    <header id="topbar">
      <el-row>
        <el-col :span="4" class="topbar-left">
          <i class="iconfont icon-kaoshi"></i>
          <span class="title">垃圾分类</span>
          
        </el-col>
      </el-row>
    </header>
    <div id="myExam">
      <div class="wrapper">
        <ul class="top">
          <li class="order">
              <h2>垃圾分类</h2>
              
          </li>
          <li class="search-li"><div class="icon"><input type="text" placeholder="输入垃圾名称查找所属分类" class="search" v-model="key"><i class="el-icon-search"></i></div></li>
          <li><el-button type="primary" @click="search()">搜索</el-button></li>
          <li><el-button type="primary" @click="tologin()">登录</el-button></li> 
        </ul>
        <p><h4>{{this.key}}{{this.temp}}{{this.result}}</h4></p><br>
        <ul class="paper" v-loading="loading">
          
          <!-- <li class="item" v-for="(item,index) in pagination.records" :key="index">
            <h4 @click="toExamMsg(item.examCode)">{{item.source}}</h4>
            <p class="name">{{item.source}}-{{item.description}}</p>
            <div class="info">
              <i class="el-icon-loading"></i><span>{{item.examDate.substr(0,10)}}</span>
              <i class="iconfont icon-icon-time"></i><span v-if="item.totalTime != null">限时{{item.totalTime}}分钟</span>
              <i class="iconfont icon-fenshu"></i><span>满分{{item.totalScore}}分</span>
            </div>
          </li> -->
          <li class="item">
              <h4 @click="toshowrecyclable()">可回收物</h4>
              <p class="name">废纸、废塑料、废玻璃制品、废金属、废织物等适宜回收，并且可以回收重复利用的生活废弃物</p>
              <!-- <div class="info">
                <i class="el-icon-loading"></i><span>{{item.examDate.substr(0,10)}}</span>
                <i class="iconfont icon-icon-time"></i><span v-if="item.totalTime != null">限时{{item.totalTime}}分钟</span>
                <i class="iconfont icon-fenshu"></i><span>满分{{item.totalScore}}分</span>
              </div> -->
            </li>
            <li class="item">
              <h4 @click="toshowhazardous()">有害垃圾</h4>
              <p class="name">废电池、费灯泡灯管、废药品、废油漆，以及有损人身体健康或者对环境直接或者间接会造成污染，有潜在危害的生活用品</p>
              <!-- <div class="info">
                <i class="el-icon-loading"></i><span>{{item.examDate.substr(0,10)}}</span>
                <i class="iconfont icon-icon-time"></i><span v-if="item.totalTime != null">限时{{item.totalTime}}分钟</span>
                <i class="iconfont icon-fenshu"></i><span>满分{{item.totalScore}}分</span>
              </div> -->
            </li>
            <li class="item">
              <h4 @click="toshowhousehold()">湿垃圾</h4>
              <p class="name">易腐垃圾，如食材废弃料、剩饭剩菜、过期食品、水果皮、干果垃圾，废弃植物、中药残渣等生活废弃物品。
  
                  如：剩菜剩饭、瓜皮果核、花卉绿植、过期食品等。</p>
              <!-- <div class="info">
                <i class="el-icon-loading"></i><span>{{item.examDate.substr(0,10)}}</span>
                <i class="iconfont icon-icon-time"></i><span v-if="item.totalTime != null">限时{{item.totalTime}}分钟</span>
                <i class="iconfont icon-fenshu"></i><span>满分{{item.totalScore}}分</span>
              </div> -->
            </li>
            <li class="item">
              <h4 @click="toshowresidual()">干垃圾</h4>
              <p class="name">就是生活中的其它垃圾，并且不属于“湿垃圾”、“有害垃圾”、“可回收垃圾”的垃圾分类，也叫其它垃圾。</p>
              <!-- <div class="info">
                <i class="el-icon-loading"></i><span>{{item.examDate.substr(0,10)}}</span>
                <i class="iconfont icon-icon-time"></i><span v-if="item.totalTime != null">限时{{item.totalTime}}分钟</span>
                <i class="iconfont icon-fenshu"></i><span>满分{{item.totalScore}}分</span>
              </div> -->
            </li>
         
            
        </ul>
        <!-- <div class="pagination">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pagination.current"
            :page-sizes="[6, 10, 20, 40]"
            :page-size="pagination.size"
            layout="total, sizes, prev, pager, next, jumper"
            :total="pagination.total">
          </el-pagination>
        </div> -->
      </div>
    </div>
  </div>
  

</template>

<script>
export default {
  // name: 'myExam'
  data() {
    return {
      loading: false,
      key: '', //搜索关键字
      result: '',
      temp: '',
      // allExam: null, //所有考试信息
      // pagination: { //分页后的考试信息
      //   current: 1, //当前页
      //   total: null, //记录条数
      //   size: 6 //每页条数
      // }
    }
  },
  created() {
    // this.getExamInfo()
    // this.loading = true
  },
  // watch: {
    
  // },
  methods: {
    //获取当前所有考试信息
    getExamInfo() {
      this.$axios(`/api/exams/${this.pagination.current}/${this.pagination.size}/`).then(res => {
        this.pagination = res.data.data
        this.loading = false
        console.log(this.pagination)
      }).catch(error => {
        console.log(error)
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val
      this.getExamInfo()
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val
      this.getExamInfo()
    },
    //搜索垃圾
    search() {
      let searchval=this.key
      this.$axios(`/api/hazardousName/${searchval}`).then(res => {
        if(res.data.code == 400){
          this.temp="关键字有误，请重新输入！"
        }
        if(res.data.code == 200) {
          this.temp='属于'
          this.result= res.data.data
        }
        
      })
    },
    //跳转到可回收物页
    toshowrecyclable() {
      this.$router.push({path: '/toshowrecyclable'})
    },
    //跳转到有害垃圾页
    toshowhazardous() {
      this.$router.push({path: '/toshowhazardous'})
    },
    //跳转到湿垃圾页
    toshowhousehold() {
      this.$router.push({path: '/toshowhousehold'})
    },
    //跳转到干垃圾页
    toshowresidual() {
      this.$router.push({path: '/toshowresidual'})
    },
    tologin(){
      this.$router.push({path: '/tologin'})
    }
  }
}
</script>

<style lang="scss" scoped>
.pagination {
  padding: 20px 0px 30px 0px;
  .el-pagination {
    display: flex;
    justify-content: center;
  }
}
.paper {
  h4 {
    cursor: pointer;
  }
}
.paper .item a {
  color: #000;
}
.wrapper .top .order {
  cursor: pointer;
}
.wrapper .top .order:hover {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.wrapper .top .order:visited {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.item .info i {
  margin-right: 5px;
  color: #0195ff;
}
.item .info span {
  margin-right: 14px;
}
.paper .item {
  width: 380px;
  border-radius: 4px;
  padding: 20px 30px;
  border: 1px solid #eee;
  box-shadow: 0 0 4px 2px rgba(217,222,234,0.3);
  transition: all 0.6s ease;
}
.paper .item:hover {
  box-shadow: 0 0 4px 2px rgba(140, 193, 248, 0.45);
  transform: scale(1.03);
}
.paper .item .info {
  font-size: 14px;
  color: #88949b;
}
.paper .item .name {
  font-size: 14px;
  color: #88949b;
}
.paper * {
  margin: 20px 0;
}
.wrapper .paper {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}
.top .el-icon-search {
  position: absolute;
  right: 10px;
  top: 10px;
}
.top .icon {
  position: relative;
}
.wrapper .top {
  border-bottom: 1px solid #eee;
  margin-bottom: 20px;
}
#myExam .search-li {
  margin-left: auto;
}
.top .search-li {
  margin-left: auto;
}
.top li {
  display: flex;
  align-items: center;
}
.top .search {
    width: 200px;
  margin-left: auto;
  padding: 10px;
  border-radius: 4px;
  border: 1px solid #eee;
  box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
  transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
.top .search:hover {
  color: #0195ff;
  border-color: #0195ff;
}
.wrapper .top {
  display: flex;
}
.wrapper .top li {
  margin: 20px;
}
#myExam {
  width: 1200px;
  
  margin: 0 auto;
}
#myExam .title {
  margin: 20px;
}
#myExam .wrapper {
  z-index: 1;
  background-color: #fff;
  
}
.bg{
  z-index: 2;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  overflow-y: auto;
  height: 100%;
  background: url('../../assets/img/loginbg.png')center top / cover no-repeat;
  background-color: #b6bccdd1 !important;
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
    z-index: 10;
    background-color: #124280;
    height: 80px;
    line-height: 80px;
    color: #fff;
    box-shadow: 5px 0px 10px rgba(0, 0, 0, 0.5);
  }
  #topbar .topbar-left {
    height: 80px;
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
    margin-left: 20px;
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
  </style>