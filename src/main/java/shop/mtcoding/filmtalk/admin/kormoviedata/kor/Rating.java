
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ratingMain",
    "ratingDate",
    "ratingNo",
    "ratingGrade",
    "releaseDate",
    "runtime"
})
@Data
public class Rating {

    @JsonProperty("ratingMain")
    private String ratingMain;
    @JsonProperty("ratingDate")
    private String ratingDate;
    @JsonProperty("ratingNo")
    private String ratingNo;
    @JsonProperty("ratingGrade")
    private String ratingGrade;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("runtime")
    private String runtime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("ratingMain")
    public String getRatingMain() {
        return ratingMain;
    }

    @JsonProperty("ratingMain")
    public void setRatingMain(String ratingMain) {
        this.ratingMain = ratingMain;
    }

    @JsonProperty("ratingDate")
    public String getRatingDate() {
        return ratingDate;
    }

    @JsonProperty("ratingDate")
    public void setRatingDate(String ratingDate) {
        this.ratingDate = ratingDate;
    }

    @JsonProperty("ratingNo")
    public String getRatingNo() {
        return ratingNo;
    }

    @JsonProperty("ratingNo")
    public void setRatingNo(String ratingNo) {
        this.ratingNo = ratingNo;
    }

    @JsonProperty("ratingGrade")
    public String getRatingGrade() {
        return ratingGrade;
    }

    @JsonProperty("ratingGrade")
    public void setRatingGrade(String ratingGrade) {
        this.ratingGrade = ratingGrade;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("runtime")
    public String getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(String runtime) {
        this.runtime = runtime;
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
