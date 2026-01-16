package com.google.android.exoplayer2.source.ads;

import ir.nasim.InterfaceC22367v7;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface AdsLoader {

    public interface EventListener {
    }

    public interface Provider {
    }

    void a(AdsMediaSource adsMediaSource, int i, int i2);

    void b(AdsMediaSource adsMediaSource, int i, int i2, IOException iOException);

    void c(AdsMediaSource adsMediaSource, EventListener eventListener);

    void d(AdsMediaSource adsMediaSource, com.google.android.exoplayer2.upstream.b bVar, Object obj, InterfaceC22367v7 interfaceC22367v7, EventListener eventListener);
}
