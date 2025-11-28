package Strings;

public class ReverseStringRec {
    public static void pro(String s,int index){
        if(index == s.length()){
            return ;
        }
        pro(s,index+1);
        System.out.print(s.charAt(index));
    }
    public static void main(String[] args) {
        String name = "rohit";
        pro(name, 0);
    }
    
}
