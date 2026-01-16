package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C24254yJ;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.iv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15050iv3 {

    /* renamed from: ir.nasim.iv3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC10254bL2 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ C6021Lv3 g;
        final /* synthetic */ TS4 h;
        final /* synthetic */ boolean i;
        final /* synthetic */ C24254yJ.m j;
        final /* synthetic */ C24254yJ.e k;
        final /* synthetic */ InterfaceC7645Sp2 l;
        final /* synthetic */ boolean m;
        final /* synthetic */ InterfaceC14124hO4 n;
        final /* synthetic */ UA2 o;
        final /* synthetic */ int p;
        final /* synthetic */ int q;
        final /* synthetic */ int r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC10254bL2 interfaceC10254bL2, androidx.compose.ui.e eVar, C6021Lv3 c6021Lv3, TS4 ts4, boolean z, C24254yJ.m mVar, C24254yJ.e eVar2, InterfaceC7645Sp2 interfaceC7645Sp2, boolean z2, InterfaceC14124hO4 interfaceC14124hO4, UA2 ua2, int i, int i2, int i3) {
            super(2);
            this.e = interfaceC10254bL2;
            this.f = eVar;
            this.g = c6021Lv3;
            this.h = ts4;
            this.i = z;
            this.j = mVar;
            this.k = eVar2;
            this.l = interfaceC7645Sp2;
            this.m = z2;
            this.n = interfaceC14124hO4;
            this.o = ua2;
            this.p = i;
            this.q = i2;
            this.r = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC15050iv3.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, interfaceC22053ub1, QJ5.a(this.p | 1), QJ5.a(this.q), this.r);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.iv3$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC10254bL2 e;
        final /* synthetic */ C24254yJ.e f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC10254bL2 interfaceC10254bL2, C24254yJ.e eVar) {
            super(2);
            this.e = interfaceC10254bL2;
            this.f = eVar;
        }

        public final C4852Gv3 a(WH1 wh1, long j) {
            if (!(C17833ne1.l(j) != Integer.MAX_VALUE)) {
                P73.a("LazyVerticalGrid's width should be bound by parent.");
            }
            int iL = C17833ne1.l(j);
            InterfaceC10254bL2 interfaceC10254bL2 = this.e;
            C24254yJ.e eVar = this.f;
            int[] iArrL1 = AbstractC15401jX0.l1(interfaceC10254bL2.a(wh1, iL, wh1.B0(eVar.a())));
            int[] iArr = new int[iArrL1.length];
            eVar.b(wh1, iL, iArrL1, EnumC12613eu3.a, iArr);
            return new C4852Gv3(iArrL1, iArr);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((WH1) obj, ((C17833ne1) obj2).r());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.InterfaceC10254bL2 r33, androidx.compose.ui.e r34, ir.nasim.C6021Lv3 r35, ir.nasim.TS4 r36, boolean r37, ir.nasim.C24254yJ.m r38, ir.nasim.C24254yJ.e r39, ir.nasim.InterfaceC7645Sp2 r40, boolean r41, ir.nasim.InterfaceC14124hO4 r42, ir.nasim.UA2 r43, ir.nasim.InterfaceC22053ub1 r44, int r45, int r46, int r47) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15050iv3.a(ir.nasim.bL2, androidx.compose.ui.e, ir.nasim.Lv3, ir.nasim.TS4, boolean, ir.nasim.yJ$m, ir.nasim.yJ$e, ir.nasim.Sp2, boolean, ir.nasim.hO4, ir.nasim.UA2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    private static final InterfaceC5086Hv3 d(InterfaceC10254bL2 interfaceC10254bL2, C24254yJ.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-76500289, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:221)");
        }
        boolean z = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(interfaceC10254bL2)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(eVar)) || (i & 48) == 32);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new C12886fL2(new b(interfaceC10254bL2, eVar));
            interfaceC22053ub1.s(objB);
        }
        InterfaceC5086Hv3 interfaceC5086Hv3 = (InterfaceC5086Hv3) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC5086Hv3;
    }
}
