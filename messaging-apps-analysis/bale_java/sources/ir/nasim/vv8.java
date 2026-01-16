package ir.nasim;

/* loaded from: classes3.dex */
abstract class vv8 extends Fq8 {
    final CharSequence c;
    final AbstractC9994at8 d;
    final boolean e;
    int f = 0;
    int g = Integer.MAX_VALUE;

    protected vv8(Cv8 cv8, CharSequence charSequence) {
        this.d = cv8.a;
        this.e = cv8.b;
        this.c = charSequence;
    }

    @Override // ir.nasim.Fq8
    protected final /* bridge */ /* synthetic */ Object a() {
        int iD;
        int iC;
        int i = this.f;
        while (true) {
            int i2 = this.f;
            if (i2 == -1) {
                b();
                return null;
            }
            iD = d(i2);
            if (iD == -1) {
                iD = this.c.length();
                this.f = -1;
                iC = -1;
            } else {
                iC = c(iD);
                this.f = iC;
            }
            if (iC == i) {
                int i3 = iC + 1;
                this.f = i3;
                if (i3 > this.c.length()) {
                    this.f = -1;
                }
            } else {
                if (i < iD) {
                    this.c.charAt(i);
                }
                if (i < iD) {
                    this.c.charAt(iD - 1);
                }
                if (!this.e || i != iD) {
                    break;
                }
                i = this.f;
            }
        }
        int i4 = this.g;
        if (i4 == 1) {
            iD = this.c.length();
            this.f = -1;
            if (iD > i) {
                this.c.charAt(iD - 1);
            }
        } else {
            this.g = i4 - 1;
        }
        return this.c.subSequence(i, iD).toString();
    }

    abstract int c(int i);

    abstract int d(int i);
}
