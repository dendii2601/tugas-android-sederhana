<?php
    include("../../config.php");
    session_start();

    $id = $_GET['id'];

    $sql = "DELETE FROM konsumens WHERE id='$id'";
    $query = mysqli_query($conn, $sql) or die ("Tidak ada database");

    if($query){
        echo"<script>alert('Hapus konsumen sukses!')</script>";
        echo "<script>top.location='../../dashboard/dasboard_konsumen.php'</script>";
    }else{
        echo"<script>alert('Hapus konsumen gagal!')</script>";
        echo "<script>top.location='../../index.php'</script>";
    }
?>