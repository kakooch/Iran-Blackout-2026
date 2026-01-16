package ir.nasim;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC16239kw0;

/* renamed from: ir.nasim.oH1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18213oH1 extends RecyclerView.C {
    public static final a w = new a(null);
    public static final int x = 8;
    private static final int y = AbstractC9591aD5.delete_all_separator_item;
    private final C17031mH1 u;
    private final SA2 v;

    /* renamed from: ir.nasim.oH1$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C18213oH1.y;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18213oH1(C17031mH1 c17031mH1, SA2 sa2) {
        super(c17031mH1.getRoot());
        AbstractC13042fc3.i(c17031mH1, "binding");
        AbstractC13042fc3.i(sa2, "deleteAllClickListener");
        this.u = c17031mH1;
        this.v = sa2;
        c17031mH1.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nH1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C18213oH1.D0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(C18213oH1 c18213oH1, View view) {
        AbstractC13042fc3.i(c18213oH1, "this$0");
        c18213oH1.v.invoke();
    }

    public final void F0(InterfaceC16239kw0.b bVar) {
        AbstractC13042fc3.i(bVar, "deleteAll");
        this.u.b.setChecked(bVar.e());
    }
}
