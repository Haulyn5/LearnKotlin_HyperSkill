class City(val name: String) {
    var degrees: Int = 100
        set(value) {
            if (value < -92 || value > 57) {
                when (this.name) {
                    "Dubai" -> {field =  30}
                    "Moscow" -> {field = 5}
                    "Hanoi" -> {field = 20 }
                }
            } else {
                field = value
            }
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    //implement comparing here
    var cityList = mutableListOf(firstCity,secondCity,thirdCity)
    cityList.sortBy{it.degrees}
    if(cityList[0].degrees == cityList[1].degrees) {
        print("neither")
    }
    else {
        print(cityList[0].name)
    }
}
