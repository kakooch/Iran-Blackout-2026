package org.rbmain.ui.Cells;

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
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.ColorSpanUnderline;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class StickerSetNameCell extends FrameLayout {
    private ImageView buttonView;
    private boolean empty;
    private boolean isEmoji;
    private CharSequence stickerSetName;
    private int stickerSetNameSearchIndex;
    private int stickerSetNameSearchLength;
    private TextView textView;
    private CharSequence url;
    private int urlSearchLength;
    private TextView urlTextView;

    public StickerSetNameCell(Context context, boolean z) {
        this(context, z, false);
    }

    public StickerSetNameCell(Context context, boolean z, boolean z2) {
        FrameLayout.LayoutParams layoutParamsCreateFrame;
        FrameLayout.LayoutParams layoutParamsCreateFrame2;
        FrameLayout.LayoutParams layoutParamsCreateFrame3;
        super(context);
        this.isEmoji = z;
        TextView textView = new TextView(context);
        this.textView = textView;
        int i = Theme.key_chat_emojiPanelStickerSetName;
        textView.setTextColor(Theme.getColor(i));
        this.textView.setTextSize(1, 15.0f);
        this.textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setSingleLine(true);
        if (z2) {
            layoutParamsCreateFrame = LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388659, z ? 15.0f : 17.0f, 4.0f, 57.0f, 0.0f);
        } else {
            layoutParamsCreateFrame = LayoutHelper.createFrame(-2, -2.0f, 51, z ? 15.0f : 17.0f, 4.0f, 57.0f, 0.0f);
        }
        addView(this.textView, layoutParamsCreateFrame);
        TextView textView2 = new TextView(context);
        this.urlTextView = textView2;
        textView2.setTextColor(Theme.getColor(i));
        this.urlTextView.setTextSize(1, 12.0f);
        this.urlTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.urlTextView.setSingleLine(true);
        this.urlTextView.setVisibility(4);
        if (z2) {
            layoutParamsCreateFrame2 = LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388661, 17.0f, 6.0f, 17.0f, 0.0f);
        } else {
            layoutParamsCreateFrame2 = LayoutHelper.createFrame(-2, -2.0f, 53, 17.0f, 6.0f, 17.0f, 0.0f);
        }
        addView(this.urlTextView, layoutParamsCreateFrame2);
        ImageView imageView = new ImageView(context);
        this.buttonView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.buttonView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_emojiPanelStickerSetNameIcon), PorterDuff.Mode.MULTIPLY));
        if (z2) {
            layoutParamsCreateFrame3 = LayoutHelper.createFrameRelatively(24.0f, 24.0f, 8388661, 0.0f, 0.0f, 16.0f, 0.0f);
        } else {
            layoutParamsCreateFrame3 = LayoutHelper.createFrame(24, 24.0f, 53, 0.0f, 0.0f, 16.0f, 0.0f);
        }
        addView(this.buttonView, layoutParamsCreateFrame3);
    }

    public void setUrl(CharSequence charSequence, int i) {
        this.url = charSequence;
        this.urlSearchLength = i;
        this.urlTextView.setVisibility(charSequence != null ? 0 : 8);
        updateUrlSearchSpan();
    }

    private void updateUrlSearchSpan() {
        if (this.url != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.url);
            try {
                spannableStringBuilder.setSpan(new ColorSpanUnderline(Theme.getColor(Theme.key_chat_emojiPanelStickerSetNameHighlight)), 0, this.urlSearchLength, 33);
                spannableStringBuilder.setSpan(new ColorSpanUnderline(Theme.getColor(Theme.key_chat_emojiPanelStickerSetName)), this.urlSearchLength, this.url.length(), 33);
            } catch (Exception unused) {
            }
            this.urlTextView.setText(spannableStringBuilder);
        }
    }

    public void setText(CharSequence charSequence, int i) {
        setText(charSequence, i, 0, 0);
    }

    public void setTitleColor(int i) {
        this.textView.setTextColor(i);
    }

    public void setText(CharSequence charSequence, int i, int i2, int i3) {
        this.stickerSetName = charSequence;
        this.stickerSetNameSearchIndex = i2;
        this.stickerSetNameSearchLength = i3;
        if (charSequence == null) {
            this.empty = true;
            this.textView.setText(BuildConfig.FLAVOR);
            this.buttonView.setVisibility(4);
            return;
        }
        if (i3 != 0) {
            updateTextSearchSpan();
        } else {
            TextView textView = this.textView;
            textView.setText(Emoji.replaceEmoji(charSequence, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
        }
        if (i != 0) {
            this.buttonView.setImageResource(i);
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
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Theme.getColor(Theme.key_chat_emojiPanelStickerSetNameHighlight));
            int i = this.stickerSetNameSearchIndex;
            spannableStringBuilder.setSpan(foregroundColorSpan, i, this.stickerSetNameSearchLength + i, 33);
        } catch (Exception unused) {
        }
        TextView textView = this.textView;
        textView.setText(Emoji.replaceEmoji(spannableStringBuilder, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(14.0f), false));
    }

    public void setOnIconClickListener(View.OnClickListener onClickListener) {
        this.buttonView.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void invalidate() {
        this.textView.invalidate();
        super.invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.empty) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(1, 1073741824));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.isEmoji ? 28.0f : 24.0f), 1073741824));
        }
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (view == this.urlTextView) {
            i2 += this.textView.getMeasuredWidth() + AndroidUtilities.dp(16.0f);
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    public void updateColors() {
        updateTextSearchSpan();
        updateUrlSearchSpan();
    }

    public static void createThemeDescriptions(List<ThemeDescription> list, RecyclerListView recyclerListView, ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate) {
        int i = Theme.key_chat_emojiPanelStickerSetName;
        list.add(new ThemeDescription(recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{StickerSetNameCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i));
        list.add(new ThemeDescription(recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{StickerSetNameCell.class}, new String[]{"urlTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i));
        list.add(new ThemeDescription(recyclerListView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{StickerSetNameCell.class}, new String[]{"buttonView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chat_emojiPanelStickerSetNameIcon));
        list.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_chat_emojiPanelStickerSetNameHighlight));
        list.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, i));
    }
}
