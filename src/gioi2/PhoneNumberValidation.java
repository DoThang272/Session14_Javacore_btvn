package gioi2;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumberValidation {

    // Phương thức kiểm tra số điện thoại
    public static void validatePhoneNumber(String phone)
            throws InvalidPhoneNumberLengthException {

        // Kiểm tra khoảng trắng
        if (phone.contains(" ")) {
            throw new IllegalArgumentException("Không được chứa khoảng trắng");
        }

        // Kiểm tra ký tự không hợp lệ
        if (!phone.matches("\\d+")) {
            throw new IllegalArgumentException("Chứa ký tự không hợp lệ");
        }

        // Kiểm tra độ dài
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Sai độ dài (phải đủ 10 chữ số)");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> validPhones = new ArrayList<>();
        ArrayList<String> invalidPhones = new ArrayList<>();

        System.out.println("Nhập các số điện thoại (ngăn cách bằng dấu phẩy):");
        String input = scanner.nextLine();

        // Tách chuỗi
        String[] phones = input.split(",");

        for (String phone : phones) {
            phone = phone.trim();

            try {
                validatePhoneNumber(phone);
                validPhones.add(phone);
            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhones.add(phone + " : " + e.getMessage());
            } catch (IllegalArgumentException e) {
                invalidPhones.add(phone + " : " + e.getMessage());
            }
        }

        // In kết quả
        System.out.println("\nSố điện thoại hợp lệ:");
        for (String phone : validPhones) {
            System.out.println("- " + phone);
        }

        System.out.println("\nSố điện thoại không hợp lệ:");
        for (String error : invalidPhones) {
            System.out.println("- " + error);
        }

        scanner.close();
    }
}
