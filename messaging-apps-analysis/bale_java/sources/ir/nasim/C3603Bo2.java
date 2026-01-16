package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.fragment.app.FragmentActivity;

/* renamed from: ir.nasim.Bo2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3603Bo2 extends androidx.fragment.app.l {
    final Handler m1 = new Handler(Looper.getMainLooper());
    final Runnable n1 = new a();
    C3754Cf0 o1;
    private int p1;
    private int q1;
    private ImageView r1;
    TextView s1;

    /* renamed from: ir.nasim.Bo2$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3603Bo2.this.Q8();
        }
    }

    /* renamed from: ir.nasim.Bo2$b */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            C3603Bo2.this.o1.M1(true);
        }
    }

    /* renamed from: ir.nasim.Bo2$c */
    class c implements QG4 {
        c() {
        }

        @Override // ir.nasim.QG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            C3603Bo2 c3603Bo2 = C3603Bo2.this;
            c3603Bo2.m1.removeCallbacks(c3603Bo2.n1);
            C3603Bo2.this.S8(num.intValue());
            C3603Bo2.this.T8(num.intValue());
            C3603Bo2 c3603Bo22 = C3603Bo2.this;
            c3603Bo22.m1.postDelayed(c3603Bo22.n1, 2000L);
        }
    }

    /* renamed from: ir.nasim.Bo2$d */
    class d implements QG4 {
        d() {
        }

        @Override // ir.nasim.QG4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CharSequence charSequence) {
            C3603Bo2 c3603Bo2 = C3603Bo2.this;
            c3603Bo2.m1.removeCallbacks(c3603Bo2.n1);
            C3603Bo2.this.U8(charSequence);
            C3603Bo2 c3603Bo22 = C3603Bo2.this;
            c3603Bo22.m1.postDelayed(c3603Bo22.n1, 2000L);
        }
    }

    /* renamed from: ir.nasim.Bo2$e */
    private static class e {
        static void a(Drawable drawable) {
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
            }
        }
    }

    /* renamed from: ir.nasim.Bo2$f */
    private static class f {
        static int a() {
            return AbstractC16381lA5.colorError;
        }
    }

    private void M8() {
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 == null) {
            return;
        }
        C3754Cf0 c3754Cf0 = (C3754Cf0) new androidx.lifecycle.G(fragmentActivityA5).b(C3754Cf0.class);
        this.o1 = c3754Cf0;
        c3754Cf0.d1().j(this, new c());
        this.o1.b1().j(this, new d());
    }

    private Drawable N8(int i, int i2) {
        int i3;
        Context contextG5 = G5();
        if (contextG5 == null) {
            Log.w("FingerprintFragment", "Unable to get asset. Context is null.");
            return null;
        }
        if (i == 0 && i2 == 1) {
            i3 = DB5.fingerprint_dialog_fp_icon;
        } else if (i == 1 && i2 == 2) {
            i3 = DB5.fingerprint_dialog_error;
        } else if (i == 2 && i2 == 1) {
            i3 = DB5.fingerprint_dialog_fp_icon;
        } else {
            if (i != 1 || i2 != 3) {
                return null;
            }
            i3 = DB5.fingerprint_dialog_fp_icon;
        }
        return AbstractC4043Dl1.f(contextG5, i3);
    }

    private int O8(int i) throws Resources.NotFoundException {
        Context contextG5 = G5();
        FragmentActivity fragmentActivityA5 = A5();
        if (contextG5 == null || fragmentActivityA5 == null) {
            Log.w("FingerprintFragment", "Unable to get themed color. Context or activity is null.");
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        contextG5.getTheme().resolveAttribute(i, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = fragmentActivityA5.obtainStyledAttributes(typedValue.data, new int[]{i});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }

    static C3603Bo2 P8() {
        return new C3603Bo2();
    }

    private boolean R8(int i, int i2) {
        if (i == 0 && i2 == 1) {
            return false;
        }
        if (i == 1 && i2 == 2) {
            return true;
        }
        return i == 2 && i2 == 1;
    }

    @Override // androidx.fragment.app.l
    public Dialog B8(Bundle bundle) {
        a.C0011a c0011a = new a.C0011a(S7());
        c0011a.setTitle(this.o1.i1());
        View viewInflate = LayoutInflater.from(c0011a.getContext()).inflate(WC5.fingerprint_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(AbstractC21831uC5.fingerprint_subtitle);
        if (textView != null) {
            CharSequence charSequenceH1 = this.o1.h1();
            if (TextUtils.isEmpty(charSequenceH1)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(charSequenceH1);
            }
        }
        TextView textView2 = (TextView) viewInflate.findViewById(AbstractC21831uC5.fingerprint_description);
        if (textView2 != null) {
            CharSequence charSequenceA1 = this.o1.a1();
            if (TextUtils.isEmpty(charSequenceA1)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(charSequenceA1);
            }
        }
        this.r1 = (ImageView) viewInflate.findViewById(AbstractC21831uC5.fingerprint_icon);
        this.s1 = (TextView) viewInflate.findViewById(AbstractC21831uC5.fingerprint_error);
        c0011a.g(UR.c(this.o1.P0()) ? h6(ND5.confirm_device_credential_password) : this.o1.g1(), new b());
        c0011a.setView(viewInflate);
        androidx.appcompat.app.a aVarCreate = c0011a.create();
        aVarCreate.setCanceledOnTouchOutside(false);
        return aVarCreate;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        M8();
        if (Build.VERSION.SDK_INT >= 26) {
            this.p1 = O8(f.a());
        } else {
            Context contextG5 = G5();
            this.p1 = contextG5 != null ? AbstractC4043Dl1.c(contextG5, LA5.biometric_error_color) : 0;
        }
        this.q1 = O8(android.R.attr.textColorSecondary);
    }

    void Q8() {
        Context contextG5 = G5();
        if (contextG5 == null) {
            Log.w("FingerprintFragment", "Not resetting the dialog. Context is null.");
        } else {
            this.o1.K1(1);
            this.o1.I1(contextG5.getString(ND5.fingerprint_dialog_touch_sensor));
        }
    }

    void S8(int i) {
        int iC1;
        Drawable drawableN8;
        if (this.r1 == null || (drawableN8 = N8((iC1 = this.o1.c1()), i)) == null) {
            return;
        }
        this.r1.setImageDrawable(drawableN8);
        if (R8(iC1, i)) {
            e.a(drawableN8);
        }
        this.o1.J1(i);
    }

    void T8(int i) {
        TextView textView = this.s1;
        if (textView != null) {
            textView.setTextColor(i == 2 ? this.p1 : this.q1);
        }
    }

    void U8(CharSequence charSequence) {
        TextView textView = this.s1;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        this.m1.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        this.o1.J1(0);
        this.o1.K1(1);
        this.o1.I1(h6(ND5.fingerprint_dialog_touch_sensor));
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.o1.G1(true);
    }
}
