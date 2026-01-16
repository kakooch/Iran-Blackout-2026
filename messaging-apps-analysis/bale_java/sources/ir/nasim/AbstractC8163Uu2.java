package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.Uu2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8163Uu2 {

    /* renamed from: ir.nasim.Uu2$a */
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
            return AbstractC8163Uu2.b(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Uu2$b */
    static final class b extends V06 implements InterfaceC14603iB2 {
        int a;
        private /* synthetic */ Object b;
        final /* synthetic */ InterfaceC11938do1 c;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC11938do1;
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.c, this.d, interfaceC20295rm1);
            bVar.b = obj;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v2, types: [ir.nasim.EV, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v3, types: [ir.nasim.EV, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005a -> B:12:0x0029). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0071 -> B:12:0x0029). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r8.a
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L35
                if (r1 == r5) goto L2d
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r1 = r8.b
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                ir.nasim.AbstractC10685c16.b(r9)
                goto L29
            L1a:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L22:
                java.lang.Object r1 = r8.b
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.util.concurrent.CancellationException -> L2b
            L29:
                r9 = r1
                goto L3c
            L2b:
                r9 = move-exception
                goto L61
            L2d:
                java.lang.Object r1 = r8.b
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                ir.nasim.AbstractC10685c16.b(r9)     // Catch: java.util.concurrent.CancellationException -> L2b
                goto L52
            L35:
                ir.nasim.AbstractC10685c16.b(r9)
                java.lang.Object r9 = r8.b
                ir.nasim.EV r9 = (ir.nasim.EV) r9
            L3c:
                ir.nasim.do1 r1 = r8.c
                boolean r1 = ir.nasim.AbstractC19067pj3.q(r1)
                if (r1 == 0) goto L75
                ir.nasim.iB2 r1 = r8.d     // Catch: java.util.concurrent.CancellationException -> L5d
                r8.b = r9     // Catch: java.util.concurrent.CancellationException -> L5d
                r8.a = r5     // Catch: java.util.concurrent.CancellationException -> L5d
                java.lang.Object r1 = r1.invoke(r9, r8)     // Catch: java.util.concurrent.CancellationException -> L5d
                if (r1 != r0) goto L51
                return r0
            L51:
                r1 = r9
            L52:
                r8.b = r1     // Catch: java.util.concurrent.CancellationException -> L2b
                r8.a = r3     // Catch: java.util.concurrent.CancellationException -> L2b
                java.lang.Object r9 = ir.nasim.AbstractC8163Uu2.c(r1, r4, r8, r5, r4)     // Catch: java.util.concurrent.CancellationException -> L2b
                if (r9 != r0) goto L29
                return r0
            L5d:
                r1 = move-exception
                r7 = r1
                r1 = r9
                r9 = r7
            L61:
                ir.nasim.do1 r6 = r8.c
                boolean r6 = ir.nasim.AbstractC19067pj3.q(r6)
                if (r6 == 0) goto L74
                r8.b = r1
                r8.a = r2
                java.lang.Object r9 = ir.nasim.AbstractC8163Uu2.c(r1, r4, r8, r5, r4)
                if (r9 != r0) goto L29
                return r0
            L74:
                throw r9
            L75:
                ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8163Uu2.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final boolean a(EV ev) {
        List listC = ev.S0().c();
        int size = listC.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (((C6616Og5) listC.get(i)).i()) {
                z = true;
                break;
            }
            i++;
        }
        return !z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (a(r7) == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004f -> B:19:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(ir.nasim.EV r7, ir.nasim.EnumC4002Dg5 r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            boolean r0 = r9 instanceof ir.nasim.AbstractC8163Uu2.a
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.Uu2$a r0 = (ir.nasim.AbstractC8163Uu2.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.Uu2$a r0 = new ir.nasim.Uu2$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.b
            ir.nasim.Dg5 r7 = (ir.nasim.EnumC4002Dg5) r7
            java.lang.Object r8 = r0.a
            ir.nasim.EV r8 = (ir.nasim.EV) r8
            ir.nasim.AbstractC10685c16.b(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L52
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            ir.nasim.AbstractC10685c16.b(r9)
            boolean r9 = a(r7)
            if (r9 != 0) goto L72
        L45:
            r0.a = r7
            r0.b = r8
            r0.d = r3
            java.lang.Object r9 = r7.f0(r8, r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            ir.nasim.Bg5 r9 = (ir.nasim.C3534Bg5) r9
            java.util.List r9 = r9.c()
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r4 = 0
        L60:
            if (r4 >= r2) goto L72
            java.lang.Object r5 = r9.get(r4)
            ir.nasim.Og5 r5 = (ir.nasim.C6616Og5) r5
            boolean r5 = r5.i()
            if (r5 == 0) goto L6f
            goto L45
        L6f:
            int r4 = r4 + 1
            goto L60
        L72:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8163Uu2.b(ir.nasim.EV, ir.nasim.Dg5, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object c(EV ev, EnumC4002Dg5 enumC4002Dg5, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC4002Dg5 = EnumC4002Dg5.c;
        }
        return b(ev, enumC4002Dg5, interfaceC20295rm1);
    }

    public static final Object d(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB1 = interfaceC9049Yg5.B1(new b(interfaceC20295rm1.getContext(), interfaceC14603iB2, null), interfaceC20295rm1);
        return objB1 == AbstractC14862ic3.e() ? objB1 : C19938rB7.a;
    }
}
