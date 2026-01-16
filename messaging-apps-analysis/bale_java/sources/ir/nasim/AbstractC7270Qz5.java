package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.utils.share.SharedContent;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 P2\u00020\u0001:\u0002QRB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH$¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH$¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b \u0010!J\u0011\u0010#\u001a\u0004\u0018\u00010\"H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0014¢\u0006\u0004\b%\u0010\u0003J'\u0010*\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(H&¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00062\b\b\u0001\u0010,\u001a\u00020\u0011¢\u0006\u0004\b-\u0010\u0014J\u0019\u0010/\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010(H&¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H&¢\u0006\u0004\b1\u0010\u0003R\"\u00109\u001a\u0002028\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010A\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010H\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006S"}, d2 = {"Lir/nasim/Qz5;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/os/Bundle;", "arguments", "Lir/nasim/rB7;", "W9", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "resId", "ca", "(I)V", "res", "X9", "(Landroid/view/View;)V", "V9", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "Lir/nasim/J44;", DialogEntity.COLUMN_MESSAGE, "", "isEditMode", "Lir/nasim/Ew7;", "", "P9", "(Lir/nasim/J44;Z)Lir/nasim/Ew7;", "Lir/nasim/Qz5$b;", "T9", "()Lir/nasim/Qz5$b;", "Z9", "Landroid/net/Uri;", "uri", "", "inputMimeType", "Q9", "(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;", "hint", "R9", "rawText", "ba", "(Ljava/lang/String;)Z", "U9", "Lir/nasim/d25;", "c1", "Lir/nasim/d25;", "getPeer", "()Lir/nasim/d25;", "da", "(Lir/nasim/d25;)V", "peer", "Lir/nasim/utils/share/SharedContent$MediaContent;", "d1", "Lir/nasim/utils/share/SharedContent$MediaContent;", "S9", "()Lir/nasim/utils/share/SharedContent$MediaContent;", "ea", "(Lir/nasim/utils/share/SharedContent$MediaContent;)V", "sharedContent", "e1", "Z", "Y9", "()Z", "setDiscussion", "(Z)V", "isDiscussion", "f1", "Landroid/view/View;", "closeButton", "Lir/nasim/EM2;", "g1", "Lir/nasim/EM2;", "canSendGifStickerMessage", "h1", "b", "a", "chat_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Qz5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC7270Qz5 extends C22042ua0 {

    /* renamed from: h1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int i1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    protected C11458d25 peer;

    /* renamed from: d1, reason: from kotlin metadata */
    private SharedContent.MediaContent sharedContent;

    /* renamed from: e1, reason: from kotlin metadata */
    private boolean isDiscussion;

    /* renamed from: f1, reason: from kotlin metadata */
    private View closeButton;

    /* renamed from: g1, reason: from kotlin metadata */
    protected EM2 canSendGifStickerMessage;

    /* renamed from: ir.nasim.Qz5$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ String d(Companion companion, Context context, Uri uri, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            return companion.c(context, uri, str);
        }

        public final String a(String str) {
            AbstractC13042fc3.i(str, "fileName");
            int iQ0 = AbstractC20762sZ6.q0(str, '.', 0, false, 6, null);
            if (iQ0 < 0) {
                return "";
            }
            String strSubstring = str.substring(iQ0 + 1);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            return strSubstring;
        }

        public final String b(Uri uri) {
            if (uri == null) {
                return "";
            }
            String lastPathSegment = uri.getLastPathSegment();
            return lastPathSegment == null ? AbstractC14815iX3.f(uri) : lastPathSegment;
        }

        public final String c(Context context, Uri uri, String str) throws IOException {
            String mimeTypeFromExtension;
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(uri, "uri");
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(context, uri);
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(12);
                    if (strExtractMetadata != null) {
                        return strExtractMetadata;
                    }
                } catch (Exception e) {
                    C19406qI3.j("QuoteFragmentBase", "Failed to load mimetype of file " + uri, e);
                }
                if (str != null) {
                    return str;
                }
                if (uri.getScheme() == null || !AbstractC13042fc3.d(uri.getScheme(), "content")) {
                    String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
                    AbstractC13042fc3.f(fileExtensionFromUrl);
                    if (fileExtensionFromUrl.length() == 0) {
                        fileExtensionFromUrl = C6906Pm2.l(uri.toString());
                    }
                    MimeTypeMap singleton = MimeTypeMap.getSingleton();
                    AbstractC13042fc3.f(fileExtensionFromUrl);
                    Locale locale = Locale.getDefault();
                    AbstractC13042fc3.h(locale, "getDefault(...)");
                    String lowerCase = fileExtensionFromUrl.toLowerCase(locale);
                    AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                    mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
                } else {
                    mimeTypeFromExtension = context.getContentResolver().getType(uri);
                }
                return (mimeTypeFromExtension == null || mimeTypeFromExtension.length() <= 0) ? "media" : mimeTypeFromExtension;
            } finally {
                mediaMetadataRetriever.release();
            }
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Qz5$b */
    public static final class b {
        private final long a;
        private final Long b;
        private final boolean c;

        public b(long j, Long l, boolean z) {
            this.a = j;
            this.b = l;
            this.c = z;
        }

        public static /* synthetic */ b b(b bVar, long j, Long l, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = bVar.a;
            }
            if ((i & 2) != 0) {
                l = bVar.b;
            }
            if ((i & 4) != 0) {
                z = bVar.c;
            }
            return bVar.a(j, l, z);
        }

        public final b a(long j, Long l, boolean z) {
            return new b(j, l, z);
        }

        public final boolean c() {
            return this.c;
        }

        public final Long d() {
            return this.b;
        }

        public final long e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c;
        }

        public int hashCode() {
            int iHashCode = Long.hashCode(this.a) * 31;
            Long l = this.b;
            return ((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "VideoCompressionInfo(initialSize=" + this.a + ", compressedSize=" + this.b + ", compressWasEnabled=" + this.c + Separators.RPAREN;
        }
    }

    private final void W9(Bundle arguments) {
        try {
            da(C11458d25.q(arguments.getByteArray("EXTRA_PEER")));
            this.canSendGifStickerMessage = (EM2) arguments.getSerializable("CAN_SEND_GIF");
            this.isDiscussion = arguments.getBoolean("arg_is_discussion", false);
        } catch (IOException e) {
            C19406qI3.a("QUOTE FRAGMENT BASE", e.toString(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(AbstractC7270Qz5 abstractC7270Qz5, View view) {
        AbstractC13042fc3.i(abstractC7270Qz5, "this$0");
        abstractC7270Qz5.Z9();
    }

    public abstract C4382Ew7 P9(J44 message, boolean isEditMode);

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Bundle bundleR7 = R7();
        AbstractC13042fc3.h(bundleR7, "requireArguments(...)");
        W9(bundleR7);
        View viewV9 = V9(inflater, container);
        X9(viewV9);
        View viewFindViewById = viewV9.findViewById(BC5.ib_close_quote);
        this.closeButton = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Pz5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AbstractC7270Qz5.aa(this.a, view);
                }
            });
        }
        return viewV9;
    }

    public abstract Uri Q9(Uri uri, String inputMimeType);

    public final void R9(int hint) {
        androidx.lifecycle.h hVarU5 = U5();
        if (hVarU5 instanceof InterfaceC21117t83) {
            ((InterfaceC21117t83) hVarU5).d0(hint);
        }
    }

    /* renamed from: S9, reason: from getter */
    public final SharedContent.MediaContent getSharedContent() {
        return this.sharedContent;
    }

    public abstract b T9();

    public abstract void U9();

    protected abstract View V9(LayoutInflater inflater, ViewGroup container);

    protected abstract void X9(View res);

    /* renamed from: Y9, reason: from getter */
    public final boolean getIsDiscussion() {
        return this.isDiscussion;
    }

    protected void Z9() {
        androidx.lifecycle.h hVarU5 = U5();
        if (hVarU5 instanceof InterfaceC6792Oz5) {
            ((InterfaceC6792Oz5) hVarU5).y4();
        }
    }

    public abstract boolean ba(String rawText);

    public final void ca(int resId) {
        View view = this.closeButton;
        if (view != null) {
            Context contextG5 = G5();
            view.setContentDescription(contextG5 != null ? contextG5.getString(resId) : null);
        }
    }

    protected final void da(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "<set-?>");
        this.peer = c11458d25;
    }

    public final void ea(SharedContent.MediaContent mediaContent) {
        this.sharedContent = mediaContent;
    }
}
