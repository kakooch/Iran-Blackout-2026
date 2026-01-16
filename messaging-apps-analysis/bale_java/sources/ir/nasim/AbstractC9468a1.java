package ir.nasim;

/* renamed from: ir.nasim.a1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9468a1 {
    public static final byte a(char c) {
        if (c < '~') {
            return C9649aK0.c[c];
        }
        return (byte) 0;
    }

    public static final char b(int i) {
        if (i < 117) {
            return C9649aK0.b[i];
        }
        return (char) 0;
    }

    public static final String c(byte b) {
        return b == 1 ? "quotation mark '\"'" : b == 2 ? "string escape sequence '\\'" : b == 4 ? "comma ','" : b == 5 ? "colon ':'" : b == 6 ? "start of the object '{'" : b == 7 ? "end of the object '}'" : b == 8 ? "start of the array '['" : b == 9 ? "end of the array ']'" : b == 10 ? "end of the input" : b == 127 ? "invalid token" : "valid token";
    }
}
