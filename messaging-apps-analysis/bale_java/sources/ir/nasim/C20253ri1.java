package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC15519jj1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C14486i0;
import ir.nasim.C20253ri1;
import ir.nasim.C21753u45;
import ir.nasim.C6878Pj1;
import ir.nasim.EF2;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.components.appbar.view.DrawerToolbar;
import ir.nasim.contact.data.ContactItem;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.mxp.entity.PuppetGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0007*\b¯\u0001´\u0001¹\u0001¾\u0001\b\u0007\u0018\u0000 Ã\u00012\u00020\u0001:\u0001\u001eB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0003J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001dH\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u001dH\u0002¢\u0006\u0004\b,\u0010\u001fJ\u000f\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u0019\u00106\u001a\u00020\u00062\b\b\u0001\u00105\u001a\u00020\u0013H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0003J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010\u0003J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010\u0003J\u000f\u0010<\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010\u0003J\u000f\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b=\u0010\u0003J\u000f\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\u0003J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bF\u0010\u0003J\u0013\u0010H\u001a\u00020\u0006*\u00020GH\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0006H\u0002¢\u0006\u0004\bJ\u0010\u0003J\u000f\u0010K\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010\u0003J\u000f\u0010L\u001a\u00020\u0006H\u0002¢\u0006\u0004\bL\u0010\u0003J\u000f\u0010M\u001a\u00020\u0006H\u0002¢\u0006\u0004\bM\u0010\u0003J\u000f\u0010N\u001a\u00020\u0006H\u0002¢\u0006\u0004\bN\u0010\u0003J\u0017\u0010Q\u001a\u00020-2\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u00062\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bS\u0010TJ'\u0010W\u001a\u00020O*\u00020O2\b\b\u0001\u0010U\u001a\u00020\u00132\b\b\u0001\u0010V\u001a\u00020\u0013H\u0002¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0006H\u0002¢\u0006\u0004\bY\u0010\u0003J\u0017\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0016H\u0002¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0006H\u0002¢\u0006\u0004\b]\u0010\u0003J\u000f\u0010^\u001a\u00020\u0006H\u0002¢\u0006\u0004\b^\u0010\u0003J\u000f\u0010_\u001a\u00020\u0006H\u0002¢\u0006\u0004\b_\u0010\u0003J\u000f\u0010`\u001a\u00020\u0006H\u0002¢\u0006\u0004\b`\u0010\u0003J\u0017\u0010b\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u001dH\u0002¢\u0006\u0004\bb\u0010$J\u0017\u0010d\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\u001dH\u0002¢\u0006\u0004\bd\u0010$J\u000f\u0010e\u001a\u00020\u0006H\u0002¢\u0006\u0004\be\u0010\u0003J\u000f\u0010f\u001a\u00020\u0006H\u0002¢\u0006\u0004\bf\u0010\u0003J\u000f\u0010g\u001a\u00020\u0006H\u0002¢\u0006\u0004\bg\u0010\u0003J\u000f\u0010h\u001a\u00020\u001dH\u0002¢\u0006\u0004\bh\u0010\u001fJ\u0017\u0010k\u001a\u00020\u00062\u0006\u0010j\u001a\u00020iH\u0002¢\u0006\u0004\bk\u0010lJ\u0017\u0010o\u001a\u00020\u00062\u0006\u0010n\u001a\u00020mH\u0002¢\u0006\u0004\bo\u0010pJ\u001f\u0010r\u001a\u00020\u00062\u0006\u0010n\u001a\u00020m2\u0006\u0010q\u001a\u00020\u001dH\u0002¢\u0006\u0004\br\u0010sJ\u0017\u0010t\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bt\u00107J\u0017\u0010u\u001a\u00020\u00062\u0006\u0010n\u001a\u00020mH\u0002¢\u0006\u0004\bu\u0010pJ\u0017\u0010v\u001a\u00020\u00062\u0006\u0010n\u001a\u00020mH\u0002¢\u0006\u0004\bv\u0010pJ\u0017\u0010w\u001a\u00020\u00062\u0006\u0010n\u001a\u00020mH\u0002¢\u0006\u0004\bw\u0010pJ\u0017\u0010x\u001a\u00020\u00062\u0006\u0010n\u001a\u00020mH\u0002¢\u0006\u0004\bx\u0010pJ\u001d\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010y\u001a\u00020\u0016H\u0002¢\u0006\u0004\bz\u0010{J\u0017\u0010}\u001a\u00020\u00062\u0006\u0010j\u001a\u00020|H\u0002¢\u0006\u0004\b}\u0010~J\u000f\u0010\u007f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u007f\u0010\u0003J\u0011\u0010\u0080\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0080\u0001\u0010\u0003J\u0011\u0010\u0081\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0005\b\u0081\u0001\u0010\u0003R!\u0010\u0087\u0001\u001a\u00030\u0082\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R!\u0010\u008d\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R*\u0010\u0095\u0001\u001a\u00030\u008e\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R*\u0010\u009d\u0001\u001a\u00030\u0096\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R \u0010£\u0001\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b \u0001\u0010\u008a\u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R!\u0010«\u0001\u001a\u00030§\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¨\u0001\u0010\u008a\u0001\u001a\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010®\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R!\u0010³\u0001\u001a\u00030¯\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b°\u0001\u0010\u008a\u0001\u001a\u0006\b±\u0001\u0010²\u0001R!\u0010¸\u0001\u001a\u00030´\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bµ\u0001\u0010\u008a\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R!\u0010½\u0001\u001a\u00030¹\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bº\u0001\u0010\u008a\u0001\u001a\u0006\b»\u0001\u0010¼\u0001R!\u0010Â\u0001\u001a\u00030¾\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¿\u0001\u0010\u008a\u0001\u001a\u0006\bÀ\u0001\u0010Á\u0001¨\u0006Ä\u0001"}, d2 = {"Lir/nasim/ri1;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "", "", "permissions", "", "grantResults", "g7", "(I[Ljava/lang/String;[I)V", "T6", "", "a", "()Z", "j7", "h7", ParameterNames.HIDDEN, "W6", "(Z)V", "Lir/nasim/Pf2;", "fabricEventType", "Yb", "(Lir/nasim/Pf2;)V", "ec", "Ya", "Ta", "jb", "Lir/nasim/gj3;", "ic", "()Lir/nasim/gj3;", "yb", "pb", "tb", "mb", "kb", "iconId", "Pb", "(I)V", "Tb", "fc", "Jb", "Hb", "ac", "Mb", "Lb", "Lir/nasim/fj1;", "adapter", "Ka", "(Lir/nasim/fj1;)V", "Lir/nasim/Pj1;", "Ua", "()Lir/nasim/Pj1;", "qb", "Lir/nasim/components/appbar/view/BaleToolbar;", "rb", "(Lir/nasim/components/appbar/view/BaleToolbar;)V", "mc", "dc", "zb", "Db", "Pa", "Landroid/view/MenuItem;", "menuItem", "Fb", "(Landroid/view/MenuItem;)Lir/nasim/gj3;", "Gb", "(Landroid/view/MenuItem;)V", "iconResId", "titleResId", "Zb", "(Landroid/view/MenuItem;II)Landroid/view/MenuItem;", "Eb", ParameterNames.TEXT, "gc", "(Ljava/lang/String;)V", "hc", "Cb", "Oa", "Ab", "listIsEmpty", "ib", "isVisible", "Ma", "Vb", "Ja", "Va", "Na", "Lir/nasim/contact/data/ContactItem$MxpPuppetContactItem;", "item", "Rb", "(Lir/nasim/contact/data/ContactItem$MxpPuppetContactItem;)V", "Lir/nasim/contact/data/ContactItem$BaleContactItem;", "contact", "Qb", "(Lir/nasim/contact/data/ContactItem$BaleContactItem;)V", "isVideo", "jc", "(Lir/nasim/contact/data/ContactItem$BaleContactItem;Z)V", "Wb", "bc", "Ub", "Xa", "Wa", "contactName", "Qa", "(Ljava/lang/String;)[Ljava/lang/String;", "Lir/nasim/contact/data/ContactItem$PhoneBookContactItem;", "Xb", "(Lir/nasim/contact/data/ContactItem$PhoneBookContactItem;)V", "Sa", "Ra", "Ia", "Lir/nasim/Mx2;", "h1", "Lir/nasim/bW7;", "Za", "()Lir/nasim/Mx2;", "binding", "Lir/nasim/Zj1;", "i1", "Lir/nasim/Yu3;", "hb", "()Lir/nasim/Zj1;", "viewModel", "Lir/nasim/aO2;", "j1", "Lir/nasim/aO2;", "bb", "()Lir/nasim/aO2;", "setGroupTypeMakerNavigator", "(Lir/nasim/aO2;)V", "groupTypeMakerNavigator", "Lir/nasim/uv6;", "k1", "Lir/nasim/uv6;", "getSettingNavigator", "()Lir/nasim/uv6;", "setSettingNavigator", "(Lir/nasim/uv6;)V", "settingNavigator", "l1", "Lir/nasim/fj1;", "m1", "gb", "()Ljava/lang/String;", "readContactsPermission", "n1", "Lir/nasim/contact/data/ContactItem$BaleContactItem;", "selectedContactItem", "Lir/nasim/n10;", "o1", "ab", "()Lir/nasim/n10;", "callErrorsSnackBar", "p1", "Z", "isFromCallLog", "ir/nasim/ri1$o", "q1", "cb", "()Lir/nasim/ri1$o;", "onBaleContactClickedListener", "ir/nasim/ri1$p", "r1", "db", "()Lir/nasim/ri1$p;", "onMxpClickListener", "ir/nasim/ri1$q", "s1", "eb", "()Lir/nasim/ri1$q;", "onPhoneBookClickedListener", "ir/nasim/ri1$r", "t1", "fb", "()Lir/nasim/ri1$r;", "onPhoneBookMxpClickedListener", "u1", "contact_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.ri1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20253ri1 extends AbstractC14194hW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new u(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: j1, reason: from kotlin metadata */
    public InterfaceC9687aO2 groupTypeMakerNavigator;

    /* renamed from: k1, reason: from kotlin metadata */
    public InterfaceC22258uv6 settingNavigator;

    /* renamed from: l1, reason: from kotlin metadata */
    private C13137fj1 adapter;

    /* renamed from: m1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 readContactsPermission;

    /* renamed from: n1, reason: from kotlin metadata */
    private ContactItem.BaleContactItem selectedContactItem;

    /* renamed from: o1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 callErrorsSnackBar;

    /* renamed from: p1, reason: from kotlin metadata */
    private boolean isFromCallLog;

    /* renamed from: q1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 onBaleContactClickedListener;

    /* renamed from: r1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 onMxpClickListener;

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 onPhoneBookClickedListener;

    /* renamed from: t1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 onPhoneBookMxpClickedListener;
    static final /* synthetic */ InterfaceC5239Im3[] v1 = {AbstractC10882cM5.i(new C25226zw5(C20253ri1.class, "binding", "getBinding()Lir/nasim/contact/databinding/FragmentContactsBinding;", 0))};

    /* renamed from: u1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int w1 = 8;

    /* renamed from: ir.nasim.ri1$A */
    static final class A extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        A(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            A a = C20253ri1.this.new A(interfaceC20295rm1);
            a.c = obj;
            return a;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003b -> B:14:0x003e). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r5.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r6)
                goto L3e
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1b:
                ir.nasim.AbstractC10685c16.b(r6)
                java.lang.Object r6 = r5.c
                ir.nasim.ro1 r6 = (ir.nasim.InterfaceC20315ro1) r6
                r1 = r6
            L23:
                boolean r6 = ir.nasim.AbstractC20906so1.g(r1)
                if (r6 == 0) goto L48
                ir.nasim.ri1 r6 = ir.nasim.C20253ri1.this
                ir.nasim.Zj1 r6 = ir.nasim.C20253ri1.ta(r6)
                long r3 = r6.B1()
                r5.c = r1
                r5.b = r2
                java.lang.Object r6 = ir.nasim.HG1.b(r3, r5)
                if (r6 != r0) goto L3e
                return r0
            L3e:
                ir.nasim.ri1 r6 = ir.nasim.C20253ri1.this
                ir.nasim.Zj1 r6 = ir.nasim.C20253ri1.ta(r6)
                r6.a2()
                goto L23
            L48:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20253ri1.A.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((A) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ri1$B */
    /* synthetic */ class B extends EB2 implements UA2 {
        B(Object obj) {
            super(1, obj, C20253ri1.class, "requestStartCallPermission", "requestStartCallPermission(I)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y(((Number) obj).intValue());
            return C19938rB7.a;
        }

        public final void y(int i) {
            ((C20253ri1) this.receiver).Wb(i);
        }
    }

    /* renamed from: ir.nasim.ri1$a, reason: case insensitive filesystem and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C20253ri1 a(boolean z, EnumC6843Pf2 enumC6843Pf2) {
            AbstractC13042fc3.i(enumC6843Pf2, "contactsFragmentNavigationEvent");
            C20253ri1 c20253ri1 = new C20253ri1();
            c20253ri1.Yb(enumC6843Pf2);
            c20253ri1.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("IS_FROM_CALL_LOGS", Boolean.valueOf(z))));
            return c20253ri1;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ri1$b, reason: case insensitive filesystem */
    static final class C20255b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.ri1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20253ri1 c;

            /* renamed from: ir.nasim.ri1$b$a$a, reason: collision with other inner class name */
            static final class C1505a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C20253ri1 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1505a(C20253ri1 c20253ri1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c20253ri1;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1505a c1505a = new C1505a(this.d, interfaceC20295rm1);
                    c1505a.c = obj;
                    return c1505a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    NT4 nt4 = (NT4) this.c;
                    C13137fj1 c13137fj1 = this.d.adapter;
                    if (c13137fj1 != null) {
                        androidx.lifecycle.j lifecycle = this.d.getLifecycle();
                        AbstractC13042fc3.h(lifecycle, "<get-lifecycle>(...)");
                        c13137fj1.M(lifecycle, nt4);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1505a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20253ri1 c20253ri1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20253ri1;
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
                    InterfaceC4557Fq2 interfaceC4557Fq2W1 = this.c.hb().w1();
                    C1505a c1505a = new C1505a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W1, c1505a, this) == objE) {
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

        C20255b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20253ri1.this.new C20255b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20253ri1 c20253ri1 = C20253ri1.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(c20253ri1, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c20253ri1, bVar, aVar, this) == objE) {
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
            return ((C20255b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ri1$c */
    public static final class c implements C6878Pj1.a.InterfaceC0580a {
        c() {
        }

        @Override // ir.nasim.C6878Pj1.a.InterfaceC0580a
        public void a() {
            C20253ri1.this.Ia();
        }

        @Override // ir.nasim.C6878Pj1.a.InterfaceC0580a
        public void b() {
            C20253ri1.this.Ra();
        }

        @Override // ir.nasim.C6878Pj1.a.InterfaceC0580a
        public void c() {
            C20253ri1.this.Sa();
        }

        @Override // ir.nasim.C6878Pj1.a.InterfaceC0580a
        public void d() {
            C22042ua0.A9(C20253ri1.this, C10265bM4.INSTANCE.a(), false, null, 6, null);
        }
    }

    /* renamed from: ir.nasim.ri1$d */
    /* synthetic */ class d extends EB2 implements SA2 {
        d(Object obj) {
            super(0, obj, C20253ri1.class, "onInvitationViaLink", "onInvitationViaLink()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C20253ri1) this.receiver).Jb();
        }
    }

    /* renamed from: ir.nasim.ri1$e */
    /* synthetic */ class e extends EB2 implements SA2 {
        e(Object obj) {
            super(0, obj, C20253ri1.class, "onBaleClubClickedListener", "onBaleClubClickedListener()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C20253ri1) this.receiver).Hb();
        }
    }

    /* renamed from: ir.nasim.ri1$f */
    /* synthetic */ class f extends EB2 implements UA2 {
        f(Object obj) {
            super(1, obj, C20253ri1.class, "onTitleIconsClickedListener", "onTitleIconsClickedListener(I)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y(((Number) obj).intValue());
            return C19938rB7.a;
        }

        public final void y(int i) {
            ((C20253ri1) this.receiver).Pb(i);
        }
    }

    /* renamed from: ir.nasim.ri1$g */
    public static final class g implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.ri1$g$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.ri1$g$a$a, reason: collision with other inner class name */
            public static final class C1506a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1506a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C20253ri1.g.a.C1506a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.ri1$g$a$a r0 = (ir.nasim.C20253ri1.g.a.C1506a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.ri1$g$a$a r0 = new ir.nasim.ri1$g$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L45
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.gZ0 r5 = (ir.nasim.C13628gZ0) r5
                    ir.nasim.iG3 r5 = r5.e()
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L45
                    return r1
                L45:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20253ri1.g.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public g(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ri1$h */
    public static final class h implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C13137fj1 b;

        /* renamed from: ir.nasim.ri1$h$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C13137fj1 b;

            /* renamed from: ir.nasim.ri1$h$a$a, reason: collision with other inner class name */
            public static final class C1507a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1507a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C13137fj1 c13137fj1) {
                this.a = interfaceC4806Gq2;
                this.b = c13137fj1;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.C20253ri1.h.a.C1507a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.ri1$h$a$a r0 = (ir.nasim.C20253ri1.h.a.C1507a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.ri1$h$a$a r0 = new ir.nasim.ri1$h$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L62
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.iG3 r5 = (ir.nasim.C14653iG3) r5
                    ir.nasim.gG3 r2 = r5.f()
                    boolean r2 = r2 instanceof ir.nasim.AbstractC13460gG3.c
                    if (r2 == 0) goto L54
                    ir.nasim.gG3 r5 = r5.d()
                    boolean r5 = r5.a()
                    if (r5 == 0) goto L54
                    ir.nasim.fj1 r5 = r4.b
                    int r5 = r5.getItemCount()
                    if (r5 != 0) goto L54
                    r5 = r3
                    goto L55
                L54:
                    r5 = 0
                L55:
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L62
                    return r1
                L62:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20253ri1.h.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public h(InterfaceC4557Fq2 interfaceC4557Fq2, C13137fj1 c13137fj1) {
            this.a = interfaceC4557Fq2;
            this.b = c13137fj1;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ri1$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC4557Fq2 d;

        /* renamed from: ir.nasim.ri1$i$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ C20253ri1 d;

            /* renamed from: ir.nasim.ri1$i$a$a, reason: collision with other inner class name */
            static final class C1508a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ boolean c;
                final /* synthetic */ C20253ri1 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1508a(C20253ri1 c20253ri1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c20253ri1;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1508a c1508a = new C1508a(this.d, interfaceC20295rm1);
                    c1508a.c = ((Boolean) obj).booleanValue();
                    return c1508a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.ib(this.c);
                    return C19938rB7.a;
                }

                public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1508a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC4557Fq2 interfaceC4557Fq2, C20253ri1 c20253ri1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = c20253ri1;
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
                    InterfaceC4557Fq2 interfaceC4557Fq2 = this.c;
                    C1508a c1508a = new C1508a(this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2, c1508a, this) == objE) {
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
        i(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4557Fq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20253ri1.this.new i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20253ri1 c20253ri1 = C20253ri1.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(this.d, c20253ri1, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c20253ri1, bVar, aVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ri1$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.ri1$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20253ri1 c;

            /* renamed from: ir.nasim.ri1$j$a$a, reason: collision with other inner class name */
            static final class C1509a implements InterfaceC4806Gq2 {
                final /* synthetic */ C20253ri1 a;

                C1509a(C20253ri1 c20253ri1) {
                    this.a = c20253ri1;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(EF2 ef2, InterfaceC20295rm1 interfaceC20295rm1) {
                    if (ef2 instanceof EF2.d) {
                        this.a.Oa();
                        this.a.Ab();
                        this.a.Vb();
                    } else if (AbstractC13042fc3.d(ef2, EF2.c.a)) {
                        this.a.Ja();
                    } else if (ef2 instanceof EF2.a) {
                        this.a.hb().S1();
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20253ri1 c20253ri1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20253ri1;
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
                    InterfaceC10258bL6 interfaceC10258bL6S1 = this.c.hb().s1();
                    C1509a c1509a = new C1509a(this.c);
                    this.b = 1;
                    if (interfaceC10258bL6S1.b(c1509a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20253ri1.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20253ri1 c20253ri1 = C20253ri1.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(c20253ri1, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c20253ri1, bVar, aVar, this) == objE) {
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ri1$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.ri1$k$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C20253ri1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20253ri1 c20253ri1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20253ri1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                XV4 xv4 = (XV4) this.c;
                C19100pm6.s1.a(new PuppetGroup((String) xv4.e(), (List) xv4.f())).L8(this.d.F5(), "mxpContactBottomSheet");
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(xv4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20253ri1.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(C20253ri1.this.hb().z1());
                a aVar = new a(C20253ri1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2F, aVar, this) == objE) {
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ri1$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.ri1$l$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20253ri1 c;

            /* renamed from: ir.nasim.ri1$l$a$a, reason: collision with other inner class name */
            static final class C1510a implements InterfaceC4806Gq2 {
                final /* synthetic */ C20253ri1 a;

                C1510a(C20253ri1 c20253ri1) {
                    this.a = c20253ri1;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(AbstractC15519jj1 abstractC15519jj1, InterfaceC20295rm1 interfaceC20295rm1) {
                    FrameLayout frameLayout = this.a.Za().j;
                    AbstractC13042fc3.h(frameLayout, "refreshSyncLoading");
                    frameLayout.setVisibility(abstractC15519jj1 instanceof AbstractC15519jj1.a ? 0 : 8);
                    if (AbstractC13042fc3.d(abstractC15519jj1, AbstractC15519jj1.b.a)) {
                        this.a.hc();
                        this.a.hb().Y1();
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20253ri1 c20253ri1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20253ri1;
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
                    InterfaceC10258bL6 interfaceC10258bL6A1 = this.c.hb().A1();
                    C1510a c1510a = new C1510a(this.c);
                    this.b = 1;
                    if (interfaceC10258bL6A1.b(c1510a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20253ri1.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20253ri1 c20253ri1 = C20253ri1.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(c20253ri1, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c20253ri1, bVar, aVar, this) == objE) {
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ri1$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MenuItem d;

        /* renamed from: ir.nasim.ri1$m$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20253ri1 c;
            final /* synthetic */ MenuItem d;

            /* renamed from: ir.nasim.ri1$m$a$a, reason: collision with other inner class name */
            static final class C1511a implements InterfaceC4806Gq2 {
                final /* synthetic */ C20253ri1 a;
                final /* synthetic */ MenuItem b;

                C1511a(C20253ri1 c20253ri1, MenuItem menuItem) {
                    this.a = c20253ri1;
                    this.b = menuItem;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(EnumC4715Gg1 enumC4715Gg1, InterfaceC20295rm1 interfaceC20295rm1) {
                    this.a.Zb(this.b, enumC4715Gg1.j(), enumC4715Gg1.p());
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20253ri1 c20253ri1, MenuItem menuItem, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20253ri1;
                this.d = menuItem;
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
                    InterfaceC10258bL6 interfaceC10258bL6E1 = this.c.hb().E1();
                    C1511a c1511a = new C1511a(this.c, this.d);
                    this.b = 1;
                    if (interfaceC10258bL6E1.b(c1511a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(MenuItem menuItem, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = menuItem;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20253ri1.this.new m(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20253ri1 c20253ri1 = C20253ri1.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(c20253ri1, this.d, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c20253ri1, bVar, aVar, this) == objE) {
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
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ri1$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MenuItem d;

        /* renamed from: ir.nasim.ri1$n$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20253ri1 c;
            final /* synthetic */ MenuItem d;

            /* renamed from: ir.nasim.ri1$n$a$a, reason: collision with other inner class name */
            static final class C1512a implements InterfaceC4806Gq2 {
                final /* synthetic */ MenuItem a;
                final /* synthetic */ C20253ri1 b;

                C1512a(MenuItem menuItem, C20253ri1 c20253ri1) {
                    this.a = menuItem;
                    this.b = c20253ri1;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
                }

                public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    MenuItem menuItem = this.a;
                    C20253ri1 c20253ri1 = this.b;
                    XV4 xv4 = z ? new XV4(c20253ri1.hb().D1().getValue(), AbstractC6392Nk0.d(SA5.white)) : new XV4(EnumC4715Gg1.d, AbstractC6392Nk0.d(SA5.n100));
                    int iC = AbstractC4043Dl1.c(c20253ri1.S7(), ((Number) xv4.f()).intValue());
                    if (Build.VERSION.SDK_INT >= 26) {
                        menuItem.setIconTintList(ColorStateList.valueOf(iC));
                    } else {
                        Drawable icon = menuItem.getIcon();
                        if (icon != null) {
                            icon.setTint(iC);
                        }
                    }
                    c20253ri1.Zb(menuItem, ((EnumC4715Gg1) xv4.e()).j(), ((EnumC4715Gg1) xv4.e()).p());
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20253ri1 c20253ri1, MenuItem menuItem, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20253ri1;
                this.d = menuItem;
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
                    InterfaceC10258bL6 interfaceC10258bL6Q1 = this.c.hb().q1();
                    C1512a c1512a = new C1512a(this.d, this.c);
                    this.b = 1;
                    if (interfaceC10258bL6Q1.b(c1512a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(MenuItem menuItem, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = menuItem;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20253ri1.this.new n(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20253ri1 c20253ri1 = C20253ri1.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(c20253ri1, this.d, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c20253ri1, bVar, aVar, this) == objE) {
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
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ri1$o */
    public static final class o implements XI4 {
        o() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(ContactItem.BaleContactItem baleContactItem) {
            AbstractC13042fc3.i(baleContactItem, "item");
            C20253ri1.this.Qb(baleContactItem);
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(ContactItem.BaleContactItem baleContactItem) {
            AbstractC13042fc3.i(baleContactItem, "item");
            C20253ri1.this.bc(baleContactItem);
            return true;
        }

        @Override // ir.nasim.XI4
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void l5(ContactItem.BaleContactItem baleContactItem) {
            AbstractC13042fc3.i(baleContactItem, "item");
            C20253ri1.this.jc(baleContactItem, false);
        }
    }

    /* renamed from: ir.nasim.ri1$p */
    public static final class p implements EJ4 {
        p() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(ContactItem.MxpPuppetContactItem mxpPuppetContactItem) {
            AbstractC13042fc3.i(mxpPuppetContactItem, "item");
            C20253ri1.this.Rb(mxpPuppetContactItem);
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(ContactItem.MxpPuppetContactItem mxpPuppetContactItem) {
            AbstractC13042fc3.i(mxpPuppetContactItem, "item");
            return false;
        }

        @Override // ir.nasim.EJ4
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void L0(ContactItem.MxpPuppetContactItem mxpPuppetContactItem) {
            AbstractC13042fc3.i(mxpPuppetContactItem, "item");
            C20253ri1.this.Rb(mxpPuppetContactItem);
        }
    }

    /* renamed from: ir.nasim.ri1$q */
    public static final class q implements InterfaceC22483vJ4 {
        q() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(ContactItem.PhoneBookContactItem phoneBookContactItem) {
            AbstractC13042fc3.i(phoneBookContactItem, "item");
            C20253ri1.this.Xb(phoneBookContactItem);
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(ContactItem.PhoneBookContactItem phoneBookContactItem) {
            AbstractC13042fc3.i(phoneBookContactItem, "item");
            return false;
        }
    }

    /* renamed from: ir.nasim.ri1$r */
    public static final class r implements InterfaceC22483vJ4 {
        r() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(ContactItem.PhoneBookContactItem phoneBookContactItem) {
            AbstractC13042fc3.i(phoneBookContactItem, "item");
            C20253ri1.this.hb().y1(phoneBookContactItem.getName(), phoneBookContactItem.getPhoneNumber());
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(ContactItem.PhoneBookContactItem phoneBookContactItem) {
            AbstractC13042fc3.i(phoneBookContactItem, "item");
            return false;
        }
    }

    /* renamed from: ir.nasim.ri1$t */
    static final class t implements InterfaceC15796kB2 {
        t() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C20253ri1 c20253ri1) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c20253ri1, "this$0");
            dialog.dismiss();
            c20253ri1.hb().H1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            P31 p31 = P31.a;
            InterfaceC14603iB2 interfaceC14603iB2A = p31.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = p31.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(2006050600);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C20253ri1.this);
            final C20253ri1 c20253ri1 = C20253ri1.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.si1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20253ri1.t.d(dialog, c20253ri1);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = ED5.contacts_refresh_positive_btn;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(2006059381);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.ti1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20253ri1.t.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, ED5.contacts_refresh_negative_btn, null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ri1$u */
    public static final class u extends AbstractC8614Ws3 implements UA2 {
        public u() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C6272Mx2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.ri1$v */
    public static final class v extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.ri1$w */
    public static final class w extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.ri1$x */
    public static final class x extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.ri1$y */
    public static final class y extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.ri1$z */
    public static final class z extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C20253ri1() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new w(new v(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C9306Zj1.class), new x(interfaceC9173Yu3B), new y(null, interfaceC9173Yu3B), new z(this, interfaceC9173Yu3B));
        this.readContactsPermission = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mi1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.Sb();
            }
        });
        this.callErrorsSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ni1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.La(this.a);
            }
        });
        this.onBaleContactClickedListener = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.oi1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.Ib(this.a);
            }
        });
        this.onMxpClickListener = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pi1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.Kb(this.a);
            }
        });
        this.onPhoneBookClickedListener = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qi1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.Nb(this.a);
            }
        });
        this.onPhoneBookMxpClickedListener = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Zh1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.Ob(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ab() {
        C13137fj1 c13137fj1 = this.adapter;
        if (c13137fj1 == null) {
            return;
        }
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new i(AbstractC6459Nq2.v(new h(new g(AbstractC6459Nq2.x(c13137fj1.E(), new UA2() { // from class: ir.nasim.di1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20253ri1.Bb((C13628gZ0) obj);
            }
        })), c13137fj1)), null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC13460gG3 Bb(C13628gZ0 c13628gZ0) {
        AbstractC13042fc3.i(c13628gZ0, "it");
        return c13628gZ0.e().f();
    }

    private final void Cb() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new j(null), 3, null);
    }

    private final void Db() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new k(null), 3, null);
    }

    private final void Eb() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new l(null), 3, null);
    }

    private final InterfaceC13730gj3 Fb(MenuItem menuItem) {
        return AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new m(menuItem, null), 3, null);
    }

    private final void Gb(MenuItem menuItem) {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new n(menuItem, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hb() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (C4100Dr4.a(contextS7)) {
            ac();
            return;
        }
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C24398yZ.c(fragmentActivityQ7, this).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ia() {
        C22042ua0.A9(this, C8386Vt0.a.m8() ? new C13973h8() : new CH4(), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o Ib(C20253ri1 c20253ri1) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        return c20253ri1.new o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja() {
        C6272Mx2 c6272Mx2Za = Za();
        ProgressBar progressBar = c6272Mx2Za.h;
        AbstractC13042fc3.h(progressBar, "progressBar");
        progressBar.setVisibility(0);
        ConstraintLayout root = c6272Mx2Za.m.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        root.setVisibility(this.isFromCallLog ^ true ? 0 : 8);
        RecyclerView recyclerView = c6272Mx2Za.d;
        AbstractC13042fc3.h(recyclerView, "container");
        recyclerView.setVisibility(8);
        MaterialCardView root2 = c6272Mx2Za.i.getRoot();
        AbstractC13042fc3.h(root2, "getRoot(...)");
        root2.setVisibility(8);
        LinearLayout root3 = c6272Mx2Za.e.getRoot();
        AbstractC13042fc3.h(root3, "getRoot(...)");
        root3.setVisibility(8);
        LinearLayout root4 = c6272Mx2Za.g.getRoot();
        AbstractC13042fc3.h(root4, "getRoot(...)");
        root4.setVisibility(8);
        Ma(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jb() {
        String strN2 = AbstractC5969Lp4.d().n2();
        AbstractC13042fc3.h(strN2, "getInviteMessage(...)");
        String strM = AbstractC20153rZ6.M(strN2, "{inviteUrl}", hb().p1(), false, 4, null);
        String strF = C5735Kp4.w().f();
        AbstractC13042fc3.h(strF, "getAppName(...)");
        String strM2 = AbstractC20153rZ6.M(strM, "{appName}", strF, false, 4, null);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", strM2);
        intent.setType("text/plain");
        n8(intent);
    }

    private final void Ka(C13137fj1 adapter) {
        androidx.recyclerview.widget.f fVarN = adapter.N(new VT4());
        if (!this.isFromCallLog) {
            fVarN = new androidx.recyclerview.widget.f(Ua(), fVarN);
        }
        RecyclerView recyclerView = Za().d;
        recyclerView.setAdapter(fVarN);
        recyclerView.setItemAnimator(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p Kb(C20253ri1 c20253ri1) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        return c20253ri1.new p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 La(C20253ri1 c20253ri1) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        ConstraintLayout root = c20253ri1.Za().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.m(4000);
        return c17468n10;
    }

    private final void Lb() {
        hb().d2(false);
        if (m8(gb())) {
            return;
        }
        C5505Jq.M(gb(), false);
        C5505Jq.M("android.permission.READ_CONTACTS_fragment", false);
    }

    private final void Ma(boolean isVisible) {
        Menu menu = Za().l.getMenu();
        if (menu != null) {
            int size = menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                menu.getItem(i2).setVisible(isVisible);
            }
        }
    }

    private final void Mb() {
        hb().R1();
        hb().d2(true);
    }

    private final boolean Na() {
        return Za().l.j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q Nb(C20253ri1 c20253ri1) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        return c20253ri1.new q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oa() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new C20255b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r Ob(C20253ri1 c20253ri1) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        return c20253ri1.new r();
    }

    private final void Pa() {
        MenuItem menuItemFindItem = Za().l.getMenu().findItem(AbstractC10176bC5.sort_contacts);
        if (menuItemFindItem != null) {
            Gb(menuItemFindItem);
            Fb(menuItemFindItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pb(int iconId) {
        if (iconId == AbstractC15799kB5.ic_refresh) {
            Tb();
        }
    }

    private final String[] Qa(String contactName) {
        String strH6 = h6(ED5.contacts_menu_edit);
        String strH62 = h6(ED5.contacts_menu_remove);
        AbstractC13042fc3.h(strH62, "getString(...)");
        return new String[]{strH6, AbstractC20153rZ6.O(strH62, "{0}", contactName, false, 4, null)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qb(ContactItem.BaleContactItem contact) {
        Za().l.j0();
        C18987pb3 c18987pb3 = C18987pb3.a;
        C11458d25 c11458d25E = C11458d25.E(contact.getId());
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        if (!c18987pb3.w1(c11458d25E, null, false)) {
            gc("Failed to open " + contact.getName() + " page");
        }
        C3343Am.g("contacts_click_on_a_contact");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ra() {
        C22042ua0.A9(this, bb().a(ZN2.CHANNEL), false, "GroupTypeMakerFragment", 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rb(ContactItem.MxpPuppetContactItem item) {
        C19100pm6.s1.a(new PuppetGroup(item.getName(), item.getPuppets())).L8(F5(), "mxpContactBottomSheet");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa() {
        C22042ua0.A9(this, bb().a(ZN2.GROUP), false, "GroupTypeMakerFragment", 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Sb() {
        return "android.permission.READ_CONTACTS";
    }

    private final void Ta() {
        C21753u45.a.a1(this, 1088, C21753u45.c.d, (56 & 8) != 0 ? null : null, (56 & 16) != 0 ? new SA2() { // from class: ir.nasim.e45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.c1();
            }
        } : null, (56 & 32) != 0 ? new SA2() { // from class: ir.nasim.f45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.d1();
            }
        } : null, C21753u45.d.h, C21753u45.d.i);
    }

    private final void Tb() {
        fc();
    }

    private final C6878Pj1 Ua() {
        return new C6878Pj1(hb().u1(), hb().J1(), new c());
    }

    private final void Ub(ContactItem.BaleContactItem contact) {
        InterfaceC14830iZ0 interfaceC14830iZ0K1 = AbstractC5969Lp4.d().k1(contact.getId());
        if (interfaceC14830iZ0K1 == null) {
            Xa(contact);
        } else {
            R8(interfaceC14830iZ0K1, ED5.contacts_menu_remove_progress, new s(contact));
        }
    }

    private final void Va() {
        this.adapter = null;
        Za().d.setAdapter(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vb() {
        ProgressBar progressBar = Za().h;
        AbstractC13042fc3.h(progressBar, "progressBar");
        progressBar.setVisibility(8);
        Ma(true);
    }

    private final void Wa(ContactItem.BaleContactItem contact) {
        int id = contact.getId();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        n8(C22055ub3.c(id, contextS7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wb(int requestCode) {
        if (requestCode == 1011 || requestCode == 1012) {
            C5505Jq.L(this, requestCode, null);
            return;
        }
        if (requestCode == 1014) {
            C5505Jq.J(this, requestCode, null);
        } else if (requestCode == 1019 || requestCode == 1020) {
            C5505Jq.K(this, requestCode, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xa(ContactItem.BaleContactItem contact) {
        gc("Failed to remove " + contact.getName() + " from your contacts");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xb(ContactItem.PhoneBookContactItem item) {
        n8(C20778sb3.a.a(item.getPhoneNumber(), Y8(ED5.invitation_via_sms)));
    }

    private final void Ya() {
        Bundle bundleE5 = E5();
        boolean z2 = false;
        if (bundleE5 != null && bundleE5.getBoolean("IS_FROM_CALL_LOGS", false)) {
            z2 = true;
        }
        this.isFromCallLog = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6272Mx2 Za() {
        Object objA = this.binding.a(this, v1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C6272Mx2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MenuItem Zb(MenuItem menuItem, int i2, int i3) {
        menuItem.setIcon(AbstractC4043Dl1.f(S7(), i2));
        menuItem.setTitle(h6(i3));
        return menuItem;
    }

    private final C17468n10 ab() {
        return (C17468n10) this.callErrorsSnackBar.getValue();
    }

    private final void ac() {
        C14486i0.a aVar = C14486i0.f;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C14486i0 c14486i0A = aVar.a(fragmentActivityQ7);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        FragmentActivity fragmentActivityQ72 = Q7();
        AbstractC13042fc3.g(fragmentActivityQ72, "null cannot be cast to non-null type ir.nasim.designsystem.base.activity.BaseActivity");
        c14486i0A.o(new BottomSheetWebView(contextS7, (BaseActivity) fragmentActivityQ72, AbstractC5969Lp4.d().o2().S().X4(), c14486i0A, null, null, 32, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bc(final ContactItem.BaleContactItem contact) {
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        new AlertDialog.a(fragmentActivityQ7).h(Qa(contact.getName()), new DialogInterface.OnClickListener() { // from class: ir.nasim.Yh1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C20253ri1.cc(this.a, contact, dialogInterface, i2);
            }
        }).o().setCanceledOnTouchOutside(true);
    }

    private final o cb() {
        return (o) this.onBaleContactClickedListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cc(C20253ri1 c20253ri1, ContactItem.BaleContactItem baleContactItem, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        AbstractC13042fc3.i(baleContactItem, "$contact");
        if (i2 == 0) {
            c20253ri1.Wa(baleContactItem);
        } else if (i2 == 1) {
            c20253ri1.Ub(baleContactItem);
        }
        dialogInterface.dismiss();
    }

    private final p db() {
        return (p) this.onMxpClickListener.getValue();
    }

    private final void dc() {
        List listM;
        C11066cg3 c11066cg3K;
        C13137fj1 c13137fj1 = this.adapter;
        List listF = (c13137fj1 == null || (c11066cg3K = c13137fj1.K()) == null) ? null : c11066cg3K.f();
        if (listF == null || (listM = listF.subList(0, Math.min(listF.size(), hb().U1()))) == null) {
            listM = AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            ContactItem contactItem = (ContactItem) obj;
            if ((contactItem instanceof ContactItem.BaleContactItem) || (contactItem instanceof ContactItem.MxpPuppetContactItem) || (contactItem instanceof ContactItem.PhoneBookContactItem) || (contactItem instanceof ContactItem.SeparatorTitleItem)) {
                arrayList.add(obj);
            }
        }
        C22042ua0.A9(this, C21543tj1.INSTANCE.a((ContactItem[]) arrayList.toArray(new ContactItem[0]), this.isFromCallLog), false, null, 6, null);
    }

    private final q eb() {
        return (q) this.onPhoneBookClickedListener.getValue();
    }

    private final void ec() {
        if (jb()) {
            hb().d2(true);
        } else {
            Ta();
        }
    }

    private final r fb() {
        return (r) this.onPhoneBookMxpClickedListener.getValue();
    }

    private final void fc() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-328290254, true, new t()), 4, null).show();
    }

    private final String gb() {
        return (String) this.readContactsPermission.getValue();
    }

    private final void gc(String text) {
        ConstraintLayout root = Za().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.m(1500);
        c17468n10.k(Za().k);
        c17468n10.o(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C9306Zj1 hb() {
        return (C9306Zj1) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hc() {
        if (C15542jl4.a.a()) {
            String strH6 = h6(ED5.contacts_refresh_sync_was_successful);
            AbstractC13042fc3.h(strH6, "getString(...)");
            gc(strH6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ib(boolean listIsEmpty) {
        C6272Mx2 c6272Mx2Za = Za();
        RecyclerView recyclerView = c6272Mx2Za.d;
        AbstractC13042fc3.h(recyclerView, "container");
        recyclerView.setVisibility(listIsEmpty ^ true ? 0 : 8);
        ConstraintLayout root = c6272Mx2Za.m.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        root.setVisibility(listIsEmpty && !this.isFromCallLog ? 0 : 8);
        MaterialCardView root2 = c6272Mx2Za.i.getRoot();
        AbstractC13042fc3.h(root2, "getRoot(...)");
        root2.setVisibility(listIsEmpty && hb().x1() ? 0 : 8);
        LinearLayout root3 = c6272Mx2Za.e.getRoot();
        AbstractC13042fc3.h(root3, "getRoot(...)");
        root3.setVisibility(8);
        LinearLayout root4 = c6272Mx2Za.g.getRoot();
        AbstractC13042fc3.h(root4, "getRoot(...)");
        root4.setVisibility(listIsEmpty && !hb().x1() ? 0 : 8);
    }

    private final InterfaceC13730gj3 ic() {
        return AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new A(null), 3, null);
    }

    private final boolean jb() {
        return AbstractC4043Dl1.a(S7(), gb()) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jc(ContactItem.BaleContactItem contact, boolean isVideo) {
        this.selectedContactItem = contact;
        C11458d25 c11458d25E = C11458d25.E(contact.getId());
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        C20384rv0 c20384rv0 = C20384rv0.a;
        C20384rv0.c0(c11458d25E.getPeerId(), isVideo, new SA2() { // from class: ir.nasim.ki1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.kc(this.a);
            }
        }, new SA2() { // from class: ir.nasim.li1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.lc(this.a);
            }
        }, new B(this));
        C5074Hu0.a.d(EnumC22288uz0.e, isVideo);
    }

    private final void kb() {
        d dVar = new d(this);
        e eVar = new e(this);
        o oVarCb = cb();
        p pVarDb = db();
        q qVarEb = eb();
        r rVarFb = fb();
        C13137fj1 c13137fj1 = new C13137fj1(dVar, eVar, new f(this), new SA2() { // from class: ir.nasim.ci1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.lb(this.a);
            }
        }, oVarCb, pVarDb, qVarEb, rVarFb, this.isFromCallLog);
        Ka(c13137fj1);
        this.adapter = c13137fj1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 kc(C20253ri1 c20253ri1) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        C17468n10 c17468n10Ab = c20253ri1.ab();
        String strH6 = c20253ri1.h6(ED5.not_possible_to_use_when_calling);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10Ab.o(strH6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 lb(C20253ri1 c20253ri1) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        C21753u45.Q0(C21753u45.a, c20253ri1, 1088, null, new C21753u45.d[]{C21753u45.d.h, C21753u45.d.i}, 4, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 lc(C20253ri1 c20253ri1) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        FragmentActivity fragmentActivityQ7 = c20253ri1.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C24398yZ.c(fragmentActivityQ7, c20253ri1).show();
        return C19938rB7.a;
    }

    private final void mb() {
        C9063Yi1 c9063Yi1 = Za().i;
        TextView textView = c9063Yi1.e;
        textView.setTypeface(C6011Lu2.i());
        textView.setText(ED5.contacts_refresh_title);
        TextView textView2 = c9063Yi1.d;
        textView2.setTypeface(C6011Lu2.k());
        textView2.setText(ED5.contacts_refresh_card_description);
        MaterialButton materialButton = c9063Yi1.c;
        materialButton.setTypeface(C6011Lu2.i());
        materialButton.setText(ED5.contacts_refresh_title);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ai1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20253ri1.nb(this.a, view);
            }
        });
        C14929ij1 c14929ij1 = Za().g;
        c14929ij1.c.setTypeface(C6011Lu2.k());
        TextView textView3 = c14929ij1.b;
        textView3.setTypeface(C6011Lu2.i());
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20253ri1.ob(this.a, view);
            }
        });
    }

    private final void mc() {
        if (((Boolean) hb().q1().getValue()).booleanValue()) {
            hb().c2();
            return;
        }
        ConstraintLayout root = Za().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        String strH6 = h6(ED5.change_privacy_setting_to_sort_contacts_by_last_seen);
        AbstractC13042fc3.h(strH6, "getString(...)");
        C17468n10.p(c17468n10, strH6, new AbstractC13463gG6.a(h6(ED5.settings_setting), null, false, new SA2() { // from class: ir.nasim.ii1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20253ri1.nc(this.a);
            }
        }, 2, null), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nb(C20253ri1 c20253ri1, View view) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        c20253ri1.Tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 nc(C20253ri1 c20253ri1) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        C22042ua0.A9(c20253ri1, new C4747Gj6(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ob(C20253ri1 c20253ri1, View view) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        C21753u45.Q0(C21753u45.a, c20253ri1, 1088, null, new C21753u45.d[]{C21753u45.d.h, C21753u45.d.i}, 4, null);
    }

    private final void pb() {
        Za().f.setTypeface(C6011Lu2.i());
    }

    private final void qb() {
        DrawerToolbar drawerToolbar = Za().l;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(drawerToolbar, fragmentActivityQ7, true, false, 4, null);
        AbstractC13042fc3.f(drawerToolbar);
        rb(drawerToolbar);
    }

    private final void rb(BaleToolbar baleToolbar) {
        baleToolbar.y(AbstractC13435gD5.contacts_menu);
        baleToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.ji1
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return C20253ri1.sb(this.a, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sb(C20253ri1 c20253ri1, MenuItem menuItem) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        int itemId = menuItem.getItemId();
        if (itemId == AbstractC10176bC5.search_contacts) {
            c20253ri1.dc();
            return true;
        }
        if (itemId != AbstractC10176bC5.sort_contacts) {
            return false;
        }
        c20253ri1.mc();
        return true;
    }

    private final void tb() {
        C7356Rj1 c7356Rj1 = Za().m;
        c7356Rj1.g.setTypeface(C6011Lu2.k());
        c7356Rj1.d.setTypeface(C6011Lu2.k());
        c7356Rj1.c.setTypeface(C6011Lu2.k());
        if (hb().J1()) {
            c7356Rj1.j.setVisibility(0);
            c7356Rj1.h.setVisibility(0);
            String strU1 = hb().u1();
            if (strU1 != null) {
                c7356Rj1.i.setText(S7().getString(ED5.organization_title, strU1));
            }
            c7356Rj1.i.setTypeface(C6011Lu2.k());
            c7356Rj1.k.setTypeface(C6011Lu2.i());
        }
        c7356Rj1.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ei1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20253ri1.ub(this.a, view);
            }
        });
        c7356Rj1.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20253ri1.vb(this.a, view);
            }
        });
        c7356Rj1.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.gi1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20253ri1.wb(this.a, view);
            }
        });
        if (hb().J1()) {
            c7356Rj1.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.hi1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C20253ri1.xb(this.a, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ub(C20253ri1 c20253ri1, View view) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        c20253ri1.Sa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vb(C20253ri1 c20253ri1, View view) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        c20253ri1.Ra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wb(C20253ri1 c20253ri1, View view) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        c20253ri1.Ia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xb(C20253ri1 c20253ri1, View view) {
        AbstractC13042fc3.i(c20253ri1, "this$0");
        C22042ua0.A9(c20253ri1, C10265bM4.INSTANCE.a(), false, null, 6, null);
    }

    private final void yb() {
        qb();
        tb();
        mb();
        kb();
        pb();
    }

    private final void zb() {
        Cb();
        Eb();
        Pa();
        Db();
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        ec();
        Ya();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C6272Mx2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        Va();
    }

    @Override // androidx.fragment.app.Fragment
    public void W6(boolean hidden) {
        super.W6(hidden);
        if (hidden) {
            return;
        }
        hb().S1();
    }

    public final void Yb(EnumC6843Pf2 fabricEventType) {
        AbstractC13042fc3.i(fabricEventType, "fabricEventType");
        HashMap map = new HashMap();
        map.put("origin", Integer.valueOf(fabricEventType.j()));
        C3343Am.i("open_contacts", map);
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        return Na();
    }

    public final InterfaceC9687aO2 bb() {
        InterfaceC9687aO2 interfaceC9687aO2 = this.groupTypeMakerNavigator;
        if (interfaceC9687aO2 != null) {
            return interfaceC9687aO2;
        }
        AbstractC13042fc3.y("groupTypeMakerNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int requestCode, String[] permissions, int[] grantResults) {
        ContactItem.BaleContactItem baleContactItem;
        ContactItem.BaleContactItem baleContactItem2;
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (requestCode != 1011) {
            if (requestCode != 1012 && requestCode != 1014) {
                if (requestCode == 1088) {
                    Integer numD0 = AbstractC10242bK.d0(grantResults);
                    if (numD0 != null && numD0.intValue() == 0) {
                        Mb();
                        return;
                    } else {
                        Lb();
                        return;
                    }
                }
                if (requestCode != 1019) {
                    if (requestCode != 1020) {
                        super.g7(requestCode, permissions, grantResults);
                        return;
                    }
                }
            }
            Integer numD02 = AbstractC10242bK.d0(grantResults);
            if (numD02 == null || numD02.intValue() != 0 || (baleContactItem2 = this.selectedContactItem) == null) {
                return;
            }
            jc(baleContactItem2, true);
            return;
        }
        Integer numD03 = AbstractC10242bK.d0(grantResults);
        if (numD03 == null || numD03.intValue() != 0 || (baleContactItem = this.selectedContactItem) == null) {
            return;
        }
        jc(baleContactItem, false);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        hb().S1();
    }

    @Override // androidx.fragment.app.Fragment
    public void j7() {
        super.j7();
        hb().d2(jb());
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        yb();
        zb();
        ic();
    }

    /* renamed from: ir.nasim.ri1$s */
    public static final class s implements InterfaceC15419jZ0 {
        final /* synthetic */ ContactItem.BaleContactItem b;

        s(ContactItem.BaleContactItem baleContactItem) {
            this.b = baleContactItem;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            C20253ri1.this.Xa(this.b);
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
        }
    }
}
