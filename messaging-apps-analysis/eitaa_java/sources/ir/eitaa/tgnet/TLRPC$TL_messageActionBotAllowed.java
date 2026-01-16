package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messageActionBotAllowed extends TLRPC$MessageAction {
    public static int constructor = -1410748418;
    public String domain;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.domain = stream.readString(exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.domain);
    }
}
