import java.lang.IllegalArgumentException

fun main() {

//    Thread.sleep(1)


    try {
        throw java.lang.Exception()
//        Thread.sleep(1)
    } catch (e: Exception) {
        println("에러 발생!")
    } finally {
        println("finally 실행!")
    }

    // 코틀린에서 try-catch는 표현식, 자바의 경우는 구문
    // 표현식이므로 값을 전달할 수 있다.
    val a = try {
        "1234".toInt()
    } catch (e: java.lang.Exception) {
        println("예외 발생 !")
    }
    println(a)

    // throw 역시도 표현식이다.
//    throw java.lang.Exception("예외 발생!!!!!")

    val b: String? = null
    val c: String = b ?: failFast("b is null")

    // Nothing Type일 경우는 c?. 하지 않아도 된다. -> 이건 좀 이해가 안된다...
    // Nothing Type인 경우 null이 될 수 없다고 컴파일러가 판단한다.
    println(c.length)
//    println("이 메시지는 출력될까?")

}

// Nothing, Util Type 은 조금 다르다.
// Return이 없을떄는 Util
// 코드에 문제가 있는경우, 코드가 정상적으로 수행하는 것을 보장하지 않을때는 Nothing
fun failFast(message: String): Nothing {
    throw IllegalArgumentException(message)
}