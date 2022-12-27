import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Author: ssw
 * @DateTime: 2022/2/17 23:53
 * @Description: TODO
 */
public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    public static void info(String msg){
        System.out.println(logger.getClass());
        logger.info(msg);
    }
}

