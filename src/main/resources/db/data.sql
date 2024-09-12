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
values ('부산', '화명');

-- 서면롯데시네마 영화관 데이터 삽입
insert into cinema_tb (img_name, img_uname, name, region_id)
values ('seomyeon_lotte_img.jpg', 'unique_seomyeon_lotte_img.jpg', '서면롯데시네마', 1);

-- 사상롯데시네마 영화관 데이터 삽입
insert into cinema_tb (img_name, img_uname, name, region_id)
values ('sasang_lotte_img.jpg', 'unique_sasang_lotte_img.jpg', '화명cgv', 2);


-- 첫 번째 레코드
insert into admin_tb (username, password, email, phone, name, role, approved, profile_url, created_at, cinema_id)
values ('ssar', '1234', 'ssar@nate.com', '01048086967', '강재영', 'ROLE_ADMIN', true, 'http://example.com/profile1.jpg', now(), 1);

-- 두 번째 레코드
insert into admin_tb (username, password, email, phone, name, role, approved, profile_url, created_at, cinema_id)
values ('cos', '1234', 'cos@nate.com', '01048086967', '진선우', 'ROLE_SUPERADMIN', true, 'http://example.com/profile2.jpg', now(), 1);

-- 세 번째 레코드
insert into admin_tb (username, password, email, phone, name, role, approved, profile_url, created_at, cinema_id)
values ('love', '1234', 'love@nate.com', '01048086967', '박관호', 'ROLE_SUPERADMIN', false, 'http://example.com/profile3.jpg', now(), 2);

