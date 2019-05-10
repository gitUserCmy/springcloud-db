import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }*/

    public static void main(String[] args){
        String string = "adc汉字";
        String s = "";
        if(s.isEmpty()){
            System.out.println(22);
        }
        for (int i=0;i<string.length();i++){
            char ch = string.charAt(i);
            System.out.println(ch);
        }
        char c = 'a';
        if(c == 'b'){
            System.out.println("a");
        }else if(c == 'd'){
            System.out.println("a");
        }
    }
}
