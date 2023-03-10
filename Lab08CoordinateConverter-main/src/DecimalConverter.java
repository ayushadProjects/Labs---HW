import java.lang.Math;

public class DecimalConverter implements Converter{

    DecimalCoordinate decimalObj;

    DMSCoordinate convertedObj;
    
    public DecimalConverter() {
        this.decimalObj = new DecimalCoordinate();
    }

    public DecimalConverter(DecimalCoordinate decimalObj) {
        this.decimalObj = decimalObj;
    }

    public DMSCoordinate getConvertedObj() {
        return convertedObj;
    }

    public void convert() {//lat is first
        int degreesLat = (int) Math.floor(decimalObj.getLatitude());
        double minsSeconds = (decimalObj.getLatitude() - Math.floor(decimalObj.getLatitude())) * 60.00;
        int minutesLat = (int) minsSeconds;
        int secondsLat = (int) ((minsSeconds - Math.floor(minsSeconds)) * 60);

        int degreesLong = (int) Math.floor(decimalObj.getLongitude());
        double minsSecondsLong = (decimalObj.getLongitude() - Math.floor(decimalObj.getLongitude())) * 60.00;
        int minutesLong = (int) minsSecondsLong;
        int secondsLong = (int) ((minsSecondsLong - Math.floor(minsSecondsLong)) * 60.00);

        convertedObj = new DMSCoordinate(degreesLat, minutesLat, secondsLat, degreesLong, minutesLong, secondsLong); //This line will also be changed.
    }
}
