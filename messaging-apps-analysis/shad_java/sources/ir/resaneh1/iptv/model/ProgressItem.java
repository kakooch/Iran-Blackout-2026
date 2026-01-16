package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ProgressItem extends PresenterItem {
    public boolean hasError;
    private int progress;
    private String unit;
    public float uploadedByte = 0.0f;
    public float totalSize = 0.0f;

    public ProgressItem(int i) {
        this.progress = i;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.ProgressItem;
    }

    public int getProgress() {
        int i = this.progress;
        if (i < 0) {
            return 0;
        }
        if (i > 100) {
            return 100;
        }
        return i;
    }

    private String getUnitString() {
        float f = this.totalSize;
        if (f > 1.0737418E9f) {
            this.unit = "گیگابایت";
        } else if (f > 1048576.0f) {
            this.unit = "مگابایت";
        } else if (f > 1024.0f) {
            this.unit = "کیلوبایت";
        } else {
            this.unit = "بایت";
        }
        return this.unit;
    }

    public String getProgressString() {
        float f = this.totalSize;
        float f2 = this.uploadedByte;
        float f3 = 1.0737418E9f;
        if (f > 1.0737418E9f) {
            this.unit = "گیگابایت";
        } else {
            f3 = 1048576.0f;
            if (f > 1048576.0f) {
                this.unit = "مگابایت";
            } else {
                f3 = 1024.0f;
                if (f > 1024.0f) {
                    this.unit = "کیلوبایت";
                } else {
                    this.unit = "بایت";
                    return NumberUtils.toPersian(String.format("%.02f", Float.valueOf(f2)) + " از " + String.format("%.02f", Float.valueOf(f)) + " " + this.unit);
                }
            }
        }
        f /= f3;
        f2 /= f3;
        return NumberUtils.toPersian(String.format("%.02f", Float.valueOf(f2)) + " از " + String.format("%.02f", Float.valueOf(f)) + " " + this.unit);
    }

    public void setProgress(float f, float f2) {
        if (f2 == 0.0f) {
            this.progress = 0;
        } else {
            if (f == f2) {
                this.progress = 100;
                return;
            }
            this.uploadedByte = f;
            this.totalSize = f2;
            this.progress = (int) ((f * 100.0f) / f2);
        }
    }
}
