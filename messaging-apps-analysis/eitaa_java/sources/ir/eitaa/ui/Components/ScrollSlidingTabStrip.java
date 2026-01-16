package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DocumentObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class ScrollSlidingTabStrip extends HorizontalScrollView {
    private boolean animateFromPosition;
    boolean animateToExpanded;
    int currentDragPosition;
    SparseArray<StickerTabView> currentPlayingImages;
    SparseArray<StickerTabView> currentPlayingImagesTmp;
    private int currentPosition;
    private LinearLayout.LayoutParams defaultExpandLayoutParams;
    private LinearLayout.LayoutParams defaultTabLayoutParams;
    private ScrollSlidingTabStripDelegate delegate;
    private int dividerPadding;
    float dragDx;
    private boolean dragEnabled;
    float draggindViewDxOnScreen;
    float draggindViewXOnScreen;
    View draggingView;
    float draggingViewIndicatorOutProgress;
    float draggingViewOutProgress;
    private float expandOffset;
    float expandProgress;
    ValueAnimator expandStickerAnimator;
    boolean expanded;
    private SparseArray<View> futureTabsPositions;
    private int indicatorColor;
    private GradientDrawable indicatorDrawable;
    private int indicatorHeight;
    private long lastAnimationTime;
    private int lastScrollX;
    Runnable longClickRunnable;
    boolean longClickRunning;
    private float positionAnimationProgress;
    float pressedX;
    float pressedY;
    private HashMap<String, View> prevTypes;
    private Paint rectPaint;
    private final Theme.ResourcesProvider resourcesProvider;
    private int scrollByOnNextMeasure;
    private int scrollOffset;
    boolean scrollRight;
    Runnable scrollRunnable;
    long scrollStartTime;
    private boolean shouldExpand;
    private float startAnimationPosition;
    int startDragFromPosition;
    float startDragFromX;
    private float stickerTabExpandedWidth;
    private float stickerTabWidth;
    private int tabCount;
    private int tabPadding;
    private HashMap<String, View> tabTypes;
    private LinearLayout tabsContainer;
    private float touchSlop;
    private Type type;
    private int underlineColor;
    private int underlineHeight;

    public interface ScrollSlidingTabStripDelegate {
        void onPageSelected(int page);
    }

    public enum Type {
        LINE,
        TAB
    }

    protected void invalidateOverlays() {
    }

    protected void stickerSetPositionChanged(int fromPosition, int toPosition) {
    }

    protected void updatePosition() {
    }

    public ScrollSlidingTabStrip(Context context, Theme.ResourcesProvider resourcesProvider) {
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
        this.dividerPadding = AndroidUtilities.dp(12.0f);
        this.tabPadding = AndroidUtilities.dp(24.0f);
        this.lastScrollX = 0;
        this.currentPlayingImages = new SparseArray<>();
        this.currentPlayingImagesTmp = new SparseArray<>();
        this.longClickRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ScrollSlidingTabStrip.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollSlidingTabStrip scrollSlidingTabStrip = ScrollSlidingTabStrip.this;
                scrollSlidingTabStrip.longClickRunning = false;
                float scrollX = scrollSlidingTabStrip.getScrollX();
                ScrollSlidingTabStrip scrollSlidingTabStrip2 = ScrollSlidingTabStrip.this;
                scrollSlidingTabStrip.startDragFromX = scrollX + scrollSlidingTabStrip2.pressedX;
                scrollSlidingTabStrip2.dragDx = 0.0f;
                int iCeil = ((int) Math.ceil(scrollSlidingTabStrip2.startDragFromX / scrollSlidingTabStrip2.getTabSize())) - 1;
                ScrollSlidingTabStrip scrollSlidingTabStrip3 = ScrollSlidingTabStrip.this;
                scrollSlidingTabStrip3.currentDragPosition = iCeil;
                scrollSlidingTabStrip3.startDragFromPosition = iCeil;
                if (scrollSlidingTabStrip3.canSwap(iCeil) && iCeil >= 0 && iCeil < ScrollSlidingTabStrip.this.tabsContainer.getChildCount()) {
                    ScrollSlidingTabStrip.this.performHapticFeedback(0);
                    ScrollSlidingTabStrip scrollSlidingTabStrip4 = ScrollSlidingTabStrip.this;
                    scrollSlidingTabStrip4.draggindViewDxOnScreen = 0.0f;
                    scrollSlidingTabStrip4.draggingViewOutProgress = 0.0f;
                    scrollSlidingTabStrip4.draggingView = scrollSlidingTabStrip4.tabsContainer.getChildAt(iCeil);
                    ScrollSlidingTabStrip scrollSlidingTabStrip5 = ScrollSlidingTabStrip.this;
                    scrollSlidingTabStrip5.draggindViewXOnScreen = scrollSlidingTabStrip5.draggingView.getX() - ScrollSlidingTabStrip.this.getScrollX();
                    ScrollSlidingTabStrip.this.draggingView.invalidate();
                    ScrollSlidingTabStrip.this.tabsContainer.invalidate();
                    ScrollSlidingTabStrip.this.invalidateOverlays();
                    ScrollSlidingTabStrip.this.invalidate();
                }
            }
        };
        this.expanded = false;
        this.stickerTabExpandedWidth = AndroidUtilities.dp(86.0f);
        this.stickerTabWidth = AndroidUtilities.dp(52.0f);
        this.scrollByOnNextMeasure = -1;
        this.scrollRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ScrollSlidingTabStrip.6
            /* JADX WARN: Removed duplicated region for block: B:6:0x0021 A[PHI: r0
              0x0021: PHI (r0v12 int) = (r0v4 int), (r0v7 int), (r0v15 int) binds: [B:14:0x004a, B:11:0x0039, B:5:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r7 = this;
                    long r0 = java.lang.System.currentTimeMillis()
                    ir.eitaa.ui.Components.ScrollSlidingTabStrip r2 = ir.eitaa.ui.Components.ScrollSlidingTabStrip.this
                    long r2 = r2.scrollStartTime
                    long r0 = r0 - r2
                    r2 = -1
                    r3 = 1
                    r4 = 3000(0xbb8, double:1.482E-320)
                    int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r6 >= 0) goto L25
                    r0 = 1065353216(0x3f800000, float:1.0)
                    int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
                    int r0 = java.lang.Math.max(r3, r0)
                    ir.eitaa.ui.Components.ScrollSlidingTabStrip r1 = ir.eitaa.ui.Components.ScrollSlidingTabStrip.this
                    boolean r1 = r1.scrollRight
                    if (r1 == 0) goto L22
                L21:
                    r2 = 1
                L22:
                    int r0 = r0 * r2
                    goto L4d
                L25:
                    r4 = 5000(0x1388, double:2.4703E-320)
                    int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                    if (r6 >= 0) goto L3c
                    r0 = 1073741824(0x40000000, float:2.0)
                    int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
                    int r0 = java.lang.Math.max(r3, r0)
                    ir.eitaa.ui.Components.ScrollSlidingTabStrip r1 = ir.eitaa.ui.Components.ScrollSlidingTabStrip.this
                    boolean r1 = r1.scrollRight
                    if (r1 == 0) goto L22
                    goto L21
                L3c:
                    r0 = 1082130432(0x40800000, float:4.0)
                    int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
                    int r0 = java.lang.Math.max(r3, r0)
                    ir.eitaa.ui.Components.ScrollSlidingTabStrip r1 = ir.eitaa.ui.Components.ScrollSlidingTabStrip.this
                    boolean r1 = r1.scrollRight
                    if (r1 == 0) goto L22
                    goto L21
                L4d:
                    ir.eitaa.ui.Components.ScrollSlidingTabStrip r1 = ir.eitaa.ui.Components.ScrollSlidingTabStrip.this
                    r2 = 0
                    r1.scrollBy(r0, r2)
                    ir.eitaa.ui.Components.ScrollSlidingTabStrip r0 = ir.eitaa.ui.Components.ScrollSlidingTabStrip.this
                    java.lang.Runnable r0 = r0.scrollRunnable
                    ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ScrollSlidingTabStrip.AnonymousClass6.run():void");
            }
        };
        this.resourcesProvider = resourcesProvider;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.eitaa.ui.Components.ScrollSlidingTabStrip.2
            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (child instanceof StickerTabView) {
                    ((StickerTabView) child).updateExpandProgress(ScrollSlidingTabStrip.this.expandProgress);
                }
                if (child == ScrollSlidingTabStrip.this.draggingView) {
                    return true;
                }
                return super.drawChild(canvas, child, drawingTime);
            }
        };
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
        int i = AnonymousClass7.$SwitchMap$ir$eitaa$ui$Components$ScrollSlidingTabStrip$Type[type.ordinal()];
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

    /* renamed from: ir.eitaa.ui.Components.ScrollSlidingTabStrip$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$ir$eitaa$ui$Components$ScrollSlidingTabStrip$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$ir$eitaa$ui$Components$ScrollSlidingTabStrip$Type = iArr;
            try {
                iArr[Type.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$eitaa$ui$Components$ScrollSlidingTabStrip$Type[Type.TAB.ordinal()] = 2;
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

    public void beginUpdate(boolean animated) {
        this.prevTypes = this.tabTypes;
        this.tabTypes = new HashMap<>();
        this.futureTabsPositions.clear();
        this.tabCount = 0;
        if (!animated || Build.VERSION.SDK_INT < 19) {
            return;
        }
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(250L);
        autoTransition.setOrdering(0);
        autoTransition.addTransition(new AnonymousClass3());
        TransitionManager.beginDelayedTransition(this.tabsContainer, autoTransition);
    }

    /* renamed from: ir.eitaa.ui.Components.ScrollSlidingTabStrip$3, reason: invalid class name */
    class AnonymousClass3 extends Transition {
        @Override // android.transition.Transition
        public void captureEndValues(TransitionValues transitionValues) {
        }

        @Override // android.transition.Transition
        public void captureStartValues(TransitionValues transitionValues) {
        }

        AnonymousClass3() {
        }

        @Override // android.transition.Transition
        public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ScrollSlidingTabStrip$3$xfasG2vvWqgQD7-s58zN73vLRzc
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createAnimator$0$ScrollSlidingTabStrip$3(valueAnimator);
                }
            });
            return valueAnimatorOfFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$createAnimator$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$createAnimator$0$ScrollSlidingTabStrip$3(ValueAnimator valueAnimator) {
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

    public void selectTab(int num) {
        if (num < 0 || num >= this.tabCount) {
            return;
        }
        this.tabsContainer.getChildAt(num).performClick();
    }

    private void checkViewIndex(String key, View view, int index) {
        HashMap<String, View> map = this.prevTypes;
        if (map != null) {
            map.remove(key);
        }
        this.futureTabsPositions.put(index, view);
    }

    public ImageView addIconTab(int id, Drawable drawable) {
        String str = "tab" + id;
        int i = this.tabCount;
        this.tabCount = i + 1;
        ImageView imageView = (ImageView) this.prevTypes.get(str);
        if (imageView != null) {
            checkViewIndex(str, imageView, i);
        } else {
            imageView = new ImageView(getContext());
            imageView.setFocusable(true);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ScrollSlidingTabStrip$XZfyRc1x1phRSESIADIq268KYnc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addIconTab$1$ScrollSlidingTabStrip(view);
                }
            });
            this.tabsContainer.addView(imageView, i);
        }
        imageView.setTag(R.id.index_tag, Integer.valueOf(i));
        imageView.setSelected(i == this.currentPosition);
        this.tabTypes.put(str, imageView);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addIconTab$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addIconTab$1$ScrollSlidingTabStrip(View view) {
        this.delegate.onPageSelected(((Integer) view.getTag(R.id.index_tag)).intValue());
    }

    public StickerTabView addStickerIconTab(int id, Drawable drawable) {
        String str = "tab" + id;
        int i = this.tabCount;
        this.tabCount = i + 1;
        StickerTabView stickerTabView = (StickerTabView) this.prevTypes.get(str);
        if (stickerTabView != null) {
            checkViewIndex(str, stickerTabView, i);
        } else {
            stickerTabView = new StickerTabView(getContext(), 1);
            stickerTabView.iconView.setImageDrawable(drawable);
            stickerTabView.setFocusable(true);
            stickerTabView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ScrollSlidingTabStrip$9Uc2IjE1NwbjyJDVWw2r3vC0dRc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addStickerIconTab$2$ScrollSlidingTabStrip(view);
                }
            });
            stickerTabView.setExpanded(this.expanded);
            stickerTabView.updateExpandProgress(this.expandProgress);
            this.tabsContainer.addView(stickerTabView, i);
        }
        stickerTabView.isChatSticker = false;
        stickerTabView.setTag(R.id.index_tag, Integer.valueOf(i));
        stickerTabView.setSelected(i == this.currentPosition);
        this.tabTypes.put(str, stickerTabView);
        return stickerTabView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addStickerIconTab$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addStickerIconTab$2$ScrollSlidingTabStrip(View view) {
        this.delegate.onPageSelected(((Integer) view.getTag(R.id.index_tag)).intValue());
    }

    public void addStickerTab(TLRPC$Chat chat) {
        String str = "chat" + chat.id;
        int i = this.tabCount;
        this.tabCount = i + 1;
        StickerTabView stickerTabView = (StickerTabView) this.prevTypes.get(str);
        if (stickerTabView != null) {
            checkViewIndex(str, stickerTabView, i);
        } else {
            stickerTabView = new StickerTabView(getContext(), 0);
            stickerTabView.setFocusable(true);
            stickerTabView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ScrollSlidingTabStrip$_y8QQm23H0Z2yDIr9GCpbBo0wEo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addStickerTab$3$ScrollSlidingTabStrip(view);
                }
            });
            this.tabsContainer.addView(stickerTabView, i);
            stickerTabView.setRoundImage();
            AvatarDrawable avatarDrawable = new AvatarDrawable();
            avatarDrawable.setTextSize(AndroidUtilities.dp(14.0f));
            avatarDrawable.setInfo(chat);
            BackupImageView backupImageView = stickerTabView.imageView;
            backupImageView.setLayerNum(1);
            backupImageView.setForUserOrChat(chat, avatarDrawable);
            backupImageView.setAspectFit(true);
            stickerTabView.setExpanded(this.expanded);
            stickerTabView.updateExpandProgress(this.expandProgress);
            stickerTabView.textView.setText(chat.title);
        }
        stickerTabView.isChatSticker = true;
        stickerTabView.setTag(R.id.index_tag, Integer.valueOf(i));
        stickerTabView.setSelected(i == this.currentPosition);
        this.tabTypes.put(str, stickerTabView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addStickerTab$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addStickerTab$3$ScrollSlidingTabStrip(View view) {
        this.delegate.onPageSelected(((Integer) view.getTag(R.id.index_tag)).intValue());
    }

    public View addStickerTab(TLObject thumb, TLRPC$Document sticker, TLRPC$TL_messages_stickerSet parentObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("set");
        sb.append(parentObject == null ? sticker.id : parentObject.set.id);
        String string = sb.toString();
        int i = this.tabCount;
        this.tabCount = i + 1;
        StickerTabView stickerTabView = (StickerTabView) this.prevTypes.get(string);
        if (stickerTabView != null) {
            checkViewIndex(string, stickerTabView, i);
        } else {
            stickerTabView = new StickerTabView(getContext(), 0);
            stickerTabView.setFocusable(true);
            stickerTabView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ScrollSlidingTabStrip$-r3vHnYFQa_LmCo0_9UDjBnZLOw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$addStickerTab$5$ScrollSlidingTabStrip(view);
                }
            });
            stickerTabView.setExpanded(this.expanded);
            stickerTabView.updateExpandProgress(this.expandProgress);
            this.tabsContainer.addView(stickerTabView, i);
        }
        stickerTabView.isChatSticker = false;
        stickerTabView.setTag(thumb);
        stickerTabView.setTag(R.id.index_tag, Integer.valueOf(i));
        stickerTabView.setTag(R.id.parent_tag, parentObject);
        stickerTabView.setTag(R.id.object_tag, sticker);
        stickerTabView.setSelected(i == this.currentPosition);
        this.tabTypes.put(string, stickerTabView);
        return stickerTabView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addStickerTab$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addStickerTab$5$ScrollSlidingTabStrip(View view) {
        this.delegate.onPageSelected(((Integer) view.getTag(R.id.index_tag)).intValue());
    }

    public void expandStickers(final float x, final boolean expanded) {
        if (this.expanded != expanded) {
            this.expanded = expanded;
            if (!expanded) {
                fling(0);
            }
            ValueAnimator valueAnimator = this.expandStickerAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.expandStickerAnimator.cancel();
            }
            float[] fArr = new float[2];
            fArr[0] = this.expandProgress;
            fArr[1] = expanded ? 1.0f : 0.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            this.expandStickerAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ScrollSlidingTabStrip$k2nCiK8S9kGLlRV3NrdLaV3_wzg
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$expandStickers$6$ScrollSlidingTabStrip(expanded, x, valueAnimator2);
                }
            });
            this.expandStickerAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ScrollSlidingTabStrip.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ScrollSlidingTabStrip scrollSlidingTabStrip = ScrollSlidingTabStrip.this;
                    scrollSlidingTabStrip.expandStickerAnimator = null;
                    scrollSlidingTabStrip.expandProgress = expanded ? 1.0f : 0.0f;
                    for (int i = 0; i < ScrollSlidingTabStrip.this.tabsContainer.getChildCount(); i++) {
                        ScrollSlidingTabStrip.this.tabsContainer.getChildAt(i).invalidate();
                    }
                    ScrollSlidingTabStrip.this.tabsContainer.invalidate();
                    ScrollSlidingTabStrip.this.updatePosition();
                    if (expanded) {
                        return;
                    }
                    float childCount = ScrollSlidingTabStrip.this.stickerTabWidth * ScrollSlidingTabStrip.this.tabsContainer.getChildCount();
                    float scrollX = (ScrollSlidingTabStrip.this.getScrollX() + x) / (ScrollSlidingTabStrip.this.stickerTabExpandedWidth * ScrollSlidingTabStrip.this.tabsContainer.getChildCount());
                    float measuredWidth = (childCount - ScrollSlidingTabStrip.this.getMeasuredWidth()) / childCount;
                    float f = x;
                    if (scrollX > measuredWidth) {
                        scrollX = measuredWidth;
                        f = 0.0f;
                    }
                    float f2 = childCount * scrollX;
                    if (f2 - f < 0.0f) {
                        f2 = f;
                    }
                    ScrollSlidingTabStrip.this.expandOffset = (r1.getScrollX() + f) - f2;
                    ScrollSlidingTabStrip.this.scrollByOnNextMeasure = (int) (f2 - f);
                    if (ScrollSlidingTabStrip.this.scrollByOnNextMeasure < 0) {
                        ScrollSlidingTabStrip.this.scrollByOnNextMeasure = 0;
                    }
                    for (int i2 = 0; i2 < ScrollSlidingTabStrip.this.tabsContainer.getChildCount(); i2++) {
                        View childAt = ScrollSlidingTabStrip.this.tabsContainer.getChildAt(i2);
                        if (childAt instanceof StickerTabView) {
                            ((StickerTabView) childAt).setExpanded(false);
                        }
                        childAt.getLayoutParams().width = AndroidUtilities.dp(52.0f);
                    }
                    ScrollSlidingTabStrip scrollSlidingTabStrip2 = ScrollSlidingTabStrip.this;
                    scrollSlidingTabStrip2.animateToExpanded = false;
                    scrollSlidingTabStrip2.getLayoutParams().height = AndroidUtilities.dp(48.0f);
                    ScrollSlidingTabStrip.this.tabsContainer.requestLayout();
                }
            });
            this.expandStickerAnimator.start();
            if (expanded) {
                this.animateToExpanded = true;
                for (int i = 0; i < this.tabsContainer.getChildCount(); i++) {
                    View childAt = this.tabsContainer.getChildAt(i);
                    if (childAt instanceof StickerTabView) {
                        ((StickerTabView) childAt).setExpanded(true);
                    }
                    childAt.getLayoutParams().width = AndroidUtilities.dp(86.0f);
                }
                this.tabsContainer.requestLayout();
                getLayoutParams().height = AndroidUtilities.dp(98.0f);
            }
            if (expanded) {
                float childCount = this.stickerTabExpandedWidth * this.tabsContainer.getChildCount() * ((getScrollX() + x) / (this.stickerTabWidth * this.tabsContainer.getChildCount()));
                this.expandOffset = childCount - (getScrollX() + x);
                this.scrollByOnNextMeasure = (int) (childCount - x);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$expandStickers$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$expandStickers$6$ScrollSlidingTabStrip(boolean z, float f, ValueAnimator valueAnimator) {
        if (!z) {
            float childCount = this.stickerTabWidth * this.tabsContainer.getChildCount();
            float scrollX = (getScrollX() + f) / (this.stickerTabExpandedWidth * this.tabsContainer.getChildCount());
            float measuredWidth = (childCount - getMeasuredWidth()) / childCount;
            if (scrollX > measuredWidth) {
                scrollX = measuredWidth;
                f = 0.0f;
            }
            float f2 = childCount * scrollX;
            if (f2 - f < 0.0f) {
                f2 = f;
            }
            this.expandOffset = (getScrollX() + f) - f2;
        }
        this.expandProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (int i = 0; i < this.tabsContainer.getChildCount(); i++) {
            this.tabsContainer.getChildAt(i).invalidate();
        }
        this.tabsContainer.invalidate();
        updatePosition();
    }

    public float getExpandedOffset() {
        if (this.animateToExpanded) {
            return AndroidUtilities.dp(50.0f) * this.expandProgress;
        }
        return 0.0f;
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

    private void scrollToChild(int position) {
        if (this.tabCount == 0 || this.tabsContainer.getChildAt(position) == null) {
            return;
        }
        int left = this.tabsContainer.getChildAt(position).getLeft();
        if (position > 0) {
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
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        setImages();
        int i = this.scrollByOnNextMeasure;
        if (i >= 0) {
            scrollTo(i, 0);
            this.scrollByOnNextMeasure = -1;
        }
    }

    public void setImages() {
        ImageLocation forSticker;
        float fDp = AndroidUtilities.dp(52.0f);
        float fDp2 = AndroidUtilities.dp(34.0f);
        float f = this.expandProgress;
        int scrollX = (int) ((getScrollX() - (this.animateToExpanded ? this.expandOffset * (1.0f - f) : 0.0f)) / (fDp + (fDp2 * f)));
        int iMin = Math.min(this.tabsContainer.getChildCount(), ((int) Math.ceil(getMeasuredWidth() / r1)) + scrollX + 1);
        if (this.animateToExpanded) {
            scrollX -= 2;
            iMin += 2;
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (iMin > this.tabsContainer.getChildCount()) {
                iMin = this.tabsContainer.getChildCount();
            }
        }
        this.currentPlayingImagesTmp.clear();
        for (int i = 0; i < this.currentPlayingImages.size(); i++) {
            this.currentPlayingImagesTmp.put(this.currentPlayingImages.valueAt(i).index, this.currentPlayingImages.valueAt(i));
        }
        this.currentPlayingImages.clear();
        while (true) {
            if (scrollX >= iMin) {
                break;
            }
            View childAt = this.tabsContainer.getChildAt(scrollX);
            if (childAt instanceof StickerTabView) {
                StickerTabView stickerTabView = (StickerTabView) childAt;
                if (stickerTabView.type == 2) {
                    Object tag = stickerTabView.getTag(R.id.parent_tag);
                    Object tag2 = stickerTabView.getTag(R.id.object_tag);
                    Drawable drawable = tag instanceof Drawable ? (Drawable) tag : null;
                    if (tag2 instanceof TLRPC$Document) {
                        stickerTabView.imageView.setImage(ImageLocation.getForDocument((TLRPC$Document) tag2), "36_36", drawable, (Object) null);
                    } else {
                        stickerTabView.imageView.setImageDrawable(drawable);
                    }
                } else {
                    Object tag3 = childAt.getTag();
                    Object tag4 = childAt.getTag(R.id.parent_tag);
                    TLRPC$Document tLRPC$Document = (TLRPC$Document) childAt.getTag(R.id.object_tag);
                    boolean z = tag3 instanceof TLRPC$Document;
                    if (z) {
                        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90);
                        if (!stickerTabView.inited) {
                            stickerTabView.svgThumb = DocumentObject.getSvgThumb((TLRPC$Document) tag3, "emptyListPlaceholder", 0.2f);
                        }
                        forSticker = ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$Document);
                    } else if (tag3 instanceof TLRPC$PhotoSize) {
                        forSticker = ImageLocation.getForSticker((TLRPC$PhotoSize) tag3, tLRPC$Document, tag4 instanceof TLRPC$TL_messages_stickerSet ? ((TLRPC$TL_messages_stickerSet) tag4).set.thumb_version : 0);
                    }
                    if (forSticker != null) {
                        stickerTabView.inited = true;
                        SvgHelper.SvgDrawable svgDrawable = stickerTabView.svgThumb;
                        BackupImageView backupImageView = stickerTabView.imageView;
                        if (z && MessageObject.isAnimatedStickerDocument(tLRPC$Document, true)) {
                            if (svgDrawable != null) {
                                backupImageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "40_40", svgDrawable, 0, tag4);
                            } else {
                                backupImageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "40_40", forSticker, (String) null, 0, tag4);
                            }
                        } else if (forSticker.imageType == 1) {
                            backupImageView.setImage(forSticker, "40_40", "tgs", svgDrawable, tag4);
                        } else {
                            backupImageView.setImage(forSticker, (String) null, "webp", svgDrawable, tag4);
                        }
                        stickerTabView.textView.setText(tag4 instanceof TLRPC$TL_messages_stickerSet ? ((TLRPC$TL_messages_stickerSet) tag4).set.title : null);
                    }
                }
                this.currentPlayingImages.put(stickerTabView.index, stickerTabView);
                this.currentPlayingImagesTmp.remove(stickerTabView.index);
            }
            scrollX++;
        }
        for (int i2 = 0; i2 < this.currentPlayingImagesTmp.size(); i2++) {
            if (this.currentPlayingImagesTmp.valueAt(i2) != this.draggingView) {
                this.currentPlayingImagesTmp.valueAt(i2).imageView.setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTabSize() {
        return AndroidUtilities.dp(this.animateToExpanded ? 86.0f : 52.0f);
    }

    @Override // android.view.View
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        setImages();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0109  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void dispatchDraw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ScrollSlidingTabStrip.dispatchDraw(android.graphics.Canvas):void");
    }

    public void drawOverlays(Canvas canvas) {
        if (this.draggingView != null) {
            canvas.save();
            float x = this.draggindViewXOnScreen - this.draggindViewDxOnScreen;
            float f = this.draggingViewOutProgress;
            if (f > 0.0f) {
                x = (x * (1.0f - f)) + ((this.draggingView.getX() - getScrollX()) * this.draggingViewOutProgress);
            }
            canvas.translate(x, 0.0f);
            this.draggingView.draw(canvas);
            canvas.restore();
        }
    }

    public void setShouldExpand(boolean value) {
        this.shouldExpand = value;
        requestLayout();
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void onPageScrolled(int position, int first) {
        int i = this.currentPosition;
        if (i == position) {
            return;
        }
        if (this.tabsContainer.getChildAt(i) != null) {
            this.startAnimationPosition = r0.getLeft();
            this.positionAnimationProgress = 0.0f;
            this.animateFromPosition = true;
            this.lastAnimationTime = SystemClock.elapsedRealtime();
        } else {
            this.animateFromPosition = false;
        }
        this.currentPosition = position;
        if (position >= this.tabsContainer.getChildCount()) {
            return;
        }
        this.positionAnimationProgress = 0.0f;
        int i2 = 0;
        while (i2 < this.tabsContainer.getChildCount()) {
            this.tabsContainer.getChildAt(i2).setSelected(i2 == position);
            i2++;
        }
        if (this.expandStickerAnimator == null) {
            if (first == position && position > 1) {
                scrollToChild(position - 1);
            } else {
                scrollToChild(position);
            }
        }
        invalidate();
    }

    public void invalidateTabs() {
        int childCount = this.tabsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.tabsContainer.getChildAt(i).invalidate();
        }
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setIndicatorHeight(int value) {
        this.indicatorHeight = value;
        invalidate();
    }

    public void setIndicatorColor(int value) {
        this.indicatorColor = value;
        invalidate();
    }

    public void setUnderlineColor(int value) {
        this.underlineColor = value;
        invalidate();
    }

    public void setUnderlineColorResource(int resId) {
        this.underlineColor = getResources().getColor(resId);
        invalidate();
    }

    public void setUnderlineHeight(int value) {
        this.underlineHeight = value;
        invalidate();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return checkLongPress(ev) || super.onInterceptTouchEvent(ev);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        return checkLongPress(ev) || super.onTouchEvent(ev);
    }

    public boolean checkLongPress(MotionEvent ev) {
        if (ev.getAction() == 0 && this.draggingView == null) {
            this.longClickRunning = true;
            AndroidUtilities.runOnUIThread(this.longClickRunnable, 500L);
            this.pressedX = ev.getX();
            this.pressedY = ev.getY();
        }
        if (this.longClickRunning && ev.getAction() == 2 && (Math.abs(ev.getX() - this.pressedX) > this.touchSlop || Math.abs(ev.getY() - this.pressedY) > this.touchSlop)) {
            this.longClickRunning = false;
            AndroidUtilities.cancelRunOnUIThread(this.longClickRunnable);
        }
        if (ev.getAction() == 2 && this.draggingView != null) {
            float scrollX = getScrollX() + ev.getX();
            int iCeil = ((int) Math.ceil(scrollX / getTabSize())) - 1;
            int i = this.currentDragPosition;
            if (iCeil != i) {
                if (iCeil < i) {
                    while (!canSwap(iCeil) && iCeil != this.currentDragPosition) {
                        iCeil++;
                    }
                } else {
                    while (!canSwap(iCeil) && iCeil != this.currentDragPosition) {
                        iCeil--;
                    }
                }
            }
            if (this.currentDragPosition != iCeil && canSwap(iCeil)) {
                for (int i2 = 0; i2 < this.tabsContainer.getChildCount(); i2++) {
                    if (i2 != this.currentDragPosition) {
                        ((StickerTabView) this.tabsContainer.getChildAt(i2)).saveXPosition();
                    }
                }
                this.startDragFromX += (iCeil - this.currentDragPosition) * getTabSize();
                this.currentDragPosition = iCeil;
                this.tabsContainer.removeView(this.draggingView);
                this.tabsContainer.addView(this.draggingView, this.currentDragPosition);
                invalidate();
            }
            this.dragDx = scrollX - this.startDragFromX;
            this.draggindViewDxOnScreen = this.pressedX - ev.getX();
            float x = ev.getX();
            if (x < this.draggingView.getMeasuredWidth() / 2.0f) {
                startScroll(false);
            } else if (x > getMeasuredWidth() - (this.draggingView.getMeasuredWidth() / 2.0f)) {
                startScroll(true);
            } else {
                stopScroll();
            }
            this.tabsContainer.invalidate();
            invalidateOverlays();
            return true;
        }
        if (ev.getAction() == 1 || ev.getAction() == 3) {
            stopScroll();
            AndroidUtilities.cancelRunOnUIThread(this.longClickRunnable);
            if (this.draggingView != null) {
                int i3 = this.startDragFromPosition;
                int i4 = this.currentDragPosition;
                if (i3 != i4) {
                    stickerSetPositionChanged(i3, i4);
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ScrollSlidingTabStrip$nntjQzcPeO4RfKIdP8ixjokkS0Y
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$checkLongPress$7$ScrollSlidingTabStrip(valueAnimator);
                    }
                });
                valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ScrollSlidingTabStrip.5
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ScrollSlidingTabStrip scrollSlidingTabStrip = ScrollSlidingTabStrip.this;
                        if (scrollSlidingTabStrip.draggingView != null) {
                            scrollSlidingTabStrip.invalidateOverlays();
                            ScrollSlidingTabStrip.this.draggingView.invalidate();
                            ScrollSlidingTabStrip.this.tabsContainer.invalidate();
                            ScrollSlidingTabStrip.this.invalidate();
                            ScrollSlidingTabStrip.this.draggingView = null;
                        }
                    }
                });
                valueAnimatorOfFloat.start();
            }
            this.longClickRunning = false;
            invalidateOverlays();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkLongPress$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkLongPress$7$ScrollSlidingTabStrip(ValueAnimator valueAnimator) {
        this.draggingViewOutProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidateOverlays();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canSwap(int p) {
        if (this.dragEnabled && p >= 0 && p < this.tabsContainer.getChildCount()) {
            View childAt = this.tabsContainer.getChildAt(p);
            if (childAt instanceof StickerTabView) {
                StickerTabView stickerTabView = (StickerTabView) childAt;
                if (stickerTabView.type == 0 && !stickerTabView.isChatSticker) {
                    return true;
                }
            }
        }
        return false;
    }

    private void startScroll(boolean scrollRight) {
        this.scrollRight = scrollRight;
        if (this.scrollStartTime <= 0) {
            this.scrollStartTime = System.currentTimeMillis();
        }
        AndroidUtilities.runOnUIThread(this.scrollRunnable, 16L);
    }

    private void stopScroll() {
        this.scrollStartTime = -1L;
        AndroidUtilities.cancelRunOnUIThread(this.scrollRunnable);
    }

    boolean isDragging() {
        return this.draggingView != null;
    }

    @Override // android.view.View
    public void cancelLongPress() {
        super.cancelLongPress();
        this.longClickRunning = false;
        AndroidUtilities.cancelRunOnUIThread(this.longClickRunnable);
    }

    public void setDragEnabled(boolean enabled) {
        this.dragEnabled = enabled;
    }
}
