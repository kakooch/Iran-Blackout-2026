package ir.appp.rghapp.rubinoPostSlider;

import android.util.Property;
import org.rbmain.ui.Components.AnimationProperties;

/* loaded from: classes3.dex */
public class AnimationProperties {
    public static final Property<PhotoViewerCell, Float> RGH_PHOTO_VIEWER_CELL_ANIMATION_VALUE;

    static {
        String str = "animationValue";
        RGH_PHOTO_VIEWER_CELL_ANIMATION_VALUE = new AnimationProperties.FloatProperty<PhotoViewerCell>(str) { // from class: ir.appp.rghapp.rubinoPostSlider.AnimationProperties.1
            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(PhotoViewerCell photoViewerCell, float f) {
                photoViewerCell.setAnimationValue(f);
            }

            @Override // android.util.Property
            public Float get(PhotoViewerCell photoViewerCell) {
                return Float.valueOf(photoViewerCell.getAnimationValue());
            }
        };
        new AnimationProperties.FloatProperty<AddPostHeaderMediaView>(str) { // from class: ir.appp.rghapp.rubinoPostSlider.AnimationProperties.2
            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(AddPostHeaderMediaView addPostHeaderMediaView, float f) {
                addPostHeaderMediaView.setAnimationValue(f);
            }

            @Override // android.util.Property
            public Float get(AddPostHeaderMediaView addPostHeaderMediaView) {
                return Float.valueOf(addPostHeaderMediaView.getAnimationValue());
            }
        };
    }
}
