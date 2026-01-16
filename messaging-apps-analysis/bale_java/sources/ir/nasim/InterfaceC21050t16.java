package ir.nasim;

import androidx.camera.core.impl.h;
import ir.nasim.InterfaceC21050t16;

/* renamed from: ir.nasim.t16, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC21050t16 {
    public static final InterfaceC21050t16 a = new InterfaceC21050t16() { // from class: ir.nasim.s16
        @Override // ir.nasim.InterfaceC21050t16
        public final InterfaceC21050t16.c d(InterfaceC21050t16.b bVar) {
            return InterfaceC21050t16.f(bVar);
        }
    };
    public static final InterfaceC21050t16 b = new h.b(e());
    public static final InterfaceC21050t16 c = new androidx.camera.core.impl.h(e());

    /* renamed from: ir.nasim.t16$a */
    public static final class a {
        private final InterfaceC21050t16 a;
        private long b;

        public a(InterfaceC21050t16 interfaceC21050t16) {
            this.a = interfaceC21050t16;
            this.b = interfaceC21050t16.a();
        }

        public InterfaceC21050t16 a() {
            InterfaceC21050t16 interfaceC21050t16 = this.a;
            return interfaceC21050t16 instanceof InterfaceC22314v16 ? ((InterfaceC22314v16) interfaceC21050t16).c(this.b) : new C4094Dq7(this.b, this.a);
        }
    }

    /* renamed from: ir.nasim.t16$b */
    public interface b {
        Throwable a();

        long b();

        int j();
    }

    /* renamed from: ir.nasim.t16$c */
    public static final class c {
        public static final c d = new c(false, 0);
        public static final c e = new c(true);
        public static final c f = new c(true, 100);
        public static c g = new c(false, 0, true);
        private final long a;
        private final boolean b;
        private final boolean c;

        private c(boolean z) {
            this(z, a());
        }

        public static long a() {
            return 500L;
        }

        public long b() {
            return this.a;
        }

        public boolean c() {
            return this.c;
        }

        public boolean d() {
            return this.b;
        }

        private c(boolean z, long j) {
            this(z, j, false);
        }

        private c(boolean z, long j, boolean z2) {
            this.b = z;
            this.a = j;
            if (z2) {
                AbstractC4980Hj5.b(!z, "shouldRetry must be false when completeWithoutFailure is set to true");
            }
            this.c = z2;
        }
    }

    static long e() {
        return 6000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ c f(b bVar) {
        return c.d;
    }

    default long a() {
        return 0L;
    }

    c d(b bVar);
}
