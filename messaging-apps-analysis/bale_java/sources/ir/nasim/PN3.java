package ir.nasim;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class PN3 implements KZ1 {
    private final Map a;

    public PN3(Map map) {
        this.a = map;
    }

    @Override // ir.nasim.KZ1
    public Object a(float f, boolean z) {
        Object next;
        Iterator it = this.a.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float fFloatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
                float f2 = z ? fFloatValue - f : f - fFloatValue;
                if (f2 < 0.0f) {
                    f2 = Float.POSITIVE_INFINITY;
                }
                do {
                    Object next2 = it.next();
                    float fFloatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                    float f3 = z ? fFloatValue2 - f : f - fFloatValue2;
                    if (f3 < 0.0f) {
                        f3 = Float.POSITIVE_INFINITY;
                    }
                    if (Float.compare(f2, f3) > 0) {
                        next = next2;
                        f2 = f3;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return entry.getKey();
        }
        return null;
    }

    @Override // ir.nasim.KZ1
    public Object b(float f) {
        Object next;
        Iterator it = this.a.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                float fAbs = Math.abs(f - ((Number) ((Map.Entry) next).getValue()).floatValue());
                do {
                    Object next2 = it.next();
                    float fAbs2 = Math.abs(f - ((Number) ((Map.Entry) next2).getValue()).floatValue());
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return entry.getKey();
        }
        return null;
    }

    @Override // ir.nasim.KZ1
    public boolean c(Object obj) {
        return this.a.containsKey(obj);
    }

    @Override // ir.nasim.KZ1
    public float d() {
        Float fL0 = AbstractC15401jX0.L0(this.a.values());
        if (fL0 != null) {
            return fL0.floatValue();
        }
        return Float.NaN;
    }

    @Override // ir.nasim.KZ1
    public float e(Object obj) {
        Float f = (Float) this.a.get(obj);
        if (f != null) {
            return f.floatValue();
        }
        return Float.NaN;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PN3) {
            return AbstractC13042fc3.d(this.a, ((PN3) obj).a);
        }
        return false;
    }

    @Override // ir.nasim.KZ1
    public float f() {
        Float fI0 = AbstractC15401jX0.I0(this.a.values());
        if (fI0 != null) {
            return fI0.floatValue();
        }
        return Float.NaN;
    }

    public int hashCode() {
        return this.a.hashCode() * 31;
    }

    public String toString() {
        return "MapDraggableAnchors(" + this.a + ')';
    }
}
