insert into user_tb(username, password, email, phone, created_at)
values ('ssar', '1234', 'ssar@nate.com','01048086967', now());
insert into user_tb(username, password, email, phone, created_at)
values ('cos', '1234', 'cos@nate.com','01048086967', now());
insert into user_tb(username, password, email, phone, created_at)
values ('love', '1234', 'love@nate.com','01048086967', now());

insert into region_tb(city, name)
values ('부산', '서면점');

insert into region_tb(city, name)
values ('서울', '여의도점');

insert into region_tb(city, name)
values ('서울', '강남점');

insert into region_tb(city, name)
values ('서울', '홍대점');

insert into region_tb(city, name)
values ('서울', '잠실점');

insert into region_tb(city, name)
values ('부산', '해운대점');

insert into region_tb(city, name)
values ('부산', '광안리점');

insert into region_tb(city, name)
values ('대구', '동성로점');

insert into region_tb(city, name)
values ('대전', '유성점');

insert into region_tb(city, name)
values ('인천', '송도점');

insert into region_tb(city, name)
values ('광주', '상무점');

insert into region_tb(city, name)
values ('수원', '인계점');
insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('서울 강남대로 123', 'cinema1.jpg', 'cinema1_unique.jpg', '강남 필톡 시네마', '01012345678', now(), now(), 1);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('서울 홍대입구 45', 'cinema2.jpg', 'cinema2_unique.jpg', '홍대 필톡 시네마', '01023456789', now(), now(), 2);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('서울 잠실로 101', 'cinema3.jpg', 'cinema3_unique.jpg', '잠실 필톡 시네마', '01034567890', now(), now(), 3);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('부산 해운대로 456', 'cinema4.jpg', 'cinema4_unique.jpg', '해운대 필톡 시네마', '01045678901', now(), now(), 4);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('부산 광안리해변로 78', 'cinema5.jpg', 'cinema5_unique.jpg', '광안리 필톡 시네마', '01056789012', now(), now(), 5);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('대구 동성로 88', 'cinema6.jpg', 'cinema6_unique.jpg', '동성로 필톡 시네마', '01067890123', now(), now(), 6);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('대전 유성구 789', 'cinema7.jpg', 'cinema7_unique.jpg', '유성 필톡 시네마', '01078901234', now(), now(), 7);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('인천 송도대로 55', 'cinema8.jpg', 'cinema8_unique.jpg', '송도 필톡 시네마', '01089012345', now(), now(), 8);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('광주 상무대로 99', 'cinema9.jpg', 'cinema9_unique.jpg', '상무 필톡 시네마', '01090123456', now(), now(), 9);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('수원 인계로 123', 'cinema10.jpg', 'cinema10_unique.jpg', '인계 필톡 시네마', '01101234567', now(), now(), 10);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('서울 여의도대로 123', 'cinema11.jpg', 'cinema11_unique.jpg', '여의도 필톡 시네마', '01011223344', now(), now(), 11);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('서울 서초구 반포대로 256', 'cinema12.jpg', 'cinema12_unique.jpg', '서초 필톡 시네마', '01022334455', now(), now(), 1);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('부산 센텀시티 789', 'cinema13.jpg', 'cinema13_unique.jpg', '센텀 필톡 시네마', '01033445566', now(), now(), 4);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('서울 성동구 왕십리로 34', 'cinema14.jpg', 'cinema14_unique.jpg', '왕십리 필톡 시네마', '01044556677', now(), now(), 1);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('대전 둔산대로 85', 'cinema15.jpg', 'cinema15_unique.jpg', '둔산 필톡 시네마', '01055667788', now(), now(), 7);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('광주 광산구 첨단중앙로 101', 'cinema16.jpg', 'cinema16_unique.jpg', '첨단 필톡 시네마', '01066778899', now(), now(), 9);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('인천 부평구 부평대로 202', 'cinema17.jpg', 'cinema17_unique.jpg', '부평 필톡 시네마', '01077889900', now(), now(), 8);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('서울 마포구 월드컵로 255', 'cinema18.jpg', 'cinema18_unique.jpg', '상암 필톡 시네마', '01088990011', now(), now(), 2);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('부산 북구 화명대로 33', 'cinema19.jpg', 'cinema19_unique.jpg', '화명 필톡 시네마', '01099001122', now(), now(), 5);

