package j$.util;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Comparator;
import org.rbmain.messenger.LiteMode;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes2.dex */
class H implements t {
    private final Collection a;
    private java.util.Iterator b = null;
    private final int c;
    private long d;
    private int e;

    public H(Collection collection, int i) {
        this.a = collection;
        this.c = (i & 4096) == 0 ? i | 64 | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM : i;
    }

    @Override // j$.util.t
    public boolean a(Consumer consumer) {
        consumer.getClass();
        if (this.b == null) {
            this.b = this.a.iterator();
            this.d = this.a.size();
        }
        if (!this.b.hasNext()) {
            return false;
        }
        consumer.accept(this.b.next());
        return true;
    }

    @Override // j$.util.t
    public int characteristics() {
        return this.c;
    }

    @Override // j$.util.t
    public long estimateSize() {
        if (this.b != null) {
            return this.d;
        }
        this.b = this.a.iterator();
        long size = this.a.size();
        this.d = size;
        return size;
    }

    @Override // j$.util.t
    public void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        java.util.Iterator it = this.b;
        if (it == null) {
            it = this.a.iterator();
            this.b = it;
            this.d = this.a.size();
        }
        if (it instanceof Iterator) {
            ((Iterator) it).forEachRemaining(consumer);
        } else {
            Iterator.CC.$default$forEachRemaining(it, consumer);
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
        long size;
        java.util.Iterator it = this.b;
        if (it == null) {
            it = this.a.iterator();
            this.b = it;
            size = this.a.size();
            this.d = size;
        } else {
            size = this.d;
        }
        if (size <= 1 || !it.hasNext()) {
            return null;
        }
        int i = this.e + 1024;
        if (i > size) {
            i = (int) size;
        }
        if (i > 33554432) {
            i = ConnectionsManager.FileTypeVideo;
        }
        Object[] objArr = new Object[i];
        int i2 = 0;
        do {
            objArr[i2] = it.next();
            i2++;
            if (i2 >= i) {
                break;
            }
        } while (it.hasNext());
        this.e = i2;
        long j = this.d;
        if (j != Long.MAX_VALUE) {
            this.d = j - i2;
        }
        return new z(objArr, 0, i2, this.c);
    }
}
