class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // int consumed = numBottles;
        // int exchange = numBottles / numExchange;
        // int left = numBottles % numExchange;
        // int empty = exchange + left;
        // while (empty / numExchange != 0) {
        //     exchange = numBottles / numExchange;
        //     consumed += exchange;
        //     left = numBottles % numExchange;
        //     empty = exchange + left;
        // }
        // return consumed;

        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
/* 
numBottles  = 15 | exchange = 4

total consumed = exchange = 15 + 3 + 1

1st:
empty = 15
exchange : 15/4 = 3 
left : 15%4 = 3

2nd:
empty = exchange + left = 3 + 3 = 6
exchange = 6/4 = 1
leftEmpty = 6%4 = 2

3rd:
empty = exchange + left = 1 + 2 = 3
exchange = 3/4 = 0 => (exchange < numExchange) -> break
left = 3%4 = 3
*/