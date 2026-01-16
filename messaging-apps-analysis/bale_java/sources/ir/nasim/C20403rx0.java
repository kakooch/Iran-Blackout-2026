package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.rx0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20403rx0 extends VW7 {
    private final SettingsModule b;
    private final C9728aS7 c;
    private final C21786u78 d;
    private final C4627Fy0 e;
    private final InterfaceC10258bL6 f;
    private final InterfaceC10258bL6 g;
    private final InterfaceC10258bL6 h;
    private final InterfaceC10258bL6 i;
    private final InterfaceC9336Zm4 j;
    private final InterfaceC10258bL6 k;

    /* renamed from: ir.nasim.rx0$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.rx0$a$a, reason: collision with other inner class name */
        public static final class C1533a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.rx0$a$a$a, reason: collision with other inner class name */
            public static final class C1534a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1534a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C1533a.this.a(null, this);
                }
            }

            public C1533a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.C20403rx0.a.C1533a.C1534a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.rx0$a$a$a r0 = (ir.nasim.C20403rx0.a.C1533a.C1534a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.rx0$a$a$a r0 = new ir.nasim.rx0$a$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L69
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.r78 r7 = (ir.nasim.C19900r78) r7
                    if (r7 == 0) goto L5d
                    java.util.List r7 = r7.d()
                    if (r7 == 0) goto L5d
                    java.lang.Iterable r7 = (java.lang.Iterable) r7
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Iterator r7 = r7.iterator()
                L4b:
                    boolean r4 = r7.hasNext()
                    if (r4 == 0) goto L5e
                    java.lang.Object r4 = r7.next()
                    boolean r5 = r4 instanceof ir.nasim.XN
                    if (r5 == 0) goto L4b
                    r2.add(r4)
                    goto L4b
                L5d:
                    r2 = 0
                L5e:
                    if (r2 == 0) goto L69
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r2, r0)
                    if (r7 != r1) goto L69
                    return r1
                L69:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20403rx0.a.C1533a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C1533a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rx0$b */
    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.rx0$b$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.rx0$b$a$a, reason: collision with other inner class name */
            public static final class C1535a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1535a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.C20403rx0.b.a.C1535a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.rx0$b$a$a r0 = (ir.nasim.C20403rx0.b.a.C1535a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.rx0$b$a$a r0 = new ir.nasim.rx0$b$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L69
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.r78 r7 = (ir.nasim.C19900r78) r7
                    if (r7 == 0) goto L5d
                    java.util.List r7 = r7.d()
                    if (r7 == 0) goto L5d
                    java.lang.Iterable r7 = (java.lang.Iterable) r7
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Iterator r7 = r7.iterator()
                L4b:
                    boolean r4 = r7.hasNext()
                    if (r4 == 0) goto L5e
                    java.lang.Object r4 = r7.next()
                    boolean r5 = r4 instanceof ir.nasim.CT7
                    if (r5 == 0) goto L4b
                    r2.add(r4)
                    goto L4b
                L5d:
                    r2 = 0
                L5e:
                    if (r2 == 0) goto L69
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r2, r0)
                    if (r7 != r1) goto L69
                    return r1
                L69:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20403rx0.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rx0$c */
    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.rx0$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.rx0$c$a$a, reason: collision with other inner class name */
            public static final class C1536a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1536a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.C20403rx0.c.a.C1536a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.rx0$c$a$a r0 = (ir.nasim.C20403rx0.c.a.C1536a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.rx0$c$a$a r0 = new ir.nasim.rx0$c$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L69
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.r78 r7 = (ir.nasim.C19900r78) r7
                    if (r7 == 0) goto L5d
                    java.util.List r7 = r7.c()
                    if (r7 == 0) goto L5d
                    java.lang.Iterable r7 = (java.lang.Iterable) r7
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Iterator r7 = r7.iterator()
                L4b:
                    boolean r4 = r7.hasNext()
                    if (r4 == 0) goto L5e
                    java.lang.Object r4 = r7.next()
                    boolean r5 = r4 instanceof ir.nasim.PN
                    if (r5 == 0) goto L4b
                    r2.add(r4)
                    goto L4b
                L5d:
                    r2 = 0
                L5e:
                    if (r2 == 0) goto L69
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r2, r0)
                    if (r7 != r1) goto L69
                    return r1
                L69:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20403rx0.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

    /* renamed from: ir.nasim.rx0$d */
    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.rx0$d$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.rx0$d$a$a, reason: collision with other inner class name */
            public static final class C1537a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1537a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.C20403rx0.d.a.C1537a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.rx0$d$a$a r0 = (ir.nasim.C20403rx0.d.a.C1537a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.rx0$d$a$a r0 = new ir.nasim.rx0$d$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L69
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.r78 r7 = (ir.nasim.C19900r78) r7
                    if (r7 == 0) goto L5d
                    java.util.List r7 = r7.c()
                    if (r7 == 0) goto L5d
                    java.lang.Iterable r7 = (java.lang.Iterable) r7
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Iterator r7 = r7.iterator()
                L4b:
                    boolean r4 = r7.hasNext()
                    if (r4 == 0) goto L5e
                    java.lang.Object r4 = r7.next()
                    boolean r5 = r4 instanceof ir.nasim.C21986uT7
                    if (r5 == 0) goto L4b
                    r2.add(r4)
                    goto L4b
                L5d:
                    r2 = 0
                L5e:
                    if (r2 == 0) goto L69
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r2, r0)
                    if (r7 != r1) goto L69
                    return r1
                L69:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20403rx0.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public C20403rx0(SettingsModule settingsModule, C9728aS7 c9728aS7, C21786u78 c21786u78, C4627Fy0 c4627Fy0) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c9728aS7, "versionCodeNumber");
        AbstractC13042fc3.i(c21786u78, "webRtcStatsRepository");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        this.b = settingsModule;
        this.c = c9728aS7;
        this.d = c21786u78;
        this.e = c4627Fy0;
        a aVar = new a(c21786u78.a());
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC9773aX7.a(this);
        InterfaceC16863lz6.a aVar2 = InterfaceC16863lz6.a;
        InterfaceC10258bL6 interfaceC10258bL6O0 = AbstractC6459Nq2.o0(aVar, interfaceC20315ro1A, aVar2.c(), AbstractC10360bX0.m());
        this.f = interfaceC10258bL6O0;
        InterfaceC10258bL6 interfaceC10258bL6O02 = AbstractC6459Nq2.o0(new b(c21786u78.a()), AbstractC9773aX7.a(this), aVar2.c(), AbstractC10360bX0.m());
        this.g = interfaceC10258bL6O02;
        InterfaceC10258bL6 interfaceC10258bL6O03 = AbstractC6459Nq2.o0(new c(c21786u78.a()), AbstractC9773aX7.a(this), aVar2.c(), AbstractC10360bX0.m());
        this.h = interfaceC10258bL6O03;
        InterfaceC10258bL6 interfaceC10258bL6O04 = AbstractC6459Nq2.o0(new d(c21786u78.a()), AbstractC9773aX7.a(this), aVar2.c(), AbstractC10360bX0.m());
        this.i = interfaceC10258bL6O04;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C19794qx0(P0(), C18039nz0.a.d(), interfaceC10258bL6O0, interfaceC10258bL6O02, interfaceC10258bL6O03, interfaceC10258bL6O04));
        this.j = interfaceC9336Zm4A;
        this.k = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    private final String P0() {
        Object next;
        K26 k26;
        C22279uy0 c22279uy0P3 = this.b.p3();
        if (c22279uy0P3 != null) {
            Set setEntrySet = c22279uy0P3.a().entrySet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : setEntrySet) {
                if (((Number) ((Map.Entry) obj).getKey()).longValue() <= this.c.a()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    long jLongValue = ((Number) ((Map.Entry) next).getKey()).longValue();
                    do {
                        Object next2 = it.next();
                        long jLongValue2 = ((Number) ((Map.Entry) next2).getKey()).longValue();
                        if (jLongValue < jLongValue2) {
                            next = next2;
                            jLongValue = jLongValue2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry == null || (k26 = (K26) entry.getValue()) == null) {
                k26 = (K26) AbstractC15401jX0.r0(c22279uy0P3.a().values());
            }
            String string = k26 != null ? k26.toString() : null;
            if (string != null) {
                return string;
            }
        }
        return "Not found !";
    }

    public final InterfaceC10258bL6 R0() {
        return this.k;
    }
}
