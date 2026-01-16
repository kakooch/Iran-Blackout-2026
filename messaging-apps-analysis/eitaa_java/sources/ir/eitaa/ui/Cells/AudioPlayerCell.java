package ir.eitaa.ui.Cells;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_photoSize;
import ir.eitaa.tgnet.TLRPC$TL_photoSizeProgressive;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.DotDividerSpan;
import ir.eitaa.ui.Components.RadialProgress2;
import ir.eitaa.ui.FilteredSearchView;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class AudioPlayerCell extends View implements DownloadController.FileDownloadProgressListener {
    private int TAG;
    private boolean buttonPressed;
    private int buttonState;
    private int buttonX;
    private int buttonY;
    private int currentAccount;
    private MessageObject currentMessageObject;
    private StaticLayout descriptionLayout;
    private int descriptionY;
    private SpannableStringBuilder dotSpan;
    private int hasMiniProgress;
    private boolean miniButtonPressed;
    private int miniButtonState;
    private RadialProgress2 radialProgress;
    private final Theme.ResourcesProvider resourcesProvider;
    private StaticLayout titleLayout;
    private int titleY;
    private int viewType;

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String fileName, long uploadedSize, long totalSize, boolean isEncrypted) {
    }

    public AudioPlayerCell(Context context, int viewType, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.titleY = AndroidUtilities.dp(9.0f);
        this.descriptionY = AndroidUtilities.dp(29.0f);
        this.currentAccount = UserConfig.selectedAccount;
        this.resourcesProvider = resourcesProvider;
        this.viewType = viewType;
        RadialProgress2 radialProgress2 = new RadialProgress2(this, resourcesProvider);
        this.radialProgress = radialProgress2;
        radialProgress2.setColors("chat_inLoader", "chat_inLoaderSelected", "chat_inMediaIcon", "chat_inMediaIconSelected");
        this.TAG = DownloadController.getInstance(this.currentAccount).generateObserverTag();
        setFocusable(true);
        if (viewType == 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(".");
            this.dotSpan = spannableStringBuilder;
            spannableStringBuilder.setSpan(new DotDividerSpan(), 0, 1, 0);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.descriptionLayout = null;
        this.titleLayout = null;
        int size = (View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(AndroidUtilities.leftBaseline)) - AndroidUtilities.dp(28.0f);
        try {
            this.titleLayout = new StaticLayout(TextUtils.ellipsize(this.currentMessageObject.getMusicTitle().replace('\n', ' '), Theme.chat_contextResult_titleTextPaint, Math.min((int) Math.ceil(Theme.chat_contextResult_titleTextPaint.measureText(r0)), size), TextUtils.TruncateAt.END), Theme.chat_contextResult_titleTextPaint, size + AndroidUtilities.dp(4.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            CharSequence charSequenceReplace = this.currentMessageObject.getMusicAuthor().replace('\n', ' ');
            if (this.viewType == 1) {
                charSequenceReplace = new SpannableStringBuilder(charSequenceReplace).append(' ').append((CharSequence) this.dotSpan).append(' ').append(FilteredSearchView.createFromInfoString(this.currentMessageObject));
            }
            this.descriptionLayout = new StaticLayout(TextUtils.ellipsize(charSequenceReplace, Theme.chat_contextResult_descriptionTextPaint, size, TextUtils.TruncateAt.END), Theme.chat_contextResult_descriptionTextPaint, size + AndroidUtilities.dp(4.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(56.0f));
        int size2 = LocaleController.isRTL ? (View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(8.0f)) - AndroidUtilities.dp(52.0f) : AndroidUtilities.dp(8.0f);
        RadialProgress2 radialProgress2 = this.radialProgress;
        int iDp = AndroidUtilities.dp(4.0f) + size2;
        this.buttonX = iDp;
        int iDp2 = AndroidUtilities.dp(6.0f);
        this.buttonY = iDp2;
        radialProgress2.setProgressRect(iDp, iDp2, size2 + AndroidUtilities.dp(48.0f), AndroidUtilities.dp(50.0f));
    }

    public void setMessageObject(MessageObject messageObject) {
        this.currentMessageObject = messageObject;
        TLRPC$Document document = messageObject.getDocument();
        TLRPC$PhotoSize closestPhotoSizeWithSize = document != null ? FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90) : null;
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
        requestLayout();
        updateButtonState(false, false);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.radialProgress.onDetachedFromWindow();
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.radialProgress.onAttachedToWindow();
    }

    public MessageObject getMessageObject() {
        return this.currentMessageObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkAudioMotionEvent(android.view.MotionEvent r9) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r8 = this;
            float r0 = r9.getX()
            int r0 = (int) r0
            float r1 = r9.getY()
            int r1 = (int) r1
            r2 = 1108344832(0x42100000, float:36.0)
            int r2 = ir.eitaa.messenger.AndroidUtilities.dp(r2)
            int r3 = r8.miniButtonState
            r4 = 1
            r5 = 0
            if (r3 < 0) goto L32
            r3 = 1104674816(0x41d80000, float:27.0)
            int r3 = ir.eitaa.messenger.AndroidUtilities.dp(r3)
            int r6 = r8.buttonX
            int r7 = r6 + r3
            if (r0 < r7) goto L32
            int r6 = r6 + r3
            int r6 = r6 + r2
            if (r0 > r6) goto L32
            int r0 = r8.buttonY
            int r6 = r0 + r3
            if (r1 < r6) goto L32
            int r0 = r0 + r3
            int r0 = r0 + r2
            if (r1 > r0) goto L32
            r0 = 1
            goto L33
        L32:
            r0 = 0
        L33:
            int r1 = r9.getAction()
            if (r1 != 0) goto L46
            if (r0 == 0) goto L7e
            r8.miniButtonPressed = r4
            ir.eitaa.ui.Components.RadialProgress2 r9 = r8.radialProgress
            r9.setPressed(r4, r4)
            r8.invalidate()
            goto L7f
        L46:
            boolean r1 = r8.miniButtonPressed
            if (r1 == 0) goto L7e
            int r1 = r9.getAction()
            if (r1 != r4) goto L5c
            r8.miniButtonPressed = r5
            r8.playSoundEffect(r5)
            r8.didPressedMiniButton(r4)
            r8.invalidate()
            goto L77
        L5c:
            int r1 = r9.getAction()
            r2 = 3
            if (r1 != r2) goto L69
            r8.miniButtonPressed = r5
            r8.invalidate()
            goto L77
        L69:
            int r9 = r9.getAction()
            r1 = 2
            if (r9 != r1) goto L77
            if (r0 != 0) goto L77
            r8.miniButtonPressed = r5
            r8.invalidate()
        L77:
            ir.eitaa.ui.Components.RadialProgress2 r9 = r8.radialProgress
            boolean r0 = r8.miniButtonPressed
            r9.setPressed(r0, r4)
        L7e:
            r4 = 0
        L7f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.AudioPlayerCell.checkAudioMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) throws InterruptedException, IOException {
        if (this.currentMessageObject == null) {
            return super.onTouchEvent(event);
        }
        boolean zCheckAudioMotionEvent = checkAudioMotionEvent(event);
        if (event.getAction() != 3) {
            return zCheckAudioMotionEvent;
        }
        this.miniButtonPressed = false;
        this.buttonPressed = false;
        return false;
    }

    private void didPressedMiniButton(boolean animated) throws InterruptedException, IOException {
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
            if (MediaController.getInstance().findMessageInPlaylistAndPlay(this.currentMessageObject)) {
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
            if (MediaController.getInstance().lambda$startAudioAgain$7$MediaController(this.currentMessageObject)) {
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
        if (this.titleLayout != null) {
            canvas.save();
            canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline), this.titleY);
            this.titleLayout.draw(canvas);
            canvas.restore();
        }
        if (this.descriptionLayout != null) {
            Theme.chat_contextResult_descriptionTextPaint.setColor(getThemedColor("windowBackgroundWhiteGrayText2"));
            canvas.save();
            canvas.translate(AndroidUtilities.dp(LocaleController.isRTL ? 8.0f : AndroidUtilities.leftBaseline), this.descriptionY);
            this.descriptionLayout.draw(canvas);
            canvas.restore();
        }
        this.radialProgress.setProgressColor(getThemedColor(this.buttonPressed ? "chat_inAudioSelectedProgress" : "chat_inAudioProgress"));
        this.radialProgress.draw(canvas);
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

    public void updateButtonState(boolean ifSame, boolean animated) {
        String fileName = this.currentMessageObject.getFileName();
        File pathToAttach = null;
        if (!TextUtils.isEmpty(this.currentMessageObject.messageOwner.attachPath)) {
            File file = new File(this.currentMessageObject.messageOwner.attachPath);
            if (file.exists()) {
                pathToAttach = file;
            }
        }
        if (pathToAttach == null) {
            pathToAttach = FileLoader.getPathToAttach(this.currentMessageObject.getDocument());
        }
        if (TextUtils.isEmpty(fileName)) {
            return;
        }
        if (pathToAttach.exists() && pathToAttach.length() == 0) {
            pathToAttach.delete();
        }
        boolean zExists = pathToAttach.exists();
        if (SharedConfig.streamMedia && ((int) this.currentMessageObject.getDialogId()) != 0) {
            this.hasMiniProgress = zExists ? 1 : 2;
            zExists = true;
        } else {
            this.miniButtonState = -1;
        }
        if (this.hasMiniProgress == 0) {
            if (zExists) {
                DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
                boolean zIsPlayingMessage = MediaController.getInstance().isPlayingMessage(this.currentMessageObject);
                if (!zIsPlayingMessage || (zIsPlayingMessage && MediaController.getInstance().isMessagePaused())) {
                    this.buttonState = 0;
                } else {
                    this.buttonState = 1;
                }
                this.radialProgress.setProgress(1.0f, animated);
                this.radialProgress.setIcon(getIconForCurrentState(), ifSame, animated);
                invalidate();
                return;
            }
            DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(fileName, this);
            if (!FileLoader.getInstance(this.currentAccount).isLoadingFile(fileName)) {
                this.buttonState = 2;
                this.radialProgress.setIcon(getIconForCurrentState(), ifSame, animated);
            } else {
                this.buttonState = 4;
                Float fileProgress = ImageLoader.getInstance().getFileProgress(fileName);
                if (fileProgress != null) {
                    this.radialProgress.setProgress(fileProgress.floatValue(), animated);
                } else {
                    this.radialProgress.setProgress(0.0f, animated);
                }
                this.radialProgress.setIcon(getIconForCurrentState(), ifSame, animated);
            }
            invalidate();
            return;
        }
        this.radialProgress.setMiniProgressBackgroundColor(getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outLoader" : "chat_inLoader"));
        boolean zIsPlayingMessage2 = MediaController.getInstance().isPlayingMessage(this.currentMessageObject);
        if (!zIsPlayingMessage2 || (zIsPlayingMessage2 && MediaController.getInstance().isMessagePaused())) {
            this.buttonState = 0;
        } else {
            this.buttonState = 1;
        }
        this.radialProgress.setIcon(getIconForCurrentState(), ifSame, animated);
        if (this.hasMiniProgress == 1) {
            DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
            this.miniButtonState = -1;
            this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), ifSame, animated);
            return;
        }
        DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(fileName, this.currentMessageObject, this);
        if (!FileLoader.getInstance(this.currentAccount).isLoadingFile(fileName)) {
            this.miniButtonState = 0;
            this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), ifSame, animated);
            return;
        }
        this.miniButtonState = 1;
        this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), ifSame, animated);
        Float fileProgress2 = ImageLoader.getInstance().getFileProgress(fileName);
        if (fileProgress2 != null) {
            this.radialProgress.setProgress(fileProgress2.floatValue(), animated);
        } else {
            this.radialProgress.setProgress(0.0f, animated);
        }
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String fileName, boolean canceled) {
        updateButtonState(true, canceled);
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onSuccessDownload(String fileName) {
        this.radialProgress.setProgress(1.0f, true);
        updateButtonState(false, true);
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String fileName, long downloadedSize, long totalSize) {
        this.radialProgress.setProgress(Math.min(1.0f, downloadedSize / totalSize), true);
        if (this.hasMiniProgress != 0) {
            if (this.miniButtonState != 1) {
                updateButtonState(false, true);
            }
        } else if (this.buttonState != 4) {
            updateButtonState(false, true);
        }
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (this.currentMessageObject.isMusic()) {
            info.setText(LocaleController.formatString("AccDescrMusicInfo", R.string.AccDescrMusicInfo, this.currentMessageObject.getMusicAuthor(), this.currentMessageObject.getMusicTitle()));
            return;
        }
        info.setText(((Object) this.titleLayout.getText()) + ", " + ((Object) this.descriptionLayout.getText()));
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
