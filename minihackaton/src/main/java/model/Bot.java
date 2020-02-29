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
    private static final String token = "1141059604:AAHXae2xfpTXkaJZGdirvYAO6WxsWZosrxI";
    private static final String botUserName = "Magistr";

    static List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
    static List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
    static List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();

    static InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
    static InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
    static InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
    static InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
    static InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
    static InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
    static InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
    static InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
    static InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
    static InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();
    private Integer buttonRes = 0;

    public static SendMessage sendInlineKeyBoardMessage(long chatId) {

        inlineKeyboardButton1.setText(String.format("%s", State.c));
        inlineKeyboardButton1.setCallbackData("1");
        inlineKeyboardButton2.setText(String.format("%s", State.c));
        inlineKeyboardButton2.setCallbackData("2");
        inlineKeyboardButton3.setText(String.format("%s", State.c));
        inlineKeyboardButton3.setCallbackData("3");
        inlineKeyboardButton4.setText(String.format("%s", State.c));
        inlineKeyboardButton4.setCallbackData("4");
        inlineKeyboardButton5.setText(String.format("%s", State.c));
        inlineKeyboardButton5.setCallbackData("5");
        inlineKeyboardButton6.setText(String.format("%s", State.c));
        inlineKeyboardButton6.setCallbackData("6");
        inlineKeyboardButton7.setText(String.format("%s", State.c));
        inlineKeyboardButton7.setCallbackData("7");
        inlineKeyboardButton8.setText(String.format("%s", State.c));
        inlineKeyboardButton8.setCallbackData("8");
        inlineKeyboardButton9.setText(String.format("%s", State.c));
        inlineKeyboardButton9.setCallbackData("9");


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


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                System.out.println(update.getMessage());
                if (update.getMessage().getText().equals("Start game")) {
                    try {
                        execute(sendInlineKeyBoardMessage(update.getMessage().getChatId()));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            } else if (update.getCallbackQuery().getData() != null) {
                buttonRes = Integer.parseInt(update.getCallbackQuery().getData());
            }
        }

    }


    private static void handleMessage(int move) {

        char m;    // holds move type being added

        // if(p1Turn)
        m = 'X';
//            else
//                m = 'O';

        // sets move
        switch (move) {
            case 1:
                keyboardButtonsRow1.get(0).setText(String.format("%s", State.X));

                break;
            case 2:
                keyboardButtonsRow1.get(1).setText(String.format("%s", State.X));

                break;
            case 3:
                keyboardButtonsRow1.get(2).setText(String.format("%s", State.X));

                break;
            case 4:
                keyboardButtonsRow2.get(0).setText(String.format("%s", State.X));
                break;
            case 5:
                keyboardButtonsRow2.get(1).setText(String.format("%s", State.X));

                break;
            case 6:
                keyboardButtonsRow2.get(2).setText(String.format("%s", State.X));

                break;
            case 7:
                keyboardButtonsRow3.get(0).setText(String.format("%s", State.X));

                break;
            case 8:
                keyboardButtonsRow3.get(1).setText(String.format("%s", State.X));

                break;
            case 9:
                keyboardButtonsRow3.get(2).setText(String.format("%s", State.X));

                break;
        }
        p1Turn ^= true;
    }

}


    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
