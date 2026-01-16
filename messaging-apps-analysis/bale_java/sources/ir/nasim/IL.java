package ir.nasim;

/* loaded from: classes5.dex */
public abstract class IL {
    private boolean a;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Object obj) {
        if (this.a) {
            return;
        }
        e(obj);
    }

    public void a(boolean z) {
        this.a = true;
    }

    public void b() {
        this.a = true;
    }

    protected abstract void e(Object obj);

    protected final void f(final Object obj) {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.HL
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(obj);
            }
        });
    }
}
