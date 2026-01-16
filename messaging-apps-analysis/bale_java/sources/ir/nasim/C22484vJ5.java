package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.YT4;

/* renamed from: ir.nasim.vJ5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22484vJ5 extends YT4 {
    private final InterfaceC23080wJ5 b;
    private final C11458d25 c;

    /* renamed from: ir.nasim.vJ5$a */
    public interface a {
        C22484vJ5 a(C11458d25 c11458d25);
    }

    /* renamed from: ir.nasim.vJ5$b */
    static final class b extends AbstractC22163um1 {
        int a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C22484vJ5.this.f(null, this);
        }
    }

    public C22484vJ5(InterfaceC23080wJ5 interfaceC23080wJ5, C11458d25 c11458d25) {
        AbstractC13042fc3.i(interfaceC23080wJ5, "repository");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.b = interfaceC23080wJ5;
        this.c = c11458d25;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C22484vJ5.b
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.vJ5$b r0 = (ir.nasim.C22484vJ5.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.vJ5$b r0 = new ir.nasim.vJ5$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r7 = r0.a
            ir.nasim.AbstractC10685c16.b(r8)     // Catch: java.lang.Exception -> L2b
            goto L5c
        L2b:
            r7 = move-exception
            goto L7b
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            ir.nasim.AbstractC10685c16.b(r8)
            java.lang.Object r8 = r7.a()
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto L45
            int r8 = r8.intValue()
            goto L46
        L45:
            r8 = 0
        L46:
            ir.nasim.wJ5 r2 = r6.b     // Catch: java.lang.Exception -> L2b
            ir.nasim.d25 r4 = r6.c     // Catch: java.lang.Exception -> L2b
            int r7 = r7.b()     // Catch: java.lang.Exception -> L2b
            r0.a = r8     // Catch: java.lang.Exception -> L2b
            r0.d = r3     // Catch: java.lang.Exception -> L2b
            java.lang.Object r7 = r2.a(r4, r8, r7, r0)     // Catch: java.lang.Exception -> L2b
            if (r7 != r1) goto L59
            return r1
        L59:
            r5 = r8
            r8 = r7
            r7 = r5
        L5c:
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Exception -> L2b
            ir.nasim.YT4$b$c r0 = new ir.nasim.YT4$b$c     // Catch: java.lang.Exception -> L2b
            r1 = 0
            if (r7 != 0) goto L65
            r2 = r1
            goto L6b
        L65:
            int r2 = r7 + (-1)
            java.lang.Integer r2 = ir.nasim.AbstractC6392Nk0.d(r2)     // Catch: java.lang.Exception -> L2b
        L6b:
            boolean r4 = r8.isEmpty()     // Catch: java.lang.Exception -> L2b
            if (r4 == 0) goto L72
            goto L77
        L72:
            int r7 = r7 + r3
            java.lang.Integer r1 = ir.nasim.AbstractC6392Nk0.d(r7)     // Catch: java.lang.Exception -> L2b
        L77:
            r0.<init>(r8, r2, r1)     // Catch: java.lang.Exception -> L2b
            goto L80
        L7b:
            ir.nasim.YT4$b$a r0 = new ir.nasim.YT4$b$a
            r0.<init>(r7)
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22484vJ5.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Integer d(ZT4 zt4) {
        Integer num;
        int iIntValue;
        Integer num2;
        AbstractC13042fc3.i(zt4, "state");
        Integer numC = zt4.c();
        if (numC == null) {
            return null;
        }
        YT4.b.c cVarB = zt4.b(numC.intValue());
        if (cVarB != null && (num2 = (Integer) cVarB.o()) != null) {
            iIntValue = num2.intValue() + 1;
        } else {
            if (cVarB == null || (num = (Integer) cVarB.j()) == null) {
                return null;
            }
            iIntValue = num.intValue() - 1;
        }
        return Integer.valueOf(iIntValue);
    }
}
