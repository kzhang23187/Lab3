import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScrapper {
    public static void main(String [] unused) {
        System.out.println("Ran");
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(count(urlToString("http://erdani.com/tdpl/hamlet.txt")));

    }


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int count(String passage) {
        int count = 0;
        for (int i = 0; i < passage.length(); i++) {
            if((passage.charAt(i) + "").equals(" ") && !(passage.charAt(i - 1) + "").equals(" ")) {
                count++;

            }
        }
        return count;
    }

}
