package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputChannelEmpty extends TLRPC$InputChannel {
    public static int constructor = -292807034;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
