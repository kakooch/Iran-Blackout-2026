package ir.nasim;

import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import ir.nasim.C24525yl7;

/* renamed from: ir.nasim.gr, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13806gr extends TextPaint {
    private InterfaceC12969fU4 a;
    private C24525yl7 b;
    private int c;
    private C5566Jw6 d;
    private C24381yX0 e;
    private AbstractC12520el0 f;
    private InterfaceC9664aL6 g;
    private OD6 h;
    private AbstractC18051o02 i;

    /* renamed from: ir.nasim.gr$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ AbstractC12520el0 e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC12520el0 abstractC12520el0, long j) {
            super(0);
            this.e = abstractC12520el0;
            this.f = j;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Shader invoke() {
            return ((AbstractC4147Dw6) this.e).b(this.f);
        }
    }

    public C13806gr(int i, float f) {
        super(i);
        ((TextPaint) this).density = f;
        this.b = C24525yl7.b.c();
        this.c = InterfaceC17460n02.i0.a();
        this.d = C5566Jw6.d.a();
    }

    private final void a() {
        this.g = null;
        this.f = null;
        this.h = null;
        setShader(null);
    }

    private final InterfaceC12969fU4 c() {
        InterfaceC12969fU4 interfaceC12969fU4 = this.a;
        if (interfaceC12969fU4 != null) {
            return interfaceC12969fU4;
        }
        InterfaceC12969fU4 interfaceC12969fU4B = AbstractC15587jq.b(this);
        this.a = interfaceC12969fU4B;
        return interfaceC12969fU4B;
    }

    public final int b() {
        return this.c;
    }

    public final void d(int i) {
        if (AbstractC7094Qg0.E(i, this.c)) {
            return;
        }
        c().g(i);
        this.c = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(ir.nasim.AbstractC12520el0 r5, long r6, float r8) {
        /*
            r4 = this;
            if (r5 != 0) goto L6
            r4.a()
            goto L6d
        L6:
            boolean r0 = r5 instanceof ir.nasim.CH6
            if (r0 == 0) goto L18
            ir.nasim.CH6 r5 = (ir.nasim.CH6) r5
            long r5 = r5.b()
            long r5 = ir.nasim.AbstractC5000Hl7.c(r5, r8)
            r4.f(r5)
            goto L6d
        L18:
            boolean r0 = r5 instanceof ir.nasim.AbstractC4147Dw6
            if (r0 == 0) goto L6d
            ir.nasim.el0 r0 = r4.f
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r0, r5)
            r1 = 0
            if (r0 == 0) goto L35
            ir.nasim.OD6 r0 = r4.h
            if (r0 != 0) goto L2b
            r0 = r1
            goto L33
        L2b:
            long r2 = r0.m()
            boolean r0 = ir.nasim.OD6.f(r2, r6)
        L33:
            if (r0 != 0) goto L54
        L35:
            r2 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 == 0) goto L3f
            r1 = 1
        L3f:
            if (r1 == 0) goto L54
            r4.f = r5
            ir.nasim.OD6 r0 = ir.nasim.OD6.c(r6)
            r4.h = r0
            ir.nasim.gr$a r0 = new ir.nasim.gr$a
            r0.<init>(r5, r6)
            ir.nasim.aL6 r5 = ir.nasim.AbstractC10222bH6.d(r0)
            r4.g = r5
        L54:
            ir.nasim.fU4 r5 = r4.c()
            ir.nasim.aL6 r6 = r4.g
            r7 = 0
            if (r6 == 0) goto L64
            java.lang.Object r6 = r6.getValue()
            android.graphics.Shader r6 = (android.graphics.Shader) r6
            goto L65
        L64:
            r6 = r7
        L65:
            r5.q(r6)
            r4.e = r7
            ir.nasim.AbstractC14399hr.a(r4, r8)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13806gr.e(ir.nasim.el0, long, float):void");
    }

    public final void f(long j) {
        C24381yX0 c24381yX0 = this.e;
        if (c24381yX0 == null ? false : C24381yX0.q(c24381yX0.y(), j)) {
            return;
        }
        if (j != 16) {
            this.e = C24381yX0.k(j);
            setColor(DX0.k(j));
            a();
        }
    }

    public final void g(AbstractC18051o02 abstractC18051o02) {
        if (abstractC18051o02 == null || AbstractC13042fc3.d(this.i, abstractC18051o02)) {
            return;
        }
        this.i = abstractC18051o02;
        if (AbstractC13042fc3.d(abstractC18051o02, C8568Wn2.a)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (abstractC18051o02 instanceof C23815xZ6) {
            c().v(VV4.a.b());
            C23815xZ6 c23815xZ6 = (C23815xZ6) abstractC18051o02;
            c().w(c23815xZ6.f());
            c().t(c23815xZ6.d());
            c().j(c23815xZ6.c());
            c().f(c23815xZ6.b());
            InterfaceC12969fU4 interfaceC12969fU4C = c();
            c23815xZ6.e();
            interfaceC12969fU4C.s(null);
        }
    }

    public final void h(C5566Jw6 c5566Jw6) {
        if (c5566Jw6 == null || AbstractC13042fc3.d(this.d, c5566Jw6)) {
            return;
        }
        this.d = c5566Jw6;
        if (AbstractC13042fc3.d(c5566Jw6, C5566Jw6.d.a())) {
            clearShadowLayer();
        } else {
            setShadowLayer(AbstractC23955xn7.b(this.d.b()), Float.intBitsToFloat((int) (this.d.d() >> 32)), Float.intBitsToFloat((int) (this.d.d() & 4294967295L)), DX0.k(this.d.c()));
        }
    }

    public final void i(C24525yl7 c24525yl7) {
        if (c24525yl7 == null || AbstractC13042fc3.d(this.b, c24525yl7)) {
            return;
        }
        this.b = c24525yl7;
        C24525yl7.a aVar = C24525yl7.b;
        setUnderlineText(c24525yl7.d(aVar.d()));
        setStrikeThruText(this.b.d(aVar.b()));
    }
}
