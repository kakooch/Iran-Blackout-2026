package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Arrays;
import org.rbmain.messenger.LiteMode;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class wa extends vt {
    private byte[] a;
    private volatile boolean b;

    public wa(abx abxVar, acb acbVar, cy cyVar, int i, Object obj, byte[] bArr) {
        wa waVar;
        byte[] bArr2;
        super(abxVar, acbVar, 3, cyVar, i, obj, -9223372036854775807L, -9223372036854775807L);
        if (bArr == null) {
            bArr2 = aeu.f;
            waVar = this;
        } else {
            waVar = this;
            bArr2 = bArr;
        }
        waVar.a = bArr2;
    }

    public final byte[] a() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void b() {
        this.b = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void c() throws IOException {
        try {
            this.k.c(this.d);
            int iA = 0;
            int i = 0;
            while (iA != -1 && !this.b) {
                byte[] bArr = this.a;
                int length = bArr.length;
                if (length < i + LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM) {
                    this.a = Arrays.copyOf(bArr, length + LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
                }
                iA = this.k.a(this.a, i, LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
                if (iA != -1) {
                    i += iA;
                }
            }
            if (!this.b) {
                d(this.a, i);
            }
        } finally {
            aeu.q(this.k);
        }
    }

    protected abstract void d(byte[] bArr, int i) throws IOException;
}
