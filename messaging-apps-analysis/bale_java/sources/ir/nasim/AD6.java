package ir.nasim;

/* loaded from: classes8.dex */
class AD6 {
    private final Object a;
    private final Thread b = Thread.currentThread();

    AD6(Object obj) {
        this.a = obj;
    }

    public Object a() {
        if (b()) {
            return this.a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.b == Thread.currentThread();
    }
}
