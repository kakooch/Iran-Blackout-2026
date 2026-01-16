package j$.util.stream;

/* loaded from: classes2.dex */
class J extends AbstractC0150f3 {
    public final /* synthetic */ int b = 0;
    final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(K k, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = k;
    }

    @Override // j$.util.stream.InterfaceC0174j3, j$.util.stream.InterfaceC0192m3
    public void accept(double d) {
        switch (this.b) {
            case 0:
                this.a.accept(((j$.wrappers.J) ((K) this.c).m).a(d));
                return;
            case 1:
                this.a.accept((InterfaceC0192m3) ((j$.util.function.g) ((L) this.c).m).apply(d));
                return;
            case 2:
                this.a.accept(((j$.wrappers.F) ((M) this.c).m).a(d));
                return;
            case 3:
                this.a.accept(((j$.util.function.h) ((N) this.c).m).applyAsLong(d));
                return;
            case 4:
                U u = (U) ((j$.util.function.g) ((K) this.c).m).apply(d);
                if (u != null) {
                    try {
                        u.sequential().k(new F(this));
                    } finally {
                        try {
                            u.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (u != null) {
                    return;
                } else {
                    return;
                }
            case 5:
                if (((j$.wrappers.D) ((K) this.c).m).b(d)) {
                    this.a.accept(d);
                    return;
                }
                return;
            default:
                ((j$.util.function.f) ((K) this.c).m).accept(d);
                this.a.accept(d);
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        switch (this.b) {
            case 4:
                this.a.o(-1L);
                break;
            case 5:
                this.a.o(-1L);
                break;
            default:
                this.a.o(j);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(K k, InterfaceC0192m3 interfaceC0192m3, j$.lang.a aVar) {
        super(interfaceC0192m3);
        this.c = k;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(K k, InterfaceC0192m3 interfaceC0192m3, j$.lang.b bVar) {
        super(interfaceC0192m3);
        this.c = k;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(K k, InterfaceC0192m3 interfaceC0192m3, j$.lang.c cVar) {
        super(interfaceC0192m3);
        this.c = k;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(L l, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(M m, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = m;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(N n, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = n;
    }
}
