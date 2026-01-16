package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.PhotoViewer;

/* loaded from: classes3.dex */
public class SharedPhotoVideoCell extends FrameLayout {
    private Paint backgroundPaint;
    private int currentAccount;
    private SharedPhotoVideoCellDelegate delegate;
    private boolean ignoreLayout;
    private int[] indeces;
    private boolean isFirst;
    private int itemsCount;
    private MessageObject[] messageObjects;
    private PhotoVideoView[] photoVideoViews;
    private int type;

    public interface SharedPhotoVideoCellDelegate {
        void didClickItem(SharedPhotoVideoCell cell, int index, MessageObject messageObject, int a);

        boolean didLongClickItem(SharedPhotoVideoCell cell, int index, MessageObject messageObject, int a);
    }

    public SharedPhotoVideoCellDelegate getDelegate() {
        return this.delegate;
    }

    public class PhotoVideoView extends FrameLayout {
        private AnimatorSet animator;
        private CheckBox2 checkBox;
        private FrameLayout container;
        private MessageObject currentMessageObject;
        private BackupImageView imageView;
        private View selector;
        private FrameLayout videoInfoContainer;
        private TextView videoTextView;

        public PhotoVideoView(Context context) {
            super(context);
            setWillNotDraw(false);
            FrameLayout frameLayout = new FrameLayout(context);
            this.container = frameLayout;
            addView(frameLayout, LayoutHelper.createFrame(-1, -1.0f));
            BackupImageView backupImageView = new BackupImageView(context);
            this.imageView = backupImageView;
            backupImageView.getImageReceiver().setNeedsQualityThumb(true);
            this.imageView.getImageReceiver().setShouldGenerateQualityThumb(true);
            this.container.addView(this.imageView, LayoutHelper.createFrame(-1, -1.0f));
            FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.Cells.SharedPhotoVideoCell.PhotoVideoView.1
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
            View view = new View(context);
            this.selector = view;
            view.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            addView(this.selector, LayoutHelper.createFrame(-1, -1.0f));
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setVisibility(4);
            this.checkBox.setColor(null, "sharedMedia_photoPlaceholder", "checkboxCheck");
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(1);
            addView(this.checkBox, LayoutHelper.createFrame(24, 24.0f, 53, 0.0f, 1.0f, 1.0f, 0.0f));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.selector.drawableHotspotChanged(event.getX(), event.getY());
            }
            return super.onTouchEvent(event);
        }

