package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$PhoneCall extends TLObject {
    public long access_hash;
    public long admin_id;
    public ArrayList<TLRPC$PhoneConnection> connections = new ArrayList<>();
    public int date;
    public int duration;
    public int flags;
    public byte[] g_a_hash;
    public byte[] g_a_or_b;
    public byte[] g_b;
    public long id;
    public long key_fingerprint;
    public boolean need_debug;
    public boolean need_rating;
    public boolean p2p_allowed;
    public long participant_id;
    public TLRPC$PhoneCallProtocol protocol;
    public TLRPC$PhoneCallDiscardReason reason;
    public int receive_date;
    public int start_date;
    public boolean video;

    public static TLRPC$PhoneCall TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PhoneCall tLRPC$PhoneCall;
        switch (constructor) {
            case -1770029977:
                tLRPC$PhoneCall = new TLRPC$PhoneCall() { // from class: ir.eitaa.tgnet.TLRPC$TL_phoneCall
                    public static int constructor = -1770029977;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.p2p_allowed = (int32 & 32) != 0;
                        this.video = (int32 & 64) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt64(exception2);
                        this.participant_id = stream2.readInt64(exception2);
                        this.g_a_or_b = stream2.readByteArray(exception2);
                        this.key_fingerprint = stream2.readInt64(exception2);
                        this.protocol = TLRPC$PhoneCallProtocol.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        int int322 = stream2.readInt32(exception2);
                        if (int322 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
                            }
                            return;
                        }
                        int int323 = stream2.readInt32(exception2);
                        for (int i = 0; i < int323; i++) {
                            TLRPC$PhoneConnection tLRPC$PhoneConnectionTLdeserialize = TLRPC$PhoneConnection.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PhoneConnectionTLdeserialize == null) {
                                return;
                            }
                            this.connections.add(tLRPC$PhoneConnectionTLdeserialize);
                        }
                        this.start_date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.p2p_allowed ? this.flags | 32 : this.flags & (-33);
                        this.flags = i;
                        int i2 = this.video ? i | 64 : i & (-65);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt64(this.admin_id);
                        stream2.writeInt64(this.participant_id);
                        stream2.writeByteArray(this.g_a_or_b);
                        stream2.writeInt64(this.key_fingerprint);
                        this.protocol.serializeToStream(stream2);
                        stream2.writeInt32(481674261);
                        int size = this.connections.size();
                        stream2.writeInt32(size);
                        for (int i3 = 0; i3 < size; i3++) {
                            this.connections.get(i3).serializeToStream(stream2);
                        }
                        stream2.writeInt32(this.start_date);
                    }
                };
                break;
            case -987599081:
                tLRPC$PhoneCall = new TLRPC$PhoneCall() { // from class: ir.eitaa.tgnet.TLRPC$TL_phoneCallWaiting
                    public static int constructor = -987599081;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.video = (int32 & 64) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt64(exception2);
                        this.participant_id = stream2.readInt64(exception2);
                        this.protocol = TLRPC$PhoneCallProtocol.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        if ((this.flags & 1) != 0) {
                            this.receive_date = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.video ? this.flags | 64 : this.flags & (-65);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt64(this.admin_id);
                        stream2.writeInt64(this.participant_id);
                        this.protocol.serializeToStream(stream2);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.receive_date);
                        }
                    }
                };
                break;
            case 347139340:
                tLRPC$PhoneCall = new TLRPC$PhoneCall() { // from class: ir.eitaa.tgnet.TLRPC$TL_phoneCallRequested
                    public static int constructor = 347139340;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.video = (int32 & 64) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt64(exception2);
                        this.participant_id = stream2.readInt64(exception2);
                        this.g_a_hash = stream2.readByteArray(exception2);
                        this.protocol = TLRPC$PhoneCallProtocol.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.video ? this.flags | 64 : this.flags & (-65);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt64(this.admin_id);
                        stream2.writeInt64(this.participant_id);
                        stream2.writeByteArray(this.g_a_hash);
                        this.protocol.serializeToStream(stream2);
                    }
                };
                break;
            case 912311057:
                tLRPC$PhoneCall = new TLRPC$PhoneCall() { // from class: ir.eitaa.tgnet.TLRPC$TL_phoneCallAccepted
                    public static int constructor = 912311057;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.video = (int32 & 64) != 0;
                        this.id = stream2.readInt64(exception2);
                        this.access_hash = stream2.readInt64(exception2);
                        this.date = stream2.readInt32(exception2);
                        this.admin_id = stream2.readInt64(exception2);
                        this.participant_id = stream2.readInt64(exception2);
                        this.g_b = stream2.readByteArray(exception2);
                        this.protocol = TLRPC$PhoneCallProtocol.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.video ? this.flags | 64 : this.flags & (-65);
                        this.flags = i;
                        stream2.writeInt32(i);
                        stream2.writeInt64(this.id);
                        stream2.writeInt64(this.access_hash);
                        stream2.writeInt32(this.date);
                        stream2.writeInt64(this.admin_id);
                        stream2.writeInt64(this.participant_id);
                        stream2.writeByteArray(this.g_b);
                        this.protocol.serializeToStream(stream2);
                    }
                };
                break;
            case 1355435489:
                tLRPC$PhoneCall = new TLRPC$PhoneCall() { // from class: ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscarded
                    public static int constructor = 1355435489;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.need_rating = (int32 & 4) != 0;
                        this.need_debug = (int32 & 8) != 0;
                        this.video = (int32 & 64) != 0;
                        this.id = stream2.readInt64(exception2);
                        if ((this.flags & 1) != 0) {
                            this.reason = TLRPC$PhoneCallDiscardReason.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.duration = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.need_rating ? this.flags | 4 : this.flags & (-5);
                        this.flags = i;
                        int i2 = this.need_debug ? i | 8 : i & (-9);
                        this.flags = i2;
                        int i3 = this.video ? i2 | 64 : i2 & (-65);
                        this.flags = i3;
                        stream2.writeInt32(i3);
                        stream2.writeInt64(this.id);
                        if ((this.flags & 1) != 0) {
                            this.reason.serializeToStream(stream2);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeInt32(this.duration);
                        }
                    }
                };
                break;
            case 1399245077:
                tLRPC$PhoneCall = new TLRPC$PhoneCall() { // from class: ir.eitaa.tgnet.TLRPC$TL_phoneCallEmpty
                    public static int constructor = 1399245077;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.id = stream2.readInt64(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.id);
                    }
                };
                break;
            default:
                tLRPC$PhoneCall = null;
                break;
        }
        if (tLRPC$PhoneCall == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PhoneCall", Integer.valueOf(constructor)));
        }
        if (tLRPC$PhoneCall != null) {
            tLRPC$PhoneCall.readParams(stream, exception);
        }
        return tLRPC$PhoneCall;
    }
}
