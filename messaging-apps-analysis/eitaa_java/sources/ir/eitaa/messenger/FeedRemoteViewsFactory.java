package ir.eitaa.messenger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import androidx.core.content.FileProvider;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* compiled from: FeedWidgetService.java */
/* loaded from: classes.dex */
class FeedRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory, NotificationCenter.NotificationCenterDelegate {
    private AccountInstance accountInstance;
    private int classGuid;
    private long dialogId;
    private Context mContext;
    private ArrayList<MessageObject> messages = new ArrayList<>();
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public void onDestroy() {
    }

    public FeedRemoteViewsFactory(Context context, Intent intent) {
        this.mContext = context;
        int intExtra = intent.getIntExtra("appWidgetId", 0);
        SharedPreferences sharedPreferences = context.getSharedPreferences("shortcut_widget", 0);
        int i = sharedPreferences.getInt("account" + intExtra, -1);
        if (i >= 0) {
            this.dialogId = sharedPreferences.getLong("dialogId" + intExtra, 0L);
            this.accountInstance = AccountInstance.getInstance(i);
        }
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public void onCreate() {
        ApplicationLoader.postInitApplication();
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public int getCount() {
        return this.messages.size();
    }

    protected void grantUriAccessToWidget(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, uri, 1);
        }
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public RemoteViews getViewAt(int position) {
        MessageObject messageObject = this.messages.get(position);
        RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), R.layout.feed_widget_item);
        if (messageObject.type == 0) {
            remoteViews.setTextViewText(R.id.feed_widget_item_text, messageObject.messageText);
            remoteViews.setViewVisibility(R.id.feed_widget_item_text, 0);
        } else if (TextUtils.isEmpty(messageObject.caption)) {
            remoteViews.setViewVisibility(R.id.feed_widget_item_text, 8);
        } else {
            remoteViews.setTextViewText(R.id.feed_widget_item_text, messageObject.caption);
            remoteViews.setViewVisibility(R.id.feed_widget_item_text, 0);
        }
        ArrayList<TLRPC$PhotoSize> arrayList = messageObject.photoThumbs;
        if (arrayList == null || arrayList.isEmpty()) {
            remoteViews.setViewVisibility(R.id.feed_widget_item_image, 8);
        } else {
            File pathToAttach = FileLoader.getPathToAttach(FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize()));
            if (pathToAttach.exists()) {
                remoteViews.setViewVisibility(R.id.feed_widget_item_image, 0);
                Uri uriForFile = FileProvider.getUriForFile(this.mContext, "ir.eitaa.messenger.provider", pathToAttach);
                grantUriAccessToWidget(this.mContext, uriForFile);
                remoteViews.setImageViewUri(R.id.feed_widget_item_image, uriForFile);
            } else {
                remoteViews.setViewVisibility(R.id.feed_widget_item_image, 8);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putLong("chatId", -messageObject.getDialogId());
        bundle.putInt("message_id", messageObject.getId());
        bundle.putInt("currentAccount", this.accountInstance.getCurrentAccount());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        remoteViews.setOnClickFillInIntent(R.id.shortcut_widget_item, intent);
        return remoteViews;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public void onDataSetChanged() throws InterruptedException {
        AccountInstance accountInstance = this.accountInstance;
        if (accountInstance == null || !accountInstance.getUserConfig().isClientActivated()) {
            this.messages.clear();
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$FeedRemoteViewsFactory$gTc1lgcUA8g47MBKO3Jn026ZHrE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDataSetChanged$0$FeedRemoteViewsFactory();
            }
        });
        try {
            this.countDownLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDataSetChanged$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDataSetChanged$0$FeedRemoteViewsFactory() {
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.messagesDidLoad);
        if (this.classGuid == 0) {
            this.classGuid = ConnectionsManager.generateClassGuid();
        }
        this.accountInstance.getMessagesController().loadMessages(this.dialogId, 0L, false, 20, 0, 0, true, 0, this.classGuid, 0, 0, 0, 0, 0, 1);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.messagesDidLoad && ((Integer) args[10]).intValue() == this.classGuid) {
            this.messages.clear();
            this.messages.addAll((ArrayList) args[2]);
            this.countDownLatch.countDown();
        }
    }
}
