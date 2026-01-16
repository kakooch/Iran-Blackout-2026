package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import java.util.Calendar;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes5.dex */
public interface D50 extends InterfaceC4411Fa0 {
    default boolean I0(String str, String str2) {
        int[] iArrT = T(Calendar.getInstance().get(1), Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(5));
        int i = iArrT[0];
        int i2 = iArrT[1];
        int iIntValue = Integer.valueOf(str).intValue();
        return iIntValue == i ? Integer.valueOf(str2).intValue() < i2 : iIntValue <= i;
    }

    default int[] T(int i, int i2, int i3) {
        int i4;
        int i5 = 0;
        int[] iArr = {0, 31, 59, 90, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 151, SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER, 212, WKSRecord.Service.SUR_MEAS, 273, 304, 334};
        if (i > 1600) {
            i4 = i - 1600;
            i5 = 979;
        } else {
            i4 = i - 621;
        }
        int i6 = i2 > 2 ? i4 + 1 : i4;
        int i7 = (((((i4 * 365) + ((i6 + 3) / 4)) - ((i6 + 99) / 100)) + ((i6 + 399) / 400)) - 80) + i3 + iArr[i2 - 1];
        int i8 = i5 + ((i7 / 12053) * 33);
        int i9 = i7 % 12053;
        int i10 = i8 + ((i9 / 1461) * 4);
        int i11 = i9 % 1461;
        if (i11 > 365) {
            int i12 = i11 - 1;
            i10 += i12 / 365;
            i11 = i12 % 365;
        }
        return new int[]{i10, i11 < 186 ? (i11 / 31) + 1 : ((i11 - 186) / 30) + 7, (i11 < 186 ? i11 % 31 : (i11 - 186) % 30) + 1};
    }

    AbstractC20471s40 getBankCard();
}
