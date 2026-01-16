package ir.nasim;

/* renamed from: ir.nasim.b72, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10125b72 implements QH1 {
    private final char a;

    protected AbstractC10125b72(char c) {
        this.a = c;
    }

    @Override // ir.nasim.QH1
    public void a(C5693Kk7 c5693Kk7, C5693Kk7 c5693Kk72, int i) {
        if (i == 2) {
            return;
        }
        Z62 z62 = new Z62(String.valueOf(d()));
        TA4 ta4E = c5693Kk7.e();
        while (ta4E != null && ta4E != c5693Kk72) {
            TA4 ta4E2 = ta4E.e();
            z62.b(ta4E);
            ta4E = ta4E2;
        }
        c5693Kk7.h(z62);
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
