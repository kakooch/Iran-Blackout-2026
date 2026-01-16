package me.leolin.shortcutbadger.impl;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.gov.nist.core.Separators;
import android.os.Build;
import ir.nasim.AbstractC9903al0;
import ir.nasim.PW;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.ShortcutBadgeException;

@Deprecated
/* loaded from: classes8.dex */
public class XiaomiHomeBadger implements PW {
    private ResolveInfo a;

    private void c(Context context, int i) throws IllegalAccessException, ShortcutBadgeException, IllegalArgumentException, InvocationTargetException {
        if (this.a == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            this.a = context.getPackageManager().resolveActivity(intent, 65536);
        }
        if (this.a != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Notification notificationBuild = new Notification.Builder(context).setContentTitle("").setContentText("").setSmallIcon(this.a.getIconResource()).build();
            try {
                Object obj = notificationBuild.getClass().getDeclaredField("extraNotification").get(notificationBuild);
                obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i));
                notificationManager.notify(0, notificationBuild);
            } catch (Exception e) {
                throw new ShortcutBadgeException("not able to set badge", e);
            }
        }
    }

    @Override // ir.nasim.PW
    public List a() {
        return Arrays.asList("com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher");
    }

    @Override // ir.nasim.PW
    public void b(Context context, ComponentName componentName, int i) throws IllegalAccessException, ShortcutBadgeException, NoSuchFieldException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object objValueOf;
        try {
            Object objNewInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = objNewInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            if (i == 0) {
                objValueOf = "";
            } else {
                try {
                    objValueOf = Integer.valueOf(i);
                } catch (Exception unused) {
                    declaredField.set(objNewInstance, Integer.valueOf(i));
                }
            }
            declaredField.set(objNewInstance, String.valueOf(objValueOf));
        } catch (Exception unused2) {
            Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent.putExtra("android.intent.extra.update_application_component_name", componentName.getPackageName() + Separators.SLASH + componentName.getClassName());
            intent.putExtra("android.intent.extra.update_application_message_text", String.valueOf(i != 0 ? Integer.valueOf(i) : ""));
            try {
                AbstractC9903al0.c(context, intent);
            } catch (ShortcutBadgeException unused3) {
            }
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            c(context, i);
        }
    }
}
