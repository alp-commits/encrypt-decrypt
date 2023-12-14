package encryptdecrypt.shift;
import encryptdecrypt.Encrypt;

public class ShiftEncrypt extends Encrypt{

    @Override
    public char encryptChar(char c, int shift){
        if ((c >= 97) && (c <= 122)) return (char) ((c - 97 + shift) % 26 + 97);
        if ((c >= 65) && (c <= 90)) return (char) ((c - 65 + shift) % 26 + 65);
        return c;
    }

}