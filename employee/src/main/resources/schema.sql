CREATE TABLE IF NOT EXISTS `employees` (
`emp_id` int AUTO_INCREMENT not null PRIMARY KEY,
`name` varchar(200) not null,
`address` varchar(255) not null,
`age` varchar(2) not null,
`phone` varchar(20) not null,
`in_branch` varchar(200) not null,
`created_at` date NOT NULL,
`created_by` varchar(20) NOT NULL,
`updated_at` date DEFAULT NULL,
`updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `accounts` (
`emp_id` int not null,
`account_number` int AUTO_INCREMENT not null PRIMARY KEY,
`email` varchar(200) not null,
`type` varchar(200) not null,
`created_at` date NOT NULL,
`created_by` varchar(20) NOT NULL,
`updated_at` date DEFAULT NULL,
`updated_by` varchar(20) DEFAULT NULL
);