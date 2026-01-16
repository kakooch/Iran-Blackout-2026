package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionValues;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ir.medu.shad.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;

/* loaded from: classes5.dex */
public class ScrollSlidingTabStrip extends HorizontalScrollView {
    private boolean animateFromPosition;
    private int currentPosition;
    private LinearLayout.LayoutParams defaultExpandLayoutParams;
    private LinearLayout.LayoutParams defaultTabLayoutParams;
    private ScrollSlidingTabStripDelegate delegate;
    private SparseArray<View> futureTabsPositions;
    private int indicatorColor;
    private GradientDrawable indicatorDrawable;
    private int indicatorHeight;
    private long lastAnimationTime;
    private int lastScrollX;
    private float positionAnimationProgress;
    private HashMap<String, View> prevTypes;
    private Paint rectPaint;
    private int scrollOffset;
    private boolean shouldExpand;
    private float startAnimationPosition;
    private int tabCount;
    private HashMap<String, View> tabTypes;
    private LinearLayout tabsContainer;
    private Type type;
    private int underlineColor;
    private int underlineHeight;

    public interface ScrollSlidingTabStripDelegate {
        void onPageSelected(int i);
    }

    public enum Type {
        LINE,
        TAB
    }

    public ScrollSlidingTabStrip(Context context) {
        super(context);
        this.type = Type.LINE;
        this.tabTypes = new HashMap<>();
        this.prevTypes = new HashMap<>();
        this.futureTabsPositions = new SparseArray<>();
        this.indicatorColor = -10066330;
        this.underlineColor = 436207616;
        this.indicatorDrawable = new GradientDrawable();
        this.scrollOffset = AndroidUtilities.dp(52.0f);
        this.underlineHeight = AndroidUtilities.dp(2.0f);
        AndroidUtilities.dp(12.0f);
        AndroidUtilities.dp(24.0f);
        this.lastScrollX = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        this.defaultTabLayoutParams = new LinearLayout.LayoutParams(AndroidUtilities.dp(52.0f), -1);
        this.defaultExpandLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    public void setDelegate(ScrollSlidingTabStripDelegate scrollSlidingTabStripDelegate) {
        this.delegate = scrollSlidingTabStripDelegate;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        if (type == null || this.type == type) {
            return;
        }
        this.type = type;
        int i = AnonymousClass2.$SwitchMap$org$rbmain$ui$Components$ScrollSlidingTabStrip$Type[type.ordinal()];
        if (i == 1) {
            this.indicatorDrawable.setCornerRadius(0.0f);
        } else {
            if (i != 2) {
                return;
            }
            float fDpf2 = AndroidUtilities.dpf2(3.0f);
            this.indicatorDrawable.setCornerRadii(new float[]{fDpf2, fDpf2, fDpf2, fDpf2, 0.0f, 0.0f, 0.0f, 0.0f});
        }
    }

    /* renamed from: org.rbmain.ui.Components.ScrollSlidingTabStrip$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$rbmain$ui$Components$ScrollSlidingTabStrip$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$org$rbmain$ui$Components$ScrollSlidingTabStrip$Type = iArr;
            try {
                iArr[Type.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$rbmain$ui$Components$ScrollSlidingTabStrip$Type[Type.TAB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void removeTabs() {
        this.tabsContainer.removeAllViews();
        this.tabTypes.clear();
        this.prevTypes.clear();
        this.futureTabsPositions.clear();
        this.tabCount = 0;
        this.currentPosition = 0;
        this.animateFromPosition = false;
    }

    public void beginUpdate(boolean z) {
        this.prevTypes = this.tabTypes;
        this.tabTypes = new HashMap<>();
        this.futureTabsPositions.clear();
        this.tabCount = 0;
        if (!z || Build.VERSION.SDK_INT < 19) {
            return;
        }
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(250L);
        autoTransition.setOrdering(0);
        autoTransition.addTransition(new AnonymousClass1());
        TransitionManager.beginDelayedTransition(this.tabsContainer, autoTransition);
    }

    /* renamed from: org.rbmain.ui.Components.ScrollSlidingTabStrip$1, reason: invalid class name */
    class AnonymousClass1 extends Transition {
        @Override // android.transition.Transition
        public void captureEndValues(TransitionValues transitionValues) {
        }

        @Override // android.transition.Transition
        public void captureStartValues(TransitionValues transitionValues) {
        }

        AnonymousClass1() {
        }

        @Override // android.transition.Transition
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ScrollSlidingTabStrip$1$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createAnimator$0(valueAnimator);
                }
            });
            return valueAnimatorOfFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createAnimator$0(ValueAnimator valueAnimator) {
            ScrollSlidingTabStrip.this.invalidate();
        }
    }

    public void commitUpdate() {
        HashMap<String, View> map = this.prevTypes;
        if (map != null) {
            Iterator<Map.Entry<String, View>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                this.tabsContainer.removeView(it.next().getValue());
            }
            this.prevTypes.clear();
        }
        int size = this.futureTabsPositions.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = this.futureTabsPositions.keyAt(i);
            View viewValueAt = this.futureTabsPositions.valueAt(i);
            if (this.tabsContainer.indexOfChild(viewValueAt) != iKeyAt) {
                this.tabsContainer.removeView(viewValueAt);
                this.tabsContainer.addView(viewValueAt, iKeyAt);
            }
        }
        this.futureTabsPositions.clear();
    }

    public void selectTab(int i) {
        if (i < 0 || i >= this.tabCount) {
            return;
        }
        this.tabsContainer.getChildAt(i).performClick();
    }

    private void checkViewIndex(String str, View view, int i) {
        HashMap<String, View> map = this.prevTypes;
        if (map != null) {
            map.remove(str);
        }
        this.futureTabsPositions.put(i, view);
    }

    public ImageView addIconTab(int i, Drawable drawable) {
        String str = "tab" + i;
        int i2 = this.tabCount;
        this.tabCount = i2 + 1;
        ImageView imageView = (ImageView) this.prevTypes.get(str);
        if (imageView != null) {
            checkViewIndex(str, imageView, i2);
        } else {
            imageView = new ImageView(getContext());
            imageView.setFocusable(true);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ScrollSlidingTabStrip$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addIconTab$0(view);
                }
            });
            this.tabsContainer.addView(imageView, i2);
        }
        imageView.setTag(R.id.index_tag, Integer.valueOf(i2));
        imageView.setSelected(i2 == this.currentPosition);
        this.tabTypes.put(str, imageView);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addIconTab$0(View view) {
        this.delegate.onPageSelected(((Integer) view.getTag(R.id.index_tag)).intValue());
    }

    public void addStickerTab(TLRPC$Chat tLRPC$Chat) {
        String str = "chat" + tLRPC$Chat.id;
        int i = this.tabCount;
        this.tabCount = i + 1;
        FrameLayout frameLayout = (FrameLayout) this.prevTypes.get(str);
        if (frameLayout != null) {
            checkViewIndex(str, frameLayout, i);
        } else {
            frameLayout = new FrameLayout(getContext());
            frameLayout.setFocusable(true);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ScrollSlidingTabStrip$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addStickerTab$1(view);
                }
            });
            this.tabsContainer.addView(frameLayout, i);
            AvatarDrawable avatarDrawable = new AvatarDrawable();
            avatarDrawable.setTextSize(AndroidUtilities.dp(14.0f));
            avatarDrawable.setInfo(tLRPC$Chat);
            BackupImageView backupImageView = new BackupImageView(getContext());
            backupImageView.setLayerNum(1);
            backupImageView.setRoundRadius(AndroidUtilities.dp(15.0f));
            backupImageView.setForUserOrChat(tLRPC$Chat, avatarDrawable);
            backupImageView.setAspectFit(true);
            frameLayout.addView(backupImageView, LayoutHelper.createFrame(30, 30, 17));
        }
        frameLayout.setTag(R.id.index_tag, Integer.valueOf(i));
        frameLayout.setSelected(i == this.currentPosition);
        this.tabTypes.put(str, frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addStickerTab$1(View view) {
        this.delegate.onPageSelected(((Integer) view.getTag(R.id.index_tag)).intValue());
    }

    public View addStickerTab(TLObject tLObject, SvgHelper.SvgDrawable svgDrawable, TLRPC$Document tLRPC$Document, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet) {
        String str = "set" + tLRPC$TL_messages_stickerSet.set.id;
        int i = this.tabCount;
        this.tabCount = i + 1;
        FrameLayout frameLayout = (FrameLayout) this.prevTypes.get(str);
        if (frameLayout != null) {
            checkViewIndex(str, frameLayout, i);
        } else {
            frameLayout = new FrameLayout(getContext());
            frameLayout.setFocusable(true);
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ScrollSlidingTabStrip$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addStickerTab$2(view);
                }
            });
            this.tabsContainer.addView(frameLayout, i);
            BackupImageView backupImageView = new BackupImageView(getContext());
            backupImageView.setLayerNum(1);
            backupImageView.setAspectFit(true);
            frameLayout.addView(backupImageView, LayoutHelper.createFrame(30, 30, 17));
        }
        frameLayout.setTag(tLObject);
        frameLayout.setTag(R.id.index_tag, Integer.valueOf(i));
        frameLayout.setTag(R.id.parent_tag, tLRPC$TL_messages_stickerSet);
        frameLayout.setTag(R.id.object_tag, tLRPC$Document);
        frameLayout.setTag(R.id.svg_tag, svgDrawable);
        frameLayout.setSelected(i == this.currentPosition);
        this.tabTypes.put(str, frameLayout);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addStickerTab$2(View view) {
        this.delegate.onPageSelected(((Integer) view.getTag(R.id.index_tag)).intValue());
    }

    public void updateTabStyles() {
        for (int i = 0; i < this.tabCount; i++) {
            View childAt = this.tabsContainer.getChildAt(i);
            if (this.shouldExpand) {
                childAt.setLayoutParams(this.defaultExpandLayoutParams);
            } else {
                childAt.setLayoutParams(this.defaultTabLayoutParams);
            }
        }
    }

    private void scrollToChild(int i) {
        if (this.tabCount == 0 || this.tabsContainer.getChildAt(i) == null) {
            return;
        }
        int left = this.tabsContainer.getChildAt(i).getLeft();
        if (i > 0) {
            left -= this.scrollOffset;
        }
        int scrollX = getScrollX();
        if (left != this.lastScrollX) {
            if (left < scrollX) {
                this.lastScrollX = left;
                smoothScrollTo(left, 0);
            } else if (this.scrollOffset + left > (scrollX + getWidth()) - (this.scrollOffset * 2)) {
                int width = (left - getWidth()) + (this.scrollOffset * 3);
                this.lastScrollX = width;
                smoothScrollTo(width, 0);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setImages();
    }

    public void setImages() {
        ImageLocation forSticker;
        int scrollX = getScrollX() / AndroidUtilities.dp(52.0f);
        int iMin = Math.min(this.tabsContainer.getChildCount(), ((int) Math.ceil(getMeasuredWidth() / r0)) + scrollX + 1);
        while (scrollX < iMin) {
            View childAt = this.tabsContainer.getChildAt(scrollX);
            Object tag = childAt.getTag();
            Object tag2 = childAt.getTag(R.id.parent_tag);
            SvgHelper.SvgDrawable svgDrawable = (SvgHelper.SvgDrawable) childAt.getTag(R.id.svg_tag);
            TLRPC$Document tLRPC$Document = (TLRPC$Document) childAt.getTag(R.id.object_tag);
            boolean z = tag instanceof TLRPC$Document;
            if (z) {
                forSticker = ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90), tLRPC$Document);
            } else if (tag instanceof TLRPC$PhotoSize) {
                forSticker = ImageLocation.getForSticker((TLRPC$PhotoSize) tag, tLRPC$Document);
            } else {
                scrollX++;
            }
            if (forSticker != null) {
                BackupImageView backupImageView = (BackupImageView) ((FrameLayout) childAt).getChildAt(0);
                if (z && MessageObject.isAnimatedStickerDocument(tLRPC$Document, true)) {
                    if (svgDrawable != null) {
                        backupImageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "30_30", svgDrawable, 0, tag2);
                    } else {
                        backupImageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "30_30", forSticker, (String) null, 0, tag2);
                    }
                } else if (forSticker.imageType == 1) {
                    backupImageView.setImage(forSticker, "30_30", "tgs", svgDrawable, tag2);
                } else {
                    backupImageView.setImage(forSticker, (String) null, "webp", svgDrawable, tag2);
                }
            }
            scrollX++;
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        ImageLocation forSticker;
        super.onScrollChanged(i, i2, i3, i4);
        int iDp = AndroidUtilities.dp(52.0f);
        int i5 = i3 / iDp;
        int i6 = i / iDp;
        int iCeil = ((int) Math.ceil(getMeasuredWidth() / iDp)) + 1;
        int iMin = Math.min(this.tabsContainer.getChildCount(), Math.max(i5, i6) + iCeil);
        for (int iMax = Math.max(0, Math.min(i5, i6)); iMax < iMin; iMax++) {
            View childAt = this.tabsContainer.getChildAt(iMax);
            if (childAt != null) {
                Object tag = childAt.getTag();
                Object tag2 = childAt.getTag(R.id.parent_tag);
                TLRPC$Document tLRPC$Document = (TLRPC$Document) childAt.getTag(R.id.object_tag);
                boolean z = tag instanceof TLRPC$Document;
                if (z) {
                    forSticker = ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90), tLRPC$Document);
                } else if (tag instanceof TLRPC$PhotoSize) {
                    forSticker = ImageLocation.getForSticker((TLRPC$PhotoSize) tag, tLRPC$Document);
                }
                if (forSticker != null) {
                    BackupImageView backupImageView = (BackupImageView) ((FrameLayout) childAt).getChildAt(0);
                    if (iMax < i6 || iMax >= i6 + iCeil) {
                        backupImageView.setImageDrawable(null);
                    } else if (z && MessageObject.isAnimatedStickerDocument(tLRPC$Document, true)) {
                        backupImageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "30_30", forSticker, (String) null, 0, tag2);
                    } else if (forSticker.imageType == 1) {
                        backupImageView.setImage(forSticker, "30_30", "tgs", (Drawable) null, tag2);
                    } else {
                        backupImageView.setImage(forSticker, (String) null, "webp", (Drawable) null, tag2);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int measuredWidth;
        super.onDraw(canvas);
        if (isInEditMode() || this.tabCount == 0) {
            return;
        }
        int height = getHeight();
        if (this.underlineHeight > 0) {
            this.rectPaint.setColor(this.underlineColor);
            canvas.drawRect(0.0f, height - this.underlineHeight, this.tabsContainer.getWidth(), height, this.rectPaint);
        }
        if (this.indicatorHeight >= 0) {
            View childAt = this.tabsContainer.getChildAt(this.currentPosition);
            float interpolation = 0.0f;
            if (childAt != null) {
                interpolation = childAt.getLeft();
                measuredWidth = childAt.getMeasuredWidth();
            } else {
                measuredWidth = 0;
            }
            if (this.animateFromPosition) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime - this.lastAnimationTime;
                this.lastAnimationTime = jElapsedRealtime;
                float f = this.positionAnimationProgress + (j / 150.0f);
                this.positionAnimationProgress = f;
                if (f >= 1.0f) {
                    this.positionAnimationProgress = 1.0f;
                    this.animateFromPosition = false;
                }
                float f2 = this.startAnimationPosition;
                interpolation = ((interpolation - f2) * CubicBezierInterpolator.EASE_OUT_QUINT.getInterpolation(this.positionAnimationProgress)) + f2;
                invalidate();
            }
            int i = AnonymousClass2.$SwitchMap$org$rbmain$ui$Components$ScrollSlidingTabStrip$Type[this.type.ordinal()];
            if (i == 1) {
                int i2 = this.indicatorHeight;
                if (i2 == 0) {
                    int i3 = (int) interpolation;
                    this.indicatorDrawable.setBounds(i3, 0, measuredWidth + i3, height);
                } else {
                    int i4 = (int) interpolation;
                    this.indicatorDrawable.setBounds(i4, height - i2, measuredWidth + i4, height);
                }
            } else if (i == 2) {
                int i5 = (int) interpolation;
                this.indicatorDrawable.setBounds(AndroidUtilities.dp(6.0f) + i5, height - AndroidUtilities.dp(3.0f), (i5 + measuredWidth) - AndroidUtilities.dp(6.0f), height);
            }
            this.indicatorDrawable.setColor(this.indicatorColor);
            this.indicatorDrawable.draw(canvas);
        }
    }

    public void setShouldExpand(boolean z) {
        this.shouldExpand = z;
        requestLayout();
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void onPageScrolled(int i, int i2) {
        int i3 = this.currentPosition;
        if (i3 == i) {
            return;
        }
        if (this.tabsContainer.getChildAt(i3) != null) {
            this.startAnimationPosition = r0.getLeft();
            this.positionAnimationProgress = 0.0f;
            this.animateFromPosition = true;
            this.lastAnimationTime = SystemClock.elapsedRealtime();
        } else {
            this.animateFromPosition = false;
        }
        this.currentPosition = i;
        if (i >= this.tabsContainer.getChildCount()) {
            return;
        }
        this.positionAnimationProgress = 0.0f;
        int i4 = 0;
        while (i4 < this.tabsContainer.getChildCount()) {
            this.tabsContainer.getChildAt(i4).setSelected(i4 == i);
            i4++;
        }
        if (i2 == i && i > 1) {
            scrollToChild(i - 1);
        } else {
            scrollToChild(i);
        }
        invalidate();
    }

    public void invalidateTabs() {
        int childCount = this.tabsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.tabsContainer.getChildAt(i).invalidate();
        }
    }

    public void setCurrentPosition(int i) {
        this.currentPosition = i;
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.indicatorColor = i;
        invalidate();
    }

    public void setUnderlineColor(int i) {
        this.underlineColor = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.underlineColor = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.underlineHeight = i;
        invalidate();
    }
}
