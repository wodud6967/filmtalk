
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CodeNm",
    "CodeNo"
})
@Data
public class CommCode {

    @JsonProperty("CodeNm")
    private String codeNm;
    @JsonProperty("CodeNo")
    private String codeNo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("CodeNm")
    public String getCodeNm() {
        return codeNm;
    }

    @JsonProperty("CodeNm")
    public void setCodeNm(String codeNm) {
        this.codeNm = codeNm;
    }

    @JsonProperty("CodeNo")
    public String getCodeNo() {
        return codeNo;
    }

    @JsonProperty("CodeNo")
    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
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
