package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC17445my6;
import ir.nasim.InterfaceC18963pY7;
import ir.nasim.InterfaceC19554qY7;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001*B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u001b\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0016\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lir/nasim/RV7;", "Lir/nasim/Ha0;", "Lir/nasim/my6$e;", "Lir/nasim/KV7;", "<init>", "()V", "Lir/nasim/pJ2;", "currentMessage", "Lir/nasim/rB7;", "ua", "(Lir/nasim/pJ2;)V", "", "W9", "()I", "X9", "Lir/nasim/OT4;", "V9", "()Lir/nasim/OT4;", "Landroidx/recyclerview/widget/GridLayoutManager;", "sa", "()Landroidx/recyclerview/widget/GridLayoutManager;", "Lir/nasim/Fq2;", "Lir/nasim/NT4;", "aa", "()Lir/nasim/Fq2;", "Lir/nasim/cU7;", "o1", "Lir/nasim/cU7;", "ta", "()Lir/nasim/cU7;", "setVideoPlayerNavigator", "(Lir/nasim/cU7;)V", "videoPlayerNavigator", "Landroidx/recyclerview/widget/RecyclerView$o;", "p1", "Landroidx/recyclerview/widget/RecyclerView$o;", "Y9", "()Landroidx/recyclerview/widget/RecyclerView$o;", "setItemDecoration", "(Landroidx/recyclerview/widget/RecyclerView$o;)V", "itemDecoration", "q1", "a", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class RV7 extends AbstractC9777aY2<InterfaceC17445my6.e, KV7> {

    /* renamed from: q1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int r1 = 8;

    /* renamed from: o1, reason: from kotlin metadata */
    public InterfaceC10956cU7 videoPlayerNavigator;

    /* renamed from: p1, reason: from kotlin metadata */
    private RecyclerView.o itemDecoration = new C13504gL2(2.0f, 3);

    /* renamed from: ir.nasim.RV7$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final RV7 a(C11458d25 c11458d25, ExPeerType exPeerType) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            RV7 rv7 = new RV7();
            rv7.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("peerUniqueIdArg", Long.valueOf(c11458d25.u())), AbstractC4616Fw7.a("exPeerTypeArg", exPeerType)));
            return rv7;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa(RV7 rv7, C18823pJ2 c18823pJ2) {
        AbstractC13042fc3.i(rv7, "this$0");
        rv7.ua(c18823pJ2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(RV7 rv7, boolean z) {
        AbstractC13042fc3.i(rv7, "this$0");
        rv7.ba().x4(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(RV7 rv7, InterfaceC17445my6 interfaceC17445my6) {
        AbstractC13042fc3.i(rv7, "this$0");
        AbstractC13042fc3.i(interfaceC17445my6, "item");
        rv7.ba().f4(interfaceC17445my6);
        return C19938rB7.a;
    }

    private final void ua(C18823pJ2 currentMessage) {
        FileReference fileReferenceB;
        AbstractC17457n0 abstractC17457n0Q;
        C24967zW1 c24967zW1F = (currentMessage == null || (abstractC17457n0Q = currentMessage.q()) == null) ? null : abstractC17457n0Q.f();
        GS7 gs7 = c24967zW1F instanceof GS7 ? (GS7) c24967zW1F : null;
        if (gs7 == null) {
            return;
        }
        InterfaceC18505om2 interfaceC18505om2Z = gs7.z();
        C11920dm2 c11920dm2 = interfaceC18505om2Z instanceof C11920dm2 ? (C11920dm2) interfaceC18505om2Z : null;
        if (c11920dm2 == null || (fileReferenceB = c11920dm2.b()) == null) {
            return;
        }
        C23345wl7 c23345wl7L = gs7.l();
        String strV = c23345wl7L != null ? c23345wl7L.v() : null;
        InterfaceC10956cU7 interfaceC10956cU7Ta = ta();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        C11458d25 c11458d25V3 = ba().v3();
        ExPeerType exPeerTypeD3 = ba().d3();
        long jI = currentMessage.i();
        Long lR = currentMessage.r();
        AbstractC13042fc3.h(lR, "getDate(...)");
        long jLongValue = lR.longValue();
        String fileName = fileReferenceB.getFileName();
        int iS = currentMessage.s();
        GS7 gs72 = gs7;
        InterfaceC19554qY7.b bVar = new InterfaceC19554qY7.b(fileReferenceB.getFileId(), fileReferenceB.getAccessHash());
        long fileSize = fileReferenceB.getFileSize();
        String strX = gs72.x();
        long jG = gs72.G();
        C22694vg2 c22694vg2V = gs72.v();
        InterfaceC10956cU7.a(interfaceC10956cU7Ta, contextS7, c11458d25V3, exPeerTypeD3, new InterfaceC18963pY7.c(jG, jI, jLongValue, fileName, iS, fileSize, strV, strX, new C15539jl1(gs72.I(), gs72.H()), bVar, c22694vg2V != null ? c22694vg2V.c() : null), null, EnumC24384yX3.c, 16, null);
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public OT4 V9() {
        return new WV7(new UA2() { // from class: ir.nasim.OV7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return RV7.pa(this.a, (C18823pJ2) obj);
            }
        }, ba().Z3(), null, new UA2() { // from class: ir.nasim.PV7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return RV7.qa(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.QV7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return RV7.ra(this.a, (InterfaceC17445my6) obj);
            }
        }, 4, null);
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public int W9() {
        return AbstractC22412vB5.video;
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public int X9() {
        return RD5.not_exist_video;
    }

    @Override // ir.nasim.AbstractC4894Ha0
    /* renamed from: Y9, reason: from getter */
    public RecyclerView.o getItemDecoration() {
        return this.itemDecoration;
    }

    @Override // ir.nasim.AbstractC4894Ha0
    public InterfaceC4557Fq2 aa() {
        return ba().L3();
    }

    @Override // ir.nasim.AbstractC4894Ha0
    /* renamed from: sa, reason: merged with bridge method [inline-methods] */
    public GridLayoutManager Z9() {
        return new GridLayoutManager(S7(), 3);
    }

    public final InterfaceC10956cU7 ta() {
        InterfaceC10956cU7 interfaceC10956cU7 = this.videoPlayerNavigator;
        if (interfaceC10956cU7 != null) {
            return interfaceC10956cU7;
        }
        AbstractC13042fc3.y("videoPlayerNavigator");
        return null;
    }
}
