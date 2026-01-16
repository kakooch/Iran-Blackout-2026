package ir.nasim;

import android.content.Context;
import android.util.DisplayMetrics;
import ir.nasim.FT1;

/* loaded from: classes2.dex */
public final class DV1 implements ZD6 {
    private final Context b;

    public DV1(Context context) {
        this.b = context;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DV1) && AbstractC13042fc3.d(this.b, ((DV1) obj).b);
    }

    @Override // ir.nasim.ZD6
    public Object f(InterfaceC20295rm1 interfaceC20295rm1) {
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        FT1.a aVarA = AbstractC13301g.a(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new PD6(aVarA, aVarA);
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}
