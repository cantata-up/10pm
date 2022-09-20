import java.util.LinkedList
import java.util.stream.Collectors

fun main() {

    // immutable - 불변
    val currencyList = listOf("달러", "유로", "원")

    // mutable
    val mutableCurrencyList = mutableListOf<String>().apply {
        this.add("달러")
        add("유료")
        add("원")
    }

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // immutable map
    // to는 keyword는 아니고, 중위표현식 infix 표현식
    val numberMap = mapOf("one" to 1, "two" to 2)

    // mutable map
    // put은 not recommended
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1
    mutableNumberMap.put("two", 2)

    // Collection Builder
    // mutableList(내부) -> immutableList(외부)로 할당
    // builder 밖에서는 add가 불가능함
    val numberList: List<Int> = buildList{
        add(1)
        add(2)
        add(3)
    }
//    numberList.add(4)


    // LinkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    // Collection 반복하기
    val iterator = currencyList.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("=============================")

    for (currency in currencyList) {
        println(currency)
    }

    println("=============================")

    currencyList.forEach {
        // it은 람다하면서 설명
        println(it)
    }

    // for loop -> map
    val lowerList = listOf("a", "b", "c")
//    val upperList = mutableListOf<String>()

//    for (lowerCase in lowerList) {
//        upperList.add(lowerCase.uppercase())
//    }

    val upperList = lowerList.map { it.uppercase() }
//    println(upperList)

//    val filteredList = mutableListOf<String>()
//    for (upperCase in upperList) {
//        if (upperCase == "A" || upperCase == "C") {
//            filteredList.add(upperCase)
//        }
//    }

    // 자바 8 스트림과 차이, 코틀린은 Terminal Operator x, 중간연산자 o
    // collect Terminal Operator 자바는 필요함
    // 코틀린의 inline 함수들은 일반적으로 Terminal Operator가 존재하지 않음
    // 자바8랑 유사한 것은 asSequence()
//    val filteredList = upperList.stream()
//        .filter{ it == "A" || it == "B" }
//        .collect(Collectors.toList())
//    val filteredList = upperList.filter { it == "A" || it == "B" }

//    val filteredList = upperList
//        .asSequence()
//        .filter { it == "A" || it == "B" }
//        .toList()

    // 함수가 동작할때마다 Collection들이 생성되는 것
    // 그래서 메모리적으로는 별로 안좋다
    // inline 함수에 대한 Chnaining이 많아질 경우에는 asSequnece 사용
    // asSequence 사용하고 Teminal Operator를 사용하면 마지막에 Collection 한번 생성
    // 데이터가 100,000건 이하면 inline이 성능이 더 좋음
    val filteredList = upperList
        .asSequence()
        .filter { it == "A" || it == "B" }
        .filter { it == "C" }
        .toList()

    println(filteredList)




}