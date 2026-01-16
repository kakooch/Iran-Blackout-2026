package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 Y2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001ZB\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010!\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010\u0005R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00106R\u0014\u0010>\u001a\u0002048\u0002X\u0082D¢\u0006\u0006\n\u0004\b=\u00106R\u0016\u0010@\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00106R\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010P\u001a\u00020I8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010\u0016R\u0014\u0010X\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010W¨\u0006["}, d2 = {"Lir/nasim/fc2;", "Lir/nasim/ua0;", "Lir/nasim/vJ4;", "Lir/nasim/wM2;", "<init>", "()V", "Ljava/util/HashSet;", "allMember", "Lir/nasim/rB7;", "X9", "(Ljava/util/HashSet;)V", "ga", "Ljava/util/ArrayList;", "groupMembers", "Lir/nasim/tK7;", "userVM", "Lir/nasim/Nv5;", "ba", "(Ljava/util/ArrayList;Lir/nasim/tK7;)Lir/nasim/Nv5;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "W9", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "Landroid/os/Bundle;", "saveInstance", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "T6", "groupMember", "la", "(Lir/nasim/wM2;)V", "item", "", "oa", "(Lir/nasim/wM2;)Z", "h7", "Lir/nasim/fy2;", "c1", "Lir/nasim/fy2;", "_binding", "Lir/nasim/iO2;", "d1", "Lir/nasim/iO2;", "groupVM", "", "e1", TokenNames.I, "groupId", "f1", "Ljava/util/ArrayList;", "members", "g1", "checkIndex", "h1", "PAGINATION_SIZE", "i1", "limitSize", "Lir/nasim/E34;", "j1", "Lir/nasim/E34;", "ea", "()Lir/nasim/E34;", "qa", "(Lir/nasim/E34;)V", "membersExceptedAdapter", "Landroidx/recyclerview/widget/RecyclerView$w;", "k1", "Landroidx/recyclerview/widget/RecyclerView$w;", "fa", "()Landroidx/recyclerview/widget/RecyclerView$w;", "ra", "(Landroidx/recyclerview/widget/RecyclerView$w;)V", "recyclerListener", "l1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "da", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "pa", "aa", "()Lir/nasim/fy2;", "binding", "m1", "a", "group_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.fc2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13041fc2 extends C22042ua0 implements InterfaceC22483vJ4 {

    /* renamed from: m1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int n1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private C13286fy2 _binding;

    /* renamed from: d1, reason: from kotlin metadata */
    private C14733iO2 groupVM;

    /* renamed from: e1, reason: from kotlin metadata */
    private int groupId;

    /* renamed from: g1, reason: from kotlin metadata */
    private int checkIndex;

    /* renamed from: j1, reason: from kotlin metadata */
    public E34 membersExceptedAdapter;

    /* renamed from: k1, reason: from kotlin metadata */
    public RecyclerView.w recyclerListener;

    /* renamed from: l1, reason: from kotlin metadata */
    public LinearLayoutManager layoutManager;

    /* renamed from: f1, reason: from kotlin metadata */
    private final ArrayList members = new ArrayList();

    /* renamed from: h1, reason: from kotlin metadata */
    private final int PAGINATION_SIZE = 50;

    /* renamed from: i1, reason: from kotlin metadata */
    private int limitSize = 50;

    /* renamed from: ir.nasim.fc2$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C13041fc2 a(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_GROUP_ID", i);
            C13041fc2 c13041fc2 = new C13041fc2();
            c13041fc2.a8(bundle);
            return c13041fc2;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private final void W9(LinearLayoutManager layoutManager) {
        if (this.checkIndex - layoutManager.g2() < this.PAGINATION_SIZE / 2) {
            ga();
        }
    }

    private final void X9(final HashSet allMember) {
        C9248Zc6 c9248Zc6G = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.ac2
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return C13041fc2.Y9(allMember, this);
            }
        }).h(EnumC11723dV1.IO).f(true).g(new InterfaceC5620Kc6() { // from class: ir.nasim.bc2
            @Override // ir.nasim.InterfaceC5620Kc6
            public final void onSuccess(Object obj) {
                C13041fc2.Z9(this.a, (List) obj);
            }
        });
        AbstractC13042fc3.h(c9248Zc6G, "onSuccess(...)");
        SZ.e(c9248Zc6G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Y9(HashSet hashSet, C13041fc2 c13041fc2) {
        AbstractC13042fc3.i(hashSet, "$allMember");
        AbstractC13042fc3.i(c13041fc2, "this$0");
        ArrayList arrayList = new ArrayList();
        for (Object obj : hashSet) {
            C23104wM2 c23104wM2 = (C23104wM2) obj;
            C14733iO2 c14733iO2 = c13041fc2.groupVM;
            if (c14733iO2 == null || c23104wM2.f() != c14733iO2.x()) {
                if (!c23104wM2.j()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(C13041fc2 c13041fc2, List list) {
        AbstractC13042fc3.i(c13041fc2, "this$0");
        c13041fc2.members.addAll(list);
        c13041fc2.ga();
    }

    private final C13286fy2 aa() {
        C13286fy2 c13286fy2 = this._binding;
        AbstractC13042fc3.f(c13286fy2);
        return c13286fy2;
    }

    private final C6517Nv5 ba(final ArrayList groupMembers, final C21231tK7 userVM) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.ec2
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                C13041fc2.ca(groupMembers, userVM, c7234Qv5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(ArrayList arrayList, C21231tK7 c21231tK7, C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(arrayList, "$groupMembers");
        AbstractC13042fc3.i(c21231tK7, "$userVM");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        Iterator it = arrayList.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            C23104wM2 c23104wM2 = (C23104wM2) next;
            if (c23104wM2.f() == c21231tK7.o()) {
                c23104wM2.l(c21231tK7);
                c7234Qv5.b(c23104wM2);
                return;
            }
        }
        c7234Qv5.a(new Exception("Not Found GroupMember"));
    }

    private final void ga() {
        if (this.checkIndex >= this.members.size()) {
            return;
        }
        aa().e.setVisibility(0);
        final boolean z = this.checkIndex == 0;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        while (this.checkIndex < this.limitSize) {
            int size = this.members.size();
            int i = this.checkIndex;
            if (size <= i) {
                break;
            }
            Object obj = this.members.get(i);
            AbstractC13042fc3.h(obj, "get(...)");
            C23104wM2 c23104wM2 = (C23104wM2) obj;
            arrayList.add(Integer.valueOf(c23104wM2.f()));
            arrayList2.add(c23104wM2);
            this.checkIndex++;
        }
        if (arrayList.size() > 0) {
            this.limitSize += this.PAGINATION_SIZE;
            C5735Kp4.w().i().d1(arrayList);
            AbstractC5969Lp4.d().V0(arrayList).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Zb2
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    C13041fc2.ha(arrayList, this, arrayList2, z, (C14505i18) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(ArrayList arrayList, final C13041fc2 c13041fc2, final ArrayList arrayList2, final boolean z, C14505i18 c14505i18) {
        AbstractC13042fc3.i(arrayList, "$uidList");
        AbstractC13042fc3.i(c13041fc2, "this$0");
        AbstractC13042fc3.i(arrayList2, "$groupMembers");
        AbstractC5969Lp4.g().l(arrayList).I(new InterfaceC17569nB2() { // from class: ir.nasim.cc2
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C13041fc2.ia(this.a, arrayList2, (C21231tK7) obj);
            }
        }).M().m0(new InterfaceC24449ye1() { // from class: ir.nasim.dc2
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C13041fc2.ja(this.a, z, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 ia(C13041fc2 c13041fc2, ArrayList arrayList, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(c13041fc2, "this$0");
        AbstractC13042fc3.i(arrayList, "$groupMembers");
        AbstractC13042fc3.i(c21231tK7, "userVM");
        return c13041fc2.ba(arrayList, c21231tK7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(C13041fc2 c13041fc2, boolean z, List list) {
        AbstractC13042fc3.i(c13041fc2, "this$0");
        c13041fc2.aa().e.setVisibility(8);
        if (z) {
            c13041fc2.ea().F(list);
        } else {
            c13041fc2.ea().A(list);
        }
    }

    public static final C13041fc2 ka(int i) {
        return INSTANCE.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(C13041fc2 c13041fc2, RecyclerView.C c) {
        AbstractC13042fc3.i(c13041fc2, "this$0");
        AbstractC13042fc3.i(c, "it");
        c13041fc2.W9(c13041fc2.da());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(C13041fc2 c13041fc2, HashSet hashSet, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c13041fc2, "this$0");
        c13041fc2.members.clear();
        c13041fc2.checkIndex = 0;
        if (hashSet != null) {
            c13041fc2.X9(hashSet);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle saveInstance) {
        super.M6(saveInstance);
        Bundle bundleE5 = E5();
        int i = 0;
        if (bundleE5 != null) {
            i = bundleE5.getInt("ARG_GROUP_ID", 0);
            this.groupVM = AbstractC5969Lp4.d().V(i);
        }
        this.groupId = i;
        qa(new E34(this, this.groupVM));
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C13286fy2.c(inflater, container, false);
        aa().getRoot().setBackgroundColor(C5495Jo7.a.O0());
        pa(new LinearLayoutManager(S7()));
        ra(new RecyclerView.w() { // from class: ir.nasim.Xb2
            @Override // androidx.recyclerview.widget.RecyclerView.w
            public final void a(RecyclerView.C c) {
                C13041fc2.ma(this.a, c);
            }
        });
        aa().b.setLayoutManager(da());
        aa().b.setAdapter(ea());
        aa().b.addRecyclerListener(fa());
        C14733iO2 c14733iO2 = this.groupVM;
        if (c14733iO2 != null) {
            s8(c14733iO2.t(), new InterfaceC14756iQ7() { // from class: ir.nasim.Yb2
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    C13041fc2.na(this.a, (HashSet) obj, abstractC13554gQ7);
                }
            });
        }
        BaleToolbar baleToolbar = aa().d;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        ConstraintLayout constraintLayoutB = aa().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        return constraintLayoutB;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        aa().b.removeRecyclerListener(fa());
        this._binding = null;
    }

    public final LinearLayoutManager da() {
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager != null) {
            return linearLayoutManager;
        }
        AbstractC13042fc3.y("layoutManager");
        return null;
    }

    public final E34 ea() {
        E34 e34 = this.membersExceptedAdapter;
        if (e34 != null) {
            return e34;
        }
        AbstractC13042fc3.y("membersExceptedAdapter");
        return null;
    }

    public final RecyclerView.w fa() {
        RecyclerView.w wVar = this.recyclerListener;
        if (wVar != null) {
            return wVar;
        }
        AbstractC13042fc3.y("recyclerListener");
        return null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        C23381wp3.c(A5());
    }

    @Override // ir.nasim.InterfaceC22483vJ4
    /* renamed from: la, reason: merged with bridge method [inline-methods] */
    public void e(C23104wM2 groupMember) {
        AbstractC13042fc3.i(groupMember, "groupMember");
        C16891m24 c16891m24Ga = C16891m24.Ga(groupMember, this.groupId, groupMember.f());
        c16891m24Ga.k8(k6(), m6());
        AbstractC13042fc3.f(c16891m24Ga);
        C22042ua0.A9(this, c16891m24Ga, false, null, 6, null);
    }

    @Override // ir.nasim.InterfaceC22483vJ4
    /* renamed from: oa, reason: merged with bridge method [inline-methods] */
    public boolean v(C23104wM2 item) {
        AbstractC13042fc3.i(item, "item");
        return false;
    }

    public final void pa(LinearLayoutManager linearLayoutManager) {
        AbstractC13042fc3.i(linearLayoutManager, "<set-?>");
        this.layoutManager = linearLayoutManager;
    }

    public final void qa(E34 e34) {
        AbstractC13042fc3.i(e34, "<set-?>");
        this.membersExceptedAdapter = e34;
    }

    public final void ra(RecyclerView.w wVar) {
        AbstractC13042fc3.i(wVar, "<set-?>");
        this.recyclerListener = wVar;
    }
}
