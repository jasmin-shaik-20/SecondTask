import java.util.*


class ShoppingCart {
    val items = mutableMapOf<String, Int>()
    fun addItem(scanner: Scanner, list: MutableMap<String, Int>): MutableMap<String, Int> {
        println("How many items do you add")
        val num = scanner.nextInt()
        for (i in 1..num) {
            println("Enter the item")
            var name = readln()
            if (name !in list.keys) {
                println("Item not found")
            } else if(name in items.keys&&name in list.keys){
                items.replace(name,items[name]!!+list[name]!!)
            }
            else{
                list[name]?.let { items.put(name, it) }
            }
        }
        println(items)
        return items
    }

    fun removeItem(scanner: Scanner, items: MutableMap<String, Int>) {
        println("How many items do you remove")
        val num = scanner.nextInt()
        for (i in 1..num) {
            println("Enter the item")
            var name = readln()
            if (name !in items.keys) {
                println("Item not found")
            } else {
                items[name]?.let { items.remove(name, it) }
            }
        }
        println(items)
    }

    fun calculateTotalPrice():Double {
        var totalPrice = 0.0
        for (item in items.values) {
            totalPrice += item
        }
        return totalPrice


    }

    fun applyDiscount(discountPercentage: Double,scanner: Scanner): Double {
        val discountedPrice = let {
            val totalPrice = calculateTotalPrice()
            totalPrice - (totalPrice * (discountPercentage / 100))
        }
        return discountedPrice
    }


}

fun main() {
    val scanner = Scanner(System.`in`)
    val cart = ShoppingCart()
    val list = mutableMapOf<String, Int>()
    var items = mutableMapOf<String, Int>()
    list.put("shirts", 50)
    list.put("Pants", 60)
    list.put("shoes", 65)
    list.put("belts", 80)
    list.put("socks", 30)
    println("Shopping Cart list is")
    println(list)
    var choice = 0
    while (choice != 5) {
        println("\nMenu:")
        println("1. Add Item")
        println("2. Remove Item")
        println("3. Calculate Total Price")
        println("4. Apply Discount")
        println("5. Exit")
        print("Enter your choice: ")
        choice = scanner.nextInt()
        scanner.nextLine()
        when (choice) {
            1 -> items=cart.addItem(scanner,list)
            2 -> cart.removeItem(scanner,items)
            3 -> println( cart.calculateTotalPrice())
            4 -> println(cart.applyDiscount(10.0 ,scanner))
            5 -> println("Exiting...")
            else -> println("Invalid choice. Please try again.")
        }
    }

}




