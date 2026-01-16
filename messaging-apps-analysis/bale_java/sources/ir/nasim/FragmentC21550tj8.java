package ir.nasim;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.tj8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class FragmentC21550tj8 extends Fragment implements InterfaceC16269kz3 {
    private static final WeakHashMap d = new WeakHashMap();
    private final Map a = Collections.synchronizedMap(new KJ());
    private int b = 0;
    private Bundle c;

    public static FragmentC21550tj8 c(Activity activity) {
        FragmentC21550tj8 fragmentC21550tj8;
        WeakHashMap weakHashMap = d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (fragmentC21550tj8 = (FragmentC21550tj8) weakReference.get()) != null) {
            return fragmentC21550tj8;
        }
        try {
            FragmentC21550tj8 fragmentC21550tj82 = (FragmentC21550tj8) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (fragmentC21550tj82 == null || fragmentC21550tj82.isRemoving()) {
                fragmentC21550tj82 = new FragmentC21550tj8();
                activity.getFragmentManager().beginTransaction().add(fragmentC21550tj82, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(fragmentC21550tj82));
            return fragmentC21550tj82;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    @Override // ir.nasim.InterfaceC16269kz3
    public final Activity O3() {
        return getActivity();
    }

    @Override // ir.nasim.InterfaceC16269kz3
    public final void b0(String str, LifecycleCallback lifecycleCallback) {
        if (this.a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.a.put(str, lifecycleCallback);
        if (this.b > 0) {
            new Vp8(Looper.getMainLooper()).post(new RunnableC9871ah8(this, lifecycleCallback, str));
        }
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // ir.nasim.InterfaceC16269kz3
    public final LifecycleCallback f1(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.a.get(str));
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).e(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = 1;
        this.c = bundle;
        for (Map.Entry entry : this.a.entrySet()) {
            ((LifecycleCallback) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.b = 5;
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).g();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.b = 3;
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).h();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((LifecycleCallback) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.b = 2;
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).j();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.b = 4;
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((LifecycleCallback) it.next()).k();
        }
    }
}
