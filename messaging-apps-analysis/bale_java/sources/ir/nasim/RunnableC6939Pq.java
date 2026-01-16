package ir.nasim;

import android.view.Choreographer;
import android.view.View;

/* renamed from: ir.nasim.Pq, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC6939Pq implements InterfaceC4989Hk5, YM5, Runnable, Choreographer.FrameCallback {
    public static final a g = new a(null);
    public static final int h = 8;
    private static long i;
    private final View a;
    private boolean c;
    private boolean e;
    private long f;
    private final C12544en4 b = new C12544en4(new InterfaceC4506Fk5[16], 0);
    private final Choreographer d = Choreographer.getInstance();

    /* renamed from: ir.nasim.Pq$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(android.view.View r5) {
            /*
                r4 = this;
                long r0 = ir.nasim.RunnableC6939Pq.c()
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L2c
                android.view.Display r0 = r5.getDisplay()
                boolean r5 = r5.isInEditMode()
                if (r5 != 0) goto L21
                if (r0 == 0) goto L21
                float r5 = r0.getRefreshRate()
                r0 = 1106247680(0x41f00000, float:30.0)
                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r0 < 0) goto L21
                goto L23
            L21:
                r5 = 1114636288(0x42700000, float:60.0)
            L23:
                r0 = 1000000000(0x3b9aca00, float:0.0047237873)
                float r0 = (float) r0
                float r0 = r0 / r5
                long r0 = (long) r0
                ir.nasim.RunnableC6939Pq.f(r0)
            L2c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.RunnableC6939Pq.a.b(android.view.View):void");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Pq$b */
    public static final class b implements InterfaceC4755Gk5 {
        private final long a;

        public b(long j) {
            this.a = j;
        }

        @Override // ir.nasim.InterfaceC4755Gk5
        public long a() {
            return Math.max(0L, this.a - System.nanoTime());
        }
    }

    public RunnableC6939Pq(View view) {
        this.a = view;
        g.b(view);
    }

    @Override // ir.nasim.InterfaceC4989Hk5
    public void a(InterfaceC4506Fk5 interfaceC4506Fk5) {
        this.b.d(interfaceC4506Fk5);
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.post(this);
    }

    @Override // ir.nasim.YM5
    public void b() {
        this.e = true;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.e) {
            this.f = j;
            this.a.post(this);
        }
    }

    @Override // ir.nasim.YM5
    public void e() {
        this.e = false;
        this.a.removeCallbacks(this);
        this.d.removeFrameCallback(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.o() == 0 || !this.c || !this.e || this.a.getWindowVisibility() != 0) {
            this.c = false;
            return;
        }
        b bVar = new b(this.f + i);
        boolean z = false;
        while (this.b.o() != 0 && !z) {
            if (bVar.a() <= 0 || ((InterfaceC4506Fk5) this.b.a[0]).b(bVar)) {
                z = true;
            } else {
                this.b.w(0);
            }
        }
        if (z) {
            this.d.postFrameCallback(this);
        } else {
            this.c = false;
        }
    }

    @Override // ir.nasim.YM5
    public void d() {
    }
}
