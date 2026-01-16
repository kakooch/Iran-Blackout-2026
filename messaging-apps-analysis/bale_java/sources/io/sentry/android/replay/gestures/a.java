package io.sentry.android.replay.gestures;

import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import io.sentry.C3155n3;
import io.sentry.InterfaceC3102d0;
import io.sentry.Y2;
import io.sentry.android.replay.A;
import io.sentry.android.replay.d;
import io.sentry.android.replay.util.i;
import io.sentry.util.C3202a;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC14155hS;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.UA2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class a implements d {
    private final C3155n3 a;
    private final c b;
    private final ArrayList c;
    private final C3202a d;

    /* renamed from: io.sentry.android.replay.gestures.a$a, reason: collision with other inner class name */
    public static final class C0240a extends i {
        private final C3155n3 b;
        private final c c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0240a(C3155n3 c3155n3, c cVar, Window.Callback callback) {
            super(callback);
            AbstractC13042fc3.i(c3155n3, "options");
            this.b = c3155n3;
            this.c = cVar;
        }

        @Override // io.sentry.android.replay.util.i, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (motionEvent != null) {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                AbstractC13042fc3.h(motionEventObtainNoHistory, "obtainNoHistory(event)");
                try {
                    c cVar = this.c;
                    if (cVar != null) {
                        cVar.a(motionEventObtainNoHistory);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ View e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(View view) {
            super(1);
            this.e = view;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(WeakReference weakReference) {
            AbstractC13042fc3.i(weakReference, "it");
            return Boolean.valueOf(AbstractC13042fc3.d(weakReference.get(), this.e));
        }
    }

    public a(C3155n3 c3155n3, c cVar) {
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(cVar, "touchRecorderCallback");
        this.a = c3155n3;
        this.b = cVar;
        this.c = new ArrayList();
        this.d = new C3202a();
    }

    private final void b(View view) {
        Window windowA = A.a(view);
        if (windowA == null) {
            this.a.getLogger().c(Y2.DEBUG, "Window is invalid, not tracking gestures", new Object[0]);
            return;
        }
        Window.Callback callback = windowA.getCallback();
        if (callback instanceof C0240a) {
            return;
        }
        windowA.setCallback(new C0240a(this.a, this.b, callback));
    }

    private final void d(View view) {
        Window windowA = A.a(view);
        if (windowA == null) {
            this.a.getLogger().c(Y2.DEBUG, "Window was null in stopGestureTracking", new Object[0]);
            return;
        }
        Window.Callback callback = windowA.getCallback();
        if (callback instanceof C0240a) {
            windowA.setCallback(((C0240a) callback).a);
        }
    }

    @Override // io.sentry.android.replay.d
    public void a(View view, boolean z) throws Exception {
        AbstractC13042fc3.i(view, "root");
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            if (z) {
                this.c.add(new WeakReference(view));
                b(view);
                C19938rB7 c19938rB7 = C19938rB7.a;
            } else {
                d(view);
                AbstractC13610gX0.K(this.c, new b(view));
            }
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } finally {
        }
    }

    public final void c() throws Exception {
        InterfaceC3102d0 interfaceC3102d0A = this.d.a();
        try {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                View view = (View) ((WeakReference) it.next()).get();
                if (view != null) {
                    AbstractC13042fc3.h(view, "get()");
                    d(view);
                }
            }
            this.c.clear();
            C19938rB7 c19938rB7 = C19938rB7.a;
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } finally {
        }
    }
}
