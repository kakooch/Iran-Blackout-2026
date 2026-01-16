package ir.nasim;

import android.content.ComponentCallbacks2;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;

/* renamed from: ir.nasim.hp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C14379hp implements InterfaceC20014rK2 {
    public static final a e = new a(null);
    private static boolean f = true;
    private final ViewGroup a;
    private DrawChildContainer c;
    private final Object b = new Object();
    private final ComponentCallbacks2 d = null;

    /* renamed from: ir.nasim.hp$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.hp$b */
    private static final class b {
        public static final b a = new b();

        private b() {
        }

        public static final long a(View view) {
            return view.getUniqueDrawingId();
        }
    }

    public C14379hp(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    private final long c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b.a(view);
        }
        return -1L;
    }

    private final DrawChildContainer d(ViewGroup viewGroup) {
        DrawChildContainer drawChildContainer = this.c;
        if (drawChildContainer != null) {
            return drawChildContainer;
        }
        ViewLayerContainer viewLayerContainer = new ViewLayerContainer(viewGroup.getContext());
        viewGroup.addView(viewLayerContainer);
        this.c = viewLayerContainer;
        return viewLayerContainer;
    }

    @Override // ir.nasim.InterfaceC20014rK2
    public C21226tK2 a() {
        androidx.compose.ui.graphics.layer.a xk2;
        C21226tK2 c21226tK2;
        synchronized (this.b) {
            try {
                long jC = c(this.a);
                if (Build.VERSION.SDK_INT >= 29) {
                    xk2 = new WK2(jC, null, null, 6, null);
                } else if (f) {
                    try {
                        xk2 = new C24266yK2(this.a, jC, null, null, 12, null);
                    } catch (Throwable unused) {
                        f = false;
                        xk2 = new XK2(d(this.a), jC, null, null, 12, null);
                    }
                } else {
                    xk2 = new XK2(d(this.a), jC, null, null, 12, null);
                }
                c21226tK2 = new C21226tK2(xk2, null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return c21226tK2;
    }

    @Override // ir.nasim.InterfaceC20014rK2
    public void b(C21226tK2 c21226tK2) {
        synchronized (this.b) {
            c21226tK2.I();
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }
}
