<?php
session_start();
include "db_conn.php";

if(isset($_POST['ID']) && isset($_POST['password']))
{
  function validate($data){
    $data=trim($data);
    $data=stripslashes($data);
    $data=htmlspecialchars($data);
    return $data;
  }
  $ID=validate($_POST['ID']);
  $pass=validate($_POST['password']);
  if(empty($ID))
  { header("Location: index.php ? error=ID is required");
    exit();

  }else if(empty($pass)){
    header("Location: index.php ? error=Password is required");
      exit();
  }else{
    $sql="SELECT * FROM `employee_details` WHERE ID='$ID' AND Password='$pass'";
    $result=mysqli_query($conn,$sql);
    if(mysqli_num_rows($result)===1){
      $row=mysqli_fetch_assoc($result);
      if($row['ID']===$ID && $row["Password"]===$pass)
      {
      $_SESSION['ID']=$row['ID'];
      $_SESSION['Name']=$row['Fname']." ".$row['Lname'];
      $_SESSION['Post']=$row['Post'];
      header("Location:home.php");
      exit();
      }
    }
    else {
      header("Location: index.php ? error=Invalid credentials");
        exit();
    }
}
} else{
  header("Location: index.php");
  exit();
}
 ?>
