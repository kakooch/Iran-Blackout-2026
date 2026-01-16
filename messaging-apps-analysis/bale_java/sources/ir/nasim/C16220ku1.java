package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.upstream.cache.a;
import ir.nasim.C16220ku1;
import ir.nasim.Q12;
import ir.nasim.RY1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.NavigableSet;
import kotlinx.coroutines.TimeoutCancellationException;

/* renamed from: ir.nasim.ku1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16220ku1 {
    private static final a g = new a(null);
    private final Context a;
    private final AbstractC13778go1 b;
    private final IT7 c;
    private final InterfaceC12532em2 d;
    private final a.c e;
    private final HashMap f;

    /* renamed from: ir.nasim.ku1$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ku1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ long d;
        final /* synthetic */ C16220ku1 e;

        /* renamed from: ir.nasim.ku1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C2018a0 d;
            final /* synthetic */ C16220ku1 e;

            /* renamed from: ir.nasim.ku1$b$a$a, reason: collision with other inner class name */
            static final class C1362a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C17416mv5 c;
                final /* synthetic */ InterfaceC16204ks5 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1362a(C17416mv5 c17416mv5, InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c17416mv5;
                    this.d = interfaceC16204ks5;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void y(InterfaceC16204ks5 interfaceC16204ks5, long j, long j2, float f) {
                    if (j == j2) {
                        interfaceC16204ks5.h(new RY1.a(new C9115Yo("")));
                    } else {
                        interfaceC16204ks5.h(new RY1.b(f / 100.0f));
                    }
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1362a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    C17416mv5 c17416mv5 = this.c;
                    final InterfaceC16204ks5 interfaceC16204ks5 = this.d;
                    c17416mv5.d(new InterfaceC10995cZ1() { // from class: ir.nasim.nu1
                        @Override // ir.nasim.InterfaceC10995cZ1
                        public final void a(long j, long j2, float f) {
                            C16220ku1.b.a.C1362a.y(interfaceC16204ks5, j, j2, f);
                        }
                    });
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1362a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C2018a0 c2018a0, C16220ku1 c16220ku1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c2018a0;
                this.e = c16220ku1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 D(C17416mv5 c17416mv5) {
                c17416mv5.c();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 z(InterfaceC16204ks5 interfaceC16204ks5, Throwable th) {
                C19406qI3.a("GeVideoFromExoCacheUseCase", "Download completed with cause(" + th + Separators.RPAREN, new Object[0]);
                if (th == null) {
                    interfaceC16204ks5.h(new RY1.a(new C9115Yo("")));
                } else {
                    interfaceC16204ks5.h(new RY1.c(null, 1, null));
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                    final C17416mv5 c17416mv5 = new C17416mv5(this.d, this.e.e);
                    AbstractC10533bm0.d(interfaceC16204ks5, null, null, new C1362a(c17416mv5, interfaceC16204ks5, null), 3, null).s(new UA2() { // from class: ir.nasim.lu1
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return C16220ku1.b.a.z(interfaceC16204ks5, (Throwable) obj2);
                        }
                    });
                    SA2 sa2 = new SA2() { // from class: ir.nasim.mu1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C16220ku1.b.a.D(c17416mv5);
                        }
                    };
                    this.b = 1;
                    if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.ku1$b$b, reason: collision with other inner class name */
        static final class C1363b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ Exception d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1363b(Exception exc, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = exc;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1363b c1363b = new C1363b(this.d, interfaceC20295rm1);
                c1363b.c = obj;
                return c1363b;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) throws Exception {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((RY1) this.c) instanceof RY1.c) {
                    throw this.d;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1363b) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.ku1$b$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;

            c(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.b = 1;
                    if (HG1.b(200L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return AbstractC6392Nk0.a(true);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(th, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.ku1$b$d */
        static final class d extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ Exception e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(Exception exc, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.e = exc;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    Throwable th = (Throwable) this.d;
                    if (!(th instanceof TimeoutCancellationException) && th != this.e) {
                        C19406qI3.d("GeVideoFromExoCacheUseCase", th);
                    }
                    RY1.c cVar = new RY1.c(null, 1, null);
                    this.c = null;
                    this.b = 1;
                    if (interfaceC4806Gq2.a(cVar, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
                d dVar = new d(this.e, interfaceC20295rm1);
                dVar.c = interfaceC4806Gq2;
                dVar.d = th;
                return dVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.ku1$b$e */
        public static final class e implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.ku1$b$e$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.ku1$b$e$a$a, reason: collision with other inner class name */
                public static final class C1364a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1364a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r7 instanceof ir.nasim.C16220ku1.b.e.a.C1364a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.ku1$b$e$a$a r0 = (ir.nasim.C16220ku1.b.e.a.C1364a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.ku1$b$e$a$a r0 = new ir.nasim.ku1$b$e$a$a
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
                        ir.nasim.RY1 r2 = (ir.nasim.RY1) r2
                        boolean r4 = r2 instanceof ir.nasim.RY1.a
                        if (r4 != 0) goto L41
                        boolean r2 = r2 instanceof ir.nasim.RY1.c
                        if (r2 == 0) goto L4a
                    L41:
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L4a
                        return r1
                    L4a:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16220ku1.b.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public e(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, long j, C16220ku1 c16220ku1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = j;
            this.e = c16220ku1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C2018a0 c2018a0A = new C2018a0.c().k("").b(this.c).a();
                AbstractC13042fc3.h(c2018a0A, "build(...)");
                Exception exc = new Exception("Failed to download the video.");
                InterfaceC4557Fq2 interfaceC4557Fq2G0 = AbstractC6459Nq2.g0(AbstractC6459Nq2.b0(new e(AbstractC6459Nq2.f(new a(c2018a0A, this.e, null))), new C1363b(exc, null)), this.d, new c(null));
                Q12.a aVar = Q12.b;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.h(AbstractC6459Nq2.r0(interfaceC4557Fq2G0, T12.s(2, W12.e)), new d(exc, null)), this.e.b);
                this.b = 1;
                if (AbstractC6459Nq2.G(interfaceC4557Fq2V, this) == objE) {
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

    /* renamed from: ir.nasim.ku1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ String g;
        final /* synthetic */ long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, long j2, String str, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = j;
            this.f = j2;
            this.g = str;
            this.h = j3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16220ku1.this.new c(this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            if (r0 == null) goto L19;
         */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r10 = ir.nasim.AbstractC13660gc3.e()
                int r0 = r13.c
                r11 = 0
                r1 = 1
                if (r0 == 0) goto L1e
                if (r0 != r1) goto L16
                java.lang.Object r0 = r13.b
                java.lang.String r0 = (java.lang.String) r0
                ir.nasim.AbstractC10685c16.b(r14)
                r12 = r0
                r0 = r14
                goto L6e
            L16:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1e:
                ir.nasim.AbstractC10685c16.b(r14)
                ir.nasim.ku1 r0 = ir.nasim.C16220ku1.this
                ir.nasim.IT7 r0 = ir.nasim.C16220ku1.c(r0)
                long r2 = r13.e
                long r4 = r13.f
                java.lang.String r12 = r0.a(r2, r4)
                ir.nasim.ku1 r0 = ir.nasim.C16220ku1.this
                java.util.HashMap r0 = ir.nasim.C16220ku1.d(r0)
                java.lang.Object r0 = r0.get(r12)
                java.io.File r0 = (java.io.File) r0
                if (r0 == 0) goto L54
                long r2 = r13.h
                boolean r4 = r0.exists()
                if (r4 == 0) goto L4e
                long r4 = r0.length()
                int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r2 != 0) goto L4e
                goto L4f
            L4e:
                r0 = r11
            L4f:
                if (r0 != 0) goto L52
                goto L54
            L52:
                r11 = r0
                goto L7c
            L54:
                ir.nasim.ku1 r0 = ir.nasim.C16220ku1.this
                long r2 = r13.e
                long r4 = r13.f
                java.lang.String r6 = r13.g
                long r7 = r13.h
                r13.b = r12
                r13.c = r1
                r1 = r2
                r3 = r4
                r5 = r6
                r6 = r12
                r9 = r13
                java.lang.Object r0 = ir.nasim.C16220ku1.h(r0, r1, r3, r5, r6, r7, r9)
                if (r0 != r10) goto L6e
                return r10
            L6e:
                java.io.File r0 = (java.io.File) r0
                if (r0 == 0) goto L7c
                ir.nasim.ku1 r1 = ir.nasim.C16220ku1.this
                java.util.HashMap r1 = ir.nasim.C16220ku1.d(r1)
                r1.put(r12, r0)
                goto L52
            L7c:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16220ku1.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ku1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ long h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, long j2, String str, String str2, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = str;
            this.g = str2;
            this.h = j3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16220ku1.this.new d(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0092 A[Catch: IOException -> 0x0096, TryCatch #1 {IOException -> 0x0096, blocks: (B:25:0x0071, B:27:0x0092, B:30:0x0098, B:33:0x00ae, B:43:0x00bf, B:44:0x00c2, B:39:0x00b9, B:31:0x00a6, B:32:0x00ac, B:38:0x00b6, B:41:0x00bd), top: B:48:0x0071, inners: #0, #3 }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.io.IOException {
            /*
                r14 = this;
                java.lang.String r0 = "GeVideoFromExoCacheUseCase"
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r14.b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L20
                if (r2 == r4) goto L1c
                if (r2 != r3) goto L14
                ir.nasim.AbstractC10685c16.b(r15)
                goto L70
            L14:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L1c:
                ir.nasim.AbstractC10685c16.b(r15)
                goto L3a
            L20:
                ir.nasim.AbstractC10685c16.b(r15)
                ir.nasim.ku1 r15 = ir.nasim.C16220ku1.this
                ir.nasim.em2 r5 = ir.nasim.C16220ku1.f(r15)
                long r6 = r14.d
                long r8 = r14.e
                r14.b = r4
                r10 = 0
                r12 = 4
                r13 = 0
                r11 = r14
                java.lang.Object r15 = ir.nasim.InterfaceC12532em2.b(r5, r6, r8, r10, r11, r12, r13)
                if (r15 != r1) goto L3a
                return r1
            L3a:
                ir.nasim.RY1 r15 = (ir.nasim.RY1) r15
                boolean r2 = r15 instanceof ir.nasim.RY1.a
                if (r2 == 0) goto L61
                ir.nasim.RY1$a r15 = (ir.nasim.RY1.a) r15
                ir.nasim.Am2 r15 = r15.a()
                java.lang.String r2 = r15.getDescriptor()
                boolean r2 = ir.nasim.AbstractC14836iZ6.n0(r2)
                r2 = r2 ^ r4
                if (r2 == 0) goto L61
                boolean r2 = r15.a()
                if (r2 == 0) goto L61
                java.io.File r0 = new java.io.File
                java.lang.String r15 = r15.getDescriptor()
                r0.<init>(r15)
                return r0
            L61:
                ir.nasim.ku1 r15 = ir.nasim.C16220ku1.this
                java.lang.String r2 = r14.f
                r14.b = r3
                r3 = 3
                java.lang.Object r15 = ir.nasim.C16220ku1.a(r15, r2, r3, r14)
                if (r15 != r1) goto L70
                return r1
            L70:
                r15 = 0
                java.io.File r1 = new java.io.File     // Catch: java.io.IOException -> L96
                ir.nasim.ku1 r2 = ir.nasim.C16220ku1.this     // Catch: java.io.IOException -> L96
                android.content.Context r2 = ir.nasim.C16220ku1.e(r2)     // Catch: java.io.IOException -> L96
                java.io.File r2 = r2.getCacheDir()     // Catch: java.io.IOException -> L96
                java.lang.String r3 = "Bale Video"
                r1.<init>(r2, r3)     // Catch: java.io.IOException -> L96
                r1.mkdirs()     // Catch: java.io.IOException -> L96
                java.io.File r2 = new java.io.File     // Catch: java.io.IOException -> L96
                java.lang.String r3 = r14.g     // Catch: java.io.IOException -> L96
                r2.<init>(r1, r3)     // Catch: java.io.IOException -> L96
                boolean r1 = r2.exists()     // Catch: java.io.IOException -> L96
                if (r1 == 0) goto L98
                r2.delete()     // Catch: java.io.IOException -> L96
                goto L98
            L96:
                r1 = move-exception
                goto Lc3
            L98:
                r2.createNewFile()     // Catch: java.io.IOException -> L96
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L96
                r1.<init>(r2)     // Catch: java.io.IOException -> L96
                ir.nasim.ku1 r3 = ir.nasim.C16220ku1.this     // Catch: java.io.IOException -> L96
                java.lang.String r4 = r14.f     // Catch: java.io.IOException -> L96
                long r5 = r14.h     // Catch: java.io.IOException -> L96
                ir.nasim.C16220ku1.i(r3, r4, r1, r5)     // Catch: java.lang.Throwable -> Lb3 java.lang.Exception -> Lb5
                r1.flush()     // Catch: java.lang.Throwable -> Lb3 java.lang.Exception -> Lb5
                ir.nasim.rB7 r3 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> Lb3
                ir.nasim.YV0.a(r1, r15)     // Catch: java.io.IOException -> L96
                r15 = r2
                goto Lc6
            Lb3:
                r2 = move-exception
                goto Lbd
            Lb5:
                r2 = move-exception
                ir.nasim.C19406qI3.d(r0, r2)     // Catch: java.lang.Throwable -> Lb3
                ir.nasim.YV0.a(r1, r15)     // Catch: java.io.IOException -> L96
                return r15
            Lbd:
                throw r2     // Catch: java.lang.Throwable -> Lbe
            Lbe:
                r3 = move-exception
                ir.nasim.YV0.a(r1, r2)     // Catch: java.io.IOException -> L96
                throw r3     // Catch: java.io.IOException -> L96
            Lc3:
                ir.nasim.C19406qI3.d(r0, r1)
            Lc6:
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16220ku1.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C16220ku1(Context context, AbstractC13778go1 abstractC13778go1, IT7 it7, InterfaceC12532em2 interfaceC12532em2, a.c cVar) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(it7, "cacheIdGenerator");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(cVar, "cacheDataSourceFactory");
        this.a = context;
        this.b = abstractC13778go1;
        this.c = it7;
        this.d = interfaceC12532em2;
        this.e = cVar;
        this.f = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(String str, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new b(str, j, this, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(long j, long j2, String str, String str2, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new d(j, j2, str2, str, j3, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String str, FileOutputStream fileOutputStream, long j) throws IOException {
        NavigableSet<AbstractC18533op0> navigableSetM = DD6.c().m(str);
        AbstractC13042fc3.h(navigableSetM, "getCachedSpans(...)");
        long j2 = 0;
        for (AbstractC18533op0 abstractC18533op0 : navigableSetM) {
            long j3 = abstractC18533op0.b;
            if (j2 != j3) {
                fileOutputStream.write(new byte[(int) (j3 - j2)]);
            }
            File file = abstractC18533op0.e;
            fileOutputStream.write(file != null ? AbstractC11308cn2.f(file) : null);
            j2 = abstractC18533op0.b + abstractC18533op0.c;
        }
        if (j2 != j) {
            fileOutputStream.write(new byte[(int) (j - j2)]);
        }
    }

    public final Object k(long j, long j2, long j3, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new c(j, j2, str, j3, null), interfaceC20295rm1);
    }
}
