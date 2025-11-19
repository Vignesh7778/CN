import java.util.*;

public class ArpSim {
    public static void main(String[] args) {
        Map<String,String> table = new HashMap<>();
        table.put("10.0.0.5", "AA:BB:CC:11:22:33");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP: ");
        String ip = sc.nextLine();

        System.out.println(table.getOrDefault(ip, "MAC NOT FOUND"));
    }
}
