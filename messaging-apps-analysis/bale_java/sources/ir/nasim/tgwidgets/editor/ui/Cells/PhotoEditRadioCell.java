package ir.nasim.tgwidgets.editor.ui.Cells;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.RadioButton;

/* loaded from: classes7.dex */
public class PhotoEditRadioCell extends FrameLayout {
    private TextView a;
    private int b;
    private LinearLayout c;
    private View.OnClickListener d;
    private int e;
    private final int[] f;
    private final int[] g;

    public PhotoEditRadioCell(Context context) {
        super(context);
        this.f = new int[]{0, -45747, -753630, -13056, -8269183, -9321002, -16747844, -10080879};
        this.g = new int[]{0, -1076602, -1388894, -859780, -5968466, -7742235, -13726776, -3303195};
        TextView textView = new TextView(context);
        this.a = textView;
        textView.setGravity(5);
        this.a.setTextColor(-1);
        this.a.setTextSize(1, 12.0f);
        this.a.setMaxLines(1);
        this.a.setSingleLine(true);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.a, AbstractC13840gu3.c(80, -2.0f, 19, 0.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.c = linearLayout;
        linearLayout.setOrientation(0);
        for (int i = 0; i < this.f.length; i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setTag(Integer.valueOf(i));
            this.c.addView(radioButton, AbstractC13840gu3.h(0, -1, 1.0f / this.f.length));
            radioButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.s85
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.b(view);
                }
            });
        }
        addView(this.c, AbstractC13840gu3.c(-1, 40.0f, 51, 96.0f, 0.0f, 24.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (this.b == 0) {
            this.e = this.f[((Integer) radioButton.getTag()).intValue()];
        } else {
            this.e = this.g[((Integer) radioButton.getTag()).intValue()];
        }
        c(true);
        this.d.onClick(this);
    }

    private void c(boolean z) {
        int childCount = this.c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.c.getChildAt(i);
            if (childAt instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) childAt;
                int iIntValue = ((Integer) radioButton.getTag()).intValue();
                radioButton.setChecked(this.e == (this.b == 0 ? this.f[iIntValue] : this.g[iIntValue]), z);
                radioButton.setColor(iIntValue == 0 ? -1 : this.b == 0 ? this.f[iIntValue] : this.g[iIntValue], iIntValue != 0 ? this.b == 0 ? this.f[iIntValue] : this.g[iIntValue] : -1);
            }
        }
    }

    public int getCurrentColor() {
        return this.e;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(40.0f), 1073741824));
    }

    public void setIconAndTextAndValue(String str, int i, int i2) {
        this.b = i;
        this.e = i2;
        this.a.setText(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
        c(false);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }
}
