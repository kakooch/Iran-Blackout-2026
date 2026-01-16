package ir.nasim;

import ai.bale.proto.MessagingOuterClass$ResponseLoadFolders;
import ai.bale.proto.MessagingStruct$Folder;
import ai.bale.proto.MessagingStruct$UnreadPeer;
import ai.bale.proto.PeersStruct$ExPeer;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogFolderAssociationEntity;
import ir.nasim.database.dailogLists.DialogFolderEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ir.nasim.Ms2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6227Ms2 implements InterfaceC24010xt2 {
    private final ir.nasim.database.dailogLists.c b;
    private final C5760Ks2 c;
    private final InterfaceC9145Yr2 d;
    private final InterfaceC14123hO3 e;
    private final InterfaceC20667sP1 f;
    private final InterfaceC11621dJ7 g;
    private final KM2 h;
    private final AbstractC13778go1 i;
    private final E84 j;
    private final InterfaceC3570Bk5 k;
    private final int l;
    private final QB7 m;

    /* renamed from: ir.nasim.Ms2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ F92 a = G92.a(EnumC7296Rc4.values());
    }

    /* renamed from: ir.nasim.Ms2$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[W25.values().length];
            try {
                iArr2[W25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[W25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[W25.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.Ms2$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C6227Ms2.this.a(null, null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.Ms2$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objP = C6227Ms2.this.p(0, this);
            return objP == AbstractC14862ic3.e() ? objP : C9475a16.a(objP);
        }
    }

    /* renamed from: ir.nasim.Ms2$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objM = C6227Ms2.this.m(0, this);
            return objM == AbstractC14862ic3.e() ? objM : C9475a16.a(objM);
        }
    }

    /* renamed from: ir.nasim.Ms2$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        int e;
        /* synthetic */ Object f;
        int h;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            Object objQ = C6227Ms2.this.q(0, null, null, null, this);
            return objQ == AbstractC14862ic3.e() ? objQ : C9475a16.a(objQ);
        }
    }

    /* renamed from: ir.nasim.Ms2$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C6227Ms2.this.e(this);
        }
    }

    /* renamed from: ir.nasim.Ms2$h */
    public static final class h implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C6227Ms2 b;

        /* renamed from: ir.nasim.Ms2$h$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C6227Ms2 b;

            /* renamed from: ir.nasim.Ms2$h$a$a, reason: collision with other inner class name */
            public static final class C0512a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;
                Object e;
                Object f;
                Object g;

                public C0512a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C6227Ms2 c6227Ms2) {
                this.a = interfaceC4806Gq2;
                this.b = c6227Ms2;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0081 -> B:22:0x0084). Please report as a decompilation issue!!! */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r10, ir.nasim.InterfaceC20295rm1 r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof ir.nasim.C6227Ms2.h.a.C0512a
                    if (r0 == 0) goto L13
                    r0 = r11
                    ir.nasim.Ms2$h$a$a r0 = (ir.nasim.C6227Ms2.h.a.C0512a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ms2$h$a$a r0 = new ir.nasim.Ms2$h$a$a
                    r0.<init>(r11)
                L18:
                    java.lang.Object r11 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L49
                    if (r2 == r4) goto L35
                    if (r2 != r3) goto L2d
                    ir.nasim.AbstractC10685c16.b(r11)
                    goto La0
                L2d:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L35:
                    java.lang.Object r10 = r0.g
                    java.util.Iterator r10 = (java.util.Iterator) r10
                    java.lang.Object r2 = r0.f
                    java.util.Collection r2 = (java.util.Collection) r2
                    java.lang.Object r5 = r0.e
                    ir.nasim.Gq2 r5 = (ir.nasim.InterfaceC4806Gq2) r5
                    java.lang.Object r6 = r0.c
                    ir.nasim.Ms2$h$a r6 = (ir.nasim.C6227Ms2.h.a) r6
                    ir.nasim.AbstractC10685c16.b(r11)
                    goto L84
                L49:
                    ir.nasim.AbstractC10685c16.b(r11)
                    ir.nasim.Gq2 r11 = r9.a
                    java.util.List r10 = (java.util.List) r10
                    java.lang.Iterable r10 = (java.lang.Iterable) r10
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Iterator r10 = r10.iterator()
                    r6 = r9
                    r5 = r11
                L5d:
                    boolean r11 = r10.hasNext()
                    if (r11 == 0) goto L8c
                    java.lang.Object r11 = r10.next()
                    java.lang.Number r11 = (java.lang.Number) r11
                    long r7 = r11.longValue()
                    ir.nasim.Ms2 r11 = r6.b
                    ir.nasim.Yr2 r11 = ir.nasim.C6227Ms2.t(r11)
                    r0.c = r6
                    r0.e = r5
                    r0.f = r2
                    r0.g = r10
                    r0.b = r4
                    java.lang.Object r11 = r11.e(r7, r0)
                    if (r11 != r1) goto L84
                    return r1
                L84:
                    ir.nasim.RM1 r11 = (ir.nasim.RM1) r11
                    if (r11 == 0) goto L5d
                    r2.add(r11)
                    goto L5d
                L8c:
                    java.util.List r2 = (java.util.List) r2
                    r10 = 0
                    r0.c = r10
                    r0.e = r10
                    r0.f = r10
                    r0.g = r10
                    r0.b = r3
                    java.lang.Object r10 = r5.a(r2, r0)
                    if (r10 != r1) goto La0
                    return r1
                La0:
                    ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.h.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public h(InterfaceC4557Fq2 interfaceC4557Fq2, C6227Ms2 c6227Ms2) {
            this.a = interfaceC4557Fq2;
            this.b = c6227Ms2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ms2$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6227Ms2.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ir.nasim.database.dailogLists.c cVar = C6227Ms2.this.b;
                this.b = 1;
                obj = cVar.B(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (Iterable) obj) {
                if (((DialogFolderEntity) obj2).getId() != 11) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : arrayList) {
                DialogFolderEntity dialogFolderEntity = (DialogFolderEntity) obj3;
                if (C8386Vt0.a.Pb() || dialogFolderEntity.getId() != 10) {
                    arrayList2.add(obj3);
                }
            }
            C6227Ms2 c6227Ms2 = C6227Ms2.this;
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(c6227Ms2.d.b((DialogFolderEntity) it.next()));
            }
            return arrayList3;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ms2$j */
    public static final class j extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ C6227Ms2 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(InterfaceC20295rm1 interfaceC20295rm1, C6227Ms2 c6227Ms2, boolean z) {
            super(3, interfaceC20295rm1);
            this.e = c6227Ms2;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                l lVar = new l(this.e.b.q(this.f), this.e);
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, lVar, this) == objE) {
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
            j jVar = new j(interfaceC20295rm1, this.e, this.f);
            jVar.c = interfaceC4806Gq2;
            jVar.d = obj;
            return jVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ms2$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = C6227Ms2.this.new k(this.h, interfaceC20295rm1);
            kVar.f = obj;
            return kVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x010f A[LOOP:0: B:41:0x0109->B:43:0x010f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x012b A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 303
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ms2$l */
    public static final class l implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C6227Ms2 b;

        /* renamed from: ir.nasim.Ms2$l$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C6227Ms2 b;

            /* renamed from: ir.nasim.Ms2$l$a$a, reason: collision with other inner class name */
            public static final class C0513a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0513a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C6227Ms2 c6227Ms2) {
                this.a = interfaceC4806Gq2;
                this.b = c6227Ms2;
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
                    boolean r0 = r8 instanceof ir.nasim.C6227Ms2.l.a.C0513a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.Ms2$l$a$a r0 = (ir.nasim.C6227Ms2.l.a.C0513a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Ms2$l$a$a r0 = new ir.nasim.Ms2$l$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L6c
                L29:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L31:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    java.util.List r7 = (java.util.List) r7
                    java.lang.Iterable r7 = (java.lang.Iterable) r7
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r4 = 10
                    int r4 = ir.nasim.ZW0.x(r7, r4)
                    r2.<init>(r4)
                    java.util.Iterator r7 = r7.iterator()
                L49:
                    boolean r4 = r7.hasNext()
                    if (r4 == 0) goto L63
                    java.lang.Object r4 = r7.next()
                    ir.nasim.database.dailogLists.DialogFolderEntity r4 = (ir.nasim.database.dailogLists.DialogFolderEntity) r4
                    ir.nasim.Ms2 r5 = r6.b
                    ir.nasim.Yr2 r5 = ir.nasim.C6227Ms2.t(r5)
                    ir.nasim.Xr2 r4 = r5.b(r4)
                    r2.add(r4)
                    goto L49
                L63:
                    r0.b = r3
                    java.lang.Object r7 = r8.a(r2, r0)
                    if (r7 != r1) goto L6c
                    return r1
                L6c:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.l.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public l(InterfaceC4557Fq2 interfaceC4557Fq2, C6227Ms2 c6227Ms2) {
            this.a = interfaceC4557Fq2;
            this.b = c6227Ms2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ms2$m */
    static final class m extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objD = C6227Ms2.this.D(this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.Ms2$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6227Ms2.this.new n(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0102  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 267
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.n.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ms2$o */
    static final class o extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C6227Ms2.this.i(0, this);
        }
    }

    /* renamed from: ir.nasim.Ms2$p */
    static final class p extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objD = C6227Ms2.this.d(this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.Ms2$q */
    static final class q extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C6227Ms2.this.g(null, this);
        }
    }

    /* renamed from: ir.nasim.Ms2$r */
    static final class r extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C6227Ms2.this.F(null, this);
        }
    }

    /* renamed from: ir.nasim.Ms2$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MessagingOuterClass$ResponseLoadFolders d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(MessagingOuterClass$ResponseLoadFolders messagingOuterClass$ResponseLoadFolders, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = messagingOuterClass$ResponseLoadFolders;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6227Ms2.this.new s(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ir.nasim.database.dailogLists.c cVar = C6227Ms2.this.b;
                C7681St2 c7681St2E = C6227Ms2.this.J(this.d).e(C6227Ms2.this.E());
                this.b = 1;
                if (cVar.K(c7681St2E, this) == objE) {
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
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ms2$t */
    static final class t extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        t(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C6227Ms2.this.f(null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.Ms2$u */
    static final class u extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        u(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C6227Ms2.this.b(this);
        }
    }

    public C6227Ms2(ir.nasim.database.dailogLists.c cVar, C5760Ks2 c5760Ks2, InterfaceC9145Yr2 interfaceC9145Yr2, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC20667sP1 interfaceC20667sP1, InterfaceC11621dJ7 interfaceC11621dJ7, KM2 km2, AbstractC13778go1 abstractC13778go1, E84 e84, InterfaceC3570Bk5 interfaceC3570Bk5, int i2, QB7 qb7) {
        AbstractC13042fc3.i(cVar, "dialogFolderDao");
        AbstractC13042fc3.i(c5760Ks2, "folderRemoteDataSource");
        AbstractC13042fc3.i(interfaceC9145Yr2, "folderDTOConverter");
        AbstractC13042fc3.i(interfaceC14123hO3, "structExPeerTypeToExPeerType");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(qb7, "unreadPeerMapper");
        this.b = cVar;
        this.c = c5760Ks2;
        this.d = interfaceC9145Yr2;
        this.e = interfaceC14123hO3;
        this.f = interfaceC20667sP1;
        this.g = interfaceC11621dJ7;
        this.h = km2;
        this.i = abstractC13778go1;
        this.j = e84;
        this.k = interfaceC3570Bk5;
        this.l = i2;
        this.m = qb7;
    }

    private final List A(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((DialogFolderEntity) it.next()).getId()));
        }
        F92 f92 = a.a;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : f92) {
            if (!AbstractC4597Fu6.i(EnumC7296Rc4.ReservedFolderID_ARCHIVED, EnumC7296Rc4.UNRECOGNIZED, EnumC7296Rc4.ReservedFolderID_ALL).contains((EnumC7296Rc4) obj)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!arrayList.contains(Integer.valueOf(((EnumC7296Rc4) obj2).getNumber()))) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(AbstractC10976cX0.x(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(this.d.f((EnumC7296Rc4) it2.next(), false));
        }
        return AbstractC15401jX0.R0(list, arrayList4);
    }

    private final List B() {
        F92 f92 = a.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : f92) {
            if (!AbstractC4597Fu6.i(EnumC7296Rc4.UNRECOGNIZED, EnumC7296Rc4.ReservedFolderID_ARCHIVED).contains((EnumC7296Rc4) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            EnumC7296Rc4 enumC7296Rc4 = (EnumC7296Rc4) obj2;
            if (C8386Vt0.a.Pb() || enumC7296Rc4 != EnumC7296Rc4.ReservedFolderID_UNREAD) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Integer.valueOf(((EnumC7296Rc4) it.next()).getNumber()));
        }
        return arrayList3;
    }

    private final List C(List list, int i2) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new DialogFolderAssociationEntity(((Number) it.next()).longValue(), i2, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List E() {
        CopyOnWriteArrayList copyOnWriteArrayListQ = this.j.N0().q();
        AbstractC13042fc3.h(copyOnWriteArrayListQ, "getGroups(...)");
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayListQ.iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList<C25254zz6> copyOnWriteArrayListQ2 = ((C15913kO2) it.next()).q();
            AbstractC13042fc3.h(copyOnWriteArrayListQ2, "getShortDialogs(...)");
            ArrayList arrayList2 = new ArrayList();
            for (C25254zz6 c25254zz6 : copyOnWriteArrayListQ2) {
                ExPeerType exPeerType = c25254zz6.getExPeerType();
                int i2 = exPeerType == null ? -1 : b.a[exPeerType.ordinal()];
                List listP = null;
                Integer num = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : 4 : 3 : 2 : 1;
                if (num != null) {
                    int iIntValue = num.intValue();
                    long jU = c25254zz6.w().u();
                    listP = AbstractC10360bX0.p(new DialogFolderAssociationEntity(jU, iIntValue, null, 4, null), new DialogFolderAssociationEntity(jU, 0, null, 4, null));
                }
                if (listP != null) {
                    arrayList2.add(listP);
                }
            }
            AbstractC13610gX0.D(arrayList, AbstractC10976cX0.z(arrayList2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(java.util.List r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.F(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    private final List G(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(new C11458d25((ExPeer) it.next()).u()));
        }
        return arrayList;
    }

    private final List H(List list) {
        List<PeersStruct$ExPeer> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (PeersStruct$ExPeer peersStruct$ExPeer : list2) {
            InterfaceC14123hO3 interfaceC14123hO3 = this.e;
            EnumC10088b35 type = peersStruct$ExPeer.getType();
            AbstractC13042fc3.h(type, "getType(...)");
            arrayList.add(Long.valueOf(new C11458d25(new ExPeer((ExPeerType) interfaceC14123hO3.a(type), peersStruct$ExPeer.getId())).u()));
        }
        return arrayList;
    }

    private final Set I(MessagingStruct$UnreadPeer messagingStruct$UnreadPeer) {
        Set setB = AbstractC4363Eu6.b();
        InterfaceC14123hO3 interfaceC14123hO3 = this.e;
        EnumC10088b35 type = messagingStruct$UnreadPeer.getPeer().getType();
        AbstractC13042fc3.h(type, "getType(...)");
        ExPeer exPeer = new ExPeer((ExPeerType) interfaceC14123hO3.a(type), messagingStruct$UnreadPeer.getPeer().getId());
        long jU = new C11458d25(exPeer).u();
        setB.add(new DialogFolderAssociationEntity(jU, 0, null, 4, null));
        ExPeerType exPeerType = exPeer.getExPeerType();
        int i2 = exPeerType == null ? -1 : b.a[exPeerType.ordinal()];
        Integer num = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : 4 : 3 : 2 : 1;
        if (num != null) {
            setB.add(new DialogFolderAssociationEntity(jU, num.intValue(), null, 4, null));
        }
        return AbstractC4363Eu6.a(setB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C7681St2 J(MessagingOuterClass$ResponseLoadFolders messagingOuterClass$ResponseLoadFolders) {
        List<MessagingStruct$Folder> foldersList = messagingOuterClass$ResponseLoadFolders.getFoldersList();
        AbstractC13042fc3.h(foldersList, "getFoldersList(...)");
        List<MessagingStruct$Folder> list = foldersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            MessagingStruct$Folder messagingStruct$Folder = (MessagingStruct$Folder) obj;
            InterfaceC9145Yr2 interfaceC9145Yr2 = this.d;
            AbstractC13042fc3.f(messagingStruct$Folder);
            arrayList.add(interfaceC9145Yr2.d(messagingStruct$Folder, i2, true));
            i2 = i3;
        }
        List listA = A(arrayList);
        Set setB = AbstractC4363Eu6.b();
        List<MessagingStruct$Folder> foldersList2 = messagingOuterClass$ResponseLoadFolders.getFoldersList();
        AbstractC13042fc3.h(foldersList2, "getFoldersList(...)");
        for (MessagingStruct$Folder messagingStruct$Folder2 : foldersList2) {
            List<PeersStruct$ExPeer> peersList = messagingStruct$Folder2.getPeersList();
            AbstractC13042fc3.h(peersList, "getPeersList(...)");
            setB.addAll(C(H(peersList), messagingStruct$Folder2.getId()));
        }
        List<MessagingStruct$UnreadPeer> unreadPeersList = messagingOuterClass$ResponseLoadFolders.getUnreadPeersList();
        AbstractC13042fc3.h(unreadPeersList, "getUnreadPeersList(...)");
        for (MessagingStruct$UnreadPeer messagingStruct$UnreadPeer : unreadPeersList) {
            AbstractC13042fc3.f(messagingStruct$UnreadPeer);
            setB.addAll(I(messagingStruct$UnreadPeer));
        }
        return new C7681St2(listA, AbstractC15401jX0.m1(AbstractC15401jX0.q1(AbstractC4363Eu6.a(setB))));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object D(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C6227Ms2.m
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Ms2$m r0 = (ir.nasim.C6227Ms2.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ms2$m r0 = new ir.nasim.Ms2$m
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.i
            ir.nasim.Ms2$n r2 = new ir.nasim.Ms2$n
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.D(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0116 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r21, java.util.List r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.a(java.lang.String, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.InterfaceC20295rm1 r20) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.b(ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC24010xt2
    public InterfaceC4557Fq2 c() {
        return this.b.y(C8386Vt0.I3());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C6227Ms2.p
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.Ms2$p r0 = (ir.nasim.C6227Ms2.p) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Ms2$p r0 = new ir.nasim.Ms2$p
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.Ks2 r5 = r4.c
            r0.c = r3
            java.lang.Object r5 = r5.l(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.d(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C6227Ms2.g
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Ms2$g r0 = (ir.nasim.C6227Ms2.g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Ms2$g r0 = new ir.nasim.Ms2$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.Ms2 r0 = (ir.nasim.C6227Ms2) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L48
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.database.dailogLists.c r6 = r5.b
            r0.a = r5
            r0.d = r3
            r2 = 0
            r4 = 0
            java.lang.Object r6 = ir.nasim.database.dailogLists.c.p(r6, r2, r0, r3, r4)
            if (r6 != r1) goto L47
            return r1
        L47:
            r0 = r5
        L48:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = ir.nasim.ZW0.x(r6, r2)
            r1.<init>(r2)
            java.util.Iterator r6 = r6.iterator()
        L59:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L6f
            java.lang.Object r2 = r6.next()
            ir.nasim.database.dailogLists.DialogFolderEntity r2 = (ir.nasim.database.dailogLists.DialogFolderEntity) r2
            ir.nasim.Yr2 r3 = r0.d
            ir.nasim.Xr2 r2 = r3.b(r2)
            r1.add(r2)
            goto L59
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.e(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C6227Ms2.t
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Ms2$t r0 = (ir.nasim.C6227Ms2.t) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Ms2$t r0 = new ir.nasim.Ms2$t
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r7 = r0.a
            ir.nasim.AbstractC10685c16.b(r8)
            goto L84
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            java.lang.Object r7 = r0.a
            ir.nasim.Ms2 r7 = (ir.nasim.C6227Ms2) r7
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r8 = r8.l()
            r5 = r8
            r8 = r7
            r7 = r5
            goto L6e
        L47:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.Rc4 r8 = ir.nasim.EnumC7296Rc4.ReservedFolderID_ALL
            int r8 = r8.getNumber()
            java.lang.Integer r8 = ir.nasim.AbstractC6392Nk0.d(r8)
            java.util.List r8 = ir.nasim.ZW0.e(r8)
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r7 = ir.nasim.ZW0.R0(r8, r7)
            ir.nasim.Ks2 r8 = r6.c
            r0.a = r6
            r0.d = r4
            java.lang.Object r7 = r8.m(r7, r0)
            if (r7 != r1) goto L6d
            return r1
        L6d:
            r8 = r6
        L6e:
            boolean r2 = ir.nasim.C9475a16.j(r7)
            if (r2 == 0) goto L84
            r2 = r7
            java.util.List r2 = (java.util.List) r2
            ir.nasim.database.dailogLists.c r8 = r8.b
            r0.a = r7
            r0.d = r3
            java.lang.Object r8 = r8.N(r2, r0)
            if (r8 != r1) goto L84
            return r1
        L84:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.f(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0088 -> B:26:0x008b). Please report as a decompilation issue!!! */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(java.util.List r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.C6227Ms2.q
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.Ms2$q r0 = (ir.nasim.C6227Ms2.q) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.Ms2$q r0 = new ir.nasim.Ms2$q
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r8 = r0.c
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r2 = r0.b
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.a
            ir.nasim.Ms2 r4 = (ir.nasim.C6227Ms2) r4
            ir.nasim.AbstractC10685c16.b(r9)
            goto L8b
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            java.lang.Object r8 = r0.b
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r2 = r0.a
            ir.nasim.Ms2 r2 = (ir.nasim.C6227Ms2) r2
            ir.nasim.AbstractC10685c16.b(r9)
            goto L5d
        L4c:
            ir.nasim.AbstractC10685c16.b(r9)
            r0.a = r7
            r0.b = r8
            r0.f = r4
            java.lang.Object r9 = r7.F(r8, r0)
            if (r9 != r1) goto L5c
            return r1
        L5c:
            r2 = r7
        L5d:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r8 = r8.iterator()
            r4 = r2
            r2 = r9
        L6a:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L93
            java.lang.Object r9 = r8.next()
            java.lang.Number r9 = (java.lang.Number) r9
            long r5 = r9.longValue()
            ir.nasim.Yr2 r9 = r4.d
            r0.a = r4
            r0.b = r2
            r0.c = r8
            r0.f = r3
            java.lang.Object r9 = r9.e(r5, r0)
            if (r9 != r1) goto L8b
            return r1
        L8b:
            ir.nasim.RM1 r9 = (ir.nasim.RM1) r9
            if (r9 == 0) goto L6a
            r2.add(r9)
            goto L6a
        L93:
            java.util.List r2 = (java.util.List) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.g(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC24010xt2
    public Object h(MessagingOuterClass$ResponseLoadFolders messagingOuterClass$ResponseLoadFolders, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new s(messagingOuterClass$ResponseLoadFolders, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008a -> B:26:0x008d). Please report as a decompilation issue!!! */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(int r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ir.nasim.C6227Ms2.o
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.Ms2$o r0 = (ir.nasim.C6227Ms2.o) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.Ms2$o r0 = new ir.nasim.Ms2$o
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.d
            java.lang.Object r8 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r0.f
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L48
            if (r1 == r2) goto L40
            if (r1 != r9) goto L38
            java.lang.Object r11 = r0.c
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r1 = r0.b
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r2 = r0.a
            ir.nasim.Ms2 r2 = (ir.nasim.C6227Ms2) r2
            ir.nasim.AbstractC10685c16.b(r12)
            goto L8d
        L38:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L40:
            java.lang.Object r11 = r0.a
            ir.nasim.Ms2 r11 = (ir.nasim.C6227Ms2) r11
            ir.nasim.AbstractC10685c16.b(r12)
            goto L5f
        L48:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.database.dailogLists.c r1 = r10.b
            r0.a = r10
            r0.f = r2
            r3 = 0
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r11
            r5 = r0
            java.lang.Object r12 = ir.nasim.database.dailogLists.c.u(r1, r2, r3, r4, r5, r6, r7)
            if (r12 != r8) goto L5e
            return r8
        L5e:
            r11 = r10
        L5f:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r12 = r12.iterator()
            r2 = r11
            r11 = r12
        L6c:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L95
            java.lang.Object r12 = r11.next()
            java.lang.Number r12 = (java.lang.Number) r12
            long r3 = r12.longValue()
            ir.nasim.Yr2 r12 = r2.d
            r0.a = r2
            r0.b = r1
            r0.c = r11
            r0.f = r9
            java.lang.Object r12 = r12.e(r3, r0)
            if (r12 != r8) goto L8d
            return r8
        L8d:
            ir.nasim.RM1 r12 = (ir.nasim.RM1) r12
            if (r12 == 0) goto L6c
            r1.add(r12)
            goto L6c
        L95:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.i(int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC24010xt2
    public InterfaceC4557Fq2 j(int i2) {
        return this.b.s(EnumC7296Rc4.ReservedFolderID_ARCHIVED.getNumber(), i2);
    }

    @Override // ir.nasim.InterfaceC24010xt2
    public InterfaceC4557Fq2 k(int i2) {
        return new h(this.b.H(i2), this);
    }

    @Override // ir.nasim.InterfaceC24010xt2
    public Object l(int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.b.x(i2, interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m(int r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C6227Ms2.e
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.Ms2$e r0 = (ir.nasim.C6227Ms2.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Ms2$e r0 = new ir.nasim.Ms2$e
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4e
            if (r2 == r5) goto L3b
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            goto L34
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            java.lang.Object r10 = r0.a
            ir.nasim.AbstractC10685c16.b(r11)
            goto Laf
        L3b:
            int r10 = r0.b
            java.lang.Object r2 = r0.a
            ir.nasim.Ms2 r2 = (ir.nasim.C6227Ms2) r2
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11
            java.lang.Object r11 = r11.l()
        L4a:
            r8 = r11
            r11 = r10
            r10 = r8
            goto L62
        L4e:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.Ks2 r11 = r9.c
            r0.a = r9
            r0.b = r10
            r0.e = r5
            java.lang.Object r11 = r11.g(r10, r0)
            if (r11 != r1) goto L60
            return r1
        L60:
            r2 = r9
            goto L4a
        L62:
            boolean r6 = ir.nasim.C9475a16.j(r10)
            if (r6 == 0) goto Laf
            r6 = r10
            ir.nasim.rB7 r6 = (ir.nasim.C19938rB7) r6
            java.util.List r6 = r2.B()
            java.lang.Integer r7 = ir.nasim.AbstractC6392Nk0.d(r11)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto La2
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.lang.String r6 = "action_type"
            java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
            r3.put(r6, r5)
            java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r11)
            java.lang.String r6 = "folder_id"
            r3.put(r6, r5)
            java.lang.String r5 = "disable_folder"
            ir.nasim.C3343Am.i(r5, r3)
            ir.nasim.database.dailogLists.c r2 = r2.b
            r0.a = r10
            r0.e = r4
            java.lang.Object r11 = r2.j(r11, r0)
            if (r11 != r1) goto Laf
            return r1
        La2:
            ir.nasim.database.dailogLists.c r2 = r2.b
            r0.a = r10
            r0.e = r3
            java.lang.Object r11 = r2.g(r11, r0)
            if (r11 != r1) goto Laf
            return r1
        Laf:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.m(int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC24010xt2
    public Object n(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.i, new i(null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC24010xt2
    public InterfaceC4557Fq2 o(boolean z) {
        return AbstractC6459Nq2.s0(AbstractC6459Nq2.R(new k(z, null)), new j(null, this, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object p(int r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C6227Ms2.d
            if (r0 == 0) goto L13
            r0 = r11
            ir.nasim.Ms2$d r0 = (ir.nasim.C6227Ms2.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Ms2$d r0 = new ir.nasim.Ms2$d
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L49
            if (r2 == r3) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r10 = r0.a
            ir.nasim.AbstractC10685c16.b(r11)
            goto L93
        L2e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L36:
            int r10 = r0.b
            java.lang.Object r2 = r0.a
            ir.nasim.Ms2 r2 = (ir.nasim.C6227Ms2) r2
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.a16 r11 = (ir.nasim.C9475a16) r11
            java.lang.Object r11 = r11.l()
        L45:
            r8 = r11
            r11 = r10
            r10 = r8
            goto L5d
        L49:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.Ks2 r11 = r9.c
            r0.a = r9
            r0.b = r10
            r0.e = r3
            java.lang.Object r11 = r11.f(r10, r0)
            if (r11 != r1) goto L5b
            return r1
        L5b:
            r2 = r9
            goto L45
        L5d:
            boolean r3 = ir.nasim.C9475a16.j(r10)
            if (r3 == 0) goto L93
            r3 = r10
            ai.bale.proto.MessagingOuterClass$ResponseCreateReservedFolder r3 = (ai.bale.proto.MessagingOuterClass$ResponseCreateReservedFolder) r3
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.lang.String r6 = "action_type"
            java.lang.Integer r7 = ir.nasim.AbstractC6392Nk0.d(r4)
            r5.put(r6, r7)
            java.lang.Integer r6 = ir.nasim.AbstractC6392Nk0.d(r11)
            java.lang.String r7 = "folder_id"
            r5.put(r7, r6)
            java.lang.String r6 = "disable_folder"
            ir.nasim.C3343Am.i(r6, r5)
            ir.nasim.database.dailogLists.c r2 = r2.b
            int r3 = r3.getIndex()
            r0.a = r10
            r0.e = r4
            java.lang.Object r11 = r2.T(r3, r11, r0)
            if (r11 != r1) goto L93
            return r1
        L93:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.p(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8 A[LOOP:0: B:29:0x00e2->B:31:0x00e8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ir.nasim.InterfaceC24010xt2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object q(int r17, java.lang.String r18, java.util.List r19, java.util.List r20, ir.nasim.InterfaceC20295rm1 r21) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6227Ms2.q(int, java.lang.String, java.util.List, java.util.List, ir.nasim.rm1):java.lang.Object");
    }
}
