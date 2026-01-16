package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionTogglePreHistoryHidden extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1599903217;
    public boolean new_value;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.new_value = stream.readBool(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeBool(this.new_value);
    }
}
