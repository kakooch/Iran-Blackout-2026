package ir.nasim.features.conversation;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C14486i0;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C8138Ur4;
import ir.nasim.DialogC7946Tw1;
import ir.nasim.EM2;
import ir.nasim.EnumC15673jy7;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.InterfaceC7197Qr4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.features.conversation.NewAdvancedForward;
import ir.nasim.features.conversation.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001KBS\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\"\u0010\u001eJ\u000f\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010!J\u000f\u0010$\u001a\u00020\u0011H\u0002¢\u0006\u0004\b$\u0010!J\u000f\u0010%\u001a\u00020\u0011H\u0002¢\u0006\u0004\b%\u0010!J\u0017\u0010&\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b&\u0010\u001eJ7\u0010.\u001a\u00020(2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u00102J\u0017\u00104\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0011H\u0016¢\u0006\u0004\b6\u0010!J\r\u00107\u001a\u00020\u0011¢\u0006\u0004\b7\u0010!J\u000f\u00108\u001a\u00020\u0011H\u0016¢\u0006\u0004\b8\u0010!J\u000f\u00109\u001a\u00020\u0011H\u0016¢\u0006\u0004\b9\u0010!J7\u0010>\u001a\u00020\u00112\u0006\u0010;\u001a\u00020:2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010B\u001a\u00020\u00112\u0006\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020+H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\u00112\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\u00112\u0006\u0010H\u001a\u00020+H\u0016¢\u0006\u0004\bI\u0010JR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010OR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010%R(\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010PR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010 R\u001b\u0010Y\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010k\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\bj\u0010%R\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010V\u001a\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010\u0015R\u0016\u0010t\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010%R\u0016\u0010v\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010%R\u0016\u0010x\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010%R#\u0010\u0080\u0001\u001a\u00020y8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u0019\u0010\u0083\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u008d\u0001"}, d2 = {"Lir/nasim/features/conversation/NewAdvancedForward;", "Landroid/widget/RelativeLayout;", "Lir/nasim/Qr4;", "Lir/nasim/m0;", "Lir/nasim/features/conversation/b$a;", "Landroid/content/Context;", "context", "Lir/nasim/d25;", "forwardedPeer", "", "Lir/nasim/J44;", "messages", "Landroid/widget/LinearLayout;", "bottomView", "", "shouldShowToast", "Lkotlin/Function1;", "Lir/nasim/rB7;", "successCallback", "<init>", "(Landroid/content/Context;Lir/nasim/d25;Ljava/util/List;Landroid/widget/LinearLayout;ZLir/nasim/UA2;)V", TokenNames.I, "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "setupAdvancedForwardView", "(Landroid/view/LayoutInflater;)V", "Landroid/view/View;", "res", TokenNames.L, "(Landroid/view/View;)V", TokenNames.S, "J", "()V", "setupForwardAdapter", "Y", "a0", "Z", "N", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "peerList", "", "resForMulti", "resForSingular", "H", "(Ljava/util/ArrayList;II)Ljava/lang/String;", "peer", "e", "(Lir/nasim/d25;)Z", "c", "d", "(Lir/nasim/d25;)V", "q0", TokenNames.E, "B3", "R2", "Lir/nasim/jy7;", "type", "Lir/nasim/EM2;", "status", "c0", "(Lir/nasim/jy7;Ljava/util/ArrayList;Lir/nasim/EM2;)V", "positionStart", "itemCount", "n0", "(II)V", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", ParameterNames.TEXT, "L2", "(I)V", "a", "Lir/nasim/d25;", "b", "Ljava/util/List;", "Landroid/widget/LinearLayout;", "Lir/nasim/UA2;", "", "f", "lastActionClickTime", "Lir/nasim/features/conversation/b;", "g", "Lir/nasim/Yu3;", "getNewForwardAdapter", "()Lir/nasim/features/conversation/b;", "newForwardAdapter", "Lir/nasim/Ur4;", "h", "Lir/nasim/Ur4;", "presenter", "Lcom/google/android/material/textfield/TextInputEditText;", "i", "Lcom/google/android/material/textfield/TextInputEditText;", "searchField", "Landroid/widget/ImageButton;", "j", "Landroid/widget/ImageButton;", "cancelSearch", "Landroidx/recyclerview/widget/RecyclerView;", "k", "Landroidx/recyclerview/widget/RecyclerView;", "gridView", "l", "isHalfExpanded", "Lir/nasim/features/conversation/CustomGridLayoutManager;", "m", "getCustomGridLayoutManager", "()Lir/nasim/features/conversation/CustomGridLayoutManager;", "customGridLayoutManager", "n", "lastTopAnchor", "o", "isExpanding", "p", "isHalfExpanding", "q", "isDismissing", "Lir/nasim/Tw1;", "r", "Lir/nasim/Tw1;", "getParentDialog", "()Lir/nasim/Tw1;", "setParentDialog", "(Lir/nasim/Tw1;)V", "parentDialog", "s", "Landroid/view/View;", "actionButton", "Landroid/widget/EditText;", "t", "Landroid/widget/EditText;", "forwardText", "Ljava/lang/Runnable;", "u", "Ljava/lang/Runnable;", "updateListRunnable", "v", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class NewAdvancedForward extends RelativeLayout implements InterfaceC7197Qr4, InterfaceC16866m0, b.a {
    public static final int w = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final C11458d25 forwardedPeer;

    /* renamed from: b, reason: from kotlin metadata */
    private final List messages;

    /* renamed from: c, reason: from kotlin metadata */
    private final LinearLayout bottomView;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean shouldShowToast;

    /* renamed from: e, reason: from kotlin metadata */
    private final UA2 successCallback;

    /* renamed from: f, reason: from kotlin metadata */
    private long lastActionClickTime;

    /* renamed from: g, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 newForwardAdapter;

    /* renamed from: h, reason: from kotlin metadata */
    private C8138Ur4 presenter;

    /* renamed from: i, reason: from kotlin metadata */
    private TextInputEditText searchField;

    /* renamed from: j, reason: from kotlin metadata */
    private ImageButton cancelSearch;

    /* renamed from: k, reason: from kotlin metadata */
    private RecyclerView gridView;

    /* renamed from: l, reason: from kotlin metadata */
    private final boolean isHalfExpanded;

    /* renamed from: m, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 customGridLayoutManager;

    /* renamed from: n, reason: from kotlin metadata */
    private int lastTopAnchor;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isExpanding;

    /* renamed from: p, reason: from kotlin metadata */
    private boolean isHalfExpanding;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean isDismissing;

    /* renamed from: r, reason: from kotlin metadata */
    public DialogC7946Tw1 parentDialog;

    /* renamed from: s, reason: from kotlin metadata */
    private View actionButton;

    /* renamed from: t, reason: from kotlin metadata */
    private EditText forwardText;

    /* renamed from: u, reason: from kotlin metadata */
    private final Runnable updateListRunnable;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC15673jy7.values().length];
            try {
                iArr[EnumC15673jy7.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC15673jy7.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC15673jy7.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
            C8138Ur4 c8138Ur4 = NewAdvancedForward.this.presenter;
            if (c8138Ur4 == null) {
                AbstractC13042fc3.y("presenter");
                c8138Ur4 = null;
            }
            c8138Ur4.o(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
            int i4 = i + i3;
            C8138Ur4 c8138Ur4 = null;
            TextInputEditText textInputEditText = null;
            if (i4 <= 0) {
                ImageButton imageButton = NewAdvancedForward.this.cancelSearch;
                if (imageButton == null) {
                    AbstractC13042fc3.y("cancelSearch");
                    imageButton = null;
                }
                imageButton.setVisibility(4);
                C8138Ur4 c8138Ur42 = NewAdvancedForward.this.presenter;
                if (c8138Ur42 == null) {
                    AbstractC13042fc3.y("presenter");
                } else {
                    c8138Ur4 = c8138Ur42;
                }
                c8138Ur4.r();
                NewAdvancedForward.this.B3();
                return;
            }
            ImageButton imageButton2 = NewAdvancedForward.this.cancelSearch;
            if (imageButton2 == null) {
                AbstractC13042fc3.y("cancelSearch");
                imageButton2 = null;
            }
            imageButton2.setVisibility(0);
            C8138Ur4 c8138Ur43 = NewAdvancedForward.this.presenter;
            if (c8138Ur43 == null) {
                AbstractC13042fc3.y("presenter");
                c8138Ur43 = null;
            }
            c8138Ur43.s();
            TextInputEditText textInputEditText2 = NewAdvancedForward.this.searchField;
            if (textInputEditText2 == null) {
                AbstractC13042fc3.y("searchField");
                textInputEditText2 = null;
            }
            if (!textInputEditText2.hasFocus()) {
                TextInputEditText textInputEditText3 = NewAdvancedForward.this.searchField;
                if (textInputEditText3 == null) {
                    AbstractC13042fc3.y("searchField");
                } else {
                    textInputEditText = textInputEditText3;
                }
                textInputEditText.requestFocus();
            }
            NewAdvancedForward.this.B3();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }
    }

    public static final class d implements RecyclerView.s {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AbstractC13042fc3.i(recyclerView, "rv");
            AbstractC13042fc3.i(motionEvent, "e");
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
        @Override // androidx.recyclerview.widget.RecyclerView.s
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean c(androidx.recyclerview.widget.RecyclerView r3, android.view.MotionEvent r4) {
            /*
                r2 = this;
                java.lang.String r0 = "rv"
                ir.nasim.AbstractC13042fc3.i(r3, r0)
                java.lang.String r3 = "e"
                ir.nasim.AbstractC13042fc3.i(r4, r3)
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                int r3 = ir.nasim.features.conversation.NewAdvancedForward.t(r3)
                r4 = -1
                r0 = 0
                java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewGroup"
                if (r3 != r4) goto L2c
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                android.view.ViewParent r4 = r3.getParent()
                ir.nasim.AbstractC13042fc3.g(r4, r1)
                android.view.ViewGroup r4 = (android.view.ViewGroup) r4
                int r4 = r4.getTop()
                int r4 = r4 + 50
                ir.nasim.features.conversation.NewAdvancedForward.A(r3, r4)
                goto Lce
            L2c:
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                boolean r3 = ir.nasim.features.conversation.NewAdvancedForward.x(r3)
                if (r3 != 0) goto L62
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                boolean r3 = ir.nasim.features.conversation.NewAdvancedForward.y(r3)
                if (r3 == 0) goto L62
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                int r3 = ir.nasim.features.conversation.NewAdvancedForward.t(r3)
                ir.nasim.features.conversation.NewAdvancedForward r4 = ir.nasim.features.conversation.NewAdvancedForward.this
                android.view.ViewParent r4 = r4.getParent()
                ir.nasim.AbstractC13042fc3.g(r4, r1)
                android.view.ViewGroup r4 = (android.view.ViewGroup) r4
                int r4 = r4.getTop()
                if (r3 <= r4) goto L62
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                ir.nasim.features.conversation.CustomGridLayoutManager r3 = ir.nasim.features.conversation.NewAdvancedForward.s(r3)
                r3.m3(r0)
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                ir.nasim.features.conversation.NewAdvancedForward.C(r3)
                goto Lce
            L62:
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                boolean r3 = ir.nasim.features.conversation.NewAdvancedForward.z(r3)
                if (r3 != 0) goto L99
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                boolean r3 = ir.nasim.features.conversation.NewAdvancedForward.y(r3)
                if (r3 != 0) goto L99
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                int r3 = ir.nasim.features.conversation.NewAdvancedForward.t(r3)
                ir.nasim.features.conversation.NewAdvancedForward r4 = ir.nasim.features.conversation.NewAdvancedForward.this
                android.view.ViewParent r4 = r4.getParent()
                ir.nasim.AbstractC13042fc3.g(r4, r1)
                android.view.ViewGroup r4 = (android.view.ViewGroup) r4
                int r4 = r4.getTop()
                if (r3 >= r4) goto L99
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                ir.nasim.features.conversation.CustomGridLayoutManager r3 = ir.nasim.features.conversation.NewAdvancedForward.s(r3)
                r4 = 1
                r3.m3(r4)
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                ir.nasim.features.conversation.NewAdvancedForward.D(r3)
                goto Lce
            L99:
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                boolean r3 = ir.nasim.features.conversation.NewAdvancedForward.w(r3)
                if (r3 != 0) goto Lce
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                boolean r3 = ir.nasim.features.conversation.NewAdvancedForward.y(r3)
                if (r3 == 0) goto Lce
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                int r3 = ir.nasim.features.conversation.NewAdvancedForward.t(r3)
                ir.nasim.features.conversation.NewAdvancedForward r4 = ir.nasim.features.conversation.NewAdvancedForward.this
                android.view.ViewParent r4 = r4.getParent()
                ir.nasim.AbstractC13042fc3.g(r4, r1)
                android.view.ViewGroup r4 = (android.view.ViewGroup) r4
                int r4 = r4.getTop()
                if (r3 >= r4) goto Lce
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                ir.nasim.features.conversation.NewAdvancedForward.B(r3)
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                ir.nasim.features.conversation.CustomGridLayoutManager r3 = ir.nasim.features.conversation.NewAdvancedForward.s(r3)
                r3.m3(r0)
            Lce:
                ir.nasim.features.conversation.NewAdvancedForward r3 = ir.nasim.features.conversation.NewAdvancedForward.this
                android.view.ViewParent r4 = r3.getParent()
                ir.nasim.AbstractC13042fc3.g(r4, r1)
                android.view.ViewGroup r4 = (android.view.ViewGroup) r4
                int r4 = r4.getTop()
                ir.nasim.features.conversation.NewAdvancedForward.A(r3, r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.conversation.NewAdvancedForward.d.c(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewAdvancedForward(final Context context, C11458d25 c11458d25, List list, LinearLayout linearLayout, boolean z, UA2 ua2) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c11458d25, "forwardedPeer");
        AbstractC13042fc3.i(list, "messages");
        AbstractC13042fc3.i(linearLayout, "bottomView");
        this.forwardedPeer = c11458d25;
        this.messages = list;
        this.bottomView = linearLayout;
        this.shouldShowToast = z;
        this.successCallback = ua2;
        this.newForwardAdapter = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Lr4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewAdvancedForward.U(context, this);
            }
        });
        this.customGridLayoutManager = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Mr4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewAdvancedForward.G(context);
            }
        });
        this.lastTopAnchor = -1;
        I(context);
        this.updateListRunnable = new Runnable() { // from class: ir.nasim.Nr4
            @Override // java.lang.Runnable
            public final void run() {
                NewAdvancedForward.b0(this.a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomGridLayoutManager G(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new CustomGridLayoutManager(context, 5);
    }

    private final String H(ArrayList peerList, int resForMulti, int resForSingular) {
        if (peerList.size() <= 1) {
            String string = getContext().getString(resForSingular);
            AbstractC13042fc3.f(string);
            return string;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = peerList.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            sb.append(getContext().getString(AbstractC12217eE5.group));
            sb.append(Separators.SP);
            sb.append((String) next);
            sb.append(Separators.SP);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        String string2 = getContext().getString(resForMulti);
        AbstractC13042fc3.h(string2, "getString(...)");
        String string3 = sb.toString();
        AbstractC13042fc3.h(string3, "toString(...)");
        return AbstractC20153rZ6.M(string2, "{0}", string3, false, 4, null);
    }

    private final void I(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.presenter = new C8138Ur4(this);
        setupAdvancedForwardView((LayoutInflater) systemService);
    }

    private final void J() {
        this.forwardText = (EditText) this.bottomView.findViewById(BC5.et_message);
        View viewFindViewById = this.bottomView.findViewById(BC5.ib_send);
        this.actionButton = viewFindViewById;
        if (viewFindViewById == null) {
            AbstractC13042fc3.y("actionButton");
            viewFindViewById = null;
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Gr4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewAdvancedForward.K(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(NewAdvancedForward newAdvancedForward, View view) {
        C8138Ur4 c8138Ur4;
        AbstractC13042fc3.i(newAdvancedForward, "this$0");
        if (System.currentTimeMillis() - newAdvancedForward.lastActionClickTime < 1000) {
            return;
        }
        newAdvancedForward.lastActionClickTime = System.currentTimeMillis();
        C8138Ur4 c8138Ur42 = newAdvancedForward.presenter;
        EditText editText = null;
        if (c8138Ur42 == null) {
            AbstractC13042fc3.y("presenter");
            c8138Ur4 = null;
        } else {
            c8138Ur4 = c8138Ur42;
        }
        C11458d25 c11458d25 = newAdvancedForward.forwardedPeer;
        List list = newAdvancedForward.messages;
        EditText editText2 = newAdvancedForward.forwardText;
        if (editText2 == null) {
            AbstractC13042fc3.y("forwardText");
        } else {
            editText = editText2;
        }
        c8138Ur4.n(c11458d25, list, editText.getText().toString(), newAdvancedForward.shouldShowToast, newAdvancedForward.successCallback);
    }

    private final void L(View res) {
        res.findViewById(BC5.close_compose).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Hr4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewAdvancedForward.M(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(NewAdvancedForward newAdvancedForward, View view) {
        AbstractC13042fc3.i(newAdvancedForward, "this$0");
        newAdvancedForward.getParentDialog().f();
    }

    private final void N(View res) {
        ImageButton imageButton = (ImageButton) res.findViewById(BC5.cancel_search);
        this.cancelSearch = imageButton;
        TextInputEditText textInputEditText = null;
        if (imageButton == null) {
            AbstractC13042fc3.y("cancelSearch");
            imageButton = null;
        }
        imageButton.setVisibility(4);
        ImageButton imageButton2 = this.cancelSearch;
        if (imageButton2 == null) {
            AbstractC13042fc3.y("cancelSearch");
            imageButton2 = null;
        }
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ir4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewAdvancedForward.O(this.a, view);
            }
        });
        ((ImageButton) res.findViewById(BC5.search_icon)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Jr4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewAdvancedForward.Q(this.a, view);
            }
        });
        TextInputEditText textInputEditText2 = (TextInputEditText) res.findViewById(BC5.search_field);
        this.searchField = textInputEditText2;
        if (textInputEditText2 == null) {
            AbstractC13042fc3.y("searchField");
            textInputEditText2 = null;
        }
        textInputEditText2.setTypeface(C6011Lu2.k());
        TextInputEditText textInputEditText3 = this.searchField;
        if (textInputEditText3 == null) {
            AbstractC13042fc3.y("searchField");
            textInputEditText3 = null;
        }
        textInputEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.Kr4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                NewAdvancedForward.R(this.a, view, z);
            }
        });
        TextInputEditText textInputEditText4 = this.searchField;
        if (textInputEditText4 == null) {
            AbstractC13042fc3.y("searchField");
        } else {
            textInputEditText = textInputEditText4;
        }
        textInputEditText.addTextChangedListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(NewAdvancedForward newAdvancedForward, View view) {
        AbstractC13042fc3.i(newAdvancedForward, "this$0");
        C8138Ur4 c8138Ur4 = newAdvancedForward.presenter;
        TextInputEditText textInputEditText = null;
        if (c8138Ur4 == null) {
            AbstractC13042fc3.y("presenter");
            c8138Ur4 = null;
        }
        c8138Ur4.r();
        TextInputEditText textInputEditText2 = newAdvancedForward.searchField;
        if (textInputEditText2 == null) {
            AbstractC13042fc3.y("searchField");
            textInputEditText2 = null;
        }
        textInputEditText2.setText("");
        TextInputEditText textInputEditText3 = newAdvancedForward.searchField;
        if (textInputEditText3 == null) {
            AbstractC13042fc3.y("searchField");
        } else {
            textInputEditText = textInputEditText3;
        }
        textInputEditText.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(NewAdvancedForward newAdvancedForward, View view) {
        AbstractC13042fc3.i(newAdvancedForward, "this$0");
        C8138Ur4 c8138Ur4 = newAdvancedForward.presenter;
        TextInputEditText textInputEditText = null;
        if (c8138Ur4 == null) {
            AbstractC13042fc3.y("presenter");
            c8138Ur4 = null;
        }
        TextInputEditText textInputEditText2 = newAdvancedForward.searchField;
        if (textInputEditText2 == null) {
            AbstractC13042fc3.y("searchField");
        } else {
            textInputEditText = textInputEditText2;
        }
        c8138Ur4.o(String.valueOf(textInputEditText.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(NewAdvancedForward newAdvancedForward, View view, boolean z) {
        AbstractC13042fc3.i(newAdvancedForward, "this$0");
        if (z) {
            C8138Ur4 c8138Ur4 = newAdvancedForward.presenter;
            if (c8138Ur4 == null) {
                AbstractC13042fc3.y("presenter");
                c8138Ur4 = null;
            }
            c8138Ur4.s();
        }
    }

    private final void S(View res) {
        TextView textView = (TextView) res.findViewById(BC5.compose_title);
        textView.setTextColor(C5495Jo7.a.g0());
        textView.setTextSize(18.0f);
        textView.setTypeface(C6011Lu2.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.conversation.b U(Context context, NewAdvancedForward newAdvancedForward) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(newAdvancedForward, "this$0");
        C8138Ur4 c8138Ur4 = newAdvancedForward.presenter;
        if (c8138Ur4 == null) {
            AbstractC13042fc3.y("presenter");
            c8138Ur4 = null;
        }
        return new ir.nasim.features.conversation.b(context, c8138Ur4.q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void V(ir.nasim.EnumC15673jy7 r2, ir.nasim.EM2 r3, ir.nasim.features.conversation.NewAdvancedForward r4, java.util.ArrayList r5) {
        /*
            java.lang.String r0 = "$type"
            ir.nasim.AbstractC13042fc3.i(r2, r0)
            java.lang.String r0 = "$status"
            ir.nasim.AbstractC13042fc3.i(r3, r0)
            java.lang.String r0 = "this$0"
            ir.nasim.AbstractC13042fc3.i(r4, r0)
            java.lang.String r0 = "$peerList"
            ir.nasim.AbstractC13042fc3.i(r5, r0)
            int[] r0 = ir.nasim.features.conversation.NewAdvancedForward.b.a
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            if (r2 == r0) goto L5f
            r1 = 2
            if (r2 == r1) goto L45
            r1 = 3
            if (r2 != r1) goto L3f
            ir.nasim.EM2 r2 = ir.nasim.EM2.b
            if (r3 != r2) goto L32
            int r2 = ir.nasim.AbstractC12217eE5.your_multi_group_send_sticker_permission_denied
            int r3 = ir.nasim.AbstractC12217eE5.your_single_group_send_sticker_permission_denied
            java.lang.String r2 = r4.H(r5, r2, r3)
            goto L7a
        L32:
            ir.nasim.EM2 r2 = ir.nasim.EM2.c
            if (r3 != r2) goto L79
            int r2 = ir.nasim.AbstractC12217eE5.default_multi_group_send_sticker_permission_denied
            int r3 = ir.nasim.AbstractC12217eE5.default_single_group_send_sticker_permission_denied
            java.lang.String r2 = r4.H(r5, r2, r3)
            goto L7a
        L3f:
            kotlin.NoWhenBranchMatchedException r2 = new kotlin.NoWhenBranchMatchedException
            r2.<init>()
            throw r2
        L45:
            ir.nasim.EM2 r2 = ir.nasim.EM2.b
            if (r3 != r2) goto L52
            int r2 = ir.nasim.AbstractC12217eE5.your_multi_group_send_media_permission_denied
            int r3 = ir.nasim.AbstractC12217eE5.your_single_group_send_media_permission_denied
            java.lang.String r2 = r4.H(r5, r2, r3)
            goto L7a
        L52:
            ir.nasim.EM2 r2 = ir.nasim.EM2.c
            if (r3 != r2) goto L79
            int r2 = ir.nasim.AbstractC12217eE5.default_multi_group_send_media_permission_denied
            int r3 = ir.nasim.AbstractC12217eE5.default_single_group_send_media_permission_denied
            java.lang.String r2 = r4.H(r5, r2, r3)
            goto L7a
        L5f:
            ir.nasim.EM2 r2 = ir.nasim.EM2.b
            if (r3 != r2) goto L6c
            int r2 = ir.nasim.AbstractC12217eE5.your_multi_group_send_both_permission_denied
            int r3 = ir.nasim.AbstractC12217eE5.your_single_group_send_both_permission_denied
            java.lang.String r2 = r4.H(r5, r2, r3)
            goto L7a
        L6c:
            ir.nasim.EM2 r2 = ir.nasim.EM2.c
            if (r3 != r2) goto L79
            int r2 = ir.nasim.AbstractC12217eE5.default_multi_group_send_both_permission_denied
            int r3 = ir.nasim.AbstractC12217eE5.default_single_group_send_both_permission_denied
            java.lang.String r2 = r4.H(r5, r2, r3)
            goto L7a
        L79:
            r2 = 0
        L7a:
            ir.nasim.NY r3 = new ir.nasim.NY
            android.content.Context r5 = r4.getContext()
            java.lang.String r1 = "getContext(...)"
            ir.nasim.AbstractC13042fc3.h(r5, r1)
            r3.<init>(r5)
            android.content.Context r4 = r4.getContext()
            int r5 = ir.nasim.AbstractC12217eE5.multi_group_send_media_permission_denied_title
            java.lang.String r4 = r4.getString(r5)
            ir.nasim.NY r3 = r3.B(r4)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            ir.nasim.NY r2 = r3.i(r2)
            int r3 = ir.nasim.AbstractC12217eE5.dialog_ok
            ir.nasim.NY r2 = r2.w(r3)
            r3 = 4
            ir.nasim.NY r2 = r2.k(r3)
            ir.nasim.NY r2 = r2.E(r3)
            int r3 = ir.nasim.KB5.ic_card_payment_ba_error_dialog_icon
            ir.nasim.NY r2 = r2.p(r3)
            ir.nasim.NY r2 = r2.f(r0)
            ir.nasim.MY r2 = r2.a()
            r2.z()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.conversation.NewAdvancedForward.V(ir.nasim.jy7, ir.nasim.EM2, ir.nasim.features.conversation.NewAdvancedForward, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(NewAdvancedForward newAdvancedForward, int i) {
        AbstractC13042fc3.i(newAdvancedForward, "this$0");
        Toast.makeText(newAdvancedForward.getContext(), i, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        this.isDismissing = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        this.isExpanding = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        this.isHalfExpanding = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(NewAdvancedForward newAdvancedForward) {
        AbstractC13042fc3.i(newAdvancedForward, "this$0");
        C8138Ur4 c8138Ur4 = newAdvancedForward.presenter;
        if (c8138Ur4 == null) {
            AbstractC13042fc3.y("presenter");
            c8138Ur4 = null;
        }
        c8138Ur4.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomGridLayoutManager getCustomGridLayoutManager() {
        return (CustomGridLayoutManager) this.customGridLayoutManager.getValue();
    }

    private final ir.nasim.features.conversation.b getNewForwardAdapter() {
        return (ir.nasim.features.conversation.b) this.newForwardAdapter.getValue();
    }

    private final void setupAdvancedForwardView(LayoutInflater inflater) {
        View viewInflate = inflater.inflate(AbstractC12208eD5.advanced_forward_new, this);
        AbstractC13042fc3.f(viewInflate);
        setupForwardAdapter(viewInflate);
        J();
        S(viewInflate);
        N(viewInflate);
        L(viewInflate);
    }

    private final void setupForwardAdapter(View res) {
        this.gridView = (RecyclerView) res.findViewById(BC5.forward_grid);
        C8138Ur4 c8138Ur4 = this.presenter;
        RecyclerView recyclerView = null;
        if (c8138Ur4 == null) {
            AbstractC13042fc3.y("presenter");
            c8138Ur4 = null;
        }
        c8138Ur4.t();
        getNewForwardAdapter().B(this);
        RecyclerView recyclerView2 = this.gridView;
        if (recyclerView2 == null) {
            AbstractC13042fc3.y("gridView");
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(getNewForwardAdapter());
        RecyclerView recyclerView3 = this.gridView;
        if (recyclerView3 == null) {
            AbstractC13042fc3.y("gridView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(getCustomGridLayoutManager());
        RecyclerView recyclerView4 = this.gridView;
        if (recyclerView4 == null) {
            AbstractC13042fc3.y("gridView");
            recyclerView4 = null;
        }
        recyclerView4.setNestedScrollingEnabled(true);
        RecyclerView recyclerView5 = this.gridView;
        if (recyclerView5 == null) {
            AbstractC13042fc3.y("gridView");
        } else {
            recyclerView = recyclerView5;
        }
        recyclerView.addOnItemTouchListener(new d());
    }

    @Override // ir.nasim.InterfaceC7197Qr4
    public void B3() {
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        aVar.d(this.updateListRunnable);
        aVar.G(this.updateListRunnable, 200L);
    }

    public final void E() {
        TextInputEditText textInputEditText = this.searchField;
        TextInputEditText textInputEditText2 = null;
        if (textInputEditText == null) {
            AbstractC13042fc3.y("searchField");
            textInputEditText = null;
        }
        textInputEditText.clearFocus();
        View view = this.actionButton;
        if (view == null) {
            AbstractC13042fc3.y("actionButton");
            view = null;
        }
        view.clearFocus();
        Object systemService = getContext().getSystemService("input_method");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        TextInputEditText textInputEditText3 = this.searchField;
        if (textInputEditText3 == null) {
            AbstractC13042fc3.y("searchField");
        } else {
            textInputEditText2 = textInputEditText3;
        }
        inputMethodManager.hideSoftInputFromWindow(textInputEditText2.getWindowToken(), 0);
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void L2(final int text) {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.Or4
            @Override // java.lang.Runnable
            public final void run() {
                NewAdvancedForward.X(this.a, text);
            }
        });
    }

    @Override // ir.nasim.InterfaceC7197Qr4
    public void R2() {
        getNewForwardAdapter().notifyDataSetChanged();
    }

    @Override // ir.nasim.features.conversation.b.a
    public boolean c(C11458d25 peer) {
        AbstractC13042fc3.i(peer, "peer");
        C8138Ur4 c8138Ur4 = this.presenter;
        if (c8138Ur4 == null) {
            AbstractC13042fc3.y("presenter");
            c8138Ur4 = null;
        }
        return c8138Ur4.u(peer);
    }

    @Override // ir.nasim.InterfaceC7197Qr4
    public void c0(final EnumC15673jy7 type, final ArrayList peerList, final EM2 status) {
        AbstractC13042fc3.i(type, "type");
        AbstractC13042fc3.i(peerList, "peerList");
        AbstractC13042fc3.i(status, "status");
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.Pr4
            @Override // java.lang.Runnable
            public final void run() {
                NewAdvancedForward.V(type, status, this, peerList);
            }
        });
    }

    @Override // ir.nasim.features.conversation.b.a
    public void d(C11458d25 peer) {
        AbstractC13042fc3.i(peer, "peer");
        C8138Ur4 c8138Ur4 = this.presenter;
        if (c8138Ur4 == null) {
            AbstractC13042fc3.y("presenter");
            c8138Ur4 = null;
        }
        c8138Ur4.A(peer);
    }

    @Override // ir.nasim.features.conversation.b.a
    public boolean e(C11458d25 peer) {
        AbstractC13042fc3.i(peer, "peer");
        C8138Ur4 c8138Ur4 = this.presenter;
        if (c8138Ur4 == null) {
            AbstractC13042fc3.y("presenter");
            c8138Ur4 = null;
        }
        return c8138Ur4.l(peer);
    }

    public final DialogC7946Tw1 getParentDialog() {
        DialogC7946Tw1 dialogC7946Tw1 = this.parentDialog;
        if (dialogC7946Tw1 != null) {
            return dialogC7946Tw1;
        }
        AbstractC13042fc3.y("parentDialog");
        return null;
    }

    @Override // ir.nasim.InterfaceC7197Qr4
    public void n0(int positionStart, int itemCount) {
        getNewForwardAdapter().notifyItemRangeChanged(positionStart, itemCount);
    }

    @Override // ir.nasim.InterfaceC7197Qr4
    public void q0() {
        getParentDialog().f();
    }

    public void setAbolInstance(C14486i0 abol) {
        AbstractC13042fc3.i(abol, "abol");
    }

    public final void setParentDialog(DialogC7946Tw1 dialogC7946Tw1) {
        AbstractC13042fc3.i(dialogC7946Tw1, "<set-?>");
        this.parentDialog = dialogC7946Tw1;
    }
}
