package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.q4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0217q4 implements InterfaceC0180k3 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0217q4(j$.util.function.l lVar) {
        this.b = lVar;
    }

    public /* synthetic */ void a(Integer num) {
        switch (this.a) {
            case 0:
                AbstractC0202o1.b(this, num);
                break;
            default:
                AbstractC0202o1.b(this, num);
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

    @Override // j$.util.function.l
    public j$.util.function.l m(j$.util.function.l lVar) {
        switch (this.a) {
            case 0:
                lVar.getClass();
                break;
            default:
                lVar.getClass();
                break;
        }
        return new j$.util.function.k(this, lVar);
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

    public /* synthetic */ C0217q4(W3 w3) {
        this.b = w3;
    }

    @Override // j$.util.stream.InterfaceC0180k3, j$.util.stream.InterfaceC0192m3
    public final void accept(int i) {
        switch (this.a) {
            case 0:
                ((j$.util.function.l) this.b).accept(i);
                break;
            default:
                ((W3) this.b).accept(i);
                break;
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3, j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public /* synthetic */ void accept(long j) {
        switch (this.a) {
            case 0:
                AbstractC0202o1.e(this);
                throw null;
            default:
                AbstractC0202o1.e(this);
                throw null;
        }
    }

    @Override // j$.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.a) {
            case 0:
                a((Integer) obj);
                break;
            default:
                a((Integer) obj);
                break;
        }
    }
}
