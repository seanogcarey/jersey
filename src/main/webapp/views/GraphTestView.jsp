<%--
  Created by IntelliJ IDEA.
  User: Sean
  Date: 21/04/2016
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Chart.js demo</title>
    <!-- import plugin script
    <script type="text/javascript" src="http://www.chartjs.org/assets/Chart.js">
    </script>
    -->

    <script src="../javascript/externalJavascriptResources/Chart.js"></script>

</head>
<body>
<!-- line chart canvas element -->
<canvas id="buyers" width="600" height="400"></canvas>
<!-- pie chart canvas element -->
<canvas id="countries" width="600" height="400"></canvas>
<!-- bar chart canvas element -->
<canvas id="income" width="600" height="400"></canvas>
<script>
    // line chart data
    var buyerData = {
        labels : ["Fitness","Speed","Strength"],
        datasets : [
            {
                fillColor : "rgba(172,194,132,0.4)",
                strokeColor : "#ACC26D",
                pointColor : "#fff",
                pointStrokeColor : "#9DB86D",
                data : [3,3,1]
            }
        ]
    }
    // get line chart canvas
    var buyers = document.getElementById('buyers').getContext('2d');
    // draw line chart

    new Chart(buyers).Line(buyerData);
    // pie chart data
    var pieData = [
        {
            value: 20,
            color:"#878BB6"
        },
        {
            value : 40,
            color : "#4ACAB4"
        },
        {
            value : 10,
            color : "#FF8153"
        },
        {
            value : 30,
            color : "#FFEA88"
        }
    ];
    // pie chart options
    var pieOptions = {
        segmentShowStroke : false,
        animateScale : true
    }
    // get pie chart canvas
    var countries= document.getElementById("countries").getContext("2d");
    // draw pie chart
    new Chart(countries).Pie(pieData, pieOptions);
    // bar chart data
    var barData = {
        labels : ["January","February","March","April","May","June"],
        datasets : [
            {
                fillColor : "#48A497",
                strokeColor : "#48A4D1",
                data : [456,479,324,569,702,600]
            },
            {
                fillColor : "rgba(73,188,170,0.4)",
                strokeColor : "rgba(72,174,209,0.4)",
                data : [364,504,605,400,345,320]
            }
        ]
    }
    // get bar chart canvas
    var income = document.getElementById("income").getContext("2d");
    // draw bar chart
    new Chart(income).Bar(barData);
</script>
</body>
</html>