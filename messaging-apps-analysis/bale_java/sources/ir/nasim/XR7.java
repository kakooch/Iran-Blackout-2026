package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.zxing.FormatException;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public final class XR7 {
    private static final XR7[] h = a();
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final c f;
    private final int g;

    static final class b {
        private final int a;
        private final int b;

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }

        private b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    private XR7(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.g = iA;
    }

    private static XR7[] a() {
        int i = 1;
        int i2 = 5;
        XR7 xr7 = new XR7(1, 10, 10, 8, 8, new c(i2, new b(i, 3)));
        XR7 xr72 = new XR7(2, 12, 12, 10, 10, new c(7, new b(i, i2)));
        XR7 xr73 = new XR7(3, 14, 14, 12, 12, new c(10, new b(i, 8)));
        int i3 = 12;
        XR7 xr74 = new XR7(4, 16, 16, 14, 14, new c(i3, new b(i, i3)));
        int i4 = 18;
        XR7 xr75 = new XR7(5, 18, 18, 16, 16, new c(14, new b(i, i4)));
        XR7 xr76 = new XR7(6, 20, 20, 18, 18, new c(i4, new b(i, 22)));
        XR7 xr77 = new XR7(7, 22, 22, 20, 20, new c(20, new b(i, 30)));
        int i5 = 36;
        XR7 xr78 = new XR7(8, 24, 24, 22, 22, new c(24, new b(i, i5)));
        XR7 xr79 = new XR7(9, 26, 26, 24, 24, new c(28, new b(i, 44)));
        XR7 xr710 = new XR7(10, 32, 32, 14, 14, new c(i5, new b(i, 62)));
        int i6 = 42;
        int i7 = 56;
        int i8 = 2;
        int i9 = 4;
        return new XR7[]{xr7, xr72, xr73, xr74, xr75, xr76, xr77, xr78, xr79, xr710, new XR7(11, 36, 36, 16, 16, new c(i6, new b(i, 86))), new XR7(12, 40, 40, 18, 18, new c(48, new b(i, 114))), new XR7(13, 44, 44, 20, 20, new c(i7, new b(i, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER))), new XR7(14, 48, 48, 22, 22, new c(68, new b(i, 174))), new XR7(15, 52, 52, 24, 24, new c(i6, new b(i8, 102))), new XR7(16, 64, 64, 14, 14, new c(i7, new b(i8, WKSRecord.Service.EMFIS_DATA))), new XR7(17, 72, 72, 16, 16, new c(36, new b(i9, 92))), new XR7(18, 80, 80, 18, 18, new c(48, new b(i9, 114))), new XR7(19, 88, 88, 20, 20, new c(i7, new b(i9, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER))), new XR7(20, 96, 96, 22, 22, new c(68, new b(i9, 174))), new XR7(21, 104, 104, 24, 24, new c(i7, new b(6, 136))), new XR7(22, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 18, 18, new c(68, new b(6, 175))), new XR7(23, WKSRecord.Service.CISCO_SYS, WKSRecord.Service.CISCO_SYS, 20, 20, new c(62, new b(8, SetUpdatesStruct$ComposedUpdates.MESSAGE_DATE_CHANGED_FIELD_NUMBER))), new XR7(24, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_MY_TIME_ZONE_FIELD_NUMBER, 22, 22, new c(62, new b(8, 156), new b(i8, 155))), new XR7(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new XR7(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new XR7(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new XR7(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new XR7(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new XR7(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public static XR7 h(int i, int i2) throws FormatException {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw FormatException.a();
        }
        for (XR7 xr7 : h) {
            if (xr7.b == i && xr7.c == i2) {
                return xr7;
            }
        }
        throw FormatException.a();
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    c d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.g;
    }

    public int i() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(this.a);
    }

    static final class c {
        private final int a;
        private final b[] b;

        b[] a() {
            return this.b;
        }

        int b() {
            return this.a;
        }

        private c(int i, b bVar) {
            this.a = i;
            this.b = new b[]{bVar};
        }

        private c(int i, b bVar, b bVar2) {
            this.a = i;
            this.b = new b[]{bVar, bVar2};
        }
    }
}
