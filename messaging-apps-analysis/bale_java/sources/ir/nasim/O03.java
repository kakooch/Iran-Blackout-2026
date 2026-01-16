package ir.nasim;

/* loaded from: classes8.dex */
public class O03 extends TA4 {
    private String f;
    private String g;

    public O03(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    @Override // ir.nasim.TA4
    public void a(NY7 ny7) {
        ny7.b(this);
    }

    @Override // ir.nasim.TA4
    protected String k() {
        return "destination=" + this.f + ", title=" + this.g;
    }
}
