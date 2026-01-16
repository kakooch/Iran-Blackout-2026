package ir.nasim;

import android.content.Context;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class GS7 extends C24967zW1 {
    public static final a n = new a(null);
    public static final int o = 8;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private long m;

    public static final class a {
        private a() {
        }

        public static /* synthetic */ GS7 e(a aVar, String str, String str2, String str3, int i, int i2, int i3, int i4, C22694vg2 c22694vg2, boolean z, int i5, Object obj) {
            return aVar.d(str, str2, str3, i, i2, i3, i4, c22694vg2, (i5 & 256) != 0 ? false : z);
        }

        public final GS7 a(GS7 gs7, int i, boolean z) {
            AbstractC13042fc3.i(gs7, "videoContent");
            AbstractC18048o0 abstractC18048o0I = gs7.i();
            AbstractC13042fc3.g(abstractC18048o0I, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.ContentLocalContainer");
            AbstractC19230q0 abstractC19230q0C = ((C8540Wk1) abstractC18048o0I).c();
            AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalVideo");
            C21874uH3 c21874uH3 = (C21874uH3) abstractC19230q0C;
            return new GS7(new C8540Wk1(new C21874uH3(gs7.z().a(), c21874uH3.u(), gs7.t().v(), i, "video/mp4", c21874uH3.s(), c21874uH3.C(), c21874uH3.z(), gs7.G(), z)));
        }

        public final GS7 b(GS7 gs7, String str, int i) {
            AbstractC13042fc3.i(gs7, "videoContent");
            AbstractC18048o0 abstractC18048o0I = gs7.i();
            AbstractC13042fc3.g(abstractC18048o0I, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.ContentLocalContainer");
            AbstractC19230q0 abstractC19230q0C = ((C8540Wk1) abstractC18048o0I).c();
            AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalVideo");
            C21874uH3 c21874uH3 = (C21874uH3) abstractC19230q0C;
            return new GS7(new C8540Wk1(new C21874uH3(gs7.z().a(), str, gs7.t().v(), i, "video/mp4", c21874uH3.s(), c21874uH3.C(), c21874uH3.z(), gs7.G(), gs7.J())));
        }

        public final GS7 c(String str, String str2, String str3, int i, int i2, int i3, int i4, C22694vg2 c22694vg2) {
            return e(this, str, str2, str3, i, i2, i3, i4, c22694vg2, false, 256, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final ir.nasim.GS7 d(java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, int r18, int r19, int r20, ir.nasim.C22694vg2 r21, boolean r22) {
            /*
                r13 = this;
                r0 = r21
                r1 = 0
                if (r22 == 0) goto L26
                boolean r2 = ir.nasim.C8386Vt0.F5()
                if (r2 == 0) goto L26
                ir.nasim.tgwidgets.editor.messenger.H r2 = ir.nasim.AbstractC25148zo6.a(r14)
                if (r2 == 0) goto L18
                boolean r3 = r2.b()
                if (r3 == 0) goto L18
                goto L19
            L18:
                r2 = r1
            L19:
                if (r2 == 0) goto L26
                int r3 = r2.k
                int r4 = r2.l
                long r5 = r2.p
                int r2 = (int) r5
                r6 = r2
                r9 = r3
                r10 = r4
                goto L2c
            L26:
                r6 = r17
                r9 = r18
                r10 = r19
            L2c:
                if (r0 == 0) goto L33
                ir.nasim.RG3 r1 = new ir.nasim.RG3
                r1.<init>(r0)
            L33:
                r8 = r1
                ir.nasim.uH3 r0 = new ir.nasim.uH3
                java.lang.String r7 = "video/mp4"
                r2 = r0
                r3 = r15
                r4 = r14
                r5 = r16
                r11 = r20
                r12 = r22
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                ir.nasim.Wk1 r1 = new ir.nasim.Wk1
                r1.<init>(r0)
                ir.nasim.GS7 r0 = new ir.nasim.GS7
                r0.<init>(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GS7.a.d(java.lang.String, java.lang.String, java.lang.String, int, int, int, int, ir.nasim.vg2, boolean):ir.nasim.GS7");
        }

        public final GS7 f(FileReference fileReference, ArrayList arrayList, int i, int i2, int i3, C22694vg2 c22694vg2) {
            AbstractC13042fc3.i(fileReference, "reference");
            AbstractC13042fc3.i(arrayList, "mentions");
            long fileId = fileReference.getFileId();
            long accessHash = fileReference.getAccessHash();
            int fileSize = fileReference.getFileSize();
            String fileName = fileReference.getFileName();
            C11413cy c11413cy = c22694vg2 != null ? new C11413cy(c22694vg2.d(), c22694vg2.b(), c22694vg2.c(), null) : null;
            C5568Jx c5568Jx = new C5568Jx(i, i2, i3);
            String caption = fileReference.getCaption();
            return new GS7(new C11909dl1(new C6035Lx(fileId, accessHash, fileSize, fileName, "video/mp4", c11413cy, c5568Jx, caption != null ? new ZC(caption, arrayList, null, null) : null, "checksum", "algorithms", fileReference.getFileStorageVersion(), null, null)));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GS7(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiDocumentMessage");
        AbstractC4383Ex abstractC4383ExW = ((C6035Lx) abstractC24063xzC).w();
        AbstractC13042fc3.g(abstractC4383ExW, "null cannot be cast to non-null type ir.nasim.core.api.ApiDocumentExVideo");
        C5568Jx c5568Jx = (C5568Jx) abstractC4383ExW;
        this.j = c5568Jx.y();
        this.k = c5568Jx.w();
        this.i = c5568Jx.u();
        AbstractC24063xz abstractC24063xzC2 = c11909dl1.c();
        this.m = (abstractC24063xzC2 instanceof C6035Lx ? (C6035Lx) abstractC24063xzC2 : null) != null ? r3.getFileSize() : 0L;
    }

    public static final GS7 B(GS7 gs7, int i, boolean z) {
        return n.a(gs7, i, z);
    }

    public static final GS7 C(GS7 gs7, String str, int i) {
        return n.b(gs7, str, i);
    }

    public static final GS7 D(String str, String str2, String str3, int i, int i2, int i3, int i4, C22694vg2 c22694vg2) {
        return n.c(str, str2, str3, i, i2, i3, i4, c22694vg2);
    }

    public static final GS7 E(String str, String str2, String str3, int i, int i2, int i3, int i4, C22694vg2 c22694vg2, boolean z) {
        return n.d(str, str2, str3, i, i2, i3, i4, c22694vg2, z);
    }

    public static final GS7 F(FileReference fileReference, ArrayList arrayList, int i, int i2, int i3, C22694vg2 c22694vg2) {
        return n.f(fileReference, arrayList, i, i2, i3, c22694vg2);
    }

    public final int G() {
        return this.i;
    }

    public final int H() {
        return this.k;
    }

    public final int I() {
        return this.j;
    }

    public final boolean J() {
        return this.l;
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.message_holder_content_video);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    @Override // ir.nasim.C24967zW1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(GS7.class, obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.VideoContent");
        GS7 gs7 = (GS7) obj;
        return this.i == gs7.i && this.j == gs7.j && this.k == gs7.k && this.l == gs7.l && this.m == gs7.m;
    }

    @Override // ir.nasim.C24967zW1
    public int hashCode() {
        return (((((((((super.hashCode() * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + Boolean.hashCode(this.l)) * 31) + Long.hashCode(this.m);
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        String strA = super.A(context, AbstractC12217eE5.media_video, C10082b3.b(context, Long.valueOf(this.m)));
        AbstractC13042fc3.h(strA, "getTypeAndCaptionContentDescription(...)");
        return strA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GS7(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "contentContainer");
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalVideo");
        C21874uH3 c21874uH3 = (C21874uH3) abstractC19230q0C;
        this.j = c21874uH3.C();
        this.k = c21874uH3.z();
        this.i = c21874uH3.y();
        this.l = c21874uH3.D();
        this.m = c21874uH3.getFileSize();
    }
}
