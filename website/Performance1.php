<?php
$connect=mysqli_connect("localhost","root","","employeemanagementsystem");
$sql="SELECT * FROM per";
$result=mysqli_query($connect,$sql);
$chart_data='';
while( $row = mysqli_fetch_array($result)){
  $chart_data .="{project: '".$row["project"]."', cie1:".$row["cie1"].", cie2:".$row["cie2"].",cie3:".$row["cie3"].",cie4:".$row["cie4"]."} ,";
}
$chart_data=substr($chart_data,0,-2);
?>
<!DOCTYPE html>
<html>
<head>
  <title>Performance Analysis</title>
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"> </script>
      <script src=" https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"> </script>
  <script src=" https://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"> </script>
</head>
<body>
  <br />   <br />
  <div class="container" style="width:900px">
    <h2 align="center"> Team Performance</h2>
    <h3 align="center">Based on CIE</h3>
    <br />   <br />
    <div id="chart"></div>
  </div>
</body>
</html>

<script>
    Morris.Bar({
      element:'chart',
      data:[<?php echo $chart_data ?>],
      xkey:'project',
      ykeys:['cie1','cie2','cie3','cie4'],
      labels:['cie1','cie2','cie3','cie4'],
      hideHover:'auto',
    });

</script>
