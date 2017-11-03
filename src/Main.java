import java.util.*;

public class Main {
    public static void main(String[] args) {
        class passengerTrain {
            int id;
            int passenges;
            int baggage;
            String name;
            public passengerTrain(int ids, int passegess, int baggages, String names) {
                this.id = ids;
                this.passenges = passegess;
                this.baggage = baggages;
                this.name = names;
            }
            public int getId() {
                return this.id;
            }
            public int getPassengers() {
                return this.passenges;
            }
            public int getBaggage() {
                return this.baggage;
            }
            public String getName() {
                return this.name;
            }
        }
        List<passengerTrain> passenger = new ArrayList<>();
        passenger.add(new passengerTrain(1, (int)(Math.random() * 100), (int)(Math.random() * 100), "Локомотив"));
        passenger.add(new passengerTrain(2, (int)(Math.random() * 100), (int)(Math.random() * 100), "Пассажирский вагон"));
        passenger.add(new passengerTrain(3, (int)(Math.random() * 100), (int)(Math.random() * 100), "Пассажирский вагон"));
        passenger.add(new passengerTrain(4, (int)(Math.random() * 100), (int)(Math.random() * 100), "Пассажирский вагон"));
        passenger.add(new passengerTrain(5, (int)(Math.random() * 100), (int)(Math.random() * 100), "Пассажирский вагон"));
        passenger.add(new passengerTrain(6, (int)(Math.random() * 100), (int)(Math.random() * 100), "Пассажирский вагон"));
        passenger.add(new passengerTrain(7, (int)(Math.random() * 100), (int)(Math.random() * 100), "Грузовой вагон"));
        passenger.add(new passengerTrain(8, (int)(Math.random() * 100), (int)(Math.random() * 100), "Грузовой вагон"));
        passenger.add(new passengerTrain(9, (int)(Math.random() * 100), (int)(Math.random() * 100), "Грузовой вагон"));
        passenger.add(new passengerTrain(10, (int)(Math.random() * 100), (int)(Math.random() * 100), "Головной вагон"));
        int passengerCount = 0, baggegesCount = 0;
        for(int i = 0; i < passenger.size(); i++) {
            passengerCount += passenger.get(i).getPassengers();
            baggegesCount += passenger.get(i).getBaggage();
        }
        System.out.println("Общая численность пассажиров в поезде: " + passengerCount);
        System.out.println("Общая численность багажа в поезде: " + baggegesCount);
        Collections.sort(passenger, new Comparator<passengerTrain>() {
            public int compare(passengerTrain o1, passengerTrain o2) {
                return Integer.compare(o1.passenges, o2.passenges);
            }
        });
        System.out.println("Отсортированный вид: ");
        for(int i = 0; i < passenger.size(); i++) {
            System.out.println(passenger.get(i).id + ", " + passenger.get(i).passenges + ", " + passenger.get(i).baggage + ", " + passenger.get(i).name);
        }
        int choice = 1, min, max, result;
        do {
            Scanner s = new Scanner(System.in);
            List<Integer> l = new ArrayList<>();
            System.out.println("Введите свой выбор(1 - поиск по диапозону пассажирова, 2 - поиск по диапозону багажа)");
            if(s.hasNextInt()) {
                choice = s.nextInt();
                try {
                    switch (choice) {
                        case 1:
                            System.out.println("Введите искомый диапозон пассажиров(первое число - минимум, второе - максимум).");
                            try {
                                if(s.hasNextInt()) {
                                    min = s.nextInt();
                                }
                                else {
                                    System.out.println("Должно быть введено число.");
                                    break;
                                }
                                if(s.hasNextInt()) {
                                    max = s.nextInt();
                                }
                                else {
                                    System.out.println("Должно быть введено число.");
                                    break;
                                }
                                for (int i = 0; i < passenger.size(); i++) {
                                    if (passenger.get(i).getPassengers() >= min && passenger.get(i).getPassengers() <= max) {
                                        l.add(i);
                                    }
                                }
                                if (l.size() >= 1) {
                                    System.out.println("Результат поиска: ");
                                    for (int i = 0; i <= l.size(); i++) {
                                        result = l.get(i);
                                        System.out.println("Вагон: " + passenger.get(result).id + "| Пассажиров: " + passenger.get(result).passenges + "| Багажа: "
                                                + passenger.get(result).baggage + "| Наименование: " + passenger.get(result).name);
                                    }
                                } else {
                                    System.out.println("Вагоны с таким диапозоном пассажиров отсутствуют.");
                                }
                            } catch (Exception e) {
                                System.out.println("Ошибка в ходе выполнения программы. Попробуйте снова.");
                            }
                            break;
                        case 2:
                            System.out.println("Введите диапозон багажа(первое число - минимум, второе - максимум).");
                            try {
                                if(s.hasNextInt()) {
                                    min = s.nextInt();
                                }
                                else {
                                    System.out.println("Должно быть введено число.");
                                    break;
                                }
                                if(s.hasNextInt()) {
                                    max = s.nextInt();
                                }
                                else {
                                    System.out.println("Должно быть введено число.");
                                    break;
                                }
                                for (int i = 0; i < passenger.size(); i++) {
                                    if (passenger.get(i).getBaggage() >= min && passenger.get(i).getBaggage() <= max) {
                                        l.add(i);
                                    }
                                }
                                if (l.size() >= 1) {
                                    for (int i = 0; i <= l.size(); i++) {
                                        result = l.get(i);
                                        System.out.println("Вагон: " + passenger.get(result).id + "| Пассажиров: " + passenger.get(result).passenges + "| Багажа: "
                                                + passenger.get(result).baggage + "| Наименование: " + passenger.get(result).name);
                                    }
                                } else {
                                    System.out.println("Вагоны с таким диапозоном багажа отсутствуют.");
                                }
                            } catch (Exception e) {
                                System.out.println("Ошибка в ходе выполнения программы. Попробуйте снова.");
                            }
                            break;
                        default:
                            choice = 4;
                            break;
                    }
                } catch (ArithmeticException e) {
                    System.out.println("Ошибка в ходе выполнения программы. Попробуйте снова.");
                    choice = 3;
                }
            }
            else {
                System.out.println("Должно быть введено число.");
                choice = 3;
            }
            System.out.println("Желаете провести ещё один поиск?");
            if(s.hasNextInt()) {
                choice = s.nextInt();
            }
            else {
                System.out.println("Должно быть введено число.");
            }
        }while(choice > 0 && choice < 4);
    }
}