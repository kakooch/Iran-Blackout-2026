package ir.nasim;

/* loaded from: classes4.dex */
public class AB extends AbstractC17902nl0 {
    private boolean a;
    private Boolean b;

    public AB(boolean z, Boolean bool) {
        this.a = z;
        this.b = bool;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.b(1);
        this.b = Boolean.valueOf(c19084pl0.u(2));
    }

    public boolean q() {
        return this.a;
    }

    public Boolean r() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.a);
        Boolean bool = this.b;
        if (bool != null) {
            c19675ql0.a(2, bool.booleanValue());
        }
    }

    public String toString() {
        return "struct ReplyKeyboardRemove{}";
    }

    public AB() {
    }
}
