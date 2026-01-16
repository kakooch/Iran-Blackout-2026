package ir.nasim;

import com.google.android.exoplayer2.X;

/* loaded from: classes2.dex */
final class TX6 implements InterfaceC23772xV {
    public final com.google.android.exoplayer2.X a;

    public TX6(com.google.android.exoplayer2.X x) {
        this.a = x;
    }

    private static String a(int i) {
        switch (i) {
            case 808802372:
            case 877677894:
            case 1145656883:
            case 1145656920:
            case 1482049860:
            case 1684633208:
            case 2021026148:
                return "video/mp4v-es";
            case 826496577:
            case 828601953:
            case 875967048:
                return "video/avc";
            case 842289229:
                return "video/mp42";
            case 859066445:
                return "video/mp43";
            case 1196444237:
            case 1735420525:
                return "video/mjpeg";
            default:
                return null;
        }
    }

    private static String b(int i) {
        if (i == 1) {
            return "audio/raw";
        }
        if (i == 85) {
            return "audio/mpeg";
        }
        if (i == 255) {
            return "audio/mp4a-latm";
        }
        if (i == 8192) {
            return "audio/ac3";
        }
        if (i != 8193) {
            return null;
        }
        return "audio/vnd.dts";
    }

    private static InterfaceC23772xV c(EW4 ew4) {
        ew4.T(4);
        int iS = ew4.s();
        int iS2 = ew4.s();
        ew4.T(4);
        int iS3 = ew4.s();
        String strA = a(iS3);
        if (strA != null) {
            X.b bVar = new X.b();
            bVar.n0(iS).S(iS2).g0(strA);
            return new TX6(bVar.G());
        }
        AbstractC18815pI3.k("StreamFormatChunk", "Ignoring track with unsupported compression " + iS3);
        return null;
    }

    public static InterfaceC23772xV d(int i, EW4 ew4) {
        if (i == 2) {
            return c(ew4);
        }
        if (i == 1) {
            return e(ew4);
        }
        AbstractC18815pI3.k("StreamFormatChunk", "Ignoring strf box for unsupported track type: " + AbstractC9683aN7.k0(i));
        return null;
    }

    private static InterfaceC23772xV e(EW4 ew4) {
        int iX = ew4.x();
        String strB = b(iX);
        if (strB == null) {
            AbstractC18815pI3.k("StreamFormatChunk", "Ignoring track with unsupported format tag " + iX);
            return null;
        }
        int iX2 = ew4.x();
        int iS = ew4.s();
        ew4.T(6);
        int iA0 = AbstractC9683aN7.a0(ew4.L());
        int iX3 = ew4.x();
        byte[] bArr = new byte[iX3];
        ew4.j(bArr, 0, iX3);
        X.b bVar = new X.b();
        bVar.g0(strB).J(iX2).h0(iS);
        if ("audio/raw".equals(strB) && iA0 != 0) {
            bVar.a0(iA0);
        }
        if ("audio/mp4a-latm".equals(strB) && iX3 > 0) {
            bVar.V(AbstractC12710f43.W(bArr));
        }
        return new TX6(bVar.G());
    }

    @Override // ir.nasim.InterfaceC23772xV
    public int getType() {
        return 1718776947;
    }
}
