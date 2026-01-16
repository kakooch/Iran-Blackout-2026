package ir.nasim;

/* loaded from: classes5.dex */
public class OG3 extends AbstractC19230q0 {
    private String a;
    private String b;
    private int c;
    private String d;
    private RG3 e;
    private String f;

    public OG3(String str, String str2, String str3, int i, String str4, RG3 rg3) {
        this.a = str;
        this.b = str2;
        this.f = str3;
        this.c = i;
        this.d = str4;
        this.e = rg3;
    }

    public String getCaption() {
        return this.f;
    }

    public String getFileName() {
        return this.a;
    }

    public int getFileSize() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.r(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.g(3);
        this.d = c19084pl0.r(4);
        byte[] bArrV = c19084pl0.v(5);
        if (bArrV != null) {
            this.e = new RG3(bArrV);
        }
        if (c19084pl0.t()) {
            this.f = c19084pl0.r(6);
        }
    }

    public RG3 s() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.o(1, this.a);
        c19675ql0.o(2, this.b);
        c19675ql0.f(3, this.c);
        c19675ql0.o(4, this.d);
        RG3 rg3 = this.e;
        if (rg3 != null) {
            c19675ql0.i(5, rg3);
        }
        c19675ql0.o(6, this.f);
    }

    public String u() {
        return this.b;
    }

    public String w() {
        return this.d;
    }

    public OG3(byte[] bArr) {
        load(bArr);
    }
}
