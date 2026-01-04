package gioi1;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 1_000_000;   // số dư ban đầu
        double minBalance = 50_000;   // số dư tối thiểu

        while (true) {
            try {
                System.out.print("Nhập số tiền muốn rút: ");
                double withdrawAmount = scanner.nextDouble();

                // Kiểm tra số tiền nhập vào
                if (withdrawAmount <= 0) {
                    System.out.println("Lỗi: Số tiền rút phải lớn hơn 0!");
                    continue;
                }

                // Kiểm tra rút quá số dư
                if (withdrawAmount > balance) {
                    System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
                    continue;
                }

                // Kiểm tra số dư tối thiểu
                if (balance - withdrawAmount < minBalance) {
                    System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
                    continue;
                }

                // Rút tiền thành công
                balance -= withdrawAmount;
                System.out.println("Rút tiền thành công!");
                System.out.println("Số tiền đã rút: " + withdrawAmount + " đồng");
                System.out.println("Số dư còn lại: " + balance + " đồng");
                break;

            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                scanner.nextLine(); // xóa dữ liệu nhập sai
            }
        }

        scanner.close();
    }
}
