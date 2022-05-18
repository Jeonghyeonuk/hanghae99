public class Test {
    public static void main(String[] args) {
        Bus bus100 = new Bus(100);

        bus100.leftFuel(); // 남은 주유랑
        bus100.drive(); //
        bus100.maxPassenger();
        System.out.println("===================================================");

        bus100.take(2);
        bus100.drive();
        bus100.chaneSpeed(0, 20);
        System.out.println("주유량을 확인해 주세요");
        bus100.leftFuel();
        System.out.println("===================================================");


        bus100.chaneSpeed(20, 0);
        bus100.drive();
        bus100.take(7);
        bus100.chaneSpeed(0, 30);
        System.out.println("주유량을 확인해 주세요");
        bus100.leftFuel();
        System.out.println("===================================================");

        bus100.chaneSpeed(20, 0);
        bus100.drive();
        bus100.take(7);
        System.out.println("주유량을 확인해 주세요");
        bus100.leftFuel();
        System.out.println("===================================================");
        bus100.status(false);

    }
}

class Bus {
    boolean drive = true;
    int maxPassenger = 10;
    int busNum;
    int fuel = 25;
    int passenger;
    int leftFuel;
    boolean status;
    public Bus(int busNum) {
        this.busNum = busNum;
        System.out.println("이 버스는 " + busNum + "번 버스 입니다.");
    }
    public void leftFuel() {
        leftFuel = fuel;
        if (leftFuel <= 10) {
            System.out.println("남은 주유량은 " + leftFuel + " 입니다, 주유가 필요합니다");
        } else {
            System.out.println("남은 주유량은 " + leftFuel + " 입니다");
        }
    }
    public void drive() {
        if (this.drive) {
            status = true;
            fuel -= 5;
            if (leftFuel <= 10) {
                System.out.println("차고지행입니다");
                status = false;
            } else {
                System.out.println("운행중 입니다");
            }
        } else if (status == false || leftFuel >= 10) {
            this.drive = false;
            System.out.println("차고지행입니다");
        }
    }
    public void status(boolean status) {
        if (!status) {
            this.status = false;
            System.out.println("운행이 종료 되었습니다");
        } else {
            this.status = true;
        }
    }
    public void maxPassenger() {
        System.out.println("이 버스의 최대 탑승 인원은 " + maxPassenger + " 명 입니다");

    }

    public int take(int passenger) {
        if (passenger < 10) {
            this.passenger += passenger;
            if (this.passenger <= 10 && status) {
                System.out.println(this.getBusNum() + " 번 버스에 승객 " + this.getPassenger() + " 명이 탑승중입니다");
            } else if (this.passenger >= 10 && status) {
                System.out.println("최대 탑승 인원을 초과하였습니다.");
                System.out.println("탑승이 불가능 합니다.");
            } else if (!status) {
                passenger = 0;
                System.out.println("차고지행입니다. 탑승이 불가능 합니다.");
            }
        }
        return passenger;
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

    public int getBusNum() {
        return busNum;
    }

    public int getPassenger() {
        return passenger;
    }

}