package ir.nasim;

/* renamed from: ir.nasim.a72, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9531a72 implements QH1 {
    private final char a;

    protected AbstractC9531a72(char c) {
        this.a = c;
    }

    @Override // ir.nasim.QH1
    public void a(C5693Kk7 c5693Kk7, C5693Kk7 c5693Kk72, int i) {
        TA4 bz6;
        String strValueOf = String.valueOf(d());
        if (i == 1) {
            bz6 = new Z62(strValueOf);
        } else {
            bz6 = new BZ6(strValueOf + strValueOf);
        }
        TA4 ta4E = c5693Kk7.e();
        while (ta4E != null && ta4E != c5693Kk72) {
            TA4 ta4E2 = ta4E.e();
            bz6.b(ta4E);
            ta4E = ta4E2;
        }
        c5693Kk7.h(bz6);
    }

    @Override // ir.nasim.QH1
    public char b() {
        return this.a;
    }

    @Override // ir.nasim.QH1
    public int c() {
        return 1;
    }

    @Override // ir.nasim.QH1
    public char d() {
        return this.a;
    }

    @Override // ir.nasim.QH1
    public int e(RH1 rh1, RH1 rh12) {
        if ((rh1.a() || rh12.c()) && rh12.b() % 3 != 0 && (rh1.b() + rh12.b()) % 3 == 0) {
            return 0;
        }
        return (rh1.length() < 2 || rh12.length() < 2) ? 1 : 2;
    }
}
