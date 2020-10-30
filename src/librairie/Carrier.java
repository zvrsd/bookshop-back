/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librairie;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author cda611
 */
public class Carrier implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long carrierId;
    private String carrierCorporateName;
    private String carrierEmail;
    private Address addressId;
    private Collection<ShippingOffer> shippingOfferCollection;

    public Carrier() {
    }

    public Carrier(Long carrierId) {
        this.carrierId = carrierId;
    }

    public Carrier(Long carrierId, String carrierCorporateName, String carrierEmail) {
        this.carrierId = carrierId;
        this.carrierCorporateName = carrierCorporateName;
        this.carrierEmail = carrierEmail;
    }

    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierCorporateName() {
        return carrierCorporateName;
    }

    public void setCarrierCorporateName(String carrierCorporateName) {
        this.carrierCorporateName = carrierCorporateName;
    }

    public String getCarrierEmail() {
        return carrierEmail;
    }

    public void setCarrierEmail(String carrierEmail) {
        this.carrierEmail = carrierEmail;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Collection<ShippingOffer> getShippingOfferCollection() {
        return shippingOfferCollection;
    }

    public void setShippingOfferCollection(Collection<ShippingOffer> shippingOfferCollection) {
        this.shippingOfferCollection = shippingOfferCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carrierId != null ? carrierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrier)) {
            return false;
        }
        Carrier other = (Carrier) object;
        if ((this.carrierId == null && other.carrierId != null) || (this.carrierId != null && !this.carrierId.equals(other.carrierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "librairie.Carrier[ carrierId=" + carrierId + " ]";
    }
    
}
