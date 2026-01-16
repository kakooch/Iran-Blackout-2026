package com.github.mikephil.charting.charts;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    public static final String LOG_TAG = "MPAndroidChart";
    public static final int PAINT_CENTER_TEXT = 14;
    public static final int PAINT_DESCRIPTION = 11;
    public static final int PAINT_GRID_BACKGROUND = 4;
    public static final int PAINT_HOLE = 13;
    public static final int PAINT_INFO = 7;
    public static final int PAINT_LEGEND_LABEL = 18;
    private boolean a;
    private float b;
    private String c;
    private OnChartGestureListener d;
    private float e;
    private float f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;
    protected ChartAnimator mAnimator;
    protected ChartTouchListener mChartTouchListener;
    protected T mData;
    protected DefaultValueFormatter mDefaultValueFormatter;
    protected Paint mDescPaint;
    protected Description mDescription;
    protected boolean mDrawMarkers;
    protected boolean mHighLightPerTapEnabled;
    protected IHighlighter mHighlighter;
    protected Highlight[] mIndicesToHighlight;
    protected Paint mInfoPaint;
    protected ArrayList<Runnable> mJobs;
    protected Legend mLegend;
    protected LegendRenderer mLegendRenderer;
    protected boolean mLogEnabled;
    protected IMarker mMarker;
    protected float mMaxHighlightDistance;
    protected DataRenderer mRenderer;
    protected OnChartValueSelectedListener mSelectionListener;
    protected boolean mTouchEnabled;
    protected ViewPortHandler mViewPortHandler;
    protected XAxis mXAxis;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Chart.this.postInvalidate();
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            a = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Chart(Context context) {
        super(context);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.a = true;
        this.b = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.c = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.j = false;
        init();
    }

    private void a(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                viewGroup.removeAllViews();
                return;
            } else {
                a(viewGroup.getChildAt(i));
                i++;
            }
        }
    }

    public void addViewportJob(Runnable runnable) {
        if (this.mViewPortHandler.hasChartDimens()) {
            post(runnable);
        } else {
            this.mJobs.add(runnable);
        }
    }

    public void animateX(int i, Easing.EasingFunction easingFunction) {
        this.mAnimator.animateX(i, easingFunction);
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        this.mAnimator.animateXY(i, i2, easingFunction, easingFunction2);
    }

    public void animateY(int i, Easing.EasingFunction easingFunction) {
        this.mAnimator.animateY(i, easingFunction);
    }

    protected abstract void calcMinMax();

    protected abstract void calculateOffsets();

    public void clear() {
        this.mData = null;
        this.i = false;
        this.mIndicesToHighlight = null;
        this.mChartTouchListener.setLastHighlighted(null);
        invalidate();
    }

    public void clearAllViewportJobs() {
        this.mJobs.clear();
    }

    public void clearValues() {
        this.mData.clearValues();
        invalidate();
    }

    public void disableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    protected void drawDescription(Canvas canvas) {
        float height;
        float width;
        Description description = this.mDescription;
        if (description == null || !description.isEnabled()) {
            return;
        }
        MPPointF position = this.mDescription.getPosition();
        this.mDescPaint.setTypeface(this.mDescription.getTypeface());
        this.mDescPaint.setTextSize(this.mDescription.getTextSize());
        this.mDescPaint.setColor(this.mDescription.getTextColor());
        this.mDescPaint.setTextAlign(this.mDescription.getTextAlign());
        if (position == null) {
            width = (getWidth() - this.mViewPortHandler.offsetRight()) - this.mDescription.getXOffset();
            height = (getHeight() - this.mViewPortHandler.offsetBottom()) - this.mDescription.getYOffset();
        } else {
            float f = position.x;
            height = position.y;
            width = f;
        }
        canvas.drawText(this.mDescription.getText(), width, height, this.mDescPaint);
    }

    protected void drawMarkers(Canvas canvas) {
        if (this.mMarker == null || !isDrawMarkersEnabled() || !valuesToHighlight()) {
            return;
        }
        int i = 0;
        while (true) {
            Highlight[] highlightArr = this.mIndicesToHighlight;
            if (i >= highlightArr.length) {
                return;
            }
            Highlight highlight = highlightArr[i];
            IDataSet dataSetByIndex = this.mData.getDataSetByIndex(highlight.getDataSetIndex());
            Entry entryForHighlight = this.mData.getEntryForHighlight(this.mIndicesToHighlight[i]);
            int entryIndex = dataSetByIndex.getEntryIndex(entryForHighlight);
            if (entryForHighlight != null && entryIndex <= dataSetByIndex.getEntryCount() * this.mAnimator.getPhaseX()) {
                float[] markerPosition = getMarkerPosition(highlight);
                if (this.mViewPortHandler.isInBounds(markerPosition[0], markerPosition[1])) {
                    this.mMarker.refreshContent(entryForHighlight, highlight);
                    this.mMarker.draw(canvas, markerPosition[0], markerPosition[1]);
                }
            }
            i++;
        }
    }

    public void enableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public ChartAnimator getAnimator() {
        return this.mAnimator;
    }

    public MPPointF getCenter() {
        return MPPointF.getInstance(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public MPPointF getCenterOfView() {
        return getCenter();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public MPPointF getCenterOffsets() {
        return this.mViewPortHandler.getContentCenter();
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public RectF getContentRect() {
        return this.mViewPortHandler.getContentRect();
    }

    public T getData() {
        return this.mData;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public ValueFormatter getDefaultValueFormatter() {
        return this.mDefaultValueFormatter;
    }

    public Description getDescription() {
        return this.mDescription;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.b;
    }

    public float getExtraBottomOffset() {
        return this.g;
    }

    public float getExtraLeftOffset() {
        return this.h;
    }

    public float getExtraRightOffset() {
        return this.f;
    }

    public float getExtraTopOffset() {
        return this.e;
    }

    public Highlight getHighlightByTouchPoint(float f, float f2) {
        if (this.mData != null) {
            return getHighlighter().getHighlight(f, f2);
        }
        Log.e(LOG_TAG, "Can't select by touch. No data set.");
        return null;
    }

    public Highlight[] getHighlighted() {
        return this.mIndicesToHighlight;
    }

    public IHighlighter getHighlighter() {
        return this.mHighlighter;
    }

    public ArrayList<Runnable> getJobs() {
        return this.mJobs;
    }

    public Legend getLegend() {
        return this.mLegend;
    }

    public LegendRenderer getLegendRenderer() {
        return this.mLegendRenderer;
    }

    public IMarker getMarker() {
        return this.mMarker;
    }

    protected float[] getMarkerPosition(Highlight highlight) {
        return new float[]{highlight.getDrawX(), highlight.getDrawY()};
    }

    @Deprecated
    public IMarker getMarkerView() {
        return getMarker();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getMaxHighlightDistance() {
        return this.mMaxHighlightDistance;
    }

    public OnChartGestureListener getOnChartGestureListener() {
        return this.d;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.mChartTouchListener;
    }

    public Paint getPaint(int i) {
        if (i == 7) {
            return this.mInfoPaint;
        }
        if (i != 11) {
            return null;
        }
        return this.mDescPaint;
    }

    public DataRenderer getRenderer() {
        return this.mRenderer;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.mViewPortHandler;
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXChartMax() {
        return this.mXAxis.mAxisMaximum;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXChartMin() {
        return this.mXAxis.mAxisMinimum;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXRange() {
        return this.mXAxis.mAxisRange;
    }

    public float getYMax() {
        return this.mData.getYMax();
    }

    public float getYMin() {
        return this.mData.getYMin();
    }

    public void highlightValue(float f, int i) {
        highlightValue(f, i, true);
    }

    public void highlightValues(Highlight[] highlightArr) {
        this.mIndicesToHighlight = highlightArr;
        setLastHighlighted(highlightArr);
        invalidate();
    }

    protected void init() {
        setWillNotDraw(false);
        this.mAnimator = new ChartAnimator(new a());
        Utils.init(getContext());
        this.mMaxHighlightDistance = Utils.convertDpToPixel(500.0f);
        this.mDescription = new Description();
        Legend legend = new Legend();
        this.mLegend = legend;
        this.mLegendRenderer = new LegendRenderer(this.mViewPortHandler, legend);
        this.mXAxis = new XAxis();
        this.mDescPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mInfoPaint = paint;
        paint.setColor(Color.rgb(SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER, SetRpcStruct$ComposedRpc.VALIDATE_CODE_FIELD_NUMBER, 51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        if (this.mLogEnabled) {
            Log.i("", "Chart.init()");
        }
    }

    public boolean isDragDecelerationEnabled() {
        return this.a;
    }

    @Deprecated
    public boolean isDrawMarkerViewsEnabled() {
        return isDrawMarkersEnabled();
    }

    public boolean isDrawMarkersEnabled() {
        return this.mDrawMarkers;
    }

    public boolean isEmpty() {
        T t = this.mData;
        return t == null || t.getEntryCount() <= 0;
    }

    public boolean isHighlightPerTapEnabled() {
        return this.mHighLightPerTapEnabled;
    }

    public boolean isLogEnabled() {
        return this.mLogEnabled;
    }

    public abstract void notifyDataSetChanged();

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j) {
            a(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mData == null) {
            if (!TextUtils.isEmpty(this.c)) {
                MPPointF center = getCenter();
                canvas.drawText(this.c, center.x, center.y, this.mInfoPaint);
                return;
            }
            return;
        }
        if (this.i) {
            return;
        }
        calculateOffsets();
        this.i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iConvertDpToPixel = (int) Utils.convertDpToPixel(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(iConvertDpToPixel, i)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(iConvertDpToPixel, i2)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mLogEnabled) {
            Log.i(LOG_TAG, "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            if (this.mLogEnabled) {
                Log.i(LOG_TAG, "Setting chart dimens, width: " + i + ", height: " + i2);
            }
            this.mViewPortHandler.setChartDimens(i, i2);
        } else if (this.mLogEnabled) {
            Log.w(LOG_TAG, "*Avoiding* setting chart dimens! width: " + i + ", height: " + i2);
        }
        notifyDataSetChanged();
        Iterator<Runnable> it = this.mJobs.iterator();
        while (it.hasNext()) {
            post(it.next());
        }
        this.mJobs.clear();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void removeViewportJob(Runnable runnable) {
        this.mJobs.remove(runnable);
    }

    public boolean saveToGallery(String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i) throws IOException {
        String str4;
        if (i < 0 || i > 100) {
            i = 50;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/" + str2);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        int i2 = b.a[compressFormat.ordinal()];
        if (i2 == 1) {
            str4 = "image/png";
            if (!str.endsWith(".png")) {
                str = str + ".png";
            }
        } else if (i2 != 2) {
            str4 = "image/jpeg";
            if (!str.endsWith(".jpg") && !str.endsWith(".jpeg")) {
                str = str + ".jpg";
            }
        } else {
            str4 = "image/webp";
            if (!str.endsWith(".webp")) {
                str = str + ".webp";
            }
        }
        String str5 = file.getAbsolutePath() + Separators.SLASH + str;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str5);
            getChartBitmap().compress(compressFormat, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            long length = new File(str5).length();
            ContentValues contentValues = new ContentValues(8);
            contentValues.put("title", str);
            contentValues.put("_display_name", str);
            contentValues.put("date_added", Long.valueOf(jCurrentTimeMillis));
            contentValues.put("mime_type", str4);
            contentValues.put("description", str3);
            contentValues.put("orientation", (Integer) 0);
            contentValues.put("_data", str5);
            contentValues.put("_size", Long.valueOf(length));
            return getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveToPath(String str, String str2) throws IOException {
        Bitmap chartBitmap = getChartBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + str2 + Separators.SLASH + str + ".png");
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setData(T t) {
        this.mData = t;
        this.i = false;
        if (t == null) {
            return;
        }
        setupDefaultFormatter(t.getYMin(), t.getYMax());
        for (IDataSet iDataSet : this.mData.getDataSets()) {
            if (iDataSet.needsFormatter() || iDataSet.getValueFormatter() == this.mDefaultValueFormatter) {
                iDataSet.setValueFormatter(this.mDefaultValueFormatter);
            }
        }
        notifyDataSetChanged();
        if (this.mLogEnabled) {
            Log.i(LOG_TAG, "Data is set.");
        }
    }

    public void setDescription(Description description) {
        this.mDescription = description;
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.a = z;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f >= 1.0f) {
            f = 0.999f;
        }
        this.b = f;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z) {
        setDrawMarkers(z);
    }

    public void setDrawMarkers(boolean z) {
        this.mDrawMarkers = z;
    }

    public void setExtraBottomOffset(float f) {
        this.g = Utils.convertDpToPixel(f);
    }

    public void setExtraLeftOffset(float f) {
        this.h = Utils.convertDpToPixel(f);
    }

    public void setExtraOffsets(float f, float f2, float f3, float f4) {
        setExtraLeftOffset(f);
        setExtraTopOffset(f2);
        setExtraRightOffset(f3);
        setExtraBottomOffset(f4);
    }

    public void setExtraRightOffset(float f) {
        this.f = Utils.convertDpToPixel(f);
    }

    public void setExtraTopOffset(float f) {
        this.e = Utils.convertDpToPixel(f);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.mHighLightPerTapEnabled = z;
    }

    public void setHighlighter(ChartHighlighter chartHighlighter) {
        this.mHighlighter = chartHighlighter;
    }

    protected void setLastHighlighted(Highlight[] highlightArr) {
        Highlight highlight;
        if (highlightArr == null || highlightArr.length <= 0 || (highlight = highlightArr[0]) == null) {
            this.mChartTouchListener.setLastHighlighted(null);
        } else {
            this.mChartTouchListener.setLastHighlighted(highlight);
        }
    }

    public void setLogEnabled(boolean z) {
        this.mLogEnabled = z;
    }

    public void setMarker(IMarker iMarker) {
        this.mMarker = iMarker;
    }

    @Deprecated
    public void setMarkerView(IMarker iMarker) {
        setMarker(iMarker);
    }

    public void setMaxHighlightDistance(float f) {
        this.mMaxHighlightDistance = Utils.convertDpToPixel(f);
    }

    public void setNoDataText(String str) {
        this.c = str;
    }

    public void setNoDataTextColor(int i) {
        this.mInfoPaint.setColor(i);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.mInfoPaint.setTypeface(typeface);
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.d = onChartGestureListener;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.mSelectionListener = onChartValueSelectedListener;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.mChartTouchListener = chartTouchListener;
    }

    public void setPaint(Paint paint, int i) {
        if (i == 7) {
            this.mInfoPaint = paint;
        } else {
            if (i != 11) {
                return;
            }
            this.mDescPaint = paint;
        }
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.mRenderer = dataRenderer;
        }
    }

    public void setTouchEnabled(boolean z) {
        this.mTouchEnabled = z;
    }

    public void setUnbindEnabled(boolean z) {
        this.j = z;
    }

    protected void setupDefaultFormatter(float f, float f2) {
        T t = this.mData;
        this.mDefaultValueFormatter.setup(Utils.getDecimals((t == null || t.getEntryCount() < 2) ? Math.max(Math.abs(f), Math.abs(f2)) : Math.abs(f2 - f)));
    }

    public boolean valuesToHighlight() {
        Highlight[] highlightArr = this.mIndicesToHighlight;
        return (highlightArr == null || highlightArr.length <= 0 || highlightArr[0] == null) ? false : true;
    }

    public void animateX(int i) {
        this.mAnimator.animateX(i);
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction) {
        this.mAnimator.animateXY(i, i2, easingFunction);
    }

    public void animateY(int i) {
        this.mAnimator.animateY(i);
    }

    public void highlightValue(float f, float f2, int i) {
        highlightValue(f, f2, i, true);
    }

    public void animateXY(int i, int i2) {
        this.mAnimator.animateXY(i, i2);
    }

    public void highlightValue(float f, int i, boolean z) {
        highlightValue(f, Float.NaN, i, z);
    }

    public void highlightValue(float f, float f2, int i, boolean z) {
        if (i >= 0 && i < this.mData.getDataSetCount()) {
            highlightValue(new Highlight(f, f2, i), z);
        } else {
            highlightValue((Highlight) null, z);
        }
    }

    public void highlightValue(Highlight highlight) {
        highlightValue(highlight, false);
    }

    public void highlightValue(Highlight highlight, boolean z) {
        Entry entry = null;
        if (highlight == null) {
            this.mIndicesToHighlight = null;
        } else {
            if (this.mLogEnabled) {
                Log.i(LOG_TAG, "Highlighted: " + highlight.toString());
            }
            Entry entryForHighlight = this.mData.getEntryForHighlight(highlight);
            if (entryForHighlight == null) {
                this.mIndicesToHighlight = null;
                highlight = null;
            } else {
                this.mIndicesToHighlight = new Highlight[]{highlight};
            }
            entry = entryForHighlight;
        }
        setLastHighlighted(this.mIndicesToHighlight);
        if (z && this.mSelectionListener != null) {
            if (!valuesToHighlight()) {
                this.mSelectionListener.onNothingSelected();
            } else {
                this.mSelectionListener.onValueSelected(entry, highlight);
            }
        }
        invalidate();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.a = true;
        this.b = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.c = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.j = false;
        init();
    }

    public boolean saveToGallery(String str, int i) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, i);
    }

    public boolean saveToGallery(String str) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.a = true;
        this.b = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.c = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.j = false;
        init();
    }
}
