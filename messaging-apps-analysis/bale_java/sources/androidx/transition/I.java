package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes2.dex */
class I implements J {
    private final WindowId a;

    I(View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof I) && ((I) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