-- Movie 테이블 더미 데이터 삽입
insert into movie_tb (movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, runtime, rating_grade, vod_url, plot, actor_nm, api_id)
values
    ('Interstellar', '2014', '2014-11-07', 'USA', 'Sci-Fi', 'Christopher Nolan', 'Warner Bros.', 169, '12세', 'https://example.com/interstellar_vod', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.', 'Matthew McConaughey, Anne Hathaway', 1),
    ('Parasite', '2019', '2019-05-30', 'South Korea', 'Drama', 'Bong Joon Ho', 'Barunson E&A', 132, '15세', 'https://example.com/parasite_vod', 'Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.', 'Song Kang-ho, Lee Sun-kyun', 2),
    ('The Godfather', '1972', '1972-03-24', 'USA', 'Crime, Drama', 'Francis Ford Coppola', 'Paramount Pictures', 175, '15세', 'https://example.com/godfather_vod', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 'Marlon Brando, Al Pacino', 3),
    ('Your Name', '2016', '2016-08-26', 'Japan', 'Animation, Fantasy, Romance', 'Makoto Shinkai', 'CoMix Wave Films', 112, '12세', 'https://example.com/yourname_vod', 'Two teenagers share a profound, magical connection upon discovering they are swapping bodies.', 'Ryunosuke Kamiki, Mone Kamishiraishi', 4);

-- Poster 테이블 더미 데이터 삽입 (Interstellar)
insert into poster_tb (url, movie_id)
values
    ('https://example.com/posters/interstellar_1.jpg', 1),
    ('https://example.com/posters/interstellar_2.jpg', 1);

-- Poster 테이블 더미 데이터 삽입 (Parasite)
insert into poster_tb (url, movie_id)
values
    ('https://example.com/posters/parasite_1.jpg', 2),
    ('https://example.com/posters/parasite_2.jpg', 2);

-- Poster 테이블 더미 데이터 삽입 (The Godfather)
insert into poster_tb (url, movie_id)
values
    ('https://example.com/posters/godfather_1.jpg', 3),
    ('https://example.com/posters/godfather_2.jpg', 3);

-- Poster 테이블 더미 데이터 삽입 (Your Name)
insert into poster_tb (url, movie_id)
values
    ('https://example.com/posters/yourname_1.jpg', 4),
    ('https://example.com/posters/yourname_2.jpg', 4);


-- Still 테이블 더미 데이터 삽입 (Interstellar)
insert into still_tb (url, movie_id)
values
    ('https://example.com/stills/interstellar_1.jpg', 1),
    ('https://example.com/stills/interstellar_2.jpg', 1);

-- Still 테이블 더미 데이터 삽입 (Parasite)
insert into still_tb (url, movie_id)
values
    ('https://example.com/stills/parasite_1.jpg', 2),
    ('https://example.com/stills/parasite_2.jpg', 2);

-- Still 테이블 더미 데이터 삽입 (The Godfather)
insert into still_tb (url, movie_id)
values
    ('https://example.com/stills/godfather_1.jpg', 3),
    ('https://example.com/stills/godfather_2.jpg', 3);

-- Still 테이블 더미 데이터 삽입 (Your Name)
insert into still_tb (url, movie_id)
values
    ('https://example.com/stills/yourname_1.jpg', 4),
    ('https://example.com/stills/yourname_2.jpg', 4);
-- 서면롯데시네마 상영관 더미 데이터 삽입
insert into screen_tb (cinema_id, name)
values (1, '서면1상영관');

insert into screen_tb (cinema_id, name)
values (1, '서면2상영관');

insert into screen_tb (cinema_id, name)
values (1, '서면3상영관');

insert into screen_tb (cinema_id, name)
values (2, '화명1상영관');
insert into screen_tb (cinema_id, name)
values (2, '화명2상영관');






-- 사상롯데시네마 상영관 더미 데이터 삽입
insert into screen_tb (cinema_id, name)
values (2, '1상영관');

insert into screen_tb (cinema_id, name)
values (2, '2상영관');

-- 1번 영화 (movie_id = 1), 서면롯데시네마 Screen 1에서 상영
insert into showtime_tb (movie_id, screen_id, started_at)
values (1, 1, '2024-09-12 14:00:00');
insert into showtime_tb (movie_id, screen_id, started_at)
values (1, 1, '2024-09-12 16:00:00');
insert into showtime_tb (movie_id, screen_id, started_at)
values (1, 1, '2024-09-12 18:00:00');

-- 1번 영화 (movie_id = 1), 서면롯데시네마 Screen 2에서 상영
insert into showtime_tb (movie_id, screen_id, started_at)
values (1, 2, '2024-09-12 17:00:00');


-- 2번 영화 (movie_id = 2), 사상롯데시네마 Screen 1에서 상영
insert into showtime_tb (movie_id, screen_id, started_at)
values (2, 3, '2024-09-12 15:30:00');

-- 2번 영화 (movie_id = 2), 사상롯데시네마 Screen 2에서 상영
insert into showtime_tb (movie_id, screen_id, started_at)
values (2, 4, '2024-09-12 20:00:00');

-- 서면롯데시네마 Screen 1 좌석 더미 데이터 삽입
insert into seat_tb (showtime_id, seat_number, row_num, col_num)
values (1, 'A1', 'A', '1'), (1, 'A2', 'A', '2'), (1, 'A3', 'A', '3'), (1, 'A4', 'A', '4'), (1, 'A5', 'A', '5');

insert into seat_tb (showtime_id, seat_number, row_num, col_num)
values (1, 'B1', 'B', '1'), (1, 'B2', 'B', '2'), (1, 'B3', 'B', '3'), (1, 'B4', 'B', '4'), (1, 'B5', 'B', '5');

-- 서면롯데시네마 Screen 2 좌석 더미 데이터 삽입
insert into seat_tb (showtime_id, seat_number, row_num, col_num)
values (2, 'A1', 'A', '1'), (2, 'A2', 'A', '2'), (2, 'A3', 'A', '3'), (2, 'A4', 'A', '4'), (2, 'A5', 'A', '5');

insert into seat_tb (showtime_id, seat_number, row_num, col_num)
values (2, 'B1', 'B', '1'), (2, 'B2', 'B', '2'), (2, 'B3', 'B', '3'), (2, 'B4', 'B', '4'), (2, 'B5', 'B', '5');

-- 사상롯데시네마 Screen 1 좌석 더미 데이터 삽입
insert into seat_tb (showtime_id, seat_number, row_num, col_num)
values (3, 'A1', 'A', '1'), (3, 'A2', 'A', '2'), (3, 'A3', 'A', '3'), (3, 'A4', 'A', '4'), (3, 'A5', 'A', '5');

insert into seat_tb (showtime_id, seat_number, row_num, col_num)
values (3, 'B1', 'B', '1'), (3, 'B2', 'B', '2'), (3, 'B3', 'B', '3'), (3, 'B4', 'B', '4'), (3, 'B5', 'B', '5');

-- ssar 사용자의 좌석 예약
insert into reservation_tb ( user_id, created_at)
values ( 1, now());

-- cos 사용자의 좌석 예약
insert into reservation_tb ( user_id, created_at)
values ( 2, now());

-- love 사용자의 좌석 예약
insert into reservation_tb ( user_id, created_at)
values ( 3, now());

-- ssar 사용자의 티켓 (1번 좌석, 1번 상영시간, 1번 예약)
insert into ticket_tb (seat_id, showtime_id, reservation_id, created_at)
values (1, 1, 1, now());

-- cos 사용자의 티켓 (2번 좌석, 2번 상영시간, 2번 예약)
insert into ticket_tb (seat_id, showtime_id, reservation_id, created_at)
values (2, 2, 2, now());

-- love 사용자의 티켓 (3번 좌석, 3번 상영시간, 3번 예약)
insert into ticket_tb (seat_id, showtime_id, reservation_id, created_at)
values (3, 3, 3, now());

-- ssar 사용자의 또 다른 티켓 (4번 좌석, 4번 상영시간, 1번 예약)
insert into ticket_tb (seat_id, showtime_id, reservation_id, created_at)
values (4, 1, 1, now());

-- ssar 사용자의 결제 (결제 완료 상태, 신용카드 사용)
insert into payment_tb (type, price, pay_date, cncl_date, mycoupon, point, state, imp_uid, reservation_id)
values ('신용카드', 15000.00, '2024-09-10 14:00:00', null, 'WELCOME10', 500, 1, 'imp_1234567890', 1);

-- cos 사용자의 결제 (결제 완료 상태, 카카오페이 사용)
insert into payment_tb (type, price, pay_date, cncl_date, mycoupon, point, state, imp_uid, reservation_id)
values ('카카오페이', 18000.00, '2024-09-10 15:00:00', null, 'DISCOUNT20', 1000, 1, 'imp_0987654321', 2);

-- love 사용자의 결제 (결제 취소 상태, 신용카드 사용)
insert into payment_tb (type, price, pay_date, cncl_date, mycoupon, point, state, imp_uid, reservation_id)
values ('신용카드', 20000.00, '2024-09-09 13:00:00', '2024-09-09 16:00:00', 'WELCOME10', 0, 2, 'imp_1122334455', 3);

-- 1. 사용자 ssar가 올린 QnA, 관리자가 답변한 경우
insert into qna_tb (type, title, content, created_at, state, answered_at, admin_id, user_id)
values ('문의', '로그인 문제가 있습니다', '로그인 시도 시 오류 메시지가 나옵니다.', '2024-09-10 12:00:00', true, '2024-09-10 14:00:00', 1, 1);

-- 2. 사용자 cos가 올린 QnA, 관리자가 아직 답변하지 않은 경우
insert into qna_tb (type, title, content, created_at, state, answered_at, admin_id, user_id)
values ('버그 리포트', '결제 오류 발생', '결제 중 카드 오류가 발생했습니다.', '2024-09-11 09:30:00', false, null, null, 2);

-- 3. 사용자 love가 올린 QnA, 관리자가 답변한 경우
insert into qna_tb (type, title, content, created_at, state, answered_at, admin_id, user_id)
values ('기타', '영화 추천 부탁드립니다', '어떤 영화를 추천하시겠어요?', '2024-09-12 15:20:00', true, '2024-09-12 17:00:00', 1, 3);