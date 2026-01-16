package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_secureRequiredType extends TLRPC$SecureRequiredType {
    public static int constructor = -2103600678;
    public int flags;
    public boolean native_names;
    public boolean selfie_required;
    public boolean translation_required;
    public TLRPC$SecureValueType type;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.native_names = (int32 & 1) != 0;
        this.selfie_required = (int32 & 2) != 0;
        this.translation_required = (int32 & 4) != 0;
        this.type = TLRPC$SecureValueType.TLdeserialize(stream, stream.readInt32(exception), exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.native_names ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.selfie_required ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.translation_required ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        stream.writeInt32(i3);
        this.type.serializeToStream(stream);
    }
}
