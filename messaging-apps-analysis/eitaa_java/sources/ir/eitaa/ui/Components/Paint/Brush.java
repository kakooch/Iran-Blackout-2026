package ir.eitaa.ui.Components.Paint;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.R;

/* loaded from: classes3.dex */
public interface Brush {
    float getAlpha();

    float getAngle();

    float getScale();

    float getSpacing();

    Bitmap getStamp();

    boolean isLightSaber();

    public static class Radial implements Brush {
        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getAlpha() {
            return 0.85f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getAngle() {
            return 0.0f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getScale() {
            return 1.0f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getSpacing() {
            return 0.15f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public boolean isLightSaber() {
            return false;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public Bitmap getStamp() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeResource(ApplicationLoader.applicationContext.getResources(), R.drawable.paint_radial_brush, options);
        }
    }

    public static class Elliptical implements Brush {
        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getAlpha() {
            return 0.3f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getScale() {
            return 1.5f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getSpacing() {
            return 0.04f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public boolean isLightSaber() {
            return false;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getAngle() {
            return (float) Math.toRadians(125.0d);
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public Bitmap getStamp() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeResource(ApplicationLoader.applicationContext.getResources(), R.drawable.paint_elliptical_brush, options);
        }
    }

    public static class Neon implements Brush {
        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getAlpha() {
            return 0.7f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getAngle() {
            return 0.0f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getScale() {
            return 1.45f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getSpacing() {
            return 0.07f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public boolean isLightSaber() {
            return true;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public Bitmap getStamp() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeResource(ApplicationLoader.applicationContext.getResources(), R.drawable.paint_neon_brush, options);
        }
    }

    public static class Arrow implements Brush {
        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getAlpha() {
            return 0.85f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getAngle() {
            return 0.0f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getScale() {
            return 1.0f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public float getSpacing() {
            return 0.15f;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public boolean isLightSaber() {
            return false;
        }

        @Override // ir.eitaa.ui.Components.Paint.Brush
        public Bitmap getStamp() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            return BitmapFactory.decodeResource(ApplicationLoader.applicationContext.getResources(), R.drawable.paint_radial_brush, options);
        }
    }
}
