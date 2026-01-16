package ir.nasim;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes6.dex */
public final class K37 implements View.OnTouchListener {
    public static final a f = new a(null);
    public static final int g = 8;
    private final L37 a;
    private final int b;
    private final View c;
    private float d;
    private boolean e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public K37(L37 l37, int i, View view) {
        AbstractC13042fc3.i(l37, "listener");
        AbstractC13042fc3.i(view, "overlayedView");
        this.a = l37;
        this.b = i;
        this.c = view;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(motionEvent, "event");
        this.c.dispatchTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getY();
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                this.e = true;
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        if (Math.abs(motionEvent.getY() - this.d) > this.b && this.e) {
            if (motionEvent.getY() > this.d) {
                this.a.b();
            } else {
                this.a.a();
            }
        }
        return true;
    }

    public /* synthetic */ K37(L37 l37, int i, View view, int i2, ED1 ed1) {
        this(l37, (i2 & 2) != 0 ? 200 : i, view);
    }
}
