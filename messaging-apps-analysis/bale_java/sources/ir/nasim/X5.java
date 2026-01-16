package ir.nasim;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import ir.nasim.AbstractC9203Yx6;
import ir.nasim.X5;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class X5 extends AbstractC4043Dl1 {

    static class a {
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    static class c {
        static boolean a(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        static boolean b(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    static class d {
        static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface e {
        void s(int i);
    }

    static class f extends SharedElementCallback {
        private final AbstractC9203Yx6 a;

        f(AbstractC9203Yx6 abstractC9203Yx6) {
            this.a = abstractC9203Yx6;
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.a.b(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.a.d(context, parcelable);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List list, Map map) {
            this.a.e(list, map);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List list) {
            this.a.f(list);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List list, List list2, List list3) {
            this.a.g(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List list, List list2, List list3) {
            this.a.h(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List list, List list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.a.i(list, list2, new AbstractC9203Yx6.a() { // from class: ir.nasim.Y5
                @Override // ir.nasim.AbstractC9203Yx6.a
                public final void a() {
                    X5.b.a(onSharedElementsReadyListener);
                }
            });
        }
    }

    public static void A(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void B(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void C(Activity activity) {
        a.e(activity);
    }

    public static void r(Activity activity) {
        activity.finishAffinity();
    }

    public static void s(Activity activity) {
        a.a(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(Activity activity) {
        if (activity.isFinishing() || AbstractC16926m6.i(activity)) {
            return;
        }
        activity.recreate();
    }

    public static void u(Activity activity) {
        a.b(activity);
    }

    public static void v(final Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new Runnable() { // from class: ir.nasim.W5
                @Override // java.lang.Runnable
                public final void run() {
                    X5.t(activity);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void w(Activity activity, String[] strArr, int i) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!hashSet.contains(Integer.valueOf(i4))) {
                    strArr2[i3] = strArr[i4];
                    i3++;
                }
            }
        }
        if (activity instanceof e) {
            ((e) activity).s(i);
        }
        b.b(activity, strArr, i);
    }

    public static void x(Activity activity, AbstractC9203Yx6 abstractC9203Yx6) {
        a.c(activity, abstractC9203Yx6 != null ? new f(abstractC9203Yx6) : null);
    }

    public static void y(Activity activity, AbstractC9203Yx6 abstractC9203Yx6) {
        a.d(activity, abstractC9203Yx6 != null ? new f(abstractC9203Yx6) : null);
    }

    public static boolean z(Activity activity, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return i >= 32 ? d.a(activity, str) : i == 31 ? c.b(activity, str) : b.c(activity, str);
        }
        return false;
    }
}