        public void setChecked(final boolean checked, boolean animated) {
            if (this.checkBox.getVisibility() != 0) {
                this.checkBox.setVisibility(0);
            }
            this.checkBox.setChecked(checked, animated);
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
                fArr[0] = checked ? 0.81f : 1.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr);
                FrameLayout frameLayout2 = this.container;
                Property property2 = View.SCALE_Y;
                float[] fArr2 = new float[1];
                fArr2[0] = checked ? 0.81f : 1.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2);
                animatorSet2.playTogether(animatorArr);
                this.animator.setDuration(200L);
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.SharedPhotoVideoCell.PhotoVideoView.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (PhotoVideoView.this.animator == null || !PhotoVideoView.this.animator.equals(animation)) {
                            return;
                        }
                        PhotoVideoView.this.animator = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        if (PhotoVideoView.this.animator == null || !PhotoVideoView.this.animator.equals(animation)) {
                            return;
                        }
                        PhotoVideoView.this.animator = null;
                    }
                });
                this.animator.start();
                return;
            }
            this.container.setScaleX(checked ? 0.85f : 1.0f);
            this.container.setScaleY(checked ? 0.85f : 1.0f);
        }

        public void setMessageObject(MessageObject messageObject) {
            TLRPC$PhotoSize tLRPC$PhotoSize;
            this.currentMessageObject = messageObject;
            this.imageView.getImageReceiver().setVisible(!PhotoViewer.isShowingImage(messageObject), false);
            if (!TextUtils.isEmpty(MessagesController.getRestrictionReason(messageObject.messageOwner.restriction_reason))) {
                this.videoInfoContainer.setVisibility(4);
                this.imageView.setImageResource(R.drawable.photo_placeholder_in);
                return;
            }
            if (messageObject.isVideo()) {
                this.videoInfoContainer.setVisibility(0);
                this.videoTextView.setText(AndroidUtilities.formatShortDuration(messageObject.getDuration()));
                TLRPC$Document document = messageObject.getDocument();
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 50);
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 320);
                tLRPC$PhotoSize = closestPhotoSizeWithSize != closestPhotoSizeWithSize2 ? closestPhotoSizeWithSize2 : null;
                if (closestPhotoSizeWithSize != null) {
                    if (messageObject.strippedThumb != null) {
                        this.imageView.setImage(ImageLocation.getForDocument(tLRPC$PhotoSize, document), "100_100", (String) null, messageObject.strippedThumb, messageObject);
                        return;
                    } else {
                        this.imageView.setImage(ImageLocation.getForDocument(tLRPC$PhotoSize, document), "100_100", ImageLocation.getForDocument(closestPhotoSizeWithSize, document), "b", ApplicationLoader.applicationContext.getResources().getDrawable(R.drawable.photo_placeholder_in), null, null, 0, messageObject);
                        return;
                    }
                }
                this.imageView.setImageResource(R.drawable.photo_placeholder_in);
                return;
            }
            TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
            if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null && !messageObject.photoThumbs.isEmpty()) {
                this.videoInfoContainer.setVisibility(4);
                TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 50);
                TLRPC$PhotoSize closestPhotoSizeWithSize4 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 320, false, closestPhotoSizeWithSize3, false);
                if (messageObject.mediaExists || DownloadController.getInstance(SharedPhotoVideoCell.this.currentAccount).canDownloadMedia(messageObject)) {
                    tLRPC$PhotoSize = closestPhotoSizeWithSize4 != closestPhotoSizeWithSize3 ? closestPhotoSizeWithSize3 : null;
                    if (messageObject.strippedThumb != null) {
                        this.imageView.getImageReceiver().setImage(ImageLocation.getForObject(closestPhotoSizeWithSize4, messageObject.photoThumbsObject), "100_100", null, null, messageObject.strippedThumb, closestPhotoSizeWithSize4 != null ? closestPhotoSizeWithSize4.size : 0, null, messageObject, messageObject.shouldEncryptPhotoOrVideo() ? 2 : 1);
                        return;
                    } else {
                        this.imageView.getImageReceiver().setImage(ImageLocation.getForObject(closestPhotoSizeWithSize4, messageObject.photoThumbsObject), "100_100", ImageLocation.getForObject(tLRPC$PhotoSize, messageObject.photoThumbsObject), "b", closestPhotoSizeWithSize4 != null ? closestPhotoSizeWithSize4.size : 0, null, messageObject, messageObject.shouldEncryptPhotoOrVideo() ? 2 : 1);
                        return;
                    }
                }
                BitmapDrawable bitmapDrawable = messageObject.strippedThumb;
                if (bitmapDrawable != null) {
                    this.imageView.setImage(null, null, null, null, bitmapDrawable, null, null, 0, messageObject);
                    return;
                } else {
                    this.imageView.setImage(null, null, ImageLocation.getForObject(closestPhotoSizeWithSize3, messageObject.photoThumbsObject), "b", ApplicationLoader.applicationContext.getResources().getDrawable(R.drawable.photo_placeholder_in), null, null, 0, messageObject);
                    return;
                }
            }
            this.videoInfoContainer.setVisibility(4);
            this.imageView.setImageResource(R.drawable.photo_placeholder_in);
        }

        @Override // android.view.View
        public void clearAnimation() {
            super.clearAnimation();
            AnimatorSet animatorSet = this.animator;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.animator = null;
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.checkBox.isChecked() || !this.imageView.getImageReceiver().hasBitmapImage() || this.imageView.getImageReceiver().getCurrentAlpha() != 1.0f || PhotoViewer.isShowingImage(this.currentMessageObject)) {
                canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), SharedPhotoVideoCell.this.backgroundPaint);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            if (this.currentMessageObject.isVideo()) {
                info.setText(LocaleController.getString("AttachVideo", R.string.AttachVideo) + ", " + LocaleController.formatDuration(this.currentMessageObject.getDuration()));
            } else {
                info.setText(LocaleController.getString("AttachPhoto", R.string.AttachPhoto));
            }
            if (this.checkBox.isChecked()) {
                info.setCheckable(true);
                info.setChecked(true);
            }
        }
    }

    public SharedPhotoVideoCell(Context context) {
        this(context, 0);
    }

    public SharedPhotoVideoCell(Context context, int type) {
        super(context);
        Paint paint = new Paint();
        this.backgroundPaint = paint;
        this.currentAccount = UserConfig.selectedAccount;
        this.type = type;
        paint.setColor(Theme.getColor("sharedMedia_photoPlaceholder"));
        this.messageObjects = new MessageObject[6];
        this.photoVideoViews = new PhotoVideoView[6];
        this.indeces = new int[6];
        for (int i = 0; i < 6; i++) {
            this.photoVideoViews[i] = new PhotoVideoView(context);
            addView(this.photoVideoViews[i]);
            this.photoVideoViews[i].setVisibility(4);
            this.photoVideoViews[i].setTag(Integer.valueOf(i));
            this.photoVideoViews[i].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$SharedPhotoVideoCell$BgSpplfsQEVu56xMslw0XoLp-T0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$SharedPhotoVideoCell(view);
                }
            });
            this.photoVideoViews[i].setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$SharedPhotoVideoCell$J6bOaC33We6ekxYmbEOZlL9F4gc
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$new$1$SharedPhotoVideoCell(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$SharedPhotoVideoCell(View view) {
        if (this.delegate != null) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            this.delegate.didClickItem(this, this.indeces[iIntValue], this.messageObjects[iIntValue], iIntValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$1$SharedPhotoVideoCell(View view) {
        if (this.delegate == null) {
            return false;
        }
        int iIntValue = ((Integer) view.getTag()).intValue();
        return this.delegate.didLongClickItem(this, this.indeces[iIntValue], this.messageObjects[iIntValue], iIntValue);
    }

    public void updateCheckboxColor() {
        for (int i = 0; i < 6; i++) {
            this.photoVideoViews[i].checkBox.invalidate();
        }
    }

    @Override // android.view.View
    public void invalidate() {
        for (int i = 0; i < 6; i++) {
            this.photoVideoViews[i].invalidate();
        }
        super.invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setDelegate(SharedPhotoVideoCellDelegate delegate) {
        this.delegate = delegate;
    }

    public void setItemsCount(int count) {
        int i = 0;
        while (true) {
            PhotoVideoView[] photoVideoViewArr = this.photoVideoViews;
            if (i < photoVideoViewArr.length) {
                photoVideoViewArr[i].clearAnimation();
                this.photoVideoViews[i].setVisibility(i < count ? 0 : 4);
                i++;
            } else {
                this.itemsCount = count;
                return;
            }
        }
    }

    public BackupImageView getImageView(int a) {
        if (a >= this.itemsCount) {
            return null;
        }
        return this.photoVideoViews[a].imageView;
    }

    public MessageObject getMessageObject(int a) {
        if (a >= this.itemsCount) {
            return null;
        }
        return this.messageObjects[a];
    }

    public void setIsFirst(boolean first) {
        this.isFirst = first;
    }

    public void setChecked(int a, boolean checked, boolean animated) {
        this.photoVideoViews[a].setChecked(checked, animated);
    }

    public void setItem(int a, int index, MessageObject messageObject) {
        this.messageObjects[a] = messageObject;
        this.indeces[a] = index;
        if (messageObject != null) {
            this.photoVideoViews[a].setVisibility(0);
            this.photoVideoViews[a].setMessageObject(messageObject);
        } else {
            this.photoVideoViews[a].clearAnimation();
            this.photoVideoViews[a].setVisibility(4);
            this.messageObjects[a] = null;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int itemSize;
        if (this.type == 1) {
            itemSize = (View.MeasureSpec.getSize(widthMeasureSpec) - ((this.itemsCount - 1) * AndroidUtilities.dp(2.0f))) / this.itemsCount;
        } else {
            itemSize = getItemSize(this.itemsCount);
        }
        this.ignoreLayout = true;
        for (int i = 0; i < this.itemsCount; i++) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.photoVideoViews[i].getLayoutParams();
            layoutParams.topMargin = this.isFirst ? 0 : AndroidUtilities.dp(2.0f);
            layoutParams.leftMargin = (AndroidUtilities.dp(2.0f) + itemSize) * i;
            if (i == this.itemsCount - 1) {
                if (AndroidUtilities.isTablet()) {
                    layoutParams.width = AndroidUtilities.dp(490.0f) - ((this.itemsCount - 1) * (AndroidUtilities.dp(2.0f) + itemSize));
                } else {
                    layoutParams.width = AndroidUtilities.displaySize.x - ((this.itemsCount - 1) * (AndroidUtilities.dp(2.0f) + itemSize));
                }
            } else {
                layoutParams.width = itemSize;
            }
            layoutParams.height = itemSize;
            layoutParams.gravity = 51;
            this.photoVideoViews[i].setLayoutParams(layoutParams);
        }
        this.ignoreLayout = false;
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((this.isFirst ? 0 : AndroidUtilities.dp(2.0f)) + itemSize, 1073741824));
    }

    public static int getItemSize(int itemsCount) {
        if (AndroidUtilities.isTablet()) {
            return (AndroidUtilities.dp(490.0f) - ((itemsCount - 1) * AndroidUtilities.dp(2.0f))) / itemsCount;
        }
        return (AndroidUtilities.displaySize.x - ((itemsCount - 1) * AndroidUtilities.dp(2.0f))) / itemsCount;
    }
}
