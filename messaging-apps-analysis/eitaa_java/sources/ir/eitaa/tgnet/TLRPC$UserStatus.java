package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$UserStatus extends TLObject {
    public int expires;

    public static TLRPC$UserStatus TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$UserStatus tLRPC$UserStatus;
        switch (constructor) {
            case -496024847:
                tLRPC$UserStatus = new TLRPC$UserStatus() { // from class: ir.eitaa.tgnet.TLRPC$TL_userStatusRecently
                    public static int constructor = -496024847;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -306628279:
                tLRPC$UserStatus = new TLRPC$UserStatus() { // from class: ir.eitaa.tgnet.TLRPC$TL_userStatusOnline
                    public static int constructor = -306628279;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.expires = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.expires);
                    }
                };
                break;
            case 9203775:
                tLRPC$UserStatus = new TLRPC$UserStatus() { // from class: ir.eitaa.tgnet.TLRPC$TL_userStatusOffline
                    public static int constructor = 9203775;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.expires = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.expires);
                    }
                };
                break;
            case 129960444:
                tLRPC$UserStatus = new TLRPC$UserStatus() { // from class: ir.eitaa.tgnet.TLRPC$TL_userStatusLastWeek
                    public static int constructor = 129960444;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 164646985:
                tLRPC$UserStatus = new TLRPC$UserStatus() { // from class: ir.eitaa.tgnet.TLRPC$TL_userStatusEmpty
                    public static int constructor = 164646985;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 2011940674:
                tLRPC$UserStatus = new TLRPC$UserStatus() { // from class: ir.eitaa.tgnet.TLRPC$TL_userStatusLastMonth
                    public static int constructor = 2011940674;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            default:
                tLRPC$UserStatus = null;
                break;
        }
        if (tLRPC$UserStatus == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in UserStatus", Integer.valueOf(constructor)));
        }
        if (tLRPC$UserStatus != null) {
            tLRPC$UserStatus.readParams(stream, exception);
        }
        return tLRPC$UserStatus;
    }
}
