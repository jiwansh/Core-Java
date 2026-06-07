package Exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
Checked exceptions are not compile-time exceptions. 
They occur at runtime, but the compiler checks at compile time whether
 they are properly handled or declared using throws or try catch
 */

public class CompileTIme {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\CODING\\E-Library\\GithubSource.pdf"));
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
        
        catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
