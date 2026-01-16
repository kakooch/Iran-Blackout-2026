package ir.nasim.designsystem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.C22013uW7;

/* loaded from: classes5.dex */
public class PullBackLayout extends FrameLayout {
    private final C22013uW7 a;
    private final int b;
    private boolean c;
    private a d;

    public interface a {
        void g();

        void u(float f);

        void y();

        void z();
    }

    private class b extends C22013uW7.c {
        @Override // ir.nasim.C22013uW7.c
        public int a(View view, int i, int i2) {
            return 0;
        }

        @Override // ir.nasim.C22013uW7.c
        public int b(View view, int i, int i2) {
            return Math.max(0, i);
        }

        @Override // ir.nasim.C22013uW7.c
        public int d(View view) {
            return 0;
        }

        @Override // ir.nasim.C22013uW7.c
        public int e(View view) {
            return PullBackLayout.this.getHeight();
        }

        @Override // ir.nasim.C22013uW7.c
        public void i(View view, int i) {
            if (PullBackLayout.this.d != null) {
                PullBackLayout.this.d.g();
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public void k(View view, int i, int i2, int i3, int i4) {
            if (PullBackLayout.this.d != null) {
                PullBackLayout.this.d.u(i2 / PullBackLayout.this.getHeight());
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public void l(View view, float f, float f2) {
            if (view.getTop() > (f2 > ((float) PullBackLayout.this.b) ? PullBackLayout.this.getHeight() / 6 : PullBackLayout.this.getHeight() / 3)) {
                if (PullBackLayout.this.d != null) {
                    PullBackLayout.this.d.z();
                }
            } else {
                if (PullBackLayout.this.d != null) {
                    PullBackLayout.this.d.y();
                }
                PullBackLayout.this.a.P(0, 0);
                PullBackLayout.this.invalidate();
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public boolean m(View view, int i) {
            return PullBackLayout.this.d();
        }

        private b() {
        }
    }

    public PullBackLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.a.n(true)) {
            AbstractC12990fW7.g0(this);
        }
    }

    public boolean d() {
        return this.c;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return d() && this.a.Q(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.a.G(motionEvent);
        return true;
    }

    public void setCallback(a aVar) {
        this.d = aVar;
    }

    public void setPullDownEnable(boolean z) {
        this.c = z;
    }

    public PullBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = C22013uW7.o(this, 0.125f, new b());
        this.b = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }
}
