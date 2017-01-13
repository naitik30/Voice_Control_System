/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speachtotext;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Naitik
 */
public class ProgramControl {
    public void stratProgram(String program) throws URISyntaxException, IOException
    {
        
        String comd= "cmd /c start "+program;
//        System.out.println(comd);
        if(program.equals("explorer")){
            Desktop desktop = java.awt.Desktop.getDesktop();
          URI oURL = new URI("http://www.google.com");
            desktop.browse(oURL);
            return;
        }
        
//        winword
        try {
                Process p;
                p = Runtime.getRuntime().exec(comd);
            } catch (Exception ae) {
            }
    }
    public void exitProgram(String program)
    {
        String comd= "cmd /c start taskkill /im "+program +".exe /f";
        System.out.println(program);
        try {
                Process p;
                if(checkProgrunning(program))
                {
                    p = Runtime.getRuntime().exec(comd);
                }
                else
                {
                    System.out.println("Program is not running");
                }
            } catch (Exception ae) {
            }
    }
    
    public boolean checkProgrunning(String program)
    {
        String cmd= System.getenv("windir") +"\\system32\\"+"tasklist.exe";
        System.out.println(program);
        try{
            Process p;
            p =Runtime.getRuntime().exec(cmd);
            BufferedReader data = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            String tasklist = null;
            while((line = data.readLine()) != null)
            {
                tasklist+=line;
            }
            data.close();
            System.out.println(tasklist);
            
            if(tasklist.contains(program))
            {
                System.out.println(program);
                return true;
            }
            else
            {
                return  true;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
