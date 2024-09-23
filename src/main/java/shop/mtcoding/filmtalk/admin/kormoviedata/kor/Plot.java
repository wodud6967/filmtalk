
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "plotLang",
    "plotText"
})
@Data
public class Plot {

    @JsonProperty("plotLang")
    private String plotLang;
    @JsonProperty("plotText")
    private String plotText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("plotLang")
    public String getPlotLang() {
        return plotLang;
    }

    @JsonProperty("plotLang")
    public void setPlotLang(String plotLang) {
        this.plotLang = plotLang;
    }

    @JsonProperty("plotText")
    public String getPlotText() {
        return plotText;
    }

    @JsonProperty("plotText")
    public void setPlotText(String plotText) {
        this.plotText = plotText;
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
