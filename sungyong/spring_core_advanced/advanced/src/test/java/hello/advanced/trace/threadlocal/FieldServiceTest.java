package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * [ThreadLocal - 동시성 문제 예제]
 * FieldService test를 위한 test 코드
 * - 동시성 이슈: Thread가 동시에 같은 인스턴스의 필드 값에 접근/변경하면서 발생하는 이슈이다.
 *
 * [동시성 이슈 미발생]
 * - sleep(2000) 적용
 * ```
 * [Test worker] main start
 * [thread-A] 저장 name=userA -> nameStore=null
 * [thread-A] 조회 nameStore=userA
 * [thread-B] 저장 name=userB -> nameStore=userA
 * [thread-B] 조회 nameStore=userB
 * [Test worker] main exit
 * ```
 *
 * [동시성 이슈 발생]
 * - sleep(100) 적용
 * - A의 작업이 끝나기 전에 B의 작업이 수행된다. 이때 userA가 저장한 데이터가 오염된다.
 * ```
 * [Test worker] main start
 * [thread-A] 저장 name=userA -> nameStore=null
 * [thread-B] 저장 name=userB -> nameStore=userA  // userA가 저장한 데이터가 오염된다.
 * [thread-A] 조회 nameStore=userB
 * [thread-B] 조회 nameStore=userB
 * [Test worker] main exit
 * ```
 * [동시성 문제의 해결책]
 * ThreadLocal
 */
@Slf4j
public class FieldServiceTest {
    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB =  new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();        // A 실행
//        sleep(2000);      // 동시성 문제 발생 X
        sleep(100);       // 동시성 문제 발생 O
        threadB.start();        // B 실행

        sleep(3000);      // 메인 스레드 종료 대기
        log.info("main exit");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
