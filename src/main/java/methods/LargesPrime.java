package methods;

public class LargesPrime {
    public static void main(String[] args) {
        System.out.println("Largest prime divisor for 21 is " + LargesPrime.getLargestPrime(21));
    }
    public static int getLargestPrime (int number){
int checkNumber = number;
int checkPrime;

if (checkNumber < 0) return -1;

while (checkNumber > 0) {
    if (number % checkNumber ==0) {
checkPrime = 2;
while (checkPrime <= checkNumber) {
    if (checkNumber % checkPrime ==0) break;
checkPrime++;
}
if(checkPrime == checkNumber)
    return  checkNumber;
    }
    checkNumber --;

}
        return -1;
    }
}
