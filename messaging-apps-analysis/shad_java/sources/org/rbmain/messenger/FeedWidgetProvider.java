package org.rbmain.messenger;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import androidMessenger.utilites.PendingIntentUtils;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes4.dex */
public class FeedWidgetProvider extends AppWidgetProvider {
    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        for (int i : iArr) {
            updateWidget(context, appWidgetManager, i);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
        for (int i = 0; i < iArr.length; i++) {
            context.getSharedPreferences("shortcut_widget", 0).edit().remove("account" + iArr[i]).remove("dialogId" + iArr[i]).apply();
        }
    }

    public static void updateWidget(Context context, AppWidgetManager appWidgetManager, int i) {
        Intent intent = new Intent(context, (Class<?>) FeedWidgetService.class);
        intent.putExtra("appWidgetId", i);
        intent.setData(Uri.parse(intent.toUri(1)));
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), ir.medu.shad.R.layout.feed_widget_layout);
        remoteViews.setRemoteAdapter(i, ir.medu.shad.R.id.list_view, intent);
        remoteViews.setEmptyView(ir.medu.shad.R.id.list_view, ir.medu.shad.R.id.empty_view);
        Intent intent2 = new Intent(ApplicationLoader.applicationContext, (Class<?>) LaunchActivity.class);
        intent2.setAction("com.tmessages.openchat" + Math.random() + ConnectionsManager.DEFAULT_DATACENTER_ID);
        intent2.addFlags(ConnectionsManager.FileTypeFile);
        intent2.addCategory("android.intent.category.LAUNCHER");
        remoteViews.setPendingIntentTemplate(ir.medu.shad.R.id.list_view, PendingIntentUtils.getPendingIntentActivity(ApplicationLoader.applicationContext, 0, intent2, 134217728));
        appWidgetManager.updateAppWidget(i, remoteViews);
    }
}
