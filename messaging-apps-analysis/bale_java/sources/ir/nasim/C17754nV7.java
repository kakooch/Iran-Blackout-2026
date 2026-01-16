package ir.nasim;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.exoplayer2.ui.PlayerView;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;

/* renamed from: ir.nasim.nV7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17754nV7 extends AbstractC17168mW3 implements InterfaceC20718sU7 {
    private final com.bumptech.glide.h d;
    private final PlayerView e;
    private final InterfaceC9173Yu3 f;
    private final InterfaceC9173Yu3 g;
    private boolean h;

    /* renamed from: ir.nasim.nV7$a */
    public static final class a extends AbstractC4151Dx1 {
        a() {
        }

        @Override // ir.nasim.InterfaceC21549tj7
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Drawable drawable, InterfaceC22855vv7 interfaceC22855vv7) {
            AbstractC13042fc3.i(drawable, "resource");
            if (C17754nV7.this.h) {
                PlayerView playerView = C17754nV7.this.e;
                playerView.setUseArtwork(true);
                playerView.setDefaultArtwork(drawable);
            }
        }

        @Override // ir.nasim.InterfaceC21549tj7
        public void g(Drawable drawable) {
            PlayerView playerView = C17754nV7.this.e;
            playerView.setUseArtwork(false);
            playerView.setDefaultArtwork(null);
        }

        @Override // ir.nasim.AbstractC4151Dx1, ir.nasim.InterfaceC21549tj7
        public void k(Drawable drawable) {
            PlayerView playerView = C17754nV7.this.e;
            playerView.setUseArtwork(false);
            playerView.setDefaultArtwork(drawable);
        }
    }

    /* renamed from: ir.nasim.nV7$b */
    public static final class b implements IT5 {
        b() {
        }

        @Override // ir.nasim.IT5
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(Drawable drawable, Object obj, InterfaceC21549tj7 interfaceC21549tj7, EnumC21012sz1 enumC21012sz1, boolean z) {
            AbstractC13042fc3.i(drawable, "resource");
            AbstractC13042fc3.i(obj, CommonUrlParts.MODEL);
            AbstractC13042fc3.i(enumC21012sz1, "dataSource");
            if (!C17754nV7.this.h) {
                return true;
            }
            ImageView imageViewJ = C17754nV7.this.J();
            AbstractC13042fc3.h(imageViewJ, "access$getImageView(...)");
            imageViewJ.setVisibility(0);
            return false;
        }

        @Override // ir.nasim.IT5
        public boolean d(GlideException glideException, Object obj, InterfaceC21549tj7 interfaceC21549tj7, boolean z) {
            AbstractC13042fc3.i(interfaceC21549tj7, "target");
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17754nV7(com.bumptech.glide.h hVar, PlayerView playerView, Drawable drawable, byte[] bArr, XV4 xv4) {
        super(drawable, bArr, xv4);
        AbstractC13042fc3.i(hVar, "glideManager");
        AbstractC13042fc3.i(playerView, "playerView");
        AbstractC13042fc3.i(xv4, "measuredSize");
        this.d = hVar;
        this.e = playerView;
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.f = AbstractC13269fw3.b(enumC4870Gx3, new SA2() { // from class: ir.nasim.lV7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17754nV7.M(this.a);
            }
        });
        this.g = AbstractC13269fw3.b(enumC4870Gx3, new SA2() { // from class: ir.nasim.mV7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17754nV7.L(this.a);
            }
        });
        this.h = true;
        AbstractC17168mW3.A(this, bArr, false, 2, null);
    }

    private final a I() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView J() {
        return (ImageView) this.g.getValue();
    }

    private final a K() {
        return (a) this.f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageView L(C17754nV7 c17754nV7) {
        AbstractC13042fc3.i(c17754nV7, "this$0");
        ImageView imageView = (ImageView) c17754nV7.e.findViewById(VB5.exo_artwork);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a M(C17754nV7 c17754nV7) {
        AbstractC13042fc3.i(c17754nV7, "this$0");
        return c17754nV7.I();
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        this.d.n(J());
        this.d.o(K());
        J().setBackground(w());
    }

    @Override // ir.nasim.InterfaceC20718sU7
    public void onFirstFrameRendered() {
        this.h = false;
        ImageView imageViewJ = J();
        AbstractC13042fc3.h(imageViewJ, "<get-imageView>(...)");
        imageViewJ.setVisibility(8);
    }

    @Override // ir.nasim.AbstractC17168mW3
    public void z(byte[] bArr, boolean z) {
        this.d.z(bArr).b(y(z)).B0(new b()).Q0(J());
        this.d.z(bArr).b(y(z)).M0(K());
    }
}
