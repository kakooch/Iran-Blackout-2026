package org.rbmain.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LinkSpanDrawable;
import org.rbmain.ui.Components.spoilers.SpoilersTextView;

/* loaded from: classes5.dex */
public class EffectsTextView extends SpoilersTextView {
    private boolean disablePaddingsOffset;
    private boolean disablePaddingsOffsetX;
    private boolean disablePaddingsOffsetY;
    private boolean isCustomLinkCollector;
    private LinkSpanDrawable.LinkCollector links;
    private LinkSpanDrawable.LinksTextView.OnLinkPress onLongPressListener;
    private LinkSpanDrawable.LinksTextView.OnLinkPress onPressListener;
    private LinkSpanDrawable<ClickableSpan> pressedLink;
    private Theme.ResourcesProvider resourcesProvider;

    public EffectsTextView(Context context) {
        this(context, null);
    }

    public EffectsTextView(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context, true);
        this.isCustomLinkCollector = false;
        this.links = new LinkSpanDrawable.LinkCollector(this);
        this.resourcesProvider = resourcesProvider;
    }

    @Override // org.rbmain.ui.Components.spoilers.SpoilersTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(Emoji.replaceEmoji(charSequence, getPaint().getFontMetricsInt(), AndroidUtilities.dp(14.0f), false), bufferType);
    }

    public void setDisablePaddingsOffset(boolean z) {
        this.disablePaddingsOffset = z;
    }

    public void setDisablePaddingsOffsetX(boolean z) {
        this.disablePaddingsOffsetX = z;
    }

    public void setDisablePaddingsOffsetY(boolean z) {
        this.disablePaddingsOffsetY = z;
    }

    public void setOnLinkPressListener(LinkSpanDrawable.LinksTextView.OnLinkPress onLinkPress) {
        this.onPressListener = onLinkPress;
    }

    public void setOnLinkLongPressListener(LinkSpanDrawable.LinksTextView.OnLinkPress onLinkPress) {
        this.onLongPressListener = onLinkPress;
    }

    public ClickableSpan hit(int i, int i2) {
        Layout layout = getLayout();
        if (layout == null) {
            return null;
        }
        int paddingLeft = i - getPaddingLeft();
        int paddingTop = i2 - getPaddingTop();
        int lineForVertical = layout.getLineForVertical(paddingTop);
        float f = paddingLeft;
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
        float lineLeft = getLayout().getLineLeft(lineForVertical);
        if (lineLeft <= f && lineLeft + layout.getLineWidth(lineForVertical) >= f && paddingTop >= 0 && paddingTop <= layout.getHeight()) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) new SpannableString(layout.getText()).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0 && !AndroidUtilities.isAccessibilityScreenReaderEnabled()) {
                return clickableSpanArr[0];
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.links != null) {
            Layout layout = getLayout();
            final ClickableSpan clickableSpanHit = hit((int) motionEvent.getX(), (int) motionEvent.getY());
            if (clickableSpanHit != null && motionEvent.getAction() == 0) {
                final LinkSpanDrawable<ClickableSpan> linkSpanDrawable = new LinkSpanDrawable<>(clickableSpanHit, this.resourcesProvider, motionEvent.getX(), motionEvent.getY());
                this.pressedLink = linkSpanDrawable;
                this.links.addLink(linkSpanDrawable);
                SpannableString spannableString = new SpannableString(layout.getText());
                int spanStart = spannableString.getSpanStart(this.pressedLink.getSpan());
                int spanEnd = spannableString.getSpanEnd(this.pressedLink.getSpan());
                LinkPath linkPathObtainNewPath = this.pressedLink.obtainNewPath();
                linkPathObtainNewPath.setCurrentLayout(layout, spanStart, getPaddingTop());
                layout.getSelectionPath(spanStart, spanEnd, linkPathObtainNewPath);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.EffectsTextView$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onTouchEvent$0(linkSpanDrawable, clickableSpanHit);
                    }
                }, ViewConfiguration.getLongPressTimeout());
                return true;
            }
            if (motionEvent.getAction() == 1) {
                this.links.clear();
                LinkSpanDrawable<ClickableSpan> linkSpanDrawable2 = this.pressedLink;
                if (linkSpanDrawable2 != null && linkSpanDrawable2.getSpan() == clickableSpanHit) {
                    LinkSpanDrawable.LinksTextView.OnLinkPress onLinkPress = this.onPressListener;
                    if (onLinkPress != null) {
                        onLinkPress.run((ClickableSpan) this.pressedLink.getSpan());
                    } else if (this.pressedLink.getSpan() != null) {
                        ((ClickableSpan) this.pressedLink.getSpan()).onClick(this);
                    }
                    this.pressedLink = null;
                    return true;
                }
                this.pressedLink = null;
            }
            if (motionEvent.getAction() == 3) {
                this.links.clear();
                this.pressedLink = null;
            }
        }
        return this.pressedLink != null || super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouchEvent$0(LinkSpanDrawable linkSpanDrawable, ClickableSpan clickableSpan) {
        LinkSpanDrawable.LinksTextView.OnLinkPress onLinkPress = this.onLongPressListener;
        if (onLinkPress == null || this.pressedLink != linkSpanDrawable) {
            return;
        }
        onLinkPress.run(clickableSpan);
        this.pressedLink = null;
        this.links.clear();
    }

    @Override // org.rbmain.ui.Components.spoilers.SpoilersTextView, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.isCustomLinkCollector) {
            canvas.save();
            if (!this.disablePaddingsOffset) {
                canvas.translate(this.disablePaddingsOffsetX ? 0.0f : getPaddingLeft(), this.disablePaddingsOffsetY ? 0.0f : getPaddingTop());
            }
            if (this.links.draw(canvas)) {
                invalidate();
            }
            canvas.restore();
        }
        super.onDraw(canvas);
    }
}
