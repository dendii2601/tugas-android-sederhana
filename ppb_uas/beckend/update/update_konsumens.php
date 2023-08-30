<?php
    include("../../config.php");

    $id = $_POST["id"];
    
    $username = $_POST["username"];
    $email = $_POST["email"];
    $password = $_POST["password"];
    $alamat = $_POST["alamat"];

    $sql = "UPDATE konsumens SET username='$username', email='$email', password='$password', alamat='$alamat' WHERE id='$id'";

    $result = mysqli_query($conn, $sql);

    if ($result) {
        echo"<script>alert('Update Sukses !!!')</script>";
        echo"<script>top.location='../../dashboard/dasboard_konsumen.php'</script>";
    }
    else{
        echo"<script>alert('Update Gagal !!!')</script>";
        echo"<script>top.location='../../dashboard/dasboard_konsumen.php'</script>";
    }
?>