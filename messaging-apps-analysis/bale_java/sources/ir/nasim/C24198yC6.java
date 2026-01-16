package ir.nasim;

import ir.nasim.GJ0;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* renamed from: ir.nasim.yC6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24198yC6 {
    private final InterfaceC20315ro1 a;
    private final InterfaceC14603iB2 b;
    private final InterfaceC17639nJ0 c;
    private final AtomicInteger d;

    /* renamed from: ir.nasim.yC6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ C24198yC6 f;
        final /* synthetic */ InterfaceC14603iB2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, C24198yC6 c24198yC6, InterfaceC14603iB2 interfaceC14603iB2) {
            super(1);
            this.e = ua2;
            this.f = c24198yC6;
            this.g = interfaceC14603iB2;
        }

        public final void a(Throwable th) {
            C19938rB7 c19938rB7;
            this.e.invoke(th);
            this.f.c.w(th);
            do {
                Object objF = GJ0.f(this.f.c.v());
                if (objF == null) {
                    c19938rB7 = null;
                } else {
                    this.g.invoke(objF, th);
                    c19938rB7 = C19938rB7.a;
                }
            } while (c19938rB7 != null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yC6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24198yC6.this.new b(interfaceC20295rm1);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005f -> B:21:0x0062). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ir.nasim.AbstractC10685c16.b(r6)
                goto L62
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                java.lang.Object r1 = r5.b
                ir.nasim.iB2 r1 = (ir.nasim.InterfaceC14603iB2) r1
                ir.nasim.AbstractC10685c16.b(r6)
                goto L56
            L22:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.yC6 r6 = ir.nasim.C24198yC6.this
                java.util.concurrent.atomic.AtomicInteger r6 = ir.nasim.C24198yC6.c(r6)
                int r6 = r6.get()
                if (r6 <= 0) goto L33
                r6 = r3
                goto L34
            L33:
                r6 = 0
            L34:
                if (r6 == 0) goto L71
            L36:
                ir.nasim.yC6 r6 = ir.nasim.C24198yC6.this
                ir.nasim.ro1 r6 = ir.nasim.C24198yC6.d(r6)
                ir.nasim.AbstractC20906so1.f(r6)
                ir.nasim.yC6 r6 = ir.nasim.C24198yC6.this
                ir.nasim.iB2 r1 = ir.nasim.C24198yC6.a(r6)
                ir.nasim.yC6 r6 = ir.nasim.C24198yC6.this
                ir.nasim.nJ0 r6 = ir.nasim.C24198yC6.b(r6)
                r5.b = r1
                r5.c = r3
                java.lang.Object r6 = r6.i(r5)
                if (r6 != r0) goto L56
                return r0
            L56:
                r4 = 0
                r5.b = r4
                r5.c = r2
                java.lang.Object r6 = r1.invoke(r6, r5)
                if (r6 != r0) goto L62
                return r0
            L62:
                ir.nasim.yC6 r6 = ir.nasim.C24198yC6.this
                java.util.concurrent.atomic.AtomicInteger r6 = ir.nasim.C24198yC6.c(r6)
                int r6 = r6.decrementAndGet()
                if (r6 != 0) goto L36
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            L71:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                java.lang.String r0 = r0.toString()
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24198yC6.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C24198yC6(InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22) {
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(ua2, "onComplete");
        AbstractC13042fc3.i(interfaceC14603iB2, "onUndeliveredElement");
        AbstractC13042fc3.i(interfaceC14603iB22, "consumeMessage");
        this.a = interfaceC20315ro1;
        this.b = interfaceC14603iB22;
        this.c = DJ0.b(Integer.MAX_VALUE, null, null, 6, null);
        this.d = new AtomicInteger(0);
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) interfaceC20315ro1.getCoroutineContext().a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 == null) {
            return;
        }
        interfaceC13730gj3.s(new a(ua2, this, interfaceC14603iB2));
    }

    public final void e(Object obj) throws Throwable {
        Object objH = this.c.h(obj);
        if (objH instanceof GJ0.a) {
            Throwable thE = GJ0.e(objH);
            if (thE != null) {
                throw thE;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (!GJ0.i(objH)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.d.getAndIncrement() == 0) {
            AbstractC10533bm0.d(this.a, null, null, new b(null), 3, null);
        }
    }
}
