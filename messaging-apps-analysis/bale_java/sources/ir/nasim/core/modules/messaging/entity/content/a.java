package ir.nasim.core.modules.messaging.entity.content;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC17457n0;
import ir.nasim.AbstractC18048o0;
import ir.nasim.AbstractC19230q0;
import ir.nasim.C11413cy;
import ir.nasim.C11909dl1;
import ir.nasim.C16247kx;
import ir.nasim.C22694vg2;
import ir.nasim.C23345wl7;
import ir.nasim.C5100Hx;
import ir.nasim.C6035Lx;
import ir.nasim.C8540Wk1;
import ir.nasim.C9625aH3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.MG3;
import ir.nasim.SA2;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public final class a extends AbstractC17457n0 {
    public static final C0997a g = new C0997a(null);
    public static final int h = 8;
    private C11909dl1 c;
    private C8540Wk1 d;
    private AbstractC17457n0 e;
    private final InterfaceC9173Yu3 f;

    /* renamed from: ir.nasim.core.modules.messaging.entity.content.a$a, reason: collision with other inner class name */
    public static final class C0997a {
        private C0997a() {
        }

        public final a a(CrowdfundingContentInfo crowdfundingContentInfo, AbstractC17457n0 abstractC17457n0) {
            AbstractC13042fc3.i(crowdfundingContentInfo, ParameterNames.INFO);
            AbstractC13042fc3.i(abstractC17457n0, DialogEntity.COLUMN_MESSAGE);
            AbstractC18048o0 abstractC18048o0I = abstractC17457n0.i();
            AbstractC13042fc3.g(abstractC18048o0I, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.ContentLocalContainer");
            AbstractC19230q0 abstractC19230q0C = ((C8540Wk1) abstractC18048o0I).c();
            AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalPhoto");
            return new a(new C8540Wk1(new MG3(crowdfundingContentInfo, (C9625aH3) abstractC19230q0C)), abstractC17457n0);
        }

        public final a b(a aVar, FileReference fileReference, C22694vg2 c22694vg2, int i, int i2) {
            AbstractC13042fc3.i(aVar, "content");
            AbstractC13042fc3.i(fileReference, "reference");
            AbstractC13042fc3.i(c22694vg2, "fastThumb");
            return new a(new C11909dl1(new C16247kx(aVar.t().getAmount(), aVar.t().getCardNumber(), aVar.t().getQuotaAmount(), aVar.t().getTitle(), aVar.t().getDescription(), aVar.t().getEndTime(), aVar.t().getStatus(), new C6035Lx(fileReference.getFileId(), fileReference.getAccessHash(), fileReference.getFileSize(), fileReference.getFileName(), "image/jpeg", new C11413cy(c22694vg2.d(), c22694vg2.b(), c22694vg2.c(), null), new C5100Hx(i, i2), null, "checksum", "algorithm", fileReference.getFileStorageVersion(), null, null))));
        }

        public /* synthetic */ C0997a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(C8540Wk1 c8540Wk1, AbstractC17457n0 abstractC17457n0) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "content");
        AbstractC13042fc3.i(abstractC17457n0, "absContent");
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.iv1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.core.modules.messaging.entity.content.a.w(this.a);
            }
        });
        this.d = c8540Wk1;
        this.e = abstractC17457n0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CrowdfundingContentInfo w(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        C11909dl1 c11909dl1 = aVar.c;
        if (c11909dl1 != null) {
            CrowdfundingContentInfo.Companion companion = CrowdfundingContentInfo.INSTANCE;
            AbstractC13042fc3.f(c11909dl1);
            return companion.b(c11909dl1);
        }
        C8540Wk1 c8540Wk1 = aVar.d;
        AbstractC13042fc3.f(c8540Wk1);
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalCrowdfundingContent");
        return ((MG3) abstractC19230q0C).C();
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.message_holder_content_crowdfunding);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(a.class, obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.CrowdfundingContent");
        a aVar = (a) obj;
        return AbstractC13042fc3.d(this.c, aVar.c) && AbstractC13042fc3.d(this.d, aVar.d) && AbstractC13042fc3.d(this.e, aVar.e) && AbstractC13042fc3.d(t(), aVar.t());
    }

    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        C11909dl1 c11909dl1 = this.c;
        int iHashCode2 = (iHashCode + (c11909dl1 != null ? c11909dl1.hashCode() : 0)) * 31;
        C8540Wk1 c8540Wk1 = this.d;
        int iHashCode3 = (iHashCode2 + (c8540Wk1 != null ? c8540Wk1.hashCode() : 0)) * 31;
        AbstractC17457n0 abstractC17457n0 = this.e;
        return ((iHashCode3 + (abstractC17457n0 != null ? abstractC17457n0.hashCode() : 0)) * 31) + t().hashCode();
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        return context.getString(AbstractC12217eE5.crowd_funding) + Separators.SP + context.getString(AbstractC12217eE5.chat_fragment_has_caption_content_description) + Separators.SP + t().getDescription();
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public final AbstractC17457n0 s() {
        return this.e;
    }

    public final CrowdfundingContentInfo t() {
        return (CrowdfundingContentInfo) this.f.getValue();
    }

    public final C8540Wk1 u() {
        return this.d;
    }

    public final C11909dl1 v() {
        return this.c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "content");
        this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.iv1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.core.modules.messaging.entity.content.a.w(this.a);
            }
        });
        this.c = c11909dl1;
    }
}
