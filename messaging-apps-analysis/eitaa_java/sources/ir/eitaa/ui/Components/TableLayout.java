package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.tgnet.TLRPC$TL_pageTableCell;
import ir.eitaa.ui.ArticleViewer;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import j$.lang.Iterable;
import j$.time.a;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.S1;
import j$.util.stream.Stream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class TableLayout extends View {
    public static final Alignment BASELINE;
    public static final Alignment BOTTOM;
    public static final Alignment CENTER;
    public static final Alignment END;
    public static final Alignment FILL;
    private static final Alignment LEADING;
    public static final Alignment LEFT;
    public static final Alignment RIGHT;
    public static final Alignment START;
    public static final Alignment TOP;
    private static final Alignment TRAILING;
    static final Alignment UNDEFINED_ALIGNMENT = new Alignment() { // from class: ir.eitaa.ui.Components.TableLayout.1
        @Override // ir.eitaa.ui.Components.TableLayout.Alignment
        public int getAlignmentValue(Child view, int viewSize) {
            return Integer.MIN_VALUE;
        }

        @Override // ir.eitaa.ui.Components.TableLayout.Alignment
        int getGravityOffset(Child view, int cellDelta) {
            return Integer.MIN_VALUE;
        }
    };
    private Path backgroundPath;
    private ArrayList<Child> cellsToFixHeight;
    private ArrayList<Child> childrens;
    private int colCount;
    private TableLayoutDelegate delegate;
    private boolean drawLines;
    private boolean isRtl;
    private boolean isStriped;
    private int itemPaddingLeft;
    private int itemPaddingTop;
    private Path linePath;
    private int mAlignmentMode;
    private int mDefaultGap;
    private final Axis mHorizontalAxis;
    private int mLastLayoutParamsHashCode;
    private int mOrientation;
    private boolean mUseDefaultMargins;
    private final Axis mVerticalAxis;
    private float[] radii;
    private RectF rect;
    private ArrayList<Point> rowSpans;
    private TextSelectionHelper.ArticleTextSelectionHelper textSelectionHelper;

    public interface TableLayoutDelegate {
        ArticleViewer.DrawingText createTextLayout(TLRPC$TL_pageTableCell cell, int maxWidth);

        Paint getHeaderPaint();

        Paint getLinePaint();

        Paint getStripPaint();

        void onLayoutChild(ArticleViewer.DrawingText text, int x, int y);
    }

    static boolean canStretch(int flexibility) {
        return (flexibility & 2) != 0;
    }

    public class Child {
        private TLRPC$TL_pageTableCell cell;
        private int fixedHeight;
        private int index;
        private LayoutParams layoutParams;
        private int measuredHeight;
        private int measuredWidth;
        public int rowspan;
        private int selectionIndex = -1;
        public int textHeight;
        public ArticleViewer.DrawingText textLayout;
        public int textLeft;
        public int textWidth;
        public int textX;
        public int textY;
        public int x;
        public int y;

        static /* synthetic */ int access$1520(Child child, int i) {
            int i2 = child.measuredHeight - i;
            child.measuredHeight = i2;
            return i2;
        }

        public Child(int i) {
            this.index = i;
        }

        public LayoutParams getLayoutParams() {
            return this.layoutParams;
        }

        public int getMeasuredWidth() {
            return this.measuredWidth;
        }

        public int getMeasuredHeight() {
            return this.measuredHeight;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void measure(int r2, int r3, boolean r4) {
            /*
                r1 = this;
                r1.measuredWidth = r2
                r1.measuredHeight = r3
                if (r4 == 0) goto L8
                r1.fixedHeight = r3
            L8:
                ir.eitaa.tgnet.TLRPC$TL_pageTableCell r2 = r1.cell
                if (r2 == 0) goto Lb4
                boolean r0 = r2.valign_middle
                if (r0 == 0) goto L18
                int r2 = r1.textHeight
                int r3 = r3 - r2
                int r3 = r3 / 2
                r1.textY = r3
                goto L31
            L18:
                boolean r2 = r2.valign_bottom
                if (r2 == 0) goto L29
                int r2 = r1.textHeight
                int r3 = r3 - r2
                ir.eitaa.ui.Components.TableLayout r2 = ir.eitaa.ui.Components.TableLayout.this
                int r2 = ir.eitaa.ui.Components.TableLayout.access$100(r2)
                int r3 = r3 - r2
                r1.textY = r3
                goto L31
            L29:
                ir.eitaa.ui.Components.TableLayout r2 = ir.eitaa.ui.Components.TableLayout.this
                int r2 = ir.eitaa.ui.Components.TableLayout.access$100(r2)
                r1.textY = r2
            L31:
                ir.eitaa.ui.ArticleViewer$DrawingText r2 = r1.textLayout
                if (r2 == 0) goto Lb4
                int r2 = r2.getLineCount()
                if (r4 != 0) goto L71
                r3 = 1
                if (r2 > r3) goto L4a
                if (r2 <= 0) goto L71
                ir.eitaa.tgnet.TLRPC$TL_pageTableCell r2 = r1.cell
                boolean r3 = r2.align_center
                if (r3 != 0) goto L4a
                boolean r2 = r2.align_right
                if (r2 == 0) goto L71
            L4a:
                ir.eitaa.ui.Components.TableLayout r2 = ir.eitaa.ui.Components.TableLayout.this
                ir.eitaa.ui.Components.TableLayout$TableLayoutDelegate r2 = ir.eitaa.ui.Components.TableLayout.access$300(r2)
                ir.eitaa.tgnet.TLRPC$TL_pageTableCell r3 = r1.cell
                int r4 = r1.measuredWidth
                ir.eitaa.ui.Components.TableLayout r0 = ir.eitaa.ui.Components.TableLayout.this
                int r0 = ir.eitaa.ui.Components.TableLayout.access$200(r0)
                int r0 = r0 * 2
                int r4 = r4 - r0
                ir.eitaa.ui.ArticleViewer$DrawingText r2 = r2.createTextLayout(r3, r4)
                r1.setTextLayout(r2)
                int r2 = r1.textHeight
                ir.eitaa.ui.Components.TableLayout r3 = ir.eitaa.ui.Components.TableLayout.this
                int r3 = ir.eitaa.ui.Components.TableLayout.access$100(r3)
                int r3 = r3 * 2
                int r2 = r2 + r3
                r1.fixedHeight = r2
            L71:
                int r2 = r1.textLeft
                if (r2 == 0) goto Lac
                int r2 = -r2
                r1.textX = r2
                ir.eitaa.tgnet.TLRPC$TL_pageTableCell r3 = r1.cell
                boolean r4 = r3.align_right
                if (r4 == 0) goto L8e
                int r3 = r1.measuredWidth
                int r4 = r1.textWidth
                int r3 = r3 - r4
                ir.eitaa.ui.Components.TableLayout r4 = ir.eitaa.ui.Components.TableLayout.this
                int r4 = ir.eitaa.ui.Components.TableLayout.access$200(r4)
                int r3 = r3 - r4
                int r2 = r2 + r3
                r1.textX = r2
                goto Lb4
            L8e:
                boolean r3 = r3.align_center
                if (r3 == 0) goto La2
                int r3 = r1.measuredWidth
                int r4 = r1.textWidth
                int r3 = r3 - r4
                int r3 = r3 / 2
                float r3 = (float) r3
                int r3 = java.lang.Math.round(r3)
                int r2 = r2 + r3
                r1.textX = r2
                goto Lb4
            La2:
                ir.eitaa.ui.Components.TableLayout r3 = ir.eitaa.ui.Components.TableLayout.this
                int r3 = ir.eitaa.ui.Components.TableLayout.access$200(r3)
                int r2 = r2 + r3
                r1.textX = r2
                goto Lb4
            Lac:
                ir.eitaa.ui.Components.TableLayout r2 = ir.eitaa.ui.Components.TableLayout.this
                int r2 = ir.eitaa.ui.Components.TableLayout.access$200(r2)
                r1.textX = r2
            Lb4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.TableLayout.Child.measure(int, int, boolean):void");
        }

        public void setTextLayout(ArticleViewer.DrawingText layout) {
            this.textLayout = layout;
            int i = 0;
            if (layout != null) {
                this.textWidth = 0;
                this.textLeft = 0;
                int lineCount = layout.getLineCount();
                while (i < lineCount) {
                    float lineLeft = layout.getLineLeft(i);
                    this.textLeft = i == 0 ? (int) Math.ceil(lineLeft) : Math.min(this.textLeft, (int) Math.ceil(lineLeft));
                    this.textWidth = (int) Math.ceil(Math.max(layout.getLineWidth(i), this.textWidth));
                    i++;
                }
                this.textHeight = layout.getHeight();
                return;
            }
            this.textLeft = 0;
            this.textWidth = 0;
            this.textHeight = 0;
        }

        public void layout(int left, int top, int right, int bottom) {
            this.x = left;
            this.y = top;
        }

        public int getTextX() {
            return this.x + this.textX;
        }

        public int getTextY() {
            return this.y + this.textY;
        }

        public void setFixedHeight(int value) {
            int i = this.fixedHeight;
            this.measuredHeight = i;
            TLRPC$TL_pageTableCell tLRPC$TL_pageTableCell = this.cell;
            if (tLRPC$TL_pageTableCell.valign_middle) {
                this.textY = (i - this.textHeight) / 2;
            } else if (tLRPC$TL_pageTableCell.valign_bottom) {
                this.textY = (i - this.textHeight) - TableLayout.this.itemPaddingTop;
            }
        }

        public void draw(Canvas canvas) {
            float f;
            float f2;
            int i;
            if (this.cell == null) {
                return;
            }
            boolean z = false;
            boolean z2 = true;
            boolean z3 = this.x + this.measuredWidth == TableLayout.this.getMeasuredWidth();
            boolean z4 = this.y + this.measuredHeight == TableLayout.this.getMeasuredHeight();
            int iDp = AndroidUtilities.dp(3.0f);
            if (this.cell.header || (TableLayout.this.isStriped && this.layoutParams.rowSpec.span.min % 2 == 0)) {
                if (this.x != 0 || this.y != 0) {
                    float[] fArr = TableLayout.this.radii;
                    TableLayout.this.radii[1] = 0.0f;
                    fArr[0] = 0.0f;
                } else {
                    float[] fArr2 = TableLayout.this.radii;
                    float f3 = iDp;
                    TableLayout.this.radii[1] = f3;
                    fArr2[0] = f3;
                    z = true;
                }
                if (!z3 || this.y != 0) {
                    float[] fArr3 = TableLayout.this.radii;
                    TableLayout.this.radii[3] = 0.0f;
                    fArr3[2] = 0.0f;
                } else {
                    float[] fArr4 = TableLayout.this.radii;
                    float f4 = iDp;
                    TableLayout.this.radii[3] = f4;
                    fArr4[2] = f4;
                    z = true;
                }
                if (!z3 || !z4) {
                    float[] fArr5 = TableLayout.this.radii;
                    TableLayout.this.radii[5] = 0.0f;
                    fArr5[4] = 0.0f;
                } else {
                    float[] fArr6 = TableLayout.this.radii;
                    float f5 = iDp;
                    TableLayout.this.radii[5] = f5;
                    fArr6[4] = f5;
                    z = true;
                }
                if (this.x != 0 || !z4) {
                    float[] fArr7 = TableLayout.this.radii;
                    TableLayout.this.radii[7] = 0.0f;
                    fArr7[6] = 0.0f;
                    z2 = z;
                } else {
                    float[] fArr8 = TableLayout.this.radii;
                    float f6 = iDp;
                    TableLayout.this.radii[7] = f6;
                    fArr8[6] = f6;
                }
                if (z2) {
                    TableLayout.this.rect.set(this.x, this.y, r3 + this.measuredWidth, r7 + this.measuredHeight);
                    TableLayout.this.backgroundPath.reset();
                    TableLayout.this.backgroundPath.addRoundRect(TableLayout.this.rect, TableLayout.this.radii, Path.Direction.CW);
                    if (this.cell.header) {
                        canvas.drawPath(TableLayout.this.backgroundPath, TableLayout.this.delegate.getHeaderPaint());
                    } else {
                        canvas.drawPath(TableLayout.this.backgroundPath, TableLayout.this.delegate.getStripPaint());
                    }
                } else if (this.cell.header) {
                    canvas.drawRect(this.x, this.y, r2 + this.measuredWidth, r3 + this.measuredHeight, TableLayout.this.delegate.getHeaderPaint());
                } else {
                    canvas.drawRect(this.x, this.y, r2 + this.measuredWidth, r3 + this.measuredHeight, TableLayout.this.delegate.getStripPaint());
                }
            }
            if (this.textLayout != null) {
                canvas.save();
                canvas.translate(getTextX(), getTextY());
                if (this.selectionIndex >= 0) {
                    TableLayout.this.textSelectionHelper.draw(canvas, (TextSelectionHelper.ArticleSelectableView) TableLayout.this.getParent().getParent(), this.selectionIndex);
                }
                this.textLayout.draw(canvas);
                canvas.restore();
            }
            if (TableLayout.this.drawLines) {
                Paint linePaint = TableLayout.this.delegate.getLinePaint();
                Paint linePaint2 = TableLayout.this.delegate.getLinePaint();
                float strokeWidth = linePaint.getStrokeWidth() / 2.0f;
                float strokeWidth2 = linePaint2.getStrokeWidth() / 2.0f;
                int i2 = this.x;
                if (i2 == 0) {
                    int i3 = this.y;
                    float f7 = i3;
                    float f8 = this.measuredHeight + i3;
                    if (i3 == 0) {
                        f7 += iDp;
                    }
                    float f9 = f7;
                    if (f8 == TableLayout.this.getMeasuredHeight()) {
                        f8 -= iDp;
                    }
                    int i4 = this.x;
                    canvas.drawLine(i4 + strokeWidth, f9, i4 + strokeWidth, f8, linePaint);
                } else {
                    canvas.drawLine(i2 - strokeWidth2, this.y, i2 - strokeWidth2, r9 + this.measuredHeight, linePaint2);
                }
                int i5 = this.y;
                if (i5 == 0) {
                    int i6 = this.x;
                    float f10 = i6;
                    float f11 = this.measuredWidth + i6;
                    if (i6 == 0) {
                        f10 += iDp;
                    }
                    float f12 = f10;
                    if (f11 == TableLayout.this.getMeasuredWidth()) {
                        f11 -= iDp;
                    }
                    int i7 = this.y;
                    canvas.drawLine(f12, i7 + strokeWidth, f11, i7 + strokeWidth, linePaint);
                } else {
                    canvas.drawLine(this.x, i5 - strokeWidth2, r8 + this.measuredWidth, i5 - strokeWidth2, linePaint2);
                }
                float f13 = (z3 && (i = this.y) == 0) ? i + iDp : this.y - strokeWidth;
                if (z3 && z4) {
                    f = (this.y + this.measuredHeight) - iDp;
                } else {
                    f = (this.y + this.measuredHeight) - strokeWidth;
                }
                float f14 = f;
                int i8 = this.x;
                int i9 = this.measuredWidth;
                canvas.drawLine((i8 + i9) - strokeWidth, f13, (i8 + i9) - strokeWidth, f14, linePaint);
                int i10 = this.x;
                float f15 = (i10 == 0 && z4) ? i10 + iDp : i10 - strokeWidth;
                if (z3 && z4) {
                    f2 = (i10 + this.measuredWidth) - iDp;
                } else {
                    f2 = (i10 + this.measuredWidth) - strokeWidth;
                }
                float f16 = f2;
                int i11 = this.y;
                int i12 = this.measuredHeight;
                canvas.drawLine(f15, (i11 + i12) - strokeWidth, f16, (i11 + i12) - strokeWidth, linePaint);
                if (this.x == 0 && this.y == 0) {
                    RectF rectF = TableLayout.this.rect;
                    int i13 = this.x;
                    int i14 = this.y;
                    float f17 = iDp * 2;
                    rectF.set(i13 + strokeWidth, i14 + strokeWidth, i13 + strokeWidth + f17, i14 + strokeWidth + f17);
                    canvas.drawArc(TableLayout.this.rect, -180.0f, 90.0f, false, linePaint);
                }
                if (z3 && this.y == 0) {
                    RectF rectF2 = TableLayout.this.rect;
                    int i15 = this.x;
                    int i16 = this.measuredWidth;
                    float f18 = iDp * 2;
                    int i17 = this.y;
                    rectF2.set(((i15 + i16) - strokeWidth) - f18, i17 + strokeWidth, (i15 + i16) - strokeWidth, i17 + strokeWidth + f18);
                    canvas.drawArc(TableLayout.this.rect, 0.0f, -90.0f, false, linePaint);
                }
                if (this.x == 0 && z4) {
                    RectF rectF3 = TableLayout.this.rect;
                    int i18 = this.x;
                    int i19 = this.y;
                    int i20 = this.measuredHeight;
                    float f19 = iDp * 2;
                    rectF3.set(i18 + strokeWidth, ((i19 + i20) - strokeWidth) - f19, i18 + strokeWidth + f19, (i19 + i20) - strokeWidth);
                    canvas.drawArc(TableLayout.this.rect, 180.0f, -90.0f, false, linePaint);
                }
                if (z3 && z4) {
                    RectF rectF4 = TableLayout.this.rect;
                    int i21 = this.x;
                    int i22 = this.measuredWidth;
                    float f20 = iDp * 2;
                    int i23 = this.y;
                    int i24 = this.measuredHeight;
                    rectF4.set(((i21 + i22) - strokeWidth) - f20, ((i23 + i24) - strokeWidth) - f20, (i21 + i22) - strokeWidth, (i23 + i24) - strokeWidth);
                    canvas.drawArc(TableLayout.this.rect, 0.0f, 90.0f, false, linePaint);
                }
            }
        }

        public void setSelectionIndex(int selectionIndex) {
            this.selectionIndex = selectionIndex;
        }

        public int getRow() {
            return this.rowspan + 10;
        }
    }

    public void addChild(int x, int y, int colspan, int rowspan) {
        Child child = new Child(this.childrens.size());
        LayoutParams layoutParams = new LayoutParams();
        Interval interval = new Interval(y, y + rowspan);
        Alignment alignment = FILL;
        layoutParams.rowSpec = new Spec(false, interval, alignment, 0.0f);
        layoutParams.columnSpec = new Spec(false, new Interval(x, x + colspan), alignment, 0.0f);
        child.layoutParams = layoutParams;
        child.rowspan = y;
        this.childrens.add(child);
        invalidateStructure();
    }

    public void addChild(TLRPC$TL_pageTableCell cell, int x, int y, int colspan) {
        int i = colspan == 0 ? 1 : colspan;
        Child child = new Child(this.childrens.size());
        child.cell = cell;
        LayoutParams layoutParams = new LayoutParams();
        boolean z = false;
        int i2 = cell.rowspan;
        if (i2 == 0) {
            i2 = 1;
        }
        Interval interval = new Interval(y, i2 + y);
        Alignment alignment = FILL;
        layoutParams.rowSpec = new Spec(z, interval, alignment, 0.0f);
        layoutParams.columnSpec = new Spec(false, new Interval(x, i + x), alignment, 1.0f);
        child.layoutParams = layoutParams;
        child.rowspan = y;
        this.childrens.add(child);
        if (cell.rowspan > 1) {
            this.rowSpans.add(new Point(y, r1 + y));
        }
        invalidateStructure();
    }

    public void setDrawLines(boolean value) {
        this.drawLines = value;
    }

    public void setStriped(boolean value) {
        this.isStriped = value;
    }

    public void setRtl(boolean value) {
        this.isRtl = value;
    }

    public void removeAllChildrens() {
        this.childrens.clear();
        this.rowSpans.clear();
        invalidateStructure();
    }

    public int getChildCount() {
        return this.childrens.size();
    }

    public Child getChildAt(int index) {
        if (index < 0 || index >= this.childrens.size()) {
            return null;
        }
        return this.childrens.get(index);
    }

    public TableLayout(Context context, TableLayoutDelegate tableLayoutDelegate, TextSelectionHelper.ArticleTextSelectionHelper textSelectionHelper) {
        super(context);
        this.mHorizontalAxis = new Axis(true);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.itemPaddingTop = AndroidUtilities.dp(7.0f);
        this.itemPaddingLeft = AndroidUtilities.dp(8.0f);
        this.cellsToFixHeight = new ArrayList<>();
        this.rowSpans = new ArrayList<>();
        this.linePath = new Path();
        this.backgroundPath = new Path();
        this.rect = new RectF();
        this.radii = new float[8];
        this.childrens = new ArrayList<>();
        this.textSelectionHelper = textSelectionHelper;
        setRowCount(Integer.MIN_VALUE);
        setColumnCount(Integer.MIN_VALUE);
        setOrientation(0);
        setUseDefaultMargins(false);
        setAlignmentMode(1);
        setRowOrderPreserved(true);
        setColumnOrderPreserved(true);
        this.delegate = tableLayoutDelegate;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int orientation) {
        if (this.mOrientation != orientation) {
            this.mOrientation = orientation;
            invalidateStructure();
            requestLayout();
        }
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    public void setRowCount(int rowCount) {
        this.mVerticalAxis.setCount(rowCount);
        invalidateStructure();
        requestLayout();
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    public void setColumnCount(int columnCount) {
        this.mHorizontalAxis.setCount(columnCount);
        invalidateStructure();
        requestLayout();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public void setUseDefaultMargins(boolean useDefaultMargins) {
        this.mUseDefaultMargins = useDefaultMargins;
        requestLayout();
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public void setAlignmentMode(int alignmentMode) {
        this.mAlignmentMode = alignmentMode;
        requestLayout();
    }

    public void setRowOrderPreserved(boolean rowOrderPreserved) {
        this.mVerticalAxis.setOrderPreserved(rowOrderPreserved);
        invalidateStructure();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean columnOrderPreserved) {
        this.mHorizontalAxis.setOrderPreserved(columnOrderPreserved);
        invalidateStructure();
        requestLayout();
    }

    static int max2(int[] a, int valueIfEmpty) {
        for (int i : a) {
            valueIfEmpty = Math.max(valueIfEmpty, i);
        }
        return valueIfEmpty;
    }

    static <T> T[] append(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    private int getDefaultMargin(Child c, boolean horizontal, boolean leading) {
        return this.mDefaultGap / 2;
    }

    private int getDefaultMargin(Child c, boolean isAtEdge, boolean horizontal, boolean leading) {
        return getDefaultMargin(c, horizontal, leading);
    }

    private int getDefaultMargin(Child c, LayoutParams p, boolean horizontal, boolean leading) {
        boolean z = false;
        if (!this.mUseDefaultMargins) {
            return 0;
        }
        Spec spec = horizontal ? p.columnSpec : p.rowSpec;
        Axis axis = horizontal ? this.mHorizontalAxis : this.mVerticalAxis;
        Interval interval = spec.span;
        if (!((horizontal && this.isRtl) != leading) ? interval.max == axis.getCount() : interval.min == 0) {
            z = true;
        }
        return getDefaultMargin(c, z, horizontal, leading);
    }

    int getMargin1(Child view, boolean horizontal, boolean leading) {
        int i;
        LayoutParams layoutParams = view.getLayoutParams();
        if (horizontal) {
            i = leading ? ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin : ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i = leading ? ((ViewGroup.MarginLayoutParams) layoutParams).topMargin : ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return i == Integer.MIN_VALUE ? getDefaultMargin(view, layoutParams, horizontal, leading) : i;
    }

    private int getMargin(Child view, boolean horizontal, boolean leading) {
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, horizontal, leading);
        }
        Axis axis = horizontal ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] leadingMargins = leading ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams layoutParams = view.getLayoutParams();
        Interval interval = (horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        return leadingMargins[leading ? interval.min : interval.max];
    }

    private int getTotalMargin(Child child, boolean horizontal) {
        return getMargin(child, horizontal, true) + getMargin(child, horizontal, false);
    }

    private static boolean fits(int[] a, int value, int start, int end) {
        if (end > a.length) {
            return false;
        }
        while (start < end) {
            if (a[start] > value) {
                return false;
            }
            start++;
        }
        return true;
    }

    private static void procrusteanFill(int[] a, int start, int end, int value) {
        int length = a.length;
        Arrays.fill(a, Math.min(start, length), Math.min(end, length), value);
    }

    private static void setCellGroup(LayoutParams lp, int row, int rowSpan, int col, int colSpan) {
        lp.setRowSpecSpan(new Interval(row, rowSpan + row));
        lp.setColumnSpecSpan(new Interval(col, colSpan + col));
    }

    private static int clip(Interval minorRange, boolean minorWasDefined, int count) {
        int size = minorRange.size();
        if (count == 0) {
            return size;
        }
        return Math.min(size, count - (minorWasDefined ? Math.min(minorRange.min, count) : 0));
    }

    private void validateLayoutParams() {
        boolean z = this.mOrientation == 0;
        int i = (z ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int[] iArr = new int[i];
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams = getChildAt(i4).getLayoutParams();
            Spec spec = z ? layoutParams.rowSpec : layoutParams.columnSpec;
            Interval interval = spec.span;
            boolean z2 = spec.startDefined;
            int size = interval.size();
            if (z2) {
                i2 = interval.min;
            }
            Spec spec2 = z ? layoutParams.columnSpec : layoutParams.rowSpec;
            Interval interval2 = spec2.span;
            boolean z3 = spec2.startDefined;
            int iClip = clip(interval2, z3, i);
            if (z3) {
                i3 = interval2.min;
            }
            if (i != 0) {
                if (!z2 || !z3) {
                    while (true) {
                        int i5 = i3 + iClip;
                        if (fits(iArr, i2, i3, i5)) {
                            break;
                        }
                        if (z3) {
                            i2++;
                        } else if (i5 <= i) {
                            i3++;
                        } else {
                            i2++;
                            i3 = 0;
                        }
                    }
                }
                procrusteanFill(iArr, i3, i3 + iClip, i2 + size);
            }
            if (z) {
                setCellGroup(layoutParams, i2, size, i3, iClip);
            } else {
                setCellGroup(layoutParams, i3, iClip, i2, size);
            }
            i3 += iClip;
        }
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = 0;
        this.mHorizontalAxis.invalidateStructure();
        this.mVerticalAxis.invalidateStructure();
        invalidateValues();
    }

    private void invalidateValues() {
        Axis axis = this.mHorizontalAxis;
        if (axis == null || this.mVerticalAxis == null) {
            return;
        }
        axis.invalidateValues();
        this.mVerticalAxis.invalidateValues();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleInvalidParams(String msg) {
        throw new IllegalArgumentException(msg + ". ");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).draw(canvas);
        }
    }

    private int computeLayoutParamsHashCode() {
        int childCount = getChildCount();
        int iHashCode = 1;
        for (int i = 0; i < childCount; i++) {
            iHashCode = (iHashCode * 31) + getChildAt(i).getLayoutParams().hashCode();
        }
        return iHashCode;
    }

    private void consistencyCheck() {
        int i = this.mLastLayoutParamsHashCode;
        if (i == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (i != computeLayoutParamsHashCode()) {
            invalidateStructure();
            consistencyCheck();
        }
    }

    private void measureChildWithMargins2(Child child, int parentWidthSpec, int parentHeightSpec, int childWidth, int childHeight, boolean first) {
        child.measure(getTotalMargin(child, true) + childWidth, getTotalMargin(child, false) + childHeight, first);
    }

    private void measureChildrenWithMargins(int widthSpec, int heightSpec, boolean firstPass) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            Child childAt = getChildAt(i);
            LayoutParams layoutParams = childAt.getLayoutParams();
            if (firstPass) {
                int size = View.MeasureSpec.getSize(widthSpec);
                childAt.setTextLayout(this.delegate.createTextLayout(childAt.cell, this.colCount == 2 ? ((int) (size / 2.0f)) - (this.itemPaddingLeft * 4) : (int) (size / 1.5f)));
                if (childAt.textLayout != null) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = childAt.textWidth + (this.itemPaddingLeft * 2);
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = childAt.textHeight + (this.itemPaddingTop * 2);
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                }
                measureChildWithMargins2(childAt, widthSpec, heightSpec, ((ViewGroup.MarginLayoutParams) layoutParams).width, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
            } else {
                boolean z = this.mOrientation == 0;
                Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
                if (spec.getAbsoluteAlignment(z) == FILL) {
                    Interval interval = spec.span;
                    int[] locations = (z ? this.mHorizontalAxis : this.mVerticalAxis).getLocations();
                    int totalMargin = (locations[interval.max] - locations[interval.min]) - getTotalMargin(childAt, z);
                    if (z) {
                        measureChildWithMargins2(childAt, widthSpec, heightSpec, totalMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    } else {
                        measureChildWithMargins2(childAt, widthSpec, heightSpec, ((ViewGroup.MarginLayoutParams) layoutParams).width, totalMargin, false);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthSpec, int heightSpec) {
        int measure;
        int measure2;
        boolean z;
        boolean z2;
        consistencyCheck();
        invalidateValues();
        boolean z3 = false;
        this.colCount = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.colCount = Math.max(this.colCount, getChildAt(i).layoutParams.columnSpec.span.max);
        }
        boolean z4 = true;
        measureChildrenWithMargins(widthSpec, heightSpec, true);
        if (this.mOrientation == 0) {
            measure = this.mHorizontalAxis.getMeasure(widthSpec);
            measureChildrenWithMargins(widthSpec, heightSpec, false);
            measure2 = this.mVerticalAxis.getMeasure(heightSpec);
        } else {
            int measure3 = this.mVerticalAxis.getMeasure(heightSpec);
            measureChildrenWithMargins(widthSpec, heightSpec, false);
            measure = this.mHorizontalAxis.getMeasure(widthSpec);
            measure2 = measure3;
        }
        int iMax = Math.max(measure, View.MeasureSpec.getSize(widthSpec));
        int iMax2 = Math.max(measure2, getSuggestedMinimumHeight());
        setMeasuredDimension(iMax, iMax2);
        this.mHorizontalAxis.layout(iMax);
        this.mVerticalAxis.layout(iMax2);
        int[] locations = this.mHorizontalAxis.getLocations();
        int[] locations2 = this.mVerticalAxis.getLocations();
        this.cellsToFixHeight.clear();
        int i2 = locations[locations.length - 1];
        int childCount2 = getChildCount();
        int i3 = 0;
        while (i3 < childCount2) {
            Child childAt = getChildAt(i3);
            LayoutParams layoutParams = childAt.getLayoutParams();
            Spec spec = layoutParams.columnSpec;
            Spec spec2 = layoutParams.rowSpec;
            Interval interval = spec.span;
            Interval interval2 = spec2.span;
            int i4 = locations[interval.min];
            int i5 = locations2[interval2.min];
            int i6 = locations[interval.max] - i4;
            int i7 = locations2[interval2.max] - i5;
            int measurement = getMeasurement(childAt, z4);
            int measurement2 = getMeasurement(childAt, z3);
            Alignment absoluteAlignment = spec.getAbsoluteAlignment(z4);
            Alignment absoluteAlignment2 = spec2.getAbsoluteAlignment(z3);
            Bounds value = this.mHorizontalAxis.getGroupBounds().getValue(i3);
            Bounds value2 = this.mVerticalAxis.getGroupBounds().getValue(i3);
            int gravityOffset = absoluteAlignment.getGravityOffset(childAt, i6 - value.size(z4));
            int gravityOffset2 = absoluteAlignment2.getGravityOffset(childAt, i7 - value2.size(z4));
            int margin = getMargin(childAt, z4, z4);
            int margin2 = getMargin(childAt, false, z4);
            int margin3 = getMargin(childAt, z4, false);
            int i8 = margin + margin3;
            int margin4 = margin2 + getMargin(childAt, false, false);
            int i9 = iMax2;
            int offset = value.getOffset(this, childAt, absoluteAlignment, measurement + i8, true);
            int offset2 = value2.getOffset(this, childAt, absoluteAlignment2, measurement2 + margin4, false);
            int sizeInCell = absoluteAlignment.getSizeInCell(childAt, measurement, i6 - i8);
            int sizeInCell2 = absoluteAlignment2.getSizeInCell(childAt, measurement2, i7 - margin4);
            int i10 = i4 + gravityOffset + offset;
            int i11 = !this.isRtl ? margin + i10 : ((i2 - sizeInCell) - margin3) - i10;
            int i12 = i5 + gravityOffset2 + offset2 + margin2;
            if (childAt.cell != null) {
                if (sizeInCell != childAt.getMeasuredWidth() || sizeInCell2 != childAt.getMeasuredHeight()) {
                    childAt.measure(sizeInCell, sizeInCell2, false);
                }
                if (childAt.fixedHeight != 0 && childAt.fixedHeight != sizeInCell2 && childAt.layoutParams.rowSpec.span.max - childAt.layoutParams.rowSpec.span.min <= 1) {
                    int size = this.rowSpans.size();
                    int i13 = 0;
                    while (true) {
                        if (i13 >= size) {
                            z2 = false;
                            break;
                        }
                        Point point = this.rowSpans.get(i13);
                        if (point.x <= childAt.layoutParams.rowSpec.span.min && point.y > childAt.layoutParams.rowSpec.span.min) {
                            z2 = true;
                            break;
                        }
                        i13++;
                    }
                    if (!z2) {
                        this.cellsToFixHeight.add(childAt);
                    }
                }
            }
            childAt.layout(i11, i12, sizeInCell + i11, sizeInCell2 + i12);
            i3++;
            iMax2 = i9;
            z3 = false;
            z4 = true;
        }
        int size2 = this.cellsToFixHeight.size();
        int i14 = 0;
        while (i14 < size2) {
            Child child = this.cellsToFixHeight.get(i14);
            int iMin = child.measuredHeight - child.fixedHeight;
            int size3 = this.childrens.size();
            for (int i15 = child.index + 1; i15 < size3; i15++) {
                Child child2 = this.childrens.get(i15);
                if (child.layoutParams.rowSpec.span.min != child2.layoutParams.rowSpec.span.min) {
                    break;
                }
                if (child.fixedHeight < child2.fixedHeight) {
                    z = true;
                    break;
                }
                int i16 = child2.measuredHeight - child2.fixedHeight;
                if (i16 > 0) {
                    iMin = Math.min(iMin, i16);
                }
            }
            z = false;
            if (!z) {
                int i17 = child.index - 1;
                while (true) {
                    if (i17 < 0) {
                        break;
                    }
                    Child child3 = this.childrens.get(i17);
                    if (child.layoutParams.rowSpec.span.min != child3.layoutParams.rowSpec.span.min) {
                        break;
                    }
                    if (child.fixedHeight < child3.fixedHeight) {
                        z = true;
                        break;
                    }
                    int i18 = child3.measuredHeight - child3.fixedHeight;
                    if (i18 > 0) {
                        iMin = Math.min(iMin, i18);
                    }
                    i17--;
                }
            }
            if (!z) {
                child.setFixedHeight(child.fixedHeight);
                iMax2 -= iMin;
                int size4 = this.childrens.size();
                int i19 = i14;
                for (int i20 = 0; i20 < size4; i20++) {
                    Child child4 = this.childrens.get(i20);
                    if (child != child4) {
                        if (child.layoutParams.rowSpec.span.min == child4.layoutParams.rowSpec.span.min) {
                            if (child4.fixedHeight != child4.measuredHeight) {
                                this.cellsToFixHeight.remove(child4);
                                if (child4.index < child.index) {
                                    i19--;
                                }
                                size2--;
                            }
                            Child.access$1520(child4, iMin);
                            child4.measure(child4.measuredWidth, child4.measuredHeight, true);
                        } else if (child.layoutParams.rowSpec.span.min < child4.layoutParams.rowSpec.span.min) {
                            child4.y -= iMin;
                        }
                    }
                }
                i14 = i19;
            }
            i14++;
        }
        int childCount3 = getChildCount();
        for (int i21 = 0; i21 < childCount3; i21++) {
            Child childAt2 = getChildAt(i21);
            this.delegate.onLayoutChild(childAt2.textLayout, childAt2.getTextX(), childAt2.getTextY());
        }
        setMeasuredDimension(i2, iMax2);
    }

    private int getMeasurement(Child c, boolean horizontal) {
        return horizontal ? c.getMeasuredWidth() : c.getMeasuredHeight();
    }

    final int getMeasurementIncludingMargin(Child c, boolean horizontal) {
        return getMeasurement(c, horizontal) + getTotalMargin(c, horizontal);
    }

    @Override // android.view.View
    public void requestLayout() {
        super.requestLayout();
        invalidateValues();
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        consistencyCheck();
    }

    final class Axis {
        public Arc[] arcs;
        public boolean arcsValid;
        PackedMap<Interval, MutableInt> backwardLinks;
        public boolean backwardLinksValid;
        public int definedCount;
        public int[] deltas;
        PackedMap<Interval, MutableInt> forwardLinks;
        public boolean forwardLinksValid;
        PackedMap<Spec, Bounds> groupBounds;
        public boolean groupBoundsValid;
        public boolean hasWeights;
        public boolean hasWeightsValid;
        public final boolean horizontal;
        public int[] leadingMargins;
        public boolean leadingMarginsValid;
        public int[] locations;
        public boolean locationsValid;
        private int maxIndex;
        boolean orderPreserved;
        private MutableInt parentMax;
        private MutableInt parentMin;
        public int[] trailingMargins;
        public boolean trailingMarginsValid;

        private Axis(boolean horizontal) {
            this.definedCount = Integer.MIN_VALUE;
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
            this.hasWeightsValid = false;
            this.orderPreserved = true;
            this.parentMin = new MutableInt(0);
            this.parentMax = new MutableInt(-100000);
            this.horizontal = horizontal;
        }

        private int calculateMaxIndex() {
            int childCount = TableLayout.this.getChildCount();
            int iMax = -1;
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = TableLayout.this.getChildAt(i).getLayoutParams();
                Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                iMax = Math.max(Math.max(Math.max(iMax, interval.min), interval.max), interval.size());
            }
            if (iMax == -1) {
                return Integer.MIN_VALUE;
            }
            return iMax;
        }

        private int getMaxIndex() {
            if (this.maxIndex == Integer.MIN_VALUE) {
                this.maxIndex = Math.max(0, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public void setCount(int count) {
            if (count != Integer.MIN_VALUE && count < getMaxIndex()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.horizontal ? "column" : "row");
                sb.append("Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
                TableLayout.handleInvalidParams(sb.toString());
            }
            this.definedCount = count;
        }

        public void setOrderPreserved(boolean orderPreserved) {
            this.orderPreserved = orderPreserved;
            invalidateStructure();
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc assocOf = Assoc.of(Spec.class, Bounds.class);
            int childCount = TableLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = TableLayout.this.getChildAt(i).getLayoutParams();
                boolean z = this.horizontal;
                Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
                assocOf.put(spec, spec.getAbsoluteAlignment(z).getBounds());
            }
            return assocOf.pack();
        }

        private void computeGroupBounds() {
            for (Bounds bounds : this.groupBounds.values) {
                bounds.reset();
            }
            int childCount = TableLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Child childAt = TableLayout.this.getChildAt(i);
                LayoutParams layoutParams = childAt.getLayoutParams();
                boolean z = this.horizontal;
                Spec spec = z ? layoutParams.columnSpec : layoutParams.rowSpec;
                this.groupBounds.getValue(i).include(TableLayout.this, childAt, spec, this, TableLayout.this.getMeasurementIncludingMargin(childAt, z) + (spec.weight == 0.0f ? 0 : this.deltas[i]));
            }
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = true;
            }
            return this.groupBounds;
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean min) {
            Assoc assocOf = Assoc.of(Interval.class, MutableInt.class);
            Spec[] specArr = getGroupBounds().keys;
            int length = specArr.length;
            for (int i = 0; i < length; i++) {
                assocOf.put(min ? specArr[i].span : specArr[i].span.inverse(), new MutableInt());
            }
            return assocOf.pack();
        }

        private void computeLinks(PackedMap<Interval, MutableInt> links, boolean min) {
            for (MutableInt mutableInt : links.values) {
                mutableInt.reset();
            }
            Bounds[] boundsArr = getGroupBounds().values;
            for (int i = 0; i < boundsArr.length; i++) {
                int size = boundsArr[i].size(min);
                MutableInt value = links.getValue(i);
                int i2 = value.value;
                if (!min) {
                    size = -size;
                }
                value.value = Math.max(i2, size);
            }
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(true);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, true);
                this.forwardLinksValid = true;
            }
            return this.forwardLinks;
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks(false);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, false);
                this.backwardLinksValid = true;
            }
            return this.backwardLinks;
        }

        private void include(List<Arc> arcs, Interval key, MutableInt size, boolean ignoreIfAlreadyPresent) {
            if (key.size() == 0) {
                return;
            }
            if (ignoreIfAlreadyPresent) {
                Iterator<Arc> it = arcs.iterator();
                while (it.hasNext()) {
                    if (it.next().span.equals(key)) {
                        return;
                    }
                }
            }
            arcs.add(new Arc(key, size));
        }

        private void include(List<Arc> arcs, Interval key, MutableInt size) {
            include(arcs, key, size, true);
        }

        Arc[][] groupArcsByFirstVertex(Arc[] arcs) {
            int count = getCount() + 1;
            Arc[][] arcArr = new Arc[count][];
            int[] iArr = new int[count];
            for (Arc arc : arcs) {
                int i = arc.span.min;
                iArr[i] = iArr[i] + 1;
            }
            for (int i2 = 0; i2 < count; i2++) {
                arcArr[i2] = new Arc[iArr[i2]];
            }
            Arrays.fill(iArr, 0);
            for (Arc arc2 : arcs) {
                int i3 = arc2.span.min;
                Arc[] arcArr2 = arcArr[i3];
                int i4 = iArr[i3];
                iArr[i3] = i4 + 1;
                arcArr2[i4] = arc2;
            }
            return arcArr;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [ir.eitaa.ui.Components.TableLayout$Axis$1] */
        private Arc[] topologicalSort(final Arc[] arcs) {
            return new Object(arcs) { // from class: ir.eitaa.ui.Components.TableLayout.Axis.1
                Arc[][] arcsByVertex;
                int cursor;
                Arc[] result;
                final /* synthetic */ Arc[] val$arcs;
                int[] visited;

                {
                    this.val$arcs = arcs;
                    this.result = new Arc[arcs.length];
                    this.cursor = r0.length - 1;
                    this.arcsByVertex = Axis.this.groupArcsByFirstVertex(arcs);
                    this.visited = new int[Axis.this.getCount() + 1];
                }

                void walk(int loc) {
                    int[] iArr = this.visited;
                    if (iArr[loc] != 0) {
                        return;
                    }
                    iArr[loc] = 1;
                    for (Arc arc : this.arcsByVertex[loc]) {
                        walk(arc.span.max);
                        Arc[] arcArr = this.result;
                        int i = this.cursor;
                        this.cursor = i - 1;
                        arcArr[i] = arc;
                    }
                    this.visited[loc] = 2;
                }

                Arc[] sort() {
                    int length = this.arcsByVertex.length;
                    for (int i = 0; i < length; i++) {
                        walk(i);
                    }
                    return this.result;
                }
            }.sort();
        }

        private Arc[] topologicalSort(List<Arc> arcs) {
            return topologicalSort((Arc[]) arcs.toArray(new Arc[0]));
        }

        private void addComponentSizes(List<Arc> result, PackedMap<Interval, MutableInt> links) {
            int i = 0;
            while (true) {
                Interval[] intervalArr = links.keys;
                if (i >= intervalArr.length) {
                    return;
                }
                include(result, intervalArr[i], links.values[i], false);
                i++;
            }
        }

        private Arc[] createArcs() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            addComponentSizes(arrayList, getForwardLinks());
            addComponentSizes(arrayList2, getBackwardLinks());
            if (this.orderPreserved) {
                int i = 0;
                while (i < getCount()) {
                    int i2 = i + 1;
                    include(arrayList, new Interval(i, i2), new MutableInt(0));
                    i = i2;
                }
            }
            int count = getCount();
            include(arrayList, new Interval(0, count), this.parentMin, false);
            include(arrayList2, new Interval(count, 0), this.parentMax, false);
            return (Arc[]) TableLayout.append(topologicalSort(arrayList), topologicalSort(arrayList2));
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = true;
            }
            return this.arcs;
        }

        private boolean relax(int[] locations, Arc entry) {
            if (!entry.valid) {
                return false;
            }
            Interval interval = entry.span;
            int i = interval.min;
            int i2 = interval.max;
            int i3 = locations[i] + entry.value.value;
            if (i3 <= locations[i2]) {
                return false;
            }
            locations[i2] = i3;
            return true;
        }

        private void init(int[] locations) {
            Arrays.fill(locations, 0);
        }

        private boolean solve(Arc[] arcs, int[] locations) {
            return solve(arcs, locations, true);
        }

        private boolean solve(Arc[] arcs, int[] locations, boolean modifyOnError) {
            int count = getCount() + 1;
            for (int i = 0; i < arcs.length; i++) {
                init(locations);
                for (int i2 = 0; i2 < count; i2++) {
                    boolean zRelax = false;
                    for (Arc arc : arcs) {
                        zRelax |= relax(locations, arc);
                    }
                    if (!zRelax) {
                        return true;
                    }
                }
                if (!modifyOnError) {
                    return false;
                }
                boolean[] zArr = new boolean[arcs.length];
                for (int i3 = 0; i3 < count; i3++) {
                    int length = arcs.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        zArr[i4] = zArr[i4] | relax(locations, arcs[i4]);
                    }
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= arcs.length) {
                        break;
                    }
                    if (zArr[i5]) {
                        Arc arc2 = arcs[i5];
                        Interval interval = arc2.span;
                        if (interval.min >= interval.max) {
                            arc2.valid = false;
                            break;
                        }
                    }
                    i5++;
                }
            }
            return true;
        }

        private void computeMargins(boolean leading) {
            int[] iArr = leading ? this.leadingMargins : this.trailingMargins;
            int childCount = TableLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Child childAt = TableLayout.this.getChildAt(i);
                LayoutParams layoutParams = childAt.getLayoutParams();
                boolean z = this.horizontal;
                Interval interval = (z ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                int i2 = leading ? interval.min : interval.max;
                iArr[i2] = Math.max(iArr[i2], TableLayout.this.getMargin1(childAt, z, leading));
            }
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[getCount() + 1];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(true);
                this.leadingMarginsValid = true;
            }
            return this.leadingMargins;
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[getCount() + 1];
            }
            if (!this.trailingMarginsValid) {
                computeMargins(false);
                this.trailingMarginsValid = true;
            }
            return this.trailingMargins;
        }

        private boolean solve(int[] a) {
            return solve(getArcs(), a);
        }

        private boolean computeHasWeights() {
            int childCount = TableLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = TableLayout.this.getChildAt(i).getLayoutParams();
                if ((this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight != 0.0f) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = true;
            }
            return this.hasWeights;
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[TableLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        private void shareOutDelta(int totalDelta, float totalWeight) {
            Arrays.fill(this.deltas, 0);
            int childCount = TableLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = TableLayout.this.getChildAt(i).getLayoutParams();
                float f = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                if (f != 0.0f) {
                    int iRound = Math.round((totalDelta * f) / totalWeight);
                    this.deltas[i] = iRound;
                    totalDelta -= iRound;
                    totalWeight -= f;
                }
            }
        }

        private void solveAndDistributeSpace(int[] a) {
            Arrays.fill(getDeltas(), 0);
            solve(a);
            boolean z = true;
            int childCount = (this.parentMin.value * TableLayout.this.getChildCount()) + 1;
            if (childCount < 2) {
                return;
            }
            float fCalculateTotalWeight = calculateTotalWeight();
            int i = -1;
            int i2 = 0;
            while (i2 < childCount) {
                int i3 = (int) ((i2 + childCount) / 2);
                invalidateValues();
                shareOutDelta(i3, fCalculateTotalWeight);
                boolean zSolve = solve(getArcs(), a, false);
                if (zSolve) {
                    i2 = i3 + 1;
                    i = i3;
                } else {
                    childCount = i3;
                }
                z = zSolve;
            }
            if (i <= 0 || z) {
                return;
            }
            invalidateValues();
            shareOutDelta(i, fCalculateTotalWeight);
            solve(a);
        }

        private float calculateTotalWeight() {
            int childCount = TableLayout.this.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = TableLayout.this.getChildAt(i).getLayoutParams();
                f += (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
            }
            return f;
        }

        private void computeLocations(int[] a) {
            if (!hasWeights()) {
                solve(a);
            } else {
                solveAndDistributeSpace(a);
            }
            if (this.orderPreserved) {
                return;
            }
            int i = a[0];
            int length = a.length;
            for (int i2 = 0; i2 < length; i2++) {
                a[i2] = a[i2] - i;
            }
        }

        public int[] getLocations() {
            if (this.locations == null) {
                this.locations = new int[getCount() + 1];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = true;
            }
            return this.locations;
        }

        private int size(int[] locations) {
            return locations[getCount()];
        }

        private void setParentConstraints(int min, int max) {
            this.parentMin.value = min;
            this.parentMax.value = -max;
            this.locationsValid = false;
        }

        private int getMeasure(int min, int max) {
            setParentConstraints(min, max);
            return size(getLocations());
        }

        public int getMeasure(int measureSpec) {
            int mode = View.MeasureSpec.getMode(measureSpec);
            int size = View.MeasureSpec.getSize(measureSpec);
            if (mode == Integer.MIN_VALUE) {
                return getMeasure(0, size);
            }
            if (mode == 0) {
                return getMeasure(0, 100000);
            }
            if (mode != 1073741824) {
                return 0;
            }
            return getMeasure(size, size);
        }

        public void layout(int size) {
            setParentConstraints(size, size);
            getLocations();
        }

        public void invalidateStructure() {
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.deltas = null;
            this.hasWeightsValid = false;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final Interval DEFAULT_SPAN;
        private static final int DEFAULT_SPAN_SIZE;
        public Spec columnSpec;
        public Spec rowSpec;

        static {
            Interval interval = new Interval(Integer.MIN_VALUE, -2147483647);
            DEFAULT_SPAN = interval;
            DEFAULT_SPAN_SIZE = interval.size();
        }

        private LayoutParams(int width, int height, int left, int top, int right, int bottom, Spec rowSpec, Spec columnSpec) {
            super(width, height);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
            setMargins(left, top, right, bottom);
            this.rowSpec = rowSpec;
            this.columnSpec = columnSpec;
        }

        public LayoutParams(Spec rowSpec, Spec columnSpec) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, rowSpec, columnSpec);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public LayoutParams() {
            Spec spec = Spec.UNDEFINED;
            this(spec, spec);
        }

        final void setRowSpecSpan(Interval span) {
            this.rowSpec = this.rowSpec.copyWriteSpan(span);
        }

        final void setColumnSpecSpan(Interval span) {
            this.columnSpec = this.columnSpec.copyWriteSpan(span);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || LayoutParams.class != o.getClass()) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) o;
            return this.columnSpec.equals(layoutParams.columnSpec) && this.rowSpec.equals(layoutParams.rowSpec);
        }

        public int hashCode() {
            return (this.rowSpec.hashCode() * 31) + this.columnSpec.hashCode();
        }
    }

    static final class Arc {
        public final Interval span;
        public boolean valid = true;
        public final MutableInt value;

        public Arc(Interval span, MutableInt value) {
            this.span = span;
            this.value = value;
        }
    }

    static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public MutableInt(int value) {
            this.value = value;
        }

        public void reset() {
            this.value = Integer.MIN_VALUE;
        }
    }

    static final class Assoc<K, V> extends ArrayList<Pair<K, V>> implements j$.util.List {
        private final Class<K> keyType;
        private final Class<V> valueType;

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return S1.v(a.D(this), true);
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // j$.util.List
        public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
            List.CC.$default$replaceAll(this, unaryOperator);
        }

        @Override // java.util.ArrayList, java.util.List, j$.util.List
        public /* synthetic */ void sort(Comparator comparator) {
            List.CC.$default$sort(this, comparator);
        }

        @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List, j$.util.List, j$.util.Collection, java.util.Set, j$.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return List.CC.$default$spliterator(this);
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return S1.v(a.D(this), false);
        }

        private Assoc(Class<K> keyType, Class<V> valueType) {
            this.keyType = keyType;
            this.valueType = valueType;
        }

        public static <K, V> Assoc<K, V> of(Class<K> keyType, Class<V> valueType) {
            return new Assoc<>(keyType, valueType);
        }

        public void put(K key, V value) {
            add(Pair.create(key, value));
        }

        public PackedMap<K, V> pack() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.valueType, size);
            for (int i = 0; i < size; i++) {
                objArr[i] = get(i).first;
                objArr2[i] = get(i).second;
            }
            return new PackedMap<>(objArr, objArr2);
        }
    }

    static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        private PackedMap(K[] kArr, V[] vArr) {
            int[] iArrCreateIndex = createIndex(kArr);
            this.index = iArrCreateIndex;
            this.keys = (K[]) compact(kArr, iArrCreateIndex);
            this.values = (V[]) compact(vArr, iArrCreateIndex);
        }

        public V getValue(int i) {
            return this.values[this.index[i]];
        }

        private static <K> int[] createIndex(K[] keys) {
            int length = keys.length;
            int[] iArr = new int[length];
            HashMap map = new HashMap();
            for (int i = 0; i < length; i++) {
                K k = keys[i];
                Integer numValueOf = (Integer) map.get(k);
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(map.size());
                    map.put(k, numValueOf);
                }
                iArr[i] = numValueOf.intValue();
            }
            return iArr;
        }

        private static <K> K[] compact(K[] kArr, int[] iArr) {
            int length = kArr.length;
            K[] kArr2 = (K[]) ((Object[]) Array.newInstance(kArr.getClass().getComponentType(), TableLayout.max2(iArr, -1) + 1));
            for (int i = 0; i < length; i++) {
                kArr2[iArr[i]] = kArr[i];
            }
            return kArr2;
        }
    }

    static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        private Bounds() {
            reset();
        }

        protected void reset() {
            this.before = Integer.MIN_VALUE;
            this.after = Integer.MIN_VALUE;
            this.flexibility = 2;
        }

        protected void include(int before, int after) {
            this.before = Math.max(this.before, before);
            this.after = Math.max(this.after, after);
        }

        protected int size(boolean min) {
            if (min || !TableLayout.canStretch(this.flexibility)) {
                return this.before + this.after;
            }
            return 100000;
        }

        protected int getOffset(TableLayout gl, Child c, Alignment a, int size, boolean horizontal) {
            return this.before - a.getAlignmentValue(c, size);
        }

        protected final void include(TableLayout gl, Child c, Spec spec, Axis axis, int size) {
            this.flexibility &= spec.getFlexibility();
            int alignmentValue = spec.getAbsoluteAlignment(axis.horizontal).getAlignmentValue(c, size);
            include(alignmentValue, size - alignmentValue);
        }
    }

    static final class Interval {
        public final int max;
        public final int min;

        public Interval(int min, int max) {
            this.min = min;
            this.max = max;
        }

        int size() {
            return this.max - this.min;
        }

        Interval inverse() {
            return new Interval(this.max, this.min);
        }

        public boolean equals(Object that) {
            if (this == that) {
                return true;
            }
            if (that == null || Interval.class != that.getClass()) {
                return false;
            }
            Interval interval = (Interval) that;
            return this.max == interval.max && this.min == interval.min;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }
    }

    public static class Spec {
        static final Spec UNDEFINED = TableLayout.spec(Integer.MIN_VALUE);
        final Alignment alignment;
        final Interval span;
        final boolean startDefined;
        float weight;

        private Spec(boolean startDefined, Interval span, Alignment alignment, float weight) {
            this.startDefined = startDefined;
            this.span = span;
            this.alignment = alignment;
            this.weight = weight;
        }

        private Spec(boolean startDefined, int start, int size, Alignment alignment, float weight) {
            this(startDefined, new Interval(start, size + start), alignment, weight);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Alignment getAbsoluteAlignment(boolean horizontal) {
            Alignment alignment = this.alignment;
            if (alignment != TableLayout.UNDEFINED_ALIGNMENT) {
                return alignment;
            }
            if (this.weight == 0.0f) {
                return horizontal ? TableLayout.START : TableLayout.BASELINE;
            }
            return TableLayout.FILL;
        }

        final Spec copyWriteSpan(Interval span) {
            return new Spec(this.startDefined, span, this.alignment, this.weight);
        }

        final int getFlexibility() {
            return (this.alignment == TableLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? 0 : 2;
        }

        public boolean equals(Object that) {
            if (this == that) {
                return true;
            }
            if (that == null || Spec.class != that.getClass()) {
                return false;
            }
            Spec spec = (Spec) that;
            return this.alignment.equals(spec.alignment) && this.span.equals(spec.span);
        }

        public int hashCode() {
            return (this.span.hashCode() * 31) + this.alignment.hashCode();
        }
    }

    public static Spec spec(int start, int size, Alignment alignment, float weight) {
        return new Spec(start != Integer.MIN_VALUE, start, size, alignment, weight);
    }

    public static Spec spec(int start, int size, Alignment alignment) {
        return spec(start, size, alignment, 0.0f);
    }

    public static Spec spec(int start, int size) {
        return spec(start, size, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int start) {
        return spec(start, 1);
    }

    public static abstract class Alignment {
        abstract int getAlignmentValue(Child view, int viewSize);

        abstract int getGravityOffset(Child view, int cellDelta);

        int getSizeInCell(Child view, int viewSize, int cellSize) {
            return viewSize;
        }

        Alignment() {
        }

        Bounds getBounds() {
            return new Bounds();
        }
    }

    static {
        Alignment alignment = new Alignment() { // from class: ir.eitaa.ui.Components.TableLayout.2
            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            public int getAlignmentValue(Child view, int viewSize) {
                return 0;
            }

            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            int getGravityOffset(Child view, int cellDelta) {
                return 0;
            }
        };
        LEADING = alignment;
        Alignment alignment2 = new Alignment() { // from class: ir.eitaa.ui.Components.TableLayout.3
            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            public int getAlignmentValue(Child view, int viewSize) {
                return viewSize;
            }

            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            int getGravityOffset(Child view, int cellDelta) {
                return cellDelta;
            }
        };
        TRAILING = alignment2;
        TOP = alignment;
        BOTTOM = alignment2;
        START = alignment;
        END = alignment2;
        LEFT = createSwitchingAlignment(alignment);
        RIGHT = createSwitchingAlignment(alignment2);
        CENTER = new Alignment() { // from class: ir.eitaa.ui.Components.TableLayout.5
            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            public int getAlignmentValue(Child view, int viewSize) {
                return viewSize >> 1;
            }

            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            int getGravityOffset(Child view, int cellDelta) {
                return cellDelta >> 1;
            }
        };
        BASELINE = new Alignment() { // from class: ir.eitaa.ui.Components.TableLayout.6
            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            public int getAlignmentValue(Child view, int viewSize) {
                return Integer.MIN_VALUE;
            }

            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            int getGravityOffset(Child view, int cellDelta) {
                return 0;
            }

            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            public Bounds getBounds() {
                return new Bounds() { // from class: ir.eitaa.ui.Components.TableLayout.6.1
                    private int size;

                    @Override // ir.eitaa.ui.Components.TableLayout.Bounds
                    protected void reset() {
                        super.reset();
                        this.size = Integer.MIN_VALUE;
                    }

                    @Override // ir.eitaa.ui.Components.TableLayout.Bounds
                    protected void include(int before, int after) {
                        super.include(before, after);
                        this.size = Math.max(this.size, before + after);
                    }

                    @Override // ir.eitaa.ui.Components.TableLayout.Bounds
                    protected int size(boolean min) {
                        return Math.max(super.size(min), this.size);
                    }

                    @Override // ir.eitaa.ui.Components.TableLayout.Bounds
                    protected int getOffset(TableLayout gl, Child c, Alignment a, int size, boolean hrz) {
                        return Math.max(0, super.getOffset(gl, c, a, size, hrz));
                    }
                };
            }
        };
        FILL = new Alignment() { // from class: ir.eitaa.ui.Components.TableLayout.7
            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            public int getAlignmentValue(Child view, int viewSize) {
                return Integer.MIN_VALUE;
            }

            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            int getGravityOffset(Child view, int cellDelta) {
                return 0;
            }

            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            public int getSizeInCell(Child view, int viewSize, int cellSize) {
                return cellSize;
            }
        };
    }

    private static Alignment createSwitchingAlignment(final Alignment ltr) {
        return new Alignment() { // from class: ir.eitaa.ui.Components.TableLayout.4
            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            int getGravityOffset(Child view, int cellDelta) {
                return ltr.getGravityOffset(view, cellDelta);
            }

            @Override // ir.eitaa.ui.Components.TableLayout.Alignment
            public int getAlignmentValue(Child view, int viewSize) {
                return ltr.getAlignmentValue(view, viewSize);
            }
        };
    }
}
