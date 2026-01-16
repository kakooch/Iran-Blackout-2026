package ir.nasim;

/* loaded from: classes8.dex */
public enum KQ7 {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);

    private final String a;
    private final boolean b;
    private final boolean c;
    private final int d;

    KQ7(String str, boolean z, boolean z2, int i) {
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = i;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static KQ7[] valuesCustom() {
        KQ7[] kq7ArrValuesCustom = values();
        KQ7[] kq7Arr = new KQ7[kq7ArrValuesCustom.length];
        System.arraycopy(kq7ArrValuesCustom, 0, kq7Arr, 0, kq7ArrValuesCustom.length);
        return kq7Arr;
    }

    public final boolean a() {
        return this.c;
    }

    public final String j() {
        return this.a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
