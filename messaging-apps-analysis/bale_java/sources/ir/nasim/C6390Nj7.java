package ir.nasim;

/* renamed from: ir.nasim.Nj7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6390Nj7 extends AbstractRunnableC4748Gj7 {
    public final Runnable c;

    public C6390Nj7(Runnable runnable, long j, InterfaceC5216Ij7 interfaceC5216Ij7) {
        super(j, interfaceC5216Ij7);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.c.run();
        } finally {
            this.b.a();
        }
    }

    public String toString() {
        return "Task[" + YA1.a(this.c) + '@' + YA1.b(this.c) + ", " + this.a + ", " + this.b + ']';
    }
}
