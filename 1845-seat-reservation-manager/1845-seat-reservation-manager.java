class SeatManager {

    int numSeats;
    HashMap<Integer, Boolean> map;
    PriorityQueue<Integer> minUnreserve;
    
    public SeatManager(int n) {
        this.numSeats = n;
        map = new HashMap<>();
        minUnreserve = new PriorityQueue<>();
        
        for(int i=1; i<=n; i++) {
            map.put(i, false);
            minUnreserve.add(i);
        }
    }
    
    public int reserve() {
        int seatNum = minUnreserve.poll();
        map.put(seatNum, true);
        return seatNum;
    }
    
    public void unreserve(int seatNumber) {
        map.put(seatNumber, false);
        minUnreserve.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */