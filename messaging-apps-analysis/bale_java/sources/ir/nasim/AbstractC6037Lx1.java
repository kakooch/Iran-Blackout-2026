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

/* renamed from: ir.nasim.Lx1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6037Lx1 implements InterfaceC21549tj7 {
    private static final int f = UB5.glide_custom_view_target_tag;
    private final a a;
    protected final View b;
    private View.OnAttachStateChangeListener c;
    private boolean d;
    private boolean e;

    /* renamed from: ir.nasim.Lx1$a */
    static final class a {
        static Integer e;
        private final View a;
        private final List b = new ArrayList();
        boolean c;
        private ViewTreeObserverOnPreDrawListenerC0492a d;

        /* renamed from: ir.nasim.Lx1$a$a, reason: collision with other inner class name */
        private static final class ViewTreeObserverOnPreDrawListenerC0492a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference a;

            ViewTreeObserverOnPreDrawListenerC0492a(a aVar) {
                this.a = new WeakReference(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
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
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
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
                ViewTreeObserverOnPreDrawListenerC0492a viewTreeObserverOnPreDrawListenerC0492a = new ViewTreeObserverOnPreDrawListenerC0492a(this);
                this.d = viewTreeObserverOnPreDrawListenerC0492a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0492a);
            }
        }

        void k(YD6 yd6) {
            this.b.remove(yd6);
        }
    }

    public AbstractC6037Lx1(View view) {
        this.b = (View) AbstractC3322Aj5.d(view);
        this.a = new a(view);
    }

    private Object b() {
        return this.b.getTag(f);
    }

    private void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener == null || this.e) {
            return;
        }
        this.b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.e = true;
    }

    private void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener == null || !this.e) {
            return;
        }
        this.b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.e = false;
    }

    private void o(Object obj) {
        this.b.setTag(f, obj);
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final void c(YD6 yd6) {
        this.a.k(yd6);
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final void e(Drawable drawable) {
        d();
        n(drawable);
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final void g(Drawable drawable) {
        this.a.b();
        m(drawable);
        if (this.d) {
            return;
        }
        j();
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final RP5 getRequest() {
        Object objB = b();
        if (objB == null) {
            return null;
        }
        if (objB instanceof RP5) {
            return (RP5) objB;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final void h(YD6 yd6) {
        this.a.d(yd6);
    }

    @Override // ir.nasim.InterfaceC21549tj7
    public final void l(RP5 rp5) {
        o(rp5);
    }

    protected abstract void m(Drawable drawable);

    public String toString() {
        return "Target for: " + this.b;
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void f() {
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void i() {
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public void onDestroy() {
    }

    protected void n(Drawable drawable) {
    }
}
