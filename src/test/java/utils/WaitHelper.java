package utils;

import aquality.selenium.browser.AqualityServices;
import java.util.concurrent.TimeoutException;
import aquality.selenium.core.waitings.IConditionalWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.time.Duration;

public class WaitHelper {

    private static final Logger log = LoggerFactory.getLogger(WaitHelper.class);

    private static final long SMALL_WAIT_TIMEOUT = 2000L;
    private static final IConditionalWait wait = AqualityServices.getConditionalWait();

    public static void smallWait() {
        try {
            log.info("Small wait - {} ms", SMALL_WAIT_TIMEOUT);
            Thread.sleep(SMALL_WAIT_TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean waitForFileDownloaded(String fileName) {
        String downloadDir = AqualityServices.getConfiguration().getBrowserProfile()
                .getDriverSettings().getDownloadDir();
        try {
            wait.waitForTrue(
                    () -> {
                        File[] files = new File(downloadDir).listFiles(f ->
                                f.isFile() &&
                                        f.length() > 0 &&
                                        f.getName().toLowerCase().contains("steam.")
                        );
                        return files != null && files.length > 0;
                    },
                    Duration.ofSeconds(120),
                    Duration.ofMillis(2000),
                    "Waiting for file to be downloaded: " + fileName
            );
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        File[] files = new File(downloadDir).listFiles(f ->
                f.isFile() &&
                        f.length() > 0 &&
                        f.getName().toLowerCase().contains("steam.")
        );
        return files != null && files.length > 0;
    }
}
