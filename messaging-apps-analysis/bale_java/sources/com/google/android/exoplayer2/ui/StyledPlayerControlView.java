package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.K0;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.ui.B;
import com.google.android.exoplayer2.z0;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10774cA5;
import ir.nasim.AbstractC12190eB5;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC15817kD5;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC20563sD5;
import ir.nasim.AbstractC20572sE5;
import ir.nasim.AbstractC9253Zd2;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C6241Mt7;
import ir.nasim.C6740Ot7;
import ir.nasim.CC5;
import ir.nasim.DE5;
import ir.nasim.FB5;
import ir.nasim.FO5;
import ir.nasim.InterfaceC4355Et7;
import ir.nasim.LB5;
import ir.nasim.OF1;
import ir.nasim.VB5;
import ir.nasim.VW5;
import ir.nasim.XC5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class StyledPlayerControlView extends FrameLayout {
    private static final float[] o1;
    private final View A;
    private final J0.b A0;
    private final View B;
    private final J0.d B0;
    private final Runnable C0;
    private final TextView D;
    private final Drawable D0;
    private final Drawable E0;
    private final Drawable F0;
    private final TextView G;
    private final String G0;
    private final B H;
    private final String H0;
    private final String I0;
    private final StringBuilder J;
    private final Drawable J0;
    private final Drawable K0;
    private final float L0;
    private final float M0;
    private final String N0;
    private final String O0;
    private final Drawable P0;
    private final Drawable Q0;
    private final String R0;
    private final String S0;
    private final Drawable T0;
    private final Drawable U0;
    private final String V0;
    private final String W0;
    private z0 X0;
    private f Y0;
    private d Z0;
    private final w a;
    private boolean a1;
    private final Resources b;
    private boolean b1;
    private final c c;
    private boolean c1;
    private final CopyOnWriteArrayList d;
    private boolean d1;
    private final RecyclerView e;
    private boolean e1;
    private final h f;
    private int f1;
    private final e g;
    private int g1;
    private final j h;
    private int h1;
    private final b i;
    private long[] i1;
    private final InterfaceC4355Et7 j;
    private boolean[] j1;
    private final PopupWindow k;
    private long[] k1;
    private final int l;
    private boolean[] l1;
    private final View m;
    private long m1;
    private final View n;
    private boolean n1;
    private final View o;
    private final View p;
    private final View q;
    private final TextView r;
    private final TextView s;
    private final ImageView t;
    private final ImageView u;
    private final View v;
    private final ImageView w;
    private final ImageView x;
    private final ImageView y;
    private final View z;
    private final Formatter z0;

    /* JADX INFO: Access modifiers changed from: private */
    final class b extends l {
        private b() {
            super();
        }

        private boolean H(C6740Ot7 c6740Ot7) {
            for (int i = 0; i < this.d.size(); i++) {
                if (c6740Ot7.y.containsKey(((k) this.d.get(i)).a.c())) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void J(View view) {
            if (StyledPlayerControlView.this.X0 == null || !StyledPlayerControlView.this.X0.K(29)) {
                return;
            }
            ((z0) AbstractC9683aN7.j(StyledPlayerControlView.this.X0)).T(StyledPlayerControlView.this.X0.P().B().B(1).J(1, false).A());
            StyledPlayerControlView.this.f.C(1, StyledPlayerControlView.this.getResources().getString(AbstractC20563sD5.exo_track_selection_auto));
            StyledPlayerControlView.this.k.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void D(i iVar) {
            iVar.u.setText(AbstractC20563sD5.exo_track_selection_auto);
            iVar.v.setVisibility(H(((z0) AbstractC20011rK.e(StyledPlayerControlView.this.X0)).P()) ? 4 : 0);
            iVar.a.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.J(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void F(String str) {
            StyledPlayerControlView.this.f.C(1, str);
        }

        public void I(List list) {
            this.d = list;
            C6740Ot7 c6740Ot7P = ((z0) AbstractC20011rK.e(StyledPlayerControlView.this.X0)).P();
            if (list.isEmpty()) {
                StyledPlayerControlView.this.f.C(1, StyledPlayerControlView.this.getResources().getString(AbstractC20563sD5.exo_track_selection_none));
                return;
            }
            if (!H(c6740Ot7P)) {
                StyledPlayerControlView.this.f.C(1, StyledPlayerControlView.this.getResources().getString(AbstractC20563sD5.exo_track_selection_auto));
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                k kVar = (k) list.get(i);
                if (kVar.a()) {
                    StyledPlayerControlView.this.f.C(1, kVar.c);
                    return;
                }
            }
        }
    }

    private final class c implements z0.d, B.a, View.OnClickListener, PopupWindow.OnDismissListener {
        private c() {
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void M3(z0 z0Var, z0.c cVar) {
            if (cVar.b(4, 5, 13)) {
                StyledPlayerControlView.this.y0();
            }
            if (cVar.b(4, 5, 7, 13)) {
                StyledPlayerControlView.this.A0();
            }
            if (cVar.b(8, 13)) {
                StyledPlayerControlView.this.B0();
            }
            if (cVar.b(9, 13)) {
                StyledPlayerControlView.this.F0();
            }
            if (cVar.b(8, 9, 11, 0, 16, 17, 13)) {
                StyledPlayerControlView.this.x0();
            }
            if (cVar.b(11, 0, 13)) {
                StyledPlayerControlView.this.G0();
            }
            if (cVar.b(12, 13)) {
                StyledPlayerControlView.this.z0();
            }
            if (cVar.b(2, 13)) {
                StyledPlayerControlView.this.H0();
            }
        }

        @Override // com.google.android.exoplayer2.ui.B.a
        public void a(B b, long j) {
            if (StyledPlayerControlView.this.G != null) {
                StyledPlayerControlView.this.G.setText(AbstractC9683aN7.f0(StyledPlayerControlView.this.J, StyledPlayerControlView.this.z0, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.B.a
        public void e(B b, long j, boolean z) {
            StyledPlayerControlView.this.e1 = false;
            if (!z && StyledPlayerControlView.this.X0 != null) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.o0(styledPlayerControlView.X0, j);
            }
            StyledPlayerControlView.this.a.W();
        }

        @Override // com.google.android.exoplayer2.ui.B.a
        public void h(B b, long j) {
            StyledPlayerControlView.this.e1 = true;
            if (StyledPlayerControlView.this.G != null) {
                StyledPlayerControlView.this.G.setText(AbstractC9683aN7.f0(StyledPlayerControlView.this.J, StyledPlayerControlView.this.z0, j));
            }
            StyledPlayerControlView.this.a.V();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z0 z0Var = StyledPlayerControlView.this.X0;
            if (z0Var == null) {
                return;
            }
            StyledPlayerControlView.this.a.W();
            if (StyledPlayerControlView.this.n == view) {
                if (z0Var.K(9)) {
                    z0Var.Q();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.m == view) {
                if (z0Var.K(7)) {
                    z0Var.C();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.p == view) {
                if (z0Var.p() == 4 || !z0Var.K(12)) {
                    return;
                }
                z0Var.x0();
                return;
            }
            if (StyledPlayerControlView.this.q == view) {
                if (z0Var.K(11)) {
                    z0Var.y0();
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.o == view) {
                StyledPlayerControlView.this.X(z0Var);
                return;
            }
            if (StyledPlayerControlView.this.t == view) {
                if (z0Var.K(15)) {
                    z0Var.s(FO5.a(z0Var.B(), StyledPlayerControlView.this.h1));
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.u == view) {
                if (z0Var.K(14)) {
                    z0Var.Y(!z0Var.v0());
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.z == view) {
                StyledPlayerControlView.this.a.V();
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.Y(styledPlayerControlView.f, StyledPlayerControlView.this.z);
                return;
            }
            if (StyledPlayerControlView.this.A == view) {
                StyledPlayerControlView.this.a.V();
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                styledPlayerControlView2.Y(styledPlayerControlView2.g, StyledPlayerControlView.this.A);
            } else if (StyledPlayerControlView.this.B == view) {
                StyledPlayerControlView.this.a.V();
                StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                styledPlayerControlView3.Y(styledPlayerControlView3.i, StyledPlayerControlView.this.B);
            } else if (StyledPlayerControlView.this.w == view) {
                StyledPlayerControlView.this.a.V();
                StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                styledPlayerControlView4.Y(styledPlayerControlView4.h, StyledPlayerControlView.this.w);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (StyledPlayerControlView.this.n1) {
                StyledPlayerControlView.this.a.W();
            }
        }
    }

    public interface d {
        void e(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class e extends RecyclerView.h {
        private final String[] d;
        private final float[] e;
        private int f;

        public e(String[] strArr, float[] fArr) {
            this.d = strArr;
            this.e = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B(int i, View view) {
            if (i != this.f) {
                StyledPlayerControlView.this.setPlaybackSpeed(this.e[i]);
            }
            StyledPlayerControlView.this.k.dismiss();
        }

        public String A() {
            return this.d[this.f];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, final int i) {
            String[] strArr = this.d;
            if (i < strArr.length) {
                iVar.u.setText(strArr[i]);
            }
            if (i == this.f) {
                iVar.a.setSelected(true);
                iVar.v.setVisibility(0);
            } else {
                iVar.a.setSelected(false);
                iVar.v.setVisibility(4);
            }
            iVar.a.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.B(i, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(XC5.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public void E(float f) {
            int i = 0;
            float f2 = Float.MAX_VALUE;
            int i2 = 0;
            while (true) {
                float[] fArr = this.e;
                if (i >= fArr.length) {
                    this.f = i2;
                    return;
                }
                float fAbs = Math.abs(f - fArr[i]);
                if (fAbs < f2) {
                    i2 = i;
                    f2 = fAbs;
                }
                i++;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return this.d.length;
        }
    }

    public interface f {
        void a(long j, long j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class g extends RecyclerView.C {
        private final TextView u;
        private final TextView v;
        private final ImageView w;

        public g(View view) {
            super(view);
            if (AbstractC9683aN7.a < 26) {
                view.setFocusable(true);
            }
            this.u = (TextView) view.findViewById(VB5.exo_main_text);
            this.v = (TextView) view.findViewById(VB5.exo_sub_text);
            this.w = (ImageView) view.findViewById(VB5.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.H0(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void H0(View view) {
            StyledPlayerControlView.this.l0(J());
        }
    }

    private class h extends RecyclerView.h {
        private final String[] d;
        private final String[] e;
        private final Drawable[] f;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.d = strArr;
            this.e = new String[strArr.length];
            this.f = drawableArr;
        }

        private boolean D(int i) {
            if (StyledPlayerControlView.this.X0 == null) {
                return false;
            }
            if (i == 0) {
                return StyledPlayerControlView.this.X0.K(13);
            }
            if (i != 1) {
                return true;
            }
            return StyledPlayerControlView.this.X0.K(30) && StyledPlayerControlView.this.X0.K(29);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i) {
            if (D(i)) {
                gVar.a.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                gVar.a.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
            gVar.u.setText(this.d[i]);
            if (this.e[i] == null) {
                gVar.v.setVisibility(8);
            } else {
                gVar.v.setText(this.e[i]);
            }
            if (this.f[i] == null) {
                gVar.w.setVisibility(8);
            } else {
                gVar.w.setImageDrawable(this.f[i]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i) {
            return StyledPlayerControlView.this.new g(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(XC5.exo_styled_settings_list_item, viewGroup, false));
        }

        public void C(int i, String str) {
            this.e[i] = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return this.d.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public long getItemId(int i) {
            return i;
        }

        public boolean z() {
            return D(1) || D(0);
        }
    }

    private static class i extends RecyclerView.C {
        public final TextView u;
        public final View v;

        public i(View view) {
            super(view);
            if (AbstractC9683aN7.a < 26) {
                view.setFocusable(true);
            }
            this.u = (TextView) view.findViewById(VB5.exo_text);
            this.v = view.findViewById(VB5.exo_check);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class j extends l {
        private j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void I(View view) {
            if (StyledPlayerControlView.this.X0 == null || !StyledPlayerControlView.this.X0.K(29)) {
                return;
            }
            StyledPlayerControlView.this.X0.T(StyledPlayerControlView.this.X0.P().B().B(3).F(-3).A());
            StyledPlayerControlView.this.k.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l, androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i) {
            super.onBindViewHolder(iVar, i);
            if (i > 0) {
                iVar.v.setVisibility(((k) this.d.get(i + (-1))).a() ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void D(i iVar) {
            boolean z;
            iVar.u.setText(AbstractC20563sD5.exo_track_selection_none);
            int i = 0;
            while (true) {
                if (i >= this.d.size()) {
                    z = true;
                    break;
                } else {
                    if (((k) this.d.get(i)).a()) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            iVar.v.setVisibility(z ? 0 : 4);
            iVar.a.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.I(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void F(String str) {
        }

        public void H(List list) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (((k) list.get(i)).a()) {
                    z = true;
                    break;
                }
                i++;
            }
            if (StyledPlayerControlView.this.w != null) {
                ImageView imageView = StyledPlayerControlView.this.w;
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                imageView.setImageDrawable(z ? styledPlayerControlView.P0 : styledPlayerControlView.Q0);
                StyledPlayerControlView.this.w.setContentDescription(z ? StyledPlayerControlView.this.R0 : StyledPlayerControlView.this.S0);
            }
            this.d = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class k {
        public final K0.a a;
        public final int b;
        public final String c;

        public k(K0 k0, int i, int i2, String str) {
            this.a = (K0.a) k0.c().get(i);
            this.b = i2;
            this.c = str;
        }

        public boolean a() {
            return this.a.h(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    abstract class l extends RecyclerView.h {
        protected List d = new ArrayList();

        protected l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B(z0 z0Var, TrackGroup trackGroup, k kVar, View view) {
            if (z0Var.K(29)) {
                z0Var.T(z0Var.P().B().G(new C6241Mt7(trackGroup, AbstractC12710f43.W(Integer.valueOf(kVar.b)))).J(kVar.a.e(), false).A());
                F(kVar.c);
                StyledPlayerControlView.this.k.dismiss();
            }
        }

        protected void A() {
            this.d = Collections.emptyList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: C */
        public void onBindViewHolder(i iVar, int i) {
            final z0 z0Var = StyledPlayerControlView.this.X0;
            if (z0Var == null) {
                return;
            }
            if (i == 0) {
                D(iVar);
                return;
            }
            final k kVar = (k) this.d.get(i - 1);
            final TrackGroup trackGroupC = kVar.a.c();
            boolean z = z0Var.P().y.get(trackGroupC) != null && kVar.a();
            iVar.u.setText(kVar.c);
            iVar.v.setVisibility(z ? 0 : 4);
            iVar.a.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.B(z0Var, trackGroupC, kVar, view);
                }
            });
        }

        protected abstract void D(i iVar);

        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(XC5.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        protected abstract void F(String str);

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            if (this.d.isEmpty()) {
                return 0;
            }
            return this.d.size() + 1;
        }
    }

    public interface m {
        void a(int i);
    }

    static {
        AbstractC9253Zd2.a("goog.exo.ui");
        o1 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        long jL0;
        long jW0;
        if (h0() && this.b1) {
            z0 z0Var = this.X0;
            if (z0Var == null || !z0Var.K(16)) {
                jL0 = 0;
                jW0 = 0;
            } else {
                jL0 = this.m1 + z0Var.l0();
                jW0 = this.m1 + z0Var.w0();
            }
            TextView textView = this.G;
            if (textView != null && !this.e1) {
                textView.setText(AbstractC9683aN7.f0(this.J, this.z0, jL0));
            }
            B b2 = this.H;
            if (b2 != null) {
                b2.setPosition(jL0);
                this.H.setBufferedPosition(jW0);
            }
            f fVar = this.Y0;
            if (fVar != null) {
                fVar.a(jL0, jW0);
            }
            removeCallbacks(this.C0);
            int iP = z0Var == null ? 1 : z0Var.p();
            if (z0Var == null || !z0Var.i()) {
                if (iP == 4 || iP == 1) {
                    return;
                }
                postDelayed(this.C0, 1000L);
                return;
            }
            B b3 = this.H;
            long jMin = Math.min(b3 != null ? b3.getPreferredUpdateDelay() : 1000L, 1000 - (jL0 % 1000));
            float f2 = z0Var.c().a;
            postDelayed(this.C0, AbstractC9683aN7.q(f2 > 0.0f ? (long) (jMin / f2) : 1000L, this.g1, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        ImageView imageView;
        if (h0() && this.b1 && (imageView = this.t) != null) {
            if (this.h1 == 0) {
                t0(false, imageView);
                return;
            }
            z0 z0Var = this.X0;
            if (z0Var == null || !z0Var.K(15)) {
                t0(false, this.t);
                this.t.setImageDrawable(this.D0);
                this.t.setContentDescription(this.G0);
                return;
            }
            t0(true, this.t);
            int iB = z0Var.B();
            if (iB == 0) {
                this.t.setImageDrawable(this.D0);
                this.t.setContentDescription(this.G0);
            } else if (iB == 1) {
                this.t.setImageDrawable(this.E0);
                this.t.setContentDescription(this.H0);
            } else {
                if (iB != 2) {
                    return;
                }
                this.t.setImageDrawable(this.F0);
                this.t.setContentDescription(this.I0);
            }
        }
    }

    private void C0() {
        z0 z0Var = this.X0;
        int iE0 = (int) ((z0Var != null ? z0Var.E0() : 5000L) / 1000);
        TextView textView = this.s;
        if (textView != null) {
            textView.setText(String.valueOf(iE0));
        }
        View view = this.q;
        if (view != null) {
            view.setContentDescription(this.b.getQuantityString(AbstractC15817kD5.exo_controls_rewind_by_amount_description, iE0, Integer.valueOf(iE0)));
        }
    }

    private void D0() {
        t0(this.f.z(), this.z);
    }

    private void E0() {
        this.e.measure(0, 0);
        this.k.setWidth(Math.min(this.e.getMeasuredWidth(), getWidth() - (this.l * 2)));
        this.k.setHeight(Math.min(getHeight() - (this.l * 2), this.e.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        ImageView imageView;
        if (h0() && this.b1 && (imageView = this.u) != null) {
            z0 z0Var = this.X0;
            if (!this.a.A(imageView)) {
                t0(false, this.u);
                return;
            }
            if (z0Var == null || !z0Var.K(14)) {
                t0(false, this.u);
                this.u.setImageDrawable(this.K0);
                this.u.setContentDescription(this.O0);
            } else {
                t0(true, this.u);
                this.u.setImageDrawable(z0Var.v0() ? this.J0 : this.K0);
                this.u.setContentDescription(z0Var.v0() ? this.N0 : this.O0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G0() {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.StyledPlayerControlView.G0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        d0();
        t0(this.h.getItemCount() > 0, this.w);
        D0();
    }

    private static boolean T(z0 z0Var, J0.d dVar) {
        J0 j0N;
        int iU;
        if (!z0Var.K(17) || (iU = (j0N = z0Var.N()).u()) <= 1 || iU > 100) {
            return false;
        }
        for (int i2 = 0; i2 < iU; i2++) {
            if (j0N.s(i2, dVar).n == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    private void V(z0 z0Var) {
        if (z0Var.K(1)) {
            z0Var.h();
        }
    }

    private void W(z0 z0Var) {
        int iP = z0Var.p();
        if (iP == 1 && z0Var.K(2)) {
            z0Var.r();
        } else if (iP == 4 && z0Var.K(4)) {
            z0Var.t();
        }
        if (z0Var.K(1)) {
            z0Var.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(z0 z0Var) {
        int iP = z0Var.p();
        if (iP == 1 || iP == 4 || !z0Var.X()) {
            W(z0Var);
        } else {
            V(z0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(RecyclerView.h hVar, View view) {
        this.e.setAdapter(hVar);
        E0();
        this.n1 = false;
        this.k.dismiss();
        this.n1 = true;
        this.k.showAsDropDown(view, (getWidth() - this.k.getWidth()) - this.l, (-this.k.getHeight()) - this.l);
    }

    private AbstractC12710f43 Z(K0 k0, int i2) {
        AbstractC12710f43.a aVar = new AbstractC12710f43.a();
        AbstractC12710f43 abstractC12710f43C = k0.c();
        for (int i3 = 0; i3 < abstractC12710f43C.size(); i3++) {
            K0.a aVar2 = (K0.a) abstractC12710f43C.get(i3);
            if (aVar2.e() == i2) {
                for (int i4 = 0; i4 < aVar2.a; i4++) {
                    if (aVar2.i(i4)) {
                        X xD = aVar2.d(i4);
                        if ((xD.d & 2) == 0) {
                            aVar.a(new k(k0, i3, i4, this.j.a(xD)));
                        }
                    }
                }
            }
        }
        return aVar.h();
    }

    private static int a0(TypedArray typedArray, int i2) {
        return typedArray.getInt(DE5.StyledPlayerControlView_repeat_toggle_modes, i2);
    }

    private void d0() {
        this.h.A();
        this.i.A();
        z0 z0Var = this.X0;
        if (z0Var != null && z0Var.K(30) && this.X0.K(29)) {
            K0 k0F = this.X0.F();
            this.i.I(Z(k0F, 1));
            if (this.a.A(this.w)) {
                this.h.H(Z(k0F, 3));
            } else {
                this.h.H(AbstractC12710f43.V());
            }
        }
    }

    private static void e0(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    private static boolean g0(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(View view) {
        if (this.Z0 == null) {
            return;
        }
        boolean z = !this.a1;
        this.a1 = z;
        v0(this.x, z);
        v0(this.y, this.a1);
        d dVar = this.Z0;
        if (dVar != null) {
            dVar.e(this.a1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5 - i3;
        int i11 = i9 - i7;
        if (!(i4 - i2 == i8 - i6 && i10 == i11) && this.k.isShowing()) {
            E0();
            this.k.update(view, (getWidth() - this.k.getWidth()) - this.l, (-this.k.getHeight()) - this.l, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(int i2) {
        if (i2 == 0) {
            Y(this.g, (View) AbstractC20011rK.e(this.z));
        } else if (i2 == 1) {
            Y(this.i, (View) AbstractC20011rK.e(this.z));
        } else {
            this.k.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(z0 z0Var, long j2) {
        if (this.d1) {
            if (z0Var.K(17) && z0Var.K(10)) {
                J0 j0N = z0Var.N();
                int iU = j0N.u();
                int i2 = 0;
                while (true) {
                    long jG = j0N.s(i2, this.B0).g();
                    if (j2 < jG) {
                        break;
                    }
                    if (i2 == iU - 1) {
                        j2 = jG;
                        break;
                    } else {
                        j2 -= jG;
                        i2++;
                    }
                }
                z0Var.U(i2, j2);
            }
        } else if (z0Var.K(5)) {
            z0Var.x(j2);
        }
        A0();
    }

    private boolean p0() {
        z0 z0Var = this.X0;
        return (z0Var == null || !z0Var.K(1) || (this.X0.K(17) && this.X0.N().v())) ? false : true;
    }

    private boolean q0() {
        z0 z0Var = this.X0;
        return (z0Var == null || z0Var.p() == 4 || this.X0.p() == 1 || !this.X0.X()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
        z0 z0Var = this.X0;
        if (z0Var == null || !z0Var.K(13)) {
            return;
        }
        z0 z0Var2 = this.X0;
        z0Var2.e(z0Var2.c().e(f2));
    }

    private void t0(boolean z, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        view.setAlpha(z ? this.L0 : this.M0);
    }

    private void u0() {
        z0 z0Var = this.X0;
        int iK0 = (int) ((z0Var != null ? z0Var.k0() : 15000L) / 1000);
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(String.valueOf(iK0));
        }
        View view = this.p;
        if (view != null) {
            view.setContentDescription(this.b.getQuantityString(AbstractC15817kD5.exo_controls_fastforward_by_amount_description, iK0, Integer.valueOf(iK0)));
        }
    }

    private void v0(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(this.T0);
            imageView.setContentDescription(this.V0);
        } else {
            imageView.setImageDrawable(this.U0);
            imageView.setContentDescription(this.W0);
        }
    }

    private static void w0(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        boolean zK;
        boolean zK2;
        boolean zK3;
        boolean zK4;
        boolean zK5;
        if (h0() && this.b1) {
            z0 z0Var = this.X0;
            if (z0Var != null) {
                zK = (this.c1 && T(z0Var, this.B0)) ? z0Var.K(10) : z0Var.K(5);
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
            if (zK4) {
                C0();
            }
            if (zK5) {
                u0();
            }
            t0(zK3, this.m);
            t0(zK4, this.q);
            t0(zK5, this.p);
            t0(zK2, this.n);
            B b2 = this.H;
            if (b2 != null) {
                b2.setEnabled(zK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        if (h0() && this.b1 && this.o != null) {
            boolean zQ0 = q0();
            int i2 = zQ0 ? FB5.exo_styled_controls_pause : FB5.exo_styled_controls_play;
            int i3 = zQ0 ? AbstractC20563sD5.exo_controls_pause_description : AbstractC20563sD5.exo_controls_play_description;
            ((ImageView) this.o).setImageDrawable(AbstractC9683aN7.S(getContext(), this.b, i2));
            this.o.setContentDescription(this.b.getString(i3));
            t0(p0(), this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        z0 z0Var = this.X0;
        if (z0Var == null) {
            return;
        }
        this.g.E(z0Var.c().a);
        this.f.C(0, this.g.A());
        D0();
    }

    public void S(m mVar) {
        AbstractC20011rK.e(mVar);
        this.d.add(mVar);
    }

    public boolean U(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        z0 z0Var = this.X0;
        if (z0Var == null || !g0(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (z0Var.p() == 4 || !z0Var.K(12)) {
                return true;
            }
            z0Var.x0();
            return true;
        }
        if (keyCode == 89 && z0Var.K(11)) {
            z0Var.y0();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            X(z0Var);
            return true;
        }
        if (keyCode == 87) {
            if (!z0Var.K(9)) {
                return true;
            }
            z0Var.Q();
            return true;
        }
        if (keyCode == 88) {
            if (!z0Var.K(7)) {
                return true;
            }
            z0Var.C();
            return true;
        }
        if (keyCode == 126) {
            W(z0Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        V(z0Var);
        return true;
    }

    public void b0() {
        this.a.C();
    }

    public void c0() {
        this.a.F();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return U(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean f0() {
        return this.a.I();
    }

    public z0 getPlayer() {
        return this.X0;
    }

    public int getRepeatToggleModes() {
        return this.h1;
    }

    public boolean getShowShuffleButton() {
        return this.a.A(this.u);
    }

    public boolean getShowSubtitleButton() {
        return this.a.A(this.w);
    }

    public int getShowTimeoutMs() {
        return this.f1;
    }

    public boolean getShowVrButton() {
        return this.a.A(this.v);
    }

    public boolean h0() {
        return getVisibility() == 0;
    }

    void i0() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((m) it.next()).a(getVisibility());
        }
    }

    public void m0(m mVar) {
        this.d.remove(mVar);
    }

    void n0() {
        View view = this.o;
        if (view != null) {
            view.requestFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.O();
        this.b1 = true;
        if (f0()) {
            this.a.W();
        }
        s0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.P();
        this.b1 = false;
        removeCallbacks(this.C0);
        this.a.V();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.a.Q(z, i2, i3, i4, i5);
    }

    public void r0() {
        this.a.b0();
    }

    void s0() {
        y0();
        x0();
        B0();
        F0();
        H0();
        z0();
        G0();
    }

    public void setAnimationEnabled(boolean z) {
        this.a.X(z);
    }

    public void setExtraAdGroupMarkers(long[] jArr, boolean[] zArr) {
        if (jArr == null) {
            this.k1 = new long[0];
            this.l1 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) AbstractC20011rK.e(zArr);
            AbstractC20011rK.a(jArr.length == zArr2.length);
            this.k1 = jArr;
            this.l1 = zArr2;
        }
        G0();
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(d dVar) {
        this.Z0 = dVar;
        w0(this.x, dVar != null);
        w0(this.y, dVar != null);
    }

    public void setPlayer(z0 z0Var) {
        AbstractC20011rK.g(Looper.myLooper() == Looper.getMainLooper());
        AbstractC20011rK.a(z0Var == null || z0Var.O() == Looper.getMainLooper());
        z0 z0Var2 = this.X0;
        if (z0Var2 == z0Var) {
            return;
        }
        if (z0Var2 != null) {
            z0Var2.o(this.c);
        }
        this.X0 = z0Var;
        if (z0Var != null) {
            z0Var.m0(this.c);
        }
        s0();
    }

    public void setProgressUpdateListener(f fVar) {
        this.Y0 = fVar;
    }

    public void setRepeatToggleModes(int i2) {
        this.h1 = i2;
        z0 z0Var = this.X0;
        if (z0Var != null && z0Var.K(15)) {
            int iB = this.X0.B();
            if (i2 == 0 && iB != 0) {
                this.X0.s(0);
            } else if (i2 == 1 && iB == 2) {
                this.X0.s(1);
            } else if (i2 == 2 && iB == 1) {
                this.X0.s(2);
            }
        }
        this.a.Y(this.t, i2 != 0);
        B0();
    }

    public void setShowFastForwardButton(boolean z) {
        this.a.Y(this.p, z);
        x0();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.c1 = z;
        G0();
    }

    public void setShowNextButton(boolean z) {
        this.a.Y(this.n, z);
        x0();
    }

    public void setShowPreviousButton(boolean z) {
        this.a.Y(this.m, z);
        x0();
    }

    public void setShowRewindButton(boolean z) {
        this.a.Y(this.q, z);
        x0();
    }

    public void setShowShuffleButton(boolean z) {
        this.a.Y(this.u, z);
        F0();
    }

    public void setShowSubtitleButton(boolean z) {
        this.a.Y(this.w, z);
    }

    public void setShowTimeoutMs(int i2) {
        this.f1 = i2;
        if (f0()) {
            this.a.W();
        }
    }

    public void setShowVrButton(boolean z) {
        this.a.Y(this.v, z);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.g1 = AbstractC9683aN7.p(i2, 16, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.v;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            t0(onClickListener != null, this.v);
        }
    }

    public StyledPlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    public StyledPlayerControlView(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        c cVar;
        boolean z9;
        boolean z10;
        TextView textView;
        boolean z11;
        super(context, attributeSet, i2);
        int resourceId = XC5.exo_styled_player_control_view;
        this.f1 = 5000;
        this.h1 = 0;
        this.g1 = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, DE5.StyledPlayerControlView, i2, 0);
            try {
                resourceId = typedArrayObtainStyledAttributes.getResourceId(DE5.StyledPlayerControlView_controller_layout_id, resourceId);
                this.f1 = typedArrayObtainStyledAttributes.getInt(DE5.StyledPlayerControlView_show_timeout, this.f1);
                this.h1 = a0(typedArrayObtainStyledAttributes, this.h1);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerControlView_show_rewind_button, true);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerControlView_show_fastforward_button, true);
                boolean z14 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerControlView_show_previous_button, true);
                boolean z15 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerControlView_show_next_button, true);
                boolean z16 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerControlView_show_shuffle_button, false);
                boolean z17 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerControlView_show_subtitle_button, false);
                boolean z18 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(DE5.StyledPlayerControlView_time_bar_min_update_interval, this.g1));
                boolean z19 = typedArrayObtainStyledAttributes.getBoolean(DE5.StyledPlayerControlView_animation_enabled, true);
                typedArrayObtainStyledAttributes.recycle();
                z3 = z17;
                z7 = z14;
                z = z18;
                z8 = z15;
                z5 = z12;
                z6 = z13;
                z4 = z19;
                z2 = z16;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = true;
            z5 = true;
            z6 = true;
            z7 = true;
            z8 = true;
        }
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        c cVar2 = new c();
        this.c = cVar2;
        this.d = new CopyOnWriteArrayList();
        this.A0 = new J0.b();
        this.B0 = new J0.d();
        StringBuilder sb = new StringBuilder();
        this.J = sb;
        this.z0 = new Formatter(sb, Locale.getDefault());
        this.i1 = new long[0];
        this.j1 = new boolean[0];
        this.k1 = new long[0];
        this.l1 = new boolean[0];
        this.C0 = new Runnable() { // from class: ir.nasim.JZ6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.A0();
            }
        };
        this.D = (TextView) findViewById(VB5.exo_duration);
        this.G = (TextView) findViewById(VB5.exo_position);
        ImageView imageView = (ImageView) findViewById(VB5.exo_subtitle);
        this.w = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar2);
        }
        ImageView imageView2 = (ImageView) findViewById(VB5.exo_fullscreen);
        this.x = imageView2;
        e0(imageView2, new View.OnClickListener() { // from class: ir.nasim.KZ6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.j0(view);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(VB5.exo_minimal_fullscreen);
        this.y = imageView3;
        e0(imageView3, new View.OnClickListener() { // from class: ir.nasim.KZ6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.j0(view);
            }
        });
        View viewFindViewById = findViewById(VB5.exo_settings);
        this.z = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(cVar2);
        }
        View viewFindViewById2 = findViewById(VB5.exo_playback_speed);
        this.A = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar2);
        }
        View viewFindViewById3 = findViewById(VB5.exo_audio_track);
        this.B = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar2);
        }
        B b2 = (B) findViewById(VB5.exo_progress);
        View viewFindViewById4 = findViewById(VB5.exo_progress_placeholder);
        if (b2 != null) {
            this.H = b2;
            cVar = cVar2;
            z9 = z4;
            z10 = z;
            textView = null;
        } else if (viewFindViewById4 != null) {
            textView = null;
            cVar = cVar2;
            z9 = z4;
            z10 = z;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, AbstractC20572sE5.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(VB5.exo_progress);
            defaultTimeBar.setLayoutParams(viewFindViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById4.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById4);
            viewGroup.removeView(viewFindViewById4);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.H = defaultTimeBar;
        } else {
            cVar = cVar2;
            z9 = z4;
            z10 = z;
            textView = null;
            this.H = null;
        }
        B b3 = this.H;
        c cVar3 = cVar;
        if (b3 != null) {
            b3.a(cVar3);
        }
        View viewFindViewById5 = findViewById(VB5.exo_play_pause);
        this.o = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar3);
        }
        View viewFindViewById6 = findViewById(VB5.exo_prev);
        this.m = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar3);
        }
        View viewFindViewById7 = findViewById(VB5.exo_next);
        this.n = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar3);
        }
        Typeface typefaceH = VW5.h(context, LB5.roboto_medium_numbers);
        View viewFindViewById8 = findViewById(VB5.exo_rew);
        TextView textView2 = viewFindViewById8 == null ? (TextView) findViewById(VB5.exo_rew_with_amount) : textView;
        this.s = textView2;
        if (textView2 != null) {
            textView2.setTypeface(typefaceH);
        }
        viewFindViewById8 = viewFindViewById8 == null ? textView2 : viewFindViewById8;
        this.q = viewFindViewById8;
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(cVar3);
        }
        View viewFindViewById9 = findViewById(VB5.exo_ffwd);
        TextView textView3 = viewFindViewById9 == null ? (TextView) findViewById(VB5.exo_ffwd_with_amount) : null;
        this.r = textView3;
        if (textView3 != null) {
            textView3.setTypeface(typefaceH);
        }
        viewFindViewById9 = viewFindViewById9 == null ? textView3 : viewFindViewById9;
        this.p = viewFindViewById9;
        if (viewFindViewById9 != null) {
            viewFindViewById9.setOnClickListener(cVar3);
        }
        ImageView imageView4 = (ImageView) findViewById(VB5.exo_repeat_toggle);
        this.t = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar3);
        }
        ImageView imageView5 = (ImageView) findViewById(VB5.exo_shuffle);
        this.u = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar3);
        }
        Resources resources = context.getResources();
        this.b = resources;
        this.L0 = resources.getInteger(CC5.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.M0 = resources.getInteger(CC5.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View viewFindViewById10 = findViewById(VB5.exo_vr);
        this.v = viewFindViewById10;
        boolean z20 = z3;
        if (viewFindViewById10 != null) {
            t0(false, viewFindViewById10);
        }
        w wVar = new w(this);
        this.a = wVar;
        wVar.X(z9);
        boolean z21 = z2;
        h hVar = new h(new String[]{resources.getString(AbstractC20563sD5.exo_controls_playback_speed), resources.getString(AbstractC20563sD5.exo_track_selection_title_audio)}, new Drawable[]{AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_speed), AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_audiotrack)});
        this.f = hVar;
        this.l = resources.getDimensionPixelSize(AbstractC12190eB5.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(XC5.exo_styled_settings_list, (ViewGroup) null);
        this.e = recyclerView;
        recyclerView.setAdapter(hVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
        this.k = popupWindow;
        if (AbstractC9683aN7.a < 23) {
            z11 = false;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        } else {
            z11 = false;
        }
        popupWindow.setOnDismissListener(cVar3);
        this.n1 = true;
        this.j = new OF1(getResources());
        this.P0 = AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_subtitle_on);
        this.Q0 = AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_subtitle_off);
        this.R0 = resources.getString(AbstractC20563sD5.exo_controls_cc_enabled_description);
        this.S0 = resources.getString(AbstractC20563sD5.exo_controls_cc_disabled_description);
        this.h = new j();
        this.i = new b();
        this.g = new e(resources.getStringArray(AbstractC10774cA5.exo_controls_playback_speeds), o1);
        this.T0 = AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_fullscreen_exit);
        this.U0 = AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_fullscreen_enter);
        this.D0 = AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_repeat_off);
        this.E0 = AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_repeat_one);
        this.F0 = AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_repeat_all);
        this.J0 = AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_shuffle_on);
        this.K0 = AbstractC9683aN7.S(context, resources, FB5.exo_styled_controls_shuffle_off);
        this.V0 = resources.getString(AbstractC20563sD5.exo_controls_fullscreen_exit_description);
        this.W0 = resources.getString(AbstractC20563sD5.exo_controls_fullscreen_enter_description);
        this.G0 = resources.getString(AbstractC20563sD5.exo_controls_repeat_off_description);
        this.H0 = resources.getString(AbstractC20563sD5.exo_controls_repeat_one_description);
        this.I0 = resources.getString(AbstractC20563sD5.exo_controls_repeat_all_description);
        this.N0 = resources.getString(AbstractC20563sD5.exo_controls_shuffle_on_description);
        this.O0 = resources.getString(AbstractC20563sD5.exo_controls_shuffle_off_description);
        wVar.Y((ViewGroup) findViewById(VB5.exo_bottom_bar), true);
        wVar.Y(viewFindViewById9, z6);
        wVar.Y(viewFindViewById8, z5);
        wVar.Y(viewFindViewById6, z7);
        wVar.Y(viewFindViewById7, z8);
        wVar.Y(imageView5, z21);
        wVar.Y(imageView, z20);
        wVar.Y(viewFindViewById10, z10);
        wVar.Y(imageView4, this.h1 != 0 ? true : z11);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ir.nasim.LZ6
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                this.a.k0(view, i3, i4, i5, i6, i7, i8, i9, i10);
            }
        });
    }
}
