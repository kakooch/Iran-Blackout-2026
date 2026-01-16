package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.View;
import com.google.android.material.textview.MaterialTextView;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* loaded from: classes5.dex */
public final class A17 extends AbstractC16640ld0 {
    private final B17 v;
    private final H17 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A17(View view, B17 b17) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        AbstractC13042fc3.i(b17, "suggestionChannelClickListener");
        this.v = b17;
        H17 h17A = H17.a(view);
        AbstractC13042fc3.h(h17A, "bind(...)");
        this.w = h17A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(A17 a17, C12913fO2 c12913fO2, View view) {
        AbstractC13042fc3.i(a17, "this$0");
        AbstractC13042fc3.i(c12913fO2, "$group");
        a17.v.a(c12913fO2.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(A17 a17, C12913fO2 c12913fO2, View view) {
        AbstractC13042fc3.i(a17, "this$0");
        AbstractC13042fc3.i(c12913fO2, "$group");
        a17.v.a(c12913fO2.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(A17 a17, C12913fO2 c12913fO2, final SA2 sa2, View view) {
        AbstractC13042fc3.i(a17, "this$0");
        AbstractC13042fc3.i(c12913fO2, "$group");
        AbstractC13042fc3.i(sa2, "$onJoinSuccess");
        a17.v.c(c12913fO2.i(), new SA2() { // from class: ir.nasim.z17
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return A17.O0(sa2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onJoinSuccess");
        sa2.invoke();
        return C19938rB7.a;
    }

    public final void J0(final C12913fO2 c12913fO2, final SA2 sa2) {
        AbstractC13042fc3.i(c12913fO2, "group");
        AbstractC13042fc3.i(sa2, "onJoinSuccess");
        H17 h17 = this.w;
        h17.c.setVisibility(c12913fO2.f() == E25.VERIFIED ? 0 : 8);
        h17.d.B(16.0f, true);
        h17.f.setText(c12913fO2.g());
        MaterialTextView materialTextView = h17.e;
        materialTextView.setTextDirection(JF5.g() ? 4 : 3);
        String strG = AbstractC20655sN7.g(c12913fO2.e());
        if (JF5.g()) {
            GY6.a(strG);
        }
        materialTextView.setText(((Object) strG) + Separators.HT + h17.getRoot().getContext().getString(AbstractC12217eE5.member));
        AvatarViewGlide.v(h17.d, c12913fO2.c(), c12913fO2.g(), c12913fO2.d(), false, null, 16, null);
        h17.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.w17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                A17.L0(this.a, c12913fO2, view);
            }
        });
        if (c12913fO2.h()) {
            h17.b.setText(h17.getRoot().getContext().getString(AbstractC12217eE5.see));
            h17.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.x17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    A17.M0(this.a, c12913fO2, view);
                }
            });
        } else {
            h17.b.setText(h17.getRoot().getContext().getString(AbstractC12217eE5.join));
            h17.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.y17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    A17.N0(this.a, c12913fO2, sa2, view);
                }
            });
        }
    }
}
