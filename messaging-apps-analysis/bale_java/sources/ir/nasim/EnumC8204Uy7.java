package ir.nasim;

/* renamed from: ir.nasim.Uy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC8204Uy7 {
    IN("in"),
    OUT("out"),
    INV("");

    private final String a;

    EnumC8204Uy7(String str) {
        this.a = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC8204Uy7[] valuesCustom() {
        EnumC8204Uy7[] enumC8204Uy7ArrValuesCustom = values();
        EnumC8204Uy7[] enumC8204Uy7Arr = new EnumC8204Uy7[enumC8204Uy7ArrValuesCustom.length];
        System.arraycopy(enumC8204Uy7ArrValuesCustom, 0, enumC8204Uy7Arr, 0, enumC8204Uy7ArrValuesCustom.length);
        return enumC8204Uy7Arr;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
