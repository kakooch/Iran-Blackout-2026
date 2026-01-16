package ir.appp.rghapp;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import ir.appp.rghapp.FilterBuilder;

/* loaded from: classes3.dex */
public class RGHFilter implements Parcelable {
    public static final Parcelable.Creator<RGHFilter> CREATOR;
    public static final int OUTPUT_HEIGHT;
    public static final int OUTPUT_WIDTH;
    private int blurAmount;
    private float brightness;
    private float brightnessNext;
    private float contrast;
    private float contrastNext;
    private FilterType filterType = FilterType.None;
    public int filterUiIndicator;
    private boolean isBlackAndWhiteEnabled;
    private boolean isImageMedia;
    private boolean isTrimEnabled;
    private float originalRotationAngle;
    private float outputScaleHeight;
    private float outputScaleWidth;
    private FilterBuilder.OverlayImage overlayImage;
    public boolean reverseOrder;
    private float rotationAngle;
    private float saturation;
    private float saturationNext;
    private float sharpness;
    private int trimEnd;
    private int trimStart;
    private float xPosInContainer;
    private float yPosInContainer;

    public enum FilterType {
        None,
        BlackAndWhite,
        Greish,
        Happy,
        Dark,
        BuenosAires,
        Tokyo,
        Menegol,
        Cold,
        Pinky,
        Sepia
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        Utils.useNewStoryCreationSystem();
        OUTPUT_WIDTH = 720;
        Utils.useNewStoryCreationSystem();
        OUTPUT_HEIGHT = 1280;
        CREATOR = new Parcelable.Creator<RGHFilter>() { // from class: ir.appp.rghapp.RGHFilter.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RGHFilter createFromParcel(Parcel parcel) {
                return new RGHFilter(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RGHFilter[] newArray(int i) {
                return new RGHFilter[i];
            }
        };
    }

    public RGHFilter(float f, float f2, float f3, float f4, boolean z, int i, float f5, float f6, float f7, float f8, float f9, float f10, boolean z2, int i2, int i3, FilterBuilder.OverlayImage overlayImage, boolean z3) {
        this.contrast = f;
        this.brightness = f2;
        this.saturation = f3;
        this.sharpness = f4;
        this.isBlackAndWhiteEnabled = z;
        this.blurAmount = i;
        this.outputScaleHeight = f6;
        this.outputScaleWidth = f5;
        this.xPosInContainer = f7;
        this.yPosInContainer = f8;
        this.rotationAngle = f10;
        this.originalRotationAngle = f9;
        this.isTrimEnabled = z2;
        this.trimStart = i2;
        this.trimEnd = i3;
        this.overlayImage = overlayImage;
        this.isImageMedia = z3;
    }

    public void setFilterType(FilterType filterType, boolean z) {
        this.filterType = filterType;
        this.reverseOrder = z;
        if (filterType == FilterType.None) {
            if (!z) {
                this.contrastNext = 1.0f;
                this.contrast = 1.0f;
                this.brightnessNext = 0.0f;
                this.brightness = 0.0f;
                this.saturationNext = 1.0f;
                this.saturation = 1.0f;
                this.sharpness = 1.0f;
                return;
            }
            this.contrast = 1.0f;
            this.brightness = 0.0f;
            this.saturation = 1.0f;
            this.sharpness = 1.0f;
            this.contrastNext = 1.4f;
            this.brightnessNext = -100.0f;
            this.saturationNext = 1.1f;
            return;
        }
        if (filterType == FilterType.BlackAndWhite) {
            this.isBlackAndWhiteEnabled = true;
            this.contrastNext = 1.0f;
            this.brightnessNext = 0.0f;
            this.saturationNext = 1.0f;
            return;
        }
        if (filterType == FilterType.Cold) {
            this.contrast = 1.0f;
            this.brightness = 0.0f;
            this.saturation = 0.4f;
            this.sharpness = 1.0f;
            this.contrastNext = 1.0f;
            this.brightnessNext = 0.0f;
            this.saturationNext = 1.0f;
            return;
        }
        if (filterType == FilterType.Happy) {
            this.contrast = 1.0f;
            this.brightness = 44.0f;
            this.saturation = 1.4f;
            this.sharpness = 1.0f;
            if (!z) {
                this.contrastNext = 1.4f;
                this.brightnessNext = -100.0f;
                this.saturationNext = 1.1f;
                return;
            } else {
                this.contrastNext = 1.0f;
                this.brightnessNext = 0.0f;
                this.saturationNext = 1.0f;
                return;
            }
        }
        if (filterType == FilterType.Dark) {
            this.contrast = 1.4f;
            this.brightness = -100.0f;
            this.saturation = 1.1f;
            this.sharpness = 1.0f;
            if (!z) {
                this.contrastNext = 1.0f;
                this.brightnessNext = 0.0f;
                this.saturationNext = 1.0f;
                return;
            } else {
                this.contrastNext = 1.0f;
                this.brightnessNext = 44.0f;
                this.saturationNext = 1.4f;
                return;
            }
        }
        if (filterType == FilterType.Greish) {
            this.contrast = 1.0f;
            this.brightness = 0.0f;
            this.saturation = 1.0f;
            if (!z) {
                this.contrastNext = 1.0f;
                this.brightnessNext = 44.0f;
                this.saturationNext = 1.4f;
                return;
            } else {
                this.isBlackAndWhiteEnabled = true;
                this.contrastNext = 1.0f;
                this.brightnessNext = 0.0f;
                this.saturationNext = 1.0f;
                return;
            }
        }
        if ((filterType == FilterType.Pinky && z) || (filterType == FilterType.Menegol && !z)) {
            this.contrastNext = 1.0f;
            this.brightnessNext = 0.0f;
            this.saturationNext = 0.4f;
        } else if (filterType == FilterType.BuenosAires && z) {
            this.contrastNext = 1.4f;
            this.brightnessNext = -100.0f;
            this.saturationNext = 1.1f;
        } else {
            if (filterType != FilterType.Sepia || z) {
                return;
            }
            this.contrastNext = 1.0f;
            this.brightnessNext = 0.0f;
            this.saturationNext = 1.0f;
        }
    }

