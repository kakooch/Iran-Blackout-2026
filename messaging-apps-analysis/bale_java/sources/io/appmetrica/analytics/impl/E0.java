package io.appmetrica.analytics.impl;

import android.content.Intent;

/* loaded from: classes3.dex */
public final class E0 implements Runnable {
    public final /* synthetic */ Intent a;
    public final /* synthetic */ C2601i1 b;

    public E0(C2601i1 c2601i1, Intent intent) {
        this.b = c2601i1;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2941w7 c2941w7 = this.b.d().b;
        Intent intent = this.a;
        c2941w7.getClass();
        if (intent != null) {
            c2941w7.a(intent.getDataString(), false);
        }
    }
}
