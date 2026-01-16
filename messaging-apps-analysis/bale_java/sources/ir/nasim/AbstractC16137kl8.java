package ir.nasim;

/* renamed from: ir.nasim.kl8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract /* synthetic */ class AbstractC16137kl8 {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[Dl8.values().length];
        b = iArr;
        try {
            iArr[Dl8.k.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[Dl8.m.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[Dl8.j.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[EnumC17910nl8.values().length];
        a = iArr2;
        try {
            iArr2[EnumC17910nl8.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[EnumC17910nl8.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[EnumC17910nl8.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
