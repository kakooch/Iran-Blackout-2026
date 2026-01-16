package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.CombinedDrawable;

/* loaded from: classes3.dex */
public class ShadowSectionCell extends View {
    private int size;

    public ShadowSectionCell(Context context) {
        this(context, 12);
    }

    public ShadowSectionCell(Context context, int s) {
        super(context);
        setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
        this.size = s;
    }

    public ShadowSectionCell(Context context, int s, int backgroundColor) {
        super(context);
        CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(backgroundColor), Theme.getThemedDrawable(context, R.drawable.greydivider, "windowBackgroundGrayShadow"), 0, 0);
        combinedDrawable.setFullsize(true);
        setBackgroundDrawable(combinedDrawable);
        this.size = s;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.size), 1073741824));
    }
}
