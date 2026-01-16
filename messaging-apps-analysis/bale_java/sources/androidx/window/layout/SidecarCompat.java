package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import ir.nasim.C25010za8;
import ir.nasim.ED1;
import ir.nasim.InterfaceC5868Le2;
import ir.nasim.LB6;
import ir.nasim.VR7;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* loaded from: classes2.dex */
public final class SidecarCompat implements InterfaceC5868Le2 {
    public static final a f = new a(null);
    private final SidecarInterface a;
    private final LB6 b;
    private final Map c;
    private final Map d;
    private InterfaceC5868Le2.a e;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u001d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Lir/nasim/LB6;", "sidecarAdapter", "callbackInterface", "<init>", "(Lir/nasim/LB6;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "Lir/nasim/rB7;", "onDeviceStateChanged", "(Landroidx/window/sidecar/SidecarDeviceState;)V", "Landroid/os/IBinder;", "token", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "(Landroid/os/IBinder;Landroidx/window/sidecar/SidecarWindowLayoutInfo;)V", "a", "Lir/nasim/LB6;", "b", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Ljava/util/concurrent/locks/ReentrantLock;", "c", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "d", "Landroidx/window/sidecar/SidecarDeviceState;", "lastDeviceState", "Ljava/util/WeakHashMap;", "e", "Ljava/util/WeakHashMap;", "mActivityWindowLayoutInfo", "window_release"}, k = 1, mv = {1, 6, 0})
    private static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

        /* renamed from: a, reason: from kotlin metadata */
        private final LB6 sidecarAdapter;

        /* renamed from: b, reason: from kotlin metadata */
        private final SidecarInterface.SidecarCallback callbackInterface;

        /* renamed from: c, reason: from kotlin metadata */
        private final ReentrantLock lock;

        /* renamed from: d, reason: from kotlin metadata */
        private SidecarDeviceState lastDeviceState;

        /* renamed from: e, reason: from kotlin metadata */
        private final WeakHashMap mActivityWindowLayoutInfo;

        public DistinctSidecarElementCallback(LB6 lb6, SidecarInterface.SidecarCallback sidecarCallback) {
            AbstractC13042fc3.i(lb6, "sidecarAdapter");
            AbstractC13042fc3.i(sidecarCallback, "callbackInterface");
            this.sidecarAdapter = lb6;
            this.callbackInterface = sidecarCallback;
            this.lock = new ReentrantLock();
            this.mActivityWindowLayoutInfo = new WeakHashMap();
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            AbstractC13042fc3.i(newDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.sidecarAdapter.a(this.lastDeviceState, newDeviceState)) {
                    return;
                }
                this.lastDeviceState = newDeviceState;
                this.callbackInterface.onDeviceStateChanged(newDeviceState);
                C19938rB7 c19938rB7 = C19938rB7.a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder token, SidecarWindowLayoutInfo newLayout) {
            AbstractC13042fc3.i(token, "token");
            AbstractC13042fc3.i(newLayout, "newLayout");
            synchronized (this.lock) {
                if (this.sidecarAdapter.d((SidecarWindowLayoutInfo) this.mActivityWindowLayoutInfo.get(token), newLayout)) {
                    return;
                }
                this.callbackInterface.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "<init>", "(Landroidx/window/layout/SidecarCompat;)V", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "Lir/nasim/rB7;", "onDeviceStateChanged", "(Landroidx/window/sidecar/SidecarDeviceState;)V", "Landroid/os/IBinder;", "windowToken", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "(Landroid/os/IBinder;Landroidx/window/sidecar/SidecarWindowLayoutInfo;)V", "window_release"}, k = 1, mv = {1, 6, 0})
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat a;

        public TranslatingCallback(SidecarCompat sidecarCompat) {
            AbstractC13042fc3.i(sidecarCompat, "this$0");
            this.a = sidecarCompat;
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface sidecarInterfaceG;
            AbstractC13042fc3.i(newDeviceState, "newDeviceState");
            Collection<Activity> collectionValues = this.a.c.values();
            SidecarCompat sidecarCompat = this.a;
            for (Activity activity : collectionValues) {
                IBinder iBinderA = SidecarCompat.f.a(activity);
                SidecarWindowLayoutInfo windowLayoutInfo = null;
                if (iBinderA != null && (sidecarInterfaceG = sidecarCompat.g()) != null) {
                    windowLayoutInfo = sidecarInterfaceG.getWindowLayoutInfo(iBinderA);
                }
                InterfaceC5868Le2.a aVar = sidecarCompat.e;
                if (aVar != null) {
                    aVar.a(activity, sidecarCompat.b.e(windowLayoutInfo, newDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            AbstractC13042fc3.i(windowToken, "windowToken");
            AbstractC13042fc3.i(newLayout, "newLayout");
            Activity activity = (Activity) this.a.c.get(windowToken);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            LB6 lb6 = this.a.b;
            SidecarInterface sidecarInterfaceG = this.a.g();
            SidecarDeviceState deviceState = sidecarInterfaceG == null ? null : sidecarInterfaceG.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            C25010za8 c25010za8E = lb6.e(newLayout, deviceState);
            InterfaceC5868Le2.a aVar = this.a.e;
            if (aVar == null) {
                return;
            }
            aVar.a(activity, c25010za8E);
        }
    }

    public static final class a {
        private a() {
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface b(Context context) {
            AbstractC13042fc3.i(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final VR7 c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return VR7.f.b(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b implements InterfaceC5868Le2.a {
        private final InterfaceC5868Le2.a a;
        private final ReentrantLock b;
        private final WeakHashMap c;

        public b(InterfaceC5868Le2.a aVar) {
            AbstractC13042fc3.i(aVar, "callbackInterface");
            this.a = aVar;
            this.b = new ReentrantLock();
            this.c = new WeakHashMap();
        }

        @Override // ir.nasim.InterfaceC5868Le2.a
        public void a(Activity activity, C25010za8 c25010za8) {
            AbstractC13042fc3.i(activity, "activity");
            AbstractC13042fc3.i(c25010za8, "newLayout");
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                if (AbstractC13042fc3.d(c25010za8, (C25010za8) this.c.get(activity))) {
                    return;
                }
                reentrantLock.unlock();
                this.a.a(activity, c25010za8);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private static final class c implements View.OnAttachStateChangeListener {
        private final SidecarCompat a;
        private final WeakReference b;

        public c(SidecarCompat sidecarCompat, Activity activity) {
            AbstractC13042fc3.i(sidecarCompat, "sidecarCompat");
            AbstractC13042fc3.i(activity, "activity");
            this.a = sidecarCompat;
            this.b = new WeakReference(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AbstractC13042fc3.i(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = (Activity) this.b.get();
            IBinder iBinderA = SidecarCompat.f.a(activity);
            if (activity == null || iBinderA == null) {
                return;
            }
            this.a.i(iBinderA, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            AbstractC13042fc3.i(view, "view");
        }
    }

    public static final class d implements ComponentCallbacks {
        final /* synthetic */ Activity b;

        d(Activity activity) {
            this.b = activity;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            AbstractC13042fc3.i(configuration, "newConfig");
            InterfaceC5868Le2.a aVar = SidecarCompat.this.e;
            if (aVar == null) {
                return;
            }
            Activity activity = this.b;
            aVar.a(activity, SidecarCompat.this.h(activity));
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    public SidecarCompat(SidecarInterface sidecarInterface, LB6 lb6) {
        AbstractC13042fc3.i(lb6, "sidecarAdapter");
        this.a = sidecarInterface;
        this.b = lb6;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    private final void j(Activity activity) {
        if (this.d.get(activity) == null) {
            d dVar = new d(activity);
            this.d.put(activity, dVar);
            activity.registerComponentCallbacks(dVar);
        }
    }

    private final void k(Activity activity) {
        activity.unregisterComponentCallbacks((ComponentCallbacks) this.d.get(activity));
        this.d.remove(activity);
    }

    @Override // ir.nasim.InterfaceC5868Le2
    public void a(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        IBinder iBinderA = f.a(activity);
        if (iBinderA != null) {
            i(iBinderA, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new c(this, activity));
        }
    }

    @Override // ir.nasim.InterfaceC5868Le2
    public void b(Activity activity) {
        SidecarInterface sidecarInterface;
        AbstractC13042fc3.i(activity, "activity");
        IBinder iBinderA = f.a(activity);
        if (iBinderA == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinderA);
        }
        k(activity);
        boolean z = this.c.size() == 1;
        this.c.remove(iBinderA);
        if (!z || (sidecarInterface = this.a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    @Override // ir.nasim.InterfaceC5868Le2
    public void c(InterfaceC5868Le2.a aVar) {
        AbstractC13042fc3.i(aVar, "extensionCallback");
        this.e = new b(aVar);
        SidecarInterface sidecarInterface = this.a;
        if (sidecarInterface == null) {
            return;
        }
        sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.b, new TranslatingCallback(this)));
    }

    public final SidecarInterface g() {
        return this.a;
    }

    public final C25010za8 h(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        IBinder iBinderA = f.a(activity);
        if (iBinderA == null) {
            return new C25010za8(AbstractC10360bX0.m());
        }
        SidecarInterface sidecarInterface = this.a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(iBinderA);
        LB6 lb6 = this.b;
        SidecarInterface sidecarInterface2 = this.a;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return lb6.e(windowLayoutInfo, deviceState);
    }

    public final void i(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        AbstractC13042fc3.i(iBinder, "windowToken");
        AbstractC13042fc3.i(activity, "activity");
        this.c.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.c.size() == 1 && (sidecarInterface = this.a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        InterfaceC5868Le2.a aVar = this.e;
        if (aVar != null) {
            aVar.a(activity, h(activity));
        }
        j(activity);
    }

    public boolean l() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.a;
            Method method = (sidecarInterface == null || (cls = sidecarInterface.getClass()) == null) ? null : cls.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType = method == null ? null : method.getReturnType();
            Class cls5 = Void.TYPE;
            if (!AbstractC13042fc3.d(returnType, cls5)) {
                throw new NoSuchMethodException(AbstractC13042fc3.q("Illegal return type for 'setSidecarCallback': ", returnType));
            }
            SidecarInterface sidecarInterface2 = this.a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.a;
            Method method2 = (sidecarInterface4 == null || (cls2 = sidecarInterface4.getClass()) == null) ? null : cls2.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType2 = method2 == null ? null : method2.getReturnType();
            if (!AbstractC13042fc3.d(returnType2, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException(AbstractC13042fc3.q("Illegal return type for 'getWindowLayoutInfo': ", returnType2));
            }
            SidecarInterface sidecarInterface5 = this.a;
            Method method3 = (sidecarInterface5 == null || (cls3 = sidecarInterface5.getClass()) == null) ? null : cls3.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType3 = method3 == null ? null : method3.getReturnType();
            if (!AbstractC13042fc3.d(returnType3, cls5)) {
                throw new NoSuchMethodException(AbstractC13042fc3.q("Illegal return type for 'onWindowLayoutChangeListenerAdded': ", returnType3));
            }
            SidecarInterface sidecarInterface6 = this.a;
            Method method4 = (sidecarInterface6 == null || (cls4 = sidecarInterface6.getClass()) == null) ? null : cls4.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            Class<?> returnType4 = method4 == null ? null : method4.getReturnType();
            if (!AbstractC13042fc3.d(returnType4, cls5)) {
                throw new NoSuchMethodException(AbstractC13042fc3.q("Illegal return type for 'onWindowLayoutChangeListenerRemoved': ", returnType4));
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                if (objInvoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                if (((Integer) objInvoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            AbstractC13042fc3.h(rect, "displayFeature.rect");
            sidecarDisplayFeature.setRect(rect);
            sidecarDisplayFeature.getType();
            sidecarDisplayFeature.setType(1);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
            try {
                List list = sidecarWindowLayoutInfo.displayFeatures;
                return true;
            } catch (NoSuchFieldError unused2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(sidecarDisplayFeature);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                Object objInvoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                if (objInvoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                }
                if (AbstractC13042fc3.d(arrayList, (List) objInvoke2)) {
                    return true;
                }
                throw new Exception("Invalid display feature getter/setter");
            }
        } catch (Throwable unused3) {
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f.b(context), new LB6(null, 1, null));
        AbstractC13042fc3.i(context, "context");
    }
}
