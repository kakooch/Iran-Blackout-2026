package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class ContactsNeedsReloadResult {
    public TypeEnum type;

    public enum TypeEnum {
        allContactListUpdated,
        lastOnlineSortedChanged
    }

    public ContactsNeedsReloadResult(TypeEnum typeEnum) {
        this.type = typeEnum;
    }
}
