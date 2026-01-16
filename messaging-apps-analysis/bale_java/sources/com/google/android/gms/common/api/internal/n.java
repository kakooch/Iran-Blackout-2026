package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ComponentCallbacks2C2057a;

/* loaded from: classes3.dex */
final class n implements ComponentCallbacks2C2057a.InterfaceC0172a {
    final /* synthetic */ C2059c a;

    n(C2059c c2059c) {
        this.a = c2059c;
    }

    @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C2057a.InterfaceC0172a
    public final void a(boolean z) {
        C2059c c2059c = this.a;
        c2059c.p.sendMessage(c2059c.p.obtainMessage(1, Boolean.valueOf(z)));
    }
}
