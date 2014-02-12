-- phpMyAdmin SQL Dump
-- version 4.0.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 12, 2014 at 03:17 AM
-- Server version: 5.5.33
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `csc_473`
--

-- --------------------------------------------------------

--
-- Table structure for table `BUSINESS_UNIT`
--

CREATE TABLE `BUSINESS_UNIT` (
  `BUSINESS_UNIT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FACILITY_ID` int(11) NOT NULL,
  `NAME` varchar(300) NOT NULL,
  `IS_AVAILABLE` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 IS NOT AVAILABLE ; 1 IS AVAILABLE',
  `STATUS` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1 IS READY STATUS; 0 IS IN MAINTENANCE ',
  PRIMARY KEY (`BUSINESS_UNIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `BUSINESS_UNIT_DETAILS`
--

CREATE TABLE `BUSINESS_UNIT_DETAILS` (
  `BUSINESS_UNIT_DETAILS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BUSINESS_UNIT_ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(500) NOT NULL,
  `FEATURES` varchar(500) NOT NULL,
  PRIMARY KEY (`BUSINESS_UNIT_DETAILS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `FACILITY`
--

CREATE TABLE `FACILITY` (
  `FACILITY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) NOT NULL,
  `ADDRESS` varchar(200) NOT NULL,
  `CONTACT` varchar(200) NOT NULL,
  `BUILD_DATE` date NOT NULL,
  PRIMARY KEY (`FACILITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `FACILITY_DETAILS`
--

CREATE TABLE `FACILITY_DETAILS` (
  `FACILITY_DETAILS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FACILITY_ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(500) NOT NULL,
  `NOTE` varchar(1000) NOT NULL,
  PRIMARY KEY (`FACILITY_DETAILS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `FACILITY_USE`
--

CREATE TABLE `FACILITY_USE` (
  `FACILITY_USE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BUSINESS_UNIT_ID` int(11) NOT NULL,
  `PRICE` float NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `NOTE` varchar(500) NOT NULL,
  PRIMARY KEY (`FACILITY_USE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `MAINTENANCE`
--

CREATE TABLE `MAINTENANCE` (
  `MAINTENANCE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BUSINESS_UNIT_ID` int(11) NOT NULL,
  `COST` float NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `STATUS` char(1) NOT NULL DEFAULT '0' COMMENT 'P PENDING; W WORK IN PROGRESS; C COMPLETE',
  `NOTE` varchar(500) NOT NULL,
  PRIMARY KEY (`MAINTENANCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `MAINTENANCE_ORDER`
--

CREATE TABLE `MAINTENANCE_ORDER` (
  `ORDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAINTENANCE_ID` int(11) NOT NULL,
  `ORDER_DATE` date NOT NULL,
  `CONTACTS` varchar(300) NOT NULL,
  `ORDER_NOTE` int(11) NOT NULL,
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `MAINTENANCE_REQUEST`
--

CREATE TABLE `MAINTENANCE_REQUEST` (
  `REQUEST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MAINTENANCE_ID` int(11) NOT NULL,
  `BUSINESS_UNIT_ID` int(11) NOT NULL,
  `REQUEST_NOTE` varchar(500) NOT NULL,
  `REQUEST_DATE` date NOT NULL,
  PRIMARY KEY (`REQUEST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;
