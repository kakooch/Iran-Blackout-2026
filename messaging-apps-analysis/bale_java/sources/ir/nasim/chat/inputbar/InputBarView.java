package ir.nasim.chat.inputbar;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.j;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10185bD5;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC11526d93;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13040fc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.AbstractC14828iY7;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15208jB5;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC15742k57;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19652qi7;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20488s57;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC22039uZ6;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.AbstractC23831xb3;
import ir.nasim.AbstractC24667z03;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4572Fs;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC6797Pa1;
import ir.nasim.AbstractC6919Pn6;
import ir.nasim.AbstractC7270Qz5;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9339Zm7;
import ir.nasim.AbstractC9582aC5;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.AbstractC9939ao6;
import ir.nasim.ActionModeCallbackC25231zx1;
import ir.nasim.B26;
import ir.nasim.C10299bQ2;
import ir.nasim.C10743c74;
import ir.nasim.C11458d25;
import ir.nasim.C11494d61;
import ir.nasim.C13245fu;
import ir.nasim.C14697iL2;
import ir.nasim.C14733iO2;
import ir.nasim.C14864ic5;
import ir.nasim.C15225jD4;
import ir.nasim.C15581jp3;
import ir.nasim.C17637nI7;
import ir.nasim.C17784nZ1;
import ir.nasim.C17959nq7;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20171rb5;
import ir.nasim.C21753u45;
import ir.nasim.C22042ua0;
import ir.nasim.C22078ud6;
import ir.nasim.C23104wM2;
import ir.nasim.C23698xM6;
import ir.nasim.C24254yJ;
import ir.nasim.C4892Gz7;
import ir.nasim.C5495Jo7;
import ir.nasim.C5505Jq;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.C7252Qx5;
import ir.nasim.C7880To7;
import ir.nasim.C8386Vt0;
import ir.nasim.C92;
import ir.nasim.CF6;
import ir.nasim.DD5;
import ir.nasim.DG7;
import ir.nasim.EB2;
import ir.nasim.ED1;
import ir.nasim.EM2;
import ir.nasim.EnumC12613eu3;
import ir.nasim.EnumC5360Iz7;
import ir.nasim.F62;
import ir.nasim.FF6;
import ir.nasim.FV0;
import ir.nasim.FV4;
import ir.nasim.G10;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC10503bj0;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11819dc1;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14695iL0;
import ir.nasim.InterfaceC15247jG;
import ir.nasim.InterfaceC15419jZ0;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC19127pp3;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21117t83;
import ir.nasim.InterfaceC21596to4;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC4411Fa0;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9291Zh4;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.J66;
import ir.nasim.JF5;
import ir.nasim.M10;
import ir.nasim.M6;
import ir.nasim.M66;
import ir.nasim.N46;
import ir.nasim.NP0;
import ir.nasim.OK7;
import ir.nasim.PE;
import ir.nasim.QF6;
import ir.nasim.QG2;
import ir.nasim.QJ5;
import ir.nasim.R08;
import ir.nasim.R62;
import ir.nasim.S08;
import ir.nasim.SA2;
import ir.nasim.SO5;
import ir.nasim.T08;
import ir.nasim.TF2;
import ir.nasim.U67;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.V67;
import ir.nasim.VX7;
import ir.nasim.W25;
import ir.nasim.WO5;
import ir.nasim.WZ;
import ir.nasim.XY6;
import ir.nasim.ZN2;
import ir.nasim.chat.ChatFragment;
import ir.nasim.chat.audiorecorder.AudioRecorderView;
import ir.nasim.chat.inputbar.BarEditText;
import ir.nasim.chat.inputbar.InputBarView;
import ir.nasim.core.modules.file.FileSizeExceededException;
import ir.nasim.core.modules.file.GifSizeExceededException;
import ir.nasim.core.modules.file.audio.audiofocus.c;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.designsystem.TintImageView;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.features.keyboard.NewKeyboardLayout;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.features.media.components.PhotoViewerBridge;
import ir.nasim.features.media.components.PhotoViewerInterface;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000¹\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0003E¦\u0002\b\u0007\u0018\u0000 ÷\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\nê\u0001ñ\u0001ô\u0001í\u0001ò\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u0014J\u001f\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010\u0014J\u000f\u0010!\u001a\u00020\u0012H\u0002¢\u0006\u0004\b!\u0010\u0014J\u000f\u0010\"\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010\u0014J\u000f\u0010#\u001a\u00020\u0012H\u0002¢\u0006\u0004\b#\u0010\u0014J\u000f\u0010$\u001a\u00020\u0012H\u0002¢\u0006\u0004\b$\u0010\u0014J\u000f\u0010%\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010\u0014J\u000f\u0010&\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010\u0014J\u000f\u0010'\u001a\u00020\u0012H\u0002¢\u0006\u0004\b'\u0010\u0014J\u0017\u0010*\u001a\u00020\u00122\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00122\u0006\u0010-\u001a\u00020,H\u0003¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00122\u0006\u0010-\u001a\u000200H\u0003¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0012H\u0002¢\u0006\u0004\b3\u0010\u0014J\u000f\u00104\u001a\u00020\u0012H\u0002¢\u0006\u0004\b4\u0010\u0014J\u0017\u00107\u001a\u00020(2\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0012H\u0002¢\u0006\u0004\b9\u0010\u0014J\u000f\u0010:\u001a\u00020\u0012H\u0003¢\u0006\u0004\b:\u0010\u0014J\u0017\u0010<\u001a\u00020\u00122\u0006\u0010;\u001a\u00020(H\u0002¢\u0006\u0004\b<\u0010+J\u000f\u0010=\u001a\u00020\u0012H\u0002¢\u0006\u0004\b=\u0010\u0014J\u000f\u0010>\u001a\u00020\u0012H\u0002¢\u0006\u0004\b>\u0010\u0014J\u000f\u0010?\u001a\u00020\u0012H\u0002¢\u0006\u0004\b?\u0010\u0014J\u0017\u0010B\u001a\u00020\u00122\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u00122\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bD\u0010CJ\u000f\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0012H\u0002¢\u0006\u0004\bH\u0010\u0014J'\u0010L\u001a\u00020(2\u0006\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020(H\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0012H\u0002¢\u0006\u0004\bN\u0010\u0014J!\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020O2\b\u0010Q\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0012H\u0002¢\u0006\u0004\bT\u0010\u0014J\u0017\u0010W\u001a\u00020\u00122\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020\u00122\u0006\u0010V\u001a\u00020UH\u0002¢\u0006\u0004\bY\u0010XJ\u000f\u0010Z\u001a\u00020(H\u0002¢\u0006\u0004\bZ\u0010[J\u0019\u0010]\u001a\u00020\u00122\b\b\u0002\u0010\\\u001a\u00020(H\u0002¢\u0006\u0004\b]\u0010+J\u000f\u0010^\u001a\u00020\u0012H\u0002¢\u0006\u0004\b^\u0010\u0014J\u000f\u0010_\u001a\u00020\u0012H\u0002¢\u0006\u0004\b_\u0010\u0014J\u001f\u0010b\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\u000fH\u0002¢\u0006\u0004\bb\u0010cJ/\u0010h\u001a\u00020\u00122\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000fH\u0002¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\u0012H\u0002¢\u0006\u0004\bj\u0010\u0014J\u000f\u0010k\u001a\u00020\u0012H\u0002¢\u0006\u0004\bk\u0010\u0014J\u0017\u0010n\u001a\u00020\u00122\u0006\u0010m\u001a\u00020lH\u0002¢\u0006\u0004\bn\u0010oJ\u0017\u0010q\u001a\u00020\u00122\u0006\u0010p\u001a\u00020(H\u0002¢\u0006\u0004\bq\u0010+J\u000f\u0010r\u001a\u00020(H\u0002¢\u0006\u0004\br\u0010[J\u000f\u0010s\u001a\u00020\u0012H\u0002¢\u0006\u0004\bs\u0010\u0014J\u0015\u0010u\u001a\u0004\u0018\u00010\u0012*\u00020tH\u0002¢\u0006\u0004\bu\u0010vJ\u0019\u0010z\u001a\u0004\u0018\u00010y2\u0006\u0010x\u001a\u00020wH\u0002¢\u0006\u0004\bz\u0010{J\u0019\u0010~\u001a\u0004\u0018\u00010}2\u0006\u0010x\u001a\u00020|H\u0002¢\u0006\u0004\b~\u0010\u007fJ\u0011\u0010\u0080\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u0014J/\u0010\u0084\u0001\u001a\u00020\u00122\u0007\u0010\u0081\u0001\u001a\u00020(2\u0012\b\u0002\u0010\u0083\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0082\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001b\u0010\u0087\u0001\u001a\u00020\u00122\u0007\u0010\u0086\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001a\u0010\u008a\u0001\u001a\u00020\u00122\u0007\u0010\u0089\u0001\u001a\u00020(H\u0002¢\u0006\u0005\b\u008a\u0001\u0010+J\u0011\u0010\u008b\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u0014J\u0011\u0010\u008c\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u0014J\"\u0010\u008e\u0001\u001a\u00020\u00122\u000e\u0010\u008d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0082\u0001H\u0002¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001c\u0010\u0092\u0001\u001a\u00020\u00122\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001c\u0010\u0096\u0001\u001a\u00020\u00122\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001c\u0010\u009a\u0001\u001a\u00020\u00122\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0017\u0010\u009c\u0001\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b¢\u0006\u0005\b\u009c\u0001\u0010\u000bJ!\u0010 \u0001\u001a\u00020\u00122\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u00030\u009e\u00010\u009d\u0001¢\u0006\u0006\b \u0001\u0010¡\u0001J\u001a\u0010¤\u0001\u001a\u00020\u00122\b\u0010£\u0001\u001a\u00030¢\u0001¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0015\u0010§\u0001\u001a\u0005\u0018\u00010¦\u0001H\u0014¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u0018\u0010ª\u0001\u001a\u00020\u00122\u0007\u0010©\u0001\u001a\u00020(¢\u0006\u0005\bª\u0001\u0010+J\u001c\u0010\u00ad\u0001\u001a\u00020\u00122\n\u0010¬\u0001\u001a\u0005\u0018\u00010«\u0001¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u000f\u0010¯\u0001\u001a\u00020\u0012¢\u0006\u0005\b¯\u0001\u0010\u0014J\u0011\u0010°\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\b°\u0001\u0010\u0014J\u0011\u0010±\u0001\u001a\u00020\u0012H\u0014¢\u0006\u0005\b±\u0001\u0010\u0014J\u000f\u0010²\u0001\u001a\u00020\u0012¢\u0006\u0005\b²\u0001\u0010\u0014J\u000f\u0010³\u0001\u001a\u00020\u0012¢\u0006\u0005\b³\u0001\u0010\u0014J\u001c\u0010¶\u0001\u001a\u00020\u00122\n\u0010µ\u0001\u001a\u0005\u0018\u00010´\u0001¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u000f\u0010¸\u0001\u001a\u00020\u0012¢\u0006\u0005\b¸\u0001\u0010\u0014J*\u0010»\u0001\u001a\u00020\u00122\u0006\u0010f\u001a\u00020\u000f2\u0007\u0010¹\u0001\u001a\u00020\u000f2\u0007\u0010º\u0001\u001a\u00020\u001c¢\u0006\u0006\b»\u0001\u0010¼\u0001J#\u0010¾\u0001\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010\u001c2\u0007\u0010½\u0001\u001a\u00020(¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u001a\u0010Â\u0001\u001a\u00020\u00122\b\u0010Á\u0001\u001a\u00030À\u0001¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u000f\u0010Ä\u0001\u001a\u00020\u0012¢\u0006\u0005\bÄ\u0001\u0010\u0014J\u0018\u0010Æ\u0001\u001a\u00020\u00122\u0007\u0010Å\u0001\u001a\u00020(¢\u0006\u0005\bÆ\u0001\u0010+J\u000f\u0010Ç\u0001\u001a\u00020\u0012¢\u0006\u0005\bÇ\u0001\u0010\u0014J?\u0010Í\u0001\u001a\u00020\u00122\u0007\u0010È\u0001\u001a\u00020(2\u0007\u0010É\u0001\u001a\u00020\u000f2\u0007\u0010Ê\u0001\u001a\u00020\u000f2\u0007\u0010Ë\u0001\u001a\u00020\u000f2\u0007\u0010Ì\u0001\u001a\u00020\u000fH\u0014¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u0011\u0010Ï\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bÏ\u0001\u0010\u0014J\u000f\u0010Ð\u0001\u001a\u00020(¢\u0006\u0005\bÐ\u0001\u0010[J\u0011\u0010Ò\u0001\u001a\u00030Ñ\u0001¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J\u001b\u0010Õ\u0001\u001a\u00020\u00122\t\b\u0001\u0010Ô\u0001\u001a\u00020\u000f¢\u0006\u0006\bÕ\u0001\u0010\u0088\u0001J\u0011\u0010Ö\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bÖ\u0001\u0010\u0014J\u000f\u0010×\u0001\u001a\u00020\u0012¢\u0006\u0005\b×\u0001\u0010\u0014J\u000f\u0010Ø\u0001\u001a\u00020\u0012¢\u0006\u0005\bØ\u0001\u0010\u0014J1\u0010Ü\u0001\u001a\u00020\u00122\u0007\u0010Ù\u0001\u001a\u00020\u000f2\u0014\u0010Û\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00030Ú\u0001\"\u00020\u0003H\u0016¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\u001c\u0010à\u0001\u001a\u00020\u00122\n\u0010ß\u0001\u001a\u0005\u0018\u00010Þ\u0001¢\u0006\u0006\bà\u0001\u0010á\u0001J\u001a\u0010ã\u0001\u001a\u00020\u00122\b\u0010â\u0001\u001a\u00030Þ\u0001¢\u0006\u0006\bã\u0001\u0010á\u0001J\u001c\u0010ä\u0001\u001a\u00020(2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001¢\u0006\u0006\bä\u0001\u0010å\u0001J\u001c\u0010è\u0001\u001a\u00020\u00122\n\u0010ç\u0001\u001a\u0005\u0018\u00010æ\u0001¢\u0006\u0006\bè\u0001\u0010é\u0001J\u0011\u0010ê\u0001\u001a\u00020(H\u0016¢\u0006\u0005\bê\u0001\u0010[J\u0011\u0010ë\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bë\u0001\u0010\u0014J\u0011\u0010ì\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bì\u0001\u0010\u0014J\u0011\u0010í\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bí\u0001\u0010\u0014J\u0011\u0010î\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bî\u0001\u0010\u0014J\u0011\u0010ï\u0001\u001a\u00020\u0012H\u0016¢\u0006\u0005\bï\u0001\u0010\u0014J\u001a\u0010ñ\u0001\u001a\u00020\u00122\u0007\u0010ð\u0001\u001a\u00020@H\u0016¢\u0006\u0005\bñ\u0001\u0010CJ\u001a\u0010ò\u0001\u001a\u00020\u00122\u0007\u0010ð\u0001\u001a\u00020@H\u0016¢\u0006\u0005\bò\u0001\u0010CR\u0018\u0010ö\u0001\u001a\u00030ó\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bô\u0001\u0010õ\u0001R\u001c\u0010ù\u0001\u001a\u0005\u0018\u00010÷\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010ø\u0001R\u001c\u0010ü\u0001\u001a\u0005\u0018\u00010ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010û\u0001R\u001c\u0010ÿ\u0001\u001a\u0005\u0018\u00010ý\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010þ\u0001R\u001c\u0010\u0080\u0002\u001a\u0005\u0018\u00010ý\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010þ\u0001R\u001c\u0010\u0082\u0002\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010\u0081\u0002R\u001c\u0010\u0083\u0002\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010\u0081\u0002R\u001c\u0010\u0085\u0002\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0002\u0010\u0081\u0002R\u001c\u0010\u0086\u0002\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010\u0081\u0002R\u001c\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u0087\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0002\u0010\u0089\u0002R\u001a\u0010A\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010\u008b\u0002R\u0019\u0010\u008e\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u008d\u0002R\u0019\u0010\u0091\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u0090\u0002R*\u0010\u0099\u0002\u001a\u00030\u0092\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0093\u0002\u0010\u0094\u0002\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002\"\u0006\b\u0097\u0002\u0010\u0098\u0002R*\u0010¡\u0002\u001a\u00030\u009a\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u009b\u0002\u0010\u009c\u0002\u001a\u0006\b\u009d\u0002\u0010\u009e\u0002\"\u0006\b\u009f\u0002\u0010 \u0002R\u001c\u0010¥\u0002\u001a\u0005\u0018\u00010¢\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0002\u0010¤\u0002R\u0017\u0010¨\u0002\u001a\u00030¦\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\be\u0010§\u0002R1\u0010±\u0002\u001a\n\u0012\u0005\u0012\u00030ª\u00020©\u00028\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b«\u0002\u0010¬\u0002\u001a\u0006\b\u00ad\u0002\u0010®\u0002\"\u0006\b¯\u0002\u0010°\u0002R\u001c\u0010µ\u0002\u001a\u0005\u0018\u00010²\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0002\u0010´\u0002R\u001a\u0010·\u0002\u001a\u00030«\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¶\u0002\u0010\u0081\u0002R\u001a\u0010¹\u0002\u001a\u00030«\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¸\u0002\u0010\u0081\u0002R\u001b\u0010¼\u0002\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0002\u0010»\u0002R,\u0010Ä\u0002\u001a\u0005\u0018\u00010½\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¾\u0002\u0010¿\u0002\u001a\u0006\bÀ\u0002\u0010Á\u0002\"\u0006\bÂ\u0002\u0010Ã\u0002R*\u0010Ì\u0002\u001a\u00030Å\u00028\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bÆ\u0002\u0010Ç\u0002\u001a\u0006\bÈ\u0002\u0010É\u0002\"\u0006\bÊ\u0002\u0010Ë\u0002R\u0019\u0010Ï\u0002\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÍ\u0002\u0010Î\u0002R\u0019\u0010Ò\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0002\u0010Ñ\u0002R\u0019\u0010Ô\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0002\u0010Ñ\u0002R\u0019\u0010Ö\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0002\u0010\u0090\u0002R'\u0010Ø\u0002\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b×\u0002\u0010\u0090\u0002\u001a\u0005\bØ\u0002\u0010[\"\u0005\bÙ\u0002\u0010+R\u0019\u0010Û\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0002\u0010\u0090\u0002R\u0019\u0010Ý\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0002\u0010\u0090\u0002R\u0019\u0010ß\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0002\u0010\u0090\u0002R\u0019\u0010á\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0002\u0010Ñ\u0002R\u0019\u0010ã\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0002\u0010Ñ\u0002R\u0019\u0010å\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0002\u0010\u0090\u0002R\u0019\u0010ç\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0002\u0010\u0090\u0002R\u001a\u0010ë\u0002\u001a\u00030è\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bé\u0002\u0010ê\u0002R\u001b\u0010í\u0002\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0002\u0010Î\u0002R\u001a\u0010ï\u0002\u001a\u00030«\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bî\u0002\u0010\u0081\u0002R\u001c\u0010ó\u0002\u001a\u0005\u0018\u00010ð\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0002\u0010ò\u0002R\u0019\u0010õ\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0002\u0010Ñ\u0002R\u0019\u0010÷\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0002\u0010Ñ\u0002R\u0019\u0010ù\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0002\u0010\u0090\u0002R\u0019\u0010û\u0002\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0002\u0010\u0090\u0002R\u0019\u0010ý\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0002\u0010Ñ\u0002R\u001a\u0010ÿ\u0002\u001a\u00030ð\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bþ\u0002\u0010ò\u0002R\u0019\u0010\u0081\u0003\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0003\u0010\u0090\u0002R\u001c\u0010\u0085\u0003\u001a\u0005\u0018\u00010\u0082\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0003\u0010\u0084\u0003R\u0019\u0010\u0087\u0003\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0003\u0010\u0090\u0002R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0003\u0010\u0089\u0003R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0003\u0010\u008b\u0003R\u001a\u0010\u008f\u0003\u001a\u00030\u008c\u00038\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008d\u0003\u0010\u008e\u0003R!\u0010\u0094\u0003\u001a\n\u0018\u00010\u0090\u0003R\u00030\u0091\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0003\u0010\u0093\u0003R\u0018\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0095\u0003\u0010\u0096\u0003R\u001b\u0010\u0098\u0003\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0003\u0010Î\u0002R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0003\u0010\u009a\u0003R\u001c\u0010\u009d\u0003\u001a\u0005\u0018\u00010Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0003\u0010\u009c\u0003R\u001c\u0010\u009f\u0003\u001a\u0005\u0018\u00010Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0003\u0010\u009c\u0003R\u001c\u0010£\u0003\u001a\u0005\u0018\u00010 \u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0003\u0010¢\u0003R\u001c\u0010ç\u0001\u001a\u0005\u0018\u00010æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0003\u0010¥\u0003R\u0018\u0010©\u0003\u001a\u00030¦\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0003\u0010¨\u0003R\u0018\u0010\u00ad\u0003\u001a\u00030ª\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0003\u0010¬\u0003R\u001c\u0010±\u0003\u001a\u0005\u0018\u00010®\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0003\u0010°\u0003R\u001c\u0010µ\u0003\u001a\u0005\u0018\u00010²\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0003\u0010´\u0003R,\u0010½\u0003\u001a\u0005\u0018\u00010¶\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b·\u0003\u0010¸\u0003\u001a\u0006\b¹\u0003\u0010º\u0003\"\u0006\b»\u0003\u0010¼\u0003R,\u0010Å\u0003\u001a\u0005\u0018\u00010¾\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¿\u0003\u0010À\u0003\u001a\u0006\bÁ\u0003\u0010Â\u0003\"\u0006\bÃ\u0003\u0010Ä\u0003R8\u0010Í\u0003\u001a\u0011\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u0012\u0018\u00010Æ\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÇ\u0003\u0010È\u0003\u001a\u0006\bÉ\u0003\u0010Ê\u0003\"\u0006\bË\u0003\u0010Ì\u0003R*\u0010Õ\u0003\u001a\u00030Î\u00038\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÏ\u0003\u0010Ð\u0003\u001a\u0006\bÑ\u0003\u0010Ò\u0003\"\u0006\bÓ\u0003\u0010Ô\u0003R\u0019\u0010×\u0003\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0003\u0010Ñ\u0002R\u0018\u0010Û\u0003\u001a\u00030Ø\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÙ\u0003\u0010Ú\u0003R\u0018\u0010ß\u0003\u001a\u00030Ü\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÝ\u0003\u0010Þ\u0003R\u0018\u0010á\u0003\u001a\u00030Ø\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0003\u0010Ú\u0003R\u0018\u0010ã\u0003\u001a\u00030Ü\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0003\u0010Þ\u0003R\u0018\u0010ç\u0003\u001a\u00030ä\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0003\u0010æ\u0003R\u0016\u0010é\u0003\u001a\u00020(8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bè\u0003\u0010[R\u0016\u0010ë\u0003\u001a\u00020(8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bê\u0003\u0010[R\u0018\u0010ï\u0003\u001a\u00030ì\u00038BX\u0082\u0004¢\u0006\b\u001a\u0006\bí\u0003\u0010î\u0003R\u0016\u0010ñ\u0003\u001a\u00020(8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bð\u0003\u0010[R,\u0010I\u001a\u0004\u0018\u00010\u001c2\b\u0010I\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bò\u0003\u0010ó\u0003\"\u0006\b¾\u0001\u0010ô\u0003R\u0013\u0010ö\u0003\u001a\u00020(8F¢\u0006\u0007\u001a\u0005\bõ\u0003\u0010[¨\u0006ú\u0003²\u0006\u000e\u0010ù\u0003\u001a\u00030ø\u00038\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/chat/inputbar/InputBarView;", "Landroid/widget/FrameLayout;", "Lir/nasim/Fa0;", "", "Lir/nasim/to4;", "Lir/nasim/jD4$b;", "Lir/nasim/chat/audiorecorder/AudioRecorderView$b;", "Lir/nasim/WZ;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "B1", "()V", "Y2", "s2", "b2", "k4", "D2", "Landroid/net/Uri;", "uri", "", "mimeType", "K3", "(Landroid/net/Uri;Ljava/lang/String;)V", "B2", "S2", "I2", "v3", "k3", "i2", "a2", "F2", "", "isVisible", "setBotMenuVisibility", "(Z)V", "Lir/nasim/bj0$a;", "menuStateValue", "d0", "(Lir/nasim/bj0$a;Lir/nasim/ub1;I)V", "Lir/nasim/bj0$c;", "l0", "(Lir/nasim/bj0$c;Lir/nasim/ub1;I)V", "l3", "l2", "Landroid/view/MotionEvent;", "event", "W1", "(Landroid/view/MotionEvent;)Z", "c4", "g3", "cancelAudio", "P3", "X3", "T3", "x2", "Landroid/view/View;", "editTextContainer", "S1", "(Landroid/view/View;)V", "I1", "ir/nasim/chat/inputbar/InputBarView$l", "O1", "()Lir/nasim/chat/inputbar/InputBarView$l;", "q4", ParameterNames.TEXT, "index", "checkBefore", "m3", "(Ljava/lang/String;IZ)Z", "X2", "", "time", "fileOutputPath", "V3", "(JLjava/lang/String;)V", "K2", "Lir/nasim/QF6;", "tab", "o4", "(Lir/nasim/QF6;)V", "p4", "y1", "()Z", "dismiss", "z1", "o3", "Q1", "count", "after", "t3", "(II)V", "", "s", "start", "before", "C3", "(Ljava/lang/CharSequence;III)V", "z3", "M3", "Landroid/text/Editable;", "editable", "n3", "(Landroid/text/Editable;)V", "hasText", "D1", "g4", "n4", "Lir/nasim/S08;", "U3", "(Lir/nasim/S08;)Lir/nasim/rB7;", "Lir/nasim/S08$a$a;", "eventType", "Lir/nasim/S08$a;", "L1", "(Lir/nasim/S08$a$a;)Lir/nasim/S08$a;", "Lir/nasim/S08$b$a;", "Lir/nasim/S08$b;", "M1", "(Lir/nasim/S08$b$a;)Lir/nasim/S08$b;", "i3", "showLockButton", "Lkotlin/Function0;", "onEnd", "u1", "(ZLir/nasim/SA2;)V", "value", "l4", "(I)V", "cancel", "Y1", "f3", "Z2", "onDeleteButtonClicked", "j4", "(Lir/nasim/SA2;)V", "Lir/nasim/d25;", "peer", "setPeer", "(Lir/nasim/d25;)V", "Lir/nasim/To7;", "threadId", "setThreadId", "(Lir/nasim/To7;)V", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, "setExPeerType", "(Lir/nasim/core/modules/profile/entity/ExPeerType;)V", "g2", "Lir/nasim/Fq2;", "Lir/nasim/bj0;", "botMenuStateFlow", "r2", "(Lir/nasim/Fq2;)V", "Lir/nasim/WO5;", "replyKeyboardMarkupState", "H2", "(Lir/nasim/WO5;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "isEdit", "setSendButtonContentDescription", "Landroid/widget/ImageView;", "lockButton", "setLockButton", "(Landroid/widget/ImageView;)V", "F1", "m", "onDetachedFromWindow", "U1", "u3", "Landroid/os/Bundle;", "outState", "w3", "(Landroid/os/Bundle;)V", "E3", "end", "inputUrl", "t1", "(IILjava/lang/String;)V", "selectAll", "setText", "(Ljava/lang/String;Z)V", "Landroid/text/Spannable;", "word", "O3", "(Landroid/text/Spannable;)V", "A3", "isDiscussion", "setIsDiscussion", "C1", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "k", "p3", "Lir/nasim/chat/ChatFragment$c;", "getEditMode", "()Lir/nasim/chat/ChatFragment$c;", "hint", "x1", "H1", "setCaptionFilter", "N3", "id", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "Lir/nasim/EM2;", "sendMediaEnabled", "setIsSendMediaEnabled", "(Lir/nasim/EM2;)V", "sendGifEnabled", "setIsSendGifEnabled", "d3", "(Lir/nasim/d25;)Z", "Lir/nasim/features/keyboard/NewKeyboardLayout;", "newKeyboardLayout", "setNewKeyboardLayout", "(Lir/nasim/features/keyboard/NewKeyboardLayout;)V", "e", "h", "g", "d", "f", "i", "lockView", "b", "a", "Landroid/graphics/Rect;", "c", "Landroid/graphics/Rect;", "exclusionRects", "Lir/nasim/chat/inputbar/BarEditText;", "Lir/nasim/chat/inputbar/BarEditText;", "messageEditText", "Lir/nasim/F62;", "Lir/nasim/F62;", "emojiTextWatcher", "Lir/nasim/designsystem/TintImageView;", "Lir/nasim/designsystem/TintImageView;", "sendButton", "sendAudioButton", "Landroid/widget/ImageView;", "attachButton", "audioButton", "j", "audioLockButton", "replayMarkupButton", "Landroidx/compose/ui/platform/ComposeView;", "l", "Landroidx/compose/ui/platform/ComposeView;", "botMenuButton", "Landroid/widget/FrameLayout;", "n", "Ljava/lang/String;", "lastWord", "o", "Z", "isCommentChat", "Lir/nasim/Gz7;", "p", "Lir/nasim/Gz7;", "getTypingModule", "()Lir/nasim/Gz7;", "setTypingModule", "(Lir/nasim/Gz7;)V", "typingModule", "Lir/nasim/TF2;", "q", "Lir/nasim/TF2;", "getGetFilePathFromUriUseCase", "()Lir/nasim/TF2;", "setGetFilePathFromUriUseCase", "(Lir/nasim/TF2;)V", "getFilePathFromUriUseCase", "Lir/nasim/jp3;", "r", "Lir/nasim/jp3;", "keyboardUtils", "ir/nasim/chat/inputbar/InputBarView$i", "Lir/nasim/chat/inputbar/InputBarView$i;", "audioFocusOwner", "Lir/nasim/bL6;", "Lir/nasim/FF6;", "t", "Lir/nasim/bL6;", "getSmilesPanelState", "()Lir/nasim/bL6;", "setSmilesPanelState", "(Lir/nasim/bL6;)V", "smilesPanelState", "Lir/nasim/features/keyboard/a;", "u", "Lir/nasim/features/keyboard/a;", "keyboardManager", "v", "emojiButton", "w", "emojiBadge", "x", "Ljava/lang/Boolean;", "lastSendState", "Lir/nasim/ua0;", "y", "Lir/nasim/ua0;", "getParentFragment", "()Lir/nasim/ua0;", "setParentFragment", "(Lir/nasim/ua0;)V", "parentFragment", "Lir/nasim/designsystem/base/activity/BaseActivity;", "z", "Lir/nasim/designsystem/base/activity/BaseActivity;", "getParentActivity", "()Lir/nasim/designsystem/base/activity/BaseActivity;", "setParentActivity", "(Lir/nasim/designsystem/base/activity/BaseActivity;)V", "parentActivity", "A", "Landroid/view/View;", "res", "B", TokenNames.I, "lastExpandPaddingValue", "D", "lastCollapsePaddingValue", "G", "isAudioEnabled", "H", "isDisableOnEmptyText", "setDisableOnEmptyText", "J", "isEditTextExpanded", "z0", "isEditTextCollapsed", "A0", "runForFirstTime", "B0", "attachButtonVisibility", "C0", "attachBadgeVisibility", "D0", "isTypingDisabled", "E0", "invalidateEditText", "Landroid/view/ViewStub;", "F0", "Landroid/view/ViewStub;", "audioRecorderBarViewStub", "G0", "audioContainer", "H0", "recordPoint", "Landroid/widget/TextView;", "I0", "Landroid/widget/TextView;", "audioSlide", "J0", "downX", "K0", "downY", "L0", "isLocked", "M0", "canBeLocked", "N0", "pointerId", "O0", "audioTimer", "P0", "isAudioVisible", "Landroid/text/TextWatcher;", "Q0", "Landroid/text/TextWatcher;", "inputBarTextWatcher", "R0", ContactEntity.COLUMN_IS_BOT, "S0", "Lir/nasim/d25;", "T0", "Lir/nasim/To7;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "U0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rootView", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "V0", "Landroid/os/PowerManager$WakeLock;", "wakeLock", "W0", "Landroid/content/Context;", "X0", "attachBadge", "Y0", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "Z0", "Lir/nasim/EM2;", "isSendMediaEnabled", "a1", "isSendGifEnabled", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "b1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayoutListener", "c1", "Lir/nasim/features/keyboard/NewKeyboardLayout;", "Lir/nasim/core/modules/settings/SettingsModule;", "d1", "Lir/nasim/core/modules/settings/SettingsModule;", "settingsModule", "Lir/nasim/PE;", "e1", "Lir/nasim/PE;", "appStateModule", "Lir/nasim/R08;", "f1", "Lir/nasim/R08;", "voiceRecorder", "Lir/nasim/chat/audiorecorder/AudioRecorderView;", "g1", "Lir/nasim/chat/audiorecorder/AudioRecorderView;", "audioRecorderView", "Lir/nasim/chat/inputbar/InputBarView$d;", "h1", "Lir/nasim/chat/inputbar/InputBarView$d;", "getLockViewAttacherListener", "()Lir/nasim/chat/inputbar/InputBarView$d;", "setLockViewAttacherListener", "(Lir/nasim/chat/inputbar/InputBarView$d;)V", "lockViewAttacherListener", "Lir/nasim/SO5;", "i1", "Lir/nasim/SO5;", "getReplyKeyboardCallback", "()Lir/nasim/SO5;", "setReplyKeyboardCallback", "(Lir/nasim/SO5;)V", "replyKeyboardCallback", "Lkotlin/Function1;", "j1", "Lir/nasim/UA2;", "getOnSendVoiceRecorderEvent$chat_release", "()Lir/nasim/UA2;", "setOnSendVoiceRecorderEvent$chat_release", "(Lir/nasim/UA2;)V", "onSendVoiceRecorderEvent", "Lir/nasim/T08$g;", "k1", "Lir/nasim/T08$g;", "getVoiceRecorderFactory", "()Lir/nasim/T08$g;", "setVoiceRecorderFactory", "(Lir/nasim/T08$g;)V", "voiceRecorderFactory", "l1", "currentPaddingLeft", "Landroid/view/animation/Animation;", "m1", "Landroid/view/animation/Animation;", "expandAnimation", "Landroid/view/animation/Animation$AnimationListener;", "n1", "Landroid/view/animation/Animation$AnimationListener;", "expandAnimationListener", "o1", "collapseAnimation", "p1", "collapseAnimationListener", "Lir/nasim/CF6;", "q1", "Lir/nasim/CF6;", "smilesKeyboardListener", "b3", "isBadgeEnabledForPoll", "a3", "isBadgeAttachmentEnabled", "Landroid/graphics/drawable/Drawable;", "getVoiceSlideArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "voiceSlideArrowDrawable", "e3", "isSendByEnterEnabled", "getText", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "c3", "isEmojiKeyboardShowing", "r1", "", "rotation", "chat_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class InputBarView extends Hilt_InputBarView implements InterfaceC4411Fa0, InterfaceC21596to4, C15225jD4.b, AudioRecorderView.b, WZ {

    /* renamed from: r1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int s1 = 8;
    private static final int t1 = C22078ud6.a(25.0f);
    private static final int u1 = C22078ud6.a(200.0f);
    private static int v1 = C22078ud6.a(90.0f);

    /* renamed from: A, reason: from kotlin metadata */
    private View res;

    /* renamed from: A0, reason: from kotlin metadata */
    private boolean runForFirstTime;

    /* renamed from: B, reason: from kotlin metadata */
    private int lastExpandPaddingValue;

    /* renamed from: B0, reason: from kotlin metadata */
    private int attachButtonVisibility;

    /* renamed from: C0, reason: from kotlin metadata */
    private int attachBadgeVisibility;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastCollapsePaddingValue;

    /* renamed from: D0, reason: from kotlin metadata */
    private boolean isTypingDisabled;

    /* renamed from: E0, reason: from kotlin metadata */
    private boolean invalidateEditText;

    /* renamed from: F0, reason: from kotlin metadata */
    private ViewStub audioRecorderBarViewStub;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isAudioEnabled;

    /* renamed from: G0, reason: from kotlin metadata */
    private View audioContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isDisableOnEmptyText;

    /* renamed from: H0, reason: from kotlin metadata */
    private ImageView recordPoint;

    /* renamed from: I0, reason: from kotlin metadata */
    private TextView audioSlide;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isEditTextExpanded;

    /* renamed from: J0, reason: from kotlin metadata */
    private int downX;

    /* renamed from: K0, reason: from kotlin metadata */
    private int downY;

    /* renamed from: L0, reason: from kotlin metadata */
    private boolean isLocked;

    /* renamed from: M0, reason: from kotlin metadata */
    private boolean canBeLocked;

    /* renamed from: N0, reason: from kotlin metadata */
    private int pointerId;

    /* renamed from: O0, reason: from kotlin metadata */
    private TextView audioTimer;

    /* renamed from: P0, reason: from kotlin metadata */
    private boolean isAudioVisible;

    /* renamed from: Q0, reason: from kotlin metadata */
    private TextWatcher inputBarTextWatcher;

    /* renamed from: R0, reason: from kotlin metadata */
    private boolean isBot;

    /* renamed from: S0, reason: from kotlin metadata */
    private C11458d25 peer;

    /* renamed from: T0, reason: from kotlin metadata */
    private C7880To7 threadId;

    /* renamed from: U0, reason: from kotlin metadata */
    private ConstraintLayout rootView;

    /* renamed from: V0, reason: from kotlin metadata */
    private PowerManager.WakeLock wakeLock;

    /* renamed from: W0, reason: from kotlin metadata */
    private Context context;

    /* renamed from: X0, reason: from kotlin metadata */
    private View attachBadge;

    /* renamed from: Y0, reason: from kotlin metadata */
    private ExPeerType exPeerType;

    /* renamed from: Z0, reason: from kotlin metadata */
    private EM2 isSendMediaEnabled;

    /* renamed from: a1, reason: from kotlin metadata */
    private EM2 isSendGifEnabled;

    /* renamed from: b1, reason: from kotlin metadata */
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    /* renamed from: c, reason: from kotlin metadata */
    private final Rect exclusionRects;

    /* renamed from: c1, reason: from kotlin metadata */
    private NewKeyboardLayout newKeyboardLayout;

    /* renamed from: d, reason: from kotlin metadata */
    private BarEditText messageEditText;

    /* renamed from: d1, reason: from kotlin metadata */
    private final SettingsModule settingsModule;

    /* renamed from: e, reason: from kotlin metadata */
    private F62 emojiTextWatcher;

    /* renamed from: e1, reason: from kotlin metadata */
    private final PE appStateModule;

    /* renamed from: f, reason: from kotlin metadata */
    private TintImageView sendButton;

    /* renamed from: f1, reason: from kotlin metadata */
    private R08 voiceRecorder;

    /* renamed from: g, reason: from kotlin metadata */
    private TintImageView sendAudioButton;

    /* renamed from: g1, reason: from kotlin metadata */
    private AudioRecorderView audioRecorderView;

    /* renamed from: h, reason: from kotlin metadata */
    private ImageView attachButton;

    /* renamed from: h1, reason: from kotlin metadata */
    private d lockViewAttacherListener;

    /* renamed from: i, reason: from kotlin metadata */
    private ImageView audioButton;

    /* renamed from: i1, reason: from kotlin metadata */
    private SO5 replyKeyboardCallback;

    /* renamed from: j, reason: from kotlin metadata */
    private ImageView audioLockButton;

    /* renamed from: j1, reason: from kotlin metadata */
    private UA2 onSendVoiceRecorderEvent;

    /* renamed from: k, reason: from kotlin metadata */
    private ImageView replayMarkupButton;

    /* renamed from: k1, reason: from kotlin metadata */
    public T08.g voiceRecorderFactory;

    /* renamed from: l, reason: from kotlin metadata */
    private ComposeView botMenuButton;

    /* renamed from: l1, reason: from kotlin metadata */
    private int currentPaddingLeft;

    /* renamed from: m, reason: from kotlin metadata */
    private FrameLayout editTextContainer;

    /* renamed from: m1, reason: from kotlin metadata */
    private final Animation expandAnimation;

    /* renamed from: n, reason: from kotlin metadata */
    private String lastWord;

    /* renamed from: n1, reason: from kotlin metadata */
    private final Animation.AnimationListener expandAnimationListener;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isCommentChat;

    /* renamed from: o1, reason: from kotlin metadata */
    private final Animation collapseAnimation;

    /* renamed from: p, reason: from kotlin metadata */
    public C4892Gz7 typingModule;

    /* renamed from: p1, reason: from kotlin metadata */
    private final Animation.AnimationListener collapseAnimationListener;

    /* renamed from: q, reason: from kotlin metadata */
    public TF2 getFilePathFromUriUseCase;

    /* renamed from: q1, reason: from kotlin metadata */
    private final CF6 smilesKeyboardListener;

    /* renamed from: r, reason: from kotlin metadata */
    private C15581jp3 keyboardUtils;

    /* renamed from: s, reason: from kotlin metadata */
    private final i audioFocusOwner;

    /* renamed from: t, reason: from kotlin metadata */
    public InterfaceC10258bL6 smilesPanelState;

    /* renamed from: u, reason: from kotlin metadata */
    private ir.nasim.features.keyboard.a keyboardManager;

    /* renamed from: v, reason: from kotlin metadata */
    private ImageView emojiButton;

    /* renamed from: w, reason: from kotlin metadata */
    private ImageView emojiBadge;

    /* renamed from: x, reason: from kotlin metadata */
    private Boolean lastSendState;

    /* renamed from: y, reason: from kotlin metadata */
    private C22042ua0 parentFragment;

    /* renamed from: z, reason: from kotlin metadata */
    public BaseActivity parentActivity;

    /* renamed from: z0, reason: from kotlin metadata */
    private boolean isEditTextCollapsed;

    /* renamed from: ir.nasim.chat.inputbar.InputBarView$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final int a() {
            return InputBarView.v1;
        }

        public final void b(View view, boolean z) {
            View view2 = view;
            while (true) {
                if ((view2 != null ? view2.getParent() : null) == null || !(view2.getParent() instanceof ViewGroup)) {
                    return;
                }
                ViewParent parent = view2.getParent();
                AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup.getId() == AbstractC9582aC5.container) {
                    return;
                }
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
                view2 = viewGroup;
            }
        }

        public final void c(int i) {
            InputBarView.v1 = i;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private static final class c implements PhotoViewerAbs.PhotoViewerProviderAbs {
        private final /* synthetic */ PhotoViewerAbs.EmptyPhotoViewerProviderAbs a;
        private final String b;
        private final InterfaceC14603iB2 c;
        private boolean d;
        private String e;
        private final AbstractC14815iX3.b f;

        public c(boolean z, CharSequence charSequence, String str, InterfaceC14603iB2 interfaceC14603iB2) {
            AbstractC13042fc3.i(str, "filePath");
            AbstractC13042fc3.i(interfaceC14603iB2, "onSendPressed");
            this.a = new PhotoViewerAbs.EmptyPhotoViewerProviderAbs();
            this.b = str;
            this.c = interfaceC14603iB2;
            AbstractC14815iX3.b bVar = new AbstractC14815iX3.b(0, 0, 0L, str, 0, z);
            bVar.a = charSequence;
            this.f = bVar;
        }

        public final AbstractC14815iX3.b a() {
            return this.f;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean allowCaption() {
            return true;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public boolean allowSendingSubmenu() {
            return this.a.allowSendingSubmenu();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean canCaptureMorePhotos() {
            return this.a.canCaptureMorePhotos();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public boolean canReplace(int i) {
            return this.a.canReplace(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean canScrollAway() {
            return this.a.canScrollAway();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean cancelButtonPressed() {
            return this.a.cancelButtonPressed();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean closeKeyboard() {
            return this.a.closeKeyboard();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public void deleteImageAtIndex(int i) {
            this.a.deleteImageAtIndex(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public String getDeleteMessageString() {
            return this.a.getDeleteMessageString();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public C10743c74 getEditingMessageObject() {
            return this.a.getEditingMessageObject();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int getPhotoIndex(int i) {
            return this.a.getPhotoIndex(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public PhotoViewerAbs.PlaceProviderObjectAbs getPlaceForPhoto(int i) {
            return this.a.getPlaceForPhoto(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int getSelectedCount() {
            return 1;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public HashMap getSelectedPhotos() {
            return this.a.getSelectedPhotos();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public ArrayList getSelectedPhotosOrder() {
            return this.a.getSelectedPhotosOrder();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public CharSequence getSubtitleFor(int i) {
            return this.a.getSubtitleFor(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public Bitmap getThumbForPhoto(int i) {
            return this.a.getThumbForPhoto(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public CharSequence getTitleFor(int i) {
            return this.a.getTitleFor(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int getTotalImageCount() {
            return this.a.getTotalImageCount();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean isPhotoChecked(int i) {
            return this.d;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean loadMore() {
            return this.a.loadMore();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void needAddMorePhotos() {
            this.a.needAddMorePhotos();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void onApplyCaption(CharSequence charSequence) {
            this.a.onApplyCaption(charSequence);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public void onCaptionChanged(int i, CharSequence charSequence) {
            this.a.onCaptionChanged(i, charSequence);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void onClose() {
            this.a.onClose();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void onOpen() {
            this.a.onOpen();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public void onPathChanged(int i, String str, MediaController.l lVar) {
            this.e = str;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void openPhotoForEdit(String str, String str2, boolean z) {
            this.a.openPhotoForEdit(str, str2, z);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void replaceButtonPressed(int i, H h) {
            this.a.replaceButtonPressed(i, h);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean scaleToFill() {
            return this.a.scaleToFill();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void sendButtonPressed(int i, H h, boolean z, int i2, boolean z2) {
            sendButtonPressed(i, h);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int setPhotoChecked(int i, H h) {
            return this.a.setPhotoChecked(i, h);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public int setPhotoUnchecked(Object obj) {
            return this.a.setPhotoUnchecked(obj);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void updatePhotoAtIndex(int i) {
            this.a.updatePhotoAtIndex(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public boolean validateGroupId(long j) {
            return this.a.validateGroupId(j);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void willHidePhotoViewer() {
            this.a.willHidePhotoViewer();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public void willSwitchFromPhoto(int i) {
            this.a.willSwitchFromPhoto(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public PhotoViewer.D0 getPlaceForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i, boolean z) {
            return this.a.getPlaceForPhoto(c10743c74, abstractC20488s57, i, z);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public ImageReceiver.b getThumbForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
            return this.a.getThumbForPhoto(c10743c74, abstractC20488s57, i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void onCaptionChanged(CharSequence charSequence) {
            this.a.onCaptionChanged(charSequence);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public void sendButtonPressed(int i, H h) {
            InterfaceC14603iB2 interfaceC14603iB2 = this.c;
            AbstractC14815iX3.b bVar = this.f;
            String str = bVar.c;
            if (str == null && (str = bVar.A) == null) {
                str = this.b;
            }
            CharSequence charSequence = bVar.a;
            interfaceC14603iB2.invoke(str, charSequence != null ? charSequence.toString() : null);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public boolean setPhotoChecked(int i) {
            boolean z = !this.d;
            this.d = z;
            return z;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public void willSwitchFromPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
            this.a.willSwitchFromPhoto(c10743c74, abstractC20488s57, i);
        }
    }

    public interface d {
        void a(View view);

        void b(View view);
    }

    private final class e implements InterfaceC15419jZ0 {
        public e() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            C22042ua0 parentFragment = InputBarView.this.getParentFragment();
            ChatFragment chatFragment = parentFragment instanceof ChatFragment ? (ChatFragment) parentFragment : null;
            if (chatFragment != null) {
                chatFragment.Qh();
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            ChatFragment chatFragment;
            AbstractC13042fc3.i(exc, "e");
            C22042ua0 parentFragment = InputBarView.this.getParentFragment();
            ChatFragment chatFragment2 = parentFragment instanceof ChatFragment ? (ChatFragment) parentFragment : null;
            if (chatFragment2 != null) {
                chatFragment2.Qh();
            }
            if (exc instanceof FileSizeExceededException) {
                C22042ua0 parentFragment2 = InputBarView.this.getParentFragment();
                chatFragment = parentFragment2 instanceof ChatFragment ? (ChatFragment) parentFragment2 : null;
                if (chatFragment != null) {
                    chatFragment.cr();
                    return;
                }
                return;
            }
            if (exc instanceof GifSizeExceededException) {
                C22042ua0 parentFragment3 = InputBarView.this.getParentFragment();
                chatFragment = parentFragment3 instanceof ChatFragment ? (ChatFragment) parentFragment3 : null;
                if (chatFragment != null) {
                    chatFragment.Jr(DD5.gif_size_exceeded);
                }
            }
        }
    }

    static final class f implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC10503bj0.c b;

        f(InterfaceC10503bj0.c cVar) {
            this.b = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InputBarView inputBarView, InterfaceC10503bj0.c cVar) {
            AbstractC13042fc3.i(inputBarView, "this$0");
            AbstractC13042fc3.i(cVar, "$menuStateValue");
            androidx.lifecycle.h parentFragment = inputBarView.getParentFragment();
            InterfaceC21117t83 interfaceC21117t83 = parentFragment instanceof InterfaceC21117t83 ? (InterfaceC21117t83) parentFragment : null;
            if (interfaceC21117t83 != null) {
                interfaceC21117t83.p1(cVar);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InputBarView inputBarView, InterfaceC10503bj0.c cVar, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(inputBarView, "this$0");
            AbstractC13042fc3.i(cVar, "$menuStateValue");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.p0(interfaceC11943do6, B26.b.a());
            inputBarView.setContentDescription(cVar.a());
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            int i2 = 1;
            ED1 ed1 = null;
            androidx.compose.ui.e eVarA = androidx.compose.foundation.layout.t.A(aVar, 0.0f, C17784nZ1.q(120.0f), 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(FV0.a(eVarA, N46.d(g10.c(interfaceC22053ub1, i3).a().d())), g10.a(interfaceC22053ub1, i3).I(), null, 2, null);
            interfaceC22053ub1.W(-515613185);
            boolean zD = interfaceC22053ub1.D(InputBarView.this) | interfaceC22053ub1.D(this.b);
            final InputBarView inputBarView = InputBarView.this;
            final InterfaceC10503bj0.c cVar = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.chat.inputbar.c
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return InputBarView.f.d(inputBarView, cVar);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.q.h(androidx.compose.foundation.e.f(eVarD, false, null, null, (SA2) objB, 7, null), androidx.compose.foundation.layout.q.b(g10.c(interfaceC22053ub1, i3).b().u(), g10.c(interfaceC22053ub1, i3).b().r()));
            interfaceC22053ub1.W(-515599640);
            boolean zD2 = interfaceC22053ub1.D(InputBarView.this) | interfaceC22053ub1.D(this.b);
            final InputBarView inputBarView2 = InputBarView.this;
            final InterfaceC10503bj0.c cVar2 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.chat.inputbar.d
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return InputBarView.f.f(inputBarView2, cVar2, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            int i4 = 0;
            androidx.compose.ui.e eVarD2 = AbstractC6919Pn6.d(eVarH, false, (UA2) objB2, 1, null);
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            C24254yJ.f fVarO = C24254yJ.a.o(g10.c(interfaceC22053ub1, i3).b().n());
            InterfaceC10503bj0.c cVar3 = this.b;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, cVarI, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD2);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            AbstractC24667z03.b(FV4.c(AbstractC15208jB5.miniapp, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i3).b().f()), g10.a(interfaceC22053ub1, i3).G(), interfaceC22053ub1, 48, 0);
            long jG = g10.a(interfaceC22053ub1, i3).G();
            C13245fu.b bVar = new C13245fu.b(i4, i2, ed1);
            bVar.append(R62.V(cVar3.a(), null, true));
            AbstractC9339Zm7.c(bVar.o(), null, jG, 0L, null, null, null, 0L, null, null, 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, null, g10.d(interfaceC22053ub1, i3).g(), interfaceC22053ub1, 0, 3120, 120826);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[QF6.values().length];
            try {
                iArr2[QF6.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[QF6.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    public static final class h implements Animation.AnimationListener {
        final /* synthetic */ SA2 a;

        h(SA2 sa2) {
            this.a = sa2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (animation != null) {
                animation.setAnimationListener(null);
            }
            this.a.invoke();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class i implements ir.nasim.core.modules.file.audio.audiofocus.c {
        private final c.a a = c.a.c;
        private final boolean b;

        i() {
        }

        @Override // ir.nasim.core.modules.file.audio.audiofocus.c
        public c.a getContentType() {
            return this.a;
        }

        @Override // ir.nasim.core.modules.file.audio.audiofocus.c
        public boolean q() {
            return this.b;
        }
    }

    public static final class j extends Animation {
        j() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            AbstractC13042fc3.i(transformation, "t");
            Companion companion = InputBarView.INSTANCE;
            ImageView imageView = InputBarView.this.attachButton;
            companion.c(imageView != null ? imageView.getWidth() + C22078ud6.a(6.0f) : C22078ud6.a(12.0f));
            InputBarView inputBarView = InputBarView.this;
            inputBarView.lastCollapsePaddingValue = inputBarView.currentPaddingLeft + ((int) (f * companion.a()));
            FrameLayout frameLayout = InputBarView.this.editTextContainer;
            if (frameLayout != null) {
                frameLayout.setLeft(InputBarView.this.lastCollapsePaddingValue);
                frameLayout.requestLayout();
            }
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public static final class k implements Animation.AnimationListener {
        k() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AbstractC13042fc3.i(animation, "animation");
            InputBarView.this.isEditTextExpanded = false;
            FrameLayout frameLayout = InputBarView.this.editTextContainer;
            if (frameLayout != null) {
                InputBarView inputBarView = InputBarView.this;
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = inputBarView.lastCollapsePaddingValue;
                frameLayout.setLayoutParams(layoutParams2);
                frameLayout.requestLayout();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            AbstractC13042fc3.i(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AbstractC13042fc3.i(animation, "animation");
            InputBarView.this.isEditTextCollapsed = true;
        }
    }

    public static final class l extends R08.b {
        l() {
        }

        private final void n() {
            if (!InputBarView.this.isCommentChat && (InputBarView.this.exPeerType == ExPeerType.PRIVATE || InputBarView.this.exPeerType == ExPeerType.GROUP)) {
                InputBarView.this.getTypingModule().F(InputBarView.this.peer, EnumC5360Iz7.d);
            }
            ir.nasim.core.modules.file.audio.audiofocus.a.h.a().c(InputBarView.this.audioFocusOwner);
            InputBarView.this.getParentActivity().getWindow().clearFlags(128);
            PowerManager.WakeLock wakeLock = InputBarView.this.wakeLock;
            if (wakeLock != null) {
                wakeLock.release();
            }
            InputBarView.this.wakeLock = null;
            InputBarView.this.Y1(true);
        }

        @Override // ir.nasim.R08.b
        public void a(Long l, Throwable th) {
            C19406qI3.a("InputBar", "onRecordCanceled(isAudioVisible: " + InputBarView.this.isAudioVisible + ", throwable: " + th + Separators.RPAREN, new Object[0]);
            S08.a aVarL1 = InputBarView.this.L1(new S08.a.AbstractC0605a.C0606a(l != null ? Integer.valueOf((int) l.longValue()) : null));
            if (aVarL1 != null) {
                InputBarView.this.U3(aVarL1);
            }
            n();
        }

        @Override // ir.nasim.R08.b
        public void d() {
            C19406qI3.a("InputBar", "onRecordPaused(isAudioVisible: " + InputBarView.this.isAudioVisible + Separators.RPAREN, new Object[0]);
            AudioRecorderView audioRecorderView = InputBarView.this.audioRecorderView;
            if (audioRecorderView != null) {
                audioRecorderView.P0();
            }
        }

        @Override // ir.nasim.R08.b
        public void f(long j) {
            if (C8386Vt0.a.R8()) {
                return;
            }
            C19406qI3.a("InputBar", "onRecordProgress(isAudioVisible: " + InputBarView.this.isAudioVisible + Separators.RPAREN, new Object[0]);
            String strA = C17959nq7.a.a((int) (j / ((long) AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)));
            if (JF5.g()) {
                strA = XY6.e(strA);
            }
            TextView textView = InputBarView.this.audioTimer;
            if (textView == null) {
                AbstractC13042fc3.y("audioTimer");
                textView = null;
            }
            textView.setText(strA);
        }

        @Override // ir.nasim.R08.b
        public void h(long j) {
            C19406qI3.a("InputBar", "onRecordResumed(isAudioVisible: " + InputBarView.this.isAudioVisible + ", time: " + j + Separators.RPAREN, new Object[0]);
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            AudioRecorderView audioRecorderView = InputBarView.this.audioRecorderView;
            if (audioRecorderView != null) {
                audioRecorderView.X0(jCurrentTimeMillis);
            }
        }

        @Override // ir.nasim.R08.b
        public void j() {
            C19406qI3.a("InputBar", "onRecordStarted(isAudioVisible: " + InputBarView.this.isAudioVisible + Separators.RPAREN, new Object[0]);
            InputBarView.this.q4();
            if (InputBarView.this.isCommentChat) {
                return;
            }
            if (InputBarView.this.exPeerType == ExPeerType.PRIVATE || InputBarView.this.exPeerType == ExPeerType.GROUP) {
                InputBarView.this.getTypingModule().D(InputBarView.this.peer, EnumC5360Iz7.d);
            }
        }

        @Override // ir.nasim.R08.b
        public void l(long j) {
            C19406qI3.a("InputBar", "onRecordEnd(isAudioVisible: " + InputBarView.this.isAudioVisible + Separators.RPAREN, new Object[0]);
            n();
        }
    }

    public static final class m extends Animation {
        m() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            AbstractC13042fc3.i(transformation, "t");
            int iA = C22078ud6.a(6.0f);
            ComposeView composeView = InputBarView.this.botMenuButton;
            int width = iA + (composeView != null ? composeView.getWidth() : C22078ud6.a(6.0f));
            InputBarView.this.lastExpandPaddingValue = InputBarView.INSTANCE.a() - ((int) (f * (r1.a() - width)));
            FrameLayout frameLayout = InputBarView.this.editTextContainer;
            if (frameLayout != null) {
                frameLayout.setLeft(InputBarView.this.lastExpandPaddingValue);
                frameLayout.requestLayout();
            }
            BarEditText barEditText = InputBarView.this.messageEditText;
            if (barEditText != null) {
                barEditText.setRight(0);
                barEditText.requestLayout();
            }
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public static final class n implements Animation.AnimationListener {
        n() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AbstractC13042fc3.i(animation, "animation");
            InputBarView.this.isEditTextCollapsed = false;
            FrameLayout frameLayout = InputBarView.this.editTextContainer;
            if (frameLayout != null) {
                InputBarView inputBarView = InputBarView.this;
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ConstraintLayout constraintLayout = inputBarView.rootView;
                if (constraintLayout == null) {
                    AbstractC13042fc3.y("rootView");
                    constraintLayout = null;
                }
                layoutParams2.s = constraintLayout.getId();
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = inputBarView.lastExpandPaddingValue;
                frameLayout.setLayoutParams(layoutParams2);
                frameLayout.requestLayout();
            }
            BarEditText barEditText = InputBarView.this.messageEditText;
            if (barEditText != null) {
                ViewGroup.LayoutParams layoutParams3 = barEditText.getLayoutParams();
                AbstractC13042fc3.g(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                layoutParams4.width = -1;
                layoutParams4.rightMargin = 0;
                barEditText.setLayoutParams(layoutParams4);
            }
            if (InputBarView.this.isBot) {
                return;
            }
            InputBarView inputBarView2 = InputBarView.this;
            if (inputBarView2.d3(inputBarView2.peer)) {
                return;
            }
            InputBarView.INSTANCE.c(C22078ud6.a(90.0f));
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            AbstractC13042fc3.i(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            AbstractC13042fc3.i(animation, "animation");
            InputBarView.this.isEditTextExpanded = true;
        }
    }

    static final class o implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InputBarView b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ InputBarView b;

            a(InterfaceC4557Fq2 interfaceC4557Fq2, InputBarView inputBarView) {
                this.a = interfaceC4557Fq2;
                this.b = inputBarView;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.a;
                InterfaceC10503bj0.b bVar = InterfaceC10503bj0.b.a;
                InterfaceC10503bj0 interfaceC10503bj0 = (InterfaceC10503bj0) AbstractC10222bH6.a(interfaceC4557Fq2, bVar, null, interfaceC22053ub1, InterfaceC10503bj0.b.b << 3, 2).getValue();
                if (AbstractC13042fc3.d(interfaceC10503bj0, bVar)) {
                    interfaceC22053ub1.W(-1617114754);
                    interfaceC22053ub1.Q();
                    this.b.setBotMenuVisibility(false);
                } else {
                    if (interfaceC10503bj0 instanceof InterfaceC10503bj0.a) {
                        interfaceC22053ub1.W(-1616972898);
                        this.b.setBotMenuVisibility(true);
                        this.b.d0((InterfaceC10503bj0.a) interfaceC10503bj0, interfaceC22053ub1, InterfaceC10503bj0.a.c);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    if (!(interfaceC10503bj0 instanceof InterfaceC10503bj0.c)) {
                        interfaceC22053ub1.W(86379948);
                        interfaceC22053ub1.Q();
                        throw new NoWhenBranchMatchedException();
                    }
                    interfaceC22053ub1.W(-1616771553);
                    this.b.setBotMenuVisibility(true);
                    this.b.l0((InterfaceC10503bj0.c) interfaceC10503bj0, interfaceC22053ub1, InterfaceC10503bj0.c.c);
                    interfaceC22053ub1.Q();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        o(InterfaceC4557Fq2 interfaceC4557Fq2, InputBarView inputBarView) {
            this.a = interfaceC4557Fq2;
            this.b = inputBarView;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1941611897, true, new a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class p implements InterfaceC19127pp3 {
        p() {
        }

        @Override // ir.nasim.InterfaceC19127pp3
        public void a() {
            InputBarView.this.k3();
        }

        @Override // ir.nasim.InterfaceC19127pp3
        public void b(boolean z) {
            BarEditText barEditText;
            FF6 ff6 = (FF6) InputBarView.this.getSmilesPanelState().getValue();
            InputBarView.this.p4(ff6.c());
            ImageView imageView = InputBarView.this.emojiButton;
            ImageView imageView2 = null;
            if (imageView == null) {
                AbstractC13042fc3.y("emojiButton");
                imageView = null;
            }
            imageView.setImageResource(!ff6.d() ? ff6.c().j() : QF6.b.j());
            ImageView imageView3 = InputBarView.this.emojiButton;
            if (imageView3 == null) {
                AbstractC13042fc3.y("emojiButton");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setColorFilter(C5495Jo7.a.L0());
            if (!z || (barEditText = InputBarView.this.messageEditText) == null) {
                return;
            }
            barEditText.requestFocus();
        }

        @Override // ir.nasim.InterfaceC19127pp3
        public void c() {
            InputBarView inputBarView = InputBarView.this;
            inputBarView.o4(((FF6) inputBarView.getSmilesPanelState().getValue()).c());
            ImageView imageView = InputBarView.this.emojiButton;
            ImageView imageView2 = null;
            if (imageView == null) {
                AbstractC13042fc3.y("emojiButton");
                imageView = null;
            }
            imageView.setImageResource(AbstractC15208jB5.ic_keyboard);
            ImageView imageView3 = InputBarView.this.emojiBadge;
            if (imageView3 == null) {
                AbstractC13042fc3.y("emojiBadge");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(8);
        }

        @Override // ir.nasim.InterfaceC19127pp3
        public void d(boolean z) {
            if (InputBarView.this.replayMarkupButton != null) {
                InputBarView.this.l3();
            }
        }
    }

    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C22042ua0 c;
        final /* synthetic */ InputBarView d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InputBarView c;

            /* renamed from: ir.nasim.chat.inputbar.InputBarView$q$a$a, reason: collision with other inner class name */
            static final class C0984a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ InputBarView d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0984a(InputBarView inputBarView, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = inputBarView;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0984a c0984a = new C0984a(this.d, interfaceC20295rm1);
                    c0984a.c = obj;
                    return c0984a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    int iJ;
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    FF6 ff6 = (FF6) this.c;
                    ImageView imageView = this.d.emojiButton;
                    ImageView imageView2 = null;
                    if (imageView == null) {
                        AbstractC13042fc3.y("emojiButton");
                        imageView = null;
                    }
                    if (ff6.d()) {
                        ImageView imageView3 = this.d.emojiBadge;
                        if (imageView3 == null) {
                            AbstractC13042fc3.y("emojiBadge");
                        } else {
                            imageView2 = imageView3;
                        }
                        imageView2.setVisibility(C8386Vt0.a.W3() && !this.d.y1() ? 0 : 8);
                        iJ = QF6.b.j();
                    } else {
                        ImageView imageView4 = this.d.emojiBadge;
                        if (imageView4 == null) {
                            AbstractC13042fc3.y("emojiBadge");
                        } else {
                            imageView2 = imageView4;
                        }
                        imageView2.setVisibility(C8386Vt0.a.W3() && ff6.c() == QF6.b && !this.d.y1() ? 0 : 8);
                        iJ = ff6.c().j();
                    }
                    imageView.setImageResource(iJ);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(FF6 ff6, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0984a) create(ff6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InputBarView inputBarView, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = inputBarView;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 smilesPanelState = this.c.getSmilesPanelState();
                    C0984a c0984a = new C0984a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(smilesPanelState, c0984a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(C22042ua0 c22042ua0, InputBarView inputBarView, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c22042ua0;
            this.d = inputBarView;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new q(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC18633oz3 interfaceC18633oz3P6 = this.c.p6();
                AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
                j.b bVar = j.b.STARTED;
                a aVar = new a(this.d, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(interfaceC18633oz3P6, bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class r implements TextWatcher {
        r() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "editable");
            InputBarView.this.n3(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "charSequence");
            InputBarView.this.t3(i2, i3);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "charSequence");
            InputBarView.this.C3(charSequence, i, i2, i3);
            if (JF5.d(charSequence.toString()) == 1) {
                BarEditText barEditText = InputBarView.this.messageEditText;
                if (barEditText != null) {
                    barEditText.setGravity(21);
                    return;
                }
                return;
            }
            BarEditText barEditText2 = InputBarView.this.messageEditText;
            if (barEditText2 != null) {
                barEditText2.setGravity(16);
            }
        }
    }

    public static final class s implements TextWatcher {
        s() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "editable");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "charSequence");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "charSequence");
            if (charSequence.length() <= 0 || !AbstractC20153rZ6.D(charSequence.subSequence(charSequence.length() - 1, charSequence.length()).toString(), Separators.RETURN, true)) {
                return;
            }
            InputBarView.this.A3();
        }
    }

    /* synthetic */ class t extends EB2 implements InterfaceC14603iB2 {
        t(Object obj) {
            super(2, obj, InputBarView.class, "sendVoiceFile", "sendVoiceFile(JLjava/lang/String;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y(((Number) obj).longValue(), (String) obj2);
            return C19938rB7.a;
        }

        public final void y(long j, String str) {
            ((InputBarView) this.receiver).V3(j, str);
        }
    }

    /* synthetic */ class u extends EB2 implements InterfaceC14603iB2 {
        u(Object obj) {
            super(2, obj, InputBarView.class, "sendVoiceFile", "sendVoiceFile(JLjava/lang/String;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y(((Number) obj).longValue(), (String) obj2);
            return C19938rB7.a;
        }

        public final void y(long j, String str) {
            ((InputBarView) this.receiver).V3(j, str);
        }
    }

    static final class v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Uri d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ ChatFragment f;
        final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(Uri uri, C11458d25 c11458d25, ChatFragment chatFragment, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = uri;
            this.e = c11458d25;
            this.f = chatFragment;
            this.g = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(InputBarView inputBarView, String str, C14864ic5 c14864ic5, String str2, String str3) {
            C22042ua0 parentFragment = inputBarView.getParentFragment();
            ChatFragment chatFragment = parentFragment instanceof ChatFragment ? (ChatFragment) parentFragment : null;
            if (chatFragment != null) {
                Uri uriFromFile = Uri.fromFile(new File(str2));
                AbstractC13042fc3.h(uriFromFile, "fromFile(...)");
                chatFragment.Kp(uriFromFile, str3, str, false, inputBarView.new e());
            }
            c14864ic5.E0();
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return InputBarView.this.new v(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objR;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                TF2 getFilePathFromUriUseCase = InputBarView.this.getGetFilePathFromUriUseCase();
                Uri uri = this.d;
                this.b = 1;
                objR = getFilePathFromUriUseCase.r(uri, this);
                if (objR == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objR = obj;
            }
            String string = (String) objR;
            PhotoViewerInterface photoViewerAbs = PhotoViewerAbs.getInstance(C8386Vt0.d9());
            C11458d25 c11458d25 = this.e;
            ChatFragment chatFragment = this.f;
            final InputBarView inputBarView = InputBarView.this;
            Uri uri2 = this.d;
            final String str = this.g;
            C20171rb5 c20171rb5 = photoViewerAbs instanceof C20171rb5 ? (C20171rb5) photoViewerAbs : null;
            if (c20171rb5 != null) {
                c20171rb5.c = true;
            }
            Context contextS7 = chatFragment.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = chatFragment.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            final C14864ic5 c14864ic5 = new C14864ic5(c11458d25, contextS7, AbstractC19224pz3.a(interfaceC18633oz3P6), new C14864ic5.b(chatFragment.S7().getString(DD5.input_bar_hint), 4), null, null, 48, null);
            c14864ic5.k0();
            photoViewerAbs.setInputBar(c14864ic5);
            photoViewerAbs.setParentActivity(inputBarView.getParentActivity());
            int i2 = (photoViewerAbs instanceof PhotoViewerBridge ? (PhotoViewerBridge) photoViewerAbs : null) != null ? 2 : 1;
            b bVar = new b(c11458d25, 0, null, null, 14, null);
            if (string == null) {
                string = uri2.toString();
                AbstractC13042fc3.h(string, "toString(...)");
            }
            BarEditText barEditText = inputBarView.messageEditText;
            c cVar = new c(false, barEditText != null ? barEditText.getText() : null, string, new InterfaceC14603iB2() { // from class: ir.nasim.chat.inputbar.e
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return InputBarView.v.y(inputBarView, str, c14864ic5, (String) obj2, (String) obj3);
                }
            });
            photoViewerAbs.openPhotoForSelect(AbstractC10360bX0.g(cVar.a()), 0, i2, true, false, (PhotoViewerAbs.PhotoViewerProviderAbs) cVar, (C11458d25) null, (ExPeerType) null, (NP0) bVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class w implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ InputBarView b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ InputBarView a;

            a(InputBarView inputBarView) {
                this.a = inputBarView;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                Context context = this.a.context;
                if (context == null) {
                    AbstractC13042fc3.y("context");
                    context = null;
                }
                String string = context.getString(DD5.features_chat_input_bar_delete_voice_title);
                AbstractC13042fc3.h(string, "getString(...)");
                AbstractC19555qZ.B0(string, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ InputBarView a;

            b(InputBarView inputBarView) {
                this.a = inputBarView;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                Context context = this.a.context;
                if (context == null) {
                    AbstractC13042fc3.y("context");
                    context = null;
                }
                String string = context.getString(DD5.features_chat_input_bar_delete_voice_body);
                AbstractC13042fc3.h(string, "getString(...)");
                AbstractC19555qZ.e0(string, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        w(SA2 sa2, InputBarView inputBarView) {
            this.a = sa2;
            this.b = inputBarView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2, Dialog dialog) {
            AbstractC13042fc3.i(sa2, "$onDeleteButtonClicked");
            AbstractC13042fc3.i(dialog, "$dialog");
            sa2.invoke();
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1096554187, true, new a(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-253855923, true, new b(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(1726826919);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(dialog);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.chat.inputbar.f
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return InputBarView.w.d(sa2, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = DD5.features_chat_input_bar_delete_voice_delete_button;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(1726836443);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.chat.inputbar.g
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return InputBarView.w.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa22, i2, c1454b, (SA2) objB2, DD5.dialog_cancel, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class x implements CF6 {
        x() {
        }

        @Override // ir.nasim.CF6
        public boolean a() {
            BarEditText barEditText = InputBarView.this.messageEditText;
            if (barEditText != null && barEditText.length() == 0) {
                return false;
            }
            BarEditText barEditText2 = InputBarView.this.messageEditText;
            if (barEditText2 == null) {
                return true;
            }
            barEditText2.dispatchKeyEvent(new KeyEvent(0, 67));
            return true;
        }

        @Override // ir.nasim.CF6
        public void b(C23698xM6 c23698xM6, long j) {
            AbstractC13042fc3.i(c23698xM6, "sticker");
            if (InputBarView.this.getParentFragment() instanceof InterfaceC21117t83) {
                androidx.lifecycle.h parentFragment = InputBarView.this.getParentFragment();
                AbstractC13042fc3.g(parentFragment, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
                ((InterfaceC21117t83) parentFragment).S2(c23698xM6);
                InputBarView.this.p4(QF6.c);
            }
        }

        @Override // ir.nasim.CF6
        public void c() {
            InputBarView inputBarView = InputBarView.this;
            inputBarView.p4(((FF6) inputBarView.getSmilesPanelState().getValue()).c());
            if (InputBarView.this.getParentFragment() instanceof InterfaceC21117t83) {
                androidx.lifecycle.h parentFragment = InputBarView.this.getParentFragment();
                AbstractC13042fc3.g(parentFragment, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
                ((InterfaceC21117t83) parentFragment).D0();
            }
        }

        @Override // ir.nasim.CF6
        public void d() {
            InputBarView inputBarView = InputBarView.this;
            inputBarView.p4(((FF6) inputBarView.getSmilesPanelState().getValue()).c());
            InputBarView.this.o4(QF6.d);
            if (InputBarView.this.getParentFragment() instanceof InterfaceC21117t83) {
                androidx.lifecycle.h parentFragment = InputBarView.this.getParentFragment();
                AbstractC13042fc3.g(parentFragment, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
                ((InterfaceC21117t83) parentFragment).L1();
            }
        }

        @Override // ir.nasim.CF6
        public void e() {
            InputBarView inputBarView = InputBarView.this;
            inputBarView.p4(((FF6) inputBarView.getSmilesPanelState().getValue()).c());
            InputBarView.this.o4(QF6.c);
            if (InputBarView.this.getParentFragment() instanceof InterfaceC21117t83) {
                androidx.lifecycle.h parentFragment = InputBarView.this.getParentFragment();
                AbstractC13042fc3.g(parentFragment, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
                ((InterfaceC21117t83) parentFragment).g1();
            }
        }

        @Override // ir.nasim.CF6
        public void f(String str) {
            F62 f62;
            AbstractC13042fc3.i(str, "emoji");
            BarEditText barEditText = InputBarView.this.messageEditText;
            if (barEditText != null) {
                InputBarView inputBarView = InputBarView.this;
                int selectionEnd = barEditText.getSelectionEnd();
                if (selectionEnd < 0) {
                    selectionEnd = 0;
                }
                try {
                    try {
                        F62 f622 = inputBarView.emojiTextWatcher;
                        if (f622 != null) {
                            f622.b(2);
                        }
                        CharSequence charSequenceW = R62.W(str, barEditText.getPaint().getFontMetricsInt(), AbstractC7426Rr.a.f(20.0f), false, null, null, 48, null);
                        barEditText.setText(barEditText.getText().insert(selectionEnd, charSequenceW));
                        int length = selectionEnd + (charSequenceW != null ? charSequenceW.length() : 0);
                        barEditText.setSelection(length, length);
                        f62 = inputBarView.emojiTextWatcher;
                        if (f62 == null) {
                            return;
                        }
                    } catch (Exception e) {
                        C19406qI3.b("InputBar", "onEmojiSelected error: " + e);
                        f62 = inputBarView.emojiTextWatcher;
                        if (f62 == null) {
                            return;
                        }
                    }
                    f62.b(0);
                } catch (Throwable th) {
                    F62 f623 = inputBarView.emojiTextWatcher;
                    if (f623 != null) {
                        f623.b(0);
                    }
                    throw th;
                }
            }
        }

        @Override // ir.nasim.CF6
        public void g(QG2 qg2) {
            AbstractC13042fc3.i(qg2, "gif");
            if (InputBarView.this.getParentFragment() instanceof InterfaceC21117t83) {
                androidx.lifecycle.h parentFragment = InputBarView.this.getParentFragment();
                AbstractC13042fc3.g(parentFragment, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
                ((InterfaceC21117t83) parentFragment).j5(qg2);
                InputBarView.this.p4(QF6.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBarView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.exclusionRects = new Rect();
        this.lastWord = "";
        this.audioFocusOwner = new i();
        this.isAudioEnabled = true;
        this.isDisableOnEmptyText = true;
        this.isEditTextCollapsed = true;
        this.runForFirstTime = true;
        this.attachBadgeVisibility = 8;
        this.canBeLocked = true;
        this.pointerId = -1;
        C5721Ko c5721Ko = C5721Ko.a;
        this.settingsModule = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).b1();
        this.appStateModule = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).M0();
        this.expandAnimation = new m();
        this.expandAnimationListener = new n();
        this.collapseAnimation = new j();
        this.collapseAnimationListener = new k();
        this.smilesKeyboardListener = new x();
        this.context = context;
    }

    static /* synthetic */ void A1(InputBarView inputBarView, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        inputBarView.z1(z);
    }

    private final void B1() {
        ImageView imageView = this.attachButton;
        if (imageView != null) {
            imageView.setImageResource(AbstractC15208jB5.attach_vd);
        }
        ImageView imageView2 = this.attachButton;
        if (imageView2 != null) {
            imageView2.setColorFilter(C5495Jo7.a.L0());
        }
    }

    private final void B2() {
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            barEditText.setOnKeyListener(new View.OnKeyListener() { // from class: ir.nasim.D83
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    return InputBarView.C2(this.a, view, i2, keyEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C2(InputBarView inputBarView, View view, int i2, KeyEvent keyEvent) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        AbstractC13042fc3.i(keyEvent, "keyEvent");
        if (!inputBarView.e3() || keyEvent.getAction() != 0 || i2 != 66) {
            return false;
        }
        inputBarView.A3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C3(CharSequence s2, int start, int before, int count) {
        int length = AbstractC20762sZ6.n1(s2.toString()).toString().length();
        if (!this.isEditTextExpanded && ((length >= 1 && start == 0 && before < count) || (count > 0 && before < count))) {
            b2();
            FrameLayout frameLayout = this.editTextContainer;
            if (frameLayout != null) {
                C1();
                S1(frameLayout);
            }
        }
        if (!this.isEditTextCollapsed && ((before > 1 && start == 0 && length == 0 && count == 0) || (before <= 1 && length == 0))) {
            k4();
            FrameLayout frameLayout2 = this.editTextContainer;
            if (frameLayout2 != null) {
                C1();
                I1(frameLayout2);
            }
        }
        androidx.lifecycle.h hVar = this.parentFragment;
        if (hVar instanceof InterfaceC21117t83) {
            AbstractC13042fc3.g(hVar, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
            ((InterfaceC21117t83) hVar).c3(s2.toString());
        }
        M3();
    }

    private final void D1(boolean hasText) {
        ChatFragment.EnumC11088c editMode = getEditMode();
        if (this.sendButton == null || this.audioButton == null) {
            return;
        }
        boolean z = (!hasText && this.isDisableOnEmptyText && editMode == ChatFragment.EnumC11088c.a) ? false : true;
        Boolean bool = this.lastSendState;
        if (bool == null || !AbstractC13042fc3.d(bool, Boolean.valueOf(z))) {
            if (z) {
                TintImageView tintImageView = this.sendButton;
                if (tintImageView != null) {
                    tintImageView.setTint(C5495Jo7.a.e2());
                }
                TintImageView tintImageView2 = this.sendButton;
                if (tintImageView2 != null) {
                    tintImageView2.setEnabled(true);
                }
                AbstractC14828iY7.p(this.audioButton);
                AbstractC14828iY7.o(this.sendButton);
            } else {
                TintImageView tintImageView3 = this.sendButton;
                if (tintImageView3 != null) {
                    tintImageView3.setTint(C5495Jo7.a.L0());
                }
                TintImageView tintImageView4 = this.sendButton;
                if (tintImageView4 != null) {
                    tintImageView4.setEnabled(false);
                }
                AbstractC14828iY7.o(this.audioButton);
                AbstractC14828iY7.p(this.sendButton);
            }
            this.lastSendState = Boolean.valueOf(z);
        }
    }

    private final void D2() {
        View view = this.res;
        if (view == null) {
            AbstractC13042fc3.y("res");
            view = null;
        }
        final BarEditText barEditText = (BarEditText) view.findViewById(AbstractC9582aC5.et_message);
        barEditText.setHint(this.isBot ? DD5.chat_bot_message_hint : DD5.chat_message_hint);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        barEditText.setTextColor(c5495Jo7.N0());
        barEditText.setHintTextColor(c5495Jo7.K0());
        barEditText.setGravity(JF5.g() ? 21 : 16);
        barEditText.setOnRichContentSentListener(new BarEditText.a() { // from class: ir.nasim.F83
            @Override // ir.nasim.chat.inputbar.BarEditText.a
            public final void a(Uri uri) {
                InputBarView.E2(barEditText, this, uri);
            }
        });
        this.messageEditText = barEditText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(InputBarView inputBarView) {
        Editable text;
        AbstractC13042fc3.i(inputBarView, "this$0");
        BarEditText barEditText = inputBarView.messageEditText;
        boolean z = false;
        if (barEditText != null && (text = barEditText.getText()) != null && text.length() > 0) {
            z = true;
        }
        inputBarView.D1(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(BarEditText barEditText, InputBarView inputBarView, Uri uri) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        AbstractC13042fc3.i(uri, "uri");
        AbstractC7270Qz5.Companion companion = AbstractC7270Qz5.INSTANCE;
        Context context = barEditText.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        String strD = AbstractC7270Qz5.Companion.d(companion, context, uri, null, 4, null);
        EM2 em2 = inputBarView.isSendMediaEnabled;
        EM2 em22 = EM2.a;
        if (em2 != em22 && AbstractC20762sZ6.X(strD, "image/", false, 2, null) && !AbstractC13042fc3.d(strD, "image/gif")) {
            C22042ua0 c22042ua0 = inputBarView.parentFragment;
            if (c22042ua0 == null) {
                return;
            }
            Context context2 = barEditText.getContext();
            AbstractC13042fc3.h(context2, "getContext(...)");
            AbstractC21375tZ.c(context2, c22042ua0, null, C11494d61.a.c(), 4, null).show();
            return;
        }
        if (inputBarView.isSendGifEnabled != em22 && AbstractC13042fc3.d(strD, "image/gif")) {
            C22042ua0 c22042ua02 = inputBarView.parentFragment;
            if (c22042ua02 == null) {
                return;
            }
            Context context3 = barEditText.getContext();
            AbstractC13042fc3.h(context3, "getContext(...)");
            AbstractC21375tZ.c(context3, c22042ua02, null, C11494d61.a.f(), 4, null).show();
            return;
        }
        if (AbstractC20153rZ6.S(strD, "image/", false, 2, null) && !AbstractC13042fc3.d(strD, "image/gif")) {
            inputBarView.H1();
            inputBarView.K3(uri, strD);
            return;
        }
        C22042ua0 c22042ua03 = inputBarView.parentFragment;
        ChatFragment chatFragment = c22042ua03 instanceof ChatFragment ? (ChatFragment) c22042ua03 : null;
        if (chatFragment != null) {
            chatFragment.Kp(uri, "", null, true, inputBarView.new e());
        }
    }

    private final void F2() {
        ImageView imageView = (ImageView) findViewById(AbstractC9582aC5.bot_replay_markup);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.G83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InputBarView.G2(this.a, view);
            }
        });
        this.replayMarkupButton = imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F3(InputBarView inputBarView, int i2, int i3) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        C22042ua0 c22042ua0 = inputBarView.parentFragment;
        ChatFragment chatFragment = c22042ua0 instanceof ChatFragment ? (ChatFragment) c22042ua0 : null;
        if (chatFragment != null) {
            chatFragment.Qq(i2, i3);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G2(InputBarView inputBarView, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        ir.nasim.features.keyboard.a aVar = inputBarView.keyboardManager;
        if (aVar != null) {
            if (aVar.z()) {
                aVar.t(false);
            }
            if (aVar.x()) {
                inputBarView.F1();
                inputBarView.l3();
            } else {
                aVar.J();
                inputBarView.k3();
            }
        }
    }

    private final void I1(View editTextContainer) {
        this.currentPaddingLeft = editTextContainer.getLeft();
        BarEditText barEditText = this.messageEditText;
        ViewGroup.LayoutParams layoutParams = barEditText != null ? barEditText.getLayoutParams() : null;
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).rightMargin = 0;
        if (this.currentPaddingLeft > 0) {
            editTextContainer.startAnimation(this.collapseAnimation);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ir.nasim.S83
                @Override // java.lang.Runnable
                public final void run() {
                    InputBarView.J1(this.a);
                }
            }, 400L);
        }
    }

    private final void I2() {
        View view = this.res;
        if (view == null) {
            AbstractC13042fc3.y("res");
            view = null;
        }
        TintImageView tintImageView = (TintImageView) view.findViewById(AbstractC9582aC5.ib_send);
        tintImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.L83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InputBarView.J2(this.a, view2);
            }
        });
        this.sendButton = tintImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(InputBarView inputBarView) {
        BarEditText barEditText;
        AbstractC13042fc3.i(inputBarView, "this$0");
        if (inputBarView.keyboardManager == null || !(!r0.y()) || (barEditText = inputBarView.messageEditText) == null) {
            return;
        }
        barEditText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(InputBarView inputBarView, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        inputBarView.A3();
    }

    private final void K2() {
        ChatFragment chatFragment;
        NewKeyboardLayout newKeyboardLayout = this.newKeyboardLayout;
        BarEditText barEditText = this.messageEditText;
        CF6 cf6 = this.smilesKeyboardListener;
        SO5 so5 = this.replyKeyboardCallback;
        C11458d25 c11458d25 = this.peer;
        if (c11458d25 == null || (chatFragment = (ChatFragment) this.parentFragment) == null) {
            return;
        }
        ir.nasim.features.keyboard.a aVar = new ir.nasim.features.keyboard.a(newKeyboardLayout, barEditText, cf6, so5, c11458d25, chatFragment, getSmilesPanelState(), this.isCommentChat);
        aVar.H(new p());
        this.keyboardManager = aVar;
        BarEditText barEditText2 = this.messageEditText;
        if (barEditText2 != null) {
            barEditText2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.A83
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InputBarView.O2(this.a, view);
                }
            });
        }
        BarEditText barEditText3 = this.messageEditText;
        if (barEditText3 != null) {
            barEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.B83
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    InputBarView.P2(this.a, view, z);
                }
            });
        }
        C22042ua0 c22042ua0 = this.parentFragment;
        if (c22042ua0 != null) {
            InterfaceC18633oz3 interfaceC18633oz3P6 = c22042ua0.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new q(c22042ua0, this, null), 3, null);
        }
    }

    private final void K3(Uri uri, String mimeType) {
        C11458d25 c11458d25 = this.peer;
        if (c11458d25 == null) {
            return;
        }
        C22042ua0 c22042ua0 = this.parentFragment;
        ChatFragment chatFragment = c22042ua0 instanceof ChatFragment ? (ChatFragment) c22042ua0 : null;
        if (chatFragment == null) {
            return;
        }
        AbstractC10533bm0.d(AbstractC19224pz3.a(chatFragment), null, null, new v(uri, c11458d25, chatFragment, mimeType, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final S08.a L1(S08.a.AbstractC0605a eventType) {
        ExPeerType exPeerType;
        C11458d25 c11458d25 = this.peer;
        if (c11458d25 == null || (exPeerType = this.exPeerType) == null) {
            return null;
        }
        return new S08.a(c11458d25, exPeerType, eventType);
    }

    private final S08.b M1(S08.b.a eventType) {
        ExPeerType exPeerType;
        C11458d25 c11458d25 = this.peer;
        if (c11458d25 == null || (exPeerType = this.exPeerType) == null) {
            return null;
        }
        return new S08.b(c11458d25, exPeerType, eventType);
    }

    private final void M3() {
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            Editable text = barEditText.getText();
            AbstractC13042fc3.h(text, "getText(...)");
            int selectionStart = barEditText.getSelectionStart();
            int i2 = selectionStart - 1;
            while (i2 >= 0 && text.charAt(i2) != ' ' && text.charAt(i2) != '\n') {
                i2--;
            }
            int i3 = i2 + 1;
            String string = (i3 < 0 || i3 >= selectionStart || i3 >= text.length()) ? "" : text.subSequence(i3, selectionStart).toString();
            if (AbstractC13042fc3.d(this.lastWord, string)) {
                return;
            }
            this.lastWord = string;
            androidx.lifecycle.h hVar = this.parentFragment;
            if (hVar instanceof InterfaceC21117t83) {
                AbstractC13042fc3.g(hVar, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
                ((InterfaceC21117t83) hVar).G2(this.lastWord);
            }
        }
    }

    private final l O1() {
        return new l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O2(InputBarView inputBarView, View view) {
        ir.nasim.features.keyboard.a aVar;
        AbstractC13042fc3.i(inputBarView, "this$0");
        ir.nasim.features.keyboard.a aVar2 = inputBarView.keyboardManager;
        if (aVar2 != null && aVar2.y() && (aVar = inputBarView.keyboardManager) != null) {
            aVar.r(true);
        }
        BarEditText barEditText = inputBarView.messageEditText;
        if (barEditText != null) {
            barEditText.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P2(InputBarView inputBarView, View view, boolean z) {
        ir.nasim.features.keyboard.a aVar;
        ir.nasim.features.keyboard.a aVar2;
        ir.nasim.features.keyboard.a aVar3;
        AbstractC13042fc3.i(inputBarView, "this$0");
        if (!z || (aVar = inputBarView.keyboardManager) == null || !aVar.y() || (aVar2 = inputBarView.keyboardManager) == null || aVar2.x() || (aVar3 = inputBarView.keyboardManager) == null) {
            return;
        }
        aVar3.r(true);
    }

    private final void P3(boolean cancelAudio) {
        C19406qI3.a("InputBar", "resetAudioLock(isAudioVisible: " + this.isAudioVisible + ", cancelAudio: " + cancelAudio + Separators.RPAREN, new Object[0]);
        if (getResources() == null) {
            return;
        }
        this.isLocked = false;
        this.canBeLocked = true;
        Y1(cancelAudio);
        T3();
        TintImageView tintImageView = this.sendAudioButton;
        if (tintImageView != null) {
            tintImageView.setVisibility(8);
        }
        if (this.audioLockButton != null) {
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.c93
                @Override // java.lang.Runnable
                public final void run() {
                    InputBarView.S3(this.a);
                }
            }, 160L);
        }
    }

    private final void Q1() {
        if (this.settingsModule.h5()) {
            this.settingsModule.f6(false);
        }
    }

    private final void S1(View editTextContainer) {
        int left = editTextContainer.getLeft();
        v1 = left;
        if (left > 0) {
            editTextContainer.startAnimation(this.expandAnimation);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ir.nasim.T83
                @Override // java.lang.Runnable
                public final void run() {
                    InputBarView.T1(this.a);
                }
            }, 400L);
        }
    }

    private final void S2() {
        BarEditText barEditText;
        this.inputBarTextWatcher = new r();
        BarEditText barEditText2 = this.messageEditText;
        if (barEditText2 != null) {
            if (e3() && (barEditText = this.messageEditText) != null) {
                barEditText.addTextChangedListener(new s());
            }
            barEditText2.setTextDirection(2);
            F62 f62 = new F62(barEditText2);
            this.emojiTextWatcher = f62;
            barEditText2.addTextChangedListener(f62);
            barEditText2.addTextChangedListener(this.inputBarTextWatcher);
            barEditText2.b(new BarEditText.b() { // from class: ir.nasim.M83
                @Override // ir.nasim.chat.inputbar.BarEditText.b
                public final void a() {
                    InputBarView.V2(this.a);
                }
            });
            barEditText2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.N83
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InputBarView.T2(this.a, view);
                }
            });
            barEditText2.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.O83
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return InputBarView.U2(this.a, view, motionEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S3(InputBarView inputBarView) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        ImageView imageView = inputBarView.audioLockButton;
        if (imageView != null) {
            imageView.setImageResource(AbstractC15208jB5.ba_voicelock_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(InputBarView inputBarView) {
        BarEditText barEditText;
        AbstractC13042fc3.i(inputBarView, "this$0");
        if (inputBarView.keyboardManager == null || !(!r0.y()) || (barEditText = inputBarView.messageEditText) == null) {
            return;
        }
        barEditText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T2(InputBarView inputBarView, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        inputBarView.v3();
    }

    private final void T3() {
        TextView textView;
        if (getResources() == null || (textView = this.audioSlide) == null) {
            return;
        }
        textView.setText(textView.getResources().getString(DD5.chat_voice_record_cancel));
        textView.setOnClickListener(null);
        textView.setCompoundDrawablesWithIntrinsicBounds(getVoiceSlideArrowDrawable(), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setTextColor(C5495Jo7.a.o0());
        textView.setTextSize(14.0f);
        textView.setTypeface(C6011Lu2.k());
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = 21;
        textView.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U2(InputBarView inputBarView, View view, MotionEvent motionEvent) {
        ir.nasim.features.keyboard.a aVar;
        AbstractC13042fc3.i(inputBarView, "this$0");
        inputBarView.v3();
        ir.nasim.features.keyboard.a aVar2 = inputBarView.keyboardManager;
        if (aVar2 != null && aVar2.x() && (aVar = inputBarView.keyboardManager) != null) {
            aVar.s(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C19938rB7 U3(S08 s08) {
        UA2 ua2 = this.onSendVoiceRecorderEvent;
        if (ua2 == null) {
            return null;
        }
        ua2.invoke(s08);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(InputBarView inputBarView) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        inputBarView.z3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V3(final long time, final String fileOutputPath) {
        C19406qI3.a("InputBar", "onSendVoice()", new Object[0]);
        androidx.lifecycle.h hVar = this.parentFragment;
        final InterfaceC21117t83 interfaceC21117t83 = hVar instanceof InterfaceC21117t83 ? (InterfaceC21117t83) hVar : null;
        if (interfaceC21117t83 != null) {
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.P83
                @Override // java.lang.Runnable
                public final void run() {
                    InputBarView.W3(time, fileOutputPath, this, interfaceC21117t83);
                }
            }, 100L);
        }
    }

    private final boolean W1(MotionEvent event) {
        ImageView imageView;
        int i2 = this.pointerId;
        if (i2 != -1 && event.findPointerIndex(i2) < 0) {
            C19406qI3.j("InputBar", "handlesVoiceRecorderTouchEvent(isAudioVisible: " + this.isAudioVisible + ") pointer not matched (pointerId: " + this.pointerId + Separators.RPAREN, new Object[0]);
            return false;
        }
        if (this.isLocked) {
            C19406qI3.j("InputBar", "handlesVoiceRecorderTouchEvent(isAudioVisible: " + this.isAudioVisible + ") isLocked true", new Object[0]);
            return true;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.pointerId = -1;
                this.canBeLocked = true;
                this.downX = 0;
                this.downY = 0;
                Y1(false);
            } else if (actionMasked != 2) {
                if (actionMasked != 3) {
                    return false;
                }
                this.pointerId = -1;
                this.canBeLocked = true;
                this.downX = 0;
                this.downY = 0;
                Y1(false);
            } else {
                if (!this.isAudioVisible) {
                    return false;
                }
                int iE = AbstractC23053wG5.e(this.downY - ((int) event.getY()), 0);
                int iE2 = AbstractC23053wG5.e(this.downX - ((int) event.getX()), 0);
                boolean z = this.canBeLocked;
                boolean z2 = iE2 <= ((int) ((((double) 60) * ((double) AbstractC3742Cd6.c())) + 0.5d));
                this.canBeLocked = z2;
                if (z2 != z) {
                    v1(this, z2, null, 2, null);
                } else {
                    if (Math.abs(iE) > ((int) ((40 * AbstractC3742Cd6.c()) + 0.5d)) && this.canBeLocked) {
                        g3();
                        return true;
                    }
                    if (this.canBeLocked && (imageView = this.audioLockButton) != null) {
                        if (imageView.getVisibility() == 0) {
                            imageView.setTranslationY(-iE);
                        } else if (imageView.getAnimation() != null) {
                            v1(this, true, null, 2, null);
                        }
                    }
                }
                if (iE2 > Math.min((getWidth() * 2) / 3, (int) ((SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER * AbstractC3742Cd6.c()) + 0.5d))) {
                    Y1(true);
                } else {
                    l4(iE2);
                }
            }
        } else {
            if (this.isAudioVisible) {
                return false;
            }
            g4();
            this.pointerId = event.getPointerId(0);
            this.downX = (int) event.getX();
            this.downY = (int) event.getY();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W3(long j2, String str, InputBarView inputBarView, InterfaceC21117t83 interfaceC21117t83) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        AbstractC13042fc3.i(interfaceC21117t83, "$inputBarCallback");
        C19406qI3.a("InputBar", "onAudioSent(" + j2 + ", " + str + Separators.RPAREN, new Object[0]);
        int i2 = (int) j2;
        S08.a aVarL1 = inputBarView.L1(new S08.a.AbstractC0605a.b(Integer.valueOf(i2)));
        if (aVarL1 != null) {
            inputBarView.U3(aVarL1);
        }
        InterfaceC21117t83.M1(interfaceC21117t83, i2, str, null, 4, null);
    }

    private final void X2() {
        R08 m6;
        R08 r08 = this.voiceRecorder;
        if (r08 != null) {
            r08.c();
        }
        if (C8386Vt0.a.P8()) {
            m6 = getVoiceRecorderFactory().a(O1(), new t(this));
        } else {
            Context context = this.context;
            if (context == null) {
                AbstractC13042fc3.y("context");
                context = null;
            }
            u uVar = new u(this);
            l lVarO1 = O1();
            C11458d25 c11458d25 = this.peer;
            Long lValueOf = c11458d25 != null ? Long.valueOf(c11458d25.u()) : null;
            m6 = new M6(context, lValueOf + "_" + System.currentTimeMillis(), lVarO1, uVar);
        }
        this.voiceRecorder = m6;
    }

    private final void X3() {
        TextView textView = this.audioSlide;
        if (textView != null) {
            textView.setText(textView.getResources().getString(DD5.chat_voice_record_lock_cancel));
            textView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.V83
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InputBarView.b4(this.a, view);
                }
            });
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setTextColor(C5495Jo7.a.t2());
            textView.setTextSize(15.0f);
            textView.setTypeface(C6011Lu2.i());
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 17;
            textView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y1(boolean cancel) {
        C19406qI3.a("InputBar", "hideAudio(isAudioVisible: " + this.isAudioVisible + ", cancel: " + cancel + Separators.RPAREN, new Object[0]);
        if (this.isAudioVisible) {
            C8386Vt0 c8386Vt0 = C8386Vt0.a;
            if (c8386Vt0.R8() || this.audioContainer != null) {
                this.isAudioVisible = false;
                if (!c8386Vt0.R8()) {
                    AbstractC14828iY7.l(this.attachButton);
                    this.attachButtonVisibility = 0;
                    AbstractC14828iY7.l(this.messageEditText);
                    ImageView imageView = this.emojiButton;
                    if (imageView == null) {
                        AbstractC13042fc3.y("emojiButton");
                        imageView = null;
                    }
                    AbstractC14828iY7.l(imageView);
                }
                getParentActivity().setRequestedOrientation(-1);
                if (cancel) {
                    R08 r08 = this.voiceRecorder;
                    if (r08 != null) {
                        r08.a();
                    }
                } else {
                    R08 r082 = this.voiceRecorder;
                    if (r082 != null) {
                        r082.g();
                    }
                }
                if (!c8386Vt0.R8()) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, C22078ud6.c(), 0.0f, 0.0f);
                    translateAnimation.setDuration(160L);
                    View view = this.audioContainer;
                    if (view != null) {
                        view.clearAnimation();
                    }
                    View view2 = this.audioContainer;
                    if (view2 != null) {
                        view2.setAnimation(translateAnimation);
                    }
                    View view3 = this.audioContainer;
                    if (view3 != null) {
                        view3.animate();
                    }
                    View view4 = this.audioContainer;
                    if (view4 != null) {
                        view4.setVisibility(8);
                    }
                    v1(this, false, null, 2, null);
                }
                BarEditText barEditText = this.messageEditText;
                if (barEditText != null) {
                    barEditText.requestFocus();
                }
                AudioRecorderView audioRecorderView = this.audioRecorderView;
                if (audioRecorderView != null) {
                    audioRecorderView.F0();
                    return;
                }
                return;
            }
        }
        C19406qI3.j("InputBar", "returned from the hideAudio()", new Object[0]);
    }

    private final void Y2() {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        this.expandAnimation.setAnimationListener(this.expandAnimationListener);
        this.expandAnimation.setInterpolator(accelerateInterpolator);
        this.expandAnimation.setDuration(200L);
        this.collapseAnimation.setAnimationListener(this.collapseAnimationListener);
        this.collapseAnimation.setInterpolator(accelerateInterpolator);
        this.collapseAnimation.setDuration(150L);
    }

    private final void Z2() {
        ir.nasim.features.keyboard.a aVar = this.keyboardManager;
        if (aVar == null || this.messageEditText == null) {
            return;
        }
        if (aVar != null) {
            aVar.r(false);
        }
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            barEditText.clearFocus();
        }
    }

    private final void a2() {
        View view = this.attachBadge;
        if (view != null) {
            view.setVisibility(8);
            this.attachBadgeVisibility = 8;
        }
    }

    private final boolean a3() {
        ExPeerType exPeerType = this.exPeerType;
        int i2 = exPeerType == null ? -1 : g.a[exPeerType.ordinal()];
        return (i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : this.settingsModule.D3() : this.settingsModule.g1() : this.settingsModule.p2()) > 0;
    }

    private final void b2() {
        AbstractC14828iY7.h(this.attachButton, true, false);
        AbstractC14828iY7.h(this.attachBadge, true, false);
    }

    private final boolean b3() {
        return AbstractC15401jX0.i0(AbstractC10360bX0.p(ExPeerType.GROUP, ExPeerType.CHANNEL), this.exPeerType) && this.settingsModule.h5() && C8386Vt0.f9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b4(InputBarView inputBarView, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        inputBarView.P3(true);
    }

    private final void c4() {
        TintImageView tintImageView = this.sendButton;
        if (tintImageView != null) {
            Context context = this.context;
            if (context == null) {
                AbstractC13042fc3.y("context");
                context = null;
            }
            tintImageView.setContentDescription(context.getString(DD5.Send));
        }
        ImageView imageView = this.replayMarkupButton;
        if (imageView == null || imageView.getVisibility() != 0) {
            TintImageView tintImageView2 = this.sendButton;
            if (tintImageView2 != null) {
                tintImageView2.setBackgroundResource(AbstractC15208jB5.ba_send_fill_icon);
                return;
            }
            return;
        }
        TintImageView tintImageView3 = this.sendButton;
        if (tintImageView3 != null) {
            tintImageView3.setBackgroundResource(AbstractC15208jB5.ba_send_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(final InterfaceC10503bj0.a aVar, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1746469052);
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? interfaceC22053ub1J.V(aVar) : interfaceC22053ub1J.D(aVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        int i4 = i3;
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            final InterfaceC9664aL6 interfaceC9664aL6D = AbstractC4572Fs.d(aVar.d() ? 0.0f : 180.0f, null, 0.0f, "Rotation", null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 22);
            int i5 = aVar.d() ? AbstractC15208jB5.collapse_bot_menu : AbstractC15208jB5.expand_bot_menu;
            e.a aVar2 = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i6 = G10.b;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(aVar2, g10.c(interfaceC22053ub1J, i6).b().r());
            interfaceC22053ub1J.W(-789550877);
            boolean zV = interfaceC22053ub1J.V(interfaceC9664aL6D);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Y83
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return InputBarView.h0(interfaceC9664aL6D, (androidx.compose.ui.graphics.c) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(androidx.compose.ui.graphics.b.a(eVarI, (UA2) objB), g10.c(interfaceC22053ub1J, i6).b().j());
            interfaceC22053ub1J.W(-789544782);
            Object objB2 = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
            if (objB2 == aVar3.a()) {
                objB2 = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-789542771);
            boolean zD = interfaceC22053ub1J.D(this) | ((i4 & 14) == 4 || ((i4 & 8) != 0 && interfaceC22053ub1J.D(aVar)));
            Object objB3 = interfaceC22053ub1J.B();
            if (zD || objB3 == aVar3.a()) {
                objB3 = new SA2() { // from class: ir.nasim.Z83
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return InputBarView.i0(this.a, aVar);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC24667z03.b(FV4.c(i5, interfaceC22053ub1J, 0), UY6.c(DD5.bot_command_menu, interfaceC22053ub1J, 0), androidx.compose.foundation.e.d(eVarT, interfaceC18507om4, null, false, null, null, (SA2) objB3, 28, null), g10.a(interfaceC22053ub1J, i6).I(), interfaceC22053ub1J, 0, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.a93
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return InputBarView.j0(this.a, aVar, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d4(InputBarView inputBarView, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        inputBarView.P3(true);
    }

    private static final float e0(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    private final boolean e3() {
        return this.settingsModule.M5();
    }

    private final void f3() {
        FragmentActivity fragmentActivityA5;
        C22042ua0 c22042ua0 = this.parentFragment;
        if (c22042ua0 == null || (fragmentActivityA5 = c22042ua0.A5()) == null) {
            return;
        }
        int i2 = getResources().getConfiguration().orientation;
        int rotation = fragmentActivityA5.getWindowManager().getDefaultDisplay().getRotation();
        if (i2 == 1) {
            if (rotation == 1 || rotation == 2) {
                fragmentActivityA5.setRequestedOrientation(9);
                return;
            } else {
                fragmentActivityA5.setRequestedOrientation(1);
                return;
            }
        }
        if (i2 != 2) {
            return;
        }
        if (rotation == 0 || rotation == 1) {
            fragmentActivityA5.setRequestedOrientation(0);
        } else {
            fragmentActivityA5.setRequestedOrientation(8);
        }
    }

    private final void g3() {
        C19406qI3.a("InputBar", "lockVoiceRecorder(isAudioVisible: " + this.isAudioVisible + ", isLocked: " + this.isLocked + Separators.RPAREN, new Object[0]);
        if (this.isLocked) {
            return;
        }
        this.isLocked = true;
        u1(true, new SA2() { // from class: ir.nasim.U83
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return InputBarView.h3(this.a);
            }
        });
    }

    private final boolean g4() {
        C19406qI3.a("InputBar", "showAudio(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        if (!C5505Jq.F()) {
            C21753u45.a.J0(getParentActivity(), 0, new SA2() { // from class: ir.nasim.z83
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return InputBarView.h4();
                }
            }, C21753u45.d.j, C21753u45.d.m);
            return false;
        }
        if (AbstractC4043Dl1.a(getParentActivity(), "android.permission.RECORD_AUDIO") != 0 || AbstractC4043Dl1.a(C5721Ko.a.d(), "android.permission.VIBRATE") != 0) {
            C21753u45.h0(C21753u45.a, getParentActivity(), 1009, C21753u45.d.s, null, 8, null);
            return false;
        }
        if (this.isAudioVisible) {
            C19406qI3.j("InputBar", "Returned from the showAudio().", new Object[0]);
            return false;
        }
        this.isAudioVisible = true;
        if (!C8386Vt0.a.R8()) {
            AbstractC14828iY7.f(this.attachButton);
            this.attachButtonVisibility = 4;
            ImageView imageView = this.emojiButton;
            if (imageView == null) {
                AbstractC13042fc3.y("emojiButton");
                imageView = null;
            }
            AbstractC14828iY7.f(imageView);
        }
        C22042ua0 c22042ua0 = this.parentFragment;
        if (c22042ua0 instanceof ChatFragment) {
            AbstractC13042fc3.g(c22042ua0, "null cannot be cast to non-null type ir.nasim.chat.ChatFragment");
            ((ChatFragment) c22042ua0).ep();
        }
        f3();
        ir.nasim.core.modules.file.audio.audiofocus.a.h.a().e(this.audioFocusOwner);
        n4();
        return true;
    }

    private final Drawable getVoiceSlideArrowDrawable() {
        Drawable drawableL = AbstractC21710u02.l(getResources().getDrawable(AbstractC15208jB5.conv_voice_slide_arrow));
        AbstractC13042fc3.h(drawableL, "wrap(...)");
        AbstractC21710u02.h(drawableL, C5495Jo7.a.L0());
        return drawableL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h0(InterfaceC9664aL6 interfaceC9664aL6, androidx.compose.ui.graphics.c cVar) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$rotation$delegate");
        AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
        cVar.l(e0(interfaceC9664aL6));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h3(InputBarView inputBarView) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        AbstractC13042fc3.i(inputBarView, "this$0");
        ImageView imageView = inputBarView.audioLockButton;
        if (imageView != null) {
            imageView.setImageResource(AbstractC15208jB5.ba_voicestop_icon);
        }
        TintImageView tintImageView = inputBarView.sendAudioButton;
        if (tintImageView != null) {
            tintImageView.setVisibility(0);
        }
        Object systemService = inputBarView.getContext().getSystemService("vibrator");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(8L);
        inputBarView.X3();
        ImageView imageView2 = inputBarView.audioLockButton;
        if (imageView2 != null && (viewPropertyAnimatorAnimate = imageView2.animate()) != null) {
            viewPropertyAnimatorAnimate.translationY(0.0f);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h4() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i0(InputBarView inputBarView, InterfaceC10503bj0.a aVar) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        AbstractC13042fc3.i(aVar, "$menuStateValue");
        androidx.lifecycle.h hVar = inputBarView.parentFragment;
        InterfaceC21117t83 interfaceC21117t83 = hVar instanceof InterfaceC21117t83 ? (InterfaceC21117t83) hVar : null;
        if (interfaceC21117t83 != null) {
            interfaceC21117t83.p1(aVar);
        }
        return C19938rB7.a;
    }

    private final void i2() {
        View view = this.res;
        View view2 = null;
        if (view == null) {
            AbstractC13042fc3.y("res");
            view = null;
        }
        final ImageView imageView = (ImageView) view.findViewById(AbstractC9582aC5.ib_attach);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.H83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                InputBarView.j2(this.a, imageView, view3);
            }
        });
        this.attachButton = imageView;
        View view3 = this.res;
        if (view3 == null) {
            AbstractC13042fc3.y("res");
        } else {
            view2 = view3;
        }
        View viewFindViewById = view2.findViewById(AbstractC9582aC5.ib_attach_new_feature_badge);
        if (a3() || b3()) {
            viewFindViewById.setVisibility(0);
            this.attachBadgeVisibility = 0;
        } else {
            viewFindViewById.setVisibility(8);
            this.attachBadgeVisibility = 8;
        }
        this.attachBadge = viewFindViewById;
    }

    private final void i3() {
        View view = this.audioContainer;
        ImageView imageView = null;
        if (view == null) {
            ViewStub viewStub = this.audioRecorderBarViewStub;
            if (viewStub == null) {
                AbstractC13042fc3.y("audioRecorderBarViewStub");
                viewStub = null;
            }
            viewStub.inflate();
        } else if (view != null) {
            view.setVisibility(0);
        }
        l4(0);
        String strE = JF5.g() ? XY6.e("00:00") : "00:00";
        TextView textView = this.audioTimer;
        if (textView == null) {
            AbstractC13042fc3.y("audioTimer");
            textView = null;
        }
        textView.setText(strE);
        TextView textView2 = this.audioTimer;
        if (textView2 == null) {
            AbstractC13042fc3.y("audioTimer");
            textView2 = null;
        }
        textView2.setTypeface(C6011Lu2.k());
        TranslateAnimation translateAnimation = new TranslateAnimation(C22078ud6.c(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(160L);
        View view2 = this.audioContainer;
        if (view2 != null) {
            view2.clearAnimation();
        }
        View view3 = this.audioContainer;
        if (view3 != null) {
            view3.setAnimation(translateAnimation);
        }
        View view4 = this.audioContainer;
        if (view4 != null) {
            view4.animate();
        }
        v1(this, true, null, 2, null);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
        ImageView imageView2 = this.recordPoint;
        if (imageView2 == null) {
            AbstractC13042fc3.y("recordPoint");
            imageView2 = null;
        }
        imageView2.clearAnimation();
        ImageView imageView3 = this.recordPoint;
        if (imageView3 == null) {
            AbstractC13042fc3.y("recordPoint");
            imageView3 = null;
        }
        imageView3.setAnimation(alphaAnimation);
        ImageView imageView4 = this.recordPoint;
        if (imageView4 == null) {
            AbstractC13042fc3.y("recordPoint");
        } else {
            imageView = imageView4;
        }
        imageView.animate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j0(InputBarView inputBarView, InterfaceC10503bj0.a aVar, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(inputBarView, "$tmp3_rcvr");
        AbstractC13042fc3.i(aVar, "$menuStateValue");
        inputBarView.d0(aVar, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(InputBarView inputBarView, ImageView imageView, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        ImageView imageView2 = inputBarView.replayMarkupButton;
        if (imageView2 != null) {
            imageView2.setImageDrawable(imageView.getResources().getDrawable(AbstractC15208jB5.category_inputbar));
        }
        inputBarView.o3();
        inputBarView.a2();
    }

    private final void j4(SA2 onDeleteButtonClicked) {
        InterfaceC18633oz3 interfaceC18633oz3A = VX7.a(this);
        if (interfaceC18633oz3A == null) {
            C19406qI3.j("InputBar", "Failed to find lifecycle owner.", new Object[0]);
            onDeleteButtonClicked.invoke();
            return;
        }
        Context context = this.context;
        if (context == null) {
            AbstractC13042fc3.y("context");
            context = null;
        }
        AbstractC21375tZ.c(context, interfaceC18633oz3A, null, AbstractC19242q11.c(903059695, true, new w(onDeleteButtonClicked, this)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k3() {
        ImageView imageView = this.replayMarkupButton;
        if (imageView != null) {
            imageView.setImageDrawable(getResources().getDrawable(AbstractC15208jB5.collapse_bot_menu));
        }
        ImageView imageView2 = this.replayMarkupButton;
        if (imageView2 != null) {
            imageView2.setColorFilter(C5495Jo7.a.e2());
        }
        androidx.lifecycle.h hVar = this.parentFragment;
        InterfaceC21117t83 interfaceC21117t83 = hVar instanceof InterfaceC21117t83 ? (InterfaceC21117t83) hVar : null;
        if (interfaceC21117t83 != null) {
            interfaceC21117t83.j1(true);
        }
    }

    private final void k4() {
        ImageView imageView = this.attachButton;
        if (imageView != null) {
            int i2 = this.attachButtonVisibility;
            if (i2 == 0) {
                AbstractC14828iY7.n(imageView, true, false);
            } else {
                imageView.setVisibility(i2);
            }
        }
        View view = this.attachBadge;
        if (view != null) {
            int i3 = this.attachBadgeVisibility;
            if (i3 == 0) {
                AbstractC14828iY7.n(view, true, false);
            } else {
                view.setVisibility(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(final InterfaceC10503bj0.c cVar, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(471430439);
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? interfaceC22053ub1J.V(cVar) : interfaceC22053ub1J.D(cVar) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(-113928089, true, new f(cVar), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.b93
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return InputBarView.m0(this.a, cVar, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private final void l2() {
        C19406qI3.a("InputBar", "initAudioRecorder(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        View view = this.res;
        View view2 = null;
        if (view == null) {
            AbstractC13042fc3.y("res");
            view = null;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(AbstractC9582aC5.audio_recorder_bar_view_stub);
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: ir.nasim.I83
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub2, View view3) {
                InputBarView.n2(this.a, viewStub2, view3);
            }
        });
        this.audioRecorderBarViewStub = viewStub;
        View view3 = this.res;
        if (view3 == null) {
            AbstractC13042fc3.y("res");
        } else {
            view2 = view3;
        }
        final ImageView imageView = (ImageView) view2.findViewById(AbstractC9582aC5.record_btn);
        imageView.setVisibility(0);
        if (this.isSendMediaEnabled != EM2.a) {
            imageView.getDrawable().setTint(C5495Jo7.a.e0());
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.J83
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    InputBarView.p2(this.a, imageView, view4);
                }
            });
        } else {
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.K83
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view4, MotionEvent motionEvent) {
                    return InputBarView.q2(this.a, view4, motionEvent);
                }
            });
        }
        this.audioButton = imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l3() {
        ImageView imageView = this.replayMarkupButton;
        if (imageView != null) {
            imageView.setImageDrawable(getResources().getDrawable(AbstractC15208jB5.category_inputbar));
        }
        ImageView imageView2 = this.replayMarkupButton;
        if (imageView2 != null) {
            imageView2.setColorFilter(C5495Jo7.a.L0());
        }
        androidx.lifecycle.h hVar = this.parentFragment;
        InterfaceC21117t83 interfaceC21117t83 = hVar instanceof InterfaceC21117t83 ? (InterfaceC21117t83) hVar : null;
        if (interfaceC21117t83 != null) {
            interfaceC21117t83.j1(false);
        }
    }

    private final void l4(int value) {
        TextView textView = this.audioSlide;
        if (textView != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "translationX", textView.getX(), -value);
            objectAnimatorOfFloat.setDuration(0L);
            objectAnimatorOfFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m0(InputBarView inputBarView, InterfaceC10503bj0.c cVar, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(inputBarView, "$tmp0_rcvr");
        AbstractC13042fc3.i(cVar, "$menuStateValue");
        inputBarView.l0(cVar, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final boolean m3(String text, int index, boolean checkBefore) {
        if (checkBefore) {
            if (index > 0) {
                Character chT1 = AbstractC22039uZ6.t1(text, index - 1);
                if (chT1 != null ? Character.isLetterOrDigit(chT1.charValue()) : false) {
                    return true;
                }
            }
        } else if (index < text.length()) {
            Character chT12 = AbstractC22039uZ6.t1(text, index);
            if (chT12 != null ? Character.isLetterOrDigit(chT12.charValue()) : false) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(final InputBarView inputBarView, ViewStub viewStub, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        AbstractC13042fc3.i(view, "inflated");
        inputBarView.audioContainer = view;
        TintImageView tintImageView = (TintImageView) view.findViewById(AbstractC9582aC5.ib_sendAudio);
        tintImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Q83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InputBarView.o2(this.a, view2);
            }
        });
        inputBarView.sendAudioButton = tintImageView;
        inputBarView.audioTimer = (TextView) view.findViewById(AbstractC9582aC5.audioTimer);
        TextView textView = (TextView) view.findViewById(AbstractC9582aC5.audioSlide);
        textView.setCompoundDrawablesWithIntrinsicBounds(inputBarView.getVoiceSlideArrowDrawable(), (Drawable) null, (Drawable) null, (Drawable) null);
        inputBarView.audioSlide = textView;
        inputBarView.recordPoint = (ImageView) view.findViewById(AbstractC9582aC5.record_point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n3(Editable editable) {
        D1(editable.length() > 0);
    }

    private final void n4() {
        C19406qI3.a("InputBar", "startRecording(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        try {
            R08 r08 = this.voiceRecorder;
            if (r08 != null) {
                r08.e();
            }
            S08.a aVarL1 = L1(S08.a.AbstractC0605a.c.b);
            if (aVarL1 != null) {
                U3(aVarL1);
            }
            getParentActivity().getWindow().addFlags(128);
            if (!C8386Vt0.a.R8()) {
                i3();
            }
            if (this.wakeLock == null) {
                Object systemService = C5721Ko.a.d().getSystemService("power");
                AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(536870918, "Bale:BaleRecordWakelock");
                wakeLockNewWakeLock.acquire();
                this.wakeLock = wakeLockNewWakeLock;
            }
        } catch (Exception e2) {
            C19406qI3.d("InputBar", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(InputBarView inputBarView, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        inputBarView.P3(false);
    }

    private final void o3() {
        if (this.parentFragment instanceof InterfaceC21117t83) {
            Q1();
            androidx.lifecycle.h hVar = this.parentFragment;
            AbstractC13042fc3.g(hVar, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
            ((InterfaceC21117t83) hVar).g5();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o4(QF6 tab) {
        C11458d25 c11458d25 = this.peer;
        if ((c11458d25 != null ? c11458d25.s() : null) == W25.b || this.isCommentChat) {
            return;
        }
        int i2 = g.b[tab.ordinal()];
        if (i2 == 1) {
            getTypingModule().E(this.peer, EnumC5360Iz7.l, Integer.valueOf(AbstractC11526d93.a), Integer.valueOf(AbstractC11526d93.b));
        } else {
            if (i2 != 2) {
                return;
            }
            getTypingModule().E(this.peer, EnumC5360Iz7.m, Integer.valueOf(AbstractC11526d93.a), Integer.valueOf(AbstractC11526d93.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(InputBarView inputBarView, ImageView imageView, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        if (inputBarView.isSendMediaEnabled == EM2.c) {
            Toast.makeText(imageView.getContext(), imageView.getContext().getText(inputBarView.isCommentChat ? DD5.default_send_media_permission_denied_comment : DD5.default_send_media_permission_denied), 1).show();
        } else {
            Toast.makeText(imageView.getContext(), imageView.getContext().getText(DD5.send_media_permission_denied), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p4(QF6 tab) {
        C11458d25 c11458d25 = this.peer;
        if ((c11458d25 != null ? c11458d25.s() : null) == W25.b || this.isCommentChat) {
            return;
        }
        int i2 = g.b[tab.ordinal()];
        if (i2 == 1) {
            getTypingModule().F(this.peer, EnumC5360Iz7.l);
        } else {
            if (i2 != 2) {
                return;
            }
            getTypingModule().F(this.peer, EnumC5360Iz7.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q2(InputBarView inputBarView, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        AbstractC13042fc3.i(motionEvent, "event");
        if (!C8386Vt0.a.R8()) {
            return inputBarView.W1(motionEvent);
        }
        AudioRecorderView audioRecorderView = inputBarView.audioRecorderView;
        return audioRecorderView != null && audioRecorderView.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q4() {
        Object systemService = getContext().getSystemService("vibrator");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        Vibrator vibrator = (Vibrator) systemService;
        if (vibrator.hasVibrator()) {
            long[] jArr = {0, 60};
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createWaveform(jArr, -1));
            } else {
                vibrator.vibrate(jArr, -1);
            }
        }
    }

    private final void s2() {
        View view = this.res;
        if (view == null) {
            AbstractC13042fc3.y("res");
            view = null;
        }
        this.editTextContainer = (FrameLayout) view.findViewById(AbstractC9582aC5.editText_container);
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            barEditText.setTypeface(C6011Lu2.k());
        }
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.nasim.C83
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                InputBarView.v2(this.a);
            }
        };
        getRootView().getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s3(InputBarView inputBarView, AudioRecorderView audioRecorderView) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        AbstractC13042fc3.i(audioRecorderView, "$this_run");
        inputBarView.f();
        audioRecorderView.F0();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBotMenuVisibility(boolean isVisible) {
        ComposeView composeView = this.botMenuButton;
        if (composeView != null) {
            composeView.setVisibility(isVisible ? 0 : 8);
        }
        ImageView imageView = this.attachButton;
        if (imageView != null) {
            AbstractC14828iY7.k(imageView, Float.valueOf(isVisible ? 0.0f : 6.0f), null, null, null, 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t3(int count, int after) {
        if (!(this.parentFragment instanceof InterfaceC21117t83) || after <= count || this.isTypingDisabled || getEditMode() != ChatFragment.EnumC11088c.a) {
            return;
        }
        androidx.lifecycle.h hVar = this.parentFragment;
        AbstractC13042fc3.g(hVar, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
        ((InterfaceC21117t83) hVar).j4();
    }

    private final void u1(boolean showLockButton, SA2 onEnd) {
        ImageView imageView;
        ImageView imageView2;
        C19406qI3.a("InputBar", "animateAudioLock(isAudioVisible: " + this.isAudioVisible + ", showLockButton: " + showLockButton + Separators.RPAREN, new Object[0]);
        INSTANCE.b(this.audioLockButton, showLockButton ^ true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (!showLockButton || (imageView2 = this.audioLockButton) == null) ? 0 : imageView2.getHeight(), (showLockButton || (imageView = this.audioLockButton) == null) ? 0 : imageView.getHeight());
        translateAnimation.setDuration(160L);
        if (onEnd != null) {
            translateAnimation.setAnimationListener(new h(onEnd));
        }
        ImageView imageView3 = this.audioLockButton;
        if (imageView3 != null) {
            imageView3.clearAnimation();
            imageView3.setAnimation(translateAnimation);
            imageView3.animate();
            imageView3.setVisibility(showLockButton ? 0 : 8);
        }
    }

    static /* synthetic */ void v1(InputBarView inputBarView, boolean z, SA2 sa2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            sa2 = null;
        }
        inputBarView.u1(z, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(InputBarView inputBarView) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        if (inputBarView.isEditTextExpanded) {
            return;
        }
        BarEditText barEditText = inputBarView.messageEditText;
        if ((barEditText != null ? barEditText.length() : 0) <= 0 || !inputBarView.runForFirstTime) {
            return;
        }
        inputBarView.b2();
        inputBarView.isEditTextCollapsed = false;
        inputBarView.runForFirstTime = false;
        inputBarView.C1();
        FrameLayout frameLayout = inputBarView.editTextContainer;
        if (frameLayout != null) {
            inputBarView.S1(frameLayout);
            BarEditText barEditText2 = inputBarView.messageEditText;
            if (barEditText2 != null) {
                barEditText2.setRight(frameLayout.getRight() - frameLayout.getPaddingRight());
            }
            BarEditText barEditText3 = inputBarView.messageEditText;
            if (barEditText3 != null) {
                barEditText3.requestLayout();
            }
        }
    }

    private final void v3() {
        BarEditText barEditText;
        ir.nasim.features.keyboard.a aVar;
        ir.nasim.features.keyboard.a aVar2;
        if (this.keyboardManager == null || (barEditText = this.messageEditText) == null || !barEditText.hasFocus() || (aVar = this.keyboardManager) == null || !aVar.y() || (aVar2 = this.keyboardManager) == null) {
            return;
        }
        aVar2.r(true);
    }

    private final void x2() {
        View view = this.res;
        View view2 = null;
        if (view == null) {
            AbstractC13042fc3.y("res");
            view = null;
        }
        ImageView imageView = (ImageView) view.findViewById(AbstractC9582aC5.ib_emoji);
        imageView.setColorFilter(C5495Jo7.a.L0());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.E83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                InputBarView.z2(this.a, view3);
            }
        });
        this.emojiButton = imageView;
        View view3 = this.res;
        if (view3 == null) {
            AbstractC13042fc3.y("res");
        } else {
            view2 = view3;
        }
        ImageView imageView2 = (ImageView) view2.findViewById(AbstractC9582aC5.emoji_badge);
        AbstractC13042fc3.f(imageView2);
        imageView2.setVisibility(C8386Vt0.a.W3() && !y1() ? 0 : 8);
        this.emojiBadge = imageView2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y1() {
        return C7183Qq.p().h("HAS_SEEN_YALDA_STICKERS", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence y3(Bundle bundle, String str) {
        return "key: " + str + " -> value: " + bundle.get(str);
    }

    private final void z1(boolean dismiss) {
        ir.nasim.features.keyboard.a aVar;
        FrameLayout frameLayout;
        C11458d25 c11458d25 = this.peer;
        if ((c11458d25 != null ? c11458d25.s() : null) == null) {
            return;
        }
        boolean z = this.exPeerType == ExPeerType.BOT;
        this.isBot = z;
        if (z && (frameLayout = this.editTextContainer) != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            frameLayout.setLayoutParams((ConstraintLayout.LayoutParams) layoutParams);
        }
        if (!dismiss || (aVar = this.keyboardManager) == null) {
            return;
        }
        aVar.s(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(InputBarView inputBarView, View view) {
        AbstractC13042fc3.i(inputBarView, "this$0");
        inputBarView.l3();
        ir.nasim.features.keyboard.a aVar = inputBarView.keyboardManager;
        if (aVar != null) {
            aVar.M();
        }
    }

    private final void z3() {
        M3();
    }

    public final void A3() {
        if (getResources().getDisplayMetrics().heightPixels <= getResources().getDisplayMetrics().widthPixels) {
            C15581jp3 c15581jp3 = this.keyboardUtils;
            if (c15581jp3 != null) {
                c15581jp3.c(this.messageEditText, false);
            }
            BarEditText barEditText = this.messageEditText;
            if (barEditText != null) {
                barEditText.clearFocus();
            }
        }
        androidx.lifecycle.h hVar = this.parentFragment;
        if (hVar instanceof InterfaceC21117t83) {
            AbstractC13042fc3.g(hVar, "null cannot be cast to non-null type ir.nasim.chat.inputbar.InputBarCallback");
            InterfaceC21117t83 interfaceC21117t83 = (InterfaceC21117t83) hVar;
            BarEditText barEditText2 = this.messageEditText;
            interfaceC21117t83.i3(barEditText2 != null ? barEditText2.getText() : null);
        }
    }

    public final void C1() {
        if (this.messageEditText == null) {
            return;
        }
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.x83
            @Override // java.lang.Runnable
            public final void run() {
                InputBarView.E1(this.a);
            }
        });
    }

    public final void E3() {
        if (this.keyboardManager != null) {
            return;
        }
        Context context = null;
        A1(this, false, 1, null);
        Context context2 = this.context;
        if (context2 == null) {
            AbstractC13042fc3.y("context");
        } else {
            context = context2;
        }
        g2(context);
        K2();
        C15225jD4.b().a(this, C15225jD4.i);
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            if (C8386Vt0.a.H5()) {
                ActionModeCallbackC25231zx1 actionModeCallbackC25231zx1 = new ActionModeCallbackC25231zx1(this.messageEditText, new InterfaceC14603iB2() { // from class: ir.nasim.y83
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return InputBarView.F3(this.a, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    }
                });
                barEditText.setCustomInsertionActionModeCallback(actionModeCallbackC25231zx1);
                barEditText.setCustomSelectionActionModeCallback(actionModeCallbackC25231zx1);
            }
            ViewGroup.LayoutParams layoutParams = barEditText.getLayoutParams();
            AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = -1;
            layoutParams2.rightMargin = 0;
            barEditText.setLayoutParams(layoutParams2);
            barEditText.requestLayout();
        }
        C19406qI3.a("InputBar", "onViewCreated(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        AudioRecorderView audioRecorderView = this.audioRecorderView;
        if (audioRecorderView != null) {
            audioRecorderView.setListener(this);
        }
        X2();
    }

    public final void F1() {
        ir.nasim.features.keyboard.a aVar = this.keyboardManager;
        if (aVar != null) {
            aVar.s(false);
        }
    }

    public void H1() {
        Z2();
    }

    public final void H2(WO5 replyKeyboardMarkupState) {
        AbstractC13042fc3.i(replyKeyboardMarkupState, "replyKeyboardMarkupState");
        ImageView imageView = this.replayMarkupButton;
        if (imageView != null) {
            imageView.setVisibility(0);
            c4();
        }
        if (replyKeyboardMarkupState instanceof WO5.b) {
            k3();
            ir.nasim.features.keyboard.a aVar = this.keyboardManager;
            if (aVar != null) {
                aVar.J();
            }
        } else {
            if (!(replyKeyboardMarkupState instanceof WO5.a)) {
                throw new NoWhenBranchMatchedException();
            }
            l3();
            F1();
        }
        ir.nasim.features.keyboard.a aVar2 = this.keyboardManager;
        if (aVar2 != null) {
            aVar2.I(replyKeyboardMarkupState.a());
        }
    }

    public final void N3() {
    }

    public final void O3(Spannable word) {
        AbstractC13042fc3.i(word, "word");
        this.isTypingDisabled = true;
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            Editable text = barEditText.getText();
            int selectionEnd = barEditText.getSelectionEnd();
            int selectionStart = barEditText.getSelectionStart() - 1;
            while (selectionStart >= 0 && text.charAt(selectionStart) != ' ' && text.charAt(selectionStart) != '\n') {
                selectionStart--;
            }
            int i2 = selectionStart + 1;
            while (selectionEnd < text.length() && text.charAt(selectionEnd) != ' ' && text.charAt(selectionEnd) != '\n') {
                selectionEnd++;
            }
            if (i2 >= 0 && i2 < selectionEnd && selectionEnd <= text.length()) {
                boolean z = selectionEnd == text.length();
                Editable editableReplace = text.replace(i2, selectionEnd, word);
                if (z) {
                    editableReplace = editableReplace.append(' ');
                }
                barEditText.setText(editableReplace);
                if (z) {
                    barEditText.setSelection(editableReplace.length());
                } else {
                    barEditText.setSelection(i2 + word.length() + 1);
                }
            }
        }
        this.isTypingDisabled = false;
    }

    public final void U1() {
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            barEditText.requestFocus();
        }
        ir.nasim.features.keyboard.a aVar = this.keyboardManager;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.b
    public void a(View lockView) {
        AbstractC13042fc3.i(lockView, "lockView");
        d dVar = this.lockViewAttacherListener;
        if (dVar != null) {
            dVar.a(lockView);
        }
    }

    @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.b
    public void b(View lockView) {
        AbstractC13042fc3.i(lockView, "lockView");
        d dVar = this.lockViewAttacherListener;
        if (dVar != null) {
            dVar.b(lockView);
        }
    }

    public final boolean c3() {
        BarEditText barEditText = this.messageEditText;
        if (barEditText == null || this.keyboardManager == null) {
            return false;
        }
        if (!(barEditText != null ? barEditText.hasFocus() : false)) {
            return false;
        }
        ir.nasim.features.keyboard.a aVar = this.keyboardManager;
        return aVar != null ? aVar.z() : false;
    }

    @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.b
    public void d() {
        C19406qI3.a("InputBar", "onRecordingEnded", new Object[0]);
        Y1(false);
    }

    public final boolean d3(C11458d25 peer) {
        C14733iO2 c14733iO2;
        return (peer == null || peer.s() != W25.b || (c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n((long) peer.getPeerId())) == null || c14733iO2.s() == null || c14733iO2.s().b() == null || c14733iO2.q() != ZN2.CHANNEL || ((C23104wM2) c14733iO2.s().b()).j()) ? false : true;
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        F62 f62;
        AbstractC13042fc3.i(args, "args");
        if (id != C15225jD4.i || !this.invalidateEditText || this.messageEditText == null || (f62 = this.emojiTextWatcher) == null) {
            return;
        }
        if (f62 != null) {
            f62.a(true);
        }
        F62 f622 = this.emojiTextWatcher;
        int length = 0;
        if (f622 != null) {
            f622.b(0);
        }
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            CharSequence charSequenceW = R62.W(barEditText.getText(), barEditText.getPaint().getFontMetricsInt(), AbstractC7426Rr.a.f(20.0f), false, null, null, 48, null);
            int selectionStart = barEditText.getSelectionStart();
            barEditText.setText(charSequenceW);
            if (selectionStart != -1) {
                length = selectionStart;
            } else if (charSequenceW != null) {
                length = charSequenceW.length();
            }
            barEditText.setSelection(length);
        }
    }

    @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.b
    public boolean e() {
        boolean zG4 = g4();
        C19406qI3.a("InputBar", "onStartRecording --> " + zG4, new Object[0]);
        return zG4;
    }

    @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.b
    public void f() {
        C19406qI3.a("InputBar", "onCancelRecording", new Object[0]);
        Y1(true);
    }

    @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.b
    public void g() {
        C19406qI3.a("InputBar", "onPauseRecording", new Object[0]);
        S08.b bVarM1 = M1(S08.b.a.c);
        if (bVarM1 != null) {
            U3(bVarM1);
        }
        R08 r08 = this.voiceRecorder;
        if (r08 != null) {
            r08.b();
        }
    }

    public final void g2(Context context) {
        AbstractC13042fc3.i(context, "context");
        C19406qI3.a("InputBar", "init(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.res = ((LayoutInflater) systemService).inflate(AbstractC10185bD5.fragment_inputbarview, this);
        View view = null;
        if (C8386Vt0.a.R8()) {
            View view2 = this.res;
            if (view2 == null) {
                AbstractC13042fc3.y("res");
                view2 = null;
            }
            this.audioRecorderView = (AudioRecorderView) view2.findViewById(AbstractC9582aC5.audioRecorderView);
        }
        View view3 = this.res;
        if (view3 == null) {
            AbstractC13042fc3.y("res");
        } else {
            view = view3;
        }
        this.rootView = (ConstraintLayout) view.findViewById(AbstractC9582aC5.root);
        this.keyboardUtils = new C15581jp3();
        D2();
        B2();
        S2();
        I2();
        F2();
        i2();
        x2();
        l2();
        s2();
        Y2();
        B1();
        C19406qI3.a("InputBar", "init_after(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            barEditText.clearFocus();
        }
    }

    public final ChatFragment.EnumC11088c getEditMode() {
        C22042ua0 c22042ua0 = this.parentFragment;
        if (!(c22042ua0 instanceof ChatFragment)) {
            return ChatFragment.EnumC11088c.a;
        }
        AbstractC13042fc3.g(c22042ua0, "null cannot be cast to non-null type ir.nasim.chat.ChatFragment");
        return ((ChatFragment) c22042ua0).getEditMode();
    }

    public final TF2 getGetFilePathFromUriUseCase() {
        TF2 tf2 = this.getFilePathFromUriUseCase;
        if (tf2 != null) {
            return tf2;
        }
        AbstractC13042fc3.y("getFilePathFromUriUseCase");
        return null;
    }

    public final d getLockViewAttacherListener() {
        return this.lockViewAttacherListener;
    }

    /* renamed from: getOnSendVoiceRecorderEvent$chat_release, reason: from getter */
    public final UA2 getOnSendVoiceRecorderEvent() {
        return this.onSendVoiceRecorderEvent;
    }

    public final BaseActivity getParentActivity() {
        BaseActivity baseActivity = this.parentActivity;
        if (baseActivity != null) {
            return baseActivity;
        }
        AbstractC13042fc3.y("parentActivity");
        return null;
    }

    public final C22042ua0 getParentFragment() {
        return this.parentFragment;
    }

    public final SO5 getReplyKeyboardCallback() {
        return this.replyKeyboardCallback;
    }

    public final InterfaceC10258bL6 getSmilesPanelState() {
        InterfaceC10258bL6 interfaceC10258bL6 = this.smilesPanelState;
        if (interfaceC10258bL6 != null) {
            return interfaceC10258bL6;
        }
        AbstractC13042fc3.y("smilesPanelState");
        return null;
    }

    public final String getText() {
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            return String.valueOf(barEditText != null ? barEditText.getText() : null);
        }
        C19406qI3.j("InputBar", "messageEditText is null", new Object[0]);
        return "";
    }

    public final C4892Gz7 getTypingModule() {
        C4892Gz7 c4892Gz7 = this.typingModule;
        if (c4892Gz7 != null) {
            return c4892Gz7;
        }
        AbstractC13042fc3.y("typingModule");
        return null;
    }

    public final T08.g getVoiceRecorderFactory() {
        T08.g gVar = this.voiceRecorderFactory;
        if (gVar != null) {
            return gVar;
        }
        AbstractC13042fc3.y("voiceRecorderFactory");
        return null;
    }

    @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.b
    public void h() {
        C19406qI3.a("InputBar", "onResumeRecording", new Object[0]);
        S08.b bVarM1 = M1(S08.b.a.d);
        if (bVarM1 != null) {
            U3(bVarM1);
        }
        R08 r08 = this.voiceRecorder;
        if (r08 != null) {
            r08.d();
        }
    }

    @Override // ir.nasim.chat.audiorecorder.AudioRecorderView.b
    public void i() {
        S08.b bVarM1 = M1(S08.b.a.b);
        if (bVarM1 != null) {
            U3(bVarM1);
        }
    }

    @Override // ir.nasim.WZ
    public void k() {
        C19406qI3.a("InputBar", "onPauseConfirmed(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        ir.nasim.features.keyboard.a aVar = this.keyboardManager;
        if (aVar != null) {
            aVar.D();
        }
        if (!C8386Vt0.a.R8()) {
            P3(true);
            return;
        }
        R08 r08 = this.voiceRecorder;
        if (r08 != null) {
            r08.b();
        }
        AudioRecorderView audioRecorderView = this.audioRecorderView;
        if (audioRecorderView != null) {
            audioRecorderView.P0();
        }
    }

    @Override // ir.nasim.WZ
    public void m() {
        C19406qI3.a("InputBar", "onResumeConfirmed(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        ir.nasim.features.keyboard.a aVar = this.keyboardManager;
        if (aVar != null) {
            aVar.E();
        }
        z1(false);
        if (this.isBot || d3(this.peer)) {
            return;
        }
        v1 = C22078ud6.a(90.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.onGlobalLayoutListener != null) {
            View rootView = getRootView();
            if (rootView != null && rootView.getViewTreeObserver().isAlive()) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
            }
            this.onGlobalLayoutListener = null;
        }
        C19406qI3.a("InputBar", "onDetachedFromWindow(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        AudioRecorderView audioRecorderView = this.audioRecorderView;
        if (audioRecorderView != null) {
            audioRecorderView.setListener(null);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.exclusionRects.set(left, top, right, bottom);
        AbstractC12990fW7.K0(this, AbstractC9766aX0.e(this.exclusionRects));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    public final boolean p3() {
        final AudioRecorderView audioRecorderView;
        C19406qI3.a("InputBar", "onBackPressed(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        if (C8386Vt0.a.R8() && (audioRecorderView = this.audioRecorderView) != null) {
            if (audioRecorderView.getState().p()) {
                R08 r08 = this.voiceRecorder;
                if (r08 != null) {
                    r08.b();
                }
                audioRecorderView.P0();
                return true;
            }
            if (audioRecorderView.getState() != AudioRecorderView.c.a) {
                j4(new SA2() { // from class: ir.nasim.X83
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return InputBarView.s3(this.a, audioRecorderView);
                    }
                });
                return true;
            }
        }
        P3(true);
        C22042ua0 c22042ua0 = this.parentFragment;
        if (c22042ua0 instanceof ChatFragment) {
            AbstractC13042fc3.g(c22042ua0, "null cannot be cast to non-null type ir.nasim.chat.ChatFragment");
            ChatFragment.EnumC11088c enumC11088cAk = ((ChatFragment) c22042ua0).getEditMode();
            ChatFragment.EnumC11088c enumC11088c = ChatFragment.EnumC11088c.a;
            if (enumC11088cAk != enumC11088c) {
                C22042ua0 c22042ua02 = this.parentFragment;
                AbstractC13042fc3.g(c22042ua02, "null cannot be cast to non-null type ir.nasim.chat.ChatFragment");
                ((ChatFragment) c22042ua02).cq(enumC11088c);
            }
        }
        ir.nasim.features.keyboard.a aVar = this.keyboardManager;
        return aVar != null && aVar.A();
    }

    public final void r2(InterfaceC4557Fq2 botMenuStateFlow) {
        AbstractC13042fc3.i(botMenuStateFlow, "botMenuStateFlow");
        ComposeView composeView = (ComposeView) findViewById(AbstractC9582aC5.bot_menu_btn);
        if (composeView != null) {
            composeView.setContent(AbstractC19242q11.c(1745612478, true, new o(botMenuStateFlow, this)));
        } else {
            composeView = null;
        }
        this.botMenuButton = composeView;
    }

    public final void setCaptionFilter() {
    }

    public final void setDisableOnEmptyText(boolean z) {
        this.isDisableOnEmptyText = z;
    }

    public final void setExPeerType(ExPeerType exPeerType) {
        this.exPeerType = exPeerType;
    }

    public final void setGetFilePathFromUriUseCase(TF2 tf2) {
        AbstractC13042fc3.i(tf2, "<set-?>");
        this.getFilePathFromUriUseCase = tf2;
    }

    public final void setIsDiscussion(boolean isDiscussion) {
        this.isCommentChat = isDiscussion;
    }

    public final void setIsSendGifEnabled(EM2 sendGifEnabled) {
        AbstractC13042fc3.i(sendGifEnabled, "sendGifEnabled");
        this.isSendGifEnabled = sendGifEnabled;
    }

    public final void setIsSendMediaEnabled(EM2 sendMediaEnabled) {
        this.isSendMediaEnabled = sendMediaEnabled;
    }

    public final void setLockButton(ImageView lockButton) {
        C19406qI3.a("InputBar", "setLockButton(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        if (C8386Vt0.a.R8()) {
            return;
        }
        this.audioLockButton = lockButton;
        if (lockButton != null) {
            lockButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.W83
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InputBarView.d4(this.a, view);
                }
            });
        }
    }

    public final void setLockViewAttacherListener(d dVar) {
        this.lockViewAttacherListener = dVar;
    }

    public final void setNewKeyboardLayout(NewKeyboardLayout newKeyboardLayout) {
        this.newKeyboardLayout = newKeyboardLayout;
    }

    public final void setOnSendVoiceRecorderEvent$chat_release(UA2 ua2) {
        this.onSendVoiceRecorderEvent = ua2;
    }

    public final void setParentActivity(BaseActivity baseActivity) {
        AbstractC13042fc3.i(baseActivity, "<set-?>");
        this.parentActivity = baseActivity;
    }

    public final void setParentFragment(C22042ua0 c22042ua0) {
        this.parentFragment = c22042ua0;
    }

    public final void setPeer(C11458d25 peer) {
        this.peer = peer;
    }

    public final void setReplyKeyboardCallback(SO5 so5) {
        this.replyKeyboardCallback = so5;
    }

    public final void setSendButtonContentDescription(boolean isEdit) {
        String string;
        TintImageView tintImageView = this.sendButton;
        if (tintImageView != null) {
            Context context = null;
            if (isEdit) {
                Context context2 = this.context;
                if (context2 == null) {
                    AbstractC13042fc3.y("context");
                } else {
                    context = context2;
                }
                string = context.getString(DD5.edit_message);
            } else {
                Context context3 = this.context;
                if (context3 == null) {
                    AbstractC13042fc3.y("context");
                } else {
                    context = context3;
                }
                string = context.getString(DD5.Send);
            }
            tintImageView.setContentDescription(string);
        }
    }

    public final void setSmilesPanelState(InterfaceC10258bL6 interfaceC10258bL6) {
        AbstractC13042fc3.i(interfaceC10258bL6, "<set-?>");
        this.smilesPanelState = interfaceC10258bL6;
    }

    public final void setText(String text, boolean selectAll) {
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            this.invalidateEditText = true;
            this.isTypingDisabled = true;
            barEditText.setText(R62.W(text, barEditText.getPaint().getFontMetricsInt(), AbstractC7426Rr.a.f(20.0f), false, null, null, 48, null));
            if (selectAll) {
                barEditText.setSelection(barEditText.getText().length());
            }
            this.isTypingDisabled = false;
        }
    }

    public final void setThreadId(C7880To7 threadId) {
        this.threadId = threadId;
    }

    public final void setTypingModule(C4892Gz7 c4892Gz7) {
        AbstractC13042fc3.i(c4892Gz7, "<set-?>");
        this.typingModule = c4892Gz7;
    }

    public final void setVoiceRecorderFactory(T08.g gVar) {
        AbstractC13042fc3.i(gVar, "<set-?>");
        this.voiceRecorderFactory = gVar;
    }

    public final void t1(int start, int end, String inputUrl) {
        AbstractC13042fc3.i(inputUrl, "inputUrl");
        String text = getText();
        if (text == null) {
            text = "";
        }
        String str = m3(text, start, true) ? Separators.SP : "";
        String str2 = m3(text, end, false) ? Separators.SP : "";
        String strSubstring = text.substring(start, end);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String strSubstring2 = text.substring(0, start);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        String strSubstring3 = text.substring(end);
        AbstractC13042fc3.h(strSubstring3, "substring(...)");
        String str3 = strSubstring2 + str + "[" + strSubstring + "](" + inputUrl + Separators.RPAREN + str2 + strSubstring3;
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            barEditText.setText(str3);
        }
        BarEditText barEditText2 = this.messageEditText;
        if (barEditText2 != null) {
            barEditText2.setSelection(strSubstring.length() + start + 3, start + strSubstring.length() + 3 + inputUrl.length() + str.length());
        }
    }

    public final void u3() {
        C15225jD4.b().e(this, C15225jD4.i);
        ir.nasim.features.keyboard.a aVar = this.keyboardManager;
        if (aVar != null) {
            aVar.q(false);
        }
        P3(true);
        R08 r08 = this.voiceRecorder;
        if (r08 != null) {
            r08.c();
            this.voiceRecorder = null;
        }
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null) {
            wakeLock.release();
        }
        this.wakeLock = null;
        if (this.parentActivity != null) {
            getParentActivity().getWindow().clearFlags(128);
        }
        this.parentFragment = null;
        C19406qI3.a("InputBar", "onDestroy(isAudioVisible: " + this.isAudioVisible + Separators.RPAREN, new Object[0]);
        AudioRecorderView audioRecorderView = this.audioRecorderView;
        if (audioRecorderView != null) {
            audioRecorderView.setListener(null);
        }
    }

    public final void w3(final Bundle outState) {
        if (outState == null) {
            return;
        }
        outState.putBoolean("isAudioVisible", this.isAudioVisible);
        outState.putBoolean("isAudioEnabled", this.isAudioEnabled);
        outState.putBoolean("isDisableOnEmptyText", this.isDisableOnEmptyText);
        outState.putBoolean(ContactEntity.COLUMN_IS_BOT, this.isBot);
        boolean z = this.isAudioVisible;
        Set<String> setKeySet = outState.keySet();
        AbstractC13042fc3.h(setKeySet, "keySet(...)");
        C19406qI3.a("InputBar", "onSaveInstanceState(isAudioVisible: " + z + ") bundle: " + AbstractC15401jX0.A0(setKeySet, Separators.RETURN, null, null, 0, null, new UA2() { // from class: ir.nasim.R83
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return InputBarView.y3(outState, (String) obj);
            }
        }, 30, null), new Object[0]);
    }

    public final void x1(int hint) {
        BarEditText barEditText = this.messageEditText;
        if (barEditText != null) {
            barEditText.setHint(hint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b implements NP0 {
        private final C11458d25 a;
        private final int b;
        private final OK7 c;
        private final C10299bQ2 d;
        private final InterfaceC9173Yu3 e;
        private final InterfaceC9173Yu3 f;

        private final class a extends AbstractC15742k57 {
            final /* synthetic */ b S;

            public a(b bVar, C14697iL2 c14697iL2) {
                AbstractC13042fc3.i(c14697iL2, "group");
                this.S = bVar;
                this.c = c14697iL2.G0();
                this.g = c14697iL2.w0() == bVar.b;
                this.L = new U67();
                V67 v67 = new V67();
                v67.p = true;
                v67.q = true;
                this.M = v67;
            }
        }

        /* renamed from: ir.nasim.chat.inputbar.InputBarView$b$b, reason: collision with other inner class name */
        private final class C0983b extends AbstractC19652qi7 {
            final /* synthetic */ b Q;

            public C0983b(b bVar, C17637nI7 c17637nI7) {
                AbstractC13042fc3.i(c17637nI7, "user");
                this.Q = bVar;
                this.l = c17637nI7.u0().getPeerId() == bVar.b;
                this.c = c17637nI7.getName();
                this.d = "";
            }
        }

        public b(C11458d25 c11458d25, int i, OK7 ok7, C10299bQ2 c10299bQ2) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(ok7, "usersModule");
            AbstractC13042fc3.i(c10299bQ2, "groupsModule");
            this.a = c11458d25;
            this.b = i;
            this.c = ok7;
            this.d = c10299bQ2;
            this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.chat.inputbar.a
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return InputBarView.b.j(this.a);
                }
            });
            this.f = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.chat.inputbar.b
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return InputBarView.b.i(this.a);
                }
            });
        }

        private final C14697iL2 g() {
            return (C14697iL2) this.f.getValue();
        }

        private final C17637nI7 h() {
            return (C17637nI7) this.e.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C14697iL2 i(b bVar) {
            AbstractC13042fc3.i(bVar, "this$0");
            if (bVar.a.s() == W25.b) {
                return (C14697iL2) bVar.d.X1().d(bVar.a.getPeerId());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C17637nI7 j(b bVar) {
            AbstractC13042fc3.i(bVar, "this$0");
            if (bVar.a.s() == W25.a) {
                return (C17637nI7) bVar.c.o0().o().d(bVar.a.getPeerId());
            }
            return null;
        }

        @Override // ir.nasim.NP0
        public AbstractC15742k57 a() {
            C14697iL2 c14697iL2G = g();
            if (c14697iL2G != null) {
                return new a(this, c14697iL2G);
            }
            return null;
        }

        @Override // ir.nasim.NP0
        public AbstractC19652qi7 b() {
            C17637nI7 c17637nI7H = h();
            if (c17637nI7H != null) {
                return new C0983b(this, c17637nI7H);
            }
            return null;
        }

        @Override // ir.nasim.NP0
        public InterfaceC14695iL0 c() {
            return null;
        }

        public /* synthetic */ b(C11458d25 c11458d25, int i, OK7 ok7, C10299bQ2 c10299bQ2, int i2, ED1 ed1) {
            this(c11458d25, (i2 & 2) != 0 ? AbstractC5969Lp4.e().i0() : i, (i2 & 4) != 0 ? AbstractC5969Lp4.e().W() : ok7, (i2 & 8) != 0 ? AbstractC5969Lp4.e().E() : c10299bQ2);
        }
    }

    public final void setText(String str) {
        setText(str, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        this.exclusionRects = new Rect();
        this.lastWord = "";
        this.audioFocusOwner = new i();
        this.isAudioEnabled = true;
        this.isDisableOnEmptyText = true;
        this.isEditTextCollapsed = true;
        this.runForFirstTime = true;
        this.attachBadgeVisibility = 8;
        this.canBeLocked = true;
        this.pointerId = -1;
        C5721Ko c5721Ko = C5721Ko.a;
        this.settingsModule = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).b1();
        this.appStateModule = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).M0();
        this.expandAnimation = new m();
        this.expandAnimationListener = new n();
        this.collapseAnimation = new j();
        this.collapseAnimationListener = new k();
        this.smilesKeyboardListener = new x();
        this.context = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AbstractC13042fc3.i(context, "context");
        this.exclusionRects = new Rect();
        this.lastWord = "";
        this.audioFocusOwner = new i();
        this.isAudioEnabled = true;
        this.isDisableOnEmptyText = true;
        this.isEditTextCollapsed = true;
        this.runForFirstTime = true;
        this.attachBadgeVisibility = 8;
        this.canBeLocked = true;
        this.pointerId = -1;
        C5721Ko c5721Ko = C5721Ko.a;
        this.settingsModule = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).b1();
        this.appStateModule = ((InterfaceC9291Zh4) C92.a(c5721Ko.d(), InterfaceC9291Zh4.class)).M0();
        this.expandAnimation = new m();
        this.expandAnimationListener = new n();
        this.collapseAnimation = new j();
        this.collapseAnimationListener = new k();
        this.smilesKeyboardListener = new x();
        this.context = context;
    }
}
