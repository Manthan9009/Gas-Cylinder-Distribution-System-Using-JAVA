-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2024 at 08:43 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gas1`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `aadhar_number` bigint(20) DEFAULT NULL,
  `mobile_number` bigint(20) DEFAULT NULL,
  `connectionType` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `firstname`, `lastname`, `dateofbirth`, `aadhar_number`, `mobile_number`, `connectionType`) VALUES
(1, 'Aarav', 'Sharma', '1985-07-12', 123456789012, 9876543210, '14.2kg'),
(2, 'Vivaan', 'Verma', '1992-01-18', 123456789013, 9876543211, '19kg'),
(3, 'Aditya', 'Mishra', '1988-03-25', 123456789014, 9876543212, '5kg'),
(4, 'Arjun', 'Yadav', '1995-05-22', 123456789015, 9876543213, '14.2kg'),
(5, 'Vihaan', 'Singh', '1990-08-30', 123456789016, 9876543214, '19kg'),
(6, 'Sai', 'Kumar', '1983-11-05', 123456789017, 9876543215, '5kg'),
(7, 'Reyansh', 'Patel', '1987-02-14', 123456789018, 9876543216, '14.2kg'),
(8, 'Ayaan', 'Joshi', '1991-04-29', 123456789019, 9876543217, '19kg'),
(9, 'Krishna', 'Sinha', '1989-07-17', 123456789020, 9876543218, '5kg'),
(10, 'Ishaan', 'Reddy', '1993-12-11', 123456789021, 9876543219, '14.2kg'),
(11, 'Anaya', 'Sharma', '1984-02-23', 123456789022, 9876543220, '19kg'),
(12, 'Diya', 'Gupta', '1990-06-30', 123456789023, 9876543221, '5kg'),
(13, 'Aadhya', 'Mehta', '1985-09-04', 123456789024, 9876543222, '14.2kg'),
(14, 'Kiara', 'Chopra', '1993-11-22', 123456789025, 9876543223, '19kg'),
(15, 'Mishka', 'Pandey', '1986-05-10', 123456789026, 9876543224, '5kg'),
(16, 'Aarohi', 'Rana', '1982-08-15', 123456789027, 9876543225, '14.2kg'),
(17, 'Riya', 'Malik', '1992-12-08', 123456789028, 9876543226, '19kg'),
(18, 'Anika', 'Das', '1994-03-14', 123456789029, 9876543227, '5kg'),
(19, 'Pari', 'Ghosh', '1989-07-02', 123456789030, 9876543228, '14.2kg'),
(20, 'Prisha', 'Saxena', '1987-10-28', 123456789031, 9876543229, '19kg'),
(21, 'Manya', 'Sharma', '1996-01-18', 123456789032, 9876543230, '5kg'),
(22, 'Saanvi', 'Patel', '1988-04-06', 123456789033, 9876543231, '14.2kg'),
(23, 'Arya', 'Iyer', '1991-09-19', 123456789034, 9876543232, '19kg'),
(24, 'Myra', 'Rao', '1985-11-29', 123456789035, 9876543233, '5kg'),
(25, 'Tara', 'Sharma', '1983-07-07', 123456789036, 9876543234, '14.2kg'),
(26, 'Shanaya', 'Nair', '1986-12-15', 123456789037, 9876543235, '19kg'),
(27, 'Amaira', 'Menon', '1992-03-23', 123456789038, 9876543236, '5kg'),
(28, 'Navya', 'Singh', '1994-06-18', 123456789039, 9876543237, '14.2kg'),
(29, 'Aadhira', 'Khan', '1989-10-03', 123456789040, 9876543238, '19kg'),
(30, 'Vedika', 'Sinha', '1987-02-19', 123456789041, 9876543239, '5kg'),
(31, 'Kavya', 'Patil', '1990-05-13', 123456789042, 9876543240, '14.2kg'),
(32, 'Nitya', 'Reddy', '1984-08-24', 123456789043, 9876543241, '19kg'),
(33, 'Meera', 'Agarwal', '1983-11-16', 123456789044, 9876543242, '5kg'),
(34, 'Nandini', 'Bose', '1995-03-25', 123456789045, 9876543243, '14.2kg'),
(35, 'Aarush', 'Shah', '1982-07-09', 123456789046, 9876543244, '19kg'),
(36, 'Rudra', 'Desai', '1993-10-19', 123456789047, 9876543245, '5kg'),
(37, 'Aryan', 'Kapoor', '1991-02-04', 123456789048, 9876543246, '14.2kg'),
(38, 'Atharv', 'Chatterjee', '1996-06-12', 123456789049, 9876543247, '19kg'),
(39, 'Dhruv', 'Bhatt', '1984-09-08', 123456789050, 9876543248, '5kg'),
(40, 'Advait', 'Bajaj', '1988-11-22', 123456789051, 9876543249, '14.2kg'),
(41, 'Kabir', 'Sharma', '1986-03-15', 123456789052, 9876543250, '19kg'),
(42, 'Neha', 'Gupta', '1992-07-23', 123456789053, 9876543251, '5kg'),
(43, 'Rohan', 'Mehta', '1990-12-30', 123456789054, 9876543252, '14.2kg'),
(44, 'Arjun', 'Verma', '1985-01-14', 123456789055, 9876543253, '19kg'),
(45, 'Ishika', 'Patel', '1993-04-28', 123456789056, 9876543254, '5kg'),
(46, 'Manav', 'Rao', '1988-09-10', 123456789057, 9876543255, '14.2kg'),
(47, 'Simran', 'Singh', '1987-06-05', 123456789058, 9876543256, '19kg'),
(48, 'Yash', 'Kumar', '1995-11-21', 123456789059, 9876543257, '5kg'),
(49, 'Karan', 'Agarwal', '1991-02-18', 123456789060, 9876543258, '14.2kg'),
(50, 'Divya', 'Iyer', '1989-08-08', 123456789061, 1234567867, '19kg');

--
-- Triggers `customer`
--
DELIMITER $$
CREATE TRIGGER `insert_Trigg` AFTER INSERT ON `customer` FOR EACH ROW BEGIN insert into customer_audit (action, customerId, firstname, lastname, new_mobile_number , connectionType, execution_time) values ('INSERT', new.customerID, new.firstname, new.lastname, new.mobile_number, new.connectionType, current_timestamp); END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `remove_Trigg` AFTER DELETE ON `customer` FOR EACH ROW BEGIN insert into customer_audit (action, customerId, firstname, lastname, old_mobile_number , connectionType, execution_time) values ('DELETE', old.customerID, old.firstname, old.lastname, old.mobile_number, old.connectionType, current_timestamp); END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `update_Trigg` AFTER UPDATE ON `customer` FOR EACH ROW BEGIN insert into customer_audit (action, customerId, firstname, lastname, old_mobile_number, new_mobile_number , connectionType, execution_time) values ('UPDATE', old.customerID, old.firstname, old.lastname, old.mobile_number, new.mobile_number, old.connectionType, current_timestamp); END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `customer_audit`
--

CREATE TABLE `customer_audit` (
  `action` varchar(100) NOT NULL,
  `customerID` int(11) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `old_mobile_number` bigint(20) DEFAULT NULL,
  `new_mobile_number` bigint(20) DEFAULT NULL,
  `connectionType` varchar(10) NOT NULL,
  `execution_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_audit`
--

INSERT INTO `customer_audit` (`action`, `customerID`, `firstname`, `lastname`, `old_mobile_number`, `new_mobile_number`, `connectionType`, `execution_time`) VALUES
('INSERT', 1, 'Aarav', 'Sharma', NULL, 9876543210, '14.2kg', '2024-08-23 11:48:06'),
('INSERT', 2, 'Vivaan', 'Verma', NULL, 9876543211, '19kg', '2024-08-23 11:50:59'),
('INSERT', 3, 'Aditya', 'Mishra', NULL, 9876543212, '5kg', '2024-08-23 11:52:19'),
('INSERT', 4, 'Arjun', 'Yadav', NULL, 9876543213, '14.2kg', '2024-08-23 11:54:32'),
('INSERT', 5, 'Vihaan', 'Singh', NULL, 9876543214, '19kg', '2024-08-23 11:56:38'),
('INSERT', 6, 'Sai', 'Kumar', NULL, 9876543215, '5kg', '2024-08-23 11:58:11'),
('INSERT', 7, 'Reyansh', 'Patel', NULL, 9876543216, '14.2kg', '2024-08-23 12:00:04'),
('INSERT', 8, 'Ayaan', 'Joshi', NULL, 9876543217, '19kg', '2024-08-23 12:15:50'),
('INSERT', 9, 'Krishna', 'Sinha', NULL, 9876543218, '5kg', '2024-08-23 12:17:07'),
('INSERT', 10, 'Ishaan', 'Reddy', NULL, 9876543219, '14.2kg', '2024-08-23 12:20:33'),
('INSERT', 11, 'Anaya', 'Sharma', NULL, 9876543220, '19kg', '2024-08-23 12:36:11'),
('INSERT', 12, 'Diya', 'Gupta', NULL, 9876543221, '5kg', '2024-08-23 12:37:09'),
('INSERT', 13, 'Aadhya', 'Mehta', NULL, 9876543222, '14.2kg', '2024-08-23 12:37:51'),
('INSERT', 14, 'Kiara', 'Chopra', NULL, 9876543223, '19kg', '2024-08-23 12:44:40'),
('INSERT', 15, 'Mishka', 'Pandey', NULL, 9876543224, '5kg', '2024-08-23 12:45:31'),
('INSERT', 16, 'Aarohi', 'Rana', NULL, 9876543225, '14.2kg', '2024-08-23 12:46:15'),
('INSERT', 17, 'Riya', 'Malik', NULL, 9876543226, '19kg', '2024-08-23 12:47:01'),
('INSERT', 18, 'Anika', 'Das', NULL, 9876543227, '5kg', '2024-08-23 12:47:43'),
('INSERT', 19, 'Pari', 'Ghosh', NULL, 9876543228, '14.2kg', '2024-08-23 12:48:44'),
('INSERT', 20, 'Prisha', 'Saxena', NULL, 9876543229, '19kg', '2024-08-23 12:49:25'),
('INSERT', 21, 'Manya', 'Sharma', NULL, 9876543230, '5kg', '2024-08-23 12:53:54'),
('INSERT', 22, 'Saanvi', 'Patel', NULL, 9876543231, '14.2kg', '2024-08-23 12:54:58'),
('INSERT', 23, 'Arya', 'Iyer', NULL, 9876543232, '19kg', '2024-08-23 12:55:39'),
('INSERT', 24, 'Myra', 'Rao', NULL, 9876543233, '5kg', '2024-08-23 12:56:28'),
('INSERT', 25, 'Tara', 'Sharma', NULL, 9876543234, '14.2kg', '2024-08-23 13:02:37'),
('INSERT', 26, 'Shanaya', 'Nair', NULL, 9876543235, '19kg', '2024-08-23 13:03:20'),
('INSERT', 27, 'Amaira', 'Menon', NULL, 9876543236, '5kg', '2024-08-23 13:03:56'),
('INSERT', 28, 'Navya', 'Singh', NULL, 9876543237, '14.2kg', '2024-08-23 13:04:33'),
('INSERT', 29, 'Aadhira', 'Khan', NULL, 9876543238, '19kg', '2024-08-23 13:05:09'),
('INSERT', 30, 'Vedika', 'Sinha', NULL, 9876543239, '5kg', '2024-08-23 13:05:46'),
('INSERT', 31, 'Kavya', 'Patil', NULL, 9876543240, '14.2kg', '2024-08-23 13:20:20'),
('INSERT', 32, 'Nitya', 'Reddy', NULL, 9876543241, '19kg', '2024-08-23 13:21:44'),
('INSERT', 33, 'Meera', 'Agarwal', NULL, 9876543242, '5kg', '2024-08-23 13:23:15'),
('INSERT', 34, 'Nandini', 'Bose', NULL, 9876543243, '14.2kg', '2024-08-23 13:25:13'),
('INSERT', 35, 'Aarush', 'Shah', NULL, 9876543244, '19kg', '2024-08-23 13:26:56'),
('INSERT', 36, 'Rudra', 'Desai', NULL, 9876543245, '5kg', '2024-08-23 13:28:10'),
('INSERT', 37, 'Aryan', 'Kapoor', NULL, 9876543246, '14.2kg', '2024-08-23 13:28:48'),
('INSERT', 38, 'Atharv', 'Chatterjee', NULL, 9876543247, '19kg', '2024-08-23 13:29:20'),
('INSERT', 39, 'Dhruv', 'Bhatt', NULL, 9876543248, '5kg', '2024-08-23 13:30:05'),
('INSERT', 40, 'Advait', 'Bajaj', NULL, 9876543249, '14.2kg', '2024-08-23 13:30:42'),
('INSERT', 41, 'Kabir', 'Sharma', NULL, 9876543250, '19kg', '2024-08-23 13:36:15'),
('INSERT', 42, 'Neha', 'Gupta', NULL, 9876543251, '5kg', '2024-08-23 13:37:26'),
('INSERT', 43, 'Rohan', 'Mehta', NULL, 9876543252, '14.2kg', '2024-08-23 13:38:22'),
('INSERT', 44, 'Arjun', 'Verma', NULL, 9876543253, '19kg', '2024-08-23 13:41:01'),
('INSERT', 45, 'Ishika', 'Patel', NULL, 9876543254, '5kg', '2024-08-23 13:42:09'),
('INSERT', 46, 'Manav', 'Rao', NULL, 9876543255, '14.2kg', '2024-08-23 13:42:57'),
('INSERT', 47, 'Simran', 'Singh', NULL, 9876543256, '19kg', '2024-08-23 13:43:35'),
('INSERT', 48, 'Yash', 'Kumar', NULL, 9876543257, '5kg', '2024-08-23 13:44:06'),
('INSERT', 49, 'Karan', 'Agarwal', NULL, 9876543258, '14.2kg', '2024-08-23 13:44:43'),
('INSERT', 50, 'Divya', 'Iyer', NULL, 9876543259, '19kg', '2024-08-23 13:45:29'),
('UPDATE', 50, 'Divya', 'Iyer', 9876543259, 1234567867, '19kg', '2024-08-24 04:13:54'),
('INSERT', 51, 'Babita', 'Gada', NULL, 9098987534, '14.2kg', '2024-08-24 04:15:29'),
('DELETE', 51, 'Babita', 'Gada', 9098987534, NULL, '14.2kg', '2024-08-24 04:15:48');

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `14kg_filled` int(11) DEFAULT NULL,
  `14kg_empty` int(11) DEFAULT NULL,
  `19kg_filled` int(11) DEFAULT NULL,
  `19kg_empty` int(11) DEFAULT NULL,
  `5kg_filled` int(11) DEFAULT NULL,
  `5kg_empty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `warehouse`
--

INSERT INTO `warehouse` (`14kg_filled`, `14kg_empty`, `19kg_filled`, `19kg_empty`, `5kg_filled`, `5kg_empty`) VALUES
(17, 358, 69, 51, 11, 39);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
