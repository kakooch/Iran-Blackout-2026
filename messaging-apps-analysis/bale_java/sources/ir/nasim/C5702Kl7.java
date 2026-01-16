package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import ir.nasim.KX0;

/* renamed from: ir.nasim.Kl7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5702Kl7 extends androidx.fragment.app.l {
    public static final a s1 = new a(null);
    public static final int t1 = 8;
    private final InterfaceC15279jJ4 m1;
    private final String n1;
    private int o1;
    private InputMethodManager p1;
    private b q1;
    private C18023nx2 r1;

    /* renamed from: ir.nasim.Kl7$a */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ C5702Kl7 b(a aVar, InterfaceC15279jJ4 interfaceC15279jJ4, String str, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str = "";
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return aVar.a(interfaceC15279jJ4, str, i);
        }

        public final C5702Kl7 a(InterfaceC15279jJ4 interfaceC15279jJ4, String str, int i) {
            AbstractC13042fc3.i(interfaceC15279jJ4, "onFragmentCloseListener");
            return new C5702Kl7(interfaceC15279jJ4, str, i);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Kl7$b */
    public interface b {
        void a(String str, int i);
    }

    /* renamed from: ir.nasim.Kl7$c */
    public static final class c implements KX0.b {
        c() {
        }

        @Override // ir.nasim.KX0.b
        public void a(int i) {
            C5702Kl7.this.o1 = i;
            C18023nx2 c18023nx2 = C5702Kl7.this.r1;
            if (c18023nx2 == null) {
                AbstractC13042fc3.y("binding");
                c18023nx2 = null;
            }
            c18023nx2.d.setTextColor(i);
        }
    }

    public C5702Kl7(InterfaceC15279jJ4 interfaceC15279jJ4, String str, int i) {
        AbstractC13042fc3.i(interfaceC15279jJ4, "onFragmentCloseListener");
        this.m1 = interfaceC15279jJ4;
        this.n1 = str;
        this.o1 = i;
    }

    private final void P8() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(A5(), 0, false);
        C18023nx2 c18023nx2 = this.r1;
        C18023nx2 c18023nx22 = null;
        if (c18023nx2 == null) {
            AbstractC13042fc3.y("binding");
            c18023nx2 = null;
        }
        c18023nx2.b.setLayoutManager(linearLayoutManager);
        C18023nx2 c18023nx23 = this.r1;
        if (c18023nx23 == null) {
            AbstractC13042fc3.y("binding");
            c18023nx23 = null;
        }
        c18023nx23.b.setHasFixedSize(true);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        KX0 kx0 = new KX0(contextS7, this.o1);
        kx0.E(new c());
        C18023nx2 c18023nx24 = this.r1;
        if (c18023nx24 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c18023nx22 = c18023nx24;
        }
        c18023nx22.b.setAdapter(kx0);
    }

    private final void Q8() {
        C18023nx2 c18023nx2 = this.r1;
        if (c18023nx2 == null) {
            AbstractC13042fc3.y("binding");
            c18023nx2 = null;
        }
        c18023nx2.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Jl7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5702Kl7.R8(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R8(C5702Kl7 c5702Kl7, View view) {
        b bVar;
        AbstractC13042fc3.i(c5702Kl7, "this$0");
        InputMethodManager inputMethodManager = c5702Kl7.p1;
        AbstractC13042fc3.f(inputMethodManager);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        C18023nx2 c18023nx2 = c5702Kl7.r1;
        C18023nx2 c18023nx22 = null;
        if (c18023nx2 == null) {
            AbstractC13042fc3.y("binding");
            c18023nx2 = null;
        }
        c18023nx2.d.clearFocus();
        c5702Kl7.u8();
        C18023nx2 c18023nx23 = c5702Kl7.r1;
        if (c18023nx23 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c18023nx22 = c18023nx23;
        }
        String string = c18023nx22.d.getText().toString();
        if (TextUtils.isEmpty(string) || (bVar = c5702Kl7.q1) == null || bVar == null) {
            return;
        }
        bVar.a(string, c5702Kl7.o1);
    }

    private final void S8() {
        C18023nx2 c18023nx2 = this.r1;
        C18023nx2 c18023nx22 = null;
        if (c18023nx2 == null) {
            AbstractC13042fc3.y("binding");
            c18023nx2 = null;
        }
        c18023nx2.d.requestFocus();
        C18023nx2 c18023nx23 = this.r1;
        if (c18023nx23 == null) {
            AbstractC13042fc3.y("binding");
            c18023nx23 = null;
        }
        c18023nx23.d.setTextColor(this.o1);
        String str = this.n1;
        if (str != null && str.length() > 0) {
            C18023nx2 c18023nx24 = this.r1;
            if (c18023nx24 == null) {
                AbstractC13042fc3.y("binding");
                c18023nx24 = null;
            }
            c18023nx24.d.setText(str);
            C18023nx2 c18023nx25 = this.r1;
            if (c18023nx25 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c18023nx22 = c18023nx25;
            }
            c18023nx22.d.setSelection(str.length());
        }
        Object systemService = S7().getSystemService("input_method");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        this.p1 = inputMethodManager;
        AbstractC13042fc3.f(inputMethodManager);
        inputMethodManager.toggleSoftInput(2, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        C18023nx2 c18023nx2C = C18023nx2.c(layoutInflater, viewGroup, false);
        this.r1 = c18023nx2C;
        if (c18023nx2C == null) {
            AbstractC13042fc3.y("binding");
            c18023nx2C = null;
        }
        ConstraintLayout root = c18023nx2C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final void T8(b bVar) {
        AbstractC13042fc3.i(bVar, "textEditorListener");
        this.q1 = bVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void j7() {
        super.j7();
        Dialog dialogY8 = y8();
        if (dialogY8 != null) {
            Window window = dialogY8.getWindow();
            AbstractC13042fc3.f(window);
            window.setLayout(-1, -1);
            Window window2 = dialogY8.getWindow();
            AbstractC13042fc3.f(window2);
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        if (this.o1 == 0) {
            this.o1 = AbstractC4043Dl1.c(S7(), TA5.white);
        }
        S8();
        P8();
        Q8();
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        AbstractC13042fc3.i(dialogInterface, "dialog");
        this.m1.onClose();
        super.onDismiss(dialogInterface);
    }
}
