package ir.nasim;

/* renamed from: ir.nasim.yz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24653yz extends AbstractC17902nl0 {
    private Boolean a;
    private Boolean b;
    private Boolean c;
    private Boolean d;

    public C24653yz(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.a = bool;
        this.b = bool2;
        this.c = bool3;
        this.d = bool4;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Boolean.valueOf(c19084pl0.u(1));
        this.b = Boolean.valueOf(c19084pl0.u(2));
        this.c = Boolean.valueOf(c19084pl0.u(3));
        this.d = Boolean.valueOf(c19084pl0.u(4));
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Boolean bool = this.a;
        if (bool != null) {
            c19675ql0.a(1, bool.booleanValue());
        }
        Boolean bool2 = this.b;
        if (bool2 != null) {
            c19675ql0.a(2, bool2.booleanValue());
        }
        Boolean bool3 = this.c;
        if (bool3 != null) {
            c19675ql0.a(3, bool3.booleanValue());
        }
        Boolean bool4 = this.d;
        if (bool4 != null) {
            c19675ql0.a(4, bool4.booleanValue());
        }
    }

    public String toString() {
        return "struct MessageAttributes{}";
    }

    public C24653yz() {
    }
}
