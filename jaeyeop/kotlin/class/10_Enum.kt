enum class PaymentStatus(val label: String): Payable{
    UNPAID("미지급") {
        override fun isPayble(): Boolean = false
    },
    PAID("지급") {
        override fun isPayble(): Boolean = true
    },
    FAILED("지급실패") {
        override fun isPayble(): Boolean = false
    },
    REFUNDED("환불") {
        override fun isPayble(): Boolean = false
    }
}

interface Payable {
    fun isPayble(): Boolean
}

fun main() {
//    if (PaymentStatus.PAID.isPayble()) {
//        println("지급")
//    }

    val paymentStatus = PaymentStatus.valueOf("PAID")
    println(paymentStatus.label)

    if (paymentStatus == PaymentStatus.PAID) {
        println("결제 완료 상태")
    }

    for (status in PaymentStatus.values()) {
        println("[$status](${status.label}) : ${status.ordinal}")
    }

}