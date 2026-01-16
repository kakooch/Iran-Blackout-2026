package ir.nasim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class Tl8 extends Fragment implements InterfaceC16269kz3 {
    private static final WeakHashMap Z0 = new WeakHashMap();
    private final Map W0 = Collections.synchronizedMap(new KJ());
    private int X0 = 0;
    private Bundle Y0;

    public static Tl8 t8(FragmentActivity fragmentActivity) {
        Tl8 tl8;
        WeakHashMap weakHashMap = Z0;
        WeakReference weakReference = (WeakReference) weakHashMap.get(fragmentActivity);
        if (weakReference != null && (tl8 = (Tl8) weakReference.get()) != null) {
            return tl8;
        }
        try {
            Tl8 tl82 = (Tl8) fragmentActivity.B0().p0("SupportLifecycleFragmentImpl");
            if (tl82 == null || tl82.A6()) {
                tl82 = new Tl8();
                fragmentActivity.B0().s().e(tl82, "SupportLifecycleFragmentImpl").i();
            }
            weakHashMap.put(fragmentActivity, new WeakReference(tl82));
            return tl82;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void H6(int i, int i2, Intent intent) {
        super.H6(i, i2, intent);
        Iterator it = this.W0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void M6(Bundle bundle) {
        super.M6(bundle);
        this.X0 = 1;
        this.Y0 = bundle;
        for (Map.Entry entry : this.W0.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // ir.nasim.InterfaceC16269kz3
    public final /* synthetic */ Activity O3() {
        return A5();
    }

    @Override // androidx.fragment.app.Fragment
    public final void R6() {
        super.R6();
        this.X0 = 5;
        Iterator it = this.W0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // ir.nasim.InterfaceC16269kz3
    public final void b0(String str, LifecycleCallback lifecycleCallback) {
        if (this.W0.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.W0.put(str, lifecycleCallback);
        if (this.X0 > 0) {
            new Vp8(Looper.getMainLooper()).post(new Vk8(this, lifecycleCallback, str));
        }
    }

    @Override // ir.nasim.InterfaceC16269kz3
    public final LifecycleCallback f1(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.W0.get(str));
    }

    @Override // androidx.fragment.app.Fragment
    public final void h7() {
        super.h7();
        this.X0 = 3;
        Iterator it = this.W0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void i7(Bundle bundle) {
        super.i7(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.W0.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void j7() {
        super.j7();
        this.X0 = 2;
        Iterator it = this.W0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void k7() {
        super.k7();
        this.X0 = 4;
        Iterator it = this.W0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).k();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void w5(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.w5(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.W0.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }
}
