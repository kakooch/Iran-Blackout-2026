package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;

/* renamed from: io.appmetrica.analytics.impl.ga, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2562ga implements InterfaceC2905uj {
    @Override // io.appmetrica.analytics.impl.InterfaceC2905uj
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2905uj
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}
