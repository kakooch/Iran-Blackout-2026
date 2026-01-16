package ir.nasim;

import java.util.NoSuchElementException;

/* renamed from: ir.nasim.xa3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23821xa3 extends AbstractC18386oa3 {
    private final int a;
    private final int b;
    private boolean c;
    private int d;

    public C23821xa3(int i, int i2, int i3) {
        this.a = i3;
        this.b = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.c = z;
        this.d = z ? i : i2;
    }

    @Override // ir.nasim.AbstractC18386oa3
    public int b() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
        } else {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }
}
