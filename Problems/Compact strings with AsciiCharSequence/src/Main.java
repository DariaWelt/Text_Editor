import java.util.Arrays;

class AsciiCharSequence implements java.lang.CharSequence {

    private byte[] byteSequence;

    public AsciiCharSequence(byte[] byteSequence) {
        this.byteSequence = byteSequence;
    }

    @Override
    public int length() {
        return byteSequence.length;
    }

    @Override
    public char charAt(int i) {
        return (char)byteSequence[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(Arrays.copyOfRange(byteSequence,i,i1));
    }

    @Override
    public String toString() {
        return new String(byteSequence);
    }
}