package ir.nasim;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.y34, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C24108y34 extends C22042ua0 implements A34, CompoundButton.OnCheckedChangeListener, InterfaceC22483vJ4 {
    private FullWidthButtonPrimary A1;
    private C14733iO2 B1;
    private boolean C1;
    private RecyclerView D1;
    private E34 E1;
    private C17468n10 F1;
    private boolean G1 = false;
    private C24698z34 c1;
    private C24119y45 d1;
    private TextView e1;
    private TextView f1;
    private int g1;
    private boolean h1;
    private SwitchCompat i1;
    private SwitchCompat j1;
    private SwitchCompat k1;
    private SwitchCompat l1;
    private SwitchCompat m1;
    private SwitchCompat n1;
    private SwitchCompat o1;
    private ConstraintLayout p1;
    private ConstraintLayout q1;
    private ConstraintLayout r1;
    private ConstraintLayout s1;
    private ConstraintLayout t1;
    private ConstraintLayout u1;
    private ConstraintLayout v1;
    private ConstraintLayout w1;
    private ConstraintLayout x1;
    private View y1;
    private View z1;

    private void Aa(String str) {
        try {
            C17468n10 c17468n10 = this.F1;
            if (c17468n10 != null) {
                c17468n10.o(str);
            }
        } catch (Exception e) {
            C19406qI3.j("MembersAccessFragment", "showSnackBar error: " + e.getMessage(), new Object[0]);
        }
    }

    private boolean ba() {
        return !this.h1 && (this.B1.x() == AbstractC5969Lp4.f() || (this.B1.s() != null && ((C23104wM2) this.B1.s().b()).j()));
    }

    private void ca(boolean z) {
        this.A1.setEnabled(z);
        if (z) {
            this.A1.i();
        } else {
            this.A1.a();
        }
    }

    private C24119y45 da() {
        return new C24119y45(this.d1.n(), this.d1.g(), this.d1.j(), this.l1.isChecked(), this.k1.isChecked(), this.d1.b(), this.i1.isChecked(), this.j1.isChecked(), this.d1.m(), this.d1.h(), this.m1.isChecked(), this.n1.isChecked(), this.d1.l(), this.d1.c(), this.o1.isChecked(), this.d1.e());
    }

    private void ea(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(BC5.profileConstraintLayout);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        constraintLayout.setBackgroundColor(c5495Jo7.o());
        ((FrameLayout) view.findViewById(BC5.drawer_items1)).setBackgroundColor(c5495Jo7.O0());
        this.A1 = (FullWidthButtonPrimary) view.findViewById(BC5.save_changes);
        this.e1 = (TextView) view.findViewById(BC5.name);
        this.f1 = (TextView) view.findViewById(BC5.tv_add_to_excepted);
        this.p1 = (ConstraintLayout) view.findViewById(BC5.change_channel_info);
        this.q1 = (ConstraintLayout) view.findViewById(BC5.change_send_message);
        this.r1 = (ConstraintLayout) view.findViewById(BC5.change_add_member);
        this.u1 = (ConstraintLayout) view.findViewById(BC5.change_pin_messages);
        this.s1 = (ConstraintLayout) view.findViewById(BC5.change_send_media);
        this.t1 = (ConstraintLayout) view.findViewById(BC5.change_send_gift_sticker);
        this.v1 = (ConstraintLayout) view.findViewById(BC5.add_to_excepted);
        this.x1 = (ConstraintLayout) view.findViewById(BC5.change_start_call);
        this.w1 = (ConstraintLayout) view.findViewById(BC5.black_list);
        this.i1 = (SwitchCompat) view.findViewById(BC5.enable_change_channel_info);
        this.j1 = (SwitchCompat) view.findViewById(BC5.enable_change_send_message);
        this.k1 = (SwitchCompat) view.findViewById(BC5.enable_change_add_member);
        this.l1 = (SwitchCompat) view.findViewById(BC5.enable_change_pin_messages);
        this.m1 = (SwitchCompat) view.findViewById(BC5.enable_change_send_media);
        this.n1 = (SwitchCompat) view.findViewById(BC5.enable_change_send_gift_sticker);
        this.o1 = (SwitchCompat) view.findViewById(BC5.enable_change_start_call);
        this.y1 = view.findViewById(BC5.disable_change_channel_info);
        this.z1 = view.findViewById(BC5.disable_change_pin_messages);
        this.D1 = (RecyclerView) view.findViewById(BC5.rv_members_excepted);
        ya(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fa(ArrayList arrayList, String str, C23104wM2 c23104wM2, String str2, DialogInterface dialogInterface, int i) {
        if (((String) arrayList.get(i)).equals(str)) {
            this.c1.h(this.g1, c23104wM2, null);
            ca(true);
        } else if (((String) arrayList.get(i)).equals(str2)) {
            C16891m24 c16891m24Ga = C16891m24.Ga(c23104wM2, this.g1, c23104wM2.f());
            c16891m24Ga.k8(this, 10);
            y9(c16891m24Ga);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ga(View view) {
        Aa(Y8(AbstractC12217eE5.not_possible_set_permissions_in_public));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ha(View view) {
        Aa(Y8(AbstractC12217eE5.not_possible_set_permissions_in_public));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ia(View view) {
        this.c1.i(this.g1, da(), Boolean.valueOf(this.h1), (Integer) this.B1.o().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ja(View view) {
        this.i1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ka(View view) {
        this.j1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void la(View view) {
        this.k1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ma(View view) {
        this.l1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void na(View view) {
        C13041fc2 c13041fc2Ka = C13041fc2.ka(this.g1);
        c13041fc2Ka.k8(this, 10);
        y9(c13041fc2Ka);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oa(View view) {
        y9(IM2.INSTANCE.a().b(this.g1, ZN2.GROUP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pa(View view) {
        this.m1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void qa(View view) {
        this.n1.toggle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ra(View view) {
        this.o1.toggle();
    }

    public static C24108y34 sa(int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARG_is_comment", z);
        bundle.putInt("ARG_GROUP_ID", i);
        C24108y34 c24108y34 = new C24108y34();
        c24108y34.a8(bundle);
        return c24108y34;
    }

    private void va(W06 w06) {
        SwitchCompat switchCompat = this.i1;
        W06 w062 = W06.PUBLIC;
        switchCompat.setClickable(w06 != w062);
        this.p1.setClickable(w06 != w062);
        this.l1.setClickable(w06 != w062);
        this.u1.setClickable(w06 != w062);
        this.y1.setClickable(w06 == w062);
        this.z1.setClickable(w06 == w062);
        this.y1.setVisibility(w06 == w062 ? 0 : 8);
        this.z1.setVisibility(w06 != w062 ? 8 : 0);
        if (w06 == w062) {
            this.y1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.p34
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.ga(view);
                }
            });
            this.z1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.q34
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.ha(view);
                }
            });
        }
    }

    private void wa(ConstraintLayout constraintLayout) {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        constraintLayout.setBackground(AbstractC4310Eo7.j(c5495Jo7.f0(), c5495Jo7.y0(c5495Jo7.n0(), 27), 0));
    }

    private void xa(C24119y45 c24119y45) {
        this.d1 = c24119y45;
        this.i1.setChecked(c24119y45.f());
        this.j1.setChecked(c24119y45.q());
        this.k1.setChecked(c24119y45.i());
        this.l1.setChecked(c24119y45.k());
        this.m1.setChecked(c24119y45.p());
        this.n1.setChecked(c24119y45.o());
        this.o1.setChecked(c24119y45.r());
        this.i1.jumpDrawablesToCurrentState();
        this.j1.jumpDrawablesToCurrentState();
        this.k1.jumpDrawablesToCurrentState();
        this.l1.jumpDrawablesToCurrentState();
        this.m1.jumpDrawablesToCurrentState();
        this.n1.jumpDrawablesToCurrentState();
        this.o1.jumpDrawablesToCurrentState();
    }

    private void ya(View view) {
        boolean z = this.B1.q() == ZN2.GROUP;
        ((TextView) view.findViewById(BC5.change_send_message_title)).setText(z ? AbstractC12217eE5.group_send_message : AbstractC12217eE5.channel_send_message);
        ((TextView) view.findViewById(BC5.change_send_media_title)).setText(z ? AbstractC12217eE5.group_send_media : AbstractC12217eE5.channel_send_media);
        ((TextView) view.findViewById(BC5.change_send_gift_sticker_title)).setText(z ? AbstractC12217eE5.group_send_gift_sticker : AbstractC12217eE5.channel_send_gift_sticker);
        ((TextView) view.findViewById(BC5.change_pin_messages_title)).setText(z ? AbstractC12217eE5.group_pin_message : AbstractC12217eE5.channel_pin_message);
        ((TextView) view.findViewById(BC5.change_channel_info_title)).setText(z ? AbstractC12217eE5.group_change_info : AbstractC12217eE5.channel_change_info);
        ((TextView) view.findViewById(BC5.change_add_member_title)).setText(z ? AbstractC12217eE5.group_add_member : AbstractC12217eE5.channel_add_member);
        ((TextView) view.findViewById(BC5.not_access_to_change)).setText(z ? AbstractC12217eE5.group_not_access : AbstractC12217eE5.channel_not_access);
        ((TextView) view.findViewById(BC5.change_start_call_title)).setText(AbstractC12217eE5.start_call_permission_title);
    }

    private void za() {
        this.A1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.r34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ia(view);
            }
        });
        this.p1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.s34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ja(view);
            }
        });
        wa(this.p1);
        this.q1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.t34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ka(view);
            }
        });
        wa(this.q1);
        this.r1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.u34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.la(view);
            }
        });
        wa(this.r1);
        this.u1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.v34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ma(view);
            }
        });
        wa(this.u1);
        this.v1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.w34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.na(view);
            }
        });
        this.w1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.x34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.oa(view);
            }
        });
        wa(this.v1);
        wa(this.w1);
        this.s1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.m34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.pa(view);
            }
        });
        wa(this.s1);
        this.t1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.n34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.qa(view);
            }
        });
        wa(this.t1);
        this.x1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.o34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ra(view);
            }
        });
        wa(this.x1);
        TextView textView = this.e1;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.g1());
        this.e1.setTypeface(C6011Lu2.k());
        this.f1.setTextColor(c5495Jo7.d1());
        this.f1.setTypeface(C6011Lu2.k());
        this.i1.setOnCheckedChangeListener(this);
        this.j1.setOnCheckedChangeListener(this);
        this.k1.setOnCheckedChangeListener(this);
        this.l1.setOnCheckedChangeListener(this);
        this.m1.setOnCheckedChangeListener(this);
        this.n1.setOnCheckedChangeListener(this);
        this.o1.setOnCheckedChangeListener(this);
        this.D1.setBackgroundColor(c5495Jo7.O0());
        this.D1.setAdapter(this.E1);
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int i, int i2, Intent intent) {
        super.H6(i, i2, intent);
        if (i2 == -1 && intent != null && i == 10) {
            boolean booleanExtra = intent.getBooleanExtra("ir.nasim.MemberAccessFragment.permission", false);
            C23104wM2 c23104wM2 = (C23104wM2) intent.getSerializableExtra("ir.nasim.MemberAccessFragment.groupMember");
            if (booleanExtra) {
                this.E1.E(c23104wM2);
            } else {
                this.c1.g(this.g1);
            }
            this.G1 = true;
            ca(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        this.c1 = new C24698z34(this);
        this.g1 = E5().getInt("ARG_GROUP_ID");
        this.h1 = E5().getBoolean("ARG_is_comment");
        C14733iO2 c14733iO2V = AbstractC5969Lp4.d().V(this.g1);
        this.B1 = c14733iO2V;
        this.E1 = new E34(this, c14733iO2V);
        this.c1.g(this.g1);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_members_access, viewGroup, false);
        ea(viewInflate);
        za();
        xa(FM2.c(this.B1));
        va((W06) this.B1.E().b());
        if (ba()) {
            this.w1.setVisibility(0);
        } else {
            this.w1.setVisibility(8);
        }
        this.v1.setVisibility(0);
        this.D1.setVisibility(0);
        BaleToolbar baleToolbar = (BaleToolbar) viewInflate.findViewById(BC5.members_access_toolbar);
        baleToolbar.setHasBackButton(Q7(), true);
        if (this.h1) {
            baleToolbar.setTitle(AbstractC12217eE5.set_comment_permissions);
        } else {
            baleToolbar.setTitle(AbstractC12217eE5.members_access_fragment_title);
        }
        if (this.h1) {
            this.x1.setVisibility(8);
            this.p1.setVisibility(8);
            this.u1.setVisibility(8);
            this.r1.setVisibility(8);
            this.v1.setVisibility(8);
            this.D1.setVisibility(8);
        }
        return viewInflate;
    }

    @Override // ir.nasim.A34
    public void R1(List list) {
        this.E1.F(list);
    }

    @Override // ir.nasim.A34
    public void R3(C23104wM2 c23104wM2) {
        this.E1.E(c23104wM2);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        this.F1 = null;
        super.T6();
    }

    @Override // ir.nasim.A34
    public void V1() {
        Q7().onBackPressed();
    }

    @Override // ir.nasim.A34
    public void f4(Exception exc, boolean z) {
        Aa(UN2.a(exc, this.B1.q()));
        if (z) {
            Q7().onBackPressed();
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        C23381wp3.c(Q7());
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        super.l7(view, bundle);
        C17468n10 c17468n10 = new C17468n10(view);
        this.F1 = c17468n10;
        c17468n10.k(this.A1);
        if (C8386Vt0.g6()) {
            return;
        }
        this.x1.setVisibility(8);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2 = true;
        this.C1 = (this.d1.f() == this.i1.isChecked() && this.d1.q() == this.j1.isChecked() && this.d1.i() == this.k1.isChecked() && this.d1.k() == this.l1.isChecked() && this.d1.p() == this.m1.isChecked() && this.d1.o() == this.n1.isChecked() && this.d1.r() == this.o1.isChecked()) ? false : true;
        if (compoundButton == this.j1 && !z && this.n1.isChecked()) {
            this.n1.setChecked(false);
        }
        if (compoundButton == this.j1 && !z && this.m1.isChecked()) {
            this.m1.setChecked(false);
        }
        if (compoundButton == this.n1 && z && !this.j1.isChecked()) {
            this.j1.setChecked(true);
        }
        if (compoundButton == this.m1 && z && !this.j1.isChecked()) {
            this.j1.setChecked(true);
        }
        if (!this.C1 && !this.G1) {
            z2 = false;
        }
        ca(z2);
    }

    @Override // ir.nasim.InterfaceC22483vJ4
    /* renamed from: ta, reason: merged with bridge method [inline-methods] */
    public void e(final C23104wM2 c23104wM2) {
        if (c23104wM2.f() == AbstractC5969Lp4.f() || c23104wM2.g() == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final String strH6 = h6(AbstractC12217eE5.group_context_edit_access);
        arrayList.add(strH6);
        final String strH62 = h6(AbstractC12217eE5.group_context_remove_from_excepted);
        arrayList.add(strH62);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(KB5.ic_baseline_admin_panel_settings_24));
        arrayList2.add(Integer.valueOf(KB5.ic_baseline_person_remove_24));
        ArrayList arrayList3 = new ArrayList();
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        arrayList3.add(Integer.valueOf(c5495Jo7.g1()));
        arrayList3.add(Integer.valueOf(c5495Jo7.J0()));
        CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
        int[] iArr = new int[arrayList2.size()];
        for (int i = 0; i < arrayList2.size(); i++) {
            if (arrayList2.get(i) != null) {
                iArr[i] = ((Integer) arrayList2.get(i)).intValue();
            }
        }
        AlertDialog.a aVar = new AlertDialog.a(A5());
        aVar.g(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: ir.nasim.l34
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.a.fa(arrayList, strH62, c23104wM2, strH6, dialogInterface, i2);
            }
        });
        aVar.e(arrayList3);
        AlertDialog alertDialogA = aVar.a();
        q9(alertDialogA);
        alertDialogA.setCanceledOnTouchOutside(true);
    }

    @Override // ir.nasim.InterfaceC22483vJ4
    /* renamed from: ua, reason: merged with bridge method [inline-methods] */
    public boolean v(C23104wM2 c23104wM2) {
        return false;
    }
}
