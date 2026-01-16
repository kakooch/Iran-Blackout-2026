package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.enums.EnumActionObject;

/* loaded from: classes3.dex */
public class ActionOnObjectInput {
    public EnumActionObject action;
    public String arg1;
    public String arg2;
    public String id;
    public String type;

    public ActionOnObjectInput(String str, String str2, EnumActionObject enumActionObject, String str3, String str4) {
        this.arg1 = BuildConfig.FLAVOR;
        this.arg2 = BuildConfig.FLAVOR;
        this.id = str;
        this.type = str2;
        this.action = enumActionObject;
        this.arg1 = str3;
        this.arg2 = str4;
    }

    public ActionOnObjectInput(String str, String str2, EnumActionObject enumActionObject) {
        this.arg1 = BuildConfig.FLAVOR;
        this.arg2 = BuildConfig.FLAVOR;
        this.id = str;
        this.type = str2;
        this.action = enumActionObject;
    }
}
