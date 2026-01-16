package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$SecureValueType extends TLObject {
    public static TLRPC$SecureValueType TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$SecureValueType tLRPC$TL_secureValueTypePersonalDetails;
        switch (constructor) {
            case -1995211763:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypeBankStatement
                    public static int constructor = -1995211763;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1954007928:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypeRentalAgreement
                    public static int constructor = -1954007928;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1908627474:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypeEmail
                    public static int constructor = -1908627474;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1717268701:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypeInternalPassport
                    public static int constructor = -1717268701;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1713143702:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypePassportRegistration
                    public static int constructor = -1713143702;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1658158621:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$TL_secureValueTypePersonalDetails();
                break;
            case -1596951477:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypeIdentityCard
                    public static int constructor = -1596951477;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1289704741:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypePhone
                    public static int constructor = -1289704741;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -874308058:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$TL_secureValueTypeAddress();
                break;
            case -368907213:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypeTemporaryRegistration
                    public static int constructor = -368907213;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -63531698:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypeUtilityBill
                    public static int constructor = -63531698;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 115615172:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypeDriverLicense
                    public static int constructor = 115615172;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 1034709504:
                tLRPC$TL_secureValueTypePersonalDetails = new TLRPC$SecureValueType() { // from class: ir.eitaa.tgnet.TLRPC$TL_secureValueTypePassport
                    public static int constructor = 1034709504;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$TL_secureValueTypePersonalDetails = null;
                break;
        }
        if (tLRPC$TL_secureValueTypePersonalDetails == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in SecureValueType", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_secureValueTypePersonalDetails != null) {
            tLRPC$TL_secureValueTypePersonalDetails.readParams(stream, exception);
        }
        return tLRPC$TL_secureValueTypePersonalDetails;
    }
}
