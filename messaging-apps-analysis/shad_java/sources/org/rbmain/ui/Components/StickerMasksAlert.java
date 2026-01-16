package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DocumentObject;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_stickers;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.EmptyCell;
import org.rbmain.ui.Cells.StickerEmojiCell;
import org.rbmain.ui.Cells.StickerSetNameCell;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ScrollSlidingTabStrip;
import org.rbmain.ui.ContentPreviewViewer;

/* loaded from: classes5.dex */
public class StickerMasksAlert extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private FrameLayout bottomTabContainer;
    private ContentPreviewViewer.ContentPreviewViewerDelegate contentPreviewViewerDelegate;
    private int currentAccount;
    private int currentType;
    private StickerMasksAlertDelegate delegate;
    private int favTabBum;
    private ArrayList<TLRPC$Document> favouriteStickers;
    private RecyclerListView gridView;
    private String[] lastSearchKeyboardLanguage;
    private ImageView masksButton;
    private ArrayList<TLRPC$Document>[] recentStickers;
    private int recentTabBum;
    private int scrollOffsetY;
    private int searchFieldHeight;
    private Drawable shadowDrawable;
    private View shadowLine;
    private Drawable[] stickerIcons;
    private ArrayList<TLRPC$TL_messages_stickerSet>[] stickerSets;
    private ImageView stickersButton;
    private StickersGridAdapter stickersGridAdapter;
    private GridLayoutManager stickersLayoutManager;
    private RecyclerListView.OnItemClickListener stickersOnItemClickListener;
    private SearchField stickersSearchField;
    private StickersSearchGridAdapter stickersSearchGridAdapter;
    private ScrollSlidingTabStrip stickersTab;
    private int stickersTabOffset;

    public interface StickerMasksAlertDelegate {
        void onStickerSelected(Object obj, TLRPC$Document tLRPC$Document);
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchField extends FrameLayout {
        private ImageView clearSearchImageView;
        private CloseProgressDrawable2 progressDrawable;
        private EditTextBoldCursor searchEditText;
        private AnimatorSet shadowAnimator;
        private View shadowView;

        public SearchField(Context context, int i) {
            super(context);
            View view = new View(context);
            this.shadowView = view;
            view.setAlpha(0.0f);
            this.shadowView.setTag(1);
            this.shadowView.setBackgroundColor(301989888);
            addView(this.shadowView, new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83));
            View view2 = new View(context);
            view2.setBackgroundColor(-14342875);
            addView(view2, new FrameLayout.LayoutParams(-1, StickerMasksAlert.this.searchFieldHeight));
            View view3 = new View(context);
            view3.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), -13224394));
            addView(view3, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 14.0f, 14.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.drawable.smiles_inputsearch);
            imageView.setColorFilter(new PorterDuffColorFilter(-8947849, PorterDuff.Mode.MULTIPLY));
            addView(imageView, LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 14.0f, 0.0f, 0.0f));
            ImageView imageView2 = new ImageView(context);
            this.clearSearchImageView = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            ImageView imageView3 = this.clearSearchImageView;
            CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
            this.progressDrawable = closeProgressDrawable2;
            imageView3.setImageDrawable(closeProgressDrawable2);
            this.progressDrawable.setSide(AndroidUtilities.dp(7.0f));
            this.clearSearchImageView.setScaleX(0.1f);
            this.clearSearchImageView.setScaleY(0.1f);
            this.clearSearchImageView.setAlpha(0.0f);
            this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(-8947849, PorterDuff.Mode.MULTIPLY));
            addView(this.clearSearchImageView, LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 14.0f, 14.0f, 0.0f));
            this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.StickerMasksAlert$SearchField$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    this.f$0.lambda$new$0(view4);
                }
            });
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context, StickerMasksAlert.this) { // from class: org.rbmain.ui.Components.StickerMasksAlert.SearchField.1
                @Override // org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        SearchField.this.searchEditText.requestFocus();
                        AndroidUtilities.showKeyboard(SearchField.this.searchEditText);
                    }
                    return super.onTouchEvent(motionEvent);
                }
            };
            this.searchEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.searchEditText.setHintTextColor(-8947849);
            this.searchEditText.setTextColor(-1);
            this.searchEditText.setBackgroundDrawable(null);
            this.searchEditText.setPadding(0, 0, 0, 0);
            this.searchEditText.setMaxLines(1);
            this.searchEditText.setLines(1);
            this.searchEditText.setSingleLine(true);
            this.searchEditText.setImeOptions(268435459);
            if (i == 0) {
                this.searchEditText.setHint(LocaleController.getString("SearchStickersHint", R.string.SearchStickersHint));
            } else if (i == 1) {
                this.searchEditText.setHint(LocaleController.getString("SearchEmojiHint", R.string.SearchEmojiHint));
            } else if (i == 2) {
                this.searchEditText.setHint(LocaleController.getString("SearchGifsTitle", R.string.SearchGifsTitle));
            }
            this.searchEditText.setCursorColor(-1);
            this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.searchEditText.setCursorWidth(1.5f);
            addView(this.searchEditText, LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 12.0f, 46.0f, 0.0f));
            this.searchEditText.addTextChangedListener(new TextWatcher(StickerMasksAlert.this) { // from class: org.rbmain.ui.Components.StickerMasksAlert.SearchField.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    boolean z = SearchField.this.searchEditText.length() > 0;
                    if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                        SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                    }
                    StickerMasksAlert.this.stickersSearchGridAdapter.search(SearchField.this.searchEditText.getText().toString());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            this.searchEditText.setText(BuildConfig.FLAVOR);
            AndroidUtilities.showKeyboard(this.searchEditText);
        }

        public void hideKeyboard() {
            AndroidUtilities.hideKeyboard(this.searchEditText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showShadow(boolean z, boolean z2) {
            if (z && this.shadowView.getTag() == null) {
                return;
            }
            if (z || this.shadowView.getTag() == null) {
                AnimatorSet animatorSet = this.shadowAnimator;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.shadowAnimator = null;
                }
                this.shadowView.setTag(z ? null : 1);
                if (z2) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    this.shadowAnimator = animatorSet2;
                    Animator[] animatorArr = new Animator[1];
                    View view = this.shadowView;
                    Property property = View.ALPHA;
                    float[] fArr = new float[1];
                    fArr[0] = z ? 1.0f : 0.0f;
                    animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
                    animatorSet2.playTogether(animatorArr);
                    this.shadowAnimator.setDuration(200L);
                    this.shadowAnimator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                    this.shadowAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.StickerMasksAlert.SearchField.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            SearchField.this.shadowAnimator = null;
                        }
                    });
                    this.shadowAnimator.start();
                    return;
                }
                this.shadowView.setAlpha(z ? 1.0f : 0.0f);
            }
        }
    }

    public StickerMasksAlert(Context context, boolean z) {
        super(context, true);
        this.currentAccount = UserConfig.selectedAccount;
        this.stickerSets = new ArrayList[]{new ArrayList<>(), new ArrayList<>()};
        this.recentStickers = new ArrayList[]{new ArrayList<>(), new ArrayList<>()};
        this.favouriteStickers = new ArrayList<>();
        this.recentTabBum = -2;
        this.favTabBum = -2;
        this.contentPreviewViewerDelegate = new ContentPreviewViewer.ContentPreviewViewerDelegate() { // from class: org.rbmain.ui.Components.StickerMasksAlert.1
            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean can() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$can(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean canSchedule() {
                return false;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ Boolean canSetAsStatus(TLRPC$Document tLRPC$Document) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$canSetAsStatus(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void copyEmoji(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$copyEmoji(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public long getDialogId() {
                return 0L;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ String getQuery(boolean z2) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$getQuery(this, z2);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void gifAddedOrDeleted() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$gifAddedOrDeleted(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean isInScheduleMode() {
                return false;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needCopy() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needCopy(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needMenu() {
                return false;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needOpen() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needOpen(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needRemove() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needRemove(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needRemoveFromRecent(TLRPC$Document tLRPC$Document) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needRemoveFromRecent(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needSend(int i) {
                return false;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void openSet(TLRPC$InputStickerSet tLRPC$InputStickerSet, boolean z2) {
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void removeFromRecent(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$removeFromRecent(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void resetTouch() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$resetTouch(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendEmoji(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendEmoji(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendGif(Object obj, Object obj2, boolean z2, int i) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendGif(this, obj, obj2, z2, i);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void setAsEmojiStatus(TLRPC$Document tLRPC$Document, Integer num) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$setAsEmojiStatus(this, tLRPC$Document, num);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendSticker(TLRPC$Document tLRPC$Document, String str, Object obj, boolean z2, int i) {
                StickerMasksAlert.this.delegate.onStickerSelected(obj, tLRPC$Document);
            }
        };
        this.behindKeyboardColorKey = -1;
        this.behindKeyboardColor = -14342875;
        this.useLightStatusBar = false;
        this.currentType = 0;
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.stickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.recentDocumentsDidLoad);
        MediaDataController.getInstance(this.currentAccount).loadRecents(0, false, true, false);
        MediaDataController.getInstance(this.currentAccount).loadRecents(1, false, true, false);
        MediaDataController.getInstance(this.currentAccount).loadRecents(2, false, true, false);
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(-14342875, PorterDuff.Mode.MULTIPLY));
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: org.rbmain.ui.Components.StickerMasksAlert.2
            private long lastUpdateTime;
            private float statusBarProgress;
            private boolean ignoreLayout = false;
            private RectF rect = new RectF();

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                int iDp;
                int size = View.MeasureSpec.getSize(i2);
                if (Build.VERSION.SDK_INT >= 21 && !((BottomSheet) StickerMasksAlert.this).isFullscreen) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) StickerMasksAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) StickerMasksAlert.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
                int paddingTop = size - getPaddingTop();
                if (measureKeyboardHeight() > AndroidUtilities.dp(20.0f)) {
                    this.statusBarProgress = 1.0f;
                    iDp = 0;
                } else {
                    iDp = (paddingTop - ((paddingTop / 5) * 3)) + AndroidUtilities.dp(8.0f);
                }
                if (StickerMasksAlert.this.gridView.getPaddingTop() != iDp) {
                    this.ignoreLayout = true;
                    StickerMasksAlert.this.gridView.setPinnedSectionOffsetY(-iDp);
                    StickerMasksAlert.this.gridView.setPadding(0, iDp, 0, AndroidUtilities.dp(48.0f));
                    this.ignoreLayout = false;
                }
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            }

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
                super.onLayout(z2, i, i2, i3, i4);
                StickerMasksAlert.this.updateLayout(false);
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && StickerMasksAlert.this.scrollOffsetY != 0 && motionEvent.getY() < StickerMasksAlert.this.scrollOffsetY + AndroidUtilities.dp(12.0f)) {
                    StickerMasksAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !StickerMasksAlert.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f;
                int iDp = AndroidUtilities.dp(13.0f);
                int translationY = (StickerMasksAlert.this.scrollOffsetY - ((BottomSheet) StickerMasksAlert.this).backgroundPaddingTop) - iDp;
                if (((BottomSheet) StickerMasksAlert.this).currentSheetAnimationType == 1) {
                    translationY = (int) (translationY + StickerMasksAlert.this.gridView.getTranslationY());
                }
                int iDp2 = AndroidUtilities.dp(20.0f) + translationY;
                int measuredHeight = getMeasuredHeight() + AndroidUtilities.dp(15.0f) + ((BottomSheet) StickerMasksAlert.this).backgroundPaddingTop;
                int iDp3 = AndroidUtilities.dp(12.0f);
                if (((BottomSheet) StickerMasksAlert.this).backgroundPaddingTop + translationY < iDp3) {
                    float fDp = iDp + AndroidUtilities.dp(4.0f);
                    float fMin = Math.min(1.0f, ((iDp3 - translationY) - ((BottomSheet) StickerMasksAlert.this).backgroundPaddingTop) / fDp);
                    int i = (int) ((iDp3 - fDp) * fMin);
                    translationY -= i;
                    iDp2 -= i;
                    measuredHeight += i;
                    f = 1.0f - fMin;
                } else {
                    f = 1.0f;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    int i2 = AndroidUtilities.statusBarHeight;
                    translationY += i2;
                    iDp2 += i2;
                }
                StickerMasksAlert.this.shadowDrawable.setBounds(0, translationY, getMeasuredWidth(), measuredHeight);
                StickerMasksAlert.this.shadowDrawable.draw(canvas);
                if (f != 1.0f) {
                    Theme.dialogs_onlineCirclePaint.setColor(-14342875);
                    this.rect.set(((BottomSheet) StickerMasksAlert.this).backgroundPaddingLeft, ((BottomSheet) StickerMasksAlert.this).backgroundPaddingTop + translationY, getMeasuredWidth() - ((BottomSheet) StickerMasksAlert.this).backgroundPaddingLeft, ((BottomSheet) StickerMasksAlert.this).backgroundPaddingTop + translationY + AndroidUtilities.dp(24.0f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(12.0f) * f, AndroidUtilities.dp(12.0f) * f, Theme.dialogs_onlineCirclePaint);
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime - this.lastUpdateTime;
                if (j > 18) {
                    j = 18;
                }
                this.lastUpdateTime = jElapsedRealtime;
                if (f > 0.0f) {
                    int iDp4 = AndroidUtilities.dp(36.0f);
                    this.rect.set((getMeasuredWidth() - iDp4) / 2, iDp2, (getMeasuredWidth() + iDp4) / 2, iDp2 + AndroidUtilities.dp(4.0f));
                    int iAlpha = Color.alpha(-11842741);
                    Theme.dialogs_onlineCirclePaint.setColor(-11842741);
                    Theme.dialogs_onlineCirclePaint.setAlpha((int) (iAlpha * 1.0f * f));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), Theme.dialogs_onlineCirclePaint);
                    float f2 = this.statusBarProgress;
                    if (f2 > 0.0f) {
                        float f3 = f2 - (j / 180.0f);
                        this.statusBarProgress = f3;
                        if (f3 < 0.0f) {
                            this.statusBarProgress = 0.0f;
                        } else {
                            invalidate();
                        }
                    }
                } else {
                    float f4 = this.statusBarProgress;
                    if (f4 < 1.0f) {
                        float f5 = f4 + (j / 180.0f);
                        this.statusBarProgress = f5;
                        if (f5 > 1.0f) {
                            this.statusBarProgress = 1.0f;
                        } else {
                            invalidate();
                        }
                    }
                }
                Theme.dialogs_onlineCirclePaint.setColor(Color.argb((int) (this.statusBarProgress * 255.0f), (int) (Color.red(-14342875) * 0.8f), (int) (Color.green(-14342875) * 0.8f), (int) (Color.blue(-14342875) * 0.8f)));
                canvas.drawRect(((BottomSheet) StickerMasksAlert.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) StickerMasksAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, Theme.dialogs_onlineCirclePaint);
            }
        };
        this.containerView = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        this.searchFieldHeight = AndroidUtilities.dp(64.0f);
        this.stickerIcons = new Drawable[]{Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_recent, -11842741, -9520403), Theme.createEmojiIconSelectorDrawable(context, R.drawable.stickers_favorites, -11842741, -9520403)};
        MediaDataController.getInstance(this.currentAccount).checkStickers(0);
        MediaDataController.getInstance(this.currentAccount).checkStickers(1);
        MediaDataController.getInstance(this.currentAccount).checkFeaturedStickers();
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.StickerMasksAlert.3
            @Override // org.rbmain.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float f, float f2) {
                return f2 >= ((float) (StickerMasksAlert.this.scrollOffsetY + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)));
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return super.onInterceptTouchEvent(motionEvent) || ContentPreviewViewer.getInstance().onInterceptTouchEvent(motionEvent, StickerMasksAlert.this.gridView, ((BottomSheet) StickerMasksAlert.this).containerView.getMeasuredHeight(), StickerMasksAlert.this.contentPreviewViewerDelegate, this.resourcesProvider);
            }
        };
        this.gridView = recyclerListView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 5) { // from class: org.rbmain.ui.Components.StickerMasksAlert.4
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: org.rbmain.ui.Components.StickerMasksAlert.4.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateDyToMakeVisible(View view, int i3) {
                        return super.calculateDyToMakeVisible(view, i3) - (StickerMasksAlert.this.gridView.getPaddingTop() - AndroidUtilities.dp(7.0f));
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int calculateTimeForDeceleration(int i3) {
                        return super.calculateTimeForDeceleration(i3) * 4;
                    }
                };
                linearSmoothScroller.setTargetPosition(i2);
                startSmoothScroll(linearSmoothScroller);
            }
        };
        this.stickersLayoutManager = gridLayoutManager;
        recyclerListView.setLayoutManager(gridLayoutManager);
        this.stickersLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: org.rbmain.ui.Components.StickerMasksAlert.5
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i2) {
                if (StickerMasksAlert.this.gridView.getAdapter() != StickerMasksAlert.this.stickersGridAdapter) {
                    if (i2 == StickerMasksAlert.this.stickersSearchGridAdapter.totalItems || !(StickerMasksAlert.this.stickersSearchGridAdapter.cache.get(i2) == null || (StickerMasksAlert.this.stickersSearchGridAdapter.cache.get(i2) instanceof TLRPC$Document))) {
                        return StickerMasksAlert.this.stickersGridAdapter.stickersPerRow;
                    }
                    return 1;
                }
                if (i2 == 0) {
                    return StickerMasksAlert.this.stickersGridAdapter.stickersPerRow;
                }
                if (i2 == StickerMasksAlert.this.stickersGridAdapter.totalItems || !(StickerMasksAlert.this.stickersGridAdapter.cache.get(i2) == null || (StickerMasksAlert.this.stickersGridAdapter.cache.get(i2) instanceof TLRPC$Document))) {
                    return StickerMasksAlert.this.stickersGridAdapter.stickersPerRow;
                }
                return 1;
            }
        });
        this.gridView.setPadding(0, AndroidUtilities.dp(52.0f), 0, AndroidUtilities.dp(48.0f));
        this.gridView.setClipToPadding(false);
        this.gridView.setHorizontalScrollBarEnabled(false);
        this.gridView.setVerticalScrollBarEnabled(false);
        this.gridView.setGlowColor(-14342875);
        this.stickersSearchGridAdapter = new StickersSearchGridAdapter(context);
        RecyclerListView recyclerListView2 = this.gridView;
        StickersGridAdapter stickersGridAdapter = new StickersGridAdapter(context);
        this.stickersGridAdapter = stickersGridAdapter;
        recyclerListView2.setAdapter(stickersGridAdapter);
        this.gridView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.StickerMasksAlert$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$new$0(view, motionEvent);
            }
        });
        RecyclerListView.OnItemClickListener onItemClickListener = new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.StickerMasksAlert$$ExternalSyntheticLambda3
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$new$1(view, i2);
            }
        };
        this.stickersOnItemClickListener = onItemClickListener;
        this.gridView.setOnItemClickListener(onItemClickListener);
        this.containerView.addView(this.gridView, LayoutHelper.createFrame(-1, -1.0f));
        this.stickersTab = new ScrollSlidingTabStrip(this, context) { // from class: org.rbmain.ui.Components.StickerMasksAlert.6
            @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.onInterceptTouchEvent(motionEvent);
            }
        };
        SearchField searchField = new SearchField(context, 0);
        this.stickersSearchField = searchField;
        this.containerView.addView(searchField, new FrameLayout.LayoutParams(-1, this.searchFieldHeight + AndroidUtilities.getShadowHeight()));
        this.stickersTab.setType(ScrollSlidingTabStrip.Type.TAB);
        this.stickersTab.setUnderlineHeight(AndroidUtilities.getShadowHeight());
        this.stickersTab.setIndicatorColor(-9520403);
        this.stickersTab.setUnderlineColor(-16053493);
        this.stickersTab.setBackgroundColor(-14342875);
        this.containerView.addView(this.stickersTab, LayoutHelper.createFrame(-1, 48, 51));
        this.stickersTab.setDelegate(new ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate() { // from class: org.rbmain.ui.Components.StickerMasksAlert$$ExternalSyntheticLambda4
            @Override // org.rbmain.ui.Components.ScrollSlidingTabStrip.ScrollSlidingTabStripDelegate
            public final void onPageSelected(int i2) {
                this.f$0.lambda$new$2(i2);
            }
        });
        this.gridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.StickerMasksAlert.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                if (i2 == 1) {
                    StickerMasksAlert.this.stickersSearchField.hideKeyboard();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                StickerMasksAlert.this.updateLayout(true);
            }
        });
        View view = new View(context);
        view.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, -1907225));
        this.containerView.addView(view, LayoutHelper.createFrame(-1, 6.0f));
        if (!z) {
            this.bottomTabContainer = new FrameLayout(this, context) { // from class: org.rbmain.ui.Components.StickerMasksAlert.8
                @Override // android.view.ViewGroup
                public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return super.onInterceptTouchEvent(motionEvent);
                }
            };
            View view2 = new View(context);
            this.shadowLine = view2;
            view2.setBackgroundColor(301989888);
            this.bottomTabContainer.addView(this.shadowLine, new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight()));
            View view3 = new View(context);
            view3.setBackgroundColor(-14342875);
            this.bottomTabContainer.addView(view3, new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(48.0f), 83));
            this.containerView.addView(this.bottomTabContainer, new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(48.0f) + AndroidUtilities.getShadowHeight(), 83));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            this.bottomTabContainer.addView(linearLayout, LayoutHelper.createFrame(-2, 48, 81));
            ImageView imageView = new ImageView(this, context) { // from class: org.rbmain.ui.Components.StickerMasksAlert.9
                @Override // android.widget.ImageView, android.view.View
                public void setSelected(boolean z2) {
                    super.setSelected(z2);
                    Drawable background = getBackground();
                    if (Build.VERSION.SDK_INT < 21 || background == null) {
                        return;
                    }
                    int i2 = z2 ? -9520403 : 520093695;
                    Theme.setSelectorDrawableColor(background, Color.argb(30, Color.red(i2), Color.green(i2), Color.blue(i2)), true);
                }
            };
            this.stickersButton = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.stickersButton.setImageDrawable(Theme.createEmojiIconSelectorDrawable(context, R.drawable.smiles_tab_stickers, -1, -9520403));
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                RippleDrawable rippleDrawable = (RippleDrawable) Theme.createSelectorDrawable(520093695);
                Theme.setRippleDrawableForceSoftware(rippleDrawable);
                this.stickersButton.setBackground(rippleDrawable);
            }
            linearLayout.addView(this.stickersButton, LayoutHelper.createLinear(70, 48));
            this.stickersButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.StickerMasksAlert$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    this.f$0.lambda$new$3(view4);
                }
            });
            ImageView imageView2 = new ImageView(this, context) { // from class: org.rbmain.ui.Components.StickerMasksAlert.10
                @Override // android.widget.ImageView, android.view.View
                public void setSelected(boolean z2) {
                    super.setSelected(z2);
                    Drawable background = getBackground();
                    if (Build.VERSION.SDK_INT < 21 || background == null) {
                        return;
                    }
                    int i3 = z2 ? -9520403 : 520093695;
                    Theme.setSelectorDrawableColor(background, Color.argb(30, Color.red(i3), Color.green(i3), Color.blue(i3)), true);
                }
            };
            this.masksButton = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            this.masksButton.setImageDrawable(Theme.createEmojiIconSelectorDrawable(context, R.drawable.ic_masks_msk1, -1, -9520403));
            if (i2 >= 21) {
                RippleDrawable rippleDrawable2 = (RippleDrawable) Theme.createSelectorDrawable(520093695);
                Theme.setRippleDrawableForceSoftware(rippleDrawable2);
                this.masksButton.setBackground(rippleDrawable2);
            }
            linearLayout.addView(this.masksButton, LayoutHelper.createLinear(70, 48));
            this.masksButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.StickerMasksAlert$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    this.f$0.lambda$new$4(view4);
                }
            });
        }
        checkDocuments(true);
        reloadStickersAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(View view, MotionEvent motionEvent) {
        return ContentPreviewViewer.getInstance().onTouch(motionEvent, this.gridView, this.containerView.getMeasuredHeight(), this.stickersOnItemClickListener, this.contentPreviewViewerDelegate, this.resourcesProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view, int i) {
        if (view instanceof StickerEmojiCell) {
            ContentPreviewViewer.getInstance().reset();
            StickerEmojiCell stickerEmojiCell = (StickerEmojiCell) view;
            this.delegate.onStickerSelected(stickerEmojiCell.getParentObject(), stickerEmojiCell.getSticker());
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(int i) {
        int positionForPack;
        if (i == this.recentTabBum) {
            positionForPack = this.stickersGridAdapter.getPositionForPack("recent");
            ScrollSlidingTabStrip scrollSlidingTabStrip = this.stickersTab;
            int i2 = this.recentTabBum;
            scrollSlidingTabStrip.onPageScrolled(i2, i2 > 0 ? i2 : this.stickersTabOffset);
        } else if (i == this.favTabBum) {
            positionForPack = this.stickersGridAdapter.getPositionForPack("fav");
            ScrollSlidingTabStrip scrollSlidingTabStrip2 = this.stickersTab;
            int i3 = this.favTabBum;
            scrollSlidingTabStrip2.onPageScrolled(i3, i3 > 0 ? i3 : this.stickersTabOffset);
        } else {
            int size = i - this.stickersTabOffset;
            if (size >= this.stickerSets[this.currentType].size()) {
                return;
            }
            if (size >= this.stickerSets[this.currentType].size()) {
                size = this.stickerSets[this.currentType].size() - 1;
            }
            positionForPack = this.stickersGridAdapter.getPositionForPack(this.stickerSets[this.currentType].get(size));
        }
        if (this.stickersLayoutManager.findFirstVisibleItemPosition() == positionForPack) {
            return;
        }
        this.stickersLayoutManager.scrollToPositionWithOffset(positionForPack, (-this.gridView.getPaddingTop()) + this.searchFieldHeight + AndroidUtilities.dp(48.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
        if (this.currentType == 0) {
            return;
        }
        this.currentType = 0;
        updateType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(View view) {
        if (this.currentType == 1) {
            return;
        }
        this.currentType = 1;
        updateType();
    }

    private void updateType() {
        View childAt;
        RecyclerView.ViewHolder viewHolderFindContainingViewHolder;
        int top;
        if (this.gridView.getChildCount() > 0 && (viewHolderFindContainingViewHolder = this.gridView.findContainingViewHolder((childAt = this.gridView.getChildAt(0)))) != null) {
            if (viewHolderFindContainingViewHolder.getAdapterPosition() != 0) {
                top = -this.gridView.getPaddingTop();
            } else {
                top = childAt.getTop() + (-this.gridView.getPaddingTop());
            }
            this.stickersLayoutManager.scrollToPositionWithOffset(0, top);
        }
        checkDocuments(true);
    }

    public void setDelegate(StickerMasksAlertDelegate stickerMasksAlertDelegate) {
        this.delegate = stickerMasksAlertDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout(boolean z) {
        RecyclerListView.Holder holder;
        if (this.gridView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.gridView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.containerView.invalidate();
            return;
        }
        View childAt = this.gridView.getChildAt(0);
        RecyclerListView.Holder holder2 = (RecyclerListView.Holder) this.gridView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        int iDp = AndroidUtilities.dp(7.0f);
        if (top < AndroidUtilities.dp(7.0f) || holder2 == null || holder2.getAdapterPosition() != 0) {
            top = iDp;
        }
        int i = top + (-AndroidUtilities.dp(11.0f));
        if (this.scrollOffsetY != i) {
            RecyclerListView recyclerListView2 = this.gridView;
            this.scrollOffsetY = i;
            recyclerListView2.setTopGlowOffset(i);
            this.stickersTab.setTranslationY(i);
            this.stickersSearchField.setTranslationY(i + AndroidUtilities.dp(48.0f));
            this.containerView.invalidate();
        }
        RecyclerListView.Holder holder3 = (RecyclerListView.Holder) this.gridView.findViewHolderForAdapterPosition(0);
        if (holder3 == null) {
            this.stickersSearchField.showShadow(true, z);
        } else {
            this.stickersSearchField.showShadow(holder3.itemView.getTop() < this.gridView.getPaddingTop(), z);
        }
        RecyclerView.Adapter adapter = this.gridView.getAdapter();
        StickersSearchGridAdapter stickersSearchGridAdapter = this.stickersSearchGridAdapter;
        if (adapter == stickersSearchGridAdapter && (holder = (RecyclerListView.Holder) this.gridView.findViewHolderForAdapterPosition(stickersSearchGridAdapter.getItemCount() - 1)) != null && holder.getItemViewType() == 5) {
            FrameLayout frameLayout = (FrameLayout) holder.itemView;
            int childCount = frameLayout.getChildCount();
            float f = (-((frameLayout.getTop() - this.searchFieldHeight) - AndroidUtilities.dp(48.0f))) / 2;
            for (int i2 = 0; i2 < childCount; i2++) {
                frameLayout.getChildAt(i2).setTranslationY(f);
            }
        }
        checkPanels();
    }

    private void updateStickerTabs() {
        ArrayList<TLRPC$Document> arrayList;
        if (this.stickersTab == null) {
            return;
        }
        ImageView imageView = this.stickersButton;
        if (imageView != null) {
            if (this.currentType == 0) {
                imageView.setSelected(true);
                this.masksButton.setSelected(false);
            } else {
                imageView.setSelected(false);
                this.masksButton.setSelected(true);
            }
        }
        this.recentTabBum = -2;
        this.favTabBum = -2;
        this.stickersTabOffset = 0;
        int currentPosition = this.stickersTab.getCurrentPosition();
        this.stickersTab.beginUpdate(false);
        if (this.currentType == 0 && !this.favouriteStickers.isEmpty()) {
            int i = this.stickersTabOffset;
            this.favTabBum = i;
            this.stickersTabOffset = i + 1;
            this.stickersTab.addIconTab(1, this.stickerIcons[1]).setContentDescription(LocaleController.getString("FavoriteStickers", R.string.FavoriteStickers));
        }
        if (!this.recentStickers[this.currentType].isEmpty()) {
            int i2 = this.stickersTabOffset;
            this.recentTabBum = i2;
            this.stickersTabOffset = i2 + 1;
            this.stickersTab.addIconTab(0, this.stickerIcons[0]).setContentDescription(LocaleController.getString("RecentStickers", R.string.RecentStickers));
        }
        this.stickerSets[this.currentType].clear();
        ArrayList<TLRPC$TL_messages_stickerSet> stickerSets = MediaDataController.getInstance(this.currentAccount).getStickerSets(this.currentType);
        for (int i3 = 0; i3 < stickerSets.size(); i3++) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = stickerSets.get(i3);
            if (!tLRPC$TL_messages_stickerSet.set.archived && (arrayList = tLRPC$TL_messages_stickerSet.documents) != null && !arrayList.isEmpty()) {
                this.stickerSets[this.currentType].add(tLRPC$TL_messages_stickerSet);
            }
        }
        for (int i4 = 0; i4 < this.stickerSets[this.currentType].size(); i4++) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet2 = this.stickerSets[this.currentType].get(i4);
            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickerSet2.documents.get(0);
            TLObject closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$TL_messages_stickerSet2.set.thumbs, 90);
            SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(tLRPC$TL_messages_stickerSet2.set.thumbs, Theme.key_windowBackgroundGray, 1.0f);
            if (closestPhotoSizeWithSize == null) {
                closestPhotoSizeWithSize = tLRPC$Document;
            }
            this.stickersTab.addStickerTab(closestPhotoSizeWithSize, svgThumb, tLRPC$Document, tLRPC$TL_messages_stickerSet2).setContentDescription(tLRPC$TL_messages_stickerSet2.set.title + ", " + LocaleController.getString("AccDescrStickerSet", R.string.AccDescrStickerSet));
        }
        this.stickersTab.commitUpdate();
        this.stickersTab.updateTabStyles();
        if (currentPosition != 0) {
            this.stickersTab.onPageScrolled(currentPosition, currentPosition);
        }
        checkPanels();
    }

    private void checkPanels() {
        if (this.stickersTab == null) {
            return;
        }
        int childCount = this.gridView.getChildCount();
        View childAt = null;
        for (int i = 0; i < childCount; i++) {
            childAt = this.gridView.getChildAt(i);
            if (childAt.getBottom() > this.searchFieldHeight + AndroidUtilities.dp(48.0f)) {
                break;
            }
        }
        if (childAt == null) {
            return;
        }
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.gridView.findContainingViewHolder(childAt);
        int adapterPosition = holder != null ? holder.getAdapterPosition() : -1;
        if (adapterPosition != -1) {
            int i2 = this.favTabBum;
            if (i2 <= 0 && (i2 = this.recentTabBum) <= 0) {
                i2 = this.stickersTabOffset;
            }
            this.stickersTab.onPageScrolled(this.stickersGridAdapter.getTabForPosition(adapterPosition), i2);
        }
    }

    private void reloadStickersAdapter() {
        StickersGridAdapter stickersGridAdapter = this.stickersGridAdapter;
        if (stickersGridAdapter != null) {
            stickersGridAdapter.notifyDataSetChanged();
        }
        StickersSearchGridAdapter stickersSearchGridAdapter = this.stickersSearchGridAdapter;
        if (stickersSearchGridAdapter != null) {
            stickersSearchGridAdapter.notifyDataSetChanged();
        }
        if (ContentPreviewViewer.getInstance().isVisible()) {
            ContentPreviewViewer.getInstance().close();
        }
        ContentPreviewViewer.getInstance().reset();
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        super.dismissInternal();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.stickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.recentDocumentsDidLoad);
    }

    private void checkDocuments(boolean z) {
        int size = this.recentStickers[this.currentType].size();
        int size2 = this.favouriteStickers.size();
        this.recentStickers[this.currentType] = MediaDataController.getInstance(this.currentAccount).getRecentStickers(this.currentType);
        this.favouriteStickers = MediaDataController.getInstance(this.currentAccount).getRecentStickers(2);
        if (this.currentType == 0) {
            for (int i = 0; i < this.favouriteStickers.size(); i++) {
                TLRPC$Document tLRPC$Document = this.favouriteStickers.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 < this.recentStickers[this.currentType].size()) {
                        TLRPC$Document tLRPC$Document2 = this.recentStickers[this.currentType].get(i2);
                        if (tLRPC$Document2.dc_id == tLRPC$Document.dc_id && tLRPC$Document2.id == tLRPC$Document.id) {
                            this.recentStickers[this.currentType].remove(i2);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        if (z || size != this.recentStickers[this.currentType].size() || size2 != this.favouriteStickers.size()) {
            updateStickerTabs();
        }
        StickersGridAdapter stickersGridAdapter = this.stickersGridAdapter;
        if (stickersGridAdapter != null) {
            stickersGridAdapter.notifyDataSetChanged();
        }
        if (z) {
            return;
        }
        checkPanels();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        RecyclerListView recyclerListView;
        if (i == NotificationCenter.stickersDidLoad) {
            if (((Integer) objArr[0]).intValue() == this.currentType) {
                updateStickerTabs();
                reloadStickersAdapter();
                checkPanels();
                return;
            }
            return;
        }
        if (i == NotificationCenter.recentDocumentsDidLoad) {
            boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
            int iIntValue = ((Integer) objArr[1]).intValue();
            if (zBooleanValue) {
                return;
            }
            if (iIntValue == this.currentType || iIntValue == 2) {
                checkDocuments(false);
                return;
            }
            return;
        }
        if (i != NotificationCenter.emojiDidLoad || (recyclerListView = this.gridView) == null) {
            return;
        }
        int childCount = recyclerListView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.gridView.getChildAt(i3);
            if ((childAt instanceof StickerSetNameCell) || (childAt instanceof StickerEmojiCell)) {
                childAt.invalidate();
            }
        }
    }

    private class StickersGridAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private int stickersPerRow;
        private int totalItems;
        private SparseArray<Object> rowStartPack = new SparseArray<>();
        private HashMap<Object, Integer> packStartPosition = new HashMap<>();
        private SparseArray<Object> cache = new SparseArray<>();
        private SparseArray<Object> cacheParents = new SparseArray<>();
        private SparseIntArray positionToRow = new SparseIntArray();

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public StickersGridAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int i = this.totalItems;
            if (i != 0) {
                return i + 1;
            }
            return 0;
        }

        public int getPositionForPack(Object obj) {
            Integer num = this.packStartPosition.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 4;
            }
            Object obj = this.cache.get(i);
            if (obj != null) {
                return obj instanceof TLRPC$Document ? 0 : 2;
            }
            return 1;
        }

        public int getTabForPosition(int i) {
            if (i == 0) {
                i = 1;
            }
            if (this.stickersPerRow == 0) {
                int measuredWidth = StickerMasksAlert.this.gridView.getMeasuredWidth();
                if (measuredWidth == 0) {
                    measuredWidth = AndroidUtilities.displaySize.x;
                }
                this.stickersPerRow = measuredWidth / AndroidUtilities.dp(72.0f);
            }
            int i2 = this.positionToRow.get(i, Integer.MIN_VALUE);
            if (i2 == Integer.MIN_VALUE) {
                return (StickerMasksAlert.this.stickerSets[StickerMasksAlert.this.currentType].size() - 1) + StickerMasksAlert.this.stickersTabOffset;
            }
            Object obj = this.rowStartPack.get(i2);
            if (obj instanceof String) {
                return "recent".equals(obj) ? StickerMasksAlert.this.recentTabBum : StickerMasksAlert.this.favTabBum;
            }
            return StickerMasksAlert.this.stickerSets[StickerMasksAlert.this.currentType].indexOf((TLRPC$TL_messages_stickerSet) obj) + StickerMasksAlert.this.stickersTabOffset;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            StickerEmojiCell stickerEmojiCell;
            View emptyCell;
            boolean z = false;
            if (i == 0) {
                stickerEmojiCell = new StickerEmojiCell(this, this.context, z) { // from class: org.rbmain.ui.Components.StickerMasksAlert.StickersGridAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    public void onMeasure(int i2, int i3) {
                        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                    }
                };
            } else {
                if (i == 1) {
                    emptyCell = new EmptyCell(this.context);
                } else if (i == 2) {
                    StickerSetNameCell stickerSetNameCell = new StickerSetNameCell(this.context, false);
                    stickerSetNameCell.setTitleColor(-7829368);
                    stickerEmojiCell = stickerSetNameCell;
                } else if (i != 4) {
                    emptyCell = null;
                } else {
                    emptyCell = new View(this.context);
                    emptyCell.setLayoutParams(new RecyclerView.LayoutParams(-1, StickerMasksAlert.this.searchFieldHeight + AndroidUtilities.dp(48.0f)));
                }
                return new RecyclerListView.Holder(emptyCell);
            }
            emptyCell = stickerEmojiCell;
            return new RecyclerListView.Holder(emptyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ArrayList<TLRPC$Document> arrayList;
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                TLRPC$Document tLRPC$Document = (TLRPC$Document) this.cache.get(i);
                StickerEmojiCell stickerEmojiCell = (StickerEmojiCell) viewHolder.itemView;
                stickerEmojiCell.setSticker(tLRPC$Document, this.cacheParents.get(i), false);
                stickerEmojiCell.setRecent(StickerMasksAlert.this.recentStickers[StickerMasksAlert.this.currentType].contains(tLRPC$Document));
                return;
            }
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    return;
                }
                StickerSetNameCell stickerSetNameCell = (StickerSetNameCell) viewHolder.itemView;
                Object obj = this.cache.get(i);
                if (!(obj instanceof TLRPC$TL_messages_stickerSet)) {
                    if (obj != StickerMasksAlert.this.recentStickers[StickerMasksAlert.this.currentType]) {
                        if (obj == StickerMasksAlert.this.favouriteStickers) {
                            stickerSetNameCell.setText(LocaleController.getString("FavoriteStickers", R.string.FavoriteStickers), 0);
                            return;
                        }
                        return;
                    }
                    stickerSetNameCell.setText(LocaleController.getString("RecentStickers", R.string.RecentStickers), 0);
                    return;
                }
                TLRPC$StickerSet tLRPC$StickerSet = ((TLRPC$TL_messages_stickerSet) obj).set;
                if (tLRPC$StickerSet != null) {
                    stickerSetNameCell.setText(tLRPC$StickerSet.title, 0);
                    return;
                }
                return;
            }
            EmptyCell emptyCell = (EmptyCell) viewHolder.itemView;
            if (i == this.totalItems) {
                int i2 = this.positionToRow.get(i - 1, Integer.MIN_VALUE);
                if (i2 == Integer.MIN_VALUE) {
                    emptyCell.setHeight(1);
                    return;
                }
                Object obj2 = this.rowStartPack.get(i2);
                if (obj2 instanceof TLRPC$TL_messages_stickerSet) {
                    arrayList = ((TLRPC$TL_messages_stickerSet) obj2).documents;
                } else if (obj2 instanceof String) {
                    arrayList = "recent".equals(obj2) ? StickerMasksAlert.this.recentStickers[StickerMasksAlert.this.currentType] : StickerMasksAlert.this.favouriteStickers;
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    emptyCell.setHeight(1);
                    return;
                } else if (!arrayList.isEmpty()) {
                    int height = StickerMasksAlert.this.gridView.getHeight() - (((int) Math.ceil(arrayList.size() / this.stickersPerRow)) * AndroidUtilities.dp(82.0f));
                    emptyCell.setHeight(height > 0 ? height : 1);
                    return;
                } else {
                    emptyCell.setHeight(AndroidUtilities.dp(8.0f));
                    return;
                }
            }
            emptyCell.setHeight(AndroidUtilities.dp(82.0f));
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x015a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void notifyDataSetChanged() {
            /*
                Method dump skipped, instructions count: 356
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.StickerMasksAlert.StickersGridAdapter.notifyDataSetChanged():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class StickersSearchGridAdapter extends RecyclerListView.SelectionAdapter {
        boolean cleared;
        private Context context;
        private int emojiSearchId;
        private int reqId2;
        private String searchQuery;
        private int totalItems;
        private SparseArray<Object> rowStartPack = new SparseArray<>();
        private SparseArray<Object> cache = new SparseArray<>();
        private SparseArray<Object> cacheParent = new SparseArray<>();
        private SparseIntArray positionToRow = new SparseIntArray();
        private SparseArray<String> positionToEmoji = new SparseArray<>();
        private ArrayList<TLRPC$TL_messages_stickerSet> localPacks = new ArrayList<>();
        private HashMap<TLRPC$TL_messages_stickerSet, Boolean> localPacksByShortName = new HashMap<>();
        private HashMap<TLRPC$TL_messages_stickerSet, Integer> localPacksByName = new HashMap<>();
        private HashMap<ArrayList<TLRPC$Document>, String> emojiStickers = new HashMap<>();
        private ArrayList<ArrayList<TLRPC$Document>> emojiArrays = new ArrayList<>();
        private Runnable searchRunnable = new AnonymousClass1();

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        static /* synthetic */ int access$4804(StickersSearchGridAdapter stickersSearchGridAdapter) {
            int i = stickersSearchGridAdapter.emojiSearchId + 1;
            stickersSearchGridAdapter.emojiSearchId = i;
            return i;
        }

        /* renamed from: org.rbmain.ui.Components.StickerMasksAlert$StickersSearchGridAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            private void clear() {
                StickersSearchGridAdapter stickersSearchGridAdapter = StickersSearchGridAdapter.this;
                if (stickersSearchGridAdapter.cleared) {
                    return;
                }
                stickersSearchGridAdapter.cleared = true;
                stickersSearchGridAdapter.emojiStickers.clear();
                StickersSearchGridAdapter.this.emojiArrays.clear();
                StickersSearchGridAdapter.this.localPacks.clear();
                StickersSearchGridAdapter.this.localPacksByShortName.clear();
                StickersSearchGridAdapter.this.localPacksByName.clear();
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
            /* JADX WARN: Removed duplicated region for block: B:98:0x00c8 A[SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 805
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.StickerMasksAlert.StickersSearchGridAdapter.AnonymousClass1.run():void");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0(int i, HashMap map, ArrayList arrayList, String str) {
                if (i != StickersSearchGridAdapter.this.emojiSearchId) {
                    return;
                }
                int size = arrayList.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    String str2 = ((MediaDataController.KeywordResult) arrayList.get(i2)).emoji;
                    ArrayList arrayList2 = map != null ? (ArrayList) map.get(str2) : null;
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        clear();
                        if (!StickersSearchGridAdapter.this.emojiStickers.containsKey(arrayList2)) {
                            StickersSearchGridAdapter.this.emojiStickers.put(arrayList2, str2);
                            StickersSearchGridAdapter.this.emojiArrays.add(arrayList2);
                            z = true;
                        }
                    }
                }
                if (!z) {
                    if (StickersSearchGridAdapter.this.reqId2 == 0) {
                        clear();
                        StickersSearchGridAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                StickersSearchGridAdapter.this.notifyDataSetChanged();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$2(final TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers, final ArrayList arrayList, final LongSparseArray longSparseArray, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.StickerMasksAlert$StickersSearchGridAdapter$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$1(tLRPC$TL_messages_getStickers, tLObject, arrayList, longSparseArray);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$1(TLRPC$TL_messages_getStickers tLRPC$TL_messages_getStickers, TLObject tLObject, ArrayList arrayList, LongSparseArray longSparseArray) {
                if (tLRPC$TL_messages_getStickers.emoticon.equals(StickersSearchGridAdapter.this.searchQuery)) {
                    StickerMasksAlert.this.stickersSearchField.progressDrawable.stopAnimation();
                    StickersSearchGridAdapter.this.reqId2 = 0;
                    if (tLObject instanceof TLRPC$TL_messages_stickers) {
                        TLRPC$TL_messages_stickers tLRPC$TL_messages_stickers = (TLRPC$TL_messages_stickers) tLObject;
                        int size = arrayList.size();
                        int size2 = tLRPC$TL_messages_stickers.stickers.size();
                        for (int i = 0; i < size2; i++) {
                            TLRPC$Document tLRPC$Document = tLRPC$TL_messages_stickers.stickers.get(i);
                            if (longSparseArray.indexOfKey(tLRPC$Document.id) < 0) {
                                arrayList.add(tLRPC$Document);
                            }
                        }
                        if (size != arrayList.size()) {
                            StickersSearchGridAdapter.this.emojiStickers.put(arrayList, StickersSearchGridAdapter.this.searchQuery);
                            if (size == 0) {
                                StickersSearchGridAdapter.this.emojiArrays.add(arrayList);
                            }
                            StickersSearchGridAdapter.this.notifyDataSetChanged();
                        }
                        if (StickerMasksAlert.this.gridView.getAdapter() != StickerMasksAlert.this.stickersSearchGridAdapter) {
                            StickerMasksAlert.this.gridView.setAdapter(StickerMasksAlert.this.stickersSearchGridAdapter);
                        }
                    }
                }
            }
        }

        public StickersSearchGridAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int i = this.totalItems;
            if (i != 1) {
                return i + 1;
            }
            return 2;
        }

        public void search(String str) {
            if (this.reqId2 != 0) {
                ConnectionsManager.getInstance(StickerMasksAlert.this.currentAccount).cancelRequest(this.reqId2, true);
                this.reqId2 = 0;
            }
            if (TextUtils.isEmpty(str)) {
                this.searchQuery = null;
                this.localPacks.clear();
                this.emojiStickers.clear();
                if (StickerMasksAlert.this.gridView.getAdapter() != StickerMasksAlert.this.stickersGridAdapter) {
                    StickerMasksAlert.this.gridView.setAdapter(StickerMasksAlert.this.stickersGridAdapter);
                }
                notifyDataSetChanged();
            } else {
                this.searchQuery = str.toLowerCase();
            }
            AndroidUtilities.cancelRunOnUIThread(this.searchRunnable);
            AndroidUtilities.runOnUIThread(this.searchRunnable, 300L);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 4;
            }
            if (i == 1 && this.totalItems == 1) {
                return 5;
            }
            Object obj = this.cache.get(i);
            if (obj != null) {
                return obj instanceof TLRPC$Document ? 0 : 2;
            }
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View stickerSetNameCell;
            View emptyCell;
            boolean z = false;
            if (i == 0) {
                stickerSetNameCell = new StickerEmojiCell(this, this.context, z) { // from class: org.rbmain.ui.Components.StickerMasksAlert.StickersSearchGridAdapter.2
                    @Override // android.widget.FrameLayout, android.view.View
                    public void onMeasure(int i2, int i3) {
                        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                    }
                };
            } else {
                if (i == 1) {
                    emptyCell = new EmptyCell(this.context);
                } else if (i == 2) {
                    stickerSetNameCell = new StickerSetNameCell(this.context, false);
                } else if (i == 4) {
                    View view = new View(this.context);
                    view.setLayoutParams(new RecyclerView.LayoutParams(-1, StickerMasksAlert.this.searchFieldHeight + AndroidUtilities.dp(48.0f)));
                    emptyCell = view;
                } else if (i != 5) {
                    emptyCell = null;
                } else {
                    FrameLayout frameLayout = new FrameLayout(this.context) { // from class: org.rbmain.ui.Components.StickerMasksAlert.StickersSearchGridAdapter.3
                        @Override // android.widget.FrameLayout, android.view.View
                        protected void onMeasure(int i2, int i3) {
                            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(((StickerMasksAlert.this.gridView.getMeasuredHeight() - StickerMasksAlert.this.searchFieldHeight) - AndroidUtilities.dp(48.0f)) - AndroidUtilities.dp(48.0f), 1073741824));
                        }
                    };
                    ImageView imageView = new ImageView(this.context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    imageView.setImageResource(R.drawable.stickers_empty);
                    imageView.setColorFilter(new PorterDuffColorFilter(-7038047, PorterDuff.Mode.MULTIPLY));
                    frameLayout.addView(imageView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 50.0f));
                    TextView textView = new TextView(this.context);
                    textView.setText(LocaleController.getString("NoStickersFound", R.string.NoStickersFound));
                    textView.setTextSize(1, 16.0f);
                    textView.setTextColor(-7038047);
                    frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, 0.0f));
                    frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                    emptyCell = frameLayout;
                }
                return new RecyclerListView.Holder(emptyCell);
            }
            emptyCell = stickerSetNameCell;
            return new RecyclerListView.Holder(emptyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                TLRPC$Document tLRPC$Document = (TLRPC$Document) this.cache.get(i);
                StickerEmojiCell stickerEmojiCell = (StickerEmojiCell) viewHolder.itemView;
                stickerEmojiCell.setSticker(tLRPC$Document, this.cacheParent.get(i), this.positionToEmoji.get(i), false);
                stickerEmojiCell.setRecent(StickerMasksAlert.this.recentStickers[StickerMasksAlert.this.currentType].contains(tLRPC$Document) || StickerMasksAlert.this.favouriteStickers.contains(tLRPC$Document));
                return;
            }
            Integer numValueOf = null;
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    return;
                }
                StickerSetNameCell stickerSetNameCell = (StickerSetNameCell) viewHolder.itemView;
                Object obj = this.cache.get(i);
                if (obj instanceof TLRPC$TL_messages_stickerSet) {
                    TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) obj;
                    if (!TextUtils.isEmpty(this.searchQuery) && this.localPacksByShortName.containsKey(tLRPC$TL_messages_stickerSet)) {
                        TLRPC$StickerSet tLRPC$StickerSet = tLRPC$TL_messages_stickerSet.set;
                        if (tLRPC$StickerSet != null) {
                            stickerSetNameCell.setText(tLRPC$StickerSet.title, 0);
                        }
                        stickerSetNameCell.setUrl(tLRPC$TL_messages_stickerSet.set.short_name, this.searchQuery.length());
                        return;
                    }
                    Integer num = this.localPacksByName.get(tLRPC$TL_messages_stickerSet);
                    TLRPC$StickerSet tLRPC$StickerSet2 = tLRPC$TL_messages_stickerSet.set;
                    if (tLRPC$StickerSet2 != null && num != null) {
                        stickerSetNameCell.setText(tLRPC$StickerSet2.title, 0, num.intValue(), !TextUtils.isEmpty(this.searchQuery) ? this.searchQuery.length() : 0);
                    }
                    stickerSetNameCell.setUrl(null, 0);
                    return;
                }
                return;
            }
            EmptyCell emptyCell = (EmptyCell) viewHolder.itemView;
            if (i == this.totalItems) {
                int i2 = this.positionToRow.get(i - 1, Integer.MIN_VALUE);
                if (i2 == Integer.MIN_VALUE) {
                    emptyCell.setHeight(1);
                    return;
                }
                Object obj2 = this.rowStartPack.get(i2);
                if (obj2 instanceof TLRPC$TL_messages_stickerSet) {
                    numValueOf = Integer.valueOf(((TLRPC$TL_messages_stickerSet) obj2).documents.size());
                } else if (obj2 instanceof Integer) {
                    numValueOf = (Integer) obj2;
                }
                if (numValueOf == null) {
                    emptyCell.setHeight(1);
                    return;
                } else if (numValueOf.intValue() != 0) {
                    int height = StickerMasksAlert.this.gridView.getHeight() - (((int) Math.ceil(numValueOf.intValue() / StickerMasksAlert.this.stickersGridAdapter.stickersPerRow)) * AndroidUtilities.dp(82.0f));
                    emptyCell.setHeight(height > 0 ? height : 1);
                    return;
                } else {
                    emptyCell.setHeight(AndroidUtilities.dp(8.0f));
                    return;
                }
            }
            emptyCell.setHeight(AndroidUtilities.dp(82.0f));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            int i;
            this.rowStartPack.clear();
            this.positionToRow.clear();
            this.cache.clear();
            this.positionToEmoji.clear();
            this.totalItems = 0;
            int size = this.localPacks.size();
            int i2 = !this.emojiArrays.isEmpty() ? 1 : 0;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            while (i4 < size + i2) {
                if (i4 == i3) {
                    SparseArray<Object> sparseArray = this.cache;
                    int i6 = this.totalItems;
                    this.totalItems = i6 + 1;
                    sparseArray.put(i6, "search");
                    i5++;
                } else if (i4 < size) {
                    TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.localPacks.get(i4);
                    ArrayList<TLRPC$Document> arrayList = tLRPC$TL_messages_stickerSet.documents;
                    if (!arrayList.isEmpty()) {
                        int iCeil = (int) Math.ceil(arrayList.size() / StickerMasksAlert.this.stickersGridAdapter.stickersPerRow);
                        this.cache.put(this.totalItems, tLRPC$TL_messages_stickerSet);
                        this.positionToRow.put(this.totalItems, i5);
                        int size2 = arrayList.size();
                        int i7 = 0;
                        while (i7 < size2) {
                            int i8 = i7 + 1;
                            int i9 = this.totalItems + i8;
                            int i10 = i5 + 1 + (i7 / StickerMasksAlert.this.stickersGridAdapter.stickersPerRow);
                            this.cache.put(i9, arrayList.get(i7));
                            this.cacheParent.put(i9, tLRPC$TL_messages_stickerSet);
                            this.positionToRow.put(i9, i10);
                            i7 = i8;
                        }
                        int i11 = iCeil + 1;
                        for (int i12 = 0; i12 < i11; i12++) {
                            this.rowStartPack.put(i5 + i12, tLRPC$TL_messages_stickerSet);
                        }
                        this.totalItems += (iCeil * StickerMasksAlert.this.stickersGridAdapter.stickersPerRow) + 1;
                        i5 += i11;
                    }
                } else {
                    int size3 = this.emojiArrays.size();
                    String str = BuildConfig.FLAVOR;
                    int i13 = 0;
                    for (int i14 = 0; i14 < size3; i14++) {
                        ArrayList<TLRPC$Document> arrayList2 = this.emojiArrays.get(i14);
                        String str2 = this.emojiStickers.get(arrayList2);
                        if (str2 != null && !str.equals(str2)) {
                            this.positionToEmoji.put(this.totalItems + i13, str2);
                            str = str2;
                        }
                        int size4 = arrayList2.size();
                        int i15 = 0;
                        while (i15 < size4) {
                            int i16 = this.totalItems + i13;
                            int i17 = (i13 / StickerMasksAlert.this.stickersGridAdapter.stickersPerRow) + i5;
                            TLRPC$Document tLRPC$Document = arrayList2.get(i15);
                            this.cache.put(i16, tLRPC$Document);
                            int i18 = size;
                            TLRPC$TL_messages_stickerSet stickerSetById = MediaDataController.getInstance(StickerMasksAlert.this.currentAccount).getStickerSetById(MediaDataController.getStickerSetId(tLRPC$Document));
                            if (stickerSetById != null) {
                                this.cacheParent.put(i16, stickerSetById);
                            }
                            this.positionToRow.put(i16, i17);
                            i13++;
                            i15++;
                            size = i18;
                        }
                    }
                    i = size;
                    int iCeil2 = (int) Math.ceil(i13 / StickerMasksAlert.this.stickersGridAdapter.stickersPerRow);
                    for (int i19 = 0; i19 < iCeil2; i19++) {
                        this.rowStartPack.put(i5 + i19, Integer.valueOf(i13));
                    }
                    this.totalItems += StickerMasksAlert.this.stickersGridAdapter.stickersPerRow * iCeil2;
                    i5 += iCeil2;
                    i4++;
                    size = i;
                    i3 = -1;
                }
                i = size;
                i4++;
                size = i;
                i3 = -1;
            }
            super.notifyDataSetChanged();
        }
    }
}
