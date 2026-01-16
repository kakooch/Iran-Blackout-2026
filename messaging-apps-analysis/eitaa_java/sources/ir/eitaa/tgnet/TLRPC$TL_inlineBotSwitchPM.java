package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inlineBotSwitchPM extends TLObject {
    public static int constructor = 1008755359;
    public String start_param;
    public String text;

    public static TLRPC$TL_inlineBotSwitchPM TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_inlineBotSwitchPM", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_inlineBotSwitchPM tLRPC$TL_inlineBotSwitchPM = new TLRPC$TL_inlineBotSwitchPM();
        tLRPC$TL_inlineBotSwitchPM.readParams(stream, exception);
        return tLRPC$TL_inlineBotSwitchPM;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.text = stream.readString(exception);
        this.start_param = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.text);
        stream.writeString(this.start_param);
    }
}
