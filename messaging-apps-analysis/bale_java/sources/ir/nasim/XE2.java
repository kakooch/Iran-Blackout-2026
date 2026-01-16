package ir.nasim;

import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class XE2 extends C15 {
    private Pattern a;

    public XE2(String str) {
        this.a = Pattern.compile(str);
    }

    @Override // ir.nasim.C15
    public RU3 a(String str) {
        return new WE2(this.a.matcher(str));
    }
}
