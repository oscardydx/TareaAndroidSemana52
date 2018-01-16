package com.example.vulcanussoft.carviewfinal;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FormularioContacto extends AppCompatActivity {
    String Correo="";
    String Contraseña="";

    EditText mensaje;
    EditText remitente;
    Button enviar;
    Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contacto);
         mensaje=(EditText) findViewById(R.id.etmensaje);
         remitente=(EditText) findViewById(R.id.etcorreo);
         enviar= (Button) findViewById(R.id.button);

         enviar.setOnClickListener(new View.OnClickListener( ) {
             @Override
             public void onClick(View view) {
                 StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                 StrictMode.setThreadPolicy(policy);

                 Properties propierties= new Properties();
                 propierties.put("mail.smtp.host","smtp.googlemail.com");
                 propierties.put("mail.smtp.socketFactory.port","465");
                 propierties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                 propierties.put("mail.smtp.auth","true");
                 propierties.put("mail.smtp.port","465");

                 try{
                     session=Session.getDefaultInstance(propierties, new Authenticator( ) {
                         @Override
                         protected PasswordAuthentication getPasswordAuthentication() {
                             return new PasswordAuthentication(Correo,Contraseña );
                         }
                     });
                     if (session!=null){
                         String mensajeCorreo=mensaje.getText().toString()+".Remitente:"+remitente.getText().toString();
                         Message message= new MimeMessage(session);
                         message.setFrom(new InternetAddress(Correo));
                     message.setSubject("Formulario de contactacto App");
                     message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("oscardydx@gmail.com"));
                     message.setContent(mensajeCorreo,"text/html; charset=utf-8");
                         Transport.send(message);}
                 }catch (Exception e){e.printStackTrace();}
                 Toast.makeText(getBaseContext(),getString(R.string.confirmacion), Toast.LENGTH_LONG).show();
                 Intent intent=new Intent(FormularioContacto.this,MainActivity.class);
                 startActivity(intent);

             }
         });


    }
}
