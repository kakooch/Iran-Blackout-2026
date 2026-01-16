package ir.nasim.features.smiles.panel.sticker;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14828iY7;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC20790sc5;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C14819iX7;
import ir.nasim.C19223pz2;
import ir.nasim.C19938rB7;
import ir.nasim.C23698xM6;
import ir.nasim.C25226zw5;
import ir.nasim.C6011Lu2;
import ir.nasim.CF6;
import ir.nasim.ED1;
import ir.nasim.EF6;
import ir.nasim.EM2;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC11627dK4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.JF5;
import ir.nasim.P91;
import ir.nasim.QG4;
import ir.nasim.QK5;
import ir.nasim.RF6;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.UA2;
import ir.nasim.W25;
import ir.nasim.features.smiles.panel.sticker.StickerPagerFragment;
import ir.nasim.features.smiles.panel.sticker.k;
import ir.nasim.features.smiles.widget.StickerRecyclerView;
import ir.nasim.features.smiles.widget.TabLayoutRecycler;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 }2\u00020\u00012\u00020\u0002:\u0002~\u007fB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0004J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0004\b%\u0010\u0004J\u0017\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0007H\u0002¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0007H\u0002¢\u0006\u0004\b.\u0010\u0004J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101J!\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000202H\u0002¢\u0006\u0004\b5\u00106J-\u0010;\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u0002022\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u000208H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0007H\u0002¢\u0006\u0004\b=\u0010\u0004J\u0017\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b@\u0010AR\u001b\u0010F\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001b\u0010P\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010C\u001a\u0004\bN\u0010OR\u001b\u0010T\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010C\u001a\u0004\bR\u0010SR\u001b\u0010Z\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001b\u0010_\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010C\u001a\u0004\b]\u0010^R\u001b\u0010d\u001a\u00020`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010C\u001a\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010C\u001a\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010t\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010w\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010vR\u0016\u0010|\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{¨\u0006\u0080\u0001"}, d2 = {"Lir/nasim/features/smiles/panel/sticker/StickerPagerFragment;", "Landroidx/fragment/app/Fragment;", "Lir/nasim/dK4;", "<init>", "()V", "Lir/nasim/CF6;", "SmilesKeyboardListener", "Lir/nasim/rB7;", "i9", "(Lir/nasim/CF6;)V", "Lir/nasim/EF6;", "smilesPanelListener", "j9", "(Lir/nasim/EF6;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/xM6;", "sticker", "", "replyRid", "P3", "(Lir/nasim/xM6;J)V", "h7", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "R8", "", ParameterNames.TEXT, "m9", "(Ljava/lang/String;)V", "Lcom/google/android/material/button/MaterialButton;", "p9", "()Lcom/google/android/material/button/MaterialButton;", "t9", "l9", "Lir/nasim/features/smiles/widget/StickerRecyclerView;", "n9", "()Lir/nasim/features/smiles/widget/StickerRecyclerView;", "", "targetPos", "offset", "h9", "(II)Lir/nasim/rB7;", "position", "", "delayedForItemAnimator", "forceUpdateTabIndex", "y9", "(IZZ)V", "a9", "Lir/nasim/features/smiles/panel/sticker/StickerPagerFragment$b;", "newState", "k9", "(Lir/nasim/features/smiles/panel/sticker/StickerPagerFragment$b;)V", "W0", "Lir/nasim/Yu3;", "Y8", "()Z", "isCommentChat", "X0", "Lir/nasim/CF6;", "smilesKeyboardListener", "Y0", "Lir/nasim/EF6;", "Lir/nasim/W25;", "Z0", "U8", "()Lir/nasim/W25;", "peerType", "a1", "T8", "()I", "peerId", "Lir/nasim/pz2;", "b1", "Lir/nasim/bW7;", "S8", "()Lir/nasim/pz2;", "binding", "Lir/nasim/features/smiles/panel/sticker/f;", "c1", "W8", "()Lir/nasim/features/smiles/panel/sticker/f;", "stickerViewModel", "Lir/nasim/features/smiles/panel/sticker/m;", "d1", "V8", "()Lir/nasim/features/smiles/panel/sticker/m;", "stickerTabAdapter", "Lir/nasim/features/smiles/panel/sticker/j;", "e1", "X8", "()Lir/nasim/features/smiles/panel/sticker/j;", "stickersAdapter", "Lir/nasim/QK5;", "f1", "Lir/nasim/QK5;", "stickerScrollHelper", "Landroidx/recyclerview/widget/GridLayoutManager;", "g1", "Landroidx/recyclerview/widget/GridLayoutManager;", "stickerLayoutManager", "h1", "Lir/nasim/features/smiles/panel/sticker/StickerPagerFragment$b;", "viewState", "i1", TokenNames.I, "mSpanCount", "j1", "firstVisiblePackId", "k1", "Z", "hasStickersRecyclerViewBeenLaidOut", "l1", "a", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class StickerPagerFragment extends Fragment implements InterfaceC11627dK4 {

    /* renamed from: X0, reason: from kotlin metadata */
    private CF6 smilesKeyboardListener;

    /* renamed from: Y0, reason: from kotlin metadata */
    private EF6 smilesPanelListener;

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 stickerViewModel;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 stickerTabAdapter;

    /* renamed from: e1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 stickersAdapter;

    /* renamed from: f1, reason: from kotlin metadata */
    private QK5 stickerScrollHelper;

    /* renamed from: g1, reason: from kotlin metadata */
    private GridLayoutManager stickerLayoutManager;

    /* renamed from: h1, reason: from kotlin metadata */
    private b viewState;

    /* renamed from: i1, reason: from kotlin metadata */
    private int mSpanCount;

    /* renamed from: j1, reason: from kotlin metadata */
    private int firstVisiblePackId;

    /* renamed from: k1, reason: from kotlin metadata */
    private boolean hasStickersRecyclerViewBeenLaidOut;
    static final /* synthetic */ InterfaceC5239Im3[] m1 = {AbstractC10882cM5.i(new C25226zw5(StickerPagerFragment.class, "binding", "getBinding()Lir/nasim/databinding/FragmentSmilesStickerBinding;", 0))};

    /* renamed from: l1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int n1 = 8;

    /* renamed from: W0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 isCommentChat = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ZM6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Boolean.valueOf(StickerPagerFragment.Z8(this.a));
        }
    });

    /* renamed from: Z0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 peerType = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.fN6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return StickerPagerFragment.g9(this.a);
        }
    });

    /* renamed from: a1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 peerId = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.gN6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Integer.valueOf(StickerPagerFragment.f9(this.a));
        }
    });

    /* renamed from: b1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new m(), AbstractC20046rN7.c());

    /* renamed from: ir.nasim.features.smiles.panel.sticker.StickerPagerFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final StickerPagerFragment a(W25 w25, int i, boolean z, boolean z2) {
            AbstractC13042fc3.i(w25, "peerType");
            StickerPagerFragment stickerPagerFragment = new StickerPagerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_PEER_TYPE", w25.ordinal());
            bundle.putInt("ARG_PEER_ID", i);
            bundle.putBoolean("ARG_is_comment", z);
            bundle.putBoolean("ARG_force_night_mode", z2);
            stickerPagerFragment.a8(bundle);
            return stickerPagerFragment;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class b {
        public static final b a = new b("STICKERS", 0);
        public static final b b = new b("SHORTCUT", 1);
        public static final b c = new b("NO_PERMISSION", 2);
        private static final /* synthetic */ b[] d;
        private static final /* synthetic */ F92 e;

        static {
            b[] bVarArrA = a();
            d = bVarArrA;
            e = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b, c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ StickerPagerFragment d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(StickerPagerFragment stickerPagerFragment, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = stickerPagerFragment;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((EM2) this.c) == EM2.a) {
                    this.d.k9(b.a);
                } else {
                    StickerPagerFragment stickerPagerFragment = this.d;
                    String strH6 = stickerPagerFragment.h6(stickerPagerFragment.Y8() ? AbstractC12217eE5.no_stickers_permissoin_for_member_comment : AbstractC12217eE5.no_stickers_permissoin_for_member);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    stickerPagerFragment.m9(strH6);
                    this.d.k9(b.c);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EM2 em2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(em2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return StickerPagerFragment.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6Q1 = StickerPagerFragment.this.W8().q1();
                a aVar = new a(StickerPagerFragment.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6Q1, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            StickerPagerFragment.this.hasStickersRecyclerViewBeenLaidOut = true;
            StickerPagerFragment.z9(StickerPagerFragment.this, 0, false, true, 3, null);
        }
    }

    public static final class f implements View.OnLayoutChangeListener {
        public f() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            StickerPagerFragment.this.mSpanCount = RF6.a.b(view.getMeasuredWidth() - (view.getPaddingLeft() + view.getPaddingRight()));
            GridLayoutManager gridLayoutManager = StickerPagerFragment.this.stickerLayoutManager;
            if (gridLayoutManager != null) {
                gridLayoutManager.j3(StickerPagerFragment.this.mSpanCount);
            }
        }
    }

    static final class g implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        g(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    public static final class h implements View.OnLayoutChangeListener {
        public h() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            AbstractC13042fc3.g(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) view;
            StickerPagerFragment.this.mSpanCount = RF6.a.b(recyclerView.getMeasuredWidth() - (recyclerView.getPaddingLeft() + recyclerView.getPaddingRight()));
            StickerPagerFragment stickerPagerFragment = StickerPagerFragment.this;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(stickerPagerFragment.G5(), StickerPagerFragment.this.mSpanCount);
            gridLayoutManager.k3(StickerPagerFragment.this.new i());
            recyclerView.setLayoutManager(gridLayoutManager);
            StickerPagerFragment.this.stickerScrollHelper = new QK5(recyclerView, gridLayoutManager);
            stickerPagerFragment.stickerLayoutManager = gridLayoutManager;
        }
    }

    public static final class i extends GridLayoutManager.b {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ir.nasim.features.smiles.panel.sticker.i.values().length];
                try {
                    iArr[ir.nasim.features.smiles.panel.sticker.i.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ir.nasim.features.smiles.panel.sticker.i.d.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ir.nasim.features.smiles.panel.sticker.i.e.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        i() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int f(int i) {
            int i2 = a.a[ir.nasim.features.smiles.panel.sticker.i.b.a(StickerPagerFragment.this.X8().getItemViewType(i)).ordinal()];
            if (i2 == 1) {
                return StickerPagerFragment.this.mSpanCount;
            }
            if (i2 == 2 || i2 == 3) {
                return 1;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class j extends RecyclerView.t {
        j() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
        }
    }

    public static final class k implements RecyclerView.s {
        private int a = -1;
        private int b;
        final /* synthetic */ StickerRecyclerView c;

        k(StickerRecyclerView stickerRecyclerView) {
            this.c = stickerRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AbstractC13042fc3.i(recyclerView, "rv");
            AbstractC13042fc3.i(motionEvent, "e");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            AbstractC13042fc3.i(recyclerView, "rv");
            AbstractC13042fc3.i(motionEvent, "e");
            View viewFindChildViewUnder = this.c.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (viewFindChildViewUnder == null) {
                return false;
            }
            this.b = this.c.getChildAdapterPosition(viewFindChildViewUnder);
            if (motionEvent.getAction() == 0) {
                recyclerView.stopScroll();
                if (this.b < 0) {
                    this.c.b1();
                } else {
                    RecyclerView.C childViewHolder = this.c.getChildViewHolder(viewFindChildViewUnder);
                    k.b bVar = childViewHolder instanceof k.b ? (k.b) childViewHolder : null;
                    if (bVar == null) {
                        return false;
                    }
                    Dialog stickerDialogPreview = this.c.getStickerDialogPreview();
                    if (stickerDialogPreview == null || !stickerDialogPreview.isShowing() || this.a != this.b) {
                        this.c.f1(new StickerRecyclerView.a(bVar.M0(), bVar.N0()));
                        this.a = this.b;
                    }
                }
            }
            if (this.a != this.b || motionEvent.getAction() == 1 || motionEvent.getAction() == 9 || motionEvent.getAction() == 3 || motionEvent.getAction() == 7 || motionEvent.getAction() == 8) {
                this.c.b1();
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z) {
        }
    }

    static final class l implements InterfaceC15796kB2 {
        l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(StickerPagerFragment stickerPagerFragment, Dialog dialog) {
            AbstractC13042fc3.i(stickerPagerFragment, "this$0");
            AbstractC13042fc3.i(dialog, "$it");
            stickerPagerFragment.W8().g1();
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            P91 p91 = P91.a;
            InterfaceC14603iB2 interfaceC14603iB2A = p91.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = p91.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(-776652292);
            boolean zD = interfaceC22053ub1.D(StickerPagerFragment.this) | interfaceC22053ub1.D(dialog);
            final StickerPagerFragment stickerPagerFragment = StickerPagerFragment.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.smiles.panel.sticker.b
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return StickerPagerFragment.l.d(stickerPagerFragment, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.smiles_clear_recent_sticker_clean_btn;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-776642158);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.smiles.panel.sticker.c
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return StickerPagerFragment.l.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, AbstractC12217eE5.smiles_clear_recent_sticker_cancel_btn, null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class m extends AbstractC8614Ws3 implements UA2 {
        public m() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C19223pz2.a(fragment.V7());
        }
    }

    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class p extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    public static final class r extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public StickerPagerFragment() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new o(new n(this)));
        this.stickerViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(ir.nasim.features.smiles.panel.sticker.f.class), new p(interfaceC9173Yu3B), new q(null, interfaceC9173Yu3B), new r(this, interfaceC9173Yu3B));
        this.stickerTabAdapter = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.hN6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return StickerPagerFragment.u9(this.a);
            }
        });
        this.stickersAdapter = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.iN6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return StickerPagerFragment.w9(this.a);
            }
        });
        this.viewState = b.a;
        this.mSpanCount = 5;
        this.firstVisiblePackId = RecyclerView.UNDEFINED_DURATION;
    }

    private final void R8() {
        W8().d1(U8(), T8());
        AbstractC16751lo1.c(this, j.b.STARTED, new d(null));
    }

    private final C19223pz2 S8() {
        Object objA = this.binding.a(this, m1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C19223pz2) objA;
    }

    private final int T8() {
        return ((Number) this.peerId.getValue()).intValue();
    }

    private final W25 U8() {
        return (W25) this.peerType.getValue();
    }

    private final ir.nasim.features.smiles.panel.sticker.m V8() {
        return (ir.nasim.features.smiles.panel.sticker.m) this.stickerTabAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ir.nasim.features.smiles.panel.sticker.f W8() {
        return (ir.nasim.features.smiles.panel.sticker.f) this.stickerViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ir.nasim.features.smiles.panel.sticker.j X8() {
        return (ir.nasim.features.smiles.panel.sticker.j) this.stickersAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Y8() {
        return ((Boolean) this.isCommentChat.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z8(StickerPagerFragment stickerPagerFragment) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        return stickerPagerFragment.R7().getBoolean("ARG_is_comment", false);
    }

    private final void a9() {
        W8().m1().j(p6(), new g(new UA2() { // from class: ir.nasim.mN6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return StickerPagerFragment.b9(this.a, (List) obj);
            }
        }));
        W8().o1().j(p6(), new g(new UA2() { // from class: ir.nasim.nN6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return StickerPagerFragment.c9(this.a, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b9(StickerPagerFragment stickerPagerFragment, List list) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        stickerPagerFragment.X8().C(list);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c9(final StickerPagerFragment stickerPagerFragment, List list) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        stickerPagerFragment.V8().D(list, new Runnable() { // from class: ir.nasim.bN6
            @Override // java.lang.Runnable
            public final void run() {
                StickerPagerFragment.d9(this.a);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d9(StickerPagerFragment stickerPagerFragment) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        if (stickerPagerFragment.hasStickersRecyclerViewBeenLaidOut) {
            z9(stickerPagerFragment, 0, true, true, 1, null);
            return;
        }
        StickerRecyclerView stickerRecyclerView = stickerPagerFragment.S8().g;
        AbstractC13042fc3.h(stickerRecyclerView, "rcSmilesSticker");
        stickerRecyclerView.addOnLayoutChangeListener(stickerPagerFragment.new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e9(StickerPagerFragment stickerPagerFragment) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        StickerRecyclerView stickerRecyclerView = stickerPagerFragment.S8().g;
        AbstractC13042fc3.h(stickerRecyclerView, "rcSmilesSticker");
        if (!stickerRecyclerView.isLaidOut() || stickerRecyclerView.isLayoutRequested()) {
            stickerRecyclerView.addOnLayoutChangeListener(stickerPagerFragment.new f());
            return;
        }
        stickerPagerFragment.mSpanCount = RF6.a.b(stickerRecyclerView.getMeasuredWidth() - (stickerRecyclerView.getPaddingLeft() + stickerRecyclerView.getPaddingRight()));
        GridLayoutManager gridLayoutManager = stickerPagerFragment.stickerLayoutManager;
        if (gridLayoutManager != null) {
            gridLayoutManager.j3(stickerPagerFragment.mSpanCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f9(StickerPagerFragment stickerPagerFragment) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        return stickerPagerFragment.R7().getInt("ARG_PEER_ID");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W25 g9(StickerPagerFragment stickerPagerFragment) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        return (W25) W25.j().get(stickerPagerFragment.R7().getInt("ARG_PEER_TYPE"));
    }

    private final C19938rB7 h9(int targetPos, int offset) {
        GridLayoutManager gridLayoutManager = this.stickerLayoutManager;
        if (gridLayoutManager == null) {
            return null;
        }
        gridLayoutManager.E2(targetPos, offset);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k9(b newState) {
        C19223pz2 c19223pz2S8 = S8();
        if (newState == this.viewState) {
            return;
        }
        int i2 = c.a[newState.ordinal()];
        if (i2 == 1) {
            AbstractC14828iY7.l(c19223pz2S8.g);
            TabLayoutRecycler.z0(c19223pz2S8.h, false, 1, null);
            AbstractC14828iY7.l(c19223pz2S8.f);
            c19223pz2S8.c.setImageTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(S7(), TA5.color8)));
            AbstractC14828iY7.c(c19223pz2S8.d);
            AbstractC14828iY7.c(c19223pz2S8.i);
        } else if (i2 == 2) {
            AbstractC14828iY7.l(c19223pz2S8.d);
            AbstractC14828iY7.l(c19223pz2S8.f);
            TabLayoutRecycler.r0(c19223pz2S8.h, false, 1, null);
            c19223pz2S8.c.setImageTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(S7(), TA5.secondary_2)));
            this.firstVisiblePackId = RecyclerView.UNDEFINED_DURATION;
            AbstractC14828iY7.c(c19223pz2S8.g);
            AbstractC14828iY7.c(c19223pz2S8.i);
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC14828iY7.l(c19223pz2S8.i);
            c19223pz2S8.c.setImageTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(S7(), TA5.color8)));
            AbstractC14828iY7.c(c19223pz2S8.g);
            AbstractC14828iY7.c(c19223pz2S8.f);
            AbstractC14828iY7.c(c19223pz2S8.d);
        }
        this.viewState = newState;
    }

    private final void l9() {
        StickerRecyclerView stickerRecyclerView = S8().g;
        AbstractC13042fc3.h(stickerRecyclerView, "rcSmilesSticker");
        stickerRecyclerView.addOnLayoutChangeListener(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m9(String text) {
        C19223pz2 c19223pz2S8 = S8();
        c19223pz2S8.i.setText(text);
        c19223pz2S8.i.setTypeface(C6011Lu2.i());
    }

    private final StickerRecyclerView n9() {
        StickerRecyclerView stickerRecyclerView = S8().g;
        androidx.recyclerview.widget.h hVar = new androidx.recyclerview.widget.h();
        hVar.w(220L);
        hVar.z(220L);
        hVar.x(160L);
        stickerRecyclerView.setItemAnimator(hVar);
        stickerRecyclerView.addOnScrollListener(new j());
        stickerRecyclerView.addOnItemTouchListener(new k(stickerRecyclerView));
        stickerRecyclerView.setOnClearRecentListener(new SA2() { // from class: ir.nasim.aN6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return StickerPagerFragment.o9(this.a);
            }
        });
        l9();
        stickerRecyclerView.setAdapter(X8());
        AbstractC13042fc3.h(stickerRecyclerView, "apply(...)");
        return stickerRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o9(StickerPagerFragment stickerPagerFragment) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        Context contextS7 = stickerPagerFragment.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = stickerPagerFragment.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(622324204, true, stickerPagerFragment.new l()), 4, null).show();
        return C19938rB7.a;
    }

    private final MaterialButton p9() {
        C19223pz2 c19223pz2S8 = S8();
        AppCompatImageView appCompatImageView = c19223pz2S8.c;
        int iC = AbstractC8943Xx1.c(5);
        AbstractC13042fc3.f(appCompatImageView);
        if (appCompatImageView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            int iF = RF6.a.f() + (iC * 2);
            layoutParams2.width = iF;
            layoutParams2.height = iF;
        }
        appCompatImageView.setPadding(iC, iC, iC, iC);
        appCompatImageView.setBackground(AbstractC4310Eo7.h(5.0f));
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kN6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerPagerFragment.q9(this.a, view);
            }
        });
        c19223pz2S8.b.setTypeface(C6011Lu2.i());
        MaterialButton materialButton = c19223pz2S8.b;
        materialButton.setLayoutDirection(JF5.g() ? 1 : 0);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lN6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerPagerFragment.r9(this.a, view);
            }
        });
        AbstractC13042fc3.h(materialButton, "with(...)");
        return materialButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q9(StickerPagerFragment stickerPagerFragment, View view) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        stickerPagerFragment.k9(b.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r9(final StickerPagerFragment stickerPagerFragment, View view) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        stickerPagerFragment.W8().t1(new SA2() { // from class: ir.nasim.dN6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return StickerPagerFragment.s9(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s9(StickerPagerFragment stickerPagerFragment) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        Toast.makeText(stickerPagerFragment.S7(), AbstractC12217eE5.toast_chat_not_found, 0).show();
        return C19938rB7.a;
    }

    private final void t9() {
        TabLayoutRecycler tabLayoutRecycler = S8().h;
        tabLayoutRecycler.setIndicatorWidth(ir.nasim.features.smiles.panel.sticker.e.v.b());
        tabLayoutRecycler.setAdapter(V8());
        ViewGroup.LayoutParams layoutParams = S8().e.getLayoutParams();
        CoordinatorLayout.e eVar = layoutParams instanceof CoordinatorLayout.e ? (CoordinatorLayout.e) layoutParams : null;
        if (eVar != null) {
            eVar.o(new CoordinatorLayout.Behavior<View>() { // from class: ir.nasim.features.smiles.panel.sticker.StickerPagerFragment$setupTabLayout$2$1$1
                @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
                public boolean A(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes, int type) {
                    AbstractC13042fc3.i(coordinatorLayout, "coordinatorLayout");
                    AbstractC13042fc3.i(child, "child");
                    AbstractC13042fc3.i(directTargetChild, "directTargetChild");
                    AbstractC13042fc3.i(target, "target");
                    return nestedScrollAxes == 2;
                }

                @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
                public void t(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
                    AbstractC13042fc3.i(coordinatorLayout, "coordinatorLayout");
                    AbstractC13042fc3.i(child, "child");
                    AbstractC13042fc3.i(target, "target");
                    AbstractC13042fc3.i(consumed, "consumed");
                    if (dyConsumed != 0) {
                        StickerPagerFragment.z9(this.a, 0, false, false, 7, null);
                    }
                    super.t(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.smiles.panel.sticker.m u9(final StickerPagerFragment stickerPagerFragment) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        return new ir.nasim.features.smiles.panel.sticker.m(new InterfaceC14603iB2() { // from class: ir.nasim.cN6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return StickerPagerFragment.v9(this.a, (ir.nasim.features.smiles.panel.sticker.l) obj, ((Integer) obj2).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v9(StickerPagerFragment stickerPagerFragment, ir.nasim.features.smiles.panel.sticker.l lVar, int i2) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        AbstractC13042fc3.i(lVar, "sticker");
        stickerPagerFragment.k9(b.a);
        TabLayoutRecycler.w0(stickerPagerFragment.S8().h, i2, false, 2, null);
        stickerPagerFragment.S8().g.stopScroll();
        QK5 qk5 = stickerPagerFragment.stickerScrollHelper;
        if (qk5 != null) {
            qk5.h();
        }
        stickerPagerFragment.h9(stickerPagerFragment.W8().p1(lVar.a()), AbstractC7426Rr.a.f(-1.0f));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.smiles.panel.sticker.j w9(final StickerPagerFragment stickerPagerFragment) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        return new ir.nasim.features.smiles.panel.sticker.j(new InterfaceC14603iB2() { // from class: ir.nasim.eN6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return StickerPagerFragment.x9(this.a, (C23698xM6) obj, ((Boolean) obj2).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x9(StickerPagerFragment stickerPagerFragment, C23698xM6 c23698xM6, boolean z) {
        AbstractC13042fc3.i(stickerPagerFragment, "this$0");
        AbstractC13042fc3.i(c23698xM6, "sticker");
        if (!z) {
            stickerPagerFragment.W8().c1(c23698xM6);
        }
        stickerPagerFragment.P3(c23698xM6, 0L);
        return C19938rB7.a;
    }

    private final void y9(int position, boolean delayedForItemAnimator, boolean forceUpdateTabIndex) {
        if (position == -1) {
            return;
        }
        RecyclerView.C cFindViewHolderForAdapterPosition = S8().g.findViewHolderForAdapterPosition(position);
        ir.nasim.features.smiles.panel.sticker.k kVar = cFindViewHolderForAdapterPosition instanceof ir.nasim.features.smiles.panel.sticker.k ? (ir.nasim.features.smiles.panel.sticker.k) cFindViewHolderForAdapterPosition : null;
        if (kVar != null) {
            int iD0 = kVar.D0();
            if (this.firstVisiblePackId != iD0 || forceUpdateTabIndex) {
                this.firstVisiblePackId = iD0;
                int iS1 = W8().s1(iD0);
                if (iS1 <= -1) {
                    iS1 = 0;
                }
                S8().h.v0(iS1, delayedForItemAnimator);
            }
        }
    }

    static /* synthetic */ void z9(StickerPagerFragment stickerPagerFragment, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            GridLayoutManager gridLayoutManager = stickerPagerFragment.stickerLayoutManager;
            i2 = gridLayoutManager != null ? gridLayoutManager.d2() : 0;
        }
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        stickerPagerFragment.y9(i2, z, z2);
    }

    @Override // ir.nasim.InterfaceC11627dK4
    public void P3(C23698xM6 sticker, long replyRid) {
        AbstractC13042fc3.i(sticker, "sticker");
        CF6 cf6 = this.smilesKeyboardListener;
        if (cf6 != null) {
            cf6.b(sticker, replyRid);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        if (R7().getBoolean("ARG_force_night_mode", false)) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            inflater = LayoutInflater.from(AbstractC20790sc5.b(contextS7, 0, 1, null));
        }
        CoordinatorLayout root = C19223pz2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void h7() {
        EF6 ef6 = this.smilesPanelListener;
        if (ef6 != null) {
            ef6.a(false);
        }
        super.h7();
    }

    public final void i9(CF6 SmilesKeyboardListener) {
        this.smilesKeyboardListener = SmilesKeyboardListener;
    }

    public final void j9(EF6 smilesPanelListener) {
        this.smilesPanelListener = smilesPanelListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        k9(b.a);
        t9();
        n9();
        a9();
        R8();
        p9();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        S8().g.postDelayed(new Runnable() { // from class: ir.nasim.jN6
            @Override // java.lang.Runnable
            public final void run() {
                StickerPagerFragment.e9(this.a);
            }
        }, 100L);
    }
}
