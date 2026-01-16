package com.google.ads.interactivemedia.v3.internal;

import com.facebook.stetho.websocket.CloseCodes;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class acj {
    private final int a = -1;

    public static final long b(acr acrVar) {
        IOException iOException = acrVar.a;
        if (!(iOException instanceof aco)) {
            return -9223372036854775807L;
        }
        int i = ((aco) iOException).a;
        return (i == 403 || i == 404 || i == 410 || i == 416 || i == 500 || i == 503) ? 60000L : -9223372036854775807L;
    }

    public static final long c(acr acrVar) {
        IOException iOException = acrVar.a;
        if ((iOException instanceof dt) || (iOException instanceof FileNotFoundException) || (iOException instanceof acz)) {
            return -9223372036854775807L;
        }
        return Math.min((acrVar.b - 1) * CloseCodes.NORMAL_CLOSURE, 5000);
    }

    public final int a(int i) {
        return i == 7 ? 6 : 3;
    }
}
