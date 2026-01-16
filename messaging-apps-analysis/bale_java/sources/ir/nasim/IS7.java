package ir.nasim;

import android.media.MediaMetadataRetriever;
import android.os.Build;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable;

/* loaded from: classes7.dex */
public class IS7 {
    private long c;
    private long d;
    private int e;
    private int a = 0;
    private int b = 0;
    private String f = CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE;
    private int g = 0;
    private int h = 24;
    private int i = 0;

    private IS7() {
    }

    public static IS7 b(String str) throws IllegalArgumentException {
        IS7 is7 = new IS7();
        int[] iArr = new int[11];
        c(str, iArr);
        if (iArr[0] == 0) {
            return null;
        }
        is7.c = iArr[6];
        is7.d = iArr[5];
        is7.h = iArr[7];
        is7.i = iArr[8];
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(20);
        String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(9);
        String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(12);
        if (XY6.m(strExtractMetadata)) {
            strExtractMetadata = "0";
        }
        is7.b = Integer.parseInt(strExtractMetadata);
        if (XY6.m(strExtractMetadata2)) {
            strExtractMetadata2 = "0";
        }
        is7.a = Integer.parseInt(strExtractMetadata2);
        if (XY6.m(strExtractMetadata4)) {
            strExtractMetadata4 = "0";
        }
        is7.g = Integer.parseInt(strExtractMetadata4);
        if (XY6.m(strExtractMetadata5)) {
            strExtractMetadata5 = CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE;
        }
        is7.f = strExtractMetadata5;
        if (XY6.m(strExtractMetadata3)) {
            strExtractMetadata3 = "0";
        }
        is7.e = Integer.parseInt(strExtractMetadata3);
        return is7;
    }

    private static void c(String str, int[] iArr) {
        AnimatedFileDrawable.getVideoInfo(Build.VERSION.SDK_INT, str, iArr);
    }

    public int a() {
        return this.g;
    }
}
