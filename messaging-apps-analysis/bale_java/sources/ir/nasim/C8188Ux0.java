package ir.nasim;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Ux0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8188Ux0 extends RecyclerView.C {
    private final C5418Jg2 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8188Ux0(C5418Jg2 c5418Jg2, Typeface typeface) {
        super(c5418Jg2.getRoot());
        AbstractC13042fc3.i(c5418Jg2, "binding");
        AbstractC13042fc3.i(typeface, "font");
        this.u = c5418Jg2;
        c5418Jg2.e.setTypeface(typeface);
        c5418Jg2.b.setTypeface(typeface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(InterfaceC5569Jx0 interfaceC5569Jx0, View view) {
        AbstractC13042fc3.i(interfaceC5569Jx0, "$callOption");
        interfaceC5569Jx0.b().invoke();
    }

    public final void D0(final InterfaceC5569Jx0 interfaceC5569Jx0) {
        AbstractC13042fc3.i(interfaceC5569Jx0, "callOption");
        C5418Jg2 c5418Jg2 = this.u;
        TextView textView = c5418Jg2.b;
        AbstractC13042fc3.h(textView, "callOptionBadgeNew");
        textView.setVisibility(interfaceC5569Jx0.a() ? 0 : 8);
        c5418Jg2.e.setText(interfaceC5569Jx0.getTitle());
        c5418Jg2.d.setImageDrawable(interfaceC5569Jx0.getIcon());
        c5418Jg2.getRoot().setContentDescription(interfaceC5569Jx0.getTitle());
        c5418Jg2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Tx0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8188Ux0.E0(interfaceC5569Jx0, view);
            }
        });
    }
}
