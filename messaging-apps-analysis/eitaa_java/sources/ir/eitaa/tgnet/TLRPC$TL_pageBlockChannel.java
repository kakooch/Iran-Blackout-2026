package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_pageBlockChannel extends TLRPC$PageBlock {
    public static int constructor = -283684427;
    public TLRPC$Chat channel;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.channel = TLRPC$Chat.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.channel.serializeToStream(stream);
    }
}
