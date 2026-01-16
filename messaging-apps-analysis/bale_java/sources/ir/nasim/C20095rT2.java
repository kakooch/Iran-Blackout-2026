package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.rT2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20095rT2 extends AbstractC20704sT2 implements GG1 {
    private volatile C20095rT2 _immediate;
    private final Handler c;
    private final String d;
    private final boolean e;
    private final C20095rT2 f;

    /* renamed from: ir.nasim.rT2$a */
    public static final class a implements Runnable {
        final /* synthetic */ HE0 a;
        final /* synthetic */ C20095rT2 b;

        public a(HE0 he0, C20095rT2 c20095rT2) {
            this.a = he0;
            this.b = c20095rT2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.O(this.b, C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rT2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Runnable f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Runnable runnable) {
            super(1);
            this.f = runnable;
        }

        public final void a(Throwable th) {
            C20095rT2.this.c.removeCallbacks(this.f);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    private C20095rT2(Handler handler, String str, boolean z) {
        super(null);
        this.c = handler;
        this.d = str;
        this.e = z;
        this._immediate = z ? this : null;
        C20095rT2 c20095rT2 = this._immediate;
        if (c20095rT2 == null) {
            c20095rT2 = new C20095rT2(handler, str, true);
            this._immediate = c20095rT2;
        }
        this.f = c20095rT2;
    }

    private final void L0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        AbstractC19067pj3.c(interfaceC11938do1, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C12366eV1.b().x0(interfaceC11938do1, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(C20095rT2 c20095rT2, Runnable runnable) {
        c20095rT2.c.removeCallbacks(runnable);
    }

    @Override // ir.nasim.AbstractC13778go1
    public boolean A0(InterfaceC11938do1 interfaceC11938do1) {
        return (this.e && AbstractC13042fc3.d(Looper.myLooper(), this.c.getLooper())) ? false : true;
    }

    @Override // ir.nasim.GG1
    public NV1 J(long j, final Runnable runnable, InterfaceC11938do1 interfaceC11938do1) {
        if (this.c.postDelayed(runnable, AbstractC23053wG5.j(j, 4611686018427387903L))) {
            return new NV1() { // from class: ir.nasim.qT2
                @Override // ir.nasim.NV1
                public final void dispose() {
                    C20095rT2.Q0(this.a, runnable);
                }
            };
        }
        L0(interfaceC11938do1, runnable);
        return C14007hB4.a;
    }

    @Override // ir.nasim.AbstractC20704sT2
    /* renamed from: N0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C20095rT2 F0() {
        return this.f;
    }

    @Override // ir.nasim.GG1
    public void e0(long j, HE0 he0) {
        a aVar = new a(he0, this);
        if (this.c.postDelayed(aVar, AbstractC23053wG5.j(j, 4611686018427387903L))) {
            he0.J(new b(aVar));
        } else {
            L0(he0.getContext(), aVar);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C20095rT2) && ((C20095rT2) obj).c == this.c;
    }

    public int hashCode() {
        return System.identityHashCode(this.c);
    }

    @Override // ir.nasim.AbstractC13778go1
    public String toString() {
        String strD0 = D0();
        if (strD0 != null) {
            return strD0;
        }
        String string = this.d;
        if (string == null) {
            string = this.c.toString();
        }
        if (!this.e) {
            return string;
        }
        return string + ".immediate";
    }

    @Override // ir.nasim.AbstractC13778go1
    public void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        if (this.c.post(runnable)) {
            return;
        }
        L0(interfaceC11938do1, runnable);
    }

    public /* synthetic */ C20095rT2(Handler handler, String str, int i, ED1 ed1) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public C20095rT2(Handler handler, String str) {
        this(handler, str, false);
    }
}