insert into cinema_tb(address, img_name, img_uname, name, phone, modified_at, created_at, region_id)
values ('수원 권선구 효원로 77', 'cinema20.jpg', 'cinema20_unique.jpg', '권선 필톡 시네마', '01100112233', now(), now(), 10);

/*insert into cinema_tb( city, address ,img_name ,img_uname, name, phone, modified_at, created_at)
values( '서울', '강남구 강남대로 123', 'cinema1.jpg', 'cinema1_unique.jpg', '강남 영화관', '01012345678', now(), now());

insert into cinema_tb( city, address ,img_name ,img_uname, name, phone, modified_at, created_at)
values( '부산', '해운대구 해운대로 456', 'cinema2.jpg', 'cinema2_unique.jpg', '해운대 영화관', '01023456789', now(), now());*/

insert into screen_tb(name, type, modified_at, created_at)
values ('1관', '일반관', now(), now());

insert into screen_tb(name, type, modified_at, created_at)
values ('2관', '일반관', now(), now());

insert into screen_tb(name, type, modified_at, created_at)
values ('IMAX관', '특별관', now(), now());

-- 1관에 대한 좌석 데이터 10개
insert into seat_tb(type, grade, run_time, seat_number, row_num, col_num, reserved, screen_id)
values
    ('성인', 'VIP', 120, 'A1', 'A', '1', false, 1),
    ('성인', 'VIP', 120, 'A2', 'A', '2', false, 1),
    ('성인', 'VIP', 120, 'A3', 'A', '3', false, 1),
    ('성인', 'VIP', 120, 'A4', 'A', '4', false, 1),
    ('성인', 'VIP', 120, 'A5', 'A', '5', false, 1),
    ('성인', 'VIP', 120, 'B1', 'B', '1', false, 1),
    ('성인', 'VIP', 120, 'B2', 'B', '2', false, 1),
    ('성인', 'VIP', 120, 'B3', 'B', '3', false, 1),
    ('성인', 'VIP', 120, 'B4', 'B', '4', false, 1),
    ('성인', 'VIP', 120, 'B5', 'B', '5', false, 1);

-- 2관에 대한 좌석 데이터 10개
insert into seat_tb(type, grade, run_time, seat_number, row_num, col_num, reserved, screen_id)
values
    ('성인', '일반', 130, 'C1', 'C', '1', false, 2),
    ('성인', '일반', 130, 'C2', 'C', '2', false, 2),
    ('성인', '일반', 130, 'C3', 'C', '3', false, 2),
    ('성인', '일반', 130, 'C4', 'C', '4', false, 2),
    ('성인', '일반', 130, 'C5', 'C', '5', false, 2),
    ('성인', '일반', 130, 'D1', 'D', '1', false, 2),
    ('성인', '일반', 130, 'D2', 'D', '2', false, 2),
    ('성인', '일반', 130, 'D3', 'D', '3', false, 2),
    ('성인', '일반', 130, 'D4', 'D', '4', false, 2),
    ('성인', '일반', 130, 'D5', 'D', '5', false, 2);

-- IMAX관에 대한 좌석 데이터 10개
insert into seat_tb(type, grade, run_time, seat_number, row_num, col_num, reserved, screen_id)
values
    ('청소년', '프리미엄', 150, 'E1', 'E', '1', false, 3),
    ('청소년', '프리미엄', 150, 'E2', 'E', '2', false, 3),
    ('청소년', '프리미엄', 150, 'E3', 'E', '3', false, 3),
    ('청소년', '프리미엄', 150, 'E4', 'E', '4', false, 3),
    ('청소년', '프리미엄', 150, 'E5', 'E', '5', false, 3),
    ('청소년', '프리미엄', 150, 'F1', 'F', '1', false, 3),
    ('청소년', '프리미엄', 150, 'F2', 'F', '2', false, 3),
    ('청소년', '프리미엄', 150, 'F3', 'F', '3', false, 3),
    ('청소년', '프리미엄', 150, 'F4', 'F', '4', false, 3),
    ('청소년', '프리미엄', 150, 'F5', 'F', '5', false, 3);


