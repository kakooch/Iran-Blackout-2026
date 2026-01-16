package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
class CamColor {
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    float getHue() {
        return this.mHue;
    }

    float getChroma() {
        return this.mChroma;
    }

    float getJ() {
        return this.mJ;
    }

    float getJStar() {
        return this.mJstar;
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    CamColor(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.mHue = f;
        this.mChroma = f2;
        this.mJ = f3;
        this.mQ = f4;
        this.mM = f5;
        this.mS = f6;
        this.mJstar = f7;
        this.mAstar = f8;
        this.mBstar = f9;
    }

    static int toColor(float f, float f2, float f3) {
        return toColor(f, f2, f3, ViewingConditions.DEFAULT);
    }

    static CamColor fromColor(int i) {
        return fromColorInViewingConditions(i, ViewingConditions.DEFAULT);
    }

    static CamColor fromColorInViewingConditions(int i, ViewingConditions viewingConditions) {
        float[] fArrXyzFromInt = CamUtils.xyzFromInt(i);
        float[][] fArr = CamUtils.XYZ_TO_CAM16RGB;
        float f = (fArrXyzFromInt[0] * fArr[0][0]) + (fArrXyzFromInt[1] * fArr[0][1]) + (fArrXyzFromInt[2] * fArr[0][2]);
        float f2 = (fArrXyzFromInt[0] * fArr[1][0]) + (fArrXyzFromInt[1] * fArr[1][1]) + (fArrXyzFromInt[2] * fArr[1][2]);
        float f3 = (fArrXyzFromInt[0] * fArr[2][0]) + (fArrXyzFromInt[1] * fArr[2][1]) + (fArrXyzFromInt[2] * fArr[2][2]);
        float f4 = viewingConditions.getRgbD()[0] * f;
        float f5 = viewingConditions.getRgbD()[1] * f2;
        float f6 = viewingConditions.getRgbD()[2] * f3;
        double fl = viewingConditions.getFl() * Math.abs(f4);
        Double.isNaN(fl);
        float fPow = (float) Math.pow(fl / 100.0d, 0.42d);
        double fl2 = viewingConditions.getFl() * Math.abs(f5);
        Double.isNaN(fl2);
        float fPow2 = (float) Math.pow(fl2 / 100.0d, 0.42d);
        double fl3 = viewingConditions.getFl() * Math.abs(f6);
        Double.isNaN(fl3);
        float fPow3 = (float) Math.pow(fl3 / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f4) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f5) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f6) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum;
        Double.isNaN(d);
        double d2 = fSignum2;
        Double.isNaN(d2);
        double d3 = (d * 11.0d) + (d2 * (-12.0d));
        double d4 = fSignum3;
        Double.isNaN(d4);
        double d5 = fSignum + fSignum2;
        Double.isNaN(d4);
        Double.isNaN(d5);
        float f7 = ((float) (d5 - (d4 * 2.0d))) / 9.0f;
        float f8 = fSignum2 * 20.0f;
        float f9 = (((fSignum * 20.0f) + f8) + (21.0f * fSignum3)) / 20.0f;
        float f10 = (((fSignum * 40.0f) + f8) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f7, ((float) (d3 + d4)) / 11.0f)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f11 = fAtan2;
        float f12 = (3.1415927f * f11) / 180.0f;
        float fPow4 = ((float) Math.pow((f10 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float flRoot = viewingConditions.getFlRoot() * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (viewingConditions.getAw() + 4.0f);
        Double.isNaN(((double) f11) < 20.14d ? 360.0f + f11 : f11);
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((r9 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((r3 * r3) + (f7 * f7)))) / (f9 + 0.305f), 0.9d));
        double d6 = fPow4;
        Double.isNaN(d6);
        float fSqrt = fPow5 * ((float) Math.sqrt(d6 / 100.0d));
        float flRoot2 = fSqrt * viewingConditions.getFlRoot();
        float fSqrt2 = ((float) Math.sqrt((fPow5 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f13 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * flRoot2) + 1.0f)) * 43.85965f;
        double d7 = f12;
        return new CamColor(f11, fSqrt, fPow4, flRoot, flRoot2, fSqrt2, f13, fLog * ((float) Math.cos(d7)), fLog * ((float) Math.sin(d7)));
    }

