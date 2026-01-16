package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.InterfaceC12088e12;

@Deprecated
/* loaded from: classes2.dex */
public interface MediaSourceFactory extends MediaSource.Factory {

    /* renamed from: com.google.android.exoplayer2.source.MediaSourceFactory$1, reason: invalid class name */
    class AnonymousClass1 implements MediaSourceFactory {
        AnonymousClass1() {
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        public MediaSource a(C2018a0 c2018a0) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public MediaSourceFactory c(com.google.android.exoplayer2.upstream.j jVar) {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public MediaSourceFactory b(InterfaceC12088e12 interfaceC12088e12) {
            return this;
        }
    }
}
