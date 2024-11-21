import kotlin.test.Test
import kotlin.test.assertEquals

class MainKtTest {

@Test
 fun transferMoney() {
  assertEquals(75,transferMoney("Мир",1000,10000))
 }
}