<?php
    include("../../config.php");
    session_start();

    $id = $_GET['id'];

    $sql = "DELETE FROM user WHERE id='$id'";
    $query = mysqli_query($conn, $sql) or die ("Tidak ada database");

    if($query){
        echo"<script>alert('Hapus admin sukses!')</script>";
        echo "<script>top.location='../../dashboard/dasboard.php'</script>";
    }else{
        echo"<script>alert('Hapus admin gagal!')</script>";
        echo "<script>top.location='../../index.php'</script>";
    }
?>