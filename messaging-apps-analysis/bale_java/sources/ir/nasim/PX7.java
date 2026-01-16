package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class PX7 extends AbstractC9823ad0 {
    private static boolean f;
    private static int g = UB5.glide_custom_view_target_tag;
    protected final View a;
    private final a b;
    private View.OnAttachStateChangeListener c;
    private boolean d;
    private boolean e;

    static final class a {
        static Integer e;
        private final View a;
        private final List b = new ArrayList();
        boolean c;
        private ViewTreeObserverOnPreDrawListenerC0576a d;

        /* renamed from: ir.nasim.PX7$a$a, reason: collision with other inner class name */
        private static final class ViewTreeObserverOnPreDrawListenerC0576a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference a;

            ViewTreeObserverOnPreDrawListenerC0576a(a aVar) {
                this.a = new WeakReference(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = (a) this.a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.a = view;
        }

        private static int c(Context context) {
            if (e == null) {
                Display defaultDisplay = ((WindowManager) AbstractC3322Aj5.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return e.intValue();
        }

        private int e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.a.getContext());
        }

        private int f() {
            int paddingTop = this.a.getPaddingTop() + this.a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.a.getPaddingLeft() + this.a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private boolean i(int i, int i2) {
            return h(i) && h(i2);
        }

        private void j(int i, int i2) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((YD6) it.next()).d(i, i2);
            }
        }

        void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j(iG, iF);
                b();
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        void d(YD6 yd6) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                yd6.d(iG, iF);
                return;
            }
            if (!this.b.contains(yd6)) {
                this.b.add(yd6);
            }
            if (this.d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0576a viewTreeObserverOnPreDrawListenerC0576a = new ViewTreeObserverOnPreDrawListenerC0576a(this);
                this.d = viewTreeObserverOnPreDrawListenerC0576a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0576a);
            }
        }

        void k(YD6 yd6) {
            this.b.remove(yd6);
        }
    }

    public PX7(View view) {
        this.a = (View) AbstractC3322Aj5.d(view);
        this.b = new a(view);
    }

    private Object j() {
        return this.a.getTag(g);
    }

    private void m() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener == null || this.e) {
            return;
        }
        this.a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.e = true;
    }

    private void n() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener == null || !this.e) {
            return;
        }
        this.a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.e = false;
    }

    private void o(Object obj) {
        f = true;
        this.a.setTag(g, obj);
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void c(YD6 yd6) {
        this.b.k(yd6);
    }

    @Override // ir.nasim.AbstractC9823ad0, ir.nasim.InterfaceC21549tj7
    public void e(Drawable drawable) {
        super.e(drawable);
        m();
    }

    @Override // ir.nasim.AbstractC9823ad0, ir.nasim.InterfaceC21549tj7
    public void g(Drawable drawable) {
        super.g(drawable);
        this.b.b();
        if (this.d) {
            return;
        }
        n();
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public RP5 getRequest() {
        Object objJ = j();
        if (objJ == null) {
            return null;
        }
        if (objJ instanceof RP5) {
            return (RP5) objJ;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void h(YD6 yd6) {
        this.b.d(yd6);
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public void l(RP5 rp5) {
        o(rp5);
    }

    public String toString() {
        return "Target for: " + this.a;
    }
}
