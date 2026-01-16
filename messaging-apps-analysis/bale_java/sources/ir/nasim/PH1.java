package ir.nasim;

/* loaded from: classes8.dex */
public class PH1 implements RH1 {
    public final C5693Kk7 a;
    public final char b;
    public final boolean c;
    public final boolean d;
    public PH1 e;
    public PH1 f;
    public int g = 1;
    public int h = 1;

    public PH1(C5693Kk7 c5693Kk7, char c, boolean z, boolean z2, PH1 ph1) {
        this.a = c5693Kk7;
        this.b = c;
        this.c = z;
        this.d = z2;
        this.e = ph1;
    }

    @Override // ir.nasim.RH1
    public boolean a() {
        return this.d;
    }

    @Override // ir.nasim.RH1
    public int b() {
        return this.h;
    }

    @Override // ir.nasim.RH1
    public boolean c() {
        return this.c;
    }

    @Override // ir.nasim.RH1
    public int length() {
        return this.g;
    }
}
