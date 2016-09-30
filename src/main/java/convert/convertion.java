
package convert;

import entity.person;
import com.google.gson.Gson;

public class convertion {
    public static void main(String[] args) {
        String json = "{\"firstName\":\"Ole\",\"lastName\":\"Olsen\",\"phoneNumber\":12345678}";
        person p1 = new Gson().fromJson(json, person.class);
//        System.out.println(p1.firstName);
    }
}
