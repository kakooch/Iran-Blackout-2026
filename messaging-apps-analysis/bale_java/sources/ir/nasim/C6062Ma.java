package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.designsystem.adapters.RecyclerListView;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.Ma, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C6062Ma extends KV2 {
    private TextView A1;
    C10299bQ2 h1;
    InterfaceC8288Vi1 i1;
    private int j1;
    private C14733iO2 k1;
    private RecyclerListView l1;
    private C3717Cb m1;
    private boolean n1;
    private boolean o1;
    private boolean p1;
    private C17468n10 s1;
    private HashSet t1;
    private C24119y45 x1;
    private ConstraintLayout y1;
    private TextView z1;
    private ZN2 q1 = ZN2.GROUP;
    private W06 r1 = W06.PUBLIC;
    private final int[] u1 = {AbstractC12217eE5.group_menu_add_admin};
    private final int[] v1 = {KB5.add_contact_vd};
    d w1 = new a();

    /* renamed from: ir.nasim.Ma$a */
    class a implements d {
        a() {
        }

        @Override // ir.nasim.C6062Ma.d
        public void a(int i) {
            if (Integer.valueOf(C6062Ma.this.u1[i]).equals(Integer.valueOf(AbstractC12217eE5.group_menu_add_admin))) {
                C6062Ma c6062Ma = C6062Ma.this;
                c6062Ma.y9(c6062Ma.i1.a(c6062Ma.h6(AbstractC12217eE5.contact_picker_group_add_admin), null, null, null, C6062Ma.this.q1, false, EnumC6357Ng1.b, Integer.valueOf(C6062Ma.this.k1.r()), C6062Ma.this.n1, C6062Ma.this.o1, null, false, new ArrayList()));
            }
        }
    }

    /* renamed from: ir.nasim.Ma$b */
    class b implements InterfaceC13295fz2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC13295fz2
        public void a(String str, Bundle bundle) {
            if (str.equals("add_new_list_admin_request") && bundle.getBoolean("extra_new_list_admin_added")) {
                C6062Ma.this.Oa();
            }
        }
    }

    /* renamed from: ir.nasim.Ma$c */
    class c implements InterfaceC15419jZ0 {
        c() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            if (C6062Ma.this.m1 != null) {
                C6062Ma.this.m1.notifyDataSetChanged();
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C6062Ma.this.Ma(UN2.a(exc, C6062Ma.this.q1));
        }
    }

    /* renamed from: ir.nasim.Ma$d */
    interface d {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Aa(Exception exc) {
        Ma(UN2.a(exc, this.q1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba(C21231tK7 c21231tK7, DialogInterface dialogInterface, int i) {
        S8(this.h1.R2(this.j1, c21231tK7.o()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Aa
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.xa((C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Ba
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.Aa((Exception) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ca(Exception exc) {
        Ma(h6(AbstractC12217eE5.toast_bot_constraint_applied_failure));
        C19406qI3.d("AdminListFragment", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Da(C14505i18 c14505i18) {
        Ma(ua(h6(AbstractC12217eE5.toast_bot_constraint_applied_success), this.q1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ea(C21231tK7 c21231tK7, DialogInterface dialogInterface, int i) {
        T8(this.h1.B3(this.j1, c21231tK7.o(), false).E(new InterfaceC24449ye1() { // from class: ir.nasim.ya
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.Ca((Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.za
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.Da((C14505i18) obj);
            }
        }), AbstractC12217eE5.progress_common);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fa(Exception exc) {
        Ma(ua(h6(AbstractC12217eE5.toast_bot_constraint_applied_failure), this.q1));
        C19406qI3.d("AdminListFragment", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ga(C14505i18 c14505i18) {
        Ma(ua(h6(AbstractC12217eE5.toast_bot_constraint_applied_success), this.q1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ha(C21231tK7 c21231tK7, DialogInterface dialogInterface, int i) {
        T8(this.h1.B3(this.j1, c21231tK7.o(), true).E(new InterfaceC24449ye1() { // from class: ir.nasim.Ka
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.Fa((Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.La
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.Ga((C14505i18) obj);
            }
        }), AbstractC12217eE5.progress_common);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ia(C21231tK7 c21231tK7, InterfaceC15419jZ0 interfaceC15419jZ0) {
        C6517Nv5 c6517Nv5F3 = this.h1.F3(this.j1, c21231tK7.o());
        Objects.requireNonNull(interfaceC15419jZ0);
        c6517Nv5F3.m0(new C14272he4(interfaceC15419jZ0)).E(new C12454ee4(interfaceC15419jZ0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ja(final C21231tK7 c21231tK7, DialogInterface dialogInterface, int i) {
        R8(new InterfaceC14830iZ0() { // from class: ir.nasim.Ca
            @Override // ir.nasim.InterfaceC14830iZ0
            public final void a(InterfaceC15419jZ0 interfaceC15419jZ0) {
                this.a.Ia(c21231tK7, interfaceC15419jZ0);
            }
        }, AbstractC12217eE5.progress_common, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ka(List list) {
        HashSet hashSet = new HashSet();
        this.t1 = hashSet;
        hashSet.addAll(list);
        C3717Cb c3717Cb = new C3717Cb(this.t1, A5(), this.k1);
        this.m1 = c3717Cb;
        this.l1.setAdapter((ListAdapter) c3717Cb);
        String strE = this.t1.size() + "";
        if (JF5.g()) {
            strE = XY6.e(strE);
        }
        this.A1.setText(h6(AbstractC12217eE5.group_count).replace("{0}", strE));
        this.A1.setTextColor(C5495Jo7.a.b1());
        this.A1.setTypeface(C6011Lu2.k());
    }

    private void La(View view) {
        BaleToolbar baleToolbar = (BaleToolbar) view.findViewById(BC5.admin_list_toolbar);
        baleToolbar.setTitle(ua(h6(AbstractC12217eE5.admin_list_fragment_title), this.q1));
        baleToolbar.setHasBackButton(Q7(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma(String str) {
        try {
            C17468n10 c17468n10 = this.s1;
            if (c17468n10 != null) {
                c17468n10.o(str);
            }
        } catch (Exception e) {
            C19406qI3.j("AdminListFragment", "showSnackBar error: " + e.getMessage(), new Object[0]);
        }
    }

    private void Na(final C21231tK7 c21231tK7) {
        AlertDialog alertDialogA = new AlertDialog.a(A5()).i(ua(h6(AbstractC12217eE5.alert_group_owner_text), this.q1).replace("{0}", (CharSequence) c21231tK7.r().b())).j(h6(AbstractC12217eE5.alert_group_owner_yes), new DialogInterface.OnClickListener() { // from class: ir.nasim.xa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.Ja(c21231tK7, dialogInterface, i);
            }
        }).l(h6(AbstractC12217eE5.dialog_cancel), null).a();
        q9(alertDialogA);
        alertDialogA.R(C5495Jo7.a.B0(), -2);
        alertDialogA.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
        this.h1.U1(this.k1.r()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Ea
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.Ka((List) obj);
            }
        });
    }

    private void qa(Context context, FrameLayout frameLayout, LayoutInflater layoutInflater, final d dVar) {
        int length = this.u1.length;
        int i = 0;
        for (final int i2 = 0; i2 < length; i2++) {
            if (this.u1[i2] == AbstractC12217eE5.group_menu_add_admin && !ra()) {
                return;
            }
            View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_settings_item, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(BC5.title);
            textView.setText(ua(h6(this.u1[i2]), this.q1));
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setTextColor(c5495Jo7.W0());
            ImageView imageView = (ImageView) viewInflate.findViewById(BC5.icon);
            imageView.setImageResource(this.v1[i2]);
            imageView.setColorFilter(c5495Jo7.W0());
            viewInflate.setBackgroundDrawable(AbstractC4310Eo7.g());
            frameLayout.addView(viewInflate, C14433hu3.b(-1, 48.0f, 48, 0.0f, i, 0.0f, 0.0f));
            int i3 = i + 48;
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ga
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dVar.a(i2);
                }
            });
            if (i2 != length - 1) {
                View view = new View(context);
                view.setBackgroundColor(c5495Jo7.a1());
                frameLayout.addView(view, C14433hu3.b(-1, 1.0f, 48, 0.0f, i3, 0.0f, 0.0f));
                i += 49;
            } else {
                i = i3;
            }
        }
    }

    private boolean ra() {
        C24119y45 c24119y45;
        return this.k1.q() == ZN2.GROUP ? FM2.a(this.k1) : this.o1 || (this.n1 && ((c24119y45 = this.x1) == null || (c24119y45.b() && this.x1.i())));
    }

    public static C22042ua0 sa(int i, int i2, boolean z, C23104wM2 c23104wM2) {
        Bundle bundle = new Bundle();
        bundle.putInt("userId", i);
        bundle.putInt("groupId", i2);
        bundle.putBoolean("isFirst", z);
        if (c23104wM2 != null) {
            bundle.putSerializable("ARG_GROUP_MEMBER", c23104wM2);
        }
        C23827xb c23827xb = new C23827xb();
        c23827xb.a8(bundle);
        return c23827xb;
    }

    private String ua(String str, ZN2 zn2) {
        if (zn2 == null || zn2.equals(ZN2.GROUP)) {
            return str;
        }
        Context context = C5721Ko.b;
        String string = context.getString(AbstractC12217eE5.dialog_type_group);
        String string2 = context.getString(AbstractC12217eE5.dialog_type_channel);
        return str.replace(string, string2).replaceAll(string.toLowerCase(), string2.toLowerCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wa(boolean z, W06 w06, AbstractC13554gQ7 abstractC13554gQ7) {
        if (this.r1 != w06) {
            this.r1 = w06;
        }
        W06 w062 = W06.PUBLIC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xa(C14505i18 c14505i18) {
        Oa();
        Bundle bundle = new Bundle();
        bundle.putBoolean("extra_new_admin_removed", true);
        V5().G1("remove_new_admin_request", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ya(ArrayList arrayList, String str, final C21231tK7 c21231tK7, String str2, String str3, C23104wM2 c23104wM2, String str4, String str5, DialogInterface dialogInterface, int i) {
        if (((String) arrayList.get(i)).equals(str)) {
            Na(c21231tK7);
            return;
        }
        if (((String) arrayList.get(i)).equals(str2) || ((String) arrayList.get(i)).equals(str3)) {
            y9(sa(c23104wM2.f(), this.k1.r(), false, c23104wM2));
            return;
        }
        if (((String) arrayList.get(i)).equals(str4)) {
            AlertDialog alertDialogA = new AlertDialog.a(A5()).i(ua(h6(AbstractC12217eE5.alert_group_remove_admin_text), this.q1).replace("{0}", (CharSequence) c21231tK7.r().b())).j(h6(AbstractC12217eE5.alert_group_remove_yes), new DialogInterface.OnClickListener() { // from class: ir.nasim.Ha
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.a.Ba(c21231tK7, dialogInterface2, i2);
                }
            }).l(h6(AbstractC12217eE5.dialog_cancel), null).a();
            q9(alertDialogA);
            alertDialogA.R(C5495Jo7.a.B0(), -2);
            alertDialogA.setCanceledOnTouchOutside(true);
            return;
        }
        if (((String) arrayList.get(i)).equals(str5)) {
            Dialog dialogA = new AlertDialog.a(A5()).i(h6(AbstractC12217eE5.alert_group_bot_constraint_text)).l(h6(AbstractC12217eE5.alert_group_bot_constraint_mention), new DialogInterface.OnClickListener() { // from class: ir.nasim.Ia
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.a.Ea(c21231tK7, dialogInterface2, i2);
                }
            }).j(h6(AbstractC12217eE5.alert_group_bot_constraint_all_message), new DialogInterface.OnClickListener() { // from class: ir.nasim.Ja
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.a.Ha(c21231tK7, dialogInterface2, i2);
                }
            }).a();
            q9(dialogA);
            dialogA.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void za(AdapterView adapterView, View view, int i, long j) {
        Object itemAtPosition = adapterView.getItemAtPosition(i);
        if (itemAtPosition == null || !(itemAtPosition instanceof C23104wM2)) {
            return;
        }
        final C23104wM2 c23104wM2 = (C23104wM2) itemAtPosition;
        this.o1 = AbstractC5969Lp4.f() == this.k1.x();
        this.p1 = c23104wM2.e() != null && c23104wM2.e().intValue() == AbstractC5969Lp4.f();
        if (this.o1) {
            if (c23104wM2.f() == AbstractC5969Lp4.f()) {
                return;
            }
        } else if ((c23104wM2.f() != AbstractC5969Lp4.f() && !this.p1) || c23104wM2.f() == this.k1.x()) {
            return;
        }
        final C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c23104wM2.f());
        if (c21231tK7 == null) {
            return;
        }
        c23104wM2.l(c21231tK7);
        final ArrayList arrayList = new ArrayList();
        final String strReplace = h6(AbstractC12217eE5.group_context_edit_access).replace("{0}", (CharSequence) c21231tK7.r().b());
        final String strH6 = h6(AbstractC12217eE5.group_context_view_access);
        final String strReplace2 = ua(h6(AbstractC12217eE5.group_context_remove_admin), this.q1).replace("{0}", (CharSequence) c21231tK7.r().b());
        final String strH62 = h6(AbstractC12217eE5.group_context_bot_constraint);
        ArrayList arrayList2 = new ArrayList();
        if (c23104wM2.f() == AbstractC5969Lp4.f()) {
            arrayList.add(strH6);
        } else {
            arrayList.add(strReplace);
        }
        arrayList2.add(Integer.valueOf(KB5.ic_baseline_admin_panel_settings_24));
        boolean z = this.n1 && c23104wM2.f() != this.k1.x() && c23104wM2.f() != AbstractC5969Lp4.f() && this.p1;
        final String strReplace3 = ua(h6(AbstractC12217eE5.group_context_owner), this.q1).replace("{0}", (CharSequence) c21231tK7.r().b());
        if (this.o1 && c23104wM2.j() && !c21231tK7.y()) {
            arrayList.add(strReplace3);
            arrayList2.add(Integer.valueOf(KB5.ic_transfer_within_a_station_black_18dp));
        }
        if (this.o1 || z) {
            arrayList.add(strReplace2);
            arrayList2.add(Integer.valueOf(KB5.ic_baseline_person_remove_24));
        }
        ExPeerType exPeerTypeN = c21231tK7.n();
        if (C8386Vt0.r5() && exPeerTypeN == ExPeerType.BOT) {
            arrayList.add(strH62);
            arrayList2.add(Integer.valueOf(KB5.ic_visibility_off_black_18dp));
        }
        CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
        int[] iArr = new int[arrayList2.size()];
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            if (arrayList2.get(i2) != null) {
                iArr[i2] = ((Integer) arrayList2.get(i2)).intValue();
            }
        }
        AlertDialog.a aVar = new AlertDialog.a(A5());
        aVar.g(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: ir.nasim.Fa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.a.ya(arrayList, strReplace3, c21231tK7, strReplace, strH6, c23104wM2, strReplace2, strH62, dialogInterface, i3);
            }
        });
        AlertDialog alertDialogA = aVar.a();
        q9(alertDialogA);
        alertDialogA.setCanceledOnTouchOutside(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int i, int i2, Intent intent) {
        super.H6(i, i2, intent);
        if (i2 == 20011) {
            ta(intent.getIntegerArrayListExtra("USER_LIST").get(0).intValue());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        V5().H1("add_new_list_admin_request", p6(), new b());
        this.j1 = E5().getInt("chat_id");
        C14733iO2 c14733iO2 = (C14733iO2) this.h1.Y1().n(this.j1);
        this.k1 = c14733iO2;
        this.q1 = c14733iO2.q();
        if (this.k1.x() == AbstractC5969Lp4.f()) {
            this.n1 = true;
            this.o1 = true;
        }
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_memberlist, viewGroup, false);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewInflate.setBackgroundColor(c5495Jo7.o());
        this.l1 = (RecyclerListView) viewInflate.findViewById(BC5.groupList);
        this.y1 = (ConstraintLayout) viewInflate.findViewById(BC5.member_list_header);
        this.z1 = (TextView) viewInflate.findViewById(BC5.member_list_title);
        this.A1 = (TextView) viewInflate.findViewById(BC5.member_list_count);
        this.y1.setBackgroundColor(c5495Jo7.A0());
        this.z1.setText(ua(h6(AbstractC12217eE5.admin_list_title), this.q1));
        this.z1.setTextColor(c5495Jo7.b1());
        this.z1.setTypeface(C6011Lu2.k());
        this.l1.setBackgroundColor(c5495Jo7.O0());
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(BC5.drawer_items);
        frameLayout.setBackgroundColor(c5495Jo7.O0());
        C23104wM2 c23104wM2 = (C23104wM2) this.k1.s().b();
        this.x1 = (C24119y45) this.k1.z().b();
        if (c23104wM2 != null) {
            this.n1 = c23104wM2.j();
        }
        Oa();
        final boolean z = this.n1;
        s8(((C14733iO2) this.h1.Y1().n(this.k1.r())).E(), new InterfaceC14756iQ7() { // from class: ir.nasim.wa
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                this.a.wa(z, (W06) obj, abstractC13554gQ7);
            }
        });
        this.l1.setAdapter((ListAdapter) this.m1);
        this.l1.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ir.nasim.Da
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.a.za(adapterView, view, i, j);
            }
        });
        boolean z2 = (this.q1 != ZN2.CHANNEL || this.n1) && (this.n1 || this.r1 != W06.PRIVATE) && ((Boolean) this.k1.F().b()).booleanValue();
        if (this.k1.e().b() != null && !((Boolean) this.k1.e().b()).booleanValue()) {
            z2 = false;
        }
        FrameLayout frameLayout2 = (FrameLayout) viewInflate.findViewById(BC5.groupInfoDividerAfter);
        if (z2) {
            qa(G5(), frameLayout, layoutInflater, this.w1);
            frameLayout2.setVisibility(0);
        } else {
            frameLayout2.setVisibility(8);
        }
        this.s1 = new C17468n10(viewInflate);
        La(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        C3717Cb c3717Cb = this.m1;
        if (c3717Cb != null) {
            c3717Cb.b();
        }
        this.m1 = null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this.s1 = null;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        V5().G1("admin_list_back_pressed_request", new Bundle());
        return super.a();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        if (this.m1 == null || this.l1.getCount() != 0) {
            return;
        }
        this.l1.setAdapter((ListAdapter) this.m1);
        this.m1.notifyDataSetChanged();
    }

    public void ta(int i) {
        ZN2 zn2 = this.q1;
        if (zn2 == ZN2.GROUP || zn2 == ZN2.CHANNEL) {
            y9(sa(i, this.k1.r(), true, null));
        }
    }
}
