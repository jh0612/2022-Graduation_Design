/*
header图片自适应大小且不失真
 */
window.onload = function (){
    let screenW = document.body.clientWeight;
    let ratio = screenW/1600;//1766
    let img = document.getElementById("header");//通过id进行获取id
    img.style.height = ratio*100 + "ex";//635 px
    //进入网站先自适应
    screenW = document.body.clientWidth;
    ratio = screenW/1600;
    img.style.height = ratio*100 + "ex";
    //如果拖动就再自适应页面
    window.onresize = function (){
        screenW = document.body.clientWidth;
        ratio = screenW/1600;
        img.style.height = ratio*100 + "ex";
    }
}

/*

 */
