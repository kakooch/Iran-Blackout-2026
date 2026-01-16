package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_importContacts extends TLObject {
    public static int constructor = 746589157;
    public ArrayList<TLRPC$TL_inputPhoneContact> contacts = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$TL_contacts_importedContacts.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.contacts.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.contacts.get(i).serializeToStream(stream);
        }
        stream.writeBool(true);
    }
}
