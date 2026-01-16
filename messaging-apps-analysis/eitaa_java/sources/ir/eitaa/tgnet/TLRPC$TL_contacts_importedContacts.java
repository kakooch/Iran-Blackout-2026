package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_contacts_importedContacts extends TLObject {
    public static int constructor = 2010127419;
    public ArrayList<TLRPC$TL_importedContact> imported = new ArrayList<>();
    public ArrayList<TLRPC$TL_popularContact> popular_invites = new ArrayList<>();
    public ArrayList<Long> retry_contacts = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_contacts_importedContacts TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_contacts_importedContacts", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_contacts_importedContacts tLRPC$TL_contacts_importedContacts = new TLRPC$TL_contacts_importedContacts();
        tLRPC$TL_contacts_importedContacts.readParams(stream, exception);
        return tLRPC$TL_contacts_importedContacts;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
            return;
        }
        int int322 = stream.readInt32(exception);
        for (int i = 0; i < int322; i++) {
            TLRPC$TL_importedContact tLRPC$TL_importedContactTLdeserialize = TLRPC$TL_importedContact.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_importedContactTLdeserialize == null) {
                return;
            }
            this.imported.add(tLRPC$TL_importedContactTLdeserialize);
        }
        int int323 = stream.readInt32(exception);
        if (int323 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
            }
            return;
        }
        int int324 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int324; i2++) {
            TLRPC$TL_popularContact tLRPC$TL_popularContactTLdeserialize = TLRPC$TL_popularContact.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_popularContactTLdeserialize == null) {
                return;
            }
            this.popular_invites.add(tLRPC$TL_popularContactTLdeserialize);
        }
        int int325 = stream.readInt32(exception);
        if (int325 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int325)));
            }
            return;
        }
        int int326 = stream.readInt32(exception);
        for (int i3 = 0; i3 < int326; i3++) {
            this.retry_contacts.add(Long.valueOf(stream.readInt64(exception)));
        }
        int int327 = stream.readInt32(exception);
        if (int327 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int327)));
            }
            return;
        }
        int int328 = stream.readInt32(exception);
        for (int i4 = 0; i4 < int328; i4++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(481674261);
        int size = this.imported.size();
        stream.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.imported.get(i).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.popular_invites.size();
        stream.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.popular_invites.get(i2).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size3 = this.retry_contacts.size();
        stream.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            stream.writeInt64(this.retry_contacts.get(i3).longValue());
        }
        stream.writeInt32(481674261);
        int size4 = this.users.size();
        stream.writeInt32(size4);
        for (int i4 = 0; i4 < size4; i4++) {
            this.users.get(i4).serializeToStream(stream);
        }
    }
}
