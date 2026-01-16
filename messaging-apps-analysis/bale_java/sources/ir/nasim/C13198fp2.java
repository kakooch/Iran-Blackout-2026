package ir.nasim;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.fp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C13198fp2 implements InterfaceC7974Tz2 {
    final Set a = Collections.newSetFromMap(new WeakHashMap());
    volatile boolean b;

    /* renamed from: ir.nasim.fp2$a */
    class a implements ViewTreeObserver.OnDrawListener {
        final /* synthetic */ View a;

        /* renamed from: ir.nasim.fp2$a$a, reason: collision with other inner class name */
        class RunnableC1243a implements Runnable {
            final /* synthetic */ ViewTreeObserver.OnDrawListener a;

            RunnableC1243a(ViewTreeObserver.OnDrawListener onDrawListener) {
                this.a = onDrawListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                C18331oU2.b().h();
                C13198fp2.this.b = true;
                C13198fp2.b(a.this.a, this.a);
                C13198fp2.this.a.clear();
            }
        }

        a(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            YM7.w(new RunnableC1243a(this));
        }
    }

    C13198fp2() {
    }

    static void b(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }

    @Override // ir.nasim.InterfaceC7974Tz2
    public void a(Activity activity) {
        if (!this.b && this.a.add(activity)) {
            View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new a(decorView));
        }
    }
}
