<?php
include("../../config.php");

    $username = $_POST["username"];
    $email = $_POST["email"];
    $password = $_POST["password"];


    $sql = "INSERT INTO user(username, email, password)VALUES('$username','$email','$password')";
    $query=mysqli_query($conn,$sql);
    if($query){
        echo"<script>alert('Register sukses!')</script>";
        echo "<script>top.location='../../index.php'</script>";
    }else{
        echo"<script>alert('Register gagal!')</script>";
        echo "<script>top.location='../../index.php'</script>";
    }


?>
