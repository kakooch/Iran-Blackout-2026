package ir.nasim;

import ir.nasim.C20317ro3;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Ly3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6048Ly3 extends AbstractC14981io3 {
    private final C19799qx5 a;

    /* renamed from: ir.nasim.Ly3$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[C20317ro3.c.values().length];
            b = iArr;
            try {
                iArr[C20317ro3.c.SYMMETRIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[C20317ro3.c.ASYMMETRIC_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[FN4.values().length];
            a = iArr2;
            try {
                iArr2[FN4.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FN4.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[FN4.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[FN4.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public C6048Ly3(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        c(c19799qx5, c19060pi6);
        this.a = c19799qx5;
    }

    private static void c(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        int i = a.b[c19799qx5.d().ordinal()];
        if (i == 1 || i == 2) {
            C19060pi6.b(c19060pi6);
        }
    }

    public Integer a() {
        return this.a.c();
    }

    public C19799qx5 b(C19060pi6 c19060pi6) throws GeneralSecurityException {
        c(this.a, c19060pi6);
        return this.a;
    }
}
