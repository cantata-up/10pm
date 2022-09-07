open class Dog {
    open var age: Int = 0

    open fun bark() {
        println("멍멍")
    }
}

// final 키워드로 하위 클래스에서 override 더이상 금지할 수 있다.
// 상속을 막을 수 있다.
open class Bulldog(final override var age : Int = 0): Dog() {
    final override fun bark() {
//        println("컹컹")
        super.bark()
    }
}

abstract class Developer {
    abstract var age: Int
    abstract fun code(language: String)
}

class BackendDeveloper(override var age: Int) : Developer() {

    override fun code(language: String) {
        println("I code with ${language}")
    }

}

fun main() {
    val backendDeveloper = BackendDeveloper(age = 30)
    println(backendDeveloper.age)
    backendDeveloper.code("kotlin")

//    val dog = Bulldog(age = 2)
//    println(dog.age)
//    dog.bark()

}

//class ChildBulldog : Bulldog() {
//    override var age: Int = 0
//    override fun bark() {
//        super.bark()
//    }
//}
