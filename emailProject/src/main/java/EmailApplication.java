import service.EmailService;

public class EmailApplication {
    public static void main(String[] args) {
        EmailService emailService = new EmailService("smtp.gmail.com", 587,
                "test1mail3210@gmail.com", "Zxc993sa");

        emailService.sendMail("test1mail3210@gmail.com");
    }
}
