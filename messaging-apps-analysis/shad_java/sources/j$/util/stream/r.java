package j$.util.stream;

import j$.util.function.Function;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
class r extends AbstractC0168i3 {
    public final /* synthetic */ int b = 3;
    Object c;
    final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(C0223s c0223s, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.d = c0223s;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        switch (this.b) {
            case 0:
                if (((Set) this.c).contains(obj)) {
                    return;
                }
                ((Set) this.c).add(obj);
                this.a.accept((InterfaceC0192m3) obj);
                return;
            case 1:
                InterfaceC0142e1 interfaceC0142e1 = (InterfaceC0142e1) ((Function) ((N) this.d).m).apply(obj);
                if (interfaceC0142e1 != null) {
                    try {
                        interfaceC0142e1.sequential().e((j$.util.function.q) this.c);
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
            case 2:
                IntStream intStream = (IntStream) ((Function) ((M) this.d).m).apply(obj);
                if (intStream != null) {
                    try {
                        intStream.sequential().V((j$.util.function.l) this.c);
                    } finally {
                        try {
                            intStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
                if (intStream != null) {
                    return;
                } else {
                    return;
                }
            default:
                U u = (U) ((Function) ((K) this.d).m).apply(obj);
                if (u != null) {
                    try {
                        u.sequential().k((j$.util.function.f) this.c);
                    } finally {
                        try {
                            u.close();
                        } catch (Throwable unused3) {
                        }
                    }
                }
                if (u != null) {
                    return;
                } else {
                    return;
                }
        }
    }

    @Override // j$.util.stream.AbstractC0168i3, j$.util.stream.InterfaceC0192m3
    public void n() {
        switch (this.b) {
            case 0:
                this.c = null;
                this.a.n();
                break;
            default:
                this.a.n();
                break;
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        switch (this.b) {
            case 0:
                this.c = new HashSet();
                this.a.o(-1L);
                break;
            case 1:
                this.a.o(-1L);
                break;
            case 2:
                this.a.o(-1L);
                break;
            default:
                this.a.o(-1L);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(K k, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.d = k;
        this.c = new F(interfaceC0192m3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(M m, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.d = m;
        this.c = new B0(interfaceC0192m3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(N n, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.d = n;
        this.c = new W0(interfaceC0192m3);
    }
}
