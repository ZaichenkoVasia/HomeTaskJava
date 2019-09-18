package ua.mycompany.builder;

public class User {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final int code;

    public User(Builder builder) {
        name = builder.name;
        surname = builder.surname;
        email = builder.email;
        password = builder.password;
        code = builder.code;
    }

    public static class Builder {
        private String name;
        private String surname;
        private String email;
        private String password;
        private int code;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withCode(int code) {
            if(code < 0){
                throw new IllegalArgumentException("Code must be >=0");
            }
            this.code = code;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", code=" + code +
                '}';
    }
}
