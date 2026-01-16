package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Components.ChatActivityEnterView;
import ir.eitaa.ui.Components.EmptyStubSpan;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.MessageEnterTransitionContainer;

/* loaded from: classes3.dex */
public class TextMessageEnterTransition implements MessageEnterTransitionContainer.Transition {
    private int animationIndex;
    private ValueAnimator animator;
    boolean changeColor;
    private ChatActivity chatActivity;
    MessageEnterTransitionContainer container;
    boolean crossfade;
    Bitmap crossfadeTextBitmap;
    float crossfadeTextOffset;
    MessageObject currentMessageObject;
    boolean drawBitmaps;
    private float drawableFromBottom;
    float drawableFromTop;
    ChatActivityEnterView enterView;
    int fromColor;
    Drawable fromMessageDrawable;
    float fromRadius;
    private float fromStartX;
    private float fromStartY;
    private Matrix gradientMatrix;
    private Paint gradientPaint;
    private LinearGradient gradientShader;
    boolean hasReply;
    float lastMessageX;
    float lastMessageY;
    StaticLayout layout;
    RecyclerListView listView;
    private int messageId;
    ChatMessageCell messageView;
    float progress;
    int replayFromColor;
    int replayObjectFromColor;
    float replyFromObjectStartY;
    float replyFromStartX;
    float replyFromStartY;
    float replyMessageDx;
    float replyNameDx;
    private final Theme.ResourcesProvider resourcesProvider;
    StaticLayout rtlLayout;
    private float scaleFrom;
    private float scaleY;
    Bitmap textLayoutBitmap;
    Bitmap textLayoutBitmapRtl;
    MessageObject.TextLayoutBlock textLayoutBlock;
    float textX;
    float textY;
    int toColor;
    float toXOffset;
    float toXOffsetRtl;
    Paint bitmapPaint = new Paint(1);
    boolean initBitmaps = false;
    private final int currentAccount = UserConfig.selectedAccount;

