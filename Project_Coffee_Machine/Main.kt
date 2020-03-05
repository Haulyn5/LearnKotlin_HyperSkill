package machine

enum class MachineState {
    CHOOSING_AN_ACTION,
    CHOOSING_A_VARIANT_OF_COFFEE,
    ADDING_WATER,
    ADDING_MILK,
    ADDING_COFFEE_BEANS,
    ADDING_CUPS,
    EXITING
}

class CoffeeMachine() {
    var water = 400
    var milk = 540
    var coffeeBeans = 120
    var disposableCups = 9
    var money = 550
    var state:MachineState = MachineState.CHOOSING_AN_ACTION

    fun askForAction() {
        print("Write action (buy, fill, take, remaining, exit): > ")
    }

    fun run() {
        if (this.state == MachineState.CHOOSING_AN_ACTION) {
            this.askForAction()
        }
        var userInput = readLine()!!
        this.processUserInput(userInput)
    }

    fun takeProcess(){
        println("I gave you ${this.money}")
        this.money = 0
        println("\n")
    }

    fun displayCoffeeState(){
        println("The coffee machine has:\n" +
                "${this.water} of water\n" +
                "${this.milk} of milk\n" +
                "${this.coffeeBeans} of coffee beans\n" +
                "${this.disposableCups} of disposable cups\n" +
                "\$${this.money} of money\n")
    }

    fun processUserInput(input: String) {
        when(this.state) {
            MachineState.CHOOSING_AN_ACTION-> {
                when(input) {
                    "buy" -> {
                        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: > ");
                        this.state = MachineState.CHOOSING_A_VARIANT_OF_COFFEE
                    }
                    "fill" -> {
                        print("Write how many ml of water do you want to add: > ")
                        this.state = MachineState.ADDING_WATER
                    }
                    "take" -> {
                        this.takeProcess()
                    }
                    "remaining" -> this.displayCoffeeState()
                    "exit" -> {
                        this.state = MachineState.EXITING
                    }
                }
            }
            MachineState.CHOOSING_A_VARIANT_OF_COFFEE -> {
                when (input) {
                    "1" -> {

                        if (this.water >= 250 && this.coffeeBeans >= 16 && this.disposableCups >= 1) {
                            this.water -= 250
                            this.coffeeBeans -= 16
                            this.money += 4
                            this.disposableCups--
                            println("I have enough resources, making you a coffee!")
                        } else {
                            if (this.water < 250)
                                println("Sorry, not enough water!")
                        }

                    }
                    "2" -> {
                        if (this.water >= 350 && milk >= 75 && this.coffeeBeans >= 20 && this.disposableCups >= 1) {
                            this.water -= 350
                            milk -= 75
                            this.coffeeBeans -= 20
                            this.money += 7
                            this.disposableCups--
                            println("I have enough resources, making you a coffee!")
                        } else {
                            if (this.water < 350)
                                println("Sorry, not enough water!")
                        }
                    }
                    "3" -> {
                        if (this.water >= 200 && milk >= 100 && this.coffeeBeans >= 12 && this.disposableCups >= 1) {
                            this.water -= 200
                            milk -= 100
                            this.coffeeBeans -= 12
                            this.money += 6
                            this.disposableCups--
                            println("I have enough resources, making you a coffee!")
                        } else {
                            if (this.water < 200)
                                println("Sorry, not enough water!")
                        }
                    }
                    "back" -> {

                    }
                }
                this.state = MachineState.CHOOSING_AN_ACTION
            }
            MachineState.ADDING_WATER -> {
                this.water += input.toInt()
                print("Write how many ml of milk do you want to add: > ")
                this.state = MachineState.ADDING_MILK
            }
            MachineState.ADDING_MILK -> {
                this.milk += input.toInt()
                print("Write how many grams of coffee beans do you want to add: > ")
                this.state = MachineState.ADDING_COFFEE_BEANS
            }
            MachineState.ADDING_COFFEE_BEANS -> {
                this.coffeeBeans += input.toInt()
                print("Write how many disposable cups of coffee do you want to add: > ")
                this.state = MachineState.ADDING_CUPS
            }
            MachineState.ADDING_CUPS -> {
                this.disposableCups += input.toInt()
                println("\n")
                this.state = MachineState.CHOOSING_AN_ACTION
            }
            else -> {

            }
        }
    }
}


fun main() {
    val machine:CoffeeMachine = CoffeeMachine()
    while (machine.state != MachineState.EXITING)
    {
        machine.run()
    }
}