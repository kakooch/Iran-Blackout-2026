package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.sI0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20603sI0 {
    private a a;
    private int b;
    private int c;
    private int d;
    private ArrayList e;

    /* renamed from: ir.nasim.sI0$a */
    public enum a {
        ADD,
        REMOVE,
        UPDATE,
        MOVE
    }

    private C20603sI0(a aVar, int i, int i2, int i3, ArrayList arrayList) {
        this.a = aVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = arrayList;
    }

    public static C20603sI0 a(int i, Object obj) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        return b(i, arrayList);
    }

    public static C20603sI0 b(int i, List list) {
        return new C20603sI0(a.ADD, i, 0, list.size(), new ArrayList(list));
    }

    public static C20603sI0 h(C20603sI0 c20603sI0, C20603sI0 c20603sI02) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c20603sI0.e());
        arrayList.addAll(c20603sI02.e());
        return new C20603sI0(a.ADD, c20603sI0.d(), 0, arrayList.size(), arrayList);
    }

    public static C20603sI0 i(int i, int i2) {
        return new C20603sI0(a.MOVE, i, i2, 1, null);
    }

    public static C20603sI0 j(int i) {
        return k(i, 1);
    }

    public static C20603sI0 k(int i, int i2) {
        return new C20603sI0(a.REMOVE, i, 0, i2, null);
    }

    public static C20603sI0 l(int i, Object obj) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        return m(i, arrayList);
    }

    public static C20603sI0 m(int i, List list) {
        return new C20603sI0(a.UPDATE, i, 0, list.size(), new ArrayList(list));
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public ArrayList e() {
        return this.e;
    }

    public int f() {
        return this.d;
    }

    public a g() {
        return this.a;
    }

    public String toString() {
        return "{" + this.a + " | " + this.b + " -> " + this.c + " | #" + this.d + " | " + this.e + '}';
    }
}
