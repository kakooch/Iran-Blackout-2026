package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.PhotoViewer;

/* loaded from: classes3.dex */
public class PhotoAttachPhotoCell extends FrameLayout {
    private static Rect rect = new Rect();
    private AnimatorSet animator;
    private AnimatorSet animatorSet;
    private Paint backgroundPaint;
    private CheckBox2 checkBox;
    private FrameLayout checkFrame;
    private FrameLayout container;
    private PhotoAttachPhotoCellDelegate delegate;
    private BackupImageView imageView;
    private boolean isLast;
    private boolean isVertical;
    private int itemSize;
    private boolean itemSizeChanged;
    private MediaController.PhotoEntry photoEntry;
    private boolean pressed;
    private final Theme.ResourcesProvider resourcesProvider;
    private MediaController.SearchImage searchEntry;
    private FrameLayout videoInfoContainer;
    private TextView videoTextView;
    private boolean zoomOnSelect;

    public interface PhotoAttachPhotoCellDelegate {
        void onCheckClick(PhotoAttachPhotoCell v);
    }

    public PhotoAttachPhotoCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.zoomOnSelect = true;
        this.backgroundPaint = new Paint();
        this.resourcesProvider = resourcesProvider;
        setWillNotDraw(false);
        FrameLayout frameLayout = new FrameLayout(context);
        this.container = frameLayout;
        addView(frameLayout, LayoutHelper.createFrame(80, 80.0f));
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        this.container.addView(backupImageView, LayoutHelper.createFrame(-1, -1.0f));
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.Cells.PhotoAttachPhotoCell.1
            private RectF rect = new RectF();

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                this.rect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), Theme.chat_timeBackgroundPaint);
            }
        };
        this.videoInfoContainer = frameLayout2;
        frameLayout2.setWillNotDraw(false);
        this.videoInfoContainer.setPadding(AndroidUtilities.dp(5.0f), 0, AndroidUtilities.dp(5.0f), 0);
        this.container.addView(this.videoInfoContainer, LayoutHelper.createFrame(-2, 17.0f, 83, 4.0f, 0.0f, 0.0f, 4.0f));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.play_mini_video);
        this.videoInfoContainer.addView(imageView, LayoutHelper.createFrame(-2, -2, 19));
        TextView textView = new TextView(context);
        this.videoTextView = textView;
        textView.setTextColor(-1);
        this.videoTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.videoTextView.setTextSize(1, 12.0f);
        this.videoTextView.setImportantForAccessibility(2);
        this.videoInfoContainer.addView(this.videoTextView, LayoutHelper.createFrame(-2, -2.0f, 19, 13.0f, -0.7f, 0.0f, 0.0f));
        CheckBox2 checkBox2 = new CheckBox2(context, 24, resourcesProvider);
        this.checkBox = checkBox2;
        checkBox2.setDrawBackgroundAsArc(7);
        this.checkBox.setColor("chat_attachCheckBoxBackground", "chat_attachPhotoBackground", "chat_attachCheckBoxCheck");
        addView(this.checkBox, LayoutHelper.createFrame(26, 26.0f, 51, 52.0f, 4.0f, 0.0f, 0.0f));
        this.checkBox.setVisibility(0);
        setFocusable(true);
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.checkFrame = frameLayout3;
        addView(frameLayout3, LayoutHelper.createFrame(42, 42.0f, 51, 38.0f, 0.0f, 0.0f, 0.0f));
        this.itemSize = AndroidUtilities.dp(80.0f);
    }

    public void setIsVertical(boolean value) {
        this.isVertical = value;
    }

    public void setItemSize(int size) {
        this.itemSize = size;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.container.getLayoutParams();
        int i = this.itemSize;
        layoutParams.height = i;
        layoutParams.width = i;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.checkFrame.getLayoutParams();
        layoutParams2.gravity = 53;
        layoutParams2.leftMargin = 0;
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.checkBox.getLayoutParams();
        layoutParams3.gravity = 53;
        layoutParams3.leftMargin = 0;
        int iDp = AndroidUtilities.dp(5.0f);
        layoutParams3.topMargin = iDp;
        layoutParams3.rightMargin = iDp;
        this.checkBox.setDrawBackgroundAsArc(6);
        this.itemSizeChanged = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.itemSizeChanged) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.itemSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.itemSize + AndroidUtilities.dp(5.0f), 1073741824));
            return;
        }
        if (this.isVertical) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp((this.isLast ? 0 : 6) + 80), 1073741824));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp((this.isLast ? 0 : 6) + 80), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824));
        }
    }

    public MediaController.PhotoEntry getPhotoEntry() {
        return this.photoEntry;
    }

    public BackupImageView getImageView() {
        return this.imageView;
    }

    public float getScale() {
        return this.container.getScaleX();
    }

    public CheckBox2 getCheckBox() {
        return this.checkBox;
    }

    public FrameLayout getCheckFrame() {
        return this.checkFrame;
    }

    public View getVideoInfoContainer() {
        return this.videoInfoContainer;
    }

    public void setPhotoEntry(MediaController.PhotoEntry entry, boolean needCheckShow, boolean last) {
        boolean z = false;
        this.pressed = false;
        this.photoEntry = entry;
        this.isLast = last;
        if (entry.isVideo) {
            this.imageView.setOrientation(0, true);
            this.videoInfoContainer.setVisibility(0);
            this.videoTextView.setText(AndroidUtilities.formatShortDuration(this.photoEntry.duration));
        } else {
            this.videoInfoContainer.setVisibility(4);
        }
        MediaController.PhotoEntry photoEntry = this.photoEntry;
        String str = photoEntry.thumbPath;
        if (str != null) {
            this.imageView.setImage(str, null, Theme.chat_attachEmptyDrawable);
        } else if (photoEntry.path != null) {
            if (photoEntry.isVideo) {
                this.imageView.setImage("vthumb://" + this.photoEntry.imageId + ":" + this.photoEntry.path, null, Theme.chat_attachEmptyDrawable);
            } else {
                this.imageView.setOrientation(photoEntry.orientation, true);
                this.imageView.setImage("thumb://" + this.photoEntry.imageId + ":" + this.photoEntry.path, null, Theme.chat_attachEmptyDrawable);
            }
        } else {
            this.imageView.setImageDrawable(Theme.chat_attachEmptyDrawable);
        }
        if (needCheckShow && PhotoViewer.isShowingImage(this.photoEntry.path)) {
            z = true;
        }
        this.imageView.getImageReceiver().setVisible(!z, true);
        this.checkBox.setAlpha(z ? 0.0f : 1.0f);
        this.videoInfoContainer.setAlpha(z ? 0.0f : 1.0f);
        requestLayout();
    }

    public void setPhotoEntry(MediaController.SearchImage searchImage, boolean needCheckShow, boolean last) {
        boolean z = false;
        this.pressed = false;
        this.searchEntry = searchImage;
        this.isLast = last;
        Drawable drawable = this.zoomOnSelect ? Theme.chat_attachEmptyDrawable : getResources().getDrawable(R.drawable.nophotos);
        TLRPC$PhotoSize tLRPC$PhotoSize = searchImage.thumbPhotoSize;
        if (tLRPC$PhotoSize != null) {
            this.imageView.setImage(ImageLocation.getForPhoto(tLRPC$PhotoSize, searchImage.photo), (String) null, drawable, searchImage);
        } else {
            TLRPC$PhotoSize tLRPC$PhotoSize2 = searchImage.photoSize;
            if (tLRPC$PhotoSize2 != null) {
                this.imageView.setImage(ImageLocation.getForPhoto(tLRPC$PhotoSize2, searchImage.photo), "80_80", drawable, searchImage);
            } else {
                String str = searchImage.thumbPath;
                if (str != null) {
                    this.imageView.setImage(str, null, drawable);
                } else if (!TextUtils.isEmpty(searchImage.thumbUrl)) {
                    ImageLocation forPath = ImageLocation.getForPath(searchImage.thumbUrl);
                    if (searchImage.type == 1 && searchImage.thumbUrl.endsWith("mp4")) {
                        forPath.imageType = 2;
                    }
                    this.imageView.setImage(forPath, (String) null, drawable, searchImage);
                } else {
                    TLRPC$Document tLRPC$Document = searchImage.document;
                    if (tLRPC$Document != null) {
                        MessageObject.getDocumentVideoThumb(tLRPC$Document);
                        TLRPC$VideoSize documentVideoThumb = MessageObject.getDocumentVideoThumb(searchImage.document);
                        if (documentVideoThumb != null) {
                            this.imageView.setImage(ImageLocation.getForDocument(documentVideoThumb, searchImage.document), null, ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(searchImage.document.thumbs, 90), searchImage.document), "52_52", null, -1, 1, searchImage);
                        } else {
                            this.imageView.setImage(ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(searchImage.document.thumbs, 320), searchImage.document), (String) null, drawable, searchImage);
                        }
                    } else {
                        this.imageView.setImageDrawable(drawable);
                    }
                }
            }
        }
        if (needCheckShow && PhotoViewer.isShowingImage(searchImage.getPathToAttach())) {
            z = true;
        }
        this.imageView.getImageReceiver().setVisible(!z, true);
        this.checkBox.setAlpha(z ? 0.0f : 1.0f);
        this.videoInfoContainer.setAlpha(z ? 0.0f : 1.0f);
        requestLayout();
    }

    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    public void setChecked(int num, final boolean checked, boolean animated) {
        this.checkBox.setChecked(num, checked, animated);
        if (this.itemSizeChanged) {
            AnimatorSet animatorSet = this.animator;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.animator = null;
            }
            if (animated) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animator = animatorSet2;
                Animator[] animatorArr = new Animator[2];
                FrameLayout frameLayout = this.container;
                Property property = View.SCALE_X;
                float[] fArr = new float[1];
                fArr[0] = checked ? 0.787f : 1.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr);
                FrameLayout frameLayout2 = this.container;
                Property property2 = View.SCALE_Y;
                float[] fArr2 = new float[1];
                fArr2[0] = checked ? 0.787f : 1.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2);
                animatorSet2.playTogether(animatorArr);
                this.animator.setDuration(200L);
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.PhotoAttachPhotoCell.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (PhotoAttachPhotoCell.this.animator == null || !PhotoAttachPhotoCell.this.animator.equals(animation)) {
                            return;
                        }
                        PhotoAttachPhotoCell.this.animator = null;
                        if (checked) {
                            return;
                        }
                        PhotoAttachPhotoCell.this.setBackgroundColor(0);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        if (PhotoAttachPhotoCell.this.animator == null || !PhotoAttachPhotoCell.this.animator.equals(animation)) {
                            return;
                        }
                        PhotoAttachPhotoCell.this.animator = null;
                    }
                });
                this.animator.start();
                return;
            }
            this.container.setScaleX(checked ? 0.787f : 1.0f);
            this.container.setScaleY(checked ? 0.787f : 1.0f);
        }
    }

    public void setNum(int num) {
        this.checkBox.setNum(num);
    }

    public void setOnCheckClickLisnener(View.OnClickListener onCheckClickLisnener) {
        this.checkFrame.setOnClickListener(onCheckClickLisnener);
    }

    public void setDelegate(PhotoAttachPhotoCellDelegate delegate) {
        this.delegate = delegate;
    }

    public void callDelegate() {
        this.delegate.onCheckClick(this);
    }

    public void showImage() {
        this.imageView.getImageReceiver().setVisible(true, true);
    }

    public void showCheck(boolean show) {
        if (show && this.checkBox.getAlpha() == 1.0f) {
            return;
        }
        if (show || this.checkBox.getAlpha() != 0.0f) {
            AnimatorSet animatorSet = this.animatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.animatorSet = null;
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            animatorSet2.setInterpolator(new DecelerateInterpolator());
            this.animatorSet.setDuration(180L);
            AnimatorSet animatorSet3 = this.animatorSet;
            Animator[] animatorArr = new Animator[2];
            FrameLayout frameLayout = this.videoInfoContainer;
            Property property = View.ALPHA;
            float[] fArr = new float[1];
            fArr[0] = show ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr);
            CheckBox2 checkBox2 = this.checkBox;
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = show ? 1.0f : 0.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(checkBox2, (Property<CheckBox2, Float>) property2, fArr2);
            animatorSet3.playTogether(animatorArr);
            this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.PhotoAttachPhotoCell.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (animation.equals(PhotoAttachPhotoCell.this.animatorSet)) {
                        PhotoAttachPhotoCell.this.animatorSet = null;
                    }
                }
            });
            this.animatorSet.start();
        }
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        AnimatorSet animatorSet = this.animator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animator = null;
            this.container.setScaleX(this.checkBox.isChecked() ? 0.787f : 1.0f);
            this.container.setScaleY(this.checkBox.isChecked() ? 0.787f : 1.0f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.widget.FrameLayout r0 = r5.checkFrame
            android.graphics.Rect r1 = ir.eitaa.ui.Cells.PhotoAttachPhotoCell.rect
            r0.getHitRect(r1)
            int r0 = r6.getAction()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L27
            android.graphics.Rect r0 = ir.eitaa.ui.Cells.PhotoAttachPhotoCell.rect
            float r3 = r6.getX()
            int r3 = (int) r3
            float r4 = r6.getY()
            int r4 = (int) r4
            boolean r0 = r0.contains(r3, r4)
            if (r0 == 0) goto L74
            r5.pressed = r1
            r5.invalidate()
            goto L75
        L27:
            boolean r0 = r5.pressed
            if (r0 == 0) goto L74
            int r0 = r6.getAction()
            if (r0 != r1) goto L49
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
            r5.pressed = r2
            r5.playSoundEffect(r2)
            r5.sendAccessibilityEvent(r1)
            ir.eitaa.ui.Cells.PhotoAttachPhotoCell$PhotoAttachPhotoCellDelegate r0 = r5.delegate
            r0.onCheckClick(r5)
            r5.invalidate()
            goto L74
        L49:
            int r0 = r6.getAction()
            r1 = 3
            if (r0 != r1) goto L56
            r5.pressed = r2
            r5.invalidate()
            goto L74
        L56:
            int r0 = r6.getAction()
            r1 = 2
            if (r0 != r1) goto L74
            android.graphics.Rect r0 = ir.eitaa.ui.Cells.PhotoAttachPhotoCell.rect
            float r1 = r6.getX()
            int r1 = (int) r1
            float r3 = r6.getY()
            int r3 = (int) r3
            boolean r0 = r0.contains(r1, r3)
            if (r0 != 0) goto L74
            r5.pressed = r2
            r5.invalidate()
        L74:
            r1 = 0
        L75:
            if (r1 != 0) goto L7b
            boolean r1 = super.onTouchEvent(r6)
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.PhotoAttachPhotoCell.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        MediaController.PhotoEntry photoEntry;
        MediaController.SearchImage searchImage;
        if (!this.checkBox.isChecked() && this.container.getScaleX() == 1.0f && this.imageView.getImageReceiver().hasNotThumb() && this.imageView.getImageReceiver().getCurrentAlpha() == 1.0f && (((photoEntry = this.photoEntry) == null || !PhotoViewer.isShowingImage(photoEntry.path)) && ((searchImage = this.searchEntry) == null || !PhotoViewer.isShowingImage(searchImage.getPathToAttach())))) {
            return;
        }
        this.backgroundPaint.setColor(getThemedColor("chat_attachPhotoBackground"));
        canvas.drawRect(0.0f, 0.0f, this.imageView.getMeasuredWidth(), this.imageView.getMeasuredHeight(), this.backgroundPaint);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setEnabled(true);
        MediaController.PhotoEntry photoEntry = this.photoEntry;
        if (photoEntry != null && photoEntry.isVideo) {
            info.setText(LocaleController.getString("AttachVideo", R.string.AttachVideo) + ", " + LocaleController.formatDuration(this.photoEntry.duration));
        } else {
            info.setText(LocaleController.getString("AttachPhoto", R.string.AttachPhoto));
        }
        if (this.checkBox.isChecked()) {
            info.setSelected(true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            info.addAction(new AccessibilityNodeInfo.AccessibilityAction(R.id.acc_action_open_photo, LocaleController.getString("Open", R.string.Open)));
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        if (action == R.id.acc_action_open_photo) {
            View view = (View) getParent();
            view.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, getLeft(), (getTop() + getHeight()) - 1, 0));
            view.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, getLeft(), (getTop() + getHeight()) - 1, 0));
        }
        return super.performAccessibilityAction(action, arguments);
    }

    protected int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
