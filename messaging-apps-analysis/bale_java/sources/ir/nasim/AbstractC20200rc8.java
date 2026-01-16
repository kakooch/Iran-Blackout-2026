package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import ir.nasim.AbstractC12710f43;
import ir.nasim.C14334hk4;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: ir.nasim.rc8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC20200rc8 {
    private static final String[] a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static C14334hk4 a(String str) {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            AbstractC18815pI3.k("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static C14334hk4 b(String str) throws XmlPullParserException, IOException, NumberFormatException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!AbstractC19002pc8.e(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ParserException.a("Couldn't find xmp metadata", null);
        }
        AbstractC12710f43 abstractC12710f43V = AbstractC12710f43.V();
        long jE = -9223372036854775807L;
        do {
            xmlPullParserNewPullParser.next();
            if (AbstractC19002pc8.e(xmlPullParserNewPullParser, "rdf:Description")) {
                if (!d(xmlPullParserNewPullParser)) {
                    return null;
                }
                jE = e(xmlPullParserNewPullParser);
                abstractC12710f43V = c(xmlPullParserNewPullParser);
            } else if (AbstractC19002pc8.e(xmlPullParserNewPullParser, "Container:Directory")) {
                abstractC12710f43V = f(xmlPullParserNewPullParser, "Container", "Item");
            } else if (AbstractC19002pc8.e(xmlPullParserNewPullParser, "GContainer:Directory")) {
                abstractC12710f43V = f(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!AbstractC19002pc8.c(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (abstractC12710f43V.isEmpty()) {
            return null;
        }
        return new C14334hk4(jE, abstractC12710f43V);
    }

    private static AbstractC12710f43 c(XmlPullParser xmlPullParser) throws NumberFormatException {
        for (String str : c) {
            String strA = AbstractC19002pc8.a(xmlPullParser, str);
            if (strA != null) {
                return AbstractC12710f43.Y(new C14334hk4.a("image/jpeg", "Primary", 0L, 0L), new C14334hk4.a("video/mp4", "MotionPhoto", Long.parseLong(strA), 0L));
            }
        }
        return AbstractC12710f43.V();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        for (String str : a) {
            String strA = AbstractC19002pc8.a(xmlPullParser, str);
            if (strA != null) {
                return Integer.parseInt(strA) == 1;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) throws NumberFormatException {
        for (String str : b) {
            String strA = AbstractC19002pc8.a(xmlPullParser, str);
            if (strA != null) {
                long j = Long.parseLong(strA);
                if (j == -1) {
                    return -9223372036854775807L;
                }
                return j;
            }
        }
        return -9223372036854775807L;
    }

    private static AbstractC12710f43 f(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        AbstractC12710f43.a aVarL = AbstractC12710f43.L();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (AbstractC19002pc8.e(xmlPullParser, str3)) {
                String strA = AbstractC19002pc8.a(xmlPullParser, str2 + ":Mime");
                String strA2 = AbstractC19002pc8.a(xmlPullParser, str2 + ":Semantic");
                String strA3 = AbstractC19002pc8.a(xmlPullParser, str2 + ":Length");
                String strA4 = AbstractC19002pc8.a(xmlPullParser, str2 + ":Padding");
                if (strA == null || strA2 == null) {
                    return AbstractC12710f43.V();
                }
                aVarL.a(new C14334hk4.a(strA, strA2, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
            }
        } while (!AbstractC19002pc8.c(xmlPullParser, str4));
        return aVarL.h();
    }
}
