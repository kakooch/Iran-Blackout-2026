package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.Property;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;

/* renamed from: ir.nasim.tgwidgets.editor.ui.Components.h, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC21469h {
    public static final Property a = new a("alpha");
    public static final Property b = new b("alpha");
    public static final Property c = new c("animationProgress");
    public static final Property d = new d("animationValue");

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.h$a */
    class a extends f {
        a(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(Paint paint) {
            return Integer.valueOf(paint.getAlpha());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Paint paint, int i) {
            paint.setAlpha(i);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.h$b */
    class b extends f {
        b(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer get(ColorDrawable colorDrawable) {
            return Integer.valueOf(colorDrawable.getAlpha());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(ColorDrawable colorDrawable, int i) {
            colorDrawable.setAlpha(i);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.h$c */
    class c extends e {
        c(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(ClippingImageView clippingImageView) {
            return Float.valueOf(clippingImageView.getAnimationProgress());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(ClippingImageView clippingImageView, float f) {
            clippingImageView.setAnimationProgress(f);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.h$d */
    class d extends e {
        d(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Float get(PhotoViewer photoViewer) {
            return Float.valueOf(photoViewer.getAnimationValue());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(PhotoViewer photoViewer, float f) {
            photoViewer.setAnimationValue(f);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.h$e */
    public static abstract class e extends Property {
        public e(String str) {
            super(Float.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void set(Object obj, Float f) {
            b(obj, f.floatValue());
        }

        public abstract void b(Object obj, float f);
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.h$f */
    public static abstract class f extends Property {
        public f(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void set(Object obj, Integer num) {
            b(obj, num.intValue());
        }

        public abstract void b(Object obj, int i);
    }
}
