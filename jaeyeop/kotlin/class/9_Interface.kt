class Product(val name: String, val price: Int)

interface Wheel {
    fun roll()
}

// Kotlin에서 인터페이스도 상위 인터페이스를 가질 수 있다.
// 하위인터페이스에서 상위 인터페이스의 Property를 재정의 할 수 있다.(Override)
interface Cart : Wheel {

    // 코틀린 인터페이스는 프로퍼티도 가질 수 있다.
    // coin 이라는 Property는 MyCart에서 구현해야하는 추상 Property
    var coin: Int

    // Getter 접근자를 통해 Property를 구현할 수 있다.
    // 이 경우에는 내부에 Property에 대한 초기값이 없기 때문에 인터페이스 자체에서 Backing Field에 접근할 수는 없다.
    // field 사용 금지 !!!
    // 인터페이스 내에서는 특수 값만 넣을 때 사용
    val weight: String
        get() = "20KG"

    fun add(product: Product)

    // 자바의 default 함수
    fun rent() {
        if (coin > 0) {
            println("카트를 대여합니다")
        }
    }

    // interface에서 구현
    override fun roll() {
        println("카트가 굴러갑니다")
    }

    fun printId() = println("1234")
}

interface Order {
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다")
    }

    fun printId() = println("5678")
}

// 인터페이스는 인터페이스명만 추가하는게 상속과 다르다.
// 복수개의 Interface를 구현할 수 있지만, 문제점은 동일한 Signature를 가진 함수를 구현할 떄 문제가 생긴다.
// 복수개의 Interface에서 함수를 호출하려고 하면 super 키워드를 통해 상위클래스에 참조 접근이 가능한데,
class MyCart(override var coin: Int) : Cart, Order {

    override fun add(product: Product) {
        if (coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가됐습니다")

        // super 키워드로 상위인터페이스 참조 접근이 가능하다
        // 주문하기
        super<Order>.add(product)
    }

    override fun printId() {
        super<Cart>.printId();
        super<Order>.printId();
    }
}

fun main() {
    val cart = MyCart(coin = 100)
    cart.rent()
    cart.roll()
    cart.add(Product(name = "장난감", price = 1000))
    cart.printId();
}