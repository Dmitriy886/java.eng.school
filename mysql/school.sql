-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Хост: localhost:3306
-- Время создания: Июн 09 2021 г., 22:52
-- Версия сервера: 5.7.24
-- Версия PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `school`
--

-- --------------------------------------------------------

--
-- Структура таблицы `teaching_program`
--

CREATE TABLE `teaching_program` (
  `id` bigint(20) NOT NULL,
  `complexity` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `hours` int(11) NOT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `teachings` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `teaching_program`
--

INSERT INTO `teaching_program` (`id`, `complexity`, `description`, `hours`, `thumbnail`, `title`, `teachings`) VALUES
(1, 0, 'Расширенный курс по изучению французского языка', 60, 'https://images.pexels.com/photos/4983083/pexels-photo-4983083.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Французский расширенный', 60),
(2, 0, 'Базовый курс по изучению японского языка', 40, 'https://images.pexels.com/photos/932261/pexels-photo-932261.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Японский ', 30),
(3, 0, 'Базовый курс по изучению английского языка', 25, 'https://images.pexels.com/photos/267669/pexels-photo-267669.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Английский ', 20),
(4, 0, 'Базовый курс по изучению французского языка', 40, 'https://images.pexels.com/photos/3326355/pexels-photo-3326355.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Французский', 20),
(5, 0, 'Расширенный курс по изучению японского языка', 70, 'https://images.pexels.com/photos/161401/fushimi-inari-taisha-shrine-kyoto-japan-temple-161401.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Японский расширенный', 64),
(6, 0, 'Расширенный курс по изучению английского языка', 30, 'https://images.pexels.com/photos/5676740/pexels-photo-5676740.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Английский расширенный', 60),
(7, 0, 'Расширенный курс по изучению русского языка', 50, 'https://images.pexels.com/photos/5487551/pexels-photo-5487551.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Русский расширенный', 47),
(8, 0, 'Базовый курс по изучению русского языка', 40, 'https://images.pexels.com/photos/1445230/pexels-photo-1445230.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260', 'Русский', 35);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `days` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `hours` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `plan` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `second_name` varchar(255) DEFAULT NULL,
  `subscription_end` varchar(255) DEFAULT NULL,
  `subscription_start` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `visits` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`user_id`, `age`, `avatar_url`, `days`, `enabled`, `first_name`, `height`, `hours`, `password`, `plan`, `price`, `role`, `second_name`, `subscription_end`, `subscription_start`, `username`, `visits`, `weight`) VALUES
(1, '0', 'https://i.imgur.com/4DINNqs.png', '0', b'1', 'Admin', '0', '0', '$2a$10$1yT08KxX6ptU68u.8/v1Q.OIze6DzTu4sgZcjygBRRv2t/GvX0gyC', '...', '0', 'ROLE_ADMIN', 'Admin', '23.05.2021', '23.05.2021', 'admin', '0', '0'),
(3, '30', 'https://i.imgur.com/3Ksd4OR.png', '180', b'1', 'Андрей', '181', '71', '$2a$10$dJrGXi/mKFUNvJCFediDOOCoNRGiQ9y1XgE3sg23aaav4vuIE12D6', 'VIP', '17820 руб', 'ROLE_USER', 'Андреев', '16.11.2021', '20.05.2021', 'andrey', '63', '80'),
(4, '22', 'https://i.imgur.com/AzEe4qP.png', '30', b'1', 'Иван', '177', '112', '$2a$10$8nM46tCz1e5HFJHCmr8S3eIYh4Ij311mjJMypEcTAzuZPrAmvf15C', '...', '2970 руб', 'ROLE_USER', 'Иванов', '22.06.2021', '23.05.2021', 'ivan', '34', '76'),
(5, '0', 'https://i.imgur.com/ECsO4cY.png', '0', b'1', 'Антон', '0', '0', '$2a$10$AtkwtgD2WwCYnIKUSU9rg.LxsdjV98c1U4tWsPaQvdIXbZJqRdfJC', '...', '0', 'ROLE_USER', 'Антонов', '23.05.2021', '23.05.2021', 'user', '0', '0'),
(6, '0', 'https://i.imgur.com/4DINNqs.png', '0', b'1', 'Олег', '0', '0', '$2a$10$jdoqpnBJuXGzn8j4eGk8eOYsOeoe3NpwhTy/gmyDXW5V2vcfLQL5.', '...', '0', 'ROLE_USER', 'Олегов', '10.06.2021', '10.06.2021', '123', '0', '0');

-- --------------------------------------------------------

--
-- Структура таблицы `users_teaching_programs`
--

CREATE TABLE `users_teaching_programs` (
  `users_user_id` bigint(20) NOT NULL,
  `teaching_programs_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users_teaching_programs`
--

INSERT INTO `users_teaching_programs` (`users_user_id`, `teaching_programs_id`) VALUES
(4, 2),
(4, 3),
(4, 6);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `teaching_program`
--
ALTER TABLE `teaching_program`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Индексы таблицы `users_teaching_programs`
--
ALTER TABLE `users_teaching_programs`
  ADD PRIMARY KEY (`users_user_id`,`teaching_programs_id`),
  ADD KEY `FKh2i7j8ugk4in29j9k3230xlo0` (`teaching_programs_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `teaching_program`
--
ALTER TABLE `teaching_program`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `users_teaching_programs`
--
ALTER TABLE `users_teaching_programs`
  ADD CONSTRAINT `FKh2i7j8ugk4in29j9k3230xlo0` FOREIGN KEY (`teaching_programs_id`) REFERENCES `teaching_program` (`id`),
  ADD CONSTRAINT `FKpdwqilnm0d0goh6twib63c8fj` FOREIGN KEY (`users_user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
