package ir.nasim;

/* renamed from: ir.nasim.Ok0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C6652Ok0 {
    public final C5693Kk7 a;
    public final int b;
    public final boolean c;
    public final C6652Ok0 d;
    public final PH1 e;
    public boolean f = true;
    public boolean g = false;

    private C6652Ok0(C5693Kk7 c5693Kk7, int i, C6652Ok0 c6652Ok0, PH1 ph1, boolean z) {
        this.a = c5693Kk7;
        this.b = i;
        this.c = z;
        this.d = c6652Ok0;
        this.e = ph1;
    }

    public static C6652Ok0 a(C5693Kk7 c5693Kk7, int i, C6652Ok0 c6652Ok0, PH1 ph1) {
        return new C6652Ok0(c5693Kk7, i, c6652Ok0, ph1, true);
    }

    public static C6652Ok0 b(C5693Kk7 c5693Kk7, int i, C6652Ok0 c6652Ok0, PH1 ph1) {
        return new C6652Ok0(c5693Kk7, i, c6652Ok0, ph1, false);
    }
}
