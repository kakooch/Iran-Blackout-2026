package ir.nasim;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* renamed from: ir.nasim.he2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14270he2 implements InterfaceC24671z07 {
    private final C15058iw1 a = new C15058iw1();
    private final C07 b = new C07();
    private final Deque c = new ArrayDeque();
    private int d;
    private boolean e;

    /* renamed from: ir.nasim.he2$a */
    class a extends D07 {
        a() {
        }

        @Override // ir.nasim.KB1
        public void y() {
            C14270he2.this.i(this);
        }
    }

    /* renamed from: ir.nasim.he2$b */
    private static final class b implements InterfaceC24081y07 {
        private final long a;
        private final AbstractC12710f43 b;

        public b(long j, AbstractC12710f43 abstractC12710f43) {
            this.a = j;
            this.b = abstractC12710f43;
        }

        @Override // ir.nasim.InterfaceC24081y07
        public int a(long j) {
            return this.a > j ? 0 : -1;
        }

        @Override // ir.nasim.InterfaceC24081y07
        public List h(long j) {
            return j >= this.a ? this.b : AbstractC12710f43.V();
        }

        @Override // ir.nasim.InterfaceC24081y07
        public long i(int i) {
            AbstractC20011rK.a(i == 0);
            return this.a;
        }

        @Override // ir.nasim.InterfaceC24081y07
        public int j() {
            return 1;
        }
    }

    public C14270he2() {
        for (int i = 0; i < 2; i++) {
            this.c.addFirst(new a());
        }
        this.d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(D07 d07) {
        AbstractC20011rK.g(this.c.size() < 2);
        AbstractC20011rK.a(!this.c.contains(d07));
        d07.p();
        this.c.addFirst(d07);
    }

    @Override // ir.nasim.DB1
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C07 d() {
        AbstractC20011rK.g(!this.e);
        if (this.d != 0) {
            return null;
        }
        this.d = 1;
        return this.b;
    }

    @Override // ir.nasim.DB1
    public void flush() {
        AbstractC20011rK.g(!this.e);
        this.b.p();
        this.d = 0;
    }

    @Override // ir.nasim.DB1
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public D07 b() {
        AbstractC20011rK.g(!this.e);
        if (this.d != 2 || this.c.isEmpty()) {
            return null;
        }
        D07 d07 = (D07) this.c.removeFirst();
        if (this.b.u()) {
            d07.o(4);
        } else {
            C07 c07 = this.b;
            d07.z(this.b.e, new b(c07.e, this.a.a(((ByteBuffer) AbstractC20011rK.e(c07.c)).array())), 0L);
        }
        this.b.p();
        this.d = 0;
        return d07;
    }

    @Override // ir.nasim.DB1
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(C07 c07) {
        AbstractC20011rK.g(!this.e);
        AbstractC20011rK.g(this.d == 1);
        AbstractC20011rK.a(this.b == c07);
        this.d = 2;
    }

    @Override // ir.nasim.DB1
    public void release() {
        this.e = true;
    }

    @Override // ir.nasim.InterfaceC24671z07
    public void a(long j) {
    }
}
