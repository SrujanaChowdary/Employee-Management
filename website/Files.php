<?php
if(isset($_POST['upload'])){
  $file_name=$_FILES['file']['name'];
  $file_type=$_FILES['file']['type'];
  $file_size=$_FILES['file']['size'];
  $file_tem_loc=$_FILES['file']['tmp_name'];
  $file_store="upload/".$file_name;
  move_uploaded_file($file_tem_loc,$file_store);
  header("Location:home.php");
}

 ?>

<html>
<head>
     <title>File Upload</title>
     <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
   <form  method="post" action="?" enctype="multipart/form-data">
     <label>Upload weeklly report on project</label>
     <p><input type="file" name="file"></p>
     <p><input type="submit" name="upload" value="upload"></p>

</body>
</html>
