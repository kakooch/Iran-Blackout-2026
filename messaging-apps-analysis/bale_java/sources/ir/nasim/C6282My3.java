package ir.nasim;

import java.util.Objects;

/* renamed from: ir.nasim.My3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6282My3 extends AbstractC20124rW4 {
    private final C22275ux5 a;

    /* renamed from: ir.nasim.My3$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FN4.values().length];
            a = iArr;
            try {
                iArr[FN4.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FN4.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FN4.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FN4.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C6282My3(C22275ux5 c22275ux5) {
        this.a = c22275ux5;
    }

    private static String c(FN4 fn4) {
        int i = a.a[fn4.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
    }

    public C22275ux5 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C6282My3)) {
            return false;
        }
        C22275ux5 c22275ux5 = ((C6282My3) obj).a;
        return this.a.d().W().equals(c22275ux5.d().W()) && this.a.d().X().equals(c22275ux5.d().X()) && this.a.d().Y().equals(c22275ux5.d().Y());
    }

    public int hashCode() {
        return Objects.hash(this.a.d(), this.a.a());
    }

    public String toString() {
        return String.format("(typeUrl=%s, outputPrefixType=%s)", this.a.d().X(), c(this.a.d().W()));
    }
}
