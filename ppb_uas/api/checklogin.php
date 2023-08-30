<?php
$username="";
$password="";
    $connection = mysqli_connect("localhost","root","","uasppb");
    if($connection){
        if(isset($_POST['username']) || isset($_POST['password'])){
        $username = $_POST['username'];
        $password = $_POST['password'];
        }
        $query = "SELECT * FROM konsumens WHERE username = '$username' AND password='$password'";
        $result = mysqli_query($connection, $query);
        $response = array();
        $row = mysqli_num_rows($result);
        if($row > 0){
            array_push($response, array(
                'status' => 'OK'
            ));
        }else{
            array_push($response, array(
                'status' => 'FAILED'
            ));
        }        
    }else{
        array_push($response, array(
            'status' => 'FAILED'
        ));
    }
    echo json_encode(array("server_response" => $response));
    mysqli_close($connection);
?>