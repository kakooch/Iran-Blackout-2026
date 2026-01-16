package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.location.Location;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$TL_channelLocation;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.LocationActivity;

/* loaded from: classes3.dex */
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
    private final Theme.ResourcesProvider resourcesProvider;

    public SharingLiveLocationCell(Context context, boolean distance, int padding, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.rect = new RectF();
        this.location = new Location("network");
        this.currentAccount = UserConfig.selectedAccount;
        this.invalidateRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.SharingLiveLocationCell.1
            @Override // java.lang.Runnable
            public void run() {
                SharingLiveLocationCell.this.invalidate(((int) r0.rect.left) - 5, ((int) SharingLiveLocationCell.this.rect.top) - 5, ((int) SharingLiveLocationCell.this.rect.right) + 5, ((int) SharingLiveLocationCell.this.rect.bottom) + 5);
                AndroidUtilities.runOnUIThread(SharingLiveLocationCell.this.invalidateRunnable, 1000L);
            }
        };
        this.resourcesProvider = resourcesProvider;
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(21.0f));
        this.avatarDrawable = new AvatarDrawable();
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextSize(16);
        this.nameTextView.setTextColor(getThemedColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.nameTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        if (distance) {
            BackupImageView backupImageView2 = this.avatarImageView;
            boolean z = LocaleController.isRTL;
            addView(backupImageView2, LayoutHelper.createFrame(42, 42.0f, (z ? 5 : 3) | 48, z ? 0.0f : 15.0f, 12.0f, z ? 15.0f : 0.0f, 0.0f));
            SimpleTextView simpleTextView2 = this.nameTextView;
            boolean z2 = LocaleController.isRTL;
            addView(simpleTextView2, LayoutHelper.createFrame(-1, 20.0f, (z2 ? 5 : 3) | 48, z2 ? padding : 73.0f, 12.0f, z2 ? 73.0f : padding, 0.0f));
            SimpleTextView simpleTextView3 = new SimpleTextView(context);
            this.distanceTextView = simpleTextView3;
            simpleTextView3.setTextSize(14);
            this.distanceTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.distanceTextView.setTextColor(getThemedColor("windowBackgroundWhiteGrayText3"));
            this.distanceTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            SimpleTextView simpleTextView4 = this.distanceTextView;
            boolean z3 = LocaleController.isRTL;
            addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, (z3 ? 5 : 3) | 48, z3 ? padding : 73.0f, 37.0f, z3 ? 73.0f : padding, 0.0f));
        } else {
            BackupImageView backupImageView3 = this.avatarImageView;
            boolean z4 = LocaleController.isRTL;
            addView(backupImageView3, LayoutHelper.createFrame(42, 42.0f, (z4 ? 5 : 3) | 48, z4 ? 0.0f : 15.0f, 6.0f, z4 ? 15.0f : 0.0f, 0.0f));
            SimpleTextView simpleTextView5 = this.nameTextView;
            boolean z5 = LocaleController.isRTL;
            addView(simpleTextView5, LayoutHelper.createFrame(-2, -2.0f, (z5 ? 5 : 3) | 48, z5 ? padding : 74.0f, 17.0f, z5 ? 74.0f : padding, 0.0f));
        }
        setWillNotDraw(false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.distanceTextView != null ? 66.0f : 54.0f), 1073741824));
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

    public void setDialog(long dialogId, TLRPC$TL_channelLocation chatLocation) {
        this.currentAccount = UserConfig.selectedAccount;
        String str = chatLocation.address;
        this.avatarDrawable = null;
        String str2 = "";
        if (DialogObject.isUserDialog(dialogId)) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(dialogId));
            if (user != null) {
                this.avatarDrawable = new AvatarDrawable(user);
                String userName = UserObject.getUserName(user);
                this.avatarImageView.setForUserOrChat(user, this.avatarDrawable);
                str2 = userName;
            }
        } else {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-dialogId));
            if (chat != null) {
                AvatarDrawable avatarDrawable = new AvatarDrawable(chat);
                this.avatarDrawable = avatarDrawable;
                str2 = chat.title;
                this.avatarImageView.setForUserOrChat(chat, avatarDrawable);
            }
        }
        this.nameTextView.setText(str2);
        this.location.setLatitude(chatLocation.geo_point.lat);
        this.location.setLongitude(chatLocation.geo_point._long);
        this.distanceTextView.setText(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDialog(ir.eitaa.messenger.MessageObject r8, android.location.Location r9) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.SharingLiveLocationCell.setDialog(ir.eitaa.messenger.MessageObject, android.location.Location):void");
    }

    public void setDialog(LocationController.SharingLocationInfo info) {
        this.currentInfo = info;
        this.currentAccount = info.account;
        this.avatarImageView.getImageReceiver().setCurrentAccount(this.currentAccount);
        if (DialogObject.isUserDialog(info.did)) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(info.did));
            if (user != null) {
                this.avatarDrawable.setInfo(user);
                this.nameTextView.setText(ContactsController.formatName(user.first_name, user.last_name));
                this.avatarImageView.setForUserOrChat(user, this.avatarDrawable);
                return;
            }
            return;
        }
        TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-info.did));
        if (chat != null) {
            this.avatarDrawable.setInfo(chat);
            this.nameTextView.setText(chat.title);
            this.avatarImageView.setForUserOrChat(chat, this.avatarDrawable);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int themedColor;
        LocationController.SharingLocationInfo sharingLocationInfo = this.currentInfo;
        if (sharingLocationInfo == null && this.liveLocation == null) {
            return;
        }
        sharingLocationInfo.getClass();
        int i = sharingLocationInfo.stopTime;
        int i2 = sharingLocationInfo.period;
        int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
        if (i < currentTime) {
            return;
        }
        int i3 = i - currentTime;
        float fAbs = Math.abs(i3) / i2;
        if (LocaleController.isRTL) {
            this.rect.set(AndroidUtilities.dp(13.0f), AndroidUtilities.dp(this.distanceTextView == null ? 12.0f : 18.0f), AndroidUtilities.dp(43.0f), AndroidUtilities.dp(this.distanceTextView == null ? 42.0f : 48.0f));
        } else {
            this.rect.set(getMeasuredWidth() - AndroidUtilities.dp(43.0f), AndroidUtilities.dp(this.distanceTextView == null ? 12.0f : 18.0f), getMeasuredWidth() - AndroidUtilities.dp(13.0f), AndroidUtilities.dp(this.distanceTextView == null ? 42.0f : 48.0f));
        }
        if (this.distanceTextView == null) {
            themedColor = getThemedColor("dialog_liveLocationProgress");
        } else {
            themedColor = getThemedColor("location_liveLocationProgress");
        }
        Theme.chat_radialProgress2Paint.setColor(themedColor);
        Theme.chat_livePaint.setColor(themedColor);
        canvas.drawArc(this.rect, -90.0f, fAbs * (-360.0f), false, Theme.chat_radialProgress2Paint);
        String locationLeftTime = LocaleController.formatLocationLeftTime(i3);
        canvas.drawText(locationLeftTime, this.rect.centerX() - (Theme.chat_livePaint.measureText(locationLeftTime) / 2.0f), AndroidUtilities.dp(this.distanceTextView != null ? 37.0f : 31.0f), Theme.chat_livePaint);
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
