package ir.nasim;

import android.media.MediaMetadataRetriever;

/* renamed from: ir.nasim.qe4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C19609qe4 extends QN {
    public C19609qe4(String str) throws IllegalArgumentException {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            this.c = (int) Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            this.e = mediaMetadataRetriever.extractMetadata(2);
            this.d = mediaMetadataRetriever.extractMetadata(7);
            this.g = mediaMetadataRetriever.extractMetadata(1);
        } catch (Exception e) {
            C19406qI3.a("metaDataInfo", e.getMessage(), new Object[0]);
        }
    }

    public String toString() {
        return "{ title : " + this.d + "  artist : " + this.e + " cover : " + this.t + "  duration : " + this.c + " }";
    }
}
