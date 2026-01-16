package ir.nasim;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;

/* renamed from: ir.nasim.dz3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C12069dz3 {
    private final Object a;

    public C12069dz3(Activity activity) {
        AbstractC3795Cj5.k(activity, "Activity must not be null");
        this.a = activity;
    }

    public final Activity a() {
        return (Activity) this.a;
    }

    public final FragmentActivity b() {
        return (FragmentActivity) this.a;
    }

    public final boolean c() {
        return this.a instanceof Activity;
    }

    public final boolean d() {
        return this.a instanceof FragmentActivity;
    }
}
