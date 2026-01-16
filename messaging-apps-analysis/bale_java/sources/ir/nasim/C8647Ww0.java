package ir.nasim;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C17448mz0;
import ir.nasim.C8647Ww0;
import ir.nasim.InterfaceC9449Zz0;
import ir.nasim.features.call.ui.CallActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ww0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8647Ww0 {
    public static final a l = new a(null);
    public static final int m = 8;
    private final InterfaceC20315ro1 a;
    private final Context b;
    private final NotificationManager c;
    private final C4627Fy0 d;
    private final A08 e;
    private final C15732k47 f;
    private final PM4 g;
    private final C9165Yt4 h;
    private final ST1 i;
    private final C14114hN3 j;
    private final C15874kK k;

    /* renamed from: ir.nasim.Ww0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ww0$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C17448mz0.a.values().length];
            try {
                iArr[C17448mz0.a.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C17448mz0.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C17448mz0.a.g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Ww0$c */
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
            return C8647Ww0.this.l(null, this);
        }
    }

    /* renamed from: ir.nasim.Ww0$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.Ww0$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8647Ww0 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8647Ww0 c8647Ww0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8647Ww0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C8647Ww0 c8647Ww0 = this.c;
                    this.b = 1;
                    if (c8647Ww0.q(this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Ww0$d$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8647Ww0 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C8647Ww0 c8647Ww0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8647Ww0;
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
                    C8647Ww0 c8647Ww0 = this.c;
                    this.b = 1;
                    if (c8647Ww0.o(this) == objE) {
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

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C8647Ww0.this.new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(C8647Ww0.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(C8647Ww0.this, null), 3, null);
            C8647Ww0.this.f.d();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ww0$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = C8647Ww0.this.new e(interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17448mz0 c17448mz0 = (C17448mz0) this.c;
                C19406qI3.a("CallManagerUseCase", "consumed state " + c17448mz0, new Object[0]);
                C8647Ww0 c8647Ww0 = C8647Ww0.this;
                this.b = 1;
                if (c8647Ww0.l(c17448mz0, this) == objE) {
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
        public final Object invoke(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(c17448mz0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ww0$f */
    static final class f implements InterfaceC4806Gq2 {
        f() {
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a(InterfaceC9449Zz0 interfaceC9449Zz0, InterfaceC20295rm1 interfaceC20295rm1) {
            C19406qI3.a("CallManagerUseCase", "received update " + interfaceC9449Zz0.getClass().getName(), new Object[0]);
            if (interfaceC9449Zz0 instanceof InterfaceC9449Zz0.c) {
                C8647Ww0.this.g.b((InterfaceC9449Zz0.c) interfaceC9449Zz0);
            } else {
                if (interfaceC9449Zz0 instanceof InterfaceC9449Zz0.e) {
                    Object objD = C8647Ww0.this.h.d(((InterfaceC9449Zz0.e) interfaceC9449Zz0).a(), interfaceC20295rm1);
                    return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
                }
                if (interfaceC9449Zz0 instanceof InterfaceC9449Zz0.d) {
                    Object objA = C8647Ww0.this.i.a(((InterfaceC9449Zz0.d) interfaceC9449Zz0).a(), interfaceC20295rm1);
                    return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
                }
                if (interfaceC9449Zz0 instanceof InterfaceC9449Zz0.b) {
                    InterfaceC9449Zz0.b bVar = (InterfaceC9449Zz0.b) interfaceC9449Zz0;
                    Object objB = C8647Ww0.this.k.b(bVar.a(), bVar.b(), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
                C19406qI3.a("CallManagerUseCase", "the " + interfaceC9449Zz0 + " update not handled", new Object[0]);
            }
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ww0$g */
    public static final class g implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Ww0$g$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Ww0$g$a$a, reason: collision with other inner class name */
            public static final class C0739a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0739a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C8647Ww0.g.a.C0739a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Ww0$g$a$a r0 = (ir.nasim.C8647Ww0.g.a.C0739a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ww0$g$a$a r0 = new ir.nasim.Ww0$g$a$a
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
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8647Ww0.g.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public g(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ww0$h */
    static final class h extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            List list2 = (List) this.d;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                M26 m26 = (M26) obj2;
                List list3 = list2;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((M26) it.next()).j());
                }
                if (arrayList2.contains(m26.j())) {
                    arrayList.add(obj2);
                }
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
            h hVar = new h(interfaceC20295rm1);
            hVar.c = list;
            hVar.d = list2;
            return hVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ww0$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = C8647Ww0.this.new i(interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List<M26> list = (List) this.c;
            C8647Ww0 c8647Ww0 = C8647Ww0.this;
            for (M26 m26 : list) {
                C19406qI3.a("CallManagerUseCase", "user accepted invite " + m26.j(), new Object[0]);
                c8647Ww0.d.z1(Integer.parseInt(m26.j()));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ww0$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Context c;
        final /* synthetic */ C8942Xx0 d;
        final /* synthetic */ long e;
        final /* synthetic */ C8647Ww0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Context context, C8942Xx0 c8942Xx0, long j, C8647Ww0 c8647Ww0, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = context;
            this.d = c8942Xx0;
            this.e = j;
            this.f = c8647Ww0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C8647Ww0 c8647Ww0, long j, Notification notification) {
            if (((C17448mz0) C18039nz0.a.d().getValue()).e() == C17448mz0.a.e) {
                c8647Ww0.c.notify((int) j, notification);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C19406qI3.a("CallManagerUseCase", "showIncomingCallNotification", new Object[0]);
            C5335Ix0 c5335Ix0 = C5335Ix0.a;
            Context context = this.c;
            C8942Xx0 c8942Xx0 = this.d;
            final long j = this.e;
            final C8647Ww0 c8647Ww0 = this.f;
            this.f.c.notify((int) this.e, c5335Ix0.C(context, c8942Xx0, j, false, new UA2() { // from class: ir.nasim.Xw0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C8647Ww0.j.y(c8647Ww0, j, (Notification) obj2);
                }
            }));
            C19406qI3.a("CallManagerUseCase", "showIncomingCallNotification end", new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C8647Ww0(InterfaceC20315ro1 interfaceC20315ro1, Context context, NotificationManager notificationManager, C4627Fy0 c4627Fy0, A08 a08, C15732k47 c15732k47, PM4 pm4, C9165Yt4 c9165Yt4, ST1 st1, C14114hN3 c14114hN3, C15874kK c15874kK) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(notificationManager, "notificationManager");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(a08, "voiceCallModule");
        AbstractC13042fc3.i(c15732k47, "syncOnGoingCallUseCase");
        AbstractC13042fc3.i(pm4, "outGoingCallReceivedUseCase");
        AbstractC13042fc3.i(c9165Yt4, "incomingCallUseCase");
        AbstractC13042fc3.i(st1, "discardCallUseCase");
        AbstractC13042fc3.i(c14114hN3, "manageAndroid14NotificationUseCase");
        AbstractC13042fc3.i(c15874kK, "askToJoinCallUseCase");
        this.a = interfaceC20315ro1;
        this.b = context;
        this.c = notificationManager;
        this.d = c4627Fy0;
        this.e = a08;
        this.f = c15732k47;
        this.g = pm4;
        this.h = c9165Yt4;
        this.i = st1;
        this.j = c14114hN3;
        this.k = c15874kK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(ir.nasim.C17448mz0 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C8647Ww0.c
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Ww0$c r0 = (ir.nasim.C8647Ww0.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ww0$c r0 = new ir.nasim.Ww0$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6c
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            ir.nasim.AbstractC10685c16.b(r8)
            goto La7
        L38:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.mz0$a r8 = r7.e()
            int[] r2 = ir.nasim.C8647Ww0.b.a
            int r8 = r8.ordinal()
            r8 = r2[r8]
            r2 = 0
            java.lang.String r5 = "CallManagerUseCase"
            if (r8 == r4) goto L7c
            if (r8 == r3) goto L6f
            r2 = 3
            if (r8 == r2) goto L52
            goto La7
        L52:
            ir.nasim.Vt0 r8 = ir.nasim.C8386Vt0.a
            boolean r8 = r8.l4()
            if (r8 == 0) goto L5f
            ir.nasim.hN3 r8 = r6.j
            r8.a()
        L5f:
            ir.nasim.Zm4 r7 = r7.g()
            r0.c = r3
            java.lang.Object r7 = r6.r(r7, r0)
            if (r7 != r1) goto L6c
            return r1
        L6c:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        L6f:
            java.lang.String r7 = "outgoing started"
            java.lang.Object[] r8 = new java.lang.Object[r2]
            ir.nasim.C19406qI3.a(r5, r7, r8)
            ir.nasim.PM4 r7 = r6.g
            r7.a()
            goto La7
        L7c:
            ir.nasim.Vt0 r8 = ir.nasim.C8386Vt0.a
            boolean r8 = r8.n5()
            if (r8 == 0) goto L8d
            boolean r8 = r7.m()
            if (r8 != 0) goto L8d
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        L8d:
            ir.nasim.Xx0 r8 = r7.d()
            if (r8 == 0) goto La0
            long r2 = r7.c()
            r0.c = r4
            java.lang.Object r7 = r6.m(r8, r2, r0)
            if (r7 != r1) goto La7
            return r1
        La0:
            java.lang.String r7 = "wrong call peer is in this state"
            java.lang.Object[] r8 = new java.lang.Object[r2]
            ir.nasim.C19406qI3.a(r5, r7, r8)
        La7:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8647Ww0.l(ir.nasim.mz0, ir.nasim.rm1):java.lang.Object");
    }

    private final Object m(C8942Xx0 c8942Xx0, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        C19406qI3.a("CallManagerUseCase", "show INCOMING NOTIFICATION with ID $" + ((int) j2), new Object[0]);
        if (!AD4.e(this.b).a()) {
            s();
            return C19938rB7.a;
        }
        Object objT = t(c8942Xx0, j2, this.b, interfaceC20295rm1);
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o(InterfaceC20295rm1 interfaceC20295rm1) {
        C19406qI3.a("CallManagerUseCase", "start observe call states", new Object[0]);
        Object objL = AbstractC6459Nq2.l(AbstractC6459Nq2.x(C18039nz0.a.d(), new UA2() { // from class: ir.nasim.Vw0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8647Ww0.p((C17448mz0) obj);
            }
        }), new e(null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17448mz0.a p(C17448mz0 c17448mz0) {
        AbstractC13042fc3.i(c17448mz0, "it");
        return c17448mz0.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = AbstractC7420Rq2.b(this.e.K(), 0, null, 3, null).b(new f(), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    private final Object r(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objL = AbstractC6459Nq2.l(new g(AbstractC6459Nq2.S(C18039nz0.a.e(), interfaceC4557Fq2, new h(null))), new i(null), interfaceC20295rm1);
        return objL == AbstractC14862ic3.e() ? objL : C19938rB7.a;
    }

    private final void s() {
        C19406qI3.a("CallManagerUseCase", "openCallActivity", new Object[0]);
        Intent intent = new Intent(this.b, (Class<?>) CallActivity.class);
        intent.setAction("bale_voice_call");
        intent.addFlags(268435456);
        this.b.startActivity(intent);
    }

    private final Object t(C8942Xx0 c8942Xx0, long j2, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(C12366eV1.c(), new j(context, c8942Xx0, j2, this, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    public final InterfaceC13730gj3 n() {
        return AbstractC10533bm0.d(this.a, null, null, new d(null), 3, null);
    }
}
