import kotlin.math.max
fun main() {
    val userMoney = 10000
    val card = "Visa"
    val amountOfPreviousTransfers = 1000
    val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
    println(result)
}
fun transferMoney(
    card: String,
    amountOfPreviousTransfers: Int,
    transferAmount: Int
): Int {
    val limitMouth = 600_000
    val dailyLimit = 150_000
    var commissionSize = 0
    if (limitMouth === transferAmount + amountOfPreviousTransfers ||
        dailyLimit === transferAmount + amountOfPreviousTransfers
    ) {
        return -1
    } else {
        when (card) {
            "Mastercard" -> commissionSize = if (transferAmount > 75000)
                ((transferAmount - 75000) / 100 * 0.6 + 20).toInt() else 0

            "Мир" -> commissionSize = 0
            "Visa" -> commissionSize = max(35, (transferAmount / 100 * 0.75).toInt())
            else -> commissionSize = -1
        }
        return commissionSize
    }
}