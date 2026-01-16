package j$.util;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Comparator;
import org.rbmain.messenger.LiteMode;

/* loaded from: classes2.dex */
final class I implements t.c {
    private final long[] a;
    private int b;
    private final int c;
    private final int d;

    public I(long[] jArr, int i, int i2, int i3) {
        this.a = jArr;
        this.b = i;
        this.c = i2;
        this.d = i3 | 64 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
    }

    @Override // j$.util.t.c, j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.l(this, consumer);
    }

    @Override // j$.util.t
    public int characteristics() {
        return this.d;
    }

    @Override // j$.util.u
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void e(j$.util.function.q qVar) {
        int i;
        qVar.getClass();
        long[] jArr = this.a;
        int length = jArr.length;
        int i2 = this.c;
        if (length < i2 || (i = this.b) < 0) {
            return;
        }
        this.b = i2;
        if (i < i2) {
            do {
                qVar.accept(jArr[i]);
                i++;
            } while (i < i2);
        }
    }

    @Override // j$.util.t
    public long estimateSize() {
        return this.c - this.b;
    }

    @Override // j$.util.t.c, j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.d(this, consumer);
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

    @Override // j$.util.u
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean j(j$.util.function.q qVar) {
        qVar.getClass();
        int i = this.b;
        if (i < 0 || i >= this.c) {
            return false;
        }
        long[] jArr = this.a;
        this.b = i + 1;
        qVar.accept(jArr[i]);
        return true;
    }

    @Override // j$.util.t
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0102a.f(this, i);
    }

    @Override // j$.util.u, j$.util.t
    public t.c trySplit() {
        int i = this.b;
        int i2 = (this.c + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        long[] jArr = this.a;
        this.b = i2;
        return new I(jArr, i, i2, this.d);
    }
}
