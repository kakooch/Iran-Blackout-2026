package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_ads_inputAdsLocationChatMembers extends TLRPC$Ads_Location {
    public static int constructor = -338836925;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.peer = TLRPC$InputPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.peer.serializeToStream(stream);
    }
}
