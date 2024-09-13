
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vodClass",
    "vodUrl"
})
@Data
public class Vod {

    @JsonProperty("vodClass")
    private String vodClass;
    @JsonProperty("vodUrl")
    private String vodUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("vodClass")
    public String getVodClass() {
        return vodClass;
    }

    @JsonProperty("vodClass")
    public void setVodClass(String vodClass) {
        this.vodClass = vodClass;
    }

    @JsonProperty("vodUrl")
    public String getVodUrl() {
        return vodUrl;
    }

    @JsonProperty("vodUrl")
    public void setVodUrl(String vodUrl) {
        this.vodUrl = vodUrl;
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
