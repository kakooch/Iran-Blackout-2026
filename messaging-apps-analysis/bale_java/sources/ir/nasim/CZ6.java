package ir.nasim;

/* loaded from: classes3.dex */
public abstract class CZ6 implements QH1 {
    private final char a;

    protected CZ6(char c) {
        this.a = c;
    }

    @Override // ir.nasim.QH1
    public void a(C5693Kk7 c5693Kk7, C5693Kk7 c5693Kk72, int i) {
        if (i == 2) {
            return;
        }
        BZ6 bz6 = new BZ6(String.valueOf(d()));
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
        return (rh1.length() < 2 || rh12.length() < 2) ? 1 : 2;
    }
}
