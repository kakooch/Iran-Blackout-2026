package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC3769Cg6;
import ir.nasim.C13245fu;
import ir.nasim.PI7;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.mxp.entity.PuppetUser;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ig6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC14904ig6 {

    /* renamed from: ir.nasim.ig6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.ig6$b */
    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Integer.valueOf(((PuppetUser) obj).getIr.nasim.database.dailogLists.DialogEntity.COLUMN_PUPPET_TYPE java.lang.String().r()), Integer.valueOf(((PuppetUser) obj2).getIr.nasim.database.dailogLists.DialogEntity.COLUMN_PUPPET_TYPE java.lang.String().r()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(AbstractC3769Cg6 abstractC3769Cg6, String str, androidx.compose.ui.e eVar, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, boolean z, boolean z2, UA2 ua25, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(abstractC3769Cg6, "$searchEntity");
        AbstractC13042fc3.i(ua25, "$onClickItem");
        o(abstractC3769Cg6, str, eVar, ua2, ua22, ua23, ua24, z, z2, ua25, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final float B(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Number) interfaceC9102Ym4.getValue()).floatValue();
    }

    private static final void C(InterfaceC9102Ym4 interfaceC9102Ym4, float f) {
        interfaceC9102Ym4.setValue(Float.valueOf(f));
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x023b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void D(final ir.nasim.AbstractC3769Cg6 r30, final boolean r31, final boolean r32, final ir.nasim.UA2 r33, ir.nasim.InterfaceC22053ub1 r34, final int r35) {
        /*
            Method dump skipped, instructions count: 723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14904ig6.D(ir.nasim.Cg6, boolean, boolean, ir.nasim.UA2, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(UA2 ua2, InterfaceC11379cu3 interfaceC11379cu3) {
        AbstractC13042fc3.i(ua2, "$onGloballyPositioned");
        AbstractC13042fc3.i(interfaceC11379cu3, "it");
        ua2.invoke(Float.valueOf(Float.intBitsToFloat((int) (AbstractC12000du3.a(interfaceC11379cu3).f() >> 32))));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(long j, long j2, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
        InterfaceC17460n02.L(interfaceC17460n02, j, OD6.h(interfaceC17460n02.d()) / 2, interfaceC17460n02.E1(), 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
        InterfaceC17460n02.L(interfaceC17460n02, j2, OD6.h(interfaceC17460n02.d()) / 3.0f, interfaceC17460n02.E1(), 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(AbstractC3769Cg6 abstractC3769Cg6, boolean z, boolean z2, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(abstractC3769Cg6, "$searchEntity");
        AbstractC13042fc3.i(ua2, "$onGloballyPositioned");
        D(abstractC3769Cg6, z, z2, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final String H(int i, boolean z, Context context, C11458d25 c11458d25, AbstractC17457n0 abstractC17457n0, boolean z2, boolean z3) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(abstractC17457n0, "content");
        if (i == 0) {
            return "";
        }
        String strB = abstractC17457n0.b(context, i, null, z);
        if (c11458d25.s() == W25.b && z && !(abstractC17457n0 instanceof AbstractC12586er6) && z2) {
            strB = AbstractC20655sN7.e(context, i, null, false, 6, null) + ": " + strB;
        }
        return z3 ? C15903kN1.a.e(strB).toString() : strB;
    }

    public static /* synthetic */ String I(int i, boolean z, Context context, C11458d25 c11458d25, AbstractC17457n0 abstractC17457n0, boolean z2, boolean z3, int i2, Object obj) {
        return H(i, z, context, c11458d25, abstractC17457n0, (i2 & 32) != 0 ? true : z2, (i2 & 64) != 0 ? true : z3);
    }

    private static final C13245fu J(String str, String str2, long j) {
        if (str2 == null || str2.length() == 0) {
            return new C13245fu.b(str).o();
        }
        C13245fu.b bVar = new C13245fu.b(str);
        int iL0 = AbstractC20762sZ6.l0(str, str2, 0, true, 2, null);
        while (iL0 >= 0) {
            bVar.b(new C12863fI6(j, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null), iL0, str2.length() + iL0);
            iL0 = AbstractC20762sZ6.h0(str, str2, iL0 + str2.length(), true);
        }
        return bVar.o();
    }

    private static final String K(AbstractC3769Cg6 abstractC3769Cg6, InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
        String strB;
        String strB2;
        String strB3;
        String strB4;
        String strF;
        interfaceC22053ub1.W(1208953140);
        String strA0 = "";
        String str = null;
        if (abstractC3769Cg6 instanceof AbstractC3769Cg6.c) {
            interfaceC22053ub1.W(-1356002274);
            AbstractC3769Cg6.c cVar = (AbstractC3769Cg6.c) abstractC3769Cg6;
            if (cVar.d().getPeerId() != AbstractC5969Lp4.f()) {
                if (!cVar.h() || (strF = cVar.f()) == null || strF.length() == 0) {
                    strA0 = XY6.v(C14593iA1.y((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g()), (PI7) AbstractC10222bH6.a(cVar.g(), new PI7(PI7.a.EMPTY, 0L, C11458d25.E(cVar.d().getPeerId()), true), null, interfaceC22053ub1, 0, 2).getValue(), false, 4, null));
                } else {
                    strA0 = "\u200e@" + cVar.f();
                }
            }
            interfaceC22053ub1.Q();
        } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.g) {
            interfaceC22053ub1.W(-1355509684);
            AbstractC3769Cg6.g gVar = (AbstractC3769Cg6.g) abstractC3769Cg6;
            String strF2 = gVar.f();
            if (strF2 == null || strF2.length() == 0) {
                interfaceC22053ub1.W(-1355473507);
                strB4 = UY6.b(AbstractC17590nD5.group_chat_members_count, gVar.g(), new Object[]{XY6.v(AbstractC20655sN7.g(gVar.g()))}, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-1355228297);
                strB4 = UY6.b(AbstractC17590nD5.group_chat_members_count, gVar.g(), new Object[]{XY6.v(AbstractC20655sN7.g(gVar.g()))}, interfaceC22053ub1, 0) + " | \u200e@" + gVar.f();
                interfaceC22053ub1.Q();
            }
            strA0 = strB4;
            interfaceC22053ub1.Q();
        } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.b) {
            interfaceC22053ub1.W(-1354905556);
            AbstractC3769Cg6.b bVar = (AbstractC3769Cg6.b) abstractC3769Cg6;
            String strF3 = bVar.f();
            if (strF3 == null || strF3.length() == 0) {
                interfaceC22053ub1.W(-1354869379);
                strB3 = UY6.b(AbstractC17590nD5.group_chat_members_count, bVar.g(), new Object[]{XY6.v(AbstractC20655sN7.g(bVar.g()))}, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-1354624169);
                strB3 = UY6.b(AbstractC17590nD5.group_chat_members_count, bVar.g(), new Object[]{XY6.v(AbstractC20655sN7.g(bVar.g()))}, interfaceC22053ub1, 0) + " | \u200e@" + bVar.f();
                interfaceC22053ub1.Q();
            }
            strA0 = strB3;
            interfaceC22053ub1.Q();
        } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.f) {
            interfaceC22053ub1.W(-1354297460);
            AbstractC3769Cg6.f fVar = (AbstractC3769Cg6.f) abstractC3769Cg6;
            String strF4 = fVar.f();
            if (strF4 == null || strF4.length() == 0) {
                interfaceC22053ub1.W(-1354261283);
                strB2 = UY6.b(AbstractC17590nD5.group_chat_members_count, fVar.g(), new Object[]{XY6.v(AbstractC20655sN7.g(fVar.g()))}, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-1354016073);
                strB2 = UY6.b(AbstractC17590nD5.group_chat_members_count, fVar.g(), new Object[]{XY6.v(AbstractC20655sN7.g(fVar.g()))}, interfaceC22053ub1, 0) + " | \u200e@" + fVar.f();
                interfaceC22053ub1.Q();
            }
            strA0 = strB2;
            interfaceC22053ub1.Q();
        } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.e) {
            interfaceC22053ub1.W(-1353687380);
            AbstractC3769Cg6.e eVar = (AbstractC3769Cg6.e) abstractC3769Cg6;
            String strF5 = eVar.f();
            if (strF5 == null || strF5.length() == 0) {
                interfaceC22053ub1.W(-1353651203);
                strB = UY6.b(AbstractC17590nD5.group_chat_members_count, eVar.g(), new Object[]{XY6.v(AbstractC20655sN7.g(eVar.g()))}, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-1353405993);
                strB = UY6.b(AbstractC17590nD5.group_chat_members_count, eVar.g(), new Object[]{XY6.v(AbstractC20655sN7.g(eVar.g()))}, interfaceC22053ub1, 0) + " | \u200e@" + eVar.f();
                interfaceC22053ub1.Q();
            }
            strA0 = strB;
            interfaceC22053ub1.Q();
        } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.a) {
            interfaceC22053ub1.W(-1353090909);
            AbstractC3769Cg6.a aVar = (AbstractC3769Cg6.a) abstractC3769Cg6;
            String strF6 = aVar.f();
            String strV = strF6 != null ? XY6.v(strF6) : null;
            interfaceC22053ub1.W(926185215);
            String strD = strV == null ? null : UY6.d(AbstractC12217eE5.bot_monthly_users, new Object[]{strV}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
            if (strD == null) {
                strD = UY6.c(AbstractC12217eE5.bot, interfaceC22053ub1, 0);
            }
            String strH = aVar.h();
            if (strH != null) {
                str = "\u200e@" + strH;
            }
            String strH2 = aVar.h();
            if (strH2 == null || strH2.length() == 0) {
                strA0 = strD;
            } else {
                String strF7 = aVar.f();
                if (strF7 != null && !AbstractC20762sZ6.n0(strF7)) {
                    strA0 = strD + " | " + str;
                } else if (str != null) {
                    strA0 = str;
                }
            }
            interfaceC22053ub1.Q();
        } else if (abstractC3769Cg6 instanceof AbstractC3769Cg6.i) {
            interfaceC22053ub1.W(926205350);
            AbstractC3769Cg6.i iVar = (AbstractC3769Cg6.i) abstractC3769Cg6;
            strA0 = AbstractC15401jX0.A0(AbstractC20762sZ6.u0(I(iVar.i(), iVar.c() == ExPeerType.GROUP, (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g()), iVar.d(), iVar.f(), false, false, 96, null)), Separators.SP, null, null, 0, null, null, 62, null);
            interfaceC22053ub1.Q();
        } else if ((abstractC3769Cg6 instanceof AbstractC3769Cg6.h) || AbstractC13042fc3.d(abstractC3769Cg6, AbstractC3769Cg6.d.a)) {
            interfaceC22053ub1.W(-1352339223);
            interfaceC22053ub1.Q();
        } else {
            if (!(abstractC3769Cg6 instanceof AbstractC3769Cg6.j)) {
                interfaceC22053ub1.W(926091110);
                interfaceC22053ub1.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.W(926212039);
            List listA1 = AbstractC15401jX0.a1(((AbstractC3769Cg6.j) abstractC3769Cg6).f().getPuppets(), new b());
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listA1, 10));
            Iterator it = listA1.iterator();
            while (it.hasNext()) {
                arrayList.add(UY6.c(((PuppetUser) it.next()).getIr.nasim.database.dailogLists.DialogEntity.COLUMN_PUPPET_TYPE java.lang.String().q(), interfaceC22053ub1, 0));
            }
            strA0 = AbstractC15401jX0.A0(arrayList, ", ", null, null, 0, null, null, 62, null);
            interfaceC22053ub1.Q();
        }
        interfaceC22053ub1.Q();
        return strA0;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0884  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0bfd  */
    /* JADX WARN: Removed duplicated region for block: B:378:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final ir.nasim.AbstractC3769Cg6 r83, java.lang.String r84, androidx.compose.ui.e r85, ir.nasim.UA2 r86, ir.nasim.UA2 r87, ir.nasim.UA2 r88, ir.nasim.UA2 r89, boolean r90, boolean r91, final ir.nasim.UA2 r92, ir.nasim.InterfaceC22053ub1 r93, final int r94, final int r95) {
        /*
            Method dump skipped, instructions count: 3087
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14904ig6.o(ir.nasim.Cg6, java.lang.String, androidx.compose.ui.e, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.UA2, boolean, boolean, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(UA2 ua2, AbstractC3769Cg6 abstractC3769Cg6) {
        AbstractC13042fc3.i(abstractC3769Cg6, "$searchEntity");
        if (ua2 != null) {
            ua2.invoke(abstractC3769Cg6);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(UA2 ua2, AbstractC3769Cg6 abstractC3769Cg6) {
        AbstractC13042fc3.i(ua2, "$onClickItem");
        AbstractC13042fc3.i(abstractC3769Cg6, "$searchEntity");
        ua2.invoke(abstractC3769Cg6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(long j, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$strokeWidth$delegate");
        AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
        long jE = ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L));
        float fB = B(interfaceC9102Ym4);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
        InterfaceC17460n02.V0(interfaceC17460n02, j, jE, ZG4.e((Float.floatToRawIntBits(fB) << 32) | (4294967295L & Float.floatToRawIntBits(fIntBitsToFloat2))), interfaceC17460n02.w1(C17784nZ1.q(1)), 0, null, 0.0f, null, 0, 496, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(InterfaceC9102Ym4 interfaceC9102Ym4, float f) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$strokeWidth$delegate");
        C(interfaceC9102Ym4, f);
        return C19938rB7.a;
    }

    private static final boolean v(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(UA2 ua2, AbstractC3769Cg6 abstractC3769Cg6) {
        AbstractC13042fc3.i(abstractC3769Cg6, "$searchEntity");
        ua2.invoke(abstractC3769Cg6.d());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(AbstractC3769Cg6 abstractC3769Cg6, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(abstractC3769Cg6, "$searchEntity");
        AbstractC3769Cg6.a aVar = (AbstractC3769Cg6.a) abstractC3769Cg6;
        if (aVar.g()) {
            ua2.invoke(aVar.d());
        } else {
            ua22.invoke(aVar.d());
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(AbstractC3769Cg6 abstractC3769Cg6, String str, androidx.compose.ui.e eVar, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, boolean z, boolean z2, UA2 ua25, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(abstractC3769Cg6, "$searchEntity");
        AbstractC13042fc3.i(ua25, "$onClickItem");
        o(abstractC3769Cg6, str, eVar, ua2, ua22, ua23, ua24, z, z2, ua25, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "it");
        return C19938rB7.a;
    }
}
