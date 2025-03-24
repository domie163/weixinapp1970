const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootlf81r/",
            name: "springbootlf81r",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootlf81r/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校学术研讨信息管理系统"
        } 
    }
}
export default base
