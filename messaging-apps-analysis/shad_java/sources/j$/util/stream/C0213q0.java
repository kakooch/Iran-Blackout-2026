package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;

/* renamed from: j$.util.stream.q0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0213q0 extends CountedCompleter {
    public static final /* synthetic */ int h = 0;
    private final AbstractC0256y2 a;
    private j$.util.t b;
    private final long c;
    private final ConcurrentHashMap d;
    private final InterfaceC0192m3 e;
    private final C0213q0 f;
    private A1 g;

    C0213q0(C0213q0 c0213q0, j$.util.t tVar, C0213q0 c0213q02) {
        super(c0213q0);
        this.a = c0213q0.a;
        this.b = tVar;
        this.c = c0213q0.c;
        this.d = c0213q0.d;
        this.e = c0213q0.e;
        this.f = c0213q02;
    }

    protected C0213q0(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, InterfaceC0192m3 interfaceC0192m3) {
        super(null);
        this.a = abstractC0256y2;
        this.b = tVar;
        this.c = AbstractC0146f.h(tVar.estimateSize());
        this.d = new ConcurrentHashMap(Math.max(16, AbstractC0146f.g << 1));
        this.e = interfaceC0192m3;
        this.f = null;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        j$.util.t tVarTrySplit;
        j$.util.t tVar = this.b;
        long j = this.c;
        boolean z = false;
        C0213q0 c0213q0 = this;
        while (tVar.estimateSize() > j && (tVarTrySplit = tVar.trySplit()) != null) {
            C0213q0 c0213q02 = new C0213q0(c0213q0, tVarTrySplit, c0213q0.f);
            C0213q0 c0213q03 = new C0213q0(c0213q0, tVar, c0213q02);
            c0213q0.addToPendingCount(1);
            c0213q03.addToPendingCount(1);
            c0213q0.d.put(c0213q02, c0213q03);
            if (c0213q0.f != null) {
                c0213q02.addToPendingCount(1);
                if (c0213q0.d.replace(c0213q0.f, c0213q0, c0213q02)) {
                    c0213q0.addToPendingCount(-1);
                } else {
                    c0213q02.addToPendingCount(-1);
                }
            }
            if (z) {
                tVar = tVarTrySplit;
                c0213q0 = c0213q02;
                c0213q02 = c0213q03;
            } else {
                c0213q0 = c0213q03;
            }
            z = !z;
            c0213q02.fork();
        }
        if (c0213q0.getPendingCount() > 0) {
            C0207p0 c0207p0 = new j$.util.function.m() { // from class: j$.util.stream.p0
                @Override // j$.util.function.m
                public final Object apply(int i) {
                    int i2 = C0213q0.h;
                    return new Object[i];
                }
            };
            AbstractC0256y2 abstractC0256y2 = c0213q0.a;
            InterfaceC0225s1 interfaceC0225s1U0 = abstractC0256y2.u0(abstractC0256y2.r0(tVar), c0207p0);
            AbstractC0128c abstractC0128c = (AbstractC0128c) c0213q0.a;
            abstractC0128c.getClass();
            interfaceC0225s1U0.getClass();
            abstractC0128c.o0(abstractC0128c.w0(interfaceC0225s1U0), tVar);
            c0213q0.g = interfaceC0225s1U0.b();
            c0213q0.b = null;
        }
        c0213q0.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        A1 a1 = this.g;
        if (a1 != null) {
            a1.a(this.e);
            this.g = null;
        } else {
            j$.util.t tVar = this.b;
            if (tVar != null) {
                AbstractC0256y2 abstractC0256y2 = this.a;
                InterfaceC0192m3 interfaceC0192m3 = this.e;
                AbstractC0128c abstractC0128c = (AbstractC0128c) abstractC0256y2;
                abstractC0128c.getClass();
                interfaceC0192m3.getClass();
                abstractC0128c.o0(abstractC0128c.w0(interfaceC0192m3), tVar);
                this.b = null;
            }
        }
        C0213q0 c0213q0 = (C0213q0) this.d.remove(this);
        if (c0213q0 != null) {
            c0213q0.tryComplete();
        }
    }
}
