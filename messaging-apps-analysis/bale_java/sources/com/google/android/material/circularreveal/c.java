package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.b;
import ir.nasim.AbstractC22590vV3;

/* loaded from: classes3.dex */
public interface c extends b.a {

    public static class b implements TypeEvaluator {
        public static final TypeEvaluator b = new b();
        private final e a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f, e eVar, e eVar2) {
            this.a.b(AbstractC22590vV3.d(eVar.a, eVar2.a, f), AbstractC22590vV3.d(eVar.b, eVar2.b, f), AbstractC22590vV3.d(eVar.c, eVar2.c, f));
            return this.a;
        }
    }

    /* renamed from: com.google.android.material.circularreveal.c$c, reason: collision with other inner class name */
    public static class C0182c extends Property {
        public static final Property a = new C0182c("circularReveal");

        private C0182c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    public static class d extends Property {
        public static final Property a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);

    public static class e {
        public float a;
        public float b;
        public float c;

        private e() {
        }

        public boolean a() {
            return this.c == Float.MAX_VALUE;
        }

        public void b(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        public void c(e eVar) {
            b(eVar.a, eVar.b, eVar.c);
        }

        public e(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        public e(e eVar) {
            this(eVar.a, eVar.b, eVar.c);
        }
    }
}
