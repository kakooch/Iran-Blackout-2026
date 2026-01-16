package ir.eitaa.ui.Components.voip;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class AcceptDeclineView extends View {
    private Paint acceptCirclePaint;
    private FabBackgroundDrawable acceptDrawable;
    private StaticLayout acceptLayout;
    Rect acceptRect;
    private AcceptDeclineAccessibilityNodeProvider accessibilityNodeProvider;
    Drawable arrowDrawable;
    float arrowProgress;
    float bigRadius;
    private int buttonWidth;
    private Drawable callDrawable;
    private Drawable cancelDrawable;
    boolean captured;
    private FabBackgroundDrawable declineDrawable;
    private StaticLayout declineLayout;
    Rect declineRect;
    boolean expandBigRadius;
    boolean expandSmallRadius;
    Animator leftAnimator;
    boolean leftDrag;
    float leftOffsetX;
    Paint linePaint;
    Listener listener;
    float maxOffset;
    private StaticLayout retryLayout;
    boolean retryMod;
    Animator rightAnimator;
    float rigthOffsetX;
    Drawable rippleDrawable;
    private boolean screenWasWakeup;
    float smallRadius;
    boolean startDrag;
    float startX;
    float startY;
    float touchSlop;

    public interface Listener {
        void onAccept();

        void onDicline();
    }

    public AcceptDeclineView(Context context) {
        super(context);
        this.acceptCirclePaint = new Paint(1);
        this.expandSmallRadius = true;
        this.expandBigRadius = true;
        this.acceptRect = new Rect();
        this.declineRect = new Rect();
        this.linePaint = new Paint(1);
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.buttonWidth = AndroidUtilities.dp(60.0f);
        FabBackgroundDrawable fabBackgroundDrawable = new FabBackgroundDrawable();
        this.acceptDrawable = fabBackgroundDrawable;
        fabBackgroundDrawable.setColor(-12531895);
        FabBackgroundDrawable fabBackgroundDrawable2 = new FabBackgroundDrawable();
        this.declineDrawable = fabBackgroundDrawable2;
        fabBackgroundDrawable2.setColor(-1041108);
        FabBackgroundDrawable fabBackgroundDrawable3 = this.declineDrawable;
        int i = this.buttonWidth;
        fabBackgroundDrawable3.setBounds(0, 0, i, i);
        FabBackgroundDrawable fabBackgroundDrawable4 = this.acceptDrawable;
        int i2 = this.buttonWidth;
        fabBackgroundDrawable4.setBounds(0, 0, i2, i2);
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(AndroidUtilities.dp(11.0f));
        textPaint.setColor(-1);
        String string = LocaleController.getString("AcceptCall", R.string.AcceptCall);
        String string2 = LocaleController.getString("DeclineCall", R.string.DeclineCall);
        String string3 = LocaleController.getString("RetryCall", R.string.RetryCall);
        this.acceptLayout = new StaticLayout(string, textPaint, (int) textPaint.measureText(string), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.declineLayout = new StaticLayout(string2, textPaint, (int) textPaint.measureText(string2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.retryLayout = new StaticLayout(string3, textPaint, (int) textPaint.measureText(string3), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.callDrawable = ContextCompat.getDrawable(context, R.drawable.calls_decline).mutate();
        Drawable drawableMutate = ContextCompat.getDrawable(context, R.drawable.ic_close_white).mutate();
        this.cancelDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
        this.acceptCirclePaint.setColor(1061534797);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(52.0f), 0, ColorUtils.setAlphaComponent(-1, 76));
        this.rippleDrawable = drawableCreateSimpleSelectorCircleDrawable;
        drawableCreateSimpleSelectorCircleDrawable.setCallback(this);
        this.arrowDrawable = ContextCompat.getDrawable(context, R.drawable.call_arrow_right);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.maxOffset = (getMeasuredWidth() / 2.0f) - ((this.buttonWidth / 2.0f) + AndroidUtilities.dp(46.0f));
        int iDp = (this.buttonWidth - AndroidUtilities.dp(28.0f)) / 2;
        this.callDrawable.setBounds(iDp, iDp, AndroidUtilities.dp(28.0f) + iDp, AndroidUtilities.dp(28.0f) + iDp);
        this.cancelDrawable.setBounds(iDp, iDp, AndroidUtilities.dp(28.0f) + iDp, AndroidUtilities.dp(28.0f) + iDp);
        this.linePaint.setStrokeWidth(AndroidUtilities.dp(3.0f));
        this.linePaint.setColor(-1);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.voip.AcceptDeclineView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onTouchEvent$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onTouchEvent$0$AcceptDeclineView(ValueAnimator valueAnimator) {
        this.leftOffsetX = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
        this.leftAnimator = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onTouchEvent$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onTouchEvent$1$AcceptDeclineView(ValueAnimator valueAnimator) {
        this.rigthOffsetX = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
        this.rightAnimator = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        if (!this.retryMod) {
            if (this.expandSmallRadius) {
                float fDp = this.smallRadius + (AndroidUtilities.dp(2.0f) * 0.04f);
                this.smallRadius = fDp;
                if (fDp > AndroidUtilities.dp(4.0f)) {
                    this.smallRadius = AndroidUtilities.dp(4.0f);
                    this.expandSmallRadius = false;
                }
            } else {
                float fDp2 = this.smallRadius - (AndroidUtilities.dp(2.0f) * 0.04f);
                this.smallRadius = fDp2;
                if (fDp2 < 0.0f) {
                    this.smallRadius = 0.0f;
                    this.expandSmallRadius = true;
                }
            }
            if (this.expandBigRadius) {
                float fDp3 = this.bigRadius + (AndroidUtilities.dp(4.0f) * 0.03f);
                this.bigRadius = fDp3;
                if (fDp3 > AndroidUtilities.dp(10.0f)) {
                    this.bigRadius = AndroidUtilities.dp(10.0f);
                    this.expandBigRadius = false;
                }
            } else {
                float fDp4 = this.bigRadius - (AndroidUtilities.dp(5.0f) * 0.03f);
                this.bigRadius = fDp4;
                if (fDp4 < AndroidUtilities.dp(5.0f)) {
                    this.bigRadius = AndroidUtilities.dp(5.0f);
                    this.expandBigRadius = true;
                }
            }
            invalidate();
        }
        float f2 = 0.6f;
        if (this.screenWasWakeup && !this.retryMod) {
            float f3 = this.arrowProgress + 0.010666667f;
            this.arrowProgress = f3;
            if (f3 > 1.0f) {
                this.arrowProgress = 0.0f;
            }
            int iDp = (int) (AndroidUtilities.dp(40.0f) + (this.buttonWidth / 2.0f));
            float fDp5 = AndroidUtilities.dp(46.0f) + this.buttonWidth + AndroidUtilities.dp(8.0f);
            float measuredWidth = (getMeasuredWidth() / 2.0f) - AndroidUtilities.dp(8.0f);
            float fDp6 = AndroidUtilities.dp(10.0f);
            float f4 = 0.13333333f;
            int i = 0;
            while (i < 3) {
                float f5 = i;
                float f6 = ((((measuredWidth - fDp5) - fDp6) / 3.0f) * f5) + fDp5;
                int i2 = (int) f6;
                float f7 = f5 * f4;
                float f8 = this.arrowProgress;
                float f9 = 0.5f;
                if (f8 <= f7 || f8 >= f7 + f2) {
                    f = fDp6;
                } else {
                    float f10 = (f8 - f7) / f2;
                    f = fDp6;
                    if (f10 > 0.5d) {
                        f10 = 1.0f - f10;
                    }
                    f9 = f10 + 0.5f;
                }
                canvas.save();
                canvas.clipRect(this.leftOffsetX + AndroidUtilities.dp(46.0f) + (this.buttonWidth / 2), 0.0f, getMeasuredHeight(), getMeasuredWidth() >> 1);
                this.arrowDrawable.setAlpha((int) (255.0f * f9));
                Drawable drawable = this.arrowDrawable;
                drawable.setBounds(i2, iDp - (drawable.getIntrinsicHeight() / 2), this.arrowDrawable.getIntrinsicWidth() + i2, (this.arrowDrawable.getIntrinsicHeight() / 2) + iDp);
                this.arrowDrawable.draw(canvas);
                canvas.restore();
                int measuredWidth2 = (int) (getMeasuredWidth() - f6);
                canvas.save();
                canvas.clipRect(getMeasuredWidth() >> 1, 0.0f, ((this.rigthOffsetX + getMeasuredWidth()) - AndroidUtilities.dp(46.0f)) - (this.buttonWidth / 2), getMeasuredHeight());
                canvas.rotate(180.0f, measuredWidth2 - (this.arrowDrawable.getIntrinsicWidth() / 2.0f), iDp);
                Drawable drawable2 = this.arrowDrawable;
                drawable2.setBounds(measuredWidth2 - drawable2.getIntrinsicWidth(), iDp - (this.arrowDrawable.getIntrinsicHeight() / 2), measuredWidth2, (this.arrowDrawable.getIntrinsicHeight() / 2) + iDp);
                this.arrowDrawable.draw(canvas);
                canvas.restore();
                i++;
                fDp6 = f;
                f2 = 0.6f;
                f4 = 0.13333333f;
            }
            invalidate();
        }
        this.bigRadius += AndroidUtilities.dp(8.0f) * 0.005f;
        canvas.save();
        canvas.translate(0.0f, AndroidUtilities.dp(40.0f));
        canvas.save();
        canvas.translate(this.leftOffsetX + AndroidUtilities.dp(46.0f), 0.0f);
        this.declineDrawable.draw(canvas);
        canvas.save();
        canvas.translate((this.buttonWidth / 2.0f) - (this.declineLayout.getWidth() / 2.0f), this.buttonWidth + AndroidUtilities.dp(8.0f));
        this.declineLayout.draw(canvas);
        this.declineRect.set(AndroidUtilities.dp(46.0f), AndroidUtilities.dp(40.0f), AndroidUtilities.dp(46.0f) + this.buttonWidth, AndroidUtilities.dp(40.0f) + this.buttonWidth);
        canvas.restore();
        if (this.retryMod) {
            this.cancelDrawable.draw(canvas);
        } else {
            this.callDrawable.draw(canvas);
        }
        if (this.leftDrag) {
            this.rippleDrawable.setBounds(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.buttonWidth - AndroidUtilities.dp(4.0f), this.buttonWidth - AndroidUtilities.dp(4.0f));
            this.rippleDrawable.draw(canvas);
        }
        canvas.restore();
        canvas.save();
        canvas.translate(((this.rigthOffsetX + getMeasuredWidth()) - AndroidUtilities.dp(46.0f)) - this.buttonWidth, 0.0f);
        if (!this.retryMod) {
            int i3 = this.buttonWidth;
            canvas.drawCircle(i3 / 2.0f, i3 / 2.0f, ((i3 / 2.0f) - AndroidUtilities.dp(4.0f)) + this.bigRadius, this.acceptCirclePaint);
            int i4 = this.buttonWidth;
            canvas.drawCircle(i4 / 2.0f, i4 / 2.0f, ((i4 / 2.0f) - AndroidUtilities.dp(4.0f)) + this.smallRadius, this.acceptCirclePaint);
        }
        this.acceptDrawable.draw(canvas);
        this.acceptRect.set((getMeasuredWidth() - AndroidUtilities.dp(46.0f)) - this.buttonWidth, AndroidUtilities.dp(40.0f), getMeasuredWidth() - AndroidUtilities.dp(46.0f), AndroidUtilities.dp(40.0f) + this.buttonWidth);
        if (this.retryMod) {
            canvas.save();
            canvas.translate((this.buttonWidth / 2.0f) - (this.retryLayout.getWidth() / 2.0f), this.buttonWidth + AndroidUtilities.dp(8.0f));
            this.retryLayout.draw(canvas);
            canvas.restore();
        } else {
            canvas.save();
            canvas.translate((this.buttonWidth / 2.0f) - (this.acceptLayout.getWidth() / 2.0f), this.buttonWidth + AndroidUtilities.dp(8.0f));
            this.acceptLayout.draw(canvas);
            canvas.restore();
        }
        canvas.save();
        canvas.translate(-AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f));
        canvas.rotate(-135.0f, this.callDrawable.getBounds().centerX(), this.callDrawable.getBounds().centerY());
        this.callDrawable.draw(canvas);
        canvas.restore();
        if (!this.leftDrag) {
            this.rippleDrawable.setBounds(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), this.buttonWidth - AndroidUtilities.dp(4.0f), this.buttonWidth - AndroidUtilities.dp(4.0f));
            this.rippleDrawable.draw(canvas);
        }
        canvas.restore();
        canvas.restore();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setRetryMod(boolean retryMod) {
        this.retryMod = retryMod;
        if (retryMod) {
            this.declineDrawable.setColor(-1);
            this.screenWasWakeup = false;
        } else {
            this.declineDrawable.setColor(-1696188);
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.rippleDrawable.setState(getDrawableState());
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.rippleDrawable == drawable || super.verifyDrawable(drawable);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        AcceptDeclineAccessibilityNodeProvider acceptDeclineAccessibilityNodeProvider = this.accessibilityNodeProvider;
        if (acceptDeclineAccessibilityNodeProvider == null || !acceptDeclineAccessibilityNodeProvider.onHoverEvent(event)) {
            return super.onHoverEvent(event);
        }
        return true;
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.accessibilityNodeProvider == null) {
            this.accessibilityNodeProvider = new AcceptDeclineAccessibilityNodeProvider(this, 2) { // from class: ir.eitaa.ui.Components.voip.AcceptDeclineView.1
                private final int[] coords = {0, 0};

                @Override // ir.eitaa.ui.Components.voip.AcceptDeclineView.AcceptDeclineAccessibilityNodeProvider
                protected CharSequence getVirtualViewText(int virtualViewId) {
                    if (virtualViewId != 0) {
                        if (virtualViewId != 1 || AcceptDeclineView.this.declineLayout == null) {
                            return null;
                        }
                        return AcceptDeclineView.this.declineLayout.getText();
                    }
                    AcceptDeclineView acceptDeclineView = AcceptDeclineView.this;
                    if (acceptDeclineView.retryMod) {
                        if (acceptDeclineView.retryLayout != null) {
                            return AcceptDeclineView.this.retryLayout.getText();
                        }
                        return null;
                    }
                    if (acceptDeclineView.acceptLayout != null) {
                        return AcceptDeclineView.this.acceptLayout.getText();
                    }
                    return null;
                }

                @Override // ir.eitaa.ui.Components.voip.AcceptDeclineView.AcceptDeclineAccessibilityNodeProvider
                protected void getVirtualViewBoundsInScreen(int virtualViewId, Rect outRect) {
                    getVirtualViewBoundsInParent(virtualViewId, outRect);
                    AcceptDeclineView.this.getLocationOnScreen(this.coords);
                    int[] iArr = this.coords;
                    outRect.offset(iArr[0], iArr[1]);
                }

                @Override // ir.eitaa.ui.Components.voip.AcceptDeclineView.AcceptDeclineAccessibilityNodeProvider
                protected void getVirtualViewBoundsInParent(int virtualViewId, Rect outRect) {
                    if (virtualViewId == 0) {
                        outRect.set(AcceptDeclineView.this.acceptRect);
                    } else if (virtualViewId == 1) {
                        outRect.set(AcceptDeclineView.this.declineRect);
                    } else {
                        outRect.setEmpty();
                    }
                }

                @Override // ir.eitaa.ui.Components.voip.AcceptDeclineView.AcceptDeclineAccessibilityNodeProvider
                protected void onVirtualViewClick(int virtualViewId) {
                    Listener listener = AcceptDeclineView.this.listener;
                    if (listener != null) {
                        if (virtualViewId == 0) {
                            listener.onAccept();
                        } else if (virtualViewId == 1) {
                            listener.onDicline();
                        }
                    }
                }
            };
        }
        return this.accessibilityNodeProvider;
    }

    public void setScreenWasWakeup(boolean screenWasWakeup) {
        this.screenWasWakeup = screenWasWakeup;
    }

    private static abstract class AcceptDeclineAccessibilityNodeProvider extends AccessibilityNodeProvider {
        private final AccessibilityManager accessibilityManager;
        private int currentFocusedVirtualViewId;
        private final View hostView;
        private final Rect rect;
        private final int virtualViewsCount;

        protected abstract void getVirtualViewBoundsInParent(int virtualViewId, Rect outRect);

        protected abstract void getVirtualViewBoundsInScreen(int virtualViewId, Rect outRect);

        protected abstract CharSequence getVirtualViewText(int virtualViewId);

        protected abstract void onVirtualViewClick(int virtualViewId);

        private AcceptDeclineAccessibilityNodeProvider(View hostView, int virtualViewsCount) {
            this.rect = new Rect();
            this.currentFocusedVirtualViewId = -1;
            this.hostView = hostView;
            this.virtualViewsCount = virtualViewsCount;
            this.accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(hostView.getContext(), AccessibilityManager.class);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            if (virtualViewId == -1) {
                AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(this.hostView);
                accessibilityNodeInfoObtain.setPackageName(this.hostView.getContext().getPackageName());
                for (int i = 0; i < this.virtualViewsCount; i++) {
                    accessibilityNodeInfoObtain.addChild(this.hostView, i);
                }
                return accessibilityNodeInfoObtain;
            }
            AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain(this.hostView, virtualViewId);
            accessibilityNodeInfoObtain2.setPackageName(this.hostView.getContext().getPackageName());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                accessibilityNodeInfoObtain2.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
            }
            accessibilityNodeInfoObtain2.setText(getVirtualViewText(virtualViewId));
            accessibilityNodeInfoObtain2.setClassName(Button.class.getName());
            if (i2 >= 24) {
                accessibilityNodeInfoObtain2.setImportantForAccessibility(true);
            }
            accessibilityNodeInfoObtain2.setVisibleToUser(true);
            accessibilityNodeInfoObtain2.setClickable(true);
            accessibilityNodeInfoObtain2.setEnabled(true);
            accessibilityNodeInfoObtain2.setParent(this.hostView);
            getVirtualViewBoundsInScreen(virtualViewId, this.rect);
            accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
            return accessibilityNodeInfoObtain2;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            if (virtualViewId == -1) {
                return this.hostView.performAccessibilityAction(action, arguments);
            }
            if (action == 64) {
                sendAccessibilityEventForVirtualView(virtualViewId, 32768);
                return false;
            }
            if (action != 16) {
                return false;
            }
            onVirtualViewClick(virtualViewId);
            return true;
        }

        public boolean onHoverEvent(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (event.getAction() == 9 || event.getAction() == 7) {
                for (int i = 0; i < this.virtualViewsCount; i++) {
                    getVirtualViewBoundsInParent(i, this.rect);
                    if (this.rect.contains(x, y)) {
                        if (i != this.currentFocusedVirtualViewId) {
                            this.currentFocusedVirtualViewId = i;
                            sendAccessibilityEventForVirtualView(i, 32768);
                        }
                        return true;
                    }
                }
            } else if (event.getAction() == 10 && this.currentFocusedVirtualViewId != -1) {
                this.currentFocusedVirtualViewId = -1;
                return true;
            }
            return false;
        }

        private void sendAccessibilityEventForVirtualView(int virtualViewId, int eventType) {
            ViewParent parent;
            if (!this.accessibilityManager.isTouchExplorationEnabled() || (parent = this.hostView.getParent()) == null) {
                return;
            }
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(eventType);
            accessibilityEventObtain.setPackageName(this.hostView.getContext().getPackageName());
            accessibilityEventObtain.setSource(this.hostView, virtualViewId);
            parent.requestSendAccessibilityEvent(this.hostView, accessibilityEventObtain);
        }
    }
}
