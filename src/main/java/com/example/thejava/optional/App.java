package com.example.thejava.optional;

import com.example.thejava.optional.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));

        /**
         * Optional
         * retunr type에만 쓰는것으로 생각하는게 좋음.
         * null일 수 있는 인스턴스에 대해 Optional로 감싸서 return 함.
         * ofNullable : null일수 있는 값도 받음.
         * of : 무조건 값이 있음(null 일경우 exception 발생)
         * 
         * [주의사항]
         * 프리미티브 타입용 Optional은 따로 있음. OptionalInt, OptionalLong...
         * Collection, Map, Stream Array Optioanl은 Optional로 감싸지 말것
         */

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        spring.isPresent(); // 값이 있는지 검사할 수 있음. > boolean return
        spring.isEmpty(); // 값이 없는지 검사가능 > boolean return

        //Optional의 값을 가져오는 방법
        //OnlineClass onlineClass = spring.get();

        //만일 비어있는 값을 .get()할경우 NoSuchElementException이 나옴. 그러니 확인을 하고 꺼내길 권장
        if (spring.isPresent()) {
            System.out.println("onlineClass = " + spring.get());
        }

        //위의 if문 방법보단 Optinal이 제공하는 다양한 메서드로 커버를 할 수있음.
        // 가급적 get을 사용하지 않고 처리하는것이 좋음

        //ifPresent
        spring.ifPresent(oc -> {
            System.out.println("title = " + oc.getTitle());
        });

        //orElse : 있으면 꺼내오고 없으면 행동(ex 새로운 클래스를 만드는 메서드 호출)
        // 그러나 해당 값이 있더라도 해당 코드는 실행됨. 뭔가 찝찝함.
        spring.orElse(createNewClass());

        //orElseThat : 없는경우 동작함.(대안이 있는경우)
        spring.orElseGet(() -> createNewClass());

        //orElseThrow : 값이 없을경우 에러를 던짐.(대안이 없는경우)
        spring.orElseThrow(() -> new IllegalArgumentException("값이 없음"));

        //filter : 값을 걸러냄 > 있다는 가정하에 실행, 없는경우 아무일도 일어나지 않음.
        Optional<OnlineClass> onlineClass = spring.filter(oc -> oc.getId() > 10);

        //map : getId에 따라 id의 타입인 Integer을 담고있는 Optional 반환
        Optional<Integer> integer = spring.map(OnlineClass::getId);

        //만일 map으로 꺼내는 Type이 Optional일 경우 양파까듯이 안에서부터 까줘야 함.
        Optional<Optional<Progress>> progress = spring.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        Progress progress2 = progress1.orElseThrow();

        //Optinal이 제공하는 flatMap : 위와같이 Optional로 여러번 감싸있는 경우 유용함. > 매핑해서 꺼내는 retunr 타입이 Optinal인경우 안에서 껍질을 까줌.
        Optional<Progress> progress3 = spring.flatMap(OnlineClass::getProgress);
        Progress progress4 = progress3.orElseThrow();

        //stream에서의 map > 1대 1매핑  / stream에서의  flatmap > 리스트 안에 리스트를 끄집어 내서 하나로 보여주는 느낌(인풋은 하나지만 아웃풋이 여러개인경우에 주로 쓰임)


    }

    private static OnlineClass createNewClass() {
        System.out.println("새로운 class 생성");
        return new OnlineClass(1, "spring boot", true);
    }
}
