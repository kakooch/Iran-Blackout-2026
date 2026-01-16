package ir.nasim;

/* renamed from: ir.nasim.xP5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC23724xP5 {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");

    public static final a b = new a(null);
    private final String a;

    /* renamed from: ir.nasim.xP5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    EnumC23724xP5(String str) {
        this.a = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC23724xP5[] valuesCustom() {
        EnumC23724xP5[] enumC23724xP5ArrValuesCustom = values();
        EnumC23724xP5[] enumC23724xP5Arr = new EnumC23724xP5[enumC23724xP5ArrValuesCustom.length];
        System.arraycopy(enumC23724xP5ArrValuesCustom, 0, enumC23724xP5Arr, 0, enumC23724xP5ArrValuesCustom.length);
        return enumC23724xP5Arr;
    }

    public final String a() {
        return this.a;
    }

    public final boolean j() {
        return this == IGNORE;
    }

    public final boolean p() {
        return this == WARN;
    }
}
