import java.time.LocalDateTime

// 코틀린에서는 object keyword를 사용하면 Singleton
// 함수나 변수를 사용할때는 Class 한정자를 사용한다.
//object Singleton {
//    val a = 1234
//
//    fun printA() = println(a)
//}
//
//fun main() {
//    println(Singleton.a)
//    Singleton.printA()
//}

//object DatetimeUtils {
//    val now : LocalDateTime
//        get() = LocalDateTime.now()
//
//    // const로 변수를 선언하면 자바 상수와 유사하다.
//    const val DEFAULT_FORMAT = "YYYY-MM-DD"
//
//    fun same(a: LocalDateTime, b: LocalDateTime): Boolean {
//        return a == b
//    }
//}
//
//fun main() {
//    println(DatetimeUtils.now)
//    println(DatetimeUtils.now)
//    println(DatetimeUtils.now)
//
//    println(DatetimeUtils.DEFAULT_FORMAT)
//
//    val now = LocalDateTime.now()
//    println(DatetimeUtils.same(now, now))
//}

// 동반객체
// 내부에 변수/함수 선언 가능
class MyClass {

    private constructor()

    companion object MyCompanion{
        val a = 1234

        fun newInstance() = MyClass()
    }
}

fun main() {
    println(MyClass.a)
    println(MyClass.newInstance())

    // Companion이 생략되어있다.
//    println(MyClass.Companion.a)
//    println(MyClass.Companion.newInstance())

    println(MyClass.MyCompanion.a)
    println(MyClass.MyCompanion.newInstance())
}