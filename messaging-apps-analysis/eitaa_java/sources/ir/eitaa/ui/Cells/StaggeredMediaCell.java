package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CheckBox;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.PhotoViewer;
import java.util.Locale;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class StaggeredMediaCell extends FrameLayout {
    private static final int spacing = AndroidUtilities.dp(1.0f);
    private StaggeredMediaCellDelegate delegate;
    private int importantCellIndex;
    private int[] indeces;
    public boolean isFirst;
    private int itemsCount;
    private boolean loading;
    private MessageObject[] messageObjects;
    private PhotoVideoView[] photoVideoViews;

    public interface StaggeredMediaCellDelegate {
        void didClickItem(StaggeredMediaCell cell, int index, MessageObject messageObject, int a);

        boolean didLongClickItem(StaggeredMediaCell cell, int index, MessageObject messageObject, int a);

        boolean onLongClickRelease(StaggeredMediaCell cell, int index, MessageObject messageObject, int a);
    }

    private class PhotoVideoView extends FrameLayout {
        private ImageView albumIcon;
        private AnimatorSet animator;
        private CheckBox checkBox;
        private FrameLayout container;
        private ImageView gifIcon;
        private BackupImageView imageView;
        private View selector;
        private FrameLayout videoInfoContainer;
        private TextView videoTextView;

        public PhotoVideoView(Context context) {
            super(context);
            FrameLayout frameLayout = new FrameLayout(context);
            this.container = frameLayout;
            addView(frameLayout, LayoutHelper.createFrame(-1, -1.0f));
            BackupImageView backupImageView = new BackupImageView(context);
            this.imageView = backupImageView;
            backupImageView.getImageReceiver().setNeedsQualityThumb(true);
            this.imageView.getImageReceiver().setShouldGenerateQualityThumb(true);
            this.container.addView(this.imageView, LayoutHelper.createFrame(-1, -1.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.videoInfoContainer = frameLayout2;
            frameLayout2.setPadding(AndroidUtilities.dp(3.0f), 0, AndroidUtilities.dp(3.0f), 0);
            this.container.addView(this.videoInfoContainer, LayoutHelper.createFrame(-1, 16, 51));
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.drawable.ic_video);
            this.videoInfoContainer.addView(imageView, LayoutHelper.createFrame(-2, -2, 19));
            ImageView imageView2 = new ImageView(context);
            this.albumIcon = imageView2;
            imageView2.setImageResource(R.drawable.ic_album);
            this.container.addView(this.albumIcon, LayoutHelper.createFrame(-2, -2.0f, 51, 3.0f, 3.0f, 3.0f, 3.0f));
            ImageView imageView3 = new ImageView(context);
            this.gifIcon = imageView3;
            imageView3.setImageResource(R.drawable.ic_gif_text);
            this.gifIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.container.addView(this.gifIcon, LayoutHelper.createFrame(-2, -2.0f, 51, 3.0f, 3.0f, 3.0f, 3.0f));
            TextView textView = new TextView(context);
            this.videoTextView = textView;
            textView.setTextColor(-1);
            this.videoTextView.setTextSize(1, 12.0f);
            this.videoTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.videoTextView.setVisibility(8);
            this.videoInfoContainer.addView(this.videoTextView, LayoutHelper.createFrame(-2, -2.0f, 19, 18.0f, -0.7f, 0.0f, 0.0f));
            View view = new View(context);
            this.selector = view;
            view.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            addView(this.selector, LayoutHelper.createFrame(-1, -1.0f));
            CheckBox checkBox = new CheckBox(context, R.drawable.round_check2);
            this.checkBox = checkBox;
            checkBox.setVisibility(4);
            this.checkBox.setColor(Theme.getColor("checkbox"), Theme.getColor("checkboxCheck"));
            addView(this.checkBox, LayoutHelper.createFrame(22, 22.0f, 53, 0.0f, 2.0f, 2.0f, 0.0f));
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
                if (checked) {
                    setBackgroundColor(-657931);
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.animator = animatorSet2;
                Animator[] animatorArr = new Animator[2];
                FrameLayout frameLayout = this.container;
                float[] fArr = new float[1];
                fArr[0] = checked ? 0.85f : 1.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, "scaleX", fArr);
                FrameLayout frameLayout2 = this.container;
                float[] fArr2 = new float[1];
                fArr2[0] = checked ? 0.85f : 1.0f;
                animatorArr[1] = ObjectAnimator.ofFloat(frameLayout2, "scaleY", fArr2);
                animatorSet2.playTogether(animatorArr);
                this.animator.setDuration(200L);
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.StaggeredMediaCell.PhotoVideoView.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (PhotoVideoView.this.animator == null || !PhotoVideoView.this.animator.equals(animation)) {
                            return;
                        }
                        PhotoVideoView.this.animator = null;
                        if (checked) {
                            return;
                        }
                        PhotoVideoView.this.setBackgroundColor(0);
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
            setBackgroundColor(checked ? -657931 : 0);
            this.container.setScaleX(checked ? 0.85f : 1.0f);
            this.container.setScaleY(checked ? 0.85f : 1.0f);
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
    }

    public StaggeredMediaCell(Context context) {
        super(context);
        this.importantCellIndex = -1;
        this.messageObjects = new MessageObject[6];
        this.photoVideoViews = new PhotoVideoView[6];
        this.indeces = new int[6];
        for (int i = 0; i < 6; i++) {
            this.photoVideoViews[i] = new PhotoVideoView(context);
            addView(this.photoVideoViews[i]);
            this.photoVideoViews[i].setVisibility(4);
            this.photoVideoViews[i].setTag(Integer.valueOf(i));
            this.photoVideoViews[i].setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.Cells.StaggeredMediaCell.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View v) {
                    if (StaggeredMediaCell.this.delegate == null) {
                        return false;
                    }
                    int iIntValue = ((Integer) v.getTag()).intValue();
                    StaggeredMediaCellDelegate staggeredMediaCellDelegate = StaggeredMediaCell.this.delegate;
                    StaggeredMediaCell staggeredMediaCell = StaggeredMediaCell.this;
                    return staggeredMediaCellDelegate.didLongClickItem(staggeredMediaCell, staggeredMediaCell.indeces[iIntValue], StaggeredMediaCell.this.messageObjects[iIntValue], iIntValue);
                }
            });
            this.photoVideoViews[i].setOnTouchListener(new AnonymousClass2(i));
        }
    }

    /* renamed from: ir.eitaa.ui.Cells.StaggeredMediaCell$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnTouchListener {
        final GestureDetector gestureDetector;
        boolean longPressed = false;
        final /* synthetic */ int val$finalIndex;

        AnonymousClass2(final int val$finalIndex) {
            this.val$finalIndex = val$finalIndex;
            this.gestureDetector = new GestureDetector(StaggeredMediaCell.this.getContext(), new GestureDetector.OnGestureListener() { // from class: ir.eitaa.ui.Cells.StaggeredMediaCell.2.1
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent e) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent e) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent e) {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    int i = anonymousClass2.val$finalIndex;
                    MessageObject messageObject = StaggeredMediaCell.this.messageObjects[i];
                    if (messageObject != null) {
                        TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
                        if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null && !messageObject.photoThumbs.isEmpty()) {
                            StaggeredMediaCell.this.photoVideoViews[i].imageView.getImageReceiver().setImage(ImageLocation.getForLocal(FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.photoSize.intValue()).location), null, ApplicationLoader.applicationContext.getResources().getDrawable(R.drawable.photo_placeholder_in), null, messageObject, 0);
                        }
                    }
                    if (StaggeredMediaCell.this.delegate == null) {
                        return true;
                    }
                    StaggeredMediaCellDelegate staggeredMediaCellDelegate = StaggeredMediaCell.this.delegate;
                    StaggeredMediaCell staggeredMediaCell = StaggeredMediaCell.this;
                    staggeredMediaCellDelegate.didClickItem(staggeredMediaCell, staggeredMediaCell.indeces[i], StaggeredMediaCell.this.messageObjects[i], i);
                    return true;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent e) {
                    AnonymousClass2.this.longPressed = true;
                }
            });
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            this.gestureDetector.onTouchEvent(event);
            int action = event.getAction();
            if ((action == 1 || action == 6 || action == 3) && StaggeredMediaCell.this.delegate != null && this.longPressed) {
                this.longPressed = false;
                StaggeredMediaCellDelegate staggeredMediaCellDelegate = StaggeredMediaCell.this.delegate;
                StaggeredMediaCell staggeredMediaCell = StaggeredMediaCell.this;
                int i = staggeredMediaCell.indeces[this.val$finalIndex];
                MessageObject[] messageObjectArr = StaggeredMediaCell.this.messageObjects;
                int i2 = this.val$finalIndex;
                staggeredMediaCellDelegate.onLongClickRelease(staggeredMediaCell, i, messageObjectArr[i2], i2);
            }
            return false;
        }
    }

    public void updateCheckboxColor() {
        for (int i = 0; i < 6; i++) {
            this.photoVideoViews[i].checkBox.setColor(Theme.getColor("checkbox"), Theme.getColor("checkboxCheck"));
        }
    }

    public void setDelegate(StaggeredMediaCellDelegate delegate) {
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

    public void setIsFirst(boolean first) {
        this.isFirst = first;
    }

    public void setChecked(int a, boolean checked, boolean animated) {
        this.photoVideoViews[a].setChecked(checked, animated);
    }

    public void setItem(int a, int index, MessageObject messageObject) {
        setItem(a, index, messageObject, true);
    }

    public void setItem(int a, int index, MessageObject messageObject, boolean sendView) {
        int i;
        this.messageObjects[a] = messageObject;
        this.indeces[a] = index;
        if (sendView && messageObject != null && (messageObject.messageOwner.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0 && !messageObject.viewsReloaded) {
            MessagesController.getInstance(UserConfig.selectedAccount).addToViewsQueue(messageObject);
            messageObject.viewsReloaded = true;
        }
        PhotoVideoView photoVideoView = this.photoVideoViews[a];
        photoVideoView.videoInfoContainer.setVisibility(4);
        photoVideoView.albumIcon.setVisibility(4);
        photoVideoView.gifIcon.setVisibility(4);
        if (messageObject != null) {
            photoVideoView.setVisibility(0);
            photoVideoView.imageView.getImageReceiver().setVisible(!PhotoViewer.isShowingImage(messageObject), false);
            if (messageObject.isVideo()) {
                if (messageObject.getGroupId() == 0) {
                    photoVideoView.videoInfoContainer.setVisibility(0);
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= messageObject.getDocument().attributes.size()) {
                        i = 0;
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = messageObject.getDocument().attributes.get(i2);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                        i = tLRPC$DocumentAttribute.duration;
                        break;
                    }
                    i2++;
                }
                int i3 = i / 60;
                photoVideoView.videoTextView.setText(String.format("%d:%02d", Integer.valueOf(i3), Integer.valueOf(i - (i3 * 60))));
                if (!messageObject.getDocument().thumbs.isEmpty()) {
                    photoVideoView.imageView.setImage(ImageLocation.getForLocal(FileLoader.getClosestPhotoSizeWithSize(messageObject.getDocument().thumbs, a == this.importantCellIndex ? 640 : 320).location), (String) null, (String) null, ApplicationLoader.applicationContext.getResources().getDrawable(R.drawable.photo_placeholder_in), messageObject);
                } else {
                    photoVideoView.imageView.setImageResource(R.drawable.photo_placeholder_in);
                }
            } else {
                TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
                if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null && !messageObject.photoThumbs.isEmpty()) {
                    photoVideoView.imageView.setImage((ImageLocation) null, (String) null, ImageLocation.getForObject(FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 320), messageObject.photoThumbsObject), String.format(Locale.US, "%d_%d", Integer.valueOf((int) (r1.w / AndroidUtilities.density)), Integer.valueOf((int) (r1.h / AndroidUtilities.density))) + "_b", 0, messageObject);
                } else if (messageObject.isGif()) {
                    photoVideoView.gifIcon.setVisibility(0);
                    photoVideoView.imageView.getImageReceiver().setAllowStartAnimation(messageObject.gifState != 1.0f);
                    TLRPC$Document document = messageObject.getDocument();
                    photoVideoView.imageView.getImageReceiver().setImage(ImageLocation.getForDocument(document), null, ImageLocation.getForLocal(FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90).location), "b", document.size, null, messageObject, 0);
                } else {
                    photoVideoView.imageView.setImageResource(R.drawable.photo_placeholder_in);
                }
            }
            if (messageObject.isNotAloneInGroup) {
                photoVideoView.albumIcon.setVisibility(0);
                return;
            }
            return;
        }
        if (!this.loading) {
            this.photoVideoViews[a].clearAnimation();
            this.photoVideoViews[a].setVisibility(4);
            this.messageObjects[a] = null;
        } else {
            this.photoVideoViews[a].clearAnimation();
            this.photoVideoViews[a].setVisibility(0);
            this.photoVideoViews[a].imageView.getImageReceiver().setVisible(true, false);
            this.photoVideoViews[a].imageView.setImageResource(R.drawable.photo_placeholder_in);
            this.messageObjects[a] = null;
        }
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public void setImportantCellIndex(int importantCellIndex) {
        this.importantCellIndex = importantCellIndex;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            int r12 = android.view.View.MeasureSpec.getSize(r11)
            int r0 = r10.itemsCount
            int r1 = r0 + (-1)
            int r2 = ir.eitaa.ui.Cells.StaggeredMediaCell.spacing
            int r1 = r1 * r2
            int r12 = r12 - r1
            int r12 = r12 / r0
            int r1 = r10.importantCellIndex
            r2 = 0
            r3 = 1
            if (r1 < 0) goto L18
            if (r1 >= r0) goto L18
            r0 = 1
            goto L19
        L18:
            r0 = 0
        L19:
            r1 = 0
            r4 = 0
            r5 = 0
        L1c:
            int r6 = r10.itemsCount
            if (r1 >= r6) goto L8a
            ir.eitaa.ui.Cells.StaggeredMediaCell$PhotoVideoView[] r6 = r10.photoVideoViews
            r6 = r6[r1]
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r6 = (android.widget.FrameLayout.LayoutParams) r6
            int r7 = ir.eitaa.ui.Cells.StaggeredMediaCell.spacing
            int r8 = r12 + r7
            int r8 = r8 * r4
            r6.leftMargin = r8
            if (r0 == 0) goto L41
            int r8 = r10.importantCellIndex
            if (r1 != r8) goto L3b
            int r4 = r4 + 2
            goto L43
        L3b:
            int r9 = r1 + 1
            if (r9 == r8) goto L41
            if (r5 != r3) goto L43
        L41:
            int r4 = r4 + 1
        L43:
            if (r0 != 0) goto L4f
            boolean r8 = r10.isFirst
            if (r8 == 0) goto L4b
            r8 = 0
            goto L4c
        L4b:
            r8 = r7
        L4c:
            r6.topMargin = r8
            goto L6c
        L4f:
            boolean r8 = r10.isFirst
            if (r8 == 0) goto L55
            r8 = 0
            goto L56
        L55:
            r8 = r7
        L56:
            r6.topMargin = r8
            if (r5 != r3) goto L63
            int r9 = r10.importantCellIndex
            if (r1 == r9) goto L63
            int r9 = r12 + r7
            int r8 = r8 + r9
            r6.topMargin = r8
        L63:
            int r8 = r10.importantCellIndex
            if (r1 == r8) goto L6c
            if (r5 != 0) goto L6b
            r5 = 1
            goto L6c
        L6b:
            r5 = 0
        L6c:
            int r8 = r10.importantCellIndex
            if (r1 != r8) goto L76
            int r8 = r12 * 2
            int r8 = r8 + r7
            r6.width = r8
            goto L78
        L76:
            r6.width = r12
        L78:
            int r7 = r6.width
            r6.height = r7
            r7 = 51
            r6.gravity = r7
            ir.eitaa.ui.Cells.StaggeredMediaCell$PhotoVideoView[] r7 = r10.photoVideoViews
            r7 = r7[r1]
            r7.setLayoutParams(r6)
            int r1 = r1 + 1
            goto L1c
        L8a:
            boolean r1 = r10.isFirst
            if (r1 == 0) goto L8f
            goto L91
        L8f:
            int r2 = ir.eitaa.ui.Cells.StaggeredMediaCell.spacing
        L91:
            if (r0 == 0) goto L98
            int r12 = r12 * 2
            int r0 = ir.eitaa.ui.Cells.StaggeredMediaCell.spacing
            int r12 = r12 + r0
        L98:
            int r2 = r2 + r12
            r12 = 1073741824(0x40000000, float:2.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r12)
            super.onMeasure(r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.StaggeredMediaCell.onMeasure(int, int):void");
    }
}
