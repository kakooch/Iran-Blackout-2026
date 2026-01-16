package ir.eitaa.messenger;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import androidx.collection.LongSparseArray;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import java.util.ArrayList;

/* compiled from: ContactsWidgetService.java */
/* loaded from: classes.dex */
class ContactsRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
    private AccountInstance accountInstance;
    private int appWidgetId;
    private RectF bitmapRect;
    private boolean deleted;
    private Context mContext;
    private Paint roundPaint;
    private ArrayList<Long> dids = new ArrayList<>();
    private LongSparseArray<TLRPC$Dialog> dialogs = new LongSparseArray<>();

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
        return 2;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public void onDestroy() {
    }

    public ContactsRemoteViewsFactory(Context context, Intent intent) throws Resources.NotFoundException {
        this.mContext = context;
        Theme.createDialogsResources(context);
        this.appWidgetId = intent.getIntExtra("appWidgetId", 0);
        SharedPreferences sharedPreferences = context.getSharedPreferences("shortcut_widget", 0);
        int i = sharedPreferences.getInt("account" + this.appWidgetId, -1);
        if (i >= 0) {
            this.accountInstance = AccountInstance.getInstance(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("deleted");
        sb.append(this.appWidgetId);
        this.deleted = sharedPreferences.getBoolean(sb.toString(), false) || this.accountInstance == null;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public void onCreate() {
        ApplicationLoader.postInitApplication();
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public int getCount() {
        if (this.deleted) {
            return 1;
        }
        return ((int) Math.ceil(this.dids.size() / 2.0f)) + 1;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public RemoteViews getViewAt(int position) {
        String firstName;
        TLRPC$Chat tLRPC$Chat;
        TLRPC$User user;
        TLRPC$FileLocation tLRPC$FileLocation;
        Bitmap bitmapDecodeFile;
        int i;
        AvatarDrawable avatarDrawable;
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        if (this.deleted) {
            RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), R.layout.widget_deleted);
            remoteViews.setTextViewText(R.id.widget_deleted_text, LocaleController.getString("WidgetLoggedOff", R.string.WidgetLoggedOff));
            return remoteViews;
        }
        if (position >= getCount() - 1) {
            RemoteViews remoteViews2 = new RemoteViews(this.mContext.getPackageName(), R.layout.widget_edititem);
            remoteViews2.setTextViewText(R.id.widget_edititem_text, LocaleController.getString("TapToEditWidgetShort", R.string.TapToEditWidgetShort));
            Bundle bundle = new Bundle();
            bundle.putInt("appWidgetId", this.appWidgetId);
            bundle.putInt("appWidgetType", 1);
            bundle.putInt("currentAccount", this.accountInstance.getCurrentAccount());
            Intent intent = new Intent();
            intent.putExtras(bundle);
            remoteViews2.setOnClickFillInIntent(R.id.widget_edititem, intent);
            return remoteViews2;
        }
        RemoteViews remoteViews3 = new RemoteViews(this.mContext.getPackageName(), R.layout.contacts_widget_item);
        int i2 = 0;
        while (i2 < 2) {
            int i3 = (position * 2) + i2;
            if (i3 >= this.dids.size()) {
                remoteViews3.setViewVisibility(i2 == 0 ? R.id.contacts_widget_item1 : R.id.contacts_widget_item2, 4);
            } else {
                remoteViews3.setViewVisibility(i2 == 0 ? R.id.contacts_widget_item1 : R.id.contacts_widget_item2, 0);
                Long l = this.dids.get(i3);
                if (DialogObject.isUserDialog(l.longValue())) {
                    user = this.accountInstance.getMessagesController().getUser(l);
                    if (UserObject.isUserSelf(user)) {
                        firstName = LocaleController.getString("SavedMessages", R.string.SavedMessages);
                    } else if (UserObject.isReplyUser(user)) {
                        firstName = LocaleController.getString("RepliesTitle", R.string.RepliesTitle);
                    } else if (UserObject.isDeleted(user)) {
                        firstName = LocaleController.getString("HiddenName", R.string.HiddenName);
                    } else {
                        firstName = UserObject.getFirstName(user);
                    }
                    if (UserObject.isReplyUser(user) || UserObject.isUserSelf(user) || user == null || (tLRPC$UserProfilePhoto = user.photo) == null || (tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small) == null || tLRPC$FileLocation.volume_id == 0 || tLRPC$FileLocation.local_id == 0) {
                        tLRPC$Chat = null;
                        tLRPC$FileLocation = null;
                    } else {
                        tLRPC$Chat = null;
                    }
                } else {
                    TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(-l.longValue()));
                    if (chat != null) {
                        firstName = chat.title;
                        TLRPC$ChatPhoto tLRPC$ChatPhoto = chat.photo;
                        if (tLRPC$ChatPhoto != null && (tLRPC$FileLocation = tLRPC$ChatPhoto.photo_small) != null && tLRPC$FileLocation.volume_id != 0 && tLRPC$FileLocation.local_id != 0) {
                            tLRPC$Chat = chat;
                            user = null;
                        }
                    } else {
                        firstName = "";
                    }
                    tLRPC$Chat = chat;
                    user = null;
                    tLRPC$FileLocation = null;
                }
                remoteViews3.setTextViewText(i2 == 0 ? R.id.contacts_widget_item_text1 : R.id.contacts_widget_item_text2, firstName);
                if (tLRPC$FileLocation != null) {
                    try {
                        bitmapDecodeFile = BitmapFactory.decodeFile(FileLoader.getPathToAttach(tLRPC$FileLocation, true).toString());
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                } else {
                    bitmapDecodeFile = null;
                }
                int iDp = AndroidUtilities.dp(48.0f);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iDp, iDp, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(0);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (bitmapDecodeFile == null) {
                    if (user != null) {
                        avatarDrawable = new AvatarDrawable(user);
                        if (UserObject.isReplyUser(user)) {
                            avatarDrawable.setAvatarType(12);
                        } else if (UserObject.isUserSelf(user)) {
                            avatarDrawable.setAvatarType(1);
                        }
                    } else {
                        avatarDrawable = new AvatarDrawable(tLRPC$Chat);
                    }
                    avatarDrawable.setBounds(0, 0, iDp, iDp);
                    avatarDrawable.draw(canvas);
                } else {
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    BitmapShader bitmapShader = new BitmapShader(bitmapDecodeFile, tileMode, tileMode);
                    if (this.roundPaint == null) {
                        this.roundPaint = new Paint(1);
                        this.bitmapRect = new RectF();
                    }
                    float width = iDp / bitmapDecodeFile.getWidth();
                    canvas.save();
                    canvas.scale(width, width);
                    this.roundPaint.setShader(bitmapShader);
                    this.bitmapRect.set(0.0f, 0.0f, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight());
                    canvas.drawRoundRect(this.bitmapRect, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), this.roundPaint);
                    canvas.restore();
                }
                canvas.setBitmap(null);
                remoteViews3.setImageViewBitmap(i2 == 0 ? R.id.contacts_widget_item_avatar1 : R.id.contacts_widget_item_avatar2, bitmapCreateBitmap);
                TLRPC$Dialog tLRPC$Dialog = this.dialogs.get(l.longValue());
                int i4 = R.id.contacts_widget_item_badge_bg1;
                if (tLRPC$Dialog != null && (i = tLRPC$Dialog.unread_count) > 0) {
                    remoteViews3.setTextViewText(i2 == 0 ? R.id.contacts_widget_item_badge1 : R.id.contacts_widget_item_badge2, i > 99 ? String.format("%d+", 99) : String.format("%d", Integer.valueOf(i)));
                    if (i2 != 0) {
                        i4 = R.id.contacts_widget_item_badge_bg2;
                    }
                    remoteViews3.setViewVisibility(i4, 0);
                } else {
                    if (i2 != 0) {
                        i4 = R.id.contacts_widget_item_badge_bg2;
                    }
                    remoteViews3.setViewVisibility(i4, 8);
                }
                Bundle bundle2 = new Bundle();
                if (DialogObject.isUserDialog(l.longValue())) {
                    bundle2.putLong("userId", l.longValue());
                } else {
                    bundle2.putLong("chatId", -l.longValue());
                }
                bundle2.putInt("currentAccount", this.accountInstance.getCurrentAccount());
                Intent intent2 = new Intent();
                intent2.putExtras(bundle2);
                remoteViews3.setOnClickFillInIntent(i2 == 0 ? R.id.contacts_widget_item1 : R.id.contacts_widget_item2, intent2);
            }
            i2++;
        }
        return remoteViews3;
    }

    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public void onDataSetChanged() throws InterruptedException {
        this.dids.clear();
        AccountInstance accountInstance = this.accountInstance;
        if (accountInstance == null || !accountInstance.getUserConfig().isClientActivated()) {
            return;
        }
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        ArrayList<TLRPC$Chat> arrayList2 = new ArrayList<>();
        this.accountInstance.getMessagesStorage().getWidgetDialogs(this.appWidgetId, 1, this.dids, this.dialogs, new LongSparseArray<>(), arrayList, arrayList2);
        this.accountInstance.getMessagesController().putUsers(arrayList, true);
        this.accountInstance.getMessagesController().putChats(arrayList2, true);
    }
}
