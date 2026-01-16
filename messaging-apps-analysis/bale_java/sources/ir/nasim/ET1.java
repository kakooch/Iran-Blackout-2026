package ir.nasim;

import ir.nasim.C16651le1;

/* loaded from: classes2.dex */
public class ET1 {
    public static final Object i = new Object();
    public static final Object j = new Object();
    public static final Object k = new Object();
    public static final Object l = new Object();
    public static final Object m = new Object();
    public static final Object n = new Object();
    private final int a;
    int b;
    int c;
    float d;
    int e;
    String f;
    Object g;
    boolean h;

    private ET1() {
        this.a = -2;
        this.b = 0;
        this.c = Integer.MAX_VALUE;
        this.d = 1.0f;
        this.e = 0;
        this.f = null;
        this.g = j;
        this.h = false;
    }

    public static ET1 a(int i2) {
        ET1 et1 = new ET1(i);
        et1.f(i2);
        return et1;
    }

    public static ET1 b(Object obj) {
        ET1 et1 = new ET1(i);
        et1.g(obj);
        return et1;
    }

    public static ET1 c(Object obj) {
        ET1 et1 = new ET1();
        et1.m(obj);
        return et1;
    }

    public static ET1 d() {
        return new ET1(j);
    }

    public void e(UK6 uk6, C16651le1 c16651le1, int i2) {
        String str = this.f;
        if (str != null) {
            c16651le1.C0(str);
        }
        int i3 = 2;
        if (i2 == 0) {
            if (this.h) {
                c16651le1.O0(C16651le1.b.MATCH_CONSTRAINT);
                Object obj = this.g;
                if (obj == j) {
                    i3 = 1;
                } else if (obj != m) {
                    i3 = 0;
                }
                c16651le1.P0(i3, this.b, this.c, this.d);
                return;
            }
            int i4 = this.b;
            if (i4 > 0) {
                c16651le1.Z0(i4);
            }
            int i5 = this.c;
            if (i5 < Integer.MAX_VALUE) {
                c16651le1.W0(i5);
            }
            Object obj2 = this.g;
            if (obj2 == j) {
                c16651le1.O0(C16651le1.b.WRAP_CONTENT);
                return;
            }
            if (obj2 == l) {
                c16651le1.O0(C16651le1.b.MATCH_PARENT);
                return;
            } else {
                if (obj2 == null) {
                    c16651le1.O0(C16651le1.b.FIXED);
                    c16651le1.j1(this.e);
                    return;
                }
                return;
            }
        }
        if (this.h) {
            c16651le1.f1(C16651le1.b.MATCH_CONSTRAINT);
            Object obj3 = this.g;
            if (obj3 == j) {
                i3 = 1;
            } else if (obj3 != m) {
                i3 = 0;
            }
            c16651le1.g1(i3, this.b, this.c, this.d);
            return;
        }
        int i6 = this.b;
        if (i6 > 0) {
            c16651le1.Y0(i6);
        }
        int i7 = this.c;
        if (i7 < Integer.MAX_VALUE) {
            c16651le1.V0(i7);
        }
        Object obj4 = this.g;
        if (obj4 == j) {
            c16651le1.f1(C16651le1.b.WRAP_CONTENT);
            return;
        }
        if (obj4 == l) {
            c16651le1.f1(C16651le1.b.MATCH_PARENT);
        } else if (obj4 == null) {
            c16651le1.f1(C16651le1.b.FIXED);
            c16651le1.K0(this.e);
        }
    }

    public ET1 f(int i2) {
        this.g = null;
        this.e = i2;
        return this;
    }

    public ET1 g(Object obj) {
        this.g = obj;
        if (obj instanceof Integer) {
            this.e = ((Integer) obj).intValue();
            this.g = null;
        }
        return this;
    }

    int h() {
        return this.e;
    }

    public ET1 i(int i2) {
        if (this.c >= 0) {
            this.c = i2;
        }
        return this;
    }

    public ET1 j(Object obj) {
        Object obj2 = j;
        if (obj == obj2 && this.h) {
            this.g = obj2;
            this.c = Integer.MAX_VALUE;
        }
        return this;
    }

    public ET1 k(int i2) {
        if (i2 >= 0) {
            this.b = i2;
        }
        return this;
    }

    public ET1 l(Object obj) {
        if (obj == j) {
            this.b = -2;
        }
        return this;
    }

    public ET1 m(Object obj) {
        this.g = obj;
        this.h = true;
        return this;
    }

    private ET1(Object obj) {
        this.a = -2;
        this.b = 0;
        this.c = Integer.MAX_VALUE;
        this.d = 1.0f;
        this.e = 0;
        this.f = null;
        this.h = false;
        this.g = obj;
    }
}
