package ir.nasim;

import android.graphics.Bitmap;
import android.os.Build;
import ir.nasim.FT1;
import kotlin.NoWhenBranchMatchedException;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: ir.nasim.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC18047o {

    /* renamed from: ir.nasim.o$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC14254hc6.values().length];
            try {
                iArr[EnumC14254hc6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC14254hc6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final long a(BufferedSource bufferedSource, ByteString byteString, long j, long j2) {
        if (byteString.size() <= 0) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        byte b = byteString.getByte(0);
        long size = j2 - byteString.size();
        long j3 = j;
        while (j3 < size) {
            long jIndexOf = bufferedSource.indexOf(b, j3, size);
            if (jIndexOf == -1 || bufferedSource.rangeEquals(jIndexOf, byteString)) {
                return jIndexOf;
            }
            j3 = jIndexOf + 1;
        }
        return -1L;
    }

    public static final boolean b(Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    public static final float c(FT1 ft1, EnumC14254hc6 enumC14254hc6) {
        if (ft1 instanceof FT1.a) {
            return ((FT1.a) ft1).a;
        }
        int i = a.a[enumC14254hc6.ordinal()];
        if (i == 1) {
            return Float.MIN_VALUE;
        }
        if (i == 2) {
            return Float.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Bitmap.Config d(Bitmap.Config config) {
        return (config == null || b(config)) ? Bitmap.Config.ARGB_8888 : config;
    }
}
