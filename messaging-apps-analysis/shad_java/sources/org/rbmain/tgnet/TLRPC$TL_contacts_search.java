package org.rbmain.tgnet;

import ir.aaap.messengercore.model.api.SearchGlobalObjectsInput;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class TLRPC$TL_contacts_search extends TLObject {
    public static int constructor = 301470424;
    public ArrayList<SearchGlobalObjectsInput.FilterType> filterTypes = new ArrayList<>();
    public int limit;
    public String q;

    @Override // org.rbmain.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_contacts_found.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.rbmain.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.q);
        abstractSerializedData.writeInt32(this.limit);
    }
}
