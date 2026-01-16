package ir.nasim;

/* renamed from: ir.nasim.gx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C13865gx extends AbstractC17902nl0 {
    private EnumC14458hx a;
    private String b;
    private Long c;
    private String d;
    private String e;
    private String f;

    public C13865gx(EnumC14458hx enumC14458hx, String str, Long l, String str2, String str3, String str4) {
        this.a = enumC14458hx;
        this.b = str;
        this.c = l;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC14458hx.p(iH);
        }
        this.b = c19084pl0.A(2);
        this.c = Long.valueOf(c19084pl0.y(3));
        this.d = c19084pl0.A(4);
        this.e = c19084pl0.A(5);
        this.f = c19084pl0.A(6);
    }

    public Long q() {
        return this.c;
    }

    public String r() {
        return this.b;
    }

    public String s() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC14458hx enumC14458hx = this.a;
        if (enumC14458hx != null) {
            c19675ql0.f(1, enumC14458hx.j());
        }
        String str = this.b;
        if (str != null) {
            c19675ql0.o(2, str);
        }
        Long l = this.c;
        if (l != null) {
            c19675ql0.g(3, l.longValue());
        }
        String str2 = this.d;
        if (str2 != null) {
            c19675ql0.o(4, str2);
        }
        String str3 = this.e;
        if (str3 != null) {
            c19675ql0.o(5, str3);
        }
        String str4 = this.f;
        if (str4 != null) {
            c19675ql0.o(6, str4);
        }
    }

    public String toString() {
        return "struct ContactRecord{}";
    }

    public EnumC14458hx u() {
        return this.a;
    }

    public C13865gx() {
    }
}