    @SuppressLint({"WrongConstant"})
    public TextMessageEnterTransition(final ChatMessageCell messageView, final ChatActivity chatActivity, RecyclerListView listView, final MessageEnterTransitionContainer container, Theme.ResourcesProvider resourcesProvider) {
        boolean z;
        int lineBottom;
        int lineTop;
        int i;
        int i2;
        Theme.MessageDrawable currentBackgroundDrawable;
        this.drawBitmaps = false;
        this.animationIndex = -1;
        this.resourcesProvider = resourcesProvider;
        if (messageView.getMessageObject().textLayoutBlocks.size() > 1 || messageView.getMessageObject().textLayoutBlocks.get(0).textLayout.getLineCount() > 10) {
            return;
        }
        this.messageView = messageView;
        this.listView = listView;
        this.container = container;
        this.chatActivity = chatActivity;
        this.enterView = chatActivity.getChatActivityEnterView();
        final ChatActivityEnterView chatActivityEnterView = chatActivity.getChatActivityEnterView();
        if (chatActivityEnterView == null || chatActivityEnterView.getEditField() == null || chatActivityEnterView.getEditField().getLayout() == null) {
            return;
        }
        this.fromRadius = chatActivityEnterView.getRecordCicle().drawingCircleRadius;
        this.bitmapPaint.setFilterBitmap(true);
        this.currentMessageObject = messageView.getMessageObject();
        if (!messageView.getTransitionParams().wasDraw) {
            messageView.draw(new Canvas());
        }
        messageView.setEnterTransitionInProgress(true);
        CharSequence text = chatActivityEnterView.getEditField().getLayout().getText();
        CharSequence charSequenceReplaceEmoji = messageView.getMessageObject().messageText;
        this.crossfade = false;
        int height = chatActivityEnterView.getEditField().getLayout().getHeight();
        TextPaint textPaint = Theme.chat_msgTextPaint;
        int iDp = AndroidUtilities.dp(20.0f);
        if (messageView.getMessageObject().getEmojiOnlyCount() != 0) {
            if (messageView.getMessageObject().getEmojiOnlyCount() == 1) {
                textPaint = Theme.chat_msgTextPaintOneEmoji;
                iDp = AndroidUtilities.dp(32.0f);
            } else if (messageView.getMessageObject().getEmojiOnlyCount() == 2) {
                textPaint = Theme.chat_msgTextPaintTwoEmoji;
                iDp = AndroidUtilities.dp(28.0f);
            } else if (messageView.getMessageObject().getEmojiOnlyCount() == 3) {
                textPaint = Theme.chat_msgTextPaintThreeEmoji;
                iDp = AndroidUtilities.dp(24.0f);
            }
        }
        if (charSequenceReplaceEmoji instanceof Spannable) {
            for (Object obj : ((Spannable) charSequenceReplaceEmoji).getSpans(0, charSequenceReplaceEmoji.length(), Object.class)) {
                if (!(obj instanceof Emoji.EmojiSpan)) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (text.length() != charSequenceReplaceEmoji.length() || z) {
            this.crossfade = true;
            String string = text.toString();
            String strTrim = string.trim();
            int iIndexOf = string.indexOf(strTrim);
            if (iIndexOf > 0) {
                lineTop = chatActivityEnterView.getEditField().getLayout().getLineTop(chatActivityEnterView.getEditField().getLayout().getLineForOffset(iIndexOf));
                lineBottom = chatActivityEnterView.getEditField().getLayout().getLineBottom(chatActivityEnterView.getEditField().getLayout().getLineForOffset(iIndexOf + strTrim.length())) - lineTop;
            } else {
                lineBottom = height;
                lineTop = 0;
            }
            charSequenceReplaceEmoji = Emoji.replaceEmoji(strTrim, textPaint.getFontMetricsInt(), iDp, false);
        } else {
            lineBottom = height;
            lineTop = 0;
        }
        this.scaleFrom = chatActivityEnterView.getEditField().getTextSize() / textPaint.getTextSize();
        int lineCount = chatActivityEnterView.getEditField().getLayout().getLineCount();
        int width = (int) (chatActivityEnterView.getEditField().getLayout().getWidth() / this.scaleFrom);
        if (Build.VERSION.SDK_INT >= 24) {
            this.layout = StaticLayout.Builder.obtain(charSequenceReplaceEmoji, 0, charSequenceReplaceEmoji.length(), textPaint, width).setBreakStrategy(1).setHyphenationFrequency(0).setAlignment(Layout.Alignment.ALIGN_NORMAL).build();
        } else {
            this.layout = new StaticLayout(charSequenceReplaceEmoji, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
        float y = chatActivityEnterView.getY() + chatActivityEnterView.getEditField().getY() + ((View) chatActivityEnterView.getEditField().getParent()).getY() + ((View) chatActivityEnterView.getEditField().getParent().getParent()).getY();
        this.fromStartX = chatActivityEnterView.getX() + chatActivityEnterView.getEditField().getX() + ((View) chatActivityEnterView.getEditField().getParent()).getX() + ((View) chatActivityEnterView.getEditField().getParent().getParent()).getX();
        this.fromStartY = ((AndroidUtilities.dp(10.0f) + y) - chatActivityEnterView.getEditField().getScrollY()) + lineTop;
        this.toXOffset = 0.0f;
        float f = Float.MAX_VALUE;
        for (int i3 = 0; i3 < this.layout.getLineCount(); i3++) {
            float lineLeft = this.layout.getLineLeft(i3);
            if (lineLeft < f) {
                f = lineLeft;
            }
        }
        if (f != Float.MAX_VALUE) {
            this.toXOffset = f;
        }
        this.scaleY = lineBottom / (this.layout.getHeight() * this.scaleFrom);
        this.drawableFromTop = AndroidUtilities.dp(4.0f) + y;
        if (this.enterView.isTopViewVisible()) {
            this.drawableFromTop -= AndroidUtilities.dp(12.0f);
        }
        this.drawableFromBottom = y + chatActivityEnterView.getEditField().getMeasuredHeight();
        MessageObject.TextLayoutBlock textLayoutBlock = messageView.getMessageObject().textLayoutBlocks.get(0);
        this.textLayoutBlock = textLayoutBlock;
        StaticLayout staticLayout = textLayoutBlock.textLayout;
        if (Math.abs(ColorUtils.calculateLuminance(getThemedColor("chat_messageTextOut")) - ColorUtils.calculateLuminance(getThemedColor("chat_messagePanelText"))) > 0.20000000298023224d) {
            this.crossfade = true;
            this.changeColor = true;
        }
        this.fromColor = getThemedColor("chat_messagePanelText");
        this.toColor = getThemedColor("chat_messageTextOut");
        if (staticLayout.getLineCount() == this.layout.getLineCount()) {
            lineCount = staticLayout.getLineCount();
            int i4 = 0;
            i = 0;
            i2 = 0;
            while (true) {
                if (i4 >= lineCount) {
                    break;
                }
                if (isRtlLine(this.layout, i4)) {
                    i2++;
                } else {
                    i++;
                }
                if (staticLayout.getLineEnd(i4) != this.layout.getLineEnd(i4)) {
                    this.crossfade = true;
                    break;
                }
                i4++;
            }
        } else {
            this.crossfade = true;
            i = 0;
            i2 = 0;
        }
        if (!this.crossfade && i2 > 0 && i > 0) {
            SpannableString spannableString = new SpannableString(charSequenceReplaceEmoji);
            SpannableString spannableString2 = new SpannableString(charSequenceReplaceEmoji);
            float f2 = Float.MAX_VALUE;
            for (int i5 = 0; i5 < lineCount; i5++) {
                if (isRtlLine(this.layout, i5)) {
                    spannableString.setSpan(new EmptyStubSpan(), this.layout.getLineStart(i5), this.layout.getLineEnd(i5), 0);
                    float lineLeft2 = this.layout.getLineLeft(i5);
                    f2 = lineLeft2 < f2 ? lineLeft2 : f2;
                } else {
                    spannableString2.setSpan(new EmptyStubSpan(), this.layout.getLineStart(i5), this.layout.getLineEnd(i5), 0);
                }
            }
            if (Build.VERSION.SDK_INT >= 24) {
                this.layout = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, width).setBreakStrategy(1).setHyphenationFrequency(0).setAlignment(Layout.Alignment.ALIGN_NORMAL).build();
                this.rtlLayout = StaticLayout.Builder.obtain(spannableString2, 0, spannableString2.length(), textPaint, width).setBreakStrategy(1).setHyphenationFrequency(0).setAlignment(Layout.Alignment.ALIGN_NORMAL).build();
            } else {
                TextPaint textPaint2 = textPaint;
                this.layout = new StaticLayout(spannableString, textPaint2, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                this.rtlLayout = new StaticLayout(spannableString2, textPaint2, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
        }
        this.toXOffsetRtl = this.layout.getWidth() - messageView.getMessageObject().textLayoutBlocks.get(0).textLayout.getWidth();
        try {
            if (this.drawBitmaps) {
                this.textLayoutBitmap = Bitmap.createBitmap(this.layout.getWidth(), this.layout.getHeight(), Bitmap.Config.ARGB_8888);
                this.layout.draw(new Canvas(this.textLayoutBitmap));
                StaticLayout staticLayout2 = this.rtlLayout;
                if (staticLayout2 != null) {
                    this.textLayoutBitmapRtl = Bitmap.createBitmap(staticLayout2.getWidth(), this.rtlLayout.getHeight(), Bitmap.Config.ARGB_8888);
                    this.rtlLayout.draw(new Canvas(this.textLayoutBitmapRtl));
                }
                if (this.crossfade) {
                    if (messageView.getMeasuredHeight() < listView.getMeasuredHeight()) {
                        this.crossfadeTextOffset = 0.0f;
                        this.crossfadeTextBitmap = Bitmap.createBitmap(messageView.getMeasuredWidth(), messageView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                    } else {
                        this.crossfadeTextOffset = messageView.getTop();
                        this.crossfadeTextBitmap = Bitmap.createBitmap(messageView.getMeasuredWidth(), listView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                    }
                }
            }
        } catch (Exception unused) {
            this.drawBitmaps = false;
        }
        boolean z2 = (messageView.getMessageObject().getReplyMsgId() == 0 || messageView.replyNameLayout == null) ? false : true;
        this.hasReply = z2;
        if (z2) {
            SimpleTextView replyNameTextView = chatActivity.getReplyNameTextView();
            this.replyFromStartX = replyNameTextView.getX() + ((View) replyNameTextView.getParent()).getX();
            this.replyFromStartY = replyNameTextView.getY() + ((View) replyNameTextView.getParent().getParent()).getY() + ((View) replyNameTextView.getParent().getParent().getParent()).getY();
            SimpleTextView replyObjectTextView = chatActivity.getReplyObjectTextView();
            this.replyFromObjectStartY = replyObjectTextView.getY() + ((View) replyObjectTextView.getParent().getParent()).getY() + ((View) replyObjectTextView.getParent().getParent().getParent()).getY();
            this.replayFromColor = chatActivity.getReplyNameTextView().getTextColor();
            this.replayObjectFromColor = chatActivity.getReplyObjectTextView().getTextColor();
            this.drawableFromTop -= AndroidUtilities.dp(46.0f);
        }
        this.gradientMatrix = new Matrix();
        Paint paint = new Paint(1);
        this.gradientPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        LinearGradient linearGradient = new LinearGradient(0.0f, AndroidUtilities.dp(12.0f), 0.0f, 0.0f, 0, -16777216, Shader.TileMode.CLAMP);
        this.gradientShader = linearGradient;
        this.gradientPaint.setShader(linearGradient);
        this.messageId = messageView.getMessageObject().stableId;
        chatActivityEnterView.getEditField().setAlpha(0.0f);
        chatActivityEnterView.setTextTransitionIsRunning(true);
        StaticLayout staticLayout3 = messageView.replyNameLayout;
        if (staticLayout3 != null && staticLayout3.getText().length() > 1 && messageView.replyNameLayout.getPrimaryHorizontal(0) != 0.0f) {
            this.replyNameDx = messageView.replyNameLayout.getWidth() - messageView.replyNameLayout.getLineWidth(0);
        }
        StaticLayout staticLayout4 = messageView.replyTextLayout;
        if (staticLayout4 != null && staticLayout4.getText().length() >= 1 && messageView.replyTextLayout.getPrimaryHorizontal(0) != 0.0f) {
            this.replyMessageDx = messageView.replyTextLayout.getWidth() - messageView.replyTextLayout.getLineWidth(0);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$TextMessageEnterTransition$FbJCEcp4vO6ofBrBU8-5FZoA3TU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$0$TextMessageEnterTransition(chatActivityEnterView, container, valueAnimator);
            }
        });
        this.animator.setInterpolator(new LinearInterpolator());
        this.animator.setDuration(250L);
        container.addTransition(this);
        this.animationIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.animationIndex, null);
        this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.TextMessageEnterTransition.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                NotificationCenter.getInstance(TextMessageEnterTransition.this.currentAccount).onAnimationFinish(TextMessageEnterTransition.this.animationIndex);
                container.removeTransition(TextMessageEnterTransition.this);
                messageView.setEnterTransitionInProgress(false);
                chatActivityEnterView.setTextTransitionIsRunning(false);
                chatActivityEnterView.getEditField().setAlpha(1.0f);
                chatActivity.getReplyNameTextView().setAlpha(1.0f);
                chatActivity.getReplyObjectTextView().setAlpha(1.0f);
            }
        });
        if (SharedConfig.getDevicePerformanceClass() != 2 || (currentBackgroundDrawable = messageView.getCurrentBackgroundDrawable(true)) == null) {
            return;
        }
        this.fromMessageDrawable = currentBackgroundDrawable.getTransitionDrawable(getThemedColor("chat_messagePanelBackground"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$TextMessageEnterTransition(ChatActivityEnterView chatActivityEnterView, MessageEnterTransitionContainer messageEnterTransitionContainer, ValueAnimator valueAnimator) {
        this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        chatActivityEnterView.getEditField().setAlpha(this.progress);
        messageEnterTransitionContainer.invalidate();
    }

    public void start() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    private boolean isRtlLine(Layout layout, int line) {
        return layout.getLineRight(line) == ((float) layout.getWidth()) && layout.getLineLeft(line) != 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0349  */
    @Override // ir.eitaa.ui.MessageEnterTransitionContainer.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r38) {
        /*
            Method dump skipped, instructions count: 1900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.TextMessageEnterTransition.onDraw(android.graphics.Canvas):void");
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
