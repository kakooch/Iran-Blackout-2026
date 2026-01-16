package ir.nasim;

/* renamed from: ir.nasim.Au1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C3417Au1 {
    private boolean a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private int i;
    private float j;
    private float k;
    private float l;
    private float m;

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3417Au1 clone() {
        C3417Au1 c3417Au1 = new C3417Au1();
        c3417Au1.a = this.a;
        c3417Au1.b = this.b;
        c3417Au1.c = this.c;
        c3417Au1.d = this.d;
        c3417Au1.e = this.e;
        c3417Au1.f = this.f;
        c3417Au1.g = this.g;
        c3417Au1.h = this.h;
        c3417Au1.i = this.i;
        c3417Au1.j = this.j;
        c3417Au1.k = this.k;
        c3417Au1.l = this.l;
        c3417Au1.m = this.m;
        return c3417Au1;
    }

    public float b() {
        return this.d;
    }

    public float c() {
        return this.e;
    }

    public float d() {
        return this.k;
    }

    public float e() {
        return this.j;
    }

    public float f() {
        return this.b;
    }

    public float g() {
        return this.c;
    }

    public float h() {
        return this.m;
    }

    public int i() {
        return this.i;
    }

    public float j() {
        return this.g;
    }

    public float k() {
        return this.f;
    }

    public float l() {
        return this.l;
    }

    public boolean m() {
        return this.a;
    }

    public boolean n() {
        return this.h;
    }

    public void o(boolean z) {
        this.a = z;
    }

    public void p(boolean z, float f, float f2, float f3, int i, float f4, float f5, float f6, float f7, float f8, float f9, float f10, boolean z2) {
        this.a = z;
        this.b = f;
        this.c = f2;
        this.f = f4;
        this.g = f3;
        this.i = i;
        while (true) {
            int i2 = this.i;
            if (i2 >= 0) {
                break;
            } else {
                this.i = i2 + 360;
            }
        }
        while (true) {
            int i3 = this.i;
            if (i3 < 360) {
                this.j = f7;
                this.k = f8;
                this.d = f9;
                this.e = f10;
                this.l = f5;
                this.m = f6;
                this.h = z2;
                return;
            }
            this.i = i3 - 360;
        }
    }
}
