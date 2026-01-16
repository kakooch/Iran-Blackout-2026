package ir.nasim;

import okhttp3.internal.ws.RealWebSocket;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.oH6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C18218oH6 {
    private final EW4 a = new EW4(8);
    private int b;

    private long a(InterfaceC9845af2 interfaceC9845af2) {
        int i = 0;
        interfaceC9845af2.m(this.a.e(), 0, 1);
        int i2 = this.a.e()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        interfaceC9845af2.m(this.a.e(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.e()[i] & 255) + (i5 << 8);
        }
        this.b += i4 + 1;
        return i5;
    }

    public boolean b(InterfaceC9845af2 interfaceC9845af2) {
        long length = interfaceC9845af2.getLength();
        long j = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (length != -1 && length <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            j = length;
        }
        int i = (int) j;
        interfaceC9845af2.m(this.a.e(), 0, 4);
        long jH = this.a.H();
        this.b = 4;
        while (jH != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            interfaceC9845af2.m(this.a.e(), 0, 1);
            jH = ((jH << 8) & (-256)) | (this.a.e()[0] & 255);
        }
        long jA = a(interfaceC9845af2);
        long j2 = this.b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j2 + jA >= length) {
            return false;
        }
        while (true) {
            int i3 = this.b;
            long j3 = j2 + jA;
            if (i3 >= j3) {
                return ((long) i3) == j3;
            }
            if (a(interfaceC9845af2) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = a(interfaceC9845af2);
            if (jA2 < 0 || jA2 > TTL.MAX_VALUE) {
                break;
            }
            if (jA2 != 0) {
                int i4 = (int) jA2;
                interfaceC9845af2.h(i4);
                this.b += i4;
            }
        }
        return false;
    }
}
