insert into user_tb(username, password, email, phone, created_at)
values ('ssar', '1234', 'ssar@nate.com','01048086967', now());
insert into user_tb(username, password, email, phone, created_at)
values ('cos', '1234', 'cos@nate.com','01048086967', now());
insert into user_tb(username, password, email, phone, created_at)
values ('love', '1234', 'love@nate.com','01048086967', now());


-- 서면 지역 데이터 삽입
insert into region_tb (city, name)
values ('부산', '서면');

--TODO 주헌  부산 화명에서 서울 화명으로 지역 변경함
-- 사상 지역 데이터 삽입
insert into region_tb (city, name)
values ('서울', '화명');

-- 서면롯데시네마 영화관 데이터 삽입
insert into cinema_tb (img_name, img_uname, name, region_id)
values ('seomyeon_lotte_img.jpg', 'unique_seomyeon_lotte_img.jpg', '서면롯데시네마', 1);

-- 사상롯데시네마 영화관 데이터 삽입
insert into cinema_tb (img_name, img_uname, name, region_id)
values ('sasang_lotte_img.jpg', 'unique_sasang_lotte_img.jpg', '화명cgv', 2);


-- 첫 번째 레코드
insert into admin_tb (username, password, email, phone, name, role, approved, profile_url, created_at, cinema_id)
values ('admin', '1234', 'ssar@nate.com', '01048086967', '강재영', 'ROLE_ADMIN', true, 'http://example.com/profile1.jpg', now(), 1);

-- 두 번째 레코드
insert into admin_tb (username, password, email, phone, name, role, approved, profile_url, created_at, cinema_id)
values ('cos', '1234', 'cos@nate.com', '01048086967', '진선우', 'ROLE_SUPERADMIN', true, 'http://example.com/profile2.jpg', now(), 1);

-- 세 번째 레코드
insert into admin_tb (username, password, email, phone, name, role, approved, profile_url, created_at, cinema_id)
values ('love', '1234', 'love@nate.com', '01048086967', '박관호', 'ROLE_SUPERADMIN', false, 'http://example.com/profile3.jpg', now(), 2);

-- Movie 테이블 더미 데이터 삽입
insert into movie_tb (movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, runtime, rating_grade, vod_url, plot, actor_nm, api_id)
values
    ('Interstellar', '2014', '2014-11-07', 'USA', 'Sci-Fi', 'Christopher Nolan', 'Warner Bros.', 169, '12세', 'https://www.kmdb.or.kr/trailer/trailerPlayPop?pFileNm=MK034919_P02.mp4', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.', 'Matthew McConaughey, Anne Hathaway', 1),
    ('Parasite', '2019', '2019-05-30', 'South Korea', 'Drama', 'Bong Joon Ho', 'Barunson E&A', 132, '15세', 'https://www.kmdb.or.kr/trailer/trailerPlayPop?pFileNm=MK041673_P02.mp4', 'Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.', 'Song Kang-ho, Lee Sun-kyun', 2),
    ('The Godfather', '1972', '1972-03-24', 'USA', 'Crime, Drama', 'Francis Ford Coppola', 'Paramount Pictures', 175, '15세', 'https://www.kmdb.or.kr/trailer/trailerPlayPop?pFileNm=MK013841_P03.mp4', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', 'Marlon Brando, Al Pacino', 3),
    ('Your Name', '2016', '2016-08-26', 'Japan', 'Animation, Fantasy, Romance', 'Makoto Shinkai', 'CoMix Wave Films', 112, '12세', 'https://www.kmdb.or.kr/trailer/trailerPlayPop?pFileNm=MK039884_P02.mp4', 'Two teenagers share a profound, magical connection upon discovering they are swapping bodies.', 'Ryunosuke Kamiki, Mone Kamishiraishi', 4),
    ('Spirited Away', '2001', '2001-07-20', 'Japan', 'Animation, Fantasy, Adventure', 'Hayao Miyazaki', 'Studio Ghibli', 125, 'All ages', 'https://www.kmdb.or.kr/trailer/trailerPlayPop?pFileNm=MK035672_P02.mp4', 'A young girl, Chihiro, becomes trapped in a mysterious and magical world of spirits, where she must work to free herself and her parents.', 'Rumi Hiiragi, Miyu Irino', 5);
-- Poster 테이블 더미 데이터 삽입 (Interstellar)
insert into poster_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20160106_138%2F1452044846608eaFcJ_JPEG%2Fmovie_image.jpg', 1),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20141021_288%2F1413854090045j0hQc_JPEG%2Fmovie_image.jpg', 1);

-- Poster 테이블 더미 데이터 삽입 (Parasite)
insert into poster_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20190528_36%2F1559024198386YVTEw_JPEG%2Fmovie_image.jpg', 2),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20200410_33%2F1586494001691vo2PO_JPEG%2Fmovie_image.jpg', 2);

