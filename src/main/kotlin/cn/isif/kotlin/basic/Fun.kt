package cn.isif.kotlin.basic

fun isBigCountry(country: Country): Boolean {
    return country.continent == "er" && country.population > 100
}

data class Country(var name: String, var continent: String, var population: Int)
class CountryApp {
    fun filterCountry(res: List<Country>, filter: (Country) -> Boolean): List<Country> {
        var result = mutableListOf<Country>()
        for (c in res) {
            if (filter(c)) {
                result.add(c)
            }
        }
        return result
    }
}

fun main() {
    val list = listOf("hello", "hell", "hel", "he", "h")
//    for (c in list) {
//        println(c)
//        if (c == "he") {
//            break
//        }
//    }
    val countrys = listOf(
        Country("japan", "er", 100),
        Country("china", "er", 1000),
        Country("us", "ec", 102)
    )
//    CountryApp().filterCountry(countrys, ::isBigCountry).let { println(it) } //等同于 println(CountryApp().filterCountry(countrys, ::isBigCountry))
    CountryApp().filterCountry(countrys,fun (country: Country): Boolean { return country.continent == "er" && country.population > 100 }).let { println(it) }
    //简化之后
    CountryApp().filterCountry(countrys,{country -> country.continent == "er" && country.population > 100 })
    var getName = Country::name
    countrys.map { getName(it) }.let { println(it) }
//    countrys.map(Country::name).let { println(it) }

    //匿名函数
    val check = fun(country: Country): Boolean {
        return country.name == "" && country.population > 100
    }
}