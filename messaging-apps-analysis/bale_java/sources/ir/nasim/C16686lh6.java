package ir.nasim;

import ai.bale.proto.SearchOuterClass$RequestSearchContent;
import ai.bale.proto.SearchOuterClass$ResponseSearchContent;
import ai.bale.proto.SearchStruct$SearchPieceText;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.BytesValue;

/* renamed from: ir.nasim.lh6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16686lh6 {
    private final UG7 a;
    private final C6287Mz b;
    private final JB c;

    /* renamed from: ir.nasim.lh6$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C16686lh6.this.a(null, null, this);
        }
    }

    /* renamed from: ir.nasim.lh6$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C16686lh6.this.b(null, null, this);
        }
    }

    public C16686lh6(UG7 ug7, C6287Mz c6287Mz, JB jb) {
        AbstractC13042fc3.i(ug7, "updateModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(jb, "mapper");
        this.a = ug7;
        this.b = c6287Mz;
        this.c = jb;
    }

    private final Object c(String str, byte[] bArr, EnumC6371Nh6 enumC6371Nh6, InterfaceC20295rm1 interfaceC20295rm1) {
        SearchOuterClass$RequestSearchContent searchOuterClass$RequestSearchContent = (SearchOuterClass$RequestSearchContent) SearchOuterClass$RequestSearchContent.newBuilder().A(enumC6371Nh6).B(BytesValue.parseFrom(bArr)).C(SearchStruct$SearchPieceText.newBuilder().A(str)).a();
        C6287Mz c6287Mz = this.b;
        AbstractC13042fc3.f(searchOuterClass$RequestSearchContent);
        SearchOuterClass$ResponseSearchContent defaultInstance = SearchOuterClass$ResponseSearchContent.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return InterfaceC16847ly.c(c6287Mz, new C22871vx5("/bale.search.v1.Search/SearchContent", searchOuterClass$RequestSearchContent, defaultInstance), 0L, null, interfaceC20295rm1, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0163 -> B:47:0x0183). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0180 -> B:46:0x0181). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r18, byte[] r19, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16686lh6.a(java.lang.String, byte[], ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00ad -> B:32:0x00b0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r7, byte[] r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16686lh6.b(java.lang.String, byte[], ir.nasim.rm1):java.lang.Object");
    }
}
