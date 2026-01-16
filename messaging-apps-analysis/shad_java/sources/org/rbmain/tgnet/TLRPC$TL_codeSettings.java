package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public class TLRPC$TL_codeSettings extends TLObject {
    public static int constructor = -557924733;
    public boolean allow_app_hash;
    public boolean allow_flashcall;
    public boolean current_number;
    public int flags;

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.allow_flashcall = (int32 & 1) != 0;
        this.current_number = (int32 & 2) != 0;
        this.allow_app_hash = (int32 & 16) != 0;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.allow_flashcall ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.current_number ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.allow_app_hash ? i2 | 16 : i2 & (-17);
        this.flags = i3;
        abstractSerializedData.writeInt32(i3);
    }
}
