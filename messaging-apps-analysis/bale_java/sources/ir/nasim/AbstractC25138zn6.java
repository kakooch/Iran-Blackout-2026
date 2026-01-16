package ir.nasim;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.zn6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC25138zn6 {

    /* renamed from: ir.nasim.zn6$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC25138zn6.e(null, this);
        }
    }

    /* renamed from: ir.nasim.zn6$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC25138zn6.h(null, null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.zn6$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC17305mk4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC17305mk4 interfaceC17305mk4) {
            super(1);
            this.e = interfaceC17305mk4;
        }

        public final void a(C6616Og5 c6616Og5) {
            if (this.e.d(c6616Og5.h())) {
                c6616Og5.a();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C6616Og5) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zn6$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC17305mk4 e;
        final /* synthetic */ InterfaceC23364wn6 f;
        final /* synthetic */ C9663aL5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC17305mk4 interfaceC17305mk4, InterfaceC23364wn6 interfaceC23364wn6, C9663aL5 c9663aL5) {
            super(1);
            this.e = interfaceC17305mk4;
            this.f = interfaceC23364wn6;
            this.g = c9663aL5;
        }

        public final void a(C6616Og5 c6616Og5) {
            if (this.e.b(c6616Og5.h(), this.f)) {
                c6616Og5.a();
                this.g.a = true;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C6616Og5) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zn6$e */
    static final class e implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC17305mk4 a;
        final /* synthetic */ InterfaceC4766Gl7 b;

        /* renamed from: ir.nasim.zn6$e$a */
        static final class a extends V06 implements InterfaceC14603iB2 {
            int a;
            private /* synthetic */ Object b;
            final /* synthetic */ InterfaceC17305mk4 c;
            final /* synthetic */ C20720sV0 d;
            final /* synthetic */ InterfaceC4766Gl7 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC17305mk4 interfaceC17305mk4, C20720sV0 c20720sV0, InterfaceC4766Gl7 interfaceC4766Gl7, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC17305mk4;
                this.d = c20720sV0;
                this.e = interfaceC4766Gl7;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.c, this.d, this.e, interfaceC20295rm1);
                aVar.b = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    r10 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r10.a
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L27
                    if (r1 == r4) goto L1f
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    goto L1a
                L12:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r0)
                    throw r11
                L1a:
                    ir.nasim.AbstractC10685c16.b(r11)
                    goto L8e
                L1f:
                    java.lang.Object r1 = r10.b
                    ir.nasim.EV r1 = (ir.nasim.EV) r1
                    ir.nasim.AbstractC10685c16.b(r11)
                    goto L3a
                L27:
                    ir.nasim.AbstractC10685c16.b(r11)
                    java.lang.Object r11 = r10.b
                    r1 = r11
                    ir.nasim.EV r1 = (ir.nasim.EV) r1
                    r10.b = r1
                    r10.a = r4
                    java.lang.Object r11 = ir.nasim.AbstractC25138zn6.a(r1, r10)
                    if (r11 != r0) goto L3a
                    return r0
                L3a:
                    ir.nasim.Bg5 r11 = (ir.nasim.C3534Bg5) r11
                    boolean r5 = ir.nasim.AbstractC25138zn6.g(r11)
                    r6 = 0
                    if (r5 == 0) goto L7b
                    int r5 = r11.b()
                    boolean r5 = ir.nasim.AbstractC4470Fg5.b(r5)
                    if (r5 == 0) goto L7b
                    java.util.List r5 = r11.c()
                    r7 = r5
                    java.util.Collection r7 = (java.util.Collection) r7
                    int r7 = r7.size()
                    r8 = 0
                L59:
                    if (r8 >= r7) goto L6c
                    java.lang.Object r9 = r5.get(r8)
                    ir.nasim.Og5 r9 = (ir.nasim.C6616Og5) r9
                    boolean r9 = r9.p()
                    r9 = r9 ^ r4
                    if (r9 != 0) goto L69
                    goto L7b
                L69:
                    int r8 = r8 + 1
                    goto L59
                L6c:
                    ir.nasim.mk4 r2 = r10.c
                    ir.nasim.sV0 r4 = r10.d
                    r10.b = r6
                    r10.a = r3
                    java.lang.Object r11 = ir.nasim.AbstractC25138zn6.c(r1, r2, r4, r11, r10)
                    if (r11 != r0) goto L8e
                    return r0
                L7b:
                    boolean r3 = ir.nasim.AbstractC25138zn6.g(r11)
                    if (r3 != 0) goto L8e
                    ir.nasim.Gl7 r3 = r10.e
                    r10.b = r6
                    r10.a = r2
                    java.lang.Object r11 = ir.nasim.AbstractC25138zn6.d(r1, r3, r11, r10)
                    if (r11 != r0) goto L8e
                    return r0
                L8e:
                    ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25138zn6.e.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC17305mk4 interfaceC17305mk4, InterfaceC4766Gl7 interfaceC4766Gl7) {
            this.a = interfaceC17305mk4;
            this.b = interfaceC4766Gl7;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objD = AbstractC8163Uu2.d(interfaceC9049Yg5, new a(this.a, new C20720sV0(interfaceC9049Yg5.getViewConfiguration()), this.b, null), interfaceC20295rm1);
            return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zn6$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int e;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC25138zn6.j(null, null, null, this);
        }
    }

    /* renamed from: ir.nasim.zn6$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC4766Gl7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC4766Gl7 interfaceC4766Gl7) {
            super(1);
            this.e = interfaceC4766Gl7;
        }

        public final void a(C6616Og5 c6616Og5) {
            this.e.d(AbstractC3768Cg5.g(c6616Og5));
            c6616Og5.a();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C6616Og5) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zn6$h */
    static final class h implements PointerInputEventHandler {
        final /* synthetic */ UA2 a;

        /* renamed from: ir.nasim.zn6$h$a */
        static final class a extends V06 implements InterfaceC14603iB2 {
            int a;
            private /* synthetic */ Object b;
            final /* synthetic */ UA2 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = ua2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.c, interfaceC20295rm1);
                aVar.b = obj;
                return aVar;
            }

            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:12:0x0030). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r4.a
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r1 = r4.b
                    ir.nasim.EV r1 = (ir.nasim.EV) r1
                    ir.nasim.AbstractC10685c16.b(r5)
                    goto L30
                L13:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L1b:
                    ir.nasim.AbstractC10685c16.b(r5)
                    java.lang.Object r5 = r4.b
                    ir.nasim.EV r5 = (ir.nasim.EV) r5
                    r1 = r5
                L23:
                    ir.nasim.Dg5 r5 = ir.nasim.EnumC4002Dg5.a
                    r4.b = r1
                    r4.a = r2
                    java.lang.Object r5 = r1.f0(r5, r4)
                    if (r5 != r0) goto L30
                    return r0
                L30:
                    ir.nasim.Bg5 r5 = (ir.nasim.C3534Bg5) r5
                    ir.nasim.UA2 r3 = r4.c
                    boolean r5 = ir.nasim.AbstractC25138zn6.g(r5)
                    r5 = r5 ^ r2
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r3.invoke(r5)
                    goto L23
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25138zn6.h.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(UA2 ua2) {
            this.a = ua2;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB1 = interfaceC9049Yg5.B1(new a(this.a, null), interfaceC20295rm1);
            return objB1 == AbstractC14862ic3.e() ? objB1 : C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(ir.nasim.EV r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            boolean r0 = r8 instanceof ir.nasim.AbstractC25138zn6.a
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.zn6$a r0 = (ir.nasim.AbstractC25138zn6.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.zn6$a r0 = new ir.nasim.zn6$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.a
            ir.nasim.EV r7 = (ir.nasim.EV) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            ir.nasim.AbstractC10685c16.b(r8)
        L38:
            ir.nasim.Dg5 r8 = ir.nasim.EnumC4002Dg5.b
            r0.a = r7
            r0.c = r3
            java.lang.Object r8 = r7.f0(r8, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.Bg5 r8 = (ir.nasim.C3534Bg5) r8
            java.util.List r2 = r8.c()
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
        L53:
            if (r5 >= r4) goto L65
            java.lang.Object r6 = r2.get(r5)
            ir.nasim.Og5 r6 = (ir.nasim.C6616Og5) r6
            boolean r6 = ir.nasim.AbstractC3768Cg5.b(r6)
            if (r6 != 0) goto L62
            goto L38
        L62:
            int r5 = r5 + 1
            goto L53
        L65:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25138zn6.e(ir.nasim.EV, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(InterfaceC18354oW7 interfaceC18354oW7, C6616Og5 c6616Og5, C6616Og5 c6616Og52) {
        return ZG4.k(ZG4.p(c6616Og5.h(), c6616Og52.h())) < EZ1.j(interfaceC18354oW7, c6616Og5.n());
    }

    public static final boolean g(C3534Bg5 c3534Bg5) {
        List listC = c3534Bg5.c();
        int size = listC.size();
        for (int i = 0; i < size; i++) {
            if (!AbstractC11873dh5.g(((C6616Og5) listC.get(i)).n(), AbstractC11873dh5.a.b())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(ir.nasim.EV r8, ir.nasim.InterfaceC17305mk4 r9, ir.nasim.C20720sV0 r10, ir.nasim.C3534Bg5 r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25138zn6.h(ir.nasim.EV, ir.nasim.mk4, ir.nasim.sV0, ir.nasim.Bg5, ir.nasim.rm1):java.lang.Object");
    }

    public static final androidx.compose.ui.e i(androidx.compose.ui.e eVar, InterfaceC17305mk4 interfaceC17305mk4, InterfaceC4766Gl7 interfaceC4766Gl7) {
        return AbstractC21071t37.e(eVar, interfaceC17305mk4, interfaceC4766Gl7, new e(interfaceC17305mk4, interfaceC4766Gl7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9 A[Catch: CancellationException -> 0x0035, TryCatch #0 {CancellationException -> 0x0035, blocks: (B:13:0x0031, B:33:0x00a1, B:35:0x00a9, B:37:0x00bb, B:39:0x00c7, B:40:0x00ca, B:41:0x00cd, B:42:0x00d1, B:20:0x004c, B:26:0x0073, B:28:0x0077, B:30:0x0081, B:23:0x0056), top: B:47:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1 A[Catch: CancellationException -> 0x0035, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0035, blocks: (B:13:0x0031, B:33:0x00a1, B:35:0x00a9, B:37:0x00bb, B:39:0x00c7, B:40:0x00ca, B:41:0x00cd, B:42:0x00d1, B:20:0x004c, B:26:0x0073, B:28:0x0077, B:30:0x0081, B:23:0x0056), top: B:47:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(ir.nasim.EV r8, ir.nasim.InterfaceC4766Gl7 r9, ir.nasim.C3534Bg5 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            boolean r0 = r11 instanceof ir.nasim.AbstractC25138zn6.f
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.zn6$f r0 = (ir.nasim.AbstractC25138zn6.f) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.zn6$f r0 = new ir.nasim.zn6$f
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L53
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r8 = r0.b
            r9 = r8
            ir.nasim.Gl7 r9 = (ir.nasim.InterfaceC4766Gl7) r9
            java.lang.Object r8 = r0.a
            ir.nasim.EV r8 = (ir.nasim.EV) r8
            ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.util.concurrent.CancellationException -> L35
            goto La1
        L35:
            r8 = move-exception
            goto Ld7
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            java.lang.Object r8 = r0.c
            ir.nasim.Og5 r8 = (ir.nasim.C6616Og5) r8
            java.lang.Object r9 = r0.b
            ir.nasim.Gl7 r9 = (ir.nasim.InterfaceC4766Gl7) r9
            java.lang.Object r10 = r0.a
            ir.nasim.EV r10 = (ir.nasim.EV) r10
            ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.util.concurrent.CancellationException -> L35
            r7 = r10
            r10 = r8
            r8 = r7
            goto L73
        L53:
            ir.nasim.AbstractC10685c16.b(r11)
            java.util.List r10 = r10.c()     // Catch: java.util.concurrent.CancellationException -> L35
            java.lang.Object r10 = ir.nasim.ZW0.q0(r10)     // Catch: java.util.concurrent.CancellationException -> L35
            ir.nasim.Og5 r10 = (ir.nasim.C6616Og5) r10     // Catch: java.util.concurrent.CancellationException -> L35
            long r5 = r10.f()     // Catch: java.util.concurrent.CancellationException -> L35
            r0.a = r8     // Catch: java.util.concurrent.CancellationException -> L35
            r0.b = r9     // Catch: java.util.concurrent.CancellationException -> L35
            r0.c = r10     // Catch: java.util.concurrent.CancellationException -> L35
            r0.e = r4     // Catch: java.util.concurrent.CancellationException -> L35
            java.lang.Object r11 = ir.nasim.EZ1.c(r8, r5, r0)     // Catch: java.util.concurrent.CancellationException -> L35
            if (r11 != r1) goto L73
            return r1
        L73:
            ir.nasim.Og5 r11 = (ir.nasim.C6616Og5) r11     // Catch: java.util.concurrent.CancellationException -> L35
            if (r11 == 0) goto Ld4
            ir.nasim.oW7 r2 = r8.getViewConfiguration()     // Catch: java.util.concurrent.CancellationException -> L35
            boolean r10 = f(r2, r10, r11)     // Catch: java.util.concurrent.CancellationException -> L35
            if (r10 == 0) goto Ld4
            long r4 = r11.h()     // Catch: java.util.concurrent.CancellationException -> L35
            r9.b(r4)     // Catch: java.util.concurrent.CancellationException -> L35
            long r10 = r11.f()     // Catch: java.util.concurrent.CancellationException -> L35
            ir.nasim.zn6$g r2 = new ir.nasim.zn6$g     // Catch: java.util.concurrent.CancellationException -> L35
            r2.<init>(r9)     // Catch: java.util.concurrent.CancellationException -> L35
            r0.a = r8     // Catch: java.util.concurrent.CancellationException -> L35
            r0.b = r9     // Catch: java.util.concurrent.CancellationException -> L35
            r4 = 0
            r0.c = r4     // Catch: java.util.concurrent.CancellationException -> L35
            r0.e = r3     // Catch: java.util.concurrent.CancellationException -> L35
            java.lang.Object r11 = ir.nasim.EZ1.h(r8, r10, r2, r0)     // Catch: java.util.concurrent.CancellationException -> L35
            if (r11 != r1) goto La1
            return r1
        La1:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.util.concurrent.CancellationException -> L35
            boolean r10 = r11.booleanValue()     // Catch: java.util.concurrent.CancellationException -> L35
            if (r10 == 0) goto Ld1
            ir.nasim.Bg5 r8 = r8.S0()     // Catch: java.util.concurrent.CancellationException -> L35
            java.util.List r8 = r8.c()     // Catch: java.util.concurrent.CancellationException -> L35
            r10 = r8
            java.util.Collection r10 = (java.util.Collection) r10     // Catch: java.util.concurrent.CancellationException -> L35
            int r10 = r10.size()     // Catch: java.util.concurrent.CancellationException -> L35
            r11 = 0
        Lb9:
            if (r11 >= r10) goto Lcd
            java.lang.Object r0 = r8.get(r11)     // Catch: java.util.concurrent.CancellationException -> L35
            ir.nasim.Og5 r0 = (ir.nasim.C6616Og5) r0     // Catch: java.util.concurrent.CancellationException -> L35
            boolean r1 = ir.nasim.AbstractC3768Cg5.c(r0)     // Catch: java.util.concurrent.CancellationException -> L35
            if (r1 == 0) goto Lca
            r0.a()     // Catch: java.util.concurrent.CancellationException -> L35
        Lca:
            int r11 = r11 + 1
            goto Lb9
        Lcd:
            r9.i()     // Catch: java.util.concurrent.CancellationException -> L35
            goto Ld4
        Ld1:
            r9.onCancel()     // Catch: java.util.concurrent.CancellationException -> L35
        Ld4:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        Ld7:
            r9.onCancel()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25138zn6.j(ir.nasim.EV, ir.nasim.Gl7, ir.nasim.Bg5, ir.nasim.rm1):java.lang.Object");
    }

    public static final androidx.compose.ui.e k(androidx.compose.ui.e eVar, UA2 ua2) {
        return AbstractC21071t37.c(eVar, 8675309, new h(ua2));
    }
}
