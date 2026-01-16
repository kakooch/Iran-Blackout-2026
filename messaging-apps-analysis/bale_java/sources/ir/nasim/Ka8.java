package ir.nasim;

/* loaded from: classes2.dex */
public final class Ka8 implements InterfaceC24524yl6 {
    private final CharSequence a;
    private final Ja8 b;

    public Ka8(CharSequence charSequence, Ja8 ja8) {
        this.a = charSequence;
        this.b = ja8;
    }

    @Override // ir.nasim.InterfaceC24524yl6
    public int a(int i) {
        do {
            i = this.b.p(i);
            if (i == -1 || i == this.a.length()) {
                return -1;
            }
        } while (Character.isWhitespace(this.a.charAt(i)));
        return i;
    }

    @Override // ir.nasim.InterfaceC24524yl6
    public int b(int i) {
        do {
            i = this.b.q(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(this.a.charAt(i)));
        return i;
    }

    @Override // ir.nasim.InterfaceC24524yl6
    public int c(int i) {
        do {
            i = this.b.p(i);
            if (i == -1) {
                return -1;
            }
        } while (Character.isWhitespace(this.a.charAt(i - 1)));
        return i;
    }

    @Override // ir.nasim.InterfaceC24524yl6
    public int d(int i) {
        do {
            i = this.b.q(i);
            if (i == -1 || i == 0) {
                return -1;
            }
        } while (Character.isWhitespace(this.a.charAt(i - 1)));
        return i;
    }
}
