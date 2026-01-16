package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
/* loaded from: classes.dex */
public class zzi extends Handler {
    public zzi(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }

    public zzi(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        Looper.getMainLooper();
    }
}
