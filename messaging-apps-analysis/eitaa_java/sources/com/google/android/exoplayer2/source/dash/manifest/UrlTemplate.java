package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;

/* loaded from: classes.dex */
public final class UrlTemplate {
    private final int identifierCount;
    private final String[] identifierFormatTags;
    private final int[] identifiers;
    private final String[] urlPieces;

    public static UrlTemplate compile(String template) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new UrlTemplate(strArr, iArr, strArr2, parseTemplate(template, strArr, iArr, strArr2));
    }

    private UrlTemplate(String[] urlPieces, int[] identifiers, String[] identifierFormatTags, int identifierCount) {
        this.urlPieces = urlPieces;
        this.identifiers = identifiers;
        this.identifierFormatTags = identifierFormatTags;
        this.identifierCount = identifierCount;
    }

    public String buildUri(String representationId, long segmentNumber, int bandwidth, long time) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = this.identifierCount;
            if (i < i2) {
                sb.append(this.urlPieces[i]);
                int[] iArr = this.identifiers;
                if (iArr[i] == 1) {
                    sb.append(representationId);
                } else if (iArr[i] == 2) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i], Long.valueOf(segmentNumber)));
                } else if (iArr[i] == 3) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i], Integer.valueOf(bandwidth)));
                } else if (iArr[i] == 4) {
                    sb.append(String.format(Locale.US, this.identifierFormatTags[i], Long.valueOf(time)));
                }
                i++;
            } else {
                sb.append(this.urlPieces[i2]);
                return sb.toString();
            }
        }
    }

    private static int parseTemplate(String template, String[] urlPieces, int[] identifiers, String[] identifierFormatTags) {
        String strSubstring;
        urlPieces[0] = "";
        int length = 0;
        int i = 0;
        while (length < template.length()) {
            int iIndexOf = template.indexOf("$", length);
            if (iIndexOf == -1) {
                urlPieces[i] = urlPieces[i] + template.substring(length);
                length = template.length();
            } else if (iIndexOf != length) {
                urlPieces[i] = urlPieces[i] + template.substring(length, iIndexOf);
                length = iIndexOf;
            } else if (template.startsWith("$$", length)) {
                urlPieces[i] = urlPieces[i] + "$";
                length += 2;
            } else {
                int i2 = length + 1;
                int iIndexOf2 = template.indexOf("$", i2);
                String strSubstring2 = template.substring(i2, iIndexOf2);
                if (strSubstring2.equals("RepresentationID")) {
                    identifiers[i] = 1;
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith("d") && !strSubstring.endsWith("x")) {
                            strSubstring = strSubstring + "d";
                        }
                        strSubstring2 = strSubstring2.substring(0, iIndexOf3);
                    } else {
                        strSubstring = "%01d";
                    }
                    strSubstring2.hashCode();
                    switch (strSubstring2) {
                        case "Number":
                            identifiers[i] = 2;
                            break;
                        case "Time":
                            identifiers[i] = 4;
                            break;
                        case "Bandwidth":
                            identifiers[i] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + template);
                    }
                    identifierFormatTags[i] = strSubstring;
                }
                i++;
                urlPieces[i] = "";
                length = iIndexOf2 + 1;
            }
        }
        return i;
    }
}
