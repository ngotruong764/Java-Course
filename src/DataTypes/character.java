/**
 * Create 3 char variables to store the character
 *      mySimpleChar should be assigned the literal question-mark character
 *      myUnicodeChar should be assigned the unicode value for the requestion-mark
 *      myDecimalChar should be assigned the decimal value for the question mark
 */
class character{
    public static void main(String[] args){
        char mySimpleChar = '?';
        char myUnicodeChar = '\u003F';
        char myDecimalChar = 63 ;

        System.out.println("Simple Char: "+ mySimpleChar);  
        System.out.println("Unicode Char: "+ myUnicodeChar); 
        System.out.println("Decimal Char: "+ myDecimalChar);       
    }
}