insert into movie_tb(movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, poster_url, runtime, rating_grade, audi_acc, vod_url, plot, actor_nm, still_url, api_id)
values ('기생충', '2019', '2019-05-30', '대한민국', '스릴러', '봉준호', '바른손이앤에이', 'https://example.com/poster1.jpg', '132', '15세', '10000000', 'https://example.com/vod1', '가난한 가족이 부유한 가족의 집에서 일을 하게 되며 벌어지는 이야기', '송강호', 'https://example.com/still1.jpg', 1);

insert into movie_tb(movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, poster_url, runtime, rating_grade, audi_acc, vod_url, plot, actor_nm, still_url, api_id)
values ('인터스텔라', '2014', '2014-11-07', '미국', 'SF', '크리스토퍼 놀란', '싱코피', 'https://example.com/poster2.jpg', '169', '12세', '15000000', 'https://example.com/vod2', '인류 생존을 위해 우주로 떠나는 탐험대의 이야기', '매튜 매커너히', 'https://example.com/still2.jpg', 2);

insert into movie_tb(movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, poster_url, runtime, rating_grade, audi_acc, vod_url, plot, actor_nm, still_url, api_id)
values ('다크 나이트', '2008', '2008-07-18', '미국', '액션', '크리스토퍼 놀란', '워너 브라더스', 'https://example.com/poster3.jpg', '152', '15세', '18000000', 'https://example.com/vod3', '배트맨이 고담시에서 범죄와 싸우는 이야기', '크리스찬 베일', 'https://example.com/still3.jpg', 3);

insert into movie_tb(movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, poster_url, runtime, rating_grade, audi_acc, vod_url, plot, actor_nm, still_url, api_id)
values ('인셉션', '2010', '2010-07-16', '미국', 'SF', '크리스토퍼 놀란', '워너 브라더스', 'https://example.com/poster4.jpg', '148', '15세', '16000000', 'https://example.com/vod4', '꿈을 통해 정보를 훔치는 도둑의 이야기', '레오나르도 디카프리오', 'https://example.com/still4.jpg', 4);

insert into movie_tb(movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, poster_url, runtime, rating_grade, audi_acc, vod_url, plot, actor_nm, still_url, api_id)
values ('어벤져스: 엔드게임', '2019', '2019-04-24', '미국', '액션', '안소니 루소, 조 루소', '마블 스튜디오', 'https://example.com/poster5.jpg', '181', '12세', '22000000', 'https://example.com/vod5', '어벤져스 팀이 타노스와 최후의 전투를 벌이는 이야기', '로버트 다우니 주니어', 'https://example.com/still5.jpg', 5);

insert into movie_tb(movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, poster_url, runtime, rating_grade, audi_acc, vod_url, plot, actor_nm, still_url, api_id)
values ('라라랜드', '2016', '2016-12-07', '미국', '뮤지컬', '데이미언 셔젤', '서밋 엔터테인먼트', 'https://example.com/poster6.jpg', '128', '12세', '14000000', 'https://example.com/vod6', '재즈 피아니스트와 배우 지망생의 사랑 이야기', '라이언 고슬링', 'https://example.com/still6.jpg', 6);

insert into movie_tb(movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, poster_url, runtime, rating_grade, audi_acc, vod_url, plot, actor_nm, still_url, api_id)
values ('조커', '2019', '2019-10-02', '미국', '드라마', '토드 필립스', '워너 브라더스', 'https://example.com/poster7.jpg', '122', '15세', '12000000', 'https://example.com/vod7', '한 남자가 점차 조커로 변해가는 이야기', '호아킨 피닉스', 'https://example.com/still7.jpg', 7);

insert into movie_tb(movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, poster_url, runtime, rating_grade, audi_acc, vod_url, plot, actor_nm, still_url, api_id)
values ('겨울왕국', '2013', '2013-11-27', '미국', '애니메이션', '크리스 벅, 제니퍼 리', '월트 디즈니 애니메이션 스튜디오', 'https://example.com/poster8.jpg', '102', '전체관람가', '10000000', 'https://example.com/vod8', '얼어붙은 왕국을 되살리기 위한 공주의 모험', '크리스틴 벨', 'https://example.com/still8.jpg', 8);

