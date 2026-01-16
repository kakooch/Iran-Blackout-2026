package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ManageChatUserCell extends FrameLayout {
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private int currentAccount;
    private CharSequence currentName;
    private Object currentObject;
    private CharSequence currrntStatus;
    private ImageView customImageView;
    private ManageChatUserCellDelegate delegate;
    private String dividerColor;
    private boolean isAdmin;
    private TLRPC$FileLocation lastAvatar;
    private String lastName;
    private int lastStatus;
    private int namePadding;
    private SimpleTextView nameTextView;
    private boolean needDivider;
    private ImageView optionsButton;
    private int statusColor;
    private int statusOnlineColor;
    private SimpleTextView statusTextView;

    public interface ManageChatUserCellDelegate {
        boolean onOptionsButtonCheck(ManageChatUserCell cell, boolean click);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public ManageChatUserCell(Context context, int avatarPadding, int nPadding, boolean needOption) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.statusColor = Theme.getColor("windowBackgroundWhiteGrayText");
        this.statusOnlineColor = Theme.getColor("windowBackgroundWhiteBlueText");
        this.namePadding = nPadding;
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(23.0f));
        BackupImageView backupImageView2 = this.avatarImageView;
        boolean z = LocaleController.isRTL;
        addView(backupImageView2, LayoutHelper.createFrame(46, 46.0f, (z ? 5 : 3) | 48, z ? 0.0f : avatarPadding + 7, 8.0f, z ? avatarPadding + 7 : 0.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.nameTextView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameTextView.setTextSize(17);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.nameTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        SimpleTextView simpleTextView2 = this.nameTextView;
        boolean z2 = LocaleController.isRTL;
        addView(simpleTextView2, LayoutHelper.createFrame(-1, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 46.0f : this.namePadding + 68, 11.5f, z2 ? this.namePadding + 68 : 46.0f, 0.0f));
        SimpleTextView simpleTextView3 = new SimpleTextView(context);
        this.statusTextView = simpleTextView3;
        simpleTextView3.setTextSize(14);
        this.statusTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.statusTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        SimpleTextView simpleTextView4 = this.statusTextView;
        boolean z3 = LocaleController.isRTL;
        addView(simpleTextView4, LayoutHelper.createFrame(-1, 20.0f, (z3 ? 5 : 3) | 48, z3 ? 28.0f : this.namePadding + 68, 34.5f, z3 ? this.namePadding + 68 : 28.0f, 0.0f));
        if (needOption) {
            ImageView imageView = new ImageView(context);
            this.optionsButton = imageView;
            imageView.setFocusable(false);
            this.optionsButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("stickers_menuSelector")));
            this.optionsButton.setImageResource(R.drawable.ic_ab_other);
            this.optionsButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("stickers_menu"), PorterDuff.Mode.MULTIPLY));
            this.optionsButton.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.optionsButton, LayoutHelper.createFrame(60, 64, (LocaleController.isRTL ? 3 : 5) | 48));
            this.optionsButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ManageChatUserCell$EGHFzyIgnr8fpFbKLGLkGsaxZhE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$ManageChatUserCell(view);
                }
            });
            this.optionsButton.setContentDescription(LocaleController.getString("AccDescrUserOptions", R.string.AccDescrUserOptions));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ManageChatUserCell(View view) {
        this.delegate.onOptionsButtonCheck(this, true);
    }

    public void setCustomRightImage(int resId) {
        ImageView imageView = new ImageView(getContext());
        this.customImageView = imageView;
        imageView.setImageResource(resId);
        this.customImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.customImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("voipgroup_mutedIconUnscrolled"), PorterDuff.Mode.MULTIPLY));
        addView(this.customImageView, LayoutHelper.createFrame(52, 64, (LocaleController.isRTL ? 3 : 5) | 48));
    }

    public void setCustomImageVisible(boolean visible) {
        ImageView imageView = this.customImageView;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(visible ? 0 : 8);
    }

    public void setData(Object object, CharSequence name, CharSequence status, boolean divider) {
        float f;
        float f2;
        if (object == null) {
            this.currrntStatus = null;
            this.currentName = null;
            this.currentObject = null;
            this.nameTextView.setText("");
            this.statusTextView.setText("");
            this.avatarImageView.setImageDrawable(null);
            return;
        }
        this.currrntStatus = status;
        this.currentName = name;
        this.currentObject = object;
        if (this.optionsButton != null) {
            boolean zOnOptionsButtonCheck = this.delegate.onOptionsButtonCheck(this, false);
            this.optionsButton.setVisibility(zOnOptionsButtonCheck ? 0 : 4);
            SimpleTextView simpleTextView = this.nameTextView;
            boolean z = LocaleController.isRTL;
            simpleTextView.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? zOnOptionsButtonCheck ? 46 : 28 : this.namePadding + 68, (status == null || status.length() > 0) ? 11.5f : 20.5f, LocaleController.isRTL ? this.namePadding + 68 : zOnOptionsButtonCheck ? 46 : 28, 0.0f));
            SimpleTextView simpleTextView2 = this.statusTextView;
            boolean z2 = LocaleController.isRTL;
            int i = (z2 ? 5 : 3) | 48;
            float f3 = z2 ? zOnOptionsButtonCheck ? 46 : 28 : this.namePadding + 68;
            if (z2) {
                f2 = this.namePadding + 68;
            } else {
                f2 = zOnOptionsButtonCheck ? 46 : 28;
            }
            simpleTextView2.setLayoutParams(LayoutHelper.createFrame(-1, 20.0f, i, f3, 34.5f, f2, 0.0f));
        } else {
            ImageView imageView = this.customImageView;
            if (imageView != null) {
                boolean z3 = imageView.getVisibility() == 0;
                SimpleTextView simpleTextView3 = this.nameTextView;
                boolean z4 = LocaleController.isRTL;
                simpleTextView3.setLayoutParams(LayoutHelper.createFrame(-1, -2.0f, (z4 ? 5 : 3) | 48, z4 ? z3 ? 54 : 28 : this.namePadding + 68, (status == null || status.length() > 0) ? 11.5f : 20.5f, LocaleController.isRTL ? this.namePadding + 68 : z3 ? 54 : 28, 0.0f));
                SimpleTextView simpleTextView4 = this.statusTextView;
                boolean z5 = LocaleController.isRTL;
                int i2 = (z5 ? 5 : 3) | 48;
                float f4 = z5 ? z3 ? 54 : 28 : this.namePadding + 68;
                if (z5) {
                    f = this.namePadding + 68;
                } else {
                    f = z3 ? 54 : 28;
                }
                simpleTextView4.setLayoutParams(LayoutHelper.createFrame(-1, 20.0f, i2, f4, 34.5f, f, 0.0f));
            }
        }
        this.needDivider = divider;
        setWillNotDraw(!divider);
        update(0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + (this.needDivider ? 1 : 0), 1073741824));
    }

    public long getUserId() {
        Object obj = this.currentObject;
        if (obj instanceof TLRPC$User) {
            return ((TLRPC$User) obj).id;
        }
        return 0L;
    }

    public void setStatusColors(int color, int onlineColor) {
        this.statusColor = color;
        this.statusOnlineColor = onlineColor;
    }

    public void setIsAdmin(boolean value) {
        this.isAdmin = value;
    }

    public boolean hasAvatarSet() {
        return this.avatarImageView.getImageReceiver().hasNotThumb();
    }

    public void setNameColor(int color) {
        this.nameTextView.setTextColor(color);
    }

    public void setDividerColor(String key) {
        this.dividerColor = key;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x006e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(int r12) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ManageChatUserCell.update(int):void");
    }

    public void recycle() {
        this.avatarImageView.getImageReceiver().cancelLoadImage();
    }

    public void setDelegate(ManageChatUserCellDelegate manageChatUserCellDelegate) {
        this.delegate = manageChatUserCellDelegate;
    }

    public Object getCurrentObject() {
        return this.currentObject;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            String str = this.dividerColor;
            if (str != null) {
                Theme.dividerExtraPaint.setColor(Theme.getColor(str));
            }
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(68.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(68.0f) : 0), getMeasuredHeight() - 1, this.dividerColor != null ? Theme.dividerExtraPaint : Theme.dividerPaint);
        }
    }
}
