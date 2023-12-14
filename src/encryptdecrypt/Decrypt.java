package encryptdecrypt;

public abstract class Decrypt {
    public String decrypt(String message, int shift) {
        char[] temp = decryptCharArray(breakString(message), shift);
        return makeString(temp);
    }

    public char[] breakString(String message) {
        return message.toCharArray();
    }

    public char[] decryptCharArray(char[] chars, int shift) {
        char[] temp = new char[chars.length];
        for(int i = 0; i < chars.length; i ++) {
            temp[i] = decryptChar(chars[i], shift);
        }
        return temp;
    }

    public char decryptChar(char c, int shift){
        return (char) (c - shift);
    }

    public String makeString(char[] chars) {
        return new String(chars);
    }
}
