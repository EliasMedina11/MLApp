
package medina.elias.mlapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variation {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("price")
    @Expose
    private float price;
    @SerializedName("attribute_combinations")
    @Expose
    private List<AttributeCombination> attributeCombinations = null;
    @SerializedName("available_quantity")
    @Expose
    private Integer availableQuantity;
    @SerializedName("sold_quantity")
    @Expose
    private Integer soldQuantity;
    @SerializedName("sale_terms")
    @Expose
    private List<Object> saleTerms = null;
    @SerializedName("picture_ids")
    @Expose
    private List<String> pictureIds = null;
    @SerializedName("seller_custom_field")
    @Expose
    private Object sellerCustomField;
    @SerializedName("catalog_product_id")
    @Expose
    private String catalogProductId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<AttributeCombination> getAttributeCombinations() {
        return attributeCombinations;
    }

    public void setAttributeCombinations(List<AttributeCombination> attributeCombinations) {
        this.attributeCombinations = attributeCombinations;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public List<Object> getSaleTerms() {
        return saleTerms;
    }

    public void setSaleTerms(List<Object> saleTerms) {
        this.saleTerms = saleTerms;
    }

    public List<String> getPictureIds() {
        return pictureIds;
    }

    public void setPictureIds(List<String> pictureIds) {
        this.pictureIds = pictureIds;
    }

    public Object getSellerCustomField() {
        return sellerCustomField;
    }

    public void setSellerCustomField(Object sellerCustomField) {
        this.sellerCustomField = sellerCustomField;
    }

    public String getCatalogProductId() {
        return catalogProductId;
    }

    public void setCatalogProductId(String catalogProductId) {
        this.catalogProductId = catalogProductId;
    }

}
