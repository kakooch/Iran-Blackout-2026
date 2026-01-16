package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;

/* renamed from: ir.nasim.t07, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C21041t07 implements ILoggerFactory {
    boolean a = false;
    final Map b = new HashMap();
    final LinkedBlockingQueue c = new LinkedBlockingQueue();

    @Override // org.slf4j.ILoggerFactory
    public synchronized OI3 a(String str) {
        C20438s07 c20438s07;
        c20438s07 = (C20438s07) this.b.get(str);
        if (c20438s07 == null) {
            c20438s07 = new C20438s07(str, this.c, this.a);
            this.b.put(str, c20438s07);
        }
        return c20438s07;
    }

    public void b() {
        this.b.clear();
        this.c.clear();
    }

    public LinkedBlockingQueue c() {
        return this.c;
    }

    public List d() {
        return new ArrayList(this.b.values());
    }

    public void e() {
        this.a = true;
    }
}
