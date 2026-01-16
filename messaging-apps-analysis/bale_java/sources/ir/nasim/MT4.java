package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public final class MT4 {
    public static final a g = new a(null);
    public final int a;
    public final int b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public MT4(int i, int i2, boolean z, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        if (!z && i2 == 0) {
            throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in PagingData, so either placeholders must be enabled, or prefetch distance must be > 0.");
        }
        if (i4 == Integer.MAX_VALUE || i4 >= (i2 * 2) + i) {
            if (i5 != Integer.MIN_VALUE && i5 <= 0) {
                throw new IllegalArgumentException("jumpThreshold must be positive to enable jumps or COUNT_UNDEFINED to disable jumping.".toString());
            }
            return;
        }
        throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + i + ", prefetchDist=" + i2 + ", maxSize=" + i4);
    }

    public /* synthetic */ MT4(int i, int i2, boolean z, int i3, int i4, int i5, int i6, ED1 ed1) {
        this(i, (i6 & 2) != 0 ? i : i2, (i6 & 4) != 0 ? true : z, (i6 & 8) != 0 ? i * 3 : i3, (i6 & 16) != 0 ? Integer.MAX_VALUE : i4, (i6 & 32) != 0 ? RecyclerView.UNDEFINED_DURATION : i5);
    }
}
