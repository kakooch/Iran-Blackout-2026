package ir.resaneh1.iptv.story;

import android.R;
import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.facebook.stetho.websocket.CloseCodes;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class ExtraView extends FrameLayout {
    private int animDuration;
    private boolean draggingEmoji;
    private float emojiAnimY;
    private List<Float> emojiFadeCurrentX;
    private AccelerateInterpolator emojiFadeInterpolator;
    private int emojiInitialExtraY;
    private float emojiParentScale;
    private int emojiSize;
    private int emojiSizePx;
    private StaticLayout emojiStaticLayout;
    private TextPaint emojiTextPaint;
    private long emojiUpDownAnimationStartTime;
    private float emojiUpDownHeightAnim;
    private CycleInterpolator emojiUpDownInterpolator;
    private float emojiX;
    private float emojiY;
    private float emojiZoom;
    private List<Long> fadeEmojiAnimationStartTime;
    private FireworksOverlay fireworksOverlay;
    private int hintDuration;
    private HashMap<HintDetail, HintSticker> hintStickers;
    private List<DisposableObserver> observers;
    private boolean showFireworks;
    private List<Boolean> startEmojiAnimation;

    private float convertYToRealRang(float f, float f2) {
        return f2 * f;
    }

    public ExtraView(Context context) {
        super(context);
        this.hintDuration = 300;
        this.emojiFadeInterpolator = new AccelerateInterpolator();
        this.emojiUpDownInterpolator = new CycleInterpolator(0.5f);
        this.emojiUpDownHeightAnim = AndroidUtilities.dp(10.0f);
        this.emojiUpDownAnimationStartTime = 0L;
        this.animDuration = CloseCodes.NORMAL_CLOSURE;
        this.emojiSizePx = AndroidUtilities.dp(30.0f);
        this.emojiInitialExtraY = AndroidUtilities.dp(-25.0f);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.emojiParentScale = 1.0f;
        initEmojiSlider();
    }

    private void addHintView(HintDetail hintDetail) {
        if (this.hintStickers == null) {
            this.hintStickers = new HashMap<>();
        }
        HintSticker hintSticker = new HintSticker(getContext(), hintDetail.isPointerTop());
        hintSticker.setText(hintDetail.getHintText());
        hintSticker.setAlpha(0.0f);
        hintSticker.setScaleX(0.0f);
        hintSticker.setScaleY(0.0f);
        hintSticker.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(new OvershootInterpolator()).setDuration(this.hintDuration).setListener(null);
        addView(hintSticker);
        this.hintStickers.put(hintDetail, hintSticker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideHintView(final HintDetail hintDetail) {
        HashMap<HintDetail, HintSticker> map = this.hintStickers;
        if (map == null || map.get(hintDetail) == null) {
            return;
        }
        this.hintStickers.get(hintDetail).animate().alpha(0.0f).scaleX(0.0f).scaleY(0.0f).setDuration(this.hintDuration).setListener(new Animator.AnimatorListener() { // from class: ir.resaneh1.iptv.story.ExtraView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ExtraView extraView = ExtraView.this;
                extraView.removeView((View) extraView.hintStickers.get(hintDetail));
            }
        });
    }

    public void initEmojiSlider() {
        this.emojiFadeCurrentX = new ArrayList();
        this.fadeEmojiAnimationStartTime = new ArrayList();
        this.startEmojiAnimation = new ArrayList();
        TextPaint textPaint = new TextPaint(1);
        this.emojiTextPaint = textPaint;
        textPaint.setTextSize(this.emojiSizePx);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        HashMap<HintDetail, HintSticker> map = this.hintStickers;
        if (map != null) {
            for (Map.Entry<HintDetail, HintSticker> entry : map.entrySet()) {
                HintSticker value = entry.getValue();
                HintDetail key = entry.getKey();
                value.measure(i, i2);
                value.setTranslationX(key.getHintX() - (value.getMeasuredWidth() / 2.0f));
                if (key.isPointerTop()) {
                    value.setTranslationY(key.getHintY() + key.getExtraDistance());
                } else {
                    value.setTranslationY((key.getHintY() + key.getExtraDistance()) - value.getMeasuredHeight());
                }
                value.setPivotX(value.getMeasuredWidth() / 2.0f);
                value.setPivotY(0.0f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getDeviceWidth(getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDeviceHeight(getContext()), 1073741824));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        updateDragAnimationIfNeeded(canvas);
        updateFadeAnimationIfNeeded(canvas);
        updateFireworksIfNeeded();
    }

    private void updateFireworksIfNeeded() {
        if (!this.showFireworks || this.fireworksOverlay.isStarted()) {
            return;
        }
        this.showFireworks = false;
        this.fireworksOverlay.start();
    }

    private void updateDragAnimationIfNeeded(Canvas canvas) {
        if (this.draggingEmoji) {
            this.emojiZoom = ((this.emojiX * 2.0f) / getWidth()) + 1.0f;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.emojiUpDownAnimationStartTime == 0) {
                this.emojiUpDownAnimationStartTime = jCurrentTimeMillis;
            }
            float fConvertYToRealRang = convertYToRealRang(this.emojiUpDownHeightAnim, this.emojiUpDownInterpolator.getInterpolation(convertXtoZeroOneRang(jCurrentTimeMillis - this.emojiUpDownAnimationStartTime)));
            this.emojiAnimY = fConvertYToRealRang;
            float f = this.emojiParentScale;
            float f2 = this.emojiZoom;
            this.emojiAnimY = fConvertYToRealRang + ((-(f * f2)) * this.emojiSize) + this.emojiY + (f2 * this.emojiInitialExtraY);
            canvas.save();
            canvas.translate(this.emojiX - (this.emojiStaticLayout.getWidth() / 2.0f), this.emojiAnimY - (this.emojiStaticLayout.getHeight() / 2.0f));
            float f3 = this.emojiParentScale;
            float f4 = this.emojiZoom;
            float f5 = f3 * f4;
            float f6 = f3 * f4;
            int i = this.emojiSizePx;
            canvas.scale(f5, f6, i / 2.0f, i / 2.0f);
            this.emojiStaticLayout.draw(canvas);
            canvas.restore();
            if (this.startEmojiAnimation.isEmpty()) {
                return;
            }
            invalidate();
        }
    }

    private void updateFadeAnimationIfNeeded(Canvas canvas) {
        for (int i = 0; i < this.startEmojiAnimation.size(); i++) {
            if (this.startEmojiAnimation.get(i).booleanValue()) {
                if (i >= this.emojiFadeCurrentX.size()) {
                    this.emojiFadeCurrentX.add(i, Float.valueOf(this.emojiX));
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.fadeEmojiAnimationStartTime.get(i).longValue() == 0) {
                    this.fadeEmojiAnimationStartTime.add(i, Long.valueOf(jCurrentTimeMillis));
                }
                float fConvertYToRealRang = this.emojiAnimY - convertYToRealRang(getHeight(), this.emojiFadeInterpolator.getInterpolation(convertXtoZeroOneRang(jCurrentTimeMillis - this.fadeEmojiAnimationStartTime.get(i).longValue())));
                canvas.save();
                canvas.translate(this.emojiFadeCurrentX.get(i).floatValue() - (this.emojiStaticLayout.getWidth() / 2.0f), fConvertYToRealRang - (this.emojiStaticLayout.getHeight() / 2.0f));
                float f = this.emojiParentScale;
                float f2 = this.emojiZoom;
                float f3 = f * f2;
                float f4 = f * f2;
                int i2 = this.emojiSizePx;
                canvas.scale(f3, f4, i2 / 2.0f, i2 / 2.0f);
                this.emojiStaticLayout.draw(canvas);
                canvas.restore();
                if (fConvertYToRealRang < (-this.emojiStaticLayout.getHeight())) {
                    this.startEmojiAnimation.set(i, Boolean.FALSE);
                    this.fadeEmojiAnimationStartTime.set(i, 0L);
                    this.emojiFadeCurrentX.set(i, Float.valueOf(-1.0f));
                }
            }
        }
        this.startEmojiAnimation.remove(Boolean.FALSE);
        this.fadeEmojiAnimationStartTime.remove((Object) 0L);
        this.emojiFadeCurrentX.remove(Float.valueOf(-1.0f));
        invalidate();
    }

    private float convertXtoZeroOneRang(long j) {
        return j / this.animDuration;
    }

    private static int getDeviceHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true) ? i - TypedValue.complexToDimensionPixelSize(typedValue.data, Resources.getSystem().getDisplayMetrics()) : i;
    }

    private static int getDeviceWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public void onDraggingEmoji(Point point, int i) {
        if (!this.draggingEmoji) {
            this.emojiUpDownAnimationStartTime = 0L;
        }
        this.emojiSize = i;
        this.emojiX = point.x;
        this.emojiY = point.y;
        this.draggingEmoji = true;
        invalidate();
    }

    public void onEmojiActionUpEvent(Point point, int i) {
        this.startEmojiAnimation.add(Boolean.TRUE);
        this.fadeEmojiAnimationStartTime.add(0L);
        this.emojiX = point.x;
        this.emojiY = point.y;
        this.emojiSize = i;
        this.draggingEmoji = false;
        invalidate();
    }

    public void setEmoji(String str) {
        this.emojiStaticLayout = new StaticLayout(str, this.emojiTextPaint, this.emojiSizePx * 10, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        this.emojiStaticLayout = new StaticLayout(str, this.emojiTextPaint, (int) this.emojiStaticLayout.getLineWidth(0), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        invalidate();
    }

    public void showHint(String str, int i, int i2, int i3, boolean z) {
        final HintDetail hintDetail = new HintDetail(i, i2, i3, str, z);
        addHintView(hintDetail);
        if (this.observers == null) {
            this.observers = new ArrayList();
        }
        this.observers.add((DisposableObserver) Observable.just(1).delay(3L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.story.ExtraView.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                ExtraView.this.hideHintView(hintDetail);
                dispose();
            }
        }));
    }

    public void showFireWorks() {
        this.showFireworks = true;
        if (this.fireworksOverlay == null) {
            this.fireworksOverlay = new FireworksOverlay(getContext());
            addView(this.fireworksOverlay, new FrameLayout.LayoutParams(-1, -1));
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        List<DisposableObserver> list = this.observers;
        if (list != null) {
            for (DisposableObserver disposableObserver : list) {
                if (!disposableObserver.isDisposed()) {
                    disposableObserver.dispose();
                }
            }
        }
    }

    public void setEmojiParentScale(float f) {
        this.emojiParentScale = f;
        invalidate();
    }

    public float getEmojiParentScale() {
        return this.emojiParentScale;
    }
}
