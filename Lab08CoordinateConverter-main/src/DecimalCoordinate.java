public class DecimalCoordinate {
    double latitude;
    double longitude;
    
    public DecimalCoordinate() {
        latitude = 0;
        longitude = 0;
    }

    public DecimalCoordinate(String latAndLong) {
        String latStr = latAndLong.substring(0, latAndLong.indexOf(" "));
        String longStr = latAndLong.substring(latAndLong.indexOf(" ")+1);

        double parsedLat = Double.parseDouble(latStr);
        double parsedLong = Double.parseDouble(longStr);

        if ((parsedLat <= 60 && parsedLat >= 0) && (parsedLong <= 60 && parsedLong >= 0)) {
            this.latitude = parsedLat;
            this.longitude = parsedLong;
        }
        else {
            this.latitude = 0;
            this.longitude = 0;
            System.out.println("Values must be between 0 and 60");
        }
        
    }

    public DecimalCoordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        if (latitude <= 60 && latitude >= 0) {
            this.latitude = latitude;
        }
        else {
            this.latitude = 0;
            System.out.println("Latitude must be between 0 and 60");
        }
    }

    public void setLongitude(double longitude) {
        if (longitude <= 60 && longitude >= 0) {
            this.longitude = longitude;
        }
        else {
            this.longitude = 0;
            System.out.println("Longitude must be between 0 and 60");
        }
    }

    public String toString() {
        String str = String.format("%.4f %.4f", latitude, longitude);
        return str;
    }
}
