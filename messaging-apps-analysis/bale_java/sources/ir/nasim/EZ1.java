package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public abstract class EZ1 {
    private static final float a;
    private static final float b;
    private static final float c;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return EZ1.b(null, 0L, this);
        }
    }

    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return EZ1.c(null, 0L, this);
        }
    }

    static final class c extends V06 implements InterfaceC14603iB2 {
        Object a;
        int b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ C9663aL5 e;
        final /* synthetic */ C12889fL5 f;
        final /* synthetic */ C12889fL5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C9663aL5 c9663aL5, C12889fL5 c12889fL5, C12889fL5 c12889fL52, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c9663aL5;
            this.f = c12889fL5;
            this.g = c12889fL52;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.e, this.f, this.g, interfaceC20295rm1);
            cVar.d = obj;
            return cVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
        
            r2 = r6 ? 1 : 0;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00bc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00e1 A[EDGE_INSN: B:68:0x00e1->B:44:0x00e1 BREAK  A[LOOP:0: B:39:0x00ce->B:43:0x00de], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0072 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00bd -> B:38:0x00c0). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 354
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EZ1.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(UA2 ua2) {
            super(3);
            this.e = ua2;
        }

        public final void a(C6616Og5 c6616Og5, C6616Og5 c6616Og52, long j) {
            this.e.invoke(ZG4.d(c6616Og52.h()));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((C6616Og5) obj, (C6616Og5) obj2, ((ZG4) obj3).t());
            return C19938rB7.a;
        }
    }

    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(SA2 sa2) {
            super(1);
            this.e = sa2;
        }

        public final void a(C6616Og5 c6616Og5) {
            this.e.invoke();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C6616Og5) obj);
            return C19938rB7.a;
        }
    }

    static final class i extends AbstractC8614Ws3 implements SA2 {
        public static final i e = new i();

        i() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    static final class j extends V06 implements InterfaceC14603iB2 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        boolean g;
        float h;
        int i;
        private /* synthetic */ Object j;
        final /* synthetic */ SA2 k;
        final /* synthetic */ C12280eL5 l;
        final /* synthetic */ EnumC24286yM4 m;
        final /* synthetic */ InterfaceC15796kB2 n;
        final /* synthetic */ InterfaceC14603iB2 o;
        final /* synthetic */ SA2 p;
        final /* synthetic */ UA2 q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(SA2 sa2, C12280eL5 c12280eL5, EnumC24286yM4 enumC24286yM4, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa22, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.k = sa2;
            this.l = c12280eL5;
            this.m = enumC24286yM4;
            this.n = interfaceC15796kB2;
            this.o = interfaceC14603iB2;
            this.p = sa22;
            this.q = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = new j(this.k, this.l, this.m, this.n, this.o, this.p, this.q, interfaceC20295rm1);
            jVar.j = obj;
            return jVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:165:0x04c6, code lost:
        
            if (ir.nasim.EZ1.i(r2.S0(), r0) != false) goto L166;
         */
        /* JADX WARN: Code restructure failed: missing block: B:209:0x0588, code lost:
        
            if ((!(r6 == 0.0f)) != false) goto L210;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0162, code lost:
        
            if (r15 == false) goto L80;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:127:0x03d0, B:128:0x03d4], limit reached: 234 */
        /* JADX WARN: Path cross not found for [B:131:0x03db, B:127:0x03d0], limit reached: 234 */
        /* JADX WARN: Path cross not found for [B:43:0x01e8, B:44:0x01ec], limit reached: 234 */
        /* JADX WARN: Path cross not found for [B:47:0x01f3, B:43:0x01e8], limit reached: 234 */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0316  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0395 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:120:0x03a6  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x03d4  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x03e1  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x0418  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0470  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x0475  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x049c  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x04c8  */
        /* JADX WARN: Removed duplicated region for block: B:170:0x04f0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0501  */
        /* JADX WARN: Removed duplicated region for block: B:180:0x0521  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x0525  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:217:0x059c  */
        /* JADX WARN: Removed duplicated region for block: B:221:0x05af  */
        /* JADX WARN: Removed duplicated region for block: B:223:0x05ce  */
        /* JADX WARN: Removed duplicated region for block: B:228:0x051b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:234:0x0308 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:238:0x0485 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0153 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:240:0x03c6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:244:0x01e0 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0154  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x01b2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x01c3  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x01ec  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01f9  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0225  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0278  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0284  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x028b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x029f  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x02db  */
        /* JADX WARN: Type inference failed for: r0v45, types: [ir.nasim.iB2] */
        /* JADX WARN: Type inference failed for: r12v23 */
        /* JADX WARN: Type inference failed for: r12v24 */
        /* JADX WARN: Type inference failed for: r12v25, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r13v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r14v20 */
        /* JADX WARN: Type inference failed for: r14v5, types: [ir.nasim.Dg5, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r14v6 */
        /* JADX WARN: Type inference failed for: r16v0 */
        /* JADX WARN: Type inference failed for: r16v1 */
        /* JADX WARN: Type inference failed for: r16v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16, types: [ir.nasim.Og5] */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v35, types: [ir.nasim.Og5, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v45 */
        /* JADX WARN: Type inference failed for: r1v46 */
        /* JADX WARN: Type inference failed for: r1v48, types: [ir.nasim.Og5, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v50, types: [ir.nasim.Og5] */
        /* JADX WARN: Type inference failed for: r1v53 */
        /* JADX WARN: Type inference failed for: r1v55, types: [ir.nasim.Og5] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8, types: [ir.nasim.Og5] */
        /* JADX WARN: Type inference failed for: r3v33, types: [ir.nasim.kB2] */
        /* JADX WARN: Type inference failed for: r5v24, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15, types: [ir.nasim.kt7, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v16, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v23, types: [ir.nasim.kt7] */
        /* JADX WARN: Type inference failed for: r8v33 */
        /* JADX WARN: Type inference failed for: r8v36 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x043a -> B:80:0x0287). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:155:0x0469 -> B:156:0x046a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x0485 -> B:80:0x0287). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:0x04ee -> B:171:0x04f1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0180 -> B:74:0x0276). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0183 -> B:31:0x0199). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x021e -> B:66:0x024a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0247 -> B:66:0x024a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x026b -> B:71:0x026e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x02ff -> B:88:0x02b0). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                Method dump skipped, instructions count: 1512
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EZ1.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends V06 implements InterfaceC14603iB2 {
        int a;
        private /* synthetic */ Object b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC14603iB2 f;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC14603iB2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14603iB2 interfaceC14603iB2) {
                super(1);
                this.e = interfaceC14603iB2;
            }

            public final void a(C6616Og5 c6616Og5) {
                this.e.invoke(c6616Og5, ZG4.d(AbstractC3768Cg5.g(c6616Og5)));
                c6616Og5.a();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C6616Og5) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(UA2 ua2, SA2 sa2, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
            this.d = sa2;
            this.e = sa22;
            this.f = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = new k(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            kVar.b = obj;
            return kVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[Catch: CancellationException -> 0x0019, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x00a0, B:39:0x00ac, B:40:0x00af, B:41:0x00b2, B:42:0x00b8, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x003c), top: B:47:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[Catch: CancellationException -> 0x0019, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x00a0, B:39:0x00ac, B:40:0x00af, B:41:0x00b2, B:42:0x00b8, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x003c), top: B:47:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00b8 A[Catch: CancellationException -> 0x0019, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x0019, blocks: (B:8:0x0015, B:33:0x0086, B:35:0x008e, B:37:0x00a0, B:39:0x00ac, B:40:0x00af, B:41:0x00b2, B:42:0x00b8, B:15:0x0028, B:27:0x005e, B:29:0x0062, B:18:0x0030, B:24:0x004d, B:21:0x003c), top: B:47:0x0009 }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r11.a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L34
                if (r1 == r4) goto L2c
                if (r1 == r3) goto L24
                if (r1 != r2) goto L1c
                java.lang.Object r0 = r11.b
                ir.nasim.EV r0 = (ir.nasim.EV) r0
                ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.util.concurrent.CancellationException -> L19
                goto L86
            L19:
                r12 = move-exception
                goto Lc0
            L1c:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L24:
                java.lang.Object r1 = r11.b
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.util.concurrent.CancellationException -> L19
                goto L5e
            L2c:
                java.lang.Object r1 = r11.b
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                ir.nasim.AbstractC10685c16.b(r12)     // Catch: java.util.concurrent.CancellationException -> L19
                goto L4d
            L34:
                ir.nasim.AbstractC10685c16.b(r12)
                java.lang.Object r12 = r11.b
                r1 = r12
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                r11.b = r1     // Catch: java.util.concurrent.CancellationException -> L19
                r11.a = r4     // Catch: java.util.concurrent.CancellationException -> L19
                r6 = 0
                r7 = 0
                r9 = 2
                r10 = 0
                r5 = r1
                r8 = r11
                java.lang.Object r12 = ir.nasim.AbstractC20271rj7.f(r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L19
                if (r12 != r0) goto L4d
                return r0
            L4d:
                ir.nasim.Og5 r12 = (ir.nasim.C6616Og5) r12     // Catch: java.util.concurrent.CancellationException -> L19
                long r4 = r12.f()     // Catch: java.util.concurrent.CancellationException -> L19
                r11.b = r1     // Catch: java.util.concurrent.CancellationException -> L19
                r11.a = r3     // Catch: java.util.concurrent.CancellationException -> L19
                java.lang.Object r12 = ir.nasim.EZ1.c(r1, r4, r11)     // Catch: java.util.concurrent.CancellationException -> L19
                if (r12 != r0) goto L5e
                return r0
            L5e:
                ir.nasim.Og5 r12 = (ir.nasim.C6616Og5) r12     // Catch: java.util.concurrent.CancellationException -> L19
                if (r12 == 0) goto Lbd
                ir.nasim.UA2 r3 = r11.c     // Catch: java.util.concurrent.CancellationException -> L19
                long r4 = r12.h()     // Catch: java.util.concurrent.CancellationException -> L19
                ir.nasim.ZG4 r4 = ir.nasim.ZG4.d(r4)     // Catch: java.util.concurrent.CancellationException -> L19
                r3.invoke(r4)     // Catch: java.util.concurrent.CancellationException -> L19
                long r3 = r12.f()     // Catch: java.util.concurrent.CancellationException -> L19
                ir.nasim.EZ1$k$a r12 = new ir.nasim.EZ1$k$a     // Catch: java.util.concurrent.CancellationException -> L19
                ir.nasim.iB2 r5 = r11.f     // Catch: java.util.concurrent.CancellationException -> L19
                r12.<init>(r5)     // Catch: java.util.concurrent.CancellationException -> L19
                r11.b = r1     // Catch: java.util.concurrent.CancellationException -> L19
                r11.a = r2     // Catch: java.util.concurrent.CancellationException -> L19
                java.lang.Object r12 = ir.nasim.EZ1.h(r1, r3, r12, r11)     // Catch: java.util.concurrent.CancellationException -> L19
                if (r12 != r0) goto L85
                return r0
            L85:
                r0 = r1
            L86:
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.util.concurrent.CancellationException -> L19
                boolean r12 = r12.booleanValue()     // Catch: java.util.concurrent.CancellationException -> L19
                if (r12 == 0) goto Lb8
                ir.nasim.Bg5 r12 = r0.S0()     // Catch: java.util.concurrent.CancellationException -> L19
                java.util.List r12 = r12.c()     // Catch: java.util.concurrent.CancellationException -> L19
                r0 = r12
                java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.util.concurrent.CancellationException -> L19
                int r0 = r0.size()     // Catch: java.util.concurrent.CancellationException -> L19
                r1 = 0
            L9e:
                if (r1 >= r0) goto Lb2
                java.lang.Object r2 = r12.get(r1)     // Catch: java.util.concurrent.CancellationException -> L19
                ir.nasim.Og5 r2 = (ir.nasim.C6616Og5) r2     // Catch: java.util.concurrent.CancellationException -> L19
                boolean r3 = ir.nasim.AbstractC3768Cg5.c(r2)     // Catch: java.util.concurrent.CancellationException -> L19
                if (r3 == 0) goto Laf
                r2.a()     // Catch: java.util.concurrent.CancellationException -> L19
            Laf:
                int r1 = r1 + 1
                goto L9e
            Lb2:
                ir.nasim.SA2 r12 = r11.d     // Catch: java.util.concurrent.CancellationException -> L19
                r12.invoke()     // Catch: java.util.concurrent.CancellationException -> L19
                goto Lbd
            Lb8:
                ir.nasim.SA2 r12 = r11.e     // Catch: java.util.concurrent.CancellationException -> L19
                r12.invoke()     // Catch: java.util.concurrent.CancellationException -> L19
            Lbd:
                ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
                return r12
            Lc0:
                ir.nasim.SA2 r0 = r11.e
                r0.invoke()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EZ1.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return EZ1.h(null, 0L, null, this);
        }
    }

    static {
        float fQ = C17784nZ1.q((float) 0.125d);
        a = fQ;
        float fQ2 = C17784nZ1.q(18);
        b = fQ2;
        c = fQ / fQ2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d0, code lost:
    
        if (ir.nasim.AbstractC3768Cg5.k(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:22:0x006c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(ir.nasim.EV r17, long r18, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EZ1.b(ir.nasim.EV, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r10v3, types: [ir.nasim.fL5] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(ir.nasim.EV r9, long r10, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            boolean r0 = r12 instanceof ir.nasim.EZ1.b
            if (r0 == 0) goto L13
            r0 = r12
            ir.nasim.EZ1$b r0 = (ir.nasim.EZ1.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.EZ1$b r0 = new ir.nasim.EZ1$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r9 = r0.c
            ir.nasim.aL5 r9 = (ir.nasim.C9663aL5) r9
            java.lang.Object r10 = r0.b
            ir.nasim.fL5 r10 = (ir.nasim.C12889fL5) r10
            java.lang.Object r11 = r0.a
            ir.nasim.Og5 r11 = (ir.nasim.C6616Og5) r11
            ir.nasim.AbstractC10685c16.b(r12)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            goto La9
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.Bg5 r12 = r9.S0()
            boolean r12 = i(r12, r10)
            if (r12 == 0) goto L4d
            return r4
        L4d:
            ir.nasim.Bg5 r12 = r9.S0()
            java.util.List r12 = r12.c()
            r2 = r12
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r5 = 0
        L5d:
            if (r5 >= r2) goto L74
            java.lang.Object r6 = r12.get(r5)
            r7 = r6
            ir.nasim.Og5 r7 = (ir.nasim.C6616Og5) r7
            long r7 = r7.f()
            boolean r7 = ir.nasim.AbstractC6122Mg5.b(r7, r10)
            if (r7 == 0) goto L71
            goto L75
        L71:
            int r5 = r5 + 1
            goto L5d
        L74:
            r6 = r4
        L75:
            r11 = r6
            ir.nasim.Og5 r11 = (ir.nasim.C6616Og5) r11
            if (r11 != 0) goto L7b
            return r4
        L7b:
            ir.nasim.fL5 r10 = new ir.nasim.fL5
            r10.<init>()
            ir.nasim.fL5 r12 = new ir.nasim.fL5
            r12.<init>()
            r12.a = r11
            ir.nasim.oW7 r2 = r9.getViewConfiguration()
            long r5 = r2.c()
            ir.nasim.aL5 r2 = new ir.nasim.aL5     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            r2.<init>()     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            ir.nasim.EZ1$c r7 = new ir.nasim.EZ1$c     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            r7.<init>(r2, r12, r10, r4)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            r0.a = r11     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            r0.b = r10     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            r0.c = r2     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            r0.e = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            java.lang.Object r9 = r9.Q(r5, r7, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            if (r9 != r1) goto La8
            return r1
        La8:
            r9 = r2
        La9:
            boolean r9 = r9.a     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            if (r9 == 0) goto Lbe
            java.lang.Object r9 = r10.a     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            r4 = r9
            ir.nasim.Og5 r4 = (ir.nasim.C6616Og5) r4     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> Lb6
            if (r4 != 0) goto Lbe
        Lb4:
            r4 = r11
            goto Lbe
        Lb6:
            java.lang.Object r9 = r10.a
            ir.nasim.Og5 r9 = (ir.nasim.C6616Og5) r9
            if (r9 != 0) goto Lbd
            goto Lb4
        Lbd:
            r4 = r9
        Lbe:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EZ1.c(ir.nasim.EV, long, ir.nasim.rm1):java.lang.Object");
    }

    public static final Object d(InterfaceC9049Yg5 interfaceC9049Yg5, UA2 ua2, SA2 sa2, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = e(interfaceC9049Yg5, new g(ua2), new h(sa2), sa22, i.e, null, interfaceC14603iB2, interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public static final Object e(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua2, SA2 sa2, SA2 sa22, EnumC24286yM4 enumC24286yM4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = AbstractC8163Uu2.d(interfaceC9049Yg5, new j(sa22, new C12280eL5(), enumC24286yM4, interfaceC15796kB2, interfaceC14603iB2, sa2, ua2, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    public static /* synthetic */ Object f(InterfaceC9049Yg5 interfaceC9049Yg5, UA2 ua2, SA2 sa2, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ua2 = d.e;
        }
        UA2 ua22 = ua2;
        if ((i2 & 2) != 0) {
            sa2 = e.e;
        }
        SA2 sa23 = sa2;
        if ((i2 & 4) != 0) {
            sa22 = f.e;
        }
        return d(interfaceC9049Yg5, ua22, sa23, sa22, interfaceC14603iB2, interfaceC20295rm1);
    }

    public static final Object g(InterfaceC9049Yg5 interfaceC9049Yg5, UA2 ua2, SA2 sa2, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = AbstractC8163Uu2.d(interfaceC9049Yg5, new k(ua2, sa2, sa22, interfaceC14603iB2, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0048 -> B:18:0x004b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(ir.nasim.EV r4, long r5, ir.nasim.UA2 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            boolean r0 = r8 instanceof ir.nasim.EZ1.l
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.EZ1$l r0 = (ir.nasim.EZ1.l) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.EZ1$l r0 = new ir.nasim.EZ1$l
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.b
            ir.nasim.UA2 r4 = (ir.nasim.UA2) r4
            java.lang.Object r5 = r0.a
            ir.nasim.EV r5 = (ir.nasim.EV) r5
            ir.nasim.AbstractC10685c16.b(r8)
            r7 = r4
            r4 = r5
            goto L4b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            ir.nasim.AbstractC10685c16.b(r8)
        L3e:
            r0.a = r4
            r0.b = r7
            r0.d = r3
            java.lang.Object r8 = b(r4, r5, r0)
            if (r8 != r1) goto L4b
            return r1
        L4b:
            ir.nasim.Og5 r8 = (ir.nasim.C6616Og5) r8
            if (r8 != 0) goto L55
            r4 = 0
            java.lang.Boolean r4 = ir.nasim.AbstractC6392Nk0.a(r4)
            return r4
        L55:
            boolean r5 = ir.nasim.AbstractC3768Cg5.d(r8)
            if (r5 == 0) goto L60
            java.lang.Boolean r4 = ir.nasim.AbstractC6392Nk0.a(r3)
            return r4
        L60:
            r7.invoke(r8)
            long r5 = r8.f()
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EZ1.h(ir.nasim.EV, long, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(C3534Bg5 c3534Bg5, long j2) {
        Object obj;
        List listC = c3534Bg5.c();
        int size = listC.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                obj = null;
                break;
            }
            obj = listC.get(i2);
            if (AbstractC6122Mg5.b(((C6616Og5) obj).f(), j2)) {
                break;
            }
            i2++;
        }
        C6616Og5 c6616Og5 = (C6616Og5) obj;
        if (c6616Og5 != null && c6616Og5.i()) {
            z = true;
        }
        return true ^ z;
    }

    public static final float j(InterfaceC18354oW7 interfaceC18354oW7, int i2) {
        return AbstractC11873dh5.g(i2, AbstractC11873dh5.a.b()) ? interfaceC18354oW7.g() * c : interfaceC18354oW7.g();
    }

    static final class e extends AbstractC8614Ws3 implements SA2 {
        public static final e e = new e();

        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }

        public final void a() {
        }
    }

    static final class f extends AbstractC8614Ws3 implements SA2 {
        public static final f e = new f();

        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }

        public final void a() {
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((ZG4) obj).t());
            return C19938rB7.a;
        }

        public final void a(long j) {
        }
    }
}
