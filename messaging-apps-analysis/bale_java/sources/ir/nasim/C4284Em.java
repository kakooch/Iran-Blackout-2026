package ir.nasim;

import ai.bale.proto.CollectionsStruct$MapValue;
import ai.bale.proto.CollectionsStruct$MapValueItem;
import ai.bale.proto.CollectionsStruct$RawValue;
import ai.bale.proto.FanoosOuterClass$RequestSendFanoos;
import ai.bale.proto.Misc$ResponseVoid;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import java.util.Map;

/* renamed from: ir.nasim.Em, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4284Em {
    private static final a d = new a(null);
    public static final int e = 8;
    private final C6287Mz a;
    private final AbstractC13778go1 b;
    private final b c;

    /* renamed from: ir.nasim.Em$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Em$b */
    public static final class b implements InterfaceC14123hO3 {
        b() {
        }

        @Override // ir.nasim.InterfaceC14123hO3
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CollectionsStruct$MapValueItem.a a(XV4 xv4) {
            AbstractC13042fc3.i(xv4, "input");
            String str = (String) xv4.a();
            Object objB = xv4.b();
            if (objB instanceof Integer) {
                CollectionsStruct$MapValueItem.a aVarB = CollectionsStruct$MapValueItem.newBuilder().A(str).B(CollectionsStruct$RawValue.newBuilder().C(((Number) objB).intValue()));
                AbstractC13042fc3.f(aVarB);
                return aVarB;
            }
            if (objB instanceof Long) {
                CollectionsStruct$MapValueItem.a aVarB2 = CollectionsStruct$MapValueItem.newBuilder().A(str).B(CollectionsStruct$RawValue.newBuilder().D(((Number) objB).longValue()));
                AbstractC13042fc3.f(aVarB2);
                return aVarB2;
            }
            if (objB instanceof Boolean) {
                CollectionsStruct$MapValueItem.a aVarB3 = CollectionsStruct$MapValueItem.newBuilder().A(str).B(CollectionsStruct$RawValue.newBuilder().B(((Boolean) objB).booleanValue()));
                AbstractC13042fc3.f(aVarB3);
                return aVarB3;
            }
            CollectionsStruct$MapValueItem.a aVarB4 = CollectionsStruct$MapValueItem.newBuilder().A(str).B(CollectionsStruct$RawValue.newBuilder().E(objB.toString()));
            AbstractC13042fc3.f(aVarB4);
            return aVarB4;
        }
    }

    /* renamed from: ir.nasim.Em$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objH = C4284Em.this.h(null, this);
            return objH == AbstractC14862ic3.e() ? objH : C9475a16.a(objH);
        }
    }

    /* renamed from: ir.nasim.Em$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ C4284Em d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, C4284Em c4284Em, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = c4284Em;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = FanoosOuterClass$RequestSendFanoos.newBuilder().B(this.c).C(CollectionsStruct$MapValue.newBuilder().B(CollectionsStruct$MapValueItem.newBuilder().A("Type").B(CollectionsStruct$RawValue.newBuilder().E("Simple")))).A(AbstractC20507s76.o()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.fanoos.v1.fanoos/Send", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.d.a;
                this.b = 1;
                objA = AbstractC6547Nz.a(c22871vx5, c6287Mz, 16500L, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                C19406qI3.d("AnalyticsActor", thE);
            }
            return C9475a16.a(objA);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Em$e */
    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objG = C4284Em.this.g(null, null, null, this);
            return objG == AbstractC14862ic3.e() ? objG : C9475a16.a(objG);
        }
    }

    /* renamed from: ir.nasim.Em$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ C4284Em d;
        final /* synthetic */ String e;
        final /* synthetic */ Object f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, C4284Em c4284Em, String str2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = c4284Em;
            this.e = str2;
            this.f = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = FanoosOuterClass$RequestSendFanoos.newBuilder().B(this.c).C(this.d.d(this.e, this.f)).A(AbstractC20507s76.o()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.fanoos.v1.fanoos/Send", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.d.a;
                this.b = 1;
                objA = AbstractC6547Nz.a(c22871vx5, c6287Mz, 16500L, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                C19406qI3.d("AnalyticsActor", thE);
            }
            return C9475a16.a(objA);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Em$g */
    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C4284Em.this.f(null, null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.Em$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ C4284Em d;
        final /* synthetic */ Map e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, C4284Em c4284Em, Map map, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = c4284Em;
            this.e = map;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = FanoosOuterClass$RequestSendFanoos.newBuilder().B(this.c).C(this.d.e(this.e)).A(AbstractC20507s76.o()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.fanoos.v1.fanoos/Send", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = this.d.a;
                this.b = 1;
                objA = AbstractC6547Nz.a(c22871vx5, c6287Mz, 16500L, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                C19406qI3.d("AnalyticsActor", thE);
            }
            return C9475a16.a(objA);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4284Em(C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c6287Mz;
        this.b = abstractC13778go1;
        this.c = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CollectionsStruct$MapValue.a d(String str, Object obj) {
        CollectionsStruct$MapValue.a aVarNewBuilder = CollectionsStruct$MapValue.newBuilder();
        aVarNewBuilder.B(this.c.a(AbstractC4616Fw7.a(str, obj)));
        AbstractC13042fc3.h(aVarNewBuilder, "apply(...)");
        return aVarNewBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CollectionsStruct$MapValue.a e(Map map) {
        CollectionsStruct$MapValue.a aVarNewBuilder = CollectionsStruct$MapValue.newBuilder();
        for (Map.Entry entry : map.entrySet()) {
            aVarNewBuilder.B(this.c.a(AbstractC4616Fw7.a(entry.getKey(), entry.getValue())));
        }
        AbstractC13042fc3.h(aVarNewBuilder, "apply(...)");
        return aVarNewBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.String r6, java.util.Map r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C4284Em.g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Em$g r0 = (ir.nasim.C4284Em.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Em$g r0 = new ir.nasim.Em$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L4b
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.fB4 r8 = ir.nasim.C12798fB4.b
            ir.nasim.go1 r2 = r5.b
            ir.nasim.do1 r8 = r8.X(r2)
            ir.nasim.Em$h r2 = new ir.nasim.Em$h
            r4 = 0
            r2.<init>(r6, r5, r7, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4284Em.f(java.lang.String, java.util.Map, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r11, java.lang.String r12, java.lang.Object r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.C4284Em.e
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.Em$e r0 = (ir.nasim.C4284Em.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Em$e r0 = new ir.nasim.Em$e
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L50
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.fB4 r14 = ir.nasim.C12798fB4.b
            ir.nasim.go1 r2 = r10.b
            ir.nasim.do1 r14 = r14.X(r2)
            ir.nasim.Em$f r2 = new ir.nasim.Em$f
            r9 = 0
            r4 = r2
            r5 = r11
            r6 = r10
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L50
            return r1
        L50:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4284Em.g(java.lang.String, java.lang.String, java.lang.Object, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C4284Em.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.Em$c r0 = (ir.nasim.C4284Em.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Em$c r0 = new ir.nasim.Em$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L4b
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.fB4 r7 = ir.nasim.C12798fB4.b
            ir.nasim.go1 r2 = r5.b
            ir.nasim.do1 r7 = r7.X(r2)
            ir.nasim.Em$d r2 = new ir.nasim.Em$d
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4284Em.h(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
