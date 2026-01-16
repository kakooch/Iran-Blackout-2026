package j$.time.format;

import j$.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class s {
    public static final s a = new s('0', '+', '-', '.');

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    private s(char c, char c2, char c3, char c4) {
    }

    String a(String str) {
        return str;
    }

    public char b() {
        return '.';
    }

    public char c() {
        return '-';
    }

    public char d() {
        return '+';
    }

    public char e() {
        return '0';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        ((s) obj).getClass();
        return true;
    }

    public int hashCode() {
        return 182;
    }

    public String toString() {
        return "DecimalStyle[0+-.]";
    }
}
