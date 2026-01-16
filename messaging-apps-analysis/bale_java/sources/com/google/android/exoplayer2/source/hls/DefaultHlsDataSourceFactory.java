package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.upstream.a;

/* loaded from: classes2.dex */
public final class DefaultHlsDataSourceFactory implements HlsDataSourceFactory {
    private final a.InterfaceC0163a a;

    public DefaultHlsDataSourceFactory(a.InterfaceC0163a interfaceC0163a) {
        this.a = interfaceC0163a;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsDataSourceFactory
    public com.google.android.exoplayer2.upstream.a a(int i) {
        return this.a.a();
    }
}
