package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class IN5 {
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
            Object objD = IN5.this.d(null, 0L, 0L, null, null, false, this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;
        final /* synthetic */ String e;
        final /* synthetic */ C11458d25 f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, String str, C11458d25 c11458d25, long j, long j2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
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
            return IN5.this.new b(this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                IN5.this.b.d(this.f, this.g, this.h, IN5.this.e(this.d, this.e), this.i);
                InterfaceC15271jI5 interfaceC15271jI5 = IN5.this.c;
                String str = this.e;
                C11458d25 c11458d25 = this.f;
                long j = this.g;
                long j2 = this.h;
                this.b = 1;
                objD = interfaceC15271jI5.d(str, c11458d25, j, j2, this);
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
            IN5 in5 = IN5.this;
            C11458d25 c11458d252 = this.f;
            long j3 = this.g;
            long j4 = this.h;
            boolean z = this.i;
            if (C9475a16.j(objD)) {
                in5.b.d(c11458d252, j3, j4, (List) objD, z);
            }
            return C9475a16.a(objD);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public IN5(int i, InterfaceC19305q74 interfaceC19305q74, InterfaceC15271jI5 interfaceC15271jI5) {
        AbstractC13042fc3.i(interfaceC19305q74, "messageRepository");
        AbstractC13042fc3.i(interfaceC15271jI5, "reactionsRepository");
        this.a = i;
        this.b = interfaceC19305q74;
        this.c = interfaceC15271jI5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List e(List list, String str) {
        List<GG5> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (GG5 gg5R : list2) {
            if (!AbstractC13042fc3.d(gg5R.u(), "👁️") && AbstractC13042fc3.d(str, gg5R.u()) && gg5R.y().contains(Integer.valueOf(this.a))) {
                gg5R = GG5.r(gg5R, null, AbstractC15401jX0.O0(gg5R.y(), Integer.valueOf(this.a)), gg5R.s() - 1, 1, null);
            }
            arrayList.add(gg5R);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((GG5) obj).s() > 0) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ir.nasim.C11458d25 r19, long r20, long r22, java.lang.String r24, java.util.List r25, boolean r26, ir.nasim.InterfaceC20295rm1 r27) {
        /*
            r18 = this;
            r0 = r27
            boolean r1 = r0 instanceof ir.nasim.IN5.a
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.IN5$a r1 = (ir.nasim.IN5.a) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
            r13 = r18
            goto L1e
        L17:
            ir.nasim.IN5$a r1 = new ir.nasim.IN5$a
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
            ir.nasim.IN5$b r12 = new ir.nasim.IN5$b
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IN5.d(ir.nasim.d25, long, long, java.lang.String, java.util.List, boolean, ir.nasim.rm1):java.lang.Object");
    }
}
