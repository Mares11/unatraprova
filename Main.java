package com.example;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        //è la classe che implementa la API di Telegram
        TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();

        //registriamo il bot
        String bot_token = "7160101805:AAF1nmDa2-ILIPQzCyFFM3Hs1poNwbBqKTU";
        botsApplication.registerBot(bot_token, new MemoBOT());
    }
    
}
