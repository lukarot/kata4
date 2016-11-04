package kata4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Kata4 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName="emailsfilev1.txt";
        ArrayList<String>  mailist=MailListReader.read(fileName);
        Histogram<String>histo=MailHistogramBuilder.build(mailist);
        HistogramDisplay histoDisplay=new HistogramDisplay(histo);
        histoDisplay.execute();
    }

}