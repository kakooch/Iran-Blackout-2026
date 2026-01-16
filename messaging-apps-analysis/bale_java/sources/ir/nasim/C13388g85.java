package ir.nasim;

import android.content.Context;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;

/* renamed from: ir.nasim.g85, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C13388g85 extends C24967zW1 {
    public static final a l = new a(null);
    public static final int m = 8;
    private int i;
    private int j;
    private int k;

    /* renamed from: ir.nasim.g85$a */
    public static final class a {
        private a() {
        }

        public final C13388g85 a(String str, String str2, String str3, int i, int i2, int i3, C22694vg2 c22694vg2) {
            AbstractC13042fc3.i(str, "descriptor");
            AbstractC13042fc3.i(str2, "fileName");
            return new C13388g85(new C8540Wk1(new C9625aH3(str2, str, str3, i, "image/jpeg", c22694vg2 != null ? new RG3(c22694vg2) : null, i2, i3)));
        }

        public final C13388g85 b(FileReference fileReference, ArrayList arrayList, int i, int i2, C22694vg2 c22694vg2) {
            AbstractC13042fc3.i(fileReference, "reference");
            AbstractC13042fc3.i(arrayList, "mentions");
            long fileId = fileReference.getFileId();
            long accessHash = fileReference.getAccessHash();
            int fileSize = fileReference.getFileSize();
            String fileName = fileReference.getFileName();
            C11413cy c11413cy = c22694vg2 != null ? new C11413cy(c22694vg2.d(), c22694vg2.b(), c22694vg2.c(), null) : null;
            C5100Hx c5100Hx = new C5100Hx(i, i2);
            String caption = fileReference.getCaption();
            return new C13388g85(new C11909dl1(new C6035Lx(fileId, accessHash, fileSize, fileName, "image/jpeg", c11413cy, c5100Hx, caption != null ? new ZC(caption, arrayList, null, null) : null, "checksum", "algorithm", fileReference.getFileStorageVersion(), null, null)));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13388g85(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "contentLocalContainer");
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalPhoto");
        C9625aH3 c9625aH3 = (C9625aH3) abstractC19230q0C;
        this.i = c9625aH3.z();
        this.j = c9625aH3.y();
        this.k = c9625aH3.getFileSize();
    }

    public static final C13388g85 B(String str, String str2, String str3, int i, int i2, int i3, C22694vg2 c22694vg2) {
        return l.a(str, str2, str3, i, i2, i3, c22694vg2);
    }

    public static final C13388g85 C(FileReference fileReference, ArrayList arrayList, int i, int i2, C22694vg2 c22694vg2) {
        return l.b(fileReference, arrayList, i, i2, c22694vg2);
    }

    public final int D() {
        return this.j;
    }

    public final int E() {
        return this.i;
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.message_holder_content_photo);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    @Override // ir.nasim.C24967zW1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(getClass(), obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.PhotoContent");
        C13388g85 c13388g85 = (C13388g85) obj;
        return this.i == c13388g85.i && this.j == c13388g85.j && this.k == c13388g85.k;
    }

    @Override // ir.nasim.C24967zW1
    public int hashCode() {
        return (((((super.hashCode() * 31) + this.i) * 31) + this.j) * 31) + this.k;
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        String strA = super.A(context, AbstractC12217eE5.media_picture, null);
        AbstractC13042fc3.h(strA, "getTypeAndCaptionContentDescription(...)");
        return strA;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13388g85(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentRemoteContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiDocumentMessage");
        C6035Lx c6035Lx = (C6035Lx) abstractC24063xzC;
        C5100Hx c5100Hx = (C5100Hx) c6035Lx.w();
        if (c5100Hx != null) {
            this.i = c5100Hx.w();
            this.j = c5100Hx.u();
            this.k = c6035Lx.getFileSize();
        }
    }
}
