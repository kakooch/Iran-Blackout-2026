package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.webkit.MimeTypeMap;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class XG2 extends C24967zW1 {
    public static final a l = new a(null);
    public static final int m = 8;
    private int i;
    private int j;
    private int k;

    public static final class a {
        private a() {
        }

        public static /* synthetic */ XG2 d(a aVar, FileReference fileReference, ArrayList arrayList, int i, int i2, int i3, C22694vg2 c22694vg2, String str, int i4, Object obj) {
            return aVar.c(fileReference, arrayList, i, i2, i3, c22694vg2, (i4 & 64) != 0 ? null : str);
        }

        public final XG2 a(String str, String str2, String str3, int i, int i2, int i3, int i4, C22694vg2 c22694vg2, String str4) {
            AbstractC13042fc3.i(str4, "mimeType");
            return new XG2(new C8540Wk1(new SG3(str2, str, str3, i, str4, c22694vg2 != null ? new RG3(c22694vg2) : null, i2, i3, i4)));
        }

        public final XG2 b(FileReference fileReference, ArrayList arrayList, int i, int i2, int i3, C22694vg2 c22694vg2) {
            AbstractC13042fc3.i(fileReference, "reference");
            AbstractC13042fc3.i(arrayList, "mentions");
            return d(this, fileReference, arrayList, i, i2, i3, c22694vg2, null, 64, null);
        }

        public final XG2 c(FileReference fileReference, ArrayList arrayList, int i, int i2, int i3, C22694vg2 c22694vg2, String str) {
            String str2 = str;
            AbstractC13042fc3.i(fileReference, "reference");
            AbstractC13042fc3.i(arrayList, "mentions");
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str2);
            if (extensionFromMimeType != null) {
                extensionFromMimeType = Separators.DOT + extensionFromMimeType;
            }
            long fileId = fileReference.getFileId();
            long accessHash = fileReference.getAccessHash();
            int fileSize = fileReference.getFileSize();
            String fileName = fileReference.getFileName();
            if (extensionFromMimeType == null) {
                extensionFromMimeType = "";
            }
            String str3 = fileName + extensionFromMimeType;
            if (str2 == null) {
                str2 = "video/mp4";
            }
            String str4 = str2;
            C11413cy c11413cy = c22694vg2 != null ? new C11413cy(c22694vg2.d(), c22694vg2.b(), c22694vg2.c(), null) : null;
            C4866Gx c4866Gx = new C4866Gx(i, i2, i3);
            String caption = fileReference.getCaption();
            return new XG2(new C11909dl1(new C6035Lx(fileId, accessHash, fileSize, str3, str4, c11413cy, c4866Gx, caption != null ? new ZC(caption, arrayList, null, null) : null, "checksum", "algorithms", fileReference.getFileStorageVersion(), null, null)));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XG2(C11909dl1 c11909dl1) {
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "contentContainer");
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiDocumentMessage");
        AbstractC4383Ex abstractC4383ExW = ((C6035Lx) abstractC24063xzC).w();
        AbstractC13042fc3.g(abstractC4383ExW, "null cannot be cast to non-null type ir.nasim.core.api.ApiDocumentExGif");
        C4866Gx c4866Gx = (C4866Gx) abstractC4383ExW;
        this.j = c4866Gx.y();
        this.k = c4866Gx.w();
        this.i = c4866Gx.u();
    }

    public static final XG2 B(String str, String str2, String str3, int i, int i2, int i3, int i4, C22694vg2 c22694vg2, String str4) {
        return l.a(str, str2, str3, i, i2, i3, i4, c22694vg2, str4);
    }

    public static final XG2 C(FileReference fileReference, ArrayList arrayList, int i, int i2, int i3, C22694vg2 c22694vg2) {
        return l.b(fileReference, arrayList, i, i2, i3, c22694vg2);
    }

    public static final XG2 D(FileReference fileReference, ArrayList arrayList, int i, int i2, int i3, C22694vg2 c22694vg2, String str) {
        return l.c(fileReference, arrayList, i, i2, i3, c22694vg2, str);
    }

    public final int E() {
        return this.i;
    }

    public final int F() {
        return this.k;
    }

    public final int G() {
        return this.j;
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.message_holder_content_gif);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    @Override // ir.nasim.C24967zW1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(XG2.class, obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.GifContent");
        XG2 xg2 = (XG2) obj;
        return this.i == xg2.i && this.j == xg2.j && this.k == xg2.k;
    }

    @Override // ir.nasim.C24967zW1
    public int hashCode() {
        return (((((super.hashCode() * 31) + this.i) * 31) + this.j) * 31) + this.k;
    }

    @Override // ir.nasim.C24967zW1, ir.nasim.AbstractC17457n0
    public String j(Context context) {
        AbstractC13042fc3.i(context, "context");
        return super.A(context, AbstractC12217eE5.media_Gif, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XG2(C8540Wk1 c8540Wk1) {
        super(c8540Wk1);
        AbstractC13042fc3.i(c8540Wk1, "contentContainer");
        AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
        AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalGif");
        SG3 sg3 = (SG3) abstractC19230q0C;
        this.j = sg3.C();
        this.k = sg3.z();
        this.i = sg3.y();
    }
}
