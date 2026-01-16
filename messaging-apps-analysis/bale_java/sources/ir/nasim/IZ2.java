package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ir.nasim.features.audioplayer.audioinfo.mp3.ID3v2Exception;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class IZ2 extends QN {
    static final Logger x = Logger.getLogger(IZ2.class.getName());
    private final Level v;
    private byte w;

    static class a {
        final byte a;
        final String b;
        final String c;
        final byte[] d;

        public a(byte b, String str, String str2, byte[] bArr) {
            this.a = b;
            this.b = str;
            this.c = str2;
            this.d = bArr;
        }
    }

    static class b {
        final String a;
        final String b;
        final String c;

        public b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    public IZ2(InputStream inputStream, Level level) throws ID3v2Exception, IOException {
        EZ2 ez2B;
        long jE;
        this.v = level;
        if (v(inputStream)) {
            KZ2 kz2 = new KZ2(inputStream);
            this.a = "ID3";
            this.b = String.format("2.%d.%d", Integer.valueOf(kz2.c()), Integer.valueOf(kz2.b()));
            JZ2 jz2D = kz2.d(inputStream);
            while (true) {
                try {
                    if (jz2D.d() <= 10) {
                        break;
                    }
                    HZ2 hz2 = new HZ2(jz2D);
                    if (hz2.g()) {
                        break;
                    }
                    if (hz2.a() > jz2D.d()) {
                        Logger logger = x;
                        if (logger.isLoggable(level)) {
                            logger.log(level, "ID3 frame claims to extend frames area");
                        }
                    } else if (!hz2.i() || hz2.f()) {
                        jz2D.b().f(hz2.a());
                    } else {
                        GZ2 gz2A = jz2D.a(hz2);
                        try {
                            try {
                                y(gz2A);
                                ez2B = gz2A.b();
                                jE = gz2A.e();
                            } catch (Throwable th) {
                                gz2A.b().f(gz2A.e());
                                throw th;
                            }
                        } catch (ID3v2Exception e) {
                            if (x.isLoggable(level)) {
                                x.log(level, String.format("ID3 exception occured in frame %s: %s", hz2.c(), e.getMessage()));
                            }
                            ez2B = gz2A.b();
                            jE = gz2A.e();
                        }
                        ez2B.f(jE);
                    }
                } catch (ID3v2Exception e2) {
                    Logger logger2 = x;
                    if (logger2.isLoggable(level)) {
                        logger2.log(level, "ID3 exception occured: " + e2.getMessage());
                    }
                }
            }
            jz2D.b().f(jz2D.d());
            if (kz2.a() > 0) {
                inputStream.skip(kz2.a());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean v(java.io.InputStream r2) throws java.io.IOException {
        /*
            r0 = 3
            r2.mark(r0)
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L1e
            r1 = 73
            if (r0 != r1) goto L20
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L1e
            r1 = 68
            if (r0 != r1) goto L20
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L1e
            r1 = 51
            if (r0 != r1) goto L20
            r0 = 1
            goto L21
        L1e:
            r0 = move-exception
            goto L25
        L20:
            r0 = 0
        L21:
            r2.reset()
            return r0
        L25:
            r2.reset()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.IZ2.v(java.io.InputStream):boolean");
    }

    a w(GZ2 gz2) throws ID3v2Exception, IOException {
        String strI;
        FZ2 fz2G = gz2.g();
        if (gz2.f().c() == 2) {
            String upperCase = gz2.h(3, FZ2.ISO_8859_1).toUpperCase();
            upperCase.hashCode();
            strI = !upperCase.equals("JPG") ? !upperCase.equals("PNG") ? "image/unknown" : "image/png" : "image/jpeg";
        } else {
            strI = gz2.i(20, FZ2.ISO_8859_1);
        }
        return new a(gz2.b().a(), gz2.i(200, fz2G), strI, gz2.b().c((int) gz2.e()));
    }

    b x(GZ2 gz2) throws ID3v2Exception, IOException {
        FZ2 fz2G = gz2.g();
        return new b(gz2.h(3, FZ2.ISO_8859_1), gz2.i(200, fz2G), gz2.h((int) gz2.e(), fz2G));
    }

    void y(GZ2 gz2) throws ID3v2Exception, IOException {
        String str;
        byte b2;
        CZ2 cz2P;
        int i;
        Logger logger = x;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, "Parsing frame: " + gz2.c().c());
        }
        String strC = gz2.c().c();
        strC.hashCode();
        switch (strC) {
            case "COM":
            case "COMM":
                b bVarX = x(gz2);
                if (this.j == null || (str = bVarX.b) == null || "".equals(str)) {
                    this.j = bVarX.c;
                    break;
                }
                break;
            case "PIC":
            case "APIC":
                if (this.t == null || this.w != 3) {
                    a aVarW = w(gz2);
                    if (this.t == null || (b2 = aVarW.a) == 3 || b2 == 0) {
                        try {
                            byte[] bArr = aVarW.d;
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            options.inSampleSize = 1;
                            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                            int i2 = options.outWidth;
                            if (i2 > 800 || options.outHeight > 800) {
                                for (int iMax = Math.max(i2, options.outHeight); iMax > 800; iMax /= 2) {
                                    options.inSampleSize *= 2;
                                }
                            }
                            options.inJustDecodeBounds = false;
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                            this.t = bitmapDecodeByteArray;
                            if (bitmapDecodeByteArray != null) {
                                float fMax = Math.max(bitmapDecodeByteArray.getWidth(), this.t.getHeight()) / 120.0f;
                                if (fMax > 0.0f) {
                                    this.u = Bitmap.createScaledBitmap(this.t, (int) (r1.getWidth() / fMax), (int) (this.t.getHeight() / fMax), true);
                                } else {
                                    this.u = this.t;
                                }
                                if (this.u == null) {
                                    this.u = this.t;
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        this.w = aVarW.a;
                        break;
                    }
                }
                break;
            case "TAL":
            case "TALB":
                this.g = z(gz2);
                break;
            case "TCM":
            case "TCOM":
                this.p = z(gz2);
                break;
            case "TCO":
            case "TCON":
                String strZ = z(gz2);
                if (strZ.length() > 0) {
                    this.i = strZ;
                    try {
                        if (strZ.charAt(0) == '(') {
                            int iIndexOf = strZ.indexOf(41);
                            if (iIndexOf > 1) {
                                cz2P = CZ2.p(Integer.parseInt(strZ.substring(1, iIndexOf)));
                                if (cz2P == null && strZ.length() > (i = iIndexOf + 1)) {
                                    this.i = strZ.substring(i);
                                }
                            } else {
                                cz2P = null;
                            }
                        } else {
                            cz2P = CZ2.p(Integer.parseInt(strZ));
                        }
                        if (cz2P != null) {
                            this.i = cz2P.j();
                            break;
                        }
                    } catch (NumberFormatException unused) {
                        return;
                    }
                }
                break;
            case "TCP":
            case "TCMP":
                this.r = "1".equals(z(gz2));
                break;
            case "TCR":
            case "TCOP":
                this.o = z(gz2);
                break;
            case "TLE":
            case "TLEN":
                String strZ2 = z(gz2);
                try {
                    this.c = Long.valueOf(strZ2).longValue();
                    break;
                } catch (NumberFormatException unused2) {
                    Logger logger2 = x;
                    if (logger2.isLoggable(this.v)) {
                        logger2.log(this.v, "Could not parse track duration: " + strZ2);
                        return;
                    }
                    return;
                }
            case "TP1":
            case "TPE1":
                this.e = z(gz2);
                break;
            case "TP2":
            case "TPE2":
                this.f = z(gz2);
                break;
            case "TPA":
            case "TPOS":
                String strZ3 = z(gz2);
                if (strZ3.length() > 0) {
                    int iIndexOf2 = strZ3.indexOf(47);
                    if (iIndexOf2 < 0) {
                        try {
                            this.m = Short.valueOf(strZ3).shortValue();
                            break;
                        } catch (NumberFormatException unused3) {
                            Logger logger3 = x;
                            if (logger3.isLoggable(this.v)) {
                                logger3.log(this.v, "Could not parse disc number: " + strZ3);
                                return;
                            }
                            return;
                        }
                    } else {
                        try {
                            this.m = Short.valueOf(strZ3.substring(0, iIndexOf2)).shortValue();
                        } catch (NumberFormatException unused4) {
                            Logger logger4 = x;
                            if (logger4.isLoggable(this.v)) {
                                logger4.log(this.v, "Could not parse disc number: " + strZ3);
                            }
                        }
                        try {
                            this.n = Short.valueOf(strZ3.substring(iIndexOf2 + 1)).shortValue();
                            break;
                        } catch (NumberFormatException unused5) {
                            Logger logger5 = x;
                            if (logger5.isLoggable(this.v)) {
                                logger5.log(this.v, "Could not parse number of discs: " + strZ3);
                                return;
                            }
                            return;
                        }
                    }
                }
                break;
            case "TRK":
            case "TRCK":
                String strZ4 = z(gz2);
                if (strZ4.length() > 0) {
                    int iIndexOf3 = strZ4.indexOf(47);
                    if (iIndexOf3 < 0) {
                        try {
                            this.k = Short.valueOf(strZ4).shortValue();
                            break;
                        } catch (NumberFormatException unused6) {
                            Logger logger6 = x;
                            if (logger6.isLoggable(this.v)) {
                                logger6.log(this.v, "Could not parse track number: " + strZ4);
                                return;
                            }
                            return;
                        }
                    } else {
                        try {
                            this.k = Short.valueOf(strZ4.substring(0, iIndexOf3)).shortValue();
                        } catch (NumberFormatException unused7) {
                            Logger logger7 = x;
                            if (logger7.isLoggable(this.v)) {
                                logger7.log(this.v, "Could not parse track number: " + strZ4);
                            }
                        }
                        try {
                            this.l = Short.valueOf(strZ4.substring(iIndexOf3 + 1)).shortValue();
                            break;
                        } catch (NumberFormatException unused8) {
                            Logger logger8 = x;
                            if (logger8.isLoggable(this.v)) {
                                logger8.log(this.v, "Could not parse number of tracks: " + strZ4);
                                return;
                            }
                            return;
                        }
                    }
                }
                break;
            case "TT1":
            case "TIT1":
                this.q = z(gz2);
                break;
            case "TT2":
            case "TIT2":
                this.d = z(gz2);
                break;
            case "TYE":
            case "TYER":
                String strZ5 = z(gz2);
                if (strZ5.length() > 0) {
                    try {
                        this.h = Short.valueOf(strZ5).shortValue();
                        break;
                    } catch (NumberFormatException unused9) {
                        Logger logger9 = x;
                        if (logger9.isLoggable(this.v)) {
                            logger9.log(this.v, "Could not parse year: " + strZ5);
                            return;
                        }
                        return;
                    }
                }
                break;
            case "ULT":
            case "USLT":
                if (this.s == null) {
                    this.s = x(gz2).c;
                    break;
                }
                break;
            case "TDRC":
                String strZ6 = z(gz2);
                if (strZ6.length() >= 4) {
                    try {
                        this.h = Short.valueOf(strZ6.substring(0, 4)).shortValue();
                        break;
                    } catch (NumberFormatException unused10) {
                        Logger logger10 = x;
                        if (logger10.isLoggable(this.v)) {
                            logger10.log(this.v, "Could not parse year from: " + strZ6);
                            return;
                        }
                        return;
                    }
                }
                break;
        }
    }

    String z(GZ2 gz2) throws ID3v2Exception, IOException {
        return gz2.h((int) gz2.e(), gz2.g());
    }
}
