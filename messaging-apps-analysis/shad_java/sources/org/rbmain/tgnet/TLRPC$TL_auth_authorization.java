package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_auth_authorization extends TLRPC$auth_Authorization {
    public static int constructor = -855308010;
    public int flags;
    public int tmp_sessions;
    public TLRPC$User user;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        if ((int32 & 1) != 0) {
            this.tmp_sessions = abstractSerializedData.readInt32(z);
        }
        this.user = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(this.tmp_sessions);
        }
        this.user.serializeToStream(abstractSerializedData);
    }
}
