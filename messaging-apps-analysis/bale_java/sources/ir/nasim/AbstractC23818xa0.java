package ir.nasim;

import java.util.Queue;

/* renamed from: ir.nasim.xa0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC23818xa0 {
    private final Queue a = YM7.g(20);

    AbstractC23818xa0() {
    }

    abstract InterfaceC17877ni5 a();

    InterfaceC17877ni5 b() {
        InterfaceC17877ni5 interfaceC17877ni5 = (InterfaceC17877ni5) this.a.poll();
        return interfaceC17877ni5 == null ? a() : interfaceC17877ni5;
    }

    public void c(InterfaceC17877ni5 interfaceC17877ni5) {
        if (this.a.size() < 20) {
            this.a.offer(interfaceC17877ni5);
        }
    }
}
