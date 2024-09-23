
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actorNm",
    "actorEnNm",
    "actorId"
})
@Data
public class Actor {

    @JsonProperty("actorNm")
    private String actorNm;
    @JsonProperty("actorEnNm")
    private String actorEnNm;
    @JsonProperty("actorId")
    private String actorId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("actorNm")
    public String getActorNm() {
        return actorNm;
    }

    @JsonProperty("actorNm")
    public void setActorNm(String actorNm) {
        this.actorNm = actorNm;
    }

    @JsonProperty("actorEnNm")
    public String getActorEnNm() {
        return actorEnNm;
    }

    @JsonProperty("actorEnNm")
    public void setActorEnNm(String actorEnNm) {
        this.actorEnNm = actorEnNm;
    }

    @JsonProperty("actorId")
    public String getActorId() {
        return actorId;
    }

    @JsonProperty("actorId")
    public void setActorId(String actorId) {
        this.actorId = actorId;
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
