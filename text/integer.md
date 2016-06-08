Math.signum - float double

java.lang.Integer.signum() method

public static int signum(int i)

public boolean add(E e)

true if exists


java.lang.Character
public static char toLowerCase(char ch)


int ceil = (a - 1) / b + 1;
int floor = a/b

how to check if number is odd
// num % 2 == 1 return incorrect results on negative 
public boolean isOddNumer(int num) {
    return (num & 1) != 0;
}

ASCI
0 - 0 (dec)
a - 97 (dec)
z - 122 (dec)

Usage:

Problem 1: Given a number NN. Flip all bits in its binary representation.

Solution 1: NN^((1<<32)−1)((1<<32)−1) considering NN is 3232 bit integer.

Problem 2: Given two numbers AA and BB. Swap AA and BB without using airthmetic operator and without using third variable.

Solution 2:

AA = AA ^ BB

BB = AA ^ BB

AA = AA ^ BB

number of binary digits floor(log2(N))

To convert decimal NN to binary we can do it as

n = ((N)?floor( log10(N)/log10(2) ) + 1:0); //calculate number of digits in advance floor(log2(N)) + 1
vector <int> bin(n);
i = n-1;
while(N!=0) {
    bin[i]=N%2;
    N/=2;
    i--;
}

To convert binary to decimal

string s = "1011";
n = s.length()
int N = 0;
while (n>0) {
    if (s[s.length()-n]=='1') N += pow(2,n-1);
    n--;
static int maxXor(int l, int r) {
        int xor = l ^ r;
        int a = 0;
        while(Math.pow(2,a)< xor)a++;
        return (int)Math.pow(2,a) - 1 ;
    }
