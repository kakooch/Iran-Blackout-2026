package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Handler;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class bb {
    private final Context a;
    private final az b;
    private boolean c;

    public bb(Context context, Handler handler, ba baVar) {
        this.a = context.getApplicationContext();
        this.b = new az(this, handler, baVar);
    }

    public final void a(boolean z) {
        if (this.c) {
            this.a.unregisterReceiver(this.b);
            this.c = false;
        }
    }
}
