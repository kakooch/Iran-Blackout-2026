package ir.eitaa.messenger;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.LaunchActivity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChatsWidgetProvider extends AppWidgetProvider {
    private static int getCellsForSize(int size) {
        int i = 2;
        while (i * 72 < size) {
            i++;
        }
        return i - 1;
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        for (int i : appWidgetIds) {
            updateWidget(context, appWidgetManager, i);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        updateWidget(context, appWidgetManager, appWidgetId);
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        ApplicationLoader.postInitApplication();
        SharedPreferences sharedPreferences = context.getSharedPreferences("shortcut_widget", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (int i = 0; i < appWidgetIds.length; i++) {
            int i2 = sharedPreferences.getInt("account" + appWidgetIds[i], -1);
            if (i2 >= 0) {
                AccountInstance.getInstance(i2).getMessagesStorage().clearWidgetDialogs(appWidgetIds[i]);
            }
            editorEdit.remove("account" + appWidgetIds[i]);
            editorEdit.remove("type" + appWidgetIds[i]);
            editorEdit.remove("deleted" + appWidgetIds[i]);
        }
        editorEdit.commit();
    }

    public static void updateWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        ApplicationLoader.postInitApplication();
        int cellsForSize = getCellsForSize(appWidgetManager.getAppWidgetOptions(appWidgetId).getInt("appWidgetMaxHeight"));
        Intent intent = new Intent(context, (Class<?>) ChatsWidgetService.class);
        intent.putExtra("appWidgetId", appWidgetId);
        intent.setData(Uri.parse(intent.toUri(1)));
        SharedPreferences sharedPreferences = context.getSharedPreferences("shortcut_widget", 0);
        boolean z = sharedPreferences.getBoolean("deleted" + appWidgetId, false);
        int i = R.layout.shortcut_widget_layout_1;
        if (!z) {
            int i2 = sharedPreferences.getInt("account" + appWidgetId, -1);
            if (i2 == -1) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putInt("account" + appWidgetId, UserConfig.selectedAccount);
                editorEdit.putInt("type" + appWidgetId, 0).commit();
            }
            ArrayList<Long> arrayList = new ArrayList<>();
            if (i2 >= 0) {
                AccountInstance.getInstance(i2).getMessagesStorage().getWidgetDialogIds(appWidgetId, 0, arrayList, null, null, false);
            }
            if (cellsForSize != 1 && arrayList.size() > 1) {
                if (cellsForSize == 2 || arrayList.size() <= 2) {
                    i = R.layout.shortcut_widget_layout_2;
                } else {
                    i = (cellsForSize == 3 || arrayList.size() <= 3) ? R.layout.shortcut_widget_layout_3 : R.layout.shortcut_widget_layout_4;
                }
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i);
        remoteViews.setRemoteAdapter(appWidgetId, R.id.list_view, intent);
        remoteViews.setEmptyView(R.id.list_view, R.id.empty_view);
        Intent intent2 = new Intent(ApplicationLoader.applicationContext, (Class<?>) LaunchActivity.class);
        intent2.setAction("com.tmessages.openchat" + Math.random() + ConnectionsManager.DEFAULT_DATACENTER_ID);
        intent2.addFlags(ConnectionsManager.FileTypeFile);
        intent2.addCategory("android.intent.category.LAUNCHER");
        remoteViews.setPendingIntentTemplate(R.id.list_view, PendingIntent.getActivity(ApplicationLoader.applicationContext, 0, intent2, 134217728));
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.list_view);
    }
}
