package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public abstract class BG1 {
    private InterfaceC15678jz3 a;
    private Bundle b;
    private LinkedList c;
    private final InterfaceC11618dJ4 d = new Ke8(this);

    public static void o(FrameLayout frameLayout) {
        com.google.android.gms.common.a aVarM = com.google.android.gms.common.a.m();
        Context context = frameLayout.getContext();
        int iG = aVarM.g(context);
        String strD = AbstractC9851af8.d(context, iG);
        String strC = AbstractC9851af8.c(context, iG);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(strD);
        linearLayout.addView(textView);
        Intent intentB = aVarM.b(context, iG, null);
        if (intentB != null) {
            Button button = new Button(context);
            button.setId(android.R.id.button1);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(strC);
            linearLayout.addView(button);
            button.setOnClickListener(new ViewOnClickListenerC22100uf8(context, intentB));
        }
    }

    private final void t(int i) {
        while (!this.c.isEmpty() && ((Gf8) this.c.getLast()).b() >= i) {
            this.c.removeLast();
        }
    }

    private final void u(Bundle bundle, Gf8 gf8) {
        InterfaceC15678jz3 interfaceC15678jz3 = this.a;
        if (interfaceC15678jz3 != null) {
            gf8.a(interfaceC15678jz3);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add(gf8);
        if (bundle != null) {
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.d);
    }

    protected abstract void a(InterfaceC11618dJ4 interfaceC11618dJ4);

    public InterfaceC15678jz3 b() {
        return this.a;
    }

    protected void c(FrameLayout frameLayout) {
        o(frameLayout);
    }

    public void d(Bundle bundle) {
        u(bundle, new C10471bf8(this, bundle));
    }

    public View e(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        u(bundle, new C19623qf8(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.a == null) {
            c(frameLayout);
        }
        return frameLayout;
    }

    public void f() {
        InterfaceC15678jz3 interfaceC15678jz3 = this.a;
        if (interfaceC15678jz3 != null) {
            interfaceC15678jz3.onDestroy();
        } else {
            t(1);
        }
    }

    public void g() {
        InterfaceC15678jz3 interfaceC15678jz3 = this.a;
        if (interfaceC15678jz3 != null) {
            interfaceC15678jz3.u();
        } else {
            t(2);
        }
    }

    public void h(Activity activity, Bundle bundle, Bundle bundle2) {
        u(bundle2, new Ue8(this, activity, bundle, bundle2));
    }

    public void i() {
        InterfaceC15678jz3 interfaceC15678jz3 = this.a;
        if (interfaceC15678jz3 != null) {
            interfaceC15678jz3.onLowMemory();
        }
    }

    public void j() {
        InterfaceC15678jz3 interfaceC15678jz3 = this.a;
        if (interfaceC15678jz3 != null) {
            interfaceC15678jz3.onPause();
        } else {
            t(5);
        }
    }

    public void k() {
        u(null, new Df8(this));
    }

    public void l(Bundle bundle) {
        InterfaceC15678jz3 interfaceC15678jz3 = this.a;
        if (interfaceC15678jz3 != null) {
            interfaceC15678jz3.l(bundle);
            return;
        }
        Bundle bundle2 = this.b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void m() {
        u(null, new C24466yf8(this));
    }

    public void n() {
        InterfaceC15678jz3 interfaceC15678jz3 = this.a;
        if (interfaceC15678jz3 != null) {
            interfaceC15678jz3.i();
        } else {
            t(4);
        }
    }
}
