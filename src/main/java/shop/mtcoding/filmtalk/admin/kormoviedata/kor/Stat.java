
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "screenArea",
    "screenCnt",
    "salesAcc",
    "audiAcc",
    "statSouce",
    "statDate"
})
@Data
public class Stat {

    @JsonProperty("screenArea")
    private String screenArea;
    @JsonProperty("screenCnt")
    private String screenCnt;
    @JsonProperty("salesAcc")
    private String salesAcc;
    @JsonProperty("audiAcc")
    private String audiAcc;
    @JsonProperty("statSouce")
    private String statSouce;
    @JsonProperty("statDate")
    private String statDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("screenArea")
    public String getScreenArea() {
        return screenArea;
    }

    @JsonProperty("screenArea")
    public void setScreenArea(String screenArea) {
        this.screenArea = screenArea;
    }

    @JsonProperty("screenCnt")
    public String getScreenCnt() {
        return screenCnt;
    }

    @JsonProperty("screenCnt")
    public void setScreenCnt(String screenCnt) {
        this.screenCnt = screenCnt;
    }

    @JsonProperty("salesAcc")
    public String getSalesAcc() {
        return salesAcc;
    }

    @JsonProperty("salesAcc")
    public void setSalesAcc(String salesAcc) {
        this.salesAcc = salesAcc;
    }

    @JsonProperty("audiAcc")
    public String getAudiAcc() {
        return audiAcc;
    }

    @JsonProperty("audiAcc")
    public void setAudiAcc(String audiAcc) {
        this.audiAcc = audiAcc;
    }

    @JsonProperty("statSouce")
    public String getStatSouce() {
        return statSouce;
    }

    @JsonProperty("statSouce")
    public void setStatSouce(String statSouce) {
        this.statSouce = statSouce;
    }

    @JsonProperty("statDate")
    public String getStatDate() {
        return statDate;
    }

    @JsonProperty("statDate")
    public void setStatDate(String statDate) {
        this.statDate = statDate;
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
