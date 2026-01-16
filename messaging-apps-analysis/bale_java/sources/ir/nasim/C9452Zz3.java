package ir.nasim;

/* renamed from: ir.nasim.Zz3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C9452Zz3 extends TA4 {
    private String f;
    private String g;

    public C9452Zz3(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    @Override // ir.nasim.TA4
    public void a(NY7 ny7) {
        ny7.h(this);
    }

    @Override // ir.nasim.TA4
    protected String k() {
        return "destination=" + this.f + ", title=" + this.g;
    }

    public String m() {
        return this.f;
    }
}
