package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.zn4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C25136zn4 extends RecyclerView.C {
    private final C22766vn4 u;
    private final UA2 v;
    private C21586tn4 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C25136zn4(C22766vn4 c22766vn4, UA2 ua2) {
        super(c22766vn4.getRoot());
        AbstractC13042fc3.i(c22766vn4, "binding");
        AbstractC13042fc3.i(ua2, "onClick");
        this.u = c22766vn4;
        this.v = ua2;
        c22766vn4.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yn4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C25136zn4.D0(this.a, view);
            }
        });
        c22766vn4.b.B(18.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(C25136zn4 c25136zn4, View view) {
        AbstractC13042fc3.i(c25136zn4, "this$0");
        C21586tn4 c21586tn4 = c25136zn4.w;
        if (c21586tn4 != null) {
            c25136zn4.v.invoke(c21586tn4);
        }
    }

    public final void E0(C21586tn4 c21586tn4) {
        if (c21586tn4 == null) {
            return;
        }
        this.w = c21586tn4;
        this.u.b.n(c21586tn4.b(), c21586tn4.c());
        this.u.e.setText(c21586tn4.c());
        this.u.d.setText(XY6.v(String.valueOf(c21586tn4.a())) + Separators.SP + this.u.getRoot().getContext().getString(AbstractC12217eE5.member));
    }

    public final void a() {
    }
}
