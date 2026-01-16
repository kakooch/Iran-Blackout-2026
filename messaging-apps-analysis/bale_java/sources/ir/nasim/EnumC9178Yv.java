package ir.nasim;

/* renamed from: ir.nasim.Yv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC9178Yv {
    CARD_STATEMENT(1),
    LOAN_PAYMENT(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC9178Yv(int i) {
        this.a = i;
    }

    public static EnumC9178Yv p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : LOAN_PAYMENT : CARD_STATEMENT;
    }

    public int j() {
        return this.a;
    }
}
