package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$PhoneCallProtocol extends TLObject {
    public int flags;
    public ArrayList<String> library_versions = new ArrayList<>();
    public int max_layer;
    public int min_layer;
    public boolean udp_p2p;
    public boolean udp_reflector;

    public static TLRPC$PhoneCallProtocol TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol;
        if (constructor != -1564789301) {
            tLRPC$TL_phoneCallProtocol = constructor != -58224696 ? null : new TLRPC$TL_phoneCallProtocol();
        } else {
            tLRPC$TL_phoneCallProtocol = new TLRPC$TL_phoneCallProtocol() { // from class: ir.eitaa.tgnet.TLRPC$TL_phoneCallProtocol_layer110
                public static int constructor = -1564789301;

                @Override // ir.eitaa.tgnet.TLRPC$TL_phoneCallProtocol, ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.udp_p2p = (int32 & 1) != 0;
                    this.udp_reflector = (int32 & 2) != 0;
                    this.min_layer = stream2.readInt32(exception2);
                    this.max_layer = stream2.readInt32(exception2);
                }

                @Override // ir.eitaa.tgnet.TLRPC$TL_phoneCallProtocol, ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    int i = this.udp_p2p ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    int i2 = this.udp_reflector ? i | 2 : i & (-3);
                    this.flags = i2;
                    stream2.writeInt32(i2);
                    stream2.writeInt32(this.min_layer);
                    stream2.writeInt32(this.max_layer);
                }
            };
        }
        if (tLRPC$TL_phoneCallProtocol == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PhoneCallProtocol", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_phoneCallProtocol != null) {
            tLRPC$TL_phoneCallProtocol.readParams(stream, exception);
        }
        return tLRPC$TL_phoneCallProtocol;
    }
}
