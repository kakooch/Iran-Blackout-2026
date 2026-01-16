package ir.nasim;

import android.util.Size;
import java.util.Comparator;

/* renamed from: ir.nasim.k01, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15686k01 implements Comparator {
    private boolean a;

    public C15686k01() {
        this(false);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Size size, Size size2) {
        int iSignum = Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        return this.a ? iSignum * (-1) : iSignum;
    }

    public C15686k01(boolean z) {
        this.a = z;
    }
}
