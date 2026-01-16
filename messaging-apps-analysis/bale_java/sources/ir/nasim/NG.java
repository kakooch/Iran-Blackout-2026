package ir.nasim;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.card.MaterialCardView;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J)\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lir/nasim/NG;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "T9", "", "type", "Z9", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "T6", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "Lir/nasim/IG;", "c1", "Lir/nasim/IG;", "_binding", "", "d1", "Lir/nasim/Yu3;", "X9", "()Z", "isArbaeenUSSDEnabled", "S9", "()Lir/nasim/IG;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class NG extends C22042ua0 {

    /* renamed from: c1, reason: from kotlin metadata */
    private IG _binding;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 isArbaeenUSSDEnabled = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.MG
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Boolean.valueOf(NG.Y9());
        }
    });

    private final IG S9() {
        IG ig = this._binding;
        AbstractC13042fc3.f(ig);
        return ig;
    }

    private final void T9() {
        IG igS9 = S9();
        igS9.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.JG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NG.U9(this.a, view);
            }
        });
        igS9.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.KG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NG.V9(this.a, view);
            }
        });
        igS9.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.LG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NG.W9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(NG ng, View view) {
        AbstractC13042fc3.i(ng, "this$0");
        C22042ua0.A9(ng, C23646xH.INSTANCE.a(), false, null, 6, null);
        ng.Z9("arbaeen_submit_status");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(NG ng, View view) {
        AbstractC13042fc3.i(ng, "this$0");
        C22042ua0.A9(ng, HH.INSTANCE.a(), false, null, 6, null);
        ng.Z9("arbaeen_view_other_status");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(NG ng, View view) {
        AbstractC13042fc3.i(ng, "this$0");
        C22042ua0.A9(ng, new SG(), false, null, 6, null);
        ng.Z9("arbaeen_help_click");
    }

    private final boolean X9() {
        return ((Boolean) this.isArbaeenUSSDEnabled.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y9() {
        return AbstractC5969Lp4.e().H().w0(EnumC4196Ec1.w);
    }

    private final void Z9(String type) {
        HashMap map = new HashMap();
        map.put("event_type", type);
        C3343Am.i("arbaeen_ussd_click", map);
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        super.H6(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == 0) {
            startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = IG.c(inflater);
        if (X9()) {
            S9().getRoot().setVisibility(0);
            T9();
        }
        MaterialCardView root = S9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this._binding = null;
    }
}
