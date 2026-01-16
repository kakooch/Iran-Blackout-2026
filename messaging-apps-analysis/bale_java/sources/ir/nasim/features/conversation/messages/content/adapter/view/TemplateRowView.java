package ir.nasim.features.conversation.messages.content.adapter.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.C20281rk7;
import ir.nasim.ED1;
import ir.nasim.G73;
import ir.nasim.UA2;
import ir.nasim.features.conversation.messages.content.adapter.view.TemplateRowView;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00142\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/view/TemplateRowView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rk7;", "row", "Lkotlin/Function1;", "Lir/nasim/G73;", "Lir/nasim/rB7;", "onTemplateButtonClicked", "d", "(Lir/nasim/rk7;Lir/nasim/UA2;)V", "count", "index", "Landroid/widget/LinearLayout$LayoutParams;", "f", "(II)Landroid/widget/LinearLayout$LayoutParams;", "keyboardButton", "params", "b", "(Lir/nasim/G73;Landroid/widget/LinearLayout$LayoutParams;Lir/nasim/UA2;)V", "e", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class TemplateRowView extends LinearLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TemplateRowView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void b(final G73 keyboardButton, LinearLayout.LayoutParams params, final UA2 onTemplateButtonClicked) {
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        TemplateLayoutButtonView templateLayoutButtonView = new TemplateLayoutButtonView(context, null, 2, null);
        templateLayoutButtonView.i(keyboardButton);
        templateLayoutButtonView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zk7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateRowView.c(onTemplateButtonClicked, keyboardButton, view);
            }
        });
        addView(templateLayoutButtonView, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(UA2 ua2, G73 g73, View view) {
        AbstractC13042fc3.i(ua2, "$onTemplateButtonClicked");
        AbstractC13042fc3.i(g73, "$keyboardButton");
        ua2.invoke(g73);
    }

    private final void d(C20281rk7 row, UA2 onTemplateButtonClicked) {
        List listA = row.a();
        int i = 0;
        for (Object obj : listA) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            b((G73) obj, f(listA.size(), i), onTemplateButtonClicked);
            i = i2;
        }
    }

    private final LinearLayout.LayoutParams f(int count, int index) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (count < 2) {
            return layoutParams;
        }
        if (index == 0) {
            layoutParams.setMarginEnd((int) ((2 * AbstractC3742Cd6.c()) + 0.5d));
        } else if (index == count - 1) {
            layoutParams.setMarginStart((int) ((2 * AbstractC3742Cd6.c()) + 0.5d));
        } else {
            double d = 2;
            layoutParams.setMarginStart((int) ((AbstractC3742Cd6.c() * d) + 0.5d));
            layoutParams.setMarginEnd((int) ((d * AbstractC3742Cd6.c()) + 0.5d));
        }
        return layoutParams;
    }

    public final void e(C20281rk7 row, UA2 onTemplateButtonClicked) {
        AbstractC13042fc3.i(row, "row");
        AbstractC13042fc3.i(onTemplateButtonClicked, "onTemplateButtonClicked");
        removeAllViews();
        d(row, onTemplateButtonClicked);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TemplateRowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ TemplateRowView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.textViewStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        setOrientation(0);
    }
}
