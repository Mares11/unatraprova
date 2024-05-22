package com.example;


import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.spec.EdECPoint;



public class MemoBOT implements LongPollingSingleThreadUpdateConsumer {

    String memo_path = "C:\\Users\\Acer6930\\Desktop\\javawork\\memotg\\src\\main\\java\\com\\example\\memo.txt";
    String know_path = "C:\\Users\\Acer6930\\Desktop\\javawork\\memotg\\src\\main\\java\\com\\example\\know.txt";

    
    TelegramClient telegramClient = new OkHttpTelegramClient("7160101805:AAF1nmDa2-ILIPQzCyFFM3Hs1poNwbBqKTU");
    ArrayList<String> elenco_memo = new ArrayList<>();
    SendMessage rispondi;
    String risposta;

    FileWriter writer_memo;
    FileReader reader_memo;
    FileWriter writer_know;
    FileReader reader_know;

    StringBuilder stringBuilder = new StringBuilder();


    @Override
    public void consume(Update update) {

        
        //è ok, database le salva, ma quando riavvii il programma (anche se potenzialmente non devo riavviarlo) resetta l'arraylist
        //prova con un file (ma vedi se serve prima). Devi immancabilmente trovare un modo per costruire sta risposta

        String UserID = String.valueOf(update.getMessage().getFrom().getId());
        String ChatID = update.getMessage().getChatId().toString();

        

        if((UserID.equals("1332701468"))){
            
            if(update.getMessage().getText().startsWith("/memo")){

                String item = update.getMessage().getText().replace("/memo", "").trim();
                String risposta = "Database(item, memo);";

                rispondi = new SendMessage(ChatID, risposta);

                    try {
                        telegramClient.execute(rispondi);
                        System.out.println(elenco_memo);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                        System.out.println("Il problema è qui.");
                    }
                }

            }
            

        }
}






/*
//così prendiamo il messaggio dal l'utente
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messaggio_dall_utente = update.getMessage().getText();
            System.out.println(messaggio_dall_utente);
        }
        //info dell'utente ID, Nome, Cognome, ecc
        update.getMessage().getFrom().getId();
        String ChatID = update.getMessage().getChatId().toString();

        //comandi
        String comando1 = update.getMessage().getText();
        if(comando1.equals("/ciao")){
        SendMessage rispondi = new SendMessage(ChatID, "Risposta al comando");
        try {
            telegramClient.execute(rispondi);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        }
 */

 /*
  
    public String Database(String item, String comando){ //fai separati i casi di memo e know come ha fatto chatgpt.
    try {
        writer_memo = new FileWriter(memo_path);
        reader_memo = new FileReader(memo_path);

        writer_know = new FileWriter(know_path);
        reader_know = new FileReader(know_path);

        //scrivere
        if(comando.equals("memo")){
            int ObjNumber = (char)reader_memo.read();
            
            writer_memo.append(((ObjNumber+1) + ") " + item +"\n"));
        }
        else if (comando.equals("know")){
            int ObjNumber = (char)reader_know.read();
            
            writer_know.append(((ObjNumber+1) + ") " + item +"\n"));
        }

        //leggere
        if(comando.equals("memo")){


            int l = reader_memo.read();
            while(reader_memo.read()!=-1){
                stringBuilder.append((char)l);
                reader_memo.read();
            }
        }
        else if (comando.equals("know")){
            int l = reader_memo.read();
            while(reader_know.read()!=-1){
                stringBuilder.append((char)l);
                reader_know.read();
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    
    String elenco = stringBuilder.toString();
        return elenco;
    }
  */