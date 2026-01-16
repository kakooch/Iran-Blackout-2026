package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$contacts_Contacts extends TLObject {
    public int saved_count;
    public ArrayList<TLRPC$TL_contact> contacts = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$contacts_Contacts TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$contacts_Contacts tLRPC$contacts_Contacts;
        if (i == -1219778094) {
            tLRPC$contacts_Contacts = new TLRPC$contacts_Contacts() { // from class: org.rbmain.tgnet.TLRPC$TL_contacts_contactsNotModified
                public static int constructor = -1219778094;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                }
            };
        } else {
            tLRPC$contacts_Contacts = i != -353862078 ? null : new TLRPC$contacts_Contacts() { // from class: org.rbmain.tgnet.TLRPC$TL_contacts_contacts
                public static int constructor = -353862078;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    int int32 = abstractSerializedData2.readInt32(z2);
                    if (int32 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                        }
                        return;
                    }
                    int int322 = abstractSerializedData2.readInt32(z2);
                    for (int i2 = 0; i2 < int322; i2++) {
                        TLRPC$TL_contact tLRPC$TL_contactTLdeserialize = TLRPC$TL_contact.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$TL_contactTLdeserialize == null) {
                            return;
                        }
                        this.contacts.add(tLRPC$TL_contactTLdeserialize);
                    }
                    this.saved_count = abstractSerializedData2.readInt32(z2);
                    int int323 = abstractSerializedData2.readInt32(z2);
                    if (int323 != 481674261) {
                        if (z2) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int323)));
                        }
                        return;
                    }
                    int int324 = abstractSerializedData2.readInt32(z2);
                    for (int i3 = 0; i3 < int324; i3++) {
                        TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(abstractSerializedData2, abstractSerializedData2.readInt32(z2), z2);
                        if (tLRPC$UserTLdeserialize == null) {
                            return;
                        }
                        this.users.add(tLRPC$UserTLdeserialize);
                    }
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    abstractSerializedData2.writeInt32(constructor);
                    abstractSerializedData2.writeInt32(481674261);
                    int size = this.contacts.size();
                    abstractSerializedData2.writeInt32(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        this.contacts.get(i2).serializeToStream(abstractSerializedData2);
                    }
                    abstractSerializedData2.writeInt32(this.saved_count);
                    abstractSerializedData2.writeInt32(481674261);
                    int size2 = this.users.size();
                    abstractSerializedData2.writeInt32(size2);
                    for (int i3 = 0; i3 < size2; i3++) {
                        this.users.get(i3).serializeToStream(abstractSerializedData2);
                    }
                }
            };
        }
        if (tLRPC$contacts_Contacts == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in contacts_Contacts", Integer.valueOf(i)));
        }
        if (tLRPC$contacts_Contacts != null) {
            tLRPC$contacts_Contacts.readParams(abstractSerializedData, z);
        }
        return tLRPC$contacts_Contacts;
    }
}
