package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_phoneCallProtocol extends TLRPC$PhoneCallProtocol {
    public static int constructor = -58224696;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.udp_p2p = (int32 & 1) != 0;
        this.udp_reflector = (int32 & 2) != 0;
        this.min_layer = stream.readInt32(exception);
        this.max_layer = stream.readInt32(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
        } else {
            int int323 = stream.readInt32(exception);
            for (int i = 0; i < int323; i++) {
                this.library_versions.add(stream.readString(exception));
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.udp_p2p ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.udp_reflector ? i | 2 : i & (-3);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeInt32(this.min_layer);
        stream.writeInt32(this.max_layer);
        stream.writeInt32(481674261);
        int size = this.library_versions.size();
        stream.writeInt32(size);
        for (int i3 = 0; i3 < size; i3++) {
            stream.writeString(this.library_versions.get(i3));
        }
    }
}
