package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_channelAdminLogEventActionToggleGroupCallSetting extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1456906823;
    public boolean join_muted;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.join_muted = stream.readBool(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeBool(this.join_muted);
    }
}
