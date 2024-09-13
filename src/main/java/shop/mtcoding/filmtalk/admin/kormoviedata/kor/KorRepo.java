package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KorRepo {
    private final String API_ADDRESS = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2";
    private final String API_KEY = "702XX6W727GI21HY412Q";
    private final String API_LIST_COUNT = "500";
    private KorMovies container = new KorMovies();

    public KorMovies getMovies() throws UnsupportedEncodingException {
        LocalDate today = LocalDate.now();

        // 7일 전과 7일 후 날짜 계산
        LocalDate sevenDaysBefore = today.minusDays(7);
        LocalDate sevenDaysAfter = today.plusDays(7);

        // 원하는 형식으로 날짜 포맷 (예: yyMMdd)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedBefore = sevenDaysBefore.format(formatter);
        String formattedAfter = sevenDaysAfter.format(formatter);

        String fullUrl = API_ADDRESS + "&ServiceKey="+API_KEY+"&listCount="+API_LIST_COUNT+"&releaseDts="+formattedBefore+"&releaseDte="+formattedAfter;
        System.out.println("-----------------------------------------");
        System.out.println(fullUrl);
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
            ObjectMapper objectMapper = new ObjectMapper();
            KorMovies KorMovies = objectMapper.readValue(response.toString(), KorMovies.class);
            return KorMovies;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
