package models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Builder
public class User {

    private String email;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String password;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phone;
    private String alias;




        public  User build() {
            if (firstName.isEmpty()) {
                throw new IllegalStateException("Customer first name cannot be empty.");
            }

            if (lastName.isEmpty()) {
                throw new IllegalStateException("Customer last name cannot be empty.");
            }

            if (password.isEmpty()) {
                throw new IllegalStateException("Password cannot be empty.");
            }

            if (street.isEmpty()) {
                throw new IllegalStateException("street cannot be empty.");
            }

            if (city.isEmpty()) {
                throw new IllegalStateException("City cannot be empty.");
            }

            if (String.valueOf(state).isEmpty()) {
                throw new IllegalStateException("State cannot be empty.");
            }

            if (String.valueOf(postalCode).isEmpty()) {
                throw new IllegalStateException("Zip/postal code cannot be empty.");
            }

            if (country.isEmpty()) {
                throw new IllegalStateException("Country cannot be empty.");
            }

            if (String.valueOf(phone).isEmpty()) {
                throw new IllegalStateException("Mobile phone cannot be empty.");
            }

            if (alias.isEmpty()) {
                throw new IllegalStateException("Address alias cannot be empty.");
            }

            return new User(email, gender, firstName, lastName, password, street, city, state, postalCode, country, phone, alias);
        }

}



