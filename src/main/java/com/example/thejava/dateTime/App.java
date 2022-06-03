package com.example.thejava.dateTime;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) {
        Date date = new Date(); //근본적으로 타임스탬프 > mutable (값을 바꿀수 있음) 하기 때문에 thread safe 하지 않음. Type Safety 하지 않다.
        long time = date.getTime();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        /**
         * 주요 API
         * Date.getTime() > 기계용 시간
         * LocalDate, LocalTime, LocalDateTime > 사람이 쓰는 시간
         */
        //기계용 API
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); // 기준시 UTC, GMT 시간 기준
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());// 시스템 기준 시점으로 변경
        System.out.println("zonedDateTime = " + zonedDateTime);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKorea = " + nowInKorea);

        //사람용
        LocalDateTime today = LocalDateTime.now();
        System.out.println("today = " + today);
        LocalDateTime birth = LocalDateTime.of(1994, Month.SEPTEMBER, 17, 0, 0, 0);

        //날짜 비교(human 용)
        LocalDate now = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2022, Month.SEPTEMBER, 17);

        Period prePeriod = Period.between(now, thisYearBirthday);
        System.out.println("prePeriod = " + prePeriod);

        //혹은
        Period until = now.until(thisYearBirthday);
        System.out.println("until = " + until);

        //날짜비교 (기계용)
        Instant now1 = Instant.now();
        Instant plus = now1.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now1, plus);
        System.out.println("between = " + between);

        //포매팅
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("nowTime = " + nowTime.format(dateTimeFormatter));

        //파싱
        LocalDate parse = LocalDate.parse("09/17/1994", dateTimeFormatter);
        System.out.println("parse = " + parse);
    }
}
