package com.google.ads.interactivemedia.v3.internal;

import android.util.Log;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class mt {
    static final String[] a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int b = 0;

    public static qy a(aee aeeVar) {
        String str;
        int iG = aeeVar.g() + aeeVar.v();
        int iV = aeeVar.v();
        int i = (iV >> 24) & 255;
        qy ruVar = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & iV;
                if (i2 == 6516084) {
                    int iV2 = aeeVar.v();
                    if (aeeVar.v() == 1684108385) {
                        aeeVar.k(8);
                        String strG = aeeVar.G(iV2 - 16);
                        ruVar = new ru("und", strG, strG);
                    } else {
                        String strValueOf = String.valueOf(me.g(iV));
                        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(strValueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return ruVar;
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    return b(iV, "TIT2", aeeVar);
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    return b(iV, "TCOM", aeeVar);
                }
                if (i2 == 6578553) {
                    return b(iV, "TDRC", aeeVar);
                }
                if (i2 == 4280916) {
                    return b(iV, "TPE1", aeeVar);
                }
                if (i2 == 7630703) {
                    return b(iV, "TSSE", aeeVar);
                }
                if (i2 == 6384738) {
                    return b(iV, "TALB", aeeVar);
                }
                if (i2 == 7108978) {
                    return b(iV, "USLT", aeeVar);
                }
                if (i2 == 6776174) {
                    return b(iV, "TCON", aeeVar);
                }
                if (i2 == 6779504) {
                    return b(iV, "TIT1", aeeVar);
                }
            } else {
                if (iV == 1735291493) {
                    int iE = e(aeeVar);
                    String str2 = (iE <= 0 || iE > 192) ? null : a[iE - 1];
                    if (str2 != null) {
                        ruVar = new sj("TCON", null, str2);
                    } else {
                        Log.w("MetadataUtil", "Failed to parse standard genre code");
                    }
                    return ruVar;
                }
                if (iV == 1684632427) {
                    return d(1684632427, "TPOS", aeeVar);
                }
                if (iV == 1953655662) {
                    return d(1953655662, "TRCK", aeeVar);
                }
                if (iV == 1953329263) {
                    return c(1953329263, "TBPM", aeeVar, true, false);
                }
                if (iV == 1668311404) {
                    return c(1668311404, "TCMP", aeeVar, true, true);
                }
                if (iV == 1668249202) {
                    int iV3 = aeeVar.v();
                    if (aeeVar.v() == 1684108385) {
                        int iF = me.f(aeeVar.v());
                        if (iF == 13) {
                            str = "image/jpeg";
                        } else if (iF == 14) {
                            str = "image/png";
                            iF = 14;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            StringBuilder sb = new StringBuilder(41);
                            sb.append("Unrecognized cover art flags: ");
                            sb.append(iF);
                            Log.w("MetadataUtil", sb.toString());
                        } else {
                            aeeVar.k(4);
                            int i3 = iV3 - 16;
                            byte[] bArr = new byte[i3];
                            aeeVar.m(bArr, 0, i3);
                            ruVar = new rm(str, null, 3, bArr);
                        }
                    } else {
                        Log.w("MetadataUtil", "Failed to parse cover art attribute");
                    }
                    return ruVar;
                }
                if (iV == 1631670868) {
                    return b(1631670868, "TPE2", aeeVar);
                }
                if (iV == 1936682605) {
                    return b(1936682605, "TSOT", aeeVar);
                }
                if (iV == 1936679276) {
                    return b(1936679276, "TSO2", aeeVar);
                }
                if (iV == 1936679282) {
                    return b(1936679282, "TSOA", aeeVar);
                }
                if (iV == 1936679265) {
                    return b(1936679265, "TSOP", aeeVar);
                }
                if (iV == 1936679791) {
                    return b(1936679791, "TSOC", aeeVar);
                }
                if (iV == 1920233063) {
                    return c(1920233063, "ITUNESADVISORY", aeeVar, false, false);
                }
                if (iV == 1885823344) {
                    return c(1885823344, "ITUNESGAPLESS", aeeVar, false, true);
                }
                if (iV == 1936683886) {
                    return b(1936683886, "TVSHOWSORT", aeeVar);
                }
                if (iV == 1953919848) {
                    return b(1953919848, "TVSHOW", aeeVar);
                }
                if (iV == 757935405) {
                    String strG2 = null;
                    String strG3 = null;
                    int i4 = -1;
                    int i5 = -1;
                    while (aeeVar.g() < iG) {
                        int iG2 = aeeVar.g();
                        int iV4 = aeeVar.v();
                        int iV5 = aeeVar.v();
                        aeeVar.k(4);
                        if (iV5 == 1835360622) {
                            strG2 = aeeVar.G(iV4 - 12);
                        } else if (iV5 == 1851878757) {
                            strG3 = aeeVar.G(iV4 - 12);
                        } else {
                            if (iV5 == 1684108385) {
                                i5 = iV4;
                            }
                            if (iV5 == 1684108385) {
                                i4 = iG2;
                            }
                            aeeVar.k(iV4 - 12);
                        }
                    }
                    if (strG2 != null && strG3 != null && i4 != -1) {
                        aeeVar.h(i4);
                        aeeVar.k(16);
                        ruVar = new sd(strG2, strG3, aeeVar.G(i5 - 16));
                    }
                    return ruVar;
                }
            }
            String strValueOf2 = String.valueOf(me.g(iV));
            Log.d("MetadataUtil", strValueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(strValueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            aeeVar.h(iG);
        }
    }

    private static sj b(int i, String str, aee aeeVar) {
        int iV = aeeVar.v();
        if (aeeVar.v() == 1684108385) {
            aeeVar.k(8);
            return new sj(str, null, aeeVar.G(iV - 16));
        }
        String strValueOf = String.valueOf(me.g(i));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse text attribute: ".concat(strValueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static sb c(int i, String str, aee aeeVar, boolean z, boolean z2) {
        int iE = e(aeeVar);
        if (z2) {
            iE = Math.min(1, iE);
        }
        if (iE >= 0) {
            return z ? new sj(str, null, Integer.toString(iE)) : new ru("und", str, Integer.toString(iE));
        }
        String strValueOf = String.valueOf(me.g(i));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(strValueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static sj d(int i, String str, aee aeeVar) {
        int iV = aeeVar.v();
        if (aeeVar.v() == 1684108385 && iV >= 22) {
            aeeVar.k(10);
            int iO = aeeVar.o();
            if (iO > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(iO);
                String string = sb.toString();
                int iO2 = aeeVar.o();
                if (iO2 > 0) {
                    String strValueOf = String.valueOf(string);
                    StringBuilder sb2 = new StringBuilder(strValueOf.length() + 12);
                    sb2.append(strValueOf);
                    sb2.append("/");
                    sb2.append(iO2);
                    string = sb2.toString();
                }
                return new sj(str, null, string);
            }
        }
        String strValueOf2 = String.valueOf(me.g(i));
        Log.w("MetadataUtil", strValueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(strValueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static int e(aee aeeVar) {
        aeeVar.k(4);
        if (aeeVar.v() == 1684108385) {
            aeeVar.k(8);
            return aeeVar.n();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
