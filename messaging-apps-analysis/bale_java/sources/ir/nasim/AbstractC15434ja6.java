package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: ir.nasim.ja6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15434ja6 {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private static final ExecutorService b;

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        AbstractC13042fc3.e(executorServiceNewSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        b = executorServiceNewSingleThreadExecutor;
    }

    public static final byte a(byte b2) {
        if (b2 == -128) {
            return (byte) 127;
        }
        return (-127 <= b2 && b2 <= 0) ? (byte) (-b2) : b2;
    }

    public static final Handler b() {
        return a;
    }

    public static final ExecutorService c() {
        return b;
    }

    public static final byte[] d(byte[] bArr, byte[] bArr2) {
        AbstractC13042fc3.j(bArr, "$receiver");
        AbstractC13042fc3.j(bArr2, "other");
        int i = 0;
        if (bArr.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b2 = bArr[i];
            int i3 = i2 + 1;
            bArr[i2] = (i2 < 0 || i2 > AbstractC10242bK.h0(bArr2)) ? a(bArr[i2]) : bArr2[i2];
            i++;
            i2 = i3;
        }
        return bArr;
    }
}
