package org.rbmain.ui.Cells;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.maps.model.LatLng;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.LocationController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_channelLocation;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerChat;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.LocationActivity;

/* loaded from: classes4.dex */
public class SharingLiveLocationCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private int currentAccount;
    private LocationController.SharingLocationInfo currentInfo;
    private SimpleTextView distanceTextView;
    private Runnable invalidateRunnable;
    private LocationActivity.LiveLocation liveLocation;
    private Location location;
    private SimpleTextView nameTextView;
    private RectF rect;

    public SharingLiveLocationCell(Context context, boolean z, int i) {
        super(context);
        this.rect = new RectF();
        this.location = new Location("network");
        this.currentAccount = UserConfig.selectedAccount;
        this.invalidateRunnable = new Runnable() { // from class: org.rbmain.ui.Cells.SharingLiveLocationCell.1
            @Override // java.lang.Runnable
            public void run() {
                SharingLiveLocationCell.this.invalidate(((int) r0.rect.left) - 5, ((int) SharingLiveLocationCell.this.rect.top) - 5, ((int) SharingLiveLocationCell.this.rect.right) + 5, ((int) SharingLiveLocationCell.this.rect.bottom) + 5);
                AndroidUtilities.runOnUIThread(SharingLiveLocationCell.this.invalidateRunnable, 1000L);
            }
        };
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(21.0f));
        this.avatarDrawable = new AvatarDrawable();
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextSize(16);
        this.nameTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.nameTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.nameTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        if (z) {
            BackupImageView backupImageView2 = this.avatarImageView;
            boolean z2 = LocaleController.isRTL;
            addView(backupImageView2, LayoutHelper.createFrame(42, 42.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 15.0f, 12.0f, z2 ? 15.0f : 0.0f, 0.0f));
            SimpleTextView simpleTextView2 = this.nameTextView;
            boolean z3 = LocaleController.isRTL;
            addView(simpleTextView2, LayoutHelper.createFrame(-1, 20.0f, (z3 ? 5 : 3) | 48, z3 ? i : 73.0f, 12.0f, z3 ? 73.0f : i, 0.0f));
            SimpleTextView simpleTextView3 = new SimpleTextView(context);
            this.distanceTextView = simpleTextView3;
            simpleTextView3.setTextSize(14);
            this.distanceTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
            this.distanceTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            SimpleTextView simpleTextView4 = this.distanceTextView;
            boolean z4 = LocaleController.isRTL;
            addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, (z4 ? 5 : 3) | 48, z4 ? i : 73.0f, 37.0f, z4 ? 73.0f : i, 0.0f));
        } else {
            BackupImageView backupImageView3 = this.avatarImageView;
            boolean z5 = LocaleController.isRTL;
            addView(backupImageView3, LayoutHelper.createFrame(42, 42.0f, (z5 ? 5 : 3) | 48, z5 ? 0.0f : 15.0f, 6.0f, z5 ? 15.0f : 0.0f, 0.0f));
            SimpleTextView simpleTextView5 = this.nameTextView;
            boolean z6 = LocaleController.isRTL;
            addView(simpleTextView5, LayoutHelper.createFrame(-2, -2.0f, (z6 ? 5 : 3) | 48, z6 ? i : 74.0f, 17.0f, z6 ? 74.0f : i, 0.0f));
        }
        setWillNotDraw(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.distanceTextView != null ? 66.0f : 54.0f), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AndroidUtilities.cancelRunOnUIThread(this.invalidateRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AndroidUtilities.runOnUIThread(this.invalidateRunnable);
    }

    public void setDialog(long j, TLRPC$TL_channelLocation tLRPC$TL_channelLocation) {
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        String str = tLRPC$TL_channelLocation.address;
        this.avatarDrawable = null;
        int i2 = (int) j;
        String userName = BuildConfig.FLAVOR;
        if (i2 > 0) {
            TLRPC$User user = MessagesController.getInstance(i).getUser(Integer.valueOf(i2));
            if (user != null) {
                this.avatarDrawable = new AvatarDrawable(user);
                userName = UserObject.getUserName(user);
                this.avatarImageView.setForUserOrChat(user, this.avatarDrawable);
            }
        } else {
            TLRPC$Chat chat = MessagesController.getInstance(i).getChat(Integer.valueOf(-i2));
            if (chat != null) {
                AvatarDrawable avatarDrawable = new AvatarDrawable(chat);
                this.avatarDrawable = avatarDrawable;
                String str2 = chat.title;
                this.avatarImageView.setForUserOrChat(chat, avatarDrawable);
                userName = str2;
            }
        }
        this.nameTextView.setText(userName);
        this.location.setLatitude(tLRPC$TL_channelLocation.geo_point.lat);
        this.location.setLongitude(tLRPC$TL_channelLocation.geo_point._long);
        this.distanceTextView.setText(str);
    }

    public void setDialog(MessageObject messageObject, Location location) throws Resources.NotFoundException {
        String str;
        int i;
        int fromChatId = messageObject.getFromChatId();
        if (messageObject.isForwarded()) {
            TLRPC$Peer tLRPC$Peer = messageObject.messageOwner.fwd_from.from_id;
            if (tLRPC$Peer instanceof TLRPC$TL_peerChannel) {
                i = tLRPC$Peer.channel_id;
            } else if (tLRPC$Peer instanceof TLRPC$TL_peerChat) {
                i = tLRPC$Peer.chat_id;
            } else if (tLRPC$Peer instanceof TLRPC$TL_peerUser) {
                fromChatId = tLRPC$Peer.user_id;
            }
            fromChatId = -i;
        }
        this.currentAccount = messageObject.currentAccount;
        String str2 = !TextUtils.isEmpty(messageObject.messageOwner.media.address) ? messageObject.messageOwner.media.address : null;
        if (!TextUtils.isEmpty(messageObject.messageOwner.media.title)) {
            str = messageObject.messageOwner.media.title;
            Drawable drawable = getResources().getDrawable(R.drawable.pin);
            drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_location_sendLocationIcon), PorterDuff.Mode.MULTIPLY));
            int color = Theme.getColor(Theme.key_location_placeLocationBackground);
            CombinedDrawable combinedDrawable = new CombinedDrawable(Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(42.0f), color, color), drawable);
            combinedDrawable.setCustomSize(AndroidUtilities.dp(42.0f), AndroidUtilities.dp(42.0f));
            combinedDrawable.setIconSize(AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f));
            this.avatarImageView.setImageDrawable(combinedDrawable);
        } else {
            String str3 = BuildConfig.FLAVOR;
            this.avatarDrawable = null;
            if (fromChatId > 0) {
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(fromChatId));
                if (user != null) {
                    this.avatarDrawable = new AvatarDrawable(user);
                    String userName = UserObject.getUserName(user);
                    this.avatarImageView.setForUserOrChat(user, this.avatarDrawable);
                    str = userName;
                }
            } else {
                TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(-fromChatId));
                if (chat != null) {
                    AvatarDrawable avatarDrawable = new AvatarDrawable(chat);
                    this.avatarDrawable = avatarDrawable;
                    str3 = chat.title;
                    this.avatarImageView.setForUserOrChat(chat, avatarDrawable);
                }
            }
            str = str3;
        }
        this.nameTextView.setText(str);
        this.location.setLatitude(messageObject.messageOwner.media.geo.lat);
        this.location.setLongitude(messageObject.messageOwner.media.geo._long);
        if (location == null) {
            if (str2 != null) {
                this.distanceTextView.setText(str2);
                return;
            } else {
                this.distanceTextView.setText(LocaleController.getString("Loading", R.string.Loading));
                return;
            }
        }
        float fDistanceTo = this.location.distanceTo(location);
        if (str2 != null) {
            this.distanceTextView.setText(String.format("%s - %s", str2, LocaleController.formatDistance(fDistanceTo, 0)));
        } else {
            this.distanceTextView.setText(LocaleController.formatDistance(fDistanceTo, 0));
        }
    }

    public void setDialog(LocationActivity.LiveLocation liveLocation, Location location) {
        this.liveLocation = liveLocation;
        int i = liveLocation.id;
        if (i > 0) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(i));
            if (user != null) {
                this.avatarDrawable.setInfo(user);
                this.nameTextView.setText(ContactsController.formatName(user.first_name, user.last_name));
                this.avatarImageView.setForUserOrChat(user, this.avatarDrawable);
            }
        } else {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(-i));
            if (chat != null) {
                this.avatarDrawable.setInfo(chat);
                this.nameTextView.setText(chat.title);
                this.avatarImageView.setForUserOrChat(chat, this.avatarDrawable);
            }
        }
        LatLng position = liveLocation.marker.getPosition();
        this.location.setLatitude(position.latitude);
        this.location.setLongitude(position.longitude);
        int i2 = liveLocation.object.edit_date;
        String locationUpdateDate = LocaleController.formatLocationUpdateDate(i2 != 0 ? i2 : r5.date);
        if (location != null) {
            this.distanceTextView.setText(String.format("%s - %s", locationUpdateDate, LocaleController.formatDistance(this.location.distanceTo(location), 0)));
        } else {
            this.distanceTextView.setText(locationUpdateDate);
        }
    }

    public void setDialog(LocationController.SharingLocationInfo sharingLocationInfo) {
        this.currentInfo = sharingLocationInfo;
        this.currentAccount = sharingLocationInfo.account;
        this.avatarImageView.getImageReceiver().setCurrentAccount(this.currentAccount);
        int i = (int) sharingLocationInfo.did;
        if (i > 0) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(i));
            if (user != null) {
                this.avatarDrawable.setInfo(user);
                this.nameTextView.setText(ContactsController.formatName(user.first_name, user.last_name));
                this.avatarImageView.setForUserOrChat(user, this.avatarDrawable);
                return;
            }
            return;
        }
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(-i));
        if (chat != null) {
            this.avatarDrawable.setInfo(chat);
            this.nameTextView.setText(chat.title);
            this.avatarImageView.setForUserOrChat(chat, this.avatarDrawable);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int color;
        LocationController.SharingLocationInfo sharingLocationInfo = this.currentInfo;
        if (sharingLocationInfo == null && this.liveLocation == null) {
            return;
        }
        if (sharingLocationInfo != null) {
            i2 = sharingLocationInfo.stopTime;
            i = sharingLocationInfo.period;
        } else {
            TLRPC$Message tLRPC$Message = this.liveLocation.object;
            int i3 = tLRPC$Message.date;
            i = tLRPC$Message.media.period;
            i2 = i3 + i;
        }
        int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
        if (i2 < currentTime) {
            return;
        }
        int i4 = i2 - currentTime;
        float fAbs = Math.abs(i4) / i;
        if (LocaleController.isRTL) {
            this.rect.set(AndroidUtilities.dp(13.0f), AndroidUtilities.dp(this.distanceTextView == null ? 12.0f : 18.0f), AndroidUtilities.dp(43.0f), AndroidUtilities.dp(this.distanceTextView == null ? 42.0f : 48.0f));
        } else {
            this.rect.set(getMeasuredWidth() - AndroidUtilities.dp(43.0f), AndroidUtilities.dp(this.distanceTextView == null ? 12.0f : 18.0f), getMeasuredWidth() - AndroidUtilities.dp(13.0f), AndroidUtilities.dp(this.distanceTextView == null ? 42.0f : 48.0f));
        }
        if (this.distanceTextView == null) {
            color = Theme.getColor(Theme.key_dialog_liveLocationProgress);
        } else {
            color = Theme.getColor(Theme.key_location_liveLocationProgress);
        }
        Theme.chat_radialProgress2Paint.setColor(color);
        Theme.chat_livePaint.setColor(color);
        canvas.drawArc(this.rect, -90.0f, fAbs * (-360.0f), false, Theme.chat_radialProgress2Paint);
        String locationLeftTime = LocaleController.formatLocationLeftTime(i4);
        canvas.drawText(locationLeftTime, this.rect.centerX() - (Theme.chat_livePaint.measureText(locationLeftTime) / 2.0f), AndroidUtilities.dp(this.distanceTextView != null ? 37.0f : 31.0f), Theme.chat_livePaint);
    }
}
