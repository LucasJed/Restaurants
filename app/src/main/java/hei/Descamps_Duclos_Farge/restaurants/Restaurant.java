package hei.Descamps_Duclos_Farge.restaurants;

public class Restaurant {
    private int id;
    private String name;
    private String address;
    private String zip_code;
    private String city;
    private String country;
    private String phone_number;
    private float longitude;
    private float lattitude;
    private String logo;
    private String cover;
    private String description;

    public Restaurant(int _id, String _name,String _address, String _zipCode, String _city,String _country, String _phoneNumber, float _longitude, float _lattitude, String _logo, String _cover, String _description) {
        id = _id;
        name=_name;
        address=_address;
        zip_code=_zipCode;
        city=_city;
        country=_country;
        phone_number=_phoneNumber;
        longitude=_longitude;
        lattitude=_lattitude;
        logo=_logo;
        cover=_cover;
        description=_description;

    }

    public int getId(){
        return id;
    }
    public String getName(){ return name; }
    public String getAddress(){ return address; }
    public String getZip_code(){ return zip_code; }
    public String getCity(){ return city; }
    public String getCountry(){ return country; }
    public String getPhone_number(){ return phone_number; }
    public Float getLongitude(){ return longitude; }
    public Float getLattitude(){ return lattitude; }
    public String getLogo(){ return logo; }
    public String getCover(){ return cover; }
    public String getDescription(){ return description; }



}
