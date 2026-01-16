package ir.nasim;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import java.text.BreakIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/* renamed from: ir.nasim.ou3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18586ou3 {
    private final CharSequence a;
    private final TextPaint b;
    private final int c;
    private float d = Float.NaN;
    private float e = Float.NaN;
    private BoringLayout.Metrics f;
    private boolean g;
    private CharSequence h;

    public C18586ou3(CharSequence charSequence, TextPaint textPaint, int i) {
        this.a = charSequence;
        this.b = textPaint;
        this.c = i;
    }

    private final float b() {
        BoringLayout.Metrics metricsE = e();
        float fCeil = metricsE != null ? metricsE.width : -1;
        if (fCeil < 0.0f) {
            fCeil = (float) Math.ceil(h(this, 0, 0, 3, null));
        }
        return AbstractC19177pu3.d(fCeil, this.a, this.b) ? fCeil + 0.5f : fCeil;
    }

    private final float c() {
        BreakIterator lineInstance = BreakIterator.getLineInstance(this.b.getTextLocale());
        CharSequence charSequence = this.a;
        int i = 0;
        lineInstance.setText(new C12875fK0(charSequence, 0, charSequence.length()));
        PriorityQueue priorityQueue = new PriorityQueue(10, new Comparator() { // from class: ir.nasim.nu3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C18586ou3.d((XV4) obj, (XV4) obj2);
            }
        });
        int next = lineInstance.next();
        while (true) {
            int i2 = i;
            i = next;
            if (i == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new XV4(Integer.valueOf(i2), Integer.valueOf(i)));
            } else {
                XV4 xv4 = (XV4) priorityQueue.peek();
                if (xv4 != null && ((Number) xv4.f()).intValue() - ((Number) xv4.e()).intValue() < i - i2) {
                    priorityQueue.poll();
                    priorityQueue.add(new XV4(Integer.valueOf(i2), Integer.valueOf(i)));
                }
            }
            next = lineInstance.next();
        }
        if (priorityQueue.isEmpty()) {
            return 0.0f;
        }
        Iterator it = priorityQueue.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        XV4 xv42 = (XV4) it.next();
        float fG = g(((Number) xv42.a()).intValue(), ((Number) xv42.b()).intValue());
        while (it.hasNext()) {
            XV4 xv43 = (XV4) it.next();
            fG = Math.max(fG, g(((Number) xv43.a()).intValue(), ((Number) xv43.b()).intValue()));
        }
        return fG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(XV4 xv4, XV4 xv42) {
        return (((Number) xv4.f()).intValue() - ((Number) xv4.e()).intValue()) - (((Number) xv42.f()).intValue() - ((Number) xv42.e()).intValue());
    }

    private final CharSequence f() {
        CharSequence charSequence = this.h;
        if (charSequence != null) {
            AbstractC13042fc3.f(charSequence);
            return charSequence;
        }
        if (!AbstractC19177pu3.a) {
            return this.a;
        }
        CharSequence charSequenceE = AbstractC19177pu3.e(this.a);
        this.h = charSequenceE;
        return charSequenceE;
    }

    private final float g(int i, int i2) {
        return Layout.getDesiredWidth(f(), i, i2, this.b);
    }

    static /* synthetic */ float h(C18586ou3 c18586ou3, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = c18586ou3.f().length();
        }
        return c18586ou3.g(i, i2);
    }

    public final BoringLayout.Metrics e() {
        if (!this.g) {
            this.f = C14918ii0.a.c(this.a, this.b, AbstractC15565jn7.k(this.c));
            this.g = true;
        }
        return this.f;
    }

    public final float i() {
        if (!Float.isNaN(this.d)) {
            return this.d;
        }
        float fB = b();
        this.d = fB;
        return fB;
    }

    public final float j() {
        if (!Float.isNaN(this.e)) {
            return this.e;
        }
        float fC = c();
        this.e = fC;
        return fC;
    }
}
