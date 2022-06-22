import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
        static final String name = "file777.txt";
        public static void main (String[]args) throws IOException, Two {
            Scanner scan = new Scanner(new File(name));
            ArrayList<Device> devices = new ArrayList<>();

            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                Device device = new Device();
                Scanner lineScanner = new Scanner(line).useDelimiter(",");
                while (lineScanner.hasNext()) {
                    String token = lineScanner.next();
                    if (device.serialNumber == 0) {
                        device.serialNumber = Long.parseLong(token);
                    } else if (device.brand == null) {
                        device.brand = token;
                    } else if (device.model == null) {
                        device.model = token;
                    } else if (device.price == null) {
                        device.price = Integer.parseInt(token);
                        devices.add(device);
                    }
                }
                lineScanner.close();
            }
            System.out.println(devices);
            scan.close();

            System.out.println("Enter number:");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println(devices.toString());
                    break;
                case 2:
                    List<Device> list1 = new LinkedList<>();
                    System.out.println("Enter serial number:");
                    Scanner scanner1 = new Scanner(System.in);
                    long serial_number990 = scanner1.nextLong();
                    for (Device device234 : devices) {
                        if (serial_number990 == device234.serialNumber) {
                            System.out.println(device234);
                            list1.add(device234);

                        }
                    }
                    if (list1.isEmpty() == true) {
                        throw new Two();
                    }
                    break;
                case 3:
                    Stream<Device> stream = devices.stream();
                    stream.sorted(new Comparator<Device>() {
                        @Override
                        public int compare(Device o1, Device o2) {
                            return o1.brand.compareTo(o2.brand);
                        }
                    }).forEach(System.out::println);
                    break;
                case 4:
                    Stream<Device> stream1 = devices.stream();
                    stream1.filter(parametr -> {
                        if (parametr.price > 400) {
                            return true;
                        }
                        return false;
                    }).forEach(System.out::println);
                    break;
                case 5:
                    Stream<Device> stream4 = devices.stream();
                    stream4.filter(parametr1 -> {
                        Pattern pattern = Pattern.compile(".0");
                        String par = String.valueOf(parametr1.serialNumber);
                        Matcher matcher = pattern.matcher(par);

                        if (matcher.find() == true && 800 > parametr1.price) {
                            return true;
                        }
                        return false;
                    }).forEach(System.out::println);
                    break;
                case 6:
                    Stream<Device> stream3 = devices.stream();
                    Optional<Device> first = stream3.sorted(new Comparator<Device>() {
                        @Override
                        public int compare(Device o1, Device o2) {
                            return o2.price.compareTo(o1.price);
                        }
                    }).findFirst();
                    System.out.println(first);
            }
        }
}



class Two extends Exception {

}


class Device{
    long serialNumber;
    String brand;
    String model;
    Integer price;
    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Device{" +
                "serialNumber=" + serialNumber +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}


