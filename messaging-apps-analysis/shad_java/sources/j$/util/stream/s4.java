package j$.util.stream;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class s4 implements InterfaceC0186l3 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;

    public /* synthetic */ s4(j$.util.function.q qVar) {
        this.b = qVar;
    }

    public /* synthetic */ void a(Long l) {
        switch (this.a) {
            case 0:
                AbstractC0202o1.c(this, l);
                break;
            default:
                AbstractC0202o1.c(this, l);
                break;
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(double d) {
        switch (this.a) {
            case 0:
                AbstractC0202o1.f(this);
                throw null;
            default:
                AbstractC0202o1.f(this);
                throw null;
        }
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.q
    public j$.util.function.q f(j$.util.function.q qVar) {
        switch (this.a) {
            case 0:
                qVar.getClass();
                break;
            default:
                qVar.getClass();
                break;
        }
        return new j$.util.function.p(this, qVar);
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void n() {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void o(long j) {
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ boolean p() {
        return false;
    }

    public /* synthetic */ s4(Y3 y3) {
        this.b = y3;
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public /* synthetic */ void accept(int i) {
        switch (this.a) {
            case 0:
                AbstractC0202o1.d(this);
                throw null;
            default:
                AbstractC0202o1.d(this);
                throw null;
        }
    }

    @Override // j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public final void accept(long j) {
        switch (this.a) {
            case 0:
                ((j$.util.function.q) this.b).accept(j);
                break;
            default:
                ((Y3) this.b).accept(j);
                break;
        }
    }

    @Override // j$.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.a) {
            case 0:
                a((Long) obj);
                break;
            default:
                a((Long) obj);
                break;
        }
    }
}
