package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Handler;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aok {
    private final Context a;

    public aok(Context context) {
        this.a = context;
    }

    public final ed[] a(Handler handler, afu afuVar, hi hiVar) {
        Context context = this.a;
        qk qkVar = qk.b;
        return new ed[]{new aff(context, qkVar, handler, afuVar), new ij(this.a, qkVar, handler, hiVar)};
    }
}
