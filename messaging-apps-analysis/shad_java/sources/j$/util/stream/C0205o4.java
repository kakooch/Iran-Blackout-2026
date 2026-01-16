package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.o4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0205o4 implements InterfaceC0174j3 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0205o4(j$.util.function.f fVar) {
        this.b = fVar;
    }

    public /* synthetic */ void a(Double d) {
        switch (this.a) {
            case 0:
                AbstractC0202o1.a(this, d);
                break;
            default:
                AbstractC0202o1.a(this, d);
                break;
        }
    }

    @Override // j$.util.stream.InterfaceC0174j3, j$.util.stream.InterfaceC0192m3
    public final void accept(double d) {
        switch (this.a) {
            case 0:
                ((j$.util.function.f) this.b).accept(d);
                break;
            default:
                ((U3) this.b).accept(d);
                break;
        }
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.a) {
        }
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        switch (this.a) {
            case 0:
                fVar.getClass();
                break;
            default:
                fVar.getClass();
                break;
        }
        return new j$.util.function.e(this, fVar);
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

    public /* synthetic */ C0205o4(U3 u3) {
        this.b = u3;
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
                a((Double) obj);
                break;
            default:
                a((Double) obj);
                break;
        }
    }
}
