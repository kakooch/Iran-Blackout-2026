package j$.util.stream;

import j$.wrappers.C0280i0;
import j$.wrappers.C0284k0;
import j$.wrappers.C0288m0;

/* loaded from: classes2.dex */
class Z0 extends AbstractC0162h3 {
    public final /* synthetic */ int b = 4;
    final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(K k, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = k;
    }

    @Override // j$.util.stream.InterfaceC0186l3, j$.util.function.q
    public void accept(long j) {
        switch (this.b) {
            case 0:
                this.a.accept(j);
                return;
            case 1:
                this.a.accept(((j$.util.function.t) ((N) this.c).m).applyAsLong(j));
                return;
            case 2:
                this.a.accept((InterfaceC0192m3) ((j$.util.function.r) ((L) this.c).m).apply(j));
                return;
            case 3:
                this.a.accept(((C0288m0) ((M) this.c).m).a(j));
                return;
            case 4:
                this.a.accept(((C0284k0) ((K) this.c).m).a(j));
                return;
            case 5:
                InterfaceC0142e1 interfaceC0142e1 = (InterfaceC0142e1) ((j$.util.function.r) ((N) this.c).m).apply(j);
                if (interfaceC0142e1 != null) {
                    try {
                        interfaceC0142e1.sequential().e(new W0(this));
                    } finally {
                        try {
                            interfaceC0142e1.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (interfaceC0142e1 != null) {
                    return;
                } else {
                    return;
                }
            case 6:
                if (((C0280i0) ((N) this.c).m).b(j)) {
                    this.a.accept(j);
                    return;
                }
                return;
            default:
                ((j$.util.function.q) ((N) this.c).m).accept(j);
                this.a.accept(j);
                return;
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        switch (this.b) {
            case 5:
                this.a.o(-1L);
                break;
            case 6:
                this.a.o(-1L);
                break;
            default:
                this.a.o(j);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(L l, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(M m, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = m;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(N n, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(N n, InterfaceC0192m3 interfaceC0192m3, j$.lang.a aVar) {
        super(interfaceC0192m3);
        this.c = n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(N n, InterfaceC0192m3 interfaceC0192m3, j$.lang.b bVar) {
        super(interfaceC0192m3);
        this.c = n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(N n, InterfaceC0192m3 interfaceC0192m3, j$.lang.c cVar) {
        super(interfaceC0192m3);
        this.c = n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z0(O o, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = o;
    }
}
