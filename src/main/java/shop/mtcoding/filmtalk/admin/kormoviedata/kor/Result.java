
package shop.mtcoding.filmtalk.admin.kormoviedata.kor;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DOCID",
    "movieId",
    "movieSeq",
    "title",
    "titleEng",
    "titleOrg",
    "titleEtc",
    "prodYear",
    "directors",
    "actors",
    "nation",
    "company",
    "plots",
    "runtime",
    "rating",
    "genre",
    "kmdbUrl",
    "type",
    "use",
    "episodes",
    "ratedYn",
    "repRatDate",
    "repRlsDate",
    "ratings",
    "keywords",
    "posters",
    "stlls",
    "staffs",
    "vods",
    "openThtr",
    "stat",
    "screenArea",
    "screenCnt",
    "salesAcc",
    "audiAcc",
    "statSouce",
    "statDate",
    "themeSong",
    "soundtrack",
    "fLocation",
    "Awards1",
    "Awards2",
    "regDate",
    "modDate",
    "Codes",
    "CommCodes",
    "ALIAS"
})
@Data
public class Result {

    @JsonProperty("DOCID")
    private String docid;
    @JsonProperty("movieId")
    private String movieId;
    @JsonProperty("movieSeq")
    private String movieSeq;
    @JsonProperty("title")
    private String title;
    @JsonProperty("titleEng")
    private String titleEng;
    @JsonProperty("titleOrg")
    private String titleOrg;
    @JsonProperty("titleEtc")
    private String titleEtc;
    @JsonProperty("prodYear")
    private String prodYear;
    @JsonProperty("directors")
    private Directors directors;
    @JsonProperty("actors")
    private Actors actors;
    @JsonProperty("nation")
    private String nation;
    @JsonProperty("company")
    private String company;
    @JsonProperty("plots")
    private Plots plots;
    @JsonProperty("runtime")
    private String runtime;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("kmdbUrl")
    private String kmdbUrl;
    @JsonProperty("type")
    private String type;
    @JsonProperty("use")
    private String use;
    @JsonProperty("episodes")
    private String episodes;
    @JsonProperty("ratedYn")
    private String ratedYn;
    @JsonProperty("repRatDate")
    private String repRatDate;
    @JsonProperty("repRlsDate")
    private String repRlsDate;
    @JsonProperty("ratings")
    private Ratings ratings;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("posters")
    private String posters;
    @JsonProperty("stlls")
    private String stlls;
    @JsonProperty("staffs")
    private Staffs staffs;
    @JsonProperty("vods")
    private Vods vods;
    @JsonProperty("openThtr")
    private String openThtr;
    @JsonProperty("stat")
    private List<Stat> stat;
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
    @JsonProperty("themeSong")
    private String themeSong;
    @JsonProperty("soundtrack")
    private String soundtrack;
    @JsonProperty("fLocation")
    private String fLocation;
    @JsonProperty("Awards1")
    private String awards1;
    @JsonProperty("Awards2")
    private String awards2;
    @JsonProperty("regDate")
    private String regDate;
    @JsonProperty("modDate")
    private String modDate;
    @JsonProperty("Codes")
    private Codes codes;
    @JsonProperty("CommCodes")
    private CommCodes commCodes;
    @JsonProperty("ALIAS")
    private String alias;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("DOCID")
    public String getDocid() {
        return docid;
    }

    @JsonProperty("DOCID")
    public void setDocid(String docid) {
        this.docid = docid;
    }

    @JsonProperty("movieId")
    public String getMovieId() {
        return movieId;
    }

    @JsonProperty("movieId")
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    @JsonProperty("movieSeq")
    public String getMovieSeq() {
        return movieSeq;
    }

