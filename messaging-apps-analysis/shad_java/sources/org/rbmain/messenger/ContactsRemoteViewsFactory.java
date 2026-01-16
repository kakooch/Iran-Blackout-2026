package org.rbmain.messenger;

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
import androidMessenger.proxy.IdStorage;
import androidx.collection.LongSparseArray;
import ir.aaap.messengercore.model.ChatType;
import java.util.ArrayList;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;

/* compiled from: ContactsWidgetService.java */
/* loaded from: classes4.dex */
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
    public long getItemId(int i) {
        return i;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v21 */
    @Override // android.widget.RemoteViewsService.RemoteViewsFactory
    public RemoteViews getViewAt(int i) {
        String firstName;
        TLRPC$Chat tLRPC$Chat;
        TLRPC$User tLRPC$User;
        TLRPC$FileLocation tLRPC$FileLocation;
        Bitmap bitmapDecodeFile;
        int i2;
        AvatarDrawable avatarDrawable;
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        if (this.deleted) {
            RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), ir.medu.shad.R.layout.widget_deleted);
            remoteViews.setTextViewText(ir.medu.shad.R.id.widget_deleted_text, LocaleController.getString("WidgetLoggedOff", ir.medu.shad.R.string.WidgetLoggedOff));
            return remoteViews;
        }
        ?? r3 = 1;
        if (i >= getCount() - 1) {
            RemoteViews remoteViews2 = new RemoteViews(this.mContext.getPackageName(), ir.medu.shad.R.layout.widget_edititem);
            remoteViews2.setTextViewText(ir.medu.shad.R.id.widget_edititem_text, LocaleController.getString("TapToEditWidgetShort", ir.medu.shad.R.string.TapToEditWidgetShort));
            Bundle bundle = new Bundle();
            bundle.putInt("appWidgetId", this.appWidgetId);
            bundle.putInt("appWidgetType", 1);
            bundle.putInt("currentAccount", this.accountInstance.getCurrentAccount());
            Intent intent = new Intent();
            intent.putExtras(bundle);
            remoteViews2.setOnClickFillInIntent(ir.medu.shad.R.id.widget_edititem, intent);
            return remoteViews2;
        }
        RemoteViews remoteViews3 = new RemoteViews(this.mContext.getPackageName(), ir.medu.shad.R.layout.contacts_widget_item);
        int i3 = 0;
        int i4 = 0;
        while (i4 < 2) {
            int i5 = (i * 2) + i4;
            if (i5 >= this.dids.size()) {
                remoteViews3.setViewVisibility(i4 == 0 ? ir.medu.shad.R.id.contacts_widget_item1 : ir.medu.shad.R.id.contacts_widget_item2, 4);
            } else {
                remoteViews3.setViewVisibility(i4 == 0 ? ir.medu.shad.R.id.contacts_widget_item1 : ir.medu.shad.R.id.contacts_widget_item2, i3);
                Long l = this.dids.get(i5);
                ChatType chatType = null;
                if (l.longValue() > 0) {
                    TLRPC$User user = this.accountInstance.getMessagesController().getUser(Integer.valueOf((int) l.longValue()));
                    if (UserObject.isUserSelf(user)) {
                        firstName = LocaleController.getString("SavedMessages", ir.medu.shad.R.string.SavedMessages);
                    } else if (UserObject.isReplyUser(user)) {
                        firstName = LocaleController.getString("RepliesTitle", ir.medu.shad.R.string.RepliesTitle);
                    } else if (UserObject.isDeleted(user)) {
                        firstName = LocaleController.getString("HiddenName", ir.medu.shad.R.string.HiddenName);
                    } else {
                        firstName = UserObject.getFirstName(user);
                    }
                    if (UserObject.isReplyUser(user) || UserObject.isUserSelf(user) || user == null || (tLRPC$UserProfilePhoto = user.photo) == null || (tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small) == null || tLRPC$FileLocation.volume_id == 0 || tLRPC$FileLocation.local_id == 0) {
                        tLRPC$User = user;
                        tLRPC$Chat = null;
                        tLRPC$FileLocation = null;
                    } else {
                        tLRPC$User = user;
                        tLRPC$Chat = null;
                    }
                } else {
                    TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Integer.valueOf(-((int) l.longValue())));
                    if (chat != null) {
                        firstName = chat.title;
                        TLRPC$ChatPhoto tLRPC$ChatPhoto = chat.photo;
                        if (tLRPC$ChatPhoto != null && (tLRPC$FileLocation = tLRPC$ChatPhoto.photo_small) != null && tLRPC$FileLocation.volume_id != 0 && tLRPC$FileLocation.local_id != 0) {
                            tLRPC$Chat = chat;
                            tLRPC$User = null;
                        }
                    } else {
                        firstName = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
                    }
                    tLRPC$Chat = chat;
                    tLRPC$User = null;
                    tLRPC$FileLocation = null;
                }
                remoteViews3.setTextViewText(i4 == 0 ? ir.medu.shad.R.id.contacts_widget_item_text1 : ir.medu.shad.R.id.contacts_widget_item_text2, firstName);
                if (tLRPC$FileLocation != null) {
                    try {
                        bitmapDecodeFile = BitmapFactory.decodeFile(FileLoader.getPathToAttach(tLRPC$FileLocation, r3).toString());
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                } else {
                    bitmapDecodeFile = null;
                }
                int iDp = AndroidUtilities.dp(48.0f);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iDp, iDp, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(i3);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (bitmapDecodeFile == null) {
                    if (tLRPC$User != null) {
                        AvatarDrawable avatarDrawable2 = new AvatarDrawable(tLRPC$User);
                        if (UserObject.isReplyUser(tLRPC$User)) {
                            avatarDrawable2.setAvatarType(12);
                            avatarDrawable = avatarDrawable2;
                        } else {
                            avatarDrawable = avatarDrawable2;
                            if (UserObject.isUserSelf(tLRPC$User)) {
                                avatarDrawable2.setAvatarType(r3);
                                avatarDrawable = avatarDrawable2;
                            }
                        }
                    } else {
                        avatarDrawable = new AvatarDrawable(tLRPC$Chat);
                    }
                    avatarDrawable.setBounds(i3, i3, iDp, iDp);
                    avatarDrawable.draw(canvas);
                } else {
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    BitmapShader bitmapShader = new BitmapShader(bitmapDecodeFile, tileMode, tileMode);
                    if (this.roundPaint == null) {
                        this.roundPaint = new Paint((int) r3);
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
                remoteViews3.setImageViewBitmap(i4 == 0 ? ir.medu.shad.R.id.contacts_widget_item_avatar1 : ir.medu.shad.R.id.contacts_widget_item_avatar2, bitmapCreateBitmap);
                TLRPC$Dialog tLRPC$Dialog = this.dialogs.get(l.longValue());
                int i6 = ir.medu.shad.R.id.contacts_widget_item_badge_bg1;
                if (tLRPC$Dialog != null && (i2 = tLRPC$Dialog.unread_count) > 0) {
                    remoteViews3.setTextViewText(i4 == 0 ? ir.medu.shad.R.id.contacts_widget_item_badge1 : ir.medu.shad.R.id.contacts_widget_item_badge2, i2 > 99 ? String.format("%d+", 99) : String.format("%d", Integer.valueOf(i2)));
                    if (i4 != 0) {
                        i6 = ir.medu.shad.R.id.contacts_widget_item_badge_bg2;
                    }
                    remoteViews3.setViewVisibility(i6, 0);
                } else {
                    if (i4 != 0) {
                        i6 = ir.medu.shad.R.id.contacts_widget_item_badge_bg2;
                    }
                    remoteViews3.setViewVisibility(i6, 8);
                }
                Bundle bundle2 = new Bundle();
                if (l.longValue() > 0) {
                    if (tLRPC$User != null) {
                        chatType = tLRPC$User.bot ? ChatType.Bot : tLRPC$User.support ? ChatType.Service : ChatType.User;
                    }
                    bundle2.putInt("userId", (int) l.longValue());
                } else {
                    if (tLRPC$Chat != null) {
                        chatType = tLRPC$Chat.megagroup ? ChatType.Group : ChatType.Channel;
                    }
                    bundle2.putInt("chatId", -((int) l.longValue()));
                }
                String dialogId = IdStorage.getInstance().getDialogId(l.longValue());
                if (chatType != null) {
                    bundle2.putString("object_type", chatType.name());
                    bundle2.putString("object_guid", dialogId);
                }
                bundle2.putInt("currentAccount", this.accountInstance.getCurrentAccount());
                Intent intent2 = new Intent();
                intent2.putExtras(bundle2);
                remoteViews3.setOnClickFillInIntent(i4 == 0 ? ir.medu.shad.R.id.contacts_widget_item1 : ir.medu.shad.R.id.contacts_widget_item2, intent2);
            }
            i4++;
            r3 = 1;
            i3 = 0;
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
