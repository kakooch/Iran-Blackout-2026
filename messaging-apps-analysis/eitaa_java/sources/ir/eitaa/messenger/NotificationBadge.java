package ir.eitaa.messenger;

import android.annotation.TargetApi;
import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import ir.eitaa.messenger.NotificationBadge;
import java.io.Closeable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class NotificationBadge {
    private static final List<Class<? extends Badger>> BADGERS;
    private static Badger badger;
    private static ComponentName componentName;
    private static boolean initied;

    public interface Badger {
        void executeBadge(int badgeCount);

        List<String> getSupportLaunchers();
    }

    static {
        LinkedList linkedList = new LinkedList();
        BADGERS = linkedList;
        linkedList.add(AdwHomeBadger.class);
        linkedList.add(ApexHomeBadger.class);
        linkedList.add(NewHtcHomeBadger.class);
        linkedList.add(NovaHomeBadger.class);
        linkedList.add(SonyHomeBadger.class);
        linkedList.add(XiaomiHomeBadger.class);
        linkedList.add(AsusHomeBadger.class);
        linkedList.add(HuaweiHomeBadger.class);
        linkedList.add(OPPOHomeBader.class);
        linkedList.add(SamsungHomeBadger.class);
        linkedList.add(ZukHomeBadger.class);
        linkedList.add(VivoHomeBadger.class);
    }

    public static class AdwHomeBadger implements Badger {
        public static final String CLASSNAME = "CNAME";
        public static final String COUNT = "COUNT";
        public static final String INTENT_UPDATE_COUNTER = "org.adw.launcher.counter.SEND";
        public static final String PACKAGENAME = "PNAME";

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            final Intent intent = new Intent(INTENT_UPDATE_COUNTER);
            intent.putExtra(PACKAGENAME, NotificationBadge.componentName.getPackageName());
            intent.putExtra(CLASSNAME, NotificationBadge.componentName.getClassName());
            intent.putExtra(COUNT, badgeCount);
            if (NotificationBadge.canResolveBroadcast(intent)) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationBadge$AdwHomeBadger$JNn74XTUjmfq1jfrbmEAnM_S_XA
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApplicationLoader.applicationContext.sendBroadcast(intent);
                    }
                });
            }
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("org.adw.launcher", "org.adwfreak.launcher");
        }
    }

    public static class ApexHomeBadger implements Badger {
        private static final String CLASS = "class";
        private static final String COUNT = "count";
        private static final String INTENT_UPDATE_COUNTER = "com.anddoes.launcher.COUNTER_CHANGED";
        private static final String PACKAGENAME = "package";

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            final Intent intent = new Intent(INTENT_UPDATE_COUNTER);
            intent.putExtra(PACKAGENAME, NotificationBadge.componentName.getPackageName());
            intent.putExtra("count", badgeCount);
            intent.putExtra(CLASS, NotificationBadge.componentName.getClassName());
            if (NotificationBadge.canResolveBroadcast(intent)) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationBadge$ApexHomeBadger$ueJXW5CoQ5Wn4mTJnisImvy6t8I
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApplicationLoader.applicationContext.sendBroadcast(intent);
                    }
                });
            }
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("com.anddoes.launcher");
        }
    }

    public static class AsusHomeBadger implements Badger {
        private static final String INTENT_ACTION = "android.intent.action.BADGE_COUNT_UPDATE";
        private static final String INTENT_EXTRA_ACTIVITY_NAME = "badge_count_class_name";
        private static final String INTENT_EXTRA_BADGE_COUNT = "badge_count";
        private static final String INTENT_EXTRA_PACKAGENAME = "badge_count_package_name";

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            final Intent intent = new Intent(INTENT_ACTION);
            intent.putExtra(INTENT_EXTRA_BADGE_COUNT, badgeCount);
            intent.putExtra(INTENT_EXTRA_PACKAGENAME, NotificationBadge.componentName.getPackageName());
            intent.putExtra(INTENT_EXTRA_ACTIVITY_NAME, NotificationBadge.componentName.getClassName());
            intent.putExtra("badge_vip_count", 0);
            if (NotificationBadge.canResolveBroadcast(intent)) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationBadge$AsusHomeBadger$Io060RsTqm8KpyBuJKXxob1KP-Y
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApplicationLoader.applicationContext.sendBroadcast(intent);
                    }
                });
            }
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("com.asus.launcher");
        }
    }

    public static class DefaultBadger implements Badger {
        private static final String INTENT_ACTION = "android.intent.action.BADGE_COUNT_UPDATE";
        private static final String INTENT_EXTRA_ACTIVITY_NAME = "badge_count_class_name";
        private static final String INTENT_EXTRA_BADGE_COUNT = "badge_count";
        private static final String INTENT_EXTRA_PACKAGENAME = "badge_count_package_name";

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            final Intent intent = new Intent(INTENT_ACTION);
            intent.putExtra(INTENT_EXTRA_BADGE_COUNT, badgeCount);
            intent.putExtra(INTENT_EXTRA_PACKAGENAME, NotificationBadge.componentName.getPackageName());
            intent.putExtra(INTENT_EXTRA_ACTIVITY_NAME, NotificationBadge.componentName.getClassName());
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationBadge$DefaultBadger$RE2_1AhSr5Zd3J4-bIi2eW75xW4
                @Override // java.lang.Runnable
                public final void run() {
                    ApplicationLoader.applicationContext.sendBroadcast(intent);
                }
            });
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("fr.neamar.kiss", "com.quaap.launchtime", "com.quaap.launchtime_official");
        }
    }

    public static class HuaweiHomeBadger implements Badger {
        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            final Bundle bundle = new Bundle();
            bundle.putString("package", ApplicationLoader.applicationContext.getPackageName());
            bundle.putString("class", NotificationBadge.componentName.getClassName());
            bundle.putInt("badgenumber", badgeCount);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationBadge$HuaweiHomeBadger$QxHVXYq8BE3kSd9g5wWE3T5Jgs0
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationBadge.HuaweiHomeBadger.lambda$executeBadge$0(bundle);
                }
            });
        }

        static /* synthetic */ void lambda$executeBadge$0(Bundle bundle) {
            try {
                ApplicationLoader.applicationContext.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("com.huawei.android.launcher");
        }
    }

    public static class NewHtcHomeBadger implements Badger {
        public static final String COUNT = "count";
        public static final String EXTRA_COMPONENT = "com.htc.launcher.extra.COMPONENT";
        public static final String EXTRA_COUNT = "com.htc.launcher.extra.COUNT";
        public static final String INTENT_SET_NOTIFICATION = "com.htc.launcher.action.SET_NOTIFICATION";
        public static final String INTENT_UPDATE_SHORTCUT = "com.htc.launcher.action.UPDATE_SHORTCUT";
        public static final String PACKAGENAME = "packagename";

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            final Intent intent = new Intent(INTENT_SET_NOTIFICATION);
            intent.putExtra(EXTRA_COMPONENT, NotificationBadge.componentName.flattenToShortString());
            intent.putExtra(EXTRA_COUNT, badgeCount);
            final Intent intent2 = new Intent(INTENT_UPDATE_SHORTCUT);
            intent2.putExtra(PACKAGENAME, NotificationBadge.componentName.getPackageName());
            intent2.putExtra(COUNT, badgeCount);
            if (NotificationBadge.canResolveBroadcast(intent) || NotificationBadge.canResolveBroadcast(intent2)) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationBadge$NewHtcHomeBadger$Vp1nlNhQGjJgd4PZmC5KLVFHmys
                    @Override // java.lang.Runnable
                    public final void run() {
                        NotificationBadge.NewHtcHomeBadger.lambda$executeBadge$0(intent, intent2);
                    }
                });
            }
        }

        static /* synthetic */ void lambda$executeBadge$0(Intent intent, Intent intent2) {
            ApplicationLoader.applicationContext.sendBroadcast(intent);
            ApplicationLoader.applicationContext.sendBroadcast(intent2);
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("com.htc.launcher");
        }
    }

    public static class NovaHomeBadger implements Badger {
        private static final String CONTENT_URI = "content://com.teslacoilsw.notifier/unread_count";
        private static final String COUNT = "count";
        private static final String TAG = "tag";

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TAG, NotificationBadge.componentName.getPackageName() + "/" + NotificationBadge.componentName.getClassName());
            contentValues.put("count", Integer.valueOf(badgeCount));
            ApplicationLoader.applicationContext.getContentResolver().insert(Uri.parse(CONTENT_URI), contentValues);
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("com.teslacoilsw.launcher");
        }
    }

    public static class OPPOHomeBader implements Badger {
        private static final String INTENT_ACTION = "com.oppo.unsettledevent";
        private static final String INTENT_EXTRA_BADGEUPGRADE_COUNT = "app_badge_count";
        private static final String INTENT_EXTRA_BADGE_COUNT = "number";
        private static final String INTENT_EXTRA_BADGE_UPGRADENUMBER = "upgradeNumber";
        private static final String INTENT_EXTRA_PACKAGENAME = "pakeageName";
        private static final String PROVIDER_CONTENT_URI = "content://com.android.badge/badge";
        private int mCurrentTotalCount = -1;

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            if (this.mCurrentTotalCount == badgeCount) {
                return;
            }
            this.mCurrentTotalCount = badgeCount;
            executeBadgeByContentProvider(badgeCount);
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Collections.singletonList("com.oppo.launcher");
        }

        @TargetApi(11)
        private void executeBadgeByContentProvider(int badgeCount) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt(INTENT_EXTRA_BADGEUPGRADE_COUNT, badgeCount);
                ApplicationLoader.applicationContext.getContentResolver().call(Uri.parse(PROVIDER_CONTENT_URI), "setAppBadgeCount", (String) null, bundle);
            } catch (Throwable unused) {
            }
        }
    }

    public static class SamsungHomeBadger implements Badger {
        private static final String[] CONTENT_PROJECTION = {"_id", "class"};
        private static final String CONTENT_URI = "content://com.sec.badge/apps?notify=true";
        private static DefaultBadger defaultBadger;

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            try {
                if (defaultBadger == null) {
                    defaultBadger = new DefaultBadger();
                }
                defaultBadger.executeBadge(badgeCount);
            } catch (Exception unused) {
            }
            Uri uri = Uri.parse(CONTENT_URI);
            ContentResolver contentResolver = ApplicationLoader.applicationContext.getContentResolver();
            Cursor cursorQuery = null;
            try {
                cursorQuery = contentResolver.query(uri, CONTENT_PROJECTION, "package=?", new String[]{NotificationBadge.componentName.getPackageName()}, null);
                if (cursorQuery != null) {
                    String className = NotificationBadge.componentName.getClassName();
                    boolean z = false;
                    while (cursorQuery.moveToNext()) {
                        contentResolver.update(uri, getContentValues(NotificationBadge.componentName, badgeCount, false), "_id=?", new String[]{String.valueOf(cursorQuery.getInt(0))});
                        if (className.equals(cursorQuery.getString(cursorQuery.getColumnIndex("class")))) {
                            z = true;
                        }
                    }
                    if (!z) {
                        contentResolver.insert(uri, getContentValues(NotificationBadge.componentName, badgeCount, true));
                    }
                }
            } finally {
                NotificationBadge.close(cursorQuery);
            }
        }

        private ContentValues getContentValues(ComponentName componentName, int badgeCount, boolean isInsert) {
            ContentValues contentValues = new ContentValues();
            if (isInsert) {
                contentValues.put("package", componentName.getPackageName());
                contentValues.put("class", componentName.getClassName());
            }
            contentValues.put("badgecount", Integer.valueOf(badgeCount));
            return contentValues;
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("com.sec.android.app.launcher", "com.sec.android.app.twlauncher");
        }
    }

    public static class SonyHomeBadger implements Badger {
        private static final String INTENT_ACTION = "com.sonyericsson.home.action.UPDATE_BADGE";
        private static final String INTENT_EXTRA_ACTIVITY_NAME = "com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME";
        private static final String INTENT_EXTRA_MESSAGE = "com.sonyericsson.home.intent.extra.badge.MESSAGE";
        private static final String INTENT_EXTRA_PACKAGE_NAME = "com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME";
        private static final String INTENT_EXTRA_SHOW_MESSAGE = "com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE";
        private static final String PROVIDER_COLUMNS_ACTIVITY_NAME = "activity_name";
        private static final String PROVIDER_COLUMNS_BADGE_COUNT = "badge_count";
        private static final String PROVIDER_COLUMNS_PACKAGE_NAME = "package_name";
        private static final String PROVIDER_CONTENT_URI = "content://com.sonymobile.home.resourceprovider/badge";
        private static final String SONY_HOME_PROVIDER_NAME = "com.sonymobile.home.resourceprovider";
        private static AsyncQueryHandler mQueryHandler;
        private final Uri BADGE_CONTENT_URI = Uri.parse(PROVIDER_CONTENT_URI);

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            if (sonyBadgeContentProviderExists()) {
                executeBadgeByContentProvider(badgeCount);
            } else {
                executeBadgeByBroadcast(badgeCount);
            }
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("com.sonyericsson.home", "com.sonymobile.home");
        }

        private static void executeBadgeByBroadcast(int badgeCount) {
            final Intent intent = new Intent(INTENT_ACTION);
            intent.putExtra(INTENT_EXTRA_PACKAGE_NAME, NotificationBadge.componentName.getPackageName());
            intent.putExtra(INTENT_EXTRA_ACTIVITY_NAME, NotificationBadge.componentName.getClassName());
            intent.putExtra(INTENT_EXTRA_MESSAGE, String.valueOf(badgeCount));
            intent.putExtra(INTENT_EXTRA_SHOW_MESSAGE, badgeCount > 0);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationBadge$SonyHomeBadger$ILjIIk5obSmMN6cnqAc40rwABII
                @Override // java.lang.Runnable
                public final void run() {
                    ApplicationLoader.applicationContext.sendBroadcast(intent);
                }
            });
        }

        private void executeBadgeByContentProvider(int badgeCount) {
            if (badgeCount < 0) {
                return;
            }
            if (mQueryHandler == null) {
                mQueryHandler = new AsyncQueryHandler(ApplicationLoader.applicationContext.getApplicationContext().getContentResolver()) { // from class: ir.eitaa.messenger.NotificationBadge.SonyHomeBadger.1
                    @Override // android.content.AsyncQueryHandler, android.os.Handler
                    public void handleMessage(Message msg) {
                        try {
                            super.handleMessage(msg);
                        } catch (Throwable unused) {
                        }
                    }
                };
            }
            insertBadgeAsync(badgeCount, NotificationBadge.componentName.getPackageName(), NotificationBadge.componentName.getClassName());
        }

        private void insertBadgeAsync(int badgeCount, String packageName, String activityName) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(PROVIDER_COLUMNS_BADGE_COUNT, Integer.valueOf(badgeCount));
            contentValues.put(PROVIDER_COLUMNS_PACKAGE_NAME, packageName);
            contentValues.put(PROVIDER_COLUMNS_ACTIVITY_NAME, activityName);
            mQueryHandler.startInsert(0, null, this.BADGE_CONTENT_URI, contentValues);
        }

        private static boolean sonyBadgeContentProviderExists() {
            return ApplicationLoader.applicationContext.getPackageManager().resolveContentProvider(SONY_HOME_PROVIDER_NAME, 0) != null;
        }
    }

    public static class XiaomiHomeBadger implements Badger {
        public static final String EXTRA_UPDATE_APP_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
        public static final String EXTRA_UPDATE_APP_MSG_TEXT = "android.intent.extra.update_application_message_text";
        public static final String INTENT_ACTION = "android.intent.action.APPLICATION_MESSAGE_UPDATE";

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            try {
                Object objNewInstance = Class.forName("android.app.MiuiNotification").newInstance();
                Field declaredField = objNewInstance.getClass().getDeclaredField("messageCount");
                declaredField.setAccessible(true);
                declaredField.set(objNewInstance, String.valueOf(badgeCount == 0 ? "" : Integer.valueOf(badgeCount)));
            } catch (Throwable unused) {
                final Intent intent = new Intent(INTENT_ACTION);
                intent.putExtra(EXTRA_UPDATE_APP_COMPONENT_NAME, NotificationBadge.componentName.getPackageName() + "/" + NotificationBadge.componentName.getClassName());
                intent.putExtra(EXTRA_UPDATE_APP_MSG_TEXT, String.valueOf(badgeCount != 0 ? Integer.valueOf(badgeCount) : ""));
                if (NotificationBadge.canResolveBroadcast(intent)) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.NotificationBadge.XiaomiHomeBadger.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ApplicationLoader.applicationContext.sendBroadcast(intent);
                        }
                    });
                }
            }
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2");
        }
    }

    public static class ZukHomeBadger implements Badger {
        private final Uri CONTENT_URI = Uri.parse("content://com.android.badge/badge");

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        @TargetApi(11)
        public void executeBadge(int badgeCount) {
            final Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", badgeCount);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$NotificationBadge$ZukHomeBadger$VpGw07lkFWx0i0_oH1agTxbcb4w
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$executeBadge$0$NotificationBadge$ZukHomeBadger(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$executeBadge$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$executeBadge$0$NotificationBadge$ZukHomeBadger(Bundle bundle) {
            try {
                ApplicationLoader.applicationContext.getContentResolver().call(this.CONTENT_URI, "setAppBadgeCount", (String) null, bundle);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Collections.singletonList("com.zui.launcher");
        }
    }

    public static class VivoHomeBadger implements Badger {
        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public void executeBadge(int badgeCount) {
            Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", ApplicationLoader.applicationContext.getPackageName());
            intent.putExtra("className", NotificationBadge.componentName.getClassName());
            intent.putExtra("notificationNum", badgeCount);
            ApplicationLoader.applicationContext.sendBroadcast(intent);
        }

        @Override // ir.eitaa.messenger.NotificationBadge.Badger
        public List<String> getSupportLaunchers() {
            return Arrays.asList("com.vivo.launcher");
        }
    }

    public static boolean applyCount(int badgeCount) {
        try {
            if (badger == null && !initied) {
                initBadger();
                initied = true;
            }
            Badger badger2 = badger;
            if (badger2 == null) {
                return false;
            }
            badger2.executeBadge(badgeCount);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean initBadger() throws IllegalAccessException, InstantiationException {
        Badger badgerNewInstance;
        Badger badgerNewInstance2;
        Context context = ApplicationLoader.applicationContext;
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return false;
        }
        componentName = launchIntentForPackage.getComponent();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveInfoResolveActivity != null) {
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            Iterator<Class<? extends Badger>> it = BADGERS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    badgerNewInstance2 = it.next().newInstance();
                } catch (Exception unused) {
                    badgerNewInstance2 = null;
                }
                if (badgerNewInstance2 != null && badgerNewInstance2.getSupportLaunchers().contains(str)) {
                    badger = badgerNewInstance2;
                    break;
                }
            }
            if (badger != null) {
                return true;
            }
        }
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities != null) {
            for (int i = 0; i < listQueryIntentActivities.size(); i++) {
                String str2 = listQueryIntentActivities.get(i).activityInfo.packageName;
                Iterator<Class<? extends Badger>> it2 = BADGERS.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    try {
                        badgerNewInstance = it2.next().newInstance();
                    } catch (Exception unused2) {
                        badgerNewInstance = null;
                    }
                    if (badgerNewInstance != null && badgerNewInstance.getSupportLaunchers().contains(str2)) {
                        badger = badgerNewInstance;
                        break;
                    }
                }
                if (badger != null) {
                    break;
                }
            }
        }
        if (badger == null) {
            String str3 = Build.MANUFACTURER;
            if (str3.equalsIgnoreCase("Xiaomi")) {
                badger = new XiaomiHomeBadger();
            } else if (str3.equalsIgnoreCase("ZUK")) {
                badger = new ZukHomeBadger();
            } else if (str3.equalsIgnoreCase("OPPO")) {
                badger = new OPPOHomeBader();
            } else if (str3.equalsIgnoreCase("VIVO")) {
                badger = new VivoHomeBadger();
            } else {
                badger = new DefaultBadger();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canResolveBroadcast(Intent intent) {
        List<ResolveInfo> listQueryBroadcastReceivers = ApplicationLoader.applicationContext.getPackageManager().queryBroadcastReceivers(intent, 0);
        return listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0;
    }

    public static void close(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
