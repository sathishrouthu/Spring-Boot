USE `spring_security`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `users`
VALUES
('sathish','{bcrypt}$2a$10$/n9QNW44VsevT6Zdffl/seCQLoyVIxNeuM9gvc2RY021V2XXKO8Im',1),
('john','{bcrypt}$2a$10$/n9QNW44VsevT6Zdffl/seCQLoyVIxNeuM9gvc2RY021V2XXKO8Im',1),
('dev','{bcrypt}$2a$10$/n9QNW44VsevT6Zdffl/seCQLoyVIxNeuM9gvc2RY021V2XXKO8Im',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
('sathish','ROLE_EMPLOYEE'),
('dev','ROLE_EMPLOYEE'),
('john','ROLE_EMPLOYEE'),
('john','ROLE_MANAGER'),
('sathish','ROLE_MANAGER'),
('sathish','ROLE_ADMIN');