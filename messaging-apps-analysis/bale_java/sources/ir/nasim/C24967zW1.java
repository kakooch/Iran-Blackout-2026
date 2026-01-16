package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: ir.nasim.zW1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C24967zW1 extends AbstractC17457n0 {
    protected InterfaceC18505om2 c;
    protected String d;
    protected String e;
    protected C22694vg2 f;
    protected C5118Hz g;
    protected C23345wl7 h;

    public C24967zW1(C11909dl1 c11909dl1) {
        super(c11909dl1);
        C6035Lx c6035Lx = (C6035Lx) c11909dl1.c();
        this.c = new C11920dm2(new FileReference(new C12056dy(c6035Lx.getFileId(), c6035Lx.getAccessHash(), c6035Lx.getFileStorageVersion()), c6035Lx.getName(), c6035Lx.u() != null ? c6035Lx.u().z() : "", c6035Lx.getFileSize()));
        this.d = c6035Lx.z();
        this.e = c6035Lx.getName();
        this.f = c6035Lx.C() != null ? new C22694vg2(c6035Lx.C()) : null;
        this.h = c6035Lx.u() != null ? (C23345wl7) AbstractC17457n0.h(c6035Lx.u()) : C23345wl7.s("", new ArrayList());
        this.g = c6035Lx.y();
    }

    public static C24967zW1 r(String str, int i, String str2, String str3, String str4, C22694vg2 c22694vg2) {
        return new C24967zW1(new C8540Wk1(new OG3(str, str2, str3, i, str4, c22694vg2 != null ? new RG3(c22694vg2) : null)));
    }

    public static C24967zW1 s(FileReference fileReference, ArrayList arrayList, C22694vg2 c22694vg2, String str) {
        return new C24967zW1(new C11909dl1(new C6035Lx(fileReference.getFileId(), fileReference.getAccessHash(), fileReference.getFileSize(), fileReference.getFileName(), str, c22694vg2 != null ? new C11413cy(c22694vg2.d(), c22694vg2.b(), c22694vg2.c(), null) : null, null, new ZC(fileReference.getCaption(), arrayList, null, null), "checksum!", "algorithm", fileReference.getFileStorageVersion(), null, null)));
    }

    protected String A(Context context, int i, String str) {
        String string = context.getString(i);
        if (t().v().isEmpty()) {
            if (str == null) {
                return string;
            }
            return string + str;
        }
        if (str == null) {
            return string + Separators.SP + context.getString(AbstractC12217eE5.chat_fragment_has_caption_content_description) + Separators.SP + t().v();
        }
        return string + Separators.SP + str + Separators.SP + context.getString(AbstractC12217eE5.chat_fragment_has_caption_content_description) + Separators.SP + C10082b3.d(t().v());
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_document);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        C24967zW1 c24967zW1 = (C24967zW1) obj;
        return Objects.equals(this.c, c24967zW1.c) && Objects.equals(this.d, c24967zW1.d) && Objects.equals(this.e, c24967zW1.e) && Objects.equals(this.f, c24967zW1.f) && Objects.equals(this.g, c24967zW1.g) && Objects.equals(this.h, c24967zW1.h);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.c, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        return A(context, AbstractC12217eE5.media_Document, u() + y().replace(u(), "") + Separators.SP + C10082b3.b(context, Integer.valueOf(z().f())));
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return this.h;
    }

    public C23345wl7 t() {
        return this.h;
    }

    public String u() {
        int iLastIndexOf = this.e.lastIndexOf(46);
        return iLastIndexOf >= 0 ? this.e.substring(iLastIndexOf + 1) : "";
    }

    public C22694vg2 v() {
        return this.f;
    }

    public C5118Hz w() {
        return this.g;
    }

    public String x() {
        return this.d;
    }

    public String y() {
        return this.e;
    }

    public InterfaceC18505om2 z() {
        return this.c;
    }

    public C24967zW1(C8540Wk1 c8540Wk1) {
        C23345wl7 c23345wl7S;
        super(c8540Wk1);
        OG3 og3 = (OG3) c8540Wk1.c();
        this.c = new C4512Fl2(og3.getFileName(), og3.getFileSize(), og3.u(), og3.getCaption());
        this.d = og3.w();
        this.e = og3.getFileName();
        this.f = og3.s() != null ? new C22694vg2(og3.s()) : null;
        if (og3.getCaption() != null) {
            c23345wl7S = C23345wl7.s(og3.getCaption(), new ArrayList());
        } else {
            c23345wl7S = C23345wl7.s("", new ArrayList());
        }
        this.h = c23345wl7S;
    }
}
