-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2023 at 04:01 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `miniproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `login_details`
--

CREATE TABLE `login_details` (
  `id` int(11) NOT NULL,
  `name` char(40) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `admin_status` char(20) NOT NULL,
  `logged_in` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login_details`
--

INSERT INTO `login_details` (`id`, `name`, `email`, `password`, `admin_status`, `logged_in`) VALUES
(1, 'Kamal Lamichhane', 'klamichhane08@gmail.com', 'kamal123', 'accepted', 'yes'),
(2, 'Ram Sharma', 'ramsharma@gmail.com', 'ram123', 'rejected', 'no'),
(3, 'Shyam Lal', 'shyam@gmail.com', 'shyam123', 'requested', 'no'),
(4, '', '', '', 'no', 'no'),
(5, 'ishwor shrestha', 'ishwor123@gmail.com', 'ishwor123', 'no', 'no'),
(6, 'ritu', 'reetugurung26@gmail.com', 'password', 'no', 'no'),
(7, 'Amir poudel', 'amirpoudel@gmail.com', '123456', 'no', 'no'),
(8, 'dipak dahal', 'dipak@gmail.com', 'dipak123', 'requested', 'no'),
(9, 'dipak', 'dipakdahal@gmail.com', 'dipak123', 'no', 'no'),
(10, 'Lalit', 'hellohi@mail.com', '123', 'requested', 'no'),
(11, 'Abiral Gautam', 'abiralgautam08@gmail.com', 'abiral123', 'requested', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `question_asked`
--

CREATE TABLE `question_asked` (
  `user_id` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `question` varchar(250) NOT NULL,
  `answer` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question_asked`
--

INSERT INTO `question_asked` (`user_id`, `level`, `question`, `answer`) VALUES
(1, 1, 'What is the square root of 144?', '12'),
(1, 1, 'Which is the capital city of India?', 'New Delhi'),
(1, 1, 'Which Animal Lays the Largest Eggs?', 'Ostrish'),
(1, 1, 'Which is the closest planet to the Sun?', 'Mercury'),
(1, 2, 'In which ocean did the famous Titanic sink in 1912?', 'North Atlantic'),
(1, 2, 'What is the hottest place of Nepal?', 'Nepalgunj'),
(1, 2, 'In which district is Mahendra Cave located?', 'Kaski'),
(1, 3, 'What ray is used in remote control?', 'Infra red Ray'),
(1, 3, 'What is the fastest growing plant?', 'Bamboo'),
(1, 3, 'Where is the world’s largest prison?', 'Pakistan'),
(1, 3, 'In which district is ‘Nand Bhauju’ Lake located?', 'Chitwan'),
(1, 3, 'How long does it take for the sun’s light to come to Earth?', '8min 20sec'),
(1, 1, 'What is the square root of 144?', '12'),
(1, 1, 'How old must be to become President?', '45'),
(1, 1, 'Which is the National bird of Nepal?', 'Lhophophorus'),
(1, 1, 'Which month of the year has the least number of days?', 'February'),
(1, 1, 'How Many Colors does rainbow have?', '7'),
(1, 1, 'How old must be to become President?', '45'),
(1, 1, 'How many letters are in the English Alphabet?', '26'),
(3, 1, 'Which is the highest mountain in the world?', 'Mt. Everest'),
(3, 1, 'Who is Nepals first elected Prime Minister?', 'BP Koirala'),
(3, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(3, 1, 'How old must be to become President?', '45'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which is the smallest country in the world?', 'Vatican City'),
(0, 1, 'What is the square root of 144?', '12'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'What is the square root of 144?', '12'),
(0, 1, 'How Many Colors does rainbow have?', '7'),
(0, 1, 'How Many Colors does rainbow have?', '7'),
(0, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which is the highest mountain in the world?', 'Mt. Everest'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(0, 1, 'What is the square root of 144?', '12'),
(0, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(0, 1, 'Which is the largest river in Nepal?', 'SaptaKoshi'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'What is the square root of 144?', '12'),
(0, 1, 'What is the square root of 144?', '12'),
(0, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(0, 1, 'How old must be to become President?', '45'),
(0, 1, 'How Many Colors does rainbow have?', '7'),
(0, 1, 'Who is Nepals first elected Prime Minister?', 'BP Koirala'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'How Many Colors does rainbow have?', '7'),
(0, 1, 'What is the square root of 144?', '12'),
(0, 1, 'Which is the capital city of India?', 'New Delhi'),
(0, 1, 'How many letters are in the English Alphabet?', '26'),
(0, 1, 'In which Country is the Taj Mahal Located?', 'India'),
(0, 1, 'What is the square root of 144?', '12'),
(0, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(0, 1, 'How Many Colors does rainbow have?', '7'),
(0, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(0, 1, 'Which is the largest river in Nepal?', 'SaptaKoshi'),
(0, 1, 'Which is the highest mountain in the world?', 'Mt. Everest'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which is the largest river in Nepal?', 'SaptaKoshi'),
(0, 1, 'Which Animal Lays the Largest Eggs?', 'Ostrish'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Who is Nepals first elected Prime Minister?', 'BP Koirala'),
(0, 1, 'How Many Colors does rainbow have?', '7'),
(0, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(0, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'How old must be to become President?', '45'),
(0, 1, 'Which is the highest mountain in the world?', 'Mt. Everest'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which is the smallest country in the world?', 'Vatican City'),
(0, 1, 'How many letters are in the English Alphabet?', '26'),
(0, 1, 'How Many Colors does rainbow have?', '7'),
(0, 1, 'Which is the largest river in Nepal?', 'SaptaKoshi'),
(0, 1, 'How many letters are in the English Alphabet?', '26'),
(0, 1, 'How Many Colors does rainbow have?', '7'),
(0, 1, 'Which is the smallest country in the world?', 'Vatican City'),
(0, 1, 'Which is the National bird of Nepal?', 'Lhophophorus'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which is the highest mountain in the world?', 'Mt. Everest'),
(0, 1, 'Who is Nepals first elected Prime Minister?', 'BP Koirala'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'Which is the largest river in Nepal?', 'SaptaKoshi'),
(0, 1, 'What is the square root of 144?', '12'),
(0, 1, 'Which is the highest mountain in the world?', 'Mt. Everest'),
(0, 1, 'Which is the highest mountain in the world?', 'Mt. Everest'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'How Many Colors does rainbow have?', '7'),
(0, 1, 'Which is the highest mountain in the world?', 'Mt. Everest'),
(0, 1, 'Which is the capital city of India?', 'New Delhi'),
(0, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(0, 1, 'How old must be to become President?', '45'),
(1, 1, 'Which district is name as the Switzerland of Nepal?', 'Jiri'),
(1, 1, 'Who is Nepals first elected Prime Minister?', 'BP Koirala'),
(3, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(3, 2, 'Which is the smallest country in the world?', 'Vatican City'),
(3, 3, 'Which is the National bird of Nepal?', 'Lhophophorus'),
(3, 4, 'Which month of the year has the least number of days?', 'February'),
(1, 1, 'What is the square root of 144?', '12'),
(1, 2, 'What is the closest planet to the Sun?', 'Mercury'),
(1, 3, 'What is the next number in the following sequence 7,14,21,28?', '35'),
(1, 4, 'Which is the most living creature in the world?', 'Turtle'),
(1, 1, 'How Many Colors does rainbow have?', '7'),
(1, 2, 'The ozone layer restricts?', 'Ultraviolet radiation'),
(1, 1, 'How Many Colors does rainbow have?', '7'),
(1, 1, 'How Many Colors does rainbow have?', '7'),
(6, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(6, 2, 'How many days are there in a year?', '365'),
(6, 3, 'Filaria is caused by?', 'Mosquito'),
(7, 1, 'Which is the hottest planet in our solar system?', 'Venus'),
(7, 2, 'How many days are there in a year?', '365'),
(7, 3, 'What is the next number in the following sequence 7,14,21,28?', '35'),
(7, 4, 'Which country is the sunrise at midnight?', 'Norway'),
(7, 5, 'Hitler party which came into power in 1933 is known as?', 'Nazi Party'),
(7, 6, 'For the Olympics and World Tournaments, the dimensions of basketball court are?', '28 m x 15 m'),
(1, 1, 'Which is the highest mountain in the world?', 'Mt. Everest'),
(1, 2, 'In which Country is the Taj Mahal Located?', 'India'),
(1, 3, 'What is the next number in the following sequence 7,14,21,28?', '35'),
(1, 4, 'Which country is the world’s first female president?', 'Argentina'),
(1, 5, 'Hitler party which came into power in 1933 is known as?', 'Nazi Party'),
(1, 6, 'For the Olympics and World Tournaments, the dimensions of basketball court are?', '28 m x 15 m'),
(1, 7, 'Gravity setting chambers are used in industries to remove?', 'suspended particulate matter'),
(1, 8, 'Light Year is related to?', 'distance'),
(1, 9, 'Jesus Christ was crucified in?', '20 AD'),
(1, 10, 'Mother Teresa received the Magsaysay Award in 1962 in the area of?', 'international understanding'),
(8, 1, 'How Many Colors does rainbow have?', '7'),
(10, 1, 'What is the square root of 144?', '12'),
(10, 2, 'What is the closest planet to the Sun?', 'Mercury'),
(10, 3, 'Who is Nepal’s first elected Prime Minister?', 'BP Koirala'),
(10, 4, 'Which country is the world’s first female president?', 'Argentina'),
(10, 1, 'How Many Colors does rainbow have?', '7'),
(10, 2, 'How many days are there in a year?', '365'),
(10, 3, 'What is the next number in the following sequence 7,14,21,28?', '35'),
(10, 4, 'Which is the most living creature in the world?', 'Turtle'),
(1, 1, 'What is the square root of 144?', '12'),
(1, 2, 'What is the closest planet to the Sun?', 'Mercury'),
(1, 3, 'Who is Nepal’s first elected Prime Minister?', 'BP Koirala'),
(1, 4, 'Which is the most living creature in the world?', 'Turtle'),
(1, 5, 'FFC stands for?', 'Film Finance Corporation');

-- --------------------------------------------------------

--
-- Table structure for table `question_list`
--

CREATE TABLE `question_list` (
  `id` int(11) NOT NULL,
  `question` text NOT NULL,
  `option_a` varchar(40) NOT NULL,
  `option_b` varchar(40) NOT NULL,
  `option_c` varchar(40) NOT NULL,
  `option_d` varchar(40) NOT NULL,
  `correct_answer` varchar(40) NOT NULL,
  `level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `question_list`
--

INSERT INTO `question_list` (`id`, `question`, `option_a`, `option_b`, `option_c`, `option_d`, `correct_answer`, `level`) VALUES
(1, 'Which is the hottest planet in our solar system?', 'Saturn', 'Uranus', 'Mars', 'Venus', 'Venus', 1),
(2, 'What is the square root of 144?', '11', '12', '14', '16', '12', 1),
(3, 'Which district is name as the Switzerland of Nepal?', 'Mustang', 'Jumla', 'Lamjung', 'Jiri', 'Jiri', 1),
(6, 'Which is the highest mountain in the world?', 'Mt. Everest', 'Mt. K2', 'Mt. Cho Oyu', 'Mt. Kanchenjunga', 'Mt. Everest', 1),
(9, 'How Many Colors does rainbow have?', '5', '6', '7', '8', '7', 1),
(28, 'How many days are there in a year?', '365', '366', '369', '367', '365', 2),
(29, 'What is the closest planet to the Sun?', 'Mercury', 'Venus', 'Mars', 'Jupiter', 'Mercury', 2),
(30, 'In which Country is the Taj Mahal Located?', 'India', 'Nepal', 'China', 'Japan', 'India', 2),
(31, 'How many sides are there in a triangle?', '3', '4', '6', '8', '3', 2),
(32, 'The ozone layer restricts?', 'Ultraviolet radiation', 'Visible light', 'Infrared radiation', 'X-rays and gamma rays', 'Ultraviolet radiation', 2),
(33, 'Filaria is caused by?', 'Bacteria', 'Mosquito', 'Protozoa', 'Virus', 'Mosquito', 3),
(34, 'What is the next number in the following sequence 7,14,21,28?', '33', '34', '36', '35', '35', 3),
(35, 'Which day is celebrated as Environment Day?', '5 June', '8 June', '17 June', '5 August', '5 June', 3),
(36, 'In which district is Mahendra Cave located?', 'Kaski', 'Mustang', 'Jumla', 'Myadi', 'Kaski', 3),
(37, 'Who is Nepal’s first elected Prime Minister?', 'Gahendra Shumsher', 'BP Koirala', 'Madan Bhandari', 'Prithvi Narayan Shah', 'BP Koirala', 3),
(38, 'Which country is the world’s first female president?', 'Bhutan', 'Nepal', 'Argentina', 'USA', 'Argentina', 4),
(39, 'Which caste celebrates the Gaura festival?', 'Tharu', 'Magar', 'Tamang', 'Rai', 'Tharu', 4),
(40, 'Which country is the sunrise at midnight?', 'Argentina', 'Norway', 'Brazil', 'Africa', 'Norway', 4),
(41, 'Which is the most living creature in the world?', 'Turtle', 'Elephant', 'Whale', 'Chimpanzee', 'Turtle', 4),
(42, 'How many doors are there in Koshi Barrage?', '57', '59', '55', '54', '55', 4),
(43, 'Hitler party which came into power in 1933 is known as?', 'Labour Party', 'Ku-Klux-Klan', 'Democratic Party', 'Nazi Party', 'Nazi Party', 5),
(44, 'FFC stands for?', 'Foreign Finance Corporation', 'Film Finance Corporation', 'Federation of Football Council', 'None of the above', 'Film Finance Corporation', 5),
(45, 'Where is the world largest prison?', 'Pakistan', 'England', 'Russia', 'Isreal', 'Pakistan', 6),
(46, 'Famous sculptures depicting art of love built some time in 950 AD - 1050 AD are?', 'Khajuraho temples', 'Sun temple', 'Mahabalipuram temples', 'Jama Masjid', 'Khajuraho temples', 6),
(47, 'Each year World Red Cross and Red Crescent Day is celebrated on?', 'June 8', 'May 8', 'June 18', 'May 18', 'May 8', 6),
(48, 'For the Olympics and World Tournaments, the dimensions of basketball court are?', '26 m x 14 m', '28 m x 15 m', '27 m x 16 m', '28 m x 16 m', '28 m x 15 m', 6),
(49, 'Gravity setting chambers are used in industries to remove?', 'SOx', 'NOx', 'suspended particulate matter', 'CO', 'suspended particulate matter', 7),
(50, 'Friction can be reduced by changing from?', 'sliding to rolling', 'rolling to sliding', 'potential energy to kinetic energy', 'dynamic energy to static energy', 'sliding to rolling', 7),
(51, 'Fire temple is the place of worship of which of the following religion?', 'Taoism', 'Judaism', 'Zoroastrianism ', 'Shintoism', 'Zoroastrianism ', 7),
(52, 'Durand Cup is associated with the game of?', 'Cricket', 'Football', 'Hockey', 'Volleyball', 'Football', 8),
(53, 'Number of commands of Air Force are?', 'Five', 'Six', 'Seven', 'Eight', 'Seven', 9),
(54, 'Of the following foods, which one is the best source of protein?', 'Butter', 'Fish', 'Lettuce', 'Milk', 'Fish', 9),
(55, 'Mount Everest was captured by Edmund Hillary and Tenzing Norgay in the year?', '1951', '1952', '1953', '1954', '1953', 9),
(56, 'Jesus Christ was crucified in?', '4 BC', '20 AD', '4 AD', '1AD', '20 AD', 9),
(57, 'Mother Teresa received the Magsaysay Award in 1962 in the area of?', 'Community leadership', 'public service', 'journalism and literature', 'international understanding', 'international understanding', 10),
(58, 'Richter scale is used for measuring?', 'density of liquid', 'intensity of earthquakes', 'velocity of wind', 'humidity of air', 'intensity of earthquakes', 11),
(59, 'Sculpture flourished during?', 'Egyptian civilization', 'Indus valley civilization', 'Chinese civilization', 'None of the above', 'Indus valley civilization', 12),
(60, 'Shankracharya was the founder of?', 'Buddhism', 'Jainism', 'Arya Samaj', 'Advaitic philosophy', 'Advaitic philosophy', 12),
(61, 'The 2006 World Cup Football Tournament held in?', 'France', 'China', 'Germany', 'Europe', 'Germany', 11),
(62, 'Philology is the?', 'study of bones', 'study of muscles', 'study of architecture', 'science of language', 'science of language', 10),
(63, 'Numismatics is the study of?', 'coins', 'numbers', 'stamps', 'space', 'coins', 8),
(64, '', '', '', '', '', '', 8),
(65, 'Light Year is related to?', 'energy', 'speed', 'distance', 'intensity', 'distance', 8),
(66, 'Mother Teresa won the Nobel Prize for Peace in?', '1992', '1977', '1988', '1979', '1979', 9),
(67, 'Name the instrument used to measure relative humidity?', 'Hydrometer', 'Hygrometer', 'Barometer', 'Mercury Thermometer', 'Hydrometer', 9);

-- --------------------------------------------------------

--
-- Table structure for table `win_history`
--

CREATE TABLE `win_history` (
  `user_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `prize_won` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `win_history`
--

INSERT INTO `win_history` (`user_id`, `date`, `time`, `prize_won`) VALUES
(1, '2022-11-01', '19:31:23', 30000),
(1, '2022-11-02', '11:38:59', 5000),
(1, '2022-11-02', '11:40:10', 1000),
(1, '2022-11-02', '11:40:31', 1000),
(3, '2022-11-02', '13:28:42', 1000),
(3, '2022-11-02', '13:30:48', 2000),
(1, '2022-11-02', '22:32:13', 1000),
(3, '2022-11-02', '23:01:40', 1000),
(3, '2022-11-02', '23:01:51', 1000),
(1, '2022-11-04', '09:08:05', 0),
(1, '2022-11-04', '09:08:28', 0),
(1, '2022-11-04', '10:26:12', 1000),
(1, '2022-11-04', '10:26:17', 1000),
(1, '2022-11-04', '10:31:29', 1000),
(1, '2022-11-04', '10:31:31', 1000),
(1, '2022-11-04', '10:31:55', 1000),
(1, '2022-11-04', '10:32:07', 0),
(1, '2022-11-04', '10:32:20', 1000),
(1, '2022-11-04', '10:34:42', 0),
(6, '2022-11-04', '10:44:57', 1000),
(6, '2022-11-04', '10:45:03', 1000),
(7, '2022-11-04', '10:49:17', 5000),
(7, '2022-11-04', '10:49:24', 5000),
(1, '2022-11-27', '21:17:04', 0),
(1, '2022-11-27', '21:17:29', 0),
(1, '2022-11-27', '21:30:47', 30000),
(1, '2022-11-27', '21:31:13', 30000),
(1, '2022-11-27', '21:33:13', 0),
(1, '2022-11-27', '21:34:28', 0),
(8, '2022-11-27', '21:36:49', 1000),
(8, '2022-11-27', '21:37:18', 1000),
(10, '2022-11-28', '12:44:30', 1000),
(10, '2022-11-28', '12:46:34', 5000),
(1, '2023-05-28', '20:54:34', 0),
(1, '2023-06-04', '18:31:26', 5000),
(1, '2023-06-04', '18:31:37', 5000),
(1, '2023-06-04', '18:32:20', 0),
(1, '2023-06-04', '18:32:48', 0),
(1, '2023-06-04', '18:34:47', 0),
(1, '2023-06-04', '18:35:15', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_details`
--
ALTER TABLE `login_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `question_list`
--
ALTER TABLE `question_list`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_question` (`question`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login_details`
--
ALTER TABLE `login_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `question_list`
--
ALTER TABLE `question_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
