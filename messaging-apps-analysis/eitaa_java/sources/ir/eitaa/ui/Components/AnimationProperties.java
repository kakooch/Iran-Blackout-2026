package ir.eitaa.ui.Components;

import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.Property;
import android.view.animation.OvershootInterpolator;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.PhotoViewer;

/* loaded from: classes3.dex */
public class AnimationProperties {
    public static final Property<ColorDrawable, Integer> COLOR_DRAWABLE_ALPHA;
    public static final Property<Paint, Integer> PAINT_ALPHA;
    public static final Property<ShapeDrawable, Integer> SHAPE_DRAWABLE_ALPHA;
    public static OvershootInterpolator overshootInterpolator = new OvershootInterpolator(1.9f);
    public static final Property<ClippingImageView, Float> CLIPPING_IMAGE_VIEW_PROGRESS = new FloatProperty<ClippingImageView>("animationProgress") { // from class: ir.eitaa.ui.Components.AnimationProperties.4
        @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
        public void setValue(ClippingImageView object, float value) {
            object.setAnimationProgress(value);
        }

        @Override // android.util.Property
        public Float get(ClippingImageView object) {
            return Float.valueOf(object.getAnimationProgress());
        }
    };
    public static final Property<PhotoViewer, Float> PHOTO_VIEWER_ANIMATION_VALUE = new FloatProperty<PhotoViewer>("animationValue") { // from class: ir.eitaa.ui.Components.AnimationProperties.5
        @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
        public void setValue(PhotoViewer object, float value) {
            object.setAnimationValue(value);
        }

        @Override // android.util.Property
        public Float get(PhotoViewer object) {
            return Float.valueOf(object.getAnimationValue());
        }
    };
    public static final Property<DialogCell, Float> CLIP_DIALOG_CELL_PROGRESS = new FloatProperty<DialogCell>("clipProgress") { // from class: ir.eitaa.ui.Components.AnimationProperties.6
        @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
        public void setValue(DialogCell object, float value) {
            object.setClipProgress(value);
        }

        @Override // android.util.Property
        public Float get(DialogCell object) {
            return Float.valueOf(object.getClipProgress());
        }
    };

    static {
        String str = "alpha";
        PAINT_ALPHA = new IntProperty<Paint>(str) { // from class: ir.eitaa.ui.Components.AnimationProperties.1
            @Override // ir.eitaa.ui.Components.AnimationProperties.IntProperty
            public void setValue(Paint object, int value) {
                object.setAlpha(value);
            }

            @Override // android.util.Property
            public Integer get(Paint object) {
                return Integer.valueOf(object.getAlpha());
            }
        };
        COLOR_DRAWABLE_ALPHA = new IntProperty<ColorDrawable>(str) { // from class: ir.eitaa.ui.Components.AnimationProperties.2
            @Override // ir.eitaa.ui.Components.AnimationProperties.IntProperty
            public void setValue(ColorDrawable object, int value) {
                object.setAlpha(value);
            }

            @Override // android.util.Property
            public Integer get(ColorDrawable object) {
                return Integer.valueOf(object.getAlpha());
            }
        };
        SHAPE_DRAWABLE_ALPHA = new IntProperty<ShapeDrawable>(str) { // from class: ir.eitaa.ui.Components.AnimationProperties.3
            @Override // ir.eitaa.ui.Components.AnimationProperties.IntProperty
            public void setValue(ShapeDrawable object, int value) {
                object.getPaint().setAlpha(value);
            }

            @Override // android.util.Property
            public Integer get(ShapeDrawable object) {
                return Integer.valueOf(object.getPaint().getAlpha());
            }
        };
    }

    public static abstract class FloatProperty<T> extends Property<T, Float> {
        public abstract void setValue(T object, float value);

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object object, Float value) {
            set2((FloatProperty<T>) object, value);
        }

        public FloatProperty(String name) {
            super(Float.class, name);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public final void set2(T object, Float value) {
            setValue(object, value.floatValue());
        }
    }

    public static abstract class IntProperty<T> extends Property<T, Integer> {
        public abstract void setValue(T object, int value);

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object object, Integer value) {
            set2((IntProperty<T>) object, value);
        }

        public IntProperty(String name) {
            super(Integer.class, name);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public final void set2(T object, Integer value) {
            setValue(object, value.intValue());
        }
    }
}
