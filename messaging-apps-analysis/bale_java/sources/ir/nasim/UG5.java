package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import ir.nasim.UG5;

/* loaded from: classes4.dex */
public final class UG5 extends AbstractC5462Jl1 {
    public static final b m = new b(null);
    public static final int n = 8;
    private static boolean o;
    private final View d;
    private final ViewGroup e;
    private final Point f;
    private final RS4 g;
    private final boolean h;
    private final SA2 i;
    private final Context j;
    private final InterfaceC18633oz3 k;
    private final InterfaceC15796kB2 l;

    public static final class a {
        private final View a;
        private final ViewGroup b;
        private final InterfaceC18633oz3 c;
        private InterfaceC15796kB2 d;
        private SA2 e;
        private Point f;
        private RS4 g;
        private boolean h;

        public a(View view, ViewGroup viewGroup, InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(view, "anchor");
            AbstractC13042fc3.i(viewGroup, "container");
            AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
            this.a = view;
            this.b = viewGroup;
            this.c = interfaceC18633oz3;
            this.d = Q81.a.a();
            this.e = new SA2() { // from class: ir.nasim.TG5
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return UG5.a.g();
                }
            };
            this.f = new Point(0, 0);
            this.g = new RS4(0.0f, 0.0f, 0.0f, 0.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(a aVar) {
            AbstractC13042fc3.i(aVar, "this$0");
            aVar.e.invoke();
            UG5.o = false;
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g() {
            return C19938rB7.a;
        }

        public final UG5 c() {
            return new UG5(this.a, this.b, this.f, this.g, this.h, new SA2() { // from class: ir.nasim.SG5
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return UG5.a.d(this.a);
                }
            }, null, this.c, this.d, 64, null);
        }

        public final a e(boolean z) {
            this.h = z;
            return this;
        }

        public final a f(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "onDismiss");
            this.e = sa2;
            return this;
        }

        public final a h(InterfaceC15796kB2 interfaceC15796kB2) {
            AbstractC13042fc3.i(interfaceC15796kB2, "composeContent");
            this.d = interfaceC15796kB2;
            return this;
        }

        public final a i(Point point) {
            AbstractC13042fc3.i(point, "point");
            this.f = point;
            return this;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* synthetic */ UG5(View view, ViewGroup viewGroup, Point point, RS4 rs4, boolean z, SA2 sa2, Context context, InterfaceC18633oz3 interfaceC18633oz3, InterfaceC15796kB2 interfaceC15796kB2, int i, ED1 ed1) {
        this(view, viewGroup, (i & 4) != 0 ? new Point(0, 0) : point, (i & 8) != 0 ? new RS4(0.0f, 0.0f, 0.0f, 0.0f) : rs4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? new SA2() { // from class: ir.nasim.RG5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return UG5.k();
            }
        } : sa2, (i & 64) != 0 ? new ContextThemeWrapper(viewGroup.getContext(), AbstractC17008mE5.Theme_Bale_Base) : context, interfaceC18633oz3, interfaceC15796kB2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(UG5 ug5) {
        AbstractC13042fc3.i(ug5, "this$0");
        ug5.i.invoke();
    }

    @Override // ir.nasim.AbstractC5462Jl1
    public void e(int i) {
        if (o) {
            return;
        }
        super.e(i);
        o = true;
    }

    @Override // ir.nasim.AbstractC5462Jl1
    public void h() {
        if (o) {
            return;
        }
        super.h();
        o = true;
    }

    public final Point n() {
        return this.f;
    }

    private UG5(View view, ViewGroup viewGroup, Point point, RS4 rs4, boolean z, SA2 sa2, Context context, InterfaceC18633oz3 interfaceC18633oz3, InterfaceC15796kB2 interfaceC15796kB2) {
        C7140Ql1 c7140Ql1 = new C7140Ql1(view, viewGroup, point, rs4, z, (int) ((76 * AbstractC3742Cd6.c()) + 0.5d), (int) ((24 * AbstractC3742Cd6.c()) + 0.5d), (int) ((16 * AbstractC3742Cd6.c()) + 0.5d), true);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        VG5.b(frameLayout, context, interfaceC15796kB2, interfaceC18633oz3);
        C19938rB7 c19938rB7 = C19938rB7.a;
        super(c7140Ql1, frameLayout, -2, -2);
        this.d = view;
        this.e = viewGroup;
        this.f = point;
        this.g = rs4;
        this.h = z;
        this.i = sa2;
        this.j = context;
        this.k = interfaceC18633oz3;
        this.l = interfaceC15796kB2;
        setInputMethodMode(2);
        setAnimationStyle(AbstractC17008mE5.Bale_ContextMenu_Animation);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.QG5
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                UG5.l(this.a);
            }
        });
    }
}
