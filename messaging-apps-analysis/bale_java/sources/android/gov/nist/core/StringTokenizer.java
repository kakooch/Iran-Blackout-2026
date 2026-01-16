package android.gov.nist.core;

import java.text.ParseException;
import java.util.Vector;

/* loaded from: classes.dex */
public class StringTokenizer {
    protected char[] buffer;
    protected int bufferLen;
    protected int ptr;
    protected int savedPtr;

    protected StringTokenizer() {
    }

    public static String getSDPFieldName(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.substring(0, str.indexOf(Separators.EQUALS));
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static boolean isAlpha(char c) {
        return c <= 127 ? (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') : Character.isLowerCase(c) || Character.isUpperCase(c);
    }

    public static boolean isAlphaDigit(char c) {
        return c <= 127 ? (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c <= '9' && c >= '0') : Character.isLowerCase(c) || Character.isUpperCase(c) || Character.isDigit(c);
    }

    public static boolean isDigit(char c) {
        return c <= 127 ? c <= '9' && c >= '0' : Character.isDigit(c);
    }

    public static boolean isHexDigit(char c) {
        return (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f') || isDigit(c);
    }

    public void consume() {
        this.ptr = this.savedPtr;
    }

    public String getLine() {
        int i;
        int i2;
        int i3 = this.ptr;
        while (true) {
            i = this.ptr;
            i2 = this.bufferLen;
            if (i >= i2 || this.buffer[i] == '\n') {
                break;
            }
            this.ptr = i + 1;
        }
        if (i < i2 && this.buffer[i] == '\n') {
            this.ptr = i + 1;
        }
        return String.valueOf(this.buffer, i3, this.ptr - i3);
    }

    public Vector<String> getLines() {
        Vector<String> vector = new Vector<>();
        while (hasMoreChars()) {
            vector.addElement(getLine());
        }
        return vector;
    }

    public char getNextChar() throws ParseException {
        int i = this.ptr;
        if (i < this.bufferLen) {
            char[] cArr = this.buffer;
            this.ptr = i + 1;
            return cArr[i];
        }
        throw new ParseException(((Object) this.buffer) + " getNextChar: End of buffer", this.ptr);
    }

    public String getNextToken(char c) throws ParseException {
        int i = this.ptr;
        while (true) {
            char cLookAhead = lookAhead(0);
            if (cLookAhead == c) {
                return String.valueOf(this.buffer, i, this.ptr - i);
            }
            if (cLookAhead == 0) {
                throw new ParseException("EOL reached", 0);
            }
            consume(1);
        }
    }

    public boolean hasMoreChars() {
        return this.ptr < this.bufferLen;
    }

    public char lookAhead() {
        return lookAhead(0);
    }

    public String nextToken() {
        char c;
        int i = this.ptr;
        do {
            int i2 = this.ptr;
            if (i2 >= this.bufferLen) {
                break;
            }
            c = this.buffer[i2];
            this.ptr = i2 + 1;
        } while (c != '\n');
        return String.valueOf(this.buffer, i, this.ptr - i);
    }

    public String peekLine() {
        int i = this.ptr;
        String line = getLine();
        this.ptr = i;
        return line;
    }

    public StringTokenizer(String str) {
        this.buffer = str.toCharArray();
        this.bufferLen = str.length();
        this.ptr = 0;
    }

    public void consume(int i) {
        this.ptr += i;
    }

    public char lookAhead(int i) {
        try {
            return this.buffer[this.ptr + i];
        } catch (IndexOutOfBoundsException unused) {
            return (char) 0;
        }
    }
}
