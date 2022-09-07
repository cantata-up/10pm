class Coffee(
    //(참고) val Keyword는 getter만 생성된다.
    var name:String = "",
    var price: Int = 0,
    var iced: Boolean = false
    ) {
    // Custom Getter
    val brand: String
        get() {
            return "스타벅스"
        }

    // Custom Setter
    var quantity : Int = 0
        set(value) {
            if (value > 0) { // 수량이 0 이상인 경우에만 할
                //서 field는 식별자이다. 코틀린에서는 field라고 하는 식별자를 사용해 쓸 수 있다.(Backing Field)
                // 무한재귀를 막기 위해, StackOverFow 발생.
                field = value
            }
        }
}

// 본문 내용이 없는 Class를 만들 수 있다.
class EmptyClass

fun main() {
    val coffee = Coffee()

    // 실제로는 Setter로 값을 세팅한다.
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000
    coffee.quantity = 1
    coffee.iced = true

    // Method가 아닌 Property로 사용(실제 동작은 Getter로)
    // 자바에 비해 객체지향적으로 코딩이 가능하다.
    // 상태를 나타낼때 Property로 가능하다.
    if(coffee.iced) {
        println("아이스 커피")
    }

    // 실제로는 Getter로 값을 불러온다.
    println("${coffee.brand} ${coffee.name} 가격은 ${coffee.price} 수량은 ${coffee.quantity}")
}