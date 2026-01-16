package ir.nasim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.compose.ui.e;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AV7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qS4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19497qS4 {

    /* renamed from: ir.nasim.qS4$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;

        /* renamed from: ir.nasim.qS4$a$a, reason: collision with other inner class name */
        static final class C1465a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* renamed from: ir.nasim.qS4$a$a$a, reason: collision with other inner class name */
            static final class C1466a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ InterfaceC14415hs5 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1466a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = interfaceC14415hs5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1466a c1466a = new C1466a(this.d, interfaceC20295rm1);
                    c1466a.c = obj;
                    return c1466a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.setValue((M26) this.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(M26 m26, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1466a) create(m26, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1465a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1465a c1465a = new C1465a(this.d, interfaceC20295rm1);
                c1465a.c = obj;
                return c1465a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2 = (InterfaceC4557Fq2) this.c;
                    C1466a c1466a = new C1466a(this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2, c1466a, this) == objE) {
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
            public final Object invoke(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1465a) create(interfaceC4557Fq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.qS4$a$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.qS4$a$b$a, reason: collision with other inner class name */
            public static final class C1467a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.qS4$a$b$a$a, reason: collision with other inner class name */
                public static final class C1468a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1468a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1467a.this.a(null, this);
                    }
                }

                public C1467a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.AbstractC19497qS4.a.b.C1467a.C1468a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.qS4$a$b$a$a r0 = (ir.nasim.AbstractC19497qS4.a.b.C1467a.C1468a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.qS4$a$b$a$a r0 = new ir.nasim.qS4$a$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L4a
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                        ir.nasim.mz0$a r2 = r2.e()
                        ir.nasim.mz0$a r4 = ir.nasim.C17448mz0.a.n
                        if (r2 == r4) goto L4a
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L4a
                        return r1
                    L4a:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19497qS4.a.b.C1467a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1467a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.qS4$a$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.qS4$a$c$a, reason: collision with other inner class name */
            public static final class C1469a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.qS4$a$c$a$a, reason: collision with other inner class name */
                public static final class C1470a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1470a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1469a.this.a(null, this);
                    }
                }

                public C1469a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.AbstractC19497qS4.a.c.C1469a.C1470a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.qS4$a$c$a$a r0 = (ir.nasim.AbstractC19497qS4.a.c.C1469a.C1470a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.qS4$a$c$a$a r0 = new ir.nasim.qS4$a$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                        ir.nasim.Fq2 r5 = r5.h()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19497qS4.a.c.C1469a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1469a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(new c(new b(this.d)));
                C1465a c1465a = new C1465a(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2F, c1465a, this) == objE) {
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
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qS4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;

        /* renamed from: ir.nasim.qS4$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* renamed from: ir.nasim.qS4$b$a$a, reason: collision with other inner class name */
            static final class C1471a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ InterfaceC14415hs5 d;

                /* renamed from: ir.nasim.qS4$b$a$a$a, reason: collision with other inner class name */
                static final class C1472a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;
                    final /* synthetic */ InterfaceC14415hs5 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1472a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = interfaceC14415hs5;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1472a c1472a = new C1472a(this.d, interfaceC20295rm1);
                        c1472a.c = obj;
                        return c1472a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        this.d.setValue((M26) this.c);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(M26 m26, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1472a) create(m26, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1471a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = interfaceC14415hs5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1471a c1471a = new C1471a(this.d, interfaceC20295rm1);
                    c1471a.c = obj;
                    return c1471a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2 = (InterfaceC4557Fq2) AbstractC15401jX0.q0((List) this.c);
                        C1472a c1472a = new C1472a(this.d, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2, c1472a, this) == objE) {
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
                public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1471a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.qS4$b$a$b, reason: collision with other inner class name */
            public static final class C1473b implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.qS4$b$a$b$a, reason: collision with other inner class name */
                public static final class C1474a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.qS4$b$a$b$a$a, reason: collision with other inner class name */
                    public static final class C1475a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1475a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1474a.this.a(null, this);
                        }
                    }

                    public C1474a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.AbstractC19497qS4.b.a.C1473b.C1474a.C1475a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.qS4$b$a$b$a$a r0 = (ir.nasim.AbstractC19497qS4.b.a.C1473b.C1474a.C1475a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.qS4$b$a$b$a$a r0 = new ir.nasim.qS4$b$a$b$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L4b
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            r2 = r5
                            java.util.List r2 = (java.util.List) r2
                            java.util.Collection r2 = (java.util.Collection) r2
                            boolean r2 = r2.isEmpty()
                            r2 = r2 ^ r3
                            if (r2 == 0) goto L4b
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L4b
                            return r1
                        L4b:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19497qS4.b.a.C1473b.C1474a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public C1473b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1474a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C1473b c1473b = new C1473b((InterfaceC4557Fq2) this.c);
                    C1471a c1471a = new C1471a(this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(c1473b, c1471a, this) == objE) {
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
            public final Object invoke(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC4557Fq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.qS4$b$b, reason: collision with other inner class name */
        public static final class C1476b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.qS4$b$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.qS4$b$b$a$a, reason: collision with other inner class name */
                public static final class C1477a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1477a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.AbstractC19497qS4.b.C1476b.a.C1477a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.qS4$b$b$a$a r0 = (ir.nasim.AbstractC19497qS4.b.C1476b.a.C1477a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.qS4$b$b$a$a r0 = new ir.nasim.qS4$b$b$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L4a
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                        ir.nasim.mz0$a r2 = r2.e()
                        ir.nasim.mz0$a r4 = ir.nasim.C17448mz0.a.n
                        if (r2 == r4) goto L4a
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L4a
                        return r1
                    L4a:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19497qS4.b.C1476b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public C1476b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.qS4$b$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.qS4$b$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.qS4$b$c$a$a, reason: collision with other inner class name */
                public static final class C1478a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1478a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.AbstractC19497qS4.b.c.a.C1478a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.qS4$b$c$a$a r0 = (ir.nasim.AbstractC19497qS4.b.c.a.C1478a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.qS4$b$c$a$a r0 = new ir.nasim.qS4$b$c$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                        ir.nasim.Fq2 r5 = r5.k()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19497qS4.b.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(new c(new C1476b(this.d)));
                a aVar = new a(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2F, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final void f(final InterfaceC10258bL6 interfaceC10258bL6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        androidx.compose.foundation.layout.h hVar;
        final AV7 av7K;
        AbstractC13042fc3.i(interfaceC10258bL6, "callState");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(286208265);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC10258bL6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), G10.a.b(interfaceC22053ub1J, G10.b).a(), null, 2, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.e(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar2 = androidx.compose.foundation.layout.h.a;
            M26 m26 = new M26(false, false, false, false, null, null, null, null, null, false, null, null, null, null, null, 32767, null);
            interfaceC22053ub1J.W(1188480978);
            boolean zD = interfaceC22053ub1J.D(interfaceC10258bL6);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new b(interfaceC10258bL6, null);
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6K = AbstractC10222bH6.k(m26, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 0);
            M26 m262 = new M26(false, false, false, false, null, null, null, null, null, false, null, null, null, null, null, 32767, null);
            interfaceC22053ub1J.W(1188496501);
            boolean zD2 = interfaceC22053ub1J.D(interfaceC10258bL6);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new a(interfaceC10258bL6, null);
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6K2 = AbstractC10222bH6.k(m262, (InterfaceC14603iB2) objB2, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(1188507964);
            if (g(interfaceC9664aL6K).r() || (av7K = g(interfaceC9664aL6K).k()) == null) {
                hVar = hVar2;
            } else {
                if (av7K instanceof AV7.a) {
                    interfaceC22053ub1J.W(-1285559536);
                    androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
                    interfaceC22053ub1J.W(512723268);
                    Object objB3 = interfaceC22053ub1J.B();
                    InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
                    if (objB3 == aVar4.a()) {
                        objB3 = new UA2() { // from class: ir.nasim.lS4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC19497qS4.k((Context) obj);
                            }
                        };
                        interfaceC22053ub1J.s(objB3);
                    }
                    UA2 ua2 = (UA2) objB3;
                    interfaceC22053ub1J.Q();
                    interfaceC22053ub1J.W(512729599);
                    boolean zV = interfaceC22053ub1J.V(av7K);
                    Object objB4 = interfaceC22053ub1J.B();
                    if (zV || objB4 == aVar4.a()) {
                        objB4 = new UA2() { // from class: ir.nasim.mS4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC19497qS4.l(av7K, (FrameLayout) obj);
                            }
                        };
                        interfaceC22053ub1J.s(objB4);
                    }
                    interfaceC22053ub1J.Q();
                    hVar = hVar2;
                    AbstractC11355cs.a(ua2, eVarF, (UA2) objB4, interfaceC22053ub1J, 54, 0);
                    interfaceC22053ub1J.Q();
                } else {
                    hVar = hVar2;
                    if (!(av7K instanceof AV7.b)) {
                        interfaceC22053ub1J.W(512717157);
                        interfaceC22053ub1J.Q();
                        throw new NoWhenBranchMatchedException();
                    }
                    interfaceC22053ub1J.W(-1284515425);
                    ((AV7.b) av7K).a().invoke(interfaceC22053ub1J, 0);
                    interfaceC22053ub1J.Q();
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(hVar.h(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(60)), C17784nZ1.q(80)), aVar2.c()), C17784nZ1.q(4));
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            final AV7 av7K2 = j(interfaceC9664aL6K2).k();
            interfaceC22053ub1J.W(512767375);
            if (av7K2 != null) {
                if (av7K2 instanceof AV7.a) {
                    interfaceC22053ub1J.W(-1199951599);
                    androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), N46.a(20.0f));
                    interfaceC22053ub1J.W(1208224451);
                    Object objB5 = interfaceC22053ub1J.B();
                    InterfaceC22053ub1.a aVar5 = InterfaceC22053ub1.a;
                    if (objB5 == aVar5.a()) {
                        objB5 = new UA2() { // from class: ir.nasim.nS4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC19497qS4.h((Context) obj);
                            }
                        };
                        interfaceC22053ub1J.s(objB5);
                    }
                    UA2 ua22 = (UA2) objB5;
                    interfaceC22053ub1J.Q();
                    interfaceC22053ub1J.W(1208230782);
                    boolean zV2 = interfaceC22053ub1J.V(av7K2);
                    Object objB6 = interfaceC22053ub1J.B();
                    if (zV2 || objB6 == aVar5.a()) {
                        objB6 = new UA2() { // from class: ir.nasim.oS4
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC19497qS4.i(av7K2, (FrameLayout) obj);
                            }
                        };
                        interfaceC22053ub1J.s(objB6);
                    }
                    interfaceC22053ub1J.Q();
                    AbstractC11355cs.a(ua22, eVarA, (UA2) objB6, interfaceC22053ub1J, 6, 0);
                    interfaceC22053ub1J.Q();
                } else {
                    if (!(av7K2 instanceof AV7.b)) {
                        interfaceC22053ub1J.W(1208215364);
                        interfaceC22053ub1J.Q();
                        throw new NoWhenBranchMatchedException();
                    }
                    interfaceC22053ub1J.W(-1198815232);
                    ((AV7.b) av7K2).a().invoke(interfaceC22053ub1J, 0);
                    interfaceC22053ub1J.Q();
                }
                C19938rB7 c19938rB72 = C19938rB7.a;
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.pS4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19497qS4.m(interfaceC10258bL6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final M26 g(InterfaceC9664aL6 interfaceC9664aL6) {
        return (M26) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FrameLayout h(Context context) {
        AbstractC13042fc3.i(context, "context");
        return new FrameLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(AV7 av7, FrameLayout frameLayout) {
        AbstractC13042fc3.i(av7, "$videoSurfaceView");
        AbstractC13042fc3.i(frameLayout, "view");
        View viewA = ((AV7.a) av7).a();
        if (viewA != null) {
            ViewParent parent = viewA.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(viewA);
            }
            viewA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(viewA);
        }
        return C19938rB7.a;
    }

    private static final M26 j(InterfaceC9664aL6 interfaceC9664aL6) {
        return (M26) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FrameLayout k(Context context) {
        AbstractC13042fc3.i(context, "context");
        return new FrameLayout(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(AV7 av7, FrameLayout frameLayout) {
        AbstractC13042fc3.i(av7, "$videoSurfaceView");
        AbstractC13042fc3.i(frameLayout, "view");
        View viewA = ((AV7.a) av7).a();
        if (viewA != null) {
            ViewParent parent = viewA.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(viewA);
            }
            viewA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(viewA);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(InterfaceC10258bL6 interfaceC10258bL6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC10258bL6, "$callState");
        f(interfaceC10258bL6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
