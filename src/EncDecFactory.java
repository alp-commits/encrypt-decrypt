import encryptdecrypt.shift.ShiftDecrypt;
import encryptdecrypt.shift.ShiftEncrypt;
import encryptdecrypt.unicode.UnicodeDecrypt;
import encryptdecrypt.unicode.UnicodeEncrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncDecFactory {
    public String encryptDecryptFactory(Parameters p){
        if(p.getOutput().equals("") && p.getInput().equals("")) {
            return encryptDecryptNoFile(p);
        }

        if(p.getOutput().equals("") && !p.getInput().equals("")) {
            return encryptDecryptWithFileIn(p);
        }

        if(!p.getOutput().equals("") && p.getInput().equals("")) {
            encryptDecryptWithFileOut(p);
            return ("Message included in the file: " + p.getOutput());
        }

        if(!p.getOutput().equals("") && !p.getInput().equals("")) {
            encryptDecryptWithInOutFiles(p);
            return ("Message included in the file: " + p.getOutput());
        } else return "Error in factory";
    }

    private String encryptDecryptNoFile(Parameters p){
        String temp = "Error in primary encryption/decryption mechanism";
        if(p.getOperation().equals("enc")){
            if(p.getAlgorithm().equals("unicode")) {
                UnicodeEncrypt enc = new UnicodeEncrypt();
                temp = enc.encrypt(p.getMessage(), p.getShift());
            };
            if(p.getAlgorithm().equals("shift")) {
                ShiftEncrypt enc = new ShiftEncrypt();
                temp = enc.encrypt(p.getMessage(), p.getShift());
            }
        }
        if(p.getOperation().equals("dec")){
            if(p.getAlgorithm().equals("unicode")) {
                UnicodeDecrypt dec = new UnicodeDecrypt();
                temp = dec.decrypt(p.getMessage(), p.getShift());
            };
            if(p.getAlgorithm().equals("shift")) {
                ShiftDecrypt dec = new ShiftDecrypt();
                temp = dec.decrypt(p.getMessage(), p.getShift());
            }
        }
        return temp;
    }

    private void encryptDecryptWithFileOut(Parameters p){
        String messageForFile = encryptDecryptNoFile(p);
        File file = new File(p.getOutput());
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(messageForFile);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error in destination file");
        }
    }

    private String encryptDecryptWithFileIn(Parameters p){
        StringBuilder message = new StringBuilder();
        File file = new File(p.getInput());
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                message.append(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error in input file");
        }
        p.setMessage(String.valueOf(message));
        return encryptDecryptNoFile(p);
    }

    private void encryptDecryptWithInOutFiles(Parameters p){
        String messageForFile = encryptDecryptWithFileIn(p);
        File file = new File(p.getOutput());
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(messageForFile);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error in input or destination file");
        }
    }

}
