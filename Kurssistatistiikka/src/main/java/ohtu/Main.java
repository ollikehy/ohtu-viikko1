package ohtu;

import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "010101001";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText + "\n");

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        System.out.println("Oliot:");
        for (Submission submission : subs) {
            System.out.println(submission);
        }
        int tunnit = 0;
        int tehtavat = 0;
        for (Submission sub : subs) {
            tunnit += sub.getHours();
            tehtavat += sub.getExercises().length;
        }
        System.out.println("Yhteensä: " + tehtavat + " tehtävää, " + tunnit + " tuntia");
    }
}