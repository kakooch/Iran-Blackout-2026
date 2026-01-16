package ir.nasim;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ir.nasim.lI3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C16451lI3 {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(C16451lI3.class, Object.class, "_next");
    private static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(C16451lI3.class, Object.class, "_prev");
    private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(C16451lI3.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* renamed from: ir.nasim.lI3$a */
    public static abstract class a extends UL {
        public final C16451lI3 b;
        public C16451lI3 c;

        public a(C16451lI3 c16451lI3) {
            this.b = c16451lI3;
        }

        @Override // ir.nasim.UL
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(C16451lI3 c16451lI3, Object obj) {
            boolean z = obj == null;
            C16451lI3 c16451lI32 = z ? this.b : this.c;
            if (c16451lI32 != null && F1.a(C16451lI3.a, c16451lI3, this, c16451lI32) && z) {
                C16451lI3 c16451lI33 = this.b;
                C16451lI3 c16451lI34 = this.c;
                AbstractC13042fc3.f(c16451lI34);
                c16451lI33.n(c16451lI34);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (ir.nasim.F1.a(r4, r3, r2, ((ir.nasim.MN5) r5).a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C16451lI3 i(ir.nasim.QK4 r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = ir.nasim.C16451lI3.b
            java.lang.Object r0 = r0.get(r8)
            ir.nasim.lI3 r0 = (ir.nasim.C16451lI3) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = ir.nasim.C16451lI3.a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L20
            if (r0 != r2) goto L16
            return r2
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = ir.nasim.C16451lI3.b
            boolean r0 = ir.nasim.F1.a(r1, r8, r0, r2)
            if (r0 != 0) goto L1f
            goto L0
        L1f:
            return r2
        L20:
            boolean r6 = r8.v()
            if (r6 == 0) goto L27
            return r1
        L27:
            if (r5 != r9) goto L2a
            return r2
        L2a:
            boolean r6 = r5 instanceof ir.nasim.QK4
            if (r6 == 0) goto L34
            ir.nasim.QK4 r5 = (ir.nasim.QK4) r5
            r5.a(r2)
            goto L0
        L34:
            boolean r6 = r5 instanceof ir.nasim.MN5
            if (r6 == 0) goto L50
            if (r3 == 0) goto L47
            ir.nasim.MN5 r5 = (ir.nasim.MN5) r5
            ir.nasim.lI3 r5 = r5.a
            boolean r2 = ir.nasim.F1.a(r4, r3, r2, r5)
            if (r2 != 0) goto L45
            goto L0
        L45:
            r2 = r3
            goto La
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = ir.nasim.C16451lI3.b
            java.lang.Object r2 = r4.get(r2)
            ir.nasim.lI3 r2 = (ir.nasim.C16451lI3) r2
            goto Lb
        L50:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            ir.nasim.AbstractC13042fc3.g(r5, r3)
            r3 = r5
            ir.nasim.lI3 r3 = (ir.nasim.C16451lI3) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16451lI3.i(ir.nasim.QK4):ir.nasim.lI3");
    }

    private final C16451lI3 k(C16451lI3 c16451lI3) {
        while (c16451lI3.v()) {
            c16451lI3 = (C16451lI3) b.get(c16451lI3);
        }
        return c16451lI3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(C16451lI3 c16451lI3) {
        C16451lI3 c16451lI32;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        do {
            c16451lI32 = (C16451lI3) atomicReferenceFieldUpdater.get(c16451lI3);
            if (o() != c16451lI3) {
                return;
            }
        } while (!F1.a(b, c16451lI3, c16451lI32, this));
        if (v()) {
            c16451lI3.i(null);
        }
    }

    private final MN5 y() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        MN5 mn5 = (MN5) atomicReferenceFieldUpdater.get(this);
        if (mn5 != null) {
            return mn5;
        }
        MN5 mn52 = new MN5(this);
        atomicReferenceFieldUpdater.lazySet(this, mn52);
        return mn52;
    }

    public final boolean h(C16451lI3 c16451lI3) {
        b.lazySet(c16451lI3, this);
        a.lazySet(c16451lI3, this);
        while (o() == this) {
            if (F1.a(a, this, this, c16451lI3)) {
                c16451lI3.n(this);
                return true;
            }
        }
        return false;
    }

    public final Object o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof QK4)) {
                return obj;
            }
            ((QK4) obj).a(this);
        }
    }

    public final C16451lI3 p() {
        return AbstractC15860kI3.b(o());
    }

    public final C16451lI3 t() {
        C16451lI3 c16451lI3I = i(null);
        return c16451lI3I == null ? k((C16451lI3) b.get(this)) : c16451lI3I;
    }

    public String toString() {
        return new AbstractC24042xw5(this) { // from class: ir.nasim.lI3.b
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return YA1.a(this.receiver);
            }
        } + '@' + YA1.b(this);
    }

    public boolean v() {
        return o() instanceof MN5;
    }

    public boolean w() {
        return x() == null;
    }

    public final C16451lI3 x() {
        Object objO;
        C16451lI3 c16451lI3;
        do {
            objO = o();
            if (objO instanceof MN5) {
                return ((MN5) objO).a;
            }
            if (objO == this) {
                return (C16451lI3) objO;
            }
            AbstractC13042fc3.g(objO, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            c16451lI3 = (C16451lI3) objO;
        } while (!F1.a(a, this, objO, c16451lI3.y()));
        c16451lI3.i(null);
        return null;
    }

    public final int z(C16451lI3 c16451lI3, C16451lI3 c16451lI32, a aVar) {
        b.lazySet(c16451lI3, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(c16451lI3, c16451lI32);
        aVar.c = c16451lI32;
        if (F1.a(atomicReferenceFieldUpdater, this, c16451lI32, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }
}
