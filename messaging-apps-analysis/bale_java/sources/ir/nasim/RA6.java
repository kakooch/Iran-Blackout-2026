package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.C15791kA6;
import ir.nasim.EA6;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class RA6 {
    private static volatile EA6 a;
    private static volatile List b;

    private static class a {
        static String a(List list) {
            Iterator it = list.iterator();
            int rank = -1;
            String id = null;
            while (it.hasNext()) {
                ShortcutInfo shortcutInfo = (ShortcutInfo) it.next();
                if (shortcutInfo.getRank() > rank) {
                    id = shortcutInfo.getId();
                    rank = shortcutInfo.getRank();
                }
            }
            return id;
        }
    }

    public static boolean a(Context context, List list) {
        List listL = l(list, 1);
        int i = Build.VERSION.SDK_INT;
        if (i <= 29) {
            c(context, listL);
        }
        if (i >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator it = listL.iterator();
            while (it.hasNext()) {
                arrayList.add(((C15791kA6) it.next()).p());
            }
            if (!IA6.a(context.getSystemService(FA6.a())).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        h(context).a(listL);
        Iterator it2 = g(context).iterator();
        if (!it2.hasNext()) {
            return true;
        }
        AbstractC18350oW3.a(it2.next());
        throw null;
    }

    static boolean b(Context context, C15791kA6 c15791kA6) {
        Bitmap bitmapDecodeStream;
        IconCompat iconCompat = c15791kA6.i;
        if (iconCompat == null) {
            return false;
        }
        int i = iconCompat.a;
        if (i != 6 && i != 4) {
            return true;
        }
        InputStream inputStreamS = iconCompat.s(context);
        if (inputStreamS == null || (bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamS)) == null) {
            return false;
        }
        c15791kA6.i = i == 6 ? IconCompat.f(bitmapDecodeStream) : IconCompat.i(bitmapDecodeStream);
        return true;
    }

    static void c(Context context, List list) {
        for (C15791kA6 c15791kA6 : new ArrayList(list)) {
            if (!b(context, c15791kA6)) {
                list.remove(c15791kA6);
            }
        }
    }

    public static List d(Context context) {
        if (Build.VERSION.SDK_INT < 25) {
            try {
                return h(context).b();
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        List dynamicShortcuts = IA6.a(context.getSystemService(FA6.a())).getDynamicShortcuts();
        ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
        Iterator it = dynamicShortcuts.iterator();
        while (it.hasNext()) {
            arrayList.add(new C15791kA6.b(context, MA6.a(it.next())).a());
        }
        return arrayList;
    }

    public static int e(Context context) {
        AbstractC4980Hj5.g(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return IA6.a(context.getSystemService(FA6.a())).getMaxShortcutCountPerActivity();
        }
        return 5;
    }

    private static String f(List list) {
        Iterator it = list.iterator();
        int iM = -1;
        String strF = null;
        while (it.hasNext()) {
            C15791kA6 c15791kA6 = (C15791kA6) it.next();
            if (c15791kA6.m() > iM) {
                strF = c15791kA6.f();
                iM = c15791kA6.m();
            }
        }
        return strF;
    }

    private static List g(Context context) {
        Bundle bundle;
        String string;
        if (b == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
            intent.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 128).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString("androidx.core.content.pm.shortcut_listener_impl")) != null) {
                    try {
                        AbstractC18350oW3.a(Class.forName(string, false, RA6.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                        arrayList.add(null);
                    } catch (Exception unused) {
                    }
                }
            }
            if (b == null) {
                b = arrayList;
            }
        }
        return b;
    }

    private static EA6 h(Context context) {
        if (a == null) {
            try {
                a = (EA6) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, RA6.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
            } catch (Exception unused) {
            }
            if (a == null) {
                a = new EA6.a();
            }
        }
        return a;
    }

    public static boolean i(Context context, C15791kA6 c15791kA6) {
        AbstractC4980Hj5.g(context);
        AbstractC4980Hj5.g(c15791kA6);
        int i = Build.VERSION.SDK_INT;
        if (i <= 32 && c15791kA6.o(1)) {
            Iterator it = g(context).iterator();
            if (!it.hasNext()) {
                return true;
            }
            AbstractC18350oW3.a(it.next());
            Collections.singletonList(c15791kA6);
            throw null;
        }
        int iE = e(context);
        if (iE == 0) {
            return false;
        }
        if (i <= 29) {
            b(context, c15791kA6);
        }
        if (i >= 30) {
            IA6.a(context.getSystemService(FA6.a())).pushDynamicShortcut(c15791kA6.p());
        } else if (i >= 25) {
            ShortcutManager shortcutManagerA = IA6.a(context.getSystemService(FA6.a()));
            if (shortcutManagerA.isRateLimitingActive()) {
                return false;
            }
            List dynamicShortcuts = shortcutManagerA.getDynamicShortcuts();
            if (dynamicShortcuts.size() >= iE) {
                shortcutManagerA.removeDynamicShortcuts(Arrays.asList(a.a(dynamicShortcuts)));
            }
            shortcutManagerA.addDynamicShortcuts(Arrays.asList(c15791kA6.p()));
        }
        EA6 ea6H = h(context);
        try {
            List listB = ea6H.b();
            if (listB.size() >= iE) {
                ea6H.d(Arrays.asList(f(listB)));
            }
            ea6H.a(Arrays.asList(c15791kA6));
            Iterator it2 = g(context).iterator();
            if (!it2.hasNext()) {
                m(context, c15791kA6.f());
                return true;
            }
            AbstractC18350oW3.a(it2.next());
            Collections.singletonList(c15791kA6);
            throw null;
        } catch (Exception unused) {
            Iterator it3 = g(context).iterator();
            if (!it3.hasNext()) {
                m(context, c15791kA6.f());
                return false;
            }
            AbstractC18350oW3.a(it3.next());
            Collections.singletonList(c15791kA6);
            throw null;
        } catch (Throwable th) {
            Iterator it4 = g(context).iterator();
            if (!it4.hasNext()) {
                m(context, c15791kA6.f());
                throw th;
            }
            AbstractC18350oW3.a(it4.next());
            Collections.singletonList(c15791kA6);
            throw null;
        }
    }

    public static void j(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            IA6.a(context.getSystemService(FA6.a())).removeAllDynamicShortcuts();
        }
        h(context).c();
        Iterator it = g(context).iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }

    public static void k(Context context, List list) {
        if (Build.VERSION.SDK_INT >= 25) {
            IA6.a(context.getSystemService(FA6.a())).removeDynamicShortcuts(list);
        }
        h(context).d(list);
        Iterator it = g(context).iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }

    private static List l(List list, int i) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 32) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C15791kA6 c15791kA6 = (C15791kA6) it.next();
            if (c15791kA6.o(i)) {
                arrayList.remove(c15791kA6);
            }
        }
        return arrayList;
    }

    public static void m(Context context, String str) {
        AbstractC4980Hj5.g(context);
        AbstractC4980Hj5.g(str);
        if (Build.VERSION.SDK_INT >= 25) {
            IA6.a(context.getSystemService(FA6.a())).reportShortcutUsed(str);
        }
        Iterator it = g(context).iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            Collections.singletonList(str);
            throw null;
        }
    }

    public static boolean n(Context context, List list) {
        List listL = l(list, 1);
        int i = Build.VERSION.SDK_INT;
        if (i <= 29) {
            c(context, listL);
        }
        if (i >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator it = listL.iterator();
            while (it.hasNext()) {
                arrayList.add(((C15791kA6) it.next()).p());
            }
            if (!IA6.a(context.getSystemService(FA6.a())).updateShortcuts(arrayList)) {
                return false;
            }
        }
        h(context).a(listL);
        Iterator it2 = g(context).iterator();
        if (!it2.hasNext()) {
            return true;
        }
        AbstractC18350oW3.a(it2.next());
        throw null;
    }
}
