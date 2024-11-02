import kotlin.random.Random

fun main(){
    println("Добро пожаловать в программу 'План поезда'\nЖелаете продолжить?\nВведите да или нет")
    readln().let {
        if( it.uppercase() == "ДА") println("Добро пожаловать\n")
        else if (it.uppercase() == "НЕТ") {
            print("До свидания")
            return
        }
        else {
            wrong()
            return
        }
    }
    var route = Route()
    route.generateRoute()
    println("Шаг 1 - Выбор маршрута\nПоезд следует по маршруту: ${route.routeArr[0]}-${route.routeArr[1]}\n")
    var train = Train()
    println("Шаг 2 - Продажа билетов\nПродано ${train.tickets} шт.\n")
    println("Шаг 3 - Формирование поезда\t\t\tНеобходимо дополнительно мест:")
    train.wagons()
    println("Шаг 4 - Отправление поезда\nПоезд ${route.routeArr[0]}-${route.routeArr[1]}, состоящий из ${train.wagonsCount} вагонов отправлен")
}
fun wrong(){
    println("Данные введены неверно")
}
class Train{
    var tickets = (5..201).random()
    var wagonsCount = 0
    fun wagons(){
        var countTicket = 0
        while (countTicket < tickets){
            wagonsCount++
            var ticketsNow = (5..25).random()
            countTicket += ticketsNow
            println("Вагон $wagonsCount вместимостью $ticketsNow пассажиров\t${if(countTicket < tickets) tickets - countTicket else 0}")
        }
        println("\nОсталось ${countTicket - tickets} свободных мест\n")
    }
}
class Route{
    var routeArr = arrayOf("","")
    fun generateRoute(){
        var townLi = listOf("Барнаул","Москва","Санкт-Петербург","Выборг","Всеволожск","Псков","Мурманск","Брянск",
            "Белгород","Сочи","Анапа","Рыбинск","Ростов-на-Дону","Нижний Новгород","Чехов","Пушкин")
        routeArr =arrayOf(townLi.random().toString(), townLi.random().toString())
        while (routeArr[0] == routeArr[1]){
            routeArr[1] = townLi.random()
        }
        return
    }
}