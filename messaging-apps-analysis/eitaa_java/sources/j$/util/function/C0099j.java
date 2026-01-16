package j$.util.function;

/* renamed from: j$.util.function.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0099j implements E {
    public final /* synthetic */ E a;
    public final /* synthetic */ E b;

    public /* synthetic */ C0099j(E e, E e2) {
        this.a = e;
        this.b = e2;
    }

    @Override // j$.util.function.E
    public final void accept(long j) {
        E e = this.a;
        E e2 = this.b;
        e.accept(j);
        e2.accept(j);
    }

    @Override // j$.util.function.E
    public E f(E e) {
        e.getClass();
        return new C0099j(this, e);
    }
}
