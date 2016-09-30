package Rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.person;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("quote")
public class PersonResource {

    facade.Facade fp;
    entity.person EP;

    @Context
    private UriInfo context;
    private static Map<Integer, String> quotes = new HashMap() {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Hello, my name is Yunas Mohamed");
            put(3, "Behind every great man, is a woman rolling her eyes");
            put(4, "This education is very complicated");
        }
    };

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getPerson(@PathParam("id") int id, @QueryParam("text") String text) {
        System.out.println("getPersons" + id);
        System.out.println(text);
        System.out.println(context.getQueryParameters().get("id"));
        return quotes.getOrDefault(id, text);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public String getRandomPerson() {
        Random r = new Random();
        Object[] values = quotes.values().toArray();
        Object randomValue = values[r.nextInt(values.length)];
        return randomValue.toString();
    }

    @POST
    @Path("Path")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public String postPerson(String content) {
        System.out.println("postPerson");

        fp.addPerson(new Gson().fromJson(content, person.class));

        return "{\"success\":true}";

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putPerson(String content) {
        System.out.println("putPerson");

        System.out.println(content);
        JsonObject jo = new JsonParser().parse(content).getAsJsonObject();
        System.out.println(jo.has("fName"));
        System.out.println(jo.has("firstName"));
        System.out.println(jo.get("firstName").getAsString());
        System.out.println(jo.get("id").getAsInt());

        return "{\"success\":true}";
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("alle")
    public String deletePerson() {
        System.out.println("deletePerson");
        return "{\"success\":true}";
    }

}
