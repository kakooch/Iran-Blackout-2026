package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.GL1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.RP1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.dialoglist.data.model.DialogDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.zP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24904zP1 {
    private final int a;
    private final InterfaceC20315ro1 b;
    private final InterfaceC10258bL6 c;
    private final InterfaceC10258bL6 d;
    private final int e;
    private final AbstractC13778go1 f;
    private final InterfaceC4308Eo5 g;
    private final InterfaceC5943Lm5 h;
    private final InterfaceC11621dJ7 i;
    private final Context j;
    private final TP1 k;
    private final GL1.a l;
    private final HashMap m;
    private final CopyOnWriteArrayList n;
    private InterfaceC13730gj3 o;
    private final InterfaceC9336Zm4 p;
    private final Map q;

    /* renamed from: ir.nasim.zP1$a */
    public interface a {
        void b();

        void c(String str);

        long d();

        void e(EnumC18228oI7 enumC18228oI7);

        void f(SP1 sp1);

        void g(b bVar);

        void h(DialogDTO dialogDTO, Avatar avatar, String str);

        void i(boolean z, boolean z2);

        void j(String str);

        void k(PI7 pi7);

        ExPeerType z();
    }

    /* renamed from: ir.nasim.zP1$b */
    public static final class b {
        public static final int e = RP1.h.g;
        private final boolean a;
        private final boolean b;
        private final EnumC18228oI7 c;
        private final SP1 d;

        public b(boolean z, boolean z2, EnumC18228oI7 enumC18228oI7, SP1 sp1) {
            this.a = z;
            this.b = z2;
            this.c = enumC18228oI7;
            this.d = sp1;
        }

        public final SP1 a() {
            return this.d;
        }

        public final EnumC18228oI7 b() {
            return this.c;
        }

        public final boolean c() {
            return this.b;
        }

        public final boolean d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            int iHashCode = ((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31;
            EnumC18228oI7 enumC18228oI7 = this.c;
            int iHashCode2 = (iHashCode + (enumC18228oI7 == null ? 0 : enumC18228oI7.hashCode())) * 31;
            SP1 sp1 = this.d;
            return iHashCode2 + (sp1 != null ? sp1.hashCode() : 0);
        }

        public String toString() {
            return "DialogState(isSelected=" + this.a + ", isSelectable=" + this.b + ", userActivityState=" + this.c + ", updateBundle=" + this.d + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.zP1$c */
    public interface c {
        C24904zP1 a(int i, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62);
    }

    /* renamed from: ir.nasim.zP1$d */
    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ int b;

        /* renamed from: ir.nasim.zP1$d$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ int b;

            /* renamed from: ir.nasim.zP1$d$a$a, reason: collision with other inner class name */
            public static final class C1809a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1809a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, int i) {
                this.a = interfaceC4806Gq2;
                this.b = i;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r10, ir.nasim.InterfaceC20295rm1 r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof ir.nasim.C24904zP1.d.a.C1809a
                    if (r0 == 0) goto L13
                    r0 = r11
                    ir.nasim.zP1$d$a$a r0 = (ir.nasim.C24904zP1.d.a.C1809a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.zP1$d$a$a r0 = new ir.nasim.zP1$d$a$a
                    r0.<init>(r11)
                L18:
                    java.lang.Object r11 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r11)
                    goto L81
                L29:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L31:
                    ir.nasim.AbstractC10685c16.b(r11)
                    ir.nasim.Gq2 r11 = r9.a
                    java.util.Map r10 = (java.util.Map) r10
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Set r10 = r10.entrySet()
                    java.util.Iterator r10 = r10.iterator()
                L45:
                    boolean r4 = r10.hasNext()
                    if (r4 == 0) goto L78
                    java.lang.Object r4 = r10.next()
                    java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                    java.lang.Object r5 = r4.getKey()
                    java.lang.Number r5 = (java.lang.Number) r5
                    long r5 = r5.longValue()
                    java.lang.Object r4 = r4.getValue()
                    ir.nasim.core.modules.profile.entity.ExPeerType r4 = (ir.nasim.core.modules.profile.entity.ExPeerType) r4
                    int r7 = r9.b
                    long r7 = (long) r7
                    int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                    if (r7 == 0) goto L71
                    ir.nasim.core.modules.profile.entity.ExPeerType r7 = ir.nasim.core.modules.profile.entity.ExPeerType.PRIVATE
                    if (r4 != r7) goto L71
                    java.lang.Long r4 = ir.nasim.AbstractC6392Nk0.e(r5)
                    goto L72
                L71:
                    r4 = 0
                L72:
                    if (r4 == 0) goto L45
                    r2.add(r4)
                    goto L45
                L78:
                    r0.b = r3
                    java.lang.Object r10 = r11.a(r2, r0)
                    if (r10 != r1) goto L81
                    return r1
                L81:
                    ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24904zP1.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public d(InterfaceC4557Fq2 interfaceC4557Fq2, int i) {
            this.a = interfaceC4557Fq2;
            this.b = i;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zP1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zP1$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            Object e;
            Object f;
            int g;
            /* synthetic */ Object h;
            final /* synthetic */ C24904zP1 i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24904zP1 c24904zP1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.i = c24904zP1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.i, interfaceC20295rm1);
                aVar.h = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:50:0x0142  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0198  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x01a9  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x01df  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0186 -> B:54:0x0187). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    Method dump skipped, instructions count: 524
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24904zP1.e.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24904zP1.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24904zP1 c24904zP1 = C24904zP1.this;
                InterfaceC4557Fq2 interfaceC4557Fq2W = c24904zP1.w(AbstractC6459Nq2.s(c24904zP1.p, 100L), C24904zP1.this.e);
                a aVar = new a(C24904zP1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2W, aVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zP1$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C24904zP1.this.new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            C24904zP1.this.D(interfaceC20315ro1);
            C24904zP1.this.C(interfaceC20315ro1);
            C24904zP1.this.B(interfaceC20315ro1);
            if (C8386Vt0.a.n9()) {
                C24904zP1.this.y(interfaceC20315ro1);
            }
            C24904zP1.this.A(interfaceC20315ro1);
            C24904zP1.this.E(interfaceC20315ro1);
            C24904zP1.this.F(interfaceC20315ro1);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zP1$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zP1$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C24904zP1 d;

            /* renamed from: ir.nasim.zP1$g$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C1810a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[ExPeerType.values().length];
                    try {
                        iArr[ExPeerType.PRIVATE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ExPeerType.BOT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ExPeerType.GROUP.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    a = iArr;
                }
            }

            /* renamed from: ir.nasim.zP1$g$a$b */
            public static final class b implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;
                final /* synthetic */ C24904zP1 b;
                final /* synthetic */ long c;

                /* renamed from: ir.nasim.zP1$g$a$b$a, reason: collision with other inner class name */
                public static final class C1811a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;
                    final /* synthetic */ C24904zP1 b;
                    final /* synthetic */ long c;

                    /* renamed from: ir.nasim.zP1$g$a$b$a$a, reason: collision with other inner class name */
                    public static final class C1812a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1812a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1811a.this.a(null, this);
                        }
                    }

                    public C1811a(InterfaceC4806Gq2 interfaceC4806Gq2, C24904zP1 c24904zP1, long j) {
                        this.a = interfaceC4806Gq2;
                        this.b = c24904zP1;
                        this.c = j;
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
                            boolean r0 = r8 instanceof ir.nasim.C24904zP1.g.a.b.C1811a.C1812a
                            if (r0 == 0) goto L13
                            r0 = r8
                            ir.nasim.zP1$g$a$b$a$a r0 = (ir.nasim.C24904zP1.g.a.b.C1811a.C1812a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.zP1$g$a$b$a$a r0 = new ir.nasim.zP1$g$a$b$a$a
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r8)
                            goto L5b
                        L29:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L31:
                            ir.nasim.AbstractC10685c16.b(r8)
                            ir.nasim.Gq2 r8 = r6.a
                            ir.nasim.Iz7 r7 = (ir.nasim.EnumC5360Iz7) r7
                            ir.nasim.Iz7 r2 = ir.nasim.EnumC5360Iz7.b
                            if (r7 != r2) goto L3e
                            r7 = 0
                            goto L48
                        L3e:
                            ir.nasim.zP1 r2 = r6.b
                            android.content.Context r2 = ir.nasim.C24904zP1.f(r2)
                            java.lang.String r7 = ir.nasim.AbstractC4699Ge3.b(r2, r7)
                        L48:
                            long r4 = r6.c
                            java.lang.Long r2 = ir.nasim.AbstractC6392Nk0.e(r4)
                            ir.nasim.XV4 r7 = ir.nasim.AbstractC4616Fw7.a(r2, r7)
                            r0.b = r3
                            java.lang.Object r7 = r8.a(r7, r0)
                            if (r7 != r1) goto L5b
                            return r1
                        L5b:
                            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24904zP1.g.a.b.C1811a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public b(InterfaceC4557Fq2 interfaceC4557Fq2, C24904zP1 c24904zP1, long j) {
                    this.a = interfaceC4557Fq2;
                    this.b = c24904zP1;
                    this.c = j;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1811a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.zP1$g$a$c */
            public static final class c implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;
                final /* synthetic */ long b;
                final /* synthetic */ C24904zP1 c;

                /* renamed from: ir.nasim.zP1$g$a$c$a, reason: collision with other inner class name */
                public static final class C1813a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;
                    final /* synthetic */ long b;
                    final /* synthetic */ C24904zP1 c;

                    /* renamed from: ir.nasim.zP1$g$a$c$a$a, reason: collision with other inner class name */
                    public static final class C1814a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;
                        Object c;
                        Object e;
                        Object f;

                        public C1814a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1813a.this.a(null, this);
                        }
                    }

                    public C1813a(InterfaceC4806Gq2 interfaceC4806Gq2, long j, C24904zP1 c24904zP1) {
                        this.a = interfaceC4806Gq2;
                        this.b = j;
                        this.c = c24904zP1;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r10, ir.nasim.InterfaceC20295rm1 r11) {
                        /*
                            r9 = this;
                            boolean r0 = r11 instanceof ir.nasim.C24904zP1.g.a.c.C1813a.C1814a
                            if (r0 == 0) goto L13
                            r0 = r11
                            ir.nasim.zP1$g$a$c$a$a r0 = (ir.nasim.C24904zP1.g.a.c.C1813a.C1814a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.zP1$g$a$c$a$a r0 = new ir.nasim.zP1$g$a$c$a$a
                            r0.<init>(r11)
                        L18:
                            java.lang.Object r11 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 2
                            r4 = 1
                            r5 = 0
                            if (r2 == 0) goto L46
                            if (r2 == r4) goto L36
                            if (r2 != r3) goto L2e
                            ir.nasim.AbstractC10685c16.b(r11)
                            goto Lbd
                        L2e:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                            r10.<init>(r11)
                            throw r10
                        L36:
                            java.lang.Object r10 = r0.f
                            java.util.ArrayList r10 = (java.util.ArrayList) r10
                            java.lang.Object r2 = r0.e
                            ir.nasim.Gq2 r2 = (ir.nasim.InterfaceC4806Gq2) r2
                            java.lang.Object r4 = r0.c
                            ir.nasim.zP1$g$a$c$a r4 = (ir.nasim.C24904zP1.g.a.c.C1813a) r4
                            ir.nasim.AbstractC10685c16.b(r11)
                            goto L8a
                        L46:
                            ir.nasim.AbstractC10685c16.b(r11)
                            ir.nasim.Gq2 r2 = r9.a
                            java.util.ArrayList r10 = (java.util.ArrayList) r10
                            ir.nasim.AbstractC13042fc3.f(r10)
                            java.util.Iterator r11 = r10.iterator()
                        L54:
                            boolean r6 = r11.hasNext()
                            if (r6 == 0) goto L6a
                            java.lang.Object r6 = r11.next()
                            r7 = r6
                            ir.nasim.dO2 r7 = (ir.nasim.C11661dO2) r7
                            ir.nasim.Iz7 r7 = r7.a()
                            ir.nasim.Iz7 r8 = ir.nasim.EnumC5360Iz7.b
                            if (r7 == r8) goto L54
                            goto L6b
                        L6a:
                            r6 = r5
                        L6b:
                            ir.nasim.dO2 r6 = (ir.nasim.C11661dO2) r6
                            if (r6 == 0) goto La2
                            ir.nasim.zP1 r11 = r9.c
                            ir.nasim.dJ7 r11 = ir.nasim.C24904zP1.o(r11)
                            int r6 = r6.b()
                            long r6 = (long) r6
                            r0.c = r9
                            r0.e = r2
                            r0.f = r10
                            r0.b = r4
                            java.lang.Object r11 = r11.a(r6, r0)
                            if (r11 != r1) goto L89
                            return r1
                        L89:
                            r4 = r9
                        L8a:
                            ir.nasim.nI7 r11 = (ir.nasim.C17637nI7) r11
                            if (r11 == 0) goto La3
                            java.lang.String r11 = r11.getName()
                            if (r11 == 0) goto La3
                            ir.nasim.zP1 r6 = r4.c
                            android.content.Context r6 = ir.nasim.C24904zP1.f(r6)
                            ir.nasim.AbstractC13042fc3.f(r10)
                            java.lang.String r10 = ir.nasim.AbstractC4699Ge3.a(r6, r10, r11)
                            goto La4
                        La2:
                            r4 = r9
                        La3:
                            r10 = r5
                        La4:
                            long r6 = r4.b
                            java.lang.Long r11 = ir.nasim.AbstractC6392Nk0.e(r6)
                            ir.nasim.XV4 r10 = ir.nasim.AbstractC4616Fw7.a(r11, r10)
                            r0.c = r5
                            r0.e = r5
                            r0.f = r5
                            r0.b = r3
                            java.lang.Object r10 = r2.a(r10, r0)
                            if (r10 != r1) goto Lbd
                            return r1
                        Lbd:
                            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                            return r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24904zP1.g.a.c.C1813a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public c(InterfaceC4557Fq2 interfaceC4557Fq2, long j, C24904zP1 c24904zP1) {
                    this.a = interfaceC4557Fq2;
                    this.b = j;
                    this.c = c24904zP1;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1813a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24904zP1 c24904zP1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c24904zP1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object bVar;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Map.Entry entry = (Map.Entry) this.c;
                long jLongValue = ((Number) entry.getKey()).longValue();
                ExPeerType exPeerType = (ExPeerType) entry.getValue();
                C11458d25 c11458d25R = C11458d25.r(jLongValue);
                AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                int i = C1810a.a[exPeerType.ordinal()];
                if (i == 1 || i == 2) {
                    C19482qQ7 c19482qQ7G0 = AbstractC5969Lp4.d().g0(c11458d25R.getPeerId());
                    AbstractC13042fc3.h(c19482qQ7G0, "getTyping(...)");
                    bVar = new b(AbstractC23145wQ7.a(c19482qQ7G0), this.d, jLongValue);
                } else {
                    if (i != 3) {
                        return AbstractC6459Nq2.C();
                    }
                    C19482qQ7 c19482qQ7W = AbstractC5969Lp4.d().W(c11458d25R.getPeerId());
                    AbstractC13042fc3.h(c19482qQ7W, "getGroupTyping(...)");
                    bVar = new c(AbstractC23145wQ7.a(c19482qQ7W), jLongValue, this.d);
                }
                return bVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Map.Entry entry, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(entry, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.zP1$g$b */
        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ C24904zP1 a;

            b(C24904zP1 c24904zP1) {
                this.a = c24904zP1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
                long jLongValue = ((Number) xv4.a()).longValue();
                String str = (String) xv4.b();
                for (a aVar : this.a.n) {
                    if (aVar.d() == jLongValue) {
                        aVar.j(str);
                    }
                }
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.zP1$g$c */
        public static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C24904zP1 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(InterfaceC20295rm1 interfaceC20295rm1, C24904zP1 c24904zP1) {
                super(3, interfaceC20295rm1);
                this.e = c24904zP1;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2C = AbstractC8861Xq2.c(AbstractC6459Nq2.a(((Map) this.d).entrySet()), 0, new a(this.e, null), 1, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2C, this) == objE) {
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
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(interfaceC20295rm1, this.e);
                cVar.c = interfaceC4806Gq2;
                cVar.d = obj;
                return cVar.invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24904zP1.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.s0(C24904zP1.this.p, new c(null, C24904zP1.this)), C24904zP1.this.f);
                b bVar = new b(C24904zP1.this);
                this.b = 1;
                if (interfaceC4557Fq2V.b(bVar, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zP1$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zP1$h$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C24904zP1 a;

            a(C24904zP1 c24904zP1) {
                this.a = c24904zP1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                for (a aVar : this.a.n) {
                    aVar.k((PI7) map.get(AbstractC6392Nk0.e(aVar.d())));
                }
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.zP1$h$b */
        public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ C24904zP1 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC20295rm1 interfaceC20295rm1, C24904zP1 c24904zP1) {
                super(3, interfaceC20295rm1);
                this.e = c24904zP1;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2A = this.e.g.a(AbstractC15401jX0.m1((List) this.d));
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2A, this) == objE) {
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
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(interfaceC20295rm1, this.e);
                bVar.c = interfaceC4806Gq2;
                bVar.d = obj;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24904zP1.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24904zP1 c24904zP1 = C24904zP1.this;
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.V(AbstractC6459Nq2.s0(c24904zP1.w(c24904zP1.p, C24904zP1.this.e), new b(null, C24904zP1.this)), C24904zP1.this.f);
                a aVar = new a(C24904zP1.this);
                this.b = 1;
                if (interfaceC4557Fq2V.b(aVar, this) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zP1$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zP1$i$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C24904zP1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24904zP1 c24904zP1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c24904zP1;
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
                    List list = (List) this.c;
                    InterfaceC4308Eo5 interfaceC4308Eo5 = this.d.g;
                    List list2 = list;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC6392Nk0.d(C11458d25.r(((Number) it.next()).longValue()).getPeerId()));
                    }
                    this.b = 1;
                    if (interfaceC4308Eo5.f(arrayList, true, this) == objE) {
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
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24904zP1.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C24904zP1 c24904zP1 = C24904zP1.this;
                InterfaceC4557Fq2 interfaceC4557Fq2W = c24904zP1.w(AbstractC6459Nq2.s(c24904zP1.p, 100L), C24904zP1.this.e);
                a aVar = new a(C24904zP1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2W, aVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zP1$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zP1$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C24904zP1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24904zP1 c24904zP1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c24904zP1;
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
                Map map = (Map) this.c;
                boolean z = !map.isEmpty();
                CopyOnWriteArrayList<a> copyOnWriteArrayList = this.d.n;
                C24904zP1 c24904zP1 = this.d;
                for (a aVar : copyOnWriteArrayList) {
                    aVar.i(z && map.containsKey(AP1.b(c24904zP1.a, aVar.d())), z);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(map, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24904zP1.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6 = C24904zP1.this.c;
                a aVar = new a(C24904zP1.this, null);
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zP1$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zP1$k$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C24904zP1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C24904zP1 c24904zP1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c24904zP1;
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
                Map map = (Map) this.c;
                for (a aVar : this.d.n) {
                    aVar.e((EnumC18228oI7) map.get(AbstractC6392Nk0.e(aVar.d())));
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(map, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24904zP1.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6 = C24904zP1.this.d;
                a aVar = new a(C24904zP1.this, null);
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zP1$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zP1$l$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C24904zP1 a;

            a(C24904zP1 c24904zP1) {
                this.a = c24904zP1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                for (a aVar : this.a.n) {
                    SP1 sp1 = (SP1) map.get(AbstractC6392Nk0.e(aVar.d()));
                    if (sp1 != null) {
                        aVar.f(sp1);
                    }
                }
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.zP1$l$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.zP1$l$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.zP1$l$b$a$a, reason: collision with other inner class name */
                public static final class C1815a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1815a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.C24904zP1.l.b.a.C1815a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.zP1$l$b$a$a r0 = (ir.nasim.C24904zP1.l.b.a.C1815a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.zP1$l$b$a$a r0 = new ir.nasim.zP1$l$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        java.util.Map r2 = (java.util.Map) r2
                        boolean r2 = r2.isEmpty()
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L49
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24904zP1.l.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24904zP1.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(C24904zP1.this.k.f());
                a aVar = new a(C24904zP1.this);
                this.b = 1;
                if (bVar.b(aVar, this) == objE) {
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C24904zP1(int i2, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, int i3, AbstractC13778go1 abstractC13778go1, InterfaceC4308Eo5 interfaceC4308Eo5, InterfaceC5943Lm5 interfaceC5943Lm5, InterfaceC11621dJ7 interfaceC11621dJ7, Context context, TP1 tp1, GL1.a aVar) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(interfaceC10258bL6, "selectedDialogs");
        AbstractC13042fc3.i(interfaceC10258bL62, "userActivityState");
        AbstractC13042fc3.i(abstractC13778go1, "defaultDispatcher");
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        AbstractC13042fc3.i(interfaceC5943Lm5, "premiumRepository");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(tp1, "updatesProvider");
        AbstractC13042fc3.i(aVar, "avatarAttributeObserverFactory");
        this.a = i2;
        this.b = interfaceC20315ro1;
        this.c = interfaceC10258bL6;
        this.d = interfaceC10258bL62;
        this.e = i3;
        this.f = abstractC13778go1;
        this.g = interfaceC4308Eo5;
        this.h = interfaceC5943Lm5;
        this.i = interfaceC11621dJ7;
        this.j = context;
        this.k = tp1;
        this.l = aVar;
        this.m = new HashMap();
        this.n = new CopyOnWriteArrayList();
        this.p = AbstractC12281eL6.a(AbstractC20051rO3.k());
        this.q = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 A(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new g(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 B(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new h(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 C(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new i(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 D(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new j(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 E(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new k(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 F(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new l(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(C24904zP1 c24904zP1, a aVar, DialogDTO dialogDTO, Avatar avatar) {
        String userName;
        AbstractC13042fc3.i(c24904zP1, "this$0");
        AbstractC13042fc3.i(aVar, "$adapter");
        AbstractC13042fc3.i(dialogDTO, "$dialog");
        SP1 sp1 = (SP1) ((Map) c24904zP1.k.f().getValue()).get(Long.valueOf(aVar.d()));
        if (sp1 == null || (userName = sp1.j()) == null) {
            userName = dialogDTO.getUserName();
        }
        aVar.h(dialogDTO, avatar, userName);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC4557Fq2 w(InterfaceC4557Fq2 interfaceC4557Fq2, int i2) {
        return new d(interfaceC4557Fq2, i2);
    }

    private final b x(long j2) {
        Map map = (Map) this.c.getValue();
        boolean z = !map.isEmpty();
        return new b(z && map.containsKey(AP1.b(this.a, j2)), z, (EnumC18228oI7) ((Map) this.d.getValue()).get(Long.valueOf(j2)), (SP1) ((Map) this.k.f().getValue()).get(Long.valueOf(j2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 y(InterfaceC20315ro1 interfaceC20315ro1) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new e(null), 3, null);
    }

    private final InterfaceC13730gj3 z() {
        return AbstractC10533bm0.d(this.b, null, null, new f(null), 3, null);
    }

    public final void G(final DialogDTO dialogDTO, final a aVar) {
        int peerId;
        AbstractC13042fc3.i(dialogDTO, "dialog");
        AbstractC13042fc3.i(aVar, "adapter");
        this.n.add(aVar);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.n;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(copyOnWriteArrayList, 10)), 16));
        for (a aVar2 : copyOnWriteArrayList) {
            XV4 xv4A = AbstractC4616Fw7.a(Long.valueOf(aVar2.d()), aVar2.z());
            linkedHashMap.put(xv4A.e(), xv4A.f());
        }
        interfaceC9336Zm4.setValue(linkedHashMap);
        aVar.g(x(aVar.d()));
        SP1 sp1 = (SP1) ((Map) this.k.f().getValue()).get(Long.valueOf(aVar.d()));
        if (sp1 != null) {
            aVar.f(sp1);
        }
        if (C8386Vt0.a.n9() && aVar.z() == ExPeerType.PRIVATE && (peerId = C11458d25.r(aVar.d()).getPeerId()) != this.e) {
            String str = (String) this.q.get(Integer.valueOf(peerId));
            if (str != null) {
                aVar.c(str);
            } else {
                aVar.c(null);
            }
        }
        HashMap map = this.m;
        Long lValueOf = Long.valueOf(dialogDTO.getPeerUniqueId());
        Object linkedHashSet = map.get(lValueOf);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
            map.put(lValueOf, linkedHashSet);
        }
        AL1 al1A = this.l.a(dialogDTO, new UA2() { // from class: ir.nasim.yP1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C24904zP1.H(this.a, aVar, dialogDTO, (Avatar) obj);
            }
        });
        al1A.c();
        ((Set) linkedHashSet).add(al1A);
    }

    public final void I() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.o;
        if (interfaceC13730gj3 == null || !interfaceC13730gj3.b()) {
            this.o = z();
        }
    }

    public final void J() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.o;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.o = null;
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
        this.n.clear();
        this.q.clear();
    }

    public final void K(a aVar) {
        AbstractC13042fc3.i(aVar, "adapter");
        this.n.remove(aVar);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.n;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(copyOnWriteArrayList, 10)), 16));
        for (a aVar2 : copyOnWriteArrayList) {
            XV4 xv4A = AbstractC4616Fw7.a(Long.valueOf(aVar2.d()), aVar2.z());
            linkedHashMap.put(xv4A.e(), xv4A.f());
        }
        interfaceC9336Zm4.setValue(linkedHashMap);
        aVar.b();
        Set set = (Set) this.m.remove(Long.valueOf(aVar.d()));
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                ((AL1) it.next()).a();
            }
        }
    }
}
