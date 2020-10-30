
package bookshop;


public class Carrier {
    
    private Long id;
    private String label;
    private String eMail;
    private Long adrId;
    private String adrLabel;
    private String adrLName;
    private String adrFName;
    private String adrStreet1;
    private String adrStreet2;
    private String adrPostCode;
    private String adrCity;
    private String adrPhone1;
    private String adrPhone2;

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String geteMail() {
        return eMail;
    }

    public Long getAdrId() {
        return adrId;
    }

    public String getAdrLabel() {
        return adrLabel;
    }

    public String getAdrLName() {
        return adrLName;
    }

    public String getAdrFName() {
        return adrFName;
    }

    public String getAdrStreet1() {
        return adrStreet1;
    }

    public String getAdrStreet2() {
        return adrStreet2;
    }

    public String getAdrPostCode() {
        return adrPostCode;
    }

    public String getAdrCity() {
        return adrCity;
    }

    public String getAdrPhone1() {
        return adrPhone1;
    }

    public String getAdrPhone2() {
        return adrPhone2;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setAdrId(Long adrId) {
        this.adrId = adrId;
    }

    public void setAdrLabel(String adrLabel) {
        this.adrLabel = adrLabel;
    }

    public void setAdrLName(String adrLName) {
        this.adrLName = adrLName;
    }

    public void setAdrFName(String adrFName) {
        this.adrFName = adrFName;
    }

    public void setAdrStreet1(String adrStreet1) {
        this.adrStreet1 = adrStreet1;
    }

    public void setAdrStreet2(String adrStreet2) {
        this.adrStreet2 = adrStreet2;
    }

    public void setAdrPostCode(String adrPostCode) {
        this.adrPostCode = adrPostCode;
    }

    public void setAdrCity(String adrCity) {
        this.adrCity = adrCity;
    }

    public void setAdrPhone1(String adrPhone1) {
        this.adrPhone1 = adrPhone1;
    }

    public void setAdrPhone2(String adrPhone2) {
        this.adrPhone2 = adrPhone2;
    }

    public Carrier(Long id, String label, String eMail) {
        this.id = id;
        this.label = label;
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return label;
    }
    
    
    
}
