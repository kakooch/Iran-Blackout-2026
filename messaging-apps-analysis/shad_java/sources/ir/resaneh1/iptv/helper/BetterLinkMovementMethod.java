package ir.resaneh1.iptv.helper;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.BuildConfig;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class BetterLinkMovementMethod extends LinkMovementMethod {
    private static BetterLinkMovementMethod singleInstance;
    private int activeTextViewHashcode;
    private ClickableSpan clickableSpanUnderTouchOnActionDown;
    private boolean isUrlHighlighted;
    private OnLinkClickListener onLinkClickListener;
    private OnLinkLongClickListener onLinkLongClickListener;
    private LongPressTimer ongoingLongPressTimer;
    private final RectF touchedLineBounds = new RectF();
    private boolean wasLongPressRegistered;

    public interface OnLinkClickListener {
        boolean onClick(TextView textView, String str);
    }

    public interface OnLinkLongClickListener {
        boolean onLongClick(TextView textView, String str);
    }

    public static BetterLinkMovementMethod getInstance() {
        if (singleInstance == null) {
            singleInstance = new BetterLinkMovementMethod();
        }
        return singleInstance;
    }

    protected BetterLinkMovementMethod() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(final TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (this.activeTextViewHashcode != textView.hashCode()) {
            this.activeTextViewHashcode = textView.hashCode();
            textView.setAutoLinkMask(0);
        }
        final ClickableSpan clickableSpanFindClickableSpanUnderTouch = findClickableSpanUnderTouch(textView, spannable, motionEvent);
        if (motionEvent.getAction() == 0) {
            this.clickableSpanUnderTouchOnActionDown = clickableSpanFindClickableSpanUnderTouch;
        }
        boolean z = this.clickableSpanUnderTouchOnActionDown != null;
        int action = motionEvent.getAction();
        if (action == 0) {
            if (clickableSpanFindClickableSpanUnderTouch != null) {
                highlightUrl(textView, clickableSpanFindClickableSpanUnderTouch, spannable);
            }
            if (z && this.onLinkLongClickListener != null) {
                startTimerForRegisteringLongClick(textView, new LongPressTimer.OnTimerReachedListener() { // from class: ir.resaneh1.iptv.helper.BetterLinkMovementMethod.1
                    @Override // ir.resaneh1.iptv.helper.BetterLinkMovementMethod.LongPressTimer.OnTimerReachedListener
                    public void onTimerReached() {
                        BetterLinkMovementMethod.this.wasLongPressRegistered = true;
                        textView.performHapticFeedback(0);
                        BetterLinkMovementMethod.this.removeUrlHighlightColor(textView);
                        BetterLinkMovementMethod.this.dispatchUrlLongClick(textView, clickableSpanFindClickableSpanUnderTouch);
                    }
                });
            }
            return z;
        }
        if (action == 1) {
            if (!this.wasLongPressRegistered && z && clickableSpanFindClickableSpanUnderTouch == this.clickableSpanUnderTouchOnActionDown) {
                dispatchUrlClick(textView, clickableSpanFindClickableSpanUnderTouch);
                if (Build.VERSION.SDK_INT >= 19) {
                    textView.cancelPendingInputEvents();
                }
            }
            cleanupOnTouchUp(textView);
            return z;
        }
        if (action != 2) {
            if (action != 3) {
                return false;
            }
            cleanupOnTouchUp(textView);
            return false;
        }
        if (clickableSpanFindClickableSpanUnderTouch != this.clickableSpanUnderTouchOnActionDown) {
            removeLongPressCallback(textView);
        }
        if (!this.wasLongPressRegistered) {
            if (clickableSpanFindClickableSpanUnderTouch != null) {
                highlightUrl(textView, clickableSpanFindClickableSpanUnderTouch, spannable);
            } else {
                removeUrlHighlightColor(textView);
            }
        }
        return z;
    }

    private void cleanupOnTouchUp(TextView textView) {
        this.wasLongPressRegistered = false;
        this.clickableSpanUnderTouchOnActionDown = null;
        removeUrlHighlightColor(textView);
        removeLongPressCallback(textView);
    }

    protected ClickableSpan findClickableSpanUnderTouch(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int totalPaddingLeft = x - textView.getTotalPaddingLeft();
        int totalPaddingTop = y - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        float f = scrollX;
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
        this.touchedLineBounds.left = layout.getLineLeft(lineForVertical);
        this.touchedLineBounds.top = layout.getLineTop(lineForVertical);
        RectF rectF = this.touchedLineBounds;
        float lineWidth = layout.getLineWidth(lineForVertical);
        RectF rectF2 = this.touchedLineBounds;
        rectF.right = lineWidth + rectF2.left;
        rectF2.bottom = layout.getLineBottom(lineForVertical);
        if (this.touchedLineBounds.contains(f, scrollY)) {
            for (Object obj : spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class)) {
                if (obj instanceof ClickableSpan) {
                    return (ClickableSpan) obj;
                }
            }
        }
        return null;
    }

    protected void highlightUrl(TextView textView, ClickableSpan clickableSpan, Spannable spannable) {
        if (this.isUrlHighlighted) {
            return;
        }
        this.isUrlHighlighted = true;
        int spanStart = spannable.getSpanStart(clickableSpan);
        int spanEnd = spannable.getSpanEnd(clickableSpan);
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(textView.getHighlightColor());
        spannable.setSpan(backgroundColorSpan, spanStart, spanEnd, 18);
        textView.setTag(R.id.bettermovementmethod_highlight_background_span, backgroundColorSpan);
        Selection.setSelection(spannable, spanStart, spanEnd);
    }

    protected void removeUrlHighlightColor(TextView textView) {
        if (this.isUrlHighlighted) {
            this.isUrlHighlighted = false;
            Spannable spannable = (Spannable) textView.getText();
            spannable.removeSpan((BackgroundColorSpan) textView.getTag(R.id.bettermovementmethod_highlight_background_span));
            Selection.removeSelection(spannable);
        }
    }

    protected void startTimerForRegisteringLongClick(TextView textView, LongPressTimer.OnTimerReachedListener onTimerReachedListener) {
        LongPressTimer longPressTimer = new LongPressTimer();
        this.ongoingLongPressTimer = longPressTimer;
        longPressTimer.setOnTimerReachedListener(onTimerReachedListener);
        textView.postDelayed(this.ongoingLongPressTimer, ViewConfiguration.getLongPressTimeout());
    }

    protected void removeLongPressCallback(TextView textView) {
        LongPressTimer longPressTimer = this.ongoingLongPressTimer;
        if (longPressTimer != null) {
            textView.removeCallbacks(longPressTimer);
            this.ongoingLongPressTimer = null;
        }
    }

    protected void dispatchUrlClick(TextView textView, ClickableSpan clickableSpan) {
        ClickableSpanWithText clickableSpanWithTextOfSpan = ClickableSpanWithText.ofSpan(textView, clickableSpan);
        OnLinkClickListener onLinkClickListener = this.onLinkClickListener;
        if (onLinkClickListener != null && onLinkClickListener.onClick(textView, clickableSpanWithTextOfSpan.text())) {
            return;
        }
        String strText = clickableSpanWithTextOfSpan.text();
        if (strText != null && strText.contains(LocaleController.getString(R.string.appIntentGo))) {
            Uri uri = Uri.parse(clickableSpanWithTextOfSpan.text());
            Context context = textView.getContext();
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setPackage(BuildConfig.APPLICATION_ID);
            intent.putExtra("com.android.browser.application_id", context.getPackageName());
            try {
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException unused) {
                Log.w("URLSpan", "Actvity was not found for intent, " + intent.toString());
                return;
            }
        }
        clickableSpanWithTextOfSpan.span().onClick(textView);
    }

    protected void dispatchUrlLongClick(TextView textView, ClickableSpan clickableSpan) {
        ClickableSpanWithText clickableSpanWithTextOfSpan = ClickableSpanWithText.ofSpan(textView, clickableSpan);
        OnLinkLongClickListener onLinkLongClickListener = this.onLinkLongClickListener;
        if (onLinkLongClickListener != null && onLinkLongClickListener.onLongClick(textView, clickableSpanWithTextOfSpan.text())) {
            return;
        }
        clickableSpanWithTextOfSpan.span().onClick(textView);
    }

    protected static final class LongPressTimer implements Runnable {
        private OnTimerReachedListener onTimerReachedListener;

        protected interface OnTimerReachedListener {
            void onTimerReached();
        }

        protected LongPressTimer() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.onTimerReachedListener.onTimerReached();
        }

        public void setOnTimerReachedListener(OnTimerReachedListener onTimerReachedListener) {
            this.onTimerReachedListener = onTimerReachedListener;
        }
    }

    protected static class ClickableSpanWithText {
        private ClickableSpan span;
        private String text;

        protected static ClickableSpanWithText ofSpan(TextView textView, ClickableSpan clickableSpan) {
            String string;
            Spanned spanned = (Spanned) textView.getText();
            if (clickableSpan instanceof URLSpan) {
                string = ((URLSpan) clickableSpan).getURL();
            } else {
                string = spanned.subSequence(spanned.getSpanStart(clickableSpan), spanned.getSpanEnd(clickableSpan)).toString();
            }
            return new ClickableSpanWithText(clickableSpan, string);
        }

        protected ClickableSpanWithText(ClickableSpan clickableSpan, String str) {
            this.span = clickableSpan;
            this.text = str;
        }

        protected ClickableSpan span() {
            return this.span;
        }

        protected String text() {
            return this.text;
        }
    }
}
