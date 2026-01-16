package ir.nasim.features.audioplayer.ui.playlist;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.slider.Slider;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17683nO;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC22588vV1;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC23203wX2;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C14505i18;
import ir.nasim.C15319jO;
import ir.nasim.C15910kO;
import ir.nasim.C18823pJ2;
import ir.nasim.C19024pf0;
import ir.nasim.C19406qI3;
import ir.nasim.C21753u45;
import ir.nasim.C22078ud6;
import ir.nasim.C22372v74;
import ir.nasim.C23709xO;
import ir.nasim.C4471Fg6;
import ir.nasim.C6011Lu2;
import ir.nasim.C6906Pm2;
import ir.nasim.C8552Wl4;
import ir.nasim.C8697Wz3;
import ir.nasim.DB6;
import ir.nasim.DialogC7946Tw1;
import ir.nasim.ED1;
import ir.nasim.EnumC19631qg6;
import ir.nasim.EnumC7325Rf6;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3273Ae1;
import ir.nasim.InterfaceC5362Ja0;
import ir.nasim.J44;
import ir.nasim.KB5;
import ir.nasim.UI4;
import ir.nasim.VL;
import ir.nasim.VW5;
import ir.nasim.features.audioplayer.ui.AudioPlayBar;
import ir.nasim.features.audioplayer.ui.playlist.PlayListBottomSheet;
import ir.nasim.features.conversation.NewAdvancedForward;
import java.io.File;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class PlayListBottomSheet extends AbstractC23203wX2 implements UI4, AbstractC22588vV1.e {
    public static final a P1 = new a(null);
    public static final int Q1 = 8;
    private ImageView A1;
    private CardView B1;
    private ImageView C1;
    private TextView D1;
    private TextView E1;
    private boolean F1;
    private LinearLayoutManager G1;
    private C19024pf0 H1;
    private AbstractC17683nO I1;
    private boolean J1;
    private C15319jO K1;
    private int L1;
    private ImageButton M1;
    private BottomSheetBehavior N1;
    private C15910kO O1;
    private final C11458d25 s1;
    private final long t1;
    public C4471Fg6 u1;
    private AudioPlayBar.a v1;
    private PopupWindow w1;
    private com.google.android.material.bottomsheet.a x1;
    private ImageView y1;
    private TextView z1;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DB6.values().length];
            try {
                iArr[DB6.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DB6.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DB6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final class c implements InterfaceC5362Ja0 {
        c() {
        }

        @Override // ir.nasim.InterfaceC5362Ja0
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Slider slider) {
            AbstractC13042fc3.i(slider, "slider");
            PlayListBottomSheet.this.J1 = true;
        }

        @Override // ir.nasim.InterfaceC5362Ja0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Slider slider) {
            AbstractC13042fc3.i(slider, "slider");
            PlayListBottomSheet.this.J1 = false;
            C23709xO.a.m0(AbstractC20723sV3.f((((Slider) PlayListBottomSheet.this.p9().e.findViewById(BC5.audioSlide)).getValue() * r4.R()) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
        }
    }

    public static final class d extends AbstractC17683nO {
        d() {
        }

        @Override // ir.nasim.AbstractC17683nO
        public void a(VL vl) {
            if (PlayListBottomSheet.this.v6() || !PlayListBottomSheet.this.u6()) {
                return;
            }
            PlayListBottomSheet.this.M9(vl);
        }

        @Override // ir.nasim.AbstractC17683nO
        public void e() {
            BottomSheetBehavior bottomSheetBehaviorQ9;
            if (PlayListBottomSheet.this.v6() || !PlayListBottomSheet.this.u6() || (bottomSheetBehaviorQ9 = PlayListBottomSheet.this.q9()) == null) {
                return;
            }
            bottomSheetBehaviorQ9.J0(5);
        }

        @Override // ir.nasim.AbstractC17683nO
        public void i(DB6 db6) {
            AbstractC13042fc3.i(db6, "shuffleMode");
            if (PlayListBottomSheet.this.v6() || !PlayListBottomSheet.this.u6()) {
                return;
            }
            PlayListBottomSheet.this.S9(db6);
        }
    }

    public static final class e extends BottomSheetBehavior.f {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, float f) {
            AbstractC13042fc3.i(view, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(View view, int i) {
            AbstractC13042fc3.i(view, "bottomSheet");
            C19406qI3.a("PlayListBottomSheet", " newState " + i, new Object[0]);
            if (i == 3) {
                PlayListBottomSheet.this.O9();
                return;
            }
            if (i == 4) {
                PlayListBottomSheet.this.P9();
            } else if (i == 5) {
                PlayListBottomSheet.this.Q9();
            } else {
                if (i != 6) {
                    return;
                }
                PlayListBottomSheet.this.P9();
            }
        }
    }

    public PlayListBottomSheet(C11458d25 c11458d25, long j) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.s1 = c11458d25;
        this.t1 = j;
        this.L1 = Integer.MAX_VALUE;
    }

    private final void B9() {
        TextView textView = this.z1;
        if (textView == null) {
            AbstractC13042fc3.y("messageSeparator");
            textView = null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "alpha", 0.5f, 1.0f);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    private final void C9(long j) {
        if (this.F1) {
            return;
        }
        C19024pf0 c19024pf0 = this.H1;
        if (c19024pf0 == null) {
            AbstractC13042fc3.y("displayList");
            c19024pf0 = null;
        }
        if (c19024pf0.r() >= this.L1) {
            return;
        }
        r9().R(this.s1, j, EnumC19631qg6.b, EnumC7325Rf6.d).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Lf5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                PlayListBottomSheet.D9(this.a, (C22372v74) obj);
            }
        }).z(new InterfaceC3273Ae1() { // from class: ir.nasim.Mf5
            @Override // ir.nasim.InterfaceC3273Ae1
            public final void apply(Object obj, Object obj2) {
                PlayListBottomSheet.E9(this.a, (C22372v74) obj, (Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(PlayListBottomSheet playListBottomSheet, C22372v74 c22372v74) {
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        AbstractC13042fc3.i(c22372v74, "messageSearchResult");
        playListBottomSheet.L1 = c22372v74.b();
        C19406qI3.a("PlayListBottomSheet", "searchAudios result count: " + c22372v74.a().size() + ", total count: " + playListBottomSheet.L1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(PlayListBottomSheet playListBottomSheet, C22372v74 c22372v74, Exception exc) {
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        playListBottomSheet.F1 = false;
    }

    private final void F9(boolean z) {
        if (!z) {
            p9().b.setItemAnimator(null);
            return;
        }
        h hVar = new h();
        hVar.V(false);
        hVar.z(200L);
        hVar.w(150L);
        hVar.A(200L);
        p9().b.setItemAnimator(hVar);
    }

    private final void G9(final Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(AbstractC12208eD5.popup_playlist, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(BC5.forward);
        TextView textView2 = (TextView) viewInflate.findViewById(BC5.save);
        TextView textView3 = (TextView) viewInflate.findViewById(BC5.seen);
        TextView textView4 = (TextView) viewInflate.findViewById(BC5.share);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Nf5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayListBottomSheet.K9(this.a, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Of5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayListBottomSheet.H9(this.a, context, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Pf5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayListBottomSheet.I9(this.a, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Gf5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayListBottomSheet.J9(this.a, context, view);
            }
        });
        this.w1 = new PopupWindow(viewInflate, -2, -2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(PlayListBottomSheet playListBottomSheet, Context context, View view) {
        String strC;
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        AbstractC13042fc3.i(context, "$context");
        VL vlM = C23709xO.a.M();
        if (vlM == null || (strC = vlM.c()) == null) {
            return;
        }
        playListBottomSheet.x9(strC, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(PlayListBottomSheet playListBottomSheet, View view) {
        AudioPlayBar.a aVar;
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        VL vlM = C23709xO.a.M();
        if (vlM != null && (aVar = playListBottomSheet.v1) != null) {
            aVar.g2(vlM, true);
        }
        playListBottomSheet.u8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(PlayListBottomSheet playListBottomSheet, Context context, View view) {
        String strC;
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        AbstractC13042fc3.i(context, "$context");
        VL vlM = C23709xO.a.M();
        if (vlM != null && (strC = vlM.c()) != null) {
            playListBottomSheet.y9(strC, context);
        }
        playListBottomSheet.u8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(PlayListBottomSheet playListBottomSheet, View view) {
        J44 j44A;
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        VL vlM = C23709xO.a.M();
        if (vlM != null && (j44A = vlM.a()) != null) {
            playListBottomSheet.o9(vlM.d().e(), j44A);
        }
        playListBottomSheet.u8();
    }

    private final void L9(int i) {
        ImageButton imageButton = this.M1;
        if (imageButton == null) {
            AbstractC13042fc3.y("imbShuffleMode");
            imageButton = null;
        }
        imageButton.setImageDrawable(VW5.f(S7().getResources(), i, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(VL vl) {
        if (vl instanceof C8552Wl4) {
            TextView textView = this.D1;
            CardView cardView = null;
            if (textView == null) {
                AbstractC13042fc3.y("trackName");
                textView = null;
            }
            C8552Wl4 c8552Wl4 = (C8552Wl4) vl;
            textView.setText(c8552Wl4.j());
            TextView textView2 = this.E1;
            if (textView2 == null) {
                AbstractC13042fc3.y("artistName");
                textView2 = null;
            }
            textView2.setText(c8552Wl4.h());
            if (c8552Wl4.i() == null) {
                ImageView imageView = this.A1;
                if (imageView == null) {
                    AbstractC13042fc3.y("playerAlbumArt");
                    imageView = null;
                }
                imageView.setVisibility(0);
                CardView cardView2 = this.B1;
                if (cardView2 == null) {
                    AbstractC13042fc3.y("artCardView");
                } else {
                    cardView = cardView2;
                }
                cardView.setVisibility(4);
                return;
            }
            ImageView imageView2 = this.C1;
            if (imageView2 == null) {
                AbstractC13042fc3.y("albumCover");
                imageView2 = null;
            }
            imageView2.setImageBitmap(c8552Wl4.i());
            ImageView imageView3 = this.A1;
            if (imageView3 == null) {
                AbstractC13042fc3.y("playerAlbumArt");
                imageView3 = null;
            }
            imageView3.setVisibility(4);
            CardView cardView3 = this.B1;
            if (cardView3 == null) {
                AbstractC13042fc3.y("artCardView");
            } else {
                cardView = cardView3;
            }
            cardView.setVisibility(0);
        }
    }

    private final void N9() {
        C15319jO c15319jO = this.K1;
        if (c15319jO == null || c15319jO.i.r() <= 0) {
            return;
        }
        p9().b.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        ImageView imageView = this.y1;
        TextView textView = null;
        if (imageView == null) {
            AbstractC13042fc3.y("iconSeparator");
            imageView = null;
        }
        imageView.animate().rotation(180.0f).start();
        B9();
        TextView textView2 = this.z1;
        if (textView2 == null) {
            AbstractC13042fc3.y("messageSeparator");
        } else {
            textView = textView2;
        }
        textView.setText(S7().getResources().getText(AbstractC12217eE5.close_message_playList_separator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        ImageView imageView = this.y1;
        TextView textView = null;
        if (imageView == null) {
            AbstractC13042fc3.y("iconSeparator");
            imageView = null;
        }
        imageView.animate().rotation(0.0f).start();
        B9();
        TextView textView2 = this.z1;
        if (textView2 == null) {
            AbstractC13042fc3.y("messageSeparator");
        } else {
            textView = textView2;
        }
        textView.setText(S7().getResources().getText(AbstractC12217eE5.open_message_playList_separator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        com.google.android.material.bottomsheet.a aVar = this.x1;
        if (aVar == null) {
            AbstractC13042fc3.y("bottomSheet");
            aVar = null;
        }
        aVar.dismiss();
    }

    private final void R9() {
        C23709xO c23709xO = C23709xO.a;
        int i = b.a[c23709xO.Q().ordinal()];
        if (i == 1) {
            c23709xO.o0(DB6.d);
        } else if (i == 2) {
            c23709xO.o0(DB6.c);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            c23709xO.o0(DB6.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(DB6 db6) {
        int i = b.a[db6.ordinal()];
        if (i == 1) {
            L9(KB5.player_controls_shuffle_off);
        } else if (i == 2) {
            L9(KB5.player_controls_shuffle_on);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            L9(KB5.player_controls_shuffle_reverse);
        }
    }

    private final void m9() {
        final FragmentActivity fragmentActivityA5 = A5();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fragmentActivityA5) { // from class: ir.nasim.features.audioplayer.ui.playlist.PlayListBottomSheet$configureRecyclerView$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
            public void L1(RecyclerView recyclerView, RecyclerView.z state, int position) {
                AbstractC13042fc3.i(recyclerView, "recyclerView");
                AbstractC13042fc3.i(state, "state");
                C8697Wz3 c8697Wz3 = new C8697Wz3(recyclerView.getContext());
                c8697Wz3.p(position);
                M1(c8697Wz3);
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
            public boolean P1() {
                return false;
            }
        };
        this.G1 = linearLayoutManager;
        linearLayoutManager.G2(false);
        LinearLayoutManager linearLayoutManager2 = this.G1;
        LinearLayoutManager linearLayoutManager3 = null;
        if (linearLayoutManager2 == null) {
            AbstractC13042fc3.y("linearLayoutManager");
            linearLayoutManager2 = null;
        }
        linearLayoutManager2.I2(false);
        RecyclerView recyclerView = p9().b;
        LinearLayoutManager linearLayoutManager4 = this.G1;
        if (linearLayoutManager4 == null) {
            AbstractC13042fc3.y("linearLayoutManager");
        } else {
            linearLayoutManager3 = linearLayoutManager4;
        }
        recyclerView.setLayoutManager(linearLayoutManager3);
        p9().b.setHorizontalScrollBarEnabled(false);
        p9().b.setVerticalScrollBarEnabled(true);
    }

    private final void n9(C11458d25 c11458d25, List list) {
        View viewInflate = LayoutInflater.from(A5()).inflate(AbstractC12208eD5.advanced_forward_new_bottom, (ViewGroup) null, false);
        AbstractC13042fc3.g(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        NewAdvancedForward newAdvancedForward = new NewAdvancedForward(contextS7, c11458d25, list, linearLayout, false, null);
        Context contextS72 = S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        DialogC7946Tw1 dialogC7946Tw1 = new DialogC7946Tw1(contextS72, AbstractC23035wE5.TransparentBottomSheetDialog, linearLayout, newAdvancedForward);
        newAdvancedForward.setParentDialog(dialogC7946Tw1);
        dialogC7946Tw1.show();
    }

    private final void o9(C11458d25 c11458d25, J44 j44) {
        n9(c11458d25, AbstractC9766aX0.e(j44));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C15910kO p9() {
        C15910kO c15910kO = this.O1;
        AbstractC13042fc3.f(c15910kO);
        return c15910kO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s9(PlayListBottomSheet playListBottomSheet, C14505i18 c14505i18) {
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        C19024pf0 c19024pf0 = playListBottomSheet.H1;
        if (c19024pf0 == null) {
            AbstractC13042fc3.y("displayList");
            c19024pf0 = null;
        }
        if (c19024pf0.r() <= 0) {
            playListBottomSheet.C9(playListBottomSheet.t1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t9(PlayListBottomSheet playListBottomSheet, View view) {
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        playListBottomSheet.R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u9(PlayListBottomSheet playListBottomSheet, View view) {
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int iA = C22078ud6.a(180.0f);
        int iA2 = C22078ud6.a(188.0f);
        PopupWindow popupWindow = playListBottomSheet.w1;
        PopupWindow popupWindow2 = null;
        if (popupWindow == null) {
            AbstractC13042fc3.y("playListPopupWindow");
            popupWindow = null;
        }
        popupWindow.showAtLocation(playListBottomSheet.p9().getRoot(), 0, 10, 10);
        PopupWindow popupWindow3 = playListBottomSheet.w1;
        if (popupWindow3 == null) {
            AbstractC13042fc3.y("playListPopupWindow");
        } else {
            popupWindow2 = popupWindow3;
        }
        popupWindow2.update((iArr[0] - iA) + view.getWidth(), iArr[1] + view.getHeight(), iA, iA2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v9(PlayListBottomSheet playListBottomSheet, View view) {
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        BottomSheetBehavior bottomSheetBehavior = playListBottomSheet.N1;
        if (bottomSheetBehavior == null || bottomSheetBehavior.k0() != 6) {
            BottomSheetBehavior bottomSheetBehavior2 = playListBottomSheet.N1;
            if (bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.J0(6);
                return;
            }
            return;
        }
        BottomSheetBehavior bottomSheetBehavior3 = playListBottomSheet.N1;
        if (bottomSheetBehavior3 != null) {
            bottomSheetBehavior3.J0(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w9(PlayListBottomSheet playListBottomSheet, long j, long j2) {
        AbstractC13042fc3.i(playListBottomSheet, "this$0");
        if (playListBottomSheet.J1) {
            return;
        }
        float fR = (j * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) / C23709xO.a.R();
        if (fR > 1000.0f) {
            fR = 1000.0f;
        }
        ((Slider) playListBottomSheet.p9().e.findViewById(BC5.audioSlide)).setValue(fR);
    }

    private final void x9(String str, Context context) {
        C21753u45 c21753u45 = C21753u45.a;
        if (!c21753u45.U(context)) {
            C21753u45.Q0(c21753u45, this, 4, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
            return;
        }
        if (str.length() > 0) {
            String strSubstring = str.substring(AbstractC20762sZ6.r0(str, Separators.DOT, 0, false, 6, null) + 1);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            String strL = C6906Pm2.l(strSubstring);
            if (strL.length() == 0) {
                strL = "audio/mp3";
            }
            if (AbstractC20762sZ6.r0(str, Separators.DOT, 0, false, 6, null) != -1) {
                VL vlM = C23709xO.a.M();
                String strSubstring2 = str.substring(AbstractC20762sZ6.r0(str, Separators.DOT, 0, false, 6, null));
                AbstractC13042fc3.h(strSubstring2, "substring(...)");
                if (vlM instanceof C8552Wl4) {
                    C6906Pm2.A(str, context, 3, ((C8552Wl4) vlM).j() + strSubstring2, strL);
                }
            }
        }
    }

    private final void y9(String str, Context context) {
        if (str.length() == 0) {
            return;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                String strSubstring = str.substring(AbstractC20762sZ6.r0(str, Separators.DOT, 0, false, 6, null) + 1);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                String strL = C6906Pm2.l(strSubstring);
                if (strL.length() == 0) {
                    strL = "audio/mp3";
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType(strL);
                intent.addFlags(1);
                intent.putExtra("android.intent.extra.STREAM", FileProvider.h(context, context.getPackageName() + ".provider", file));
                startActivityForResult(Intent.createChooser(intent, h6(AbstractC12217eE5.menu_share)), SIPTransactionStack.BASE_TIMER_INTERVAL);
            }
        } catch (Exception e2) {
            C19406qI3.d("PlayListBottomSheet", e2);
        }
    }

    private final void z9() {
        C23709xO c23709xO = C23709xO.a;
        d dVar = new d();
        this.I1 = dVar;
        c23709xO.u(dVar);
    }

    public final void A9(AudioPlayBar.a aVar) {
        AbstractC13042fc3.i(aVar, "playListBottomSheetDelegate");
        this.v1 = aVar;
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle bundle) {
        this.O1 = C15910kO.c(LayoutInflater.from(G5()));
        Dialog dialogB8 = super.B8(bundle);
        AbstractC13042fc3.g(dialogB8, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        this.x1 = (com.google.android.material.bottomsheet.a) dialogB8;
        this.H1 = AbstractC5969Lp4.d().Z1(this.s1);
        F9(true);
        m9();
        C19024pf0 c19024pf0 = this.H1;
        if (c19024pf0 == null) {
            AbstractC13042fc3.y("displayList");
            c19024pf0 = null;
        }
        this.K1 = new C15319jO(c19024pf0, this, G5(), this.s1);
        p9().b.setAdapter(this.K1);
        C19024pf0 c19024pf02 = this.H1;
        if (c19024pf02 == null) {
            AbstractC13042fc3.y("displayList");
            c19024pf02 = null;
        }
        c19024pf02.Z(this.t1).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Ff5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                PlayListBottomSheet.s9(this.a, (C14505i18) obj);
            }
        });
        com.google.android.material.bottomsheet.a aVar = this.x1;
        if (aVar == null) {
            AbstractC13042fc3.y("bottomSheet");
            aVar = null;
        }
        aVar.setContentView(p9().getRoot());
        StyledPlayerControlView styledPlayerControlView = p9().e;
        C23709xO c23709xO = C23709xO.a;
        styledPlayerControlView.setPlayer(c23709xO.V());
        styledPlayerControlView.setRepeatToggleModes(3);
        styledPlayerControlView.setVisibility(0);
        this.D1 = (TextView) p9().e.findViewById(BC5.track_name);
        this.E1 = (TextView) p9().e.findViewById(BC5.artist_name);
        this.y1 = p9().c;
        this.z1 = p9().d;
        ImageButton imageButton = (ImageButton) p9().e.findViewById(BC5.exo_shuffle_toggle);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Hf5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayListBottomSheet.t9(this.a, view);
            }
        });
        this.M1 = imageButton;
        S9(c23709xO.Q());
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        G9(contextS7);
        ((ImageView) p9().e.findViewById(BC5.menu_current_item)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.If5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayListBottomSheet.u9(this.a, view);
            }
        });
        p9().f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Jf5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayListBottomSheet.v9(this.a, view);
            }
        });
        TextView textView = this.D1;
        if (textView == null) {
            AbstractC13042fc3.y("trackName");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.i());
        TextView textView2 = this.E1;
        if (textView2 == null) {
            AbstractC13042fc3.y("artistName");
            textView2 = null;
        }
        textView2.setTypeface(C6011Lu2.k());
        ((TextView) p9().e.findViewById(BC5.exo_duration)).setTypeface(C6011Lu2.k());
        ((TextView) p9().e.findViewById(BC5.exo_duration)).setTypeface(C6011Lu2.k());
        this.C1 = (ImageView) p9().e.findViewById(BC5.player_album_cover);
        this.A1 = (ImageView) p9().e.findViewById(BC5.player_album_art);
        this.B1 = (CardView) p9().e.findViewById(BC5.art_card_view);
        ((Slider) p9().e.findViewById(BC5.audioSlide)).setValueFrom(0.0f);
        ((Slider) p9().e.findViewById(BC5.audioSlide)).setValueTo(1000.0f);
        p9().e.setProgressUpdateListener(new StyledPlayerControlView.f() { // from class: ir.nasim.Kf5
            @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.f
            public final void a(long j, long j2) {
                PlayListBottomSheet.w9(this.a, j, j2);
            }
        });
        ((Slider) p9().e.findViewById(BC5.audioSlide)).h(new c());
        M9(c23709xO.M());
        z9();
        com.google.android.material.bottomsheet.a aVar2 = this.x1;
        if (aVar2 != null) {
            return aVar2;
        }
        AbstractC13042fc3.y("bottomSheet");
        return null;
    }

    @Override // ir.nasim.ZD, androidx.fragment.app.l
    public void J8(Dialog dialog, int i) {
        AbstractC13042fc3.i(dialog, "dialog");
        Window window = dialog.getWindow();
        FrameLayout frameLayout = window != null ? (FrameLayout) window.findViewById(BC5.design_bottom_sheet) : null;
        AbstractC13042fc3.g(frameLayout, "null cannot be cast to non-null type android.widget.FrameLayout");
        BottomSheetBehavior bottomSheetBehaviorF0 = BottomSheetBehavior.f0(frameLayout);
        this.N1 = bottomSheetBehaviorF0;
        AbstractC13042fc3.g(bottomSheetBehaviorF0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetBehavior<*>");
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        bottomSheetBehaviorF0.F0(aVar.f(282.0f));
        float fB = C22078ud6.b();
        float f = aVar.f(282.0f);
        BottomSheetBehavior bottomSheetBehavior = this.N1;
        AbstractC13042fc3.f(bottomSheetBehavior);
        bottomSheetBehavior.B0(f / fB);
        BottomSheetBehavior bottomSheetBehavior2 = this.N1;
        AbstractC13042fc3.f(bottomSheetBehavior2);
        bottomSheetBehavior2.J0(6);
        BottomSheetBehavior bottomSheetBehavior3 = this.N1;
        AbstractC13042fc3.g(bottomSheetBehavior3, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetBehavior<*>");
        bottomSheetBehavior3.w0(new e());
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        I8(0, AbstractC23035wE5.PlayListBottomSheetDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this.O1 = null;
        this.K1 = null;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void U6() {
        super.U6();
        C23709xO c23709xO = C23709xO.a;
        AbstractC17683nO abstractC17683nO = this.I1;
        if (abstractC17683nO == null) {
            AbstractC13042fc3.y("audioPlayerCallback");
            abstractC17683nO = null;
        }
        c23709xO.z0(abstractC17683nO);
    }

    @Override // ir.nasim.UI4
    public void V(int i) {
        C19024pf0 c19024pf0 = this.H1;
        if (c19024pf0 == null) {
            AbstractC13042fc3.y("displayList");
            c19024pf0 = null;
        }
        Long lR = ((C18823pJ2) c19024pf0.o(i)).r();
        AbstractC13042fc3.f(lR);
        C9(lR.longValue());
    }

    @Override // ir.nasim.AbstractC22588vV1.e
    public void X0() {
        N9();
    }

    public final BottomSheetBehavior q9() {
        return this.N1;
    }

    public final C4471Fg6 r9() {
        C4471Fg6 c4471Fg6 = this.u1;
        if (c4471Fg6 != null) {
            return c4471Fg6;
        }
        AbstractC13042fc3.y("searchModule");
        return null;
    }
}
