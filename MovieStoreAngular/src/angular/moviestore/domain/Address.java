package angular.moviestore.domain;


public class Address {

    private String addressName;
    private String street;
    private String postcode;
    
    /**
     * @return the addressName
     */
    public String getAddressName() {
        return addressName;
    }
    
    /**
     * @param addressName the addressName to set
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
    
    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }
    
    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }
    
    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }
    
    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Address [addressName=" + addressName + ", street=" + street + ", postcode=" + postcode + "]";
    }
    
    
}
