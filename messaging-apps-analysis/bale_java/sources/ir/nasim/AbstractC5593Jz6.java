package ir.nasim;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;
import me.leolin.shortcutbadger.impl.ApexHomeBadger;
import me.leolin.shortcutbadger.impl.DefaultBadger;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import me.leolin.shortcutbadger.impl.NovaHomeBadger;
import me.leolin.shortcutbadger.impl.SonyHomeBadger;

/* renamed from: ir.nasim.Jz6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5593Jz6 {
    private static final List a;
    private static final Object b;
    private static PW c;
    private static ComponentName d;

    static {
        LinkedList linkedList = new LinkedList();
        a = linkedList;
        b = new Object();
        linkedList.add(AdwHomeBadger.class);
        linkedList.add(ApexHomeBadger.class);
        linkedList.add(DefaultBadger.class);
        linkedList.add(NewHtcHomeBadger.class);
        linkedList.add(NovaHomeBadger.class);
        linkedList.add(SonyHomeBadger.class);
        linkedList.add(AbstractC24263yK.class);
        linkedList.add(AbstractC22625vZ2.class);
        linkedList.add(DF4.class);
        linkedList.add(AbstractC16025ka6.class);
        linkedList.add(Zc8.class);
        linkedList.add(PZ7.class);
        linkedList.add(Bc8.class);
        linkedList.add(AbstractC17804nb2.class);
    }

    public static boolean a(Context context, int i) {
        try {
            b(context, i);
            return true;
        } catch (ShortcutBadgeException e) {
            if (!Log.isLoggable("ShortcutBadger", 3)) {
                return false;
            }
            Log.d("ShortcutBadger", "Unable to execute badge", e);
            return false;
        }
    }

    public static void b(Context context, int i) throws ShortcutBadgeException {
        if (c == null && !c(context)) {
            throw new ShortcutBadgeException("No default launcher available");
        }
        try {
            c.b(context, d, i);
        } catch (Exception e) {
            throw new ShortcutBadgeException("Unable to execute badge", e);
        }
    }

    private static boolean c(Context context) {
        PW pw;
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            Log.e("ShortcutBadger", "Unable to find launch intent for package " + context.getPackageName());
            return false;
        }
        d = launchIntentForPackage.getComponent();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.packageName;
            Iterator it2 = a.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                try {
                    pw = (PW) ((Class) it2.next()).newInstance();
                } catch (Exception unused) {
                    pw = null;
                }
                if (pw != null && pw.a().contains(str)) {
                    c = pw;
                    break;
                }
            }
            if (c != null) {
                break;
            }
        }
        if (c != null) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        if (str2.equalsIgnoreCase("ZUK")) {
            c = new Zc8();
            return true;
        }
        if (str2.equalsIgnoreCase("OPPO")) {
            c = new DF4();
            return true;
        }
        if (str2.equalsIgnoreCase("VIVO")) {
            c = new PZ7();
            return true;
        }
        if (str2.equalsIgnoreCase("ZTE")) {
            c = new Bc8();
            return true;
        }
        c = new DefaultBadger();
        return true;
    }
}
