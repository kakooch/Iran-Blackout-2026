package ir.nasim;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: ir.nasim.jo6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C15574jo6 extends AbstractC23344wl6 {
    private final AtomicReferenceArray e;

    public C15574jo6(long j, C15574jo6 c15574jo6, int i) {
        super(j, c15574jo6, i);
        this.e = new AtomicReferenceArray(AbstractC14984io6.f);
    }

    @Override // ir.nasim.AbstractC23344wl6
    public int n() {
        return AbstractC14984io6.f;
    }

    @Override // ir.nasim.AbstractC23344wl6
    public void o(int i, Throwable th, InterfaceC11938do1 interfaceC11938do1) {
        r().set(i, AbstractC14984io6.e);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }
}