-- Poster 테이블 더미 데이터 삽입 (The Godfather)
insert into poster_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111223_163%2F1324611357189Ya5O8_JPEG%2Fmovie_image.jpg', 3),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111223_269%2F1324582401120Q33qS_JPEG%2Fmovie_image.jpg', 3);

-- Poster 테이블 더미 데이터 삽입 (Your Name)
insert into poster_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230524_201%2F1684917828928p65nt_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20170620_81%2F1497939374352LH9Xa_JPEG%2Fmovie_image.jpg', 4);

-- Poster 테이블 더미 데이터 삽입 (Spirited Away)
insert into poster_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150113_96%2F1421113909808LPjqA_JPEG%2Fmovie_image.jpg',5),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150113_266%2F1421113938504xOjYq_JPEG%2Fmovie_image.jpg',5);

-- Still 테이블 더미 데이터 삽입 (Interstellar)
insert into still_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150204_283%2F14230153651826EYoJ_JPEG%2Fmovie_image.jpg', 1),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150203_267%2F1422954366520nmAor_JPEG%2Fmovie_image.jpg', 1),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150204_51%2F1423015363351nIvQ4_JPEG%2Fmovie_image.jpg', 1),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150204_275%2F1423015367745pwiAb_JPEG%2Fmovie_image.jpg', 1),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150204_97%2F1423015366568mzR16_JPEG%2Fmovie_image.jpg', 1),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150204_126%2F1423015368442m5fOF_JPEG%2Fmovie_image.jpg', 1),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150204_214%2F1423015367349YxGqW_JPEG%2Fmovie_image.jpg', 1),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150204_44%2F142301579295076zG3_JPEG%2Fmovie_image.jpg', 1),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20150204_56%2F1423015363999d8EK7_JPEG%2Fmovie_image.jpg', 1);

-- Still 테이블 더미 데이터 삽입 (Parasite)
insert into still_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20200427_116%2F1587951298610WREtR_JPEG%2Fmovie_image.jpg', 2),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20200427_251%2F15879512990528CvpS_JPEG%2Fmovie_image.jpg', 2),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20200427_225%2F1587951299446FvkdV_JPEG%2Fmovie_image.jpg', 2),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20200427_7%2F1587951299905j8Wyx_JPEG%2Fmovie_image.jpg', 2);

-- Still 테이블 더미 데이터 삽입 (The Godfather)
insert into still_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111223_298%2F1324645909661hw8J4_JPEG%2Fmovie_image.jpg', 3),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111223_113%2F1324582410336lRMRL_JPEG%2Fmovie_image.jpg', 3),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111223_21%2F1324582410875wAQHa_JPEG%2Fmovie_image.jpg', 3),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111223_204%2F1324582409152rmik5_JPEG%2Fmovie_image.jpg', 3);

-- Still 테이블 더미 데이터 삽입 (Your Name)
insert into still_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20160927_20%2F1474960029918woJpk_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20160927_265%2F1474960030088VIdg2_PNG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20160927_195%2F1474960030235ot3Ih_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20161116_187%2F14792642146572PCVC_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20161116_232%2F1479264214874iLNKP_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20161116_81%2F1479264215287Tkk8P_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20161116_207%2F1479264215441xOsgI_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20161116_195%2F1479264215670Ex42O_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20161116_195%2F1479264215785bBBTb_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20161116_261%2F14792642158745JCMF_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20161116_111%2F1479264216118Mv9I5_JPEG%2Fmovie_image.jpg', 4),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20161116_30%2F1479264215047b4Krx_JPEG%2Fmovie_image.jpg', 4);

