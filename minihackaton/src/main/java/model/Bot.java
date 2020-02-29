package model;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DuplicateFormatFlagsException;
import java.util.List;


public class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            if(update.getMessage().hasText()){
                if(update.getMessage().getText().equals("Start game")){
                    try {
                        execute(sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    @Override
    public String getBotUsername() {
        return "Magistr";
    }

    @Override
    public String getBotToken() {
        return "1141059604:AAHXae2xfpTXkaJZGdirvYAO6WxsWZosrxI";
    }
    public static SendMessage sendInlineKeyBoardMessage(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("0");
        inlineKeyboardButton1.setCallbackData("Button \"Тык\" has been pressed");
        inlineKeyboardButton2.setText("0");
        inlineKeyboardButton2.setCallbackData("Button \"Тык2\" has been pressed");
        inlineKeyboardButton3.setText("X");
        inlineKeyboardButton3.setCallbackData("Button \"Тык2\" has been pressed");
        inlineKeyboardButton4.setText("0");
        inlineKeyboardButton4.setCallbackData("Button \"Тык2\" has been pressed");
        inlineKeyboardButton5.setText("X");
        inlineKeyboardButton5.setCallbackData("Button \"Тык2\" has been pressed");
        inlineKeyboardButton6.setText("X");
        inlineKeyboardButton6.setCallbackData("Button \"Тык2\" has been pressed");
        inlineKeyboardButton7.setText("0");
        inlineKeyboardButton7.setCallbackData("Button \"Тык2\" has been pressed");


        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);
        keyboardButtonsRow1.add(inlineKeyboardButton3);
        keyboardButtonsRow2.add(inlineKeyboardButton4);
        keyboardButtonsRow2.add(inlineKeyboardButton5);
        keyboardButtonsRow2.add(inlineKeyboardButton6);
        keyboardButtonsRow3.add(inlineKeyboardButton7);
        keyboardButtonsRow3.add(inlineKeyboardButton8);
        keyboardButtonsRow3.add(inlineKeyboardButton9);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return new SendMessage().setChatId(chatId).setText("Пример").setReplyMarkup(inlineKeyboardMarkup);
    }
}
