package io.sentry.android.replay;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewOverlay;
import android.view.ViewTreeObserver;
import android.view.Window;
import io.sentry.C3155n3;
import io.sentry.Y2;
import io.sentry.android.replay.viewhierarchy.b;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class s implements ViewTreeObserver.OnDrawListener {
    private final u a;
    private final C3155n3 b;
    private final io.sentry.android.replay.util.j c;
    private final ScheduledExecutorService d;
    private final t e;
    private WeakReference f;
    private final InterfaceC9173Yu3 g;
    private final InterfaceC9173Yu3 h;
    private final Bitmap i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;
    private final AtomicBoolean l;
    private final AtomicBoolean m;
    private final AtomicBoolean n;
    private final io.sentry.android.replay.util.d o;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ List f;
        final /* synthetic */ Canvas g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, Canvas canvas) {
            super(1);
            this.f = list;
            this.g = canvas;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(io.sentry.android.replay.viewhierarchy.b bVar) {
            XV4 xv4A;
            Integer numI;
            AbstractC13042fc3.i(bVar, "node");
            if (bVar.c() && bVar.e() > 0 && bVar.b() > 0) {
                if (bVar.d() == null) {
                    return Boolean.FALSE;
                }
                if (bVar instanceof b.c) {
                    List listE = AbstractC9766aX0.e(bVar.d());
                    s sVar = s.this;
                    xv4A = AbstractC4616Fw7.a(listE, Integer.valueOf(sVar.n(sVar.i, bVar.d())));
                } else {
                    if (bVar instanceof b.d) {
                        b.d dVar = (b.d) bVar;
                        io.sentry.android.replay.util.o oVarJ = dVar.j();
                        xv4A = AbstractC4616Fw7.a(io.sentry.android.replay.util.p.d(dVar.j(), bVar.d(), dVar.k(), dVar.l()), Integer.valueOf(((oVarJ == null || (numI = oVarJ.f()) == null) && (numI = dVar.i()) == null) ? -16777216 : numI.intValue()));
                    } else {
                        xv4A = AbstractC4616Fw7.a(AbstractC9766aX0.e(bVar.d()), -16777216);
                    }
                }
                List list = (List) xv4A.a();
                s.this.p().setColor(((Number) xv4A.b()).intValue());
                Canvas canvas = this.g;
                s sVar2 = s.this;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    canvas.drawRoundRect(new RectF((Rect) it.next()), 10.0f, 10.0f, sVar2.p());
                }
                if (s.this.q().getReplayController().z()) {
                    this.f.addAll(list);
                }
            }
            return Boolean.TRUE;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            return new Paint();
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Matrix invoke() {
            Matrix matrix = new Matrix();
            s sVar = s.this;
            matrix.preScale(sVar.o().e(), sVar.o().f());
            return matrix;
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        public static final d e = new d();

        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap invoke() {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
            return bitmapCreateBitmap;
        }
    }

    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Canvas invoke() {
            return new Canvas(s.this.s());
        }
    }

    public s(u uVar, C3155n3 c3155n3, io.sentry.android.replay.util.j jVar, ScheduledExecutorService scheduledExecutorService, t tVar) {
        AbstractC13042fc3.i(uVar, "config");
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(jVar, "mainLooperHandler");
        AbstractC13042fc3.i(scheduledExecutorService, "recorder");
        this.a = uVar;
        this.b = c3155n3;
        this.c = jVar;
        this.d = scheduledExecutorService;
        this.e = tVar;
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.g = AbstractC13269fw3.b(enumC4870Gx3, b.e);
        this.h = AbstractC13269fw3.b(enumC4870Gx3, d.e);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(uVar.d(), uVar.c(), Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(config.reco… Bitmap.Config.ARGB_8888)");
        this.i = bitmapCreateBitmap;
        this.j = AbstractC13269fw3.b(enumC4870Gx3, new e());
        this.k = AbstractC13269fw3.b(enumC4870Gx3, new c());
        this.l = new AtomicBoolean(false);
        this.m = new AtomicBoolean(true);
        this.n = new AtomicBoolean(false);
        this.o = new io.sentry.android.replay.util.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final s sVar, final View view, int i) {
        AbstractC13042fc3.i(sVar, "this$0");
        if (i != 0) {
            sVar.b.getLogger().c(Y2.INFO, "Failed to capture replay recording: %d", Integer.valueOf(i));
            sVar.n.set(false);
        } else if (sVar.l.get()) {
            sVar.b.getLogger().c(Y2.INFO, "Failed to determine view hierarchy, not capturing", new Object[0]);
            sVar.n.set(false);
        } else {
            final io.sentry.android.replay.viewhierarchy.b bVarA = io.sentry.android.replay.viewhierarchy.b.m.a(view, null, 0, sVar.b);
            io.sentry.android.replay.util.p.k(view, bVarA, sVar.b);
            io.sentry.android.replay.util.g.e(sVar.d, sVar.b, "screenshot_recorder.mask", new Runnable() { // from class: io.sentry.android.replay.q
                @Override // java.lang.Runnable
                public final void run() {
                    s.k(this.a, bVarA, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final s sVar, io.sentry.android.replay.viewhierarchy.b bVar, final View view) {
        AbstractC13042fc3.i(sVar, "this$0");
        AbstractC13042fc3.i(bVar, "$viewHierarchy");
        final ArrayList arrayList = new ArrayList();
        Canvas canvas = new Canvas(sVar.i);
        canvas.setMatrix(sVar.r());
        bVar.h(sVar.new a(arrayList, canvas));
        if (sVar.b.getReplayController().z()) {
            sVar.c.b(new Runnable() { // from class: io.sentry.android.replay.r
                @Override // java.lang.Runnable
                public final void run() {
                    s.l(this.a, view, arrayList);
                }
            });
        }
        t tVar = sVar.e;
        if (tVar != null) {
            tVar.e(sVar.i);
        }
        sVar.n.set(true);
        sVar.l.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(s sVar, View view, List list) {
        AbstractC13042fc3.i(sVar, "this$0");
        AbstractC13042fc3.i(list, "$debugMasks");
        if (sVar.o.getCallback() == null) {
            view.getOverlay().add(sVar.o);
        }
        sVar.o.b(list);
        view.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int n(Bitmap bitmap, Rect rect) {
        Rect rect2 = new Rect(rect);
        RectF rectF = new RectF(rect2);
        r().mapRect(rectF);
        rectF.round(rect2);
        t().drawBitmap(bitmap, rect2, new Rect(0, 0, 1, 1), (Paint) null);
        return s().getPixel(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Paint p() {
        return (Paint) this.g.getValue();
    }

    private final Matrix r() {
        return (Matrix) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap s() {
        return (Bitmap) this.h.getValue();
    }

    private final Canvas t() {
        return (Canvas) this.j.getValue();
    }

    public final void h(View view) {
        AbstractC13042fc3.i(view, "root");
        WeakReference weakReference = this.f;
        w(weakReference != null ? (View) weakReference.get() : null);
        WeakReference weakReference2 = this.f;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        this.f = new WeakReference(view);
        io.sentry.android.replay.util.p.a(view, this);
        this.l.set(true);
    }

    public final void i() {
        if (this.b.getSessionReplay().o()) {
            this.b.getLogger().c(Y2.DEBUG, "Capturing screenshot, isCapturing: %s", Boolean.valueOf(this.m.get()));
        }
        if (!this.m.get()) {
            if (this.b.getSessionReplay().o()) {
                this.b.getLogger().c(Y2.DEBUG, "ScreenshotRecorder is paused, not capturing screenshot", new Object[0]);
                return;
            }
            return;
        }
        if (this.b.getSessionReplay().o()) {
            this.b.getLogger().c(Y2.DEBUG, "Capturing screenshot, contentChanged: %s, lastCaptureSuccessful: %s", Boolean.valueOf(this.l.get()), Boolean.valueOf(this.n.get()));
        }
        if (!this.l.get() && this.n.get()) {
            t tVar = this.e;
            if (tVar != null) {
                tVar.e(this.i);
                return;
            }
            return;
        }
        WeakReference weakReference = this.f;
        final View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0 || !view.isShown()) {
            this.b.getLogger().c(Y2.DEBUG, "Root view is invalid, not capturing screenshot", new Object[0]);
            return;
        }
        Window windowA = A.a(view);
        if (windowA == null) {
            this.b.getLogger().c(Y2.DEBUG, "Window is invalid, not capturing screenshot", new Object[0]);
            return;
        }
        try {
            this.l.set(false);
            PixelCopy.request(windowA, this.i, new PixelCopy.OnPixelCopyFinishedListener() { // from class: io.sentry.android.replay.p
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public final void onPixelCopyFinished(int i) {
                    s.j(this.a, view, i);
                }
            }, this.c.a());
        } catch (Throwable th) {
            this.b.getLogger().b(Y2.WARNING, "Failed to capture replay recording", th);
            this.n.set(false);
        }
    }

    public final void m() {
        WeakReference weakReference = this.f;
        w(weakReference != null ? (View) weakReference.get() : null);
        WeakReference weakReference2 = this.f;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        if (!this.i.isRecycled()) {
            this.i.recycle();
        }
        this.m.set(false);
    }

    public final u o() {
        return this.a;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        if (this.m.get()) {
            WeakReference weakReference = this.f;
            View view = weakReference != null ? (View) weakReference.get() : null;
            if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0 || !view.isShown()) {
                this.b.getLogger().c(Y2.DEBUG, "Root view is invalid, not capturing screenshot", new Object[0]);
            } else {
                this.l.set(true);
            }
        }
    }

    public final C3155n3 q() {
        return this.b;
    }

    public final void u() {
        this.m.set(false);
        WeakReference weakReference = this.f;
        w(weakReference != null ? (View) weakReference.get() : null);
    }

    public final void v() {
        View view;
        WeakReference weakReference = this.f;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            io.sentry.android.replay.util.p.a(view, this);
        }
        this.m.set(true);
    }

    public final void w(View view) {
        ViewOverlay overlay;
        if (this.b.getReplayController().z() && view != null && (overlay = view.getOverlay()) != null) {
            overlay.remove(this.o);
        }
        if (view != null) {
            io.sentry.android.replay.util.p.h(view, this);
        }
    }
}
