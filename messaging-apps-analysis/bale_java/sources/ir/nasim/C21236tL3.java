package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: ir.nasim.tL3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21236tL3 extends QN {
    static final Logger w = Logger.getLogger(C21236tL3.class.getName());
    private final Level v;

    public C21236tL3(InputStream inputStream) {
        this(inputStream, Level.FINEST);
    }

    void A(CL3 cl3) {
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        cl3.A(4);
        while (cl3.m()) {
            CL3 cl3F = cl3.f();
            if ("ilst".equals(cl3F.e())) {
                x(cl3F);
                return;
            }
        }
    }

    void B(CL3 cl3) {
        CL3 cl3F;
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        while (cl3.m()) {
            cl3F = cl3.f();
            String strE = cl3F.e();
            strE.hashCode();
            switch (strE) {
                case "mvhd":
                    C(cl3F);
                    break;
                case "trak":
                    D(cl3F);
                    break;
                case "udta":
                    E(cl3F);
                    break;
            }
        }
    }

    void C(CL3 cl3) {
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        byte bP = cl3.p();
        cl3.A(3);
        cl3.A(bP == 1 ? 16 : 8);
        int iS = cl3.s();
        long jU = bP == 1 ? cl3.u() : cl3.s();
        if (this.c == 0) {
            this.c = (jU * 1000) / iS;
        } else if (logger.isLoggable(this.v)) {
            long j = (jU * 1000) / iS;
            if (Math.abs(this.c - j) > 2) {
                logger.log(this.v, "mvhd: duration " + this.c + " -> " + j);
            }
        }
        cl3.t();
        cl3.w();
    }

    void D(CL3 cl3) {
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        z(cl3.n("mdia"));
    }

    void E(CL3 cl3) {
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        while (cl3.m()) {
            CL3 cl3F = cl3.f();
            if ("meta".equals(cl3F.e())) {
                A(cl3F);
                return;
            }
        }
    }

    void v(CL3 cl3) {
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        cl3.A(4);
        cl3.A(4);
        String strE = cl3.c().e();
        strE.hashCode();
        switch (strE) {
            case "aART":
                this.f = cl3.y("UTF-8");
                break;
            case "covr":
                try {
                    byte[] bArrQ = cl3.q();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    options.inSampleSize = 1;
                    BitmapFactory.decodeByteArray(bArrQ, 0, bArrQ.length, options);
                    int i = options.outWidth;
                    if (i > 800 || options.outHeight > 800) {
                        for (int iMax = Math.max(i, options.outHeight); iMax > 800; iMax /= 2) {
                            options.inSampleSize *= 2;
                        }
                    }
                    options.inJustDecodeBounds = false;
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrQ, 0, bArrQ.length, options);
                    this.t = bitmapDecodeByteArray;
                    if (bitmapDecodeByteArray != null) {
                        float fMax = Math.max(bitmapDecodeByteArray.getWidth(), this.t.getHeight()) / 120.0f;
                        if (fMax > 0.0f) {
                            this.u = Bitmap.createScaledBitmap(this.t, (int) (r0.getWidth() / fMax), (int) (this.t.getHeight() / fMax), true);
                        } else {
                            this.u = this.t;
                        }
                        if (this.u == null) {
                            this.u = this.t;
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case "cpil":
                this.r = cl3.o();
                break;
            case "cprt":
            case "©cpy":
                String str = this.o;
                if (str == null || str.trim().length() == 0) {
                    this.o = cl3.y("UTF-8");
                    break;
                }
                break;
            case "disk":
                cl3.A(2);
                this.m = cl3.v();
                this.n = cl3.v();
                break;
            case "gnre":
                String str2 = this.i;
                if (str2 == null || str2.trim().length() == 0) {
                    if (cl3.l() == 2) {
                        CZ2 cz2P = CZ2.p(cl3.v() - 1);
                        if (cz2P != null) {
                            this.i = cz2P.j();
                            break;
                        }
                    } else {
                        this.i = cl3.y("UTF-8");
                        break;
                    }
                }
                break;
            case "rtng":
                cl3.p();
                break;
            case "tmpo":
                cl3.v();
                break;
            case "trkn":
                cl3.A(2);
                this.k = cl3.v();
                this.l = cl3.v();
                break;
            case "©ART":
                this.e = cl3.y("UTF-8");
                break;
            case "©alb":
                this.g = cl3.y("UTF-8");
                break;
            case "©cmt":
                this.j = cl3.y("UTF-8");
                break;
            case "©com":
            case "©wrt":
                String str3 = this.p;
                if (str3 == null || str3.trim().length() == 0) {
                    this.p = cl3.y("UTF-8");
                    break;
                }
                break;
            case "©day":
                String strTrim = cl3.y("UTF-8").trim();
                if (strTrim.length() >= 4) {
                    try {
                        this.h = Short.valueOf(strTrim.substring(0, 4)).shortValue();
                        break;
                    } catch (NumberFormatException unused) {
                        return;
                    }
                }
                break;
            case "©gen":
                String str4 = this.i;
                if (str4 == null || str4.trim().length() == 0) {
                    this.i = cl3.y("UTF-8");
                    break;
                }
                break;
            case "©grp":
                this.q = cl3.y("UTF-8");
                break;
            case "©lyr":
                this.s = cl3.y("UTF-8");
                break;
            case "©nam":
                this.d = cl3.y("UTF-8");
                break;
        }
    }

    void w(CL3 cl3) {
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        String strTrim = cl3.x(4, "ISO8859_1").trim();
        this.a = strTrim;
        if (strTrim.matches("M4V|MP4|mp42|isom")) {
            logger.warning(cl3.k() + ": brand=" + this.a + " (experimental)");
        } else if (!this.a.matches("M4A|M4P")) {
            logger.warning(cl3.k() + ": brand=" + this.a + " (expected M4A or M4P)");
        }
        this.b = String.valueOf(cl3.s());
    }

    void x(CL3 cl3) {
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        while (cl3.m()) {
            CL3 cl3F = cl3.f();
            Logger logger2 = w;
            if (logger2.isLoggable(this.v)) {
                logger2.log(this.v, cl3F.toString());
            }
            if (cl3F.l() != 0) {
                v(cl3F.n("data"));
            } else if (logger2.isLoggable(this.v)) {
                logger2.log(this.v, cl3F.k() + ": contains no value");
            }
        }
    }

    void y(CL3 cl3) {
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        byte bP = cl3.p();
        cl3.A(3);
        cl3.A(bP == 1 ? 16 : 8);
        int iS = cl3.s();
        long jU = bP == 1 ? cl3.u() : cl3.s();
        if (this.c == 0) {
            this.c = (jU * 1000) / iS;
            return;
        }
        if (logger.isLoggable(this.v)) {
            long j = (jU * 1000) / iS;
            if (Math.abs(this.c - j) > 2) {
                logger.log(this.v, "mdhd: duration " + this.c + " -> " + j);
            }
        }
    }

    void z(CL3 cl3) {
        Logger logger = w;
        if (logger.isLoggable(this.v)) {
            logger.log(this.v, cl3.toString());
        }
        y(cl3.g("mdhd"));
    }

    public C21236tL3(InputStream inputStream, Level level) {
        this.v = level;
        GL3 gl3 = new GL3(inputStream);
        Logger logger = w;
        if (logger.isLoggable(level)) {
            logger.log(level, gl3.toString());
        }
        w(gl3.g("ftyp"));
        B(gl3.h("moov"));
    }
}
