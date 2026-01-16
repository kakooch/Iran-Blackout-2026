package com.yarolegovich.discretescrollview.transform;

import android.view.View;

/* loaded from: classes3.dex */
public class Pivot {
    private int axis;
    private int pivotPoint;

    public enum X {
        LEFT { // from class: com.yarolegovich.discretescrollview.transform.Pivot.X.1
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.X
            public Pivot create() {
                return new Pivot(0, 0);
            }
        },
        CENTER { // from class: com.yarolegovich.discretescrollview.transform.Pivot.X.2
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.X
            public Pivot create() {
                return new Pivot(0, -1);
            }
        },
        RIGHT { // from class: com.yarolegovich.discretescrollview.transform.Pivot.X.3
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.X
            public Pivot create() {
                return new Pivot(0, -2);
            }
        };

        public abstract Pivot create();
    }

    public enum Y {
        TOP { // from class: com.yarolegovich.discretescrollview.transform.Pivot.Y.1
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.Y
            public Pivot create() {
                return new Pivot(1, 0);
            }
        },
        CENTER { // from class: com.yarolegovich.discretescrollview.transform.Pivot.Y.2
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.Y
            public Pivot create() {
                return new Pivot(1, -1);
            }
        },
        BOTTOM { // from class: com.yarolegovich.discretescrollview.transform.Pivot.Y.3
            @Override // com.yarolegovich.discretescrollview.transform.Pivot.Y
            public Pivot create() {
                return new Pivot(1, -2);
            }
        };

        public abstract Pivot create();
    }

    public Pivot(int i, int i2) {
        this.axis = i;
        this.pivotPoint = i2;
    }

    public void setOn(View view) {
        int i = this.axis;
        if (i == 0) {
            int i2 = this.pivotPoint;
            if (i2 == -2) {
                view.setPivotX(view.getWidth());
                return;
            } else if (i2 == -1) {
                view.setPivotX(view.getWidth() * 0.5f);
                return;
            } else {
                view.setPivotX(i2);
                return;
            }
        }
        if (i == 1) {
            int i3 = this.pivotPoint;
            if (i3 == -2) {
                view.setPivotY(view.getHeight());
            } else if (i3 == -1) {
                view.setPivotY(view.getHeight() * 0.5f);
            } else {
                view.setPivotY(i3);
            }
        }
    }
}
