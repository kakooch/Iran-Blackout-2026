package ir.nasim;

import android.content.Context;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.divider.MaterialDivider;
import ir.nasim.AbstractC7270Qz5;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.chat.ChatFragment;
import ir.nasim.core.modules.file.FileSizeExceededException;
import ir.nasim.core.modules.file.GifSizeExceededException;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u0090\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\"\u0010#J!\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b%\u0010&J+\u0010(\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u00112\b\u0010'\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0014¢\u0006\u0004\b,\u0010-J!\u00102\u001a\u00020*2\u0006\u0010/\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u000100H\u0014¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0004H\u0014¢\u0006\u0004\b4\u0010\u0003J%\u00106\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u00105\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b6\u00107J+\u0010=\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0;2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b=\u0010>J\u0011\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\bH\u0016¢\u0006\u0004\bB\u0010CJ\u0019\u0010E\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0004H\u0016¢\u0006\u0004\bG\u0010\u0003R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010VR\u0018\u0010\\\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020]8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\ba\u0010_R\u0016\u0010d\u001a\u00020]8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bc\u0010_R\u0016\u0010g\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bh\u0010fR\u0016\u0010k\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bj\u0010PR\u0016\u0010m\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bl\u0010PR\u0016\u0010o\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bn\u0010PR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bt\u0010fR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bz\u0010fR\u0016\u0010\u007f\u001a\u00020|8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020p8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010rR\u0018\u0010\u0083\u0001\u001a\u00020p8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010rR\u0018\u0010\u0085\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010PR\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\"\u0010\u008e\u0001\u001a\r \u008b\u0001*\u0005\u0018\u00010\u008a\u00010\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u0091\u0001"}, d2 = {"Lir/nasim/Uz5;", "Lir/nasim/Qz5;", "<init>", "()V", "Lir/nasim/rB7;", "oa", "na", "ha", "", "isVideo", "Landroid/net/Uri;", "uri", "la", "(ZLandroid/net/Uri;)V", "", "fileSize", "estimated", "", "ja", "(IZ)Ljava/lang/String;", "filePath", "Lir/nasim/tgwidgets/editor/messenger/H;", "ia", "(Ljava/lang/String;)Lir/nasim/tgwidgets/editor/messenger/H;", "ma", "Lir/nasim/gj3;", "pa", "(Landroid/net/Uri;)Lir/nasim/gj3;", "fileName", "ra", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "view", ParameterNames.TEXT, "ta", "(Landroid/widget/TextView;Ljava/lang/String;)V", "", "sa", "(Landroid/widget/TextView;Ljava/lang/CharSequence;)V", "seq", "ua", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/CharSequence;)V", "Landroid/view/View;", "res", "X9", "(Landroid/view/View;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "V9", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "Z9", "inputMimeType", "Q9", "(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;", "Lir/nasim/J44;", DialogEntity.COLUMN_MESSAGE, "isEditMode", "Lir/nasim/Ew7;", "", "P9", "(Lir/nasim/J44;Z)Lir/nasim/Ew7;", "Lir/nasim/Qz5$b;", "T9", "()Lir/nasim/Qz5$b;", "qa", "()Z", "rawText", "ba", "(Ljava/lang/String;)Z", "U9", "", "j1", TokenNames.F, "fileSizeThreshold", "k1", "Lir/nasim/gj3;", "fileNameLoaderJob", "l1", "Landroid/widget/TextView;", "quoteText", "m1", "Landroid/net/Uri;", "captionUri", "n1", "J", "currentQuoteRid", "o1", "currentQuoteDate", "p1", "Lir/nasim/Qz5$b;", "currentVideoCompressionInfo", "Landroid/widget/RadioButton;", "q1", "Landroid/widget/RadioButton;", "rbCompressedMovie", "r1", "rbGifMovie", "s1", "rbOriginalMovie", "t1", "Landroid/view/View;", "divider1", "u1", "divider2", "v1", "tvDesc3", "w1", "tvDesc4", "x1", "tvFileName", "Landroid/widget/ImageView;", "y1", "Landroid/widget/ImageView;", "imgFileType", "z1", "frameFileImage", "Landroidx/constraintlayout/widget/ConstraintLayout;", "A1", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rootContainer", "B1", "llIconPhotoContainer", "Lcom/google/android/material/divider/MaterialDivider;", "C1", "Lcom/google/android/material/divider/MaterialDivider;", "quoteDivider", "D1", "quotePhoto", "E1", "quoteIcon", "F1", "quoteSender", "Landroid/widget/RadioGroup;", "G1", "Landroid/widget/RadioGroup;", "rgMovie", "Lir/nasim/core/modules/settings/SettingsModule;", "kotlin.jvm.PlatformType", "H1", "Lir/nasim/core/modules/settings/SettingsModule;", "settingsModule", "I1", "a", "chat_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Uz5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8211Uz5 extends AbstractC7270Qz5 {

    /* renamed from: I1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int J1 = 8;

    /* renamed from: A1, reason: from kotlin metadata */
    private ConstraintLayout rootContainer;

    /* renamed from: B1, reason: from kotlin metadata */
    private View llIconPhotoContainer;

    /* renamed from: C1, reason: from kotlin metadata */
    private MaterialDivider quoteDivider;

    /* renamed from: D1, reason: from kotlin metadata */
    private ImageView quotePhoto;

    /* renamed from: E1, reason: from kotlin metadata */
    private ImageView quoteIcon;

    /* renamed from: F1, reason: from kotlin metadata */
    private TextView quoteSender;

    /* renamed from: G1, reason: from kotlin metadata */
    private RadioGroup rgMovie;

    /* renamed from: k1, reason: from kotlin metadata */
    private InterfaceC13730gj3 fileNameLoaderJob;

    /* renamed from: l1, reason: from kotlin metadata */
    private TextView quoteText;

    /* renamed from: m1, reason: from kotlin metadata */
    private Uri captionUri;

    /* renamed from: n1, reason: from kotlin metadata */
    private long currentQuoteRid;

    /* renamed from: o1, reason: from kotlin metadata */
    private long currentQuoteDate;

    /* renamed from: p1, reason: from kotlin metadata */
    private AbstractC7270Qz5.b currentVideoCompressionInfo;

    /* renamed from: q1, reason: from kotlin metadata */
    private RadioButton rbCompressedMovie;

    /* renamed from: r1, reason: from kotlin metadata */
    private RadioButton rbGifMovie;

    /* renamed from: s1, reason: from kotlin metadata */
    private RadioButton rbOriginalMovie;

    /* renamed from: t1, reason: from kotlin metadata */
    private View divider1;

    /* renamed from: u1, reason: from kotlin metadata */
    private View divider2;

    /* renamed from: v1, reason: from kotlin metadata */
    private TextView tvDesc3;

    /* renamed from: w1, reason: from kotlin metadata */
    private TextView tvDesc4;

    /* renamed from: x1, reason: from kotlin metadata */
    private TextView tvFileName;

    /* renamed from: y1, reason: from kotlin metadata */
    private ImageView imgFileType;

    /* renamed from: z1, reason: from kotlin metadata */
    private View frameFileImage;

    /* renamed from: j1, reason: from kotlin metadata */
    private float fileSizeThreshold = 100.0f;

    /* renamed from: H1, reason: from kotlin metadata */
    private final SettingsModule settingsModule = AbstractC5969Lp4.d().Y().S();

    /* renamed from: ir.nasim.Uz5$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ C8211Uz5 b(Companion companion, C11458d25 c11458d25, EM2 em2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.a(c11458d25, em2, z);
        }

        public final C8211Uz5 a(C11458d25 c11458d25, EM2 em2, boolean z) {
            AbstractC13042fc3.i(c11458d25, "peer");
            C8211Uz5 c8211Uz5 = new C8211Uz5();
            c8211Uz5.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("EXTRA_PEER", c11458d25.toByteArray()), AbstractC4616Fw7.a("CAN_SEND_GIF", em2), AbstractC4616Fw7.a("arg_is_discussion", Boolean.valueOf(z))));
            return c8211Uz5;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Uz5$b */
    public static final class b implements InterfaceC15419jZ0 {
        final /* synthetic */ Fragment a;

        b(Fragment fragment) {
            this.a = fragment;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            ((ChatFragment) this.a).Qh();
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            AbstractC13042fc3.i(exc, "e");
            ((ChatFragment) this.a).Qh();
            if (exc instanceof FileSizeExceededException) {
                ((ChatFragment) this.a).cr();
            } else if (exc instanceof GifSizeExceededException) {
                ((ChatFragment) this.a).Jr(AbstractC12217eE5.gif_size_exceeded);
            }
        }
    }

    /* renamed from: ir.nasim.Uz5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ Uri e;

        /* renamed from: ir.nasim.Uz5$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8211Uz5 c;
            final /* synthetic */ String d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8211Uz5 c8211Uz5, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8211Uz5;
                this.d = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C8211Uz5 c8211Uz5 = this.c;
                TextView textView = c8211Uz5.tvFileName;
                if (textView == null) {
                    AbstractC13042fc3.y("tvFileName");
                    textView = null;
                }
                c8211Uz5.ta(textView, this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Uri uri, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = uri;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = C8211Uz5.this.new c(this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Closeable closeable;
            int columnIndex;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                String[] strArr = {"_display_name"};
                try {
                    Cursor cursorQuery = C8211Uz5.this.S7().getContentResolver().query(this.e, strArr, null, null, null);
                    if (cursorQuery != null) {
                        Cursor cursor = cursorQuery;
                        C8211Uz5 c8211Uz5 = C8211Uz5.this;
                        try {
                            Cursor cursor2 = cursor;
                            AbstractC20906so1.f(interfaceC20315ro1);
                            String string = (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex(strArr[0])) < 0) ? null : cursor2.getString(columnIndex);
                            if (string != null) {
                                WM3 wm3C = C12366eV1.c();
                                a aVar = new a(c8211Uz5, string, null);
                                this.c = cursor;
                                this.b = 1;
                                if (AbstractC9323Zl0.g(wm3C, aVar, this) == objE) {
                                    return objE;
                                }
                            }
                            closeable = cursor;
                        } catch (Throwable th) {
                            th = th;
                            closeable = cursor;
                            throw th;
                        }
                    }
                } catch (Exception e) {
                    C19406qI3.d("QuotePremiumFragmentNew", e);
                }
                return C19938rB7.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            closeable = (Closeable) this.c;
            try {
                AbstractC10685c16.b(obj);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    YV0.a(closeable, th);
                    throw th3;
                }
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            YV0.a(closeable, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    private final void ha() {
        if (this.canSendGifStickerMessage != EM2.a) {
            RadioButton radioButton = this.rbGifMovie;
            TextView textView = null;
            if (radioButton == null) {
                AbstractC13042fc3.y("rbGifMovie");
                radioButton = null;
            }
            radioButton.setEnabled(false);
            RadioButton radioButton2 = this.rbGifMovie;
            if (radioButton2 == null) {
                AbstractC13042fc3.y("rbGifMovie");
                radioButton2 = null;
            }
            radioButton2.setTextColor(C5495Jo7.a.e0());
            TextView textView2 = this.tvDesc4;
            if (textView2 == null) {
                AbstractC13042fc3.y("tvDesc4");
            } else {
                textView = textView2;
            }
            textView.setText(AbstractC12217eE5.no_stickers_permissoin_for_member);
        }
    }

    private final ir.nasim.tgwidgets.editor.messenger.H ia(String filePath) {
        return AbstractC25148zo6.a(filePath);
    }

    private final String ja(int fileSize, boolean estimated) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        String strA = C20877sl2.a(contextS7, fileSize);
        return Separators.LPAREN + (estimated ? "~" : "") + strA + Separators.RPAREN;
    }

    static /* synthetic */ String ka(C8211Uz5 c8211Uz5, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c8211Uz5.ja(i, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void la(boolean r17, android.net.Uri r18) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8211Uz5.la(boolean, android.net.Uri):void");
    }

    private final void ma() {
        na();
        ImageView imageView = this.quoteIcon;
        ConstraintLayout constraintLayout = null;
        if (imageView == null) {
            AbstractC13042fc3.y("quoteIcon");
            imageView = null;
        }
        K9(imageView);
        ImageView imageView2 = this.quoteIcon;
        if (imageView2 == null) {
            AbstractC13042fc3.y("quoteIcon");
            imageView2 = null;
        }
        imageView2.setImageResource(KB5.ic_reply_blue_24dp);
        TextView textView = this.quoteSender;
        if (textView == null) {
            AbstractC13042fc3.y("quoteSender");
            textView = null;
        }
        K9(textView);
        TextView textView2 = this.quoteText;
        if (textView2 == null) {
            AbstractC13042fc3.y("quoteText");
            textView2 = null;
        }
        K9(textView2);
        View view = this.llIconPhotoContainer;
        if (view == null) {
            AbstractC13042fc3.y("llIconPhotoContainer");
            view = null;
        }
        K9(view);
        MaterialDivider materialDivider = this.quoteDivider;
        if (materialDivider == null) {
            AbstractC13042fc3.y("quoteDivider");
            materialDivider = null;
        }
        K9(materialDivider);
        TextView textView3 = this.quoteSender;
        if (textView3 == null) {
            AbstractC13042fc3.y("quoteSender");
            textView3 = null;
        }
        ta(textView3, null);
        TextView textView4 = this.quoteText;
        if (textView4 == null) {
            AbstractC13042fc3.y("quoteText");
            textView4 = null;
        }
        ta(textView4, null);
        View view2 = this.frameFileImage;
        if (view2 == null) {
            AbstractC13042fc3.y("frameFileImage");
            view2 = null;
        }
        view2.getLayoutParams().width = -2;
        View view3 = this.frameFileImage;
        if (view3 == null) {
            AbstractC13042fc3.y("frameFileImage");
            view3 = null;
        }
        view3.getLayoutParams().height = -2;
        View view4 = this.frameFileImage;
        if (view4 == null) {
            AbstractC13042fc3.y("frameFileImage");
            view4 = null;
        }
        view4.setBackground(null);
        ConstraintLayout constraintLayout2 = this.rootContainer;
        if (constraintLayout2 == null) {
            AbstractC13042fc3.y("rootContainer");
            constraintLayout2 = null;
        }
        constraintLayout2.setBackgroundResource(KB5.quote_fragment_background);
        ConstraintLayout constraintLayout3 = this.rootContainer;
        if (constraintLayout3 == null) {
            AbstractC13042fc3.y("rootContainer");
        } else {
            constraintLayout = constraintLayout3;
        }
        constraintLayout.setPadding(0, 0, 0, 0);
    }

    private final void na() {
        ImageView imageView = this.imgFileType;
        MaterialDivider materialDivider = null;
        if (imageView == null) {
            AbstractC13042fc3.y("imgFileType");
            imageView = null;
        }
        Z8(imageView);
        View view = this.frameFileImage;
        if (view == null) {
            AbstractC13042fc3.y("frameFileImage");
            view = null;
        }
        Z8(view);
        TextView textView = this.quoteText;
        if (textView == null) {
            AbstractC13042fc3.y("quoteText");
            textView = null;
        }
        Z8(textView);
        View view2 = this.llIconPhotoContainer;
        if (view2 == null) {
            AbstractC13042fc3.y("llIconPhotoContainer");
            view2 = null;
        }
        Z8(view2);
        ImageView imageView2 = this.quotePhoto;
        if (imageView2 == null) {
            AbstractC13042fc3.y("quotePhoto");
            imageView2 = null;
        }
        Z8(imageView2);
        TextView textView2 = this.quoteSender;
        if (textView2 == null) {
            AbstractC13042fc3.y("quoteSender");
            textView2 = null;
        }
        Z8(textView2);
        ImageView imageView3 = this.quoteIcon;
        if (imageView3 == null) {
            AbstractC13042fc3.y("quoteIcon");
            imageView3 = null;
        }
        Z8(imageView3);
        TextView textView3 = this.tvFileName;
        if (textView3 == null) {
            AbstractC13042fc3.y("tvFileName");
            textView3 = null;
        }
        Z8(textView3);
        RadioGroup radioGroup = this.rgMovie;
        if (radioGroup == null) {
            AbstractC13042fc3.y("rgMovie");
            radioGroup = null;
        }
        Z8(radioGroup);
        MaterialDivider materialDivider2 = this.quoteDivider;
        if (materialDivider2 == null) {
            AbstractC13042fc3.y("quoteDivider");
        } else {
            materialDivider = materialDivider2;
        }
        Z8(materialDivider);
    }

    private final void oa() {
        this.fileSizeThreshold = this.settingsModule.h3();
    }

    private final InterfaceC13730gj3 pa(Uri uri) {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), C12366eV1.b(), null, new c(uri, null), 2, null);
    }

    private final void ra(String fileName) {
        ImageView imageView = this.quotePhoto;
        ImageView imageView2 = null;
        if (imageView == null) {
            AbstractC13042fc3.y("quotePhoto");
            imageView = null;
        }
        Z8(imageView);
        ImageView imageView3 = this.imgFileType;
        if (imageView3 == null) {
            AbstractC13042fc3.y("imgFileType");
            imageView3 = null;
        }
        K9(imageView3);
        Integer numValueOf = fileName != null ? Integer.valueOf(C5004Hm2.a(AbstractC7270Qz5.INSTANCE.a(fileName))) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            ImageView imageView4 = this.imgFileType;
            if (imageView4 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView4;
            }
            imageView2.setImageResource(KB5.picker_unknown);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -6) {
            ImageView imageView5 = this.imgFileType;
            if (imageView5 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView5;
            }
            imageView2.setImageResource(KB5.picker_apk);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -1) {
            ImageView imageView6 = this.imgFileType;
            if (imageView6 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView6;
            }
            imageView2.setImageResource(KB5.ic_music);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -3) {
            ImageView imageView7 = this.imgFileType;
            if (imageView7 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView7;
            }
            imageView2.setImageResource(KB5.ic_doc);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -4) {
            ImageView imageView8 = this.imgFileType;
            if (imageView8 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView8;
            }
            imageView2.setImageResource(KB5.ic_rar);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -7) {
            ImageView imageView9 = this.imgFileType;
            if (imageView9 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView9;
            }
            imageView2.setImageResource(KB5.ic_zip);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -8) {
            ImageView imageView10 = this.imgFileType;
            if (imageView10 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView10;
            }
            imageView2.setImageResource(KB5.ic_xls);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -9) {
            ImageView imageView11 = this.imgFileType;
            if (imageView11 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView11;
            }
            imageView2.setImageResource(KB5.ic_ppt);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -10) {
            ImageView imageView12 = this.imgFileType;
            if (imageView12 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView12;
            }
            imageView2.setImageResource(KB5.ic_csv);
            return;
        }
        if ((numValueOf != null && numValueOf.intValue() == -11) || (numValueOf != null && numValueOf.intValue() == -12)) {
            ImageView imageView13 = this.imgFileType;
            if (imageView13 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView13;
            }
            imageView2.setImageResource(KB5.ic_code);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == -13) {
            ImageView imageView14 = this.imgFileType;
            if (imageView14 == null) {
                AbstractC13042fc3.y("imgFileType");
            } else {
                imageView2 = imageView14;
            }
            imageView2.setImageResource(KB5.ic_pdf);
            return;
        }
        ImageView imageView15 = this.imgFileType;
        if (imageView15 == null) {
            AbstractC13042fc3.y("imgFileType");
        } else {
            imageView2 = imageView15;
        }
        imageView2.setImageResource(KB5.picker_unknown);
    }

    private final void sa(TextView view, CharSequence text) {
        ua(view, null, text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(TextView view, String text) {
        ua(view, text, null);
    }

    private final void ua(TextView view, String text, CharSequence seq) {
        if (text != null) {
            int length = text.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = AbstractC13042fc3.k(text.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (text.subSequence(i, length + 1).toString().length() > 0) {
                view.setText(text);
                view.setVisibility(0);
                return;
            }
        }
        if (seq == null || seq.length() == 0) {
            view.setVisibility(8);
        } else {
            view.setText(seq);
            view.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0211  */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v9 */
    @Override // ir.nasim.AbstractC7270Qz5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.C4382Ew7 P9(ir.nasim.J44 r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8211Uz5.P9(ir.nasim.J44, boolean):ir.nasim.Ew7");
    }

    @Override // ir.nasim.AbstractC7270Qz5
    public Uri Q9(Uri uri, String inputMimeType) throws IOException {
        if (uri == null) {
            return null;
        }
        this.captionUri = uri;
        InterfaceC13730gj3 interfaceC13730gj3 = this.fileNameLoaderJob;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            this.fileNameLoaderJob = null;
        }
        TextView textView = this.tvFileName;
        if (textView == null) {
            AbstractC13042fc3.y("tvFileName");
            textView = null;
        }
        AbstractC7270Qz5.Companion companion = AbstractC7270Qz5.INSTANCE;
        ta(textView, companion.b(this.captionUri));
        String scheme = uri.getScheme();
        if (scheme != null && AbstractC13042fc3.d(scheme, "content")) {
            this.fileNameLoaderJob = pa(uri);
        }
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        String strC = companion.c(fragmentActivityQ7, uri, inputMimeType);
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = strC.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        if (AbstractC20153rZ6.S(lowerCase, "image/", false, 2, null)) {
            la(false, uri);
            try {
                ImageView imageView = this.quotePhoto;
                if (imageView == null) {
                    AbstractC13042fc3.y("quotePhoto");
                    imageView = null;
                }
                UI2 ui2L1 = OI2.c(imageView).O(uri).u0(new P46(C22078ud6.a(3.0f))).f0(AbstractC4043Dl1.f(S7(), KB5.photoview_placeholder)).l1();
                ImageView imageView2 = this.quotePhoto;
                if (imageView2 == null) {
                    AbstractC13042fc3.y("quotePhoto");
                    imageView2 = null;
                }
                ui2L1.Q0(imageView2);
                ImageView imageView3 = this.quotePhoto;
                if (imageView3 == null) {
                    AbstractC13042fc3.y("quotePhoto");
                    imageView3 = null;
                }
                K9(imageView3);
                View view = this.frameFileImage;
                if (view == null) {
                    AbstractC13042fc3.y("frameFileImage");
                    view = null;
                }
                view.setBackground(null);
            } catch (Exception e) {
                C19406qI3.d("QuotePremiumFragmentNew", e);
            }
        } else {
            Locale locale2 = Locale.getDefault();
            AbstractC13042fc3.h(locale2, "getDefault(...)");
            String lowerCase2 = strC.toLowerCase(locale2);
            AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
            if (AbstractC20153rZ6.S(lowerCase2, "video/", false, 2, null)) {
                RadioGroup radioGroup = this.rgMovie;
                if (radioGroup == null) {
                    AbstractC13042fc3.y("rgMovie");
                    radioGroup = null;
                }
                radioGroup.check(BC5.rbOriginalMovie);
                la(true, uri);
                RadioGroup radioGroup2 = this.rgMovie;
                if (radioGroup2 == null) {
                    AbstractC13042fc3.y("rgMovie");
                    radioGroup2 = null;
                }
                K9(radioGroup2);
                try {
                    ImageView imageView4 = this.quotePhoto;
                    if (imageView4 == null) {
                        AbstractC13042fc3.y("quotePhoto");
                        imageView4 = null;
                    }
                    UI2 ui2L12 = OI2.c(imageView4).O(uri).u0(new P46(C22078ud6.a(3.0f))).f0(AbstractC4043Dl1.f(S7(), KB5.photoview_placeholder)).l1();
                    ImageView imageView5 = this.quotePhoto;
                    if (imageView5 == null) {
                        AbstractC13042fc3.y("quotePhoto");
                        imageView5 = null;
                    }
                    ui2L12.Q0(imageView5);
                    ImageView imageView6 = this.quotePhoto;
                    if (imageView6 == null) {
                        AbstractC13042fc3.y("quotePhoto");
                        imageView6 = null;
                    }
                    K9(imageView6);
                    View view2 = this.frameFileImage;
                    if (view2 == null) {
                        AbstractC13042fc3.y("frameFileImage");
                        view2 = null;
                    }
                    view2.setBackground(null);
                } catch (Exception e2) {
                    C19406qI3.d("QuotePremiumFragmentNew", e2);
                }
            } else {
                Locale locale3 = Locale.getDefault();
                AbstractC13042fc3.h(locale3, "getDefault(...)");
                String lowerCase3 = strC.toLowerCase(locale3);
                AbstractC13042fc3.h(lowerCase3, "toLowerCase(...)");
                if (AbstractC20153rZ6.S(lowerCase3, "media", false, 2, null)) {
                    la(false, uri);
                    ra(companion.b(uri));
                } else {
                    la(false, uri);
                    ra(companion.b(uri));
                }
            }
        }
        return this.captionUri;
    }

    @Override // ir.nasim.AbstractC7270Qz5
    public AbstractC7270Qz5.b T9() {
        AbstractC7270Qz5.b bVar = this.currentVideoCompressionInfo;
        if (bVar == null) {
            return null;
        }
        RadioButton radioButton = this.rbCompressedMovie;
        if (radioButton == null) {
            AbstractC13042fc3.y("rbCompressedMovie");
            radioButton = null;
        }
        return AbstractC7270Qz5.b.b(bVar, 0L, radioButton.isChecked() ? bVar.d() : null, false, 5, null);
    }

    @Override // ir.nasim.AbstractC7270Qz5
    public void U9() {
        this.currentVideoCompressionInfo = null;
        this.currentQuoteRid = 0L;
        this.captionUri = null;
    }

    @Override // ir.nasim.AbstractC7270Qz5
    protected View V9(LayoutInflater inflater, ViewGroup container) {
        AbstractC13042fc3.i(inflater, "inflater");
        View viewInflate = inflater.inflate(AbstractC12208eD5.fragment_quote_premium_new, container, false);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // ir.nasim.AbstractC7270Qz5
    protected void X9(View res) {
        AbstractC13042fc3.i(res, "res");
        this.quoteDivider = (MaterialDivider) res.findViewById(BC5.quote_divider);
        this.rootContainer = (ConstraintLayout) res.findViewById(BC5.quoteContainer);
        this.llIconPhotoContainer = res.findViewById(BC5.llIconPhotoContainer);
        this.imgFileType = (ImageView) res.findViewById(BC5.imgFileType);
        this.frameFileImage = res.findViewById(BC5.frameFileImage);
        this.quoteText = (TextView) res.findViewById(BC5.quote_text);
        this.quotePhoto = (ImageView) res.findViewById(BC5.quote_photo);
        this.quoteSender = (TextView) res.findViewById(BC5.quote_sender);
        this.quoteIcon = (ImageView) res.findViewById(BC5.quote_icon);
        this.tvFileName = (TextView) res.findViewById(BC5.tvFileName);
        this.rgMovie = (RadioGroup) res.findViewById(BC5.rgMovie);
        this.rbCompressedMovie = (RadioButton) res.findViewById(BC5.rbCompressedMovie);
        this.rbGifMovie = (RadioButton) res.findViewById(BC5.rbGifMovie);
        this.rbOriginalMovie = (RadioButton) res.findViewById(BC5.rbOriginalMovie);
        this.divider1 = res.findViewById(BC5.divider1);
        this.divider2 = res.findViewById(BC5.divider2);
        this.tvDesc3 = (TextView) res.findViewById(BC5.tvDesc3);
        this.tvDesc4 = (TextView) res.findViewById(BC5.tvDesc4);
        TextView textView = this.quoteText;
        RadioButton radioButton = null;
        if (textView == null) {
            AbstractC13042fc3.y("quoteText");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.k());
        TextView textView2 = this.quoteSender;
        if (textView2 == null) {
            AbstractC13042fc3.y("quoteSender");
            textView2 = null;
        }
        textView2.setTypeface(C6011Lu2.k());
        RadioGroup radioGroup = this.rgMovie;
        if (radioGroup == null) {
            AbstractC13042fc3.y("rgMovie");
            radioGroup = null;
        }
        radioGroup.check(BC5.rbOriginalMovie);
        TextView textView3 = this.tvFileName;
        if (textView3 == null) {
            AbstractC13042fc3.y("tvFileName");
            textView3 = null;
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView3.setTextColor(c5495Jo7.g1());
        RadioButton radioButton2 = this.rbOriginalMovie;
        if (radioButton2 == null) {
            AbstractC13042fc3.y("rbOriginalMovie");
            radioButton2 = null;
        }
        radioButton2.setTextColor(c5495Jo7.g1());
        RadioButton radioButton3 = this.rbGifMovie;
        if (radioButton3 == null) {
            AbstractC13042fc3.y("rbGifMovie");
            radioButton3 = null;
        }
        radioButton3.setTextColor(c5495Jo7.g1());
        RadioButton radioButton4 = this.rbCompressedMovie;
        if (radioButton4 == null) {
            AbstractC13042fc3.y("rbCompressedMovie");
        } else {
            radioButton = radioButton4;
        }
        radioButton.setTextColor(c5495Jo7.g1());
        View viewFindViewById = res.findViewById(BC5.tvDesc3);
        AbstractC13042fc3.g(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById).setTextColor(c5495Jo7.f1());
        View viewFindViewById2 = res.findViewById(BC5.tvDesc4);
        AbstractC13042fc3.g(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById2).setTextColor(c5495Jo7.f1());
        oa();
        ha();
    }

    @Override // ir.nasim.AbstractC7270Qz5
    protected void Z9() {
        na();
        super.Z9();
    }

    @Override // ir.nasim.AbstractC7270Qz5
    public boolean ba(String rawText) {
        Fragment fragmentU5 = U5();
        if (fragmentU5 instanceof ChatFragment) {
            ChatFragment chatFragment = (ChatFragment) fragmentU5;
            chatFragment.dq("");
            Uri uri = this.captionUri;
            if (uri != null) {
                chatFragment.Kp(uri, rawText, null, qa(), new b(fragmentU5));
                chatFragment.Dl();
                this.captionUri = null;
                U9();
                return false;
            }
        }
        U9();
        return true;
    }

    public boolean qa() {
        RadioButton radioButton = this.rbGifMovie;
        if (radioButton == null) {
            AbstractC13042fc3.y("rbGifMovie");
            radioButton = null;
        }
        return radioButton.isChecked();
    }
}
