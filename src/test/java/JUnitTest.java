import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class JUnitTest {
  @DisplayName("1 + 2 는 귀요미가 아니라 사실은 3이었답니다 충격!") //테스트 이름
  @Test
  public void JUnitTest(){
      int a = 1;
      int b = 2;
      int sum = 3;

      Assertions.assertEquals(sum, a+b);
  }


}
