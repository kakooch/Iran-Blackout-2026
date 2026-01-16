package j$.util;

import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class E extends F implements t {
    E() {
    }

    @Override // j$.util.t
    public boolean a(Consumer consumer) {
        consumer.getClass();
        return false;
    }

    @Override // j$.util.t
    public void forEachRemaining(Consumer consumer) {
        consumer.getClass();
    }

    @Override // j$.util.t
    public Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // j$.util.t
    public /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0102a.e(this);
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0102a.f(this, i);
    }
}
