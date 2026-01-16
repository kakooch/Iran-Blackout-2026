package ir.aaap.messengercore.model;

/* loaded from: classes3.dex */
public class SettingItem2 {
    public Link link;
    public String title;
    public TypeEnum type;

    public enum TypeEnum {
        Simple,
        Header,
        Empty
    }

    public SettingItem2(String str) {
        this.title = str;
        this.type = TypeEnum.Header;
    }

    public SettingItem2(TypeEnum typeEnum) {
        this.type = typeEnum;
    }
}
