
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Query",
    "KMAQuery",
    "TotalCount",
    "Data"
})
@Data
public class KorMovies {

    @JsonProperty("Query")
    private String query;
    @JsonProperty("KMAQuery")
    private String kMAQuery;
    @JsonProperty("TotalCount")
    private Integer totalCount;
    @JsonProperty("Data")
    private List<Datum> data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("Query")
    public void setQuery(String query) {
        this.query = query;
    }

    @JsonProperty("KMAQuery")
    public String getKMAQuery() {
        return kMAQuery;
    }

    @JsonProperty("KMAQuery")
    public void setKMAQuery(String kMAQuery) {
        this.kMAQuery = kMAQuery;
    }

    @JsonProperty("TotalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("TotalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("Data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(List<Datum> data) {
        this.data = data;
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