    private static CamColor fromJch(float f, float f2, float f3) {
        return fromJchInFrame(f, f2, f3, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float f, float f2, float f3, ViewingConditions viewingConditions) {
        float c = 4.0f / viewingConditions.getC();
        double d = f;
        Double.isNaN(d);
        float fSqrt = c * ((float) Math.sqrt(d / 100.0d)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float flRoot = f2 * viewingConditions.getFlRoot();
        float fSqrt2 = ((float) Math.sqrt(((f2 / ((float) Math.sqrt(r4))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f4 = (1.7f * f) / ((0.007f * f) + 1.0f);
        double d2 = flRoot;
        Double.isNaN(d2);
        float fLog = ((float) Math.log((d2 * 0.0228d) + 1.0d)) * 43.85965f;
        double d3 = (3.1415927f * f3) / 180.0f;
        return new CamColor(f3, f2, f, fSqrt, flRoot, fSqrt2, f4, fLog * ((float) Math.cos(d3)), fLog * ((float) Math.sin(d3)));
    }

    float distance(CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((jStar * jStar) + (aStar * aStar) + (bStar * bStar)), 0.63d) * 1.41d);
    }

    int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    int viewed(ViewingConditions viewingConditions) {
        float fSqrt;
        if (getChroma() == 0.0d || getJ() == 0.0d) {
            fSqrt = 0.0f;
        } else {
            float chroma = getChroma();
            double j = getJ();
            Double.isNaN(j);
            fSqrt = chroma / ((float) Math.sqrt(j / 100.0d));
        }
        double d = fSqrt;
        double dPow = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d);
        Double.isNaN(d);
        float fPow = (float) Math.pow(d / dPow, 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        Double.isNaN(hue);
        float fCos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw();
        double j2 = getJ();
        Double.isNaN(j2);
        double c = viewingConditions.getC();
        Double.isNaN(c);
        double d2 = 1.0d / c;
        double z = viewingConditions.getZ();
        Double.isNaN(z);
        float fPow2 = aw * ((float) Math.pow(j2 / 100.0d, d2 / z));
        float nc = fCos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = fPow2 / viewingConditions.getNbb();
        float fSin = (float) Math.sin(hue);
        float fCos2 = (float) Math.cos(hue);
        float f = (((0.305f + nbb) * 23.0f) * fPow) / (((nc * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f2 = fCos2 * f;
        float f3 = f * fSin;
        float f4 = nbb * 460.0f;
        float f5 = (((451.0f * f2) + f4) + (288.0f * f3)) / 1403.0f;
        float f6 = ((f4 - (891.0f * f2)) - (261.0f * f3)) / 1403.0f;
        float f7 = ((f4 - (f2 * 220.0f)) - (f3 * 6300.0f)) / 1403.0f;
        Double.isNaN(Math.abs(f5));
        Double.isNaN(Math.abs(f5));
        float fSignum = Math.signum(f5) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (r7 * 27.13d) / (400.0d - r11)), 2.380952380952381d));
        Double.isNaN(Math.abs(f6));
        Double.isNaN(Math.abs(f6));
        float fSignum2 = Math.signum(f6) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (r11 * 27.13d) / (400.0d - r9)), 2.380952380952381d));
        Double.isNaN(Math.abs(f7));
        Double.isNaN(Math.abs(f7));
        float fSignum3 = Math.signum(f7) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max(0.0d, (r9 * 27.13d) / (400.0d - r11)), 2.380952380952381d));
        float f8 = fSignum / viewingConditions.getRgbD()[0];
        float f9 = fSignum2 / viewingConditions.getRgbD()[1];
        float f10 = fSignum3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        return ColorUtils.XYZToColor((fArr[0][0] * f8) + (fArr[0][1] * f9) + (fArr[0][2] * f10), (fArr[1][0] * f8) + (fArr[1][1] * f9) + (fArr[1][2] * f10), (f8 * fArr[2][0]) + (f9 * fArr[2][1]) + (f10 * fArr[2][2]));
    }

    static int toColor(float f, float f2, float f3, ViewingConditions viewingConditions) {
        if (f2 < 1.0d || Math.round(f3) <= 0.0d || Math.round(f3) >= 100.0d) {
            return CamUtils.intFromLStar(f3);
        }
        float fMin = f < 0.0f ? 0.0f : Math.min(360.0f, f);
        float f4 = f2;
        CamColor camColor = null;
        float f5 = 0.0f;
        boolean z = true;
        while (Math.abs(f5 - f2) >= 0.4f) {
            CamColor camColorFindCamByJ = findCamByJ(fMin, f4, f3);
            if (z) {
                if (camColorFindCamByJ != null) {
                    return camColorFindCamByJ.viewed(viewingConditions);
                }
                z = false;
            } else if (camColorFindCamByJ == null) {
                f2 = f4;
            } else {
                f5 = f4;
                camColor = camColorFindCamByJ;
            }
            f4 = ((f2 - f5) / 2.0f) + f5;
        }
        if (camColor == null) {
            return CamUtils.intFromLStar(f3);
        }
        return camColor.viewed(viewingConditions);
    }

    private static CamColor findCamByJ(float f, float f2, float f3) {
        float f4 = 1000.0f;
        CamColor camColor = null;
        float f5 = 1000.0f;
        float f6 = 100.0f;
        float f7 = 0.0f;
        while (Math.abs(f7 - f6) > 0.01f) {
            float f8 = ((f6 - f7) / 2.0f) + f7;
            int iViewedInSrgb = fromJch(f8, f2, f).viewedInSrgb();
            float fLStarFromInt = CamUtils.lStarFromInt(iViewedInSrgb);
            float fAbs = Math.abs(f3 - fLStarFromInt);
            if (fAbs < 0.2f) {
                CamColor camColorFromColor = fromColor(iViewedInSrgb);
                float fDistance = camColorFromColor.distance(fromJch(camColorFromColor.getJ(), camColorFromColor.getChroma(), f));
                if (fDistance <= 1.0f) {
                    camColor = camColorFromColor;
                    f4 = fAbs;
                    f5 = fDistance;
                }
            }
            if (f4 == 0.0f && f5 == 0.0f) {
                break;
            }
            if (fLStarFromInt < f3) {
                f7 = f8;
            } else {
                f6 = f8;
            }
        }
        return camColor;
    }
}
