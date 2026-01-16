package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_chatInviteEmpty_layer122 extends TLRPC$ExportedChatInvite {
    public static int constructor = 1776236393;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
    }
}
