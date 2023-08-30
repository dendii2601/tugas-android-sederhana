<?php
    include("../../config.php");
    session_start();

    $id = $_GET['id'];

    $sql = "DELETE FROM peruqiyah WHERE id='$id'";
    $query = mysqli_query($conn, $sql) or die ("Tidak ada database");

    if($query){
        echo"<script>alert('Hapus Peruqiyah sukses!')</script>";
        echo "<script>top.location='../../dashboard/dasboard_peruqiyah.php'</script>";
    }else{
        echo"<script>alert('Hapus Peruqiyah gagal!')</script>";
        echo "<script>top.location='../../index.php'</script>";
    }
?>