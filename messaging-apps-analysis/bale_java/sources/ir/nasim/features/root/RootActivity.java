package ir.nasim.features.root;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AD4;
import ir.nasim.AI7;
import ir.nasim.AK1;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16344l68;
import ir.nasim.AbstractC17026mG5;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19329q98;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC19662qj7;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC21784u76;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC23348wm0;
import ir.nasim.AbstractC24707z43;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9220Yz5;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C12179eA3;
import ir.nasim.C12280eL5;
import ir.nasim.C14486i0;
import ir.nasim.C14505i18;
import ir.nasim.C14593iA1;
import ir.nasim.C14819iX7;
import ir.nasim.C15456jc8;
import ir.nasim.C15721k36;
import ir.nasim.C16731lm1;
import ir.nasim.C17481n23;
import ir.nasim.C18987pb3;
import ir.nasim.C19406qI3;
import ir.nasim.C19732qq7;
import ir.nasim.C19938rB7;
import ir.nasim.C21753u45;
import ir.nasim.C21832uC6;
import ir.nasim.C22042ua0;
import ir.nasim.C23709xO;
import ir.nasim.C24398yZ;
import ir.nasim.C4174Dz6;
import ir.nasim.C5161Id6;
import ir.nasim.C5495Jo7;
import ir.nasim.C5721Ko;
import ir.nasim.C7183Qq;
import ir.nasim.C8386Vt0;
import ir.nasim.C8920Xu5;
import ir.nasim.C92;
import ir.nasim.C9248Zc6;
import ir.nasim.C9475a16;
import ir.nasim.CU2;
import ir.nasim.DK4;
import ir.nasim.DW0;
import ir.nasim.E88;
import ir.nasim.ED1;
import ir.nasim.EnumC11723dV1;
import ir.nasim.EnumC14097hL4;
import ir.nasim.EnumC18608ow5;
import ir.nasim.EnumC23552x68;
import ir.nasim.EnumC4196Ec1;
import ir.nasim.H48;
import ir.nasim.HV1;
import ir.nasim.InterfaceC10156bA3;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC11677dQ0;
import ir.nasim.InterfaceC13373g70;
import ir.nasim.InterfaceC13737gk0;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15690k05;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16935m68;
import ir.nasim.InterfaceC19567qa2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21767u6;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC23146wR;
import ir.nasim.InterfaceC23238wb0;
import ir.nasim.InterfaceC24152y78;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC7298Rc6;
import ir.nasim.InterfaceC7565Sg3;
import ir.nasim.InterfaceC8898Xu3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.LQ;
import ir.nasim.NY;
import ir.nasim.OP0;
import ir.nasim.PH3;
import ir.nasim.Q12;
import ir.nasim.Q64;
import ir.nasim.R62;
import ir.nasim.RE;
import ir.nasim.SA2;
import ir.nasim.SE;
import ir.nasim.SW6;
import ir.nasim.SZ;
import ir.nasim.T12;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.W12;
import ir.nasim.W25;
import ir.nasim.XV4;
import ir.nasim.Y66;
import ir.nasim.ZF2;
import ir.nasim.core.model.webapp.WebAppArguments;
import ir.nasim.core.model.webapp.WebAppRestoreState;
import ir.nasim.core.model.webapp.WebAppType;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.file.upload.UploadService;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.designsystem.ArbaeenSimCardSelectionBottomSheet;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity;
import ir.nasim.features.inappmessage.data.model.InAppMessage;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.features.root.RootActivity;
import ir.nasim.features.root.minimizer.MinimizerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000ö\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 ß\u00022\u00020\u0001:\u0002à\u0002B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J+\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0004H\u0003¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u0003J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0000H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0003J\u0017\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u0010\u0003J\u0017\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;JQ\u0010I\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020<2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E2\b\b\u0002\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\u00042\u0006\u0010L\u001a\u00020KH\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\bO\u00105J\u0017\u0010P\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\bP\u00105J\u0017\u0010R\u001a\u00020\n2\u0006\u0010Q\u001a\u000202H\u0002¢\u0006\u0004\bR\u00107J\u0017\u0010S\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\bS\u00107J\u0017\u0010T\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\bT\u00105J\u0017\u0010U\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\bU\u00105J\u0017\u0010V\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\bV\u00105J\u0017\u0010W\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\bW\u00105J\u0011\u0010Y\u001a\u0004\u0018\u00010XH\u0002¢\u0006\u0004\bY\u0010ZJS\u0010b\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u00010\u00132\b\u0010\\\u001a\u0004\u0018\u00010\u00132\u001a\u0010_\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010]j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`^2\b\u0010`\u001a\u0004\u0018\u00010\u00132\b\u0010a\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\bb\u0010cJ\u0019\u0010e\u001a\u00020\u00042\b\u0010d\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\be\u0010fJ\u0019\u0010g\u001a\u00020\u00042\b\u0010d\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\bg\u0010fJ\u0017\u0010h\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0013H\u0002¢\u0006\u0004\bh\u0010fJ\u0017\u0010k\u001a\u00020j2\u0006\u0010i\u001a\u00020\u0013H\u0002¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020\u0004H\u0002¢\u0006\u0004\bm\u0010\u0003J\u0017\u0010o\u001a\u00020\u00042\u0006\u0010n\u001a\u00020\bH\u0016¢\u0006\u0004\bo\u0010pJ\u000f\u0010q\u001a\u00020\nH\u0016¢\u0006\u0004\bq\u0010rJ\u0019\u0010u\u001a\u00020\u00042\b\u0010t\u001a\u0004\u0018\u00010sH\u0014¢\u0006\u0004\bu\u0010vJ\u0017\u0010y\u001a\u00020\n2\u0006\u0010x\u001a\u00020wH\u0016¢\u0006\u0004\by\u0010zJ\u0017\u0010{\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0014¢\u0006\u0004\b{\u00105J\u000f\u0010|\u001a\u00020\u0004H\u0016¢\u0006\u0004\b|\u0010\u0003J\r\u0010}\u001a\u00020\u0004¢\u0006\u0004\b}\u0010\u0003J\r\u0010~\u001a\u00020\u0004¢\u0006\u0004\b~\u0010\u0003J\u0019\u0010\u0080\u0001\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020sH\u0015¢\u0006\u0005\b\u0080\u0001\u0010vJ\u0019\u0010\u0081\u0001\u001a\u00020\u00042\u0006\u0010t\u001a\u00020sH\u0014¢\u0006\u0005\b\u0081\u0001\u0010vJ\u001c\u0010\u0084\u0001\u001a\u00020\u00042\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u0004H\u0014¢\u0006\u0005\b\u0086\u0001\u0010\u0003J\u0011\u0010\u0087\u0001\u001a\u00020\u0004H\u0014¢\u0006\u0005\b\u0087\u0001\u0010\u0003J\u0011\u0010\u0088\u0001\u001a\u00020\u0004H\u0014¢\u0006\u0005\b\u0088\u0001\u0010\u0003J\u0011\u0010\u0089\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0089\u0001\u0010\u0003J\u001a\u0010\u008b\u0001\u001a\u00020\u00042\t\u0010\u008a\u0001\u001a\u0004\u0018\u000108¢\u0006\u0005\b\u008b\u0001\u0010;J\u001a\u0010\u008d\u0001\u001a\u00020\u00042\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0013¢\u0006\u0005\b\u008d\u0001\u0010fJA\u0010\u0091\u0001\u001a\u00020\u00042\u0007\u0010\u008e\u0001\u001a\u00020\u00132\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00132\u0007\u0010\u0090\u0001\u001a\u00020\u00132\u0006\u0010H\u001a\u00020G2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u0018\u0010\u0094\u0001\u001a\u00020\u00042\u0007\u0010\u0093\u0001\u001a\u00020\u0013¢\u0006\u0005\b\u0094\u0001\u0010fJ\u001b\u0010\u0096\u0001\u001a\u00020\u00042\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J5\u0010\u009d\u0001\u001a\u00020\u00042\u0007\u0010\u0098\u0001\u001a\u00020<2\u000e\u0010\u009a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u0099\u00012\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001H\u0016¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0018\u0010 \u0001\u001a\u00020\u00042\u0007\u0010\u009f\u0001\u001a\u00020\u0013¢\u0006\u0005\b \u0001\u0010fJ\u0018\u0010¢\u0001\u001a\u00020\u00042\u0007\u0010¡\u0001\u001a\u00020\u0013¢\u0006\u0005\b¢\u0001\u0010fJ/\u0010¥\u0001\u001a\u00020\u00042\u0007\u0010\u0098\u0001\u001a\u00020<2\u0007\u0010£\u0001\u001a\u00020<2\t\u0010¤\u0001\u001a\u0004\u0018\u000102H\u0014¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u001a\u0010¨\u0001\u001a\u00020\u00042\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0013¢\u0006\u0005\b¨\u0001\u0010fJ\u000f\u0010©\u0001\u001a\u00020\u0004¢\u0006\u0005\b©\u0001\u0010\u0003J\u0011\u0010ª\u0001\u001a\u00020\nH\u0016¢\u0006\u0005\bª\u0001\u0010rR*\u0010²\u0001\u001a\u00030«\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R1\u0010»\u0001\u001a\n\u0012\u0005\u0012\u00030´\u00010³\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R*\u0010Ã\u0001\u001a\u00030¼\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R*\u0010Ë\u0001\u001a\u00030Ä\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÅ\u0001\u0010Æ\u0001\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R1\u0010Ô\u0001\u001a\u00030Ì\u00018\u0006@\u0006X\u0087.¢\u0006\u001f\n\u0006\bÍ\u0001\u0010Î\u0001\u0012\u0005\bÓ\u0001\u0010\u0003\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R*\u0010Ü\u0001\u001a\u00030Õ\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÖ\u0001\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001\"\u0006\bÚ\u0001\u0010Û\u0001R*\u0010ä\u0001\u001a\u00030Ý\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÞ\u0001\u0010ß\u0001\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R*\u0010ì\u0001\u001a\u00030å\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bæ\u0001\u0010ç\u0001\u001a\u0006\bè\u0001\u0010é\u0001\"\u0006\bê\u0001\u0010ë\u0001R*\u0010ô\u0001\u001a\u00030í\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bî\u0001\u0010ï\u0001\u001a\u0006\bð\u0001\u0010ñ\u0001\"\u0006\bò\u0001\u0010ó\u0001R*\u0010ü\u0001\u001a\u00030õ\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bö\u0001\u0010÷\u0001\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R*\u0010\u0084\u0002\u001a\u00030ý\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002\"\u0006\b\u0082\u0002\u0010\u0083\u0002R*\u0010\u008c\u0002\u001a\u00030\u0085\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0086\u0002\u0010\u0087\u0002\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002\"\u0006\b\u008a\u0002\u0010\u008b\u0002R*\u0010\u0094\u0002\u001a\u00030\u008d\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u008e\u0002\u0010\u008f\u0002\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R*\u0010\u009c\u0002\u001a\u00030\u0095\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0096\u0002\u0010\u0097\u0002\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002\"\u0006\b\u009a\u0002\u0010\u009b\u0002R*\u0010¤\u0002\u001a\u00030\u009d\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u009e\u0002\u0010\u009f\u0002\u001a\u0006\b \u0002\u0010¡\u0002\"\u0006\b¢\u0002\u0010£\u0002R\u001c\u0010¨\u0002\u001a\u0005\u0018\u00010¥\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0002\u0010§\u0002R\u001b\u0010«\u0002\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0002\u0010ª\u0002R,\u0010_\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010]j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`^8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0002\u0010\u00ad\u0002R\u001b\u0010°\u0002\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0002\u0010¯\u0002R\u001a\u0010\\\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0002\u0010¯\u0002R\u001a\u0010[\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010¯\u0002R\u001a\u0010a\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0002\u0010¯\u0002R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010µ\u0002R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0002\u0010¯\u0002R\u001c\u0010º\u0002\u001a\u0005\u0018\u00010·\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0002\u0010¹\u0002R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010¯\u0002R\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0002\u0010¯\u0002R\u001b\u0010¾\u0002\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0002\u0010¯\u0002R,\u0010Æ\u0002\u001a\u0005\u0018\u00010¿\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÀ\u0002\u0010Á\u0002\u001a\u0006\bÂ\u0002\u0010Ã\u0002\"\u0006\bÄ\u0002\u0010Å\u0002R\u0019\u0010É\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0002\u0010È\u0002R\u0019\u0010Ë\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0002\u0010È\u0002R#\u0010Ñ\u0002\u001a\u0005\u0018\u00010Ì\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÍ\u0002\u0010Î\u0002\u001a\u0006\bÏ\u0002\u0010Ð\u0002R!\u0010Ö\u0002\u001a\u00030Ò\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÓ\u0002\u0010Î\u0002\u001a\u0006\bÔ\u0002\u0010Õ\u0002R\u0018\u0010Ú\u0002\u001a\u00030×\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bØ\u0002\u0010Ù\u0002R\u0016\u0010Ü\u0002\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0007\u001a\u0005\bÛ\u0002\u0010rR\u0015\u00109\u001a\u0004\u0018\u0001088F¢\u0006\b\u001a\u0006\bÝ\u0002\u0010Þ\u0002¨\u0006á\u0002"}, d2 = {"Lir/nasim/features/root/RootActivity;", "Lir/nasim/designsystem/base/activity/PasscodeRequiredActivity;", "<init>", "()V", "Lir/nasim/rB7;", "o4", "W4", "a5", "Landroid/content/Context;", "context", "", "Y3", "(Landroid/content/Context;)Z", "b4", "q5", "t5", "Lir/nasim/features/inappmessage/data/model/InAppMessage$Enabled;", "inAppMessage", "Lir/nasim/XV4;", "", "Ljava/io/Serializable;", "eventMapPairParam", "Z4", "(Lir/nasim/features/inappmessage/data/model/InAppMessage$Enabled;Lir/nasim/XV4;)V", "Lir/nasim/features/root/g;", "k3", "()Lir/nasim/features/root/g;", "k4", "n5", "r3", "m4", "e4", "n4", "u3", "l3", "h3", "z4", "o3", "i4", "g4", "d5", "rootActivity", "U4", "(Lir/nasim/features/root/RootActivity;)V", "c5", "Lir/nasim/Ec1;", "configFlag", "c4", "(Lir/nasim/Ec1;)Z", "W3", "Landroid/content/Intent;", "intent", "S3", "(Landroid/content/Intent;)V", "V3", "(Landroid/content/Intent;)Z", "Lir/nasim/d25;", "peer", "s5", "(Lir/nasim/d25;)V", "", "botPeerId", "Lir/nasim/core/model/webapp/WebAppType;", "webAppType", "Lir/nasim/H48;", "openType", "eventRandomId", "Lir/nasim/core/modules/profile/entity/ExPeer;", "chatExPeer", "Lir/nasim/core/model/webapp/WebAppRestoreState;", "webAppRestoreState", "Lir/nasim/x68;", "screenMode", "H4", "(ILir/nasim/core/model/webapp/WebAppType;Lir/nasim/H48;ILir/nasim/core/modules/profile/entity/ExPeer;Lir/nasim/core/model/webapp/WebAppRestoreState;Lir/nasim/x68;)V", "Lir/nasim/core/model/webapp/WebAppArguments;", "webAppArguments", "I4", "(Lir/nasim/core/model/webapp/WebAppArguments;)V", "B4", "x4", "inputIntent", "o5", "T3", "A4", "y4", "w4", "D4", "Lir/nasim/OP0;", "v3", "()Lir/nasim/OP0;", "sendText", "sendUriString", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sendUriMultiple", "type", "peerIdDirectShare", "f5", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "code", "F4", "(Ljava/lang/String;)V", "i3", "u5", "ussd", "Landroid/net/Uri;", "w5", "(Ljava/lang/String;)Landroid/net/Uri;", "S4", "base", "attachBaseContext", "(Landroid/content/Context;)V", "W1", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/KeyEvent;", "event", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "onNewIntent", "onBackPressed", "v5", "d4", "outState", "onSaveInstanceState", "onRestoreInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onResume", "onPause", "onStart", "onDestroy", "pendingPeer", "l5", "pendingMessage", "k5", "username", "webAppShortName", "startParams", "O4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lir/nasim/x68;Lir/nasim/core/modules/profile/entity/ExPeer;)V", "url", "C4", "isInMultiWindowMode", "onMultiWindowModeChanged", "(Z)V", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "paymentEndPoint", "i5", "paymentOriginalToken", "j5", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "token", "f3", "U3", "o2", "Lir/nasim/gk0;", "P0", "Lir/nasim/gk0;", "A3", "()Lir/nasim/gk0;", "setBottomSheetNavigatorImp", "(Lir/nasim/gk0;)V", "bottomSheetNavigatorImp", "Lir/nasim/Xu3;", "Lir/nasim/k36;", "Q0", "Lir/nasim/Xu3;", "L3", "()Lir/nasim/Xu3;", "setRootBeer", "(Lir/nasim/Xu3;)V", "rootBeer", "Lir/nasim/DK4;", "R0", "Lir/nasim/DK4;", "F3", "()Lir/nasim/DK4;", "setOnboardingNavigator", "(Lir/nasim/DK4;)V", "onboardingNavigator", "Lir/nasim/wb0;", "S0", "Lir/nasim/wb0;", "z3", "()Lir/nasim/wb0;", "setBaseSettingsNavigator", "(Lir/nasim/wb0;)V", "baseSettingsNavigator", "Lir/nasim/qa2;", "T0", "Lir/nasim/qa2;", "C3", "()Lir/nasim/qa2;", "setEventAnalytics", "(Lir/nasim/qa2;)V", "getEventAnalytics$annotations", "eventAnalytics", "Lir/nasim/core/modules/banking/BankingModule;", "U0", "Lir/nasim/core/modules/banking/BankingModule;", "y3", "()Lir/nasim/core/modules/banking/BankingModule;", "setBankingModule", "(Lir/nasim/core/modules/banking/BankingModule;)V", "bankingModule", "Lir/nasim/LQ;", "V0", "Lir/nasim/LQ;", "w3", "()Lir/nasim/LQ;", "setAuthRepository", "(Lir/nasim/LQ;)V", "authRepository", "Lir/nasim/core/modules/settings/SettingsModule;", "W0", "Lir/nasim/core/modules/settings/SettingsModule;", "M3", "()Lir/nasim/core/modules/settings/SettingsModule;", "setSettingsModule", "(Lir/nasim/core/modules/settings/SettingsModule;)V", "settingsModule", "Lir/nasim/Sg3;", "X0", "Lir/nasim/Sg3;", "E3", "()Lir/nasim/Sg3;", "setJaryanNavigator", "(Lir/nasim/Sg3;)V", "jaryanNavigator", "Lir/nasim/wR;", "Y0", "Lir/nasim/wR;", "getAuthenticatorNavigator", "()Lir/nasim/wR;", "setAuthenticatorNavigator", "(Lir/nasim/wR;)V", "authenticatorNavigator", "Lir/nasim/m68;", "Z0", "Lir/nasim/m68;", "O3", "()Lir/nasim/m68;", "setWebAppNavigator", "(Lir/nasim/m68;)V", "webAppNavigator", "Lir/nasim/k05;", "a1", "Lir/nasim/k05;", "H3", "()Lir/nasim/k05;", "setPassportsNavigator", "(Lir/nasim/k05;)V", "passportsNavigator", "Lir/nasim/dQ0;", "b1", "Lir/nasim/dQ0;", "getChatNavigator", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/Bk5;", "c1", "Lir/nasim/Bk5;", "getPreferences", "()Lir/nasim/Bk5;", "setPreferences", "(Lir/nasim/Bk5;)V", "preferences", "Lir/nasim/ZF2;", "d1", "Lir/nasim/ZF2;", "D3", "()Lir/nasim/ZF2;", "setGetInAppMessageUseCase", "(Lir/nasim/ZF2;)V", "getInAppMessageUseCase", "Lir/nasim/HV1;", "e1", "Lir/nasim/HV1;", "imageLoaderDisposable", "f1", "Lir/nasim/features/root/g;", "rootFragment", "g1", "Ljava/util/ArrayList;", "h1", "Ljava/lang/String;", "sendMimeType", "i1", "j1", "k1", "l1", "Lir/nasim/d25;", "m1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "n1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayoutListener", "o1", "p1", "q1", "ussdCode", "Lir/nasim/u6;", "r1", "Lir/nasim/u6;", "getActivityResultInterface", "()Lir/nasim/u6;", "b5", "(Lir/nasim/u6;)V", "activityResultInterface", "s1", "Z", "isThemeChanged", "t1", "isLanguageChanged", "Lir/nasim/E88;", "u1", "Lir/nasim/Yu3;", "P3", "()Lir/nasim/E88;", "webviewRepository", "Lir/nasim/features/root/I;", "v1", "N3", "()Lir/nasim/features/root/I;", "viewModel", "Landroidx/fragment/app/FragmentManager$l;", "w1", "Landroidx/fragment/app/FragmentManager$l;", "fragmentLifecycleCallback", "K1", "defaultStatusBarBackgroundEnabled", "K3", "()Lir/nasim/d25;", "x1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class RootActivity extends Hilt_RootActivity {

    /* renamed from: x1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int y1 = 8;
    private static boolean z1;

    /* renamed from: P0, reason: from kotlin metadata */
    public InterfaceC13737gk0 bottomSheetNavigatorImp;

    /* renamed from: Q0, reason: from kotlin metadata */
    public InterfaceC8898Xu3 rootBeer;

    /* renamed from: R0, reason: from kotlin metadata */
    public DK4 onboardingNavigator;

    /* renamed from: S0, reason: from kotlin metadata */
    public InterfaceC23238wb0 baseSettingsNavigator;

    /* renamed from: T0, reason: from kotlin metadata */
    public InterfaceC19567qa2 eventAnalytics;

    /* renamed from: U0, reason: from kotlin metadata */
    public BankingModule bankingModule;

    /* renamed from: V0, reason: from kotlin metadata */
    public LQ authRepository;

    /* renamed from: W0, reason: from kotlin metadata */
    public SettingsModule settingsModule;

    /* renamed from: X0, reason: from kotlin metadata */
    public InterfaceC7565Sg3 jaryanNavigator;

    /* renamed from: Y0, reason: from kotlin metadata */
    public InterfaceC23146wR authenticatorNavigator;

    /* renamed from: Z0, reason: from kotlin metadata */
    public InterfaceC16935m68 webAppNavigator;

    /* renamed from: a1, reason: from kotlin metadata */
    public InterfaceC15690k05 passportsNavigator;

    /* renamed from: b1, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: c1, reason: from kotlin metadata */
    public InterfaceC3570Bk5 preferences;

    /* renamed from: d1, reason: from kotlin metadata */
    public ZF2 getInAppMessageUseCase;

    /* renamed from: e1, reason: from kotlin metadata */
    private HV1 imageLoaderDisposable;

    /* renamed from: f1, reason: from kotlin metadata */
    private AbstractC13089g rootFragment;

    /* renamed from: g1, reason: from kotlin metadata */
    private ArrayList sendUriMultiple;

    /* renamed from: h1, reason: from kotlin metadata */
    private String sendMimeType;

    /* renamed from: i1, reason: from kotlin metadata */
    private String sendUriString;

    /* renamed from: j1, reason: from kotlin metadata */
    private String sendText;

    /* renamed from: k1, reason: from kotlin metadata */
    private String peerIdDirectShare;

    /* renamed from: l1, reason: from kotlin metadata */
    private C11458d25 pendingPeer;

    /* renamed from: m1, reason: from kotlin metadata */
    private String pendingMessage;

    /* renamed from: n1, reason: from kotlin metadata */
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    /* renamed from: o1, reason: from kotlin metadata */
    private String paymentEndPoint;

    /* renamed from: p1, reason: from kotlin metadata */
    private String paymentOriginalToken;

    /* renamed from: q1, reason: from kotlin metadata */
    private String ussdCode;

    /* renamed from: r1, reason: from kotlin metadata */
    private InterfaceC21767u6 activityResultInterface;

    /* renamed from: s1, reason: from kotlin metadata */
    private boolean isThemeChanged;

    /* renamed from: t1, reason: from kotlin metadata */
    private boolean isLanguageChanged;

    /* renamed from: u1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 webviewRepository = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.X26
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return RootActivity.x5(this.a);
        }
    });

    /* renamed from: v1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = new androidx.lifecycle.F(AbstractC10882cM5.b(I.class), new g(this), new f(this), new h(null, this));

    /* renamed from: w1, reason: from kotlin metadata */
    private final FragmentManager.l fragmentLifecycleCallback = new b();

    /* renamed from: ir.nasim.features.root.RootActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, int i, W25 w25, Q64 q64, boolean z, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                q64 = null;
            }
            Q64 q642 = q64;
            if ((i2 & 16) != 0) {
                z = q642 != null;
            }
            return companion.a(context, i, w25, q642, z);
        }

        public static /* synthetic */ void f(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                context = C5721Ko.a.d();
            }
            companion.e(context, str);
        }

        public static /* synthetic */ void i(Companion companion, Context context, String str, Bundle bundle, int i, Object obj) {
            if ((i & 1) != 0) {
                context = C5721Ko.a.d();
            }
            if ((i & 4) != 0) {
                bundle = AbstractC23348wm0.a();
            }
            companion.h(context, str, bundle);
        }

        public final Intent a(Context context, int i, W25 w25, Q64 q64, boolean z) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(w25, "peerType");
            Intent intent = new Intent(context, (Class<?>) RootActivity.class);
            intent.setAction("action_open_conversation");
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.putExtra("arg_peer_id", i);
            intent.putExtra("arg_peer_type", w25.name());
            if (q64 != null) {
                intent.putExtra("arg_rid", q64.i());
                intent.putExtra("arg_sort_key", q64.h());
            }
            intent.putExtra("arg_should_load_message", z);
            return intent;
        }

        public final boolean c() {
            return RootActivity.z1;
        }

        public final void d(boolean z) {
            RootActivity.z1 = z;
        }

        public final void e(Context context, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "code");
            Intent intent = new Intent(context, (Class<?>) RootActivity.class);
            intent.setAction("action_open_ussd");
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.putExtra("arg_ussd", str);
            context.startActivity(intent);
        }

        public final void g(Context context, Intent intent) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(intent, "intent");
            Intent intent2 = new Intent(context, (Class<?>) RootActivity.class);
            intent2.addFlags(268435456);
            intent2.addFlags(67108864);
            intent2.setAction("action_handle_share_from_external_apps");
            intent2.setSelector(intent);
            context.startActivity(intent2);
        }

        public final void h(Context context, String str, Bundle bundle) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, "openAction");
            AbstractC13042fc3.i(bundle, "argument");
            Intent intent = new Intent(context, (Class<?>) RootActivity.class);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.setAction(str);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b extends FragmentManager.l {
        b() {
        }

        @Override // androidx.fragment.app.FragmentManager.l
        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
            AbstractC13042fc3.i(fragmentManager, "fm");
            AbstractC13042fc3.i(fragment, "f");
            AbstractC13042fc3.i(context, "context");
            super.b(fragmentManager, fragment, context);
            RootActivity.this.n4();
        }

        @Override // androidx.fragment.app.FragmentManager.l
        public void e(FragmentManager fragmentManager, Fragment fragment) {
            AbstractC13042fc3.i(fragmentManager, "fm");
            AbstractC13042fc3.i(fragment, "f");
            super.e(fragmentManager, fragment);
            RootActivity.this.n4();
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MinimizerView d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ RootActivity c;
            final /* synthetic */ MinimizerView d;

            /* renamed from: ir.nasim.features.root.RootActivity$c$a$a, reason: collision with other inner class name */
            static final class C1212a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ MinimizerView d;
                final /* synthetic */ RootActivity e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1212a(MinimizerView minimizerView, RootActivity rootActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = minimizerView;
                    this.e = rootActivity;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1212a c1212a = new C1212a(this.d, this.e, interfaceC20295rm1);
                    c1212a.c = obj;
                    return c1212a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC16344l68 abstractC16344l68 = (AbstractC16344l68) this.c;
                    if (AbstractC13042fc3.d(abstractC16344l68, AbstractC16344l68.a.a)) {
                        this.d.c(false);
                    } else if (abstractC16344l68 instanceof AbstractC16344l68.b) {
                        this.d.f(((AbstractC16344l68.b) abstractC16344l68).a());
                    } else {
                        if (!(abstractC16344l68 instanceof AbstractC16344l68.c)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.d.c(true);
                        this.e.I4(((AbstractC16344l68.c) abstractC16344l68).a());
                        this.e.N3().a2();
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AbstractC16344l68 abstractC16344l68, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1212a) create(abstractC16344l68, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(RootActivity rootActivity, MinimizerView minimizerView, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = rootActivity;
                this.d = minimizerView;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6W1 = this.c.N3().W1();
                    C1212a c1212a = new C1212a(this.d, this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6W1, c1212a, this) == objE) {
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
        c(MinimizerView minimizerView, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = minimizerView;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return RootActivity.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                RootActivity rootActivity = RootActivity.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(rootActivity, this.d, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(rootActivity, bVar, aVar, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return RootActivity.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objG;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                LQ lqW3 = RootActivity.this.w3();
                this.b = 1;
                objG = lqW3.g(this);
                if (objG == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objG = ((C9475a16) obj).l();
            }
            RootActivity rootActivity = RootActivity.this;
            if (C9475a16.j(objG)) {
                rootActivity.finish();
            }
            RootActivity rootActivity2 = RootActivity.this;
            if (C9475a16.e(objG) != null) {
                rootActivity2.finish();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ InAppMessage a;
            final /* synthetic */ RootActivity b;

            /* renamed from: ir.nasim.features.root.RootActivity$e$a$a, reason: collision with other inner class name */
            static final class C1213a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InAppMessage c;
                final /* synthetic */ RootActivity d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1213a(InAppMessage inAppMessage, RootActivity rootActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = inAppMessage;
                    this.d = rootActivity;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1213a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC10156bA3 startButtonLinkAction = ((InAppMessage.Enabled) this.c).getStartButtonLinkAction();
                        RootActivity rootActivity = this.d;
                        this.b = 1;
                        if (InterfaceC10156bA3.b(startButtonLinkAction, rootActivity, false, this, 2, null) == objE) {
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
                    return ((C1213a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            a(InAppMessage inAppMessage, RootActivity rootActivity) {
                this.a = inAppMessage;
                this.b = rootActivity;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(RootActivity rootActivity, Dialog dialog, InAppMessage inAppMessage) {
                AbstractC13042fc3.i(rootActivity, "this$0");
                AbstractC13042fc3.i(dialog, "$dialog");
                AbstractC13042fc3.i(inAppMessage, "$inAppMessage");
                AbstractC10533bm0.d(AbstractC19224pz3.a(rootActivity), null, null, new C1213a(inAppMessage, rootActivity, null), 3, null);
                dialog.dismiss();
                rootActivity.Z4((InAppMessage.Enabled) inAppMessage, AbstractC4616Fw7.a("action_type", 3));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(Dialog dialog) {
                AbstractC13042fc3.i(dialog, "$dialog");
                dialog.cancel();
                return C19938rB7.a;
            }

            public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(dialog, "dialog");
                String contentMediaLink = ((InAppMessage.Enabled) this.a).getContentMediaLink();
                String titleText = ((InAppMessage.Enabled) this.a).getTitleText();
                String bodyText = ((InAppMessage.Enabled) this.a).getBodyText();
                String startButtonText = ((InAppMessage.Enabled) this.a).getStartButtonText();
                interfaceC22053ub1.W(-309009489);
                boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(dialog);
                final RootActivity rootActivity = this.b;
                final InAppMessage inAppMessage = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.features.root.e
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return RootActivity.e.a.d(rootActivity, dialog, inAppMessage);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                String strC = UY6.c(AbstractC12217eE5.in_app_message_dialog_cancel, interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-308991252);
                boolean zD2 = interfaceC22053ub1.D(dialog);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.features.root.f
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return RootActivity.e.a.f(dialog);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC24707z43.e(null, contentMediaLink, titleText, bodyText, startButtonText, sa2, strC, (SA2) objB2, interfaceC22053ub1, 0, 1);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(RootActivity rootActivity, C12280eL5 c12280eL5, InAppMessage inAppMessage, DialogInterface dialogInterface) {
            SettingsModule settingsModuleM3 = rootActivity.M3();
            settingsModuleM3.Y6(settingsModuleM3.y2() + 1);
            C7183Qq.p().putLong("arg_in_app_message_last_seen_mills", System.currentTimeMillis());
            c12280eL5.a = System.currentTimeMillis();
            rootActivity.Z4((InAppMessage.Enabled) inAppMessage, AbstractC4616Fw7.a("action_type", 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G(RootActivity rootActivity, InAppMessage inAppMessage, DialogInterface dialogInterface) {
            rootActivity.Z4((InAppMessage.Enabled) inAppMessage, AbstractC4616Fw7.a("action_type", 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(C12280eL5 c12280eL5, C12280eL5 c12280eL52, RootActivity rootActivity, InAppMessage inAppMessage, DialogInterface dialogInterface) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            c12280eL5.a = jCurrentTimeMillis;
            rootActivity.Z4((InAppMessage.Enabled) inAppMessage, AbstractC4616Fw7.a("duration_seconds", Integer.valueOf((int) ((jCurrentTimeMillis - c12280eL52.a) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT))));
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return RootActivity.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ZF2 zf2D3 = RootActivity.this.D3();
                this.b = 1;
                obj = zf2D3.f(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            final InAppMessage inAppMessage = (InAppMessage) obj;
            if (inAppMessage instanceof InAppMessage.Enabled) {
                RootActivity rootActivity = RootActivity.this;
                Dialog dialogC = AbstractC21375tZ.c(rootActivity, rootActivity, null, AbstractC19242q11.c(-1997865736, true, new a(inAppMessage, rootActivity)), 4, null);
                final C12280eL5 c12280eL5 = new C12280eL5();
                final C12280eL5 c12280eL52 = new C12280eL5();
                final RootActivity rootActivity2 = RootActivity.this;
                dialogC.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.features.root.b
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        RootActivity.e.D(rootActivity2, c12280eL5, inAppMessage, dialogInterface);
                    }
                });
                final RootActivity rootActivity3 = RootActivity.this;
                dialogC.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.nasim.features.root.c
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        RootActivity.e.G(rootActivity3, inAppMessage, dialogInterface);
                    }
                });
                final RootActivity rootActivity4 = RootActivity.this;
                dialogC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.features.root.d
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        RootActivity.e.H(c12280eL52, c12280eL5, rootActivity4, inAppMessage, dialogInterface);
                    }
                });
                dialogC.setCanceledOnTouchOutside(true);
                dialogC.show();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.n3();
        }
    }

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.d1();
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ ComponentActivity f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, ComponentActivity componentActivity) {
            super(0);
            this.e = sa2;
            this.f = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            return (sa2 == null || (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) == null) ? this.f.p3() : abstractC20375ru1;
        }
    }

    private final void A4(Intent intent) {
        try {
            androidx.lifecycle.h hVar = (Fragment) B0().C0().get(B0().C0().size() - 1);
            if (hVar instanceof CU2) {
                CU2 cu2 = (CU2) hVar;
                String stringExtra = intent.getStringExtra("arg_url");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                cu2.f5(stringExtra);
            }
        } catch (Exception e2) {
            C19406qI3.b("HashtagSpan", "Error in onClick: " + e2.getMessage());
        }
    }

    private final void B4(Intent intent) {
        String stringExtra;
        AbstractC13089g abstractC13089g = this.rootFragment;
        if (abstractC13089g == null || (stringExtra = intent.getStringExtra("INVITE_WITH_TOKEN_ARG")) == null) {
            return;
        }
        abstractC13089g.ca(stringExtra, intent.getBooleanExtra("INVITE_FROM_OUT_OF_BALE_ARG", false));
    }

    private final void D4(Intent intent) {
        C4174Dz6 c4174Dz6 = new C4174Dz6();
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("arg_short_text_title");
        if (stringExtra == null) {
            stringExtra = "";
        }
        bundle.putString("arg_short_text_title", stringExtra);
        String stringExtra2 = intent.getStringExtra("arg_short_text_content");
        bundle.putString("arg_short_text_content", stringExtra2 != null ? stringExtra2 : "");
        c4174Dz6.a8(bundle);
        k2(c4174Dz6);
    }

    private final void F4(String code) {
        if (C21753u45.Q(this) && C21753u45.X(this)) {
            i3(code);
        } else {
            C21753u45.O0(C21753u45.a, this, 1978, null, new C21753u45.d[]{C21753u45.d.p, C21753u45.d.r}, 4, null);
            this.ussdCode = code;
        }
    }

    private final void H4(int botPeerId, WebAppType webAppType, H48 openType, int eventRandomId, ExPeer chatExPeer, WebAppRestoreState webAppRestoreState, EnumC23552x68 screenMode) {
        I4(new WebAppArguments(botPeerId, webAppType, openType, eventRandomId, chatExPeer, webAppRestoreState, screenMode, false, 128, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I4(WebAppArguments webAppArguments) {
        k2(O3().a(webAppArguments));
    }

    static /* synthetic */ void M4(RootActivity rootActivity, int i, WebAppType webAppType, H48 h48, int i2, ExPeer exPeer, WebAppRestoreState webAppRestoreState, EnumC23552x68 enumC23552x68, int i3, Object obj) {
        rootActivity.H4(i, webAppType, h48, i2, (i3 & 16) != 0 ? null : exPeer, (i3 & 32) != 0 ? null : webAppRestoreState, (i3 & 64) != 0 ? EnumC23552x68.c : enumC23552x68);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final I N3() {
        return (I) this.viewModel.getValue();
    }

    private final E88 P3() {
        return (E88) this.webviewRepository.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q4(String str, String str2, RootActivity rootActivity, ExPeer exPeer, EnumC23552x68 enumC23552x68, int i) {
        AbstractC13042fc3.i(str2, "$startParams");
        AbstractC13042fc3.i(rootActivity, "this$0");
        AbstractC13042fc3.i(enumC23552x68, "$screenMode");
        M4(rootActivity, i, (str == null || !(AbstractC20762sZ6.n0(str) ^ true)) ? new WebAppType.Main(str2) : new WebAppType.DirectLink(str, str2), H48.e, AbstractC17026mG5.a.f(), exPeer, null, enumC23552x68, 32, null);
        return C19938rB7.a;
    }

    private final void S3(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("isUiTest", false);
        if ((intent.getFlags() & 1048576) == 1048576) {
            return;
        }
        if (!V3(intent)) {
            C18987pb3.a.k0(intent, this);
        }
        if (booleanExtra) {
            return;
        }
        intent.replaceExtras(new Bundle()).setAction(null).setData(null).setFlags(0);
        setIntent(null);
    }

    private final void S4() {
        final E88 e88P3;
        if (!C8386Vt0.a.h9() || (e88P3 = P3()) == null) {
            return;
        }
        C9248Zc6 c9248Zc6H = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.e36
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return RootActivity.T4(e88P3);
            }
        }).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        SZ.e(c9248Zc6H);
    }

    private final boolean T3(Intent intent) {
        String strValueOf;
        String str;
        ArrayList arrayList;
        String action = intent.getAction();
        String type = intent.getType();
        if (AbstractC13042fc3.d(action, "android.intent.action.SEND")) {
            String stringExtra = AbstractC13042fc3.d("text/plain", type) ? intent.getStringExtra("android.intent.extra.TEXT") : null;
            if (stringExtra != null || intent.getParcelableExtra("android.intent.extra.STREAM") == null) {
                str = stringExtra;
                strValueOf = null;
                arrayList = null;
            } else {
                str = stringExtra;
                strValueOf = String.valueOf(intent.getParcelableExtra("android.intent.extra.STREAM"));
                arrayList = null;
            }
        } else if (AbstractC13042fc3.d(action, "android.intent.action.SEND_MULTIPLE")) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            if (parcelableArrayListExtra != null) {
                Iterator it = parcelableArrayListExtra.iterator();
                AbstractC13042fc3.h(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    AbstractC13042fc3.h(next, "next(...)");
                    arrayList2.add(((Uri) next).toString());
                }
            }
            arrayList = arrayList2;
            strValueOf = null;
            str = null;
        } else {
            strValueOf = null;
            str = null;
            arrayList = null;
        }
        if (str == null && strValueOf == null && arrayList == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        f5(str, strValueOf, arrayList, type, extras != null ? extras.getString("android.intent.extra.shortcut.ID") : null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T4(E88 e88) {
        AbstractC13042fc3.i(e88, "$it");
        e88.init();
        return C19938rB7.a;
    }

    private final void U4(RootActivity rootActivity) {
        C5161Id6.a.c();
        C5161Id6.b(rootActivity, getResources().getConfiguration());
    }

    private final boolean V3(Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return false;
        }
        if (AbstractC13042fc3.d(action, "action_open_conversation") || AbstractC13042fc3.d(action, "action_open_dialog")) {
            y4(intent);
        } else if (AbstractC13042fc3.d(action, "action_open_ussd")) {
            F4(intent.getStringExtra("arg_ussd"));
        } else if (AbstractC13042fc3.d(action, "action_open_comment")) {
            x4(intent);
        } else if (AbstractC13042fc3.d(action, "action_open_hashtag")) {
            A4(intent);
        } else if (AbstractC13042fc3.d(action, "action_recreate")) {
            recreate();
        } else if (AbstractC13042fc3.d(action, "action_set_payment_original_token_and_set_payment_end_point")) {
            String stringExtra = intent.getStringExtra("arg_payment_original_token");
            if (stringExtra == null) {
                stringExtra = "";
            }
            j5(stringExtra);
            String stringExtra2 = intent.getStringExtra("arg_payment_end_point");
            i5(stringExtra2 != null ? stringExtra2 : "");
        } else if (AbstractC13042fc3.d(action, "action_open_code_preview_fragment")) {
            w4(intent);
        } else if (AbstractC13042fc3.d(action, "action_open_pfm")) {
            AbstractC13089g abstractC13089g = this.rootFragment;
            if (abstractC13089g != null) {
                String stringExtra3 = intent.getStringExtra("arg_pfm_from");
                if (stringExtra3 == null) {
                    stringExtra3 = "FROM_SAPTA";
                }
                abstractC13089g.ea(EnumC14097hL4.valueOf(stringExtra3));
            }
        } else if (AbstractC20762sZ6.X("shortcut_main_webapp", action, false, 2, null) || AbstractC13042fc3.d(action, "shortcut_menu_webapp")) {
            int intExtra = intent.getIntExtra("arg_peer_id_key", -1);
            if (intExtra == -1) {
                return false;
            }
            boolean zD = AbstractC13042fc3.d(action, "shortcut_menu_webapp");
            M4(this, intExtra, zD ? new WebAppType.Menu(null) : new WebAppType.Main(null), H48.h, AbstractC17026mG5.a.f(), null, null, null, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null);
        } else if (AbstractC13042fc3.d(action, "shortcut_chat")) {
            if (!C8386Vt0.F4()) {
                return false;
            }
            int intExtra2 = intent.getIntExtra("arg_peer_id_key", -1);
            int intExtra3 = intent.getIntExtra("arg_ex_peer_type_value_key", -1);
            if (intExtra2 == -1 || intExtra3 == -1) {
                return false;
            }
            ExPeerType exPeerTypeFromValue = ExPeerType.fromValue(intExtra3);
            AbstractC13042fc3.h(exPeerTypeFromValue, "fromValue(...)");
            s5(new C11458d25(exPeerTypeFromValue.getPeerType(), intExtra2));
            N3().w2();
        } else if (AbstractC13042fc3.d(action, "android.intent.action.SEND") || AbstractC13042fc3.d(action, "android.intent.action.SEND_MULTIPLE") || AbstractC13042fc3.d(action, "action_handle_share_from_external_apps")) {
            o5(intent);
        } else if (AbstractC13042fc3.d(action, "action_open_short_text_preview_fragment")) {
            D4(intent);
        } else {
            if (!AbstractC13042fc3.d(action, "INVITE_WITH_TOKEN")) {
                return false;
            }
            B4(intent);
        }
        return true;
    }

    private final void W3() {
        String lowerCase;
        String lowerCase2;
        try {
            String str = Build.DISPLAY;
            if (str != null) {
                Locale locale = Locale.getDefault();
                AbstractC13042fc3.h(locale, "getDefault(...)");
                lowerCase = str.toLowerCase(locale);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            String str2 = "";
            if (lowerCase == null) {
                lowerCase = "";
            }
            String str3 = Build.USER;
            if (str3 != null) {
                Locale locale2 = Locale.getDefault();
                AbstractC13042fc3.h(locale2, "getDefault(...)");
                lowerCase2 = str3.toLowerCase(locale2);
                AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
            } else {
                lowerCase2 = null;
            }
            if (lowerCase2 != null) {
                str2 = lowerCase2;
            }
            if (AbstractC20762sZ6.X(lowerCase, "flyme", false, 2, null) || AbstractC20762sZ6.X(str2, "flyme", false, 2, null)) {
                AbstractC7426Rr.a.K(true);
                final View rootView = getWindow().getDecorView().getRootView();
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.nasim.T26
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        RootActivity.X3(rootView);
                    }
                };
                this.onGlobalLayoutListener = onGlobalLayoutListener;
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        } catch (Exception e2) {
            C19406qI3.d("RootActivity", e2);
        }
    }

    private final void W4() {
        C3().b("accessibility_enabled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X3(View view) {
        int measuredHeight = view.getMeasuredHeight();
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        int iT = measuredHeight - aVar.t();
        if (iT <= aVar.f(100.0f) || iT >= aVar.m().y || aVar.f(100.0f) + iT <= aVar.m().y) {
            return;
        }
        aVar.m().y = iT;
    }

    private final boolean Y3(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z4(InAppMessage.Enabled inAppMessage, XV4 eventMapPairParam) {
        String lowerCase;
        ExPeerType exPeerType;
        String strName;
        XV4 xv4A = AbstractC4616Fw7.a("notif_id", Long.valueOf(inAppMessage.getInAppMessageId()));
        String titleText = inAppMessage.getTitleText();
        if (titleText == null) {
            titleText = "";
        }
        XV4 xv4A2 = AbstractC4616Fw7.a("message_type", titleText);
        XV4 xv4A3 = AbstractC4616Fw7.a("msg_info", inAppMessage.getBodyText());
        ExPeer exPeerC = inAppMessage.getStartButtonLinkAction().c();
        XV4 xv4A4 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(exPeerC != null ? exPeerC.getPeerId() : 0));
        InterfaceC10156bA3 startButtonLinkAction = inAppMessage.getStartButtonLinkAction();
        if (startButtonLinkAction instanceof InterfaceC10156bA3.a) {
            lowerCase = "external_url";
        } else if (startButtonLinkAction instanceof C12179eA3) {
            lowerCase = "deep_link";
        } else {
            ExPeer exPeerC2 = startButtonLinkAction.c();
            if (exPeerC2 == null || (exPeerType = exPeerC2.getExPeerType()) == null || (strName = exPeerType.name()) == null) {
                lowerCase = null;
            } else {
                lowerCase = strName.toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            }
        }
        C3().a("in_app_message", AbstractC20051rO3.n(eventMapPairParam, xv4A, xv4A2, xv4A3, xv4A4, AbstractC4616Fw7.a("peer_type", lowerCase != null ? lowerCase : "")));
    }

    public static final boolean a4() {
        return INSTANCE.c();
    }

    private final void a5() {
        C3().b("screen_reader_enabled");
    }

    private final boolean b4(Context context) {
        Object systemService = context.getSystemService("accessibility");
        AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
        return accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    private final boolean c4(EnumC4196Ec1 configFlag) {
        return M3().B5(configFlag);
    }

    private final void c5() {
        SE se = SE.a;
        SE.b = c4(EnumC4196Ec1.c) ? RE.b : c4(EnumC4196Ec1.r) ? RE.d : c4(EnumC4196Ec1.q) ? RE.c : c4(EnumC4196Ec1.s) ? RE.e : c4(EnumC4196Ec1.t) ? RE.f : c4(EnumC4196Ec1.u) ? RE.g : c4(EnumC4196Ec1.d) ? RE.h : c4(EnumC4196Ec1.f) ? RE.i : c4(EnumC4196Ec1.p) ? RE.j : c4(EnumC4196Ec1.b) ? RE.k : c4(EnumC4196Ec1.g) ? RE.l : c4(EnumC4196Ec1.h) ? RE.m : c4(EnumC4196Ec1.i) ? RE.o : c4(EnumC4196Ec1.j) ? RE.n : c4(EnumC4196Ec1.o) ? RE.p : c4(EnumC4196Ec1.k) ? RE.q : c4(EnumC4196Ec1.l) ? RE.r : c4(EnumC4196Ec1.m) ? RE.s : c4(EnumC4196Ec1.n) ? RE.t : c4(EnumC4196Ec1.e) ? RE.u : RE.a;
    }

    private final void d5() {
        int iL1 = C5495Jo7.l1(this);
        Configuration configuration = getApplicationContext().getResources().getConfiguration();
        if (iL1 == 1) {
            configuration.uiMode = 16;
        } else if (iL1 == 2) {
            configuration.uiMode = 32;
        }
        getApplicationContext().getResources().getConfiguration().setTo(configuration);
    }

    private final void e4() {
        B0().t1(this.fragmentLifecycleCallback, false);
    }

    private final void f5(final String sendText, final String sendUriString, final ArrayList sendUriMultiple, final String type, final String peerIdDirectShare) {
        AbstractC13089g abstractC13089g = this.rootFragment;
        if (abstractC13089g == null) {
            new SA2() { // from class: ir.nasim.Y26
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return RootActivity.g5(this.a, sendText, sendUriString, sendUriMultiple, type, peerIdDirectShare);
                }
            };
            return;
        }
        abstractC13089g.la(sendText, sendUriString, sendUriMultiple, type, peerIdDirectShare);
        this.sendText = null;
        this.sendUriString = null;
        this.sendUriMultiple = null;
        this.sendMimeType = null;
        this.peerIdDirectShare = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g3(RootActivity rootActivity, C14505i18 c14505i18) {
        AbstractC13042fc3.i(rootActivity, "this$0");
        rootActivity.U3();
    }

    private final void g4() {
        C9248Zc6 c9248Zc6H = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.b36
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return RootActivity.h4();
            }
        }).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        SZ.e(c9248Zc6H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g5(RootActivity rootActivity, String str, String str2, ArrayList arrayList, String str3, String str4) {
        AbstractC13042fc3.i(rootActivity, "this$0");
        rootActivity.sendText = str;
        rootActivity.sendUriString = str2;
        rootActivity.sendUriMultiple = arrayList;
        rootActivity.sendMimeType = str3;
        rootActivity.peerIdDirectShare = str4;
        return C19938rB7.a;
    }

    private final void h3() {
        M3().c6(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h4() {
        R62.Q();
        R62.M();
        return C19938rB7.a;
    }

    public static final void h5(boolean z) {
        INSTANCE.d(z);
    }

    private final void i3(String code) {
        if (code == null) {
            return;
        }
        C21832uC6 c21832uC6 = C21832uC6.a;
        Context applicationContext = getApplicationContext();
        AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
        int iA = c21832uC6.a(applicationContext);
        boolean zC = C15456jc8.c();
        C19406qI3.b("RootActivity", "SimCount : " + iA + " | isXiaomi : " + zC);
        if (iA >= 2 && zC) {
            u5(code);
            return;
        }
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(w5(code));
        try {
            startActivity(intent);
        } catch (Exception e2) {
            C19406qI3.c("RootActivity", "callUssd", e2);
        }
    }

    private final void i4() {
        C9248Zc6 c9248Zc6H = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.S26
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return RootActivity.j4();
            }
        }).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        this.imageLoaderDisposable = SZ.e(c9248Zc6H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17481n23 j4() {
        return C17481n23.T();
    }

    private final AbstractC13089g k3() {
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            String str = this.sendText;
            if (str != null) {
                extras.putString("send_text", str);
                this.sendText = null;
            }
            String str2 = this.sendUriString;
            if (str2 != null) {
                extras.putString("send_uri", str2);
                this.sendUriString = null;
            }
            ArrayList<String> arrayList = this.sendUriMultiple;
            if (arrayList != null) {
                extras.putStringArrayList("send_uri_multiple", arrayList);
                this.sendUriMultiple = null;
            }
            String str3 = this.sendMimeType;
            if (str3 != null) {
                extras.putString("send_mime", str3);
                this.sendMimeType = null;
            }
            String str4 = this.peerIdDirectShare;
            if (str4 != null) {
                extras.putString("peer_id_direct_share", str4);
                this.peerIdDirectShare = null;
            }
        }
        C13090h c13090h = new C13090h();
        c13090h.a8(extras);
        return c13090h;
    }

    private final void k4() {
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.Z26
            @Override // java.lang.Runnable
            public final void run() {
                RootActivity.l4();
            }
        });
    }

    private final void l3() {
        if (!AI7.a()) {
            C19406qI3.a("RootActivity", "displayAndroid14FullScreenPermission return because canDisplayInform is false", new Object[0]);
        } else {
            if (Build.VERSION.SDK_INT < 34 || !M3().g5()) {
                return;
            }
            C24398yZ.a.i(this, this, new SA2() { // from class: ir.nasim.Q26
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return RootActivity.m3(this.a);
                }
            });
            h3();
            AI7.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l4() {
        C19406qI3.a("SyncLog", "device_info: " + AK1.b(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m3(RootActivity rootActivity) {
        AbstractC13042fc3.i(rootActivity, "this$0");
        rootActivity.z4();
        return C19938rB7.a;
    }

    private final void m4() {
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n4() {
        Fragment fragmentL1 = L1();
        if (fragmentL1 instanceof C22042ua0) {
            ((C22042ua0) fragmentL1).i9();
        }
    }

    private final void n5() {
        if (C7183Qq.q(EnumC18608ow5.d).getInt("Theme_Pref", 1) == 0 && AbstractC13042fc3.d(getTheme().getResources(), new C16731lm1(this, AbstractC23035wE5.Theme_App_Starting).getResources()) && Build.VERSION.SDK_INT >= 31) {
            setTheme(AbstractC23035wE5.MainActivityTheme);
        }
    }

    private final void o3() {
        if (!AI7.a()) {
            C19406qI3.a("RootActivity", "displayBackgroundRestricted return because canDisplayInform is false", new Object[0]);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object systemService = getSystemService("activity");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            if (!((ActivityManager) systemService).isBackgroundRestricted() || System.currentTimeMillis() - C7183Qq.s().getLong("background_restriction_last_display", 0L) < 86400000) {
                return;
            }
            C24398yZ.f(this);
            C7183Qq.s().putLong("background_restriction_last_display", System.currentTimeMillis());
            AI7.b(false);
        }
    }

    private final void o4() {
        MinimizerView minimizerView = (MinimizerView) findViewById(BC5.web_container);
        minimizerView.setOnCloseClickListener(new UA2() { // from class: ir.nasim.c36
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return RootActivity.r4(this.a, (View) obj);
            }
        });
        minimizerView.setOnRetrieveClickListener(new UA2() { // from class: ir.nasim.d36
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return RootActivity.s4(this.a, (View) obj);
            }
        });
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new c(minimizerView, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if (r0.equals("android.intent.action.SEND_MULTIPLE") == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r0.equals("android.intent.action.SEND") == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean o5(android.content.Intent r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getAction()
            r1 = 0
            if (r0 == 0) goto L6e
            int r2 = r0.hashCode()
            r3 = -1173264947(0xffffffffba1165cd, float:-5.5464805E-4)
            if (r2 == r3) goto L34
            r3 = -1104605409(0xffffffffbe290f1f, float:-0.16509674)
            if (r2 == r3) goto L24
            r3 = -58484670(0xfffffffffc839842, float:-5.4662324E36)
            if (r2 == r3) goto L1b
            goto L6e
        L1b:
            java.lang.String r2 = "android.intent.action.SEND_MULTIPLE"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L3d
            goto L6e
        L24:
            java.lang.String r2 = "action_handle_share_from_external_apps"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L2d
            goto L6e
        L2d:
            android.content.Intent r7 = r7.getSelector()
            if (r7 != 0) goto L3d
            return r1
        L34:
            java.lang.String r2 = "android.intent.action.SEND"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L3d
            goto L6e
        L3d:
            boolean r0 = ir.nasim.C8386Vt0.ra()
            if (r0 == 0) goto L69
            android.content.Intent r0 = new android.content.Intent
            r0.<init>(r7)
            ir.nasim.features.root.I r7 = r6.N3()
            r7.n2(r0)
            android.os.Bundle r7 = r0.getExtras()
            if (r7 == 0) goto L5d
            java.lang.String r0 = "android.intent.extra.shortcut.ID"
            java.lang.String r7 = r7.getString(r0)
        L5b:
            r5 = r7
            goto L5f
        L5d:
            r7 = 0
            goto L5b
        L5f:
            r3 = 0
            r4 = 0
            r1 = 0
            r2 = 0
            r0 = r6
            r0.f5(r1, r2, r3, r4, r5)
            r7 = 1
            return r7
        L69:
            boolean r7 = r6.T3(r7)
            return r7
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.root.RootActivity.o5(android.content.Intent):boolean");
    }

    private final void q5() {
        F3().a(new UA2() { // from class: ir.nasim.a36
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return RootActivity.r5(this.a, ((Integer) obj).intValue());
            }
        });
    }

    private final void r3() {
        if (AbstractC21784u76.a()) {
            return;
        }
        if (!AI7.a()) {
            C19406qI3.a("RootActivity", "displayEnableNotificationDialog returns early because canDisplayInform is false", new Object[0]);
            return;
        }
        SettingsModule settingsModuleS = AbstractC5969Lp4.e().S();
        if (AD4.e(this).a()) {
            settingsModuleS.X5();
        } else if (settingsModuleS.J()) {
            NY nyA = new NY(this).q(AbstractC7426Rr.a.f(56.0f)).p(KB5.icon_notification).A(AbstractC12217eE5.dialog_enable_notification_title);
            NY.a aVar = NY.O;
            nyA.E(aVar.a()).h(AbstractC12217eE5.dialog_enable_notification_description).k(aVar.a()).w(AbstractC12217eE5.dialog_enable_notification_positive_button).t(AbstractC12217eE5.dialog_enable_notification_negative_button).v(new View.OnClickListener() { // from class: ir.nasim.R26
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RootActivity.t3(this.a, view);
                }
            }).e(false).a().z();
            AI7.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r4(RootActivity rootActivity, View view) {
        AbstractC13042fc3.i(rootActivity, "this$0");
        AbstractC13042fc3.i(view, "it");
        rootActivity.N3().A1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r5(RootActivity rootActivity, int i) {
        AbstractC13042fc3.i(rootActivity, "this$0");
        rootActivity.k2(rootActivity.F3().g(i));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s4(RootActivity rootActivity, View view) {
        AbstractC13042fc3.i(rootActivity, "this$0");
        AbstractC13042fc3.i(view, "it");
        rootActivity.N3().r2();
        return C19938rB7.a;
    }

    private final void s5(C11458d25 peer) {
        AbstractC13089g abstractC13089g = this.rootFragment;
        if (abstractC13089g != null) {
            AbstractC13089g.aa(abstractC13089g, peer, null, null, false, null, null, false, 64, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t3(RootActivity rootActivity, View view) {
        AbstractC13042fc3.i(rootActivity, "this$0");
        rootActivity.m4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t4() {
        AbstractC20507s76.y();
    }

    private final void t5() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(null), 3, null);
    }

    private final void u3() {
        if (!AI7.a()) {
            C19406qI3.a("RootActivity", "displayXiaomiShowOnLockScreen return because canDisplayInform is false", new Object[0]);
            return;
        }
        if (!C15456jc8.c() || C15456jc8.b(10020) || System.currentTimeMillis() - C7183Qq.s().getLong("show_on_lock_screen_last_display", 0L) < 604800000 || AbstractC21784u76.a()) {
            return;
        }
        C24398yZ.m(this);
        C7183Qq.s().putLong("show_on_lock_screen_last_display", System.currentTimeMillis());
        AI7.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u4(RootActivity rootActivity, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(rootActivity, "this$0");
        AbstractC10533bm0.d(AbstractC19224pz3.a(rootActivity), null, null, rootActivity.new d(null), 3, null);
    }

    private final void u5(String code) {
        C14486i0 c14486i0A = C14486i0.f.a(this);
        InterfaceC13737gk0 interfaceC13737gk0A3 = A3();
        Context baseContext = getBaseContext();
        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
        ArbaeenSimCardSelectionBottomSheet arbaeenSimCardSelectionBottomSheetA = interfaceC13737gk0A3.a(baseContext, code);
        arbaeenSimCardSelectionBottomSheetA.setAbolInstance(c14486i0A);
        c14486i0A.o(arbaeenSimCardSelectionBottomSheetA);
    }

    private final OP0 v3() {
        androidx.lifecycle.h hVarO0 = B0().o0(BC5.content_frame);
        if (hVarO0 instanceof OP0) {
            return (OP0) hVarO0;
        }
        return null;
    }

    private static final void v4(RootActivity rootActivity, Fragment fragment) {
        androidx.fragment.app.x xVarS = rootActivity.B0().s();
        int i = AbstractC9220Yz5.empty_transition;
        xVarS.t(i, i, i, AbstractC9220Yz5.slide_out_left).c(BC5.content_frame, fragment, null).g(null).h();
    }

    private final void w4(Intent intent) {
        DW0 dw0 = new DW0();
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("arg_source_code");
        if (stringExtra == null) {
            stringExtra = "";
        }
        bundle.putString("arg_source_code", stringExtra);
        dw0.a8(bundle);
        k2(dw0);
    }

    private final Uri w5(String ussd) {
        StringBuilder sb = new StringBuilder();
        if (!AbstractC20153rZ6.S(ussd, "tel:", false, 2, null)) {
            sb.append("tel:");
        }
        char[] charArray = ussd.toCharArray();
        AbstractC13042fc3.h(charArray, "toCharArray(...)");
        for (char c2 : charArray) {
            if (c2 == '#') {
                sb.append(Uri.encode(Separators.POUND));
            } else {
                sb.append(c2);
            }
        }
        Uri uri = Uri.parse(sb.toString());
        AbstractC13042fc3.h(uri, "parse(...)");
        return uri;
    }

    private final void x4(Intent intent) {
        AbstractC13089g abstractC13089g = this.rootFragment;
        if (abstractC13089g != null) {
            AbstractC13089g.X9(abstractC13089g, intent.getIntExtra("arg_discussion_group_id", 0), intent.getLongExtra("arg_comment_top_id", 0L), intent.getLongExtra("arg_comment_top_date", 0L), true, null, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final E88 x5(RootActivity rootActivity) {
        AbstractC13042fc3.i(rootActivity, "this$0");
        try {
            return ((InterfaceC24152y78) C92.a(rootActivity, InterfaceC24152y78.class)).C();
        } catch (Exception e2) {
            C19406qI3.c("RootActivity", "Failed to initialize WebViewRepository", e2);
            return null;
        }
    }

    private final void y4(Intent intent) {
        AbstractC13089g abstractC13089g;
        String stringExtra = intent.getStringExtra("arg_peer_type");
        if (stringExtra == null) {
            stringExtra = "private";
        }
        W25 w25ValueOf = W25.valueOf(stringExtra);
        int intExtra = intent.getIntExtra("arg_peer_id", 0);
        long longExtra = intent.getLongExtra("arg_rid", 0L);
        long longExtra2 = intent.getLongExtra("arg_sort_key", 0L);
        boolean booleanExtra = intent.getBooleanExtra("arg_should_load_message", false);
        String stringExtra2 = intent.getStringExtra("arg_jaryan_tab_type");
        String str = stringExtra2 == null ? "" : stringExtra2;
        String stringExtra3 = intent.getStringExtra("arg_message");
        String str2 = stringExtra3 == null ? "" : stringExtra3;
        boolean booleanExtra2 = intent.getBooleanExtra("arg_is_allowing_state_loss_enabled", false);
        if (isFinishing() || (abstractC13089g = this.rootFragment) == null || (abstractC13089g != null && abstractC13089g.h9())) {
            l5(K3());
            k5(str2);
        } else {
            AbstractC13089g abstractC13089g2 = this.rootFragment;
            if (abstractC13089g2 != null) {
                abstractC13089g2.Y9(new C11458d25(w25ValueOf, intExtra), Long.valueOf(longExtra), Long.valueOf(longExtra2), booleanExtra, str2, str, booleanExtra2);
            }
        }
    }

    private final void z4() {
        startActivity(new Intent("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT", Uri.parse("package:" + getPackageName())).addFlags(268435456));
    }

    public final InterfaceC13737gk0 A3() {
        InterfaceC13737gk0 interfaceC13737gk0 = this.bottomSheetNavigatorImp;
        if (interfaceC13737gk0 != null) {
            return interfaceC13737gk0;
        }
        AbstractC13042fc3.y("bottomSheetNavigatorImp");
        return null;
    }

    public final InterfaceC19567qa2 C3() {
        InterfaceC19567qa2 interfaceC19567qa2 = this.eventAnalytics;
        if (interfaceC19567qa2 != null) {
            return interfaceC19567qa2;
        }
        AbstractC13042fc3.y("eventAnalytics");
        return null;
    }

    public final void C4(String url) {
        AbstractC13042fc3.i(url, "url");
        k2(H3().b(url));
    }

    public final ZF2 D3() {
        ZF2 zf2 = this.getInAppMessageUseCase;
        if (zf2 != null) {
            return zf2;
        }
        AbstractC13042fc3.y("getInAppMessageUseCase");
        return null;
    }

    public final InterfaceC7565Sg3 E3() {
        InterfaceC7565Sg3 interfaceC7565Sg3 = this.jaryanNavigator;
        if (interfaceC7565Sg3 != null) {
            return interfaceC7565Sg3;
        }
        AbstractC13042fc3.y("jaryanNavigator");
        return null;
    }

    public final DK4 F3() {
        DK4 dk4 = this.onboardingNavigator;
        if (dk4 != null) {
            return dk4;
        }
        AbstractC13042fc3.y("onboardingNavigator");
        return null;
    }

    public final InterfaceC15690k05 H3() {
        InterfaceC15690k05 interfaceC15690k05 = this.passportsNavigator;
        if (interfaceC15690k05 != null) {
            return interfaceC15690k05;
        }
        AbstractC13042fc3.y("passportsNavigator");
        return null;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    /* renamed from: K1 */
    protected boolean getDefaultStatusBarBackgroundEnabled() {
        return false;
    }

    public final C11458d25 K3() {
        OP0 op0V3 = v3();
        if (op0V3 != null) {
            return op0V3.Y2();
        }
        return null;
    }

    public final InterfaceC8898Xu3 L3() {
        InterfaceC8898Xu3 interfaceC8898Xu3 = this.rootBeer;
        if (interfaceC8898Xu3 != null) {
            return interfaceC8898Xu3;
        }
        AbstractC13042fc3.y("rootBeer");
        return null;
    }

    public final SettingsModule M3() {
        SettingsModule settingsModule = this.settingsModule;
        if (settingsModule != null) {
            return settingsModule;
        }
        AbstractC13042fc3.y("settingsModule");
        return null;
    }

    public final InterfaceC16935m68 O3() {
        InterfaceC16935m68 interfaceC16935m68 = this.webAppNavigator;
        if (interfaceC16935m68 != null) {
            return interfaceC16935m68;
        }
        AbstractC13042fc3.y("webAppNavigator");
        return null;
    }

    public final void O4(String username, final String webAppShortName, final String startParams, final EnumC23552x68 screenMode, final ExPeer chatExPeer) {
        AbstractC13042fc3.i(username, "username");
        AbstractC13042fc3.i(startParams, "startParams");
        AbstractC13042fc3.i(screenMode, "screenMode");
        N3().m2(username, new UA2() { // from class: ir.nasim.V26
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return RootActivity.Q4(webAppShortName, startParams, this, chatExPeer, screenMode, ((Integer) obj).intValue());
            }
        });
    }

    public final void U3() {
        InterfaceC13373g70.a.a(this).j(AbstractC12217eE5.bank_operation_success_description, AbstractC12217eE5.bank_operation_succeed, null);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity
    public boolean W1() {
        return false;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context base) {
        AbstractC13042fc3.i(base, "base");
        super.attachBaseContext(PH3.h(base));
    }

    public final void b5(InterfaceC21767u6 interfaceC21767u6) {
        this.activityResultInterface = interfaceC21767u6;
    }

    public final void d4() {
        this.isLanguageChanged = true;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        Object objPrevious;
        AbstractC13042fc3.i(event, "event");
        if (event.getAction() == 0) {
            List listC0 = B0().C0();
            AbstractC13042fc3.h(listC0, "getFragments(...)");
            ListIterator listIterator = listC0.listIterator(listC0.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
                if (((Fragment) objPrevious).D6()) {
                    break;
                }
            }
            if (((Fragment) objPrevious) instanceof SW6) {
                E3().e(event);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public final void f3(String token) {
        if (token != null) {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(ServicesPageSectionEntity.WALLET_SECTION_TITLE, 0);
            String string = sharedPreferences.getString("endpoint", "");
            String string2 = sharedPreferences.getString("originalToken", "");
            BankingModule bankingModuleY3 = y3();
            String str = this.paymentEndPoint;
            if (str != null) {
                string = str;
            }
            AbstractC13042fc3.f(string);
            String str2 = this.paymentOriginalToken;
            if (str2 != null) {
                string2 = str2;
            }
            AbstractC13042fc3.f(string2);
            bankingModuleY3.d1(string, string2, token).m0(new InterfaceC24449ye1() { // from class: ir.nasim.U26
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    RootActivity.g3(this.a, (C14505i18) obj);
                }
            });
        }
    }

    public final void i5(String paymentEndPoint) {
        AbstractC13042fc3.i(paymentEndPoint, "paymentEndPoint");
        this.paymentEndPoint = paymentEndPoint;
    }

    public final void j5(String paymentOriginalToken) {
        AbstractC13042fc3.i(paymentOriginalToken, "paymentOriginalToken");
        this.paymentOriginalToken = paymentOriginalToken;
    }

    public final void k5(String pendingMessage) {
        this.pendingMessage = pendingMessage;
    }

    public final void l5(C11458d25 pendingPeer) {
        this.pendingPeer = pendingPeer;
    }

    @Override // ir.nasim.designsystem.base.activity.PasscodeRequiredActivity
    public boolean o2() {
        return true;
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        InterfaceC21767u6 interfaceC21767u6;
        if (requestCode == 13781 && (interfaceC21767u6 = this.activityResultInterface) != null) {
            interfaceC21767u6.c(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // ir.nasim.designsystem.base.activity.PasscodeRequiredActivity, ir.nasim.designsystem.base.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (p2()) {
            return;
        }
        C14486i0 c14486i0A = C14486i0.f.a(this);
        if (c14486i0A.j()) {
            c14486i0A.g();
        } else if (PhotoViewerAbs.getInstance().isVisible()) {
            PhotoViewerAbs.getInstance().closePhoto(true, false);
        } else {
            super.onBackPressed();
        }
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        C5161Id6.b(this, newConfig);
        super.onConfigurationChanged(newConfig);
        PH3.h(this);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseFragmentActivity, ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        n5();
        AbstractC19329q98.b(getWindow(), false);
        U4(this);
        e4();
        super.onCreate(savedInstanceState);
        d5();
        c5();
        W3();
        i4();
        androidx.appcompat.app.b.J(true);
        if (this.rootFragment == null || savedInstanceState == null) {
            AbstractC13089g abstractC13089gK3 = k3();
            j2(abstractC13089gK3);
            this.rootFragment = abstractC13089gK3;
            if (savedInstanceState == null) {
                r3();
                u3();
                o3();
            }
        }
        if (AbstractC19662qj7.c(this) && !AbstractC21784u76.b()) {
            AbstractC20507s76.D(new Runnable() { // from class: ir.nasim.P26
                @Override // java.lang.Runnable
                public final void run() {
                    RootActivity.t4();
                }
            }, 5000L);
        }
        if (AbstractC19662qj7.a(getApplication()) || (AbstractC21784u76.d() && !AbstractC21784u76.b() && ((C15721k36) L3().get()).r())) {
            if (AbstractC21784u76.a()) {
                return;
            } else {
                new AlertDialog.a(this).m(getString(AbstractC12217eE5.no_browser_founded_title)).i(getString(AbstractC12217eE5.error_tamper)).d(false, false).l(getString(AbstractC12217eE5.dialog_ok), new DialogInterface.OnClickListener() { // from class: ir.nasim.W26
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RootActivity.u4(this.a, dialogInterface, i);
                    }
                }).a().show();
            }
        }
        k4();
        u3();
        l3();
        o3();
        r3();
        C23709xO.a.B(this);
        g4();
        S4();
        o4();
        if (Y3(this)) {
            W4();
        }
        if (b4(this)) {
            a5();
        }
        C8386Vt0 c8386Vt0 = C8386Vt0.a;
        if (c8386Vt0.R9()) {
            C3().a("device_root_type", AbstractC19460qO3.g(new XV4("User_type", Integer.valueOf(((C15721k36) L3().get()).p()))));
        }
        C3().b("open_app");
        if (c8386Vt0.Rb()) {
            UploadService.INSTANCE.c(this, this);
        }
        if (C7183Qq.p().h("arg_open_from_signup", false)) {
            C7183Qq.p().g("arg_open_from_signup", false);
            q5();
            D3().g();
            return;
        }
        if (!C7183Qq.p().h("arg_open_from_signup", false)) {
            long jCurrentTimeMillis = System.currentTimeMillis() - C7183Qq.p().getLong("arg_in_app_message_last_seen_mills", -1L);
            Q12.a aVar = Q12.b;
            if (jCurrentTimeMillis > Q12.A(T12.s(M3().x2(), W12.e))) {
                t5();
                return;
            }
        }
        D3().g();
    }

    @Override // ir.nasim.designsystem.base.activity.PasscodeRequiredActivity, ir.nasim.designsystem.base.activity.BaseActivity, ir.nasim.designsystem.base.activity.Hilt_BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.onGlobalLayoutListener;
            if (onGlobalLayoutListener != null) {
                getWindow().getDecorView().getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        } catch (Exception e2) {
            C19406qI3.d("RootActivity", e2);
        }
        N3().A1();
        C8920Xu5.c();
        B0().O1(this.fragmentLifecycleCallback);
        super.onDestroy();
        Runnable runnable = this.L0;
        if (runnable != null) {
            AbstractC7426Rr.a.d(runnable);
            this.L0 = null;
        }
        if (C8386Vt0.d9()) {
            PhotoViewerAbs.getInstance(true).destroyPhotoViewer();
        }
        PhotoViewerAbs.getInstance().destroyPhotoViewer();
        HV1 hv1 = this.imageLoaderDisposable;
        if (hv1 != null) {
            hv1.dispose();
        }
        AI7.b(true);
        C23709xO c23709xO = C23709xO.a;
        c23709xO.H();
        c23709xO.C();
        this.rootFragment = null;
        Y66.a.d();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        AbstractC7426Rr.a.J(isInMultiWindowMode);
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        AbstractC13042fc3.i(intent, "intent");
        super.onNewIntent(intent);
        S3(intent);
    }

    @Override // ir.nasim.designsystem.base.activity.PasscodeRequiredActivity, ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (PhotoViewerAbs.getInstance().isVisible()) {
            PhotoViewerAbs.getInstance().onPause();
        }
        AbstractC14047hG.e();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1978) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                F4(this.ussdCode);
            }
            this.ussdCode = null;
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        AbstractC13042fc3.i(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getBoolean("LANG_CHANGED")) {
            v4(this, z3().d());
            v4(this, z3().e());
            v4(this, z3().a());
        } else if (savedInstanceState.getBoolean("THEME_CHANGED")) {
            v4(this, z3().d());
        }
    }

    @Override // ir.nasim.designsystem.base.activity.PasscodeRequiredActivity, ir.nasim.designsystem.base.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        PH3.h(this);
        Intent intent = getIntent();
        if (intent != null) {
            S3(intent);
        }
        C14486i0.f.a(this);
        AbstractC13089g abstractC13089g = this.rootFragment;
        if (abstractC13089g != null) {
            abstractC13089g.pa(this.pendingPeer);
        }
        AbstractC13089g abstractC13089g2 = this.rootFragment;
        if (abstractC13089g2 != null) {
            abstractC13089g2.oa(this.pendingMessage);
        }
        this.pendingPeer = null;
        this.pendingMessage = null;
        if (PhotoViewerAbs.getInstance().isVisible()) {
            PhotoViewerAbs.getInstance().onResume();
        }
        n4();
        AbstractC14047hG.f();
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        AbstractC13042fc3.i(outState, "outState");
        outState.putBoolean("THEME_CHANGED", this.isThemeChanged);
        outState.putBoolean("LANG_CHANGED", this.isLanguageChanged);
    }

    @Override // ir.nasim.designsystem.base.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        C19732qq7.g();
        C14593iA1.H();
        super.onStart();
    }

    public final void v5() {
        this.isThemeChanged = true;
    }

    public final LQ w3() {
        LQ lq = this.authRepository;
        if (lq != null) {
            return lq;
        }
        AbstractC13042fc3.y("authRepository");
        return null;
    }

    public final BankingModule y3() {
        BankingModule bankingModule = this.bankingModule;
        if (bankingModule != null) {
            return bankingModule;
        }
        AbstractC13042fc3.y("bankingModule");
        return null;
    }

    public final InterfaceC23238wb0 z3() {
        InterfaceC23238wb0 interfaceC23238wb0 = this.baseSettingsNavigator;
        if (interfaceC23238wb0 != null) {
            return interfaceC23238wb0;
        }
        AbstractC13042fc3.y("baseSettingsNavigator");
        return null;
    }
}
