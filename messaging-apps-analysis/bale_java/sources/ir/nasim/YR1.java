package ir.nasim;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import ir.nasim.AbstractC12129e53;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC16345l7;
import ir.nasim.AbstractC20016rK4;
import ir.nasim.AbstractC23684xL1;
import ir.nasim.AbstractC4820Gr7;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.C15225jD4;
import ir.nasim.C20085rS1;
import ir.nasim.C21753u45;
import ir.nasim.DD;
import ir.nasim.GY;
import ir.nasim.IO1;
import ir.nasim.InterfaceC18834pK4;
import ir.nasim.InterfaceC19425qK4;
import ir.nasim.InterfaceC20625sK4;
import ir.nasim.components.appbar.view.DrawerToolbar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.audioplayer.ui.AudioPlayBar;
import ir.nasim.features.audioplayer.ui.playlist.PlayListBottomSheet;
import ir.nasim.features.call.ui.CallActivity;
import ir.nasim.features.dialogs.view.CallLogsTabView;
import ir.nasim.features.dialogs.view.DialogTabView;
import ir.nasim.features.eventbar.data.model.EventBarData;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.C13090h;
import ir.nasim.features.root.RootActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes5.dex */
public class YR1 extends AbstractC22598vW2 implements InterfaceC17721nS1, AudioPlayBar.a, InterfaceC14088hK4, C15225jD4.b {
    private ComposeView A1;
    private ComposeView B1;
    private DrawerToolbar C1;
    private ImageView D1;
    private ShimmerFrameLayout E1;
    private TextView F1;
    private TextView G1;
    private TextView H1;
    private TextView I1;
    private ImageView J1;
    private LottieAnimationView K1;
    private ImageView L1;
    private ConstraintLayout M1;
    private InterfaceC19868r46 N1;
    private UM3 O1;
    private TextView P1;
    private GY Q1;
    InterfaceC8288Vi1 R1;
    InterfaceC23238wb0 S1;
    private com.google.android.material.tabs.d U1;
    private C17468n10 Y1;
    private TabLayout.d b2;
    private SpannableStringBuilder h2;
    private C20085rS1 i1;
    private C6243Mu0 j1;
    JM2 k1;
    DK4 l1;
    private ViewPager2 n1;
    private TabLayout o1;
    private C21323tT1 p1;
    private C17130mS1 q1;
    private Handler r1;
    private AudioPlayBar t1;
    private AbstractC13089g.b u1;
    private FloatingActionButton w1;
    private MaterialButton x1;
    private RecyclerView.t y1;
    private ConstraintLayout z1;
    private final AbstractC22357v6 h1 = N7(new C18699p6(), new InterfaceC17517n6() { // from class: ir.nasim.VR1
        @Override // ir.nasim.InterfaceC17517n6
        public final void a(Object obj) {
            this.a.hd((Uri) obj);
        }
    });
    private int m1 = 0;
    private boolean s1 = false;
    private boolean v1 = false;
    private int V1 = 0;
    private int W1 = 0;
    private final Map X1 = new HashMap();
    private final InterfaceC7258Qy2 Z1 = new InterfaceC7258Qy2() { // from class: ir.nasim.WR1
        @Override // ir.nasim.InterfaceC7258Qy2
        public final void d(FragmentManager fragmentManager, Fragment fragment) {
            this.a.Cc(fragmentManager, fragment);
        }
    };
    private final GN1 a2 = new GN1() { // from class: ir.nasim.XR1
        @Override // ir.nasim.GN1
        public final void a() {
            this.a.Dc();
        }
    };
    private final Runnable c2 = new Runnable() { // from class: ir.nasim.YQ1
        @Override // java.lang.Runnable
        public final void run() {
            this.a.Ec();
        }
    };
    private boolean d2 = false;
    private boolean e2 = false;
    private boolean f2 = true;
    private long g2 = 0;

    class a extends RecyclerView.t {
        private final int a;

        a() {
            this.a = YR1.this.b6().getDimensionPixelOffset(AbstractC14008hB5.fab_scroll_threshold);
        }

        private void c() {
            if (YR1.this.v1) {
                YR1.this.v1 = false;
                YR1.this.Ab();
            }
        }

        private void d() {
            if (YR1.this.v1) {
                return;
            }
            YR1.this.v1 = true;
            YR1.this.yb();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            if (recyclerView.canScrollVertically(1) || YR1.this.i1.w1().getValue() != EnumC11273cj7.e || ((Boolean) YR1.this.i1.B1().getValue()).booleanValue() || !C8386Vt0.J9()) {
                return;
            }
            YR1.this.i1.v2();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (Math.abs(i2) > this.a) {
                if (i2 > 0) {
                    d();
                } else {
                    c();
                }
            }
        }
    }

    class b extends ViewPager2.i {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i) {
            super.a(i);
            if (i == 0) {
                EnumC11273cj7 enumC11273cj7Cb = YR1.this.Cb();
                YR1.this.i1.f2(enumC11273cj7Cb);
                if (enumC11273cj7Cb == null) {
                    enumC11273cj7Cb = EnumC11273cj7.b;
                }
                if (enumC11273cj7Cb.j()) {
                    if (YR1.this.W1 >= 5) {
                        YR1.this.td(true);
                        YR1.this.sd(false);
                    } else {
                        YR1.this.td(false);
                        YR1.this.sd(true);
                    }
                    YR1.this.w1.setImageDrawable(YR1.this.S7().getDrawable(KB5.ic_add_chat));
                    YR1.this.w1.setContentDescription(YR1.this.S7().getString(AbstractC12217eE5.dialogs_fragment_fab_content_description));
                    YR1.this.x1.setText(AbstractC12217eE5.send_message_fab);
                    YR1.this.x1.setIcon(YR1.this.S7().getDrawable(KB5.ic_add_chat));
                    return;
                }
                if (YR1.this.V1 >= 5) {
                    YR1.this.td(true);
                    YR1.this.sd(false);
                } else {
                    YR1.this.td(false);
                    YR1.this.sd(true);
                }
                YR1.this.w1.setImageDrawable(YR1.this.S7().getDrawable(KB5.ic_add_call));
                YR1.this.w1.setContentDescription(YR1.this.S7().getString(AbstractC12217eE5.call_logs_fragment_fab_content_description));
                YR1.this.x1.setText(AbstractC12217eE5.call_to_contacts);
                YR1.this.x1.setIcon(YR1.this.S7().getDrawable(KB5.ic_add_call));
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i, float f, int i2) {
            super.b(i, f, i2);
        }
    }

    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;

