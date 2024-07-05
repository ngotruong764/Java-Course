package generic;

public interface Mappable {
    void render();

    static double[] stringToLatLon(String location){
        String[] split = location.split(",");
        double lat = Double.parseDouble(split[0]);
        double lng = Double.parseDouble(split[1]);
        return new double[]{lat, lng};
    }
}
