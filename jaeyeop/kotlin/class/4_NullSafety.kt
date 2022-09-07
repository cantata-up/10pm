import java.lang.NullPointerException

fun getNullStr(): String? = null

fun getLengthIfNotNull(str: String?) = str?.length ?: 0

fun main() {

    val nullableStr = getNullStr()

    // Complie 단계에서 Null을 확인할 수 있기 때문에 아주 좋다.
    val nullableStrLength = nullableStr?.length ?: "null인 경우 반환".length
    println(nullableStrLength)

    val length = getLengthIfNotNull(null)
    println(length)

    // Kotlin에서 NPE가 발생할 수 있는 케이스
    // NPE 가능성이 크게 줄어들 뿐이지 아예 사라지지는 않는다.
//    1. throw NullPointerException()
    val c: String? = null

    // 2. !! 단언연산자, 무조건 Null이 발생하지 않는다고 개발자가 지정함
    // Null이 발생하면 개발자가 Handling할 것을 컴파일러에게 알려준다.
    val d = c!!.length

    // 3. 자바코드를 호출할 경우, 코틀린 컴파일러가 작동하지 않기 떄문에 발생할 수 있다.
    // 코틀린에서 자바코드를 사용할 때는 Nullable에 대해서 유념하여야 한다.



    // Kotlin에서는 Null을 받을 수 없는 타입이 존재한다.
    // 자바와는 다르게 컴파일 단계에서 거른다.
//    val a : String = null
//    var b : String = "aabbcc"
//    b = null

    // ? Nullable Type
//    var a : String? = null
//    println(a?.length)
//
//    val b : Int = if (a != null) a.length else 0
//    println(b)
//
//    // Elvis 연산자
//    // 좌변이 Null인 경우 우변을 선택한다.
//    val c = a?.length ?: 0
//    println(c)




}