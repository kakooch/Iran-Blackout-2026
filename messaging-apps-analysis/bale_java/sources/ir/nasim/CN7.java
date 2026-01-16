package ir.nasim;

/* loaded from: classes2.dex */
public abstract class CN7 {
    private UA2 a;

    private CN7() {
    }

    public abstract void a(InterfaceC17460n02 interfaceC17460n02);

    public UA2 b() {
        return this.a;
    }

    public final void c() {
        UA2 ua2B = b();
        if (ua2B != null) {
            ua2B.invoke(this);
        }
    }

    public void d(UA2 ua2) {
        this.a = ua2;
    }

    public /* synthetic */ CN7(ED1 ed1) {
        this();
    }
}
