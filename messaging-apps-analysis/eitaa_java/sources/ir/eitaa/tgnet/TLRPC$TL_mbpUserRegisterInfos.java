package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_mbpUserRegisterInfos extends TLObject {
    public int flags;
    public ArrayList<TLRPC$TL_mxbUserRegisterInfo> mxbRegisterInfos = new ArrayList<>();

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        int int32 = stream.readInt32(exception);
        if (int32 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
            }
        } else {
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                this.mxbRegisterInfos.add(TLRPC$TL_mxbUserRegisterInfo.TLdeserialize(stream, stream.readInt32(exception), exception));
            }
        }
    }
}
