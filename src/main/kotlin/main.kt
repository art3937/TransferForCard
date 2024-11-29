import kotlin.math.max

fun main() {
    val userMoney = 75000
    val card = "Mastercard"
    val amountOfPreviousTransfers = 1000
    val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
    println(result)
}

fun transferMoney(
    card: String = "Мир",
    amountOfPreviousTransfers: Int = 0,
    transferAmount: Int
): Int {
    val limitMouth = 600_000
    val dailyLimit = 150_000
    var commissionSize = 0
    if (transferAmount >= limitMouth + amountOfPreviousTransfers ||
        transferAmount >= dailyLimit
    ) {
        return -1
    } else {
        commissionSize = when (card) {
            "Mastercard" -> toMastercard(transferAmount,amountOfPreviousTransfers)
            "Мир" -> 0
            "Visa" -> max(35, (transferAmount / 100 * 0.75).toInt())
            else -> -1
        }
        return commissionSize
    }
}
fun toMastercard(transferAmount: Int,amountOfPreviousTransfers: Int): Int{
   return when{
       (amountOfPreviousTransfers > 75000) -> (transferAmount / 100 * 0.6 + 20).toInt()
       (amountOfPreviousTransfers < 75000 && amountOfPreviousTransfers + transferAmount > 75000)
           -> ((amountOfPreviousTransfers + transferAmount - 75000)/ 100 * 0.6 + 20).toInt()
       else -> 9999999
   }
}