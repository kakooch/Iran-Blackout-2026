package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.j;
import ir.nasim.C11580dF2;
import ir.nasim.C17491n33;
import ir.nasim.C20107rU5;
import ir.nasim.LJ;
import ir.nasim.PX7;
import ir.nasim.WI2;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class d extends ContextWrapper {
    static final i k = new C11580dF2();
    private final LJ a;
    private final WI2.b b;
    private final C17491n33 c;
    private final b.a d;
    private final List e;
    private final Map f;
    private final j g;
    private final e h;
    private final int i;
    private C20107rU5 j;

    public d(Context context, LJ lj, WI2.b bVar, C17491n33 c17491n33, b.a aVar, Map map, List list, j jVar, e eVar, int i) {
        super(context.getApplicationContext());
        this.a = lj;
        this.c = c17491n33;
        this.d = aVar;
        this.e = list;
        this.f = map;
        this.g = jVar;
        this.h = eVar;
        this.i = i;
        this.b = WI2.a(bVar);
    }

    public PX7 a(ImageView imageView, Class cls) {
        return this.c.a(imageView, cls);
    }

    public LJ b() {
        return this.a;
    }

    public List c() {
        return this.e;
    }

    public synchronized C20107rU5 d() {
        try {
            if (this.j == null) {
                this.j = (C20107rU5) this.d.a().W();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.j;
    }

    public i e(Class cls) {
        i iVar = (i) this.f.get(cls);
        if (iVar == null) {
            for (Map.Entry entry : this.f.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    iVar = (i) entry.getValue();
                }
            }
        }
        return iVar == null ? k : iVar;
    }

    public j f() {
        return this.g;
    }

    public e g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }

    public Registry i() {
        return (Registry) this.b.get();
    }
}
