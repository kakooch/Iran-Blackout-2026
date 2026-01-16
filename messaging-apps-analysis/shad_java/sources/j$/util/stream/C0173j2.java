package j$.util.stream;

import j$.util.function.Consumer;
import java.util.Deque;

/* renamed from: j$.util.stream.j2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0173j2 extends AbstractC0179k2 {
    C0173j2(A1 a1) {
        super(a1);
    }

    @Override // j$.util.t
    public boolean a(Consumer consumer) {
        A1 a1B;
        if (!i()) {
            return false;
        }
        boolean zA = this.d.a(consumer);
        if (!zA) {
            if (this.c == null && (a1B = b(this.e)) != null) {
                j$.util.t tVarSpliterator = a1B.spliterator();
                this.d = tVarSpliterator;
                return tVarSpliterator.a(consumer);
            }
            this.a = null;
        }
        return zA;
    }

    @Override // j$.util.t
    public void forEachRemaining(Consumer consumer) {
        if (this.a == null) {
            return;
        }
        if (this.d != null) {
            while (a(consumer)) {
            }
            return;
        }
        j$.util.t tVar = this.c;
        if (tVar != null) {
            tVar.forEachRemaining(consumer);
            return;
        }
        Deque dequeF = f();
        while (true) {
            A1 a1B = b(dequeF);
            if (a1B == null) {
                this.a = null;
                return;
            }
            a1B.a(consumer);
        }
    }
}
