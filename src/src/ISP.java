public class ISP {

    // Interfaces
    interface EmailAddressProvider {
        String getEmailAddress();
    }

    interface TelephoneNumberProvider {
        String getTelephone();
    }


    // Clase GmailAccount implementa la interfaz EmailAddressProvider
    public class GmailAccount implements EmailAddressProvider {
        private String name, emailAddress;

        public GmailAccount(String name, String emailAddress) {
            this.name = name;
            this.emailAddress = emailAddress;
        }

        @Override
        public String getEmailAddress() {
            return emailAddress;
        }

        // Getters and setters for name and emailAddress
        // ...
    }

    // Clase Contacto implementa las interfaces
    public class Contacto implements EmailAddressProvider, TelephoneNumberProvider {
        private String name, address, emailAddress, telephone;

        public void setName(String n) {
            name = n;
        }

        public String getName() {
            return name;
        }

        public void setAddress(String a) {
            address = a;
        }

        public String getAddress() {
            return address;
        }

        public void setEmailAddress(String ea) {
            emailAddress = ea;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setTelephone(String t) {
            telephone = t;
        }

        public String getTelephone() {
            return telephone;
        }
    }

    // Clase EmailSender utiliza la interfaz EmailAddressProvider
    public class EmailSender {
        public static void sendEmail(EmailAddressProvider c, String message) {
            // Simulación: aquí enviaría el mensaje a la dirección de correo del proveedor c.
            System.out.println("Enviando correo a: " + c.getEmailAddress());
            System.out.println("Mensaje: " + message);
        }
    }

    // Clase EmailSender utiliza la interfaz EmailAddressProvider
    public class EmailSender1 {
        public static void sendEmail(EmailAddressProvider c, String message) {
            // Envía un mensaje a la dirección de correo del proveedor c.
        }
    }

    // Clase SMSSender utiliza la interfaz TelephoneNumberProvider
    public class SMSSender {
        public static void sendSMS(TelephoneNumberProvider c, String message) {
            // Envía un mensaje SMS al teléfono del proveedor c.
        }
    }


    public class Main {
        public void main(String[] args) {
            // Crear una instancia de GmailAccount
            GmailAccount gmailAccount = new GmailAccount("John Diaz", "johnDiaz@gmail.com");

            // Invocar el método sendEmail de EmailSender
            String message = "Hola, este es un ejemplo de correo enviado desde GmailAccount.";
            EmailSender.sendEmail(gmailAccount, message);
        }
    }
}
