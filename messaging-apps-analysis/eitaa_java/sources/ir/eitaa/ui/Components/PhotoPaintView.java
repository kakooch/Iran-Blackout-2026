package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Bitmaps;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$InputDocument;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker;
import ir.eitaa.tgnet.TLRPC$TL_inputDocument;
import ir.eitaa.tgnet.TLRPC$TL_maskCoords;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.BubbleActivity;
import ir.eitaa.ui.Components.Paint.Brush;
import ir.eitaa.ui.Components.Paint.Painting;
import ir.eitaa.ui.Components.Paint.PhotoFace;
import ir.eitaa.ui.Components.Paint.RenderView;
import ir.eitaa.ui.Components.Paint.Swatch;
import ir.eitaa.ui.Components.Paint.UndoStore;
import ir.eitaa.ui.Components.Paint.Views.ColorPicker;
import ir.eitaa.ui.Components.Paint.Views.EntitiesContainerView;
import ir.eitaa.ui.Components.Paint.Views.EntityView;
import ir.eitaa.ui.Components.Paint.Views.StickerView;
import ir.eitaa.ui.Components.Paint.Views.TextPaintView;
import ir.eitaa.ui.Components.StickerMasksAlert;
import ir.eitaa.ui.PhotoViewer;
import java.math.BigInteger;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class PhotoPaintView extends FrameLayout implements EntityView.EntityViewDelegate {
    private float baseScale;
    private Bitmap bitmapToEdit;
    private Swatch brushSwatch;
    private Brush[] brushes;
    private TextView cancelTextView;
    private ir.eitaa.ui.Components.Paint.Views.ColorPicker colorPicker;
    int currentBrush;
    private MediaController.CropState currentCropState;
    private EntityView currentEntityView;
    private FrameLayout curtainView;
    private FrameLayout dimView;
    private TextView doneTextView;
    private Point editedTextPosition;
    private float editedTextRotation;
    private float editedTextScale;
    private boolean editingText;
    private EntitiesContainerView entitiesView;
    private ArrayList<PhotoFace> faces;
    private Bitmap facesBitmap;
    private boolean ignoreLayout;
    private boolean inBubbleMode;
    private String initialText;
    private BigInteger lcm;
    private int originalBitmapRotation;
    private ImageView paintButton;
    private Size paintingSize;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout popupLayout;
    private android.graphics.Rect popupRect;
    private ActionBarPopupWindow popupWindow;
    private int[] pos;
    private DispatchQueue queue;
    private RenderView renderView;
    private final Theme.ResourcesProvider resourcesProvider;
    private int selectedTextType;
    private FrameLayout selectionContainerView;
    private float[] temp;
    private FrameLayout textDimView;
    private FrameLayout toolsView;
    private float transformX;
    private float transformY;
    private UndoStore undoStore;

    protected void didSetAnimatedSticker(RLottieDrawable drawable) {
    }

    protected void onOpenCloseStickersAlert(boolean open) {
    }

    protected void onTextAdd() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoPaintView(Context context, Bitmap bitmap, Bitmap bitmap2, int i, ArrayList<VideoEditedInfo.MediaEntity> arrayList, MediaController.CropState cropState, final Runnable runnable, Theme.ResourcesProvider resourcesProvider) {
        TextPaintView textPaintView;
        super(context);
        this.brushes = new Brush[]{new Brush.Radial(), new Brush.Elliptical(), new Brush.Neon(), new Brush.Arrow()};
        this.temp = new float[2];
        this.selectedTextType = 2;
        this.pos = new int[2];
        this.resourcesProvider = resourcesProvider;
        this.inBubbleMode = context instanceof BubbleActivity;
        this.currentCropState = cropState;
        this.queue = new DispatchQueue("Paint");
        this.originalBitmapRotation = i;
        this.bitmapToEdit = bitmap;
        this.facesBitmap = bitmap2;
        UndoStore undoStore = new UndoStore();
        this.undoStore = undoStore;
        undoStore.setDelegate(new UndoStore.UndoStoreDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$L_xyvAcbuTdd96f3Fn_dCZOsgEw
            @Override // ir.eitaa.ui.Components.Paint.UndoStore.UndoStoreDelegate
            public final void historyChanged() {
                this.f$0.lambda$new$0$PhotoPaintView();
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.curtainView = frameLayout;
        frameLayout.setBackgroundColor(570425344);
        this.curtainView.setVisibility(4);
        addView(this.curtainView, LayoutHelper.createFrame(-1, -1.0f));
        RenderView renderView = new RenderView(context, new Painting(getPaintingSize()), bitmap);
        this.renderView = renderView;
        renderView.setDelegate(new RenderView.RenderViewDelegate() { // from class: ir.eitaa.ui.Components.PhotoPaintView.1
            @Override // ir.eitaa.ui.Components.Paint.RenderView.RenderViewDelegate
            public void onFirstDraw() {
                runnable.run();
            }

            @Override // ir.eitaa.ui.Components.Paint.RenderView.RenderViewDelegate
            public void onBeganDrawing() {
                if (PhotoPaintView.this.currentEntityView != null) {
                    PhotoPaintView.this.selectEntity(null);
                }
            }

            @Override // ir.eitaa.ui.Components.Paint.RenderView.RenderViewDelegate
            public void onFinishedDrawing(boolean moved) {
                PhotoPaintView.this.colorPicker.setUndoEnabled(PhotoPaintView.this.undoStore.canUndo());
            }

            @Override // ir.eitaa.ui.Components.Paint.RenderView.RenderViewDelegate
            public boolean shouldDraw() {
                boolean z = PhotoPaintView.this.currentEntityView == null;
                if (!z) {
                    PhotoPaintView.this.selectEntity(null);
                }
                return z;
            }
        });
        this.renderView.setUndoStore(this.undoStore);
        this.renderView.setQueue(this.queue);
        this.renderView.setVisibility(4);
        this.renderView.setBrush(this.brushes[0]);
        addView(this.renderView, LayoutHelper.createFrame(-1, -1, 51));
        EntitiesContainerView entitiesContainerView = new EntitiesContainerView(context, new EntitiesContainerView.EntitiesContainerViewDelegate() { // from class: ir.eitaa.ui.Components.PhotoPaintView.2
            @Override // ir.eitaa.ui.Components.Paint.Views.EntitiesContainerView.EntitiesContainerViewDelegate
            public boolean shouldReceiveTouches() {
                return PhotoPaintView.this.textDimView.getVisibility() != 0;
            }

            @Override // ir.eitaa.ui.Components.Paint.Views.EntitiesContainerView.EntitiesContainerViewDelegate
            public EntityView onSelectedEntityRequest() {
                return PhotoPaintView.this.currentEntityView;
            }

            @Override // ir.eitaa.ui.Components.Paint.Views.EntitiesContainerView.EntitiesContainerViewDelegate
            public void onEntityDeselect() {
                PhotoPaintView.this.selectEntity(null);
            }
        });
        this.entitiesView = entitiesContainerView;
        addView(entitiesContainerView);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.dimView = frameLayout2;
        frameLayout2.setAlpha(0.0f);
        this.dimView.setBackgroundColor(1711276032);
        this.dimView.setVisibility(8);
        addView(this.dimView);
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.textDimView = frameLayout3;
        frameLayout3.setAlpha(0.0f);
        this.textDimView.setBackgroundColor(1711276032);
        this.textDimView.setVisibility(8);
        this.textDimView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$6vGCjzLvTieosIFUxP74Yfao5rA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$PhotoPaintView(view);
            }
        });
        FrameLayout frameLayout4 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.PhotoPaintView.3
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                return false;
            }
        };
        this.selectionContainerView = frameLayout4;
        addView(frameLayout4);
        ir.eitaa.ui.Components.Paint.Views.ColorPicker colorPicker = new ir.eitaa.ui.Components.Paint.Views.ColorPicker(context);
        this.colorPicker = colorPicker;
        addView(colorPicker);
        this.colorPicker.setDelegate(new ColorPicker.ColorPickerDelegate() { // from class: ir.eitaa.ui.Components.PhotoPaintView.4
            @Override // ir.eitaa.ui.Components.Paint.Views.ColorPicker.ColorPickerDelegate
            public void onBeganColorPicking() {
                if (PhotoPaintView.this.currentEntityView instanceof TextPaintView) {
                    return;
                }
                PhotoPaintView.this.setDimVisibility(true);
            }

            @Override // ir.eitaa.ui.Components.Paint.Views.ColorPicker.ColorPickerDelegate
            public void onColorValueChanged() {
                PhotoPaintView photoPaintView = PhotoPaintView.this;
                photoPaintView.setCurrentSwatch(photoPaintView.colorPicker.getSwatch(), false);
            }

            @Override // ir.eitaa.ui.Components.Paint.Views.ColorPicker.ColorPickerDelegate
            public void onFinishedColorPicking() {
                PhotoPaintView photoPaintView = PhotoPaintView.this;
                photoPaintView.setCurrentSwatch(photoPaintView.colorPicker.getSwatch(), false);
                if (PhotoPaintView.this.currentEntityView instanceof TextPaintView) {
                    return;
                }
                PhotoPaintView.this.setDimVisibility(false);
            }

            @Override // ir.eitaa.ui.Components.Paint.Views.ColorPicker.ColorPickerDelegate
            public void onSettingsPressed() {
                if (PhotoPaintView.this.currentEntityView != null) {
                    if (PhotoPaintView.this.currentEntityView instanceof StickerView) {
                        PhotoPaintView.this.mirrorSticker();
                        return;
                    } else {
                        if (PhotoPaintView.this.currentEntityView instanceof TextPaintView) {
                            PhotoPaintView.this.showTextSettings();
                            return;
                        }
                        return;
                    }
                }
                PhotoPaintView.this.showBrushSettings();
            }

            @Override // ir.eitaa.ui.Components.Paint.Views.ColorPicker.ColorPickerDelegate
            public void onUndoPressed() {
                PhotoPaintView.this.undoStore.undo();
            }
        });
        FrameLayout frameLayout5 = new FrameLayout(context);
        this.toolsView = frameLayout5;
        frameLayout5.setBackgroundColor(-16777216);
        addView(this.toolsView, LayoutHelper.createFrame(-1, 48, 83));
        TextView textView = new TextView(context);
        this.cancelTextView = textView;
        textView.setTextSize(1, 14.0f);
        this.cancelTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.cancelTextView.setTextColor(-1);
        this.cancelTextView.setGravity(17);
        this.cancelTextView.setBackgroundDrawable(Theme.createSelectorDrawable(-12763843, 0));
        this.cancelTextView.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.cancelTextView.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
        this.cancelTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.toolsView.addView(this.cancelTextView, LayoutHelper.createFrame(-2, -1, 51));
        TextView textView2 = new TextView(context);
        this.doneTextView = textView2;
        textView2.setTextSize(1, 14.0f);
        this.doneTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.doneTextView.setTextColor(getThemedColor("dialogFloatingButton"));
        this.doneTextView.setGravity(17);
        this.doneTextView.setBackgroundDrawable(Theme.createSelectorDrawable(-12763843, 0));
        this.doneTextView.setPadding(AndroidUtilities.dp(20.0f), 0, AndroidUtilities.dp(20.0f), 0);
        this.doneTextView.setText(LocaleController.getString("Done", R.string.Done).toUpperCase());
        this.doneTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.toolsView.addView(this.doneTextView, LayoutHelper.createFrame(-2, -1, 53));
        ImageView imageView = new ImageView(context);
        this.paintButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.paintButton.setImageResource(R.drawable.photo_paint);
        this.paintButton.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.toolsView.addView(this.paintButton, LayoutHelper.createFrame(54, -1.0f, 17, 0.0f, 0.0f, 56.0f, 0.0f));
        this.paintButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$31fo6JA-V0z9kfWxj9YFOYN6SS8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$2$PhotoPaintView(view);
            }
        });
        ImageView imageView2 = new ImageView(context);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageResource(R.drawable.photo_sticker);
        imageView2.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.toolsView.addView(imageView2, LayoutHelper.createFrame(54, -1, 17));
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$dXJjb6AWEukei3MtH-pHu-9cKfE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$3$PhotoPaintView(view);
            }
        });
        ImageView imageView3 = new ImageView(context);
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        imageView3.setImageResource(R.drawable.photo_paint_text);
        imageView3.setBackgroundDrawable(Theme.createSelectorDrawable(1090519039));
        this.toolsView.addView(imageView3, LayoutHelper.createFrame(54, -1.0f, 17, 56.0f, 0.0f, 0.0f, 0.0f));
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$Lohgo6aPAEdVOLSUsdWSLgkdwNQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$4$PhotoPaintView(view);
            }
        });
        this.colorPicker.setUndoEnabled(false);
        setCurrentSwatch(this.colorPicker.getSwatch(), false);
        updateSettingsButton();
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                VideoEditedInfo.MediaEntity mediaEntity = arrayList.get(i2);
                byte b = mediaEntity.type;
                if (b == 0) {
                    StickerView stickerViewCreateSticker = createSticker(mediaEntity.parentObject, mediaEntity.document, false);
                    if ((mediaEntity.subType & 2) != 0) {
                        stickerViewCreateSticker.mirror();
                    }
                    ViewGroup.LayoutParams layoutParams = stickerViewCreateSticker.getLayoutParams();
                    layoutParams.width = mediaEntity.viewWidth;
                    layoutParams.height = mediaEntity.viewHeight;
                    textPaintView = stickerViewCreateSticker;
                } else if (b == 1) {
                    TextPaintView textPaintViewCreateText = createText(false);
                    byte b2 = mediaEntity.subType;
                    textPaintViewCreateText.setType((b2 & 1) != 0 ? 0 : (b2 & 4) != 0 ? 2 : 1);
                    textPaintViewCreateText.setText(mediaEntity.text);
                    Swatch swatch = textPaintViewCreateText.getSwatch();
                    swatch.color = mediaEntity.color;
                    textPaintViewCreateText.setSwatch(swatch);
                    textPaintView = textPaintViewCreateText;
                }
                textPaintView.setX((mediaEntity.x * this.paintingSize.width) - ((mediaEntity.viewWidth * (1.0f - mediaEntity.scale)) / 2.0f));
                textPaintView.setY((mediaEntity.y * this.paintingSize.height) - ((mediaEntity.viewHeight * (1.0f - mediaEntity.scale)) / 2.0f));
                textPaintView.setPosition(new Point(textPaintView.getX() + (mediaEntity.viewWidth / 2), textPaintView.getY() + (mediaEntity.viewHeight / 2)));
                textPaintView.setScaleX(mediaEntity.scale);
                textPaintView.setScaleY(mediaEntity.scale);
                double d = -mediaEntity.rotation;
                Double.isNaN(d);
                textPaintView.setRotation((float) ((d / 3.141592653589793d) * 180.0d));
            }
        }
        this.entitiesView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$PhotoPaintView() {
        this.colorPicker.setUndoEnabled(this.undoStore.canUndo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$PhotoPaintView(View view) {
        closeTextEnter(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$PhotoPaintView(View view) {
        selectEntity(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$PhotoPaintView(View view) {
        openStickersView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$PhotoPaintView(View view) {
        createText(true);
    }

    public void onResume() {
        this.renderView.redraw();
    }

    public boolean onTouch(MotionEvent ev) {
        if (this.currentEntityView != null) {
            if (this.editingText) {
                closeTextEnter(true);
            } else {
                selectEntity(null);
            }
        }
        float x = ((ev.getX() - this.renderView.getTranslationX()) - (getMeasuredWidth() / 2)) / this.renderView.getScaleX();
        float y = (((ev.getY() - this.renderView.getTranslationY()) - (getMeasuredHeight() / 2)) + AndroidUtilities.dp(32.0f)) / this.renderView.getScaleY();
        double d = x;
        double radians = (float) Math.toRadians(-this.renderView.getRotation());
        double dCos = Math.cos(radians);
        Double.isNaN(d);
        double d2 = y;
        double dSin = Math.sin(radians);
        Double.isNaN(d2);
        float measuredWidth = ((float) ((dCos * d) - (dSin * d2))) + (this.renderView.getMeasuredWidth() / 2);
        double dSin2 = Math.sin(radians);
        Double.isNaN(d);
        double dCos2 = Math.cos(radians);
        Double.isNaN(d2);
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, ev.getActionMasked(), measuredWidth, ((float) ((d * dSin2) + (d2 * dCos2))) + (this.renderView.getMeasuredHeight() / 2), 0);
        this.renderView.onTouch(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    private Size getPaintingSize() {
        Size size = this.paintingSize;
        if (size != null) {
            return size;
        }
        Size size2 = new Size(this.bitmapToEdit.getWidth(), this.bitmapToEdit.getHeight());
        size2.width = 1280.0f;
        float fFloor = (float) Math.floor((1280.0f * r1) / r0);
        size2.height = fFloor;
        if (fFloor > 1280.0f) {
            size2.height = 1280.0f;
            size2.width = (float) Math.floor((1280.0f * r0) / r1);
        }
        this.paintingSize = size2;
        return size2;
    }

    private void updateSettingsButton() {
        EntityView entityView = this.currentEntityView;
        int i = R.drawable.photo_paint_brush;
        if (entityView != null) {
            if (entityView instanceof StickerView) {
                i = R.drawable.photo_flip;
            } else if (entityView instanceof TextPaintView) {
                i = R.drawable.photo_outline;
            }
            this.paintButton.setImageResource(R.drawable.photo_paint);
            this.paintButton.setColorFilter((ColorFilter) null);
        } else {
            Swatch swatch = this.brushSwatch;
            if (swatch != null) {
                setCurrentSwatch(swatch, true);
                this.brushSwatch = null;
            }
            this.paintButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogFloatingButton"), PorterDuff.Mode.MULTIPLY));
            this.paintButton.setImageResource(R.drawable.photo_paint);
        }
        this.colorPicker.setSettingsButtonImage(i);
    }

    public void updateColors() {
        ImageView imageView = this.paintButton;
        if (imageView != null && imageView.getColorFilter() != null) {
            this.paintButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogFloatingButton"), PorterDuff.Mode.MULTIPLY));
        }
        TextView textView = this.doneTextView;
        if (textView != null) {
            textView.setTextColor(getThemedColor("dialogFloatingButton"));
        }
    }

    public void init() {
        this.entitiesView.setVisibility(0);
        this.renderView.setVisibility(0);
        if (this.facesBitmap != null) {
            detectFaces();
        }
    }

    public void shutdown() {
        this.renderView.shutdown();
        this.entitiesView.setVisibility(8);
        this.selectionContainerView.setVisibility(8);
        this.queue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$Z0cIMMQLk0Hlea9NnxtPEdB2bO8
            @Override // java.lang.Runnable
            public final void run() {
                PhotoPaintView.lambda$shutdown$5();
            }
        });
    }

    static /* synthetic */ void lambda$shutdown$5() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            looperMyLooper.quit();
        }
    }

    public FrameLayout getToolsView() {
        return this.toolsView;
    }

    public FrameLayout getCurtainView() {
        return this.curtainView;
    }

    public TextView getDoneTextView() {
        return this.doneTextView;
    }

    public TextView getCancelTextView() {
        return this.cancelTextView;
    }

    public ir.eitaa.ui.Components.Paint.Views.ColorPicker getColorPicker() {
        return this.colorPicker;
    }

    public boolean hasChanges() {
        return this.undoStore.canUndo();
    }

    public Bitmap getBitmap(ArrayList<VideoEditedInfo.MediaEntity> entities, Bitmap[] thumbBitmap) {
        int i;
        Bitmap resultBitmap = this.renderView.getResultBitmap();
        this.lcm = BigInteger.ONE;
        if (resultBitmap != null && this.entitiesView.entitiesCount() > 0) {
            int childCount = this.entitiesView.getChildCount();
            byte b = 0;
            Canvas canvas = null;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.entitiesView.getChildAt(i2);
                if (childAt instanceof EntityView) {
                    EntityView entityView = (EntityView) childAt;
                    Point position = entityView.getPosition();
                    if (entities != null) {
                        VideoEditedInfo.MediaEntity mediaEntity = new VideoEditedInfo.MediaEntity();
                        if (entityView instanceof TextPaintView) {
                            mediaEntity.type = (byte) 1;
                            TextPaintView textPaintView = (TextPaintView) entityView;
                            mediaEntity.text = textPaintView.getText();
                            int type = textPaintView.getType();
                            if (type == 0) {
                                mediaEntity.subType = (byte) (1 | mediaEntity.subType);
                            } else if (type == 2) {
                                mediaEntity.subType = (byte) (mediaEntity.subType | 4);
                            }
                            mediaEntity.color = textPaintView.getSwatch().color;
                            mediaEntity.fontSize = textPaintView.getTextSize();
                        } else {
                            if (entityView instanceof StickerView) {
                                mediaEntity.type = b;
                                StickerView stickerView = (StickerView) entityView;
                                Size baseSize = stickerView.getBaseSize();
                                mediaEntity.width = baseSize.width;
                                mediaEntity.height = baseSize.height;
                                mediaEntity.document = stickerView.getSticker();
                                mediaEntity.parentObject = stickerView.getParentObject();
                                TLRPC$Document sticker = stickerView.getSticker();
                                mediaEntity.text = FileLoader.getPathToAttach(sticker, true).getAbsolutePath();
                                if (MessageObject.isAnimatedStickerDocument(sticker, true)) {
                                    mediaEntity.subType = (byte) (mediaEntity.subType | 1);
                                    long duration = stickerView.getDuration();
                                    if (duration != 0) {
                                        BigInteger bigIntegerValueOf = BigInteger.valueOf(duration);
                                        this.lcm = this.lcm.multiply(bigIntegerValueOf).divide(this.lcm.gcd(bigIntegerValueOf));
                                    }
                                }
                                if (stickerView.isMirrored()) {
                                    mediaEntity.subType = (byte) (mediaEntity.subType | 2);
                                }
                            }
                            i = i2;
                        }
                        entities.add(mediaEntity);
                        float scaleX = childAt.getScaleX();
                        float scaleY = childAt.getScaleY();
                        float x = childAt.getX();
                        float y = childAt.getY();
                        mediaEntity.viewWidth = childAt.getWidth();
                        mediaEntity.viewHeight = childAt.getHeight();
                        mediaEntity.width = (childAt.getWidth() * scaleX) / this.entitiesView.getMeasuredWidth();
                        mediaEntity.height = (childAt.getHeight() * scaleY) / this.entitiesView.getMeasuredHeight();
                        mediaEntity.x = (((childAt.getWidth() * (1.0f - scaleX)) / 2.0f) + x) / this.entitiesView.getMeasuredWidth();
                        mediaEntity.y = (((childAt.getHeight() * (1.0f - scaleY)) / 2.0f) + y) / this.entitiesView.getMeasuredHeight();
                        i = i2;
                        double d = -childAt.getRotation();
                        Double.isNaN(d);
                        mediaEntity.rotation = (float) (d * 0.017453292519943295d);
                        mediaEntity.textViewX = (x + (childAt.getWidth() / 2)) / this.entitiesView.getMeasuredWidth();
                        mediaEntity.textViewY = (y + (childAt.getHeight() / 2)) / this.entitiesView.getMeasuredHeight();
                        mediaEntity.textViewWidth = mediaEntity.viewWidth / this.entitiesView.getMeasuredWidth();
                        mediaEntity.textViewHeight = mediaEntity.viewHeight / this.entitiesView.getMeasuredHeight();
                        mediaEntity.scale = scaleX;
                        if (thumbBitmap[0] == null) {
                            thumbBitmap[0] = Bitmap.createBitmap(resultBitmap.getWidth(), resultBitmap.getHeight(), resultBitmap.getConfig());
                            canvas = new Canvas(thumbBitmap[0]);
                            canvas.drawBitmap(resultBitmap, 0.0f, 0.0f, (Paint) null);
                        }
                    } else {
                        i = i2;
                    }
                    if (canvas == null) {
                        canvas = new Canvas(resultBitmap);
                    }
                    Canvas canvas2 = canvas;
                    canvas2.save();
                    canvas2.translate(position.x, position.y);
                    canvas2.scale(childAt.getScaleX(), childAt.getScaleY());
                    canvas2.rotate(childAt.getRotation());
                    canvas2.translate((-entityView.getWidth()) / 2, (-entityView.getHeight()) / 2);
                    if (childAt instanceof TextPaintView) {
                        Bitmap bitmapCreateBitmap = Bitmaps.createBitmap(childAt.getWidth(), childAt.getHeight(), Bitmap.Config.ARGB_8888);
                        Canvas canvas3 = new Canvas(bitmapCreateBitmap);
                        childAt.draw(canvas3);
                        canvas2.drawBitmap(bitmapCreateBitmap, (android.graphics.Rect) null, new android.graphics.Rect(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight()), (Paint) null);
                        try {
                            canvas3.setBitmap(null);
                        } catch (Exception e) {
                            FileLog.e(e);
                        }
                        bitmapCreateBitmap.recycle();
                    } else {
                        childAt.draw(canvas2);
                    }
                    canvas2.restore();
                    canvas = canvas2;
                } else {
                    i = i2;
                }
                i2 = i + 1;
                b = 0;
            }
        }
        return resultBitmap;
    }

    public long getLcm() {
        return this.lcm.longValue();
    }

    public void maybeShowDismissalAlert(PhotoViewer photoViewer, Activity parentActivity, final Runnable okRunnable) {
        if (this.editingText) {
            closeTextEnter(false);
            return;
        }
        if (!hasChanges()) {
            okRunnable.run();
            return;
        }
        if (parentActivity == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        builder.setMessage(LocaleController.getString("PhotoEditorDiscardAlert", R.string.PhotoEditorDiscardAlert));
        builder.setTitle(LocaleController.getString("DiscardChanges", R.string.DiscardChanges));
        builder.setPositiveButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$ELmI-Mx3bRRkXaRjuJa_Utdgwh8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                okRunnable.run();
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        photoViewer.showAlertDialog(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentSwatch(Swatch swatch, boolean updateInterface) {
        this.renderView.setColor(swatch.color);
        this.renderView.setBrushSize(swatch.brushWeight);
        if (updateInterface) {
            if (this.brushSwatch == null && this.paintButton.getColorFilter() != null) {
                this.brushSwatch = this.colorPicker.getSwatch();
            }
            this.colorPicker.setSwatch(swatch);
        }
        EntityView entityView = this.currentEntityView;
        if (entityView instanceof TextPaintView) {
            ((TextPaintView) entityView).setSwatch(swatch);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDimVisibility(final boolean visible) {
        ObjectAnimator objectAnimatorOfFloat;
        if (visible) {
            this.dimView.setVisibility(0);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.dimView, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.dimView, (Property<FrameLayout, Float>) View.ALPHA, 1.0f, 0.0f);
        }
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PhotoPaintView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (visible) {
                    return;
                }
                PhotoPaintView.this.dimView.setVisibility(8);
            }
        });
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    private void setTextDimVisibility(final boolean visible, EntityView view) {
        ObjectAnimator objectAnimatorOfFloat;
        if (visible && view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (this.textDimView.getParent() != null) {
                ((EntitiesContainerView) this.textDimView.getParent()).removeView(this.textDimView);
            }
            viewGroup.addView(this.textDimView, viewGroup.indexOfChild(view));
        }
        view.setSelectionVisibility(!visible);
        if (visible) {
            this.textDimView.setVisibility(0);
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.textDimView, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.textDimView, (Property<FrameLayout, Float>) View.ALPHA, 1.0f, 0.0f);
        }
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PhotoPaintView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (visible) {
                    return;
                }
                PhotoPaintView.this.textDimView.setVisibility(8);
                if (PhotoPaintView.this.textDimView.getParent() != null) {
                    ((EntitiesContainerView) PhotoPaintView.this.textDimView.getParent()).removeView(PhotoPaintView.this.textDimView);
                }
            }
        });
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float currentActionBarHeight;
        float width;
        this.ignoreLayout = true;
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(size, size2);
        int currentActionBarHeight2 = (AndroidUtilities.displaySize.y - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.dp(48.0f);
        Bitmap bitmap = this.bitmapToEdit;
        if (bitmap != null) {
            width = bitmap.getWidth();
            currentActionBarHeight = this.bitmapToEdit.getHeight();
        } else {
            currentActionBarHeight = (size2 - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.dp(48.0f);
            width = size;
        }
        float fFloor = size;
        float fFloor2 = (float) Math.floor((fFloor * currentActionBarHeight) / width);
        float f = currentActionBarHeight2;
        if (fFloor2 > f) {
            fFloor = (float) Math.floor((width * f) / currentActionBarHeight);
            fFloor2 = f;
        }
        int i = (int) fFloor;
        int i2 = (int) fFloor2;
        this.renderView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        float f2 = fFloor / this.paintingSize.width;
        this.baseScale = f2;
        this.entitiesView.setScaleX(f2);
        this.entitiesView.setScaleY(this.baseScale);
        this.entitiesView.measure(View.MeasureSpec.makeMeasureSpec((int) this.paintingSize.width, 1073741824), View.MeasureSpec.makeMeasureSpec((int) this.paintingSize.height, 1073741824));
        this.dimView.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(currentActionBarHeight2, Integer.MIN_VALUE));
        EntityView entityView = this.currentEntityView;
        if (entityView != null) {
            entityView.updateSelectionView();
        }
        this.selectionContainerView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        this.colorPicker.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(currentActionBarHeight2, 1073741824));
        this.toolsView.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
        this.curtainView.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(currentActionBarHeight2, 1073741824));
        this.ignoreLayout = false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = right - left;
        int i2 = bottom - top;
        int i3 = (Build.VERSION.SDK_INT < 21 || this.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight;
        int currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + i3;
        int i4 = AndroidUtilities.displaySize.y;
        AndroidUtilities.dp(48.0f);
        int iCeil = (int) Math.ceil((i - this.renderView.getMeasuredWidth()) / 2);
        int iDp = ((((i2 - currentActionBarHeight) - AndroidUtilities.dp(48.0f)) - this.renderView.getMeasuredHeight()) / 2) + AndroidUtilities.dp(8.0f) + i3;
        RenderView renderView = this.renderView;
        renderView.layout(iCeil, iDp, renderView.getMeasuredWidth() + iCeil, this.renderView.getMeasuredHeight() + iDp);
        int measuredWidth = ((this.renderView.getMeasuredWidth() - this.entitiesView.getMeasuredWidth()) / 2) + iCeil;
        int measuredHeight = ((this.renderView.getMeasuredHeight() - this.entitiesView.getMeasuredHeight()) / 2) + iDp;
        EntitiesContainerView entitiesContainerView = this.entitiesView;
        entitiesContainerView.layout(measuredWidth, measuredHeight, entitiesContainerView.getMeasuredWidth() + measuredWidth, this.entitiesView.getMeasuredHeight() + measuredHeight);
        FrameLayout frameLayout = this.dimView;
        frameLayout.layout(0, i3, frameLayout.getMeasuredWidth(), this.dimView.getMeasuredHeight() + i3);
        FrameLayout frameLayout2 = this.selectionContainerView;
        frameLayout2.layout(iCeil, iDp, frameLayout2.getMeasuredWidth() + iCeil, this.selectionContainerView.getMeasuredHeight() + iDp);
        ir.eitaa.ui.Components.Paint.Views.ColorPicker colorPicker = this.colorPicker;
        colorPicker.layout(0, currentActionBarHeight, colorPicker.getMeasuredWidth(), this.colorPicker.getMeasuredHeight() + currentActionBarHeight);
        FrameLayout frameLayout3 = this.toolsView;
        frameLayout3.layout(0, i2 - frameLayout3.getMeasuredHeight(), this.toolsView.getMeasuredWidth(), i2);
        FrameLayout frameLayout4 = this.curtainView;
        frameLayout4.layout(0, iDp, frameLayout4.getMeasuredWidth(), this.curtainView.getMeasuredHeight() + iDp);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.EntityView.EntityViewDelegate
    public boolean onEntitySelected(EntityView entityView) {
        return selectEntity(entityView);
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.EntityView.EntityViewDelegate
    public boolean onEntityLongClicked(EntityView entityView) {
        showMenuForEntity(entityView);
        return true;
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.EntityView.EntityViewDelegate
    public float[] getTransformedTouch(float x, float y) {
        android.graphics.Point point = AndroidUtilities.displaySize;
        float f = x - (point.x / 2);
        float f2 = y - (point.y / 2);
        float radians = (float) Math.toRadians(-this.entitiesView.getRotation());
        float[] fArr = this.temp;
        double d = f;
        double d2 = radians;
        double dCos = Math.cos(d2);
        Double.isNaN(d);
        double d3 = f2;
        double dSin = Math.sin(d2);
        Double.isNaN(d3);
        fArr[0] = ((float) ((dCos * d) - (dSin * d3))) + (AndroidUtilities.displaySize.x / 2);
        float[] fArr2 = this.temp;
        double dSin2 = Math.sin(d2);
        Double.isNaN(d);
        double dCos2 = Math.cos(d2);
        Double.isNaN(d3);
        fArr2[1] = ((float) ((d * dSin2) + (d3 * dCos2))) + (AndroidUtilities.displaySize.y / 2);
        return this.temp;
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.EntityView.EntityViewDelegate
    public int[] getCenterLocation(EntityView entityView) {
        return getCenterLocationInWindow(entityView);
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.EntityView.EntityViewDelegate
    public boolean allowInteraction(EntityView entityView) {
        return !this.editingText;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        int i = 0;
        if ((child == this.renderView || child == this.entitiesView || child == this.selectionContainerView) && this.currentCropState != null) {
            canvas.save();
            if (Build.VERSION.SDK_INT >= 21 && !this.inBubbleMode) {
                i = AndroidUtilities.statusBarHeight;
            }
            int currentActionBarHeight = ActionBar.getCurrentActionBarHeight() + i;
            int measuredWidth = child.getMeasuredWidth();
            int measuredHeight = child.getMeasuredHeight();
            MediaController.CropState cropState = this.currentCropState;
            int i2 = cropState.transformRotation;
            if (i2 == 90 || i2 == 270) {
                measuredHeight = measuredWidth;
                measuredWidth = measuredHeight;
            }
            float scaleX = measuredWidth * cropState.cropPw * child.getScaleX();
            MediaController.CropState cropState2 = this.currentCropState;
            int i3 = (int) (scaleX / cropState2.cropScale);
            int scaleY = (int) (((measuredHeight * cropState2.cropPh) * child.getScaleY()) / this.currentCropState.cropScale);
            float fCeil = ((float) Math.ceil((getMeasuredWidth() - i3) / 2)) + this.transformX;
            float measuredHeight2 = ((((getMeasuredHeight() - currentActionBarHeight) - AndroidUtilities.dp(48.0f)) - scaleY) / 2) + AndroidUtilities.dp(8.0f) + i + this.transformY;
            canvas.clipRect(Math.max(0.0f, fCeil), Math.max(0.0f, measuredHeight2), Math.min(fCeil + i3, getMeasuredWidth()), Math.min(getMeasuredHeight(), measuredHeight2 + scaleY));
            i = 1;
        }
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        if (i != 0) {
            canvas.restore();
        }
        return zDrawChild;
    }

    private Point centerPositionForEntity() {
        Size paintingSize = getPaintingSize();
        float f = paintingSize.width / 2.0f;
        float f2 = paintingSize.height / 2.0f;
        if (this.currentCropState != null) {
            float radians = (float) Math.toRadians(-(r2.transformRotation + r2.cropRotate));
            double d = this.currentCropState.cropPx;
            double d2 = radians;
            double dCos = Math.cos(d2);
            Double.isNaN(d);
            double d3 = d * dCos;
            double d4 = this.currentCropState.cropPy;
            double dSin = Math.sin(d2);
            Double.isNaN(d4);
            float f3 = (float) (d3 - (d4 * dSin));
            double d5 = this.currentCropState.cropPx;
            double dSin2 = Math.sin(d2);
            Double.isNaN(d5);
            double d6 = d5 * dSin2;
            double d7 = this.currentCropState.cropPy;
            double dCos2 = Math.cos(d2);
            Double.isNaN(d7);
            f -= f3 * paintingSize.width;
            f2 -= ((float) (d6 + (d7 * dCos2))) * paintingSize.height;
        }
        return new Point(f, f2);
    }

    private Point startPositionRelativeToEntity(EntityView entityView) {
        MediaController.CropState cropState = this.currentCropState;
        float f = cropState != null ? 200.0f / cropState.cropScale : 200.0f;
        if (entityView != null) {
            Point position = entityView.getPosition();
            return new Point(position.x + f, position.y + f);
        }
        float f2 = cropState != null ? 100.0f / cropState.cropScale : 100.0f;
        Point pointCenterPositionForEntity = centerPositionForEntity();
        while (true) {
            boolean z = false;
            for (int i = 0; i < this.entitiesView.getChildCount(); i++) {
                View childAt = this.entitiesView.getChildAt(i);
                if (childAt instanceof EntityView) {
                    Point position2 = ((EntityView) childAt).getPosition();
                    if (((float) Math.sqrt(Math.pow(position2.x - pointCenterPositionForEntity.x, 2.0d) + Math.pow(position2.y - pointCenterPositionForEntity.y, 2.0d))) < f2) {
                        z = true;
                    }
                }
            }
            if (!z) {
                return pointCenterPositionForEntity;
            }
            pointCenterPositionForEntity = new Point(pointCenterPositionForEntity.x + f, pointCenterPositionForEntity.y + f);
        }
    }

    public ArrayList<TLRPC$InputDocument> getMasks() {
        int childCount = this.entitiesView.getChildCount();
        ArrayList<TLRPC$InputDocument> arrayList = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.entitiesView.getChildAt(i);
            if (childAt instanceof StickerView) {
                TLRPC$Document sticker = ((StickerView) childAt).getSticker();
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                TLRPC$TL_inputDocument tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
                tLRPC$TL_inputDocument.id = sticker.id;
                tLRPC$TL_inputDocument.access_hash = sticker.access_hash;
                byte[] bArr = sticker.file_reference;
                tLRPC$TL_inputDocument.file_reference = bArr;
                if (bArr == null) {
                    tLRPC$TL_inputDocument.file_reference = new byte[0];
                }
                arrayList.add(tLRPC$TL_inputDocument);
            }
        }
        return arrayList;
    }

    public void setTransform(float scale, float trX, float trY, float imageWidth, float imageHeight) {
        View view;
        float f;
        float f2;
        float f3;
        float f4;
        this.transformX = trX;
        this.transformY = trY;
        int i = 0;
        while (i < 3) {
            if (i == 0) {
                view = this.entitiesView;
            } else if (i == 1) {
                view = this.selectionContainerView;
            } else {
                view = this.renderView;
            }
            MediaController.CropState cropState = this.currentCropState;
            if (cropState != null) {
                float f5 = cropState.cropScale * 1.0f;
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int i2 = this.currentCropState.transformRotation;
                if (i2 == 90 || i2 == 270) {
                    measuredHeight = measuredWidth;
                    measuredWidth = measuredHeight;
                }
                float fMax = Math.max(imageWidth / ((int) (r8.cropPw * r4)), imageHeight / ((int) (r8.cropPh * r7)));
                f2 = f5 * fMax;
                MediaController.CropState cropState2 = this.currentCropState;
                float f6 = cropState2.cropPx * measuredWidth * scale * fMax;
                float f7 = cropState2.cropScale;
                f = (f6 * f7) + trX;
                f4 = trY + (cropState2.cropPy * measuredHeight * scale * fMax * f7);
                f3 = cropState2.cropRotate + i2;
            } else {
                f = trX;
                f2 = i == 0 ? 1.0f * this.baseScale : 1.0f;
                f3 = 0.0f;
                f4 = trY;
            }
            float f8 = f2 * scale;
            view.setScaleX(f8);
            view.setScaleY(f8);
            view.setTranslationX(f);
            view.setTranslationY(f4);
            view.setRotation(f3);
            view.invalidate();
            i++;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean selectEntity(EntityView entityView) {
        boolean z;
        EntityView entityView2 = this.currentEntityView;
        boolean z2 = true;
        if (entityView2 == null) {
            z = false;
        } else {
            if (entityView2 == entityView) {
                if (!this.editingText) {
                    showMenuForEntity(entityView2);
                }
                return true;
            }
            entityView2.deselect();
            z = true;
        }
        EntityView entityView3 = this.currentEntityView;
        this.currentEntityView = entityView;
        if ((entityView3 instanceof TextPaintView) && TextUtils.isEmpty(((TextPaintView) entityView3).getText())) {
            lambda$registerRemovalUndo$9(entityView3);
        }
        EntityView entityView4 = this.currentEntityView;
        if (entityView4 != null) {
            entityView4.select(this.selectionContainerView);
            this.entitiesView.bringViewToFront(this.currentEntityView);
            EntityView entityView5 = this.currentEntityView;
            if (entityView5 instanceof TextPaintView) {
                setCurrentSwatch(((TextPaintView) entityView5).getSwatch(), true);
            }
        } else {
            z2 = z;
        }
        updateSettingsButton();
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeEntity, reason: merged with bridge method [inline-methods] */
    public void lambda$registerRemovalUndo$9$PhotoPaintView(EntityView entityView) {
        EntityView entityView2 = this.currentEntityView;
        if (entityView == entityView2) {
            entityView2.deselect();
            if (this.editingText) {
                closeTextEnter(false);
            }
            this.currentEntityView = null;
            updateSettingsButton();
        }
        this.entitiesView.removeView(entityView);
        this.undoStore.unregisterUndo(entityView.getUUID());
    }

    private void duplicateSelectedEntity() {
        EntityView entityView = this.currentEntityView;
        if (entityView == null) {
            return;
        }
        EntityView entityView2 = null;
        Point pointStartPositionRelativeToEntity = startPositionRelativeToEntity(entityView);
        EntityView entityView3 = this.currentEntityView;
        if (entityView3 instanceof StickerView) {
            StickerView stickerView = new StickerView(getContext(), (StickerView) this.currentEntityView, pointStartPositionRelativeToEntity);
            stickerView.setDelegate(this);
            this.entitiesView.addView(stickerView);
            entityView2 = stickerView;
        } else if (entityView3 instanceof TextPaintView) {
            TextPaintView textPaintView = new TextPaintView(getContext(), (TextPaintView) this.currentEntityView, pointStartPositionRelativeToEntity);
            textPaintView.setDelegate(this);
            textPaintView.setMaxWidth((int) (getPaintingSize().width - 20.0f));
            this.entitiesView.addView(textPaintView, LayoutHelper.createFrame(-2, -2.0f));
            entityView2 = textPaintView;
        }
        registerRemovalUndo(entityView2);
        selectEntity(entityView2);
        updateSettingsButton();
    }

    private void openStickersView() {
        StickerMasksAlert stickerMasksAlert = new StickerMasksAlert(getContext(), this.facesBitmap == null, this.resourcesProvider);
        stickerMasksAlert.setDelegate(new StickerMasksAlert.StickerMasksAlertDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$Rv1kzgvbtpxp3k4oTHSvfMtz0Xk
            @Override // ir.eitaa.ui.Components.StickerMasksAlert.StickerMasksAlertDelegate
            public final void onStickerSelected(Object obj, TLRPC$Document tLRPC$Document) {
                this.f$0.lambda$openStickersView$7$PhotoPaintView(obj, tLRPC$Document);
            }
        });
        stickerMasksAlert.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$L1As1y4wTmsHflMY3gxMGz3amqM
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$openStickersView$8$PhotoPaintView(dialogInterface);
            }
        });
        stickerMasksAlert.show();
        onOpenCloseStickersAlert(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openStickersView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openStickersView$7$PhotoPaintView(Object obj, TLRPC$Document tLRPC$Document) {
        createSticker(obj, tLRPC$Document, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openStickersView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openStickersView$8$PhotoPaintView(DialogInterface dialogInterface) {
        onOpenCloseStickersAlert(false);
    }

    private Size baseStickerSize() {
        double d = getPaintingSize().width;
        Double.isNaN(d);
        float fFloor = (float) Math.floor(d * 0.5d);
        return new Size(fFloor, fFloor);
    }

    private void registerRemovalUndo(final EntityView entityView) {
        this.undoStore.registerUndo(entityView.getUUID(), new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$7R4vj3HibCIBj0kd2G3DwFHtvCs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$registerRemovalUndo$9$PhotoPaintView(entityView);
            }
        });
    }

    private StickerView createSticker(Object parentObject, TLRPC$Document sticker, boolean select) {
        StickerPosition stickerPositionCalculateStickerPosition = calculateStickerPosition(sticker);
        StickerView stickerView = new StickerView(getContext(), stickerPositionCalculateStickerPosition.position, stickerPositionCalculateStickerPosition.angle, stickerPositionCalculateStickerPosition.scale, baseStickerSize(), sticker, parentObject) { // from class: ir.eitaa.ui.Components.PhotoPaintView.7
            @Override // ir.eitaa.ui.Components.Paint.Views.StickerView
            protected void didSetAnimatedSticker(RLottieDrawable drawable) {
                PhotoPaintView.this.didSetAnimatedSticker(drawable);
            }
        };
        stickerView.setDelegate(this);
        this.entitiesView.addView(stickerView);
        if (select) {
            registerRemovalUndo(stickerView);
            selectEntity(stickerView);
        }
        return stickerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mirrorSticker() {
        EntityView entityView = this.currentEntityView;
        if (entityView instanceof StickerView) {
            ((StickerView) entityView).mirror();
        }
    }

    private TextPaintView createText(boolean select) {
        Swatch swatch;
        onTextAdd();
        Swatch swatch2 = this.colorPicker.getSwatch();
        int i = this.selectedTextType;
        if (i == 0) {
            swatch = new Swatch(-16777216, 0.85f, swatch2.brushWeight);
        } else if (i == 1) {
            swatch = new Swatch(-1, 1.0f, swatch2.brushWeight);
        } else {
            swatch = new Swatch(-1, 1.0f, swatch2.brushWeight);
        }
        Size paintingSize = getPaintingSize();
        TextPaintView textPaintView = new TextPaintView(getContext(), startPositionRelativeToEntity(null), (int) (paintingSize.width / 9.0f), "", swatch, this.selectedTextType);
        textPaintView.setDelegate(this);
        textPaintView.setMaxWidth((int) (paintingSize.width - 20.0f));
        this.entitiesView.addView(textPaintView, LayoutHelper.createFrame(-2, -2.0f));
        MediaController.CropState cropState = this.currentCropState;
        if (cropState != null) {
            textPaintView.scale(1.0f / cropState.cropScale);
            textPaintView.rotate(-(r0.transformRotation + this.currentCropState.cropRotate));
        }
        if (select) {
            registerRemovalUndo(textPaintView);
            selectEntity(textPaintView);
            editSelectedTextEntity();
        }
        setCurrentSwatch(swatch, true);
        return textPaintView;
    }

    private void editSelectedTextEntity() {
        if (!(this.currentEntityView instanceof TextPaintView) || this.editingText) {
            return;
        }
        this.curtainView.setVisibility(0);
        TextPaintView textPaintView = (TextPaintView) this.currentEntityView;
        this.initialText = textPaintView.getText();
        this.editingText = true;
        this.editedTextPosition = textPaintView.getPosition();
        this.editedTextRotation = textPaintView.getRotation();
        this.editedTextScale = textPaintView.getScale();
        textPaintView.setPosition(centerPositionForEntity());
        MediaController.CropState cropState = this.currentCropState;
        if (cropState != null) {
            textPaintView.setRotation(-(cropState.transformRotation + cropState.cropRotate));
            textPaintView.setScale(1.0f / this.currentCropState.cropScale);
        } else {
            textPaintView.setRotation(0.0f);
            textPaintView.setScale(1.0f);
        }
        this.toolsView.setVisibility(8);
        setTextDimVisibility(true, textPaintView);
        textPaintView.beginEditing();
        View focusedView = textPaintView.getFocusedView();
        focusedView.requestFocus();
        AndroidUtilities.showKeyboard(focusedView);
    }

    public void closeTextEnter(boolean apply) {
        if (this.editingText) {
            EntityView entityView = this.currentEntityView;
            if (entityView instanceof TextPaintView) {
                TextPaintView textPaintView = (TextPaintView) entityView;
                this.toolsView.setVisibility(0);
                AndroidUtilities.hideKeyboard(textPaintView.getFocusedView());
                textPaintView.getFocusedView().clearFocus();
                textPaintView.endEditing();
                if (!apply) {
                    textPaintView.setText(this.initialText);
                }
                if (textPaintView.getText().trim().length() == 0) {
                    this.entitiesView.removeView(textPaintView);
                    selectEntity(null);
                } else {
                    textPaintView.setPosition(this.editedTextPosition);
                    textPaintView.setRotation(this.editedTextRotation);
                    textPaintView.setScale(this.editedTextScale);
                    this.editedTextPosition = null;
                    this.editedTextRotation = 0.0f;
                    this.editedTextScale = 0.0f;
                }
                setTextDimVisibility(false, textPaintView);
                this.editingText = false;
                this.initialText = null;
                this.curtainView.setVisibility(8);
            }
        }
    }

    private void setBrush(int brush) {
        RenderView renderView = this.renderView;
        Brush[] brushArr = this.brushes;
        this.currentBrush = brush;
        renderView.setBrush(brushArr[brush]);
    }

    private void setType(int type) {
        this.selectedTextType = type;
        if (this.currentEntityView instanceof TextPaintView) {
            Swatch swatch = this.colorPicker.getSwatch();
            if (type == 0 && swatch.color == -1) {
                setCurrentSwatch(new Swatch(-16777216, 0.85f, swatch.brushWeight), true);
            } else if ((type == 1 || type == 2) && swatch.color == -16777216) {
                setCurrentSwatch(new Swatch(-1, 1.0f, swatch.brushWeight), true);
            }
            ((TextPaintView) this.currentEntityView).setType(type);
        }
    }

    private int[] getCenterLocationInWindow(View view) {
        view.getLocationInWindow(this.pos);
        float rotation = view.getRotation();
        float radians = (float) Math.toRadians(rotation + (this.currentCropState != null ? r1.cropRotate + r1.transformRotation : 0.0f));
        float width = view.getWidth() * view.getScaleX() * this.entitiesView.getScaleX();
        float height = view.getHeight() * view.getScaleY() * this.entitiesView.getScaleY();
        double d = width;
        double d2 = radians;
        double dCos = Math.cos(d2);
        Double.isNaN(d);
        double d3 = height;
        double dSin = Math.sin(d2);
        Double.isNaN(d3);
        float f = (float) ((dCos * d) - (dSin * d3));
        double dSin2 = Math.sin(d2);
        Double.isNaN(d);
        double dCos2 = Math.cos(d2);
        Double.isNaN(d3);
        int[] iArr = this.pos;
        iArr[0] = (int) (iArr[0] + (f / 2.0f));
        iArr[1] = (int) (iArr[1] + (((float) ((d * dSin2) + (d3 * dCos2))) / 2.0f));
        return iArr;
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.EntityView.EntityViewDelegate
    public float getCropRotation() {
        MediaController.CropState cropState = this.currentCropState;
        if (cropState != null) {
            return cropState.cropRotate + cropState.transformRotation;
        }
        return 0.0f;
    }

    private void showMenuForEntity(final EntityView entityView) {
        int[] centerLocationInWindow = getCenterLocationInWindow(entityView);
        showPopup(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$Ts9vsmY51nEmQRGkTfVc-fjEgWI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showMenuForEntity$13$PhotoPaintView(entityView);
            }
        }, this, 51, centerLocationInWindow[0], centerLocationInWindow[1] - AndroidUtilities.dp(32.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showMenuForEntity$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showMenuForEntity$13$PhotoPaintView(final EntityView entityView) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        textView.setTextColor(getThemedColor("actionBarDefaultSubmenuItem"));
        textView.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        textView.setGravity(16);
        textView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(14.0f), 0);
        textView.setTextSize(1, 18.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setTag(0);
        textView.setText(LocaleController.getString("PaintDelete", R.string.PaintDelete));
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$Gpq3iYGwTLiw0Mwnk6m_asa5yj0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showMenuForEntity$10$PhotoPaintView(entityView, view);
            }
        });
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, 48));
        if (entityView instanceof TextPaintView) {
            TextView textView2 = new TextView(getContext());
            textView2.setTextColor(getThemedColor("actionBarDefaultSubmenuItem"));
            textView2.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            textView2.setGravity(16);
            textView2.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
            textView2.setTextSize(1, 18.0f);
            textView2.setTypeface(AndroidUtilities.getFontFamily(false));
            textView2.setTag(1);
            textView2.setText(LocaleController.getString("PaintEdit", R.string.PaintEdit));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$LEiuZlaw9nGumoHLfZTlztvdba0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$showMenuForEntity$11$PhotoPaintView(view);
                }
            });
            linearLayout.addView(textView2, LayoutHelper.createLinear(-2, 48));
        }
        TextView textView3 = new TextView(getContext());
        textView3.setTextColor(getThemedColor("actionBarDefaultSubmenuItem"));
        textView3.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        textView3.setGravity(16);
        textView3.setPadding(AndroidUtilities.dp(14.0f), 0, AndroidUtilities.dp(16.0f), 0);
        textView3.setTextSize(1, 18.0f);
        textView3.setTypeface(AndroidUtilities.getFontFamily(false));
        textView3.setTag(2);
        textView3.setText(LocaleController.getString("PaintDuplicate", R.string.PaintDuplicate));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$Or6-CxUBGW7HdmmjJ34ERW8BX8A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showMenuForEntity$12$PhotoPaintView(view);
            }
        });
        linearLayout.addView(textView3, LayoutHelper.createLinear(-2, 48));
        this.popupLayout.addView(linearLayout);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showMenuForEntity$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showMenuForEntity$10$PhotoPaintView(EntityView entityView, View view) {
        lambda$registerRemovalUndo$9(entityView);
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.popupWindow.dismiss(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showMenuForEntity$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showMenuForEntity$11$PhotoPaintView(View view) {
        editSelectedTextEntity();
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.popupWindow.dismiss(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showMenuForEntity$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showMenuForEntity$12$PhotoPaintView(View view) {
        duplicateSelectedEntity();
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.popupWindow.dismiss(true);
    }

    private LinearLayout buttonForBrush(final int brush, int icon, String text, boolean selected) {
        LinearLayout linearLayout = new LinearLayout(getContext()) { // from class: ir.eitaa.ui.Components.PhotoPaintView.8
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                return true;
            }
        };
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$q-9XGM1OMJ7ujdxH7YsBsIyThds
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$buttonForBrush$14$PhotoPaintView(brush, view);
            }
        });
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(icon);
        imageView.setColorFilter(getThemedColor("actionBarDefaultSubmenuItem"));
        linearLayout.addView(imageView, LayoutHelper.createLinear(-2, -2, 19, 16, 0, 16, 0));
        TextView textView = new TextView(getContext());
        textView.setTextColor(getThemedColor("actionBarDefaultSubmenuItem"));
        textView.setTextSize(1, 16.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setText(text);
        textView.setMinWidth(AndroidUtilities.dp(70.0f));
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 19, 0, 0, 16, 0));
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(R.drawable.msg_text_check);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setColorFilter(new PorterDuffColorFilter(getThemedColor("radioBackgroundChecked"), PorterDuff.Mode.MULTIPLY));
        imageView2.setVisibility(selected ? 0 : 4);
        linearLayout.addView(imageView2, LayoutHelper.createLinear(50, -1));
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$buttonForBrush$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$buttonForBrush$14$PhotoPaintView(int i, View view) {
        setBrush(i);
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.popupWindow.dismiss(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBrushSettings() {
        showPopup(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$zCWxbqWahWstHxXmhrWt28jgOdc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showBrushSettings$15$PhotoPaintView();
            }
        }, this, 85, 0, AndroidUtilities.dp(48.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showBrushSettings$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showBrushSettings$15$PhotoPaintView() {
        this.popupLayout.addView((View) buttonForBrush(0, R.drawable.msg_draw_pen, LocaleController.getString("PaintPen", R.string.PaintPen), this.currentBrush == 0), LayoutHelper.createLinear(-1, 54));
        this.popupLayout.addView((View) buttonForBrush(1, R.drawable.msg_draw_marker, LocaleController.getString("PaintMarker", R.string.PaintMarker), this.currentBrush == 1), LayoutHelper.createLinear(-1, 54));
        this.popupLayout.addView((View) buttonForBrush(2, R.drawable.msg_draw_neon, LocaleController.getString("PaintNeon", R.string.PaintNeon), this.currentBrush == 2), LayoutHelper.createLinear(-1, 54));
        this.popupLayout.addView((View) buttonForBrush(3, R.drawable.msg_draw_arrow, LocaleController.getString("PaintArrow", R.string.PaintArrow), this.currentBrush == 3), LayoutHelper.createLinear(-1, 54));
    }

    private LinearLayout buttonForText(final int type, String text, int icon, boolean selected) {
        LinearLayout linearLayout = new LinearLayout(getContext()) { // from class: ir.eitaa.ui.Components.PhotoPaintView.9
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                return true;
            }
        };
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundDrawable(Theme.getSelectorDrawable(false));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$e11d3FUrFGOkBOYKTQRz99v4JF8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$buttonForText$16$PhotoPaintView(type, view);
            }
        });
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(icon);
        imageView.setColorFilter(getThemedColor("actionBarDefaultSubmenuItem"));
        linearLayout.addView(imageView, LayoutHelper.createLinear(-2, -2, 19, 16, 0, 16, 0));
        TextView textView = new TextView(getContext());
        textView.setTextColor(getThemedColor("actionBarDefaultSubmenuItem"));
        textView.setTextSize(1, 16.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setText(text);
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 19, 0, 0, 16, 0));
        if (selected) {
            ImageView imageView2 = new ImageView(getContext());
            imageView2.setImageResource(R.drawable.msg_text_check);
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            imageView2.setColorFilter(new PorterDuffColorFilter(getThemedColor("radioBackgroundChecked"), PorterDuff.Mode.MULTIPLY));
            linearLayout.addView(imageView2, LayoutHelper.createLinear(50, -1));
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$buttonForText$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$buttonForText$16$PhotoPaintView(int i, View view) {
        setType(i);
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            return;
        }
        this.popupWindow.dismiss(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTextSettings() {
        showPopup(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$tqJ9V1nHBh2JLjFnLsbsbF1wjgc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showTextSettings$17$PhotoPaintView();
            }
        }, this, 85, 0, AndroidUtilities.dp(48.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showTextSettings$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showTextSettings$17$PhotoPaintView() {
        String string;
        int i;
        for (int i2 = 0; i2 < 3; i2++) {
            boolean z = true;
            if (i2 == 0) {
                string = LocaleController.getString("PaintOutlined", R.string.PaintOutlined);
                i = R.drawable.msg_text_outlined;
            } else if (i2 == 1) {
                string = LocaleController.getString("PaintRegular", R.string.PaintRegular);
                i = R.drawable.msg_text_regular;
            } else {
                string = LocaleController.getString("PaintFramed", R.string.PaintFramed);
                i = R.drawable.msg_text_framed;
            }
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.popupLayout;
            if (this.selectedTextType != i2) {
                z = false;
            }
            actionBarPopupWindowLayout.addView((View) buttonForText(i2, string, i, z), LayoutHelper.createLinear(-1, 48));
        }
    }

    private void showPopup(Runnable setupRunnable, View parent, int gravity, int x, int y) {
        ActionBarPopupWindow actionBarPopupWindow = this.popupWindow;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.popupWindow.dismiss();
            return;
        }
        if (this.popupLayout == null) {
            this.popupRect = new android.graphics.Rect();
            ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getContext());
            this.popupLayout = actionBarPopupWindowLayout;
            actionBarPopupWindowLayout.setAnimationEnabled(false);
            this.popupLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$ZgOBwKJVjxdAkpyAxipyz69m6r8
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f$0.lambda$showPopup$18$PhotoPaintView(view, motionEvent);
                }
            });
            this.popupLayout.setDispatchKeyEventListener(new ActionBarPopupWindow.OnDispatchKeyEventListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$G2PllUK3O5MkV261h6CVvZyNGJ0
                @Override // ir.eitaa.ui.ActionBar.ActionBarPopupWindow.OnDispatchKeyEventListener
                public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                    this.f$0.lambda$showPopup$19$PhotoPaintView(keyEvent);
                }
            });
            this.popupLayout.setShownFromBotton(true);
        }
        this.popupLayout.removeInnerViews();
        setupRunnable.run();
        if (this.popupWindow == null) {
            ActionBarPopupWindow actionBarPopupWindow2 = new ActionBarPopupWindow(this.popupLayout, -2, -2);
            this.popupWindow = actionBarPopupWindow2;
            actionBarPopupWindow2.setAnimationEnabled(false);
            this.popupWindow.setAnimationStyle(R.style.PopupAnimation);
            this.popupWindow.setOutsideTouchable(true);
            this.popupWindow.setClippingEnabled(true);
            this.popupWindow.setInputMethodMode(2);
            this.popupWindow.setSoftInputMode(0);
            this.popupWindow.getContentView().setFocusableInTouchMode(true);
            this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$WTFMxvN_xI8uRUdDcNvRqfsDerU
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    this.f$0.lambda$showPopup$20$PhotoPaintView();
                }
            });
        }
        this.popupLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
        this.popupWindow.setFocusable(true);
        if ((gravity & 48) != 0) {
            x -= this.popupLayout.getMeasuredWidth() / 2;
            y -= this.popupLayout.getMeasuredHeight();
        }
        this.popupWindow.showAtLocation(parent, gravity, x, y);
        this.popupWindow.startAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPopup$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$showPopup$18$PhotoPaintView(View view, MotionEvent motionEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (motionEvent.getActionMasked() != 0 || (actionBarPopupWindow = this.popupWindow) == null || !actionBarPopupWindow.isShowing()) {
            return false;
        }
        view.getHitRect(this.popupRect);
        if (this.popupRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.popupWindow.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPopup$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPopup$19$PhotoPaintView(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.popupWindow) != null && actionBarPopupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPopup$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPopup$20$PhotoPaintView() {
        this.popupLayout.removeInnerViews();
    }

    private int getFrameRotation() {
        int i = this.originalBitmapRotation;
        if (i == 90) {
            return 1;
        }
        if (i != 180) {
            return i != 270 ? 0 : 3;
        }
        return 2;
    }

    private boolean isSidewardOrientation() {
        int i = this.originalBitmapRotation;
        return i % 360 == 90 || i % 360 == 270;
    }

    private void detectFaces() {
        this.queue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoPaintView$SzPJAsWj5OxqJK5q70yKJ4gvEdw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$detectFaces$21$PhotoPaintView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$detectFaces$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$detectFaces$21$PhotoPaintView() {
        int i;
        FaceDetector faceDetectorBuild = null;
        try {
            try {
                faceDetectorBuild = new FaceDetector.Builder(getContext()).setMode(1).setLandmarkType(1).setTrackingEnabled(false).build();
            } catch (Exception e) {
                FileLog.e(e);
                if (0 == 0) {
                    return;
                }
            }
            if (!faceDetectorBuild.isOperational()) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("face detection is not operational");
                }
                faceDetectorBuild.release();
                return;
            }
            try {
                SparseArray<Face> sparseArrayDetect = faceDetectorBuild.detect(new Frame.Builder().setBitmap(this.facesBitmap).setRotation(getFrameRotation()).build());
                ArrayList<PhotoFace> arrayList = new ArrayList<>();
                Size paintingSize = getPaintingSize();
                for (i = 0; i < sparseArrayDetect.size(); i++) {
                    PhotoFace photoFace = new PhotoFace(sparseArrayDetect.get(sparseArrayDetect.keyAt(i)), this.facesBitmap, paintingSize, isSidewardOrientation());
                    if (photoFace.isSufficient()) {
                        arrayList.add(photoFace);
                    }
                }
                this.faces = arrayList;
                faceDetectorBuild.release();
            } catch (Throwable th) {
                FileLog.e(th);
                faceDetectorBuild.release();
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                faceDetectorBuild.release();
            }
            throw th2;
        }
    }

    private StickerPosition calculateStickerPosition(TLRPC$Document document) {
        TLRPC$TL_maskCoords tLRPC$TL_maskCoords;
        float f;
        ArrayList<PhotoFace> arrayList;
        int i;
        PhotoFace randomFaceWithVacantAnchor;
        int i2 = 0;
        while (true) {
            if (i2 >= document.attributes.size()) {
                tLRPC$TL_maskCoords = null;
                break;
            }
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i2);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                tLRPC$TL_maskCoords = tLRPC$DocumentAttribute.mask_coords;
                break;
            }
            i2++;
        }
        MediaController.CropState cropState = this.currentCropState;
        float f2 = 0.75f;
        if (cropState != null) {
            f = -(cropState.transformRotation + cropState.cropRotate);
            f2 = 0.75f / cropState.cropScale;
        } else {
            f = 0.0f;
        }
        StickerPosition stickerPosition = new StickerPosition(centerPositionForEntity(), f2, f);
        if (tLRPC$TL_maskCoords == null || (arrayList = this.faces) == null || arrayList.size() == 0 || (randomFaceWithVacantAnchor = getRandomFaceWithVacantAnchor((i = tLRPC$TL_maskCoords.n), document.id, tLRPC$TL_maskCoords)) == null) {
            return stickerPosition;
        }
        Point pointForAnchor = randomFaceWithVacantAnchor.getPointForAnchor(i);
        float widthForAnchor = randomFaceWithVacantAnchor.getWidthForAnchor(i);
        float angle = randomFaceWithVacantAnchor.getAngle();
        double d = widthForAnchor / baseStickerSize().width;
        double d2 = tLRPC$TL_maskCoords.zoom;
        Double.isNaN(d);
        double radians = (float) Math.toRadians(angle);
        Double.isNaN(radians);
        double d3 = 1.5707963267948966d - radians;
        double dSin = Math.sin(d3);
        double d4 = widthForAnchor;
        Double.isNaN(d4);
        float f3 = (float) (dSin * d4 * tLRPC$TL_maskCoords.x);
        double dCos = Math.cos(d3);
        Double.isNaN(d4);
        float f4 = (float) (dCos * d4 * tLRPC$TL_maskCoords.x);
        Double.isNaN(radians);
        double d5 = radians + 1.5707963267948966d;
        double dCos2 = Math.cos(d5);
        Double.isNaN(d4);
        float f5 = (float) (dCos2 * d4 * tLRPC$TL_maskCoords.y);
        double dSin2 = Math.sin(d5);
        Double.isNaN(d4);
        return new StickerPosition(new Point(pointForAnchor.x + f3 + f5, pointForAnchor.y + f4 + ((float) (dSin2 * d4 * tLRPC$TL_maskCoords.y))), (float) (d * d2), angle);
    }

    private PhotoFace getRandomFaceWithVacantAnchor(int anchor, long documentId, TLRPC$TL_maskCoords maskCoords) {
        if (anchor >= 0 && anchor <= 3 && !this.faces.isEmpty()) {
            int size = this.faces.size();
            int iNextInt = Utilities.random.nextInt(size);
            for (int i = size; i > 0; i--) {
                PhotoFace photoFace = this.faces.get(iNextInt);
                if (!isFaceAnchorOccupied(photoFace, anchor, documentId, maskCoords)) {
                    return photoFace;
                }
                iNextInt = (iNextInt + 1) % size;
            }
        }
        return null;
    }

    private boolean isFaceAnchorOccupied(PhotoFace face, int anchor, long documentId, TLRPC$TL_maskCoords maskCoords) {
        if (face.getPointForAnchor(anchor) == null) {
            return true;
        }
        float widthForAnchor = face.getWidthForAnchor(0) * 1.1f;
        for (int i = 0; i < this.entitiesView.getChildCount(); i++) {
            View childAt = this.entitiesView.getChildAt(i);
            if (childAt instanceof StickerView) {
                StickerView stickerView = (StickerView) childAt;
                if (stickerView.getAnchor() != anchor) {
                    continue;
                } else {
                    Point position = stickerView.getPosition();
                    float fHypot = (float) Math.hypot(position.x - r14.x, position.y - r14.y);
                    if ((documentId == stickerView.getSticker().id || this.faces.size() > 1) && fHypot < widthForAnchor) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    private static class StickerPosition {
        private float angle;
        private Point position;
        private float scale;

        StickerPosition(Point position, float scale, float angle) {
            this.position = position;
            this.scale = scale;
            this.angle = angle;
        }
    }
}
