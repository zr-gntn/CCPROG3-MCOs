/* HotelReservationSystem (HRS) Class
 * An object that handles the reservation system.
 * 
 * @params:
 *  - hotel : List<Hotel> : the list of hotels in the system
 */

import java.util.*;

public class HRS {
    // Variables
    private List<Hotel> hotels;

    // Constructor
    public HRS() {
        this.hotels = new ArrayList<>();
    }

    // Setters
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    // Getters
    public List<Hotel> getHotels() {
        return this.hotels;
    }

    // Methods
    /* createHotel
     * creates a new hotel with a given name
     * 
     * @params:
     *  - name : String : the name of the new hotel
     * 
     * @returns: 
     *  - none
     * 
     * @fixme:
     *  - add a way to check if the name is unique or not
     * 
     * @author: Zhean Ganituen
     */
    public void createHotel(String name) {
        Hotel hotel = new Hotel(name);
        hotels.add(hotel);
    }

    /* fetchHotel
     * returnss the hotel given the name of the hotel
     * 
     * @params:
     *  - name : String : name of the hotel
     * 
     * @returns:
     *  - room : Hotel : the hotel with the room name in the hotel
     *  - null : null  : the hotel was not found
     * 
     * @author: Zhean Ganituen
     */
    public Hotel fetchHotel(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }

        return null;
    }

    public void createHotelUI(Scanner sc) {
        System.out.print("Enter the name of the hotel: ");
        String hotelName = sc.nextLine();

        createHotel(hotelName);
    }

    public void viewHotelUI(Scanner sc){
        System.out.print("Enter the name of the hotel: ");
        String hotelName = sc.nextLine();
        Hotel hotel = fetchHotel(hotelName);
        if (hotel != null){
            hotel.viewHotel(sc);
        } else{
            System.out.printf("Hotel '%s' is not found.\n", hotelName);
        }
    }

    public void showMenu(){
        System.out.println("1. Create Hotel");
        System.out.println("2. View Hotel");
        System.out.println("3. Manage Hotel");
        System.out.println("4. Simulate Booking");
        System.out.println("5. Exit");
    }
}
