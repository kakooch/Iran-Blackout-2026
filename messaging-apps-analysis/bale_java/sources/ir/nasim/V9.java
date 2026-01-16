package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class V9 {
    private final int a;
    private final InterfaceC19305q74 b;
    private final InterfaceC15271jI5 c;

    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objE = V9.this.e(this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = V9.this.f(null, 0L, 0L, null, null, false, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;
        final /* synthetic */ String e;
        final /* synthetic */ C11458d25 f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, String str, C11458d25 c11458d25, long j, long j2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = str;
            this.f = c11458d25;
            this.g = j;
            this.h = j2;
            this.i = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return V9.this.new c(this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                V9.this.b.d(this.f, this.g, this.h, V9.this.d(this.d, this.e), this.i);
                InterfaceC15271jI5 interfaceC15271jI5 = V9.this.c;
                String str = this.e;
                C11458d25 c11458d25 = this.f;
                long j = this.g;
                long j2 = this.h;
                this.b = 1;
                objC = interfaceC15271jI5.c(str, c11458d25, j, j2, this);
                if (objC == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objC = ((C9475a16) obj).l();
            }
            V9 v9 = V9.this;
            C11458d25 c11458d252 = this.f;
            long j3 = this.g;
            long j4 = this.h;
            boolean z = this.i;
            if (C9475a16.j(objC)) {
                v9.b.d(c11458d252, j3, j4, (List) objC, z);
            }
            return C9475a16.a(objC);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

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
            Object objG = V9.this.g(this);
            return objG == AbstractC14862ic3.e() ? objG : C9475a16.a(objG);
        }
    }

    public V9(int i, InterfaceC19305q74 interfaceC19305q74, InterfaceC15271jI5 interfaceC15271jI5) {
        AbstractC13042fc3.i(interfaceC19305q74, "messageRepository");
        AbstractC13042fc3.i(interfaceC15271jI5, "reactionsRepository");
        this.a = i;
        this.b = interfaceC19305q74;
        this.c = interfaceC15271jI5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List d(List list, String str) {
        if (list.isEmpty()) {
            return AbstractC9766aX0.e(new GG5(str, AbstractC10360bX0.s(Integer.valueOf(this.a)), 1L));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            GG5 gg5R = (GG5) it.next();
            if (!AbstractC13042fc3.d(gg5R.u(), "👁️")) {
                if (AbstractC13042fc3.d(str, gg5R.u())) {
                    if (!gg5R.y().contains(Integer.valueOf(this.a))) {
                        List listP1 = AbstractC15401jX0.p1(gg5R.y());
                        listP1.add(0, Integer.valueOf(this.a));
                        gg5R = GG5.r(gg5R, null, listP1, gg5R.s() + 1, 1, null);
                    }
                    z = true;
                } else if (!AbstractC13042fc3.d(gg5R.u(), "💵") && gg5R.y().contains(Integer.valueOf(this.a))) {
                    gg5R = GG5.r(gg5R, null, AbstractC15401jX0.O0(gg5R.y(), Integer.valueOf(this.a)), gg5R.s() - 1, 1, null);
                }
            }
            if (gg5R.s() > 0) {
                arrayList.add(gg5R);
            }
        }
        if (!z) {
            arrayList.add(new GG5(str, AbstractC10360bX0.s(Integer.valueOf(this.a)), 1L));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.V9.a
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.V9$a r0 = (ir.nasim.V9.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.V9$a r0 = new ir.nasim.V9$a
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
            ir.nasim.jI5 r5 = r4.c
            r0.c = r3
            java.lang.Object r5 = r5.b(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V9.e(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.C11458d25 r19, long r20, long r22, java.lang.String r24, java.util.List r25, boolean r26, ir.nasim.InterfaceC20295rm1 r27) {
        /*
            r18 = this;
            r0 = r27
            boolean r1 = r0 instanceof ir.nasim.V9.b
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.V9$b r1 = (ir.nasim.V9.b) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
            r13 = r18
            goto L1e
        L17:
            ir.nasim.V9$b r1 = new ir.nasim.V9$b
            r13 = r18
            r1.<init>(r0)
        L1e:
            java.lang.Object r0 = r1.a
            java.lang.Object r14 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r1.c
            r15 = 1
            if (r2 == 0) goto L37
            if (r2 != r15) goto L2f
            ir.nasim.AbstractC10685c16.b(r0)
            goto L63
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.go1 r0 = ir.nasim.C12366eV1.b()
            ir.nasim.V9$c r12 = new ir.nasim.V9$c
            r16 = 0
            r2 = r12
            r3 = r18
            r4 = r25
            r5 = r24
            r6 = r19
            r7 = r20
            r9 = r22
            r11 = r26
            r17 = r12
            r12 = r16
            r2.<init>(r4, r5, r6, r7, r9, r11, r12)
            r1.c = r15
            r2 = r17
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r0, r2, r1)
            if (r0 != r14) goto L63
            return r14
        L63:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V9.f(ir.nasim.d25, long, long, java.lang.String, java.util.List, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.V9.d
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.V9$d r0 = (ir.nasim.V9.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.V9$d r0 = new ir.nasim.V9$d
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
            ir.nasim.jI5 r5 = r4.c
            r0.c = r3
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.V9.g(ir.nasim.rm1):java.lang.Object");
    }
}
