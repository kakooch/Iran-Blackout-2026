package j$.util.stream;

import j$.wrappers.C0264a0;

/* loaded from: classes2.dex */
class F0 extends AbstractC0156g3 {
    public final /* synthetic */ int b = 0;
    final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(K k, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = k;
    }

    @Override // j$.util.stream.InterfaceC0180k3, j$.util.stream.InterfaceC0192m3
    public void accept(int i) {
        switch (this.b) {
            case 0:
                this.a.accept(i);
                return;
            case 1:
                ((j$.util.function.l) ((M) this.c).m).accept(i);
                this.a.accept(i);
                return;
            case 2:
                this.a.accept(i);
                return;
            case 3:
                this.a.accept(((C0264a0) ((M) this.c).m).a(i));
                return;
            case 4:
                this.a.accept((InterfaceC0192m3) ((j$.util.function.m) ((L) this.c).m).apply(i));
                return;
            case 5:
                this.a.accept(((j$.util.function.n) ((N) this.c).m).applyAsLong(i));
                return;
            case 6:
                this.a.accept(((j$.wrappers.W) ((K) this.c).m).a(i));
                return;
            case 7:
                IntStream intStream = (IntStream) ((j$.util.function.m) ((M) this.c).m).apply(i);
                if (intStream != null) {
                    try {
                        intStream.sequential().V(new B0(this));
                    } finally {
                        try {
                            intStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (intStream != null) {
                    return;
                } else {
                    return;
                }
            default:
                if (((j$.wrappers.U) ((M) this.c).m).b(i)) {
                    this.a.accept(i);
                    return;
                }
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        switch (this.b) {
            case 7:
                this.a.o(-1L);
                break;
            case 8:
                this.a.o(-1L);
                break;
            default:
                this.a.o(j);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(L l, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(M m, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = m;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(M m, InterfaceC0192m3 interfaceC0192m3, j$.lang.a aVar) {
        super(interfaceC0192m3);
        this.c = m;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(M m, InterfaceC0192m3 interfaceC0192m3, j$.lang.b bVar) {
        super(interfaceC0192m3);
        this.c = m;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(M m, InterfaceC0192m3 interfaceC0192m3, j$.lang.c cVar) {
        super(interfaceC0192m3);
        this.c = m;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(N n, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(O o, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = o;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(G0 g0, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = g0;
    }
}
