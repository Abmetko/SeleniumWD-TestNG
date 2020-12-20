package core.utils;

import org.openqa.selenium.WebElement;
import java.util.List;


public class DataExtractorTransformer {

    public static String[] transformListToArray(List<WebElement> list){
        String[] elementNames = new String[list.size()];
        for (WebElement i:list) {
            elementNames[list.indexOf(i)] = i.getText();
        }
        return elementNames;
    }
}