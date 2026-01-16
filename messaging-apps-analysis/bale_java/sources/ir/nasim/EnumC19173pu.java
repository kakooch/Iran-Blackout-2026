package ir.nasim;

/* renamed from: ir.nasim.pu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC19173pu {
    NO_ARGUMENTS(false, false, 3, null),
    UNLESS_EMPTY(true, false, 2, null),
    ALWAYS_PARENTHESIZED(true, true);

    private final boolean a;
    private final boolean b;

    EnumC19173pu(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC19173pu[] valuesCustom() {
        EnumC19173pu[] enumC19173puArrValuesCustom = values();
        EnumC19173pu[] enumC19173puArr = new EnumC19173pu[enumC19173puArrValuesCustom.length];
        System.arraycopy(enumC19173puArrValuesCustom, 0, enumC19173puArr, 0, enumC19173puArrValuesCustom.length);
        return enumC19173puArr;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean j() {
        return this.b;
    }

    /* synthetic */ EnumC19173pu(boolean z, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
