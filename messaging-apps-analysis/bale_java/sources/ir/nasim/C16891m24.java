package ir.nasim;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;

/* renamed from: ir.nasim.m24, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C16891m24 extends C22042ua0 implements InterfaceC18664p24, CompoundButton.OnCheckedChangeListener {
    private ConstraintLayout A1;
    private View B1;
    private View C1;
    private View D1;
    private View E1;
    private View F1;
    private View G1;
    private View H1;
    private FullWidthButtonPrimary I1;
    private C14733iO2 J1;
    private ProgressBar K1;
    private boolean L1;
    private C17468n10 M1;
    private C18073o24 c1;
    private C24119y45 d1;
    private AvatarViewGlide e1;
    private TextView f1;
    private C21231tK7 g1;
    private int h1;
    private int i1;
    private C23104wM2 j1;
    private boolean k1;
    private C24119y45 l1;
    private SwitchCompat m1;
    private SwitchCompat n1;
    private SwitchCompat o1;
    private SwitchCompat p1;
    private SwitchCompat q1;
    private SwitchCompat r1;
    private SwitchCompat s1;
    private ConstraintLayout t1;
    private ConstraintLayout u1;
    private ConstraintLayout v1;
    private ConstraintLayout w1;
    private ConstraintLayout x1;
    private ConstraintLayout y1;
    private ConstraintLayout z1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Aa(View view) {
        this.n1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba(View view) {
        this.o1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ca(View view) {
        this.p1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Da(View view) {
        this.q1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ea(View view) {
        this.r1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fa(View view) {
        this.s1.toggle();
    }

    public static C16891m24 Ga(C23104wM2 c23104wM2, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_GROUP_ID", i);
        bundle.putInt("ARG_USER_ID", i2);
        bundle.putSerializable("ARG_GROUP_MEMBER", c23104wM2);
        C16891m24 c16891m24 = new C16891m24();
        c16891m24.a8(bundle);
        return c16891m24;
    }

    private void Ha(W06 w06) {
        C24119y45 c24119y45C = FM2.c(this.J1);
        this.l1 = c24119y45C;
        boolean z = true;
        this.m1.setEnabled(c24119y45C.f() || w06 != W06.PUBLIC);
        this.t1.setClickable(this.l1.f() || w06 != W06.PUBLIC);
        this.n1.setEnabled(this.l1.q());
        this.u1.setClickable(this.l1.q());
        this.o1.setEnabled(this.l1.i());
        this.v1.setClickable(this.l1.i());
        this.p1.setEnabled(this.l1.k() || w06 != W06.PUBLIC);
        ConstraintLayout constraintLayout = this.y1;
        if (!this.l1.k() && w06 == W06.PUBLIC) {
            z = false;
        }
        constraintLayout.setClickable(z);
        this.q1.setEnabled(this.l1.p());
        this.w1.setClickable(this.l1.p());
        this.r1.setEnabled(this.l1.o());
        this.x1.setClickable(this.l1.o());
        this.s1.setEnabled(this.l1.r());
        this.A1.setClickable(this.l1.r());
        View view = this.B1;
        W06 w062 = W06.PUBLIC;
        view.setVisibility((w06 == w062 || !this.l1.f()) ? 0 : 8);
        this.C1.setVisibility((w06 == w062 || !this.l1.k()) ? 0 : 8);
        this.G1.setVisibility(!this.l1.o() ? 0 : 8);
        this.F1.setVisibility(!this.l1.p() ? 0 : 8);
        this.E1.setVisibility(!this.l1.i() ? 0 : 8);
        this.D1.setVisibility(!this.l1.q() ? 0 : 8);
        this.H1.setVisibility(this.l1.r() ? 8 : 0);
        if (w06 == w062) {
            this.B1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.l24
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.pa(view2);
                }
            });
            this.C1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.T14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.qa(view2);
                }
            });
        } else {
            if (!this.l1.f()) {
                this.B1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.U14
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.a.ra(view2);
                    }
                });
            }
            if (!this.l1.k()) {
                this.C1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.V14
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.a.sa(view2);
                    }
                });
            }
        }
        if (!this.l1.o()) {
            this.G1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.W14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.ta(view2);
                }
            });
        }
        if (!this.l1.p()) {
            this.F1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.X14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.ua(view2);
                }
            });
        }
        if (!this.l1.i()) {
            this.E1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Y14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.va(view2);
                }
            });
        }
        if (!this.l1.q()) {
            this.D1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Z14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.wa(view2);
                }
            });
        }
        if (this.l1.r()) {
            return;
        }
        this.H1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.a24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.xa(view2);
            }
        });
    }

    private void Ia(ConstraintLayout constraintLayout) {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        constraintLayout.setBackground(AbstractC4310Eo7.j(c5495Jo7.f0(), c5495Jo7.y0(c5495Jo7.n0(), 27), 0));
    }

    private void Ja(C24119y45 c24119y45) {
        this.d1 = c24119y45;
        this.m1.setChecked(c24119y45.f());
        this.n1.setChecked(c24119y45.q());
        this.o1.setChecked(c24119y45.i());
        this.p1.setChecked(c24119y45.k());
        this.q1.setChecked(c24119y45.p());
        this.r1.setChecked(c24119y45.o());
        this.s1.setChecked(c24119y45.r());
        this.m1.jumpDrawablesToCurrentState();
        this.n1.jumpDrawablesToCurrentState();
        this.o1.jumpDrawablesToCurrentState();
        this.p1.jumpDrawablesToCurrentState();
        this.q1.jumpDrawablesToCurrentState();
        this.r1.jumpDrawablesToCurrentState();
        this.s1.jumpDrawablesToCurrentState();
    }

    private void Ka(View view) {
        boolean z = this.J1.q() == ZN2.GROUP;
        ((TextView) view.findViewById(BC5.change_send_message_title)).setText(z ? AbstractC12217eE5.group_send_message : AbstractC12217eE5.channel_send_message);
        ((TextView) view.findViewById(BC5.change_send_media_title)).setText(z ? AbstractC12217eE5.group_send_media : AbstractC12217eE5.channel_send_media);
        ((TextView) view.findViewById(BC5.change_send_gift_sticker_title)).setText(z ? AbstractC12217eE5.group_send_gift_sticker : AbstractC12217eE5.channel_send_gift_sticker);
        ((TextView) view.findViewById(BC5.change_pin_messages_title)).setText(z ? AbstractC12217eE5.group_pin_message : AbstractC12217eE5.channel_pin_message);
        ((TextView) view.findViewById(BC5.change_channel_info_title)).setText(z ? AbstractC12217eE5.group_change_info : AbstractC12217eE5.channel_change_info);
        ((TextView) view.findViewById(BC5.change_add_member_title)).setText(z ? AbstractC12217eE5.group_add_member : AbstractC12217eE5.channel_add_member);
        ((TextView) view.findViewById(BC5.not_access_to_change)).setText(z ? AbstractC12217eE5.group_not_access : AbstractC12217eE5.channel_not_access);
        ((TextView) view.findViewById(BC5.change_start_call_title)).setText(AbstractC12217eE5.start_call_permission_title);
    }

    private void La() {
        this.z1.setVisibility(0);
        this.t1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.d24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.za(view);
            }
        });
        Ia(this.t1);
        this.u1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.e24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Aa(view);
            }
        });
        Ia(this.u1);
        this.v1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.f24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ba(view);
            }
        });
        Ia(this.v1);
        this.y1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.g24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ca(view);
            }
        });
        Ia(this.y1);
        this.w1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.h24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Da(view);
            }
        });
        Ia(this.w1);
        this.x1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.i24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Ea(view);
            }
        });
        Ia(this.x1);
        this.A1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.j24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Fa(view);
            }
        });
        Ia(this.A1);
        this.I1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.k24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ya(view);
            }
        });
        this.f1.setTextColor(C5495Jo7.a.g1());
        this.f1.setTypeface(C6011Lu2.k());
        this.m1.setOnCheckedChangeListener(this);
        this.n1.setOnCheckedChangeListener(this);
        this.o1.setOnCheckedChangeListener(this);
        this.p1.setOnCheckedChangeListener(this);
        this.q1.setOnCheckedChangeListener(this);
        this.r1.setOnCheckedChangeListener(this);
        this.s1.setOnCheckedChangeListener(this);
    }

    private void ia(int i) {
        this.t1.setVisibility(i);
        this.u1.setVisibility(i);
        this.v1.setVisibility(i);
        this.w1.setVisibility(i);
        this.x1.setVisibility(i);
        this.y1.setVisibility(i);
        if (C8386Vt0.g6()) {
            this.A1.setVisibility(i);
        }
    }

    private void ja(boolean z) {
        this.I1.setEnabled(z);
        if (this.k1) {
            this.I1.setText(AbstractC12217eE5.f37add_to_exceptionlist);
        }
        if (z) {
            this.I1.i();
        } else {
            this.I1.a();
        }
    }

    private C24119y45 ka() {
        return new C24119y45(this.d1.n(), this.d1.g(), this.d1.j(), this.p1.isChecked(), this.o1.isChecked(), this.d1.b(), this.m1.isChecked(), this.n1.isChecked(), this.d1.m(), this.d1.h(), this.q1.isChecked(), this.r1.isChecked(), this.d1.l(), this.d1.c(), this.s1.isChecked(), this.d1.e());
    }

    private void la(View view) {
        this.K1 = (ProgressBar) view.findViewById(BC5.loadingProgressBottom);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(BC5.profileConstraintLayout);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        constraintLayout.setBackgroundColor(c5495Jo7.o());
        ((FrameLayout) view.findViewById(BC5.drawer_items1)).setBackgroundColor(c5495Jo7.O0());
        this.e1 = (AvatarViewGlide) view.findViewById(BC5.profile_avatar);
        this.I1 = (FullWidthButtonPrimary) view.findViewById(BC5.save_changes);
        this.f1 = (TextView) view.findViewById(BC5.name);
        this.z1 = (ConstraintLayout) view.findViewById(BC5.personalInfo);
        this.t1 = (ConstraintLayout) view.findViewById(BC5.change_channel_info);
        this.u1 = (ConstraintLayout) view.findViewById(BC5.change_send_message);
        this.v1 = (ConstraintLayout) view.findViewById(BC5.change_add_member);
        this.y1 = (ConstraintLayout) view.findViewById(BC5.change_pin_messages);
        this.w1 = (ConstraintLayout) view.findViewById(BC5.change_send_media);
        this.x1 = (ConstraintLayout) view.findViewById(BC5.change_send_gift_sticker);
        this.A1 = (ConstraintLayout) view.findViewById(BC5.change_start_call);
        this.m1 = (SwitchCompat) view.findViewById(BC5.enable_change_channel_info);
        this.n1 = (SwitchCompat) view.findViewById(BC5.enable_change_send_message);
        this.o1 = (SwitchCompat) view.findViewById(BC5.enable_change_add_member);
        this.p1 = (SwitchCompat) view.findViewById(BC5.enable_change_pin_messages);
        this.q1 = (SwitchCompat) view.findViewById(BC5.enable_change_send_media);
        this.r1 = (SwitchCompat) view.findViewById(BC5.enable_change_send_gift_sticker);
        this.s1 = (SwitchCompat) view.findViewById(BC5.enable_change_start_call);
        view.findViewById(BC5.black_list).setVisibility(8);
        this.B1 = view.findViewById(BC5.disable_change_channel_info);
        this.C1 = view.findViewById(BC5.disable_change_pin_messages);
        this.D1 = view.findViewById(BC5.disable_change_send_message);
        this.E1 = view.findViewById(BC5.disable_change_add_member);
        this.F1 = view.findViewById(BC5.disable_change_send_media);
        this.G1 = view.findViewById(BC5.disable_change_send_gift_sticker);
        this.H1 = view.findViewById(BC5.disable_change_start_call);
        Ka(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ma(View view) {
        n8(XV7.a(this.g1.o(), A5()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void na(Avatar avatar, AbstractC13554gQ7 abstractC13554gQ7) {
        this.e1.B(22.0f, true);
        this.e1.r((C21231tK7) AbstractC5969Lp4.g().n(this.g1.o()));
        this.e1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.S14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ma(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oa(String str, AbstractC13554gQ7 abstractC13554gQ7) {
        this.f1.setText(R62.S(str, this.f1.getPaint().getFontMetricsInt(), AbstractC7426Rr.z(20.0f), false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pa(View view) {
        this.M1.o(Y8(AbstractC12217eE5.not_possible_set_permissions_in_public));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void qa(View view) {
        this.M1.o(Y8(AbstractC12217eE5.not_possible_set_permissions_in_public));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ra(View view) {
        this.M1.o(Y8(AbstractC12217eE5.not_possible_set_permissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sa(View view) {
        this.M1.o(Y8(AbstractC12217eE5.not_possible_set_permissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ta(View view) {
        this.M1.o(Y8(AbstractC12217eE5.not_possible_set_permissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ua(View view) {
        this.M1.o(Y8(AbstractC12217eE5.not_possible_set_permissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void va(View view) {
        this.M1.o(Y8(AbstractC12217eE5.not_possible_set_permissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wa(View view) {
        this.M1.o(Y8(AbstractC12217eE5.not_possible_set_permissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xa(View view) {
        this.M1.o(Y8(AbstractC12217eE5.not_possible_set_permissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ya(View view) {
        this.c1.j(this.i1, this.g1.o(), ka());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void za(View view) {
        this.m1.toggle();
    }

    @Override // ir.nasim.InterfaceC18664p24
    public void F(C24119y45 c24119y45) {
        Fragment fragmentK6 = k6();
        Intent intent = new Intent();
        intent.putExtra("ir.nasim.MemberAccessFragment.permission", c24119y45.equals(this.J1.m().b()));
        intent.putExtra("ir.nasim.MemberAccessFragment.groupMember", this.j1);
        if (fragmentK6 != null) {
            fragmentK6.H6(m6(), -1, intent);
        }
        Q7().onBackPressed();
    }

    @Override // ir.nasim.InterfaceC18664p24
    public void P(C24119y45 c24119y45) {
        this.k1 = c24119y45.a(FM2.c(this.J1));
        this.K1.setVisibility(8);
        Ha((W06) this.J1.E().b());
        ia(0);
        Ja(c24119y45);
        this.I1.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_members_access, viewGroup, false);
        this.i1 = E5().getInt("ARG_GROUP_ID");
        this.h1 = E5().getInt("ARG_USER_ID");
        this.j1 = (C23104wM2) E5().getSerializable("ARG_GROUP_MEMBER");
        this.J1 = AbstractC5969Lp4.d().V(this.i1);
        this.g1 = AbstractC5969Lp4.d().i0(this.h1);
        this.c1 = new C18073o24(this);
        la(viewInflate);
        La();
        s8(this.g1.h(), new InterfaceC14756iQ7() { // from class: ir.nasim.b24
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.na((Avatar) obj, abstractC13554gQ7);
            }
        });
        s8(this.g1.r(), new InterfaceC14756iQ7() { // from class: ir.nasim.c24
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.oa((String) obj, abstractC13554gQ7);
            }
        });
        BaleToolbar baleToolbar = (BaleToolbar) viewInflate.findViewById(BC5.members_access_toolbar);
        baleToolbar.setHasBackButton(Q7(), true);
        baleToolbar.setTitle(AbstractC12217eE5.member_access_fragment_title);
        return viewInflate;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        C23381wp3.c(A5());
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        super.l7(view, bundle);
        C17468n10 c17468n10 = new C17468n10(view);
        this.M1 = c17468n10;
        c17468n10.k(this.I1);
        this.K1.setVisibility(0);
        ia(8);
        this.I1.setVisibility(8);
        ja(false);
        this.c1.h(this.J1, this.g1.o());
        if (C8386Vt0.g6()) {
            return;
        }
        this.A1.setVisibility(8);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.L1 = (this.d1.f() == this.m1.isChecked() && this.d1.q() == this.n1.isChecked() && this.d1.i() == this.o1.isChecked() && this.d1.k() == this.p1.isChecked() && this.d1.p() == this.q1.isChecked() && this.d1.o() == this.r1.isChecked() && this.d1.r() == this.s1.isChecked()) ? false : true;
        if (compoundButton == this.n1 && !z && this.r1.isChecked()) {
            this.r1.setChecked(false);
        }
        if (compoundButton == this.n1 && !z && this.q1.isChecked()) {
            this.q1.setChecked(false);
        }
        if (compoundButton == this.r1 && z && !this.n1.isChecked()) {
            this.n1.setChecked(true);
        }
        if (compoundButton == this.q1 && z && !this.n1.isChecked()) {
            this.n1.setChecked(true);
        }
        ja(this.L1);
    }

    @Override // ir.nasim.InterfaceC18664p24
    public void q(Exception exc) {
        Toast.makeText(A5(), UN2.a(exc, this.J1.q()), 0).show();
    }
}
