<?php
require_once('connection.php');
$nomor = $_GET['nomor'];
if(!$nomor){
  echo json_encode(array('message'=>'form kosong.'));
}else{
$query = mysqli_query($CON, "DELETE FROM dbosakast WHERE nomor ='$nomor'");
if($query){
    echo json_encode(array('message'=>'Data batch berhasil dihapus.'));
  }else{
    echo json_encode(array('message'=>'Data batch gagal dihapus.'));
  }
}
?>