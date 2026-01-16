package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_messages_sendEncryptedMultiMedia extends TLObject {
    public ArrayList<TLRPC$TL_decryptedMessage> messages = new ArrayList<>();
    public ArrayList<TLRPC$InputEncryptedFile> files = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void freeResources() {
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
    }

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor, boolean exception) {
        return TLRPC$messages_SentEncryptedMessage.TLdeserialize(stream, constructor, exception);
    }
}
