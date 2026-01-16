package ir.nasim;

/* loaded from: classes4.dex */
public class RA extends AbstractC17902nl0 {
    private long a;
    private String b;

    public RA(long j, String str) {
        this.a = j;
        this.b = str;
    }

    public String getName() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.A(2);
    }

    public long q() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str != null) {
            c19675ql0.o(2, str);
        }
    }

    public String toString() {
        return "struct PhoneToImport{}";
    }

    public RA() {
    }
}
