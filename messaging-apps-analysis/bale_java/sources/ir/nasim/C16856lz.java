package ir.nasim;

/* renamed from: ir.nasim.lz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16856lz extends AbstractC17902nl0 {
    private Boolean a;
    private Boolean b;
    private String c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = Boolean.valueOf(c19084pl0.u(1));
        this.b = Boolean.valueOf(c19084pl0.u(2));
        this.c = c19084pl0.A(3);
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
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
    }

    public String toString() {
        return "struct LoadMembersCondition{}";
    }
}
