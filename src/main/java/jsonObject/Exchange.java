package jsonObject;

import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
public class Exchange {
    @JsonProperty("r030")
    public int property;


    public String txt;
    public double rate;
    public String cc;
    public String exchangedate;
}
