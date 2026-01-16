package ir.nasim.features.profile.avatar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC15226jD5;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C12562ep2;
import ir.nasim.C14505i18;
import ir.nasim.C14733iO2;
import ir.nasim.C18684p44;
import ir.nasim.C20719sV;
import ir.nasim.C21753u45;
import ir.nasim.C4053Dm2;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C6906Pm2;
import ir.nasim.FM2;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.JF5;
import ir.nasim.Pc8;
import ir.nasim.UN2;
import ir.nasim.W25;
import ir.nasim.XY6;
import ir.nasim.ZN2;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.features.profile.avatar.a;
import ir.nasim.features.profile.avatar.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class NewViewAvatarActivity extends BaseActivity implements b.InterfaceC1209b, a.InterfaceC1208a {
    private static int b1 = -1;
    private String K0;
    private volatile String L0;
    private C11458d25 M0;
    private ZN2 N0;
    private SafeTouchViewPager O0;
    private TextView P0;
    private RecyclerView Q0;
    private LinearLayoutManager R0;
    private ir.nasim.features.profile.avatar.a S0;
    private TextView T0;
    private String U0;
    private BaleToolbar V0;
    private List Y0;
    private C20719sV Z0;
    final int W0 = 10;
    final int X0 = 11;
    private boolean a1 = true;

    class a extends ViewPager.l {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.l, androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            super.a(i, f, i2);
            if (!NewViewAvatarActivity.this.a1 && NewViewAvatarActivity.this.Q0 != null) {
                NewViewAvatarActivity.this.D3(i);
            }
            if (f == 0.0f) {
                NewViewAvatarActivity.this.a1 = false;
            }
            if (NewViewAvatarActivity.this.a1) {
                return;
            }
            if (i != NewViewAvatarActivity.b1) {
                NewViewAvatarActivity.this.m1(i + 1);
            }
            NewViewAvatarActivity.b1 = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.l, androidx.viewpager.widget.ViewPager.i
        public void c(int i) {
            super.c(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.l, androidx.viewpager.widget.ViewPager.i
        public void d(int i) {
            super.d(i);
        }
    }

    class b implements AdapterView.OnItemClickListener {
        final /* synthetic */ ArrayList a;

        b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) throws IOException {
            NewViewAvatarActivity.this.V0.popupWindow.dismiss();
            int iD = ((C18684p44) this.a.get(i)).d();
            if (iD == 10) {
                NewViewAvatarActivity.this.C3();
            } else if (iD == 11) {
                NewViewAvatarActivity.this.O3();
            }
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.a.setVisibility(8);
        }
    }

    class d extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        d(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.a.setAlpha(1.0f);
        }
    }

    private void A3() {
        if (this.M0.s() == W25.a) {
            if (this.M0.getPeerId() == AbstractC5969Lp4.f()) {
                H1(AbstractC5969Lp4.d().l1(V2()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Kz4
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        this.a.o3((C14505i18) obj);
                    }
                }));
            }
        } else if (this.M0.s() == W25.b) {
            H1(AbstractC5969Lp4.d().Y0(this.M0.getPeerId(), V2()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Lz4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.r3((C14505i18) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Mz4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.t3((Exception) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C3() throws IOException {
        if (Build.VERSION.SDK_INT <= 29 && !C21753u45.V(this)) {
            C21753u45.a.L0(this, 0, C21753u45.d.j, C21753u45.d.m);
            return;
        }
        Avatar avatarU2 = U2();
        if (avatarU2 == null || avatarU2.getFullImage() == null) {
            return;
        }
        C6906Pm2.A(AbstractC5969Lp4.d().G(avatarU2.getFullImage().getFileReference().getFileId()), this, 0, null, null);
        C4053Dm2.h(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D3(int i) {
        if (i != b1) {
            this.R0.E2(i, (this.Q0.getWidth() / 2) - 17);
            this.S0.F(i);
            this.S0.notifyDataSetChanged();
        }
    }

    private void E3() {
        this.O0.c(new a());
    }

    private void F3() {
        this.U0 = getString(AbstractC12217eE5.avatar_loading);
    }

    private void H3() {
        if (this.M0.s() != W25.a) {
            this.U0 = AbstractC5969Lp4.a(getResources().getString(W2()), this.N0);
        } else if (this.M0.getPeerId() == AbstractC5969Lp4.f()) {
            this.U0 = getResources().getString(X2());
        } else {
            this.U0 = getResources().getString(Y2());
        }
    }

    private void K2() {
        if (this.Y0.isEmpty()) {
            return;
        }
        this.V0.getMenu().clear();
        this.V0.y(AbstractC15226jD5.more_menu);
        this.V0.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.Iz4
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.a.i3(menuItem);
            }
        });
        List list = this.Y0;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayListS2 = S2();
        this.V0.l0(BC5.more_item, arrayListS2, new b(arrayListS2));
    }

    private void K3() {
        runOnUiThread(new Runnable() { // from class: ir.nasim.Hz4
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.a.u3();
            }
        });
    }

    private void L3() {
        ir.nasim.features.profile.avatar.a aVar = this.S0;
        if (aVar == null) {
            this.S0 = new ir.nasim.features.profile.avatar.a(this, this.Y0, this);
        } else {
            aVar.E(this.Y0);
            this.S0.notifyDataSetChanged();
        }
        this.Q0.setAdapter(this.S0);
    }

    private void M3() {
        this.P0.setVisibility(0);
        this.O0.setVisibility(4);
        this.Q0.setVisibility(4);
    }

    private void N3(long j) {
        this.V0.y0(j);
        List list = this.Y0;
        if (list != null && !list.isEmpty()) {
            P3(this.Q0, j);
        }
        P3(this.T0, j);
    }

    private void O2() {
        List list = this.Y0;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.Z0.u(ir.nasim.features.profile.avatar.b.U9((Avatar) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O3() {
        new a.C0011a(this).e(AbstractC12217eE5.avatar_delete_prompt_text).setPositiveButton(AbstractC12217eE5.avatar_delete_prompt_yes, new DialogInterface.OnClickListener() { // from class: ir.nasim.Jz4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.v3(dialogInterface, i);
            }
        }).setNegativeButton(AbstractC12217eE5.avatar_delete_prompt_no, null).create().show();
    }

    private void P2() {
        AbstractC7426Rr.Q(new Runnable() { // from class: ir.nasim.Oz4
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.a.k3();
            }
        }, 100L);
    }

    private void P3(View view, long j) {
        if (view != null) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(j).setListener(new d(view));
        }
    }

    private void Q2() {
        C20719sV c20719sV = this.Z0;
        if (c20719sV != null) {
            c20719sV.v();
        }
    }

    private ArrayList S2() {
        ArrayList arrayList = new ArrayList();
        String string = getString(AbstractC12217eE5.avatar_save_to_gallery);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        arrayList.add(new C18684p44(10, string, 0, c5495Jo7.d2(), 0));
        if (g3()) {
            arrayList.add(new C18684p44(11, getString(AbstractC12217eE5.avatar_delete), 0, c5495Jo7.d2(), 0));
        }
        return arrayList;
    }

    private void S3() {
        startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", FileProvider.h(this, getApplicationContext().getPackageName() + ".provider", new File(this.K0))), 2);
    }

    private String T2(int i) {
        List list = this.Y0;
        if (list == null || list.isEmpty()) {
            return "";
        }
        String string = getString(AbstractC12217eE5.avatar_counter_text, Integer.valueOf(i), Integer.valueOf(this.Y0.size()));
        return JF5.g() ? XY6.e(string) : string;
    }

    public static Intent T3(int i, Context context) {
        Intent intent = new Intent(context, (Class<?>) NewViewAvatarActivity.class);
        intent.putExtra("chat_peer", C11458d25.E(i).u());
        return intent;
    }

    private Avatar U2() {
        Fragment fragmentT = this.Z0.t(this.O0.getCurrentItem());
        if (fragmentT instanceof ir.nasim.features.profile.avatar.b) {
            return ((ir.nasim.features.profile.avatar.b) fragmentT).currentAvatar;
        }
        return null;
    }

    public static Intent U3(int i, Context context, ZN2 zn2) {
        Intent intent = new Intent(context, (Class<?>) NewViewAvatarActivity.class);
        intent.putExtra("chat_peer", C11458d25.y(i).u());
        intent.putExtra("extra_peer_id", zn2);
        return intent;
    }

    private long V2() {
        Avatar avatarU2 = U2();
        if (avatarU2 == null || avatarU2.getId() == null) {
            return 0L;
        }
        return avatarU2.getId().longValue();
    }

    private int W2() {
        return h3() ? AbstractC12217eE5.avatar_title_group : AbstractC12217eE5.avatar_title_group_multi;
    }

    private int X2() {
        return h3() ? AbstractC12217eE5.avatar_title_your : AbstractC12217eE5.avatar_title_your_multi;
    }

    private int Y2() {
        return h3() ? AbstractC12217eE5.avatar_title_person : AbstractC12217eE5.avatar_title_person_multi;
    }

    private void Z2() {
        this.P0.setVisibility(8);
        this.O0.setVisibility(0);
        this.Q0.setVisibility(0);
    }

    private void a3(long j) {
        this.V0.q0(j);
        b3(this.Q0, j);
        b3(this.T0, j);
    }

    private void b3(View view, long j) {
        if (view != null) {
            view.animate().alpha(0.0f).setDuration(j).setListener(new c(view));
        }
    }

    private void c3() {
        this.V0.setTitle(this.U0);
        this.V0.setHasBackButton(this, true);
        K2();
    }

    private void d3() {
        F3();
        BaleToolbar baleToolbar = (BaleToolbar) findViewById(BC5.view_avtar_toolbar);
        this.V0 = baleToolbar;
        baleToolbar.setBackgroundColor(C5495Jo7.a.j2());
        this.V0.setTitle(this.U0);
        this.V0.setHasBackButton(this, true);
    }

    private void e3() throws Resources.NotFoundException {
        this.P0 = (TextView) findViewById(BC5.no_photo);
        TextView textView = (TextView) findViewById(BC5.avatars_counter);
        this.T0 = textView;
        textView.setTypeface(C6011Lu2.i());
        this.T0.setTextColor(C5495Jo7.a.l2());
        SafeTouchViewPager safeTouchViewPager = (SafeTouchViewPager) findViewById(BC5.view_pager_avatars);
        this.O0 = safeTouchViewPager;
        safeTouchViewPager.setPageTransformer(false, new Pc8());
        this.Q0 = (RecyclerView) findViewById(BC5.recycler_view_slider);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, JF5.g());
        this.R0 = linearLayoutManager;
        this.Q0.setLayoutManager(linearLayoutManager);
        this.Q0.addItemDecoration(new C12562ep2(AbstractC7426Rr.z(80.0f)));
    }

    private boolean f3() {
        return this.Q0.getVisibility() == 0;
    }

    private boolean g3() {
        if (this.M0.s() == W25.b) {
            C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(this.M0.getPeerId());
            if (c14733iO2.x() == AbstractC5969Lp4.f() || FM2.b(c14733iO2)) {
                return true;
            }
        } else if (this.M0.s() == W25.a && this.M0.getPeerId() == AbstractC5969Lp4.f()) {
            return true;
        }
        return false;
    }

    private boolean h3() {
        List list = this.Y0;
        return list != null && list.size() <= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean i3(MenuItem menuItem) {
        if (menuItem.getItemId() != BC5.more_item) {
            return false;
        }
        this.V0.popupWindow.setInputMethodMode(2);
        this.V0.popupWindow.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k3() throws Resources.NotFoundException {
        if (b1 < this.Z0.d()) {
            this.O0.setCurrentItem(b1);
            m1(b1 + 1);
        } else if (b1 - 1 < this.Z0.d()) {
            this.O0.setCurrentItem(b1 - 1);
            m1(b1);
        }
        this.Z0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l3(List list) {
        if (list.size() == 0) {
            this.Y0 = new ArrayList();
            M3();
        } else {
            Z2();
            ArrayList arrayList = new ArrayList();
            this.Y0 = arrayList;
            arrayList.addAll(list);
            Q2();
            L3();
            if (list.isEmpty()) {
                b3(this.Q0, 100L);
            }
            K3();
            m1(b1 + 1);
        }
        H3();
        c3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(int i) {
        this.T0.setText(T2(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m3() {
        if (this.Z0 != null) {
            w3();
            P2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o3(C14505i18 c14505i18) {
        z3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r3(C14505i18 c14505i18) {
        z3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t3(Exception exc) {
        Toast.makeText(this, UN2.a(exc, this.N0), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u3() throws Resources.NotFoundException {
        this.Z0 = new C20719sV(B0());
        O2();
        this.O0.setAdapter(this.Z0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v3(DialogInterface dialogInterface, int i) {
        A3();
    }

    private void w3() {
        if (this.M0.C()) {
            AbstractC5969Lp4.d().W0(this.M0.getPeerId()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Fz4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.y3((List) obj);
                }
            });
        } else {
            AbstractC5969Lp4.d().U0(this.M0.getPeerId()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Fz4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.y3((List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y3(final List list) {
        runOnUiThread(new Runnable() { // from class: ir.nasim.Gz4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l3(list);
            }
        });
    }

    private void z3() {
        AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.Nz4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m3();
            }
        });
    }

    @Override // ir.nasim.features.profile.avatar.a.InterfaceC1208a
    public void G(int i) throws Resources.NotFoundException {
        if (this.O0 != null) {
            this.a1 = true;
            D3(i);
            this.O0.setCurrentItem(i);
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C6011Lu2.m(this);
        super.onCreate(bundle);
        C11458d25 c11458d25R = C11458d25.r(getIntent().getLongExtra("chat_peer", 0L));
        this.M0 = c11458d25R;
        if (c11458d25R.getPeerId() == 0) {
            finish();
        }
        this.N0 = (ZN2) getIntent().getSerializableExtra("extra_peer_id");
        if (bundle != null) {
            this.K0 = bundle.getString("externalFile", null);
            this.L0 = bundle.getString("avatarPath", null);
        }
        setContentView(AbstractC12208eD5.activity_avatar_view);
        d3();
        e3();
        E3();
        w3();
        AbstractC7426Rr.S(this, C5495Jo7.a.j2());
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 3 && iArr.length > 0 && iArr[0] == 0) {
            S3();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        bundle.putString("Keep it from crashing", "Don't remove this.");
        super.onSaveInstanceState(bundle, persistableBundle);
        if (this.L0 != null) {
            bundle.putString("avatarPath", this.L0);
        }
        String str = this.K0;
        if (str != null) {
            bundle.putString("externalFile", str);
        }
    }

    @Override // ir.nasim.features.profile.avatar.b.InterfaceC1209b
    public void x() {
        if (f3()) {
            a3(250L);
        } else {
            N3(250L);
        }
    }
}
