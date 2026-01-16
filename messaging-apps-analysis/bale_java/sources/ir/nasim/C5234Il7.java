package ir.nasim;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.Il7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C5234Il7 {
    private float c;
    private C7605Sk7 f;
    private final TextPaint a = new TextPaint(1);
    private final AbstractC8078Uk7 b = new a();
    private boolean d = true;
    private WeakReference e = new WeakReference(null);

    /* renamed from: ir.nasim.Il7$a */
    class a extends AbstractC8078Uk7 {
        a() {
        }

        @Override // ir.nasim.AbstractC8078Uk7
        public void a(int i) {
            C5234Il7.this.d = true;
            b bVar = (b) C5234Il7.this.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // ir.nasim.AbstractC8078Uk7
        public void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            C5234Il7.this.d = true;
            b bVar = (b) C5234Il7.this.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* renamed from: ir.nasim.Il7$b */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public C5234Il7(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    public C7605Sk7 d() {
        return this.f;
    }

    public TextPaint e() {
        return this.a;
    }

    public float f(String str) {
        if (!this.d) {
            return this.c;
        }
        float fC = c(str);
        this.c = fC;
        this.d = false;
        return fC;
    }

    public void g(b bVar) {
        this.e = new WeakReference(bVar);
    }

    public void h(C7605Sk7 c7605Sk7, Context context) {
        if (this.f != c7605Sk7) {
            this.f = c7605Sk7;
            if (c7605Sk7 != null) {
                c7605Sk7.o(context, this.a, this.b);
                b bVar = (b) this.e.get();
                if (bVar != null) {
                    this.a.drawableState = bVar.getState();
                }
                c7605Sk7.n(context, this.a, this.b);
                this.d = true;
            }
            b bVar2 = (b) this.e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z) {
        this.d = z;
    }

    public void j(Context context) {
        this.f.n(context, this.a, this.b);
    }
}
