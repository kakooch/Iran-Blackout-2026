package ir.nasim;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: ir.nasim.Fi2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4485Fi2 extends GestureDetector {
    private final C4734Gi2 a;
    private final Handler b;
    private final OE0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4485Fi2(Context context, C4734Gi2 c4734Gi2) {
        super(context, c4734Gi2);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c4734Gi2, "listener");
        this.a = c4734Gi2;
        this.b = new Handler(context.getMainLooper());
        this.c = new OE0(new Runnable() { // from class: ir.nasim.Ci2
            @Override // java.lang.Runnable
            public final void run() {
                C4485Fi2.e(this.a);
            }
        });
    }

    private final SA2 d() {
        return this.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(C4485Fi2 c4485Fi2) {
        AbstractC13042fc3.i(c4485Fi2, "this$0");
        SA2 sa2C = c4485Fi2.a.c();
        if (sa2C != null) {
            sa2C.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(C4485Fi2 c4485Fi2) {
        AbstractC13042fc3.i(c4485Fi2, "this$0");
        c4485Fi2.c.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(C4485Fi2 c4485Fi2) {
        AbstractC13042fc3.i(c4485Fi2, "this$0");
        SA2 sa2D = c4485Fi2.d();
        if (sa2D != null) {
            sa2D.invoke();
        }
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            this.b.postDelayed(new Runnable() { // from class: ir.nasim.Di2
                @Override // java.lang.Runnable
                public final void run() {
                    C4485Fi2.f(this.a);
                }
            }, 700L);
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.c.a(true);
            this.b.post(new Runnable() { // from class: ir.nasim.Ei2
                @Override // java.lang.Runnable
                public final void run() {
                    C4485Fi2.g(this.a);
                }
            });
        } else {
            this.c.a(false);
        }
        return super.onTouchEvent(motionEvent);
    }
}
