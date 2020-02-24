<?php
require_once('connection.php');
$batch = $_GET['batch'];
if(!$batch){
  echo json_encode(array('message'=>'form kosong.'));
}else{
$query = mysqli_query($CON, "DELETE FROM dbosakast WHERE batch ='$batch'");
if($query){
    echo json_encode(array('message'=>'Data batch berhasil dihapus.'));
  }else{
    echo json_encode(array('message'=>'Data batch gagal dihapus.'));
  }
}
?>