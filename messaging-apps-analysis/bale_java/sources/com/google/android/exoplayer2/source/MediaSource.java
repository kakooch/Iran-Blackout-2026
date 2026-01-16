package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import ir.nasim.C15493jg5;
import ir.nasim.InterfaceC12088e12;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;

/* loaded from: classes2.dex */
public interface MediaSource {

    public interface Factory {
        MediaSource a(C2018a0 c2018a0);

        Factory b(InterfaceC12088e12 interfaceC12088e12);

        Factory c(com.google.android.exoplayer2.upstream.j jVar);
    }

    public static final class MediaPeriodId extends com.google.android.exoplayer2.source.MediaPeriodId {
        public MediaPeriodId(Object obj) {
            super(obj);
        }

        public MediaPeriodId d(Object obj) {
            return new MediaPeriodId(super.a(obj));
        }

        public MediaPeriodId e(long j) {
            return new MediaPeriodId(super.b(j));
        }

        public MediaPeriodId(Object obj, long j) {
            super(obj, j);
        }

        public MediaPeriodId(Object obj, long j, int i) {
            super(obj, j, i);
        }

        public MediaPeriodId(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public MediaPeriodId(com.google.android.exoplayer2.source.MediaPeriodId mediaPeriodId) {
            super(mediaPeriodId);
        }
    }

    public interface MediaSourceCaller {
        void x(MediaSource mediaSource, J0 j0);
    }

    void B(MediaSourceCaller mediaSourceCaller);

    void F(Handler handler, com.google.android.exoplayer2.drm.h hVar);

    void H(com.google.android.exoplayer2.drm.h hVar);

    void J();

    default boolean K() {
        return true;
    }

    default J0 P() {
        return null;
    }

    MediaPeriod b(MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j);

    void i(MediaSourceCaller mediaSourceCaller);

    void l(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    void o(MediaSourceEventListener mediaSourceEventListener);

    C2018a0 p();

    void s(MediaPeriod mediaPeriod);

    void t(MediaSourceCaller mediaSourceCaller);

    void u(MediaSourceCaller mediaSourceCaller, InterfaceC25209zu7 interfaceC25209zu7, C15493jg5 c15493jg5);
}
