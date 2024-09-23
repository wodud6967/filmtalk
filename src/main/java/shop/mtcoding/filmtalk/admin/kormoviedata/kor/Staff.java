
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "staffNm",
    "staffEnNm",
    "staffRoleGroup",
    "staffRole",
    "staffEtc",
    "staffId"
})
@Data
public class Staff {

    @JsonProperty("staffNm")
    private String staffNm;
    @JsonProperty("staffEnNm")
    private String staffEnNm;
    @JsonProperty("staffRoleGroup")
    private String staffRoleGroup;
    @JsonProperty("staffRole")
    private String staffRole;
    @JsonProperty("staffEtc")
    private String staffEtc;
    @JsonProperty("staffId")
    private String staffId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("staffNm")
    public String getStaffNm() {
        return staffNm;
    }

    @JsonProperty("staffNm")
    public void setStaffNm(String staffNm) {
        this.staffNm = staffNm;
    }

    @JsonProperty("staffEnNm")
    public String getStaffEnNm() {
        return staffEnNm;
    }

    @JsonProperty("staffEnNm")
    public void setStaffEnNm(String staffEnNm) {
        this.staffEnNm = staffEnNm;
    }

    @JsonProperty("staffRoleGroup")
    public String getStaffRoleGroup() {
        return staffRoleGroup;
    }

    @JsonProperty("staffRoleGroup")
    public void setStaffRoleGroup(String staffRoleGroup) {
        this.staffRoleGroup = staffRoleGroup;
    }

    @JsonProperty("staffRole")
    public String getStaffRole() {
        return staffRole;
    }

    @JsonProperty("staffRole")
    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    @JsonProperty("staffEtc")
    public String getStaffEtc() {
        return staffEtc;
    }

    @JsonProperty("staffEtc")
    public void setStaffEtc(String staffEtc) {
        this.staffEtc = staffEtc;
    }

    @JsonProperty("staffId")
    public String getStaffId() {
        return staffId;
    }

    @JsonProperty("staffId")
    public void setStaffId(String staffId) {
        this.staffId = staffId;
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
