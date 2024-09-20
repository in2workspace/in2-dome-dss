package es.in2.dss.api.util;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNullOrBlank(String string) {
        return string == null || string.isBlank();
    }

    public static String ensureUrlHasProtocol(String url) {
        if (url == null) {
            return null;
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            return "https://" + url;
        }
        return url;
    }

}
