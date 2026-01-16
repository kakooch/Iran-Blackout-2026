package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(constraintWidget, map);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    private class WidgetsList {
        private ConstraintWidget biggest;
        private ConstraintAnchor mBottom;
        private int mCount;
        private ConstraintAnchor mLeft;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private int mStartIndex;
        private ConstraintAnchor mTop;
        final /* synthetic */ Flow this$0;

        public void createConstraints(boolean z, int i, boolean z2) {
            ConstraintWidget constraintWidget;
            int i2 = this.mCount;
            for (int i3 = 0; i3 < i2 && this.mStartIndex + i3 < this.this$0.mDisplayedWidgetsCount; i3++) {
                ConstraintWidget constraintWidget2 = this.this$0.mDisplayedWidgets[this.mStartIndex + i3];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i2 == 0 || this.biggest == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i4 = -1;
            int i5 = -1;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = z ? (i2 - 1) - i6 : i6;
                if (this.mStartIndex + i7 >= this.this$0.mDisplayedWidgetsCount) {
                    break;
                }
                if (this.this$0.mDisplayedWidgets[this.mStartIndex + i7].getVisibility() == 0) {
                    if (i4 == -1) {
                        i4 = i6;
                    }
                    i5 = i6;
                }
            }
            ConstraintWidget constraintWidget3 = null;
            if (this.mOrientation == 0) {
                ConstraintWidget constraintWidget4 = this.biggest;
                constraintWidget4.setVerticalChainStyle(this.this$0.mVerticalStyle);
                int i8 = this.mPaddingTop;
                if (i > 0) {
                    i8 += this.this$0.mVerticalGap;
                }
                constraintWidget4.mTop.connect(this.mTop, i8);
                if (z2) {
                    constraintWidget4.mBottom.connect(this.mBottom, this.mPaddingBottom);
                }
                if (i > 0) {
                    this.mTop.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
                }
                if (this.this$0.mVerticalAlign != 3 || constraintWidget4.hasBaseline()) {
                    constraintWidget = constraintWidget4;
                } else {
                    for (int i9 = 0; i9 < i2; i9++) {
                        int i10 = z ? (i2 - 1) - i9 : i9;
                        if (this.mStartIndex + i10 >= this.this$0.mDisplayedWidgetsCount) {
                            break;
                        }
                        constraintWidget = this.this$0.mDisplayedWidgets[this.mStartIndex + i10];
                        if (constraintWidget.hasBaseline()) {
                            break;
                        }
                    }
                    constraintWidget = constraintWidget4;
                }
                int i11 = 0;
                while (i11 < i2) {
                    int i12 = z ? (i2 - 1) - i11 : i11;
                    if (this.mStartIndex + i12 >= this.this$0.mDisplayedWidgetsCount) {
                        return;
                    }
                    ConstraintWidget constraintWidget5 = this.this$0.mDisplayedWidgets[this.mStartIndex + i12];
                    if (i11 == 0) {
                        constraintWidget5.connect(constraintWidget5.mLeft, this.mLeft, this.mPaddingLeft);
                    }
                    if (i12 == 0) {
                        int i13 = this.this$0.mHorizontalStyle;
                        float f = this.this$0.mHorizontalBias;
                        if (this.mStartIndex != 0 || this.this$0.mFirstHorizontalStyle == -1) {
                            if (z2 && this.this$0.mLastHorizontalStyle != -1) {
                                i13 = this.this$0.mLastHorizontalStyle;
                                f = this.this$0.mLastHorizontalBias;
                            }
                        } else {
                            i13 = this.this$0.mFirstHorizontalStyle;
                            f = this.this$0.mFirstHorizontalBias;
                        }
                        constraintWidget5.setHorizontalChainStyle(i13);
                        constraintWidget5.setHorizontalBiasPercent(f);
                    }
                    if (i11 == i2 - 1) {
                        constraintWidget5.connect(constraintWidget5.mRight, this.mRight, this.mPaddingRight);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget5.mLeft.connect(constraintWidget3.mRight, this.this$0.mHorizontalGap);
                        if (i11 == i4) {
                            constraintWidget5.mLeft.setGoneMargin(this.mPaddingLeft);
                        }
                        constraintWidget3.mRight.connect(constraintWidget5.mLeft, 0);
                        if (i11 == i5 + 1) {
                            constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                        }
                    }
                    if (constraintWidget5 != constraintWidget4) {
                        if (this.this$0.mVerticalAlign != 3 || !constraintWidget.hasBaseline() || constraintWidget5 == constraintWidget || !constraintWidget5.hasBaseline()) {
                            int i14 = this.this$0.mVerticalAlign;
                            if (i14 == 0) {
                                constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                            } else if (i14 == 1) {
                                constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                            } else if (z3) {
                                constraintWidget5.mTop.connect(this.mTop, this.mPaddingTop);
                                constraintWidget5.mBottom.connect(this.mBottom, this.mPaddingBottom);
                            } else {
                                constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                            }
                        } else {
                            constraintWidget5.mBaseline.connect(constraintWidget.mBaseline, 0);
                        }
                    }
                    i11++;
                    constraintWidget3 = constraintWidget5;
                }
                return;
            }
            ConstraintWidget constraintWidget6 = this.biggest;
            constraintWidget6.setHorizontalChainStyle(this.this$0.mHorizontalStyle);
            int i15 = this.mPaddingLeft;
            if (i > 0) {
                i15 += this.this$0.mHorizontalGap;
            }
            if (z) {
                constraintWidget6.mRight.connect(this.mRight, i15);
                if (z2) {
                    constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingRight);
                }
                if (i > 0) {
                    this.mRight.mOwner.mLeft.connect(constraintWidget6.mRight, 0);
                }
            } else {
                constraintWidget6.mLeft.connect(this.mLeft, i15);
                if (z2) {
                    constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                }
                if (i > 0) {
                    this.mLeft.mOwner.mRight.connect(constraintWidget6.mLeft, 0);
                }
            }
            int i16 = 0;
            while (i16 < i2 && this.mStartIndex + i16 < this.this$0.mDisplayedWidgetsCount) {
                ConstraintWidget constraintWidget7 = this.this$0.mDisplayedWidgets[this.mStartIndex + i16];
                if (i16 == 0) {
                    constraintWidget7.connect(constraintWidget7.mTop, this.mTop, this.mPaddingTop);
                    int i17 = this.this$0.mVerticalStyle;
                    float f2 = this.this$0.mVerticalBias;
                    if (this.mStartIndex != 0 || this.this$0.mFirstVerticalStyle == -1) {
                        if (z2 && this.this$0.mLastVerticalStyle != -1) {
                            i17 = this.this$0.mLastVerticalStyle;
                            f2 = this.this$0.mLastVerticalBias;
                        }
                    } else {
                        i17 = this.this$0.mFirstVerticalStyle;
                        f2 = this.this$0.mFirstVerticalBias;
                    }
                    constraintWidget7.setVerticalChainStyle(i17);
                    constraintWidget7.setVerticalBiasPercent(f2);
                }
                if (i16 == i2 - 1) {
                    constraintWidget7.connect(constraintWidget7.mBottom, this.mBottom, this.mPaddingBottom);
                }
                if (constraintWidget3 != null) {
                    constraintWidget7.mTop.connect(constraintWidget3.mBottom, this.this$0.mVerticalGap);
                    if (i16 == i4) {
                        constraintWidget7.mTop.setGoneMargin(this.mPaddingTop);
                    }
                    constraintWidget3.mBottom.connect(constraintWidget7.mTop, 0);
                    if (i16 == i5 + 1) {
                        constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                    }
                }
                if (constraintWidget7 != constraintWidget6) {
                    if (z) {
                        int i18 = this.this$0.mHorizontalAlign;
                        if (i18 == 0) {
                            constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                        } else if (i18 == 1) {
                            constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                        } else if (i18 == 2) {
                            constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                            constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                        }
                    } else {
                        int i19 = this.this$0.mHorizontalAlign;
                        if (i19 == 0) {
                            constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                        } else if (i19 == 1) {
                            constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                        } else if (i19 == 2) {
                            if (z3) {
                                constraintWidget7.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                constraintWidget7.mRight.connect(this.mRight, this.mPaddingRight);
                            } else {
                                constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                            }
                        }
                    }
                }
                i16++;
                constraintWidget3 = constraintWidget7;
            }
        }
    }

    private void createAlignedConstraints(boolean z) {
        ConstraintWidget constraintWidget;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i = 0; i < this.mDisplayedWidgetsCount; i++) {
            this.mDisplayedWidgets[i].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i2 = iArr[0];
        int i3 = iArr[1];
        ConstraintWidget constraintWidget2 = null;
        for (int i4 = 0; i4 < i2; i4++) {
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[z ? (i2 - i4) - 1 : i4];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i4 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                }
                if (i4 == i2 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i4 > 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i5];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i5 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i5 == i3 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i5 > 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = (i7 * i2) + i6;
                if (this.mOrientation == 1) {
                    i8 = (i6 * i3) + i7;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i8 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i8]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i6];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i7];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        boolean zIsRtl = getParent() != null ? ((ConstraintWidgetContainer) getParent()).isRtl() : false;
        int i = this.mWrapMode;
        if (i != 0) {
            if (i == 1) {
                int size = this.mChainList.size();
                int i2 = 0;
                while (i2 < size) {
                    this.mChainList.get(i2).createConstraints(zIsRtl, i2, i2 == size + (-1));
                    i2++;
                }
            } else if (i == 2) {
                createAlignedConstraints(zIsRtl);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(zIsRtl, 0, true);
        }
        needsCallbackFromSolver(false);
    }
}
