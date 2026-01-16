package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_getAttachedStickers extends TLObject {
    public static int constructor = -866424884;
    public TLRPC$InputStickeredMedia media;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        for (int i = 0; i < int32; i++) {
            TLRPC$StickerSetCovered tLRPC$StickerSetCoveredTLdeserialize = TLRPC$StickerSetCovered.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$StickerSetCoveredTLdeserialize == null) {
                return tLRPC$Vector;
            }
            tLRPC$Vector.objects.add(tLRPC$StickerSetCoveredTLdeserialize);
        }
        return tLRPC$Vector;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.media.serializeToStream(stream);
    }
}
