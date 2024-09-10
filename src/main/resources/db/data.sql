insert into user_tb(username, password, email, phone, created_at)
values ('ssar', '1234', 'ssar@nate.com','01048086967', now());
insert into user_tb(username, password, email, phone, created_at)
values ('cos', '1234', 'cos@nate.com','01048086967', now());
insert into user_tb(username, password, email, phone, created_at)
values ('love', '1234', 'love@nate.com','01048086967', now());

-- 서면 지역 데이터 삽입
insert into region_tb (city, name)
values ('부산', '서면');

-- 사상 지역 데이터 삽입
insert into region_tb (city, name)
values ('부산', '사상');

-- 서면롯데시네마 영화관 데이터 삽입
insert into cinema_tb (img_name, img_uname, name, region_id)
values ('seomyeon_lotte_img.jpg', 'unique_seomyeon_lotte_img.jpg', '서면롯데시네마', 1);

-- 사상롯데시네마 영화관 데이터 삽입
insert into cinema_tb (img_name, img_uname, name, region_id)
values ('sasang_lotte_img.jpg', 'unique_sasang_lotte_img.jpg', '사상롯데시네마', 2);


-- 관리자 더미 데이터 삽입 예시
insert into admin_tb (username, password, email, phone, role, created_at, cinema_id)
values ('ssar', '1234', 'ssar@nate.com', '01048086967', 'ROLE_ADMIN', now(), 1);

insert into admin_tb (username, password, email, phone, role, created_at, cinema_id)
values ('cos', '1234', 'cos@nate.com', '01048086967', 'ROLE_ADMIN', now(), 1);

insert into admin_tb (username, password, email, phone, role, created_at, cinema_id)
values ('love', '1234', 'love@nate.com', '01048086967', 'ROLE_SUPERADMIN', now(), 2);
