package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aem implements acw {
    private aem() {
    }

    /* synthetic */ aem(byte[] bArr) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void b() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void c() throws IOException {
        synchronized (aen.a) {
            synchronized (aen.b) {
                if (aen.c) {
                    return;
                }
                long jG = aen.g();
                synchronized (aen.b) {
                    aen.d = jG;
                    aen.c = true;
                }
            }
        }
    }
}
