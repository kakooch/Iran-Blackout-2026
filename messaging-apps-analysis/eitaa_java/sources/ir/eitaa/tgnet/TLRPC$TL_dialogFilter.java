package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_dialogFilter extends TLObject {
    public static int constructor = 1949890536;
    public boolean admin;
    public boolean bots;
    public boolean broadcasts;
    public boolean contacts;
    public String emoticon;
    public boolean exclude_archived;
    public boolean exclude_muted;
    public boolean exclude_read;
    public boolean favourite;
    public int flags;
    public boolean groups;
    public int id;
    public boolean media_channel;
    public boolean non_contacts;
    public String title;
    public ArrayList<TLRPC$InputPeer> pinned_peers = new ArrayList<>();
    public ArrayList<TLRPC$InputPeer> include_peers = new ArrayList<>();
    public ArrayList<TLRPC$InputPeer> exclude_peers = new ArrayList<>();

    public static TLRPC$TL_dialogFilter TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_dialogFilter", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter = new TLRPC$TL_dialogFilter();
        tLRPC$TL_dialogFilter.readParams(stream, exception);
        return tLRPC$TL_dialogFilter;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.contacts = (int32 & 1) != 0;
        this.non_contacts = (int32 & 2) != 0;
        this.groups = (int32 & 4) != 0;
        this.broadcasts = (int32 & 8) != 0;
        this.bots = (int32 & 16) != 0;
        this.admin = (int32 & 32) != 0;
        this.favourite = (int32 & 64) != 0;
        this.media_channel = (int32 & 128) != 0;
        this.exclude_muted = (int32 & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0;
        this.exclude_read = (int32 & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0;
        this.exclude_archived = (int32 & 8192) != 0;
        this.id = stream.readInt32(exception);
        this.title = stream.readString(exception);
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            this.emoticon = stream.readString(exception);
        }
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$InputPeer tLRPC$InputPeerTLdeserialize = TLRPC$InputPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$InputPeerTLdeserialize == null) {
                return;
            }
            this.pinned_peers.add(tLRPC$InputPeerTLdeserialize);
        }
        int int324 = stream.readInt32(exception);
        if (int324 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
            }
            return;
        }
        int int325 = stream.readInt32(exception);
        for (int i2 = 0; i2 < int325; i2++) {
            TLRPC$InputPeer tLRPC$InputPeerTLdeserialize2 = TLRPC$InputPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$InputPeerTLdeserialize2 == null) {
                return;
            }
            this.include_peers.add(tLRPC$InputPeerTLdeserialize2);
        }
        int int326 = stream.readInt32(exception);
        if (int326 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
            }
            return;
        }
        int int327 = stream.readInt32(exception);
        for (int i3 = 0; i3 < int327; i3++) {
            TLRPC$InputPeer tLRPC$InputPeerTLdeserialize3 = TLRPC$InputPeer.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$InputPeerTLdeserialize3 == null) {
                return;
            }
            this.exclude_peers.add(tLRPC$InputPeerTLdeserialize3);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.contacts ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        int i2 = this.non_contacts ? i | 2 : i & (-3);
        this.flags = i2;
        int i3 = this.groups ? i2 | 4 : i2 & (-5);
        this.flags = i3;
        int i4 = this.broadcasts ? i3 | 8 : i3 & (-9);
        this.flags = i4;
        int i5 = this.bots ? i4 | 16 : i4 & (-17);
        this.flags = i5;
        int i6 = this.admin ? i5 | 32 : i5 & (-33);
        this.flags = i6;
        int i7 = this.favourite ? i6 | 64 : i6 & (-65);
        this.flags = i7;
        int i8 = this.media_channel ? i7 | 128 : i7 & (-129);
        this.flags = i8;
        int i9 = this.exclude_muted ? i8 | Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS : i8 & (-2049);
        this.flags = i9;
        int i10 = this.exclude_read ? i9 | Factory.DEVICE_HAS_CRAPPY_AAUDIO : i9 & (-4097);
        this.flags = i10;
        int i11 = this.exclude_archived ? i10 | 8192 : i10 & (-8193);
        this.flags = i11;
        stream.writeInt32(i11);
        stream.writeInt32(this.id);
        stream.writeString(this.title);
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            stream.writeString(this.emoticon);
        }
        stream.writeInt32(481674261);
        int size = this.pinned_peers.size();
        stream.writeInt32(size);
        for (int i12 = 0; i12 < size; i12++) {
            this.pinned_peers.get(i12).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size2 = this.include_peers.size();
        stream.writeInt32(size2);
        for (int i13 = 0; i13 < size2; i13++) {
            this.include_peers.get(i13).serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size3 = this.exclude_peers.size();
        stream.writeInt32(size3);
        for (int i14 = 0; i14 < size3; i14++) {
            this.exclude_peers.get(i14).serializeToStream(stream);
        }
    }
}
