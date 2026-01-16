package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class ape implements apd {
    protected DisplayMetrics a;
    protected final apm b;
    private final app c;

    protected ape(Context context, apm apmVar, app appVar) {
        this.b = apmVar;
        this.c = appVar;
        try {
            this.a = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException unused) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.a = displayMetrics;
            displayMetrics.density = 1.0f;
        }
    }

    private final void e() {
        this.c.a();
    }

    private final byte[] f() throws IOException {
        return this.c.d();
    }

    private final String g(Context context, boolean z) throws NoSuchAlgorithmException {
        byte[] bArrF;
        byte[] bArrArray;
        try {
            synchronized (this) {
                e();
                b(context);
                bArrF = f();
            }
            int length = bArrF.length;
            if (length == 0) {
                return Integer.toString(5);
            }
            if (length > 239) {
                e();
                c(20, 1L);
                bArrF = f();
            }
            int length2 = bArrF.length;
            if (length2 < 239) {
                byte[] bArr = new byte[239 - length2];
                new SecureRandom().nextBytes(bArr);
                bArrArray = ByteBuffer.allocate(240).put((byte) length2).put(bArrF).put(bArr).array();
            } else {
                bArrArray = ByteBuffer.allocate(240).put((byte) length2).put(bArrF).array();
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArrArray);
            byte[] bArrArray2 = ByteBuffer.allocate(256).put(messageDigest.digest()).put(bArrArray).array();
            byte[] bArr2 = new byte[256];
            aop[] aopVarArr = new apc().cN;
            int length3 = aopVarArr.length;
            for (int i = 0; i < 12; i++) {
                aopVarArr[i].a(bArrArray2, bArr2);
            }
            return this.b.b(bArr2);
        } catch (UnsupportedEncodingException unused) {
            return Integer.toString(7);
        } catch (IOException unused2) {
            return Integer.toString(3);
        } catch (NoSuchAlgorithmException unused3) {
            return Integer.toString(7);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.apd
    public final String a(Context context) {
        return g(context, false);
    }

    protected abstract void b(Context context);

    protected final void c(int i, long j) throws IOException {
        this.c.b(i, j);
    }

    protected final void d(int i, String str) throws IOException {
        this.c.c(i, str);
    }
}
