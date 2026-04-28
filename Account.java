public class Account {
    private final String accountNumber;
    private final String name;
    private final String gender;
    private final String dob;
    private String address;
    private String phone;
    private final String aadhaar;
    private final String pan;
    private final String accType;
    private double balance;

    public Account(String accountNumber, String name, String gender, String dob,
                   String address, String phone, String aadhaar, String pan,
                   String accType, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.aadhaar = aadhaar;
        this.pan = pan;
        this.accType = accType;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getDob() { return dob; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getAadhaar() { return aadhaar; }
    public String getPan() { return pan; }
    public String getAccType() { return accType; }
    public double getBalance() { return balance; }

    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return accountNumber + "|" + name + "|" + gender + "|" + dob + "|" +
               address + "|" + phone + "|" + aadhaar + "|" + pan + "|" +
               accType + "|" + balance;
    }
}
