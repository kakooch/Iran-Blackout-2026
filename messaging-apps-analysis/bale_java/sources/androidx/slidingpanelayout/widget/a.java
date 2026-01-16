package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14260hd2;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.C19938rB7;
import ir.nasim.C25010za8;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC20721sV1;
import ir.nasim.InterfaceC21132t98;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC7920Tt2;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class a {
    private final InterfaceC21132t98 a;
    private final Executor b;
    private InterfaceC13730gj3 c;
    private InterfaceC0125a d;

    /* renamed from: androidx.slidingpanelayout.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0125a {
        void a(InterfaceC7920Tt2 interfaceC7920Tt2);
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Activity d;

        /* renamed from: androidx.slidingpanelayout.widget.a$b$a, reason: collision with other inner class name */
        public static final class C0126a implements InterfaceC4806Gq2 {
            final /* synthetic */ a a;

            public C0126a(a aVar) {
                this.a = aVar;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C19938rB7 c19938rB7;
                InterfaceC7920Tt2 interfaceC7920Tt2 = (InterfaceC7920Tt2) obj;
                InterfaceC0125a interfaceC0125a = this.a.d;
                if (interfaceC0125a == null) {
                    c19938rB7 = null;
                } else {
                    interfaceC0125a.a(interfaceC7920Tt2);
                    c19938rB7 = C19938rB7.a;
                }
                return c19938rB7 == AbstractC14862ic3.e() ? c19938rB7 : C19938rB7.a;
            }
        }

        /* renamed from: androidx.slidingpanelayout.widget.a$b$b, reason: collision with other inner class name */
        public static final class C0127b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ a b;

            /* renamed from: androidx.slidingpanelayout.widget.a$b$b$a, reason: collision with other inner class name */
            public static final class C0128a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ a b;

                /* renamed from: androidx.slidingpanelayout.widget.a$b$b$a$a, reason: collision with other inner class name */
                public static final class C0129a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0129a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C0128a.this.a(null, this);
                    }
                }

                public C0128a(InterfaceC4806Gq2 interfaceC4806Gq2, a aVar) {
                    this.a = interfaceC4806Gq2;
                    this.b = aVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.slidingpanelayout.widget.a.b.C0127b.C0128a.C0129a
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.slidingpanelayout.widget.a$b$b$a$a r0 = (androidx.slidingpanelayout.widget.a.b.C0127b.C0128a.C0129a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        androidx.slidingpanelayout.widget.a$b$b$a$a r0 = new androidx.slidingpanelayout.widget.a$b$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L4a
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.za8 r5 = (ir.nasim.C25010za8) r5
                        androidx.slidingpanelayout.widget.a r2 = r4.b
                        ir.nasim.Tt2 r5 = androidx.slidingpanelayout.widget.a.a(r2, r5)
                        if (r5 != 0) goto L41
                        goto L4a
                    L41:
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4a
                        return r1
                    L4a:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.a.b.C0127b.C0128a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public C0127b(InterfaceC4557Fq2 interfaceC4557Fq2, a aVar) {
                this.a = interfaceC4557Fq2;
                this.b = aVar;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C0128a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = activity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new C0127b(a.this.a.b(this.d), a.this));
                C0126a c0126a = new C0126a(a.this);
                this.b = 1;
                if (interfaceC4557Fq2V.b(c0126a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public a(InterfaceC21132t98 interfaceC21132t98, Executor executor) {
        AbstractC13042fc3.i(interfaceC21132t98, "windowInfoTracker");
        AbstractC13042fc3.i(executor, "executor");
        this.a = interfaceC21132t98;
        this.b = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC7920Tt2 d(C25010za8 c25010za8) {
        Object next;
        Iterator it = c25010za8.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((InterfaceC20721sV1) next) instanceof InterfaceC7920Tt2) {
                break;
            }
        }
        if (next instanceof InterfaceC7920Tt2) {
            return (InterfaceC7920Tt2) next;
        }
        return null;
    }

    public final void e(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        InterfaceC13730gj3 interfaceC13730gj3 = this.c;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.c = AbstractC10533bm0.d(AbstractC20906so1.a(AbstractC14260hd2.b(this.b)), null, null, new b(activity, null), 3, null);
    }

    public final void f(InterfaceC0125a interfaceC0125a) {
        AbstractC13042fc3.i(interfaceC0125a, "onFoldingFeatureChangeListener");
        this.d = interfaceC0125a;
    }

    public final void g() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.c;
        if (interfaceC13730gj3 == null) {
            return;
        }
        InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
    }
}
