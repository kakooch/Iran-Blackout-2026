package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LinkPath;
import ir.eitaa.ui.Components.TypefaceSpan;
import ir.eitaa.ui.Components.URLSpanNoUnderline;

/* loaded from: classes3.dex */
public class BotHelpCell extends View {
    private boolean animating;
    private BotHelpCellDelegate delegate;
    private int height;
    private String oldText;
    private ClickableSpan pressedLink;
    private final Theme.ResourcesProvider resourcesProvider;
    private StaticLayout textLayout;
    private int textX;
    private int textY;
    private LinkPath urlPath;
    public boolean wasDraw;
    private int width;

    public interface BotHelpCellDelegate {
        void didPressUrl(String url);
    }

    public BotHelpCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.urlPath = new LinkPath();
        this.resourcesProvider = resourcesProvider;
    }

    public void setDelegate(BotHelpCellDelegate botHelpCellDelegate) {
        this.delegate = botHelpCellDelegate;
    }

    private void resetPressedLink() {
        if (this.pressedLink != null) {
            this.pressedLink = null;
        }
        invalidate();
    }

    public void setText(boolean bot, String text) {
        int iMin;
        if (text == null || text.length() == 0) {
            setVisibility(8);
            return;
        }
        if (text.equals(this.oldText)) {
            return;
        }
        this.oldText = AndroidUtilities.getSafeString(text);
        setVisibility(0);
        if (AndroidUtilities.isTablet()) {
            iMin = AndroidUtilities.getMinTabletSide();
        } else {
            Point point = AndroidUtilities.displaySize;
            iMin = Math.min(point.x, point.y);
        }
        int i = (int) (iMin * 0.7f);
        String[] strArrSplit = text.split("\n");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = LocaleController.getString("BotInfoTitle", R.string.BotInfoTitle);
        if (bot) {
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.append((CharSequence) "\n\n");
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            spannableStringBuilder.append((CharSequence) strArrSplit[i2].trim());
            if (i2 != strArrSplit.length - 1) {
                spannableStringBuilder.append((CharSequence) "\n");
            }
        }
        MessageObject.addLinks(false, spannableStringBuilder);
        if (bot) {
            spannableStringBuilder.setSpan(new TypefaceSpan(AndroidUtilities.getFontFamily(true)), 0, string.length(), 33);
        }
        Emoji.replaceEmoji(spannableStringBuilder, Theme.chat_msgTextPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
        try {
            StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, Theme.chat_msgTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.textLayout = staticLayout;
            this.width = 0;
            this.height = staticLayout.getHeight() + AndroidUtilities.dp(22.0f);
            int lineCount = this.textLayout.getLineCount();
            for (int i3 = 0; i3 < lineCount; i3++) {
                this.width = (int) Math.ceil(Math.max(this.width, this.textLayout.getLineWidth(i3) + this.textLayout.getLineLeft(i3)));
            }
            if (this.width > i) {
                this.width = i;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.width += AndroidUtilities.dp(22.0f);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z;
        BotHelpCellDelegate botHelpCellDelegate;
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
                                if ((url.startsWith("@") || url.startsWith("#") || url.startsWith("/")) && (botHelpCellDelegate = this.delegate) != null) {
                                    botHelpCellDelegate.didPressUrl(url);
                                }
                            } else if (clickableSpan2 instanceof URLSpan) {
                                BotHelpCellDelegate botHelpCellDelegate2 = this.delegate;
                                if (botHelpCellDelegate2 != null) {
                                    botHelpCellDelegate2.didPressUrl(((URLSpan) clickableSpan2).getURL());
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
            } else if (event.getAction() == 3) {
                resetPressedLink();
            }
            z = false;
        }
        return !z || super.onTouchEvent(event);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), this.height + AndroidUtilities.dp(8.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = (getWidth() - this.width) / 2;
        int iDp = AndroidUtilities.dp(2.0f);
        Drawable shadowDrawable = Theme.chat_msgInMediaDrawable.getShadowDrawable();
        if (shadowDrawable != null) {
            shadowDrawable.setBounds(width, iDp, this.width + width, this.height + iDp);
            shadowDrawable.draw(canvas);
        }
        Point point = AndroidUtilities.displaySize;
        int measuredWidth = point.x;
        int measuredHeight = point.y;
        if (getParent() instanceof View) {
            View view = (View) getParent();
            measuredWidth = view.getMeasuredWidth();
            measuredHeight = view.getMeasuredHeight();
        }
        int i = measuredHeight;
        Theme.MessageDrawable messageDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgInMedia");
        messageDrawable.setTop((int) getY(), measuredWidth, i, false, false);
        messageDrawable.setBounds(width, iDp, this.width + width, this.height + iDp);
        messageDrawable.draw(canvas);
        Theme.chat_msgTextPaint.setColor(getThemedColor("chat_messageTextIn"));
        Theme.chat_msgTextPaint.linkColor = getThemedColor("chat_messageLinkIn");
        canvas.save();
        int iDp2 = AndroidUtilities.dp(11.0f) + width;
        this.textX = iDp2;
        int iDp3 = AndroidUtilities.dp(11.0f) + iDp;
        this.textY = iDp3;
        canvas.translate(iDp2, iDp3);
        if (this.pressedLink != null) {
            canvas.drawPath(this.urlPath, Theme.chat_urlPaint);
        }
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
        canvas.restore();
        this.wasDraw = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.wasDraw = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setText(this.textLayout.getText());
    }

    public boolean animating() {
        return this.animating;
    }

    public void setAnimating(boolean animating) {
        this.animating = animating;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    private Drawable getThemedDrawable(String drawableKey) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Drawable drawable = resourcesProvider != null ? resourcesProvider.getDrawable(drawableKey) : null;
        return drawable != null ? drawable : Theme.getThemeDrawable(drawableKey);
    }
}
