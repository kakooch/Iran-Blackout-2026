package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$PhoneConnection extends TLObject {
    public int flags;
    public long id;
    public String ip;
    public String ipv6;
    public String password;
    public byte[] peer_tag;
    public int port;
    public boolean stun;
    public boolean turn;
    public String username;

    public static TLRPC$PhoneConnection TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PhoneConnection tLRPC$PhoneConnection;
        if (constructor == -1655957568) {
            tLRPC$PhoneConnection = new TLRPC$PhoneConnection() { // from class: ir.eitaa.tgnet.TLRPC$TL_phoneConnection
                public static int constructor = -1655957568;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    this.id = stream2.readInt64(exception2);
                    this.ip = stream2.readString(exception2);
                    this.ipv6 = stream2.readString(exception2);
                    this.port = stream2.readInt32(exception2);
                    this.peer_tag = stream2.readByteArray(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    stream2.writeInt64(this.id);
                    stream2.writeString(this.ip);
                    stream2.writeString(this.ipv6);
                    stream2.writeInt32(this.port);
                    stream2.writeByteArray(this.peer_tag);
                }
            };
        } else {
            tLRPC$PhoneConnection = constructor != 1667228533 ? null : new TLRPC$PhoneConnection() { // from class: ir.eitaa.tgnet.TLRPC$TL_phoneConnectionWebrtc
                public static int constructor = 1667228533;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream2, boolean exception2) {
                    int int32 = stream2.readInt32(exception2);
                    this.flags = int32;
                    this.turn = (int32 & 1) != 0;
                    this.stun = (int32 & 2) != 0;
                    this.id = stream2.readInt64(exception2);
                    this.ip = stream2.readString(exception2);
                    this.ipv6 = stream2.readString(exception2);
                    this.port = stream2.readInt32(exception2);
                    this.username = stream2.readString(exception2);
                    this.password = stream2.readString(exception2);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream2) {
                    stream2.writeInt32(constructor);
                    int i = this.turn ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    int i2 = this.stun ? i | 2 : i & (-3);
                    this.flags = i2;
                    stream2.writeInt32(i2);
                    stream2.writeInt64(this.id);
                    stream2.writeString(this.ip);
                    stream2.writeString(this.ipv6);
                    stream2.writeInt32(this.port);
                    stream2.writeString(this.username);
                    stream2.writeString(this.password);
                }
            };
        }
        if (tLRPC$PhoneConnection == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PhoneConnection", Integer.valueOf(constructor)));
        }
        if (tLRPC$PhoneConnection != null) {
            tLRPC$PhoneConnection.readParams(stream, exception);
        }
        return tLRPC$PhoneConnection;
    }
}
