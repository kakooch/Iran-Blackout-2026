package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.LetterDrawable;
import org.rbmain.ui.Components.LinkPath;

/* loaded from: classes4.dex */
public class SharedLinkCell extends FrameLayout {
    private StaticLayout captionLayout;
    private TextPaint captionTextPaint;
    private int captionY;
    private CheckBox2 checkBox;
    private boolean checkingForLongPress;
    private StaticLayout dateLayout;
    private int dateLayoutX;
    private SharedLinkCellDelegate delegate;
    private TextPaint description2TextPaint;
    private int description2Y;
    private StaticLayout descriptionLayout;
    private StaticLayout descriptionLayout2;
    private TextPaint descriptionTextPaint;
    private int descriptionY;
    private boolean drawLinkImageView;
    private StaticLayout fromInfoLayout;
    private int fromInfoLayoutY;
    private LetterDrawable letterDrawable;
    private ImageReceiver linkImageView;
    private ArrayList<StaticLayout> linkLayout;
    private boolean linkPreviewPressed;
    private int linkY;
    ArrayList<String> links;
    private MessageObject message;
    private boolean needDivider;
    private CheckForLongPress pendingCheckForLongPress;
    private CheckForTap pendingCheckForTap;
    private int pressCount;
    private int pressedLink;
    private StaticLayout titleLayout;
    private TextPaint titleTextPaint;
    private int titleY;
    private LinkPath urlPath;
    private int viewType;

    public interface SharedLinkCellDelegate {
        boolean canPerformActions();

        void needOpenWebView(TLRPC$WebPage tLRPC$WebPage);

        void onLinkPress(String str, boolean z);
    }

    static /* synthetic */ int access$104(SharedLinkCell sharedLinkCell) {
        int i = sharedLinkCell.pressCount + 1;
        sharedLinkCell.pressCount = i;
        return i;
    }

