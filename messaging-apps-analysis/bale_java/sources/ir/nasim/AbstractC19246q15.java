package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC18655p15;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.q15, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19246q15 {
    public static final void a(char c, ArrayList arrayList, float[] fArr, int i) {
        int i2 = 0;
        switch (c) {
            case 'A':
                int i3 = i - 7;
                for (int i4 = 0; i4 <= i3; i4 += 7) {
                    arrayList.add(new AbstractC18655p15.a(fArr[i4], fArr[i4 + 1], fArr[i4 + 2], Float.compare(fArr[i4 + 3], 0.0f) != 0, Float.compare(fArr[i4 + 4], 0.0f) != 0, fArr[i4 + 5], fArr[i4 + 6]));
                }
                return;
            case 'C':
                int i5 = i - 6;
                while (i2 <= i5) {
                    arrayList.add(new AbstractC18655p15.c(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], fArr[i2 + 4], fArr[i2 + 5]));
                    i2 += 6;
                }
                return;
            case 'H':
                int i6 = i - 1;
                while (i2 <= i6) {
                    arrayList.add(new AbstractC18655p15.d(fArr[i2]));
                    i2++;
                }
                return;
            case WKSRecord.Protocol.BR_SAT_MON /* 76 */:
                int i7 = i - 2;
                while (i2 <= i7) {
                    arrayList.add(new AbstractC18655p15.e(fArr[i2], fArr[i2 + 1]));
                    i2 += 2;
                }
                return;
            case 'M':
                b(arrayList, fArr, i);
                return;
            case 'Q':
                int i8 = i - 4;
                while (i2 <= i8) {
                    arrayList.add(new AbstractC18655p15.g(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                    i2 += 4;
                }
                return;
            case SetRpcStruct$ComposedRpc.TERMINATE_ALL_SESSIONS_FIELD_NUMBER /* 83 */:
                int i9 = i - 4;
                while (i2 <= i9) {
                    arrayList.add(new AbstractC18655p15.h(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                    i2 += 4;
                }
                return;
            case SetRpcStruct$ComposedRpc.SIGN_OUT_FIELD_NUMBER /* 84 */:
                int i10 = i - 2;
                while (i2 <= i10) {
                    arrayList.add(new AbstractC18655p15.i(fArr[i2], fArr[i2 + 1]));
                    i2 += 2;
                }
                return;
            case 'V':
                int i11 = i - 1;
                while (i2 <= i11) {
                    arrayList.add(new AbstractC18655p15.s(fArr[i2]));
                    i2++;
                }
                return;
            case AppMetricaDefaultValues.DEFAULT_DISPATCH_PERIOD_SECONDS /* 90 */:
            case 'z':
                arrayList.add(AbstractC18655p15.b.c);
                return;
            case WKSRecord.Service.SWIFT_RVF /* 97 */:
                int i12 = i - 7;
                for (int i13 = 0; i13 <= i12; i13 += 7) {
                    arrayList.add(new AbstractC18655p15.j(fArr[i13], fArr[i13 + 1], fArr[i13 + 2], Float.compare(fArr[i13 + 3], 0.0f) != 0, Float.compare(fArr[i13 + 4], 0.0f) != 0, fArr[i13 + 5], fArr[i13 + 6]));
                }
                return;
            case 'c':
                int i14 = i - 6;
                while (i2 <= i14) {
                    arrayList.add(new AbstractC18655p15.k(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], fArr[i2 + 4], fArr[i2 + 5]));
                    i2 += 6;
                }
                return;
            case 'h':
                int i15 = i - 1;
                while (i2 <= i15) {
                    arrayList.add(new AbstractC18655p15.l(fArr[i2]));
                    i2++;
                }
                return;
            case Type.EUI48 /* 108 */:
                int i16 = i - 2;
                while (i2 <= i16) {
                    arrayList.add(new AbstractC18655p15.m(fArr[i2], fArr[i2 + 1]));
                    i2 += 2;
                }
                return;
            case 'm':
                c(arrayList, fArr, i);
                return;
            case 'q':
                int i17 = i - 4;
                while (i2 <= i17) {
                    arrayList.add(new AbstractC18655p15.o(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                    i2 += 4;
                }
                return;
            case 's':
                int i18 = i - 4;
                while (i2 <= i18) {
                    arrayList.add(new AbstractC18655p15.p(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                    i2 += 4;
                }
                return;
            case 't':
                int i19 = i - 2;
                while (i2 <= i19) {
                    arrayList.add(new AbstractC18655p15.q(fArr[i2], fArr[i2 + 1]));
                    i2 += 2;
                }
                return;
            case SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER /* 118 */:
                int i20 = i - 1;
                while (i2 <= i20) {
                    arrayList.add(new AbstractC18655p15.r(fArr[i2]));
                    i2++;
                }
                return;
            default:
                throw new IllegalArgumentException("Unknown command for: " + c);
        }
    }

    private static final void b(List list, float[] fArr, int i) {
        int i2 = i - 2;
        if (i2 >= 0) {
            list.add(new AbstractC18655p15.f(fArr[0], fArr[1]));
            for (int i3 = 2; i3 <= i2; i3 += 2) {
                list.add(new AbstractC18655p15.e(fArr[i3], fArr[i3 + 1]));
            }
        }
    }

    private static final void c(List list, float[] fArr, int i) {
        int i2 = i - 2;
        if (i2 >= 0) {
            list.add(new AbstractC18655p15.n(fArr[0], fArr[1]));
            for (int i3 = 2; i3 <= i2; i3 += 2) {
                list.add(new AbstractC18655p15.m(fArr[i3], fArr[i3 + 1]));
            }
        }
    }
}
