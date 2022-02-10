import java.io.*;

public class I_O输出输入流 {
    public static void main(String[] args) {
        try{
            //这条语句必须在catch里面写未找到文件异常
            FileOutputStream out = new FileOutputStream("Newtext.txt");
            OutputStreamWriter writer = new OutputStreamWriter(out);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("1,张三,男");
            bw.newLine();
            bw.write("1,张三,男");
            bw.newLine();
            bw.write("1,张三,男");
            bw.newLine();
            bw.write("1,张三,男");
            bw.flush();//清空一下缓存
            bw.close();//
            BufferedReader
                    Red = (new BufferedReader(new InputStreamReader(new FileInputStream("Newtext.txt"))));
            
        }catch(FileNotFoundException e){

        }catch (IOException e) {

        }

    }

}
