package ir.nasim;

import ir.nasim.C5032Hp3;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Tv1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC7937Tv1 {
    public static final byte[] a = new byte[0];

    /* renamed from: ir.nasim.Tv1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FN4.values().length];
            a = iArr;
            try {
                iArr[FN4.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FN4.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FN4.TINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FN4.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static byte[] a(C5032Hp3.c cVar) throws GeneralSecurityException {
        int i = a.a[cVar.Y().ordinal()];
        if (i == 1 || i == 2) {
            return ByteBuffer.allocate(5).put((byte) 0).putInt(cVar.X()).array();
        }
        if (i == 3) {
            return ByteBuffer.allocate(5).put((byte) 1).putInt(cVar.X()).array();
        }
        if (i == 4) {
            return a;
        }
        throw new GeneralSecurityException("unknown output prefix type");
    }
}
