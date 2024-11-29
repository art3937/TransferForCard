import org.junit.Test

import org.junit.Assert.*
 class MainKtTest {

@Test
fun toMastercard() {
 assertEquals(26,toMastercard(75000,1000))
}
  @Test
  fun toMastercardNotSale() {
   assertEquals(0,toMastercard(1000,1000))
  }
     @Test
     fun toMastercardMore() {
         assertEquals(toMastercard(100,100000),20)
     }
 }