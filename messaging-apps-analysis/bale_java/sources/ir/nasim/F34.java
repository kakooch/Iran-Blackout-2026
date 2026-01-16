package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class F34 extends YT4 {
    private final int b;
    private final int c;
    private final InterfaceC9336Zm4 d;
    private V24 e;
    private final InterfaceC20315ro1 f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.F34$a$a, reason: collision with other inner class name */
        static final class C0354a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ F34 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0354a(F34 f34, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = f34;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0354a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.e();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0354a) create(obj, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return F34.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6J = F34.this.j().j();
                C0354a c0354a = new C0354a(F34.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10040ay6J, c0354a, this) == objE) {
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

    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return F34.this.f(null, this);
        }
    }

    public F34(int i, int i2, InterfaceC9336Zm4 interfaceC9336Zm4, V24 v24, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC9336Zm4, "presenceNeededIds");
        AbstractC13042fc3.i(v24, "repository");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.b = i;
        this.c = i2;
        this.d = interfaceC9336Zm4;
        this.e = v24;
        this.f = interfaceC20315ro1;
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(null), 3, null);
    }

    private final void k(List list) {
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Q14) it.next()).i()));
        }
        interfaceC9336Zm4.c(AbstractC15401jX0.r1(arrayList));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.F34.b
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.F34$b r0 = (ir.nasim.F34.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.F34$b r0 = new ir.nasim.F34$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.a
            ir.nasim.F34 r6 = (ir.nasim.F34) r6
            ir.nasim.AbstractC10685c16.b(r7)
            goto L50
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            ir.nasim.AbstractC10685c16.b(r7)
            java.lang.Object r6 = r6.a()
            com.google.protobuf.BytesValue r6 = (com.google.protobuf.BytesValue) r6
            ir.nasim.V24 r7 = r5.e
            int r2 = r5.b
            int r4 = r5.c
            r0.a = r5
            r0.d = r3
            java.lang.Object r7 = r7.m(r2, r6, r4, r0)
            if (r7 != r1) goto L4f
            return r1
        L4f:
            r6 = r5
        L50:
            ir.nasim.XV4 r7 = (ir.nasim.XV4) r7
            java.lang.Object r0 = r7.e()
            java.util.List r0 = (java.util.List) r0
            r6.k(r0)
            ir.nasim.YT4$b$c r6 = new ir.nasim.YT4$b$c
            java.lang.Object r0 = r7.e()
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r7.e()
            java.util.List r1 = (java.util.List) r1
            boolean r1 = r1.isEmpty()
            r2 = 0
            if (r1 != 0) goto L8c
            java.lang.Object r1 = r7.f()
            com.google.protobuf.BytesValue r1 = (com.google.protobuf.BytesValue) r1
            if (r1 == 0) goto L85
            com.google.protobuf.g r1 = r1.getValue()
            if (r1 == 0) goto L85
            boolean r1 = r1.isEmpty()
            if (r1 != r3) goto L85
            goto L8c
        L85:
            java.lang.Object r7 = r7.f()
            com.google.protobuf.BytesValue r7 = (com.google.protobuf.BytesValue) r7
            goto L8d
        L8c:
            r7 = r2
        L8d:
            r6.<init>(r0, r2, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F34.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public BytesValue d(ZT4 zt4) {
        AbstractC13042fc3.i(zt4, "state");
        return null;
    }

    public final V24 j() {
        return this.e;
    }
}
