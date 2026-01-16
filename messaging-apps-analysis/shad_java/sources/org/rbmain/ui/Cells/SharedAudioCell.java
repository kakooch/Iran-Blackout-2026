package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_photoSize;
import org.rbmain.tgnet.TLRPC$TL_photoSizeProgressive;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.DotDividerSpan;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RadialProgress2;
import org.rbmain.ui.FilteredSearchView;

/* loaded from: classes4.dex */
public class SharedAudioCell extends FrameLayout implements DownloadController.FileDownloadProgressListener, NotificationCenter.NotificationCenterDelegate {
    private int TAG;
    private boolean buttonPressed;
    private int buttonState;
    private int buttonX;
    private int buttonY;
    private StaticLayout captionLayout;
    private TextPaint captionTextPaint;
    private int captionY;
    private CheckBox2 checkBox;
    private boolean checkForButtonPress;
    private int currentAccount;
    private MessageObject currentMessageObject;
    private StaticLayout dateLayout;
    private int dateLayoutX;
    private TextPaint description2TextPaint;
    private StaticLayout descriptionLayout;
    private int descriptionY;
    private SpannableStringBuilder dotSpan;
    private int hasMiniProgress;
    private boolean miniButtonPressed;
    private int miniButtonState;
    private boolean needDivider;
    private RadialProgress2 radialProgress;
    private StaticLayout titleLayout;
    private int titleY;
    private int viewType;

    protected boolean needPlayMessage(MessageObject messageObject) {
        return false;
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String str, long j, long j2, boolean z) {
    }

    public SharedAudioCell(Context context) {
        this(context, 0);
    }

