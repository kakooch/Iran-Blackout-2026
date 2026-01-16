package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.List;

/* loaded from: classes5.dex */
public final class ML1 {
    private androidx.appcompat.app.a a;
    private View b;
    private TextView c;
    private RecyclerView d;
    private MaterialButton e;
    private MaterialButton f;

    public ML1(Context context, String str, List list, String str2, SA2 sa2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(list, "descriptionItems");
        AbstractC13042fc3.i(str2, "title");
        AbstractC13042fc3.i(sa2, "onOkButtonClicked");
        c(context, str2, str, list, sa2);
    }

    private final void c(Context context, String str, String str2, List list, final SA2 sa2) {
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        RecyclerView recyclerView = null;
        View viewInflate = ((LayoutInflater) systemService).inflate(AbstractC12208eD5.dialog_change_log, (ViewGroup) null);
        this.b = viewInflate;
        if (viewInflate == null) {
            AbstractC13042fc3.y("dialogView");
            viewInflate = null;
        }
        this.c = (TextView) viewInflate.findViewById(BC5.txt_title);
        View view = this.b;
        if (view == null) {
            AbstractC13042fc3.y("dialogView");
            view = null;
        }
        this.e = (MaterialButton) view.findViewById(BC5.btn_ok);
        View view2 = this.b;
        if (view2 == null) {
            AbstractC13042fc3.y("dialogView");
            view2 = null;
        }
        this.f = (MaterialButton) view2.findViewById(BC5.btn_cancel);
        View view3 = this.b;
        if (view3 == null) {
            AbstractC13042fc3.y("dialogView");
            view3 = null;
        }
        this.d = (RecyclerView) view3.findViewById(BC5.recycler_description);
        a.C0011a c0011a = new a.C0011a(context);
        View view4 = this.b;
        if (view4 == null) {
            AbstractC13042fc3.y("dialogView");
            view4 = null;
        }
        c0011a.setView(view4);
        androidx.appcompat.app.a aVarCreate = c0011a.create();
        this.a = aVarCreate;
        if (aVarCreate == null) {
            AbstractC13042fc3.y("alertDialog");
            aVarCreate = null;
        }
        Window window = aVarCreate.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (str2 == null || str2.length() == 0) {
            TextView textView = this.c;
            if (textView == null) {
                AbstractC13042fc3.y("txtTitle");
                textView = null;
            }
            textView.setText(str);
        } else {
            TextView textView2 = this.c;
            if (textView2 == null) {
                AbstractC13042fc3.y("txtTitle");
                textView2 = null;
            }
            textView2.setText(str + " (" + str2 + Separators.RPAREN);
        }
        MaterialButton materialButton = this.e;
        if (materialButton == null) {
            AbstractC13042fc3.y("btnOk");
            materialButton = null;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.KL1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                ML1.d(sa2, this, view5);
            }
        });
        MaterialButton materialButton2 = this.f;
        if (materialButton2 == null) {
            AbstractC13042fc3.y("btnCancel");
            materialButton2 = null;
        }
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.LL1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                ML1.e(this.a, view5);
            }
        });
        TextView textView3 = this.c;
        if (textView3 == null) {
            AbstractC13042fc3.y("txtTitle");
            textView3 = null;
        }
        textView3.setTypeface(C6011Lu2.i());
        MaterialButton materialButton3 = this.e;
        if (materialButton3 == null) {
            AbstractC13042fc3.y("btnOk");
            materialButton3 = null;
        }
        materialButton3.setTypeface(C6011Lu2.i());
        MaterialButton materialButton4 = this.f;
        if (materialButton4 == null) {
            AbstractC13042fc3.y("btnCancel");
            materialButton4 = null;
        }
        materialButton4.setTypeface(C6011Lu2.i());
        RecyclerView recyclerView2 = this.d;
        if (recyclerView2 == null) {
            AbstractC13042fc3.y("recyclerDescription");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new NL1(context, list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SA2 sa2, ML1 ml1, View view) {
        AbstractC13042fc3.i(sa2, "$onOkButtonClicked");
        AbstractC13042fc3.i(ml1, "this$0");
        sa2.invoke();
        androidx.appcompat.app.a aVar = ml1.a;
        if (aVar == null) {
            AbstractC13042fc3.y("alertDialog");
            aVar = null;
        }
        aVar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ML1 ml1, View view) {
        AbstractC13042fc3.i(ml1, "this$0");
        androidx.appcompat.app.a aVar = ml1.a;
        if (aVar == null) {
            AbstractC13042fc3.y("alertDialog");
            aVar = null;
        }
        aVar.dismiss();
    }

    public final void f() {
        androidx.appcompat.app.a aVar = this.a;
        if (aVar == null) {
            AbstractC13042fc3.y("alertDialog");
            aVar = null;
        }
        aVar.show();
    }
}
