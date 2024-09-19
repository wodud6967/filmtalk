package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class KorRepo {
    private final String API_ADDRESS = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2";
    private final String API_KEY = "702XX6W727GI21HY412Q";
    private final List<String> API_KEYS = new ArrayList<>(List.of(
            "702XX6W727GI21HY412Q",
            "42169U3QK88YCP139UOD"
    ));
    private final String API_LIST_COUNT = "500";
    private int apiKeyIndex = 0;

    public KorMovies getMovies() throws UnsupportedEncodingException {
        LocalDate today = LocalDate.now();

        // 7일 전과 7일 후 날짜 계산
        LocalDate sevenDaysBefore = today.minusDays(7);
        LocalDate sevenDaysAfter = today.plusDays(7);

        // 원하는 형식으로 날짜 포맷 (예: yyMMdd)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedBefore = sevenDaysBefore.format(formatter);
        String formattedAfter = sevenDaysAfter.format(formatter);

        // 순차적으로 다른 API 키를 사용하면서 요청 시도
        while (apiKeyIndex < API_KEYS.size()) {
            String currentApiKey = API_KEYS.get(apiKeyIndex);
            String fullUrl = API_ADDRESS + "&ServiceKey=" + currentApiKey + "&listCount=" + API_LIST_COUNT
                    + "&releaseDts=" + formattedBefore + "&releaseDte=" + formattedAfter;

            try {
                URL url = new URL(fullUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // 응답 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // JSON 데이터를 KorMovies 객체로 변환
                ObjectMapper objectMapper = new ObjectMapper();
                KorMovies korMovies = objectMapper.readValue(response.toString(), KorMovies.class);
                return korMovies;

            } catch (Exception e) {
                // 현재 API 키가 실패할 경우, 다음 API 키로 전환
                apiKeyIndex++;
                System.out.println("API 키 전환: " + currentApiKey);
                e.printStackTrace();
            }
        }

        // 모든 API 키가 실패했을 경우 null 반환
        System.out.println("모든 API 키가 소진되었습니다.");
        return null;
    }
}