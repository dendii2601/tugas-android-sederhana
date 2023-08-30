<?php
$conn = mysqli_connect("localhost", "root", "", "uasppb");
if ($conn) {
    
    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $alamat = $_POST['alamat'];


    $respon = array();
    if ($username != "" && $email != "" && $password != "" && $alamat != "") {
        $query = "INSERT INTO konsumens VALUES ('', '$username', '$email', '$password', '$alamat')";
        mysqli_query($conn, $query);
        if (mysqli_affected_rows($conn) > 0) {
            array_push($respon, array(
                'status' => 'OK'
            ));
        } else {
            array_push($respon, array(
                'status' => 'FAILED'
            ));
        }
    } else {
        array_push($respon, array(
            'status' => 'FAILED'
        ));
    }
} else {
    array_push($respon, array(
        'status' => 'NOT CONNECTED'
    ));
}
echo json_encode(array("server_respon" => $respon));
mysqli_close($conn);

?>