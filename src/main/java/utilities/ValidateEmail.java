package utilities;

public class ValidateEmail {

    public boolean isEmailValid(String emailAddress) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return emailAddress.matches(regex);
    }
    public static void main(String[] args) {
        String email = "aa@aa.com";
        System.out.println("The E-mail ID is: " + email);
//        System.out.println("Is the above E-mail ID valid? " + isEmailValid(email));
    }
}
