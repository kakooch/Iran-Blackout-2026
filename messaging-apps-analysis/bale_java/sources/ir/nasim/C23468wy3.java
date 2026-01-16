package ir.nasim;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: ir.nasim.wy3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23468wy3 implements WL3 {
    private static final byte[] d = {0};
    private final WL3 a;
    private final FN4 b;
    private final byte[] c;

    /* renamed from: ir.nasim.wy3$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FN4.values().length];
            a = iArr;
            try {
                iArr[FN4.RAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FN4.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FN4.CRUNCHY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FN4.TINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private C23468wy3(WL3 wl3, FN4 fn4, byte[] bArr) {
        this.a = wl3;
        this.b = fn4;
        this.c = bArr;
    }

    public static WL3 c(C6048Ly3 c6048Ly3) throws GeneralSecurityException {
        byte[] bArrArray;
        C19799qx5 c19799qx5B = c6048Ly3.b(J93.a());
        WL3 wl3 = (WL3) BM5.e().b((C20317ro3) C20317ro3.Z().q(c19799qx5B.f()).r(c19799qx5B.g()).p(c19799qx5B.d()).e(), WL3.class);
        FN4 fn4E = c19799qx5B.e();
        int i = a.a[fn4E.ordinal()];
        if (i == 1) {
            bArrArray = new byte[0];
        } else if (i == 2 || i == 3) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(c6048Ly3.a().intValue()).array();
        } else {
            if (i != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(c6048Ly3.a().intValue()).array();
        }
        return new C23468wy3(wl3, fn4E, bArrArray);
    }

    @Override // ir.nasim.WL3
    public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 10) {
            throw new GeneralSecurityException("tag too short");
        }
        if (this.b.equals(FN4.LEGACY)) {
            bArr2 = AbstractC8841Xo0.a(bArr2, d);
        }
        byte[] bArr3 = new byte[0];
        if (!this.b.equals(FN4.RAW)) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            bArr = Arrays.copyOfRange(bArr, 5, bArr.length);
            bArr3 = bArrCopyOf;
        }
        if (!Arrays.equals(this.c, bArr3)) {
            throw new GeneralSecurityException("wrong prefix");
        }
        this.a.a(bArr, bArr2);
    }

    @Override // ir.nasim.WL3
    public byte[] b(byte[] bArr) throws GeneralSecurityException {
        if (this.b.equals(FN4.LEGACY)) {
            bArr = AbstractC8841Xo0.a(bArr, d);
        }
        return AbstractC8841Xo0.a(this.c, this.a.b(bArr));
    }
}
