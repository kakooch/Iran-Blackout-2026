package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;

/* loaded from: classes3.dex */
public final class F4 implements InterfaceC2795q4 {
    public final Context a;
    public final I4 b;
    public final ResultReceiver c;

    public F4(Context context, I4 i4, A4 a4) {
        this.a = context;
        this.b = i4;
        this.c = a4.c;
        i4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2795q4
    public final void a(Q5 q5, A4 a4) {
        this.b.a(a4.b);
        this.b.a(q5, this);
    }

    public final I4 b() {
        return this.b;
    }

    public final Context c() {
        return this.a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(C2580h4 c2580h4) {
        ResultReceiverC2988y6.a(this.c, c2580h4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2795q4
    public final void a() {
        this.b.b(this);
    }
}
