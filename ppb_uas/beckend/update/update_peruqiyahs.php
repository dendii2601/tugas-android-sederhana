<?php
    include("../../config.php");

    $id = $_POST["id"];
    
    $ustad = $_POST["ustad"];
    $alamat = $_POST["alamat"];
    $email = $_POST["email"];
    $no_hp = $_POST["no_hp"];
    

    $sql = "UPDATE peruqiyah SET ustad='$ustad', alamat='$alamat', email='$email', no_hp='$no_hp' WHERE id='$id'";

    $result = mysqli_query($conn, $sql);

    if ($result) {
        echo"<script>alert('Update Sukses !!!')</script>";
        echo"<script>top.location='../../dashboard/dasboard_peruqiyah.php'</script>";
    }
    else{
        echo"<script>alert('Update Gagal !!!')</script>";
        echo"<script>top.location='../../dashboard/dasboard_peruqiyah.php'</script>";
    }
?>