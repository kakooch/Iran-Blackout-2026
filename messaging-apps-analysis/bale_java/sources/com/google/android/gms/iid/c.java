package com.google.android.gms.iid;

import android.content.Intent;

/* loaded from: classes3.dex */
final class c implements Runnable {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Intent b;
    private final /* synthetic */ zze c;

    c(zze zzeVar, Intent intent, Intent intent2) {
        this.c = zzeVar;
        this.a = intent;
        this.b = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.handleIntent(this.a);
        this.c.b(this.b);
    }
}
