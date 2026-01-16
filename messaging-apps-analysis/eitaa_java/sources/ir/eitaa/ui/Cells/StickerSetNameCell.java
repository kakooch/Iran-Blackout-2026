package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.ColorSpanUnderline;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.List;

/* loaded from: classes3.dex */
public class StickerSetNameCell extends FrameLayout {
    private ImageView buttonView;
    private boolean empty;
    private boolean isEmoji;
    private final Theme.ResourcesProvider resourcesProvider;
    private CharSequence stickerSetName;
    private int stickerSetNameSearchIndex;
    private int stickerSetNameSearchLength;
    private TextView textView;
    private CharSequence url;
    private int urlSearchLength;
    private TextView urlTextView;

    public StickerSetNameCell(Context context, boolean emoji, Theme.ResourcesProvider resourcesProvider) {
        this(context, emoji, false, resourcesProvider);
    }

    public StickerSetNameCell(Context context, boolean emoji, boolean supportRtl, Theme.ResourcesProvider resourcesProvider) {
        FrameLayout.LayoutParams layoutParamsCreateFrame;
        FrameLayout.LayoutParams layoutParamsCreateFrame2;
        FrameLayout.LayoutParams layoutParamsCreateFrame3;
        super(context);
        this.resourcesProvider = resourcesProvider;
        this.isEmoji = emoji;
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(getThemedColor("chat_emojiPanelStickerSetName"));
        this.textView.setTextSize(1, 15.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setSingleLine(true);
        if (supportRtl) {
            layoutParamsCreateFrame = LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388659, emoji ? 15.0f : 17.0f, 2.0f, 57.0f, 0.0f);
        } else {
            layoutParamsCreateFrame = LayoutHelper.createFrame(-2, -2.0f, 51, emoji ? 15.0f : 17.0f, 2.0f, 57.0f, 0.0f);
        }
        addView(this.textView, layoutParamsCreateFrame);
        TextView textView2 = new TextView(context);
        this.urlTextView = textView2;
        textView2.setTextColor(getThemedColor("chat_emojiPanelStickerSetName"));
        this.urlTextView.setTextSize(1, 12.0f);
        this.urlTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.urlTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.urlTextView.setSingleLine(true);
        this.urlTextView.setVisibility(4);
        if (supportRtl) {
            layoutParamsCreateFrame2 = LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388661, 17.0f, 6.0f, 17.0f, 0.0f);
        } else {
            layoutParamsCreateFrame2 = LayoutHelper.createFrame(-2, -2.0f, 53, 17.0f, 6.0f, 17.0f, 0.0f);
        }
        addView(this.urlTextView, layoutParamsCreateFrame2);
        ImageView imageView = new ImageView(context);
        this.buttonView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.buttonView.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_emojiPanelStickerSetNameIcon"), PorterDuff.Mode.MULTIPLY));
        if (supportRtl) {
            layoutParamsCreateFrame3 = LayoutHelper.createFrameRelatively(24.0f, 24.0f, 8388661, 0.0f, 0.0f, 16.0f, 0.0f);
        } else {
            layoutParamsCreateFrame3 = LayoutHelper.createFrame(24, 24.0f, 53, 0.0f, 0.0f, 16.0f, 0.0f);
        }
        addView(this.buttonView, layoutParamsCreateFrame3);
    }

    public void setUrl(CharSequence text, int searchLength) {
        this.url = text;
        this.urlSearchLength = searchLength;
        this.urlTextView.setVisibility(text != null ? 0 : 8);
        updateUrlSearchSpan();
    }

    private void updateUrlSearchSpan() {
        if (this.url != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.url);
            try {
                spannableStringBuilder.setSpan(new ColorSpanUnderline(getThemedColor("chat_emojiPanelStickerSetNameHighlight")), 0, this.urlSearchLength, 33);
                spannableStringBuilder.setSpan(new ColorSpanUnderline(getThemedColor("chat_emojiPanelStickerSetName")), this.urlSearchLength, this.url.length(), 33);
            } catch (Exception unused) {
            }
            this.urlTextView.setText(spannableStringBuilder);
        }
    }

    public void setText(CharSequence text, int resId) {
        setText(text, resId, 0, 0);
    }

    public void setTitleColor(int color) {
        this.textView.setTextColor(color);
    }

    public void setText(CharSequence text, int resId, int index, int searchLength) {
        this.stickerSetName = text;
        this.stickerSetNameSearchIndex = index;
        this.stickerSetNameSearchLength = searchLength;
        if (text == null) {
            this.empty = true;
            this.textView.setText("");
            this.buttonView.setVisibility(4);
            return;
        }
        if (searchLength != 0) {
            updateTextSearchSpan();
        } else {
            TextView textView = this.textView;
            textView.setText(Emoji.replaceEmoji(text, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        }
        if (resId != 0) {
            this.buttonView.setImageResource(resId);
            this.buttonView.setVisibility(0);
        } else {
            this.buttonView.setVisibility(4);
        }
    }

    private void updateTextSearchSpan() {
        if (this.stickerSetName == null || this.stickerSetNameSearchLength == 0) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.stickerSetName);
        try {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getThemedColor("chat_emojiPanelStickerSetNameHighlight"));
            int i = this.stickerSetNameSearchIndex;
            spannableStringBuilder.setSpan(foregroundColorSpan, i, this.stickerSetNameSearchLength + i, 33);
        } catch (Exception unused) {
        }
        TextView textView = this.textView;
        textView.setText(Emoji.replaceEmoji(spannableStringBuilder, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
    }

    public void setOnIconClickListener(View.OnClickListener onIconClickListener) {
        this.buttonView.setOnClickListener(onIconClickListener);
    }

    @Override // android.view.View
    public void invalidate() {
        this.textView.invalidate();
        super.invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.empty) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.isEmoji ? 28.0f : 24.0f), 1073741824));
        }
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        if (child == this.urlTextView) {
            widthUsed += this.textView.getMeasuredWidth() + AndroidUtilities.dp(16.0f);
        }
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    public void updateColors() {
        updateTextSearchSpan();
        updateUrlSearchSpan();
    }

    public static void createThemeDescriptions(List<ThemeDescription> descriptions, RecyclerListView listView, ThemeDescription.ThemeDescriptionDelegate delegate) {
        descriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{StickerSetNameCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_emojiPanelStickerSetName"));
        descriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{StickerSetNameCell.class}, new String[]{"urlTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_emojiPanelStickerSetName"));
        descriptions.add(new ThemeDescription(listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{StickerSetNameCell.class}, new String[]{"buttonView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chat_emojiPanelStickerSetNameIcon"));
        descriptions.add(new ThemeDescription(null, 0, null, null, null, delegate, "chat_emojiPanelStickerSetNameHighlight"));
        descriptions.add(new ThemeDescription(null, 0, null, null, null, delegate, "chat_emojiPanelStickerSetName"));
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
