package ir.nasim;

import java.util.NoSuchElementException;

/* renamed from: ir.nasim.dK0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11623dK0 extends ZJ0 {
    private final int a;
    private final int b;
    private boolean c;
    private int d;

    public C11623dK0(char c, char c2, int i) {
        this.a = i;
        this.b = c2;
        boolean z = false;
        if (i <= 0 ? AbstractC13042fc3.k(c, c2) >= 0 : AbstractC13042fc3.k(c, c2) <= 0) {
            z = true;
        }
        this.c = z;
        this.d = z ? c : c2;
    }

    @Override // ir.nasim.ZJ0
    public char b() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
        } else {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
        }
        return (char) i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }
}
