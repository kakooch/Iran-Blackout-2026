package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.DataGenerator;

/* loaded from: classes3.dex */
public class ObjectGuidType {
    public String object_guid;
    public ChatType type;

    public ObjectGuidType(String str, ChatType chatType) {
        this.object_guid = str;
        this.type = chatType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ObjectGuidType objectGuidType = (ObjectGuidType) obj;
        return DataGenerator.isTwoStringEquals(this.object_guid, objectGuidType.object_guid) && this.type == objectGuidType.type;
    }

    public int hashCode() {
        return this.object_guid.hashCode();
    }
}
