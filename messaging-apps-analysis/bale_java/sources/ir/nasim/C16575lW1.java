package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ir.nasim.features.conversation.NewAdvancedForward;
import java.util.List;

/* renamed from: ir.nasim.lW1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16575lW1 {
    public final void a(C11458d25 c11458d25, List list, Context context, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(c11458d25, "forwardedPeer");
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(context, "parent");
        View viewInflate = LayoutInflater.from(context).inflate(HC5.advanced_forward_new_bottom, (ViewGroup) null, false);
        AbstractC13042fc3.g(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        NewAdvancedForward newAdvancedForward = new NewAdvancedForward(context, c11458d25, list, linearLayout, z, ua2);
        DialogC7946Tw1 dialogC7946Tw1 = new DialogC7946Tw1(context, AbstractC14035hE5.TransparentBottomSheetDialog, linearLayout, newAdvancedForward);
        newAdvancedForward.setParentDialog(dialogC7946Tw1);
        dialogC7946Tw1.show();
    }
}
