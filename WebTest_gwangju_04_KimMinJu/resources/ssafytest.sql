create database if not exists `ssafytest`;
use `ssafytest`;

drop table if exists`cars`;

create table `cars` (
  `number` varchar(20) primary key not null,
  `model` varchar(20) not null,
  `price` int not null,
  `brand` varchar(20) not null,
  `size` varchar(10) default '소형'
);
insert into `cars` values
('ABC-1234','A6',70000000,'아우디', '대형'),
('XYZ-5678','코롤라',36000000,'토요타', '소형'),
('DEF-9012','머스탱',60000000,'포드', '소형'),
('GHI-3456','쏘나타',31000000,'현대', '중형'),
('JKL-7890','쏘렌토',35000000,'기아', '대형');

drop table if exists `members`;

create table `members` (
  `id` varchar(20) primary key not null,
  `password` varchar(20) not null,
  `name` varchar(30)
);

insert into `members` values
('admin','1234','관리자'),
('ssafy','1234','싸피');

commit;