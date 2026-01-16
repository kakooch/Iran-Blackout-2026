package ir.nasim;

import android.view.Surface;
import ir.nasim.C15315jN4;
import java.util.Objects;

/* renamed from: ir.nasim.oN4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC18270oN4 implements C15315jN4.a {
    final Object a;

    AbstractC18270oN4(Object obj) {
        this.a = obj;
    }

    @Override // ir.nasim.C15315jN4.a
    public void b(Surface surface) {
        AbstractC4980Hj5.h(surface, "Surface must not be null");
        if (getSurface() == surface) {
            throw new IllegalStateException("Surface is already added!");
        }
        if (!i()) {
            throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
        }
        throw new IllegalArgumentException("Exceeds maximum number of surfaces");
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC18270oN4) {
            return Objects.equals(this.a, ((AbstractC18270oN4) obj).a);
        }
        return false;
    }

    @Override // ir.nasim.C15315jN4.a
    public abstract Surface getSurface();

    public int hashCode() {
        return this.a.hashCode();
    }

    abstract boolean i();

    @Override // ir.nasim.C15315jN4.a
    public void a(long j) {
    }

    @Override // ir.nasim.C15315jN4.a
    public void g(int i) {
    }
}
