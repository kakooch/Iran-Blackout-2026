package ir.nasim;

/* renamed from: ir.nasim.gH0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C13466gH0 extends AbstractC17902nl0 implements HB3 {
    public static InterfaceC17311ml0 i = new InterfaceC17311ml0() { // from class: ir.nasim.fH0
        @Override // ir.nasim.InterfaceC17311ml0
        public final Object a() {
            return new C13466gH0();
        }
    };
    private String a;
    private String b;
    private long c;
    private Y50 d;
    private String e;
    private String f;
    private long g;
    private boolean h;

    public C13466gH0() {
        this.a = "";
        this.b = "000000:0000";
        this.c = AbstractC20507s76.o();
        this.d = Y50.d;
        this.e = "0000";
        this.f = "";
        this.g = q("000000", "0000");
        this.h = false;
    }

    public void C(boolean z) {
        this.h = z;
    }

    @Override // ir.nasim.HB3
    public long a() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C13466gH0) {
            return ((C13466gH0) obj).g == this.g;
        }
        if (!(obj instanceof String)) {
            return super.equals(obj);
        }
        String str = (String) obj;
        return str.length() > 12 && str.substring(12).equals(this.e) && AbstractC19902r80.d(str).equals(this.d);
    }

    public String getName() {
        return this.b;
    }

    @Override // ir.nasim.HB3
    public long j() {
        return this.c;
    }

    @Override // ir.nasim.HB3
    public String p() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.s(1, "000000:0000");
        this.g = c19084pl0.j(2, -1L);
        this.c = c19084pl0.j(3, 0L);
        this.d = Y50.p(c19084pl0.h(4, 0));
        this.e = c19084pl0.s(5, "");
        try {
            this.f = c19084pl0.s(6, "");
        } catch (Exception unused) {
            this.f = "";
        }
        this.a = c19084pl0.s(7, "");
        this.h = c19084pl0.c(8, false);
    }

    public long q(String str, String str2) {
        String str3 = str + str2;
        if (str3.length() != 10) {
            return -1L;
        }
        try {
            return Long.parseLong(str3);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public Y50 r() {
        return this.d;
    }

    public long s() {
        return this.g;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.o(1, this.b);
        c19675ql0.g(2, this.g);
        c19675ql0.g(3, this.c);
        c19675ql0.f(4, this.d.a);
        c19675ql0.o(5, this.e);
        c19675ql0.o(6, this.f);
        c19675ql0.o(7, this.a);
        c19675ql0.a(8, this.h);
    }

    public String u() {
        return this.e;
    }

    public String w() {
        return this.f;
    }

    public String y() {
        return this.a;
    }

    public boolean z() {
        return this.h;
    }

    public C13466gH0(String str) {
        try {
            String strQ = XY6.q(XY6.h(str));
            this.a = "";
            String strSubstring = strQ.substring(0, 6);
            this.d = AbstractC19902r80.e(strSubstring);
            this.e = strQ.substring(12);
            this.b = strSubstring + ":" + this.e;
            this.c = AbstractC20507s76.o();
            this.f = "";
            this.g = q(strSubstring, this.e);
            this.h = false;
        } catch (Exception unused) {
            new C13466gH0();
        }
    }

    public C13466gH0(String str, String str2) {
        try {
            String strQ = XY6.q(XY6.h(str2));
            this.a = "";
            String strSubstring = strQ.substring(0, 6);
            this.d = AbstractC19902r80.e(strSubstring);
            this.e = strQ.substring(12);
            this.b = strSubstring + ":" + this.e;
            this.f = str;
            this.c = AbstractC20507s76.o();
            this.g = q(strSubstring, this.e);
            this.h = false;
        } catch (Exception unused) {
            new C13466gH0();
        }
    }
}
