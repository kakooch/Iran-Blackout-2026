package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_help_termsOfService extends TLObject {
    public static int constructor = 2013922064;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public TLRPC$TL_dataJSON id;
    public int min_age_confirm;
    public boolean popup;
    public String text;

    public static TLRPC$TL_help_termsOfService TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_help_termsOfService", Integer.valueOf(i)));
            }
            return null;
        }
        TLRPC$TL_help_termsOfService tLRPC$TL_help_termsOfService = new TLRPC$TL_help_termsOfService();
        tLRPC$TL_help_termsOfService.readParams(abstractSerializedData, z);
        return tLRPC$TL_help_termsOfService;
    }

    @Override // org.rbmain.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int int32 = abstractSerializedData.readInt32(z);
        this.flags = int32;
        this.popup = (int32 & 1) != 0;
        this.id = TLRPC$TL_dataJSON.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.text = abstractSerializedData.readString(z);
        int int322 = abstractSerializedData.readInt32(z);
        if (int322 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = abstractSerializedData.readInt32(z);
        for (int i = 0; i < int323; i++) {
            TLRPC$MessageEntity tLRPC$MessageEntityTLdeserialize = TLRPC$MessageEntity.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (tLRPC$MessageEntityTLdeserialize == null) {
                return;
            }
            this.entities.add(tLRPC$MessageEntityTLdeserialize);
        }
        if ((this.flags & 2) != 0) {
            this.min_age_confirm = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.popup ? this.flags | 1 : this.flags & (-2);
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        this.id.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.text);
        abstractSerializedData.writeInt32(481674261);
        int size = this.entities.size();
        abstractSerializedData.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.entities.get(i2).serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(this.min_age_confirm);
        }
    }
}
