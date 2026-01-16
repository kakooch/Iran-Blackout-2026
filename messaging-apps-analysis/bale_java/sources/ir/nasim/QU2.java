package ir.nasim;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public final class QU2 extends RecyclerView.C {
    public static final a w = new a(null);
    public static final int x = 8;
    private static final int y = AbstractC9591aD5.header_separator_item;
    private final OU2 u;
    private final SA2 v;

    public static final class a {
        private a() {
        }

        public final int a() {
            return QU2.y;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QU2(OU2 ou2, SA2 sa2) {
        super(ou2.getRoot());
        AbstractC13042fc3.i(ou2, "binding");
        AbstractC13042fc3.i(sa2, "refreshCallLogClicked");
        this.u = ou2;
        this.v = sa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(QU2 qu2, View view) {
        AbstractC13042fc3.i(qu2, "this$0");
        qu2.v.invoke();
    }

    public final void E0() {
        this.u.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.PU2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QU2.F0(this.a, view);
            }
        });
    }
}
