-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Feb 2020 pada 08.42
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbosakast`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dbosakast`
--

CREATE TABLE `dbosakast` (
  `nomor` int(11) NOT NULL,
  `batch` varchar(10) NOT NULL,
  `musim` varchar(6) NOT NULL,
  `durasi` varchar(15) NOT NULL,
  `tglawal` date NOT NULL,
  `tglakhir` date NOT NULL,
  `destinasi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dbosakast`
--

INSERT INTO `dbosakast` (`nomor`, `batch`, `musim`, `durasi`, `tglawal`, `tglakhir`, `destinasi`) VALUES
(1, 'Batch 1', 'Spring', '3 Hari 2 Malam', '2020-03-17', '2020-02-19', 'Hari 1 :\r\nNamba Parks, Shinsaibashi, Dotonbori\r\nHari 2 :\r\nIstana Osaka,  Osaka Aquarium Kaiyukan,Kuil Shitennoji, menara Tsutenkaku,Shinsekai\r\nHari 3 :\r\nUniversal Studio Japan '),
(2, 'Batch 2', 'Spring', '5 Hari 4 Malam', '2020-02-21', '2020-02-25', 'Hari 1 :\r\nNamba Parks, Shinsaibashi, Dotonbori\r\nHari 2 :\r\nIstana Osaka,  Osaka Aquarium Kaiyukan,Kuil Shitennoji, menara Tsutenkaku,Shinsekai\r\nHari 3 :\r\nUniversal Studio Japan, Umeda\r\nHari 4 : \r\nGunung Koya,Tennen Onsen Naniwa-no-yu\r\nHari 5 :\r\nMuseum Hous');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dbosakast`
--
ALTER TABLE `dbosakast`
  ADD PRIMARY KEY (`nomor`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `dbosakast`
--
ALTER TABLE `dbosakast`
  MODIFY `nomor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
