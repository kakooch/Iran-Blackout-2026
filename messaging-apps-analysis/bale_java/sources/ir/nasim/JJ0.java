package ir.nasim;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes8.dex */
public final class JJ0 extends AbstractC23344wl6 {
    private final C6401Nl0 e;
    private final AtomicReferenceArray f;

    public JJ0(long j, JJ0 jj0, C6401Nl0 c6401Nl0, int i) {
        super(j, jj0, i);
        this.e = c6401Nl0;
        this.f = new AtomicReferenceArray(AbstractC6661Ol0.b * 2);
    }

    private final void z(int i, Object obj) {
        this.f.lazySet(i * 2, obj);
    }

    public final void A(int i, Object obj) {
        this.f.set((i * 2) + 1, obj);
    }

    public final void B(int i, Object obj) {
        z(i, obj);
    }

    @Override // ir.nasim.AbstractC23344wl6
    public int n() {
        return AbstractC6661Ol0.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
    
        s(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        if (r0 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
    
        r4 = u().b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
    
        if (r4 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
    
        ir.nasim.AbstractC16470lK4.b(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    @Override // ir.nasim.AbstractC23344wl6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(int r4, java.lang.Throwable r5, ir.nasim.InterfaceC11938do1 r6) {
        /*
            r3 = this;
            int r5 = ir.nasim.AbstractC6661Ol0.b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.v(r4)
        Le:
            java.lang.Object r1 = r3.w(r4)
            boolean r2 = r1 instanceof ir.nasim.InterfaceC21726u18
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof ir.nasim.C22316v18
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            ir.nasim.i47 r2 = ir.nasim.AbstractC6661Ol0.j()
            if (r1 == r2) goto L63
            ir.nasim.i47 r2 = ir.nasim.AbstractC6661Ol0.i()
            if (r1 != r2) goto L28
            goto L63
        L28:
            ir.nasim.i47 r2 = ir.nasim.AbstractC6661Ol0.p()
            if (r1 == r2) goto Le
            ir.nasim.i47 r2 = ir.nasim.AbstractC6661Ol0.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            ir.nasim.i47 r4 = ir.nasim.AbstractC6661Ol0.f()
            if (r1 == r4) goto L62
            ir.nasim.i47 r4 = ir.nasim.AbstractC6661Ol0.d
            if (r1 != r4) goto L40
            goto L62
        L40:
            ir.nasim.i47 r4 = ir.nasim.AbstractC6661Ol0.z()
            if (r1 != r4) goto L47
            return
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            return
        L63:
            r3.s(r4)
            if (r0 == 0) goto L73
            ir.nasim.Nl0 r4 = r3.u()
            ir.nasim.UA2 r4 = r4.b
            if (r4 == 0) goto L73
            ir.nasim.AbstractC16470lK4.b(r4, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            ir.nasim.i47 r2 = ir.nasim.AbstractC6661Ol0.j()
            goto L7f
        L7b:
            ir.nasim.i47 r2 = ir.nasim.AbstractC6661Ol0.i()
        L7f:
            boolean r1 = r3.r(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.s(r4)
            r1 = r0 ^ 1
            r3.x(r4, r1)
            if (r0 == 0) goto L9a
            ir.nasim.Nl0 r4 = r3.u()
            ir.nasim.UA2 r4 = r4.b
            if (r4 == 0) goto L9a
            ir.nasim.AbstractC16470lK4.b(r4, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.JJ0.o(int, java.lang.Throwable, ir.nasim.do1):void");
    }

    public final boolean r(int i, Object obj, Object obj2) {
        return IJ0.a(this.f, (i * 2) + 1, obj, obj2);
    }

    public final void s(int i) {
        z(i, null);
    }

    public final Object t(int i, Object obj) {
        return this.f.getAndSet((i * 2) + 1, obj);
    }

    public final C6401Nl0 u() {
        C6401Nl0 c6401Nl0 = this.e;
        AbstractC13042fc3.f(c6401Nl0);
        return c6401Nl0;
    }

    public final Object v(int i) {
        return this.f.get(i * 2);
    }

    public final Object w(int i) {
        return this.f.get((i * 2) + 1);
    }

    public final void x(int i, boolean z) {
        if (z) {
            u().X0((this.c * AbstractC6661Ol0.b) + i);
        }
        p();
    }

    public final Object y(int i) {
        Object objV = v(i);
        s(i);
        return objV;
    }
}
