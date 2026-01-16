package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_inputNotifyChats extends TLRPC$InputNotifyPeer {
    public static int constructor = 1251338318;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
