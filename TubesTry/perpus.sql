-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 28 Nov 2016 pada 20.56
-- Versi Server: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `perpus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE IF NOT EXISTS `anggota` (
  `id` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`id`, `nama`, `alamat`) VALUES
('0001', 'satrio', 'sukabirus'),
('0002', 'Nisa N', 'Sukabirus lorong'),
('0003', 'Aliza', 'Sukapura'),
('0004', 'Bety', 'Sukapura'),
('0005', 'Hariyanto', 'Sukabirus Ujung');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE IF NOT EXISTS `buku` (
  `id` varchar(10) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `pengarang` varchar(50) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`id`, `judul`, `pengarang`, `genre`, `penerbit`) VALUES
('b001', 'Matematika', 'Devi permata', 'aritmatik', 'Gramedia'),
('b002', 'Andai Aku Hewan', 'Justina Ayu', 'Fiksi', 'Gerai Cinta'),
('b003', 'CInta Itu Buta', 'Sabuta', 'Romance', 'Grambel');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pustakawan`
--

CREATE TABLE IF NOT EXISTS `pustakawan` (
  `id` varchar(10) NOT NULL,
  `namaPustakawan` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pustakawan`
--

INSERT INTO `pustakawan` (`id`, `namaPustakawan`, `password`) VALUES
('001', 'hariyanto', 'hariyanto');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `id` varchar(100) NOT NULL,
  `tanggalPinjam` varchar(100) NOT NULL,
  `tanggalKembali` varchar(100) DEFAULT NULL,
  `idAnggota` varchar(100) NOT NULL,
  `idBuku` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `tanggalPinjam`, `tanggalKembali`, `idAnggota`, `idBuku`) VALUES
('0001', '11-29-2016', '13-29-2016', '0001', 'b003'),
('0002', '11-29-2016', '12-28-2016', '0002', 'b001'),
('0004', '11-29-2016', NULL, '0004', '0005'),
('0005', '11-29-2016', NULL, '0005', 'b002'),
('0003', '11-29-2016', NULL, '0003', 'b001');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
