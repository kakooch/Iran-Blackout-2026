package ir.nasim;

/* renamed from: ir.nasim.Sx, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C7714Sx extends AbstractC17902nl0 {
    private EnumC9196Yx a;
    private EnumC23583xA b;
    private String c;

    public C7714Sx(EnumC9196Yx enumC9196Yx, EnumC23583xA enumC23583xA, String str) {
        this.a = enumC9196Yx;
        this.b = enumC23583xA;
        this.c = str;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        int iH = c19084pl0.h(1, 0);
        if (iH != 0) {
            this.a = EnumC9196Yx.p(iH);
        }
        int iH2 = c19084pl0.h(2, 0);
        if (iH2 != 0) {
            this.b = EnumC23583xA.p(iH2);
        }
        this.c = c19084pl0.A(3);
    }

    public EnumC9196Yx q() {
        return this.a;
    }

    public EnumC23583xA r() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        EnumC9196Yx enumC9196Yx = this.a;
        if (enumC9196Yx != null) {
            c19675ql0.f(1, enumC9196Yx.j());
        }
        EnumC23583xA enumC23583xA = this.b;
        if (enumC23583xA != null) {
            c19675ql0.f(2, enumC23583xA.j());
        }
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
    }

    public String toString() {
        return "struct ExInfo{}";
    }

    public C7714Sx() {
    }
}
