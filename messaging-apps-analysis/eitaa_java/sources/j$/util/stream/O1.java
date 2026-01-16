package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
abstract class O1<T> implements C2<T> {
    boolean a;
    boolean b;

    O1(P1 p1) {
        this.b = !p1.c;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(double d) {
        j$.time.a.c(this);
        throw null;
    }

    @Override // j$.util.stream.C2, j$.util.function.y
    public /* synthetic */ void accept(int i) {
        j$.time.a.a(this);
        throw null;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ void accept(long j) {
        j$.time.a.b(this);
        throw null;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.C2
    public void l() {
    }

    @Override // j$.util.stream.C2
    public void m(long j) {
    }

    @Override // j$.util.stream.C2
    public boolean o() {
        return this.a;
    }
}
