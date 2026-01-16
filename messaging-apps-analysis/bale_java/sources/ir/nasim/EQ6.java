package ir.nasim;

import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public final class EQ6 {
    private final DQ6 a;
    private final WeakReference b;
    private final WeakReference c;
    private final WeakReference d;
    private boolean e;
    private float f;
    private float g;
    private long h;

    public EQ6(View view, View view2, View view3, DQ6 dq6) {
        AbstractC13042fc3.i(view, "startView");
        AbstractC13042fc3.i(view2, "centerView");
        AbstractC13042fc3.i(view3, "endView");
        AbstractC13042fc3.i(dq6, "actionListener");
        this.a = dq6;
        this.b = new WeakReference(view);
        this.c = new WeakReference(view2);
        this.d = new WeakReference(view3);
    }

    private final void a() {
        this.a.I4();
        this.e = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(View view, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!AbstractC10360bX0.p(this.b.get(), this.c.get(), this.d.get()).contains(view)) {
                this.e = false;
                return false;
            }
            this.f = motionEvent.getX();
            this.h = System.currentTimeMillis();
            this.a.P2();
            this.e = true;
            return true;
        }
        if (action != 1 || !this.e) {
            return false;
        }
        float x = motionEvent.getX();
        this.g = x;
        if (Math.abs(x - this.f) >= 100.0f) {
            if (System.currentTimeMillis() < this.h + 1300) {
                if (this.g > this.f) {
                    this.a.O2();
                } else {
                    this.a.n4();
                }
                a();
                return true;
            }
            return false;
        }
        if (System.currentTimeMillis() < this.h + 300) {
            if (AbstractC13042fc3.d(view, this.b.get())) {
                this.a.a5();
            } else if (AbstractC13042fc3.d(view, this.d.get())) {
                this.a.y3();
            } else if (this.a.u1(motionEvent)) {
                this.e = false;
                return true;
            }
        }
        a();
        return true;
    }
}