    private final class CheckForTap implements Runnable {
        private CheckForTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SharedLinkCell.this.pendingCheckForLongPress == null) {
                SharedLinkCell sharedLinkCell = SharedLinkCell.this;
                sharedLinkCell.pendingCheckForLongPress = sharedLinkCell.new CheckForLongPress();
            }
            SharedLinkCell.this.pendingCheckForLongPress.currentPressCount = SharedLinkCell.access$104(SharedLinkCell.this);
            SharedLinkCell sharedLinkCell2 = SharedLinkCell.this;
            sharedLinkCell2.postDelayed(sharedLinkCell2.pendingCheckForLongPress, ViewConfiguration.getLongPressTimeout() - ViewConfiguration.getTapTimeout());
        }
    }

    class CheckForLongPress implements Runnable {
        public int currentPressCount;

        CheckForLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SharedLinkCell.this.checkingForLongPress && SharedLinkCell.this.getParent() != null && this.currentPressCount == SharedLinkCell.this.pressCount) {
                SharedLinkCell.this.checkingForLongPress = false;
                SharedLinkCell.this.performHapticFeedback(0);
                if (SharedLinkCell.this.pressedLink >= 0) {
                    SharedLinkCellDelegate sharedLinkCellDelegate = SharedLinkCell.this.delegate;
                    SharedLinkCell sharedLinkCell = SharedLinkCell.this;
                    sharedLinkCellDelegate.onLinkPress(sharedLinkCell.links.get(sharedLinkCell.pressedLink), true);
                }
                MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                SharedLinkCell.this.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
    }

    protected void startCheckLongPress() {
        if (this.checkingForLongPress) {
            return;
        }
        this.checkingForLongPress = true;
        if (this.pendingCheckForTap == null) {
            this.pendingCheckForTap = new CheckForTap();
        }
        postDelayed(this.pendingCheckForTap, ViewConfiguration.getTapTimeout());
    }

    protected void cancelCheckLongPress() {
        this.checkingForLongPress = false;
        CheckForLongPress checkForLongPress = this.pendingCheckForLongPress;
        if (checkForLongPress != null) {
            removeCallbacks(checkForLongPress);
        }
        CheckForTap checkForTap = this.pendingCheckForTap;
        if (checkForTap != null) {
            removeCallbacks(checkForTap);
        }
    }

    public SharedLinkCell(Context context) {
        this(context, 0);
    }

    public SharedLinkCell(Context context, int i) {
        super(context);
        this.checkingForLongPress = false;
        this.pendingCheckForLongPress = null;
        this.pressCount = 0;
        this.pendingCheckForTap = null;
        this.links = new ArrayList<>();
        this.linkLayout = new ArrayList<>();
        this.titleY = AndroidUtilities.dp(10.0f);
        this.descriptionY = AndroidUtilities.dp(30.0f);
        this.description2Y = AndroidUtilities.dp(30.0f);
        this.captionY = AndroidUtilities.dp(30.0f);
        this.fromInfoLayoutY = AndroidUtilities.dp(30.0f);
        this.viewType = i;
        setFocusable(true);
        LinkPath linkPath = new LinkPath();
        this.urlPath = linkPath;
        linkPath.setUseRoundRect(true);
        TextPaint textPaint = new TextPaint(1);
        this.titleTextPaint = textPaint;
        textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.titleTextPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        this.descriptionTextPaint = new TextPaint(1);
        this.titleTextPaint.setTextSize(AndroidUtilities.dp(14.0f));
        this.descriptionTextPaint.setTextSize(AndroidUtilities.dp(14.0f));
        setWillNotDraw(false);
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.linkImageView = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.dp(4.0f));
        this.letterDrawable = new LetterDrawable();
        CheckBox2 checkBox2 = new CheckBox2(context, 21);
        this.checkBox = checkBox2;
        checkBox2.setVisibility(4);
        this.checkBox.setColor(-1, Theme.key_windowBackgroundWhite, Theme.key_checkboxCheck);
        this.checkBox.setDrawUnchecked(false);
        this.checkBox.setDrawBackgroundAsArc(2);
        CheckBox2 checkBox22 = this.checkBox;
        boolean z = LocaleController.isRTL;
        addView(checkBox22, LayoutHelper.createFrame(24, 24.0f, (z ? 5 : 3) | 48, z ? 0.0f : 44.0f, 44.0f, z ? 44.0f : 0.0f, 0.0f));
        if (i == 1) {
            TextPaint textPaint2 = new TextPaint(1);
            this.description2TextPaint = textPaint2;
            textPaint2.setTextSize(AndroidUtilities.dp(13.0f));
        }
        TextPaint textPaint3 = new TextPaint(1);
        this.captionTextPaint = textPaint3;
        textPaint3.setTextSize(AndroidUtilities.dp(13.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.CharSequence] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r30, int r31) {
        /*
            Method dump skipped, instructions count: 1521
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.SharedLinkCell.onMeasure(int, int):void");
    }

    public void setLink(MessageObject messageObject, boolean z) {
        this.needDivider = z;
        resetPressedLink();
        this.message = messageObject;
        requestLayout();
    }

    public void setDelegate(SharedLinkCellDelegate sharedLinkCellDelegate) {
        this.delegate = sharedLinkCellDelegate;
    }

    public MessageObject getMessage() {
        return this.message;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.drawLinkImageView) {
            this.linkImageView.onDetachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.drawLinkImageView) {
            this.linkImageView.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        SharedLinkCellDelegate sharedLinkCellDelegate;
        boolean z2;
        String str;
        TLRPC$MessageMedia tLRPC$MessageMedia;
        if (this.message != null && !this.linkLayout.isEmpty() && (sharedLinkCellDelegate = this.delegate) != null && sharedLinkCellDelegate.canPerformActions()) {
            if (motionEvent.getAction() == 0 || (this.linkPreviewPressed && motionEvent.getAction() == 1)) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= this.linkLayout.size()) {
                        z2 = false;
                        break;
                    }
                    StaticLayout staticLayout = this.linkLayout.get(i);
                    if (staticLayout.getLineCount() > 0) {
                        int lineBottom = staticLayout.getLineBottom(staticLayout.getLineCount() - 1);
                        float f = x;
                        float fDp = AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline);
                        if (f >= staticLayout.getLineLeft(0) + fDp && f <= fDp + staticLayout.getLineWidth(0)) {
                            int i3 = this.linkY;
                            if (y >= i3 + i2 && y <= i3 + i2 + lineBottom) {
                                if (motionEvent.getAction() == 0) {
                                    resetPressedLink();
                                    this.pressedLink = i;
                                    this.linkPreviewPressed = true;
                                    startCheckLongPress();
                                    try {
                                        this.urlPath.setCurrentLayout(staticLayout, 0, 0.0f);
                                        staticLayout.getSelectionPath(0, staticLayout.getText().length(), this.urlPath);
                                    } catch (Exception e) {
                                        FileLog.e(e);
                                    }
                                } else if (this.linkPreviewPressed) {
                                    try {
                                        TLRPC$WebPage tLRPC$WebPage = (this.pressedLink != 0 || (tLRPC$MessageMedia = this.message.messageOwner.media) == null) ? null : tLRPC$MessageMedia.webpage;
                                        if (tLRPC$WebPage != null && (str = tLRPC$WebPage.embed_url) != null && str.length() != 0) {
                                            this.delegate.needOpenWebView(tLRPC$WebPage);
                                        } else {
                                            this.delegate.onLinkPress(this.links.get(this.pressedLink), false);
                                        }
                                    } catch (Exception e2) {
                                        FileLog.e(e2);
                                    }
                                    resetPressedLink();
                                } else {
                                    z2 = true;
                                }
                                z2 = true;
                                z = true;
                            }
                        }
                        i2 += lineBottom;
                    }
                    i++;
                }
                z = false;
                if (!z2) {
                    resetPressedLink();
                }
                return z || super.onTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 3) {
                resetPressedLink();
            }
        } else {
            resetPressedLink();
        }
        z = false;
        if (z) {
            return true;
        }
    }

    public String getLink(int i) {
        if (i < 0 || i >= this.links.size()) {
            return null;
        }
        return this.links.get(i);
    }

    protected void resetPressedLink() {
        this.pressedLink = -1;
        this.linkPreviewPressed = false;
        cancelCheckLongPress();
        invalidate();
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.checkBox.getVisibility() != 0) {
            this.checkBox.setVisibility(0);
        }
        this.checkBox.setChecked(z, z2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.viewType == 1) {
            this.description2TextPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
        }
        if (this.dateLayout != null) {
            canvas.save();
            canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline) + (LocaleController.isRTL ? 0 : this.dateLayoutX), this.titleY);
            this.dateLayout.draw(canvas);
            canvas.restore();
        }
        if (this.titleLayout != null) {
            canvas.save();
            float fDp = AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline);
            if (LocaleController.isRTL) {
                fDp += this.dateLayout == null ? 0.0f : r4.getWidth() + AndroidUtilities.dp(4.0f);
            }
            canvas.translate(fDp, this.titleY);
            this.titleLayout.draw(canvas);
            canvas.restore();
        }
        if (this.captionLayout != null) {
            this.captionTextPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            canvas.save();
            canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline), this.captionY);
            this.captionLayout.draw(canvas);
            canvas.restore();
        }
        if (this.descriptionLayout != null) {
            this.descriptionTextPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            canvas.save();
            canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline), this.descriptionY);
            this.descriptionLayout.draw(canvas);
            canvas.restore();
        }
        if (this.descriptionLayout2 != null) {
            this.descriptionTextPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            canvas.save();
            canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline), this.description2Y);
            this.descriptionLayout2.draw(canvas);
            canvas.restore();
        }
        if (!this.linkLayout.isEmpty()) {
            this.descriptionTextPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteLinkText));
            int lineBottom = 0;
            for (int i = 0; i < this.linkLayout.size(); i++) {
                StaticLayout staticLayout = this.linkLayout.get(i);
                if (staticLayout.getLineCount() > 0) {
                    canvas.save();
                    canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline), this.linkY + lineBottom);
                    if (this.pressedLink == i) {
                        canvas.drawPath(this.urlPath, Theme.linkSelectionPaint);
                    }
                    staticLayout.draw(canvas);
                    canvas.restore();
                    lineBottom += staticLayout.getLineBottom(staticLayout.getLineCount() - 1);
                }
            }
        }
        if (this.fromInfoLayout != null) {
            canvas.save();
            canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline), this.fromInfoLayoutY);
            this.fromInfoLayout.draw(canvas);
            canvas.restore();
        }
        this.letterDrawable.draw(canvas);
        if (this.drawLinkImageView) {
            this.linkImageView.draw(canvas);
        }
        if (this.needDivider) {
            if (LocaleController.isRTL) {
                canvas.drawLine(0.0f, getMeasuredHeight() - 1, getMeasuredWidth() - AndroidUtilities.dp(AndroidUtilities.leftBaseline), getMeasuredHeight() - 1, Theme.dividerPaint);
            } else {
                canvas.drawLine(AndroidUtilities.dp(AndroidUtilities.leftBaseline), getMeasuredHeight() - 1, getMeasuredWidth(), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        StringBuilder sb = new StringBuilder();
        StaticLayout staticLayout = this.titleLayout;
        if (staticLayout != null) {
            sb.append(staticLayout.getText());
        }
        if (this.descriptionLayout != null) {
            sb.append(", ");
            sb.append(this.descriptionLayout.getText());
        }
        if (this.descriptionLayout2 != null) {
            sb.append(", ");
            sb.append(this.descriptionLayout2.getText());
        }
        accessibilityNodeInfo.setText(sb.toString());
        if (this.checkBox.isChecked()) {
            accessibilityNodeInfo.setChecked(true);
            accessibilityNodeInfo.setCheckable(true);
        }
    }
}
