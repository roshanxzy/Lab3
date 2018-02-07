import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
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
    public static int count(final String url) {
        return urlToString(url).split(" ").length;
    }
    public static int countingWord(String value, String findWord)
    {
        int counter = 0;
        while (value.contains(findWord))
        {
            int index = value.indexOf(findWord);
            value = value.substring(index + findWord.length(), value.length());
            counter++;
        }
        return counter;
    }


    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(count("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(countingWord(urlToString("http://erdani.com/tdpl/hamlet.txt"), "prince"));
    }
}