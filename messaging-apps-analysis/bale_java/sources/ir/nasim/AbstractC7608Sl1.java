package ir.nasim;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Sl1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC7608Sl1 {

    /* renamed from: ir.nasim.Sl1$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC7608Sl1.b(null, this);
        }
    }

    /* renamed from: ir.nasim.Sl1$b */
    static final class b implements PointerInputEventHandler {
        final /* synthetic */ UA2 a;

        b(UA2 ua2) {
            this.a = ua2;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objD = AbstractC7608Sl1.d(interfaceC9049Yg5, this.a, interfaceC20295rm1);
            return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Sl1$c */
    static final class c extends V06 implements InterfaceC14603iB2 {
        int a;
        private /* synthetic */ Object b;
        final /* synthetic */ UA2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.c, interfaceC20295rm1);
            cVar.b = obj;
            return cVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r7.a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ir.nasim.AbstractC10685c16.b(r8)
                goto L53
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                java.lang.Object r1 = r7.b
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                ir.nasim.AbstractC10685c16.b(r8)
                goto L35
            L22:
                ir.nasim.AbstractC10685c16.b(r8)
                java.lang.Object r8 = r7.b
                r1 = r8
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                r7.b = r1
                r7.a = r3
                java.lang.Object r8 = ir.nasim.AbstractC7608Sl1.a(r1, r7)
                if (r8 != r0) goto L35
                return r0
            L35:
                ir.nasim.Og5 r8 = (ir.nasim.C6616Og5) r8
                r8.a()
                ir.nasim.UA2 r4 = r7.c
                long r5 = r8.h()
                ir.nasim.ZG4 r8 = ir.nasim.ZG4.d(r5)
                r4.invoke(r8)
                r8 = 0
                r7.b = r8
                r7.a = r2
                java.lang.Object r8 = ir.nasim.AbstractC20271rj7.t(r1, r8, r7, r3, r8)
                if (r8 != r0) goto L53
                return r0
            L53:
                ir.nasim.Og5 r8 = (ir.nasim.C6616Og5) r8
                if (r8 == 0) goto L5a
                r8.a()
            L5a:
                ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7608Sl1.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(ir.nasim.EV r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            boolean r0 = r9 instanceof ir.nasim.AbstractC7608Sl1.a
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.Sl1$a r0 = (ir.nasim.AbstractC7608Sl1.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Sl1$a r0 = new ir.nasim.Sl1$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.a
            ir.nasim.EV r8 = (ir.nasim.EV) r8
            ir.nasim.AbstractC10685c16.b(r9)
            goto L44
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            ir.nasim.AbstractC10685c16.b(r9)
        L38:
            r0.a = r8
            r0.c = r3
            r9 = 0
            java.lang.Object r9 = ir.nasim.EV.D0(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L44
            return r1
        L44:
            ir.nasim.Bg5 r9 = (ir.nasim.C3534Bg5) r9
            int r2 = r9.b()
            boolean r2 = ir.nasim.AbstractC4470Fg5.c(r2)
            if (r2 == 0) goto L38
            java.util.List r2 = r9.c()
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
            r6 = r5
        L5d:
            if (r6 >= r4) goto L6f
            java.lang.Object r7 = r2.get(r6)
            ir.nasim.Og5 r7 = (ir.nasim.C6616Og5) r7
            boolean r7 = ir.nasim.AbstractC3768Cg5.a(r7)
            if (r7 != 0) goto L6c
            goto L38
        L6c:
            int r6 = r6 + 1
            goto L5d
        L6f:
            java.util.List r8 = r9.c()
            java.lang.Object r8 = r8.get(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC7608Sl1.b(ir.nasim.EV, ir.nasim.rm1):java.lang.Object");
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, UA2 ua2) {
        return AbstractC21071t37.c(eVar, C8315Vl1.a, new b(ua2));
    }

    public static final Object d(InterfaceC9049Yg5 interfaceC9049Yg5, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = AbstractC8163Uu2.d(interfaceC9049Yg5, new c(ua2, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }
}
