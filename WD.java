import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//    int numShops = bundleQuantities.size();
//
//    int[] result = new int[n+1];
//        for(int i = 0 ; i < numShops; i++){
//        for(int j = bundleCosts.get(i); j <= n; j++){
//            result[j] = Math.max(result[j], result[j- bundleCosts.get(i)] + bundleQuantities.get(i));
//        }
//    }
//        return result[n];


public class WD {
    /*
     * Complete the function below.
     */

    static String[] getMovieTitles(String substr) {
        // I could have added movie name validation code

        final String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
        // result into the movies arrayList
        List<String> movies = new ArrayList();

        // I will do url verification
        // I will use URI builder to build the url
        //movies/search/?Title=spider&man

        try {
            // first response.
            String response = getResponseURL(url + substr);
            JsonParser parser = new JsonParser();

            JsonElement rootNode = parser.parse(response);

            JsonObject details = rootNode.getAsJsonObject();

            JsonElement totalMovies = details.get("total");

            JsonElement totalPages = details.get("total_pages");

            if(Integer.parseInt(totalPages.toString()) > 0) {
                int curPage = 1;
              JsonElement data = details.get("data");

              JsonArray jsonArray = data.getAsJsonArray();
              for (JsonElement element : jsonArray) {
                  JsonObject titleObject = element.getAsJsonObject();
                  String title = titleObject.get("Title").getAsString();
                  // Adding all movie information to the movie list.
                  movies.add(title);
                }

                while (curPage++ < Integer.parseInt(totalPages.toString())) {
                    // get next responses till the total number of pages.
                    nextPage(movies, curPage, substr);
                }
            }

            // Sorting movie titles.
            Collections.sort(movies);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] result = new String[movies.size()];
        return movies.toArray(result);
    }

    static void nextPage(List<String> movies, int curPage, String substr) throws Exception {
        final String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";

        // appending page num to URL.
        String response = getResponseURL(url + substr + "&page=" + curPage);
        JsonParser parser = new JsonParser();
        JsonElement rootNode = parser.parse(response);

        JsonObject details = rootNode.getAsJsonObject();
        JsonElement data = details.get("data");

        JsonArray jsonArray = data.getAsJsonArray();
        for (JsonElement element : jsonArray) {
            JsonObject titleObject = element.getAsJsonObject();
            String title = titleObject.get("Title").getAsString();
            // Adding all movie information to the movie list.
            movies.add(title);
        }

    }

    static String getResponseURL(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);

        // opening HTTP connection.
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String eachLine;
        while ((eachLine = read.readLine()) != null) {
            // appending each response movie title to result string.
            result.append(eachLine);
        }

        read.close();
        return result.toString();
    }

    public static void main(String[] args){
        String[] result = getMovieTitles("ironman");
        for(String each:result){
            System.out.println(each);
        }
    }


}
