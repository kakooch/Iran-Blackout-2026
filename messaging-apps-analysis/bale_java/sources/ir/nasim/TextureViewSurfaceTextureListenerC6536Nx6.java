package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C6042Lx6;
import ir.nasim.features.attach.model.ShareAttachment;
import java.io.IOException;

/* renamed from: ir.nasim.Nx6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class TextureViewSurfaceTextureListenerC6536Nx6 extends AbstractC16640ld0 implements TextureView.SurfaceTextureListener {
    public static final a H = new a(null);
    public static final int J = 8;
    public CardView A;
    public ConstraintLayout B;
    public TextView D;
    public ImageView G;
    private final C6042Lx6.a v;
    private Camera w;
    private final SparseIntArray x;
    private boolean y;
    public TextureView z;

    /* renamed from: ir.nasim.Nx6$a */
    public static final class a {
        private a() {
        }

        public final TextureViewSurfaceTextureListenerC6536Nx6 a(ViewGroup viewGroup, C6042Lx6.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.bottom_sheet_chat_attach_item_share, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new TextureViewSurfaceTextureListenerC6536Nx6(viewInflate, aVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ TextureViewSurfaceTextureListenerC6536Nx6(View view, C6042Lx6.a aVar, ED1 ed1) {
        this(view, aVar);
    }

    private final void F0() {
        M0().setVisibility(8);
        N0().setBackground(AbstractC4043Dl1.f(C0(), KB5.ba_camera_img));
    }

    private final void H0() throws IOException {
        N0().setBackground(AbstractC4043Dl1.f(C0(), KB5.drawable_oval));
        if (AbstractC4043Dl1.a(C0(), "android.permission.CAMERA") != 0) {
            M0().setVisibility(8);
            return;
        }
        M0().setVisibility(0);
        if (!P0().isAvailable()) {
            P0().setSurfaceTextureListener(this);
            return;
        }
        SurfaceTexture surfaceTexture = P0().getSurfaceTexture();
        if (surfaceTexture != null) {
            V0(surfaceTexture);
        }
    }

    private final int J0() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                return i;
            }
        }
        return -1;
    }

    private final boolean Q0(boolean z, ShareAttachment shareAttachment) {
        return !z && (AbstractC13042fc3.d(shareAttachment.getTag(), "GALLERY") || AbstractC13042fc3.d(shareAttachment.getTag(), "CAMERA") || AbstractC13042fc3.d(shareAttachment.getTag(), "FILE"));
    }

    private final void S0() {
        Drawable drawable = L0().getDrawable();
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        drawable.setTint(c5495Jo7.e0());
        O0().setTextColor(c5495Jo7.e0());
        N0().getBackground().setColorFilter(c5495Jo7.Z(), PorterDuff.Mode.SRC_ATOP);
    }

    private final void T0(final ShareAttachment shareAttachment) {
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Mx6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextureViewSurfaceTextureListenerC6536Nx6.U0(shareAttachment, this, view);
            }
        });
        O0().setTextColor(Color.parseColor(shareAttachment.getTitleColor()));
        N0().getBackground().setColorFilter(Color.parseColor(shareAttachment.getBackgroundTint()), PorterDuff.Mode.SRC_ATOP);
        if (this.y) {
            return;
        }
        L0().getDrawable().setTint(Color.parseColor(shareAttachment.getTint()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(ShareAttachment shareAttachment, TextureViewSurfaceTextureListenerC6536Nx6 textureViewSurfaceTextureListenerC6536Nx6, View view) {
        AbstractC13042fc3.i(shareAttachment, "$attachment");
        AbstractC13042fc3.i(textureViewSurfaceTextureListenerC6536Nx6, "this$0");
        if (AbstractC13042fc3.d(shareAttachment.getTag(), "POLL")) {
            View viewFindViewById = textureViewSurfaceTextureListenerC6536Nx6.a.findViewById(BC5.share_badge);
            AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
            viewFindViewById.setVisibility(8);
        }
        C6042Lx6.a aVar = textureViewSurfaceTextureListenerC6536Nx6.v;
        if (aVar != null) {
            aVar.I(shareAttachment);
        }
    }

    private final void V0(SurfaceTexture surfaceTexture) throws IOException {
        try {
            Camera cameraOpen = Camera.open(J0());
            this.w = cameraOpen;
            if (cameraOpen != null) {
                cameraOpen.setPreviewTexture(surfaceTexture);
                Object systemService = C0().getSystemService("window");
                AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                cameraOpen.setDisplayOrientation(this.x.get(((WindowManager) systemService).getDefaultDisplay().getRotation()));
                Camera.Parameters parameters = cameraOpen.getParameters();
                if (parameters != null) {
                    try {
                        parameters.setFocusMode("continuous-picture");
                    } catch (Exception unused) {
                        C19406qI3.i("Attachment", "This device can't support FOCUS_MODE_CONTINUOUS_PICTURE", new Object[0]);
                    }
                }
                cameraOpen.setParameters(parameters);
                C6042Lx6.a aVar = this.v;
                if (aVar != null) {
                    aVar.J(cameraOpen);
                }
            }
        } catch (IOException e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            if (this.w == null) {
                F0();
            }
        }
    }

    public final void E0(ShareAttachment shareAttachment) {
        AbstractC13042fc3.i(shareAttachment, "attachment");
        a1((TextureView) this.a.findViewById(BC5.texture_view));
        X0((CardView) this.a.findViewById(BC5.share_drawable_card));
        Y0((ConstraintLayout) this.a.findViewById(BC5.share_drawable_layout));
        Z0((TextView) this.a.findViewById(BC5.share_title));
        W0((ImageView) this.a.findViewById(BC5.share_drawable));
        View viewFindViewById = this.a.findViewById(BC5.share_badge);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(AbstractC13042fc3.d(shareAttachment.getShowBadge(), Boolean.TRUE) ? 0 : 8);
        P0().setSurfaceTextureListener(this);
        this.y = AbstractC13042fc3.d(shareAttachment.getTag(), "CAMERA");
        C6042Lx6.a aVar = this.v;
        EM2 em2H = aVar != null ? aVar.H() : null;
        if (this.y && em2H == EM2.a) {
            H0();
        } else {
            M0().setVisibility(8);
            N0().setBackground(AbstractC4043Dl1.f(C0(), KB5.drawable_ripple_oval));
        }
        ImageView imageViewL0 = L0();
        Context contextC0 = C0();
        Integer src = shareAttachment.getSrc();
        AbstractC13042fc3.f(src);
        imageViewL0.setImageDrawable(AbstractC4043Dl1.f(contextC0, src.intValue()));
        O0().setText(shareAttachment.getTitle());
        O0().setTypeface(C6011Lu2.i());
        if (Q0(em2H == EM2.a, shareAttachment)) {
            S0();
        } else {
            T0(shareAttachment);
        }
    }

    public final ImageView L0() {
        ImageView imageView = this.G;
        if (imageView != null) {
            return imageView;
        }
        AbstractC13042fc3.y("shareDrawable");
        return null;
    }

    public final CardView M0() {
        CardView cardView = this.A;
        if (cardView != null) {
            return cardView;
        }
        AbstractC13042fc3.y("shareDrawableCard");
        return null;
    }

    public final ConstraintLayout N0() {
        ConstraintLayout constraintLayout = this.B;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        AbstractC13042fc3.y("shareDrawableLayout");
        return null;
    }

    public final TextView O0() {
        TextView textView = this.D;
        if (textView != null) {
            return textView;
        }
        AbstractC13042fc3.y("shareTitle");
        return null;
    }

    public final TextureView P0() {
        TextureView textureView = this.z;
        if (textureView != null) {
            return textureView;
        }
        AbstractC13042fc3.y("textureView");
        return null;
    }

    public final void W0(ImageView imageView) {
        AbstractC13042fc3.i(imageView, "<set-?>");
        this.G = imageView;
    }

    public final void X0(CardView cardView) {
        AbstractC13042fc3.i(cardView, "<set-?>");
        this.A = cardView;
    }

    public final void Y0(ConstraintLayout constraintLayout) {
        AbstractC13042fc3.i(constraintLayout, "<set-?>");
        this.B = constraintLayout;
    }

    public final void Z0(TextView textView) {
        AbstractC13042fc3.i(textView, "<set-?>");
        this.D = textView;
    }

    public final void a1(TextureView textureView) {
        AbstractC13042fc3.i(textureView, "<set-?>");
        this.z = textureView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) throws IOException {
        AbstractC13042fc3.i(surfaceTexture, "surface");
        V0(surfaceTexture);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AbstractC13042fc3.i(surfaceTexture, "p0");
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AbstractC13042fc3.i(surfaceTexture, "p0");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AbstractC13042fc3.i(surfaceTexture, "p0");
    }

    private TextureViewSurfaceTextureListenerC6536Nx6(View view, C6042Lx6.a aVar) {
        super(view);
        this.v = aVar;
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.x = sparseIntArray;
        sparseIntArray.append(0, 90);
        sparseIntArray.append(1, 0);
        sparseIntArray.append(2, 270);
        sparseIntArray.append(3, SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER);
    }
}
