package equationLogic;

import com.google.gson.Gson;
import models.LogicResult;
import restServer.request.RequestEquation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class AccessLogic {

    public static void main(String [ ] args){
        AccessLogic accessLogic = new AccessLogic();
        try {
            accessLogic.UseLogic("2+4=0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String UseLogic(String equation) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "node test.js " + equation);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String result = r.readLine();
        return PrepareOutput(result);
    }

    private String PrepareOutput(String result){
        StringBuilder  sb = new StringBuilder(result);
        sb.insert(2, '\"');
        sb.insert(8, '\"');
        int comma = result.indexOf(',');
        sb.insert(comma + 4, '\"');
        sb.insert(comma + 12, '\"');
        return sb.toString().replaceAll("'", "\"");
    }
}
