package generic;

public class River extends Line{
    private String name;

    public River(String name, String... location){
        super(location);
        this.name = name;
    }

    @Override
    public String toString(){
        return name + "River";
    }
}
