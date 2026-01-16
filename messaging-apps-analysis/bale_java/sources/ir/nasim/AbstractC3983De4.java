package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;

/* renamed from: ir.nasim.De4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC3983De4 {
    static final String[] a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    private static CommentFrame a(int i, EW4 ew4) {
        int iO = ew4.o();
        if (ew4.o() == 1684108385) {
            ew4.T(8);
            String strA = ew4.A(iO - 16);
            return new CommentFrame("und", strA, strA);
        }
        AbstractC18815pI3.k("MetadataUtil", "Failed to parse comment attribute: " + ML.a(i));
        return null;
    }

    private static ApicFrame b(EW4 ew4) {
        int iO = ew4.o();
        if (ew4.o() != 1684108385) {
            AbstractC18815pI3.k("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iB = ML.b(ew4.o());
        String str = iB == 13 ? "image/jpeg" : iB == 14 ? "image/png" : null;
        if (str == null) {
            AbstractC18815pI3.k("MetadataUtil", "Unrecognized cover art flags: " + iB);
            return null;
        }
        ew4.T(4);
        int i = iO - 16;
        byte[] bArr = new byte[i];
        ew4.j(bArr, 0, i);
        return new ApicFrame(str, null, 3, bArr);
    }

    public static Metadata.Entry c(EW4 ew4) {
        int iF = ew4.f() + ew4.o();
        int iO = ew4.o();
        int i = (iO >> 24) & 255;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & iO;
                if (i2 == 6516084) {
                    return a(iO, ew4);
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    return h(iO, "TIT2", ew4);
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    return h(iO, "TCOM", ew4);
                }
                if (i2 == 6578553) {
                    return h(iO, "TDRC", ew4);
                }
                if (i2 == 4280916) {
                    return h(iO, "TPE1", ew4);
                }
                if (i2 == 7630703) {
                    return h(iO, "TSSE", ew4);
                }
                if (i2 == 6384738) {
                    return h(iO, "TALB", ew4);
                }
                if (i2 == 7108978) {
                    return h(iO, "USLT", ew4);
                }
                if (i2 == 6776174) {
                    return h(iO, "TCON", ew4);
                }
                if (i2 == 6779504) {
                    return h(iO, "TIT1", ew4);
                }
            } else {
                if (iO == 1735291493) {
                    return g(ew4);
                }
                if (iO == 1684632427) {
                    return d(iO, "TPOS", ew4);
                }
                if (iO == 1953655662) {
                    return d(iO, "TRCK", ew4);
                }
                if (iO == 1953329263) {
                    return i(iO, "TBPM", ew4, true, false);
                }
                if (iO == 1668311404) {
                    return i(iO, "TCMP", ew4, true, true);
                }
                if (iO == 1668249202) {
                    return b(ew4);
                }
                if (iO == 1631670868) {
                    return h(iO, "TPE2", ew4);
                }
                if (iO == 1936682605) {
                    return h(iO, "TSOT", ew4);
                }
                if (iO == 1936679276) {
                    return h(iO, "TSO2", ew4);
                }
                if (iO == 1936679282) {
                    return h(iO, "TSOA", ew4);
                }
                if (iO == 1936679265) {
                    return h(iO, "TSOP", ew4);
                }
                if (iO == 1936679791) {
                    return h(iO, "TSOC", ew4);
                }
                if (iO == 1920233063) {
                    return i(iO, "ITUNESADVISORY", ew4, false, false);
                }
                if (iO == 1885823344) {
                    return i(iO, "ITUNESGAPLESS", ew4, false, true);
                }
                if (iO == 1936683886) {
                    return h(iO, "TVSHOWSORT", ew4);
                }
                if (iO == 1953919848) {
                    return h(iO, "TVSHOW", ew4);
                }
                if (iO == 757935405) {
                    return e(ew4, iF);
                }
            }
            AbstractC18815pI3.b("MetadataUtil", "Skipped unknown metadata entry: " + ML.a(iO));
            ew4.S(iF);
            return null;
        } finally {
            ew4.S(iF);
        }
    }

    private static TextInformationFrame d(int i, String str, EW4 ew4) {
        int iO = ew4.o();
        if (ew4.o() == 1684108385 && iO >= 22) {
            ew4.T(10);
            int iL = ew4.L();
            if (iL > 0) {
                String str2 = "" + iL;
                int iL2 = ew4.L();
                if (iL2 > 0) {
                    str2 = str2 + Separators.SLASH + iL2;
                }
                return new TextInformationFrame(str, null, AbstractC12710f43.W(str2));
            }
        }
        AbstractC18815pI3.k("MetadataUtil", "Failed to parse index/count attribute: " + ML.a(i));
        return null;
    }

    private static Id3Frame e(EW4 ew4, int i) {
        String strA = null;
        String strA2 = null;
        int i2 = -1;
        int i3 = -1;
        while (ew4.f() < i) {
            int iF = ew4.f();
            int iO = ew4.o();
            int iO2 = ew4.o();
            ew4.T(4);
            if (iO2 == 1835360622) {
                strA = ew4.A(iO - 12);
            } else if (iO2 == 1851878757) {
                strA2 = ew4.A(iO - 12);
            } else {
                if (iO2 == 1684108385) {
                    i2 = iF;
                    i3 = iO;
                }
                ew4.T(iO - 12);
            }
        }
        if (strA == null || strA2 == null || i2 == -1) {
            return null;
        }
        ew4.S(i2);
        ew4.T(16);
        return new InternalFrame(strA, strA2, ew4.A(i3 - 16));
    }

    public static MdtaMetadataEntry f(EW4 ew4, int i, String str) {
        while (true) {
            int iF = ew4.f();
            if (iF >= i) {
                return null;
            }
            int iO = ew4.o();
            if (ew4.o() == 1684108385) {
                int iO2 = ew4.o();
                int iO3 = ew4.o();
                int i2 = iO - 16;
                byte[] bArr = new byte[i2];
                ew4.j(bArr, 0, i2);
                return new MdtaMetadataEntry(str, bArr, iO3, iO2);
            }
            ew4.S(iF + iO);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame g(ir.nasim.EW4 r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = ir.nasim.AbstractC3983De4.a
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L20
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            ir.nasim.f43 r3 = ir.nasim.AbstractC12710f43.W(r3)
            r1.<init>(r2, r0, r3)
            return r1
        L20:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            ir.nasim.AbstractC18815pI3.k(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC3983De4.g(ir.nasim.EW4):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    private static TextInformationFrame h(int i, String str, EW4 ew4) {
        int iO = ew4.o();
        if (ew4.o() == 1684108385) {
            ew4.T(8);
            return new TextInformationFrame(str, null, AbstractC12710f43.W(ew4.A(iO - 16)));
        }
        AbstractC18815pI3.k("MetadataUtil", "Failed to parse text attribute: " + ML.a(i));
        return null;
    }

    private static Id3Frame i(int i, String str, EW4 ew4, boolean z, boolean z2) {
        int iJ = j(ew4);
        if (z2) {
            iJ = Math.min(1, iJ);
        }
        if (iJ >= 0) {
            return z ? new TextInformationFrame(str, null, AbstractC12710f43.W(Integer.toString(iJ))) : new CommentFrame("und", str, Integer.toString(iJ));
        }
        AbstractC18815pI3.k("MetadataUtil", "Failed to parse uint8 attribute: " + ML.a(i));
        return null;
    }

    private static int j(EW4 ew4) {
        ew4.T(4);
        if (ew4.o() == 1684108385) {
            ew4.T(8);
            return ew4.F();
        }
        AbstractC18815pI3.k("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i, ED2 ed2, X.b bVar) {
        if (i == 1 && ed2.a()) {
            bVar.P(ed2.a).Q(ed2.b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void l(int r5, com.google.android.exoplayer2.metadata.Metadata r6, com.google.android.exoplayer2.metadata.Metadata r7, com.google.android.exoplayer2.X.b r8, com.google.android.exoplayer2.metadata.Metadata... r9) {
        /*
            com.google.android.exoplayer2.metadata.Metadata r0 = new com.google.android.exoplayer2.metadata.Metadata
            r1 = 0
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r2 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto Le
            if (r6 == 0) goto L3b
            goto L3c
        Le:
            r6 = 2
            if (r5 != r6) goto L3b
            if (r7 == 0) goto L3b
            r5 = r1
        L14:
            int r6 = r7.e()
            if (r5 >= r6) goto L3b
            com.google.android.exoplayer2.metadata.Metadata$Entry r6 = r7.d(r5)
            boolean r3 = r6 instanceof com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry r6 = (com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry) r6
            java.lang.String r3 = r6.a
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.Metadata r5 = new com.google.android.exoplayer2.metadata.Metadata
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L3c
        L39:
            int r5 = r5 + r2
            goto L14
        L3b:
            r6 = r0
        L3c:
            int r5 = r9.length
        L3d:
            if (r1 >= r5) goto L47
            r7 = r9[r1]
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.b(r7)
            int r1 = r1 + r2
            goto L3d
        L47:
            int r5 = r6.e()
            if (r5 <= 0) goto L50
            r8.Z(r6)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC3983De4.l(int, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.X$b, com.google.android.exoplayer2.metadata.Metadata[]):void");
    }
}
