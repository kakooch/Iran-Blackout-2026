package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_updateTrends extends TLObject {
    public long date;
    public ArrayList<TLRPC$TrendGroup> trendGroups = new ArrayList<>();

    public static TLRPC$TL_updateTrends TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_updateTrends tLRPC$TL_updateTrends = new TLRPC$TL_updateTrends();
        tLRPC$TL_updateTrends.readParams(stream, exception);
        return tLRPC$TL_updateTrends;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            this.trendGroups.add(TLRPC$TrendGroup.TLdeserialize(stream, stream.readInt32(exception), exception));
        }
        this.date = stream.readInt32(exception);
    }
}
