package org.rbmain.ui.Cells;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class LocationDirectionCell extends FrameLayout {
    private SimpleTextView buttonTextView;
    private FrameLayout frameLayout;

    public LocationDirectionCell(Context context) {
        super(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayout = frameLayout;
        frameLayout.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
        addView(this.frameLayout, LayoutHelper.createFrame(-1, 48.0f, 51, 16.0f, 10.0f, 16.0f, 0.0f));
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.buttonTextView = simpleTextView;
        simpleTextView.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        this.buttonTextView.setGravity(17);
        this.buttonTextView.setDrawablePadding(AndroidUtilities.dp(8.0f));
        this.buttonTextView.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
        this.buttonTextView.setTextSize(14);
        this.buttonTextView.setText(LocaleController.getString("Directions", R.string.Directions));
        this.buttonTextView.setLeftDrawable(R.drawable.navigate);
        this.buttonTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.frameLayout.addView(this.buttonTextView, LayoutHelper.createFrame(-1, -1.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(73.0f), 1073741824));
    }

    public void setOnButtonClick(View.OnClickListener onClickListener) {
        this.frameLayout.setOnClickListener(onClickListener);
    }
}
