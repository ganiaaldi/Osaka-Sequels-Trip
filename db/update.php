<?php
require_once('connection.php');
$no = $_POST['nomor'];
$batch = $_POST['batch'];
$musim = $_POST['musim'];
$durasi = $_POST['durasi'];
$tglawal = $_POST['tglawal'];
$tglakhir = $_POST['tglakhir'];
$destinasi = $_POST['destinasi'];

if(!$no || !$batch || !$musim ||!$durasi || !$tglawal || !$tglakhir || !$destinasi){
  echo json_encode(array('message'=>'form harus terisi semua!'));
}else{
$query = mysqli_query($CON, "UPDATE dbosakast SET nomor='$no', batch='$batch', musim='$musim',durasi='$durasi', tglawal='$tglawal',
tglakhir='$tglakhir', destinasi='$destinasi' WHERE nomor = '$no'");
if($query){
    echo json_encode(array('message'=>'Data batch berhasil diupdate!'));
  }else{
    echo json_encode(array('message'=>'Data batch gagal diupdate!'));
  }
}
?>