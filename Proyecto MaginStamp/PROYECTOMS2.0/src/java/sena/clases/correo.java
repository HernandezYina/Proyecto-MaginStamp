package sena.clases;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import sena.entidades.Usuario;

@Named(value = "envioCorreo")
@SessionScoped
public class correo implements Serializable {

// correo de bienvenida
    public static void sendRegistro(String para, String sujeto, String mensaje) throws UnsupportedEncodingException {
        final String user = "cempresamagin@gmail.com";//cambiara¡ en consecuencia al servidor utilizado
        final String pass = "spartanjhon117";
        String nuevoMensaje = "<h1 style=\"font-size: 20px; color:black; font-weight: bold; text-transform: uppercase ; \"> Bienvenido" + "</h1>" + "<p>" + mensaje + "<br>\n"
                + "<p style=\"text-align: center; color: black\">\n"
                + "</p> \n"
                + "<br>\n"
                + "<p style=\"color:#2E9AFE;font-weight: bold;\" > MaginStamp </p> ";
//1st paso) Obtener el objeto de sesion

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)componer el message
        try {
            //Archivos adjuntos
            BodyPart texto = new MimeBodyPart();
            texto.setContent(nuevoMensaje, "text/html");
//            BodyPart adjunto = new MimeBodyPart();
            MimeMultipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(texto);
//            multiparte.addBodyPart(adjunto);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user, "MAGIN STAMP"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
            message.setSubject(sujeto);
            message.setContent(multiparte, "text/html; charset=utf-8");

            //3rd paso)send message
            Transport.send(message);

            System.out.println("hecho");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

//correo masivo se llena con los datos de la vista 
    public static void sendmasivo(String correoEmpresa, String claveEmpresa, List<Usuario> ListaEmail, String AsuntoM, String CuerpoM) throws UnsupportedEncodingException {
        final String user = correoEmpresa;//cambiará en consecuencia al servidor utilizadoEsto es una prueba
        final String pass = claveEmpresa;
        String nuevoMensaje = "<h1 style=\"font-size: 20px; color:black; font-weight: bold; text-transform: uppercase ; \">" + AsuntoM + "</h1>" + "<p>PRUEBA</p><br>\n"
                + "<p style=\"text-align: center; color: black\">\n" + CuerpoM + "</p>\n"
                + "<br>\n"
                + "<p style=\"color:#2E9AFE;font-weight: bold;\"> MaginStamp </p>";
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {
            //Archivos adjuntos
            BodyPart texto = new MimeBodyPart();
            texto.setContent(nuevoMensaje, "text/html");
//            BodyPart adjunto = new MimeBodyPart();
//            adjunto.setDataHandler(new DataHandler(new FileDataSource("d:/cartagena.txt")));
//            adjunto.setFileName("cartagena.txt");

            MimeMultipart multiparte = new MimeMultipart();
            multiparte.addBodyPart(texto);
//            multiparte.addBodyPart(adjunto);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user, "MaginStamp"));

            InternetAddress[] correos = new InternetAddress[ListaEmail.size()];
            int index = 0;
            for (Usuario usuario : ListaEmail) {
                correos[index] = new InternetAddress(usuario.getEmail());
                index++;
            }
            message.setRecipients(Message.RecipientType.TO, correos);
            message.setSubject(AsuntoM);
            message.setContent(multiparte, "text/html; charset=utf-8");

            //3rd paso)send message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        };
    }

//METODO PARA RECUPERAR CONTRASEÑA  
    public static void sendClaves(String para, String Nombres, String Email, String Clave) {
        final String user = "cempresamagin@gmail.com";
        final String pass = "spartanjhon117";

//1st paso) Obtener el objeto de sesión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

//2nd paso)compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user)); // quien envia 
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(para)); // quien recibe
            message.setSubject("RECUPERAR CLAVE");

            message.setContent(
                    "<center><img src='' title='Claves'></center>"
                    + "<h3> Recordatorio Claves. "
                    + Nombres
                    + "</h3>"
                    + "Datos de Ingreso:"
                    + "<h4> Email usuario : "
                    + Email
                    + "</h4>"
                    + "<h4> Clave Usuario : "
                    + Clave
                    + " </h4>", "text/html");

            //3rd paso)send message
            Transport.send(message);

            System.out.println("hecho");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }


}
