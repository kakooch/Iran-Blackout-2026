package j$.util;

import j$.util.function.Consumer;
import j$.util.t;
import java.util.Comparator;
import org.rbmain.messenger.LiteMode;

/* loaded from: classes2.dex */
final class G implements t.b {
    private final int[] a;
    private int b;
    private final int c;
    private final int d;

    public G(int[] iArr, int i, int i2, int i3) {
        this.a = iArr;
        this.b = i;
        this.c = i2;
        this.d = i3 | 64 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
    }

    @Override // j$.util.t.b, j$.util.t
    public /* synthetic */ boolean a(Consumer consumer) {
        return AbstractC0102a.k(this, consumer);
    }

    @Override // j$.util.u
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void e(j$.util.function.l lVar) {
        int i;
        lVar.getClass();
        int[] iArr = this.a;
        int length = iArr.length;
        int i2 = this.c;
        if (length < i2 || (i = this.b) < 0) {
            return;
        }
        this.b = i2;
        if (i < i2) {
            do {
                lVar.accept(iArr[i]);
                i++;
            } while (i < i2);
        }
    }

    @Override // j$.util.t
    public int characteristics() {
        return this.d;
    }

    @Override // j$.util.t
    public long estimateSize() {
        return this.c - this.b;
    }

    @Override // j$.util.t.b, j$.util.t
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0102a.c(this, consumer);
    }

    @Override // j$.util.u
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean j(j$.util.function.l lVar) {
        lVar.getClass();
        int i = this.b;
        if (i < 0 || i >= this.c) {
            return false;
        }
        int[] iArr = this.a;
        this.b = i + 1;
        lVar.accept(iArr[i]);
        return true;
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

    @Override // j$.util.u, j$.util.t
    public t.b trySplit() {
        int i = this.b;
        int i2 = (this.c + i) >>> 1;
        if (i >= i2) {
            return null;
        }
        int[] iArr = this.a;
        this.b = i2;
        return new G(iArr, i, i2, this.d);
    }
}
