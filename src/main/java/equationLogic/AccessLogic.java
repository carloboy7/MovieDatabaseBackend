package equationLogic;

import com.google.gson.Gson;
import restServer.request.RequestEquation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccessLogic {

    public static void main(String [ ] args){
        AccessLogic accessLogic = new AccessLogic();
        try {
            accessLogic.UseLogic("test");
        } catch (IOException e) {
            e.printStackTrace();
        }
        RequestEquation requestEquation = new RequestEquation();
        requestEquation.setEquation("test123");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestEquation));
    }

    public String UseLogic(String equation) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "node test.js " + equation);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "init";
        String result = "";
        while (!(line == null)){
            line = r.readLine();
            result = result + line;
            System.out.println(line);
        }
        System.out.println("Result: " + result);
        return result;
    }
}
