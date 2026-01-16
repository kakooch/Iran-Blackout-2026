package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.ui.B;
import com.google.android.exoplayer2.z0;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC20563sD5;
import ir.nasim.AbstractC9253Zd2;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.CC5;
import ir.nasim.DE5;
import ir.nasim.FB5;
import ir.nasim.FO5;
import ir.nasim.VB5;
import ir.nasim.XC5;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class PlayerControlView extends FrameLayout {
    private final Drawable A;
    private boolean A0;
    private final Drawable B;
    private boolean B0;
    private boolean C0;
    private final float D;
    private boolean D0;
    private int E0;
    private int F0;
    private final float G;
    private int G0;
    private final String H;
    private boolean H0;
    private boolean I0;
    private final String J;
    private boolean J0;
    private boolean K0;
    private boolean L0;
    private long M0;
    private long[] N0;
    private boolean[] O0;
    private long[] P0;
    private boolean[] Q0;
    private long R0;
    private long S0;
    private long T0;
    private final c a;
    private final CopyOnWriteArrayList b;
    private final View c;
    private final View d;
    private final View e;
    private final View f;
    private final View g;
    private final View h;
    private final ImageView i;
    private final ImageView j;
    private final View k;
    private final TextView l;
    private final TextView m;
    private final B n;
    private final StringBuilder o;
    private final Formatter p;
    private final J0.b q;
    private final J0.d r;
    private final Runnable s;
    private final Runnable t;
    private final Drawable u;
    private final Drawable v;
    private final Drawable w;
    private final String x;
    private final String y;
    private final String z;
    private z0 z0;

    private static final class b {
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    private final class c implements z0.d, B.a, View.OnClickListener {
        private c() {
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void M3(z0 z0Var, z0.c cVar) {
            if (cVar.b(4, 5)) {
                PlayerControlView.this.T();
            }
            if (cVar.b(4, 5, 7)) {
                PlayerControlView.this.U();
            }
            if (cVar.a(8)) {
                PlayerControlView.this.V();
            }
            if (cVar.a(9)) {
                PlayerControlView.this.W();
            }
            if (cVar.b(8, 9, 11, 0, 13)) {
                PlayerControlView.this.S();
            }
            if (cVar.b(11, 0)) {
                PlayerControlView.this.X();
            }
        }

        @Override // com.google.android.exoplayer2.ui.B.a
        public void a(B b, long j) {
            if (PlayerControlView.this.m != null) {
                PlayerControlView.this.m.setText(AbstractC9683aN7.f0(PlayerControlView.this.o, PlayerControlView.this.p, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.B.a
        public void e(B b, long j, boolean z) {
            PlayerControlView.this.D0 = false;
            if (z || PlayerControlView.this.z0 == null) {
                return;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.N(playerControlView.z0, j);
        }

        @Override // com.google.android.exoplayer2.ui.B.a
        public void h(B b, long j) {
            PlayerControlView.this.D0 = true;
            if (PlayerControlView.this.m != null) {
                PlayerControlView.this.m.setText(AbstractC9683aN7.f0(PlayerControlView.this.o, PlayerControlView.this.p, j));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z0 z0Var = PlayerControlView.this.z0;
            if (z0Var == null) {
                return;
            }
            if (PlayerControlView.this.d == view) {
                z0Var.Q();
                return;
            }
            if (PlayerControlView.this.c == view) {
                z0Var.C();
                return;
            }
            if (PlayerControlView.this.g == view) {
                if (z0Var.p() != 4) {
                    z0Var.x0();
                    return;
                }
                return;
            }
            if (PlayerControlView.this.h == view) {
                z0Var.y0();
                return;
            }
            if (PlayerControlView.this.e == view) {
                PlayerControlView.this.C(z0Var);
                return;
            }
            if (PlayerControlView.this.f == view) {
                PlayerControlView.this.B(z0Var);
            } else if (PlayerControlView.this.i == view) {
                z0Var.s(FO5.a(z0Var.B(), PlayerControlView.this.G0));
            } else if (PlayerControlView.this.j == view) {
                z0Var.Y(!z0Var.v0());
            }
        }
    }

    public interface d {
    }

    public interface e {
        void a(int i);
    }

    static {
        AbstractC9253Zd2.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(z0 z0Var) {
        z0Var.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(z0 z0Var) {
        int iP = z0Var.p();
        if (iP == 1) {
            z0Var.r();
        } else if (iP == 4) {
            M(z0Var, z0Var.r0(), -9223372036854775807L);
        }
        z0Var.q();
    }

    private void D(z0 z0Var) {
        int iP = z0Var.p();
        if (iP == 1 || iP == 4 || !z0Var.X()) {
            C(z0Var);
        } else {
            B(z0Var);
        }
    }

    private static int E(TypedArray typedArray, int i) {
        return typedArray.getInt(DE5.PlayerControlView_repeat_toggle_modes, i);
    }

    private void G() {
        removeCallbacks(this.t);
        if (this.E0 <= 0) {
            this.M0 = -9223372036854775807L;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i = this.E0;
        this.M0 = jUptimeMillis + i;
        if (this.A0) {
            postDelayed(this.t, i);
        }
    }

    private static boolean H(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    private void K() {
        View view;
        View view2;
        boolean zO = O();
        if (!zO && (view2 = this.e) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!zO || (view = this.f) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    private void L() {
        View view;
        View view2;
        boolean zO = O();
        if (!zO && (view2 = this.e) != null) {
            view2.requestFocus();
        } else {
            if (!zO || (view = this.f) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    private void M(z0 z0Var, int i, long j) {
        z0Var.U(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(z0 z0Var, long j) {
        int iR0;
        J0 j0N = z0Var.N();
        if (this.C0 && !j0N.v()) {
            int iU = j0N.u();
            iR0 = 0;
            while (true) {
                long jG = j0N.s(iR0, this.r).g();
                if (j < jG) {
                    break;
                }
                if (iR0 == iU - 1) {
                    j = jG;
                    break;
                } else {
                    j -= jG;
                    iR0++;
                }
            }
        } else {
            iR0 = z0Var.r0();
        }
        M(z0Var, iR0, j);
        U();
    }

    private boolean O() {
        z0 z0Var = this.z0;
        return (z0Var == null || z0Var.p() == 4 || this.z0.p() == 1 || !this.z0.X()) ? false : true;
    }

    private void Q() {
        T();
        S();
        V();
        W();
        X();
    }

    private void R(boolean z, boolean z2, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        view.setAlpha(z2 ? this.D : this.G);
        view.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        boolean zK;
        boolean zK2;
        boolean zK3;
        boolean zK4;
        boolean zK5;
        if (I() && this.A0) {
            z0 z0Var = this.z0;
            if (z0Var != null) {
                zK = z0Var.K(5);
                zK3 = z0Var.K(7);
                zK4 = z0Var.K(11);
                zK5 = z0Var.K(12);
                zK2 = z0Var.K(9);
            } else {
                zK = false;
                zK2 = false;
                zK3 = false;
                zK4 = false;
                zK5 = false;
            }
            R(this.J0, zK3, this.c);
            R(this.H0, zK4, this.h);
            R(this.I0, zK5, this.g);
            R(this.K0, zK2, this.d);
            B b2 = this.n;
            if (b2 != null) {
                b2.setEnabled(zK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        boolean z;
        boolean z2;
        if (I() && this.A0) {
            boolean zO = O();
            View view = this.e;
            boolean z3 = true;
            if (view != null) {
                z = zO && view.isFocused();
                z2 = AbstractC9683aN7.a < 21 ? z : zO && b.a(this.e);
                this.e.setVisibility(zO ? 8 : 0);
            } else {
                z = false;
                z2 = false;
            }
            View view2 = this.f;
            if (view2 != null) {
                z |= !zO && view2.isFocused();
                if (AbstractC9683aN7.a < 21) {
                    z3 = z;
                } else if (zO || !b.a(this.f)) {
                    z3 = false;
                }
                z2 |= z3;
                this.f.setVisibility(zO ? 0 : 8);
            }
            if (z) {
                L();
            }
            if (z2) {
                K();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        long jL0;
        long jW0;
        if (I() && this.A0) {
            z0 z0Var = this.z0;
            if (z0Var != null) {
                jL0 = this.R0 + z0Var.l0();
                jW0 = this.R0 + z0Var.w0();
            } else {
                jL0 = 0;
                jW0 = 0;
            }
            boolean z = jL0 != this.S0;
            this.S0 = jL0;
            this.T0 = jW0;
            TextView textView = this.m;
            if (textView != null && !this.D0 && z) {
                textView.setText(AbstractC9683aN7.f0(this.o, this.p, jL0));
            }
            B b2 = this.n;
            if (b2 != null) {
                b2.setPosition(jL0);
                this.n.setBufferedPosition(jW0);
            }
            removeCallbacks(this.s);
            int iP = z0Var == null ? 1 : z0Var.p();
            if (z0Var == null || !z0Var.i()) {
                if (iP == 4 || iP == 1) {
                    return;
                }
                postDelayed(this.s, 1000L);
                return;
            }
            B b3 = this.n;
            long jMin = Math.min(b3 != null ? b3.getPreferredUpdateDelay() : 1000L, 1000 - (jL0 % 1000));
            float f = z0Var.c().a;
            postDelayed(this.s, AbstractC9683aN7.q(f > 0.0f ? (long) (jMin / f) : 1000L, this.F0, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        ImageView imageView;
        if (I() && this.A0 && (imageView = this.i) != null) {
            if (this.G0 == 0) {
                R(false, false, imageView);
                return;
            }
            z0 z0Var = this.z0;
            if (z0Var == null) {
                R(true, false, imageView);
                this.i.setImageDrawable(this.u);
                this.i.setContentDescription(this.x);
                return;
            }
            R(true, true, imageView);
            int iB = z0Var.B();
            if (iB == 0) {
                this.i.setImageDrawable(this.u);
                this.i.setContentDescription(this.x);
            } else if (iB == 1) {
                this.i.setImageDrawable(this.v);
                this.i.setContentDescription(this.y);
            } else if (iB == 2) {
                this.i.setImageDrawable(this.w);
                this.i.setContentDescription(this.z);
            }
            this.i.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        ImageView imageView;
        if (I() && this.A0 && (imageView = this.j) != null) {
            z0 z0Var = this.z0;
            if (!this.L0) {
                R(false, false, imageView);
                return;
            }
            if (z0Var == null) {
                R(true, false, imageView);
                this.j.setImageDrawable(this.B);
                this.j.setContentDescription(this.J);
            } else {
                R(true, true, imageView);
                this.j.setImageDrawable(z0Var.v0() ? this.A : this.B);
                this.j.setContentDescription(z0Var.v0() ? this.H : this.J);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void X() {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.X():void");
    }

    private static boolean z(J0 j0, J0.d dVar) {
        if (j0.u() > 100) {
            return false;
        }
        int iU = j0.u();
        for (int i = 0; i < iU; i++) {
            if (j0.s(i, dVar).n == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    public boolean A(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        z0 z0Var = this.z0;
        if (z0Var == null || !H(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (z0Var.p() == 4) {
                return true;
            }
            z0Var.x0();
            return true;
        }
        if (keyCode == 89) {
            z0Var.y0();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            D(z0Var);
            return true;
        }
        if (keyCode == 87) {
            z0Var.Q();
            return true;
        }
        if (keyCode == 88) {
            z0Var.C();
            return true;
        }
        if (keyCode == 126) {
            C(z0Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        B(z0Var);
        return true;
    }

    public void F() {
        if (I()) {
            setVisibility(8);
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(getVisibility());
            }
            removeCallbacks(this.s);
            removeCallbacks(this.t);
            this.M0 = -9223372036854775807L;
        }
    }

    public boolean I() {
        return getVisibility() == 0;
    }

    public void J(e eVar) {
        this.b.remove(eVar);
    }

    public void P() {
        if (!I()) {
            setVisibility(0);
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(getVisibility());
            }
            Q();
            L();
            K();
        }
        G();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return A(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.t);
        } else if (motionEvent.getAction() == 1) {
            G();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public z0 getPlayer() {
        return this.z0;
    }

    public int getRepeatToggleModes() {
        return this.G0;
    }

    public boolean getShowShuffleButton() {
        return this.L0;
    }

    public int getShowTimeoutMs() {
        return this.E0;
    }

    public boolean getShowVrButton() {
        View view = this.k;
        return view != null && view.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0 = true;
        long j = this.M0;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                F();
            } else {
                postDelayed(this.t, jUptimeMillis);
            }
        } else if (I()) {
            G();
        }
        Q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A0 = false;
        removeCallbacks(this.s);
        removeCallbacks(this.t);
    }

    public void setExtraAdGroupMarkers(long[] jArr, boolean[] zArr) {
        if (jArr == null) {
            this.P0 = new long[0];
            this.Q0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) AbstractC20011rK.e(zArr);
            AbstractC20011rK.a(jArr.length == zArr2.length);
            this.P0 = jArr;
            this.Q0 = zArr2;
        }
        X();
    }

    public void setPlayer(z0 z0Var) {
        AbstractC20011rK.g(Looper.myLooper() == Looper.getMainLooper());
        AbstractC20011rK.a(z0Var == null || z0Var.O() == Looper.getMainLooper());
        z0 z0Var2 = this.z0;
        if (z0Var2 == z0Var) {
            return;
        }
        if (z0Var2 != null) {
            z0Var2.o(this.a);
        }
        this.z0 = z0Var;
        if (z0Var != null) {
            z0Var.m0(this.a);
        }
        Q();
    }

    public void setProgressUpdateListener(d dVar) {
    }

    public void setRepeatToggleModes(int i) {
        this.G0 = i;
        z0 z0Var = this.z0;
        if (z0Var != null) {
            int iB = z0Var.B();
            if (i == 0 && iB != 0) {
                this.z0.s(0);
            } else if (i == 1 && iB == 2) {
                this.z0.s(1);
            } else if (i == 2 && iB == 1) {
                this.z0.s(2);
            }
        }
        V();
    }

    public void setShowFastForwardButton(boolean z) {
        this.I0 = z;
        S();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.B0 = z;
        X();
    }

    public void setShowNextButton(boolean z) {
        this.K0 = z;
        S();
    }

    public void setShowPreviousButton(boolean z) {
        this.J0 = z;
        S();
    }

    public void setShowRewindButton(boolean z) {
        this.H0 = z;
        S();
    }

    public void setShowShuffleButton(boolean z) {
        this.L0 = z;
        W();
    }

    public void setShowTimeoutMs(int i) {
        this.E0 = i;
        if (I()) {
            G();
        }
    }

    public void setShowVrButton(boolean z) {
        View view = this.k;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.F0 = AbstractC9683aN7.p(i, 16, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.k;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            R(getShowVrButton(), onClickListener != null, this.k);
        }
    }

    public void y(e eVar) {
        AbstractC20011rK.e(eVar);
        this.b.add(eVar);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int resourceId = XC5.exo_player_control_view;
        this.E0 = 5000;
        this.G0 = 0;
        this.F0 = 200;
        this.M0 = -9223372036854775807L;
        this.H0 = true;
        this.I0 = true;
        this.J0 = true;
        this.K0 = true;
        this.L0 = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, DE5.PlayerControlView, i, 0);
            try {
                this.E0 = typedArrayObtainStyledAttributes.getInt(DE5.PlayerControlView_show_timeout, this.E0);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(DE5.PlayerControlView_controller_layout_id, resourceId);
                this.G0 = E(typedArrayObtainStyledAttributes, this.G0);
                this.H0 = typedArrayObtainStyledAttributes.getBoolean(DE5.PlayerControlView_show_rewind_button, this.H0);
                this.I0 = typedArrayObtainStyledAttributes.getBoolean(DE5.PlayerControlView_show_fastforward_button, this.I0);
                this.J0 = typedArrayObtainStyledAttributes.getBoolean(DE5.PlayerControlView_show_previous_button, this.J0);
                this.K0 = typedArrayObtainStyledAttributes.getBoolean(DE5.PlayerControlView_show_next_button, this.K0);
                this.L0 = typedArrayObtainStyledAttributes.getBoolean(DE5.PlayerControlView_show_shuffle_button, this.L0);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(DE5.PlayerControlView_time_bar_min_update_interval, this.F0));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.b = new CopyOnWriteArrayList();
        this.q = new J0.b();
        this.r = new J0.d();
        StringBuilder sb = new StringBuilder();
        this.o = sb;
        this.p = new Formatter(sb, Locale.getDefault());
        this.N0 = new long[0];
        this.O0 = new boolean[0];
        this.P0 = new long[0];
        this.Q0 = new boolean[0];
        c cVar = new c();
        this.a = cVar;
        this.s = new Runnable() { // from class: ir.nasim.hg5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.U();
            }
        };
        this.t = new Runnable() { // from class: ir.nasim.ig5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.F();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        B b2 = (B) findViewById(VB5.exo_progress);
        View viewFindViewById = findViewById(VB5.exo_progress_placeholder);
        if (b2 != null) {
            this.n = b2;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(VB5.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.n = defaultTimeBar;
        } else {
            this.n = null;
        }
        this.l = (TextView) findViewById(VB5.exo_duration);
        this.m = (TextView) findViewById(VB5.exo_position);
        B b3 = this.n;
        if (b3 != null) {
            b3.a(cVar);
        }
        View viewFindViewById2 = findViewById(VB5.exo_play);
        this.e = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(VB5.exo_pause);
        this.f = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        View viewFindViewById4 = findViewById(VB5.exo_prev);
        this.c = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(cVar);
        }
        View viewFindViewById5 = findViewById(VB5.exo_next);
        this.d = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(VB5.exo_rew);
        this.h = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(VB5.exo_ffwd);
        this.g = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(VB5.exo_repeat_toggle);
        this.i = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(VB5.exo_shuffle);
        this.j = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View viewFindViewById8 = findViewById(VB5.exo_vr);
        this.k = viewFindViewById8;
        setShowVrButton(false);
        R(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.D = resources.getInteger(CC5.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.G = resources.getInteger(CC5.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.u = AbstractC9683aN7.S(context, resources, FB5.exo_controls_repeat_off);
        this.v = AbstractC9683aN7.S(context, resources, FB5.exo_controls_repeat_one);
        this.w = AbstractC9683aN7.S(context, resources, FB5.exo_controls_repeat_all);
        this.A = AbstractC9683aN7.S(context, resources, FB5.exo_controls_shuffle_on);
        this.B = AbstractC9683aN7.S(context, resources, FB5.exo_controls_shuffle_off);
        this.x = resources.getString(AbstractC20563sD5.exo_controls_repeat_off_description);
        this.y = resources.getString(AbstractC20563sD5.exo_controls_repeat_one_description);
        this.z = resources.getString(AbstractC20563sD5.exo_controls_repeat_all_description);
        this.H = resources.getString(AbstractC20563sD5.exo_controls_shuffle_on_description);
        this.J = resources.getString(AbstractC20563sD5.exo_controls_shuffle_off_description);
        this.S0 = -9223372036854775807L;
        this.T0 = -9223372036854775807L;
    }
}