insert into movie_tb(movie_nm, prdt_year, open_dt, nation_nm, genre_nm, director, company, poster_url, runtime, rating_grade, audi_acc, vod_url, plot, actor_nm, still_url, api_id)
values ('해리 포터와 죽음의 성물 2', '2011', '2011-07-13', '영국', '판타지', '데이빗 예이츠', '워너 브라더스', 'https://example.com/poster9.jpg', '130', '12세', '14000000', 'https://example.com/vod9', '해리 포터가 볼드모트와 최후의 대결을 벌이는 이야기', '다니엘 래드클리프', 'https://example.com/still9.jpg', 9);

insert into comment_tb(content, timestamp, movie_id, user_id)
values ('정말 재미있었어요! 기생충 최고입니다.', now(), 1, 1);

insert into comment_tb(content, timestamp, movie_id, user_id)
values ('인터스텔라는 정말 놀라운 영화입니다. 시각효과가 굉장합니다.', now(), 2, 2);

insert into comment_tb(content, timestamp, movie_id, user_id)
values ('다크 나이트는 최고의 슈퍼히어로 영화입니다.', now(), 3, 3);

insert into comment_tb(content, timestamp, movie_id, user_id)
values ('인셉션을 볼 때마다 새로운 것을 발견하게 됩니다.', now(), 4, 1);

insert into comment_tb(content, timestamp, movie_id, user_id)
values ('엔드게임은 마블 팬으로서 완벽한 결말이었습니다.', now(), 5, 1);

insert into comment_tb(content, timestamp, movie_id, user_id)
values ('라라랜드의 음악이 정말 좋았어요!', now(), 6, 1);

insert into comment_tb(content, timestamp, movie_id, user_id)
values ('조커는 굉장히 어두운 영화지만 매우 인상적이었습니다.', now(), 7, 2);

insert into comment_tb(content, timestamp, movie_id, user_id)
values ('겨울왕국은 아이들과 함께 보기 좋은 영화입니다.', now(), 8, 3);

insert into comment_tb(content, timestamp, movie_id, user_id)
values ('해리 포터 시리즈의 대미를 장식하는 멋진 결말이었어요.', now(), 9, 2);

insert into showtime_tb(movie_id, screen_id, show_time, created_at, modified_at)
values (1, 1, '2024-09-03 10:00:00', now(), now()),
       (1, 1, '2024-09-03 13:00:00', now(), now()),
       (2, 2, '2024-09-03 15:30:00', now(), now()),
       (3, 3, '2024-09-03 18:00:00', now(), now()),
       (4, 1, '2024-09-04 11:00:00', now(), now()),
       (5, 2, '2024-09-04 14:00:00', now(), now()),
       (6, 3, '2024-09-04 17:00:00', now(), now()),
       (7, 1, '2024-09-04 20:00:00', now(), now()),
       (8, 2, '2024-09-05 09:00:00', now(), now()),
       (9, 3, '2024-09-05 12:00:00', now(), now());

insert into reservation_tb(showtime_id, seat_id, user_id, reserved, booking_time)
values (1, 1, 1, true, now()),
       (1, 2, 2, true, now()),
       (2, 3, 3, true, now()),
       (3, 4, 1, true, now()),
       (4, 5, 2, true, now()),
       (5, 6, 3, true, now()),
       (6, 7, 1, true, now()),
       (7, 8, 2, true, now()),
       (8, 9, 3, true, now()),
       (9, 10, 1, true, now());

insert into admin_tb(username, password, email, phone, role, created_at)
values ('admin1', '1234', 'admin1@example.com', '01012345678', 'ROLE_ADMIN', now()),
       ('admin2', '1234', 'admin2@example.com', '01023456789', 'ROLE_ADMIN', now()),
       ('ssar', '1234', 'ssar@example.com', '01034567890', 'ROLE_SUPERADMIN', now());