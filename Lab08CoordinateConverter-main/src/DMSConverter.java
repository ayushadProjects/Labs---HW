public class DMSConverter implements Converter{

    DMSCoordinate DMSObj;

    DecimalCoordinate convertedObj;

    public DMSConverter() {
        this.DMSObj = new DMSCoordinate();
    }

    public DMSConverter(DMSCoordinate DMSObj) {
        this.DMSObj = DMSObj;
    }

    public DMSConverter(String latAndLong) {
        DMSObj = new DMSCoordinate(latAndLong);
    }

    public DecimalCoordinate getConvertedObj() {
        return convertedObj;
    }

    public void convert() {
        double decimalLat = (DMSObj.getDegreesLat()) + 
                            (DMSObj.getMinutesLat() / 60.00) + 
                            (DMSObj.getSecondsLat() / 3600.00);
        double decimalLong = (DMSObj.getDegreesLong()) + 
                            (DMSObj.getMinutesLong() / 60.00) + 
                            (DMSObj.getSecondsLong() / 3600.00);
        convertedObj = new DecimalCoordinate(decimalLat, decimalLong);
    }
}