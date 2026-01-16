package ir.nasim.features.map.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC18204oG1;
import ir.nasim.C12726f6;
import ir.nasim.C6317Nb6;
import ir.nasim.IN3;
import ir.nasim.InterfaceC10854cJ4;
import ir.nasim.LE2;
import ir.nasim.ME2;
import ir.nasim.SB7;

/* loaded from: classes3.dex */
public abstract class Hilt_MapActivity extends AppCompatActivity implements ME2 {
    private C6317Nb6 G;
    private volatile C12726f6 H;
    private final Object J = new Object();
    private boolean Y = false;

    class a implements InterfaceC10854cJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC10854cJ4
        public void a(Context context) {
            Hilt_MapActivity.this.q1();
        }
    }

    Hilt_MapActivity() {
        l1();
    }

    private void l1() {
        g0(new a());
    }

    private void p1() {
        if (getApplication() instanceof LE2) {
            C6317Nb6 c6317Nb6B = E4().b();
            this.G = c6317Nb6B;
            if (c6317Nb6B.b()) {
                this.G.c(p3());
            }
        }
    }

    @Override // ir.nasim.LE2
    public final Object N2() {
        return E4().N2();
    }

    @Override // ir.nasim.ME2
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public final C12726f6 E4() {
        if (this.H == null) {
            synchronized (this.J) {
                try {
                    if (this.H == null) {
                        this.H = o1();
                    }
                } finally {
                }
            }
        }
        return this.H;
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.h
    public G.c n3() {
        return AbstractC18204oG1.a(this, super.n3());
    }

    protected C12726f6 o1() {
        return new C12726f6(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6317Nb6 c6317Nb6 = this.G;
        if (c6317Nb6 != null) {
            c6317Nb6.a();
        }
    }

    protected void q1() {
        if (this.Y) {
            return;
        }
        this.Y = true;
        ((IN3) N2()).m((MapActivity) SB7.a(this));
    }
}