-- Still 테이블 더미 데이터 삽입 (Spirited Away)
insert into still_tb (url, movie_id)
values
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111222_145%2F1324523433350bNmTE_JPEG%2Fmovie_image.jpg',5),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111222_17%2F13245234339840F3gF_JPEG%2Fmovie_image.jpg',5),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111222_155%2F13245234346808tFEi_JPEG%2Fmovie_image.jpg',5),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111222_129%2F1324523436039IWIAr_JPEG%2Fmovie_image.jpg',5),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111222_12%2F1324523436632RMEX7_JPEG%2Fmovie_image.jpg',5),
    ('https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20111222_75%2F13245234372948Ym2G_JPEG%2Fmovie_image.jpg',5);

-- 서면롯데시네마 상영관 더미 데이터 삽입
insert into screen_tb (cinema_id, name)
values (1, '서면1상영관');

insert into screen_tb (cinema_id, name)
values (1, '서면2상영관');

insert into screen_tb (cinema_id, name)
values (1, '서면3상영관');

insert into screen_tb (cinema_id, name)
values (1, '서면4상영관');


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
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (1, 1, '2024-09-12 14:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (1, 1, '2024-09-12 16:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (1, 1, '2024-09-12 18:00:00', 10);

insert into showtime_tb (movie_id, screen_id, started_at, price)
values (1, 1, '2024-09-11 23:30:00', 10);



--TODO 주헌 DB추가
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (1, 1, '2024-09-23 14:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (1, 1, '2024-09-24 16:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (1, 1, '2024-09-25 18:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (1, 1, '2024-09-26 14:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (1, 1, '2024-09-27 16:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (2, 2, '2024-09-23 14:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (2, 3, '2024-09-24 16:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (2, 1, '2024-09-25 20:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (2, 1, '2024-09-26 18:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (2, 1, '2024-09-27 18:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (2, 6, '2024-09-28 16:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (3, 7, '2024-09-28 19:00:00', 10);





<<<<<<< HEAD


-- 호정 seat_tb 데이터 추가 ( 9월 25일 ~ 28일 상영시간에 대한 좌석 )
=======
>>>>>>> c0f0391 (1번째 ì¶충돌해결)
insert into seat_tb (showtime_id, seat_number, row_num, col_num)
values
    (8, 'A1', 'A', '1'), (8, 'A2', 'A', '2'), (8, 'A3', 'A', '3'), (8, 'A4', 'A', '4'), (8, 'A5', 'A', '5'),
    (8, 'A6', 'A', '6'), (8, 'A7', 'A', '7'), (8, 'A8', 'A', '8'), (8, 'A9', 'A', '9'),
    (8, 'B1', 'B', '1'), (8, 'B2', 'B', '2'), (8, 'B3', 'B', '3'), (8, 'B4', 'B', '4'), (8, 'B5', 'B', '5'),
    (8, 'B6', 'B', '6'), (8, 'B7', 'B', '7'), (8, 'B8', 'B', '8'), (8, 'B9', 'B', '9'),
    (8, 'C1', 'C', '1'), (8, 'C2', 'C', '2'), (8, 'C3', 'C', '3'), (8, 'C4', 'C', '4'), (8, 'C5', 'C', '5'),
    (8, 'C6', 'C', '6'), (8, 'C7', 'C', '7'), (8, 'C8', 'C', '8'), (8, 'C9', 'C', '9'),
    (8, 'D1', 'D', '1'), (8, 'D2', 'D', '2'), (8, 'D3', 'D', '3'), (8, 'D4', 'D', '4'), (8, 'D5', 'D', '5'),
    (8, 'D6', 'D', '6'), (8, 'D7', 'D', '7'), (8, 'D8', 'D', '8'), (8, 'D9', 'D', '9'),
    (8, 'E1', 'E', '1'), (8, 'E2', 'E', '2'), (8, 'E3', 'E', '3'), (8, 'E4', 'E', '4'), (8, 'E5', 'E', '5'),
    (8, 'E6', 'E', '6'), (8, 'E7', 'E', '7'), (8, 'E8', 'E', '8'), (8, 'E9', 'E', '9'),
    (8, 'F1', 'F', '1'), (8, 'F2', 'F', '2'), (8, 'F3', 'F', '3'), (8, 'F4', 'F', '4'), (8, 'F5', 'F', '5'),
    (8, 'F6', 'F', '6'), (8, 'F7', 'F', '7'), (8, 'F8', 'F', '8'), (8, 'F9', 'F', '9'),
    (8, 'G1', 'G', '1'), (8, 'G2', 'G', '2'), (8, 'G3', 'G', '3'), (8, 'G4', 'G', '4'), (8, 'G5', 'G', '5'),
    (8, 'G6', 'G', '6'), (8, 'G7', 'G', '7'), (8, 'G8', 'G', '8'), (8, 'G9', 'G', '9'),
    (8, 'H1', 'H', '1'), (8, 'H2', 'H', '2'), (8, 'H3', 'H', '3'), (8, 'H4', 'H', '4'), (8, 'H5', 'H', '5'),
    (8, 'H6', 'H', '6'), (8, 'H7', 'H', '7'), (8, 'H8', 'H', '8'), (8, 'H9', 'H', '9'),
    (8, 'I1', 'I', '1'), (8, 'I2', 'I', '2'), (8, 'I3', 'I', '3'), (8, 'I4', 'I', '4'), (8, 'I5', 'I', '5'),
    (8, 'I6', 'I', '6'), (8, 'I7', 'I', '7'), (8, 'I8', 'I', '8'), (8, 'I9', 'I', '9'),
    (8, 'J1', 'J', '1'), (8, 'J2', 'J', '2'), (8, 'J3', 'J', '3'), (8, 'J4', 'J', '4'), (8, 'J5', 'J', '5'),
    (8, 'J6', 'J', '6'), (8, 'J7', 'J', '7'), (8, 'J8', 'J', '8'), (8, 'J9', 'J', '9');





<<<<<<< HEAD


=======
>>>>>>> c0f0391 (1번째 ì¶충돌해결)
-- 1번 영화 (movie_id = 1), 서면롯데시네마 Screen 2에서 상영
insert into showtime_tb (movie_id, screen_id, started_at , price)
values (2, 1, '2024-09-12 20:00:00', 10);
insert into showtime_tb (movie_id, screen_id, started_at , price)
values (2, 1, '2024-09-12 22:00:00', 10);


-- 2번 영화 (movie_id = 2), 사상롯데시네마 Screen 1에서 상영
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (2, 3, '2024-09-12 15:30:00', 10);

-- 2번 영화 (movie_id = 2), 사상롯데시네마 Screen 2에서 상영
insert into showtime_tb (movie_id, screen_id, started_at, price)
values (2, 4, '2024-09-12 20:00:00', 10);

-- 서면롯데시네마 Screen 1 좌석 더미 데이터 삽입
insert into seat_tb (showtime_id, seat_number, row_num, col_num)
values (1, 'A1', 'A', '2'), (1, 'A3', 'A', '3'), (1, 'A4', 'A', '4'), (1, 'A5', 'A', '5');

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



insert into seat_tb (showtime_id, seat_number, row_num, col_num)
select 7, seat_number, row_num, col_num from seat_tb where showtime_id = 8;

insert into seat_tb (showtime_id, seat_number, row_num, col_num)
select 9, seat_number, row_num, col_num from seat_tb where showtime_id = 8;

insert into seat_tb (showtime_id, seat_number, row_num, col_num)
select 12, seat_number, row_num, col_num from seat_tb where showtime_id = 8;

insert into seat_tb (showtime_id, seat_number, row_num, col_num)
select 13, seat_number, row_num, col_num from seat_tb where showtime_id = 8;

insert into seat_tb (showtime_id, seat_number, row_num, col_num)
select 14, seat_number, row_num, col_num from seat_tb where showtime_id = 8;

insert into seat_tb (showtime_id, seat_number, row_num, col_num)
select 15, seat_number, row_num, col_num from seat_tb where showtime_id = 8;

insert into seat_tb (showtime_id, seat_number, row_num, col_num)
select 16, seat_number, row_num, col_num from seat_tb where showtime_id = 8;





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

-- -- ssar 사용자의 결제 (결제 완료 상태, 신용카드 사용)
-- insert into payment_tb (type, price, pay_date, cncl_date, mycoupon, point, state, imp_uid, reservation_id)
-- values ('신용카드', 15000.00, '2024-09-10 14:00:00', null, 'WELCOME10', 500, 1, 'imp_1234567890', 1);
--
-- -- cos 사용자의 결제 (결제 완료 상태, 카카오페이 사용)
-- insert into payment_tb (type, price, pay_date, cncl_date, mycoupon, point, state, imp_uid, reservation_id)
-- values ('카카오페이', 18000.00, '2024-09-10 15:00:00', null, 'DISCOUNT20', 1000, 1, 'imp_0987654321', 2);
--
-- -- love 사용자의 결제 (결제 취소 상태, 신용카드 사용)
-- insert into payment_tb (type, price, pay_date, cncl_date, mycoupon, point, state, imp_uid, reservation_id)
-- values ('신용카드', 20000.00, '2024-09-09 13:00:00', '2024-09-09 16:00:00', 'WELCOME10', 0, 2, 'imp_1122334455', 3);

-- 1. 사용자 ssar가 올린 QnA, 관리자가 답변한 경우
insert into qna_tb (type, title, content, created_at, state, answered_at, admin_id, user_id)
values ('문의', '로그인 문제가 있습니다', '로그인 시도 시 오류 메시지가 나옵니다.', '2024-09-10 12:00:00', true, '2024-09-10 14:00:00', 1, 1);

-- 2. 사용자 cos가 올린 QnA, 관리자가 아직 답변하지 않은 경우
insert into qna_tb (type, title, content, created_at, state, answered_at, admin_id, user_id)
values ('버그 리포트', '결제 오류 발생', '결제 중 카드 오류가 발생했습니다.', '2024-09-11 09:30:00', false, null, null, 2);

-- 3. 사용자 love가 올린 QnA, 관리자가 답변한 경우
insert into qna_tb (type, title, content, created_at, state, answered_at, admin_id, user_id)
values ('기타', '영화 추천 부탁드립니다', '어떤 영화를 추천하시겠어요?', '2024-09-12 15:20:00', true, '2024-09-12 17:00:00', 1, 3);

-- Movie 1에 대한 댓글
INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ('정말 감동적인 영화였어요!', CURRENT_TIMESTAMP, 1, 1);

INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ('영상미가 아주 훌륭합니다.', CURRENT_TIMESTAMP, 1, 2);

-- Movie 2에 대한 댓글
INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ('스토리가 조금 지루했어요.', CURRENT_TIMESTAMP, 2, 3);

INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ('재미있게 봤습니다.', CURRENT_TIMESTAMP, 2, 1);

-- Movie 3에 대한 댓글
INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ('캐릭터가 매력적이에요.', CURRENT_TIMESTAMP, 3, 2);

INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ('사운드트랙이 인상 깊었어요.', CURRENT_TIMESTAMP, 3, 3);

-- Movie 4에 대한 댓글
INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ('연출이 훌륭했습니다.', CURRENT_TIMESTAMP, 4, 1);

INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ('기대했던 것보다 더 좋았어요.', CURRENT_TIMESTAMP, 4, 2);

-- Movie 5에 대한 댓글
INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ( '스토리가 복잡했어요.', CURRENT_TIMESTAMP, 5, 3);

INSERT INTO comment_tb (content, created_at, movie_id, user_id)
VALUES ('다시 보고 싶어요!', CURRENT_TIMESTAMP, 5, 1);