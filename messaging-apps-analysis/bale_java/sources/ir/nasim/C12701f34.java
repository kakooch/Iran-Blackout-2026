package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.f34, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12701f34 extends RecyclerView.C {
    private final GestureDetector A;
    private final ComposeView u;
    private final InterfaceC14603iB2 v;
    private final InterfaceC9102Ym4 w;
    private final InterfaceC9102Ym4 x;
    private Q14 y;
    private final b z;

    /* renamed from: ir.nasim.f34$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ Q14 a;
        final /* synthetic */ C12701f34 b;

        /* renamed from: ir.nasim.f34$a$a, reason: collision with other inner class name */
        static final class C1070a implements InterfaceC14603iB2 {
            final /* synthetic */ Q14 a;
            final /* synthetic */ C12701f34 b;

            C1070a(Q14 q14, C12701f34 c12701f34) {
                this.a = q14;
                this.b = c12701f34;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC15719k34.d(this.a, this.b.O0(), this.b.Q0(), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(Q14 q14, C12701f34 c12701f34) {
            this.a = q14;
            this.b = c12701f34;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(174820298, true, new C1070a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.f34$b */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        private SA2 a;

        b() {
        }

        public final void a(SA2 sa2) {
            this.a = sa2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            AbstractC5770Kt3.b(new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY()));
            SA2 sa2 = this.a;
            if (sa2 == null) {
                return true;
            }
            sa2.invoke();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12701f34(ComposeView composeView, InterfaceC14603iB2 interfaceC14603iB2) {
        super(composeView);
        AbstractC13042fc3.i(composeView, "composeView");
        AbstractC13042fc3.i(interfaceC14603iB2, "onUserClick");
        this.u = composeView;
        this.v = interfaceC14603iB2;
        this.w = AbstractC13472gH6.d(null, null, 2, null);
        this.x = AbstractC13472gH6.d(null, null, 2, null);
        b bVar = new b();
        this.z = bVar;
        this.A = new GestureDetector(this.a.getContext(), bVar);
        composeView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.e34
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C12701f34.E0(this.a, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E0(C12701f34 c12701f34, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c12701f34, "this$0");
        return c12701f34.A.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L0(Q14 q14, C12701f34 c12701f34) {
        AbstractC13042fc3.i(c12701f34, "this$0");
        if (q14 != null) {
            InterfaceC14603iB2 interfaceC14603iB2 = c12701f34.v;
            View view = c12701f34.a;
            AbstractC13042fc3.h(view, "itemView");
            interfaceC14603iB2.invoke(q14, view);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String O0() {
        return (String) this.w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Q0() {
        return (String) this.x.getValue();
    }

    private final void S0(String str) {
        this.w.setValue(str);
    }

    private final void T0(String str) {
        this.x.setValue(str);
    }

    private final void U0(String str) {
        Q14 q14 = this.y;
        if (q14 == null) {
            return;
        }
        Context context = this.u.getContext();
        String string = q14.l() ? context.getString(RD5.owner) : q14.j() ? context.getString(RD5.admin) : "";
        AbstractC13042fc3.f(string);
        this.u.setContentDescription(q14.e() + Separators.SP + str + Separators.SP + string);
    }

    public final void J0(final Q14 q14) {
        this.u.setContentDescription(q14 != null ? q14.e() : null);
        this.y = q14;
        this.z.a(new SA2() { // from class: ir.nasim.d34
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12701f34.L0(q14, this);
            }
        });
        if (q14 != null) {
            this.u.setContent(AbstractC19242q11.c(-204756827, true, new a(q14, this)));
        }
    }

    public final void M0(String str) {
        S0(str);
    }

    public final void N0(String str) {
        AbstractC13042fc3.i(str, "formattedPresence");
        T0(str);
        U0(str);
    }

    public final Q14 P0() {
        return this.y;
    }

    public final void a() {
        S0(null);
        T0(null);
        this.y = null;
    }
}
