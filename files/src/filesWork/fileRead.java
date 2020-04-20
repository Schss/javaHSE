package filesWork;
import java.io.*;

public class fileRead {
    String buffer = "";
    InputStream file;

    public  fileRead(String fileName) throws IOException {
        try{
            this.file = new FileInputStream(fileName);
        }catch (FileNotFoundException ex) {
            System.out.println("Oops, FileNotFoundException caught");
        }

        int i = -1;
        assert this.file != null;
        while ((i = (this.file).read()) != -1) {
            buffer = String.format("%s%s", buffer, (char) i);
        }
        file.close();
    }

    private void RegIgnore(){
        char[] chars = buffer.toCharArray();
        int i;
        int j;
        char symbol;
        for (i = 0; i < 26; i++){
            symbol = (char) ('A'+i);
            for(j = 0; j<chars.length; j++){
                if(chars[j]==symbol){
                    chars[j] = (char) ('a'+i);
                }
            }
        }
        buffer = new String(chars);
    }

    public int[] QuantitySymb(){
        RegIgnore();
        char i;
        int k;
        char[] chars = buffer.toCharArray();
        int[] quantity = new int[26];
        char symbol;
        int j;
        for (i = 0; i < 26; i++){
            symbol = (char) ('a'+i);
            k = 0;
            for(j = 0; j<chars.length; j++){
                if(chars[j]==symbol){
                    k = k+1;
                }
            }
            quantity[i] = k;
        }
        return quantity;
    }

    public void OutputFile(int[] quantity) throws IOException {
        OutputStream output = new FileOutputStream("output.txt");
        int j;
        for(int i = 0; i < quantity.length; i++) {
            if(quantity[i]!=0) {
                output.write((char) ('a' + i));
                output.write(' ');
                output.write('-');
                String s = Integer.toString(quantity[i]);
                char[] mas = s.toCharArray();
                for(j = 0; j<mas.length; j++){
                    output.write(mas[j]);
                }
                output.write('\n');
            }
        }
        output.close();
    }

}
