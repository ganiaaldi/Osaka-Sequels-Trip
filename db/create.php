<?php
require_once('connection.php');
$batch = $_POST['batch'];
$musim = $_POST['musim'];
$durasi = $_POST['durasi'];
$tglawal = $_POST['tglawal'];
$tglakhir = $_POST['tglakhir'];
$destinasi = $_POST['destinasi'];

if(!$batch || !$musim || !$durasi || !$tglawal || !$tglakhir || !$destinasi){
  echo json_encode(array('message'=>'form harus terisi semua!'));
}else{	
$query = mysqli_query($CON, "INSERT INTO dbosakast VALUES ('$batch','$musim','$durasi','$tglawal','$tglakhir','$destinasi')");
if($query){
    echo json_encode(array('message'=>'Data batch berhasil ditambahkan!'));
  }else{
    echo json_encode(array('message'=>'Data batch gagal ditambahkan!'));
  }

}
?> 