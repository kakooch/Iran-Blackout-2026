package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.eF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12226eF5 extends B1 {
    private static final int[] k = {7, 5, 4, 3, 1};
    private static final int[] l = {4, 20, 52, 104, SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER};
    private static final int[] m = {0, 348, 1388, 2948, 3988};
    private static final int[][] n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, 7, 21, 63}, new int[]{SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER, 13, 39, WKSRecord.Service.UUCP_PATH, WKSRecord.Service.EMFIS_DATA, 209, SetRpcStruct$ComposedRpc.EDIT_NICK_NAME_FIELD_NUMBER}, new int[]{SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, SetUpdatesStruct$ComposedUpdates.MESSAGE_QUOTED_CHANGED_FIELD_NUMBER, 85, 44, WKSRecord.Service.CISCO_SYS}, new int[]{185, WKSRecord.Service.STATSRV, 188, WKSRecord.Service.BL_IDM, 4, 12, 36, Type.EUI48}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, WKSRecord.Service.NETBIOS_DGM, 203, SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER, WKSRecord.Service.NETBIOS_SSN, SetRpcStruct$ComposedRpc.CHECK_NICK_NAME_FIELD_NUMBER, 196, 166}, new int[]{76, 17, 51, SetRpcStruct$ComposedRpc.GET_GROUP_STATE_FIELD_NUMBER, 37, WKSRecord.Service.SUNRPC, 122, 155}, new int[]{43, 129, 176, Type.L64, 107, 110, 119, SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER}, new int[]{16, 48, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, 10, 30, 90, 59, SetRpcStruct$ComposedRpc.GET_GROUP_INVITE_URL_FIELD_NUMBER}, new int[]{109, 116, 137, 200, SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 125, SetUpdatesStruct$ComposedUpdates.STICKER_COLLECTIONS_CHANGED_FIELD_NUMBER}, new int[]{70, 210, 208, 202, 184, 130, SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER, 115}, new int[]{134, SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER, 151, 31, 93, 68, SetRpcStruct$ComposedRpc.RESPONSE_GET_GROUP_DIFFERENCE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER, 64, 192, 154, 40}, new int[]{SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{SetUpdatesStruct$ComposedUpdates.OWN_STICKERS_CHANGED_FIELD_NUMBER, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List g = new ArrayList(11);
    private final List h = new ArrayList();
    private final int[] i = new int[2];
    private boolean j;

    private static boolean A(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            C16652le2 c16652le2 = (C16652le2) it.next();
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                C16061ke2 c16061ke2 = (C16061ke2) it2.next();
                Iterator it3 = c16652le2.a().iterator();
                while (it3.hasNext()) {
                    if (c16061ke2.equals((C16061ke2) it3.next())) {
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean B(List list) {
        for (int[] iArr : p) {
            if (list.size() <= iArr.length) {
                for (int i = 0; i < list.size(); i++) {
                    if (((C16061ke2) list.get(i)).b().c() != iArr[i]) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private C24550yo2 C(C3988Df0 c3988Df0, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.i[0] - 1;
            while (i5 >= 0 && !c3988Df0.i(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.i;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.i;
            int i7 = iArr2[0];
            int iM = c3988Df0.m(iArr2[1] + 1);
            i2 = iM;
            i3 = i7;
            i4 = iM - this.i[1];
        }
        int[] iArrI = i();
        System.arraycopy(iArrI, 0, iArrI, 1, iArrI.length - 1);
        iArrI[0] = i4;
        try {
            return new C24550yo2(B1.p(iArrI, n), new int[]{i3, i2}, i3, i2, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private static void D(List list, List list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            C16652le2 c16652le2 = (C16652le2) it.next();
            if (c16652le2.a().size() != list.size()) {
                Iterator it2 = c16652le2.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                    C16061ke2 c16061ke2 = (C16061ke2) it2.next();
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        if (c16061ke2.equals((C16061ke2) it3.next())) {
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void F(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private void G(int i, boolean z) {
        boolean zC = false;
        int i2 = 0;
        boolean zC2 = false;
        while (true) {
            if (i2 >= this.h.size()) {
                break;
            }
            C16652le2 c16652le2 = (C16652le2) this.h.get(i2);
            if (c16652le2.b() > i) {
                zC = c16652le2.c(this.g);
                break;
            } else {
                zC2 = c16652le2.c(this.g);
                i2++;
            }
        }
        if (zC || zC2 || A(this.g, this.h)) {
            return;
        }
        this.h.add(i2, new C16652le2(this.g, i, z));
        D(this.g, this.h);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q(int r11) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12226eF5.q(int):void");
    }

    private boolean r() {
        C16061ke2 c16061ke2 = (C16061ke2) this.g.get(0);
        C7491Ry1 c7491Ry1C = c16061ke2.c();
        C7491Ry1 c7491Ry1D = c16061ke2.d();
        if (c7491Ry1D == null) {
            return false;
        }
        int iA = c7491Ry1D.a();
        int i = 2;
        for (int i2 = 1; i2 < this.g.size(); i2++) {
            C16061ke2 c16061ke22 = (C16061ke2) this.g.get(i2);
            iA += c16061ke22.c().a();
            int i3 = i + 1;
            C7491Ry1 c7491Ry1D2 = c16061ke22.d();
            if (c7491Ry1D2 != null) {
                iA += c7491Ry1D2.a();
                i += 2;
            } else {
                i = i3;
            }
        }
        return ((i + (-4)) * 211) + (iA % 211) == c7491Ry1C.b();
    }

    private List s(List list, int i) throws NotFoundException {
        while (i < this.h.size()) {
            C16652le2 c16652le2 = (C16652le2) this.h.get(i);
            this.g.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.g.addAll(((C16652le2) it.next()).a());
            }
            this.g.addAll(c16652le2.a());
            if (B(this.g)) {
                if (r()) {
                    return this.g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(c16652le2);
                try {
                    return s(arrayList, i + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i++;
        }
        throw NotFoundException.a();
    }

    private List t(boolean z) {
        List listS = null;
        if (this.h.size() > 25) {
            this.h.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(this.h);
        }
        try {
            listS = s(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.h);
        }
        return listS;
    }

    static X06 u(List list) {
        String strD = P0.a(AbstractC4222Ef0.a(list)).d();
        C12092e16[] c12092e16ArrA = ((C16061ke2) list.get(0)).b().a();
        C12092e16[] c12092e16ArrA2 = ((C16061ke2) list.get(list.size() - 1)).b().a();
        return new X06(strD, null, new C12092e16[]{c12092e16ArrA[0], c12092e16ArrA[1], c12092e16ArrA2[0], c12092e16ArrA2[1]}, EnumC9549a90.RSS_EXPANDED);
    }

    private void x(C3988Df0 c3988Df0, List list, int i) throws NotFoundException {
        int[] iArrI = i();
        iArrI[0] = 0;
        iArrI[1] = 0;
        iArrI[2] = 0;
        iArrI[3] = 0;
        int iN = c3988Df0.n();
        if (i < 0) {
            i = list.isEmpty() ? 0 : ((C16061ke2) list.get(list.size() - 1)).b().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.j) {
            z = !z;
        }
        boolean z2 = false;
        while (i < iN) {
            z2 = !c3988Df0.i(i);
            if (!z2) {
                break;
            } else {
                i++;
            }
        }
        int i2 = 0;
        boolean z3 = z2;
        int i3 = i;
        while (i < iN) {
            if (c3988Df0.i(i) != z3) {
                iArrI[i2] = iArrI[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        F(iArrI);
                    }
                    if (B1.o(iArrI)) {
                        int[] iArr = this.i;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        F(iArrI);
                    }
                    i3 += iArrI[0] + iArrI[1];
                    iArrI[0] = iArrI[2];
                    iArrI[1] = iArrI[3];
                    iArrI[2] = 0;
                    iArrI[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArrI[i2] = 1;
                z3 = !z3;
            }
            i++;
        }
        throw NotFoundException.a();
    }

    private static int y(C3988Df0 c3988Df0, int i) {
        return c3988Df0.i(i) ? c3988Df0.l(c3988Df0.m(i)) : c3988Df0.m(c3988Df0.l(i));
    }

    private static boolean z(C24550yo2 c24550yo2, boolean z, boolean z2) {
        return (c24550yo2.c() == 0 && z && z2) ? false : true;
    }

    C16061ke2 E(C3988Df0 c3988Df0, List list, int i) throws NotFoundException {
        C24550yo2 c24550yo2C;
        C7491Ry1 c7491Ry1V;
        boolean z = list.size() % 2 == 0;
        if (this.j) {
            z = !z;
        }
        int iY = -1;
        boolean z2 = true;
        do {
            x(c3988Df0, list, iY);
            c24550yo2C = C(c3988Df0, i, z);
            if (c24550yo2C == null) {
                iY = y(c3988Df0, this.i[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        C7491Ry1 c7491Ry1V2 = v(c3988Df0, c24550yo2C, z, true);
        if (!list.isEmpty() && ((C16061ke2) list.get(list.size() - 1)).f()) {
            throw NotFoundException.a();
        }
        try {
            c7491Ry1V = v(c3988Df0, c24550yo2C, z, false);
        } catch (NotFoundException unused) {
            c7491Ry1V = null;
        }
        return new C16061ke2(c7491Ry1V2, c7491Ry1V, c24550yo2C, true);
    }

    @Override // ir.nasim.MK4
    public X06 b(int i, C3988Df0 c3988Df0, Map map) {
        this.g.clear();
        this.j = false;
        try {
            return u(w(i, c3988Df0));
        } catch (NotFoundException unused) {
            this.g.clear();
            this.j = true;
            return u(w(i, c3988Df0));
        }
    }

    @Override // ir.nasim.MK4, ir.nasim.BI5
    public void reset() {
        this.g.clear();
        this.h.clear();
    }

    C7491Ry1 v(C3988Df0 c3988Df0, C24550yo2 c24550yo2, boolean z, boolean z2) throws NotFoundException {
        int[] iArrH = h();
        for (int i = 0; i < iArrH.length; i++) {
            iArrH[i] = 0;
        }
        if (z2) {
            MK4.f(c3988Df0, c24550yo2.b()[0], iArrH);
        } else {
            MK4.e(c3988Df0, c24550yo2.b()[1], iArrH);
            int i2 = 0;
            for (int length = iArrH.length - 1; i2 < length; length--) {
                int i3 = iArrH[i2];
                iArrH[i2] = iArrH[length];
                iArrH[length] = i3;
                i2++;
            }
        }
        float fD = AbstractC23186wV3.d(iArrH) / 17.0f;
        float f = (c24550yo2.b()[1] - c24550yo2.b()[0]) / 15.0f;
        if (Math.abs(fD - f) / f > 0.3f) {
            throw NotFoundException.a();
        }
        int[] iArrL = l();
        int[] iArrJ = j();
        float[] fArrM = m();
        float[] fArrK = k();
        for (int i4 = 0; i4 < iArrH.length; i4++) {
            float f2 = (iArrH[i4] * 1.0f) / fD;
            int i5 = (int) (0.5f + f2);
            if (i5 <= 0) {
                if (f2 < 0.3f) {
                    throw NotFoundException.a();
                }
                i5 = 1;
            } else if (i5 > 8) {
                if (f2 > 8.7f) {
                    throw NotFoundException.a();
                }
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                iArrL[i6] = i5;
                fArrM[i6] = f2 - i5;
            } else {
                iArrJ[i6] = i5;
                fArrK[i6] = f2 - i5;
            }
        }
        q(17);
        int iC = (((c24550yo2.c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i7 = 0;
        int i8 = 0;
        for (int length2 = iArrL.length - 1; length2 >= 0; length2--) {
            if (z(c24550yo2, z, z2)) {
                i7 += iArrL[length2] * o[iC][length2 * 2];
            }
            i8 += iArrL[length2];
        }
        int i9 = 0;
        for (int length3 = iArrJ.length - 1; length3 >= 0; length3--) {
            if (z(c24550yo2, z, z2)) {
                i9 += iArrJ[length3] * o[iC][(length3 * 2) + 1];
            }
        }
        int i10 = i7 + i9;
        if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
            throw NotFoundException.a();
        }
        int i11 = (13 - i8) / 2;
        int i12 = k[i11];
        return new C7491Ry1((AbstractC12835fF5.b(iArrL, i12, true) * l[i11]) + AbstractC12835fF5.b(iArrJ, 9 - i12, false) + m[i11], i10);
    }

    List w(int i, C3988Df0 c3988Df0) throws NotFoundException {
        boolean z = false;
        while (!z) {
            try {
                List list = this.g;
                list.add(E(c3988Df0, list, i));
            } catch (NotFoundException e) {
                if (this.g.isEmpty()) {
                    throw e;
                }
                z = true;
            }
        }
        if (r()) {
            return this.g;
        }
        boolean z2 = !this.h.isEmpty();
        G(i, false);
        if (z2) {
            List listT = t(false);
            if (listT != null) {
                return listT;
            }
            List listT2 = t(true);
            if (listT2 != null) {
                return listT2;
            }
        }
        throw NotFoundException.a();
    }
}
