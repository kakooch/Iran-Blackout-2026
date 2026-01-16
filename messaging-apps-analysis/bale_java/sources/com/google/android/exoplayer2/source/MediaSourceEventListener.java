package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public interface MediaSourceEventListener {

    public static class EventDispatcher {
        public final int a;
        public final MediaSource.MediaPeriodId b;
        private final CopyOnWriteArrayList c;
        private final long d;

        private static final class ListenerAndHandler {
            public Handler a;
            public MediaSourceEventListener b;

            public ListenerAndHandler(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.a = handler;
                this.b = mediaSourceEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private long h(long j) {
            long jC1 = AbstractC9683aN7.c1(j);
            if (jC1 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.d + jC1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.a(this.a, this.b, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.e(this.a, this.b, loadEventInfo, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.T(this.a, this.b, loadEventInfo, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            mediaSourceEventListener.W(this.a, this.b, loadEventInfo, mediaLoadData, iOException, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.h(this.a, this.b, loadEventInfo, mediaLoadData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.v(this.a, mediaPeriodId, mediaLoadData);
        }

        public void A(LoadEventInfo loadEventInfo, int i, int i2, X x, int i3, Object obj, long j, long j2) {
            B(loadEventInfo, new MediaLoadData(i, i2, x, i3, obj, h(j), h(j2)));
        }

        public void B(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                final MediaSourceEventListener mediaSourceEventListener = listenerAndHandler.b;
                AbstractC9683aN7.J0(listenerAndHandler.a, new Runnable() { // from class: ir.nasim.kZ3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.o(mediaSourceEventListener, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public void C(MediaSourceEventListener mediaSourceEventListener) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                if (listenerAndHandler.b == mediaSourceEventListener) {
                    this.c.remove(listenerAndHandler);
                }
            }
        }

        public void D(int i, long j, long j2) {
            E(new MediaLoadData(1, i, null, 3, null, h(j), h(j2)));
        }

        public void E(final MediaLoadData mediaLoadData) {
            final MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) AbstractC20011rK.e(this.b);
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                final MediaSourceEventListener mediaSourceEventListener = listenerAndHandler.b;
                AbstractC9683aN7.J0(listenerAndHandler.a, new Runnable() { // from class: ir.nasim.lZ3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.p(mediaSourceEventListener, mediaPeriodId, mediaLoadData);
                    }
                });
            }
        }

        public EventDispatcher F(int i, MediaSource.MediaPeriodId mediaPeriodId, long j) {
            return new EventDispatcher(this.c, i, mediaPeriodId, j);
        }

        public void g(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            AbstractC20011rK.e(handler);
            AbstractC20011rK.e(mediaSourceEventListener);
            this.c.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void i(int i, X x, int i2, Object obj, long j) {
            j(new MediaLoadData(1, i, x, i2, obj, h(j), -9223372036854775807L));
        }

        public void j(final MediaLoadData mediaLoadData) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                final MediaSourceEventListener mediaSourceEventListener = listenerAndHandler.b;
                AbstractC9683aN7.J0(listenerAndHandler.a, new Runnable() { // from class: ir.nasim.mZ3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.k(mediaSourceEventListener, mediaLoadData);
                    }
                });
            }
        }

        public void q(LoadEventInfo loadEventInfo, int i) {
            r(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void r(LoadEventInfo loadEventInfo, int i, int i2, X x, int i3, Object obj, long j, long j2) {
            s(loadEventInfo, new MediaLoadData(i, i2, x, i3, obj, h(j), h(j2)));
        }

        public void s(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                final MediaSourceEventListener mediaSourceEventListener = listenerAndHandler.b;
                AbstractC9683aN7.J0(listenerAndHandler.a, new Runnable() { // from class: ir.nasim.jZ3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.l(mediaSourceEventListener, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public void t(LoadEventInfo loadEventInfo, int i) {
            u(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void u(LoadEventInfo loadEventInfo, int i, int i2, X x, int i3, Object obj, long j, long j2) {
            v(loadEventInfo, new MediaLoadData(i, i2, x, i3, obj, h(j), h(j2)));
        }

        public void v(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                final MediaSourceEventListener mediaSourceEventListener = listenerAndHandler.b;
                AbstractC9683aN7.J0(listenerAndHandler.a, new Runnable() { // from class: ir.nasim.hZ3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.m(mediaSourceEventListener, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public void w(LoadEventInfo loadEventInfo, int i, int i2, X x, int i3, Object obj, long j, long j2, IOException iOException, boolean z) {
            y(loadEventInfo, new MediaLoadData(i, i2, x, i3, obj, h(j), h(j2)), iOException, z);
        }

        public void x(LoadEventInfo loadEventInfo, int i, IOException iOException, boolean z) {
            w(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
        }

        public void y(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ListenerAndHandler listenerAndHandler = (ListenerAndHandler) it.next();
                final MediaSourceEventListener mediaSourceEventListener = listenerAndHandler.b;
                AbstractC9683aN7.J0(listenerAndHandler.a, new Runnable() { // from class: ir.nasim.iZ3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.n(mediaSourceEventListener, loadEventInfo, mediaLoadData, iOException, z);
                    }
                });
            }
        }

        public void z(LoadEventInfo loadEventInfo, int i) {
            A(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        private EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int i, MediaSource.MediaPeriodId mediaPeriodId, long j) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.b = mediaPeriodId;
            this.d = j;
        }
    }

    default void T(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void W(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
    }

    default void a(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    default void e(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void h(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void v(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }
}
