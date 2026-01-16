package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC19670qk5;
import java.util.Set;

/* loaded from: classes6.dex */
public final class CB7 {
    static final /* synthetic */ InterfaceC5239Im3[] c = {AbstractC10882cM5.j(new C3678Bw5(CB7.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};
    public static final int d = 8;
    private final InterfaceC23661xI5 a;
    private final InterfaceC23475wz1 b;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(interfaceC20295rm1);
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
            ((C4772Gm4) this.c).f();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class b implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.CB7$b$a$a, reason: collision with other inner class name */
            public static final class C0306a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0306a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r10, ir.nasim.InterfaceC20295rm1 r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof ir.nasim.CB7.b.a.C0306a
                    if (r0 == 0) goto L13
                    r0 = r11
                    ir.nasim.CB7$b$a$a r0 = (ir.nasim.CB7.b.a.C0306a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.CB7$b$a$a r0 = new ir.nasim.CB7$b$a$a
                    r0.<init>(r11)
                L18:
                    java.lang.Object r11 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L32
                    if (r2 != r3) goto L2a
                    ir.nasim.AbstractC10685c16.b(r11)
                    goto Ld8
                L2a:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L32:
                    ir.nasim.AbstractC10685c16.b(r11)
                    ir.nasim.Gq2 r11 = r9.a
                    ir.nasim.qk5 r10 = (ir.nasim.AbstractC19670qk5) r10
                    java.util.Map r10 = r10.a()
                    java.util.ArrayList r2 = new java.util.ArrayList
                    int r4 = r10.size()
                    r2.<init>(r4)
                    java.util.Set r10 = r10.entrySet()
                    java.util.Iterator r10 = r10.iterator()
                L4e:
                    boolean r4 = r10.hasNext()
                    if (r4 == 0) goto Lc5
                    java.lang.Object r4 = r10.next()
                    java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                    java.lang.Object r5 = r4.getKey()
                    ir.nasim.qk5$a r5 = (ir.nasim.AbstractC19670qk5.a) r5
                    java.lang.Object r4 = r4.getValue()
                    boolean r6 = r4 instanceof java.util.Set
                    r7 = 0
                    if (r6 != 0) goto L6a
                    goto Lc1
                L6a:
                    java.lang.String r5 = r5.a()
                    java.lang.Integer r5 = ir.nasim.AbstractC14836iZ6.o(r5)
                    if (r5 == 0) goto Lc1
                    int r5 = r5.intValue()
                    ir.nasim.d25 r5 = ir.nasim.C11458d25.E(r5)
                    java.lang.String r6 = "user(...)"
                    ir.nasim.AbstractC13042fc3.h(r5, r6)
                    java.lang.Iterable r4 = (java.lang.Iterable) r4
                    java.util.ArrayList r6 = new java.util.ArrayList
                    r6.<init>()
                    java.util.Iterator r4 = r4.iterator()
                L8c:
                    boolean r7 = r4.hasNext()
                    if (r7 == 0) goto L9e
                    java.lang.Object r7 = r4.next()
                    boolean r8 = r7 instanceof java.lang.String
                    if (r8 == 0) goto L8c
                    r6.add(r7)
                    goto L8c
                L9e:
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Iterator r6 = r6.iterator()
                La7:
                    boolean r7 = r6.hasNext()
                    if (r7 == 0) goto Lbd
                    java.lang.Object r7 = r6.next()
                    java.lang.String r7 = (java.lang.String) r7
                    java.lang.Long r7 = ir.nasim.AbstractC14836iZ6.q(r7)
                    if (r7 == 0) goto La7
                    r4.add(r7)
                    goto La7
                Lbd:
                    ir.nasim.XV4 r7 = ir.nasim.AbstractC4616Fw7.a(r5, r4)
                Lc1:
                    r2.add(r7)
                    goto L4e
                Lc5:
                    java.util.List r10 = ir.nasim.ZW0.n0(r2)
                    java.lang.Iterable r10 = (java.lang.Iterable) r10
                    java.util.Map r10 = ir.nasim.AbstractC18278oO3.w(r10)
                    r0.b = r3
                    java.lang.Object r10 = r11.a(r10, r0)
                    if (r10 != r1) goto Ld8
                    return r1
                Ld8:
                    ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CB7.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ C11458d25 d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C11458d25 c11458d25, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c11458d25;
            this.e = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C4772Gm4 c4772Gm4 = (C4772Gm4) this.c;
            AbstractC19670qk5.a aVarG = AbstractC21557tk5.g(String.valueOf(this.d.getPeerId()));
            Set setD = (Set) c4772Gm4.b(aVarG);
            if (setD == null) {
                setD = AbstractC4597Fu6.d();
            }
            c4772Gm4.j(aVarG, AbstractC4846Gu6.m(setD, String.valueOf(this.e)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public CB7(Context context) {
        AbstractC13042fc3.i(context, "applicationContext");
        this.a = AbstractC16715lk5.b(EnumC12211eE.g.getKey(), null, null, null, 14, null);
        this.b = b(context);
    }

    private final InterfaceC23475wz1 b(Context context) {
        return (InterfaceC23475wz1) this.a.a(context, c[0]);
    }

    public final Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = AbstractC22147uk5.a(this.b, new a(null), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    public final Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC6459Nq2.I(new b(this.b.getData()), interfaceC20295rm1);
    }

    public final Object d(C11458d25 c11458d25, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = AbstractC22147uk5.a(this.b, new c(c11458d25, j, null), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }
}