    @JsonProperty("movieSeq")
    public void setMovieSeq(String movieSeq) {
        this.movieSeq = movieSeq;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("titleEng")
    public String getTitleEng() {
        return titleEng;
    }

    @JsonProperty("titleEng")
    public void setTitleEng(String titleEng) {
        this.titleEng = titleEng;
    }

    @JsonProperty("titleOrg")
    public String getTitleOrg() {
        return titleOrg;
    }

    @JsonProperty("titleOrg")
    public void setTitleOrg(String titleOrg) {
        this.titleOrg = titleOrg;
    }

    @JsonProperty("titleEtc")
    public String getTitleEtc() {
        return titleEtc;
    }

    @JsonProperty("titleEtc")
    public void setTitleEtc(String titleEtc) {
        this.titleEtc = titleEtc;
    }

    @JsonProperty("prodYear")
    public String getProdYear() {
        return prodYear;
    }

    @JsonProperty("prodYear")
    public void setProdYear(String prodYear) {
        this.prodYear = prodYear;
    }

    @JsonProperty("directors")
    public Directors getDirectors() {
        return directors;
    }

    @JsonProperty("directors")
    public void setDirectors(Directors directors) {
        this.directors = directors;
    }

    @JsonProperty("actors")
    public Actors getActors() {
        return actors;
    }

    @JsonProperty("actors")
    public void setActors(Actors actors) {
        this.actors = actors;
    }

    @JsonProperty("nation")
    public String getNation() {
        return nation;
    }

    @JsonProperty("nation")
    public void setNation(String nation) {
        this.nation = nation;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @JsonProperty("plots")
    public Plots getPlots() {
        return plots;
    }

    @JsonProperty("plots")
    public void setPlots(Plots plots) {
        this.plots = plots;
    }

    @JsonProperty("runtime")
    public String getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("rating")
    public String getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonProperty("kmdbUrl")
    public String getKmdbUrl() {
        return kmdbUrl;
    }

    @JsonProperty("kmdbUrl")
    public void setKmdbUrl(String kmdbUrl) {
        this.kmdbUrl = kmdbUrl;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("use")
    public String getUse() {
        return use;
    }

    @JsonProperty("use")
    public void setUse(String use) {
        this.use = use;
    }

    @JsonProperty("episodes")
    public String getEpisodes() {
        return episodes;
    }

    @JsonProperty("episodes")
    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    @JsonProperty("ratedYn")
    public String getRatedYn() {
        return ratedYn;
    }

    @JsonProperty("ratedYn")
    public void setRatedYn(String ratedYn) {
        this.ratedYn = ratedYn;
    }

    @JsonProperty("repRatDate")
    public String getRepRatDate() {
        return repRatDate;
    }

    @JsonProperty("repRatDate")
    public void setRepRatDate(String repRatDate) {
        this.repRatDate = repRatDate;
    }

    @JsonProperty("repRlsDate")
    public String getRepRlsDate() {
        return repRlsDate;
    }

    @JsonProperty("repRlsDate")
    public void setRepRlsDate(String repRlsDate) {
        this.repRlsDate = repRlsDate;
    }

    @JsonProperty("ratings")
    public Ratings getRatings() {
        return ratings;
    }

    @JsonProperty("ratings")
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    @JsonProperty("keywords")
    public String getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("posters")
    public String getPosters() {
        return posters;
    }

    @JsonProperty("posters")
    public void setPosters(String posters) {
        this.posters = posters;
    }

    @JsonProperty("stlls")
    public String getStlls() {
        return stlls;
    }

    @JsonProperty("stlls")
    public void setStlls(String stlls) {
        this.stlls = stlls;
    }

    @JsonProperty("staffs")
    public Staffs getStaffs() {
        return staffs;
    }

    @JsonProperty("staffs")
    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    @JsonProperty("vods")
    public Vods getVods() {
        return vods;
    }

    @JsonProperty("vods")
    public void setVods(Vods vods) {
        this.vods = vods;
    }

    @JsonProperty("openThtr")
    public String getOpenThtr() {
        return openThtr;
    }

    @JsonProperty("openThtr")
    public void setOpenThtr(String openThtr) {
        this.openThtr = openThtr;
    }

    @JsonProperty("stat")
    public List<Stat> getStat() {
        return stat;
    }

    @JsonProperty("stat")
    public void setStat(List<Stat> stat) {
        this.stat = stat;
    }

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

    @JsonProperty("themeSong")
    public String getThemeSong() {
        return themeSong;
    }

    @JsonProperty("themeSong")
    public void setThemeSong(String themeSong) {
        this.themeSong = themeSong;
    }

    @JsonProperty("soundtrack")
    public String getSoundtrack() {
        return soundtrack;
    }

    @JsonProperty("soundtrack")
    public void setSoundtrack(String soundtrack) {
        this.soundtrack = soundtrack;
    }

    @JsonProperty("fLocation")
    public String getfLocation() {
        return fLocation;
    }

    @JsonProperty("fLocation")
    public void setfLocation(String fLocation) {
        this.fLocation = fLocation;
    }

    @JsonProperty("Awards1")
    public String getAwards1() {
        return awards1;
    }

    @JsonProperty("Awards1")
    public void setAwards1(String awards1) {
        this.awards1 = awards1;
    }

    @JsonProperty("Awards2")
    public String getAwards2() {
        return awards2;
    }

    @JsonProperty("Awards2")
    public void setAwards2(String awards2) {
        this.awards2 = awards2;
    }

    @JsonProperty("regDate")
    public String getRegDate() {
        return regDate;
    }

    @JsonProperty("regDate")
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @JsonProperty("modDate")
    public String getModDate() {
        return modDate;
    }

    @JsonProperty("modDate")
    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    @JsonProperty("Codes")
    public Codes getCodes() {
        return codes;
    }

    @JsonProperty("Codes")
    public void setCodes(Codes codes) {
        this.codes = codes;
    }

    @JsonProperty("CommCodes")
    public CommCodes getCommCodes() {
        return commCodes;
    }

    @JsonProperty("CommCodes")
    public void setCommCodes(CommCodes commCodes) {
        this.commCodes = commCodes;
    }

    @JsonProperty("ALIAS")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("ALIAS")
    public void setAlias(String alias) {
        this.alias = alias;
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
