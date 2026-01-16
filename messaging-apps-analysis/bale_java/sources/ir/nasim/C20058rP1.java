package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20044rN5;
import ir.nasim.UO1;
import ir.nasim.database.dailogLists.DialogFolderEntity;

/* renamed from: ir.nasim.rP1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20058rP1 extends AbstractC20044rN5 {
    private final int a;
    private final C12443ed3 b;
    private final InterfaceC20667sP1 c;
    private final InterfaceC6828Pd5 d;
    private final UO1.d.a e;

    /* renamed from: ir.nasim.rP1$a */
    public interface a {
        C20058rP1 a(int i, C12443ed3 c12443ed3);
    }

    /* renamed from: ir.nasim.rP1$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16433lG3.REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16433lG3.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.rP1$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        /* synthetic */ Object e;
        int g;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C20058rP1.this.h(null, null, 0, this);
        }
    }

    /* renamed from: ir.nasim.rP1$d */
    static final class d extends AbstractC19859r37 implements UA2 {
        int b;

        /* renamed from: ir.nasim.rP1$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C20058rP1 d;

            /* renamed from: ir.nasim.rP1$d$a$a, reason: collision with other inner class name */
            static final class C1496a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C20058rP1 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1496a(C20058rP1 c20058rP1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c20058rP1;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1496a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objB;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC6828Pd5 interfaceC6828Pd5 = this.c.d;
                        int i2 = this.c.a;
                        this.b = 1;
                        objB = interfaceC6828Pd5.b(i2, false, this);
                        if (objB == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        objB = ((C9475a16) obj).l();
                    }
                    return C9475a16.a(objB);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1496a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rP1$d$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C20058rP1 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C20058rP1 c20058rP1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c20058rP1;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objD;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC20667sP1 interfaceC20667sP1 = this.c.c;
                        int i2 = this.c.a;
                        this.b = 1;
                        objD = interfaceC20667sP1.D(i2, this);
                        if (objD == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        objD = ((C9475a16) obj).l();
                    }
                    return C9475a16.a(objD);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20058rP1 c20058rP1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20058rP1;
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
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    AbstractC10533bm0.b(interfaceC20315ro1, null, null, new C1496a(this.d, null), 3, null).start();
                    InterfaceC24823zG1 interfaceC24823zG1B = AbstractC10533bm0.b(interfaceC20315ro1, null, null, new b(this.d, null), 3, null);
                    this.b = 1;
                    obj = interfaceC24823zG1B.y(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return obj;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C20058rP1.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20058rP1.this.b.o();
                a aVar = new a(C20058rP1.this, null);
                this.b = 1;
                obj = AbstractC20906so1.e(aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Object objL = ((C9475a16) obj).l();
            C20058rP1.this.b.p();
            return C9475a16.a(objL);
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rP1$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C20058rP1.this.b(null, null, this);
        }
    }

    /* renamed from: ir.nasim.rP1$f */
    static final class f extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ ZT4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(long j, ZT4 zt4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = j;
            this.e = zt4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return C20058rP1.this.new f(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objY;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20667sP1 interfaceC20667sP1 = C20058rP1.this.c;
                long j = this.d;
                int i2 = C20058rP1.this.a;
                int i3 = this.e.d().a;
                this.b = 1;
                objY = interfaceC20667sP1.y(j, i2, i3, this);
                if (objY == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objY = ((C9475a16) obj).l();
            }
            return C9475a16.a(objY);
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C20058rP1(int i, C12443ed3 c12443ed3, InterfaceC20667sP1 interfaceC20667sP1, InterfaceC6828Pd5 interfaceC6828Pd5) {
        AbstractC13042fc3.i(c12443ed3, "invalidationTracker");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(interfaceC6828Pd5, "pinnedRepository");
        this.a = i;
        this.b = c12443ed3;
        this.c = interfaceC20667sP1;
        this.d = interfaceC6828Pd5;
        this.e = UO1.d.a.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r8, ir.nasim.UA2 r9, int r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20058rP1.h(java.lang.String, ir.nasim.UA2, int, ir.nasim.rm1):java.lang.Object");
    }

    private final Object i(InterfaceC20295rm1 interfaceC20295rm1) {
        return h("INIT", new d(null), 90, interfaceC20295rm1);
    }

    private final Object j(ZT4 zt4, DialogFolderEntity dialogFolderEntity, InterfaceC20295rm1 interfaceC20295rm1) {
        Long lE = dialogFolderEntity.getHasEndOfPaginationReached() ? AbstractC6392Nk0.e(0L) : dialogFolderEntity.getLastLoadedDate() == null ? AbstractC6392Nk0.e(Long.MAX_VALUE) : dialogFolderEntity.getLastLoadedDate();
        long jLongValue = lE != null ? lE.longValue() : Long.MAX_VALUE;
        return jLongValue == 0 ? new AbstractC20044rN5.b.C1495b(true) : h("APPEND", new f(jLongValue, zt4, null), zt4.d().a, interfaceC20295rm1);
    }

    @Override // ir.nasim.AbstractC20044rN5
    public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20044rN5.a.SKIP_INITIAL_REFRESH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r0v12, types: [ir.nasim.sP1] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [ir.nasim.rP1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v6, types: [ir.nasim.rP1] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [ir.nasim.rP1$e, ir.nasim.rm1] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v3, types: [ir.nasim.rP1] */
    /* JADX WARN: Type inference failed for: r3v5, types: [ir.nasim.rP1] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Override // ir.nasim.AbstractC20044rN5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.EnumC16433lG3 r17, ir.nasim.ZT4 r18, ir.nasim.InterfaceC20295rm1 r19) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20058rP1.b(ir.nasim.lG3, ir.nasim.ZT4, ir.nasim.rm1):java.lang.Object");
    }
}
