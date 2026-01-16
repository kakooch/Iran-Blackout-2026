package ir.nasim;

/* renamed from: ir.nasim.Kk7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C5693Kk7 extends TA4 {
    private String f;

    public C5693Kk7(String str) {
        this.f = str;
    }

    @Override // ir.nasim.TA4
    public void a(NY7 ny7) {
        ny7.y(this);
    }

    @Override // ir.nasim.TA4
    protected String k() {
        return "literal=" + this.f;
    }

    public String m() {
        return this.f;
    }

    public void n(String str) {
        this.f = str;
    }
}
