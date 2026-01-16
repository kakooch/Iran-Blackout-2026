package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.Q12;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.entity.ContactEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.lj1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16701lj1 implements InterfaceC6118Mg1 {
    private final AbstractC7311Re1 b;
    private final C8054Ui1 c;
    private final InterfaceC20315ro1 d;
    private final AbstractC13778go1 e;

    /* renamed from: ir.nasim.lj1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16701lj1.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC7311Re1 abstractC7311Re1 = C16701lj1.this.b;
                this.b = 1;
                if (abstractC7311Re1.a(this) == objE) {
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

    /* renamed from: ir.nasim.lj1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ EnumC4715Gg1 c;
        final /* synthetic */ C16701lj1 d;
        final /* synthetic */ String e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        /* renamed from: ir.nasim.lj1$b$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC4715Gg1.values().length];
                try {
                    iArr[EnumC4715Gg1.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC4715Gg1.d.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EnumC4715Gg1 enumC4715Gg1, C16701lj1 c16701lj1, String str, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = enumC4715Gg1;
            this.d = c16701lj1;
            this.e = str;
            this.f = i;
            this.g = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE;
            Object objD;
            Object objE2 = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    objE = obj;
                    return (List) objE;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = obj;
                return (List) objD;
            }
            AbstractC10685c16.b(obj);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Q12.a aVar = Q12.b;
            long jA = jCurrentTimeMillis - Q12.A(T12.s(30, W12.h));
            int i2 = a.a[this.c.ordinal()];
            if (i2 == 1) {
                AbstractC7311Re1 abstractC7311Re1 = this.d.b;
                String str = this.e;
                String str2 = str != null ? str : "";
                int i3 = this.f;
                int i4 = this.g;
                this.b = 1;
                objE = abstractC7311Re1.e(str2, i3, i4, this);
                if (objE == objE2) {
                    return objE2;
                }
                return (List) objE;
            }
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC7311Re1 abstractC7311Re12 = this.d.b;
            String str3 = this.e;
            if (str3 == null) {
                str3 = "";
            }
            int i5 = this.f;
            int i6 = this.g;
            this.b = 2;
            objD = abstractC7311Re12.d(str3, i5, i6, jA, this);
            if (objD == objE2) {
                return objE2;
            }
            return (List) objD;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lj1$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16701lj1.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.d(C16701lj1.this.b.b());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lj1$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C16701lj1.this.c(0, 0, this);
        }
    }

    /* renamed from: ir.nasim.lj1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16701lj1.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC7311Re1 abstractC7311Re1 = C16701lj1.this.b;
                List<C3512Be1> list = this.d;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (C3512Be1 c3512Be1 : list) {
                    int iR = c3512Be1.r();
                    String name = c3512Be1.getName();
                    AbstractC13042fc3.h(name, "getName(...)");
                    boolean zS = c3512Be1.s();
                    long j = c3512Be1.j();
                    Avatar avatarQ = c3512Be1.q();
                    arrayList.add(new ContactEntity(iR, name, zS, j, avatarQ != null ? avatarQ.toByteArray() : null));
                }
                this.b = 1;
                if (abstractC7311Re1.h(arrayList, this) == objE) {
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

    public C16701lj1(AbstractC7311Re1 abstractC7311Re1, C8054Ui1 c8054Ui1, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(abstractC7311Re1, "contactDao");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = abstractC7311Re1;
        this.c = c8054Ui1;
        this.d = interfaceC20315ro1;
        this.e = abstractC13778go1;
    }

    @Override // ir.nasim.InterfaceC6118Mg1
    public Object a(String str, EnumC4715Gg1 enumC4715Gg1, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new b(enumC4715Gg1, this, str, i, i2, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC6118Mg1
    public void b() {
        AbstractC10533bm0.d(this.d, null, null, new a(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC6118Mg1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(int r5, int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.nasim.C16701lj1.d
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.lj1$d r0 = (ir.nasim.C16701lj1.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.lj1$d r0 = new ir.nasim.lj1$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L42
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.Re1 r7 = r4.b
            int r6 = r6 - r5
            r0.c = r3
            java.lang.String r2 = ""
            java.lang.Object r7 = r7.e(r2, r5, r6, r0)
            if (r7 != r1) goto L42
            return r1
        L42:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = ir.nasim.ZW0.x(r7, r6)
            r5.<init>(r6)
            java.util.Iterator r6 = r7.iterator()
        L53:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L6b
            java.lang.Object r7 = r6.next()
            ir.nasim.database.entity.ContactEntity r7 = (ir.nasim.database.entity.ContactEntity) r7
            int r7 = r7.getId()
            java.lang.Integer r7 = ir.nasim.AbstractC6392Nk0.d(r7)
            r5.add(r7)
            goto L53
        L6b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16701lj1.c(int, int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC6118Mg1
    public int d() {
        return ((Number) AbstractC9323Zl0.e(this.e, new c(null))).intValue();
    }

    @Override // ir.nasim.InterfaceC6118Mg1
    public void e(List list) {
        AbstractC13042fc3.i(list, "registeredContacts");
        AbstractC10533bm0.d(this.d, this.e, null, new e(list, null), 2, null);
    }
}
