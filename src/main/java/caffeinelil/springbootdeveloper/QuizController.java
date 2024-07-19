package caffeinelil.springbootdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {
    @GetMapping("/quiz")
    public ResponseEntity<String> Quiz(@RequestParam("code") int code) {
        switch(code){
            case 1:
                return ResponseEntity.created(null).body("Created!!");
            case 2:
                return ResponseEntity.badRequest().body("Bad Request!!");
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }

    @PostMapping("/quiz")
    public ResponseEntity<String> Quiz2(@RequestBody Code code){

        //향상된 switch 문이 뭐지?
        switch (code.value()){
            case 1:
                return ResponseEntity.status(403).body("Forbidden!");
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }
}

//git 잘 쓰고 있나 아무 주석 추가함

record Code(int value) {}