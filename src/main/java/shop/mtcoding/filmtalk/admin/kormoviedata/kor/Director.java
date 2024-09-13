
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "directorNm",
    "directorEnNm",
    "directorId"
})
@Data
public class Director {

    @JsonProperty("directorNm")
    private String directorNm;
    @JsonProperty("directorEnNm")
    private String directorEnNm;
    @JsonProperty("directorId")
    private String directorId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("directorNm")
    public String getDirectorNm() {
        return directorNm;
    }

    @JsonProperty("directorNm")
    public void setDirectorNm(String directorNm) {
        this.directorNm = directorNm;
    }

    @JsonProperty("directorEnNm")
    public String getDirectorEnNm() {
        return directorEnNm;
    }

    @JsonProperty("directorEnNm")
    public void setDirectorEnNm(String directorEnNm) {
        this.directorEnNm = directorEnNm;
    }

    @JsonProperty("directorId")
    public String getDirectorId() {
        return directorId;
    }

    @JsonProperty("directorId")
    public void setDirectorId(String directorId) {
        this.directorId = directorId;
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
