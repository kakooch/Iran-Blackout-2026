package ir.nasim;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C16361l85;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC7331Rg3;
import ir.nasim.RY1;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.l85, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16361l85 extends RecyclerView.C {
    private final C14577i85 u;
    private final UA2 v;
    private InterfaceC7331Rg3 w;
    private InterfaceC13730gj3 x;
    private final InterfaceC20315ro1 y;
    public static final a z = new a(null);
    public static final int A = 8;

    /* renamed from: ir.nasim.l85$a */
    public static final class a {
        private a() {
        }

        public final C16361l85 a(ViewGroup viewGroup, UA2 ua2) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(ua2, "onItemClickListener");
            C14577i85 c14577i85C = C14577i85.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c14577i85C, "inflate(...)");
            c14577i85C.f.setTypeface(C6011Lu2.k());
            return new C16361l85(c14577i85C, ua2, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.l85$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ RY1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ry1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16361l85.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C16361l85 c16361l85 = C16361l85.this;
                String descriptor = ((RY1.a) this.d).a().getDescriptor();
                this.b = 1;
                if (c16361l85.Q0(descriptor, this) == objE) {
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

    /* renamed from: ir.nasim.l85$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 d;
        final /* synthetic */ C16361l85 e;
        final /* synthetic */ Bitmap f;

        /* renamed from: ir.nasim.l85$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC20315ro1 d;
            final /* synthetic */ C16361l85 e;
            final /* synthetic */ Bitmap f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC20315ro1 interfaceC20315ro1, C16361l85 c16361l85, Bitmap bitmap, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC20315ro1;
                this.e = c16361l85;
                this.f = bitmap;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(C16361l85 c16361l85) {
                c16361l85.u.c.setVisibility(8);
                c16361l85.u.d.setVisibility(0);
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    RY1 ry1 = (RY1) this.c;
                    if (!AbstractC20906so1.g(this.d) || this.e.x == null) {
                        return C19938rB7.a;
                    }
                    if (ry1 instanceof RY1.a) {
                        C16361l85 c16361l85 = this.e;
                        String descriptor = ((RY1.a) ry1).a().getDescriptor();
                        this.b = 1;
                        if (c16361l85.Q0(descriptor, this) == objE) {
                            return objE;
                        }
                    } else if (!(ry1 instanceof RY1.b) && (ry1 instanceof RY1.c)) {
                        Bitmap bitmap = this.f;
                        if (bitmap != null) {
                            C16361l85 c16361l852 = this.e;
                            c16361l852.u.c.setVisibility(0);
                            c16361l852.u.d.setVisibility(8);
                            c16361l852.u.c.setImageBitmap(bitmap);
                        } else {
                            final C16361l85 c16361l853 = this.e;
                            new SA2() { // from class: ir.nasim.m85
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C16361l85.c.a.y(c16361l853);
                                }
                            };
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(RY1 ry1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ry1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC10258bL6 interfaceC10258bL6, C16361l85 c16361l85, Bitmap bitmap, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10258bL6;
            this.e = c16361l85;
            this.f = bitmap;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, this.f, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC10258bL6 interfaceC10258bL6 = this.d;
                a aVar = new a(interfaceC20315ro1, this.e, this.f, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.l85$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C16361l85.this.Q0(null, this);
        }
    }

    /* renamed from: ir.nasim.l85$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ PB2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(PB2 pb2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = pb2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return this.c.get();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ C16361l85(C14577i85 c14577i85, UA2 ua2, ED1 ed1) {
        this(c14577i85, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C16361l85 c16361l85, View view) {
        AbstractC13042fc3.i(c16361l85, "this$0");
        InterfaceC7331Rg3 interfaceC7331Rg3 = c16361l85.w;
        if (interfaceC7331Rg3 != null) {
            c16361l85.v.invoke(interfaceC7331Rg3);
        }
    }

    private final void M0(InterfaceC10258bL6 interfaceC10258bL6, Bitmap bitmap) {
        RY1 ry1 = (RY1) interfaceC10258bL6.getValue();
        if (ry1 instanceof RY1.a) {
            AbstractC10533bm0.d(this.y, null, null, new b(ry1, null), 3, null);
            return;
        }
        if (bitmap != null) {
            this.u.c.setImageBitmap(bitmap);
            this.u.c.setVisibility(0);
            this.u.d.setVisibility(8);
        }
        if (bitmap == null) {
            this.u.c.setVisibility(8);
            this.u.d.setVisibility(0);
        }
        this.x = AbstractC10533bm0.d(this.y, null, null, new c(interfaceC10258bL6, this, bitmap, null), 3, null);
    }

    private final void N0(InterfaceC7331Rg3.a aVar) {
        this.u.g.setVisibility(8);
        M0(aVar.b(), aVar.c());
    }

    private final void O0(InterfaceC7331Rg3.b bVar) {
        this.u.g.setVisibility(0);
        if (bVar.c() == 0) {
            this.u.f.setVisibility(8);
        } else {
            this.u.f.setVisibility(0);
            this.u.f.setText(JF5.g() ? GY6.a(C17959nq7.a.a(bVar.c())) : C17959nq7.a.a(bVar.c()));
        }
        if (bVar.b() != null) {
            M0(bVar.b(), bVar.d());
        }
        if (bVar.b() == null) {
            Bitmap bitmapD = bVar.d();
            if (bitmapD == null) {
                new SA2() { // from class: ir.nasim.j85
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C16361l85.P0(this.a);
                    }
                };
                return;
            }
            this.u.c.setImageBitmap(bitmapD);
            this.u.c.setVisibility(0);
            this.u.d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P0(C16361l85 c16361l85) {
        AbstractC13042fc3.i(c16361l85, "this$0");
        c16361l85.u.c.setVisibility(8);
        c16361l85.u.d.setVisibility(0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Q0(java.lang.String r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof ir.nasim.C16361l85.d
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.l85$d r0 = (ir.nasim.C16361l85.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.l85$d r0 = new ir.nasim.l85$d
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r12 = r0.b
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            java.lang.Object r0 = r0.a
            ir.nasim.l85 r0 = (ir.nasim.C16361l85) r0
            ir.nasim.AbstractC10685c16.b(r13)
            goto L89
        L31:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L39:
            ir.nasim.AbstractC10685c16.b(r13)
            ir.nasim.i85 r13 = r11.u
            androidx.constraintlayout.widget.ConstraintLayout r13 = r13.getRoot()
            android.content.Context r13 = r13.getContext()
            com.bumptech.glide.h r13 = com.bumptech.glide.b.t(r13)
            com.bumptech.glide.g r13 = r13.d()
            com.bumptech.glide.g r12 = r13.Z0(r12)
            ir.nasim.PB2 r12 = r12.f1()
            java.lang.String r13 = "submit(...)"
            ir.nasim.AbstractC13042fc3.h(r12, r13)
            ir.nasim.i85 r13 = r11.u
            android.widget.ImageView r13 = r13.c
            ir.nasim.do1 r2 = r0.getContext()
            ir.nasim.ro1 r4 = ir.nasim.AbstractC20906so1.a(r2)
            ir.nasim.go1 r5 = ir.nasim.C12366eV1.b()
            ir.nasim.l85$e r7 = new ir.nasim.l85$e
            r2 = 0
            r7.<init>(r12, r2)
            r8 = 2
            r9 = 0
            r6 = 0
            ir.nasim.zG1 r12 = ir.nasim.AbstractC9323Zl0.b(r4, r5, r6, r7, r8, r9)
            r0.a = r11
            r0.b = r13
            r0.e = r3
            java.lang.Object r12 = r12.y(r0)
            if (r12 != r1) goto L85
            return r1
        L85:
            r0 = r11
            r10 = r13
            r13 = r12
            r12 = r10
        L89:
            android.graphics.Bitmap r13 = (android.graphics.Bitmap) r13
            r12.setImageBitmap(r13)
            ir.nasim.i85 r12 = r0.u
            android.widget.ImageView r12 = r12.c
            r13 = 0
            r12.setVisibility(r13)
            ir.nasim.i85 r12 = r0.u
            com.facebook.shimmer.ShimmerFrameLayout r12 = r12.d
            r13 = 8
            r12.setVisibility(r13)
            ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16361l85.Q0(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public final void L0(InterfaceC7331Rg3 interfaceC7331Rg3) {
        this.w = interfaceC7331Rg3;
        if (interfaceC7331Rg3 == null) {
            this.u.c.setVisibility(8);
            this.u.g.setVisibility(8);
            this.u.d.setVisibility(0);
        } else if (interfaceC7331Rg3 instanceof InterfaceC7331Rg3.a) {
            N0((InterfaceC7331Rg3.a) interfaceC7331Rg3);
        } else {
            if (!(interfaceC7331Rg3 instanceof InterfaceC7331Rg3.b)) {
                throw new NoWhenBranchMatchedException();
            }
            O0((InterfaceC7331Rg3.b) interfaceC7331Rg3);
        }
    }

    public final void S0() {
        AbstractC20267rj3.j(this.y.getCoroutineContext(), null, 1, null);
        InterfaceC13730gj3 interfaceC13730gj3 = this.x;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.x = null;
    }

    private C16361l85(C14577i85 c14577i85, UA2 ua2) {
        super(c14577i85.getRoot());
        this.u = c14577i85;
        this.v = ua2;
        this.y = AbstractC20906so1.a(C12366eV1.c());
        c14577i85.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.k85
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16361l85.E0(this.a, view);
            }
        });
    }
}
