package program;

public enum AirportCity {
    NEW_YORK("John F. Kennedy International Airport"),
    LOS_ANGELES("Los Angeles International Airport"),
    CHICAGO("O'Hare International Airport"),
    LONDON("Heathrow Airport"),
    PARIS("Charles de Gaulle Airport"),
    DUBAI("Dubai International Airport"),
    TOKYO("Narita International Airport"),
    SYDNEY("Sydney Kingsford Smith Airport"),
    SINGAPORE("Changi Airport"),
    HONG_KONG("Hong Kong International Airport"),
    TORONTO("Toronto Pearson International Airport"),
    AMSTERDAM("Amsterdam Schiphol Airport"),
    FRANKFURT("Frankfurt Airport"),
    SEOUL("Incheon International Airport"),
    BEIJING("Beijing Capital International Airport"),
    SHANGHAI("Shanghai Pudong International Airport"),
    MUMBAI("Chhatrapati Shivaji Maharaj International Airport"),
    DELHI("Indira Gandhi International Airport"),
    MOSCOW("Sheremetyevo International Airport"),
    ISTANBUL("Istanbul Airport"),
    SAO_PAULO("São Paulo-Guarulhos International Airport"),
    BANGKOK("Suvarnabhumi Airport"),
    ROME("Leonardo da Vinci–Fiumicino Airport"),
    MADRID("Adolfo Suárez Madrid–Barajas Airport"),
    BARCELONA("Barcelona-El Prat Airport"),
    MIAMI("Miami International Airport"),
    ATLANTA("Hartsfield-Jackson Atlanta International Airport"),
    WASHINGTON_DC("Dulles International Airport"),
    BOSTON("Logan International Airport"),
    SAN_FRANCISCO("San Francisco International Airport"),
    DALLAS("Dallas/Fort Worth International Airport"),
    HOUSTON("George Bush Intercontinental Airport"),
    DENVER("Denver International Airport"),
    PHILADELPHIA("Philadelphia International Airport"),
    LAS_VEGAS("McCarran International Airport"),
    SEATTLE("Seattle-Tacoma International Airport"),
    ORLANDO("Orlando International Airport"),
    DETROIT("Detroit Metropolitan Airport"),
    MINNEAPOLIS("Minneapolis–Saint Paul International Airport"),
    PHOENIX("Phoenix Sky Harbor International Airport"),
    RIO_DE_JANEIRO("Rio de Janeiro–Galeão International Airport"),
    BUENOS_AIRES("Ministro Pistarini International Airport"),
    LIMA("Jorge Chávez International Airport"),
    MEXICO_CITY("Mexico City International Airport"),
    BOGOTA("El Dorado International Airport"),
    SANTIAGO("Comodoro Arturo Merino Benítez International Airport"),
    CARACAS("Simón Bolívar International Airport"),
    MONTEVIDEO("Carrasco International Airport"),
    PANAMA_CITY("Tocumen International Airport"),
    KINGSTON("Norman Manley International Airport"),
    NASSAU("Lynden Pindling International Airport"),
    LAGOS("Murtala Muhammed International Airport"),
    CAIRO("Cairo International Airport"),
    JOHANNESBURG("O.R. Tambo International Airport"),
    CAPE_TOWN("Cape Town International Airport"),
    NAIROBI("Jomo Kenyatta International Airport"),
    ACCRA("Kotoka International Airport"),
    ADDIS_ABABA("Addis Ababa Bole International Airport"),
    ALGIERS("Houari Boumediene Airport"),
    DAKAR("Blaise Diagne International Airport"),
    ABUJA("Nnamdi Azikiwe International Airport"),
    DOHA("Hamad International Airport"),
    KUWAIT_CITY("Kuwait International Airport"),
    RIYADH("King Khalid International Airport"),
    JEDDAH("King Abdulaziz International Airport"),
    MANAMA("Bahrain International Airport"),
    MUSCAT("Muscat International Airport"),
    AMMAN("Queen Alia International Airport"),
    TEHRAN("Tehran Imam Khomeini International Airport"),
    TEL_AVIV("Ben Gurion Airport"),
    BAKU("Heydar Aliyev International Airport"),
    KATHMANDU("Tribhuvan International Airport"),
    DHAKA("Hazrat Shahjalal International Airport"),
    KUALA_LUMPUR("Kuala Lumpur International Airport"),
    MANILA("Ninoy Aquino International Airport"),
    JAKARTA("Soekarno-Hatta International Airport"),
    HO_CHI_MINH_CITY("Tan Son Nhat International Airport"),
    HANOI("Noi Bai International Airport"),
    TAIPEI("Taiwan Taoyuan International Airport"),
    MELBOURNE("Melbourne Airport"),
    BRISBANE("Brisbane Airport"),
    PERTH("Perth Airport"),
    AUCKLAND("Auckland Airport"),
    WELLINGTON("Wellington International Airport"),
    CHRISTCHURCH("Christchurch International Airport"),
    FIJI("Nadi International Airport"),
    PORT_MORESBY("Jacksons International Airport"),
    GUAM("Antonio B. Won Pat International Airport"),
    HONOLULU("Daniel K. Inouye International Airport"),
    ANCHORAGE("Ted Stevens Anchorage International Airport"),
    REYKJAVIK("Keflavik International Airport"),
    OSLO("Oslo Gardermoen Airport"),
    STOCKHOLM("Stockholm Arlanda Airport"),
    COPENHAGEN("Copenhagen Airport"),
    HELSINKI("Helsinki-Vantaa Airport"),
    WARSAW("Warsaw Chopin Airport"),
    PRAGUE("Václav Havel Airport Prague"),
    VIENNA("Vienna International Airport"),
    BUDAPEST("Budapest Ferenc Liszt International Airport"),
    ZURICH("Zurich Airport"),
    GENEVA("Geneva Airport"),
    BRUSSELS("Brussels Airport"),
    DUBLIN("Dublin Airport"),
    EDINBURGH("Edinburgh Airport"),
    MANCHESTER("Manchester Airport"),
    BIRMINGHAM("Birmingham Airport"),
    GLASGOW("Glasgow Airport"),
    LISBON("Lisbon Portela Airport"),
    ATHENS("Athens International Airport"),
    BUCHAREST("Henri Coandă International Airport"),
    SOFIA("Sofia Airport"),
    BELGRADE("Belgrade Nikola Tesla Airport"),
    ZAGREB("Zagreb Airport"),
    LJUBLJANA("Ljubljana Jože Pučnik Airport"),

    // Cities in Pakistan
    KARACHI("Jinnah International Airport"),
    LAHORE("Allama Iqbal International Airport"),
    ISLAMABAD("Islamabad International Airport"),
    PESHAWAR("Bacha Khan International Airport"),
    QUETTA("Quetta International Airport"),
    MULTAN("Multan International Airport"),
    SIALKOT("Sialkot International Airport"),
    FAISALABAD("Faisalabad International Airport"),
    GILGIT("Gilgit Airport"),
    SKARDU("Skardu Airport");

    private final String airportName;

    AirportCity(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportName() {
        return airportName;
    }

}