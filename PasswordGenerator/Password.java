import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Password{

    private static final String lower = "abcdefghijklmnopqrstuvwxyz";
    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String numbers = "0123456789";
    private static final String symbols = "$&@?<>~!%#";

     public static String genRandomNum(boolean useSpeacialChars, boolean useCapsLetter, boolean useNumbers, int passwordLength){

        String chars = lower;
        String p = "";

        if(useSpeacialChars){
            p += String.valueOf(symbols.charAt(new Random().nextInt(symbols.length())));
            //that is so ugly but fix later
            chars = chars + symbols;
            passwordLength--;
        }
        if(useCapsLetter){
            p+= String.valueOf(upper.charAt(new Random().nextInt(upper.length())));
            chars = chars + upper;
            passwordLength--;
        }
        if(useNumbers){
            p += String.valueOf(numbers.charAt(new Random().nextInt(numbers.length())));
            chars = chars + numbers;
            passwordLength--;
        }
        for(int i = 0; i < passwordLength; i++){
            char c = chars.charAt(new Random().nextInt(chars.length()));
            p += String.valueOf(c);
        }

        java.util.List<String> letters = Arrays.asList(p.split(" "));
        Collections.shuffle(letters);
        String shuffled = " ";

        for(String letter : letters){
            shuffled += letter;
        }
            return shuffled;
     }	

}
	
	

