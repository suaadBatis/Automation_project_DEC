
package utils;

import Services.Exception;

public class Utils {

        /**
         * @param second
         * Pause the thread
         */
        public static void sleep(long second) {
            try {
                Thread.sleep (second * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }

