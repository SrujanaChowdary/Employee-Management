<?php
session_start();
 if(isset($_SESSION['ID'])) {
 ?>

<!DOCTYPE html>
<html >
  <head>
    <title>HOME</title>
          <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
    <h2>Hello, <?php echo $_SESSION['Name'] ?></h2>
    <div class="main">

           <ul>
             <?php if(  $_SESSION['Post']==="HR" ){ ?>
             <li><a href = 'Performance.php'> Trainee Performance  </a> </li>
             <li><a href = 'Performance1.php'> Employee Performance </a> </li>
           <?php } ?>
             <li><a href = 'Files.php'> Private Files </a> </li>
             </ul>
        </div>
    <a href="logout.php">Logout</a>

  </body>
</html>
<?php
}else{
  header("Location: index.php ");
    exit();
}
 ?>
