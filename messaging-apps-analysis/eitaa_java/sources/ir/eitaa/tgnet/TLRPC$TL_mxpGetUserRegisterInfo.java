package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_mxpGetUserRegisterInfo extends TLObject {
    public static int constructor = -1337037940;
    public String phone;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$TL_mbpUserRegisterInfos tLRPC$TL_mbpUserRegisterInfos = new TLRPC$TL_mbpUserRegisterInfos();
        tLRPC$TL_mbpUserRegisterInfos.readParams(stream, exception);
        return tLRPC$TL_mbpUserRegisterInfos;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.phone);
    }
}
