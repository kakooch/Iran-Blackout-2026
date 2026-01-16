package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class SearchCounterView extends View {
    int animationType;
    private StaticLayout countAnimationInLayout;
    private boolean countAnimationIncrement;
    private StaticLayout countAnimationStableLayout;
    private StaticLayout countAnimationStableLayout2;
    private ValueAnimator countAnimator;
    private float countChangeProgress;
    private StaticLayout countLayout;
    float countLeft;
    private StaticLayout countOldLayout;
    private int countWidth;
    private int countWidthOld;
    int currentCount;
    String currentString;
    float dx;
    int gravity;
    public float horizontalPadding;
    int lastH;
    RectF rectF;
    private final Theme.ResourcesProvider resourcesProvider;
    private int textColor;
    private String textColorKey;
    TextPaint textPaint;
    float x;

    public SearchCounterView(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.animationType = -1;
        this.textPaint = new TextPaint(1);
        this.rectF = new RectF();
        this.countChangeProgress = 1.0f;
        this.textColorKey = "chat_searchPanelText";
        this.gravity = 17;
        this.dx = 0.0f;
        this.resourcesProvider = resourcesProvider;
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textPaint.setTextSize(AndroidUtilities.dp(15.0f));
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredHeight() != this.lastH) {
            int i = this.currentCount;
            String str = this.currentString;
            this.currentString = null;
            setCount(str, i, false);
            this.lastH = getMeasuredHeight();
        }
    }

    public void setCount(String newStr, int count, boolean animated) {
        String strReplaceAll = newStr;
        String str = this.currentString;
        if (str == null || !str.equals(strReplaceAll)) {
            ValueAnimator valueAnimator = this.countAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            boolean z = (this.currentCount == 0 || count <= 0 || strReplaceAll == null || LocaleController.isRTL || TextUtils.isEmpty(newStr)) ? false : animated;
            if (z && strReplaceAll != null && !strReplaceAll.contains("**")) {
                z = false;
            }
            if (!z) {
                if (strReplaceAll != null) {
                    strReplaceAll = strReplaceAll.replaceAll("\\*\\*", "");
                }
                this.currentCount = count;
                if (strReplaceAll == null) {
                    this.countWidth = 0;
                    this.countLayout = null;
                } else {
                    this.countWidth = Math.max(AndroidUtilities.dp(12.0f), (int) Math.ceil(this.textPaint.measureText(strReplaceAll)));
                    this.countLayout = new StaticLayout(strReplaceAll, this.textPaint, this.countWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                }
                invalidate();
            }
            this.dx = 0.0f;
            if (z) {
                ValueAnimator valueAnimator2 = this.countAnimator;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                this.countChangeProgress = 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.countAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SearchCounterView$uyEjK_ksoYUyY3b58tTZ3nqQ7Ps
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        this.f$0.lambda$setCount$0$SearchCounterView(valueAnimator3);
                    }
                });
                this.countAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.SearchCounterView.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        SearchCounterView searchCounterView = SearchCounterView.this;
                        searchCounterView.animationType = -1;
                        searchCounterView.countChangeProgress = 1.0f;
                        SearchCounterView.this.countOldLayout = null;
                        SearchCounterView.this.countAnimationStableLayout = null;
                        SearchCounterView.this.countAnimationInLayout = null;
                        SearchCounterView.this.invalidate();
                    }
                });
                this.animationType = 2;
                this.countAnimator.setDuration(200L);
                this.countAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                if (this.countLayout != null) {
                    String str2 = this.currentString;
                    int iIndexOf = strReplaceAll.indexOf("**");
                    if (iIndexOf >= 0) {
                        strReplaceAll = strReplaceAll.replaceAll("\\*\\*", "");
                    } else {
                        iIndexOf = 0;
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strReplaceAll);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(strReplaceAll);
                    boolean z2 = Integer.toString(this.currentCount).length() != Integer.toString(count).length();
                    int iMin = Math.min(str2.length(), strReplaceAll.length());
                    if (iIndexOf > 0) {
                        spannableStringBuilder.setSpan(new EmptyStubSpan(), 0, iIndexOf, 33);
                        spannableStringBuilder2.setSpan(new EmptyStubSpan(), 0, iIndexOf, 33);
                        spannableStringBuilder3.setSpan(new EmptyStubSpan(), 0, iIndexOf, 33);
                    }
                    int i = iIndexOf;
                    int i2 = 0;
                    boolean z3 = false;
                    boolean z4 = false;
                    int i3 = 0;
                    while (i < iMin) {
                        if (!z3 && !z4) {
                            if (!z2 && str2.charAt(i) == strReplaceAll.charAt(i)) {
                                int i4 = i + 1;
                                spannableStringBuilder.setSpan(new EmptyStubSpan(), i, i4, 33);
                                spannableStringBuilder2.setSpan(new EmptyStubSpan(), i, i4, 33);
                            } else {
                                spannableStringBuilder3.setSpan(new EmptyStubSpan(), i, i + 1, 33);
                            }
                        }
                        if (!Character.isDigit(strReplaceAll.charAt(i))) {
                            spannableStringBuilder2.setSpan(new EmptyStubSpan(), i, strReplaceAll.length(), 33);
                            i3 = i;
                            z3 = true;
                        }
                        if (!Character.isDigit(str2.charAt(i))) {
                            spannableStringBuilder.setSpan(new EmptyStubSpan(), i, str2.length(), 33);
                            i2 = i;
                            z4 = true;
                        }
                        i++;
                    }
                    int iMax = Math.max(AndroidUtilities.dp(12.0f), (int) Math.ceil(this.textPaint.measureText(str2)));
                    int iMax2 = Math.max(AndroidUtilities.dp(12.0f), (int) Math.ceil(this.textPaint.measureText(strReplaceAll)));
                    this.countOldLayout = new StaticLayout(spannableStringBuilder, this.textPaint, iMax, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                    this.countAnimationStableLayout = new StaticLayout(spannableStringBuilder3, this.textPaint, iMax2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                    this.countAnimationInLayout = new StaticLayout(spannableStringBuilder2, this.textPaint, iMax2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                    if (iIndexOf > 0) {
                        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(strReplaceAll);
                        spannableStringBuilder4.setSpan(new EmptyStubSpan(), iIndexOf, strReplaceAll.length(), 0);
                        this.countAnimationStableLayout2 = new StaticLayout(spannableStringBuilder4, this.textPaint, iMax2, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                    } else {
                        this.countAnimationStableLayout2 = null;
                    }
                    this.dx = this.countOldLayout.getPrimaryHorizontal(i2) - this.countAnimationStableLayout.getPrimaryHorizontal(i3);
                }
                this.countWidthOld = this.countWidth;
                this.countAnimationIncrement = count < this.currentCount;
                this.countAnimator.start();
            }
            if (count > 0) {
                this.countWidth = Math.max(AndroidUtilities.dp(12.0f), (int) Math.ceil(this.textPaint.measureText(strReplaceAll)));
                this.countLayout = new StaticLayout(strReplaceAll, this.textPaint, this.countWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            }
            this.currentCount = count;
            invalidate();
            this.currentString = strReplaceAll;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setCount$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setCount$0$SearchCounterView(ValueAnimator valueAnimator) {
        this.countChangeProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        int color = Theme.getColor(this.textColorKey, this.resourcesProvider);
        if (this.textColor != color) {
            this.textColor = color;
            this.textPaint.setColor(color);
        }
        if (this.countChangeProgress != 1.0f) {
            float measuredHeight = (getMeasuredHeight() - AndroidUtilities.dp(23.0f)) / 2.0f;
            int i = this.countWidth;
            int i2 = this.countWidthOld;
            if (i == i2) {
                f = i;
            } else {
                float f2 = this.countChangeProgress;
                f = (i * f2) + (i2 * (1.0f - f2));
            }
            updateX(f);
            RectF rectF = this.rectF;
            float f3 = this.x;
            rectF.set(f3, measuredHeight, f + f3 + AndroidUtilities.dp(11.0f), AndroidUtilities.dp(23.0f) + measuredHeight);
            boolean z = this.countAnimationIncrement;
            if (this.countAnimationInLayout != null) {
                canvas.save();
                float f4 = this.countLeft;
                float fDp = AndroidUtilities.dp(2.0f) + measuredHeight;
                int iDp = AndroidUtilities.dp(13.0f);
                if (!z) {
                    iDp = -iDp;
                }
                canvas.translate(f4, fDp + (iDp * (1.0f - this.countChangeProgress)));
                this.textPaint.setAlpha((int) (this.countChangeProgress * 255.0f));
                this.countAnimationInLayout.draw(canvas);
                canvas.restore();
            } else if (this.countLayout != null) {
                canvas.save();
                float f5 = this.countLeft;
                float fDp2 = AndroidUtilities.dp(2.0f) + measuredHeight;
                int iDp2 = AndroidUtilities.dp(13.0f);
                if (!z) {
                    iDp2 = -iDp2;
                }
                canvas.translate(f5, fDp2 + (iDp2 * (1.0f - this.countChangeProgress)));
                this.textPaint.setAlpha((int) (this.countChangeProgress * 255.0f));
                this.countLayout.draw(canvas);
                canvas.restore();
            }
            if (this.countOldLayout != null) {
                canvas.save();
                canvas.translate(this.countLeft, AndroidUtilities.dp(2.0f) + measuredHeight + ((z ? -AndroidUtilities.dp(13.0f) : AndroidUtilities.dp(13.0f)) * this.countChangeProgress));
                this.textPaint.setAlpha((int) ((1.0f - this.countChangeProgress) * 255.0f));
                this.countOldLayout.draw(canvas);
                canvas.restore();
            }
            if (this.countAnimationStableLayout != null) {
                canvas.save();
                canvas.translate(this.countLeft + (this.dx * (1.0f - this.countChangeProgress)), AndroidUtilities.dp(2.0f) + measuredHeight);
                this.textPaint.setAlpha(255);
                this.countAnimationStableLayout.draw(canvas);
                canvas.restore();
            }
            if (this.countAnimationStableLayout2 != null) {
                canvas.save();
                canvas.translate(this.countLeft, measuredHeight + AndroidUtilities.dp(2.0f));
                this.textPaint.setAlpha(255);
                this.countAnimationStableLayout2.draw(canvas);
                canvas.restore();
            }
            this.textPaint.setAlpha(255);
            return;
        }
        drawInternal(canvas);
    }

    private void updateX(float countWidth) {
        int i = this.gravity;
        if (i == 5) {
            float measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(5.5f);
            this.countLeft = measuredWidth;
            float f = this.horizontalPadding;
            if (f != 0.0f) {
                this.countLeft = measuredWidth - Math.max(f + (countWidth / 2.0f), countWidth);
            } else {
                this.countLeft = measuredWidth - countWidth;
            }
        } else if (i == 3) {
            this.countLeft = AndroidUtilities.dp(5.5f);
        } else {
            this.countLeft = (int) ((getMeasuredWidth() - countWidth) / 2.0f);
        }
        this.x = this.countLeft - AndroidUtilities.dp(5.5f);
    }

    private void drawInternal(Canvas canvas) {
        float measuredHeight = (getMeasuredHeight() - AndroidUtilities.dp(23.0f)) / 2.0f;
        updateX(this.countWidth);
        if (this.countLayout != null) {
            canvas.save();
            canvas.translate(this.countLeft, measuredHeight + AndroidUtilities.dp(2.0f));
            this.countLayout.draw(canvas);
            canvas.restore();
        }
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }
}
