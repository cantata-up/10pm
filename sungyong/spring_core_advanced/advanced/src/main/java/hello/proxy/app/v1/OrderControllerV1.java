package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * request(): LogTrace를 적용할 대상
 * nolog(): LogTrace를 적용하지 않을 대상
 */
@RequestMapping// Spring에서 @Controller or @RequestMapping이 있어야 Controller로 인식한다.
@ResponseBody   // HTTP MessageConverter 사용 : view 페이지가 아니라 문자열을 그대로 반환하고 싶다면, @ResponseBody를 추가한다. // @RestController에 포함되어 있는 애노테이션
//@RestController
// https://velog.io/@donsco/Spring-ResponseBody
public interface OrderControllerV1 {

    // ++ @RequestParam을 생략할 경우 컴파일 이후의 자바버전에 따라 인식하지 못 할 수도 있다. 인터페이스에서 꼭 명시해야한다.
    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();

}
