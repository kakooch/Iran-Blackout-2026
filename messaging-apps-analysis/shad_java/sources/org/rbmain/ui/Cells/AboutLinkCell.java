package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.LinkPath;
import org.rbmain.ui.Components.StaticLayoutEx;
import org.rbmain.ui.Components.URLSpanNoUnderline;

/* loaded from: classes4.dex */
public class AboutLinkCell extends FrameLayout {
    private String oldText;
    private BaseFragment parentFragment;
    private ClickableSpan pressedLink;
    private SpannableStringBuilder stringBuilder;
    private StaticLayout textLayout;
    private int textX;
    private int textY;
    private LinkPath urlPath;
    private TextView valueTextView;

    protected void didPressUrl(String str) {
    }

    public AboutLinkCell(Context context, BaseFragment baseFragment) {
        super(context);
        this.urlPath = new LinkPath();
        this.parentFragment = baseFragment;
        TextView textView = new TextView(context);
        this.valueTextView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2));
        this.valueTextView.setTextSize(1, 13.0f);
        this.valueTextView.setLines(1);
        this.valueTextView.setMaxLines(1);
        this.valueTextView.setSingleLine(true);
        this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        this.valueTextView.setImportantForAccessibility(2);
        addView(this.valueTextView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 80, 23.0f, 0.0f, 23.0f, 10.0f));
        setWillNotDraw(false);
    }

    private void resetPressedLink() {
        if (this.pressedLink != null) {
            this.pressedLink = null;
        }
        invalidate();
    }

    public void setText(String str, boolean z) {
        setTextAndValue(str, null, z);
    }

    public void setTextAndValue(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.oldText)) {
            return;
        }
        this.oldText = str;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.oldText);
        this.stringBuilder = spannableStringBuilder;
        MessageObject.addLinks(false, spannableStringBuilder, false, false, !z);
        Emoji.replaceEmoji(this.stringBuilder, Theme.profile_aboutTextPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
        if (TextUtils.isEmpty(str2)) {
            this.valueTextView.setVisibility(8);
        } else {
            this.valueTextView.setText(str2);
            this.valueTextView.setVisibility(0);
        }
        requestLayout();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.textLayout == null) {
            z = false;
        } else {
            if (motionEvent.getAction() == 0 || (this.pressedLink != null && motionEvent.getAction() == 1)) {
                if (motionEvent.getAction() == 0) {
                    resetPressedLink();
                    try {
                        int lineForVertical = this.textLayout.getLineForVertical((int) (y - this.textY));
                        float f = (int) (x - this.textX);
                        int offsetForHorizontal = this.textLayout.getOffsetForHorizontal(lineForVertical, f);
                        float lineLeft = this.textLayout.getLineLeft(lineForVertical);
                        if (lineLeft <= f && lineLeft + this.textLayout.getLineWidth(lineForVertical) >= f) {
                            Spannable spannable = (Spannable) this.textLayout.getText();
                            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                            if (clickableSpanArr.length != 0) {
                                resetPressedLink();
                                ClickableSpan clickableSpan = clickableSpanArr[0];
                                this.pressedLink = clickableSpan;
                                try {
                                    int spanStart = spannable.getSpanStart(clickableSpan);
                                    this.urlPath.setCurrentLayout(this.textLayout, spanStart, 0.0f);
                                    this.textLayout.getSelectionPath(spanStart, spannable.getSpanEnd(this.pressedLink), this.urlPath);
                                } catch (Exception e) {
                                    try {
                                        FileLog.e(e);
                                    } catch (Exception e2) {
                                        e = e2;
                                        z2 = true;
                                        resetPressedLink();
                                        FileLog.e(e);
                                        z = z2;
                                        if (z) {
                                        }
                                    }
                                }
                                z = true;
                            } else {
                                resetPressedLink();
                            }
                        } else {
                            resetPressedLink();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        z2 = false;
                    }
                } else {
                    ClickableSpan clickableSpan2 = this.pressedLink;
                    if (clickableSpan2 != null) {
                        try {
                            if (clickableSpan2 instanceof URLSpanNoUnderline) {
                                String url = ((URLSpanNoUnderline) clickableSpan2).getURL();
                                if (url.startsWith("@") || url.startsWith("#") || url.startsWith("/")) {
                                    didPressUrl(url);
                                }
                            } else if (clickableSpan2 instanceof URLSpan) {
                                String url2 = ((URLSpan) clickableSpan2).getURL();
                                if (AndroidUtilities.shouldShowUrlInAlert(url2)) {
                                    AlertsCreator.showOpenUrlAlert(this.parentFragment, url2, true, true);
                                } else {
                                    Browser.openUrl(getContext(), url2);
                                }
                            } else {
                                clickableSpan2.onClick(this);
                            }
                        } catch (Exception e4) {
                            FileLog.e(e4);
                        }
                        resetPressedLink();
                        z = true;
                    }
                }
            } else if (motionEvent.getAction() == 3) {
                resetPressedLink();
            }
            z = false;
        }
        return !z || super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.stringBuilder != null) {
            int size = View.MeasureSpec.getSize(i) - AndroidUtilities.dp(46.0f);
            if (Build.VERSION.SDK_INT >= 24) {
                SpannableStringBuilder spannableStringBuilder = this.stringBuilder;
                this.textLayout = StaticLayout.Builder.obtain(spannableStringBuilder, 0, spannableStringBuilder.length(), Theme.profile_aboutTextPaint, size).setBreakStrategy(1).setHyphenationFrequency(0).setAlignment(LocaleController.isRTL ? StaticLayoutEx.ALIGN_RIGHT() : StaticLayoutEx.ALIGN_LEFT()).build();
            } else {
                this.textLayout = new StaticLayout(this.stringBuilder, Theme.profile_aboutTextPaint, size, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
        }
        StaticLayout staticLayout = this.textLayout;
        int height = (staticLayout != null ? staticLayout.getHeight() : AndroidUtilities.dp(20.0f)) + AndroidUtilities.dp(16.0f);
        if (this.valueTextView.getVisibility() == 0) {
            height += AndroidUtilities.dp(23.0f);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        int iDp = AndroidUtilities.dp(23.0f);
        this.textX = iDp;
        int iDp2 = AndroidUtilities.dp(8.0f);
        this.textY = iDp2;
        canvas.translate(iDp, iDp2);
        if (this.pressedLink != null) {
            canvas.drawPath(this.urlPath, Theme.linkSelectionPaint);
        }
        try {
            StaticLayout staticLayout = this.textLayout;
            if (staticLayout != null) {
                staticLayout.draw(canvas);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            CharSequence text = staticLayout.getText();
            CharSequence text2 = this.valueTextView.getText();
            if (TextUtils.isEmpty(text2)) {
                accessibilityNodeInfo.setText(text);
                return;
            }
            accessibilityNodeInfo.setText(((Object) text2) + ": " + ((Object) text));
        }
    }
}
