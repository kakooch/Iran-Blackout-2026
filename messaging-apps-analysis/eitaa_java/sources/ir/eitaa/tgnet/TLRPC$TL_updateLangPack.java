package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_updateLangPack extends TLRPC$Update {
    public static int constructor = 1442983757;
    public TLRPC$TL_langPackDifference difference;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.difference = TLRPC$TL_langPackDifference.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.difference.serializeToStream(stream);
    }
}
