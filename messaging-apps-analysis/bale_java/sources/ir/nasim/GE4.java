package ir.nasim;

import android.app.NotificationManager;
import android.service.notification.StatusBarNotification;
import ir.nasim.AbstractC6544Ny5;
import ir.nasim.VP4;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class GE4 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[VP4.a.values().length];
            try {
                iArr[VP4.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VP4.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final AbstractC4398Ey5 a(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return new C24845zI5(AbstractC6544Ny5.c.a, AbstractC20507s76.o(), AbstractC20507s76.o(), String.valueOf(c11458d25.s() == W25.b ? 2 : 1), String.valueOf(AbstractC5969Lp4.d().X0()), String.valueOf(c11458d25.getPeerId()), null, null, c11458d25, null, 704, null);
    }

    public static final StatusBarNotification[] b(NotificationManager notificationManager) {
        AbstractC13042fc3.i(notificationManager, "<this>");
        try {
            return notificationManager.getActiveNotifications();
        } catch (Exception unused) {
            return new StatusBarNotification[0];
        }
    }

    private static final boolean c(NotificationManager notificationManager, VP4.a aVar) {
        String str;
        String str2;
        int i;
        int i2 = a.a[aVar.ordinal()];
        boolean z = false;
        if (i2 == 1) {
            str = "group_sapta";
            str2 = "SUMMARY_SAPTA_NOTIFICATION_TAG";
            i = 1;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "group_message";
            str2 = "summaryTag";
            i = 0;
        }
        StatusBarNotification[] statusBarNotificationArrB = b(notificationManager);
        ArrayList<StatusBarNotification> arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
            String groupKey = statusBarNotification.getGroupKey();
            AbstractC13042fc3.h(groupKey, "getGroupKey(...)");
            if (AbstractC20762sZ6.X(groupKey, str, false, 2, null)) {
                arrayList.add(statusBarNotification);
            }
        }
        if (arrayList.size() == 1) {
            for (StatusBarNotification statusBarNotification2 : arrayList) {
                notificationManager.cancel(statusBarNotification2.getTag(), statusBarNotification2.getId());
            }
            return true;
        }
        if (arrayList.size() == 2) {
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((StatusBarNotification) it.next()).getId() == i) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                notificationManager.cancel(str2, i);
            }
        }
        return z;
    }

    public static final void d(NotificationManager notificationManager, int i, String str) {
        AbstractC13042fc3.i(notificationManager, "<this>");
        if (i == 270066638) {
            f(notificationManager, str);
        } else if (g(notificationManager, i) && !c(notificationManager, VP4.a.b)) {
            notificationManager.cancel(i);
        }
    }

    public static /* synthetic */ void e(NotificationManager notificationManager, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        d(notificationManager, i, str);
    }

    public static final void f(NotificationManager notificationManager, String str) {
        AbstractC13042fc3.i(notificationManager, "<this>");
        if (g(notificationManager, 270066638)) {
            if (str != null) {
                if (c(notificationManager, VP4.a.a)) {
                    return;
                }
                notificationManager.cancel(str, 270066638);
                return;
            }
            for (StatusBarNotification statusBarNotification : b(notificationManager)) {
                String groupKey = statusBarNotification.getGroupKey();
                AbstractC13042fc3.h(groupKey, "getGroupKey(...)");
                if (AbstractC20762sZ6.X(groupKey, "group_sapta", false, 2, null)) {
                    notificationManager.cancel(statusBarNotification.getTag(), statusBarNotification.getId());
                }
            }
        }
    }

    public static final boolean g(NotificationManager notificationManager, int i) {
        AbstractC13042fc3.i(notificationManager, "<this>");
        for (StatusBarNotification statusBarNotification : b(notificationManager)) {
            if (statusBarNotification.getId() == i) {
                return true;
            }
        }
        return false;
    }
}
