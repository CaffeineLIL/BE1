package caffeinelil.springbootdeveloper;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity //1. 이걸 엔티티로 지정
@NoArgsConstructor(access = AccessLevel.PROTECTED) //2. 기본 생성자로 해주기
@AllArgsConstructor
public class Member {
    @Id //id 필드를 기본키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //기본키를 자동으로 1씩 증가시킴
    @Column(name = "id", updatable = false)
    private Long id;
    
    @Column(name = "name", nullable = false) //name이라는 not null 컬럼과 매핑시킴
    private String name;

    public void changeName(String name){
        this.name = name;
    }
}