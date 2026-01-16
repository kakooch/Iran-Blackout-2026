package ir.nasim.tgwidgets.editor.ui.Components;

import ir.nasim.AbstractC13799gq2;

/* loaded from: classes7.dex */
public class B extends AbstractC13799gq2 {
    private a b;
    private b c;
    private float d;

    public interface a {
        float get(Object obj);
    }

    public interface b {
        void a(Object obj, float f);
    }

    public B(String str, a aVar, b bVar) {
        super(str);
        this.d = 1.0f;
        this.b = aVar;
        this.c = bVar;
    }

    @Override // ir.nasim.AbstractC13799gq2
    public float a(Object obj) {
        return this.b.get(obj) * this.d;
    }

    @Override // ir.nasim.AbstractC13799gq2
    public void b(Object obj, float f) {
        this.c.a(obj, f / this.d);
    }
}
