package ir.nasim;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.x48, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC23532x48 {

    /* renamed from: ir.nasim.x48$a */
    private static final class a {
        public final int a;
        public final long b;

        private a(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public static a a(InterfaceC9845af2 interfaceC9845af2, EW4 ew4) {
            interfaceC9845af2.m(ew4.e(), 0, 8);
            ew4.S(0);
            return new a(ew4.o(), ew4.v());
        }
    }

    public static boolean a(InterfaceC9845af2 interfaceC9845af2) {
        EW4 ew4 = new EW4(8);
        int i = a.a(interfaceC9845af2, ew4).a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        interfaceC9845af2.m(ew4.e(), 0, 4);
        ew4.S(0);
        int iO = ew4.o();
        if (iO == 1463899717) {
            return true;
        }
        AbstractC18815pI3.c("WavHeaderReader", "Unsupported form type: " + iO);
        return false;
    }

    public static C22942w48 b(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        byte[] bArr;
        EW4 ew4 = new EW4(16);
        a aVarD = d(1718449184, interfaceC9845af2, ew4);
        AbstractC20011rK.g(aVarD.b >= 16);
        interfaceC9845af2.m(ew4.e(), 0, 16);
        ew4.S(0);
        int iX = ew4.x();
        int iX2 = ew4.x();
        int iW = ew4.w();
        int iW2 = ew4.w();
        int iX3 = ew4.x();
        int iX4 = ew4.x();
        int i = ((int) aVarD.b) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            interfaceC9845af2.m(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = AbstractC9683aN7.f;
        }
        interfaceC9845af2.k((int) (interfaceC9845af2.g() - interfaceC9845af2.getPosition()));
        return new C22942w48(iX, iX2, iW, iW2, iX3, iX4, bArr);
    }

    public static long c(InterfaceC9845af2 interfaceC9845af2) {
        EW4 ew4 = new EW4(8);
        a aVarA = a.a(interfaceC9845af2, ew4);
        if (aVarA.a != 1685272116) {
            interfaceC9845af2.e();
            return -1L;
        }
        interfaceC9845af2.h(8);
        ew4.S(0);
        interfaceC9845af2.m(ew4.e(), 0, 8);
        long jT = ew4.t();
        interfaceC9845af2.k(((int) aVarA.b) + 8);
        return jT;
    }

    private static a d(int i, InterfaceC9845af2 interfaceC9845af2, EW4 ew4) throws ParserException {
        a aVarA = a.a(interfaceC9845af2, ew4);
        while (aVarA.a != i) {
            AbstractC18815pI3.k("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.a);
            long j = aVarA.b + 8;
            if (j > TTL.MAX_VALUE) {
                throw ParserException.d("Chunk is too large (~2GB+) to skip; id: " + aVarA.a);
            }
            interfaceC9845af2.k((int) j);
            aVarA = a.a(interfaceC9845af2, ew4);
        }
        return aVarA;
    }

    public static Pair e(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        interfaceC9845af2.e();
        a aVarD = d(1684108385, interfaceC9845af2, new EW4(8));
        interfaceC9845af2.k(8);
        return Pair.create(Long.valueOf(interfaceC9845af2.getPosition()), Long.valueOf(aVarD.b));
    }
}
