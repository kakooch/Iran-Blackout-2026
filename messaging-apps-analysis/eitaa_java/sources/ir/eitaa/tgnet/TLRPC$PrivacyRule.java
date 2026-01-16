package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$PrivacyRule extends TLObject {
    public static TLRPC$PrivacyRule TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PrivacyRule tLRPC$TL_privacyValueAllowUsers;
        switch (constructor) {
            case -1955338397:
                tLRPC$TL_privacyValueAllowUsers = new TLRPC$PrivacyRule() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyValueDisallowAll
                    public static int constructor = -1955338397;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1198497870:
                tLRPC$TL_privacyValueAllowUsers = new TLRPC$TL_privacyValueAllowUsers();
                break;
            case -463335103:
                tLRPC$TL_privacyValueAllowUsers = new TLRPC$TL_privacyValueDisallowUsers();
                break;
            case -125240806:
                tLRPC$TL_privacyValueAllowUsers = new TLRPC$PrivacyRule() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyValueDisallowContacts
                    public static int constructor = -125240806;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -123988:
                tLRPC$TL_privacyValueAllowUsers = new TLRPC$PrivacyRule() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyValueAllowContacts
                    public static int constructor = -123988;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1103656293:
                tLRPC$TL_privacyValueAllowUsers = new TLRPC$TL_privacyValueDisallowChatParticipants();
                break;
            case 1698855810:
                tLRPC$TL_privacyValueAllowUsers = new TLRPC$PrivacyRule() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyValueAllowAll
                    public static int constructor = 1698855810;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1796427406:
                tLRPC$TL_privacyValueAllowUsers = new TLRPC$TL_privacyValueAllowChatParticipants();
                break;
            default:
                tLRPC$TL_privacyValueAllowUsers = null;
                break;
        }
        if (tLRPC$TL_privacyValueAllowUsers == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PrivacyRule", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_privacyValueAllowUsers != null) {
            tLRPC$TL_privacyValueAllowUsers.readParams(stream, exception);
        }
        return tLRPC$TL_privacyValueAllowUsers;
    }
}
