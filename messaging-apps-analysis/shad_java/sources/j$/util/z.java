package j$.util;

import j$.util.function.Consumer;
import java.util.Comparator;
import org.rbmain.messenger.LiteMode;

/* loaded from: classes2.dex */
final class z implements t {
    private final Object[] a;
    private int b;
    private final int c;
    private final int d;

    public z(Object[] objArr, int i, int i2, int i3) {
        this.a = objArr;
        this.b = i;
        this.c = i2;
        this.d = i3 | 64 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
    }

    @Override // j$.util.t
    public boolean a(Consumer consumer) {
        consumer.getClass();
        int i = this.b;
        if (i < 0 || i >= this.c) {
            return false;
        }
        Object[] objArr = this.a;
        this.b = i + 1;
        consumer.accept(objArr[i]);
        return true;
    }

    @Override // j$.util.t
    public int characteristics() {
        return this.d;
    }

    @Override // j$.util.t
    public long estimateSize() {
        return this.c - this.b;
    }

    @Override // j$.util.t
    public void forEachRemaining(Consumer consumer) {
        int i;
        consumer.getClass();
        Object[] objArr = this.a;
        int length = objArr.length;
        int i2 = this.c;
        if (length < i2 || (i = this.b) < 0) {
            return;
        }
        this.b = i2;
        if (i < i2) {
            do {
                consumer.accept(objArr[i]);
                i++;
            } while (i < i2);
        }
    }

    @Override // j$.util.t
    public Comparator getComparator() {
        if (AbstractC0102a.f(this, 4)) {
            return null;
        }
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

    @Override // j$.util.t
    public t trySplit() {
        int i = this.b;
        int i2 = (this.c + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        Object[] objArr = this.a;
        this.b = i2;
        return new z(objArr, i, i2, this.d);
    }
}
