package com.example.thejava.functionalbleInterface.lambda;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        /**
         * Body가 한줄일 경우 생략가능
         */
        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        //equal
        UnaryOperator<Integer> plus10Sec = (i) -> {
            return i + 10;
        };

        /**
         * 인자가 두개인 경우
         * 인자의 타입을 생략해도 변수 선언부에 정의가 되어있어 컴파일러가 추론이 가능함.
         */
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        /**
         * 변수 캡쳐
         */
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        // local variable 지역변수 final > 변경을 하지 못함.
        // 사실상 final인 경우 final 생략이 가능 ex) int baseNumber;
        // 람다와 다른 익명, 내부 클래스와는 다른점은 쉐도잉이 되지 않음.(즉 scope 안의 변수가 같은 이름의 변수를 가리지 않음)(코드참조)
        final int baseNumber = 10; 
        

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 11; // 이럴경우 위의 final 이 아닌 11이 찍힘.(쉐도잉)
                System.out.println("baseNumber = " + baseNumber); //11
            }
        };
        
        // 로컬 클래스
        class LocalClass{
            void printBaseNumber() {
                int baseNumber = 11; // 이럴경우 위의 final 이 아닌 11이 찍힘.(쉐도잉)
                System.out.println("baseNumber = " + baseNumber); //11
            }
        }

        IntConsumer printInt = (i) -> {
            //람다의 경우 final 값이 출력됨. 위와 달리 변수를 쫓아가보면 다름.
            // i 부분에 baseNumber을 넣을 경우 같은 scope 이기 때문에 컴파일 오류가 발생함. 이미 정의되어 있다는 오류 발생
            // 마찬가지로 뒤에서 baseNumber ++; 를했을 경우에도 오류 발생(final을 바꾸려 하기때문 같은 cope 안에서)
            System.out.println(i + baseNumber);
            //baseNumber++;
        };

        printInt.accept(10);
    }
}
