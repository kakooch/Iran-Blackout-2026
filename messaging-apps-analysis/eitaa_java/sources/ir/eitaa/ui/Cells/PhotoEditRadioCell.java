package ir.eitaa.ui.Cells;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RadioButton;

/* loaded from: classes3.dex */
public class PhotoEditRadioCell extends FrameLayout {
    private int currentColor;
    private int currentType;
    private TextView nameTextView;
    private View.OnClickListener onClickListener;
    private LinearLayout tintButtonsContainer;
    private final int[] tintHighlighsColors;
    private final int[] tintShadowColors;

    public PhotoEditRadioCell(Context context) {
        super(context);
        this.tintShadowColors = new int[]{0, -45747, -753630, -13056, -8269183, -9321002, -16747844, -10080879};
        this.tintHighlighsColors = new int[]{0, -1076602, -1388894, -859780, -5968466, -7742235, -13726776, -3303195};
        TextView textView = new TextView(context);
        this.nameTextView = textView;
        textView.setGravity(5);
        this.nameTextView.setTextColor(-1);
        this.nameTextView.setTextSize(1, 12.0f);
        this.nameTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.nameTextView.setMaxLines(1);
        this.nameTextView.setSingleLine(true);
        this.nameTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.nameTextView, LayoutHelper.createFrame(80, -2.0f, 19, 0.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.tintButtonsContainer = linearLayout;
        linearLayout.setOrientation(0);
        for (int i = 0; i < this.tintShadowColors.length; i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setSize(AndroidUtilities.dp(20.0f));
            radioButton.setTag(Integer.valueOf(i));
            this.tintButtonsContainer.addView(radioButton, LayoutHelper.createLinear(0, -1, 1.0f / this.tintShadowColors.length));
            radioButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$PhotoEditRadioCell$p2UvgqYaIBM8SZEkrHNttzeHVDo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$PhotoEditRadioCell(view);
                }
            });
        }
        addView(this.tintButtonsContainer, LayoutHelper.createFrame(-1, 40.0f, 51, 96.0f, 0.0f, 24.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$PhotoEditRadioCell(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (this.currentType == 0) {
            this.currentColor = this.tintShadowColors[((Integer) radioButton.getTag()).intValue()];
        } else {
            this.currentColor = this.tintHighlighsColors[((Integer) radioButton.getTag()).intValue()];
        }
        updateSelectedTintButton(true);
        this.onClickListener.onClick(this);
    }

    public int getCurrentColor() {
        return this.currentColor;
    }

    private void updateSelectedTintButton(boolean animated) {
        int i;
        int childCount = this.tintButtonsContainer.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.tintButtonsContainer.getChildAt(i2);
            if (childAt instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) childAt;
                int iIntValue = ((Integer) radioButton.getTag()).intValue();
                radioButton.setChecked(this.currentColor == (this.currentType == 0 ? this.tintShadowColors[iIntValue] : this.tintHighlighsColors[iIntValue]), animated);
                if (iIntValue == 0) {
                    i = -1;
                } else {
                    i = this.currentType == 0 ? this.tintShadowColors[iIntValue] : this.tintHighlighsColors[iIntValue];
                }
                radioButton.setColor(i, iIntValue != 0 ? this.currentType == 0 ? this.tintShadowColors[iIntValue] : this.tintHighlighsColors[iIntValue] : -1);
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.onClickListener = l;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(40.0f), 1073741824));
    }

    public void setIconAndTextAndValue(String text, int type, int value) {
        this.currentType = type;
        this.currentColor = value;
        this.nameTextView.setText(text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase());
        updateSelectedTintButton(false);
    }
}
