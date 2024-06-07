package stringSearch;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class KoreaTime {
    public static void main(String[] args) {
        // 한국 시간대의 현재 시간을 가져옴
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        // 현재 시간을 문자열로 포맷팅 (옵션)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = nowInKorea.format(formatter);

        // 한국 현재 시간을 변수에 저장
        ZonedDateTime koreanTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        ZonedDateTime oneDayBefore = koreanTime.minusDays(1);

        // 하루 전 시간을 문자열로 포맷팅
        String formattedOneDayBefore = oneDayBefore.format(formatter);

        // 출력
        System.out.println("하루 전 시간: " + formattedOneDayBefore);

        // 변수 사용 예시
        System.out.println("변수에 저장된 한국 시간: " + koreanTime.format(formatter));
    }
}
