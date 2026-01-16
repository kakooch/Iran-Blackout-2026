package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_mxbUser extends TLObject {
    public int flags;
    public TLRPC$TL_mxbUserRegisterInfo mxbRegisterInfos;
    public TLRPC$User user;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.mxbRegisterInfos = TLRPC$TL_mxbUserRegisterInfo.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.user = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
    }
}
