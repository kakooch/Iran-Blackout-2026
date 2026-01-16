package j$.util.stream;

import java.util.Deque;

/* renamed from: j$.util.stream.i2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0167i2 extends AbstractC0179k2 implements j$.util.u {
    AbstractC0167i2(InterfaceC0260z1 interfaceC0260z1) {
        super(interfaceC0260z1);
    }

    @Override // j$.util.u
    /* renamed from: forEachRemaining, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void e(Object obj) {
        if (this.a == null) {
            return;
        }
        if (this.d != null) {
            while (j(obj)) {
            }
            return;
        }
        j$.util.t tVar = this.c;
        if (tVar != null) {
            ((j$.util.u) tVar).e(obj);
            return;
        }
        Deque dequeF = f();
        while (true) {
            InterfaceC0260z1 interfaceC0260z1 = (InterfaceC0260z1) b(dequeF);
            if (interfaceC0260z1 == null) {
                this.a = null;
                return;
            }
            interfaceC0260z1.h(obj);
        }
    }

    @Override // j$.util.u
    /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public boolean j(Object obj) {
        InterfaceC0260z1 interfaceC0260z1;
        if (!i()) {
            return false;
        }
        boolean zJ = ((j$.util.u) this.d).j(obj);
        if (!zJ) {
            if (this.c == null && (interfaceC0260z1 = (InterfaceC0260z1) b(this.e)) != null) {
                j$.util.u uVarSpliterator = interfaceC0260z1.spliterator();
                this.d = uVarSpliterator;
                return uVarSpliterator.j(obj);
            }
            this.a = null;
        }
        return zJ;
    }
}
