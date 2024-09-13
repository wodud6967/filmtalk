
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CollName",
    "TotalCount",
    "Count",
    "Result"
})
@Data
public class Datum {

    @JsonProperty("CollName")
    private String collName;
    @JsonProperty("TotalCount")
    private Integer totalCount;
    @JsonProperty("Count")
    private Integer count;
    @JsonProperty("Result")
    private List<Result> result;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("CollName")
    public String getCollName() {
        return collName;
    }

    @JsonProperty("CollName")
    public void setCollName(String collName) {
        this.collName = collName;
    }

    @JsonProperty("TotalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("TotalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("Count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("Count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("Result")
    public List<Result> getResult() {
        return result;
    }

    @JsonProperty("Result")
    public void setResult(List<Result> result) {
        this.result = result;
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
