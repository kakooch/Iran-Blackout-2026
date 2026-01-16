package ir.nasim;

/* renamed from: ir.nasim.wu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC23427wu {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");

    private final String a;

    EnumC23427wu(String str) {
        this.a = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC23427wu[] valuesCustom() {
        EnumC23427wu[] enumC23427wuArrValuesCustom = values();
        EnumC23427wu[] enumC23427wuArr = new EnumC23427wu[enumC23427wuArrValuesCustom.length];
        System.arraycopy(enumC23427wuArrValuesCustom, 0, enumC23427wuArr, 0, enumC23427wuArrValuesCustom.length);
        return enumC23427wuArr;
    }

    public final String a() {
        return this.a;
    }
}
