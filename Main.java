/*
Ich habe mich für die Nutzung des Composite- und Observer-Patterns entschieden. Das Observer-Pattern bot sich deshalb an, weil bei einer neuen Nachricht
im Channel alle Teilnehmer (= Observer) benachrichtigt werden sollten und dies mit einer Implementierung des Observer-Patterns gut zu lösen ist.
Das Composite-Pattern war deshalb notwendig, weil eine Message sowohl nur aus einer Text- oder Bildnachricht, als auch aus dem "Composite" weiterer Messages
als Anhang bestehen kann. Um eine Nachricht gleich zu behandeln, wie eine Nachricht mit dem Anhang weiterer Nachrichten, eignet sich das Composite-Pattern sehr.
*/

public class Main {

    public static void main(String[] args) throws Exception {

        Channel channel1 = new Channel();

        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user4 = new User("user4");

        channel1.connect(user1);
        channel1.connect(user2);
        channel1.connect(user3);
        channel1.connect(user4);

        Message test1 = new TextMessage(1);
        test1.setContents("Hello World!");

        // Message test2 = new ImageMessage(2);
        // test2.setContents("ibiza.jpg");

        Message test2 = new TextMessage(2);
        test2.setContents("This is another text message!");

        // MultiPartMessage test3 = new MultiPartMessage(3);
        // test3.setContents("attached there is a nice pic of ibiza in summer 2k18 and a pdf of my homework ;-)");
        // test3.addAttachment(test2);
        // test3.addAttachment("homework.pdf");

        MultiPartMessage test3 = new MultiPartMessage(3);
        test3.setContents("This is message with the two previous messages attached");
        test3.addAttachment(test1);
        test3.addAttachment(test2);

        ReceiptConfMessage recTest1 = new ReceiptConfMessage(test3);

        user1.sendMessage(channel1, test1);
        user2.processLastReceivedMessage();

        user3.sendMessage(channel1, test2);
        user2.processLastReceivedMessage();

        user4.sendMessage(channel1, test3);
        user2.processLastReceivedMessage();
        
        user4.checkReception(test3);
        user3.checkReception(test2);


    }

}
