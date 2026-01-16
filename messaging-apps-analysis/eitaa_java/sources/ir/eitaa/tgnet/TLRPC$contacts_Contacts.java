package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$contacts_Contacts extends TLObject {
    public int saved_count;
    public ArrayList<TLRPC$TL_contact> contacts = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$contacts_Contacts TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$contacts_Contacts tLRPC$contacts_Contacts;
        if (constructor == -1219778094) {
            tLRPC$contacts_Contacts = new TLRPC$contacts_Contacts() { // from class: ir.eitaa.tgnet.TLRPC$TL_contacts_contactsNotModified
                public static int constructor = -1219778094;

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$contacts_Contacts = constructor != -353862078 ? null : new TLRPC$contacts_Contacts() { // from class: ir.eitaa.tgnet.TLRPC$TL_contacts_contacts
                public static int constructor = -353862078;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    if (int32 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = stream2.readInt32(exception2);
                    for (int i = 0; i < int322; i++) {
                        TLRPC$TL_contact tLRPC$TL_contactTLdeserialize = TLRPC$TL_contact.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$TL_contactTLdeserialize == null) {
                            return;
                        }
                        this.contacts.add(tLRPC$TL_contactTLdeserialize);
                    }
                    int int323 = stream2.readInt32(exception2);
                    if (int323 != 481674261) {
                        if (exception2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                        }
                        return;
                    }
                    int int324 = stream2.readInt32(exception2);
                    for (int i2 = 0; i2 < int324; i2++) {
                        TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if (tLRPC$UserTLdeserialize == null) {
                            return;
                        }
                        this.users.add(tLRPC$UserTLdeserialize);
                    }
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt32(481674261);
                    int size = this.contacts.size();
                    stream2.writeInt32(size);
                    for (int i = 0; i < size; i++) {
                        this.contacts.get(i).serializeToStream(stream2);
                    }
                    stream2.writeInt32(481674261);
                    int size2 = this.users.size();
                    stream2.writeInt32(size2);
                    for (int i2 = 0; i2 < size2; i2++) {
                        this.users.get(i2).serializeToStream(stream2);
                    }
                }
            };
        }
        if (tLRPC$contacts_Contacts == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in contacts_Contacts", Integer.valueOf(constructor)));
        }
        if (tLRPC$contacts_Contacts != null) {
            tLRPC$contacts_Contacts.readParams(stream, exception);
        }
        return tLRPC$contacts_Contacts;
    }
}
