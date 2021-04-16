import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName : PythonRun
 * @Description : 启动python程序
 * @Author : douyonghou
 * @Date: 2021-04-07 20:44
 */
public class PythonRun {
    public static void main(String[] args) {
//        PythonInterpreter interpreter = new PythonInterpreter();
//        String username = "窦永厚";
//        interpreter.execfile("D:/code/weibo-master/src/main/python/getuid.py");

        String[] arguments = new String[] {"python", "src/main/python/getuid.py", "窦永厚" };
        String[] envp = new String[] {"path=D:\\software\\python37"};
        try {
            Process process = Runtime.getRuntime().exec(arguments, envp);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK") );
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
