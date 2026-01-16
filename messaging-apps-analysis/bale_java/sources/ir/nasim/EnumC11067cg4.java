package ir.nasim;

/* renamed from: ir.nasim.cg4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC11067cg4 {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;

    public static final a a = new a(null);

    /* renamed from: ir.nasim.cg4$a */
    public static final class a {
        private a() {
        }

        public final EnumC11067cg4 a(boolean z, boolean z2, boolean z3) {
            return z ? EnumC11067cg4.SEALED : z2 ? EnumC11067cg4.ABSTRACT : z3 ? EnumC11067cg4.OPEN : EnumC11067cg4.FINAL;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11067cg4[] valuesCustom() {
        EnumC11067cg4[] enumC11067cg4ArrValuesCustom = values();
        EnumC11067cg4[] enumC11067cg4Arr = new EnumC11067cg4[enumC11067cg4ArrValuesCustom.length];
        System.arraycopy(enumC11067cg4ArrValuesCustom, 0, enumC11067cg4Arr, 0, enumC11067cg4ArrValuesCustom.length);
        return enumC11067cg4Arr;
    }
}
