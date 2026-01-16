package ir.nasim;

import ir.nasim.IH0;
import ir.nasim.KB1;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
abstract class IH0 implements InterfaceC24671z07 {
    private final ArrayDeque a = new ArrayDeque();
    private final ArrayDeque b;
    private final PriorityQueue c;
    private b d;
    private long e;
    private long f;

    private static final class b extends C07 implements Comparable {
        private long j;

        private b() {
        }

        @Override // java.lang.Comparable
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (u() != bVar.u()) {
                return u() ? 1 : -1;
            }
            long j = this.e - bVar.e;
            if (j == 0) {
                j = this.j - bVar.j;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c extends D07 {
        private KB1.a f;

        public c(KB1.a aVar) {
            this.f = aVar;
        }

        @Override // ir.nasim.KB1
        public final void y() {
            this.f.a(this);
        }
    }

    public IH0() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new b());
        }
        this.b = new ArrayDeque();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new c(new KB1.a() { // from class: ir.nasim.HH0
                @Override // ir.nasim.KB1.a
                public final void a(KB1 kb1) {
                    this.a.n((IH0.c) kb1);
                }
            }));
        }
        this.c = new PriorityQueue();
    }

    private void m(b bVar) {
        bVar.p();
        this.a.add(bVar);
    }

    @Override // ir.nasim.InterfaceC24671z07
    public void a(long j) {
        this.e = j;
    }

    protected abstract InterfaceC24081y07 e();

    protected abstract void f(C07 c07);

    @Override // ir.nasim.DB1
    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            m((b) AbstractC9683aN7.j((b) this.c.poll()));
        }
        b bVar = this.d;
        if (bVar != null) {
            m(bVar);
            this.d = null;
        }
    }

    @Override // ir.nasim.DB1
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C07 d() {
        AbstractC20011rK.g(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        b bVar = (b) this.a.pollFirst();
        this.d = bVar;
        return bVar;
    }

    @Override // ir.nasim.DB1
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public D07 b() {
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && ((b) AbstractC9683aN7.j((b) this.c.peek())).e <= this.e) {
            b bVar = (b) AbstractC9683aN7.j((b) this.c.poll());
            if (bVar.u()) {
                D07 d07 = (D07) AbstractC9683aN7.j((D07) this.b.pollFirst());
                d07.o(4);
                m(bVar);
                return d07;
            }
            f(bVar);
            if (k()) {
                InterfaceC24081y07 interfaceC24081y07E = e();
                D07 d072 = (D07) AbstractC9683aN7.j((D07) this.b.pollFirst());
                d072.z(bVar.e, interfaceC24081y07E, Long.MAX_VALUE);
                m(bVar);
                return d072;
            }
            m(bVar);
        }
        return null;
    }

    protected final D07 i() {
        return (D07) this.b.pollFirst();
    }

    protected final long j() {
        return this.e;
    }

    protected abstract boolean k();

    @Override // ir.nasim.DB1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(C07 c07) {
        AbstractC20011rK.a(c07 == this.d);
        b bVar = (b) c07;
        if (bVar.t()) {
            m(bVar);
        } else {
            long j = this.f;
            this.f = 1 + j;
            bVar.j = j;
            this.c.add(bVar);
        }
        this.d = null;
    }

    protected void n(D07 d07) {
        d07.p();
        this.b.add(d07);
    }

    @Override // ir.nasim.DB1
    public void release() {
    }
}
