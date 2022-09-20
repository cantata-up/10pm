// 하나의 상위 클래스 또는 인터페이스에서 하위클래스에 대한 정의를 제한할 수 있음
// 컴파일러가 Developer가 Back-Front 밖에 없다는 것을 컴파일 시 파악할 수 있
// 같은 패키지, 같은 모듈에서만 sealed 클래스를 정의할 수 있음
// 1.6 이전버전은 같은 파일안에 정의해야하지만, 이후는 패키지/모듈까지 가능하도록 변경됨
sealed class Developer {

    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String): Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자입니다 ${language}를 사용합니다.")
    }
}

data class FrontendDeveloper(override val name: String): Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자입니다 ${language}를 사용합니다.")
    }
}

// 생성되면 컴파일러가 알고 있다고 생각하면 됨
object OtherDeveloper: Developer() {
    override val name: String = "익명"
    override fun code(language: String) {
        TODO("Not yet implemented")
    }
}

data class AndroidDeveloper(override val name: String): Developer() {
    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다 ${language}를 사용합니다.")
    }
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when(developer) {
        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        // 강제적으로 구현하도록 함
//        is OtherDeveloper -> println("지원하지않는 개발자 종류입니다.")
        // else를 넣지 않는다면.. 컴파일러 입장에서는 잘 알지 못한다. -> sealed class 선언
        // else 클래스는 버그를 유발할수 있음
//        else -> {
//            println("지원하지않는 개발자입니다.")
//        }
        is AndroidDeveloper -> pool[developer.name] = developer
        is OtherDeveloper -> println("지원하지 않는 개발자 종류입니다.")
    }

    fun get(name: String) = pool[name]
}

fun main() {
    val backendDeveloper = BackendDeveloper(name = "제리")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "제이")
    DeveloperPool.add(frontendDeveloper)

    val androidDeveloper = AndroidDeveloper(name="안드로")
    DeveloperPool.add(androidDeveloper)

    println(DeveloperPool.get("제리"))
    println(DeveloperPool.get("제이"))
    println(DeveloperPool.get("안드로"))
}