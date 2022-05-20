package vip.almaty.servicevisits.dto;

public class AnalyzerModelDto {

    Long anlyzerModelId;
    String analyzerProductNumber;
    Long analyzerTypeId;
    Long manufacturerId;
    String analyzerName;

    public Long getAnlyzerModelId() {
        return anlyzerModelId;
    }
    public void setAnlyzerModelId(Long anlyzerModelId) {
        this.anlyzerModelId = anlyzerModelId;
    }

    public String getAnalyzerProductNumber() {
        return analyzerProductNumber;
    }

    public void setAnalyzerProductNumber(String analyzerProductNumber) {
        this.analyzerProductNumber = analyzerProductNumber;
    }

    public Long getAnalyzerTypeId() {
        return analyzerTypeId;
    }

    public void setAnalyzerTypeId(Long analyzerTypeId) {
        this.analyzerTypeId = analyzerTypeId;
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getAnalyzerName() {
        return analyzerName;
    }

    public void setAnalyzerName(String analyzerName) {
        this.analyzerName = analyzerName;
    }
}
