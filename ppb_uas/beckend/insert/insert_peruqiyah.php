<?php
    include('../../config.php');

    $ustad=$_POST['ustad'];
    $alamat=$_POST['alamat'];
    $email=$_POST['email'];
    $no_hp=$_POST['no_hp'];

    $sql = "INSERT INTO peruqiyah(ustad, alamat, email, no_hp)VALUES('$ustad','$alamat','$email','$no_hp')";
    $query=mysqli_query($conn,$sql);
    if($query){
        echo "<script>alert('Insert Peruqiyah Sukses!!!')</script>";
        echo "<script>top.location='../../dashboard/dasboard_peruqiyah.php'</script>";
    }else{
        echo "<script>alert('Insert Peruqiyah Gagal!!!')</script>";
        echo "<script>top.location='../../dashboard/dasboard.php'</script>";
    }
?>