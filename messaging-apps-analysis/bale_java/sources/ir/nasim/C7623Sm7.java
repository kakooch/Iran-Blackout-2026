package ir.nasim;

import android.graphics.Rect;
import android.view.Choreographer;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Sm7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7623Sm7 implements InterfaceC22097uf5 {
    private final View a;
    private final InterfaceC19324q93 b;
    private final Executor c;
    private boolean d;
    private UA2 e;
    private UA2 f;
    private C23945xm7 g;
    private T33 h;
    private List i;
    private final InterfaceC9173Yu3 j;
    private Rect k;
    private final C4376Ew1 l;
    private final C12544en4 m;
    private Runnable n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Sm7$a */
    private static final class a {
        public static final a a = new a("StartInput", 0);
        public static final a b = new a("StopInput", 1);
        public static final a c = new a("ShowKeyboard", 2);
        public static final a d = new a("HideKeyboard", 3);
        private static final /* synthetic */ a[] e;
        private static final /* synthetic */ F92 f;

        static {
            a[] aVarArrA = a();
            e = aVarArrA;
            f = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c, d};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }
    }

    /* renamed from: ir.nasim.Sm7$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Sm7$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BaseInputConnection invoke() {
            return new BaseInputConnection(C7623Sm7.this.q(), false);
        }
    }

    /* renamed from: ir.nasim.Sm7$d */
    public static final class d implements InterfaceC16369l93 {
        d() {
        }

        @Override // ir.nasim.InterfaceC16369l93
        public void a(KeyEvent keyEvent) {
            C7623Sm7.this.p().sendKeyEvent(keyEvent);
        }

        @Override // ir.nasim.InterfaceC16369l93
        public void b(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            C7623Sm7.this.l.b(z, z2, z3, z4, z5, z6);
        }

        @Override // ir.nasim.InterfaceC16369l93
        public void c(int i) {
            C7623Sm7.this.f.invoke(S33.j(i));
        }

        @Override // ir.nasim.InterfaceC16369l93
        public void d(List list) {
            C7623Sm7.this.e.invoke(list);
        }

        @Override // ir.nasim.InterfaceC16369l93
        public void e(InputConnectionC11628dK5 inputConnectionC11628dK5) {
            int size = C7623Sm7.this.i.size();
            for (int i = 0; i < size; i++) {
                if (AbstractC13042fc3.d(((WeakReference) C7623Sm7.this.i.get(i)).get(), inputConnectionC11628dK5)) {
                    C7623Sm7.this.i.remove(i);
                    return;
                }
            }
        }
    }

    public C7623Sm7(View view, FV3 fv3, InterfaceC19324q93 interfaceC19324q93, Executor executor) {
        this.a = view;
        this.b = interfaceC19324q93;
        this.c = executor;
        this.e = e.e;
        this.f = f.e;
        this.g = new C23945xm7("", C4301En7.b.a(), (C4301En7) null, 4, (ED1) null);
        this.h = T33.g.a();
        this.i = new ArrayList();
        this.j = AbstractC13269fw3.b(EnumC4870Gx3.c, new c());
        this.l = new C4376Ew1(fv3, interfaceC19324q93);
        this.m = new C12544en4(new a[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection p() {
        return (BaseInputConnection) this.j.getValue();
    }

    private final void s() {
        View viewFindFocus;
        if (!this.a.isFocused() && (viewFindFocus = this.a.getRootView().findFocus()) != null && viewFindFocus.onCheckIsTextEditor()) {
            this.m.k();
            return;
        }
        C12889fL5 c12889fL5 = new C12889fL5();
        C12889fL5 c12889fL52 = new C12889fL5();
        C12544en4 c12544en4 = this.m;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i = 0; i < iO; i++) {
            t((a) objArr[i], c12889fL5, c12889fL52);
        }
        this.m.k();
        if (AbstractC13042fc3.d(c12889fL5.a, Boolean.TRUE)) {
            u();
        }
        Boolean bool = (Boolean) c12889fL52.a;
        if (bool != null) {
            x(bool.booleanValue());
        }
        if (AbstractC13042fc3.d(c12889fL5.a, Boolean.FALSE)) {
            u();
        }
    }

    private static final void t(a aVar, C12889fL5 c12889fL5, C12889fL5 c12889fL52) {
        int i = b.a[aVar.ordinal()];
        if (i == 1) {
            Boolean bool = Boolean.TRUE;
            c12889fL5.a = bool;
            c12889fL52.a = bool;
        } else if (i == 2) {
            Boolean bool2 = Boolean.FALSE;
            c12889fL5.a = bool2;
            c12889fL52.a = bool2;
        } else if ((i == 3 || i == 4) && !AbstractC13042fc3.d(c12889fL5.a, Boolean.FALSE)) {
            c12889fL52.a = Boolean.valueOf(aVar == a.c);
        }
    }

    private final void u() {
        this.b.d();
    }

    private final void v(a aVar) {
        this.m.d(aVar);
        if (this.n == null) {
            Runnable runnable = new Runnable() { // from class: ir.nasim.Rm7
                @Override // java.lang.Runnable
                public final void run() {
                    C7623Sm7.w(this.a);
                }
            };
            this.c.execute(runnable);
            this.n = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(C7623Sm7 c7623Sm7) {
        c7623Sm7.n = null;
        c7623Sm7.s();
    }

    private final void x(boolean z) {
        if (z) {
            this.b.f();
        } else {
            this.b.g();
        }
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void a(C23945xm7 c23945xm7, T33 t33, UA2 ua2, UA2 ua22) {
        this.d = true;
        this.g = c23945xm7;
        this.h = t33;
        this.e = ua2;
        this.f = ua22;
        v(a.a);
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void b() {
        v(a.a);
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void c(C23945xm7 c23945xm7, C23945xm7 c23945xm72) {
        boolean z = (C4301En7.g(this.g.g(), c23945xm72.g()) && AbstractC13042fc3.d(this.g.f(), c23945xm72.f())) ? false : true;
        this.g = c23945xm72;
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            InputConnectionC11628dK5 inputConnectionC11628dK5 = (InputConnectionC11628dK5) ((WeakReference) this.i.get(i)).get();
            if (inputConnectionC11628dK5 != null) {
                inputConnectionC11628dK5.f(c23945xm72);
            }
        }
        this.l.a();
        if (AbstractC13042fc3.d(c23945xm7, c23945xm72)) {
            if (z) {
                InterfaceC19324q93 interfaceC19324q93 = this.b;
                int iL = C4301En7.l(c23945xm72.g());
                int iK = C4301En7.k(c23945xm72.g());
                C4301En7 c4301En7F = this.g.f();
                int iL2 = c4301En7F != null ? C4301En7.l(c4301En7F.r()) : -1;
                C4301En7 c4301En7F2 = this.g.f();
                interfaceC19324q93.c(iL, iK, iL2, c4301En7F2 != null ? C4301En7.k(c4301En7F2.r()) : -1);
                return;
            }
            return;
        }
        if (c23945xm7 != null && (!AbstractC13042fc3.d(c23945xm7.h(), c23945xm72.h()) || (C4301En7.g(c23945xm7.g(), c23945xm72.g()) && !AbstractC13042fc3.d(c23945xm7.f(), c23945xm72.f())))) {
            u();
            return;
        }
        int size2 = this.i.size();
        for (int i2 = 0; i2 < size2; i2++) {
            InputConnectionC11628dK5 inputConnectionC11628dK52 = (InputConnectionC11628dK5) ((WeakReference) this.i.get(i2)).get();
            if (inputConnectionC11628dK52 != null) {
                inputConnectionC11628dK52.g(this.g, this.b);
            }
        }
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void d(C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, C13774gn7 c13774gn7, UA2 ua2, CK5 ck5, CK5 ck52) {
        this.l.d(c23945xm7, interfaceC11600dH4, c13774gn7, ua2, ck5, ck52);
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void e() {
        this.d = false;
        this.e = g.e;
        this.f = h.e;
        this.k = null;
        v(a.b);
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void f(CK5 ck5) {
        Rect rect;
        this.k = new Rect(AbstractC20723sV3.d(ck5.i()), AbstractC20723sV3.d(ck5.l()), AbstractC20723sV3.d(ck5.j()), AbstractC20723sV3.d(ck5.e()));
        if (!this.i.isEmpty() || (rect = this.k) == null) {
            return;
        }
        this.a.requestRectangleOnScreen(new Rect(rect));
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void g() {
        v(a.d);
    }

    @Override // ir.nasim.InterfaceC22097uf5
    public void h() {
        v(a.c);
    }

    public final InputConnection o(EditorInfo editorInfo) {
        if (!this.d) {
            return null;
        }
        AbstractC8330Vm7.h(editorInfo, this.h, this.g);
        AbstractC8330Vm7.i(editorInfo);
        InputConnectionC11628dK5 inputConnectionC11628dK5 = new InputConnectionC11628dK5(this.g, new d(), this.h.b());
        this.i.add(new WeakReference(inputConnectionC11628dK5));
        return inputConnectionC11628dK5;
    }

    public final View q() {
        return this.a;
    }

    public final boolean r() {
        return this.d;
    }

    public /* synthetic */ C7623Sm7(View view, FV3 fv3, InterfaceC19324q93 interfaceC19324q93, Executor executor, int i, ED1 ed1) {
        this(view, fv3, interfaceC19324q93, (i & 8) != 0 ? AbstractC8330Vm7.d(Choreographer.getInstance()) : executor);
    }

    public C7623Sm7(View view, FV3 fv3) {
        this(view, fv3, new C20524s93(view), null, 8, null);
    }

    /* renamed from: ir.nasim.Sm7$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return C19938rB7.a;
        }

        public final void a(List list) {
        }
    }

    /* renamed from: ir.nasim.Sm7$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((S33) obj).p());
            return C19938rB7.a;
        }

        public final void a(int i) {
        }
    }

    /* renamed from: ir.nasim.Sm7$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        public static final g e = new g();

        g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((List) obj);
            return C19938rB7.a;
        }

        public final void a(List list) {
        }
    }

    /* renamed from: ir.nasim.Sm7$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        public static final h e = new h();

        h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((S33) obj).p());
            return C19938rB7.a;
        }

        public final void a(int i) {
        }
    }
}