        static {
            int[] iArr = new int[EnumC14280hf2.values().length];
            e = iArr;
            try {
                iArr[EnumC14280hf2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                e[EnumC14280hf2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC18517on4.values().length];
            d = iArr2;
            try {
                iArr2[EnumC18517on4.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[EnumC18517on4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[EnumC7306Rd5.values().length];
            c = iArr3;
            try {
                iArr3[EnumC7306Rd5.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[EnumC7306Rd5.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[EnumC7306Rd5.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr4 = new int[AbstractC13089g.b.values().length];
            b = iArr4;
            try {
                iArr4[AbstractC13089g.b.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[AbstractC13089g.b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr5 = new int[EnumC11273cj7.values().length];
            a = iArr5;
            try {
                iArr5[EnumC11273cj7.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[EnumC11273cj7.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[EnumC11273cj7.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[EnumC11273cj7.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[EnumC11273cj7.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[EnumC11273cj7.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public interface e {
        void C0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ab() {
        FloatingActionButton floatingActionButton = this.w1;
        if (floatingActionButton != null) {
            floatingActionButton.animate().translationY(0.0f).setDuration(200L).start();
        }
        MaterialButton materialButton = this.x1;
        if (materialButton != null) {
            materialButton.animate().translationY(0.0f).setDuration(200L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Ac(Integer num, String str) {
        this.i1.W1(new InterfaceC19425qK4.d(num.intValue(), str, Cb()));
        return null;
    }

    private void Ad() {
        if (this.J1.getVisibility() != 8) {
            this.J1.setVisibility(8);
        }
        if (this.M1.getVisibility() != 8) {
            this.M1.setVisibility(8);
        }
        if (this.K1.getVisibility() != 0) {
            this.K1.setVisibility(0);
        }
    }

    private void Bb() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.w1.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, 0, 200);
        this.w1.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.x1.getLayoutParams();
        marginLayoutParams2.setMargins(0, 0, 0, 200);
        this.x1.setLayoutParams(marginLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Bc(View view) {
        this.h1.a("application/json");
        return true;
    }

    private void Bd(final AbstractC16345l7.a aVar) {
        final String strG;
        final int i;
        if (rb(this.n1.getCurrentItem())) {
            this.z1.setVisibility(0);
        } else {
            this.z1.setVisibility(8);
        }
        this.D1.setVisibility(8);
        this.E1.setVisibility(0);
        if (aVar.d() != null) {
            this.i1.a2(aVar.d(), new UA2() { // from class: ir.nasim.xR1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return this.a.Yc(aVar, (Drawable) obj);
                }
            });
        } else {
            this.i1.r2(aVar.e(), new UA2() { // from class: ir.nasim.yR1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return this.a.Zc((Drawable) obj);
                }
            });
            this.D1.setVisibility(0);
            this.E1.setVisibility(8);
        }
        this.F1.setText(R62.V(aVar.j(), this.F1.getPaint().getFontMetricsInt(), false));
        this.G1.setText(R62.V(AbstractC5730Kp.c(aVar.b()), this.G1.getPaint().getFontMetricsInt(), false));
        if (aVar.g().isEmpty()) {
            strG = "";
            this.H1.setText("");
            this.H1.setVisibility(8);
            i = 1;
        } else {
            strG = aVar.g();
            TextView textView = this.H1;
            textView.setText(R62.V(strG, textView.getPaint().getFontMetricsInt(), false));
            this.H1.setVisibility(0);
            i = 3;
        }
        if (Zb(aVar.f())) {
            strG = aVar.g().isEmpty() ? h6(AbstractC12217eE5.ads_join_badge) : aVar.g();
            this.H1.setText(strG);
            this.H1.setVisibility(0);
            i = 2;
        }
        this.i1.l2(aVar, i, strG);
        this.z1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zR1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.ad(aVar, i, strG, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EnumC11273cj7 Cb() {
        try {
            return (EnumC11273cj7) this.o1.y(this.n1.getCurrentItem()).j();
        } catch (Exception e2) {
            C19406qI3.c("DialogsContainerFragment", "getCurrentTab: ", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Cc(FragmentManager fragmentManager, Fragment fragment) {
        C17468n10 c17468n10;
        if (fragment == this || (c17468n10 = this.Y1) == null) {
            return;
        }
        c17468n10.f();
        this.Y1 = null;
    }

    private void Cd() {
        if (this.K1.getVisibility() != 8) {
            this.K1.setVisibility(8);
        }
        if (this.M1.getVisibility() != 8) {
            this.M1.setVisibility(8);
        }
        if (this.J1.getVisibility() != 0) {
            this.J1.setVisibility(0);
        }
    }

    private String Db(EnumC11273cj7 enumC11273cj7) {
        switch (d.a[enumC11273cj7.ordinal()]) {
            case 1:
                return h6(AbstractC12217eE5.all_dialog_tab_type_title);
            case 2:
                return h6(AbstractC12217eE5.call_log_dialog_tab_type_title);
            case 3:
                return h6(AbstractC12217eE5.private_dialog_tab_type_title);
            case 4:
                return h6(AbstractC12217eE5.channel_dialog_tab_type_title);
            case 5:
                return h6(AbstractC12217eE5.group_dialog_tab_type_title);
            case 6:
                return h6(AbstractC12217eE5.bot_dialog_tab_type_title);
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dc() {
        if (C8386Vt0.D5()) {
            this.i1.U1(new IO1.a(AbstractC23684xL1.b.b));
        } else if (rb(this.n1.getCurrentItem())) {
            this.i1.m1(false);
        }
    }

    private void Dd(String str) {
        try {
            Fragment fragmentU5 = U5();
            if (fragmentU5 instanceof C13090h) {
                ((C13090h) fragmentU5).Jd(str);
            }
        } catch (Exception e2) {
            C19406qI3.j("DialogsContainerFragment", "showSnackBar error: " + e2.getMessage(), new Object[0]);
        }
    }

    private Fragment Eb(int i) {
        return F5().p0("f" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ec() {
        if (this.o1 == null || A5() == null) {
            return;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            A5().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            this.o1.measure(0, 0);
            if (i > this.o1.getMeasuredWidth()) {
                if (this.o1.getTabMode() != 1) {
                    this.o1.setTabMode(1);
                    this.o1.setTabGravity(0);
                }
            } else if (this.o1.getTabMode() != 0) {
                this.o1.setTabMode(0);
                this.o1.setTabGravity(1);
            }
            this.o1.postInvalidate();
        } catch (Exception e2) {
            C19406qI3.d("DialogsContainerFragment", e2);
        }
    }

    private void Ed(List list) {
        int size = list.size();
        if (size == 1) {
            Dd(i6(AbstractC12217eE5.unable_to_delete_conversation, ((C17067mL1) list.get(0)).J()));
        } else if (size > 1) {
            Dd(i6(AbstractC12217eE5.unable_to_delete_conversations, Integer.valueOf(list.size())));
        }
    }

    private void Fb(T74 t74) {
        if (t74 == null) {
            return;
        }
        C18987pb3.a.t1(t74.e(), Long.valueOf(t74.f()), Long.valueOf(t74.d()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fc(AbstractC12129e53 abstractC12129e53) {
        boolean z;
        float f = 0.0f;
        if ((abstractC12129e53 instanceof AbstractC12129e53.a) || (abstractC12129e53 instanceof AbstractC12129e53.e)) {
            z = true;
        } else {
            z = false;
            if (abstractC12129e53 instanceof AbstractC12129e53.c) {
                f = ((AbstractC12129e53.c) abstractC12129e53).f();
            }
        }
        this.C1.setMenuIconForDownloadState(z, f);
    }

    private void Fd() {
        if (this.K1.getVisibility() != 8) {
            this.K1.setVisibility(8);
        }
        if (this.J1.getVisibility() != 8) {
            this.J1.setVisibility(8);
        }
        if (this.M1.getVisibility() != 0) {
            this.M1.setVisibility(0);
        }
    }

    private void Gb(AbstractC16345l7 abstractC16345l7) {
        if (abstractC16345l7 instanceof AbstractC16345l7.a) {
            this.s1 = true;
            Bd((AbstractC16345l7.a) abstractC16345l7);
        } else if (abstractC16345l7 instanceof AbstractC16345l7.b) {
            this.s1 = false;
            this.z1.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gc(Boolean bool) {
        if (bool.booleanValue()) {
            Bb();
        } else {
            zb();
        }
    }

    private void Gd(EnumC20553sC4 enumC20553sC4) {
        if (enumC20553sC4 == EnumC20553sC4.a) {
            Fd();
        } else if (enumC20553sC4 == EnumC20553sC4.b) {
            Cd();
        } else if (enumC20553sC4 == EnumC20553sC4.c) {
            Ad();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Hb() {
        /*
            r13 = this;
            ir.nasim.rS1 r0 = r13.i1
            androidx.lifecycle.r r0 = r0.M1()
            java.lang.Object r0 = r0.f()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto Lf9
            int r1 = r0.size()
            java.lang.String r2 = ""
            r3 = 1
            if (r1 != r3) goto L1f
            int r1 = ir.nasim.AbstractC12217eE5.delete_conversation
            java.lang.String r1 = r13.h6(r1)
        L1d:
            r6 = r1
            goto L39
        L1f:
            int r1 = r0.size()
            if (r1 <= r3) goto L38
            int r1 = ir.nasim.AbstractC12217eE5.delete_conversations_title
            int r4 = r0.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r1 = r13.i6(r1, r4)
            goto L1d
        L38:
            r6 = r2
        L39:
            int r1 = r0.size()
            if (r1 != r3) goto Lc7
            r1 = 0
            java.lang.Object r1 = r0.get(r1)
            ir.nasim.mL1 r1 = (ir.nasim.C17067mL1) r1
            ir.nasim.d25 r2 = r1.R()
            ir.nasim.W25 r2 = r2.s()
            ir.nasim.W25 r3 = ir.nasim.W25.b
            if (r2 != r3) goto L7d
            int r2 = ir.nasim.AbstractC12217eE5.delete_group_conversation_desc
            java.lang.String r3 = r1.J()
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r2 = r13.i6(r2, r3)
            ir.nasim.VL3 r3 = ir.nasim.AbstractC5969Lp4.b()
            ir.nasim.d25 r4 = r1.R()
            int r4 = r4.getPeerId()
            long r4 = (long) r4
            ir.nasim.id0 r3 = r3.n(r4)
            ir.nasim.iO2 r3 = (ir.nasim.C14733iO2) r3
            ir.nasim.ZN2 r3 = r3.q()
            java.lang.String r2 = ir.nasim.AbstractC5969Lp4.a(r2, r3)
        L7b:
            r7 = r2
            goto L97
        L7d:
            ir.nasim.core.modules.profile.entity.ExPeerType r2 = r1.getExPeerType()
            ir.nasim.core.modules.profile.entity.ExPeerType r3 = ir.nasim.core.modules.profile.entity.ExPeerType.BOT
            if (r2 != r3) goto L88
            int r2 = ir.nasim.AbstractC12217eE5.delete_bot_conversation_desc
            goto L8a
        L88:
            int r2 = ir.nasim.AbstractC12217eE5.delete_private_conversation_desc
        L8a:
            java.lang.String r3 = r1.J()
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r2 = r13.i6(r2, r3)
            goto L7b
        L97:
            ir.nasim.core.modules.profile.entity.ExPeerType r1 = r1.getExPeerType()
            ir.nasim.core.modules.profile.entity.ExPeerType r2 = ir.nasim.core.modules.profile.entity.ExPeerType.BOT
            if (r1 != r2) goto Ld4
            android.content.Context r4 = r13.S7()
            ir.nasim.oz3 r5 = r13.p6()
            int r1 = ir.nasim.AbstractC12217eE5.profile_settings_block
            java.lang.String r8 = r13.h6(r1)
            ir.nasim.KR1 r9 = new ir.nasim.KR1
            r9.<init>()
            ir.nasim.LR1 r10 = new ir.nasim.LR1
            r10.<init>()
            int r0 = ir.nasim.AbstractC12217eE5.dialogs_menu_conversation_delete
            java.lang.String r11 = r13.h6(r0)
            int r0 = ir.nasim.AbstractC12217eE5.dialog_cancel
            java.lang.String r12 = r13.h6(r0)
            ir.nasim.AbstractC10316bS1.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        Lc7:
            int r1 = r0.size()
            if (r1 <= r3) goto Ld3
            int r1 = ir.nasim.AbstractC12217eE5.delete_conversations_desc
            java.lang.String r2 = r13.h6(r1)
        Ld3:
            r7 = r2
        Ld4:
            android.content.Context r4 = r13.S7()
            ir.nasim.oz3 r5 = r13.p6()
            ir.nasim.MR1 r8 = new ir.nasim.MR1
            r8.<init>()
            ir.nasim.NR1 r9 = new ir.nasim.NR1
            r9.<init>()
            int r0 = ir.nasim.AbstractC12217eE5.dialogs_menu_conversation_delete
            java.lang.String r10 = r13.h6(r0)
            int r0 = ir.nasim.AbstractC12217eE5.dialog_cancel
            java.lang.String r11 = r13.h6(r0)
            android.app.Dialog r0 = ir.nasim.AbstractC10316bS1.b(r4, r5, r6, r7, r8, r9, r10, r11)
            r0.show()
        Lf9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YR1.Hb():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hc(C20085rS1.f fVar) {
        if (fVar.b() == ExPeerType.PRIVATE || fVar.b() == ExPeerType.BOT) {
            Dd(S7().getString(AbstractC12217eE5.toast_unable_delete_chat));
        } else {
            Dd(UN2.a(fVar.a(), fVar.b() == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL));
        }
    }

    private void Ib() {
        Nb();
        this.C1.j0();
        this.C1.e0(new View.OnClickListener() { // from class: ir.nasim.dR1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.nc(view);
            }
        });
        this.C1.getMenu().setGroupVisible(BC5.menu_dialog_normal, false);
        this.C1.getMenu().setGroupVisible(BC5.menu_dialog_action_mode, true);
        this.C1.getMenu().findItem(BC5.dialog_action_pin).setVisible(true);
        this.C1.getMenu().findItem(BC5.dialog_action_mute).setVisible(true);
        if (this.P1 == null) {
            TextView textView = (TextView) this.C1.findViewById(BC5.selected_dialogs_counter);
            this.P1 = textView;
            textView.setTextSize(18.0f);
            this.P1.setTypeface(C6011Lu2.i());
            this.P1.setTextColor(C5495Jo7.a.l2());
            this.P1.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.eR1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return YR1.oc(view, motionEvent);
                }
            });
        }
        this.P1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Ic(W25 w25, int i) {
        if (w25 == W25.a) {
            y9(C24137y63.b(i));
        } else if (w25 == W25.b) {
            y9(this.k1.a(i, false));
        }
        this.i1.E2(AbstractC4820Gr7.c.a);
        return C19938rB7.a;
    }

    private void Jb() {
        Nb();
        this.C1.j0();
        this.C1.e0(new View.OnClickListener() { // from class: ir.nasim.hR1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.pc(view);
            }
        });
        this.C1.getMenu().setGroupVisible(BC5.menu_dialog_normal, false);
        this.C1.getMenu().setGroupVisible(BC5.menu_dialog_action_mode, true);
        this.C1.getMenu().findItem(BC5.dialog_action_pin).setVisible(false);
        this.C1.getMenu().findItem(BC5.dialog_action_mute).setVisible(false);
        this.C1.getMenu().findItem(BC5.dialog_action_more).setVisible(false);
        if (this.P1 == null) {
            TextView textView = (TextView) this.C1.findViewById(BC5.selected_dialogs_counter);
            this.P1 = textView;
            textView.setTextSize(18.0f);
            this.P1.setTypeface(C6011Lu2.i());
            this.P1.setTextColor(C5495Jo7.a.l2());
            this.P1.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.jR1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return YR1.qc(view, motionEvent);
                }
            });
        }
        this.P1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jc(AbstractC4820Gr7 abstractC4820Gr7) {
        if (abstractC4820Gr7 instanceof AbstractC4820Gr7.a) {
            zd(((AbstractC4820Gr7.a) abstractC4820Gr7).a());
        } else if (abstractC4820Gr7 instanceof AbstractC4820Gr7.c) {
            Mb();
            Gd((EnumC20553sC4) this.i1.I1().f());
            this.i1.o1();
            this.i1.C2(true, 0);
        }
    }

    private void Kb() {
        this.i1.o2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kc(EnumC20553sC4 enumC20553sC4) {
        if (this.i1.Q1().f() instanceof AbstractC4820Gr7.a) {
            return;
        }
        Gd(enumC20553sC4);
    }

    private void Lb() {
        this.i1.z1().j(p6(), new QG4() { // from class: ir.nasim.FR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.rc((EventBarData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lc(MenuItem menuItem, EnumC18517on4 enumC18517on4) {
        if (menuItem == null) {
            return;
        }
        int i = d.d[enumC18517on4.ordinal()];
        if (i == 1) {
            if (this.i1.Q1().f() == AbstractC4820Gr7.c.a) {
                menuItem.setVisible(false);
                return;
            } else {
                if (this.i1.Q1().f() instanceof AbstractC4820Gr7.a) {
                    menuItem.setVisible(true);
                    menuItem.setIcon(KB5.ic_unmute);
                    return;
                }
                return;
            }
        }
        if (i != 2) {
            return;
        }
        if (this.i1.Q1().f() == AbstractC4820Gr7.c.a) {
            menuItem.setVisible(false);
        } else if (this.i1.Q1().f() instanceof AbstractC4820Gr7.a) {
            menuItem.setVisible(true);
            menuItem.setIcon(KB5.ic_mute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mc(MenuItem menuItem, EnumC7306Rd5 enumC7306Rd5) {
        if (menuItem == null) {
            return;
        }
        int i = d.c[enumC7306Rd5.ordinal()];
        if (i == 1) {
            if (this.i1.Q1().f() == AbstractC4820Gr7.c.a) {
                menuItem.setVisible(false);
                return;
            }
            if (this.i1.Q1().f() instanceof AbstractC4820Gr7.a) {
                menuItem.setVisible(true);
                Drawable drawableF = AbstractC4043Dl1.f(S7(), KB5.pin_off);
                if (drawableF != null) {
                    AbstractC21710u02.h(drawableF, -1);
                }
                menuItem.setIcon(drawableF);
                return;
            }
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            menuItem.setVisible(false);
        } else {
            if (this.i1.Q1().f() == AbstractC4820Gr7.c.a) {
                menuItem.setVisible(false);
                return;
            }
            if (this.i1.Q1().f() instanceof AbstractC4820Gr7.a) {
                menuItem.setVisible(true);
                Drawable drawableF2 = AbstractC4043Dl1.f(S7(), KB5.pin);
                if (drawableF2 != null) {
                    AbstractC21710u02.h(drawableF2, -1);
                }
                menuItem.setIcon(drawableF2);
            }
        }
    }

    private void Nb() {
        if (this.M1.getVisibility() != 8) {
            this.M1.setVisibility(8);
        }
        if (this.J1.getVisibility() != 8) {
            this.J1.setVisibility(8);
        }
        if (this.K1.getVisibility() != 8) {
            this.K1.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nc(Integer num) {
        TextView textView = this.P1;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        if (num.intValue() == Integer.MAX_VALUE) {
            this.P1.setText(h6(AbstractC12217eE5.toolbar_all_title));
            return;
        }
        String string = num.toString();
        if (JF5.g()) {
            string = XY6.e(string);
        }
        this.P1.setText(string);
    }

    private void Ob(View view) {
        AudioPlayBar audioPlayBar = (AudioPlayBar) view.findViewById(BC5.top_audio_play_bar);
        this.t1 = audioPlayBar;
        audioPlayBar.p();
        this.t1.setOnPlayerCallbacks(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oc(AbstractC16345l7 abstractC16345l7) {
        if (abstractC16345l7 != null) {
            Gb(abstractC16345l7);
        }
    }

    private void Pb(View view) {
        AbstractC22226us4.a((ComposeView) view.findViewById(BC5.compose), new SA2() { // from class: ir.nasim.uR1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.tc();
            }
        }, new UA2() { // from class: ir.nasim.vR1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return this.a.uc((Long) obj);
            }
        }, this.j1.W0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Pc(AbstractC20016rK4 abstractC20016rK4) {
        this.i1.W1(InterfaceC19425qK4.b.a);
        y9(this.l1.f(((AbstractC20016rK4.b) abstractC20016rK4).g()));
        return null;
    }

    private void Qb(View view, boolean z) {
        this.w1 = (FloatingActionButton) view.findViewById(BC5.fragment_dialogs_container_contacts);
        MaterialButton materialButton = (MaterialButton) view.findViewById(BC5.fragment_dialogs_container_contacts_card);
        this.x1 = materialButton;
        materialButton.setTypeface(C6011Lu2.i());
        this.w1.setImageTintList(ColorStateList.valueOf(C5495Jo7.a.q0()));
        this.w1.setContentDescription(S7().getString(AbstractC12217eE5.dialogs_fragment_fab_content_description));
        this.x1.setContentDescription(S7().getString(AbstractC12217eE5.dialogs_fragment_fab_content_description));
        if (C8386Vt0.J5()) {
            Lb();
        } else if (z) {
            Bb();
            this.i1.u2(true);
        }
        this.x1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lR1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.vc(view2);
            }
        });
        this.w1.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.mR1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.wc(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Qc() {
        this.i1.W1(InterfaceC19425qK4.c.a);
        return null;
    }

    private void Rb(View view) {
        FO1.I(this.B1, this.i1.w1(), this.i1.x1(), new UA2() { // from class: ir.nasim.nR1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return this.a.yc((IO1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rc(final AbstractC20016rK4 abstractC20016rK4) {
        if (!(abstractC20016rK4 instanceof AbstractC20016rK4.b)) {
            this.A1.setVisibility(8);
            return;
        }
        AbstractC3951Db.a(this.A1, ((AbstractC20016rK4.b) abstractC20016rK4).f(), new SA2() { // from class: ir.nasim.oR1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Pc(abstractC20016rK4);
            }
        }, new SA2() { // from class: ir.nasim.pR1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.Qc();
            }
        });
        if (sb()) {
            this.z1.setVisibility(8);
            this.A1.setVisibility(0);
            this.i1.W1(InterfaceC19425qK4.e.a);
        }
    }

    private void Sb(View view) {
        if (AbstractC5969Lp4.d().w0(EnumC4196Ec1.A)) {
            view.findViewById(BC5.nazriFabImgView).setVisibility(0);
            view.findViewById(BC5.nazriFabImgView).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sR1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.zc(view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Sc() {
        this.i1.m2(EnumC16185kq6.c);
        return C19938rB7.a;
    }

    private void Tb(View view) {
        this.l1.c(new InterfaceC14603iB2() { // from class: ir.nasim.cR1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return this.a.Ac((Integer) obj, (String) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Tc() {
        this.i1.m2(EnumC16185kq6.b);
        return C19938rB7.a;
    }

    private void Ub(View view) {
        this.C1 = (DrawerToolbar) view.findViewById(BC5.dialogs_container_toolbar);
        this.I1 = (TextView) view.findViewById(BC5.toolbar_text);
        this.L1 = (ImageView) view.findViewById(BC5.toolbar_text_drawable);
        this.M1 = (ConstraintLayout) view.findViewById(BC5.toolbar_text_container);
        this.J1 = (ImageView) view.findViewById(BC5.dialogs_container_toolbar_iv);
        this.K1 = (LottieAnimationView) view.findViewById(BC5.dialogs_container_toolbar_lottie);
        ob(view);
        if (C8386Vt0.Jb()) {
            this.C1.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.rR1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return this.a.Bc(view2);
                }
            });
        }
        this.I1.setTextColor(C5495Jo7.a.i());
        this.I1.setTypeface(C6011Lu2.i());
        this.I1.setPadding(0, 0, 0, 0);
        this.I1.setTextSize((C5161Id6.k() || b6().getConfiguration().orientation != 2) ? 19.0f : 14.0f);
        this.I1.measure(View.MeasureSpec.makeMeasureSpec(C22078ud6.a(200.0f), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(C22078ud6.a(24.0f), RecyclerView.UNDEFINED_DURATION));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Uc(Integer num) {
        this.W1 = num.intValue();
        EnumC11273cj7 enumC11273cj7Cb = Cb();
        if (enumC11273cj7Cb == null || enumC11273cj7Cb == EnumC11273cj7.a || num.intValue() == -1) {
            return;
        }
        if (num.intValue() >= 5) {
            td(true);
            sd(false);
        } else {
            td(false);
            sd(true);
        }
    }

    private void Vb(View view) {
        this.o1 = (TabLayout) view.findViewById(BC5.tab_layout_dialogs);
        this.n1 = (ViewPager2) view.findViewById(BC5.view_pager_dialogs);
        this.z1 = (ConstraintLayout) view.findViewById(BC5.bale_ad_collapsing);
        this.D1 = (ImageView) view.findViewById(BC5.bale_native_ad_logo);
        this.E1 = (ShimmerFrameLayout) view.findViewById(BC5.bale_native_ad_logo_loading);
        this.F1 = (TextView) view.findViewById(BC5.name);
        this.G1 = (TextView) view.findViewById(BC5.description_ad);
        this.A1 = (ComposeView) view.findViewById(BC5.onboarding_banner);
        this.B1 = (ComposeView) view.findViewById(BC5.dialog_list_top_spot);
        this.H1 = (TextView) view.findViewById(BC5.ads_join_badge);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Vc(Integer num) {
        this.V1 = num.intValue();
        EnumC11273cj7 enumC11273cj7Cb = Cb();
        if (enumC11273cj7Cb == null || enumC11273cj7Cb != EnumC11273cj7.a) {
            return;
        }
        if (num.intValue() >= 5) {
            td(true);
            sd(false);
        } else {
            td(false);
            sd(true);
        }
    }

    private boolean Wb() {
        return !((Boolean) AbstractC5969Lp4.d().Y().v().E().f().b()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wc(EnumC14280hf2 enumC14280hf2) {
        int i = d.e[enumC14280hf2.ordinal()];
        if (i == 1) {
            Ab();
        } else {
            if (i != 2) {
                return;
            }
            yb();
        }
    }

    private boolean Xb() {
        return ((Boolean) AbstractC5969Lp4.d().Y().v().E().g().b()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Xc(Drawable drawable) {
        if (drawable != null) {
            this.D1.setImageDrawable(drawable);
        }
        return C19938rB7.a;
    }

    private boolean Yb() {
        ViewPager2 viewPager2;
        C21323tT1 c21323tT1 = this.p1;
        return (c21323tT1 == null || c21323tT1.getItemCount() <= 0 || (viewPager2 = this.n1) == null || viewPager2.getAdapter() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Yc(AbstractC16345l7.a aVar, Drawable drawable) {
        if (h9()) {
            return C19938rB7.a;
        }
        if (drawable == null) {
            this.i1.r2(aVar.e(), new UA2() { // from class: ir.nasim.GR1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return this.a.Xc((Drawable) obj);
                }
            });
        } else {
            this.D1.setImageDrawable(drawable);
        }
        this.D1.setVisibility(0);
        this.E1.setVisibility(8);
        return C19938rB7.a;
    }

    private boolean Zb(String str) {
        return str.toLowerCase().contains("/join/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 Zc(Drawable drawable) {
        if (drawable != null) {
            this.D1.setImageDrawable(drawable);
        }
        return C19938rB7.a;
    }

    private boolean ac() {
        return AbstractC5969Lp4.d().r0() || AbstractC5969Lp4.d().v0() || AbstractC5969Lp4.d().t0() || AbstractC5969Lp4.d().u0() || AbstractC5969Lp4.d().s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ad(AbstractC16345l7.a aVar, int i, String str, View view) {
        this.i1.T1(aVar, i, str, Q7());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 bc(List list, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C17067mL1 c17067mL1 = (C17067mL1) it.next();
            if (!list2.contains(c17067mL1)) {
                this.i1.h2(c17067mL1);
            }
        }
        return null;
    }

    private void bd() {
        boolean z = this.d2;
        if (!z && this.g2 != -1) {
            this.g2 = new Date().getTime();
        } else {
            if (!z || this.g2 <= 0) {
                return;
            }
            this.g2 = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C19938rB7 cc(SA2 sa2) {
        if (sa2 != null) {
            sa2.invoke();
        }
        return C19938rB7.a;
    }

    private void cd() {
        x9(this.S1.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 dc(List list, List list2, final SA2 sa2, Boolean bool) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C17067mL1 c17067mL1 = (C17067mL1) it.next();
            if (!list2.contains(c17067mL1)) {
                this.i1.l1(c17067mL1.R().getPeerId());
                if (!bool.booleanValue()) {
                    W25 w25S = c17067mL1.R().s();
                    if (w25S == W25.a) {
                        this.i1.q1(c17067mL1.R(), new SA2() { // from class: ir.nasim.SR1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return YR1.cc(sa2);
                            }
                        });
                    } else if (w25S == W25.b) {
                        this.i1.t1(c17067mL1.R().getPeerId(), this.i1.C1(c17067mL1.R().getPeerId(), w25S) == ZN2.GROUP ? ExPeerType.GROUP.getValue() : ExPeerType.CHANNEL.getValue());
                    }
                }
            }
        }
        return null;
    }

    private void dd() {
        this.i1.F1().j(p6(), new QG4() { // from class: ir.nasim.CR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Fc((AbstractC12129e53) obj);
            }
        });
        this.i1.Y1().j(p6(), new QG4() { // from class: ir.nasim.DR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Gc((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean ec(View view, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == BC5.search) {
            ld();
            return false;
        }
        if (itemId == BC5.dialog_action_mute) {
            jd();
            return false;
        }
        if (itemId == BC5.dialog_action_pin) {
            kd();
            return false;
        }
        if (itemId == BC5.dialog_action_delete) {
            fd();
            return false;
        }
        if (itemId != BC5.dialog_action_more) {
            return false;
        }
        id(view);
        return false;
    }

    private void ed() {
        this.i1.E1().j(p6(), new QG4() { // from class: ir.nasim.wR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Hc((C20085rS1.f) obj);
            }
        });
        dd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fc(View view) {
        cd();
    }

    private void fd() {
        if (this.i1.Q1().f() instanceof AbstractC4820Gr7.a) {
            int i = d.a[((AbstractC4820Gr7.a) this.i1.Q1().f()).a().ordinal()];
            if (i == 1) {
                Hb();
            } else {
                if (i != 2) {
                    return;
                }
                Kb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gc(TabLayout.g gVar, int i) {
        if (this.q1.o().size() <= i) {
            return;
        }
        CP1 cp1 = (CP1) this.q1.o().get(i);
        String strDb = Db(cp1.b());
        if (cp1 instanceof C12039dw0) {
            CallLogsTabView callLogsTabView = new CallLogsTabView(S7());
            callLogsTabView.setTitle(strDb);
            gVar.r(callLogsTabView);
        } else {
            DialogTabView dialogTabView = new DialogTabView(S7());
            dialogTabView.setTitle(strDb);
            Integer numN = this.q1.n(cp1.b());
            if (numN == null || numN.intValue() == 0) {
                dialogTabView.c();
                dialogTabView.setContentDescription(strDb);
            } else {
                dialogTabView.setCounter(numN.intValue());
                dialogTabView.setContentDescription(S7().getResources().getString(AbstractC12217eE5.dialogs_tab_layout_content_description, strDb, numN));
            }
            this.X1.put(cp1.b(), dialogTabView);
            gVar.r(dialogTabView);
        }
        gVar.w(cp1.b());
    }

    private void gd() {
        zb();
        this.i1.u2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hc(Boolean bool) {
        if (bool.booleanValue()) {
            this.p1.U(this.q1.o());
            ub();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd(Uri uri) {
        if (uri == null) {
            return;
        }
        try {
            this.N1 = new C19277q46(S7(), uri);
            rd();
        } catch (Exception e2) {
            C19406qI3.d("DialogsContainerFragment", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 ic(List list) {
        pb((C17067mL1) list.get(0));
        return C19938rB7.a;
    }

    private void id(View view) {
        List list = (List) this.i1.M1().f();
        if (list != null) {
            AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
            if (list.size() == 1) {
                C17067mL1 c17067mL1 = (C17067mL1) list.get(0);
                final int peerId = c17067mL1.R().getPeerId();
                final W25 w25S = c17067mL1.R().s();
                if (peerId != AbstractC5969Lp4.f()) {
                    bVar.i(AbstractC12217eE5.dialogs_menu_contact_view, KB5.ic_profile, new SA2() { // from class: ir.nasim.JR1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return this.a.Ic(w25S, peerId);
                        }
                    });
                }
            }
            if (bVar.b()) {
                return;
            }
            GY gyB = new GY.a(view, (ViewGroup) view.getRootView()).d(true).g(new RS4(4.0f, 4.0f, 4.0f, 2.0f)).b(bVar);
            this.Q1 = gyB;
            gyB.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 jc(final List list, Dialog dialog, Boolean bool) {
        dialog.dismiss();
        nb(list, new SA2() { // from class: ir.nasim.RR1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return this.a.ic(list);
            }
        });
        return C19938rB7.a;
    }

    private void jd() {
        List list = (List) this.i1.M1().f();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AbstractC5969Lp4.d().t(((C17067mL1) it.next()).R(), this.i1.R1().f() == EnumC18517on4.a);
            }
        }
        this.i1.E2(AbstractC4820Gr7.c.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C19938rB7 kc(Dialog dialog) {
        dialog.dismiss();
        return C19938rB7.a;
    }

    private void kd() {
        List list = (List) this.i1.M1().f();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.i1.g2((C17067mL1) it.next());
            }
        }
        this.i1.E2(AbstractC4820Gr7.c.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 lc(List list, Dialog dialog) {
        dialog.dismiss();
        mb(list);
        return C19938rB7.a;
    }

    private void ld() {
        y9(C8899Xu4.Jb(h6(AbstractC12217eE5.search_hint_dialogs)));
        C17213mb2.j("Search_click");
    }

    private void mb(List list) {
        nb(list, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C19938rB7 mc(Dialog dialog) {
        dialog.dismiss();
        return C19938rB7.a;
    }

    private void md() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            RecyclerView recyclerView = (RecyclerView) declaredField.get(this.n1);
            Field declaredField2 = RecyclerView.class.getDeclaredField("O0");
            declaredField2.setAccessible(true);
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) declaredField2.get(recyclerView)).intValue() * 4));
        } catch (Exception e2) {
            C19406qI3.j("DialogsContainerFragment", "reduceDragSensitivity: " + e2.getMessage(), new Object[0]);
        }
    }

    private void nb(final List list, final SA2 sa2) {
        String string;
        final List arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C17067mL1 c17067mL1 = (C17067mL1) it.next();
            W25 w25S = c17067mL1.R().s();
            if (w25S == W25.b && this.i1.Z1(c17067mL1.R().getPeerId(), AbstractC5969Lp4.f(), w25S)) {
                arrayList.add(c17067mL1);
            }
        }
        if (arrayList.size() == list.size()) {
            Ed(arrayList);
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C17067mL1 c17067mL12 = (C17067mL1) it2.next();
                if (!arrayList.contains(c17067mL12)) {
                    this.i1.s1(c17067mL12.R());
                }
            }
            if (list.size() == 1) {
                W25 w25S2 = ((C17067mL1) list.get(0)).R().s();
                string = w25S2 == W25.a ? S7().getString(AbstractC12217eE5.delete_chat_in_dialogs_container) : w25S2 == W25.b ? this.i1.C1(((C17067mL1) list.get(0)).R().getPeerId(), w25S2) == ZN2.GROUP ? S7().getString(AbstractC12217eE5.delete_group_in_dialogs_container) : S7().getString(AbstractC12217eE5.delete_channel_in_dialogs_container) : "";
            } else {
                string = S7().getString(AbstractC12217eE5.delete_chats_in_dialogs_container);
            }
            Fragment fragmentU5 = U5();
            if (fragmentU5 instanceof C13090h) {
                C17468n10 c17468n10 = new C17468n10(fragmentU5.V7(), fragmentU5.V7().findViewById(BC5.bottomNavigation_container), 5000);
                this.Y1 = c17468n10;
                c17468n10.n(string, new AbstractC13463gG6.a(S7().getString(AbstractC12217eE5.snackbar_action_undo), Integer.valueOf(KB5.undo), true, new SA2() { // from class: ir.nasim.OR1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return this.a.bc(list, arrayList);
                    }
                }), new UA2() { // from class: ir.nasim.QR1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return this.a.dc(list, arrayList, sa2, (Boolean) obj);
                    }
                });
            }
        }
        this.i1.E2(AbstractC4820Gr7.c.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void nc(View view) {
        this.i1.E2(AbstractC4820Gr7.c.a);
    }

    private void nd() {
        if (AbstractC21784u76.a()) {
            return;
        }
        try {
            if (getBaleResumed()) {
                if (AbstractC4043Dl1.a(G5(), "android.permission.READ_CONTACTS") == 0 && AbstractC4043Dl1.a(G5(), "android.permission.WRITE_CONTACTS") == 0) {
                    return;
                }
                AI7.b(false);
                C21753u45.a.a1(this, 1088, C21753u45.c.c, null, new SA2() { // from class: ir.nasim.fR1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return this.a.Sc();
                    }
                }, new SA2() { // from class: ir.nasim.gR1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return this.a.Tc();
                    }
                }, C21753u45.d.i, C21753u45.d.h);
            }
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private void ob(final View view) {
        this.C1.y(AbstractC15226jD5.dialog_container_new);
        this.C1.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.HR1
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.a.ec(view, menuItem);
            }
        });
        this.C1.setNavigationDrawerFragment(this.i1.k1());
        this.C1.setNavigationOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IR1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.fc(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean oc(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void od() {
        this.v1 = false;
        Ab();
    }

    private void pb(C17067mL1 c17067mL1) {
        this.i1.i1(c17067mL1.R().getPeerId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pc(View view) {
        this.i1.n2();
        this.i1.E2(AbstractC4820Gr7.c.a);
    }

    private boolean qb(Fragment fragment) {
        return fragment instanceof e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean qc(View view, MotionEvent motionEvent) {
        return true;
    }

    private void qd() {
        if (this.N1.a(0) != 0) {
            xd(h6(this.N1.a(0)));
        }
        DD ddC = this.N1.c(0);
        if (ddC == null) {
            this.i1.z2(EnumC20553sC4.b);
            this.J1.setImageResource(this.N1.b(0));
            this.J1.setColorFilter(this.O1.b());
        } else {
            this.i1.z2(EnumC20553sC4.c);
            if (ddC instanceof DD.a) {
                this.K1.setAnimation(((DD.a) ddC).a());
            } else if (ddC instanceof DD.b) {
                this.K1.setAnimationFromJson(((DD.b) ddC).a(), null);
            }
            this.K1.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rb(int i) {
        if (sb()) {
            return false;
        }
        return (i == 0 && this.m1 == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void rc(EventBarData eventBarData) {
        if (eventBarData instanceof EventBarData.Enabled) {
            Bb();
        } else {
            zb();
        }
    }

    private void rd() {
        String strH6;
        View viewFindViewById = V7().findViewById(BC5.fragment_dialogs_container_parent);
        if (this.u1 != AbstractC13089g.b.c) {
            bd();
            boolean zWb = Wb();
            boolean zXb = Xb();
            if (zWb && !zXb) {
                qd();
                if (this.e2) {
                    this.f2 = false;
                    this.e2 = false;
                }
                viewFindViewById.setContentDescription(S7().getString(AbstractC12217eE5.all_app_name));
                return;
            }
            if (!zWb) {
                strH6 = C4100Dr4.a(G5()) ? h6(AbstractC12217eE5.dialogs_connection_state_connecting) : h6(AbstractC12217eE5.dialogs_connection_state_wait_for_network);
            } else if (this.f2) {
                strH6 = h6(AbstractC12217eE5.dialogs_connection_state_updating);
                this.e2 = true;
            } else {
                strH6 = null;
            }
            if (strH6 != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strH6);
                this.h2 = spannableStringBuilder;
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.9f), 0, this.h2.length(), 33);
                xd(this.h2);
                if (!zWb || Xb()) {
                    viewFindViewById.setContentDescription(strH6);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sb() {
        return ((AbstractC20016rK4) this.i1.J1().f()).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void sc(View view) {
        cd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sd(boolean z) {
        this.x1.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 tc() {
        n8(CallActivity.l3(S7()));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(boolean z) {
        this.w1.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 uc(Long l) {
        this.j1.Y0(l.longValue());
        return null;
    }

    private void ud() {
        TabLayout.g gVarY;
        TabLayout tabLayout = this.o1;
        if (tabLayout == null || (gVarY = tabLayout.y(tabLayout.getSelectedTabPosition())) == null) {
            return;
        }
        try {
            View viewE = gVarY.e();
            Objects.requireNonNull(viewE);
            TextView textView = (TextView) viewE.findViewById(BC5.tv_dialog_tab_title);
            if (textView != null) {
                C5495Jo7 c5495Jo7 = C5495Jo7.a;
                textView.setTextColor(c5495Jo7.y2());
                wd(textView, c5495Jo7.y2());
            }
        } catch (Exception e2) {
            C19406qI3.d("DialogsContainerFragment", e2);
        }
    }

    private void vb() {
        Q7().B0().m(this.Z1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vc(View view) {
        EnumC11273cj7 enumC11273cj7Cb = Cb();
        if (enumC11273cj7Cb == null) {
            enumC11273cj7Cb = EnumC11273cj7.b;
        }
        if (enumC11273cj7Cb.j()) {
            y9(this.R1.b(EnumC6843Pf2.d));
        } else if (enumC11273cj7Cb == EnumC11273cj7.a) {
            y9(this.R1.d(EnumC6843Pf2.e));
        }
    }

    private void vd() {
        c cVar = new c();
        this.b2 = cVar;
        this.o1.d(cVar);
    }

    private void wb() {
        this.o1.setVisibility(ac() ? 0 : 8);
        com.google.android.material.tabs.d dVar = new com.google.android.material.tabs.d(this.o1, this.n1, new d.b() { // from class: ir.nasim.kR1
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i) {
                this.a.gc(gVar, i);
            }
        });
        this.U1 = dVar;
        dVar.a();
        vd();
        ud();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wc(View view) {
        EnumC11273cj7 enumC11273cj7Cb = Cb();
        if (enumC11273cj7Cb == null) {
            enumC11273cj7Cb = EnumC11273cj7.b;
        }
        if (enumC11273cj7Cb.j()) {
            y9(this.R1.b(EnumC6843Pf2.d));
        } else if (enumC11273cj7Cb == EnumC11273cj7.a) {
            y9(this.R1.d(EnumC6843Pf2.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wd(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            }
        }
    }

    private void xb() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.i1.O1().j(p6(), new QG4() { // from class: ir.nasim.qR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.hc((Boolean) obj);
            }
        });
        this.y1 = new a();
        C21323tT1 c21323tT1 = new C21323tT1(this, this.q1.o(), this.a2, this.y1);
        this.p1 = c21323tT1;
        this.n1.setAdapter(c21323tT1);
        if (this.q1.p(EnumC11273cj7.a)) {
            this.m1 = 1;
        }
        this.n1.setCurrentItem(this.m1, false);
        this.n1.setOffscreenPageLimit(5);
        this.n1.k(new b());
        md();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 xc(IO1 io1, InterfaceC20625sK4.b bVar) {
        if (!(io1 instanceof IO1.b) || !(((IO1.b) io1).a() instanceof InterfaceC18834pK4.a)) {
            return null;
        }
        t9(this.l1.f(bVar.e()));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb() {
        if (this.w1 != null) {
            this.w1.animate().translationY(this.w1.getHeight() + ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r0.getLayoutParams())).bottomMargin).setDuration(200L).start();
        }
        if (this.x1 != null) {
            this.x1.animate().translationY(this.x1.getHeight() + ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r0.getLayoutParams())).bottomMargin).setDuration(200L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C19938rB7 yc(final IO1 io1) {
        this.i1.U1(io1);
        ((JO1) this.i1.x1().getValue()).f((EnumC11273cj7) this.i1.w1().getValue(), new UA2() { // from class: ir.nasim.BR1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return this.a.xc(io1, (InterfaceC20625sK4.b) obj);
            }
        });
        return null;
    }

    private void yd() {
        this.i1.y1().j(p6(), new QG4() { // from class: ir.nasim.ZQ1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Uc((Integer) obj);
            }
        });
        this.i1.u1().j(p6(), new QG4() { // from class: ir.nasim.aR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Vc((Integer) obj);
            }
        });
        this.i1.A1().j(p6(), new QG4() { // from class: ir.nasim.bR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Wc((EnumC14280hf2) obj);
            }
        });
    }

    private void zb() {
        if (this.w1 == null) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) o6().findViewById(BC5.fragment_dialogs_container_contacts);
            this.w1 = floatingActionButton;
            floatingActionButton.setImageTintList(ColorStateList.valueOf(C5495Jo7.a.q0()));
        }
        if (this.x1 == null) {
            this.x1 = (MaterialButton) o6().findViewById(BC5.fragment_dialogs_container_contacts_card);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.w1.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, 0, AbstractC7426Rr.z(22.0f));
        this.w1.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.x1.getLayoutParams();
        marginLayoutParams2.setMargins(0, 0, 0, C5161Id6.e(22.0f));
        this.x1.setLayoutParams(marginLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zc(View view) {
        C18987pb3.i1(AbstractC5969Lp4.d().o2().S().I2(), A5());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.InterfaceC14088hK4
    public void H2() {
        try {
            if (Yb()) {
                Fragment fragmentEb = Eb(this.n1.getCurrentItem());
                if (qb(fragmentEb)) {
                    ((e) fragmentEb).C0();
                }
            }
        } catch (Exception e2) {
            C19406qI3.d("DialogsContainerFragment", e2);
        }
    }

    @Override // ir.nasim.InterfaceC17721nS1
    public void K4() {
        rd();
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        this.q1 = new C17130mS1(this);
        this.j1 = (C6243Mu0) new androidx.lifecycle.G(this).b(C6243Mu0.class);
        this.i1 = (C20085rS1) new androidx.lifecycle.G(Q7()).b(C20085rS1.class);
        this.basePresenter = this.q1;
        vb();
        C15225jD4.b().a(this, C15225jD4.z);
        C15225jD4.b().a(this, C15225jD4.D);
    }

    public void Mb() {
        this.C1.getMenu().setGroupVisible(BC5.menu_dialog_action_mode, false);
        this.C1.getMenu().setGroupVisible(BC5.menu_dialog_normal, true);
        this.C1.f0(new View.OnClickListener() { // from class: ir.nasim.AR1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.sc(view);
            }
        });
        TextView textView = this.P1;
        if (textView != null && textView.getVisibility() == 0) {
            this.P1.setVisibility(8);
        }
        this.i1.C2(true, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.N1 = C20477s46.a.a();
        this.O1 = VM3.d().c();
        boolean z = false;
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_dialogs_container, viewGroup, false);
        if (E5() != null && E5().getBoolean("is_event_bar_enabled_argument", false)) {
            z = true;
        }
        Ub(viewInflate);
        Vb(viewInflate);
        Ob(viewInflate);
        Pb(viewInflate);
        xb();
        wb();
        ub();
        Sb(viewInflate);
        Qb(viewInflate, z);
        ed();
        if (C8386Vt0.D5()) {
            Rb(viewInflate);
        } else {
            Tb(viewInflate);
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this.Y1 = null;
        Q7().B0().v1(this.Z1);
        C15225jD4.b().e(this, C15225jD4.z);
        C15225jD4.b().e(this, C15225jD4.D);
        AudioPlayBar audioPlayBar = this.t1;
        if (audioPlayBar != null) {
            audioPlayBar.E();
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        com.google.android.material.tabs.d dVar = this.U1;
        if (dVar != null) {
            dVar.b();
        }
        C21323tT1 c21323tT1 = this.p1;
        if (c21323tT1 != null) {
            c21323tT1.T();
            this.n1.setAdapter(null);
            this.p1 = null;
        }
        TabLayout.d dVar2 = this.b2;
        if (dVar2 != null) {
            this.o1.G(dVar2);
            this.b2 = null;
        }
        C8();
        C17130mS1 c17130mS1 = this.q1;
        if (c17130mS1 != null) {
            c17130mS1.A();
            this.q1 = null;
        }
        this.y1 = null;
        super.T6();
    }

    @Override // androidx.fragment.app.Fragment
    public void W6(boolean z) {
        C17468n10 c17468n10;
        super.W6(z);
        if (!z || (c17468n10 = this.Y1) == null) {
            return;
        }
        c17468n10.f();
        this.Y1 = null;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        if (!(this.i1.Q1().f() instanceof AbstractC4820Gr7.a)) {
            return false;
        }
        this.i1.E2(AbstractC4820Gr7.c.a);
        this.i1.n2();
        return true;
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int i, Object... objArr) {
        if (i == C15225jD4.z) {
            gd();
        }
    }

    @Override // ir.nasim.features.audioplayer.ui.AudioPlayBar.a
    public void g2(VL vl, boolean z) {
        if ((vl instanceof QZ7) || z) {
            Fb(vl.d());
        } else if (vl instanceof C8552Wl4) {
            PlayListBottomSheet playListBottomSheet = new PlayListBottomSheet(vl.d().e(), vl.d().d());
            playListBottomSheet.A9(this);
            playListBottomSheet.K8(Q7().B0(), playListBottomSheet.j6());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int i, String[] strArr, int[] iArr) {
        super.g7(i, strArr, iArr);
        if (i != 1088 || iArr.length == 0) {
            return;
        }
        if (iArr[0] == 0) {
            AbstractC5969Lp4.d().f1();
            C7077Qe1.a(S7().getContentResolver());
            AI7.b(true);
        } else if (!m8("android.permission.READ_CONTACTS")) {
            C5505Jq.M("android.permission.READ_CONTACTS", false);
        } else if (iArr[0] == -1) {
            AI7.b(true);
        }
    }

    @Override // ir.nasim.InterfaceC17721nS1
    public void h2(boolean z) {
        this.d2 = z;
        if (!z) {
            this.f2 = true;
        }
        rd();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        this.q1.q();
        if (RootActivity.a4()) {
            this.p1.U(this.q1.o());
            RootActivity.h5(false);
            ub();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void k7() {
        super.k7();
        GY gy = this.Q1;
        if (gy != null) {
            gy.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        super.l7(view, bundle);
        this.i1.Q1().j(Q7(), new QG4() { // from class: ir.nasim.XQ1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Jc((AbstractC4820Gr7) obj);
            }
        });
        this.i1.I1().j(p6(), new QG4() { // from class: ir.nasim.iR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Kc((EnumC20553sC4) obj);
            }
        });
        final MenuItem menuItemFindItem = this.C1.getMenu().findItem(BC5.dialog_action_mute);
        this.i1.R1().j(p6(), new QG4() { // from class: ir.nasim.tR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Lc(menuItemFindItem, (EnumC18517on4) obj);
            }
        });
        final MenuItem menuItemFindItem2 = this.C1.getMenu().findItem(BC5.dialog_action_pin);
        this.i1.S1().j(p6(), new QG4() { // from class: ir.nasim.ER1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Mc(menuItemFindItem2, (EnumC7306Rd5) obj);
            }
        });
        this.i1.N1().j(p6(), new QG4() { // from class: ir.nasim.PR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Nc((Integer) obj);
            }
        });
        yd();
        nd();
        if (C8386Vt0.D5()) {
            return;
        }
        this.i1.v1().j(p6(), new QG4() { // from class: ir.nasim.TR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Oc((AbstractC16345l7) obj);
            }
        });
        this.i1.J1().j(p6(), new QG4() { // from class: ir.nasim.UR1
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                this.a.Rc((AbstractC20016rK4) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ub();
        ViewPager2 viewPager2 = this.n1;
        if (viewPager2 != null) {
            int currentItem = viewPager2.getCurrentItem();
            this.n1.setCurrentItem(currentItem != 0 ? Math.max(this.n1.getCurrentItem() - 1, 0) : 1, false);
            this.n1.setCurrentItem(currentItem, false);
        }
    }

    public void pd(int i) {
        this.n1.setCurrentItem(i, false);
    }

    public void tb(AbstractC13089g.b bVar) {
        this.u1 = bVar;
        int i = d.b[bVar.ordinal()];
        if (i == 1) {
            if (this.i1.Q1().f() instanceof AbstractC4820Gr7.a) {
                this.i1.E2(AbstractC4820Gr7.c.a);
            }
            xd(h6(AbstractC12217eE5.share_select_chat));
        } else if (i != 2) {
            rd();
        } else {
            xd(h6(AbstractC12217eE5.forward_select_chat));
        }
    }

    @Override // ir.nasim.InterfaceC17721nS1
    public void u2() {
        rd();
    }

    public void ub() {
        if (this.o1 != null) {
            if (this.r1 == null) {
                this.r1 = new Handler();
            }
            this.r1.removeCallbacks(this.c2);
            this.r1.postDelayed(this.c2, 20L);
        }
    }

    public void xd(CharSequence charSequence) {
        this.i1.z2(EnumC20553sC4.a);
        if (this.I1 != null) {
            if (charSequence == null || !(charSequence.toString().equals(h6(AbstractC12217eE5.dialogs_connection_state_connecting)) || charSequence.toString().equals(h6(AbstractC12217eE5.dialogs_connection_state_updating)) || charSequence.toString().equals(h6(AbstractC12217eE5.dialogs_connection_state_wait_for_network)))) {
                this.L1.setImageDrawable(null);
            } else {
                this.L1.setImageDrawable(new C4658Fz7());
            }
            this.I1.setText(charSequence);
        }
    }

    @Override // ir.nasim.InterfaceC17721nS1
    public void y2(Integer num, EnumC11273cj7 enumC11273cj7) {
        DialogTabView dialogTabView = (DialogTabView) this.X1.get(enumC11273cj7);
        if (dialogTabView != null) {
            if (num == null || num.intValue() == 0) {
                dialogTabView.c();
            } else {
                dialogTabView.setCounter(num.intValue());
            }
        }
    }

    public void zd(EnumC11273cj7 enumC11273cj7) {
        int i = d.a[enumC11273cj7.ordinal()];
        if (i == 1) {
            Ib();
        } else {
            if (i != 2) {
                return;
            }
            Jb();
        }
    }

    class c implements TabLayout.d {
        c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            YR1.this.i1.x2((EnumC11273cj7) gVar.j());
            if (!C8386Vt0.D5()) {
                YR1.this.i1.W1(new InterfaceC19425qK4.a((EnumC11273cj7) gVar.j()));
            }
            TextView textView = (TextView) gVar.e().findViewById(BC5.tv_dialog_tab_title);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setTextColor(c5495Jo7.y2());
            YR1.this.wd(textView, c5495Jo7.y2());
            if (YR1.this.rb(gVar.h())) {
                if (YR1.this.s1) {
                    YR1.this.z1.setVisibility(0);
                    YR1.this.A1.setVisibility(8);
                }
            } else if (YR1.this.sb()) {
                YR1.this.z1.setVisibility(8);
                YR1.this.A1.setVisibility(0);
            } else {
                YR1.this.z1.setVisibility(8);
                YR1.this.A1.setVisibility(8);
            }
            if (gVar.j() == EnumC11273cj7.a) {
                YR1.this.i1.V1();
            }
            YR1.this.od();
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            TextView textView = (TextView) gVar.e().findViewById(BC5.tv_dialog_tab_title);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setTextColor(c5495Jo7.z2());
            YR1.this.wd(textView, c5495Jo7.z2());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }
}
