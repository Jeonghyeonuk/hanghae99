public class Test2 {
    public static void main(String[] args) {
        taxi taxi = new taxi(5731);
        taxi.showInfo();
        taxi.take(2);
        taxi.basicFare();
        taxi.drive();
        taxi.chaneSpeed(0, 20);
        taxi.chaneSpeed(20, 0);
        taxi.distance(2000);
        System.out.println("=======================================");

        taxi.take(2);
        taxi.basicFare();
        taxi.drive();
        taxi.chaneSpeed(0, 20);
        taxi.chaneSpeed(20, 0);
        taxi.distance(2000);
        System.out.println("=======================================");

        taxi.take(2);
        taxi.drive();
    }
}

class taxi {
    int taxiNum;
    int passenger;

    int fuel = 20;

    int distance;

    int basicFare = 3000;

    String status = "일반상태";

    public void drive() {
        fuel -= 5;
        if (this.fuel >= 10 && passenger <= 1) {
            this.status = "운행 시작";
            System.out.println("운행 시작");

        } else if (this.fuel < 10) {
            System.out.println("주유량이 부족해 운행을 할 수 없습니다.");

        }
    }
    public taxi(int num) {
        this.taxiNum = num;
    }
    public void take(int passenger) {
        if (this.status.equals("일반상태")) {
            passenger++;
            System.out.println("손님 " + passenger + "명이 탑승했습니다");
        } else if (this.fuel <= 10) {
            System.out.println("탑승 할 수 없는 택시 입니다.");
        }
    }
    public void basicFare() {
        System.out.println("기본요금은 " + basicFare + " 원 이며 기본거리는 500M, 추가요금은 50M당 200원 입니다");
    }
    public void distance(int distance) {
        this.distance = (distance - 500) + ((distance - 500) / 50 * 200);
        System.out.println("목적지에 도착했습니다. 목적지까지 거리는 " + distance + "M이며 총 지불하실 금액은" + this.distance + " 입니다.");
        System.out.println("남은 주유량은 " + fuel + " 입니다.");
    }
    public int chaneSpeed(int x, int y) {
        if (x < y) {
            int result = x + y;
            System.out.println("현재 속도는 " + y + " 입니다");
            return result;
        } else {
            int result = x - y;
            System.out.println("현재 속도는 " + y + " 입니다");
            return result;
        }
    }
    public void showInfo() {
        System.out.println("현재 택시는 " + this.status + " 입니다");
    }
}