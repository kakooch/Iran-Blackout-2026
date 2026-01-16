package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C15493jg5;
import ir.nasim.InterfaceC25209zu7;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class BaseMediaSource implements MediaSource {
    private final ArrayList a = new ArrayList(1);
    private final HashSet b = new HashSet(1);
    private final MediaSourceEventListener.EventDispatcher c = new MediaSourceEventListener.EventDispatcher();
    private final h.a d = new h.a();
    private Looper e;
    private J0 f;
    private C15493jg5 g;

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void B(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z = !this.b.isEmpty();
        this.b.remove(mediaSourceCaller);
        if (z && this.b.isEmpty()) {
            a0();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void F(Handler handler, com.google.android.exoplayer2.drm.h hVar) {
        AbstractC20011rK.e(handler);
        AbstractC20011rK.e(hVar);
        this.d.g(handler, hVar);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void H(com.google.android.exoplayer2.drm.h hVar) {
        this.d.t(hVar);
    }

    protected final h.a R(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.d.u(i, mediaPeriodId);
    }

    protected final h.a S(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.d.u(0, mediaPeriodId);
    }

    protected final MediaSourceEventListener.EventDispatcher X(int i, MediaSource.MediaPeriodId mediaPeriodId, long j) {
        return this.c.F(i, mediaPeriodId, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher Z(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.c.F(0, mediaPeriodId, 0L);
    }

    protected void a0() {
    }

    protected void b0() {
    }

    protected final C15493jg5 c0() {
        return (C15493jg5) AbstractC20011rK.i(this.g);
    }

    protected final boolean d0() {
        return !this.b.isEmpty();
    }

    protected abstract void e0(InterfaceC25209zu7 interfaceC25209zu7);

    protected final void f0(J0 j0) {
        this.f = j0;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((MediaSource.MediaSourceCaller) it.next()).x(this, j0);
        }
    }

    protected abstract void g0();

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void i(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.a.remove(mediaSourceCaller);
        if (!this.a.isEmpty()) {
            B(mediaSourceCaller);
            return;
        }
        this.e = null;
        this.f = null;
        this.g = null;
        this.b.clear();
        g0();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void l(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        AbstractC20011rK.e(handler);
        AbstractC20011rK.e(mediaSourceEventListener);
        this.c.g(handler, mediaSourceEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void o(MediaSourceEventListener mediaSourceEventListener) {
        this.c.C(mediaSourceEventListener);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void t(MediaSource.MediaSourceCaller mediaSourceCaller) {
        AbstractC20011rK.e(this.e);
        boolean zIsEmpty = this.b.isEmpty();
        this.b.add(mediaSourceCaller);
        if (zIsEmpty) {
            b0();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public final void u(MediaSource.MediaSourceCaller mediaSourceCaller, InterfaceC25209zu7 interfaceC25209zu7, C15493jg5 c15493jg5) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.e;
        AbstractC20011rK.a(looper == null || looper == looperMyLooper);
        this.g = c15493jg5;
        J0 j0 = this.f;
        this.a.add(mediaSourceCaller);
        if (this.e == null) {
            this.e = looperMyLooper;
            this.b.add(mediaSourceCaller);
            e0(interfaceC25209zu7);
        } else if (j0 != null) {
            t(mediaSourceCaller);
            mediaSourceCaller.x(this, j0);
        }
    }
}
