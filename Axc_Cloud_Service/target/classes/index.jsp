
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Particles</title>
<style>
		
		body{background-color: #2D2D2D}
	</style>
</head>
<body>

<div id="mydiv" style="height:500px;"></div>
<script type="text/javascript">
		window.onload = function() {
		    //配置
		    var config = {
		        vx: 4,	//小球x轴速度,正为右，负为左
		        vy: 4,	//小球y轴速度
		        height: 2,	//小球高宽，其实为正方形，所以不宜太大
		        width: 2,
		        count: 100,		//点个数
		        color: "121, 162, 185", 	//点颜色
		        stroke: "130,255,255", 		//线条颜色
		        dist: 5000, 	//点吸附距离
		        e_dist: 10000, 	//鼠标吸附加速距离
		        max_conn: 10 	//点到点最大连接数
		    }

		    //调用
		    CanvasParticle(config);
		}
	</script>
<script type="text/javascript" src="MainPageTemplate/JS_Lib/canvas-particle.js"></script>
</body>
</html>
