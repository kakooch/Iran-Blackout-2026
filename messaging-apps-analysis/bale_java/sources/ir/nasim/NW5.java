package ir.nasim;

import android.content.res.Resources;
import android.util.TypedValue;

/* loaded from: classes2.dex */
public final class NW5 {
    private final C16734lm4 a = new C16734lm4(0, 1, null);

    public final void a() {
        synchronized (this) {
            this.a.g();
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final TypedValue b(Resources resources, int i) {
        TypedValue typedValue;
        synchronized (this) {
            typedValue = (TypedValue) this.a.b(i);
            if (typedValue == null) {
                typedValue = new TypedValue();
                resources.getValue(i, typedValue, true);
                this.a.n(i, typedValue);
            }
        }
        return typedValue;
    }
}
