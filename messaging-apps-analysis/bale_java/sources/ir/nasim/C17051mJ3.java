package ir.nasim;

import java.util.NoSuchElementException;

/* renamed from: ir.nasim.mJ3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17051mJ3 extends AbstractC12869fJ3 {
    private final long a;
    private final long b;
    private boolean c;
    private long d;

    public C17051mJ3(long j, long j2, long j3) {
        this.a = j3;
        this.b = j2;
        boolean z = false;
        if (j3 <= 0 ? j >= j2 : j <= j2) {
            z = true;
        }
        this.c = z;
        this.d = z ? j : j2;
    }

    @Override // ir.nasim.AbstractC12869fJ3
    public long b() {
        long j = this.d;
        if (j != this.b) {
            this.d = this.a + j;
        } else {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
        }
        return j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }
}
