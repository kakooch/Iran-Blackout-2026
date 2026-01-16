package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TrendGroup extends TLObject {
    public static int constructor = 257662387;
    public String title;
    public ArrayList<TLRPC$Trend> trends = new ArrayList<>();

    public static TLRPC$TrendGroup TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TrendGroup", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TrendGroup tLRPC$TrendGroup = new TLRPC$TrendGroup();
        tLRPC$TrendGroup.readParams(stream, exception);
        return tLRPC$TrendGroup;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.title = stream.readString(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                this.trends.add(TLRPC$Trend.TLdeserialize(stream, stream.readInt32(exception), exception));
            }
        }
    }
}
