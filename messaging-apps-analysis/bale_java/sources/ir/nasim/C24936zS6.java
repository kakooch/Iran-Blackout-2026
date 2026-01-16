package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.j;
import com.google.android.exoplayer2.E0;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.z0;
import com.google.protobuf.AbstractC2383g;
import ir.nasim.C17595nE1;
import ir.nasim.C6918Pn5;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14190hV7;
import ir.nasim.designsystem.ImageViewCrossFade;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.zS6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24936zS6 extends TX2 implements z0.d {
    public static final a w1 = new a(null);
    public static final int x1 = 8;
    private DS6 h1;
    public C6918Pn5.a i1;
    private C24143y7 k1;
    private com.google.android.exoplayer2.E0 l1;
    private QQ6 m1;
    private boolean n1;
    private boolean o1;
    private int p1;
    private InterfaceC14190hV7 q1;
    private InterfaceC13730gj3 r1;
    public PF2 t1;
    public C14801iV7 u1;
    public IT7 v1;
    private final InterfaceC9173Yu3 j1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.xS6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C24936zS6.sa(this.a);
        }
    });
    private final InterfaceC9173Yu3 s1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.yS6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C24936zS6.xa(this.a);
        }
    });

    /* renamed from: ir.nasim.zS6$a */
    public static final class a {
        private a() {
        }

        public final C24936zS6 a(QQ6 qq6, int i, DS6 ds6, boolean z) {
            AbstractC13042fc3.i(qq6, "storyItem");
            AbstractC13042fc3.i(ds6, "listener");
            Bundle bundle = new Bundle();
            bundle.putSerializable("BUNDLE_STORY_ITEM", qq6);
            bundle.putInt("BUNDLE_STORY_POSITION", i);
            bundle.putBoolean("BUNDLE_STORY_IS_FIRST_ITEM", z);
            C24936zS6 c24936zS6 = new C24936zS6(ds6);
            c24936zS6.a8(bundle);
            return c24936zS6;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.zS6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ QQ6 d;
        final /* synthetic */ C24936zS6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(QQ6 qq6, C24936zS6 c24936zS6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qq6;
            this.e = c24936zS6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            EnumC21310tR6 enumC21310tR6B;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                String strM = this.d.m();
                if (strM == null) {
                    return C19938rB7.a;
                }
                if (!this.d.G()) {
                    this.e.ua(strM);
                } else if (AbstractC20906so1.g(interfaceC20315ro1)) {
                    C24936zS6 c24936zS6 = this.e;
                    C20091rS7 c20091rS7C = this.d.C();
                    InterfaceC14190hV7.a aVar = new InterfaceC14190hV7.a(strM, (c20091rS7C == null || (enumC21310tR6B = c20091rS7C.b()) == null) ? null : enumC21310tR6B.q());
                    this.b = 1;
                    if (c24936zS6.ra(aVar, this) == objE) {
                        return objE;
                    }
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

    /* renamed from: ir.nasim.zS6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zS6$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C24936zS6 d;

            /* renamed from: ir.nasim.zS6$c$a$a, reason: collision with other inner class name */
            static final class C1816a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C24936zS6 c;

                /* renamed from: ir.nasim.zS6$c$a$a$a, reason: collision with other inner class name */
                static final class C1817a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;
                    final /* synthetic */ C24936zS6 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1817a(C24936zS6 c24936zS6, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = c24936zS6;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1817a c1817a = new C1817a(this.d, interfaceC20295rm1);
                        c1817a.c = obj;
                        return c1817a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        if (!AbstractC13042fc3.d((QQ6) this.c, this.d.m1)) {
                            com.google.android.exoplayer2.E0 e0 = this.d.l1;
                            if (e0 != null) {
                                e0.h();
                            }
                            com.google.android.exoplayer2.E0 e02 = this.d.l1;
                            if (e02 != null) {
                                e02.x(0L);
                            }
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(QQ6 qq6, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1817a) create(qq6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1816a(C24936zS6 c24936zS6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c24936zS6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1816a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC10258bL6 interfaceC10258bL6O3 = this.c.na().O3();
                        C1817a c1817a = new C1817a(this.c, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10258bL6O3, c1817a, this) == objE) {
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
                    return ((C1816a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.zS6$c$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C24936zS6 c;

                /* renamed from: ir.nasim.zS6$c$a$b$a, reason: collision with other inner class name */
                static final class C1818a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ boolean c;
                    final /* synthetic */ C24936zS6 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1818a(C24936zS6 c24936zS6, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = c24936zS6;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1818a c1818a = new C1818a(this.d, interfaceC20295rm1);
                        c1818a.c = ((Boolean) obj).booleanValue();
                        return c1818a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:45:0x009f  */
                    @Override // ir.nasim.E90
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                        /*
                            r4 = this;
                            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                            int r1 = r4.b
                            r2 = 1
                            if (r1 == 0) goto L18
                            if (r1 != r2) goto L10
                            ir.nasim.AbstractC10685c16.b(r5)
                            goto L92
                        L10:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r0)
                            throw r5
                        L18:
                            ir.nasim.AbstractC10685c16.b(r5)
                            boolean r5 = r4.c
                            if (r5 == 0) goto L2c
                            ir.nasim.zS6 r5 = r4.d
                            com.google.android.exoplayer2.E0 r5 = ir.nasim.C24936zS6.W9(r5)
                            if (r5 == 0) goto La2
                            r5.h()
                            goto La2
                        L2c:
                            ir.nasim.zS6 r5 = r4.d
                            ir.nasim.QQ6 r5 = ir.nasim.C24936zS6.Y9(r5)
                            if (r5 == 0) goto La2
                            ir.nasim.zS6 r5 = r4.d
                            ir.nasim.QQ6 r5 = ir.nasim.C24936zS6.Y9(r5)
                            if (r5 == 0) goto La2
                            boolean r5 = r5.G()
                            if (r5 != r2) goto La2
                            ir.nasim.zS6 r5 = r4.d
                            boolean r5 = r5.B6()
                            if (r5 == 0) goto La2
                            ir.nasim.zS6 r5 = r4.d
                            com.google.android.exoplayer2.E0 r5 = ir.nasim.C24936zS6.W9(r5)
                            if (r5 == 0) goto L5b
                            int r5 = r5.p()
                            java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
                            goto L5c
                        L5b:
                            r5 = 0
                        L5c:
                            if (r5 != 0) goto L5f
                            goto L76
                        L5f:
                            int r1 = r5.intValue()
                            r3 = 4
                            if (r1 != r3) goto L76
                            ir.nasim.zS6 r5 = r4.d
                            com.google.android.exoplayer2.E0 r5 = ir.nasim.C24936zS6.W9(r5)
                            if (r5 == 0) goto L97
                            r0 = 0
                            r5.x(r0)
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            goto L97
                        L76:
                            if (r5 != 0) goto L79
                            goto L95
                        L79:
                            int r5 = r5.intValue()
                            if (r5 != r2) goto L95
                            ir.nasim.zS6 r5 = r4.d
                            ir.nasim.hV7 r5 = ir.nasim.C24936zS6.Z9(r5)
                            if (r5 == 0) goto L97
                            ir.nasim.zS6 r1 = r4.d
                            r4.b = r2
                            java.lang.Object r5 = ir.nasim.C24936zS6.ca(r1, r5, r4)
                            if (r5 != r0) goto L92
                            return r0
                        L92:
                            ir.nasim.rB7 r5 = (ir.nasim.C19938rB7) r5
                            goto L97
                        L95:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        L97:
                            ir.nasim.zS6 r5 = r4.d
                            com.google.android.exoplayer2.E0 r5 = ir.nasim.C24936zS6.W9(r5)
                            if (r5 == 0) goto La2
                            r5.q()
                        La2:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24936zS6.c.a.b.C1818a.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1818a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C24936zS6 c24936zS6, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c24936zS6;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC10258bL6 interfaceC10258bL6N4 = this.c.na().N4();
                        C1818a c1818a = new C1818a(this.c, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10258bL6N4, c1818a, this) == objE) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24936zS6 c24936zS6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c24936zS6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C1816a(this.d, null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(this.d, null), 3, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24936zS6.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18633oz3 interfaceC18633oz3P6 = C24936zS6.this.p6();
                AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
                j.b bVar = j.b.STARTED;
                a aVar = new a(C24936zS6.this, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(interfaceC18633oz3P6, bVar, aVar, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zS6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zS6$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ float c;
            final /* synthetic */ C24936zS6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24936zS6 c24936zS6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c24936zS6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Number) obj).floatValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).floatValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                float f = this.c;
                com.google.android.exoplayer2.E0 e0 = this.d.l1;
                if (e0 != null) {
                    e0.g(f);
                }
                return C19938rB7.a;
            }

            public final Object n(float f, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Float.valueOf(f), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24936zS6.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2O4 = C24936zS6.this.na().O4();
                a aVar = new a(C24936zS6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2O4, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zS6$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ InterfaceC14190hV7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC14190hV7 interfaceC14190hV7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = interfaceC14190hV7;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = C24936zS6.this.new e(this.f, interfaceC20295rm1);
            eVar.d = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            com.google.android.exoplayer2.E0 e0;
            C24936zS6 c24936zS6;
            PlayerView playerView;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.d;
                C24936zS6.this.q1 = this.f;
                C24143y7 c24143y7 = C24936zS6.this.k1;
                if (c24143y7 != null && (playerView = c24143y7.d) != null) {
                    C24936zS6 c24936zS62 = C24936zS6.this;
                    playerView.setUseController(false);
                    playerView.setPlayer(c24936zS62.l1);
                }
                com.google.android.exoplayer2.E0 e02 = C24936zS6.this.l1;
                if (e02 != null) {
                    C24936zS6 c24936zS63 = C24936zS6.this;
                    InterfaceC14190hV7 interfaceC14190hV7 = this.f;
                    if (!AbstractC20906so1.g(interfaceC20315ro1)) {
                        return C19938rB7.a;
                    }
                    e02.m0(c24936zS63);
                    C6918Pn5 c6918Pn5La = c24936zS63.la();
                    this.d = c24936zS63;
                    this.b = e02;
                    this.c = 1;
                    if (C6918Pn5.h(c6918Pn5La, null, interfaceC14190hV7, e02, this, 1, null) == objE) {
                        return objE;
                    }
                    e0 = e02;
                    c24936zS6 = c24936zS63;
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0 = (com.google.android.exoplayer2.E0) this.b;
            c24936zS6 = (C24936zS6) this.d;
            AbstractC10685c16.b(obj);
            if ((c24936zS6.B6() && c24936zS6.wa()) || (c24936zS6.n1 && c24936zS6.wa())) {
                C19406qI3.a("Story", "pager is ready for playing video story", new Object[0]);
                e0.D(true);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zS6$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ QQ6 d;
        final /* synthetic */ C24936zS6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(QQ6 qq6, C24936zS6 c24936zS6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qq6;
            this.e = c24936zS6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(InterfaceC20315ro1 interfaceC20315ro1, C24936zS6 c24936zS6, InterfaceC3346Am2 interfaceC3346Am2, boolean z) {
            Context contextG5;
            ConstraintLayout constraintLayout;
            if (AbstractC20906so1.g(interfaceC20315ro1) && (contextG5 = c24936zS6.G5()) != null) {
                C24143y7 c24143y7 = c24936zS6.k1;
                if (c24143y7 != null && (constraintLayout = c24143y7.b) != null) {
                    constraintLayout.setBackground(new ColorDrawable(AbstractC4043Dl1.c(contextG5, TA5.black)));
                }
                c24936zS6.ua(interfaceC3346Am2.getDescriptor());
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, this.e, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r13.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2e
                if (r1 == r4) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                ir.nasim.AbstractC10685c16.b(r14)
                goto La8
            L16:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L1e:
                java.lang.Object r0 = r13.c
                ir.nasim.ro1 r0 = (ir.nasim.InterfaceC20315ro1) r0
                ir.nasim.AbstractC10685c16.b(r14)
                goto L62
            L26:
                java.lang.Object r1 = r13.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r14)
                goto L51
            L2e:
                ir.nasim.AbstractC10685c16.b(r14)
                java.lang.Object r14 = r13.c
                r1 = r14
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.QQ6 r14 = r13.d
                boolean r14 = r14.G()
                if (r14 == 0) goto L88
                ir.nasim.zS6 r14 = r13.e
                ir.nasim.bX6 r14 = ir.nasim.C24936zS6.aa(r14)
                ir.nasim.QQ6 r2 = r13.d
                r13.c = r1
                r13.b = r4
                java.lang.Object r14 = r14.M4(r2, r13)
                if (r14 != r0) goto L51
                return r0
            L51:
                ir.nasim.hV7 r14 = (ir.nasim.InterfaceC14190hV7) r14
                if (r14 == 0) goto L66
                ir.nasim.zS6 r2 = r13.e
                r13.c = r1
                r13.b = r3
                java.lang.Object r14 = ir.nasim.C24936zS6.ca(r2, r14, r13)
                if (r14 != r0) goto L62
                return r0
            L62:
                ir.nasim.rB7 r14 = (ir.nasim.C19938rB7) r14
                if (r14 != 0) goto Laa
            L66:
                ir.nasim.QQ6 r14 = r13.d
                java.lang.String r14 = r14.l()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "showContent>getVideoSource(storyId="
                r0.append(r1)
                r0.append(r14)
                java.lang.String r14 = ") can't find the source!"
                r0.append(r14)
                java.lang.String r14 = r0.toString()
                java.lang.String r0 = "Story"
                ir.nasim.C19406qI3.b(r0, r14)
                goto Laa
            L88:
                ir.nasim.zS6 r14 = r13.e
                ir.nasim.bX6 r3 = ir.nasim.C24936zS6.aa(r14)
                ir.nasim.QQ6 r4 = r13.d
                ir.nasim.zS6 r14 = r13.e
                ir.nasim.AS6 r7 = new ir.nasim.AS6
                r7.<init>()
                r13.b = r2
                r5 = 0
                r6 = 1
                r8 = 0
                r9 = 1
                r11 = 16
                r12 = 0
                r10 = r13
                java.lang.Object r14 = ir.nasim.C10366bX6.I2(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                if (r14 != r0) goto La8
                return r0
            La8:
                ir.nasim.rB7 r14 = (ir.nasim.C19938rB7) r14
            Laa:
                ir.nasim.rB7 r14 = ir.nasim.C19938rB7.a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24936zS6.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C24936zS6(DS6 ds6) {
        this.h1 = ds6;
    }

    private final InterfaceC13730gj3 ha(QQ6 qq6) {
        return AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new b(qq6, this, null), 3, null);
    }

    private final void ia() {
        InterfaceC13730gj3 interfaceC13730gj3;
        try {
            InterfaceC13730gj3 interfaceC13730gj32 = this.r1;
            if (interfaceC13730gj32 == null || !interfaceC13730gj32.b() || (interfaceC13730gj3 = this.r1) == null) {
                return;
            }
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        } catch (Exception unused) {
        }
    }

    private final C17595nE1 ja() {
        C17595nE1 c17595nE1A = new C17595nE1.a().b(new UB1(true, 65536)).c(SIPTransactionStack.BASE_TIMER_INTERVAL, (int) TimeUnit.MINUTES.toMillis(1L), SIPTransactionStack.BASE_TIMER_INTERVAL, SIPTransactionStack.BASE_TIMER_INTERVAL).e(-1).d(true).a();
        AbstractC13042fc3.h(c17595nE1A, "build(...)");
        return c17595nE1A;
    }

    private final void ka() {
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            Serializable serializable = bundleE5.getSerializable("BUNDLE_STORY_ITEM");
            AbstractC13042fc3.g(serializable, "null cannot be cast to non-null type ir.nasim.story.model.StoryItem");
            this.m1 = (QQ6) serializable;
            this.p1 = bundleE5.getInt("BUNDLE_STORY_POSITION");
            this.n1 = bundleE5.getBoolean("BUNDLE_STORY_IS_FIRST_ITEM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6918Pn5 la() {
        return (C6918Pn5) this.j1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10366bX6 na() {
        return (C10366bX6) this.s1.getValue();
    }

    private final void oa() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new c(null), 3, null);
    }

    private final void pa() {
        this.l1 = new E0.a(S7()).b(ja()).a();
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(C24936zS6 c24936zS6) {
        AbstractC13042fc3.i(c24936zS6, "this$0");
        QQ6 qq6 = c24936zS6.m1;
        c24936zS6.va(qq6 != null ? qq6.z() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object ra(InterfaceC14190hV7 interfaceC14190hV7, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new e(interfaceC14190hV7, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6918Pn5 sa(C24936zS6 c24936zS6) {
        AbstractC13042fc3.i(c24936zS6, "this$0");
        return c24936zS6.ma().a(EnumC8893Xt7.c);
    }

    private final InterfaceC13730gj3 ta(QQ6 qq6) {
        return AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new f(qq6, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C24143y7 ua(String str) {
        C24143y7 c24143y7 = this.k1;
        if (c24143y7 == null) {
            return null;
        }
        if (this.o1) {
            DS6 ds6 = this.h1;
            if (ds6 == null) {
                return c24143y7;
            }
            ds6.M4(this.p1);
            return c24143y7;
        }
        this.o1 = true;
        c24143y7.c.setVisibility(0);
        c24143y7.c.bringToFront();
        c24143y7.d.setVisibility(8);
        ImageViewCrossFade imageViewCrossFade = c24143y7.c;
        AbstractC6302Na0 abstractC6302Na0M = new C20107rU5().m();
        AbstractC13042fc3.h(abstractC6302Na0M, "fitCenter(...)");
        imageViewCrossFade.m(str, (C20107rU5) abstractC6302Na0M);
        DS6 ds62 = this.h1;
        if (ds62 == null) {
            return c24143y7;
        }
        ds62.M4(this.p1);
        return c24143y7;
    }

    private final C24143y7 va(AbstractC2383g abstractC2383g) {
        C24143y7 c24143y7 = this.k1;
        if (c24143y7 == null) {
            return null;
        }
        if (abstractC2383g == null) {
            return c24143y7;
        }
        c24143y7.c.setVisibility(0);
        c24143y7.c.bringToFront();
        c24143y7.d.setVisibility(8);
        ImageViewCrossFade imageViewCrossFade = c24143y7.c;
        byte[] bArrA0 = abstractC2383g.a0();
        AbstractC13042fc3.h(bArrA0, "toByteArray(...)");
        AbstractC6302Na0 abstractC6302Na0U0 = new C20107rU5().u0(new C5191Ih0(50, 2));
        AbstractC13042fc3.h(abstractC6302Na0U0, "transform(...)");
        imageViewCrossFade.o(bArrA0, (C20107rU5) abstractC6302Na0U0);
        return c24143y7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean wa() {
        Fragment fragmentU5 = U5();
        MW6 mw6 = fragmentU5 instanceof MW6 ? (MW6) fragmentU5 : null;
        if (mw6 != null) {
            return mw6.getBaleResumed();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 xa(C24936zS6 c24936zS6) {
        AbstractC13042fc3.i(c24936zS6, "this$0");
        FragmentActivity fragmentActivityQ7 = c24936zS6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void E0(int i) {
        DS6 ds6;
        Fragment fragmentU5 = U5();
        C22042ua0 c22042ua0 = fragmentU5 instanceof C22042ua0 ? (C22042ua0) fragmentU5 : null;
        if (c22042ua0 != null && !c22042ua0.getBaleResumed()) {
            com.google.android.exoplayer2.E0 e0 = this.l1;
            if (e0 != null) {
                e0.h();
                return;
            }
            return;
        }
        if (i == 3) {
            com.google.android.exoplayer2.E0 e02 = this.l1;
            if (e02 != null && e02.b0() != 0 && B6()) {
                DS6 ds62 = this.h1;
                if (ds62 != null) {
                    ds62.l1();
                    return;
                }
                return;
            }
            DS6 ds63 = this.h1;
            if (ds63 != null) {
                ds63.M4(this.p1);
            }
            C24143y7 c24143y7 = this.k1;
            if (c24143y7 != null) {
                c24143y7.d.bringToFront();
                c24143y7.d.setVisibility(0);
                c24143y7.c.setVisibility(8);
                c24143y7.b.setBackground(new ColorDrawable(AbstractC4043Dl1.c(S7(), TA5.black)));
            }
        } else if (i != 4 && (ds6 = this.h1) != null) {
            ds6.v4();
        }
        super.E0(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        ka();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        this.k1 = C24143y7.c(LayoutInflater.from(G5()), viewGroup, false);
        pa();
        oa();
        if (this.n1) {
            na().k6(this.m1);
            ga();
        }
        C24143y7 c24143y7 = this.k1;
        if (c24143y7 != null) {
            return c24143y7.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        com.google.android.exoplayer2.E0 e0 = this.l1;
        if (e0 != null) {
            e0.stop();
            e0.release();
        }
        this.l1 = null;
        this.h1 = null;
        super.R6();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        na().d6();
    }

    @Override // androidx.fragment.app.Fragment
    public void U6() {
        com.google.android.exoplayer2.E0 e0 = this.l1;
        if (e0 != null) {
            e0.h();
            e0.x(0L);
        }
        ia();
        super.U6();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        com.google.android.exoplayer2.E0 e0 = this.l1;
        if (e0 != null) {
            e0.h();
        }
        com.google.android.exoplayer2.E0 e02 = this.l1;
        if (e02 != null) {
            e02.o(this);
        }
        super.c7();
    }

    public final void ga() {
        QQ6 qq6 = this.m1;
        if (qq6 != null) {
            ia();
            this.r1 = qq6.u() == YK6.c ? ta(qq6) : ha(qq6);
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        com.google.android.exoplayer2.E0 e0;
        super.h7();
        if (na().Q3()) {
            na().Q5(false);
            return;
        }
        if (this.n1) {
            this.n1 = false;
            return;
        }
        na().k6(this.m1);
        if (!((Boolean) na().N4().getValue()).booleanValue() && (e0 = this.l1) != null) {
            e0.q();
        }
        ga();
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        na().Y4();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        C24143y7 c24143y7;
        ImageViewCrossFade imageViewCrossFade;
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        if (this.o1 || (c24143y7 = this.k1) == null || (imageViewCrossFade = c24143y7.c) == null) {
            return;
        }
        imageViewCrossFade.postDelayed(new Runnable() { // from class: ir.nasim.wS6
            @Override // java.lang.Runnable
            public final void run() {
                C24936zS6.qa(this.a);
            }
        }, 1L);
    }

    public final C6918Pn5.a ma() {
        C6918Pn5.a aVar = this.i1;
        if (aVar != null) {
            return aVar;
        }
        AbstractC13042fc3.y("prepareVideoPlayerUseCaseFactory");
        return null;
    }
}
