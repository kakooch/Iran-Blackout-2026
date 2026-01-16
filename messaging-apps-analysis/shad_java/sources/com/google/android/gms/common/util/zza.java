package com.google.android.gms.common.util;

import com.facebook.stetho.websocket.CloseCodes;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
/* loaded from: classes.dex */
public final class zza {
    public static int zza(int i) {
        if (i == -1) {
            return -1;
        }
        return i / CloseCodes.NORMAL_CLOSURE;
    }
}
