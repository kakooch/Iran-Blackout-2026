package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputNotifyUsers extends TLRPC$InputNotifyPeer {
    public static int constructor = 423314455;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
