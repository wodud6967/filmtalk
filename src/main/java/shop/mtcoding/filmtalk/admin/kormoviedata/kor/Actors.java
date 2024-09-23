
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actor"
})
@Data
public class Actors {

    @JsonProperty("actor")
    private List<Actor> actor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("actor")
    public List<Actor> getActor() {
        return actor;
    }

    @JsonProperty("actor")
    public void setActor(List<Actor> actor) {
        this.actor = actor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
