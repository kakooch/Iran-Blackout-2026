package ir.nasim;

import ai.bale.proto.SearchOuterClass$ResponseSearchProduct;
import ai.bale.proto.SearchStruct$ProductSearchResult;
import android.gov.nist.core.Separators;
import ir.nasim.core.modules.file.entity.FileReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.bh6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10489bh6 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final ArrayList a;
    private final int b;
    private final byte[] c;

    /* renamed from: ir.nasim.bh6$a */
    public static final class a {
        private a() {
        }

        public final C10489bh6 a(SearchOuterClass$ResponseSearchProduct searchOuterClass$ResponseSearchProduct) {
            AbstractC13042fc3.i(searchOuterClass$ResponseSearchProduct, "response");
            ArrayList arrayList = new ArrayList();
            List<SearchStruct$ProductSearchResult> productResultsList = searchOuterClass$ResponseSearchProduct.getProductResultsList();
            AbstractC13042fc3.h(productResultsList, "getProductResultsList(...)");
            for (SearchStruct$ProductSearchResult searchStruct$ProductSearchResult : productResultsList) {
                b.a aVar = b.i;
                AbstractC13042fc3.f(searchStruct$ProductSearchResult);
                arrayList.add(aVar.a(searchStruct$ProductSearchResult));
            }
            int resultCount = searchOuterClass$ResponseSearchProduct.getResultCount();
            byte[] bArrA0 = searchOuterClass$ResponseSearchProduct.getLoadMoreState().getValue().a0();
            AbstractC13042fc3.h(bArrA0, "toByteArray(...)");
            return new C10489bh6(arrayList, resultCount, bArrA0);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.bh6$b */
    public static final class b {
        public static final a i = new a(null);
        private final long a;
        private final String b;
        private final long c;
        private final int d;
        private final String e;
        private final long f;
        private final long g;
        private final int h;

        /* renamed from: ir.nasim.bh6$b$a */
        public static final class a {
            private a() {
            }

            public final b a(SearchStruct$ProductSearchResult searchStruct$ProductSearchResult) {
                AbstractC13042fc3.i(searchStruct$ProductSearchResult, "response");
                long accessHash = searchStruct$ProductSearchResult.getContent().getAccessHash();
                String text = searchStruct$ProductSearchResult.getContent().getCaption().getText();
                AbstractC13042fc3.h(text, "getText(...)");
                long fileId = searchStruct$ProductSearchResult.getContent().getFileId();
                int fileSize = searchStruct$ProductSearchResult.getContent().getFileSize();
                String name = searchStruct$ProductSearchResult.getContent().getName();
                AbstractC13042fc3.h(name, "getName(...)");
                return new b(accessHash, text, fileId, fileSize, name, searchStruct$ProductSearchResult.getMessageId().getDate(), searchStruct$ProductSearchResult.getMessageId().getRandomId(), searchStruct$ProductSearchResult.getMessageId().getPeer().getId());
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public b(long j, String str, long j2, int i2, String str2, long j3, long j4, int i3) {
            AbstractC13042fc3.i(str, "caption");
            AbstractC13042fc3.i(str2, "fileName");
            this.a = j;
            this.b = str;
            this.c = j2;
            this.d = i2;
            this.e = str2;
            this.f = j3;
            this.g = j4;
            this.h = i3;
        }

        public final FileReference a() {
            return new FileReference(new C12056dy(this.c, this.a, 1), this.e, "", this.d);
        }

        public final int b() {
            return this.h;
        }

        public final long c() {
            return this.g;
        }

        public final String d() {
            return "https://" + AbstractC5969Lp4.e().S().n1() + "/post/" + this.h + Separators.SLASH + this.g + Separators.SLASH + this.f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d && AbstractC13042fc3.d(this.e, bVar.e) && this.f == bVar.f && this.g == bVar.g && this.h == bVar.h;
        }

        public int hashCode() {
            return (((((((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Integer.hashCode(this.h);
        }

        public String toString() {
            return "Post(accessHash=" + this.a + ", caption=" + this.b + ", fileId=" + this.c + ", fileSize=" + this.d + ", fileName=" + this.e + ", date=" + this.f + ", randomId=" + this.g + ", peerId=" + this.h + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.bh6$c */
    public static final class c {
    }

    public C10489bh6(ArrayList arrayList, int i, byte[] bArr) {
        AbstractC13042fc3.i(arrayList, "posts");
        AbstractC13042fc3.i(bArr, "loadMore");
        this.a = arrayList;
        this.b = i;
        this.c = bArr;
    }

    public final int a() {
        return this.b;
    }

    public final byte[] b() {
        return this.c;
    }

    public final ArrayList c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C10489bh6.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.SearchProductResponse");
        C10489bh6 c10489bh6 = (C10489bh6) obj;
        return AbstractC13042fc3.d(this.a, c10489bh6.a) && this.b == c10489bh6.b && Arrays.equals(this.c, c10489bh6.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + Arrays.hashCode(this.c);
    }

    public String toString() {
        return "SearchProductResponse(posts=" + this.a + ", count=" + this.b + ", loadMore=" + Arrays.toString(this.c) + Separators.RPAREN;
    }
}
