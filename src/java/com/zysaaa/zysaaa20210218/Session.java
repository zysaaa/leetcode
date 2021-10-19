package com.zysaaa.zysaaa20210218;//package zysaaa20210218;
//
//public class Session {
//    private Employers employers;
//    private Employees employees = new Employees();
//
//    public static void main(String[] args) {
//
//        new Session().use();
//    }
//
//    public void use() {
//        Employers employers = new Employers();
//        //Employer employer = new Employer();
//        System.out.println("STP Payroll Management System:");
//        System.out.println("L- Login");
//        System.out.println("X- Exit");
//        System.out.print("Command (L/X): ");
//        char choice = In.nextChar();
//        while (choice != 'x' && choice != 'X') {
//            if (choice == 'l' || choice == 'L') {
//                System.out.print("Email: ");
//                String email = In.nextLine();
//                System.out.print("Password: ");
//                String password = In.nextLine();
//                for (Employer e : employers.getEmployersList()) {
//                    String tempemail = e.getEmail();
//                    String temppassword = e.getPassword();
//                    if (tempemail.equals(email) && temppassword.equals(password)) {
//                        e.Employermenu();
//                    } else {
//                        System.out.println("Incorrect employer details!");
//                    }
//
//                }
//            }
//            System.out.print("Command (L/X): ");
//            choice = In.nextChar();
//
//        }
//        System.out.println("Session Terminated!");
//    }
//}
