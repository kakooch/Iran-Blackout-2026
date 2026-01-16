package ir.nasim;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class KU2 extends RecyclerView.C {
    private final OP1 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KU2(View view, Context context, OP1 op1) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(op1, "dialogType");
        this.u = op1;
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        textView.setTextSize(1, 14.0f);
        textView.setPadding(C22078ud6.a(12.0f), C22078ud6.a(3.0f), C22078ud6.a(12.0f), C22078ud6.a(5.0f));
        textView.setGravity(16);
        textView.setTypeface(C6011Lu2.k());
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.b1());
        textView.setText(context.getResources().getString(op1 == OP1.CHANNEL ? AbstractC12217eE5.recommended_channels : AbstractC12217eE5.recommended_groups));
        frameLayout.setBackgroundColor(c5495Jo7.a1());
        frameLayout.setTag("header");
        frameLayout.addView(textView, C14433hu3.a(-1, -1.0f));
    }
}
