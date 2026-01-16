package ir.nasim;

/* renamed from: ir.nasim.Bu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC3654Bu {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(null, 1, null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");

    private final String a;

    EnumC3654Bu(String str) {
        if (str == null) {
            String strName = name();
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            str = strName.toLowerCase();
            AbstractC13042fc3.h(str, "(this as java.lang.String).toLowerCase()");
        }
        this.a = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC3654Bu[] valuesCustom() {
        EnumC3654Bu[] enumC3654BuArrValuesCustom = values();
        EnumC3654Bu[] enumC3654BuArr = new EnumC3654Bu[enumC3654BuArrValuesCustom.length];
        System.arraycopy(enumC3654BuArrValuesCustom, 0, enumC3654BuArr, 0, enumC3654BuArrValuesCustom.length);
        return enumC3654BuArr;
    }

    public final String a() {
        return this.a;
    }

    /* synthetic */ EnumC3654Bu(String str, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str);
    }
}
