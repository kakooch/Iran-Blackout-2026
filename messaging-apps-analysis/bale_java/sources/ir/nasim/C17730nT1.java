package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.UO1;
import ir.nasim.YT4;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.nT1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17730nT1 extends YT4 {
    private final ir.nasim.database.dailogLists.c b;
    private final int c;
    private final BM1 d;
    private final InterfaceC24823zG1 e;
    private final UO1.d.a f;
    private final int g;

    /* renamed from: ir.nasim.nT1$a */
    public interface a {
        static /* synthetic */ C17730nT1 b(a aVar, int i, InterfaceC24823zG1 interfaceC24823zG1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
            }
            if ((i2 & 2) != 0) {
                interfaceC24823zG1 = null;
            }
            return aVar.a(i, interfaceC24823zG1);
        }

        C17730nT1 a(int i, InterfaceC24823zG1 interfaceC24823zG1);
    }

    /* renamed from: ir.nasim.nT1$b */
    public static final class b {
        private final int a;
        private final int b;
        private final int c;

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.a;
        }

        public final int c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "Key(offset=" + this.a + ", pageLoadSize=" + this.b + ", actualOffset=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.nT1$c */
    public static final class c implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            b bVar = (b) ((YT4.b.c) obj).o();
            Integer numValueOf = bVar != null ? Integer.valueOf(bVar.b()) : null;
            b bVar2 = (b) ((YT4.b.c) obj2).o();
            return AbstractC18050o01.d(numValueOf, bVar2 != null ? Integer.valueOf(bVar2.b()) : null);
        }
    }

    /* renamed from: ir.nasim.nT1$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        int e;
        long f;
        /* synthetic */ Object g;
        int i;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return C17730nT1.this.f(null, this);
        }
    }

    public C17730nT1(ir.nasim.database.dailogLists.c cVar, int i, BM1 bm1, InterfaceC24823zG1 interfaceC24823zG1) {
        AbstractC13042fc3.i(cVar, "dialogFolderDao");
        AbstractC13042fc3.i(bm1, "dialogDTOConverter");
        this.b = cVar;
        this.c = i;
        this.d = bm1;
        this.e = interfaceC24823zG1;
        this.f = UO1.d.a.a;
        this.g = 10;
    }

    private final Object j(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return FM1.a(this.d, list, interfaceC20295rm1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d0 A[Catch: Exception -> 0x004a, CancellationException -> 0x004d, TryCatch #4 {CancellationException -> 0x004d, Exception -> 0x004a, blocks: (B:15:0x0045, B:80:0x01c1, B:81:0x01c3, B:85:0x01dc, B:89:0x01f6, B:88:0x01e8, B:84:0x01d0, B:34:0x00a0, B:56:0x0146), top: B:95:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e8 A[Catch: Exception -> 0x004a, CancellationException -> 0x004d, TryCatch #4 {CancellationException -> 0x004d, Exception -> 0x004a, blocks: (B:15:0x0045, B:80:0x01c1, B:81:0x01c3, B:85:0x01dc, B:89:0x01f6, B:88:0x01e8, B:84:0x01d0, B:34:0x00a0, B:56:0x0146), top: B:95:0x0029 }] */
    /* JADX WARN: Type inference failed for: r2v18, types: [ir.nasim.nT1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [ir.nasim.nT1$d, ir.nasim.rm1] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    @Override // ir.nasim.YT4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.YT4.a r17, ir.nasim.InterfaceC20295rm1 r18) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17730nT1.f(ir.nasim.YT4$a, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.YT4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b d(ZT4 zt4) {
        int iA;
        AbstractC13042fc3.i(zt4, "state");
        UO1.d dVar = UO1.d.a;
        int i = this.c;
        Object objC = zt4.c();
        if (objC == null) {
            objC = "null";
        }
        dVar.a(i, AbstractC16016kZ6.i("Starting getRefreshKey operation\n            | State:\n            | - Anchor position: " + objC + "\n            | - Total pages: " + zt4.e().size() + "\n            ", null, 1, null), this.f);
        Integer numC = zt4.c();
        if (numC == null) {
            dVar.a(this.c, "Anchor position is null, returning null refreshKey", this.f);
            return null;
        }
        YT4.b.c cVarB = zt4.b(numC.intValue());
        if (cVarB == null) {
            dVar.a(this.c, "No page closest to position " + numC + ", returning null refreshKey", this.f);
            return null;
        }
        YT4.b.c cVar = (YT4.b.c) AbstractC15401jX0.q0(AbstractC15401jX0.a1(zt4.e(), new c()));
        b bVar = (b) cVar.o();
        b bVar2 = (b) cVar.j();
        if (bVar != null) {
            iA = bVar.a();
        } else {
            if (bVar2 == null) {
                return null;
            }
            iA = bVar2.a();
        }
        int iIntValue = numC.intValue() + iA;
        int iE = AbstractC23053wG5.e(iIntValue - zt4.d().a, 0);
        b bVar3 = new b(iE, zt4.d().a * 2, iE);
        dVar.a(this.c, AbstractC16016kZ6.i("Computed refreshKey:\n            | - anchorOffset: " + iA + "\n            | - actualAnchor: " + iIntValue + "\n            | - prevKey: " + cVarB.o() + "\n            | - nextKey: " + cVarB.j() + "\n            | - refreshKey: " + bVar3 + "\n            ", null, 1, null), this.f);
        return bVar3;
    }
}
