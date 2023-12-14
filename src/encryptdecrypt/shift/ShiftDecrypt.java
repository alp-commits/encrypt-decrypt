package encryptdecrypt.shift;
import encryptdecrypt.Decrypt;

public class ShiftDecrypt extends Decrypt {
    @Override
    public char decryptChar(char c, int shift){
        if ((c >= 97) && (c <= 122)) return (char) ((26 + c - 97 - shift) % 26 + 97);
        if ((c >= 65) && (c <= 90)) return (char) ((26 + c - 65 - shift) % 26 + 65);
        return c;
    }
}