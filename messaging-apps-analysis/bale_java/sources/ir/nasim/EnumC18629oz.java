package ir.nasim;

/* renamed from: ir.nasim.oz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC18629oz {
    UNKNOWN(0),
    NONE_INSTALLMENT_FACILITIES(1),
    NORMALL_INSTALLMENT_FACILITIES(2),
    STAGE_INSTALLMENT_FACILITIES(3),
    OTHER_FACILITITES(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC18629oz(int i) {
        this.a = i;
    }

    public static EnumC18629oz p(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : OTHER_FACILITITES : STAGE_INSTALLMENT_FACILITIES : NORMALL_INSTALLMENT_FACILITIES : NONE_INSTALLMENT_FACILITIES : UNKNOWN;
    }

    public int j() {
        return this.a;
    }
}
