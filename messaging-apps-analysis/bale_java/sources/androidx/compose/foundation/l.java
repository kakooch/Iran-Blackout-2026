package androidx.compose.foundation;

import androidx.compose.ui.e;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC4236Eg5;
import ir.nasim.C12403eZ2;
import ir.nasim.C13012fZ2;
import ir.nasim.C19938rB7;
import ir.nasim.C3534Bg5;
import ir.nasim.EnumC4002Dg5;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC8508Wg5;

/* loaded from: classes.dex */
final class l extends e.c implements InterfaceC8508Wg5 {
    private InterfaceC18507om4 o;
    private C12403eZ2 p;

    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return l.this.x2(this);
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
            return l.this.y2(this);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return l.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                l lVar = l.this;
                this.b = 1;
                if (lVar.x2(this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return l.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                l lVar = l.this;
                this.b = 1;
                if (lVar.y2(this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public l(InterfaceC18507om4 interfaceC18507om4) {
        this.o = interfaceC18507om4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x2(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.foundation.l.a
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.foundation.l$a r0 = (androidx.compose.foundation.l.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            androidx.compose.foundation.l$a r0 = new androidx.compose.foundation.l$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r0.b
            ir.nasim.eZ2 r1 = (ir.nasim.C12403eZ2) r1
            java.lang.Object r0 = r0.a
            androidx.compose.foundation.l r0 = (androidx.compose.foundation.l) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L56
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.eZ2 r5 = r4.p
            if (r5 != 0) goto L58
            ir.nasim.eZ2 r5 = new ir.nasim.eZ2
            r5.<init>()
            ir.nasim.om4 r2 = r4.o
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r0 = r2.c(r5, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r4
            r1 = r5
        L56:
            r0.p = r1
        L58:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.l.x2(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y2(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.foundation.l.b
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.foundation.l$b r0 = (androidx.compose.foundation.l.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            androidx.compose.foundation.l$b r0 = new androidx.compose.foundation.l$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            androidx.compose.foundation.l r0 = (androidx.compose.foundation.l) r0
            ir.nasim.AbstractC10685c16.b(r5)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.eZ2 r5 = r4.p
            if (r5 == 0) goto L52
            ir.nasim.fZ2 r2 = new ir.nasim.fZ2
            r2.<init>(r5)
            ir.nasim.om4 r5 = r4.o
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.c(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r0 = r4
        L4f:
            r5 = 0
            r0.p = r5
        L52:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.l.y2(ir.nasim.rm1):java.lang.Object");
    }

    private final void z2() {
        C12403eZ2 c12403eZ2 = this.p;
        if (c12403eZ2 != null) {
            this.o.a(new C13012fZ2(c12403eZ2));
            this.p = null;
        }
    }

    public final void A2(InterfaceC18507om4 interfaceC18507om4) {
        if (AbstractC13042fc3.d(this.o, interfaceC18507om4)) {
            return;
        }
        z2();
        this.o = interfaceC18507om4;
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        z2();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void i1() {
        z2();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void k1(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j) {
        if (enumC4002Dg5 == EnumC4002Dg5.b) {
            int iG = c3534Bg5.g();
            AbstractC4236Eg5.a aVar = AbstractC4236Eg5.a;
            if (AbstractC4236Eg5.i(iG, aVar.a())) {
                AbstractC10533bm0.d(U1(), null, null, new c(null), 3, null);
            } else if (AbstractC4236Eg5.i(iG, aVar.b())) {
                AbstractC10533bm0.d(U1(), null, null, new d(null), 3, null);
            }
        }
    }
}
