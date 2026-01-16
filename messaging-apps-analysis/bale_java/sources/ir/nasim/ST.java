package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.designsystem.adapters.BottomSheetListView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001\"B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010%R\u001c\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010%R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010%¨\u0006<"}, d2 = {"Lir/nasim/ST;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/designsystem/adapters/BottomSheetListView;", "list", "", "oldRowsCount", "newRowsCount", "Lir/nasim/rB7;", "R9", "(Lir/nasim/designsystem/adapters/BottomSheetListView;II)V", "T9", "Landroid/os/Bundle;", "saveInstance", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", ParameterNames.TEXT, "V9", "(Ljava/lang/String;)V", "T6", "underlyingView", "X9", "(Landroid/view/View;)V", "", "a", "()Z", "c1", "Z", ContactEntity.COLUMN_IS_BOT, "d1", "isGroup", "e1", "isChannel", "Lir/nasim/DY2;", "f1", "Lir/nasim/DY2;", "autocompleteAdapter", "g1", "Lir/nasim/designsystem/adapters/BottomSheetListView;", "autocompleteList", "h1", "Landroid/view/View;", "i1", "isAutocompleteVisible", "j1", TokenNames.I, "gravity", "k1", "showMyUid", "l1", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ST extends C22042ua0 {

    /* renamed from: l1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private boolean isBot;

    /* renamed from: d1, reason: from kotlin metadata */
    private boolean isGroup;

    /* renamed from: e1, reason: from kotlin metadata */
    private boolean isChannel;

    /* renamed from: f1, reason: from kotlin metadata */
    private DY2 autocompleteAdapter;

    /* renamed from: g1, reason: from kotlin metadata */
    private BottomSheetListView autocompleteList;

    /* renamed from: h1, reason: from kotlin metadata */
    private View underlyingView;

    /* renamed from: i1, reason: from kotlin metadata */
    private boolean isAutocompleteVisible;

    /* renamed from: j1, reason: from kotlin metadata */
    private int gravity = 80;

    /* renamed from: k1, reason: from kotlin metadata */
    private boolean showMyUid;

    /* renamed from: ir.nasim.ST$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ST b(Companion companion, C11458d25 c11458d25, ExPeerType exPeerType, int i, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = 80;
            }
            if ((i2 & 8) != 0) {
                z = false;
            }
            return companion.a(c11458d25, exPeerType, i, z);
        }

        public final ST a(C11458d25 c11458d25, ExPeerType exPeerType, int i, boolean z) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            ST st = new ST();
            Bundle bundle = new Bundle();
            bundle.putLong("peer", c11458d25.u());
            bundle.putInt(DialogEntity.COLUMN_EX_PEER_TYPE, exPeerType.getValue());
            bundle.putInt("gravity", i);
            bundle.putBoolean("showMyUid", z);
            st.a8(bundle);
            return st;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private final void R9(final BottomSheetListView list, final int oldRowsCount, final int newRowsCount) {
        list.post(new Runnable() { // from class: ir.nasim.PT
            @Override // java.lang.Runnable
            public final void run() {
                ST.S9(newRowsCount, oldRowsCount, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(int i, int i2, BottomSheetListView bottomSheetListView) {
        int iA;
        int iA2;
        AbstractC13042fc3.i(bottomSheetListView, "$list");
        if (i == i2) {
            return;
        }
        if (i != 0) {
            int i3 = 1;
            if (i != 1) {
                i3 = 2;
                if (i != 2) {
                    iA = C22078ud6.a(122.0f);
                } else {
                    iA2 = C22078ud6.a(96.0f);
                }
            } else {
                iA2 = C22078ud6.a(48.0f);
            }
            iA = iA2 + i3;
        } else {
            iA = 0;
        }
        bottomSheetListView.setMinHeight(iA);
        bottomSheetListView.setVisibility(0);
    }

    private final void T9() {
        BottomSheetListView bottomSheetListView;
        if (this.isAutocompleteVisible) {
            this.isAutocompleteVisible = false;
            DY2 dy2 = this.autocompleteAdapter;
            if (dy2 == null || (bottomSheetListView = this.autocompleteList) == null) {
                return;
            }
            R9(bottomSheetListView, dy2.getCount(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(ST st, AdapterView adapterView, View view, int i, long j) {
        OT ot;
        AbstractC13042fc3.i(st, "this$0");
        DY2 dy2 = st.autocompleteAdapter;
        Object item = dy2 != null ? dy2.getItem(i) : null;
        if (!(item instanceof Y34)) {
            if (item instanceof C24488yi0) {
                String strC = ((C24488yi0) item).c();
                androidx.lifecycle.h hVarU5 = st.U5();
                boolean z = hVarU5 instanceof OT;
                if (z) {
                    ot = z ? (OT) hVarU5 : null;
                    if (ot != null) {
                        ot.H0(strC);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        Y34 y34 = (Y34) item;
        String strB = y34.b();
        int iE = y34.e();
        androidx.lifecycle.h hVarU52 = st.U5();
        boolean z2 = hVarU52 instanceof OT;
        if (z2) {
            ot = z2 ? (OT) hVarU52 : null;
            if (ot != null) {
                AbstractC13042fc3.f(strB);
                String strF = y34.f();
                if (strF == null) {
                    strF = "";
                }
                ot.Z4(iE, strB, strF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(ST st, BottomSheetListView bottomSheetListView, int i) {
        AbstractC13042fc3.i(st, "this$0");
        AbstractC13042fc3.i(bottomSheetListView, "$autoCompleteList");
        st.R9(bottomSheetListView, i, bottomSheetListView.getCount());
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle saveInstance) {
        boolean z;
        super.M6(saveInstance);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            C11458d25 c11458d25R = C11458d25.r(bundleE5.getLong("peer"));
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            ExPeerType exPeerTypeFromValue = ExPeerType.fromValue(bundleE5.getInt(DialogEntity.COLUMN_EX_PEER_TYPE));
            AbstractC13042fc3.h(exPeerTypeFromValue, "fromValue(...)");
            this.gravity = bundleE5.getInt("gravity");
            this.showMyUid = bundleE5.getBoolean("showMyUid");
            this.autocompleteAdapter = null;
            if (c11458d25R.s() == W25.a) {
                z = exPeerTypeFromValue == ExPeerType.BOT;
                this.isBot = z;
                if (z) {
                    int peerId = c11458d25R.getPeerId();
                    Context contextS7 = S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    this.autocompleteAdapter = new C16010kZ0(peerId, contextS7);
                    return;
                }
                return;
            }
            if (c11458d25R.s() == W25.b) {
                this.isGroup = true;
                z = exPeerTypeFromValue == ExPeerType.CHANNEL;
                this.isChannel = z;
                if (z) {
                    return;
                }
                int peerId2 = c11458d25R.getPeerId();
                Context contextS72 = S7();
                AbstractC13042fc3.h(contextS72, "requireContext(...)");
                this.autocompleteAdapter = new C15138j44(peerId2, contextS72, this.showMyUid);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        BottomSheetListView bottomSheetListView = new BottomSheetListView(contextS7, null, 0, this.gravity, 6, null);
        bottomSheetListView.setVisibility(4);
        bottomSheetListView.setUnderlyingView(this.underlyingView);
        bottomSheetListView.setDivider(null);
        bottomSheetListView.setDividerHeight(0);
        bottomSheetListView.setBackgroundColor(0);
        DY2 dy2 = this.autocompleteAdapter;
        if (dy2 != null) {
            bottomSheetListView.setAdapter((ListAdapter) dy2);
            bottomSheetListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ir.nasim.QT
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    ST.U9(this.a, adapterView, view, i, j);
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        bottomSheetListView.setLayoutParams(layoutParams);
        this.autocompleteList = bottomSheetListView;
        return bottomSheetListView;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        DY2 dy2 = this.autocompleteAdapter;
        if (dy2 != null) {
            dy2.b();
        }
        this.autocompleteList = null;
    }

    public final void V9(String text) {
        AbstractC13042fc3.i(text, ParameterNames.TEXT);
        final BottomSheetListView bottomSheetListView = this.autocompleteList;
        if (bottomSheetListView == null) {
            return;
        }
        if (this.isBot) {
            if (!AbstractC20153rZ6.S(text, Separators.SLASH, false, 2, null)) {
                this.isAutocompleteVisible = false;
                int count = bottomSheetListView.getCount();
                DY2 dy2 = this.autocompleteAdapter;
                C16010kZ0 c16010kZ0 = dy2 instanceof C16010kZ0 ? (C16010kZ0) dy2 : null;
                if (c16010kZ0 != null) {
                    c16010kZ0.f();
                }
                R9(bottomSheetListView, count, bottomSheetListView.getCount());
                return;
            }
            this.isAutocompleteVisible = true;
            String strSubstring = text.substring(1);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            int count2 = bottomSheetListView.getCount();
            DY2 dy22 = this.autocompleteAdapter;
            C16010kZ0 c16010kZ02 = dy22 instanceof C16010kZ0 ? (C16010kZ0) dy22 : null;
            if (c16010kZ02 != null) {
                c16010kZ02.i(strSubstring);
            }
            R9(bottomSheetListView, count2, bottomSheetListView.getCount());
            return;
        }
        if (!this.isGroup || this.isChannel) {
            return;
        }
        if (!AbstractC20153rZ6.S(text, Separators.AT, false, 2, null)) {
            this.isAutocompleteVisible = false;
            int count3 = bottomSheetListView.getCount();
            DY2 dy23 = this.autocompleteAdapter;
            C15138j44 c15138j44 = dy23 instanceof C15138j44 ? (C15138j44) dy23 : null;
            if (c15138j44 != null) {
                c15138j44.i();
            }
            R9(bottomSheetListView, count3, bottomSheetListView.getCount());
            return;
        }
        this.isAutocompleteVisible = true;
        String strSubstring2 = text.substring(1);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        final int count4 = bottomSheetListView.getCount();
        DY2 dy24 = this.autocompleteAdapter;
        if (dy24 == null) {
            return;
        }
        C15138j44 c15138j442 = dy24 instanceof C15138j44 ? (C15138j44) dy24 : null;
        if (c15138j442 != null) {
            c15138j442.l(strSubstring2, new Runnable() { // from class: ir.nasim.RT
                @Override // java.lang.Runnable
                public final void run() {
                    ST.W9(this.a, bottomSheetListView, count4);
                }
            });
        }
    }

    public final void X9(View underlyingView) {
        this.underlyingView = underlyingView;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        if (!this.isAutocompleteVisible) {
            return false;
        }
        T9();
        return true;
    }
}
