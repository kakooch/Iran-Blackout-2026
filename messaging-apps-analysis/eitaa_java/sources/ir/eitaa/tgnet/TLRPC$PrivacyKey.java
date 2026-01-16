package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$PrivacyKey extends TLObject {
    public static TLRPC$PrivacyKey TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PrivacyKey tLRPC$PrivacyKey;
        switch (constructor) {
            case -1777000467:
                tLRPC$PrivacyKey = new TLRPC$PrivacyKey() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyKeyProfilePhoto
                    public static int constructor = -1777000467;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1137792208:
                tLRPC$PrivacyKey = new TLRPC$PrivacyKey() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyKeyStatusTimestamp
                    public static int constructor = -1137792208;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -778378131:
                tLRPC$PrivacyKey = new TLRPC$PrivacyKey() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyKeyPhoneNumber
                    public static int constructor = -778378131;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 961092808:
                tLRPC$PrivacyKey = new TLRPC$PrivacyKey() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyKeyPhoneP2P
                    public static int constructor = 961092808;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1030105979:
                tLRPC$PrivacyKey = new TLRPC$PrivacyKey() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyKeyPhoneCall
                    public static int constructor = 1030105979;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1124062251:
                tLRPC$PrivacyKey = new TLRPC$PrivacyKey() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyKeyAddedByPhone
                    public static int constructor = 1124062251;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1343122938:
                tLRPC$PrivacyKey = new TLRPC$PrivacyKey() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyKeyChatInvite
                    public static int constructor = 1343122938;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1777096355:
                tLRPC$PrivacyKey = new TLRPC$PrivacyKey() { // from class: ir.eitaa.tgnet.TLRPC$TL_privacyKeyForwards
                    public static int constructor = 1777096355;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$PrivacyKey = null;
                break;
        }
        if (tLRPC$PrivacyKey == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PrivacyKey", Integer.valueOf(constructor)));
        }
        if (tLRPC$PrivacyKey != null) {
            tLRPC$PrivacyKey.readParams(stream, exception);
        }
        return tLRPC$PrivacyKey;
    }
}
