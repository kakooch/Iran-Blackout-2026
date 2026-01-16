package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import ir.nasim.C3846Cp2;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.zp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC25154zp2 {

    /* renamed from: ir.nasim.zp2$a */
    public static final class a {
        public C3846Cp2 a;

        public a(C3846Cp2 c3846Cp2) {
            this.a = c3846Cp2;
        }
    }

    public static boolean a(InterfaceC9845af2 interfaceC9845af2) {
        EW4 ew4 = new EW4(4);
        interfaceC9845af2.m(ew4.e(), 0, 4);
        return ew4.H() == 1716281667;
    }

    public static int b(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        interfaceC9845af2.e();
        EW4 ew4 = new EW4(2);
        interfaceC9845af2.m(ew4.e(), 0, 2);
        int iL = ew4.L();
        if ((iL >> 2) == 16382) {
            interfaceC9845af2.e();
            return iL;
        }
        interfaceC9845af2.e();
        throw ParserException.a("First frame does not start with sync code.", null);
    }

    public static Metadata c(InterfaceC9845af2 interfaceC9845af2, boolean z) {
        Metadata metadataA = new F03().a(interfaceC9845af2, z ? null : E03.b);
        if (metadataA == null || metadataA.e() == 0) {
            return null;
        }
        return metadataA;
    }

    public static Metadata d(InterfaceC9845af2 interfaceC9845af2, boolean z) {
        interfaceC9845af2.e();
        long jG = interfaceC9845af2.g();
        Metadata metadataC = c(interfaceC9845af2, z);
        interfaceC9845af2.k((int) (interfaceC9845af2.g() - jG));
        return metadataC;
    }

    public static boolean e(InterfaceC9845af2 interfaceC9845af2, a aVar) {
        interfaceC9845af2.e();
        DW4 dw4 = new DW4(new byte[4]);
        interfaceC9845af2.m(dw4.a, 0, 4);
        boolean zG = dw4.g();
        int iH = dw4.h(7);
        int iH2 = dw4.h(24) + 4;
        if (iH == 0) {
            aVar.a = h(interfaceC9845af2);
        } else {
            C3846Cp2 c3846Cp2 = aVar.a;
            if (c3846Cp2 == null) {
                throw new IllegalArgumentException();
            }
            if (iH == 3) {
                aVar.a = c3846Cp2.b(f(interfaceC9845af2, iH2));
            } else if (iH == 4) {
                aVar.a = c3846Cp2.c(j(interfaceC9845af2, iH2));
            } else if (iH == 6) {
                EW4 ew4 = new EW4(iH2);
                interfaceC9845af2.readFully(ew4.e(), 0, iH2);
                ew4.T(4);
                aVar.a = c3846Cp2.a(AbstractC12710f43.W(PictureFrame.a(ew4)));
            } else {
                interfaceC9845af2.k(iH2);
            }
        }
        return zG;
    }

    private static C3846Cp2.a f(InterfaceC9845af2 interfaceC9845af2, int i) {
        EW4 ew4 = new EW4(i);
        interfaceC9845af2.readFully(ew4.e(), 0, i);
        return g(ew4);
    }

    public static C3846Cp2.a g(EW4 ew4) {
        ew4.T(1);
        int I = ew4.I();
        long jF = ew4.f() + I;
        int i = I / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long jY = ew4.y();
            if (jY == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jY;
            jArrCopyOf2[i2] = ew4.y();
            ew4.T(2);
            i2++;
        }
        ew4.T((int) (jF - ew4.f()));
        return new C3846Cp2.a(jArrCopyOf, jArrCopyOf2);
    }

    private static C3846Cp2 h(InterfaceC9845af2 interfaceC9845af2) {
        byte[] bArr = new byte[38];
        interfaceC9845af2.readFully(bArr, 0, 38);
        return new C3846Cp2(bArr, 4);
    }

    public static void i(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        EW4 ew4 = new EW4(4);
        interfaceC9845af2.readFully(ew4.e(), 0, 4);
        if (ew4.H() != 1716281667) {
            throw ParserException.a("Failed to read FLAC stream marker.", null);
        }
    }

    private static List j(InterfaceC9845af2 interfaceC9845af2, int i) {
        EW4 ew4 = new EW4(i);
        interfaceC9845af2.readFully(ew4.e(), 0, i);
        ew4.T(4);
        return Arrays.asList(AbstractC16294l18.j(ew4, false, false).b);
    }
}
