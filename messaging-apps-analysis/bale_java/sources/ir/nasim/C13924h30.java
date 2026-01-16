package ir.nasim;

/* renamed from: ir.nasim.h30, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C13924h30 extends AbstractC12750f83 {
    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        int i = this.d;
        this.d = i + 1;
        if (j() != '[') {
            return null;
        }
        this.d++;
        C5693Kk7 c5693Kk7O = o("![");
        a(C6652Ok0.a(c5693Kk7O, i + 1, b(), c()));
        return c5693Kk7O;
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '!';
    }
}
