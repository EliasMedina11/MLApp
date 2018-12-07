
package medina.elias.mlapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rule {

    @SerializedName("default")
    @Expose
    private Boolean _default;
    @SerializedName("free_mode")
    @Expose
    private String freeMode;
    @SerializedName("free_shipping_flag")
    @Expose
    private Boolean freeShippingFlag;
    @SerializedName("value")
    @Expose
    private Object value;

    public Boolean getDefault() {
        return _default;
    }

    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    public String getFreeMode() {
        return freeMode;
    }

    public void setFreeMode(String freeMode) {
        this.freeMode = freeMode;
    }

    public Boolean getFreeShippingFlag() {
        return freeShippingFlag;
    }

    public void setFreeShippingFlag(Boolean freeShippingFlag) {
        this.freeShippingFlag = freeShippingFlag;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
