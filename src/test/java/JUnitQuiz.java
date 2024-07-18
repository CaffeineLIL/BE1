import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz {

    @Test
    public void junitQuiz(){
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길은";

        //모든 변수가 NULL이 아닌지 확인하기
        // Assertions.assertEquals(sum, a+b); 보다 가독성 좋게 개선
        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isNotEqualTo(name3);
    }

    @Test
    public void junitQuiz2(){
        int number1 = 15;
        int number2 = 0;
        int number3 = -5;

        assertThat(number1).isPositive();
        assertThat(number2).isZero(); // number2가 0인지 확인
        assertThat(number3).isNegative(); // number3가 음수인지 확인
        assertThat(number1).isGreaterThan(number2);
        assertThat(number3).isLessThan(number2);
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Hello!");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Goodbye!");
    }

    @Test
    public void junitQuiz3(){
        System.out.println("This is first test");
    }

    @Test
    public void junitQuiz4(){
        System.out.println("This is second test");
    }
}
