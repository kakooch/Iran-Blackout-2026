package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13019fa0;
import ir.nasim.AbstractC19657qj2;
import ir.nasim.C20919sp4;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.fa0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC13019fa0 extends RecyclerView.C {
    public static final a Y = new a(null);
    public static final int Z = 8;
    private final InterfaceC9173Yu3 A;
    private final C19066pj2 B;
    private final InterfaceC9173Yu3 D;
    private final InterfaceC9173Yu3 G;
    private final InterfaceC9173Yu3 H;
    private final InterfaceC9173Yu3 J;
    private final InterfaceC9764aW7 u;
    private final InterfaceC13138fj2 v;
    private C20919sp4 w;
    private C20919sp4.b x;
    private C20919sp4.b y;
    private final C4734Gi2 z;

    /* renamed from: ir.nasim.fa0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fa0$b */
    protected static final class b {
        private final InterfaceC9173Yu3 a = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ga0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC13019fa0.b.b();
            }
        });

        /* JADX INFO: Access modifiers changed from: private */
        public static final C20644sM5 b() {
            return new C20644sM5("(?:[\\t\\f\\v \u200c\\u00a0\\u1680\\u2000-\\u200a\\u2028\\u2029\\u202f\\u205f\\u3000\\ufeff]*\\n){2,}", EnumC23107wM5.d);
        }

        private final String c(String str) {
            try {
                return d().k(str, "\n\n");
            } catch (Exception e) {
                Log.e("BaseFeedHolder", "condenseBlankLines: ", e);
                return str;
            }
        }

        private final C20644sM5 d() {
            return (C20644sM5) this.a.getValue();
        }

        public final CharSequence e(String str) {
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            return R62.W(AbstractC5730Kp.f(c(str), null, null, null), null, AbstractC7426Rr.a.f(14.0f), false, null, null, 48, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC13019fa0(InterfaceC9764aW7 interfaceC9764aW7, InterfaceC13138fj2 interfaceC13138fj2) {
        super(interfaceC9764aW7.getRoot());
        AbstractC13042fc3.i(interfaceC9764aW7, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        this.u = interfaceC9764aW7;
        this.v = interfaceC13138fj2;
        this.w = new C20919sp4();
        this.z = new C4734Gi2();
        this.A = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.S90
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC13019fa0.f1(this.a);
            }
        });
        this.B = new C19066pj2(new UA2() { // from class: ir.nasim.W90
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AbstractC13019fa0.g1(this.a, (MotionEvent) obj));
            }
        }, new UA2() { // from class: ir.nasim.X90
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC13019fa0.i1(this.a, (String) obj);
            }
        });
        this.D = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Y90
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC13019fa0.e1();
            }
        });
        this.G = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Z90
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC13019fa0.j1(this.a);
            }
        });
        this.H = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.aa0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC13019fa0.A1(this.a);
            }
        });
        this.J = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ba0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC13019fa0.d1(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final D20 A1(AbstractC13019fa0 abstractC13019fa0) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        ZH5 zh5 = ZH5.a;
        Context context = abstractC13019fa0.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        Context context2 = abstractC13019fa0.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        return zh5.a(context, null, OY0.b(context2, AbstractC13999hA5.colorSurface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V0(AbstractC13019fa0 abstractC13019fa0, C14697iL2 c14697iL2, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        InterfaceC13138fj2 interfaceC13138fj2 = abstractC13019fa0.v;
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2.z(c11458d25I0, XH6.a, c5886Lg2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W0(AbstractC13019fa0 abstractC13019fa0, C14697iL2 c14697iL2, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        InterfaceC13138fj2 interfaceC13138fj2 = abstractC13019fa0.v;
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2.m(false, c11458d25I0, XH6.a, c5886Lg2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X0(J44 j44, AbstractC13019fa0 abstractC13019fa0, C14697iL2 c14697iL2, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        List listE = AbstractC9766aX0.e(j44);
        InterfaceC13138fj2 interfaceC13138fj2 = abstractC13019fa0.v;
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2.h(c11458d25I0, listE, XH6.a, c5886Lg2, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y0(AbstractC13019fa0 abstractC13019fa0, C14697iL2 c14697iL2, J44 j44, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        InterfaceC13138fj2 interfaceC13138fj2 = abstractC13019fa0.v;
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2.x(c11458d25I0, j44, c5886Lg2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z0(AbstractC13019fa0 abstractC13019fa0, J44 j44) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        abstractC13019fa0.v.j(j44);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 a1(AbstractC13019fa0 abstractC13019fa0, J44 j44, C14697iL2 c14697iL2, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        InterfaceC13138fj2 interfaceC13138fj2 = abstractC13019fa0.v;
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2.f(j44, c11458d25I0, c5886Lg2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable d1(AbstractC13019fa0 abstractC13019fa0) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        Drawable drawableF = AbstractC4043Dl1.f(abstractC13019fa0.a.getContext(), AbstractC18163oB5.ic_feed_heart);
        if (drawableF == null) {
            return null;
        }
        Context context = abstractC13019fa0.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        drawableF.setTint(OY0.b(context, AbstractC13999hA5.n500));
        return drawableF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b e1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GestureDetector f1(AbstractC13019fa0 abstractC13019fa0) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        return new GestureDetector(abstractC13019fa0.l1().getRoot().getContext(), abstractC13019fa0.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g1(AbstractC13019fa0 abstractC13019fa0, MotionEvent motionEvent) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        AbstractC13042fc3.i(motionEvent, "it");
        return abstractC13019fa0.q1().onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i1(AbstractC13019fa0 abstractC13019fa0, String str) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        AbstractC13042fc3.i(str, "it");
        abstractC13019fa0.v.s(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorDrawable j1(AbstractC13019fa0 abstractC13019fa0) {
        AbstractC13042fc3.i(abstractC13019fa0, "this$0");
        Context context = abstractC13019fa0.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new ColorDrawable(OY0.b(context, AbstractC21139tA5.n20));
    }

    protected final void B1(C20919sp4.b bVar) {
        this.x = bVar;
    }

    protected final void C1(C20919sp4.b bVar) {
        this.y = bVar;
    }

    public abstract AbstractC17457n0 T0();

    protected final List U0(final C14697iL2 c14697iL2, C14733iO2 c14733iO2, final C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c14697iL2, "group");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        ArrayList arrayList = new ArrayList();
        final J44 j44 = new J44(c5886Lg2.m(), c5886Lg2.e(), c5886Lg2.e(), c5886Lg2.n(), EnumC23558x74.PENDING, T0(), null, 0, new C8445Vz5(c5886Lg2.m(), c14697iL2.p0(), c14697iL2.w0(), c5886Lg2.e(), T0(), c14697iL2.I0(), true, null), null, 0L, null, null, false, null, null, false, null, null, 523968, null);
        if (c14733iO2 != null) {
            if (((Boolean) c14733iO2.F().b()).booleanValue()) {
                arrayList.add(new AbstractC19657qj2.f(new SA2() { // from class: ir.nasim.ca0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13019fa0.V0(this.a, c14697iL2, c5886Lg2);
                    }
                }));
            } else {
                arrayList.add(new AbstractC19657qj2.c(new SA2() { // from class: ir.nasim.da0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13019fa0.W0(this.a, c14697iL2, c5886Lg2);
                    }
                }));
            }
        }
        arrayList.add(new AbstractC19657qj2.b(new SA2() { // from class: ir.nasim.ea0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC13019fa0.X0(j44, this, c14697iL2, c5886Lg2);
            }
        }));
        arrayList.add(new AbstractC19657qj2.e(new SA2() { // from class: ir.nasim.T90
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC13019fa0.Y0(this.a, c14697iL2, j44, c5886Lg2);
            }
        }));
        if (n1()) {
            arrayList.add(new AbstractC19657qj2.a(new SA2() { // from class: ir.nasim.U90
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC13019fa0.Z0(this.a, j44);
                }
            }));
        }
        arrayList.add(new AbstractC19657qj2.d(new SA2() { // from class: ir.nasim.V90
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC13019fa0.a1(this.a, j44, c14697iL2, c5886Lg2);
            }
        }));
        return arrayList;
    }

    public void a() {
        this.z.h();
        C20919sp4.b bVar = this.x;
        if (bVar != null) {
            bVar.b();
        }
        this.x = null;
        C20919sp4.b bVar2 = this.y;
        if (bVar2 != null) {
            bVar2.b();
        }
        this.y = null;
    }

    public abstract void c1();

    public abstract InterfaceC9764aW7 l1();

    public abstract boolean n1();

    protected final Drawable o1() {
        return (Drawable) this.J.getValue();
    }

    protected final b p1() {
        return (b) this.D.getValue();
    }

    protected GestureDetector q1() {
        return (GestureDetector) this.A.getValue();
    }

    protected final C4734Gi2 r1() {
        return this.z;
    }

    public final InterfaceC13138fj2 s1() {
        return this.v;
    }

    public final C19066pj2 t1() {
        return this.B;
    }

    protected ColorDrawable u1() {
        return (ColorDrawable) this.G.getValue();
    }

    public int x1() {
        return 5;
    }

    protected final C20919sp4 y1() {
        return this.w;
    }

    protected final D20 z1() {
        return (D20) this.H.getValue();
    }
}
