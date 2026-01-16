package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ok {
    private static final byte[] d = {0, 0, 1};
    public int a;
    public int b;
    public byte[] c = new byte[128];
    private boolean e;
    private int f;

    public final void a() {
        this.e = false;
        this.a = 0;
        this.f = 0;
    }

    public final boolean b(int i, int i2) {
        int i3 = this.f;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i == 179 || i == 181) {
                            this.a -= i2;
                            this.e = false;
                            return true;
                        }
                    } else if ((i & 240) != 32) {
                        Log.w("H263Reader", "Unexpected start code value");
                        a();
                    } else {
                        this.b = this.a;
                        this.f = 4;
                    }
                } else if (i > 31) {
                    Log.w("H263Reader", "Unexpected start code value");
                    a();
                } else {
                    this.f = 3;
                }
            } else if (i != 181) {
                Log.w("H263Reader", "Unexpected start code value");
                a();
            } else {
                this.f = 2;
            }
        } else if (i == 176) {
            this.f = 1;
            this.e = true;
        }
        c(d, 0, 3);
        return false;
    }

    public final void c(byte[] bArr, int i, int i2) {
        if (this.e) {
            int i3 = i2 - i;
            byte[] bArr2 = this.c;
            int length = bArr2.length;
            int i4 = this.a + i3;
            if (length < i4) {
                this.c = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.c, this.a, i3);
            this.a += i3;
        }
    }
}
