package model;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
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
    static List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
    static boolean flag;

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
            }
        } else if (update.hasCallbackQuery()) {
            if (update.getCallbackQuery().getData() != null) {
                buttonRes = Integer.parseInt(update.getCallbackQuery().getData());
                try {
                    execute(handleMessage(buttonRes, update.getCallbackQuery().getMessage().getChatId()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private static SendMessage handleMessage(int move, long chatId) {

        State m;    // holds move type being added

        if (flag)
            m = State.X;
        else
            m = State.O;

        // sets move
        switch (move) {
            case 1:
            case 2:
            case 3:
                keyboardButtonsRow1.get(move - 1).setText(String.format("%s", m));
                break;
            case 4:
            case 5:
            case 6:
                keyboardButtonsRow2.get(move - 3 - 1).setText(String.format("%s", m));
                break;
            case 7:
            case 8:
            case 9:
                keyboardButtonsRow3.get(move - 6 - 1).setText(String.format("%s", m));

                break;
        }
        flag = !flag;
            if (checkWin(State.X)) {
                System.out.println("asd");
        }
            return new SendMessage().setChatId(chatId).setText("Пример").setReplyMarkup(inlineKeyboardMarkup);
    }

    static boolean checkWin(State state) {
        for (int i = 0; i < rowList.size(); i++) {
            for (int j = 0; j < rowList.size(); j++) {
                if (rowList.get(i).get(j).getText().equals(String.format("%s", state)) || (rowList.get(j).get(i).getText().equals(String.format("%s", state))))
                    return true;
            }
        }
        if (rowList.get(0).get(0).getText().equals(String.format("%s", state)) && (rowList.get(1).get(1).getText().equals(String.format("%s", state)))
                && rowList.get(2).get(2).getText().equals(String.format("%s", state)) || ((rowList.get(2).get(0).getText().equals(String.format("%s", state))) && (rowList.get(1).get(1).getText().equals(String.format("%s", state)))
                && rowList.get(0).get(2).getText().equals(String.format("%s", state))))
            return true;
        return false;
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
