package App.model.movers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"GainersList"
})
public class GainersLoosers {

@JsonProperty("GainersList")
private List<GainersList> gainersList = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public GainersLoosers() {
}

/**
* 
* @param gainersList
*/
public GainersLoosers(List<GainersList> gainersList) {
super();
this.gainersList = gainersList;
}

@JsonProperty("GainersList")
public List<GainersList> getGainersList() {
return gainersList;
}

@JsonProperty("GainersList")
public void setGainersList(List<GainersList> gainersList) {
this.gainersList = gainersList;
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