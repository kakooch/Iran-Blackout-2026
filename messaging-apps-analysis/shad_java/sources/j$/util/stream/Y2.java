package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.ToIntFunction;

/* loaded from: classes2.dex */
class Y2 extends AbstractC0168i3 {
    public final /* synthetic */ int b = 5;
    final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y2(K k, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = k;
    }

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        switch (this.b) {
            case 0:
                ((Consumer) ((L) this.c).m).accept(obj);
                this.a.accept((InterfaceC0192m3) obj);
                return;
            case 1:
                if (((j$.util.function.y) ((L) this.c).m).test(obj)) {
                    this.a.accept((InterfaceC0192m3) obj);
                    return;
                }
                return;
            case 2:
                this.a.accept((InterfaceC0192m3) ((C0120a3) this.c).m.apply(obj));
                return;
            case 3:
                this.a.accept(((ToIntFunction) ((M) this.c).m).applyAsInt(obj));
                return;
            case 4:
                this.a.accept(((j$.util.function.B) ((N) this.c).m).applyAsLong(obj));
                return;
            case 5:
                this.a.accept(((j$.util.function.A) ((K) this.c).m).applyAsDouble(obj));
                return;
            default:
                InterfaceC0127b4 interfaceC0127b4 = (InterfaceC0127b4) ((C0120a3) this.c).m.apply(obj);
                if (interfaceC0127b4 != null) {
                    try {
                        ((InterfaceC0127b4) interfaceC0127b4.sequential()).a(this.a);
                    } finally {
                        try {
                            interfaceC0127b4.close();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (interfaceC0127b4 != null) {
                    return;
                } else {
                    return;
                }
        }
    }

    @Override // j$.util.stream.InterfaceC0192m3
    public void o(long j) {
        switch (this.b) {
            case 1:
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
    public Y2(L l, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y2(L l, InterfaceC0192m3 interfaceC0192m3, j$.lang.a aVar) {
        super(interfaceC0192m3);
        this.c = l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y2(M m, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = m;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y2(N n, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y2(C0120a3 c0120a3, InterfaceC0192m3 interfaceC0192m3) {
        super(interfaceC0192m3);
        this.c = c0120a3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y2(C0120a3 c0120a3, InterfaceC0192m3 interfaceC0192m3, j$.lang.a aVar) {
        super(interfaceC0192m3);
        this.c = c0120a3;
    }
}
