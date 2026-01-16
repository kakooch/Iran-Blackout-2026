package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.URLSpanNoUnderline;

/* loaded from: classes3.dex */
public class AdminedChannelCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private int currentAccount;
    private TLRPC$Chat currentChannel;
    private ImageView deleteButton;
    private boolean isLast;
    private SimpleTextView nameTextView;
    private SimpleTextView statusTextView;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public AdminedChannelCell(Context context, View.OnClickListener onClickListener) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(24.0f));
        BackupImageView backupImageView2 = this.avatarImageView;
        boolean z = LocaleController.isRTL;
        addView(backupImageView2, LayoutHelper.createFrame(48, 48.0f, (z ? 5 : 3) | 48, z ? 0.0f : 12.0f, 12.0f, z ? 12.0f : 0.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTextSize(17);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        SimpleTextView simpleTextView2 = this.nameTextView;
        boolean z2 = LocaleController.isRTL;
        addView(simpleTextView2, LayoutHelper.createFrame(-1, 20.0f, (z2 ? 5 : 3) | 48, z2 ? 62.0f : 73.0f, 15.5f, z2 ? 73.0f : 62.0f, 0.0f));
        SimpleTextView simpleTextView3 = new SimpleTextView(context);
        this.statusTextView = simpleTextView3;
        simpleTextView3.setTextSize(14);
        this.statusTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.statusTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        this.statusTextView.setLinkTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
        this.statusTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        SimpleTextView simpleTextView4 = this.statusTextView;
        boolean z3 = LocaleController.isRTL;
        addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, (z3 ? 5 : 3) | 48, z3 ? 62.0f : 73.0f, 38.5f, z3 ? 73.0f : 62.0f, 0.0f));
        ImageView imageView = new ImageView(context);
        this.deleteButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.deleteButton.setImageResource(R.drawable.msg_panel_clear);
        this.deleteButton.setOnClickListener(onClickListener);
        this.deleteButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayText"), PorterDuff.Mode.MULTIPLY));
        ImageView imageView2 = this.deleteButton;
        boolean z4 = LocaleController.isRTL;
        addView(imageView2, LayoutHelper.createFrame(48, 48.0f, (z4 ? 3 : 5) | 48, z4 ? 7.0f : 0.0f, 12.0f, z4 ? 0.0f : 7.0f, 0.0f));
    }

    public void setChannel(TLRPC$Chat channel, boolean last) {
        String str = MessagesController.getInstance(this.currentAccount).linkPrefix + "/";
        this.currentChannel = channel;
        this.avatarDrawable.setInfo(channel);
        this.nameTextView.setText(channel.title);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + channel.username);
        spannableStringBuilder.setSpan(new URLSpanNoUnderline(""), str.length(), spannableStringBuilder.length(), 33);
        this.statusTextView.setText(spannableStringBuilder);
        this.avatarImageView.setForUserOrChat(channel, this.avatarDrawable);
        this.isLast = last;
    }

    public void update() {
        this.avatarDrawable.setInfo(this.currentChannel);
        this.avatarImageView.invalidate();
    }

    public TLRPC$Chat getCurrentChannel() {
        return this.currentChannel;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp((this.isLast ? 12 : 0) + 60), 1073741824));
    }

    public SimpleTextView getNameTextView() {
        return this.nameTextView;
    }

    public SimpleTextView getStatusTextView() {
        return this.statusTextView;
    }

    public ImageView getDeleteButton() {
        return this.deleteButton;
    }
}
