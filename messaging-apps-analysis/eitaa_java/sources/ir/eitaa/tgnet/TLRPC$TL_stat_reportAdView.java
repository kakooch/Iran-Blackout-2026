package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_stat_reportAdView extends TLObject {
    public static int constructor = -1634213207;
    public ArrayList<TLRPC$TL_stat_ad> statAds = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.statAds.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.statAds.get(i).serializeToStream(stream);
        }
    }
}
