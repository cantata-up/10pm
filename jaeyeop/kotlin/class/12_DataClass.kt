// DTO와 같이 데이터를 전달하고 저장하는 Class를 만들때 data class로
// 불변성이 깨지면 문제가 많다.
// MultiThreading 환경, hash 꺠짐
// Copy를 사용하는 것이 좋음, 원하는 property만 변경하여 불변객체 생성
data class Person(val name: String, val age: Int) {
}

fun main() {
    val person1 = Person(name = "jerry", age = 12)

//    val person2 = person1.copy(name = "tom")
//    println(person2)

    // 내부적으로는 componentN() 사용해서 생성, 구조와분해
    val (name, age) = person1
    println("이름=${person1.component1()}, 나이=${person1.component2()}")
    println("이름=${name}, 나이=${age}")

//    val person2 = Person(name = "jerry", age = 12)

//    println(person1 == person2)
//
//    val set = hashSetOf(person1)
//    println(set.contains(person1))
//
//    person1.name = "stranger"
//    println(set.contains(person1))
//    println(person1.toString())
}