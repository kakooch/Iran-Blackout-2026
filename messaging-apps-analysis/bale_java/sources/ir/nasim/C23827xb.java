package ir.nasim;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.xb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C23827xb extends C22042ua0 implements InterfaceC22631va, CompoundButton.OnCheckedChangeListener {
    private ConstraintLayout A1;
    private ConstraintLayout B1;
    private ConstraintLayout C1;
    private ConstraintLayout D1;
    private ConstraintLayout E1;
    private ConstraintLayout F1;
    private ConstraintLayout G1;
    private ConstraintLayout H1;
    private ConstraintLayout I1;
    private View J1;
    private View K1;
    private View L1;
    private View M1;
    private View N1;
    private View O1;
    private View P1;
    private View Q1;
    private View R1;
    private View S1;
    private View U1;
    private View V1;
    private FullWidthButtonPrimary W1;
    private C14733iO2 Y1;
    private boolean Z1;
    private ProgressBar a2;
    private boolean b2;
    private C22041ua c1;
    private boolean c2;
    private C24119y45 d1;
    private boolean d2;
    private AvatarViewGlide e1;
    private C23104wM2 e2;
    private TextView f1;
    private TextView g1;
    private TextView h1;
    private C21231tK7 i1;
    private int j1;
    private C17468n10 k1;
    private SwitchCompat l1;
    private SwitchCompat m1;
    private SwitchCompat n1;
    private SwitchCompat o1;
    private SwitchCompat p1;
    private SwitchCompat q1;
    private SwitchCompat r1;
    private SwitchCompat s1;
    private SwitchCompat t1;
    private SwitchCompat u1;
    private SwitchCompat v1;
    private SwitchCompat w1;
    private ConstraintLayout x1;
    private ConstraintLayout y1;
    private ConstraintLayout z1;
    private boolean X1 = false;
    private String f2 = null;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Aa(C24119y45 c24119y45) {
        this.p1.setChecked(c24119y45.h());
        this.s1.setChecked(c24119y45.c());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Ba(C24119y45 c24119y45) {
        this.o1.setChecked(c24119y45.j());
        this.v1.setChecked(c24119y45.k());
        this.t1.setChecked(c24119y45.r());
        this.u1.setChecked(c24119y45.e());
        if (C8386Vt0.da()) {
            this.s1.setChecked(c24119y45.c());
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Ca() {
        this.p1.jumpDrawablesToCurrentState();
        this.s1.jumpDrawablesToCurrentState();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Da() {
        this.o1.jumpDrawablesToCurrentState();
        this.v1.jumpDrawablesToCurrentState();
        this.t1.jumpDrawablesToCurrentState();
        this.u1.jumpDrawablesToCurrentState();
        if (C8386Vt0.da()) {
            this.s1.jumpDrawablesToCurrentState();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Ea() {
        this.p1.setOnCheckedChangeListener(this);
        this.s1.setOnCheckedChangeListener(this);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Fa() {
        this.o1.setOnCheckedChangeListener(this);
        this.v1.setOnCheckedChangeListener(this);
        this.t1.setOnCheckedChangeListener(this);
        this.u1.setOnCheckedChangeListener(this);
        if (C8386Vt0.da()) {
            this.s1.setOnCheckedChangeListener(this);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Ga() {
        this.b2 = (this.d1.f() == this.l1.isChecked() && this.d1.q() == this.m1.isChecked() && this.d1.i() == this.n1.isChecked() && this.d1.h() == this.p1.isChecked() && this.d1.g() == this.q1.isChecked() && this.d1.b() == this.r1.isChecked() && this.d1.c() == this.s1.isChecked()) ? false : true;
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Ha() {
        this.b2 = (this.d1.f() == this.l1.isChecked() && this.d1.q() == this.m1.isChecked() && this.d1.i() == this.n1.isChecked() && this.d1.j() == this.o1.isChecked() && this.d1.k() == this.v1.isChecked() && this.d1.g() == this.q1.isChecked() && this.d1.b() == this.r1.isChecked() && this.d1.c() == this.s1.isChecked() && this.d1.r() == this.t1.isChecked() && this.d1.e() == this.u1.isChecked()) ? false : true;
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ia(View view) {
        n8(XV7.a(this.i1.o(), A5()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ja(Avatar avatar, AbstractC13554gQ7 abstractC13554gQ7) {
        this.e1.B(22.0f, true);
        this.e1.r((C21231tK7) AbstractC5969Lp4.g().n(this.i1.o()));
        this.e1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ub
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ia(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ka(View view) {
        this.q1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void La(View view) {
        this.r1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ma(View view) {
        this.s1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Na(View view) {
        this.t1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oa(View view) {
        this.u1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Pa(View view) {
        this.w1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qa(String str, AbstractC13554gQ7 abstractC13554gQ7) {
        this.f1.setText(R62.S(str, this.f1.getPaint().getFontMetricsInt(), AbstractC7426Rr.z(20.0f), false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ra(Integer num, int i, View view) {
        C23104wM2 c23104wM2;
        C24119y45 c24119y45Wa = wa();
        if (num != null && (c23104wM2 = this.e2) != null && !Objects.equals(this.f2, c23104wM2.d()) && C8386Vt0.b9()) {
            this.c1.p(i, num.intValue(), this.f2, c24119y45Wa, this.b2 || this.c2);
        }
        if (!this.c2 || num == null) {
            if (!this.b2 || num == null) {
                return;
            }
            this.c1.o(i, num.intValue(), c24119y45Wa);
            return;
        }
        C22041ua c22041ua = this.c1;
        int iIntValue = num.intValue();
        C23104wM2 c23104wM22 = this.e2;
        c22041ua.n(i, iIntValue, (c23104wM22 == null || Objects.equals(this.f2, c23104wM22.d()) || !C8386Vt0.b9()) ? null : this.f2, c24119y45Wa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Sa(String str) {
        this.f2 = str;
        va(this.b2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ta(View view) {
        this.l1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ua(View view) {
        this.m1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Va(View view) {
        this.n1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wa(View view) {
        this.o1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xa(View view) {
        this.v1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ya(View view) {
        this.p1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Za(C24119y45 c24119y45) {
        boolean z = false;
        this.v1.setClickable(this.X1 && c24119y45.j());
        this.H1.setClickable(this.X1 && c24119y45.k());
        this.o1.setClickable(this.X1 && c24119y45.j());
        ConstraintLayout constraintLayout = this.A1;
        if (this.X1 && c24119y45.j()) {
            z = true;
        }
        constraintLayout.setClickable(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object ab(C24119y45 c24119y45) {
        boolean z = false;
        this.p1.setClickable(this.X1 && c24119y45.h());
        ConstraintLayout constraintLayout = this.B1;
        if (this.X1 && c24119y45.h()) {
            z = true;
        }
        constraintLayout.setClickable(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object bb() {
        this.H1.setVisibility(0);
        this.A1.setVisibility(0);
        if (C8386Vt0.g6()) {
            this.F1.setVisibility(0);
        }
        if (C8386Vt0.h5()) {
            this.G1.setVisibility(0);
        }
        if (C8386Vt0.da()) {
            this.E1.setVisibility(0);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object cb() {
        this.B1.setVisibility(0);
        this.E1.setVisibility(0);
        return C19938rB7.a;
    }

    private void db() {
        C14733iO2 c14733iO2 = this.Y1;
        final C24119y45 c24119y45 = c14733iO2 != null ? (C24119y45) c14733iO2.z().b() : null;
        if (c24119y45 == null) {
            return;
        }
        this.l1.setClickable(this.X1 && c24119y45.f());
        this.x1.setClickable(this.X1 && c24119y45.f());
        this.m1.setClickable(this.X1 && c24119y45.q());
        this.y1.setClickable(this.X1 && c24119y45.q());
        this.w1.setClickable(this.X1 && c24119y45.p());
        this.I1.setClickable(this.X1 && c24119y45.p());
        this.n1.setClickable(this.X1 && c24119y45.i());
        this.z1.setClickable(this.X1 && c24119y45.i());
        GM2.d(this.Y1, new SA2() { // from class: ir.nasim.Ra
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Za(c24119y45);
            }
        });
        GM2.c(this.Y1, new SA2() { // from class: ir.nasim.cb
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.ab(c24119y45);
            }
        });
        this.q1.setClickable(this.X1 && c24119y45.g());
        this.C1.setClickable(this.X1 && c24119y45.g());
        this.r1.setClickable(this.X1 && c24119y45.b());
        this.s1.setClickable(this.X1 && c24119y45.c());
        this.t1.setClickable(this.X1 && c24119y45.r());
        this.u1.setClickable(this.X1 && c24119y45.e());
        this.D1.setClickable(this.X1 && c24119y45.b());
        this.E1.setClickable(this.X1 && c24119y45.c());
        this.F1.setClickable(this.X1 && c24119y45.r());
        this.G1.setClickable(this.X1 && c24119y45.e());
        this.J1.setVisibility((this.X1 && c24119y45.f()) ? 8 : 0);
        this.K1.setVisibility((this.X1 && c24119y45.q()) ? 8 : 0);
        this.V1.setVisibility((this.X1 && c24119y45.p()) ? 8 : 0);
        this.L1.setVisibility((this.X1 && c24119y45.i()) ? 8 : 0);
        this.M1.setVisibility((this.X1 && c24119y45.j()) ? 8 : 0);
        this.U1.setVisibility((this.X1 && c24119y45.k()) ? 8 : 0);
        this.N1.setVisibility((this.X1 && c24119y45.h()) ? 8 : 0);
        this.O1.setVisibility((this.X1 && c24119y45.g()) ? 8 : 0);
        this.P1.setVisibility((this.X1 && c24119y45.b()) ? 8 : 0);
        this.Q1.setVisibility((this.X1 && c24119y45.c()) ? 8 : 0);
        this.R1.setVisibility((this.X1 && c24119y45.r()) ? 8 : 0);
        this.S1.setVisibility((this.X1 && c24119y45.e()) ? 8 : 0);
        this.a2.setVisibility(4);
        this.x1.setVisibility(0);
        this.y1.setVisibility(0);
        this.I1.setVisibility(0);
        this.z1.setVisibility(0);
        GM2.d(this.Y1, new SA2() { // from class: ir.nasim.nb
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.bb();
            }
        });
        GM2.c(this.Y1, new SA2() { // from class: ir.nasim.qb
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.cb();
            }
        });
        this.C1.setVisibility(0);
        this.D1.setVisibility(0);
    }

    private void eb(ConstraintLayout constraintLayout) {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        constraintLayout.setBackground(AbstractC4310Eo7.j(c5495Jo7.f0(), c5495Jo7.y0(c5495Jo7.n0(), 27), 0));
    }

    private void fb(String str) {
        try {
            C17468n10 c17468n10 = this.k1;
            if (c17468n10 != null) {
                c17468n10.o(str);
            }
        } catch (Exception e) {
            C19406qI3.j("AdminsAccessFragment", "showSnackBar error: " + e.getMessage(), new Object[0]);
        }
    }

    private void ua(final TextView textView, final ImageView imageView) {
        AbstractC5969Lp4.d().e0().C(getLifecycle(), this.i1.o(), new UA2() { // from class: ir.nasim.rb
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return this.a.xa(textView, imageView, (PI7) obj);
            }
        });
    }

    private void va(boolean z) {
        C23104wM2 c23104wM2;
        String str;
        C23104wM2 c23104wM22;
        String str2;
        if (!this.X1 && !this.d2) {
            this.W1.setVisibility(8);
            return;
        }
        boolean z2 = false;
        this.W1.setVisibility(0);
        FullWidthButtonPrimary fullWidthButtonPrimary = this.W1;
        if (z || this.c2 || ((c23104wM22 = this.e2) != null && (str2 = this.f2) != null && !Objects.equals(str2, c23104wM22.d()) && this.f2.length() <= 30)) {
            z2 = true;
        }
        fullWidthButtonPrimary.setEnabled(z2);
        if (!z && !this.c2 && ((c23104wM2 = this.e2) == null || (str = this.f2) == null || Objects.equals(str, c23104wM2.d()) || this.f2.length() > 30)) {
            this.W1.a();
            return;
        }
        if (this.c2) {
            this.W1.setText(AbstractC12217eE5.admin_access_fragment_confirm);
        }
        this.W1.i();
    }

    private C24119y45 wa() {
        final AtomicReference atomicReference = new AtomicReference(new C24119y45());
        GM2.c(this.Y1, new SA2() { // from class: ir.nasim.sb
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.ya(atomicReference);
            }
        });
        GM2.d(this.Y1, new SA2() { // from class: ir.nasim.tb
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.za(atomicReference);
            }
        });
        return (C24119y45) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 xa(TextView textView, ImageView imageView, PI7 pi7) {
        if (pi7 != null) {
            v8(textView, imageView, pi7);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object ya(AtomicReference atomicReference) {
        atomicReference.set(new C24119y45(this.d1.n(), this.q1.isChecked(), this.d1.j(), this.d1.k(), this.n1.isChecked(), this.r1.isChecked(), this.l1.isChecked(), this.m1.isChecked(), this.d1.m(), this.p1.isChecked(), this.w1.isChecked(), this.d1.o(), this.d1.l(), this.s1.isChecked(), this.d1.r(), this.d1.e()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object za(AtomicReference atomicReference) {
        atomicReference.set(new C24119y45(this.d1.n(), this.q1.isChecked(), this.o1.isChecked(), this.v1.isChecked(), this.n1.isChecked(), this.r1.isChecked(), this.l1.isChecked(), this.m1.isChecked(), this.d1.m(), this.d1.h(), this.w1.isChecked(), this.d1.o(), this.d1.l(), this.s1.isChecked(), this.t1.isChecked(), this.u1.isChecked()));
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC22631va
    public void F(C24119y45 c24119y45) {
        String str = (String) this.i1.r().b();
        C23104wM2 c23104wM2 = this.e2;
        if (c23104wM2 != null && !Objects.equals(this.f2, c23104wM2.d()) && C8386Vt0.b9() && str != null) {
            fb(S7().getString(AbstractC12217eE5.personal_name_success_state_snack, str));
        }
        this.d1 = c24119y45;
        va(false);
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra_new_admin_added", true);
        V5().G1("add_new_admin_request", bundle);
        bundle.putBoolean("extra_new_list_admin_added", true);
        V5().G1("add_new_list_admin_request", bundle);
        Q7().onBackPressed();
    }

    @Override // ir.nasim.InterfaceC22631va
    public void P(final C24119y45 c24119y45) {
        this.d1 = c24119y45;
        this.l1.setChecked(c24119y45.f());
        this.w1.setChecked(c24119y45.p());
        this.m1.setChecked(c24119y45.q());
        this.n1.setChecked(c24119y45.i());
        GM2.c(this.Y1, new SA2() { // from class: ir.nasim.vb
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Aa(c24119y45);
            }
        });
        GM2.d(this.Y1, new SA2() { // from class: ir.nasim.wb
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Ba(c24119y45);
            }
        });
        this.q1.setChecked(c24119y45.g());
        this.r1.setChecked(c24119y45.b());
        this.l1.jumpDrawablesToCurrentState();
        this.w1.jumpDrawablesToCurrentState();
        this.m1.jumpDrawablesToCurrentState();
        this.n1.jumpDrawablesToCurrentState();
        GM2.c(this.Y1, new SA2() { // from class: ir.nasim.Sa
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Ca();
            }
        });
        GM2.d(this.Y1, new SA2() { // from class: ir.nasim.Ta
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Da();
            }
        });
        this.q1.jumpDrawablesToCurrentState();
        this.r1.jumpDrawablesToCurrentState();
        db();
        this.l1.setOnCheckedChangeListener(this);
        this.m1.setOnCheckedChangeListener(this);
        this.w1.setOnCheckedChangeListener(this);
        this.n1.setOnCheckedChangeListener(this);
        GM2.c(this.Y1, new SA2() { // from class: ir.nasim.Ua
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Ea();
            }
        });
        GM2.d(this.Y1, new SA2() { // from class: ir.nasim.Va
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Fa();
            }
        });
        this.q1.setOnCheckedChangeListener(this);
        this.r1.setOnCheckedChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_admins_access, viewGroup, false);
        this.j1 = E5().getInt("userId");
        this.c2 = E5().getBoolean("isFirst", false);
        this.d2 = E5().getBoolean("IS_OWNER", false);
        final int i = E5().getInt("groupId");
        C23104wM2 c23104wM2 = (C23104wM2) E5().getSerializable("ARG_GROUP_MEMBER");
        this.e2 = c23104wM2;
        this.f2 = (c23104wM2 == null || !C8386Vt0.b9()) ? null : this.e2.d();
        C14733iO2 c14733iO2V = AbstractC5969Lp4.d().V(i);
        this.Y1 = c14733iO2V;
        if (c14733iO2V == null) {
            C19406qI3.b("AdminsAccessFragment", "GroupVM is null for id=" + i);
            Q7().onBackPressed();
            return viewInflate;
        }
        this.Z1 = c14733iO2V.q() == ZN2.GROUP;
        this.c1 = new C22041ua(this);
        this.a2 = (ProgressBar) viewInflate.findViewById(BC5.loadingProgressBottom);
        this.X1 = this.j1 != AbstractC5969Lp4.f();
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(BC5.profileConstraintLayout);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        constraintLayout.setBackgroundColor(c5495Jo7.o());
        this.i1 = AbstractC5969Lp4.d().i0(this.j1);
        this.e1 = (AvatarViewGlide) viewInflate.findViewById(BC5.profile_avatar);
        C21231tK7 c21231tK7 = this.i1;
        if (c21231tK7 != null) {
            s8(c21231tK7.h(), new InterfaceC14756iQ7() { // from class: ir.nasim.Wa
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    this.a.Ja((Avatar) obj, abstractC13554gQ7);
                }
            });
        }
        C21231tK7 c21231tK72 = this.i1;
        final Integer numValueOf = c21231tK72 != null ? Integer.valueOf(c21231tK72.o()) : null;
        this.W1 = (FullWidthButtonPrimary) viewInflate.findViewById(BC5.save_changes);
        va(false);
        this.W1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.eb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ra(numValueOf, i, view);
            }
        });
        this.h1 = (TextView) viewInflate.findViewById(BC5.change_channel_info_title);
        viewInflate.findViewById(BC5.title_compose_view).setVisibility((C8386Vt0.b9() && this.Z1) ? 0 : 8);
        if (C8386Vt0.b9() && this.Z1) {
            ComposeView composeView = (ComposeView) viewInflate.findViewById(BC5.edit_text_compose_view);
            UA2 ua2 = new UA2() { // from class: ir.nasim.fb
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return this.a.Sa((String) obj);
                }
            };
            C23104wM2 c23104wM22 = this.e2;
            F65.d(composeView, ua2, c23104wM22 != null ? c23104wM22.d() : null, (this.X1 || this.d2) ? false : true);
        }
        this.h1.setText(this.Z1 ? AbstractC12217eE5.group_change_info : AbstractC12217eE5.channel_change_info);
        ((TextView) viewInflate.findViewById(BC5.change_send_message_title)).setText(this.Z1 ? AbstractC12217eE5.group_send_message : AbstractC12217eE5.channel_send_message);
        ((TextView) viewInflate.findViewById(BC5.change_send_media_title)).setText(AbstractC12217eE5.channel_send_media);
        ((TextView) viewInflate.findViewById(BC5.change_edit_messages_title)).setText(this.Z1 ? AbstractC12217eE5.group_edit_message : AbstractC12217eE5.channel_edit_message);
        ((TextView) viewInflate.findViewById(BC5.change_delete_messages_title)).setText(this.Z1 ? AbstractC12217eE5.group_delete_message : AbstractC12217eE5.channel_delete_message);
        ((TextView) viewInflate.findViewById(BC5.change_pin_messages_title)).setText(this.Z1 ? AbstractC12217eE5.group_pin_message : AbstractC12217eE5.channel_pin_message);
        ((TextView) viewInflate.findViewById(BC5.change_show_member_title)).setText(this.Z1 ? AbstractC12217eE5.group_show_member : AbstractC12217eE5.channel_show_member);
        ((TextView) viewInflate.findViewById(BC5.change_delete_member_title)).setText(this.Z1 ? AbstractC12217eE5.group_delete_member : AbstractC12217eE5.channel_delete_member);
        ((TextView) viewInflate.findViewById(BC5.change_add_member_title)).setText(this.Z1 ? AbstractC12217eE5.group_add_member : AbstractC12217eE5.channel_add_member);
        ((TextView) viewInflate.findViewById(BC5.change_add_admin_title)).setText(this.Z1 ? AbstractC12217eE5.group_add_admin : AbstractC12217eE5.channel_add_admin);
        ((TextView) viewInflate.findViewById(BC5.change_add_story_title)).setText(AbstractC12217eE5.channel_add_story);
        ((TextView) viewInflate.findViewById(BC5.change_start_call_title)).setText(AbstractC12217eE5.start_call_permission_title);
        ((TextView) viewInflate.findViewById(BC5.change_call_management_title)).setText(AbstractC12217eE5.call_management_title);
        ((TextView) viewInflate.findViewById(BC5.not_access_to_change)).setText(this.Z1 ? AbstractC12217eE5.group_not_access : AbstractC12217eE5.channel_not_access);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(BC5.change_channel_info);
        this.x1 = constraintLayout2;
        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.gb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ta(view);
            }
        });
        eb(this.x1);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) viewInflate.findViewById(BC5.change_send_message);
        this.y1 = constraintLayout3;
        constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ua(view);
            }
        });
        eb(this.y1);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) viewInflate.findViewById(BC5.change_add_member);
        this.z1 = constraintLayout4;
        constraintLayout4.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ib
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Va(view);
            }
        });
        eb(this.z1);
        ConstraintLayout constraintLayout5 = (ConstraintLayout) viewInflate.findViewById(BC5.change_delete_member);
        this.A1 = constraintLayout5;
        constraintLayout5.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.jb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Wa(view);
            }
        });
        eb(this.A1);
        ConstraintLayout constraintLayout6 = (ConstraintLayout) viewInflate.findViewById(BC5.change_pin_messages);
        this.H1 = constraintLayout6;
        constraintLayout6.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Xa(view);
            }
        });
        eb(this.H1);
        ConstraintLayout constraintLayout7 = (ConstraintLayout) viewInflate.findViewById(BC5.change_edit_messages);
        this.B1 = constraintLayout7;
        constraintLayout7.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ya(view);
            }
        });
        eb(this.B1);
        ConstraintLayout constraintLayout8 = (ConstraintLayout) viewInflate.findViewById(BC5.change_delete_messages);
        this.C1 = constraintLayout8;
        constraintLayout8.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.mb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ka(view);
            }
        });
        eb(this.C1);
        ConstraintLayout constraintLayout9 = (ConstraintLayout) viewInflate.findViewById(BC5.change_add_admin);
        this.D1 = constraintLayout9;
        constraintLayout9.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Xa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.La(view);
            }
        });
        eb(this.D1);
        ConstraintLayout constraintLayout10 = (ConstraintLayout) viewInflate.findViewById(BC5.change_add_story);
        this.E1 = constraintLayout10;
        constraintLayout10.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ya
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ma(view);
            }
        });
        eb(this.E1);
        ConstraintLayout constraintLayout11 = (ConstraintLayout) viewInflate.findViewById(BC5.change_start_call);
        this.F1 = constraintLayout11;
        constraintLayout11.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Za
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Na(view);
            }
        });
        eb(this.F1);
        ConstraintLayout constraintLayout12 = (ConstraintLayout) viewInflate.findViewById(BC5.change_call_management);
        this.G1 = constraintLayout12;
        constraintLayout12.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Oa(view);
            }
        });
        eb(this.G1);
        ConstraintLayout constraintLayout13 = (ConstraintLayout) viewInflate.findViewById(BC5.change_send_media);
        this.I1 = constraintLayout13;
        constraintLayout13.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Pa(view);
            }
        });
        eb(this.I1);
        this.l1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_channel_info);
        this.m1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_send_message);
        this.n1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_add_member);
        this.o1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_delete_member);
        this.v1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_pin_messages);
        this.p1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_edit_messages);
        this.q1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_delete_messages);
        this.r1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_add_admin);
        this.s1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_add_story);
        this.t1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_start_call);
        this.u1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_call_management);
        this.w1 = (SwitchCompat) viewInflate.findViewById(BC5.enable_change_send_media);
        this.J1 = viewInflate.findViewById(BC5.disable_change_channel_info);
        this.K1 = viewInflate.findViewById(BC5.disable_change_send_message);
        this.L1 = viewInflate.findViewById(BC5.disable_change_add_member);
        this.M1 = viewInflate.findViewById(BC5.disable_change_delete_member);
        this.U1 = viewInflate.findViewById(BC5.disable_change_pin_messages);
        this.N1 = viewInflate.findViewById(BC5.disable_change_edit_messages);
        this.O1 = viewInflate.findViewById(BC5.disable_change_delete_messages);
        this.P1 = viewInflate.findViewById(BC5.disable_change_add_admin);
        this.Q1 = viewInflate.findViewById(BC5.disable_change_add_story);
        this.R1 = viewInflate.findViewById(BC5.disable_change_start_call);
        this.S1 = viewInflate.findViewById(BC5.disable_change_call_management);
        this.V1 = viewInflate.findViewById(BC5.disable_change_send_media);
        TextView textView = (TextView) viewInflate.findViewById(BC5.online_state);
        ImageView imageView = (ImageView) viewInflate.findViewById(BC5.online_circle);
        textView.setTextColor(c5495Jo7.n0());
        if (this.i1.y()) {
            imageView.setVisibility(8);
            textView.setText(G5().getString(AbstractC12217eE5.members_adapter_bot_online_status));
        } else {
            ua(textView, imageView);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.name);
        this.f1 = textView2;
        textView2.setTextColor(c5495Jo7.g1());
        this.f1.setTypeface(C6011Lu2.k());
        s8(this.i1.r(), new InterfaceC14756iQ7() { // from class: ir.nasim.db
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.Qa((String) obj, abstractC13554gQ7);
            }
        });
        Drawable drawableF = (this.i1.t() == null || this.i1.t().b() == E25.INFORMAL) ? null : AbstractC4043Dl1.f(S7(), KB5.blue_tick);
        if (drawableF != null) {
            this.f1.setCompoundDrawablePadding(C22078ud6.a(4.0f));
            if (JF5.g()) {
                this.f1.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawableF, (Drawable) null);
            } else {
                this.f1.setCompoundDrawablesWithIntrinsicBounds(drawableF, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
        TextView textView3 = (TextView) viewInflate.findViewById(BC5.not_access_to_change);
        this.g1 = textView3;
        textView3.setVisibility(this.X1 ? 8 : 0);
        ((FrameLayout) viewInflate.findViewById(BC5.drawer_items1)).setBackgroundColor(c5495Jo7.O0());
        ((BaleToolbar) viewInflate.findViewById(BC5.admin_access_toolbar)).setHasBackButton(Q7(), !this.c2);
        this.k1 = new C17468n10(viewInflate);
        return viewInflate;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        AvatarViewGlide avatarViewGlide = this.e1;
        if (avatarViewGlide != null) {
            avatarViewGlide.D();
            this.e1 = null;
        }
        this.k1 = null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        C23381wp3.c(Q7());
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        super.l7(view, bundle);
        this.a2.setVisibility(0);
        if (this.c2) {
            P(FM2.d((W06) this.Y1.E().b(), this.Y1.q()));
        } else {
            this.c1.j(this.Y1, this.i1.o());
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        GM2.c(this.Y1, new SA2() { // from class: ir.nasim.ob
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Ga();
            }
        });
        GM2.d(this.Y1, new SA2() { // from class: ir.nasim.pb
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Ha();
            }
        });
        if (compoundButton == this.m1 && !z && this.p1.isChecked()) {
            this.p1.setChecked(false);
        }
        if (compoundButton == this.p1 && z && !this.m1.isChecked()) {
            this.m1.setChecked(true);
        }
        if (compoundButton == this.m1 && !z && this.w1.isChecked()) {
            this.w1.setChecked(false);
        }
        va(this.b2);
    }

    @Override // ir.nasim.InterfaceC22631va
    public void q(Exception exc) {
        fb(UN2.a(exc, this.Y1.q()));
        Q7().onBackPressed();
    }
}
