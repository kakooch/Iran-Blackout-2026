package ir.nasim;

import java.util.Arrays;
import java.util.Vector;

/* loaded from: classes7.dex */
public class X05 {
    public double a;
    private Vector b;
    private int c;
    private float d;
    private ir.nasim.tgwidgets.editor.ui.Components.Paint.a e;

    public X05(ir.nasim.tgwidgets.editor.ui.Components.Paint.f fVar) {
        Vector vector = new Vector();
        this.b = vector;
        vector.add(fVar);
    }

    public float a() {
        return this.d;
    }

    public ir.nasim.tgwidgets.editor.ui.Components.Paint.a b() {
        return this.e;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        Vector vector = this.b;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public ir.nasim.tgwidgets.editor.ui.Components.Paint.f[] e() {
        ir.nasim.tgwidgets.editor.ui.Components.Paint.f[] fVarArr = new ir.nasim.tgwidgets.editor.ui.Components.Paint.f[this.b.size()];
        this.b.toArray(fVarArr);
        return fVarArr;
    }

    public void f(int i, float f, ir.nasim.tgwidgets.editor.ui.Components.Paint.a aVar) {
        this.c = i;
        this.d = f;
        this.e = aVar;
    }

    public X05(ir.nasim.tgwidgets.editor.ui.Components.Paint.f[] fVarArr) {
        Vector vector = new Vector();
        this.b = vector;
        vector.addAll(Arrays.asList(fVarArr));
    }
}