    protected RGHFilter(Parcel parcel) {
        this.contrast = parcel.readFloat();
        this.brightness = parcel.readFloat();
        this.saturation = parcel.readFloat();
        this.sharpness = parcel.readFloat();
        this.rotationAngle = parcel.readFloat();
        this.originalRotationAngle = parcel.readFloat();
        this.isBlackAndWhiteEnabled = parcel.readByte() != 0;
        this.isTrimEnabled = parcel.readByte() != 0;
        this.isImageMedia = parcel.readByte() != 0;
        this.trimStart = parcel.readInt();
        this.trimEnd = parcel.readInt();
        this.blurAmount = parcel.readInt();
        this.outputScaleWidth = parcel.readFloat();
        this.outputScaleHeight = parcel.readFloat();
        this.xPosInContainer = parcel.readFloat();
        this.yPosInContainer = parcel.readFloat();
    }

    public float getContrast() {
        return this.contrast;
    }

    public float getBrightness() {
        return this.brightness;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public boolean isTrimEnabled() {
        return this.isTrimEnabled;
    }

    public boolean isImageMedia() {
        return this.isImageMedia;
    }

    public int getTrimStart() {
        return this.trimStart;
    }

    public int getTrimEnd() {
        return this.trimEnd;
    }

    public float getOutputScaleWidth() {
        return this.outputScaleWidth;
    }

    public float getOutputScaleHeight() {
        return this.outputScaleHeight;
    }

    public float getxPosInContainer() {
        return this.xPosInContainer;
    }

    public float getyPosInContainer() {
        return this.yPosInContainer;
    }

    public float getRotationAngle() {
        return this.rotationAngle;
    }

    public FilterType getFilterType() {
        return this.filterType;
    }

    public float getBrightnessNext() {
        return this.brightnessNext;
    }

    public float getContrastNext() {
        return this.contrastNext;
    }

    public float getSaturationNext() {
        return this.saturationNext;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.contrast);
        parcel.writeFloat(this.brightness);
        parcel.writeFloat(this.saturation);
        parcel.writeFloat(this.sharpness);
        parcel.writeFloat(this.rotationAngle);
        parcel.writeFloat(this.originalRotationAngle);
        parcel.writeByte(this.isBlackAndWhiteEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isTrimEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isImageMedia ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.trimStart);
        parcel.writeInt(this.trimEnd);
        parcel.writeInt(this.blurAmount);
        parcel.writeFloat(this.outputScaleWidth);
        parcel.writeFloat(this.outputScaleHeight);
        parcel.writeFloat(this.xPosInContainer);
        parcel.writeFloat(this.yPosInContainer);
    }

    @Keep
    public String filterDetail() {
        String str = "{ft=" + this.filterType + ",c=" + this.contrast + ",b=" + this.brightness + ",s=" + this.saturation + ",sh=" + this.sharpness + ",isB/W=" + this.isBlackAndWhiteEnabled + ",isTE=" + this.isTrimEnabled + ",isIMG=" + this.isImageMedia + ",ts=" + this.trimStart + ",te=" + this.trimEnd + ",ba=" + this.blurAmount + ",osw=" + this.outputScaleWidth + ",osh=" + this.outputScaleHeight + ",x=" + this.xPosInContainer + ",y=" + this.yPosInContainer + ",ra=" + this.rotationAngle + ",ora=" + this.originalRotationAngle;
        if (this.overlayImage != null) {
            str = str + ",oi=" + this.overlayImage.toString();
        }
        return str + "}";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RGHFilter m288clone() {
        return new RGHFilter(this.contrast, this.brightness, this.saturation, this.sharpness, this.isBlackAndWhiteEnabled, this.blurAmount, this.outputScaleWidth, this.outputScaleHeight, this.xPosInContainer, this.yPosInContainer, this.originalRotationAngle, this.rotationAngle, this.isTrimEnabled, this.trimStart, this.trimEnd, null, this.isImageMedia);
    }
}
