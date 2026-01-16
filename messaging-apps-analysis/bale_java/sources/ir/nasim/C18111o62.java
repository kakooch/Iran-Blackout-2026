package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C15225jD4;
import ir.nasim.C18111o62;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.T62;
import ir.nasim.features.smiles.widget.EmojiRecyclerView;
import ir.nasim.features.smiles.widget.TopSmilesRecyclerViewBehavior;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0087\u0001\b\u0007\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0003@\u0092\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J+\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b+\u0010,J!\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u000f¢\u0006\u0004\b0\u0010\u0005J\r\u00102\u001a\u000201¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u000f2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u000fH\u0016¢\u0006\u0004\b8\u0010\u0005J/\u0010=\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u00172\u0016\u0010<\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010;0:\"\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u000fH\u0016¢\u0006\u0004\b?\u0010\u0005J\u000f\u0010@\u001a\u000201H\u0016¢\u0006\u0004\b@\u00103J\u000f\u0010A\u001a\u00020\u000fH\u0016¢\u0006\u0004\bA\u0010\u0005J\u000f\u0010B\u001a\u00020\u000fH\u0016¢\u0006\u0004\bB\u0010\u0005R\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010V\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u000f0R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010K\u001a\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR$\u0010s\u001a\u0004\u0018\u00010l8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR$\u0010{\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR(\u0010\u0083\u0001\u001a\u0004\u0018\u00010|8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0086\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008e\u0001\u001a\u000b\u0012\u0004\u0012\u00020*\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010\u0090\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0085\u0001¨\u0006\u0093\u0001"}, d2 = {"Lir/nasim/o62;", "Landroidx/fragment/app/Fragment;", "Lir/nasim/DF6;", "Lir/nasim/jD4$b;", "<init>", "()V", "Landroidx/appcompat/widget/LinearLayoutCompat;", "j9", "()Landroidx/appcompat/widget/LinearLayoutCompat;", "", "Lir/nasim/T62$b;", "tabs", "Lcom/google/android/material/tabs/TabLayout;", "n9", "(Ljava/util/List;)Lcom/google/android/material/tabs/TabLayout;", "Lir/nasim/rB7;", "e9", "Lir/nasim/features/smiles/widget/EmojiRecyclerView;", "f9", "()Lir/nasim/features/smiles/widget/EmojiRecyclerView;", "Lcom/google/android/material/textfield/TextInputLayout;", "i9", "()Lcom/google/android/material/textfield/TextInputLayout;", "", "targetPos", "offset", "Z8", "(II)Lir/nasim/rB7;", "position", "l9", "(I)V", "T8", "Lir/nasim/o62$b;", "newState", "d9", "(Lir/nasim/o62$b;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Y8", "", "S8", "()Z", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "T6", "id", "", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "o4", "a", "onClose", "h7", "Lir/nasim/nz2;", "b1", "Lir/nasim/bW7;", "O8", "()Lir/nasim/nz2;", "binding", "Lir/nasim/T62;", "c1", "Lir/nasim/Yu3;", "P8", "()Lir/nasim/T62;", "emojiViewModel", "d1", "Lir/nasim/o62$b;", "state", "Lkotlin/Function1;", "", "e1", "Lir/nasim/UA2;", "onEmojiSelectedListener", "Lir/nasim/W62;", "f1", "Q8", "()Lir/nasim/W62;", "emojisAdapter", "Lir/nasim/QK5;", "g1", "Lir/nasim/QK5;", "emojiScrollHelper", "Lir/nasim/Uz3;", "h1", "Lir/nasim/Uz3;", "linearSmoothScroller", "Landroidx/recyclerview/widget/GridLayoutManager;", "i1", "Landroidx/recyclerview/widget/GridLayoutManager;", "emojiLayoutManager", "Landroid/content/res/ColorStateList;", "j1", "Landroid/content/res/ColorStateList;", "TAB_ICONS_COLOR_STATE", "Lir/nasim/CF6;", "k1", "Lir/nasim/CF6;", "getSmilesKeyboardListener", "()Lir/nasim/CF6;", "b9", "(Lir/nasim/CF6;)V", "smilesKeyboardListener", "Lir/nasim/BF6;", "l1", "Lir/nasim/BF6;", "R8", "()Lir/nasim/BF6;", "a9", "(Lir/nasim/BF6;)V", "smilesActionListener", "Lir/nasim/EF6;", "m1", "Lir/nasim/EF6;", "getSmilesPanelListener", "()Lir/nasim/EF6;", "c9", "(Lir/nasim/EF6;)V", "smilesPanelListener", "n1", TokenNames.I, "mSpanCount", "ir/nasim/o62$t", "o1", "Lir/nasim/o62$t;", "tabScrollListener", "Lir/nasim/features/smiles/widget/TopSmilesRecyclerViewBehavior;", "p1", "Lir/nasim/features/smiles/widget/TopSmilesRecyclerViewBehavior;", "emojiTabBehaviour", "q1", "firstVisiblePackId", "r1", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.o62, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18111o62 extends DW2 implements DF6, C15225jD4.b {

    /* renamed from: b1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new n(), AbstractC20046rN7.c());

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 emojiViewModel;

    /* renamed from: d1, reason: from kotlin metadata */
    private b state;

    /* renamed from: e1, reason: from kotlin metadata */
    private UA2 onEmojiSelectedListener;

    /* renamed from: f1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 emojisAdapter;

    /* renamed from: g1, reason: from kotlin metadata */
    private QK5 emojiScrollHelper;

    /* renamed from: h1, reason: from kotlin metadata */
    private C8209Uz3 linearSmoothScroller;

    /* renamed from: i1, reason: from kotlin metadata */
    private GridLayoutManager emojiLayoutManager;

    /* renamed from: j1, reason: from kotlin metadata */
    private final ColorStateList TAB_ICONS_COLOR_STATE;

    /* renamed from: k1, reason: from kotlin metadata */
    private CF6 smilesKeyboardListener;

    /* renamed from: l1, reason: from kotlin metadata */
    private BF6 smilesActionListener;

    /* renamed from: m1, reason: from kotlin metadata */
    private EF6 smilesPanelListener;

    /* renamed from: n1, reason: from kotlin metadata */
    private int mSpanCount;

    /* renamed from: o1, reason: from kotlin metadata */
    private final t tabScrollListener;

    /* renamed from: p1, reason: from kotlin metadata */
    private TopSmilesRecyclerViewBehavior emojiTabBehaviour;

    /* renamed from: q1, reason: from kotlin metadata */
    private int firstVisiblePackId;
    static final /* synthetic */ InterfaceC5239Im3[] s1 = {AbstractC10882cM5.i(new C25226zw5(C18111o62.class, "binding", "getBinding()Lir/nasim/databinding/FragmentSmilesEmojiBinding;", 0))};

    /* renamed from: r1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int t1 = 8;

    /* renamed from: ir.nasim.o62$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C18111o62 a(boolean z) {
            C18111o62 c18111o62 = new C18111o62();
            c18111o62.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("ARG_force_night_mode", Boolean.valueOf(z))));
            return c18111o62;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.o62$b */
    private static final class b {
        public static final b a = new b("SEARCH", 0);
        public static final b b = new b("EMOJI", 1);
        private static final /* synthetic */ b[] c;
        private static final /* synthetic */ F92 d;

        static {
            b[] bVarArrA = a();
            c = bVarArrA;
            d = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    /* renamed from: ir.nasim.o62$c */
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
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.o62$d */
    public static final class d implements View.OnLayoutChangeListener {
        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            C18111o62.this.mSpanCount = RF6.a.a(view.getMeasuredWidth() - (view.getPaddingLeft() + view.getPaddingRight()));
            GridLayoutManager gridLayoutManager = C18111o62.this.emojiLayoutManager;
            if (gridLayoutManager != null) {
                gridLayoutManager.j3(C18111o62.this.mSpanCount);
            }
        }
    }

    /* renamed from: ir.nasim.o62$e */
    static final class e implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        e(UA2 ua2) {
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

    /* renamed from: ir.nasim.o62$f */
    public static final class f implements View.OnLayoutChangeListener {
        public f() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            long j;
            view.removeOnLayoutChangeListener(this);
            C18111o62.this.O8().e.stopScroll();
            if (C18111o62.this.O8().e.canScrollVertically(-1)) {
                GridLayoutManager gridLayoutManager = C18111o62.this.emojiLayoutManager;
                if (gridLayoutManager != null) {
                    gridLayoutManager.A1(0);
                }
                j = 10;
            } else {
                j = 0;
            }
            C18111o62.this.O8().e.postDelayed(C18111o62.this.new g(), j);
        }
    }

    /* renamed from: ir.nasim.o62$g */
    static final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view;
            int y = (int) C18111o62.this.O8().e.getY();
            RecyclerView.C cFindViewHolderForAdapterPosition = C18111o62.this.O8().e.findViewHolderForAdapterPosition(1);
            int bottom = (cFindViewHolderForAdapterPosition == null || (view = cFindViewHolderForAdapterPosition.a) == null) ? 0 : view.getBottom();
            BF6 smilesActionListener = C18111o62.this.getSmilesActionListener();
            if (smilesActionListener != null) {
                smilesActionListener.b(bottom + y);
            }
        }
    }

    /* renamed from: ir.nasim.o62$h */
    public static final class h implements View.OnLayoutChangeListener {
        public h() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            C18111o62.this.Z8(0, AbstractC7426Rr.a.f(-1.0f));
        }
    }

    /* renamed from: ir.nasim.o62$i */
    public static final class i implements View.OnLayoutChangeListener {
        public i() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            AbstractC13042fc3.g(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) view;
            C18111o62.this.mSpanCount = RF6.a.a(recyclerView.getMeasuredWidth() - (recyclerView.getPaddingLeft() + recyclerView.getPaddingRight()));
            C18111o62 c18111o62 = C18111o62.this;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(c18111o62.G5(), C18111o62.this.mSpanCount);
            gridLayoutManager.k3(C18111o62.this.new j());
            recyclerView.setLayoutManager(gridLayoutManager);
            C18111o62.this.emojiScrollHelper = new QK5(recyclerView, gridLayoutManager);
            c18111o62.emojiLayoutManager = gridLayoutManager;
        }
    }

    /* renamed from: ir.nasim.o62$j */
    public static final class j extends GridLayoutManager.b {

        /* renamed from: ir.nasim.o62$j$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[V62.values().length];
                try {
                    iArr[V62.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[V62.e.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[V62.d.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        j() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int f(int i) {
            int i2 = a.a[V62.b.a(C18111o62.this.Q8().getItemViewType(i)).ordinal()];
            if (i2 == 1) {
                return C18111o62.this.mSpanCount;
            }
            if (i2 == 2 || i2 == 3) {
                return 1;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: ir.nasim.o62$k */
    public static final class k extends RecyclerView.t {
        k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            if (i2 == 0) {
                return;
            }
            C18111o62.m9(C18111o62.this, 0, 1, null);
            super.b(recyclerView, i, i2);
        }
    }

    /* renamed from: ir.nasim.o62$l */
    static final class l implements InterfaceC15796kB2 {
        l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C18111o62 c18111o62, Dialog dialog) {
            AbstractC13042fc3.i(c18111o62, "this$0");
            AbstractC13042fc3.i(dialog, "$it");
            c18111o62.P8().b1();
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
            C21759u51 c21759u51 = C21759u51.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c21759u51.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c21759u51.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(-181564122);
            boolean zD = interfaceC22053ub1.D(C18111o62.this) | interfaceC22053ub1.D(dialog);
            final C18111o62 c18111o62 = C18111o62.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.p62
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C18111o62.l.d(c18111o62, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.smiles_clear_recent_emoji_clean_btn;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-181554176);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.q62
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C18111o62.l.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, AbstractC12217eE5.smiles_clear_recent_emoji_cancel_btn, null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.o62$n */
    public static final class n extends AbstractC8614Ws3 implements UA2 {
        public n() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C18041nz2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.o62$o */
    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.o62$p */
    public static final class p extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.o62$q */
    public static final class q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.o62$r */
    public static final class r extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.o62$s */
    public static final class s extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C18111o62() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new p(new o(this)));
        this.emojiViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(T62.class), new q(interfaceC9173Yu3B), new r(null, interfaceC9173Yu3B), new s(this, interfaceC9173Yu3B));
        this.state = b.b;
        this.onEmojiSelectedListener = new UA2() { // from class: ir.nasim.j62
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18111o62.X8(this.a, (String) obj);
            }
        };
        this.emojisAdapter = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.k62
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18111o62.N8(this.a);
            }
        });
        int[][] iArr = {new int[]{android.R.attr.state_selected}, new int[0]};
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        this.TAB_ICONS_COLOR_STATE = new ColorStateList(iArr, new int[]{c5495Jo7.u2(), c5495Jo7.v0()});
        this.mSpanCount = 8;
        this.tabScrollListener = new t();
        this.firstVisiblePackId = RecyclerView.UNDEFINED_DURATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final W62 N8(C18111o62 c18111o62) {
        AbstractC13042fc3.i(c18111o62, "this$0");
        return new W62(c18111o62.onEmojiSelectedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C18041nz2 O8() {
        Object objA = this.binding.a(this, s1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C18041nz2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T62 P8() {
        return (T62) this.emojiViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final W62 Q8() {
        return (W62) this.emojisAdapter.getValue();
    }

    private final void T8() {
        P8().e1().j(p6(), new e(new UA2() { // from class: ir.nasim.m62
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18111o62.U8(this.a, (List) obj);
            }
        }));
        P8().f1().j(p6(), new e(new UA2() { // from class: ir.nasim.n62
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18111o62.V8(this.a, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U8(C18111o62 c18111o62, List list) {
        AbstractC13042fc3.i(c18111o62, "this$0");
        c18111o62.Q8().C(list);
        m9(c18111o62, 0, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V8(C18111o62 c18111o62, List list) throws Resources.NotFoundException {
        AbstractC13042fc3.i(c18111o62, "this$0");
        AbstractC13042fc3.f(list);
        c18111o62.n9(list);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W8(C18111o62 c18111o62) {
        AbstractC13042fc3.i(c18111o62, "this$0");
        EmojiRecyclerView emojiRecyclerView = c18111o62.O8().e;
        AbstractC13042fc3.h(emojiRecyclerView, "rcSmilesEmoji");
        if (!emojiRecyclerView.isLaidOut() || emojiRecyclerView.isLayoutRequested()) {
            emojiRecyclerView.addOnLayoutChangeListener(c18111o62.new d());
            return;
        }
        c18111o62.mSpanCount = RF6.a.a(emojiRecyclerView.getMeasuredWidth() - (emojiRecyclerView.getPaddingLeft() + emojiRecyclerView.getPaddingRight()));
        GridLayoutManager gridLayoutManager = c18111o62.emojiLayoutManager;
        if (gridLayoutManager != null) {
            gridLayoutManager.j3(c18111o62.mSpanCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X8(C18111o62 c18111o62, String str) {
        AbstractC13042fc3.i(c18111o62, "this$0");
        AbstractC13042fc3.i(str, "emoji");
        EF6 ef6 = c18111o62.smilesPanelListener;
        if (ef6 != null) {
            ef6.c(true, true);
        }
        CF6 cf6 = c18111o62.smilesKeyboardListener;
        if (cf6 != null) {
            cf6.f(R62.a.u(str));
        }
        c18111o62.P8().a1(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C19938rB7 Z8(int targetPos, int offset) {
        GridLayoutManager gridLayoutManager = this.emojiLayoutManager;
        if (gridLayoutManager == null) {
            return null;
        }
        View viewD = gridLayoutManager.D(targetPos);
        int iD2 = gridLayoutManager.d2();
        if (viewD != null || Math.abs(targetPos - iD2) <= gridLayoutManager.c3() * 9) {
            C8209Uz3 c8209Uz3 = new C8209Uz3(S7(), 2);
            c8209Uz3.p(targetPos);
            c8209Uz3.x(offset);
            gridLayoutManager.M1(c8209Uz3);
            this.linearSmoothScroller = c8209Uz3;
            return C19938rB7.a;
        }
        QK5 qk5 = this.emojiScrollHelper;
        if (qk5 != null) {
            qk5.l(gridLayoutManager.d2() < targetPos ? 0 : 1);
        }
        QK5 qk52 = this.emojiScrollHelper;
        if (qk52 == null) {
            return null;
        }
        qk52.k(targetPos, offset);
        return C19938rB7.a;
    }

    private final void d9(b newState) {
        int i2 = c.a[newState.ordinal()];
        if (i2 == 1) {
            CoordinatorLayout root = O8().getRoot();
            AbstractC13042fc3.h(root, "getRoot(...)");
            root.addOnLayoutChangeListener(new f());
            AbstractC14828iY7.m(O8().f, true);
            EmojiRecyclerView emojiRecyclerView = O8().e;
            emojiRecyclerView.setPadding(0, 0, 0, emojiRecyclerView.getPaddingBottom());
            TextInputEditText textInputEditText = O8().b;
            AbstractC13042fc3.h(textInputEditText, "edSearch");
            AbstractC16172kp3.c(textInputEditText, false, 1, null);
            TopSmilesRecyclerViewBehavior topSmilesRecyclerViewBehavior = this.emojiTabBehaviour;
            if (topSmilesRecyclerViewBehavior != null) {
                topSmilesRecyclerViewBehavior.O(true);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            P8().c1();
            BF6 bf6 = this.smilesActionListener;
            if (bf6 != null) {
                bf6.a();
            }
            EmojiRecyclerView emojiRecyclerView2 = O8().e;
            AbstractC13042fc3.f(emojiRecyclerView2);
            emojiRecyclerView2.addOnLayoutChangeListener(new h());
            emojiRecyclerView2.setPadding(0, (int) emojiRecyclerView2.getResources().getDimension(AbstractC14008hB5.smiles_emoji_top_bar_height), 0, emojiRecyclerView2.getPaddingBottom());
            AbstractC14828iY7.d(O8().f, false);
            TopSmilesRecyclerViewBehavior topSmilesRecyclerViewBehavior2 = this.emojiTabBehaviour;
            if (topSmilesRecyclerViewBehavior2 != null) {
                topSmilesRecyclerViewBehavior2.O(false);
                C19938rB7 c19938rB72 = C19938rB7.a;
            }
        }
        this.state = newState;
    }

    private final void e9() {
        EmojiRecyclerView emojiRecyclerView = O8().e;
        AbstractC13042fc3.h(emojiRecyclerView, "rcSmilesEmoji");
        emojiRecyclerView.addOnLayoutChangeListener(new i());
    }

    private final EmojiRecyclerView f9() {
        EmojiRecyclerView emojiRecyclerView = O8().e;
        emojiRecyclerView.setItemAnimator(null);
        emojiRecyclerView.setHasFixedSize(false);
        emojiRecyclerView.addOnScrollListener(new k());
        emojiRecyclerView.setClearRecentListener(new SA2() { // from class: ir.nasim.h62
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18111o62.g9(this.a);
            }
        });
        emojiRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.i62
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C18111o62.h9(view, motionEvent);
            }
        });
        e9();
        emojiRecyclerView.setAdapter(Q8());
        AbstractC13042fc3.h(emojiRecyclerView, "apply(...)");
        return emojiRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g9(C18111o62 c18111o62) {
        AbstractC13042fc3.i(c18111o62, "this$0");
        Context contextS7 = c18111o62.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = c18111o62.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1518512997, true, c18111o62.new l()), 4, null).show();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h9(View view, MotionEvent motionEvent) {
        C23381wp3.f(view);
        return false;
    }

    private final TextInputLayout i9() {
        TextInputLayout textInputLayout = O8().f;
        textInputLayout.setVisibility(8);
        O8().b.addTextChangedListener(new m());
        AbstractC13042fc3.h(textInputLayout, "apply(...)");
        return textInputLayout;
    }

    private final LinearLayoutCompat j9() {
        LinearLayoutCompat linearLayoutCompat = O8().c;
        CoordinatorLayout.e eVar = new CoordinatorLayout.e(linearLayoutCompat.getLayoutParams());
        final TopSmilesRecyclerViewBehavior topSmilesRecyclerViewBehavior = new TopSmilesRecyclerViewBehavior();
        O8().h.post(new Runnable() { // from class: ir.nasim.g62
            @Override // java.lang.Runnable
            public final void run() {
                C18111o62.k9(topSmilesRecyclerViewBehavior, this);
            }
        });
        topSmilesRecyclerViewBehavior.P(true);
        topSmilesRecyclerViewBehavior.N(true);
        eVar.o(topSmilesRecyclerViewBehavior);
        this.emojiTabBehaviour = topSmilesRecyclerViewBehavior;
        linearLayoutCompat.setLayoutParams(eVar);
        AbstractC13042fc3.h(linearLayoutCompat, "apply(...)");
        return linearLayoutCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k9(TopSmilesRecyclerViewBehavior topSmilesRecyclerViewBehavior, C18111o62 c18111o62) {
        AbstractC13042fc3.i(topSmilesRecyclerViewBehavior, "$this_apply");
        AbstractC13042fc3.i(c18111o62, "this$0");
        TopSmilesRecyclerViewBehavior.M(topSmilesRecyclerViewBehavior, c18111o62.O8().h.getMeasuredHeight(), null, 2, null);
    }

    private final void l9(int position) {
        if (position == -1) {
            return;
        }
        RecyclerView.C cFindViewHolderForAdapterPosition = O8().e.findViewHolderForAdapterPosition(position);
        Y62 y62 = cFindViewHolderForAdapterPosition instanceof Y62 ? (Y62) cFindViewHolderForAdapterPosition : null;
        Integer numValueOf = y62 != null ? Integer.valueOf(y62.D0()) : null;
        if (numValueOf == null || this.firstVisiblePackId == numValueOf.intValue()) {
            return;
        }
        this.firstVisiblePackId = numValueOf.intValue();
        TabLayout tabLayout = O8().g;
        Integer numI1 = P8().i1(numValueOf.intValue());
        if (numI1 != null) {
            int iIntValue = numI1.intValue();
            tabLayout.G(this.tabScrollListener);
            TabLayout.g gVarY = tabLayout.y(iIntValue);
            if (gVarY != null) {
                gVarY.n();
            }
            tabLayout.d(this.tabScrollListener);
        }
    }

    static /* synthetic */ void m9(C18111o62 c18111o62, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            GridLayoutManager gridLayoutManager = c18111o62.emojiLayoutManager;
            i2 = gridLayoutManager != null ? gridLayoutManager.Z1() : 0;
        }
        c18111o62.l9(i2);
    }

    private final TabLayout n9(List tabs) throws Resources.NotFoundException {
        TabLayout tabLayout = O8().g;
        tabLayout.E();
        tabLayout.G(this.tabScrollListener);
        Iterator it = tabs.iterator();
        while (it.hasNext()) {
            T62.b bVar = (T62.b) it.next();
            TabLayout.g gVarB = tabLayout.B();
            gVarB.u(bVar.b());
            gVarB.s(bVar.a());
            tabLayout.setTabIconTint(this.TAB_ICONS_COLOR_STATE);
            gVarB.o(bVar.c());
            tabLayout.e(gVarB);
        }
        tabLayout.d(this.tabScrollListener);
        AbstractC13042fc3.h(tabLayout, "apply(...)");
        return tabLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        if (R7().getBoolean("ARG_force_night_mode", false)) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            inflater = LayoutInflater.from(AbstractC20790sc5.b(contextS7, 0, 1, null));
        }
        C15225jD4.b().a(this, C15225jD4.i);
        CoordinatorLayout root = C18041nz2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    /* renamed from: R8, reason: from getter */
    public final BF6 getSmilesActionListener() {
        return this.smilesActionListener;
    }

    public final boolean S8() {
        return A6() || A5() == null || v6() || !u6() || o6() == null;
    }

    @Override // androidx.fragment.app.Fragment
    public void T6() {
        C15225jD4.b().e(this, C15225jD4.i);
        super.T6();
    }

    public final void Y8() {
        if (S8()) {
            return;
        }
        P8().m1();
    }

    @Override // ir.nasim.DF6
    public boolean a() {
        if (this.state != b.a) {
            return false;
        }
        d9(b.b);
        return true;
    }

    public final void a9(BF6 bf6) {
        this.smilesActionListener = bf6;
    }

    public final void b9(CF6 cf6) {
        this.smilesKeyboardListener = cf6;
    }

    public final void c9(EF6 ef6) {
        this.smilesPanelListener = ef6;
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        AbstractC13042fc3.i(args, "args");
        if (id == C15225jD4.i) {
            O8().e.postInvalidate();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h7() {
        EF6 ef6 = this.smilesPanelListener;
        if (ef6 != null) {
            ef6.a(true);
        }
        super.h7();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        j9();
        f9();
        i9();
        T8();
    }

    @Override // ir.nasim.DF6
    public void o4() {
        d9(b.a);
    }

    @Override // ir.nasim.DF6
    public void onClose() {
        if (this.state == b.a) {
            d9(b.b);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        O8().e.postDelayed(new Runnable() { // from class: ir.nasim.l62
            @Override // java.lang.Runnable
            public final void run() {
                C18111o62.W8(this.a);
            }
        }, 100L);
    }

    /* renamed from: ir.nasim.o62$t */
    public static final class t implements TabLayout.d {
        t() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            C18111o62.this.O8().e.stopScroll();
            QK5 qk5 = C18111o62.this.emojiScrollHelper;
            if (qk5 != null) {
                qk5.h();
            }
            C18111o62.this.Z8(C18111o62.this.P8().g1(gVar != null ? gVar.g() : 0), AbstractC7426Rr.a.f(-1.0f));
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    /* renamed from: ir.nasim.o62$m */
    public static final class m implements TextWatcher {
        m() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String string;
            T62 t62P8 = C18111o62.this.P8();
            if (editable == null || (string = editable.toString()) == null) {
                string = "";
            }
            t62P8.o1(string);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
