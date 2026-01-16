package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.C2187o;

/* loaded from: classes3.dex */
final class a implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ C2187o b;
    private final /* synthetic */ DynamiteClearcutLogger c;

    a(DynamiteClearcutLogger dynamiteClearcutLogger, int i, C2187o c2187o) {
        this.c = dynamiteClearcutLogger;
        this.a = i;
        this.b = c2187o;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.zzc.zza(this.a, this.b);
    }
}
