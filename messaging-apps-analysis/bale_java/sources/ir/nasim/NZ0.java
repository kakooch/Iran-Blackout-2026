package ir.nasim;

import ai.bale.proto.GroupsOuterClass$RequestAddDiscussionGroupAdmin;
import ai.bale.proto.GroupsOuterClass$RequestRemoveDiscussionGroup;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.OA7;
import ir.nasim.Z06;

/* loaded from: classes5.dex */
public final class NZ0 extends VW7 {
    public static final b k = new b(null);
    public static final int l = 8;
    private final C10299bQ2 b;
    private final int c;
    private final C6287Mz d;
    private final WN2 e;
    public C14733iO2 f;
    private C14733iO2 g;
    private InterfaceC9336Zm4 h;
    private InterfaceC10258bL6 i;
    private boolean j;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NZ0.this.new a(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 370
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NZ0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ NZ0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, NZ0 nz0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = nz0;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C8512Wh0 c8512Wh0N;
            Boolean bool;
            Object value2;
            C8512Wh0 c8512Wh0N2;
            Boolean bool2;
            C8512Wh0 c8512Wh0F;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestAddDiscussionGroupAdmin.newBuilder().B((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(this.c).a()).A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(this.d.Z0().r()).a()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.groups.v1.Groups/AddDiscussionGroupAdmin", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287MzU0 = this.d.U0();
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287MzU0, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                C14733iO2 c14733iO2V0 = this.d.V0();
                if (c14733iO2V0 != null && (c8512Wh0F = c14733iO2V0.F()) != null) {
                    AbstractC6392Nk0.a(c8512Wh0F.i(AbstractC6392Nk0.a(true)));
                }
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.h;
                NZ0 nz0 = this.d;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                    c8512Wh0N2 = nz0.Z0().n();
                } while (!interfaceC9336Zm4.f(value2, new OA7.b((c8512Wh0N2 == null || (bool2 = (Boolean) c8512Wh0N2.b()) == null) ? false : bool2.booleanValue(), true)));
            } else if (z06 instanceof Z06.a) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = this.d.h;
                NZ0 nz02 = this.d;
                do {
                    value = interfaceC9336Zm42.getValue();
                    c8512Wh0N = nz02.Z0().n();
                } while (!interfaceC9336Zm42.f(value, new OA7.b((c8512Wh0N == null || (bool = (Boolean) c8512Wh0N.b()) == null) ? false : bool.booleanValue(), false)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        int b;
        boolean c;
        /* synthetic */ Object d;
        int f;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return NZ0.this.d1(0, false, this);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NZ0.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            C8512Wh0 c8512Wh0N;
            Boolean bool;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = GroupsOuterClass$RequestRemoveDiscussionGroup.newBuilder().A(PeersStruct$GroupOutPeer.newBuilder().B(NZ0.this.Z0().r()).A(0L)).B(System.currentTimeMillis()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.groups.v1.Groups/RemoveDiscussionGroup", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287MzU0 = NZ0.this.U0();
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287MzU0, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            if (((Z06) obj) instanceof Z06.b) {
                C8512Wh0 c8512Wh0N2 = NZ0.this.Z0().n();
                if (c8512Wh0N2 != null) {
                    AbstractC6392Nk0.a(c8512Wh0N2.i(AbstractC6392Nk0.a(false)));
                }
                InterfaceC9336Zm4 interfaceC9336Zm4 = NZ0.this.h;
                NZ0 nz0 = NZ0.this;
                do {
                    value = interfaceC9336Zm4.getValue();
                    c8512Wh0N = nz0.Z0().n();
                } while (!interfaceC9336Zm4.f(value, new OA7.b((c8512Wh0N == null || (bool = (Boolean) c8512Wh0N.b()) == null) ? false : bool.booleanValue(), nz0.b1())));
                NZ0.this.g1(false);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NZ0.this.new f(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x019f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 481
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NZ0.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return NZ0.this.i1(null, this);
        }
    }

    public NZ0(C10299bQ2 c10299bQ2, int i, C6287Mz c6287Mz, WN2 wn2) {
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(wn2, "groupStructToApiGroupMapper");
        this.b = c10299bQ2;
        this.c = i;
        this.d = c6287Mz;
        this.e = wn2;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(OA7.d.a);
        this.h = interfaceC9336Zm4A;
        this.i = interfaceC9336Zm4A;
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d1(int r11, boolean r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NZ0.d1(int, boolean, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object e1(NZ0 nz0, int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return nz0.d1(i, z, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i1(ai.bale.proto.GroupsStruct$Group r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.NZ0.g
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.NZ0$g r0 = (ir.nasim.NZ0.g) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.NZ0$g r0 = new ir.nasim.NZ0$g
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L57
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            ir.nasim.AbstractC10685c16.b(r11)
            goto Lc5
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            java.lang.Object r10 = r0.b
            ir.nasim.NZ0 r10 = (ir.nasim.NZ0) r10
            java.lang.Object r2 = r0.a
            ir.nasim.NZ0 r2 = (ir.nasim.NZ0) r2
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11
            java.lang.Object r11 = r11.l()
            goto La5
        L4b:
            java.lang.Object r10 = r0.b
            ai.bale.proto.GroupsStruct$Group r10 = (ai.bale.proto.GroupsStruct$Group) r10
            java.lang.Object r2 = r0.a
            ir.nasim.NZ0 r2 = (ir.nasim.NZ0) r2
            ir.nasim.AbstractC10685c16.b(r11)
            goto L6e
        L57:
            ir.nasim.AbstractC10685c16.b(r11)
            if (r10 != 0) goto L71
            ir.nasim.Zm4 r11 = r9.h
            ir.nasim.OA7$a r2 = ir.nasim.OA7.a.a
            r0.a = r9
            r0.b = r10
            r0.e = r5
            java.lang.Object r11 = r11.a(r2, r0)
            if (r11 != r1) goto L6d
            return r1
        L6d:
            r2 = r9
        L6e:
            ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
            goto L72
        L71:
            r2 = r9
        L72:
            if (r10 == 0) goto Lc7
            ir.nasim.bQ2 r11 = r2.b
            ir.nasim.Vo3 r11 = r11.X1()
            ir.nasim.WN2 r7 = r2.e
            ir.nasim.iL2 r7 = r7.a(r10)
            r11.e(r7)
            ir.nasim.bQ2 r11 = r2.b
            ir.nasim.VL3 r11 = r11.Y1()
            int r10 = r10.getId()
            long r7 = (long) r10
            ir.nasim.Nv5 r10 = r11.k(r7)
            java.lang.String r11 = "get(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            r0.a = r2
            r0.b = r2
            r0.e = r4
            java.lang.Object r11 = ir.nasim.AbstractC6756Ov5.d(r10, r6, r0, r5, r6)
            if (r11 != r1) goto La4
            return r1
        La4:
            r10 = r2
        La5:
            boolean r4 = ir.nasim.C9475a16.g(r11)
            if (r4 == 0) goto Lac
            r11 = r6
        Lac:
            ir.nasim.iO2 r11 = (ir.nasim.C14733iO2) r11
            r10.g = r11
            ir.nasim.iO2 r10 = r2.g
            if (r10 != 0) goto Lc7
            ir.nasim.Zm4 r10 = r2.h
            ir.nasim.OA7$a r11 = ir.nasim.OA7.a.a
            r0.a = r6
            r0.b = r6
            r0.e = r3
            java.lang.Object r10 = r10.a(r11, r0)
            if (r10 != r1) goto Lc5
            return r1
        Lc5:
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
        Lc7:
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NZ0.i1(ai.bale.proto.GroupsStruct$Group, ir.nasim.rm1):java.lang.Object");
    }

    public final boolean T0() {
        Integer num;
        if (this.f == null || Z0().o() == null) {
            return false;
        }
        C19482qQ7 c19482qQ7O = Z0().o();
        if (((c19482qQ7O == null || (num = (Integer) c19482qQ7O.b()) == null) ? 0 : num.intValue()) == 0) {
            return false;
        }
        C8512Wh0 c8512Wh0N = Z0().n();
        return c8512Wh0N != null ? AbstractC13042fc3.d(c8512Wh0N.b(), Boolean.TRUE) : false;
    }

    public final C6287Mz U0() {
        return this.d;
    }

    public final C14733iO2 V0() {
        return this.g;
    }

    public final boolean W0() {
        return this.j;
    }

    public final C10299bQ2 X0() {
        return this.b;
    }

    public final int Y0() {
        return this.c;
    }

    public final C14733iO2 Z0() {
        C14733iO2 c14733iO2 = this.f;
        if (c14733iO2 != null) {
            return c14733iO2;
        }
        AbstractC13042fc3.y("parentVM");
        return null;
    }

    public final InterfaceC10258bL6 a1() {
        return this.i;
    }

    public final boolean b1() {
        C8512Wh0 c8512Wh0F;
        C14733iO2 c14733iO2 = this.g;
        if (c14733iO2 == null || (c8512Wh0F = c14733iO2.F()) == null) {
            return false;
        }
        return AbstractC13042fc3.d(c8512Wh0F.b(), Boolean.TRUE);
    }

    public final void c1() {
        Object value;
        C14733iO2 c14733iO2 = this.g;
        if (c14733iO2 != null) {
            int iR = c14733iO2.r();
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, OA7.e.a));
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(iR, this, null), 3, null);
        }
    }

    public final void f1() {
        Object value;
        this.j = true;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, OA7.e.a));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new e(null), 3, null);
    }

    public final void g1(boolean z) {
        C19482qQ7 c19482qQ7M;
        C24119y45 c24119y45;
        C14733iO2 c14733iO2 = this.g;
        if (c14733iO2 == null || (c19482qQ7M = c14733iO2.m()) == null || (c24119y45 = (C24119y45) c19482qQ7M.b()) == null) {
            return;
        }
        int i = c24119y45.q() ? 4 : 0;
        if (c24119y45.p()) {
            i += 2;
        }
        if (c24119y45.o()) {
            i++;
        }
        C3343Am.f(i, this.c, z);
    }

    public final void h1() {
        Object value;
        this.j = true;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, OA7.e.a));
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(null), 3, null);
    }

    public final void j1(C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(c14733iO2, "<set-?>");
        this.f = c14733iO2;
    }
}
