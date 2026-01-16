package ir.appp.rghapp;

/* loaded from: classes3.dex */
public class FilterBuilder {
    private float _contrast = 1.0f;
    private float _brightness = 0.0f;
    private float _saturation = 1.0f;
    private float _sharpnessLevel = 1.0f;
    private int _blurAmount = 0;
    private boolean _isBlackAndWhiteEnabled = false;
    private boolean _isTrimEnabled = false;
    private int _trimStart = -1;
    private int _trimEnd = -1;
    private float _outputScaleWidth = -1.0f;
    private float _outputScaleHeight = -1.0f;
    private float _xPosInContainer = 0.0f;
    private float _yPosInContainer = 0.0f;
    private float _rotationAngle = 0.0f;
    private float _originalRotationAngle = 0.0f;
    private OverlayImage _overImage = null;
    private boolean _isImageMedia = false;

    public RGHFilter buildFilter() {
        return new RGHFilter(this._contrast, this._brightness, this._saturation, this._sharpnessLevel, this._isBlackAndWhiteEnabled, this._blurAmount, this._outputScaleWidth, this._outputScaleHeight, this._xPosInContainer, this._yPosInContainer, this._originalRotationAngle, this._rotationAngle, this._isTrimEnabled, this._trimStart, this._trimEnd, this._overImage, this._isImageMedia);
    }

    public FilterBuilder outputScaleSize(float f, float f2) {
        this._outputScaleWidth = f;
        this._outputScaleHeight = f2;
        return this;
    }

    public FilterBuilder videoPosition(float f, float f2) {
        this._xPosInContainer = f;
        this._yPosInContainer = f2;
        return this;
    }

    public FilterBuilder rotationAngle(float f) {
        this._rotationAngle = f;
        return this;
    }

    public FilterBuilder originalRotationAngle(float f) {
        this._originalRotationAngle = f;
        return this;
    }

    public FilterBuilder trim(int i, int i2) {
        this._isTrimEnabled = true;
        this._trimStart = i;
        this._trimEnd = i2;
        return this;
    }

    public FilterBuilder imageMedia(boolean z) {
        this._isImageMedia = z;
        return this;
    }

    public FilterBuilder withOverlayImage(OverlayImage overlayImage) {
        this._overImage = overlayImage;
        return this;
    }

    public static class OverlayImage {
        int imageHeight;
        String imagePath;
        int imageWidth;
        int xPosInContainer;
        int yPosInContainer;

        public OverlayImage(String str, int i, int i2, int i3, int i4) {
            this.imagePath = str;
            this.imageWidth = i;
            this.imageHeight = i2;
            this.xPosInContainer = i3;
            this.yPosInContainer = i4;
        }

        public String toString() {
            return "{ip='" + this.imagePath + "', iw=" + this.imageWidth + ", ih=" + this.imageHeight + ", x=" + this.xPosInContainer + ", y=" + this.yPosInContainer + '}';
        }
    }
}