    public SharedAudioCell(Context context, int i) {
        super(context);
        this.titleY = AndroidUtilities.dp(9.0f);
        this.descriptionY = AndroidUtilities.dp(29.0f);
        this.captionY = AndroidUtilities.dp(29.0f);
        this.currentAccount = UserConfig.selectedAccount;
        this.viewType = i;
        setFocusable(true);
        RadialProgress2 radialProgress2 = new RadialProgress2(this);
        this.radialProgress = radialProgress2;
        radialProgress2.setColorKeys(Theme.key_chat_inLoader, Theme.key_chat_inLoaderSelected, Theme.key_chat_inMediaIcon, Theme.key_chat_inMediaIconSelected);
        this.TAG = DownloadController.getInstance(this.currentAccount).generateObserverTag();
        setWillNotDraw(false);
        CheckBox2 checkBox2 = new CheckBox2(context, 22);
        this.checkBox = checkBox2;
        checkBox2.setVisibility(4);
        this.checkBox.setColor(-1, Theme.key_windowBackgroundWhite, Theme.key_checkboxCheck);
        this.checkBox.setDrawUnchecked(false);
        this.checkBox.setDrawBackgroundAsArc(3);
        CheckBox2 checkBox22 = this.checkBox;
        boolean z = LocaleController.isRTL;
        addView(checkBox22, LayoutHelper.createFrame(24, 24.0f, (z ? 5 : 3) | 48, z ? 0.0f : 38.1f, 32.1f, z ? 6.0f : 0.0f, 0.0f));
        if (i == 1) {
            TextPaint textPaint = new TextPaint(1);
            this.description2TextPaint = textPaint;
            textPaint.setTextSize(AndroidUtilities.dp(13.0f));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(".");
            this.dotSpan = spannableStringBuilder;
            spannableStringBuilder.setSpan(new DotDividerSpan(), 0, 1, 0);
        }
        TextPaint textPaint2 = new TextPaint(1);
        this.captionTextPaint = textPaint2;
        textPaint2.setTextSize(AndroidUtilities.dp(13.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iDp;
        CharSequence charSequenceHighlightText;
        CharSequence charSequenceReplace;
        this.descriptionLayout = null;
        this.titleLayout = null;
        this.captionLayout = null;
        int size = (View.MeasureSpec.getSize(i) - AndroidUtilities.dp(AndroidUtilities.leftBaseline)) - AndroidUtilities.dp(28.0f);
        if (this.viewType == 1) {
            String strStringForMessageListDate = LocaleController.stringForMessageListDate(this.currentMessageObject.messageOwner.date);
            int iCeil = (int) Math.ceil(this.description2TextPaint.measureText(strStringForMessageListDate));
            this.dateLayout = ChatMessageCell.generateStaticLayout(strStringForMessageListDate, this.description2TextPaint, iCeil, iCeil, 0, 1);
            this.dateLayoutX = ((size - iCeil) - AndroidUtilities.dp(8.0f)) + AndroidUtilities.dp(20.0f);
            iDp = iCeil + AndroidUtilities.dp(12.0f);
        } else {
            iDp = 0;
        }
        try {
            if (this.viewType == 1 && (this.currentMessageObject.isVoice() || this.currentMessageObject.isRoundVideo())) {
                charSequenceReplace = FilteredSearchView.createFromInfoString(this.currentMessageObject);
            } else {
                charSequenceReplace = this.currentMessageObject.getMusicTitle().replace('\n', ' ');
            }
            CharSequence charSequenceHighlightText2 = AndroidUtilities.highlightText(charSequenceReplace, this.currentMessageObject.highlightedWords);
            if (charSequenceHighlightText2 != null) {
                charSequenceReplace = charSequenceHighlightText2;
            }
            this.titleLayout = new StaticLayout(TextUtils.ellipsize(charSequenceReplace, Theme.chat_contextResult_titleTextPaint, size - iDp, TextUtils.TruncateAt.END), Theme.chat_contextResult_titleTextPaint, (AndroidUtilities.dp(4.0f) + size) - iDp, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (this.currentMessageObject.hasHighlightedWords() && (charSequenceHighlightText = AndroidUtilities.highlightText(Emoji.replaceEmoji(this.currentMessageObject.messageOwner.message.replace("\n", " ").replaceAll(" +", " ").trim(), Theme.chat_msgTextPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false), this.currentMessageObject.highlightedWords)) != null) {
            this.captionLayout = new StaticLayout(TextUtils.ellipsize(AndroidUtilities.ellipsizeCenterEnd(charSequenceHighlightText, this.currentMessageObject.highlightedWords.get(0), size, this.captionTextPaint, 130), this.captionTextPaint, size, TextUtils.TruncateAt.END), this.captionTextPaint, size + AndroidUtilities.dp(4.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
        try {
            if (this.viewType == 1 && (this.currentMessageObject.isVoice() || this.currentMessageObject.isRoundVideo())) {
                String duration = AndroidUtilities.formatDuration(this.currentMessageObject.getDuration(), false);
                TextPaint textPaint = this.viewType == 1 ? this.description2TextPaint : Theme.chat_contextResult_descriptionTextPaint;
                this.descriptionLayout = new StaticLayout(TextUtils.ellipsize(duration, textPaint, size, TextUtils.TruncateAt.END), textPaint, size + AndroidUtilities.dp(4.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            } else {
                CharSequence charSequenceReplace2 = this.currentMessageObject.getMusicAuthor().replace('\n', ' ');
                CharSequence charSequenceHighlightText3 = AndroidUtilities.highlightText(charSequenceReplace2, this.currentMessageObject.highlightedWords);
                if (charSequenceHighlightText3 != null) {
                    charSequenceReplace2 = charSequenceHighlightText3;
                }
                if (this.viewType == 1) {
                    charSequenceReplace2 = new SpannableStringBuilder(charSequenceReplace2).append(' ').append((CharSequence) this.dotSpan).append(' ').append(FilteredSearchView.createFromInfoString(this.currentMessageObject));
                }
                TextPaint textPaint2 = this.viewType == 1 ? this.description2TextPaint : Theme.chat_contextResult_descriptionTextPaint;
                this.descriptionLayout = new StaticLayout(TextUtils.ellipsize(charSequenceReplace2, textPaint2, size, TextUtils.TruncateAt.END), textPaint2, size + AndroidUtilities.dp(4.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), AndroidUtilities.dp(56.0f) + (this.captionLayout != null ? AndroidUtilities.dp(18.0f) : 0) + (this.needDivider ? 1 : 0));
        int size2 = LocaleController.isRTL ? (View.MeasureSpec.getSize(i) - AndroidUtilities.dp(8.0f)) - AndroidUtilities.dp(52.0f) : AndroidUtilities.dp(8.0f);
        RadialProgress2 radialProgress2 = this.radialProgress;
        int iDp2 = AndroidUtilities.dp(4.0f) + size2;
        this.buttonX = iDp2;
        int iDp3 = AndroidUtilities.dp(6.0f);
        this.buttonY = iDp3;
        radialProgress2.setProgressRect(iDp2, iDp3, size2 + AndroidUtilities.dp(48.0f), AndroidUtilities.dp(50.0f));
        measureChildWithMargins(this.checkBox, i, 0, i2, 0);
        if (this.captionLayout != null) {
            this.captionY = AndroidUtilities.dp(29.0f);
            this.descriptionY = AndroidUtilities.dp(29.0f) + AndroidUtilities.dp(18.0f);
        } else {
            this.descriptionY = AndroidUtilities.dp(29.0f);
        }
    }

    public void setMessageObject(MessageObject messageObject, boolean z) {
        this.needDivider = z;
        this.currentMessageObject = messageObject;
        TLRPC$Document document = messageObject.getDocument();
        TLRPC$PhotoSize closestPhotoSizeWithSize = document != null ? FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 240) : null;
        if ((closestPhotoSizeWithSize instanceof TLRPC$TL_photoSize) || (closestPhotoSizeWithSize instanceof TLRPC$TL_photoSizeProgressive)) {
            this.radialProgress.setImageOverlay(closestPhotoSizeWithSize, document, messageObject);
        } else {
            String artworkUrl = messageObject.getArtworkUrl(true);
            if (!TextUtils.isEmpty(artworkUrl)) {
                this.radialProgress.setImageOverlay(artworkUrl);
            } else {
                this.radialProgress.setImageOverlay(null, null, null);
            }
        }
        updateButtonState(false, false);
        requestLayout();
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.checkBox.getVisibility() != 0) {
            this.checkBox.setVisibility(0);
        }
        this.checkBox.setChecked(z, z2);
    }

    public void setCheckForButtonPress(boolean z) {
        this.checkForButtonPress = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.radialProgress.onAttachedToWindow();
        updateButtonState(false, false);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidStart);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
        this.radialProgress.onDetachedFromWindow();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
    }

    public MessageObject getMessage() {
        return this.currentMessageObject;
    }

    public void initStreamingIcons() {
        this.radialProgress.initMiniIcons();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkAudioMotionEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            float r0 = r9.getX()
            int r0 = (int) r0
            float r1 = r9.getY()
            int r1 = (int) r1
            r2 = 1108344832(0x42100000, float:36.0)
            int r2 = org.rbmain.messenger.AndroidUtilities.dp(r2)
            int r3 = r8.miniButtonState
            r4 = 1
            r5 = 0
            if (r3 < 0) goto L32
            r3 = 1104674816(0x41d80000, float:27.0)
            int r3 = org.rbmain.messenger.AndroidUtilities.dp(r3)
            int r6 = r8.buttonX
            int r7 = r6 + r3
            if (r0 < r7) goto L32
            int r6 = r6 + r3
            int r6 = r6 + r2
            if (r0 > r6) goto L32
            int r6 = r8.buttonY
            int r7 = r6 + r3
            if (r1 < r7) goto L32
            int r6 = r6 + r3
            int r6 = r6 + r2
            if (r1 > r6) goto L32
            r2 = 1
            goto L33
        L32:
            r2 = 0
        L33:
            int r3 = r9.getAction()
            if (r3 != 0) goto L64
            if (r2 == 0) goto L47
            r8.miniButtonPressed = r4
            org.rbmain.ui.Components.RadialProgress2 r9 = r8.radialProgress
            r9.setPressed(r4, r4)
            r8.invalidate()
        L45:
            r5 = 1
            goto Lab
        L47:
            boolean r9 = r8.checkForButtonPress
            if (r9 == 0) goto Lab
            org.rbmain.ui.Components.RadialProgress2 r9 = r8.radialProgress
            android.graphics.RectF r9 = r9.getProgressRect()
            float r0 = (float) r0
            float r1 = (float) r1
            boolean r9 = r9.contains(r0, r1)
            if (r9 == 0) goto Lab
            r8.buttonPressed = r4
            org.rbmain.ui.Components.RadialProgress2 r9 = r8.radialProgress
            r9.setPressed(r4, r5)
            r8.invalidate()
            goto L45
        L64:
            int r0 = r9.getAction()
            if (r0 != r4) goto L8a
            boolean r9 = r8.miniButtonPressed
            if (r9 == 0) goto L7a
            r8.miniButtonPressed = r5
            r8.playSoundEffect(r5)
            r8.didPressedMiniButton(r4)
            r8.invalidate()
            goto Lab
        L7a:
            boolean r9 = r8.buttonPressed
            if (r9 == 0) goto Lab
            r8.buttonPressed = r5
            r8.playSoundEffect(r5)
            r8.didPressedButton()
            r8.invalidate()
            goto Lab
        L8a:
            int r0 = r9.getAction()
            r1 = 3
            if (r0 != r1) goto L99
            r8.miniButtonPressed = r5
            r8.buttonPressed = r5
            r8.invalidate()
            goto Lab
        L99:
            int r9 = r9.getAction()
            r0 = 2
            if (r9 != r0) goto Lab
            if (r2 != 0) goto Lab
            boolean r9 = r8.miniButtonPressed
            if (r9 == 0) goto Lab
            r8.miniButtonPressed = r5
            r8.invalidate()
        Lab:
            org.rbmain.ui.Components.RadialProgress2 r9 = r8.radialProgress
            boolean r0 = r8.miniButtonPressed
            r9.setPressed(r0, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.SharedAudioCell.checkAudioMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.currentMessageObject == null) {
            return super.onTouchEvent(motionEvent);
        }
        boolean zCheckAudioMotionEvent = checkAudioMotionEvent(motionEvent);
        if (motionEvent.getAction() != 3) {
            return zCheckAudioMotionEvent;
        }
        this.miniButtonPressed = false;
        this.buttonPressed = false;
        this.radialProgress.setPressed(false, false);
        this.radialProgress.setPressed(this.miniButtonPressed, true);
        return false;
    }

    private void didPressedMiniButton(boolean z) {
        int i = this.miniButtonState;
        if (i == 0) {
            this.miniButtonState = 1;
            this.radialProgress.setProgress(0.0f, false);
            FileLoader.getInstance(this.currentAccount).loadFile(this.currentMessageObject.getDocument(), this.currentMessageObject, 1, 0);
            this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, true);
            invalidate();
            return;
        }
        if (i == 1) {
            if (MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
                MediaController.getInstance().cleanupPlayer(true, true);
            }
            this.miniButtonState = 0;
            FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.currentMessageObject.getDocument());
            this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, true);
            invalidate();
        }
    }

    public void didPressedButton() {
        int i = this.buttonState;
        if (i == 0) {
            if (this.miniButtonState == 0) {
                FileLoader.getInstance(this.currentAccount).loadFile(this.currentMessageObject.getDocument(), this.currentMessageObject, 1, 0);
            }
            if (needPlayMessage(this.currentMessageObject)) {
                if (this.hasMiniProgress == 2 && this.miniButtonState != 1) {
                    this.miniButtonState = 1;
                    this.radialProgress.setProgress(0.0f, false);
                    this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, true);
                }
                this.buttonState = 1;
                this.radialProgress.setIcon(getIconForCurrentState(), false, true);
                invalidate();
                return;
            }
            return;
        }
        if (i == 1) {
            if (MediaController.getInstance().lambda$startAudioAgain$7(this.currentMessageObject)) {
                this.buttonState = 0;
                this.radialProgress.setIcon(getIconForCurrentState(), false, true);
                invalidate();
                return;
            }
            return;
        }
        if (i == 2) {
            this.radialProgress.setProgress(0.0f, false);
            FileLoader.getInstance(this.currentAccount).loadFile(this.currentMessageObject.getDocument(), this.currentMessageObject, 1, 0);
            this.buttonState = 4;
            this.radialProgress.setIcon(getIconForCurrentState(), false, true);
            invalidate();
            return;
        }
        if (i == 4) {
            FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.currentMessageObject.getDocument());
            this.buttonState = 2;
            this.radialProgress.setIcon(getIconForCurrentState(), false, true);
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        StaticLayout staticLayout;
        if (this.viewType == 1) {
            this.description2TextPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText3));
        }
        int width = 0;
        if (this.dateLayout != null) {
            canvas.save();
            canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline) + (LocaleController.isRTL ? 0 : this.dateLayoutX), this.titleY);
            this.dateLayout.draw(canvas);
            canvas.restore();
        }
        if (this.titleLayout != null) {
            canvas.save();
            int iDp = AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline);
            if (LocaleController.isRTL && (staticLayout = this.dateLayout) != null) {
                width = staticLayout.getWidth() + AndroidUtilities.dp(4.0f);
            }
            canvas.translate(iDp + width, this.titleY);
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
            Theme.chat_contextResult_descriptionTextPaint.setColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2));
            canvas.save();
            canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline), this.descriptionY);
            this.descriptionLayout.draw(canvas);
            canvas.restore();
        }
        this.radialProgress.setProgressColor(Theme.getColor(this.buttonPressed ? Theme.key_chat_inAudioSelectedProgress : Theme.key_chat_inAudioProgress));
        this.radialProgress.draw(canvas);
        if (this.needDivider) {
            canvas.drawLine(AndroidUtilities.dp(72.0f), getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, Theme.dividerPaint);
        }
    }

    private int getMiniIconForCurrentState() {
        int i = this.miniButtonState;
        if (i < 0) {
            return 4;
        }
        return i == 0 ? 2 : 3;
    }

    private int getIconForCurrentState() {
        int i = this.buttonState;
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        return i == 4 ? 3 : 0;
    }

    public void updateButtonState(boolean z, boolean z2) {
        String fileName = this.currentMessageObject.getFileName();
        if (TextUtils.isEmpty(fileName)) {
            return;
        }
        MessageObject messageObject = this.currentMessageObject;
        boolean z3 = messageObject.attachPathExists || messageObject.mediaExists;
        if (SharedConfig.streamMedia && messageObject.isMusic() && ((int) this.currentMessageObject.getDialogId()) != 0) {
            this.hasMiniProgress = z3 ? 1 : 2;
            z3 = true;
        } else {
            this.hasMiniProgress = 0;
            this.miniButtonState = -1;
        }
        if (this.hasMiniProgress == 0) {
            if (z3) {
                DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
                boolean zIsPlayingMessage = MediaController.getInstance().isPlayingMessage(this.currentMessageObject);
                if (!zIsPlayingMessage || (zIsPlayingMessage && MediaController.getInstance().isMessagePaused())) {
                    this.buttonState = 0;
                } else {
                    this.buttonState = 1;
                }
                this.radialProgress.setProgress(1.0f, z2);
                this.radialProgress.setIcon(getIconForCurrentState(), z, z2);
                invalidate();
                return;
            }
            DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(fileName, this.currentMessageObject, this);
            if (!FileLoader.getInstance(this.currentAccount).isLoadingFile(fileName)) {
                this.buttonState = 2;
                this.radialProgress.setProgress(0.0f, z2);
            } else {
                this.buttonState = 4;
                Float fileProgress = ImageLoader.getInstance().getFileProgress(fileName);
                if (fileProgress != null) {
                    this.radialProgress.setProgress(fileProgress.floatValue(), z2);
                } else {
                    this.radialProgress.setProgress(0.0f, z2);
                }
            }
            this.radialProgress.setIcon(getIconForCurrentState(), z, z2);
            invalidate();
            return;
        }
        this.radialProgress.setMiniProgressBackgroundColor(Theme.getColor(this.currentMessageObject.isOutOwner() ? Theme.key_chat_outLoader : Theme.key_chat_inLoader));
        boolean zIsPlayingMessage2 = MediaController.getInstance().isPlayingMessage(this.currentMessageObject);
        if (!zIsPlayingMessage2 || (zIsPlayingMessage2 && MediaController.getInstance().isMessagePaused())) {
            this.buttonState = 0;
        } else {
            this.buttonState = 1;
        }
        this.radialProgress.setIcon(getIconForCurrentState(), z, z2);
        if (this.hasMiniProgress == 1) {
            DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
            this.miniButtonState = -1;
            this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), z, z2);
            return;
        }
        DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(fileName, this.currentMessageObject, this);
        if (!FileLoader.getInstance(this.currentAccount).isLoadingFile(fileName)) {
            this.miniButtonState = 0;
            this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), z, z2);
            return;
        }
        this.miniButtonState = 1;
        this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), z, z2);
        Float fileProgress2 = ImageLoader.getInstance().getFileProgress(fileName);
        if (fileProgress2 != null) {
            this.radialProgress.setProgress(fileProgress2.floatValue(), z2);
        } else {
            this.radialProgress.setProgress(0.0f, z2);
        }
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String str, boolean z) {
        updateButtonState(true, z);
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onSuccessDownload(String str) {
        this.radialProgress.setProgress(1.0f, true);
        updateButtonState(false, true);
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String str, long j, long j2) {
        this.radialProgress.setProgress(Math.min(1.0f, j / j2), true);
        if (this.hasMiniProgress != 0) {
            if (this.miniButtonState != 1) {
                updateButtonState(false, true);
            }
        } else if (this.buttonState != 4) {
            updateButtonState(false, true);
        }
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.currentMessageObject.isMusic()) {
            accessibilityNodeInfo.setText(LocaleController.formatString("AccDescrMusicInfo", R.string.AccDescrMusicInfo, this.currentMessageObject.getMusicAuthor(), this.currentMessageObject.getMusicTitle()));
        } else if (this.titleLayout != null && this.descriptionLayout != null) {
            accessibilityNodeInfo.setText(((Object) this.titleLayout.getText()) + ", " + ((Object) this.descriptionLayout.getText()));
        }
        if (this.checkBox.isChecked()) {
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(true);
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        updateButtonState(false, true);
    }
}
