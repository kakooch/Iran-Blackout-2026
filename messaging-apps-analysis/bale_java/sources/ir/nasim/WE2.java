package ir.nasim;

import java.util.regex.Matcher;

/* loaded from: classes5.dex */
public class WE2 implements RU3 {
    private Matcher a;

    public WE2(Matcher matcher) {
        this.a = matcher;
    }

    @Override // ir.nasim.RU3
    public boolean a() {
        return this.a.matches();
    }

    @Override // ir.nasim.RU3
    public String b(int i) {
        return this.a.group(i);
    }

    @Override // ir.nasim.RU3
    public int c() {
        return this.a.groupCount();
    }

    @Override // ir.nasim.RU3
    public boolean d() {
        return this.a.find();
    }

    @Override // ir.nasim.RU3
    public String e() {
        return this.a.group();
    }

    @Override // ir.nasim.RU3
    public int start() {
        return this.a.start();
    }
}
