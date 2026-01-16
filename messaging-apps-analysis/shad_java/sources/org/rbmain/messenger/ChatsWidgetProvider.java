package org.rbmain.messenger;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidMessenger.utilites.PendingIntentUtils;
import java.util.ArrayList;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes4.dex */
public class ChatsWidgetProvider extends AppWidgetProvider {
    private static int getCellsForSize(int i) {
        int i2 = 2;
        while (i2 * 72 < i) {
            i2++;
        }
        return i2 - 1;
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        for (int i : iArr) {
            updateWidget(context, appWidgetManager, i, false);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i, Bundle bundle) {
        updateWidget(context, appWidgetManager, i, true);
        super.onAppWidgetOptionsChanged(context, appWidgetManager, i, bundle);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
        ApplicationLoader.postInitApplication();
        SharedPreferences sharedPreferences = context.getSharedPreferences("shortcut_widget", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (int i = 0; i < iArr.length; i++) {
            int i2 = sharedPreferences.getInt("account" + iArr[i], -1);
            if (i2 >= 0) {
                AccountInstance.getInstance(i2).getMessagesStorage().clearWidgetDialogs(iArr[i]);
            }
            editorEdit.remove("account" + iArr[i]);
            editorEdit.remove("type" + iArr[i]);
            editorEdit.remove("deleted" + iArr[i]);
        }
        editorEdit.apply();
    }

    public static void updateWidget(Context context, AppWidgetManager appWidgetManager, int i, boolean z) {
        ApplicationLoader.postInitApplication();
        int cellsForSize = getCellsForSize(appWidgetManager.getAppWidgetOptions(i).getInt("appWidgetMaxHeight"));
        Intent intent = new Intent(context, (Class<?>) ChatsWidgetService.class);
        intent.putExtra("appWidgetId", i);
        intent.setData(Uri.parse(intent.toUri(1)));
        SharedPreferences sharedPreferences = context.getSharedPreferences("shortcut_widget", 0);
        boolean z2 = sharedPreferences.getBoolean("deleted" + i, false);
        int i2 = ir.medu.shad.R.layout.shortcut_widget_layout_1;
        if (!z2) {
            int i3 = sharedPreferences.getInt("account" + i, -1);
            ArrayList<Long> arrayList = new ArrayList<>();
            if (i3 >= 0) {
                AccountInstance.getInstance(i3).getMessagesStorage().getWidgetDialogIds(i, 0, arrayList, null, null, false);
            }
            if (cellsForSize != 1 && arrayList.size() > 1) {
                if (cellsForSize == 2 || arrayList.size() <= 2) {
                    i2 = ir.medu.shad.R.layout.shortcut_widget_layout_2;
                } else {
                    i2 = (cellsForSize == 3 || arrayList.size() <= 3) ? ir.medu.shad.R.layout.shortcut_widget_layout_3 : ir.medu.shad.R.layout.shortcut_widget_layout_4;
                }
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        remoteViews.setRemoteAdapter(i, ir.medu.shad.R.id.list_view, intent);
        remoteViews.setEmptyView(ir.medu.shad.R.id.list_view, ir.medu.shad.R.id.empty_view);
        Intent intent2 = new Intent(ApplicationLoader.applicationContext, (Class<?>) LaunchActivity.class);
        intent2.setAction("com.tmessages.openchat" + Math.random() + ConnectionsManager.DEFAULT_DATACENTER_ID);
        intent2.addFlags(ConnectionsManager.FileTypeFile);
        intent2.addCategory("android.intent.category.LAUNCHER");
        remoteViews.setPendingIntentTemplate(ir.medu.shad.R.id.list_view, PendingIntentUtils.getPendingIntentActivity(ApplicationLoader.applicationContext, 0, intent2, 134217728));
        appWidgetManager.updateAppWidget(i, remoteViews);
        if (z) {
            appWidgetManager.notifyAppWidgetViewDataChanged(i, ir.medu.shad.R.id.list_view);
        }
    }
}
