# trimString
This repository is for publishing jar file to maven central.
The jar file contains an @TrimString annotation which when used on a string varibale it will remove all white spaces in it.
In order to use this annotation the TrimStringConfig bean must be configured in The configuration file.

-------Example of setting up the bean:-----

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.Trimuchinni.TrimString.TrimStringConfig;

@Configuration
public class AppConfig {
    @Bean
    public static TrimStringConfig trim() {
        return new TrimStringConfig();
    }
}

------Example of using the Annotation--------------

  @TrimString
	public String anyString="Any String with spaces";
// When printing 
System.out.println(anyString)//Output is AnyStringwithspaces
