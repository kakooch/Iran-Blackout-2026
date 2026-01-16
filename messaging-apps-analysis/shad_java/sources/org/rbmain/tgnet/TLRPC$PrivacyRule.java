package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$PrivacyRule extends TLObject {
    public static TLRPC$PrivacyRule TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$PrivacyRule tLRPC$TL_privacyValueDisallowAll;
        switch (i) {
            case -1955338397:
                tLRPC$TL_privacyValueDisallowAll = new TLRPC$TL_privacyValueDisallowAll();
                break;
            case -1397881200:
                tLRPC$TL_privacyValueDisallowAll = new TLRPC$TL_privacyValueDisallowChatParticipants();
                break;
            case -125240806:
                tLRPC$TL_privacyValueDisallowAll = new TLRPC$PrivacyRule() { // from class: org.rbmain.tgnet.TLRPC$TL_privacyValueDisallowContacts
                    public static int constructor = -125240806;

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                        abstractSerializedData2.writeInt32(constructor);
                    }
                };
                break;
            case -123988:
                tLRPC$TL_privacyValueDisallowAll = new TLRPC$TL_privacyValueAllowContacts();
                break;
            case 209668535:
                tLRPC$TL_privacyValueDisallowAll = new TLRPC$TL_privacyValueDisallowUsers();
                break;
            case 415136107:
                tLRPC$TL_privacyValueDisallowAll = new TLRPC$TL_privacyValueAllowChatParticipants();
                break;
            case 1297858060:
                tLRPC$TL_privacyValueDisallowAll = new TLRPC$TL_privacyValueAllowUsers();
                break;
            case 1698855810:
                tLRPC$TL_privacyValueDisallowAll = new TLRPC$TL_privacyValueAllowAll();
                break;
            default:
                tLRPC$TL_privacyValueDisallowAll = null;
                break;
        }
        if (tLRPC$TL_privacyValueDisallowAll == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PrivacyRule", Integer.valueOf(i)));
        }
        if (tLRPC$TL_privacyValueDisallowAll != null) {
            tLRPC$TL_privacyValueDisallowAll.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_privacyValueDisallowAll;
    }
}
