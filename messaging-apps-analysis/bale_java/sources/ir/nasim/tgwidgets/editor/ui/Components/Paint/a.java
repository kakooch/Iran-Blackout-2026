package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.FH3;
import ir.nasim.TD5;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class a {
    public static List a = Arrays.asList(new f(), new C1587a(), new c(), new e(), new b(), new d());

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.Paint.a$a, reason: collision with other inner class name */
    public static class C1587a extends a {
        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float c() {
            return 0.25f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public int d() {
            return AbstractC19363qD5.photo_arrow;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float i() {
            return 0.25f;
        }
    }

    public static class b extends a {
        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float a() {
            return 1.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float c() {
            return 1.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public int d() {
            return AbstractC19363qD5.photo_blur;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float f() {
            return 0.35f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public String h(int i) {
            if (i == 0) {
                return "blitWithMaskBlurer";
            }
            if (i == 1) {
                return "compositeWithMaskBlurer";
            }
            if (i != 2) {
                return null;
            }
            return "brush";
        }
    }

    public static class c extends a {
        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float a() {
            return 0.3f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float b() {
            return (float) Math.toRadians(0.0d);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float c() {
            return 0.5f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public int d() {
            return AbstractC19363qD5.photo_marker;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float e() {
            return 0.45f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float f() {
            return 0.4f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float g() {
            return 1.5f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float j() {
            return 0.04f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public int l() {
            return AbstractC23598xB5.paint_elliptical_brush;
        }
    }

    public static class d extends a {
        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float a() {
            return 1.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float c() {
            return 1.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public int d() {
            return AbstractC19363qD5.photo_eraser;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float f() {
            return 0.35f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public String h(int i) {
            if (i == 0) {
                return "blitWithMaskEraser";
            }
            if (i == 1) {
                return "compositeWithMaskEraser";
            }
            if (i != 2) {
                return null;
            }
            return "brush";
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public boolean m() {
            return true;
        }
    }

    public static class e extends a {
        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float a() {
            return 0.7f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float c() {
            return 0.5f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public int d() {
            return AbstractC19363qD5.photo_neon;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float f() {
            return 0.2f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float g() {
            return 1.45f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public String h(int i) {
            if (i == 0) {
                return "blitWithMaskLight";
            }
            if (i == 1) {
                return "compositeWithMaskLight";
            }
            if (i != 2) {
                return null;
            }
            return "brushLight";
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float j() {
            return 0.07f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public int l() {
            return AbstractC23598xB5.paint_neon_brush;
        }
    }

    public static class f extends a {
        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public int d() {
            return AbstractC19363qD5.photo_pen;
        }
    }

    public static abstract class g extends a {
        public static List b = Arrays.asList(new c(), new d(), new e(), new b(), new C1588a());

        /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.Paint.a$g$a, reason: collision with other inner class name */
        public static class C1588a extends g {
            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
            public int d() {
                return AbstractC23598xB5.photo_arrowshape;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int n() {
                return AbstractC23598xB5.photo_arrowshape;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public String o() {
                return FH3.C(TD5.tgwidget_PaintArrow);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int p() {
                return 4;
            }
        }

        public static class b extends g {
            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
            public int d() {
                return AbstractC23598xB5.msg_msgbubble;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int n() {
                return AbstractC23598xB5.msg_msgbubble2;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public String o() {
                return FH3.C(TD5.tgwidget_PaintBubble);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int p() {
                return 3;
            }
        }

        public static class c extends g {
            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
            public int d() {
                return AbstractC23598xB5.photo_circle;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int n() {
                return AbstractC23598xB5.photo_circle_fill;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public String o() {
                return FH3.C(TD5.tgwidget_PaintCircle);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int p() {
                return 0;
            }
        }

        public static class d extends g {
            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
            public int d() {
                return AbstractC23598xB5.photo_rectangle;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int n() {
                return AbstractC23598xB5.photo_rectangle_fill;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public String o() {
                return FH3.C(TD5.tgwidget_PaintRectangle);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int p() {
                return 1;
            }
        }

        public static class e extends g {
            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
            public int d() {
                return AbstractC23598xB5.photo_star;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int n() {
                return AbstractC23598xB5.photo_star_fill;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public String o() {
                return FH3.C(TD5.tgwidget_PaintStar);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a.g
            public int p() {
                return 2;
            }
        }

        public static g q(int i) {
            if (i >= 0 && i <= b.size()) {
                return (g) b.get(i);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Shape type must be in range from 0 to ");
            sb.append(b.size() - 1);
            sb.append(", but got ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public float a() {
            return 1.0f;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.a
        public String h(int i) {
            if (i == 0 || i == 1) {
                return "shape";
            }
            if (i != 2) {
                return null;
            }
            return "brush";
        }

        public abstract int n();

        public abstract String o();

        public abstract int p();
    }

    public float a() {
        return 0.85f;
    }

    public float b() {
        return 0.0f;
    }

    public float c() {
        return 0.25f;
    }

    public abstract int d();

    public float e() {
        return 1.0f;
    }

    public float f() {
        return 0.4f;
    }

    public float g() {
        return 1.0f;
    }

    public String h(int i) {
        if (i == 0) {
            return "blitWithMask";
        }
        if (i == 1) {
            return "compositeWithMask";
        }
        if (i != 2) {
            return null;
        }
        return "brush";
    }

    public float i() {
        return 1.0f;
    }

    public float j() {
        return 0.15f;
    }

    public Bitmap k() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        return BitmapFactory.decodeResource(AbstractC14047hG.a.getResources(), l(), options);
    }

    public int l() {
        return AbstractC23598xB5.paint_radial_brush;
    }

    public boolean m() {
        return false;
    }
}
