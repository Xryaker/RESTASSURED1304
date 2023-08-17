package jsonObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Location {
    @JsonProperty("name")
    public String mama;

    @JsonIgnore
    public String url;
}
