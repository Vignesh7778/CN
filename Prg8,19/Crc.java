public class Crc {
    public static void main(String[] args) {
        String data = "1011001";
        String gen  = "1101";

        char[] d = (data + "000").toCharArray();

        for (int i = 0; i < data.length(); i++)
            if (d[i] == '1')
                for (int j = 0; j < gen.length(); j++)
                    d[i+j] = d[i+j] == gen.charAt(j) ? '0' : '1';

        System.out.println("CRC = " + new String(d).substring(data.length()));
    }
}
