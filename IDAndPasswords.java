import java.util.HashMap;

public class IDAndPasswords {
           HashMap<String,String> loginInfo= new HashMap<>();
    public IDAndPasswords() {
        loginInfo.put("User1","UserPassword1");
        loginInfo.put("User2","UserPassword2");
        loginInfo.put("User3","UserPassword3");
        loginInfo.put("User4","UserPassword4");
    }
    public HashMap getLoginInfo(){
           return loginInfo;
    }
}
