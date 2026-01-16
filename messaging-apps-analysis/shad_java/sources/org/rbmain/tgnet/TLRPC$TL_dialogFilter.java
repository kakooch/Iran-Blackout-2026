package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_dialogFilter extends TLObject {
    public static int constructor = 1949890536;
    public boolean bots;
    public boolean broadcasts;
    public boolean contacts;
    public String emoticon;
    public boolean exclude_archived;
    public boolean exclude_muted;
    public boolean exclude_read;
    public int flags;
    public boolean groups;
    public int id;
    public boolean is_suggested;
    public boolean non_contacts;
    public String suggested_folder_id;
    public String title;
    public ArrayList<TLRPC$InputPeer> pinned_peers = new ArrayList<>();
    public ArrayList<TLRPC$InputPeer> include_peers = new ArrayList<>();
    public ArrayList<TLRPC$InputPeer> exclude_peers = new ArrayList<>();

    public static TLRPC$TL_dialogFilter TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_dialogFilter", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter = new TLRPC$TL_dialogFilter();
        tLRPC$TL_dialogFilter.readParams(abstractSerializedData, z);
        return tLRPC$TL_dialogFilter;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.contacts = (int32 & 1) != 0;
        this.non_contacts = (int32 & 2) != 0;
        this.groups = (int32 & 4) != 0;
        this.broadcasts = (int32 & 8) != 0;
        this.bots = (int32 & 16) != 0;
        this.exclude_muted = (int32 & 2048) != 0;
        this.exclude_read = (int32 & 4096) != 0;
        this.exclude_archived = (int32 & 8192) != 0;
        this.id = abstractSerializedData.readInt32(z);
        this.title = abstractSerializedData.readString(z);
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            this.emoticon = abstractSerializedData.readString(z);
        }
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$InputPeer tLRPC$InputPeerTLdeserialize = TLRPC$InputPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$InputPeerTLdeserialize == null) {
                return;
            }
            this.pinned_peers.add(tLRPC$InputPeerTLdeserialize);
        }
        int int324 = abstractSerializedData.readInt32(z);
        if (int324 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int324)));
            }
            return;
        }
        int int325 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < int325; i2++) {
            TLRPC$InputPeer tLRPC$InputPeerTLdeserialize2 = TLRPC$InputPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$InputPeerTLdeserialize2 == null) {
                return;
            }
            this.include_peers.add(tLRPC$InputPeerTLdeserialize2);
        }
        int int326 = abstractSerializedData.readInt32(z);
        if (int326 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int326)));
            }
            return;
        }
        int int327 = abstractSerializedData.readInt32(z);
        for (int i3 = 0; i3 < int327; i3++) {
            TLRPC$InputPeer tLRPC$InputPeerTLdeserialize3 = TLRPC$InputPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$InputPeerTLdeserialize3 == null) {
                return;
            }
            this.exclude_peers.add(tLRPC$InputPeerTLdeserialize3);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
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
        int i6 = this.exclude_muted ? i5 | 2048 : i5 & (-2049);
        this.flags = i6;
        int i7 = this.exclude_read ? i6 | 4096 : i6 & (-4097);
        this.flags = i7;
        int i8 = this.exclude_archived ? i7 | 8192 : i7 & (-8193);
        this.flags = i8;
        abstractSerializedData.writeInt32(i8);
        abstractSerializedData.writeInt32(this.id);
        abstractSerializedData.writeString(this.title);
        if ((this.flags & ConnectionsManager.FileTypeVideo) != 0) {
            abstractSerializedData.writeString(this.emoticon);
        }
        abstractSerializedData.writeInt32(481674261);
        int size = this.pinned_peers.size();
        abstractSerializedData.writeInt32(size);
        for (int i9 = 0; i9 < size; i9++) {
            this.pinned_peers.get(i9).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.include_peers.size();
        abstractSerializedData.writeInt32(size2);
        for (int i10 = 0; i10 < size2; i10++) {
            this.include_peers.get(i10).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.exclude_peers.size();
        abstractSerializedData.writeInt32(size3);
        for (int i11 = 0; i11 < size3; i11++) {
            this.exclude_peers.get(i11).serializeToStream(abstractSerializedData);
        }
    }
}
