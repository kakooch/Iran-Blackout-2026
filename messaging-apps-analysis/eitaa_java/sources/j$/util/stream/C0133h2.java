package j$.util.stream;

import j$.util.Optional;
import j$.util.function.Consumer;

/* JADX INFO: Add missing generic type declarations: [T] */
/* renamed from: j$.util.stream.h2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0133h2<T> implements InterfaceC0192w2<T, Optional<T>, C0133h2> {
    private boolean a;
    private Object b;
    final /* synthetic */ j$.util.function.p c;

    C0133h2(j$.util.function.p pVar) {
        this.c = pVar;
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
    public void accept(Object obj) {
        if (this.a) {
            this.a = false;
        } else {
            obj = this.c.apply(this.b, obj);
        }
        this.b = obj;
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.L
    public Object get() {
        return this.a ? Optional.empty() : Optional.of(this.b);
    }

    @Override // j$.util.stream.InterfaceC0192w2
    public void h(InterfaceC0192w2 interfaceC0192w2) {
        C0133h2 c0133h2 = (C0133h2) interfaceC0192w2;
        if (c0133h2.a) {
            return;
        }
        accept(c0133h2.b);
    }

    @Override // j$.util.stream.C2
    public void l() {
    }

    @Override // j$.util.stream.C2
    public void m(long j) {
        this.a = true;
        this.b = null;
    }

    @Override // j$.util.stream.C2
    public /* synthetic */ boolean o() {
        return false;
    }
}
