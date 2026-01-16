package ir.eitaa.ui.Cells;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
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
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.LinkPath;
import ir.eitaa.ui.Components.StaticLayoutEx;
import ir.eitaa.ui.Components.URLSpanNoUnderline;

/* loaded from: classes3.dex */
public class AboutLinkCell extends FrameLayout {
    Runnable longPressedRunnable;
    private String oldText;
    private BaseFragment parentFragment;
    private ClickableSpan pressedLink;
    private SpannableStringBuilder stringBuilder;
    private StaticLayout textLayout;
    private int textX;
    private int textY;
    private LinkPath urlPath;
    private TextView valueTextView;

    protected void didPressUrl(String url) {
    }

    public AboutLinkCell(Context context, BaseFragment fragment) {
        super(context);
        this.urlPath = new LinkPath();
        this.longPressedRunnable = new AnonymousClass1();
        this.parentFragment = fragment;
        TextView textView = new TextView(context);
        this.valueTextView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
        this.valueTextView.setTextSize(1, 13.0f);
        this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.valueTextView.setLines(1);
        this.valueTextView.setMaxLines(1);
        this.valueTextView.setSingleLine(true);
        this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        this.valueTextView.setImportantForAccessibility(2);
        addView(this.valueTextView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 80, 23.0f, 0.0f, 23.0f, 10.0f));
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPressedLink() {
        if (this.pressedLink != null) {
            this.pressedLink = null;
        }
        AndroidUtilities.cancelRunOnUIThread(this.longPressedRunnable);
        invalidate();
    }

    public void setText(String text, boolean parseLinks) {
        setTextAndValue(text, null, parseLinks);
    }

    public void setTextAndValue(String text, String value, boolean parseLinks) {
        if (TextUtils.isEmpty(text) || TextUtils.equals(text, this.oldText)) {
            return;
        }
        try {
            this.oldText = AndroidUtilities.getSafeString(text);
        } catch (Throwable unused) {
            this.oldText = text;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.oldText);
        this.stringBuilder = spannableStringBuilder;
        MessageObject.addLinks(false, spannableStringBuilder, false, false, !parseLinks);
        Emoji.replaceEmoji(this.stringBuilder, Theme.profile_aboutTextPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
        if (TextUtils.isEmpty(value)) {
            this.valueTextView.setVisibility(8);
        } else {
            this.valueTextView.setText(value);
            this.valueTextView.setVisibility(0);
        }
        requestLayout();
    }

    /* renamed from: ir.eitaa.ui.Cells.AboutLinkCell$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AboutLinkCell.this.pressedLink != null) {
                final String url = AboutLinkCell.this.pressedLink instanceof URLSpanNoUnderline ? ((URLSpanNoUnderline) AboutLinkCell.this.pressedLink).getURL() : AboutLinkCell.this.pressedLink instanceof URLSpan ? ((URLSpan) AboutLinkCell.this.pressedLink).getURL() : AboutLinkCell.this.pressedLink.toString();
                final ClickableSpan clickableSpan = AboutLinkCell.this.pressedLink;
                BottomSheet.Builder builder = new BottomSheet.Builder(AboutLinkCell.this.parentFragment.getParentActivity());
                builder.setTitle(url);
                builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$AboutLinkCell$1$Ye47oqPi8i2ZrjKNsL6kK05byzY
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$run$0$AboutLinkCell$1(clickableSpan, url, dialogInterface, i);
                    }
                });
                builder.show();
                AboutLinkCell.this.resetPressedLink();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$AboutLinkCell$1(ClickableSpan clickableSpan, String str, DialogInterface dialogInterface, int i) {
            if (i == 0) {
                AboutLinkCell.this.onLinkClick(clickableSpan);
                return;
            }
            if (i == 1) {
                AndroidUtilities.addToClipboard(str);
                if (str.startsWith("@")) {
                    BulletinFactory.of(AboutLinkCell.this.parentFragment).createSimpleBulletin(R.raw.copy, LocaleController.getString("UsernameCopied", R.string.UsernameCopied)).show();
                } else if (str.startsWith("#") || str.startsWith("$")) {
                    BulletinFactory.of(AboutLinkCell.this.parentFragment).createSimpleBulletin(R.raw.copy, LocaleController.getString("HashtagCopied", R.string.HashtagCopied)).show();
                } else {
                    BulletinFactory.of(AboutLinkCell.this.parentFragment).createSimpleBulletin(R.raw.copy, LocaleController.getString("LinkCopied", R.string.LinkCopied)).show();
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z;
        boolean z2;
        float x = event.getX();
        float y = event.getY();
        if (this.textLayout == null) {
            z = false;
        } else {
            if (event.getAction() == 0 || (this.pressedLink != null && event.getAction() == 1)) {
                if (event.getAction() == 0) {
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
                                    try {
                                        int spanStart = spannable.getSpanStart(clickableSpan);
                                        this.urlPath.setCurrentLayout(this.textLayout, spanStart, 0.0f);
                                        this.textLayout.getSelectionPath(spanStart, spannable.getSpanEnd(this.pressedLink), this.urlPath);
                                    } catch (Exception e) {
                                        FileLog.e(e);
                                    }
                                    AndroidUtilities.runOnUIThread(this.longPressedRunnable, ViewConfiguration.getLongPressTimeout());
                                    z = true;
                                } catch (Exception e2) {
                                    e = e2;
                                    z2 = true;
                                    resetPressedLink();
                                    FileLog.e(e);
                                    z = z2;
                                    if (z) {
                                    }
                                }
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
                            onLinkClick(clickableSpan2);
                        } catch (Exception e4) {
                            FileLog.e(e4);
                        }
                        resetPressedLink();
                        z = true;
                    }
                }
            } else if (event.getAction() == 3) {
                resetPressedLink();
            }
            z = false;
        }
        return !z || super.onTouchEvent(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLinkClick(ClickableSpan pressedLink) {
        if (pressedLink instanceof URLSpanNoUnderline) {
            String url = ((URLSpanNoUnderline) pressedLink).getURL();
            if (url.startsWith("@") || url.startsWith("#") || url.startsWith("/")) {
                didPressUrl(url);
                return;
            }
            return;
        }
        if (pressedLink instanceof URLSpan) {
            String url2 = ((URLSpan) pressedLink).getURL();
            if (AndroidUtilities.shouldShowUrlInAlert(url2)) {
                AlertsCreator.showOpenUrlAlert(this.parentFragment, url2, true, true);
                return;
            } else {
                Browser.openUrl(getContext(), url2);
                return;
            }
        }
        pressedLink.onClick(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.stringBuilder != null) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(46.0f);
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
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
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            CharSequence text = staticLayout.getText();
            CharSequence text2 = this.valueTextView.getText();
            if (TextUtils.isEmpty(text2)) {
                info.setText(text);
                return;
            }
            info.setText(((Object) text2) + ": " + ((Object) text));
        }
    }
}
