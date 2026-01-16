package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
final class OH6 implements Iterator, InterfaceC17915nm3 {
    private final C21850uE6 a;
    private final int b;
    private final VN2 c;
    private final PH6 d;
    private final int e;
    private int f;

    public OH6(C21850uE6 c21850uE6, int i, VN2 vn2, PH6 ph6) {
        this.a = c21850uE6;
        this.b = i;
        this.d = ph6;
        this.e = c21850uE6.Q();
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC7991Ub1 next() {
        Object obj;
        ArrayList arrayListD = this.c.d();
        if (arrayListD != null) {
            int i = this.f;
            this.f = i + 1;
            obj = arrayListD.get(i);
        } else {
            obj = null;
        }
        if (obj instanceof C6669Om) {
            return new C22440vE6(this.a, ((C6669Om) obj).a(), this.e);
        }
        if (obj instanceof VN2) {
            return new QH6(this.a, this.b, (VN2) obj, new KM5(this.d, this.f - 1));
        }
        AbstractC5138Ib1.t("Unexpected group information structure");
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        ArrayList arrayListD = this.c.d();
        return arrayListD != null && this.f < arrayListD.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
