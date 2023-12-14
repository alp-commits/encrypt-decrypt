package encryptdecrypt;

public abstract class Encrypt {

    public String encrypt(String message, int shift) {
        char[] temp = encryptCharArray(breakString(message), shift);
        return makeString(temp);
    }

    public char[] breakString(String message) {
        return message.toCharArray();
    }

    public char[] encryptCharArray(char[] chars, int shift) {
        char[] temp = new char[chars.length];
        for(int i = 0; i < chars.length; i ++) {
            temp[i] = encryptChar(chars[i], shift);
        }
        return temp;
    }

    public char encryptChar(char c, int shift){
        return (char) (c + shift);
    }

    public String makeString(char[] chars) {
        return new String(chars);
    }

}
