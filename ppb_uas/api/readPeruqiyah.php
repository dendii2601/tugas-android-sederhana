<?php
    // include_once 'config.php';
    $konek = mysqli_connect("localhost","root","","uasppb");

    $result = array();
    $result['data'] = array();
    $sql = "SELECT * FROM peruqiyah";
    $query = mysqli_query($konek, $sql);

    while($row = mysqli_fetch_array($query)){
        $index['id'] = $row['0'];
        $index['ustad'] = $row['1'];
        $index['alamat'] = $row['2'];
        $index['email'] = $row['3'];
        $index['no_hp'] = $row['4'];
        array_push($result['data'],$index);
    }
    $result['success']="1";
    echo json_encode($result);
    mysqli_close($konek);
?>