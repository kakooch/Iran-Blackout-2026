package ir.nasim;

import android.graphics.Typeface;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RadioGroup;

/* loaded from: classes6.dex */
public class D74 extends C22042ua0 implements RadioGroup.OnCheckedChangeListener {
    private ImageView c1 = null;
    private ImageView d1 = null;
    private ImageView e1 = null;
    private ImageView f1 = null;
    private ImageView g1 = null;
    private Handler h1;
    private Runnable i1;
    Typeface j1;
    Typeface k1;
    private C25204zu2 l1;

    private void P9(int i) {
        this.c1.setImageResource(KB5.seekbar_interval);
        this.d1.setImageResource(KB5.seekbar_interval);
        this.e1.setImageResource(KB5.seekbar_interval);
        this.f1.setImageResource(KB5.seekbar_interval);
        this.g1.setImageResource(KB5.seekbar_interval);
        if (i == 0) {
            this.c1.setImageResource(KB5.seekbar_interval_blue);
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            this.g1.setImageResource(KB5.seekbar_interval_blue);
                        }
                    }
                    this.f1.setImageResource(KB5.seekbar_interval_blue);
                }
                this.e1.setImageResource(KB5.seekbar_interval_blue);
            }
            this.d1.setImageResource(KB5.seekbar_interval_blue);
            this.c1.setImageResource(KB5.seekbar_interval_blue);
        }
        U9(i);
    }

    private void U9(int i) {
        this.c1.setVisibility(0);
        this.d1.setVisibility(0);
        this.e1.setVisibility(0);
        this.f1.setVisibility(0);
        this.g1.setVisibility(0);
        if (i == 0) {
            this.c1.setVisibility(4);
            return;
        }
        if (i == 1) {
            this.d1.setVisibility(4);
            return;
        }
        if (i == 2) {
            this.e1.setVisibility(4);
        } else if (i == 3) {
            this.f1.setVisibility(4);
        } else {
            if (i != 4) {
                return;
            }
            this.g1.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 V9(Integer num) {
        P9(num.intValue());
        return C19938rB7.a;
    }

    private void W9(C11407cx2 c11407cx2) {
        c11407cx2.b.removeAllViews();
        c11407cx2.b.setLayoutDirection(3);
        C25204zu2 c25204zu2 = new C25204zu2(c11407cx2, new UA2() { // from class: ir.nasim.B74
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return this.a.V9((Integer) obj);
            }
        });
        this.l1 = c25204zu2;
        c25204zu2.c();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x017c  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View Q6(android.view.LayoutInflater r9, android.view.ViewGroup r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.D74.Q6(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public Typeface Q9() {
        if (this.j1 == null) {
            this.j1 = VW5.h(S7(), OB5.roboto_regular);
        }
        return this.j1;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        Runnable runnable;
        Handler handler = this.h1;
        if (handler != null && (runnable = this.i1) != null) {
            handler.removeCallbacks(runnable);
        }
        this.k1 = null;
        this.j1 = null;
        this.l1 = null;
        super.R6();
    }

    public Typeface R9() {
        if (this.k1 == null) {
            this.j1 = VW5.h(S7(), OB5.iran_sans_regular);
        }
        return this.k1;
    }

    public Typeface S9() {
        return VW5.h(S7(), OB5.iran_sharp_regular);
    }

    public Typeface T9() {
        return VW5.h(S7(), OB5.shabnam_regular);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        C7183Qq.q(EnumC18608ow5.d).putString("defaultFont", i == BC5.iran_sans_font ? "IRAN_SANS" : i == BC5.iransharp_font ? "IRAN_SHARP" : i == BC5.classic_font ? "ROBOTO" : i == BC5.shabnam_font ? "SHABNAM" : "");
        this.h1 = new Handler();
        Runnable runnable = new Runnable() { // from class: ir.nasim.C74
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC20507s76.A();
            }
        };
        this.i1 = runnable;
        this.h1.postDelayed(runnable, 200L);
    }
}
