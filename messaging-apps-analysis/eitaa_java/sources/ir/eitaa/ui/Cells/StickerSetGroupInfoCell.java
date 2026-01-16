package ir.eitaa.ui.Cells;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class StickerSetGroupInfoCell extends LinearLayout {
    private TextView addButton;
    private boolean isLast;

    public StickerSetGroupInfoCell(Context context) {
        super(context);
        setOrientation(1);
        TextView textView = new TextView(context);
        textView.setTextColor(Theme.getColor("chat_emojiPanelTrendingDescription"));
        textView.setTextSize(1, 14.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setText(LocaleController.getString("GroupStickersInfo", R.string.GroupStickersInfo));
        addView(textView, LayoutHelper.createLinear(-1, -2, 51, 17, 4, 17, 0));
        TextView textView2 = new TextView(context);
        this.addButton = textView2;
        textView2.setPadding(AndroidUtilities.dp(17.0f), 0, AndroidUtilities.dp(17.0f), 0);
        this.addButton.setGravity(17);
        this.addButton.setTextColor(Theme.getColor("featuredStickers_buttonText"));
        this.addButton.setTextSize(1, 14.0f);
        this.addButton.setTypeface(AndroidUtilities.getFontFamily(true));
        this.addButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
        this.addButton.setText(LocaleController.getString("ChooseStickerSet", R.string.ChooseStickerSet).toUpperCase());
        addView(this.addButton, LayoutHelper.createLinear(-2, 28, 51, 17, 10, 14, 8));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view;
        int measuredHeight;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), heightMeasureSpec);
        if (!this.isLast || (view = (View) getParent()) == null || getMeasuredHeight() >= (measuredHeight = ((view.getMeasuredHeight() - view.getPaddingBottom()) - view.getPaddingTop()) - AndroidUtilities.dp(24.0f))) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), measuredHeight);
    }

    public void setAddOnClickListener(View.OnClickListener onClickListener) {
        this.addButton.setOnClickListener(onClickListener);
    }

    public void setIsLast(boolean last) {
        this.isLast = last;
        requestLayout();
    }
}
