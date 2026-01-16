package ir.eitaa.ui.Cells;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$RecentMeUrl;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;

/* loaded from: classes3.dex */
public class DialogMeUrlCell extends BaseCell {
    private AvatarDrawable avatarDrawable;
    private ImageReceiver avatarImage;
    private int avatarTop;
    private int currentAccount;
    private boolean drawNameBot;
    private boolean drawNameBroadcast;
    private boolean drawNameGroup;
    private boolean drawNameLock;
    private boolean drawVerified;
    private boolean isSelected;
    private StaticLayout messageLayout;
    private int messageLeft;
    private int messageTop;
    private StaticLayout nameLayout;
    private int nameLeft;
    private int nameLockLeft;
    private int nameLockTop;
    private int nameMuteLeft;
    private TLRPC$RecentMeUrl recentMeUrl;
    public boolean useSeparator;

    @Override // ir.eitaa.ui.Cells.BaseCell, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public DialogMeUrlCell(Context context) throws Resources.NotFoundException {
        super(context);
        this.avatarImage = new ImageReceiver(this);
        this.avatarDrawable = new AvatarDrawable();
        this.messageTop = AndroidUtilities.dp(40.0f);
        this.avatarTop = AndroidUtilities.dp(10.0f);
        this.currentAccount = UserConfig.selectedAccount;
        Theme.createDialogsResources(context);
        this.avatarImage.setRoundRadius(AndroidUtilities.dp(26.0f));
    }

    public void setRecentMeUrl(TLRPC$RecentMeUrl url) {
        this.recentMeUrl = url;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.avatarImage.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.avatarImage.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), AndroidUtilities.dp(72.0f) + (this.useSeparator ? 1 : 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (changed) {
            buildLayout();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:0|2|(5:4|(1:12)(1:11)|13|(3:15|(1:17)(1:18)|19)(3:20|(1:22)(1:23)|24)|25)(2:26|(4:28|(1:30)(1:31)|(3:33|(2:35|(1:37)(1:38))|39)|40)(2:41|(3:43|(1:45)(1:46)|47)(2:48|(6:50|(1:52)(1:53)|54|(3:56|(1:64)(1:63)|65)(3:66|(1:72)(1:71)|73)|74|(3:76|(1:78)(1:79)|80)(3:81|(1:83)(1:84)|85))(2:86|(3:88|(1:90)(1:91)|92)(1:93)))))|94|(1:96)|97|(1:99)(1:100)|101|(1:103)(2:105|(1:107)(2:108|(1:110)(14:111|(1:113)|114|(2:116|(1:118))|119|186|120|124|(3:126|(1:128)(1:129)|130)(3:131|(1:133)(1:134)|135)|136|188|137|141|(4:143|(4:147|(1:149)|150|(2:152|(1:154)))|155|(1:192)(2:161|(2:163|194)(1:193)))(4:164|(4:168|(2:170|(1:172))|173|(1:175))|176|(1:197)(2:182|(2:184|185)(1:198))))))|104|114|(0)|119|186|120|124|(0)(0)|136|188|137|141|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x039e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x039f, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0425, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0426, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void buildLayout() {
        /*
            Method dump skipped, instructions count: 1331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.DialogMeUrlCell.buildLayout():void");
    }

    public void setDialogSelected(boolean value) {
        if (this.isSelected != value) {
            invalidate();
        }
        this.isSelected = value;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.isSelected) {
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), Theme.dialogs_tabletSeletedPaint);
        }
        if (this.drawNameLock) {
            BaseCell.setDrawableBounds(Theme.dialogs_lockDrawable, this.nameLockLeft, this.nameLockTop);
            Theme.dialogs_lockDrawable.draw(canvas);
        } else if (this.drawNameGroup) {
            BaseCell.setDrawableBounds(Theme.dialogs_groupDrawable, this.nameLockLeft, this.nameLockTop);
            Theme.dialogs_groupDrawable.draw(canvas);
        } else if (this.drawNameBroadcast) {
            BaseCell.setDrawableBounds(Theme.dialogs_broadcastDrawable, this.nameLockLeft, this.nameLockTop);
            Theme.dialogs_broadcastDrawable.draw(canvas);
        } else if (this.drawNameBot) {
            BaseCell.setDrawableBounds(Theme.dialogs_botDrawable, this.nameLockLeft, this.nameLockTop);
            Theme.dialogs_botDrawable.draw(canvas);
        }
        if (this.nameLayout != null) {
            canvas.save();
            canvas.translate(this.nameLeft, AndroidUtilities.dp(13.0f));
            this.nameLayout.draw(canvas);
            canvas.restore();
        }
        if (this.messageLayout != null) {
            canvas.save();
            canvas.translate(this.messageLeft, this.messageTop);
            try {
                this.messageLayout.draw(canvas);
            } catch (Exception e) {
                FileLog.e(e);
            }
            canvas.restore();
        }
        if (this.drawVerified) {
            BaseCell.setDrawableBounds(Theme.dialogs_verifiedDrawable, this.nameMuteLeft, AndroidUtilities.dp(16.5f));
            BaseCell.setDrawableBounds(Theme.dialogs_verifiedCheckDrawable, this.nameMuteLeft, AndroidUtilities.dp(16.5f));
            Theme.dialogs_verifiedDrawable.draw(canvas);
            Theme.dialogs_verifiedCheckDrawable.draw(canvas);
        }
        if (this.useSeparator) {
            if (LocaleController.isRTL) {
                canvas.drawLine(0.0f, getMeasuredHeight() - 1, getMeasuredWidth() - AndroidUtilities.dp(AndroidUtilities.leftBaseline), getMeasuredHeight() - 1, Theme.dividerPaint);
            } else {
                canvas.drawLine(AndroidUtilities.dp(AndroidUtilities.leftBaseline), getMeasuredHeight() - 1, getMeasuredWidth(), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        }
        this.avatarImage.draw(canvas);
    }
}
