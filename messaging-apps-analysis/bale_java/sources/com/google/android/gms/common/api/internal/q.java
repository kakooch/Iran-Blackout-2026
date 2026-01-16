package com.google.android.gms.common.api.internal;

/* loaded from: classes3.dex */
final class q implements Runnable {
    final /* synthetic */ r a;

    q(r rVar) {
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.a.a;
        sVar.h.b(sVar.h.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
