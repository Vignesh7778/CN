public class CongestionControl {
    public static void main(String[] args) {

        int cwnd = 1;      // start with 1 MSS
        int ssthresh = 8;  // threshold

        System.out.println("Simulating TCP Congestion Control\n");

        // Slow Start
        while (cwnd < ssthresh) {
            System.out.println("Slow Start: cwnd = " + cwnd);
            cwnd *= 2;
        }

        // Congestion Avoidance
        for (int i = 0; i < 5; i++) {
            System.out.println("Congestion Avoidance: cwnd = " + cwnd);
            cwnd += 1;
        }

        // Simulated packet loss
        System.out.println("\nPacket Loss Detected!");
        ssthresh = cwnd / 2;
        cwnd = 1;

        System.out.println("After Loss → cwnd reset to 1, ssthresh = " + ssthresh);
    }
}
