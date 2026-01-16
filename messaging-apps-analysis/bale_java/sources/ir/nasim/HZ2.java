package ir.nasim;

import java.io.IOException;

/* loaded from: classes5.dex */
public class HZ2 {
    private String a;
    private int b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;

    public HZ2(JZ2 jz2) throws IOException {
        byte b;
        byte b2;
        long jC = jz2.c();
        EZ2 ez2B = jz2.b();
        byte b3 = 2;
        if (jz2.e().c() == 2) {
            this.a = new String(ez2B.c(3), "ISO-8859-1");
        } else {
            this.a = new String(ez2B.c(4), "ISO-8859-1");
        }
        byte b4 = 8;
        if (jz2.e().c() == 2) {
            this.c = ((ez2B.a() & 255) << 16) | ((ez2B.a() & 255) << 8) | (ez2B.a() & 255);
        } else if (jz2.e().c() == 3) {
            this.c = ez2B.d();
        } else {
            this.c = ez2B.e();
        }
        if (jz2.e().c() > 2) {
            ez2B.a();
            byte bA = ez2B.a();
            byte b5 = 64;
            if (jz2.e().c() == 3) {
                b4 = 128;
                b = 32;
                b3 = 0;
                b2 = 0;
            } else {
                b = 64;
                b2 = 1;
                b5 = 4;
            }
            this.e = (b4 & bA) != 0;
            this.d = (bA & b3) != 0;
            this.f = (bA & b5) != 0;
            if (jz2.e().c() == 3) {
                if (this.e) {
                    this.g = ez2B.d();
                    this.c -= 4;
                }
                if (this.f) {
                    ez2B.a();
                    this.c--;
                }
                if ((bA & b) != 0) {
                    ez2B.a();
                    this.c--;
                }
            } else {
                if ((bA & b) != 0) {
                    ez2B.a();
                    this.c--;
                }
                if (this.f) {
                    ez2B.a();
                    this.c--;
                }
                if ((bA & b2) != 0) {
                    this.g = ez2B.e();
                    this.c -= 4;
                }
            }
        }
        this.b = (int) (jz2.c() - jC);
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.g;
    }

    public String c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        for (int i = 0; i < this.a.length(); i++) {
            if (this.a.charAt(0) != 0) {
                return false;
            }
        }
        return this.c == 0;
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        for (int i = 0; i < this.a.length(); i++) {
            if ((this.a.charAt(i) < 'A' || this.a.charAt(i) > 'Z') && (this.a.charAt(i) < '0' || this.a.charAt(i) > '9')) {
                return false;
            }
        }
        return this.c > 0;
    }

    public String toString() {
        return String.format("%s[id=%s, bodysize=%d]", getClass().getSimpleName(), this.a, Integer.valueOf(this.c));
    }
}
