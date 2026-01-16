package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class ra {
    public final qz a(iw iwVar) {
        ByteBuffer byteBuffer = iwVar.b;
        ary.t(byteBuffer);
        boolean z = false;
        if (byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            z = true;
        }
        ary.o(z);
        if (iwVar.b()) {
            return null;
        }
        return b(byteBuffer);
    }

    protected abstract qz b(ByteBuffer byteBuffer);
}
