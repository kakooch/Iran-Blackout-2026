package j$.time.format;

import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class g {
    public static final g a = new g('0', '+', '-', '.');
    private final char b;
    private final char c;
    private final char d;
    private final char e;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private g(char c, char c2, char c3, char c4) {
        this.b = c;
        this.c = c2;
        this.d = c3;
        this.e = c4;
    }

    String a(String str) {
        char c = this.b;
        if (c == '0') {
            return str;
        }
        int i = c - '0';
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            charArray[i2] = (char) (charArray[i2] + i);
        }
        return new String(charArray);
    }

    public char b() {
        return this.e;
    }

    public char c() {
        return this.d;
    }

    public char d() {
        return this.c;
    }

    public char e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.b == gVar.b && this.c == gVar.c && this.d == gVar.d && this.e == gVar.e;
    }

    public int hashCode() {
        return this.b + this.c + this.d + this.e;
    }

    public String toString() {
        StringBuilder sbA = j$.com.android.tools.r8.a.a("DecimalStyle[");
        sbA.append(this.b);
        sbA.append(this.c);
        sbA.append(this.d);
        sbA.append(this.e);
        sbA.append("]");
        return sbA.toString();
    }
}
