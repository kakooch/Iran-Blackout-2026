package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_mxbUserRegisterInfo extends TLObject {
    public static int constructor = 848734391;
    public int accessHash;
    public int avatar;
    public int flags;
    public int messenger_id;
    public int mxb_user_id;
    public String nickname;
    public String phone;
    public int user_id = -1;

    public static TLRPC$TL_mxbUserRegisterInfo TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_mxpUserRegisterInfo", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_mxbUserRegisterInfo tLRPC$TL_mxbUserRegisterInfo = new TLRPC$TL_mxbUserRegisterInfo();
        tLRPC$TL_mxbUserRegisterInfo.readParams(stream, exception);
        return tLRPC$TL_mxbUserRegisterInfo;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.nickname = stream.readString(exception);
        if ((this.flags & 2) != 0) {
            this.avatar = stream.readInt32(exception);
        }
        this.messenger_id = stream.readInt32(exception);
        this.phone = stream.readString(exception);
        this.mxb_user_id = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.user_id = stream.readInt32(exception);
            this.accessHash = stream.readInt32(exception);
        }
    }
}
