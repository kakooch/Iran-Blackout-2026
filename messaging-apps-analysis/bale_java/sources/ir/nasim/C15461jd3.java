package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.contact.data.ContactItem;

/* renamed from: ir.nasim.jd3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15461jd3 extends AbstractC20225rf3 {
    private final C23899xi1 w;

    /* JADX WARN: Illegal instructions before constructor call */
    public C15461jd3(C23899xi1 c23899xi1, View.OnClickListener onClickListener) {
        AbstractC13042fc3.i(c23899xi1, "binding");
        AbstractC13042fc3.i(onClickListener, "onClickListener");
        ConstraintLayout root = c23899xi1.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, null, null, 4, null);
        this.w = c23899xi1;
        P0();
        S0(onClickListener);
    }

    private final TextView P0() {
        TextView textView = this.w.b;
        textView.setTypeface(C6011Lu2.k());
        AbstractC13042fc3.h(textView, "with(...)");
        return textView;
    }

    private final void S0(View.OnClickListener onClickListener) {
        this.w.getRoot().setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC20225rf3
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public void H0(ContactItem.InvitationViaLink invitationViaLink) {
        AbstractC13042fc3.i(invitationViaLink, "item");
    }

    @Override // ir.nasim.AbstractC20225rf3
    public void a() {
    }
}
