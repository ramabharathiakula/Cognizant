public class TestDecorator {

    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        System.out.println("Email Notification:");
        notifier.send();

        System.out.println();

        System.out.println("Email + SMS Notification:");
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send();

        System.out.println();

        System.out.println("Email + SMS + Slack Notification:");
        Notifier allNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifier.send();
    }
}