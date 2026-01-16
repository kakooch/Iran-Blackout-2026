package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.window.OnBackInvokedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC21163tD2;
import ir.nasim.AbstractC22427vD2;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.C14864ic5;
import ir.nasim.C24784zC2;
import ir.nasim.GY;
import ir.nasim.InterfaceC11562dD2;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC21791u83;
import ir.nasim.O98;
import ir.nasim.TC2;
import ir.nasim.components.badges.view.CounterBadge;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.features.media.components.PhotoViewerBridge;
import ir.nasim.features.media.components.PhotoViewerInterface;
import ir.nasim.features.smiles.panel.SmilesPanelView;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ¶\u00012\u00020\u0001:\u0002·\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J-\u0010\u001e\u001a\u00020\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0011H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020+2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00112\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00112\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b7\u00106J;\u0010?\u001a\u00020>2\u0006\u00108\u001a\u00020/2\f\u0010:\u001a\b\u0012\u0004\u0012\u000203092\u0006\u0010<\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bH\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020$2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\bA\u0010BJ\u001a\u0010E\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020D0CH\u0082@¢\u0006\u0004\bE\u0010FJ)\u0010J\u001a\u00020\u00112\u0006\u0010,\u001a\u00020+2\u0006\u0010H\u001a\u00020G2\b\u0010I\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010309H\u0002¢\u0006\u0004\bL\u0010MJ!\u0010Q\u001a\u00020\u00112\b\u0010O\u001a\u0004\u0018\u00010N2\u0006\u0010P\u001a\u00020/H\u0002¢\u0006\u0004\bQ\u0010RJ)\u0010U\u001a\u00020\u00112\u0006\u0010,\u001a\u00020+2\u0006\u0010T\u001a\u00020S2\b\u0010I\u001a\u0004\u0018\u00010SH\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010Y\u001a\u00020\u00112\u0006\u0010X\u001a\u00020WH\u0002¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0011H\u0002¢\u0006\u0004\b[\u0010\u0003J\u000f\u0010\\\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\\\u0010\u0003J\u001d\u0010_\u001a\u00020\u00112\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]09H\u0002¢\u0006\u0004\b_\u0010`J!\u0010a\u001a\u00020\u00112\u0006\u0010T\u001a\u00020S2\b\u0010I\u001a\u0004\u0018\u00010SH\u0002¢\u0006\u0004\ba\u0010bJ!\u0010d\u001a\u00020\u00112\u0006\u0010X\u001a\u00020W2\b\u0010c\u001a\u0004\u0018\u00010WH\u0002¢\u0006\u0004\bd\u0010eJ\u000f\u0010g\u001a\u00020fH\u0002¢\u0006\u0004\bg\u0010hJ\u001f\u0010k\u001a\u00020\u00112\u0006\u0010i\u001a\u00020W2\u0006\u0010j\u001a\u00020/H\u0002¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020\u0011H\u0002¢\u0006\u0004\bm\u0010\u0003J\u000f\u0010n\u001a\u00020\u0011H\u0002¢\u0006\u0004\bn\u0010\u0003J\u0017\u0010q\u001a\u00020\u00112\u0006\u0010p\u001a\u00020oH\u0002¢\u0006\u0004\bq\u0010rJ\u0017\u0010t\u001a\u00020\u00112\u0006\u0010s\u001a\u00020WH\u0002¢\u0006\u0004\bt\u0010ZJ\u000f\u0010u\u001a\u00020/H\u0002¢\u0006\u0004\bu\u0010vJ\u0011\u0010x\u001a\u0004\u0018\u00010wH\u0002¢\u0006\u0004\bx\u0010yJ\u0017\u0010{\u001a\u00020\u00112\u0006\u0010z\u001a\u00020WH\u0002¢\u0006\u0004\b{\u0010ZR\u001d\u0010\u0081\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0086\u0001\u001a\u00030\u0082\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0083\u0001\u0010~\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001e\u0010\u0089\u0001\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010~\u001a\u0005\b\u0088\u0001\u0010vR!\u0010\u008f\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0094\u0001\u001a\u00030\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0091\u0001\u0010~\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0019\u0010\u009b\u0001\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001a\u0010¡\u0001\u001a\u00030\u009e\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001b\u0010¤\u0001\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R!\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R \u0010¬\u0001\u001a\u00030¨\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b©\u0001\u0010~\u001a\u0006\bª\u0001\u0010«\u0001R \u0010±\u0001\u001a\u00030\u00ad\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b®\u0001\u0010~\u001a\u0006\b¯\u0001\u0010°\u0001R\u001c\u0010µ\u0001\u001a\u00030²\u0001*\u00020\n8BX\u0082\u0004¢\u0006\b\u001a\u0006\b³\u0001\u0010´\u0001¨\u0006¸\u0001"}, d2 = {"Lir/nasim/zC2;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "view", "Lir/nasim/rB7;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "u8", "x8", "Lir/nasim/CF6;", "Y9", "()Lir/nasim/CF6;", "qa", "Lkotlin/Function0;", "onCancelSelection", "onDismissAlertDialog", "Ca", "(Lir/nasim/SA2;Lir/nasim/SA2;)V", "xa", "ua", "va", "H9", "Lir/nasim/gj3;", "O9", "()Lir/nasim/gj3;", "Lir/nasim/tD2$a;", "event", "Ba", "(Lir/nasim/tD2$a;)V", "Lir/nasim/bC2;", "galleryAdapter", "ya", "(Lir/nasim/bC2;)V", "", "isMultiSelect", "R9", "(Z)Lir/nasim/bC2;", "Lir/nasim/uD2;", "item", "na", "(Lir/nasim/uD2;)V", "la", "allowCaption", "", "uiItems", "Lir/nasim/features/media/components/PhotoViewerInterface;", "photoViewerInstance", "onSendButtonClicked", "Lir/nasim/mD2;", "S9", "(ZLjava/util/List;Lir/nasim/features/media/components/PhotoViewerInterface;Lir/nasim/SA2;)Lir/nasim/mD2;", "P9", "(Lir/nasim/bC2;)Lir/nasim/gj3;", "Lir/nasim/bL6;", "Lir/nasim/vD2;", "N9", "(Lir/nasim/bL6;Lir/nasim/rm1;)Ljava/lang/Object;", "Lir/nasim/vD2$b;", "loadingState", "previousState", "I9", "(Lir/nasim/bC2;Lir/nasim/vD2$b;Lir/nasim/vD2$b;)V", "X9", "()Ljava/util/List;", "", "caption", "candidateItemChanged", "Ha", "(Ljava/lang/String;Z)V", "Lir/nasim/vD2$c;", "selectionState", "J9", "(Lir/nasim/bC2;Lir/nasim/vD2$c;Lir/nasim/vD2$c;)V", "", "selectedItemsCount", "ja", "(I)V", "sa", "ta", "Lir/nasim/Il0;", "buckets", "za", "(Ljava/util/List;)V", "Oa", "(Lir/nasim/vD2$c;Lir/nasim/vD2$c;)V", "previousSelectedItemsCount", "Ga", "(ILjava/lang/Integer;)V", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$f;", "W9", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior$f;", "count", "showSendOptions", "Va", "(IZ)V", "Sa", "ra", "Lir/nasim/dD2;", "keyboardState", "Ia", "(Lir/nasim/dD2;)V", "keyboardHeight", "Ta", "ka", "()Z", "", "M9", "()Ljava/lang/Object;", "newHeight", "Ua", "Lir/nasim/VI2;", "s1", "Lir/nasim/Yu3;", "ba", "()Lir/nasim/VI2;", "glideRequests", "Lir/nasim/TC2;", "t1", "aa", "()Lir/nasim/TC2;", "config", "u1", "ha", "isComment", "Lir/nasim/KC2;", "v1", "Lir/nasim/bW7;", "Z9", "()Lir/nasim/KC2;", "binding", "Lir/nasim/NC2;", "w1", "fa", "()Lir/nasim/NC2;", "viewModel", "Landroid/text/TextWatcher;", "x1", "Landroid/text/TextWatcher;", "doOnTextChanged", "y1", "Z", "updateInputBarTextForCurrentCandidateItem", "z1", "Lir/nasim/bC2;", "Lcom/google/android/material/bottomsheet/a;", "A1", "Lcom/google/android/material/bottomsheet/a;", "bottomSheetDialog", "B1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$f;", "behaviorCallback", "C1", "Lir/nasim/SA2;", "onBackPressedAction", "Lir/nasim/features/smiles/panel/SmilesPanelView;", "D1", "ea", "()Lir/nasim/features/smiles/panel/SmilesPanelView;", "smilePanel", "Lir/nasim/ic5;", "E1", "da", "()Lir/nasim/ic5;", "photoViewerInputBar", "Landroid/view/inputmethod/InputMethodManager;", "ca", "(Landroid/view/View;)Landroid/view/inputmethod/InputMethodManager;", "inputMethodManager", "F1", "a", "gallery_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.zC2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24784zC2 extends MW2 {

    /* renamed from: A1, reason: from kotlin metadata */
    private com.google.android.material.bottomsheet.a bottomSheetDialog;

    /* renamed from: B1, reason: from kotlin metadata */
    private BottomSheetBehavior.f behaviorCallback;

    /* renamed from: C1, reason: from kotlin metadata */
    private SA2 onBackPressedAction;

    /* renamed from: D1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 smilePanel;

    /* renamed from: E1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 photoViewerInputBar;

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 glideRequests = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.vC2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C24784zC2.ga(this.a);
        }
    });

    /* renamed from: t1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 config = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.wC2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C24784zC2.Q9(this.a);
        }
    });

    /* renamed from: u1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 isComment = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.xC2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Boolean.valueOf(C24784zC2.ia(this.a));
        }
    });

    /* renamed from: v1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new v(), AbstractC20046rN7.c());

    /* renamed from: w1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: x1, reason: from kotlin metadata */
    private TextWatcher doOnTextChanged;

    /* renamed from: y1, reason: from kotlin metadata */
    private boolean updateInputBarTextForCurrentCandidateItem;

    /* renamed from: z1, reason: from kotlin metadata */
    private C10173bC2 galleryAdapter;
    static final /* synthetic */ InterfaceC5239Im3[] G1 = {AbstractC10882cM5.i(new C25226zw5(C24784zC2.class, "binding", "getBinding()Lir/nasim/gallery/databinding/GalleryBottomSheetBinding;", 0))};

    /* renamed from: F1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int H1 = 8;
    private static final int I1 = AbstractC8943Xx1.c(6);

    /* renamed from: ir.nasim.zC2$A */
    public static final class A extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public A(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.zC2$B */
    /* synthetic */ class B extends EB2 implements SA2 {
        B(Object obj) {
            super(0, obj, NC2.class, "dismissBottomSheet", "dismissBottomSheet()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((NC2) this.receiver).g1();
        }
    }

    /* renamed from: ir.nasim.zC2$C */
    public static final class C implements View.OnLayoutChangeListener {
        final /* synthetic */ KC2 a;
        final /* synthetic */ C24784zC2 b;

        public C(KC2 kc2, C24784zC2 c24784zC2) {
            this.a = kc2;
            this.b = c24784zC2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            RecyclerView recyclerView = this.a.g;
            AbstractC13042fc3.h(recyclerView, "galleryRecyclerView");
            recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), view.getHeight() + this.a.i.getHeight());
            this.b.ra();
        }
    }

    /* renamed from: ir.nasim.zC2$D */
    public static final class D implements View.OnLayoutChangeListener {
        final /* synthetic */ KC2 a;
        final /* synthetic */ int b;
        final /* synthetic */ C24784zC2 c;

        public D(KC2 kc2, int i, C24784zC2 c24784zC2) {
            this.a = kc2;
            this.b = i;
            this.c = c24784zC2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            int height = view.getHeight() + this.a.i.getHeight() + this.b;
            RecyclerView recyclerView = this.a.g;
            AbstractC13042fc3.h(recyclerView, "galleryRecyclerView");
            recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), height);
            this.c.ra();
        }
    }

    /* renamed from: ir.nasim.zC2$a, reason: case insensitive filesystem and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C24784zC2 a(long j, ExPeerType exPeerType, String str, TC2 tc2, boolean z) {
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            AbstractC13042fc3.i(str, "galleryResultKey");
            AbstractC13042fc3.i(tc2, "galleryConfig");
            C24784zC2 c24784zC2 = new C24784zC2();
            c24784zC2.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("peerUniqueId", Long.valueOf(j)), AbstractC4616Fw7.a("exPeerTypeValue", exPeerType), AbstractC4616Fw7.a("galleryResultKey", str), AbstractC4616Fw7.a("galleryConfig", tc2), AbstractC4616Fw7.a("arg_is_comment", Boolean.valueOf(z))));
            return c24784zC2;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.zC2$b, reason: case insensitive filesystem */
    /* synthetic */ class C24786b extends EB2 implements SA2 {
        C24786b(Object obj) {
            super(0, obj, NC2.class, "dismissBottomSheet", "dismissBottomSheet()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((NC2) this.receiver).g1();
        }
    }

    /* renamed from: ir.nasim.zC2$c, reason: case insensitive filesystem */
    public static final class C24787c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.zC2$c$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.zC2$c$a$a, reason: collision with other inner class name */
            public static final class C1803a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1803a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C24784zC2.C24787c.a.C1803a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.zC2$c$a$a r0 = (ir.nasim.C24784zC2.C24787c.a.C1803a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.zC2$c$a$a r0 = new ir.nasim.zC2$c$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    boolean r2 = r5 instanceof ir.nasim.AbstractC22427vD2.c
                    if (r2 == 0) goto L43
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24784zC2.C24787c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public C24787c(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zC2$d, reason: case insensitive filesystem */
    public static final class C24788d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.zC2$d$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.zC2$d$a$a, reason: collision with other inner class name */
            public static final class C1804a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1804a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.C24784zC2.C24788d.a.C1804a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.zC2$d$a$a r0 = (ir.nasim.C24784zC2.C24788d.a.C1804a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.zC2$d$a$a r0 = new ir.nasim.zC2$d$a$a
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
                    ir.nasim.vD2$c r5 = (ir.nasim.AbstractC22427vD2.c) r5
                    ir.nasim.u83 r5 = r5.b()
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L45
                    return r1
                L45:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24784zC2.C24788d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public C24788d(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zC2$e */
    static final class e implements InterfaceC4806Gq2 {
        final /* synthetic */ C12889fL5 b;

        e(C12889fL5 c12889fL5) {
            this.b = c12889fL5;
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a(InterfaceC21791u83 interfaceC21791u83, InterfaceC20295rm1 interfaceC20295rm1) {
            if (AbstractC13042fc3.d(interfaceC21791u83, InterfaceC21791u83.b.a)) {
                KC2 kc2Z9 = C24784zC2.this.Z9();
                ConstraintLayout constraintLayout = kc2Z9.j;
                AbstractC13042fc3.h(constraintLayout, "inputBarLayout");
                constraintLayout.setVisibility(8);
                View view = kc2Z9.i;
                AbstractC13042fc3.h(view, "inputBarDividerView");
                view.setVisibility(8);
                C24784zC2.this.Sa();
                this.b.a = null;
            } else if (AbstractC13042fc3.d(interfaceC21791u83, InterfaceC21791u83.c.a)) {
                KC2 kc2Z92 = C24784zC2.this.Z9();
                ImageView imageView = kc2Z92.q;
                AbstractC13042fc3.h(imageView, "sendImageView");
                imageView.setVisibility(0);
                LinearLayout linearLayout = kc2Z92.e;
                AbstractC13042fc3.h(linearLayout, "editTextLayout");
                linearLayout.setVisibility(8);
                View view2 = kc2Z92.i;
                AbstractC13042fc3.h(view2, "inputBarDividerView");
                view2.setVisibility(8);
                ConstraintLayout constraintLayout2 = kc2Z92.j;
                AbstractC13042fc3.f(constraintLayout2);
                constraintLayout2.setVisibility(0);
                constraintLayout2.setClickable(false);
                constraintLayout2.setFocusable(false);
                constraintLayout2.setBackground(new ColorDrawable(0));
                C24784zC2.this.Sa();
                this.b.a = null;
            } else {
                if (!(interfaceC21791u83 instanceof InterfaceC21791u83.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                KC2 kc2Z93 = C24784zC2.this.Z9();
                ConstraintLayout constraintLayout3 = kc2Z93.j;
                AbstractC13042fc3.f(constraintLayout3);
                constraintLayout3.setVisibility(0);
                constraintLayout3.setClickable(true);
                constraintLayout3.setFocusable(true);
                constraintLayout3.setBackground(new ColorDrawable(AbstractC4043Dl1.c(constraintLayout3.getContext(), AbstractC24769zA5.color4)));
                View view3 = kc2Z93.i;
                AbstractC13042fc3.h(view3, "inputBarDividerView");
                view3.setVisibility(0);
                C17337mn6 c17337mn6A = ((InterfaceC21791u83.a) interfaceC21791u83).a();
                C24784zC2 c24784zC2 = C24784zC2.this;
                String strC = c17337mn6A != null ? c17337mn6A.c() : null;
                Integer numD = c17337mn6A != null ? AbstractC6392Nk0.d(c17337mn6A.d()) : null;
                c24784zC2.Ha(strC, !AbstractC13042fc3.d(numD, ((C17337mn6) this.b.a) != null ? AbstractC6392Nk0.d(r3.d()) : null));
                C24784zC2.this.Sa();
                this.b.a = c17337mn6A;
            }
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zC2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.zC2$f$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C24784zC2 a;

            a(C24784zC2 c24784zC2) {
                this.a = c24784zC2;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(AbstractC21163tD2 abstractC21163tD2, InterfaceC20295rm1 interfaceC20295rm1) {
                if (!(abstractC21163tD2 instanceof AbstractC21163tD2.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.a.Ba((AbstractC21163tD2.a) abstractC21163tD2);
                return C19938rB7.a;
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24784zC2.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6O1 = C24784zC2.this.fa().o1();
                a aVar = new a(C24784zC2.this);
                this.b = 1;
                if (interfaceC10040ay6O1.b(aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zC2$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C10173bC2 e;

        /* renamed from: ir.nasim.zC2$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC10258bL6 c;
            final /* synthetic */ C24784zC2 d;
            final /* synthetic */ C10173bC2 e;

            /* renamed from: ir.nasim.zC2$g$a$a, reason: collision with other inner class name */
            static final class C1805a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C24784zC2 d;
                final /* synthetic */ C10173bC2 e;
                final /* synthetic */ C12889fL5 f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1805a(C24784zC2 c24784zC2, C10173bC2 c10173bC2, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c24784zC2;
                    this.e = c10173bC2;
                    this.f = c12889fL5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1805a c1805a = new C1805a(this.d, this.e, this.f, interfaceC20295rm1);
                    c1805a.c = obj;
                    return c1805a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC22427vD2 abstractC22427vD2 = (AbstractC22427vD2) this.c;
                    if (abstractC22427vD2 instanceof AbstractC22427vD2.b) {
                        C24784zC2 c24784zC2 = this.d;
                        C10173bC2 c10173bC2 = this.e;
                        AbstractC22427vD2.b bVar = (AbstractC22427vD2.b) abstractC22427vD2;
                        Object obj2 = this.f.a;
                        c24784zC2.I9(c10173bC2, bVar, obj2 instanceof AbstractC22427vD2.b ? (AbstractC22427vD2.b) obj2 : null);
                    } else if (abstractC22427vD2 instanceof AbstractC22427vD2.c) {
                        C24784zC2 c24784zC22 = this.d;
                        C10173bC2 c10173bC22 = this.e;
                        AbstractC22427vD2.c cVar = (AbstractC22427vD2.c) abstractC22427vD2;
                        Object obj3 = this.f.a;
                        c24784zC22.J9(c10173bC22, cVar, obj3 instanceof AbstractC22427vD2.c ? (AbstractC22427vD2.c) obj3 : null);
                    } else {
                        if (!(abstractC22427vD2 instanceof AbstractC22427vD2.a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.d.qa();
                        this.d.v8();
                    }
                    this.f.a = abstractC22427vD2;
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AbstractC22427vD2 abstractC22427vD2, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1805a) create(abstractC22427vD2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC10258bL6 interfaceC10258bL6, C24784zC2 c24784zC2, C10173bC2 c10173bC2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC10258bL6;
                this.d = c24784zC2;
                this.e = c10173bC2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C12889fL5 c12889fL5 = new C12889fL5();
                    InterfaceC10258bL6 interfaceC10258bL6 = this.c;
                    C1805a c1805a = new C1805a(this.d, this.e, c12889fL5, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6, c1805a, this) == objE) {
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

        /* renamed from: ir.nasim.zC2$g$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C24784zC2 c;
            final /* synthetic */ InterfaceC10258bL6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C24784zC2 c24784zC2, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c24784zC2;
                this.d = interfaceC10258bL6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C24784zC2 c24784zC2 = this.c;
                    InterfaceC10258bL6 interfaceC10258bL6 = this.d;
                    this.b = 1;
                    if (c24784zC2.N9(interfaceC10258bL6, this) == objE) {
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C10173bC2 c10173bC2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c10173bC2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = C24784zC2.this.new g(this.e, interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2P1 = C24784zC2.this.fa().p1(new C16731lm1(C24784zC2.this.S7(), AbstractC13444gE5.Theme_Bale_Base));
                this.b = 1;
                obj = AbstractC6459Nq2.p0(interfaceC4557Fq2P1, interfaceC20315ro1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC10258bL6 interfaceC10258bL6 = (InterfaceC10258bL6) obj;
            C24784zC2 c24784zC2 = C24784zC2.this;
            j.b bVar = j.b.STARTED;
            AbstractC16751lo1.c(c24784zC2, bVar, new a(interfaceC10258bL6, c24784zC2, this.e, null));
            C24784zC2 c24784zC22 = C24784zC2.this;
            AbstractC16751lo1.c(c24784zC22, bVar, new b(c24784zC22, interfaceC10258bL6, null));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zC2$h */
    /* synthetic */ class h extends C23553x7 implements InterfaceC14603iB2 {
        h(Object obj) {
            super(2, obj, NC2.class, "selectItem", "selectItem(Lir/nasim/gallery/ui/model/GalleryUIItem;Z)Z", 8);
        }

        public final void a(C21837uD2 c21837uD2, boolean z) {
            AbstractC13042fc3.i(c21837uD2, "p0");
            ((NC2) this.a).v1(c21837uD2, z);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((C21837uD2) obj, ((Boolean) obj2).booleanValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zC2$i */
    /* synthetic */ class i extends EB2 implements UA2 {
        i(Object obj) {
            super(1, obj, C24784zC2.class, "openPhotoViewerStory", "openPhotoViewerStory(Lir/nasim/gallery/ui/model/GalleryUIItem;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((C21837uD2) obj);
            return C19938rB7.a;
        }

        public final void y(C21837uD2 c21837uD2) {
            AbstractC13042fc3.i(c21837uD2, "p0");
            ((C24784zC2) this.receiver).na(c21837uD2);
        }
    }

    /* renamed from: ir.nasim.zC2$j */
    /* synthetic */ class j extends EB2 implements UA2 {
        j(Object obj) {
            super(1, obj, C24784zC2.class, "openPhotoViewer", "openPhotoViewer(Lir/nasim/gallery/ui/model/GalleryUIItem;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((C21837uD2) obj);
            return C19938rB7.a;
        }

        public final void y(C21837uD2 c21837uD2) {
            AbstractC13042fc3.i(c21837uD2, "p0");
            ((C24784zC2) this.receiver).la(c21837uD2);
        }
    }

    /* renamed from: ir.nasim.zC2$k */
    /* synthetic */ class k extends EB2 implements UA2 {
        k(Object obj) {
            super(1, obj, NC2.class, "isItemSelected", "isItemSelected(I)Z", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return y(((Number) obj).intValue());
        }

        public final Boolean y(int i) {
            return Boolean.valueOf(((NC2) this.receiver).s1(i));
        }
    }

    /* renamed from: ir.nasim.zC2$l */
    /* synthetic */ class l extends EB2 implements SA2 {
        l(Object obj) {
            super(0, obj, NC2.class, "getSelectedItemsCount", "getSelectedItemsCount()I", 0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(((NC2) this.receiver).l1());
        }
    }

    /* renamed from: ir.nasim.zC2$m */
    public static final class m extends BottomSheetBehavior.f {
        m() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C24784zC2 c24784zC2) {
            AbstractC13042fc3.i(c24784zC2, "this$0");
            c24784zC2.fa().g1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 g(m mVar) {
            AbstractC13042fc3.i(mVar, "this$0");
            mVar.h();
            return C19938rB7.a;
        }

        private final void h() {
            com.google.android.material.bottomsheet.a aVar = C24784zC2.this.bottomSheetDialog;
            if (aVar == null) {
                AbstractC13042fc3.y("bottomSheetDialog");
                aVar = null;
            }
            BottomSheetBehavior bottomSheetBehaviorO = aVar.o();
            bottomSheetBehaviorO.x0(true);
            bottomSheetBehaviorO.J0(3);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, float f) {
            AbstractC13042fc3.i(view, "bottomSheet");
            if (f < 0.0f) {
                com.google.android.material.bottomsheet.a aVar = C24784zC2.this.bottomSheetDialog;
                if (aVar == null) {
                    AbstractC13042fc3.y("bottomSheetDialog");
                    aVar = null;
                }
                BottomSheetBehavior bottomSheetBehaviorO = aVar.o();
                bottomSheetBehaviorO.x0(false);
                bottomSheetBehaviorO.J0(4);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(View view, int i) {
            AbstractC13042fc3.i(view, "bottomSheet");
            if (i == 4) {
                final C24784zC2 c24784zC2 = C24784zC2.this;
                c24784zC2.Ca(new SA2() { // from class: ir.nasim.AC2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24784zC2.m.f(c24784zC2);
                    }
                }, new SA2() { // from class: ir.nasim.BC2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24784zC2.m.g(this.a);
                    }
                });
            }
        }
    }

    /* renamed from: ir.nasim.zC2$o */
    public static final class o extends com.google.android.material.bottomsheet.a {
        o(Context context, int i) {
            super(context, i);
            setCancelable(true);
            setCanceledOnTouchOutside(true);
            if (Build.VERSION.SDK_INT >= 33) {
                getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new OnBackInvokedCallback() { // from class: ir.nasim.EC2
                    public final void onBackInvoked() {
                        C24784zC2.o.y(c24784zC2);
                    }
                });
            }
            r(true);
            BottomSheetBehavior bottomSheetBehaviorO = o();
            bottomSheetBehaviorO.J0(3);
            bottomSheetBehaviorO.z0(false);
            bottomSheetBehaviorO.I0(true);
            bottomSheetBehaviorO.B0(Float.MIN_VALUE);
            setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.FC2
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    C24784zC2.o.z(this.a, dialogInterface);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final O98 A(C24784zC2 c24784zC2, View view, O98 o98) {
            AbstractC13042fc3.i(c24784zC2, "this$0");
            AbstractC13042fc3.i(view, "<unused var>");
            AbstractC13042fc3.i(o98, "insets");
            L93 l93F = o98.f(O98.m.h());
            AbstractC13042fc3.h(l93F, "getInsets(...)");
            L93 l93F2 = o98.f(O98.m.g());
            AbstractC13042fc3.h(l93F2, "getInsets(...)");
            L93 l93F3 = o98.f(O98.m.d());
            AbstractC13042fc3.h(l93F3, "getInsets(...)");
            ConstraintLayout root = c24784zC2.Z9().getRoot();
            AbstractC13042fc3.h(root, "getRoot(...)");
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = l93F.b;
            layoutParams2.bottomMargin = l93F2.d;
            root.setLayoutParams(layoutParams2);
            c24784zC2.fa().J1(l93F3.d - l93F2.d);
            return new O98.b(o98).e(O98.m.g(), false).e(O98.m.d(), false).e(O98.m.h(), false).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(C24784zC2 c24784zC2) {
            AbstractC13042fc3.i(c24784zC2, "this$0");
            SA2 sa2 = c24784zC2.onBackPressedAction;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(o oVar, DialogInterface dialogInterface) {
            AbstractC13042fc3.i(oVar, "this$0");
            View viewFindViewById = oVar.findViewById(WB5.design_bottom_sheet);
            if (viewFindViewById != null) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                layoutParams.height = -1;
                viewFindViewById.setLayoutParams(layoutParams);
            }
        }

        @Override // com.google.android.material.bottomsheet.a, android.app.Dialog, android.view.Window.Callback
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            Window window = getWindow();
            if (window == null) {
                return;
            }
            AbstractC19329q98.b(window, false);
            View viewFindViewById = findViewById(WB5.container);
            if (viewFindViewById != null) {
                viewFindViewById.setFitsSystemWindows(false);
            }
            View viewFindViewById2 = findViewById(WB5.coordinator);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setFitsSystemWindows(false);
            }
            View decorView = window.getDecorView();
            final C24784zC2 c24784zC2 = C24784zC2.this;
            AbstractC12990fW7.E0(decorView, new InterfaceC22474vI4() { // from class: ir.nasim.DC2
                @Override // ir.nasim.InterfaceC22474vI4
                public final O98 b(View view, O98 o98) {
                    return C24784zC2.o.A(c24784zC2, view, o98);
                }
            });
        }

        @Override // ir.nasim.V01, android.app.Dialog
        public void onBackPressed() {
            SA2 sa2 = C24784zC2.this.onBackPressedAction;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            Window window = getWindow();
            if (window != null) {
                AbstractC12990fW7.E0(window.getDecorView(), null);
            }
        }
    }

    /* renamed from: ir.nasim.zC2$p */
    /* synthetic */ class p extends EB2 implements SA2 {
        p(Object obj) {
            super(0, obj, C24784zC2.class, "sendItemsAsFile", "sendItemsAsFile()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C24784zC2) this.receiver).sa();
        }
    }

    /* renamed from: ir.nasim.zC2$q */
    /* synthetic */ class q extends EB2 implements SA2 {
        q(Object obj) {
            super(0, obj, C24784zC2.class, "sendItemsSeparately", "sendItemsSeparately()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C24784zC2) this.receiver).ta();
        }
    }

    /* renamed from: ir.nasim.zC2$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C21837uD2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(C21837uD2 c21837uD2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c21837uD2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24784zC2.this.new r(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C24784zC2.this.fa().v1(this.d, false);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zC2$t */
    static final class t implements InterfaceC15796kB2 {
        final /* synthetic */ AbstractC21163tD2.a b;

        /* renamed from: ir.nasim.zC2$t$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C24784zC2 a;
            final /* synthetic */ AbstractC21163tD2.a b;

            a(C24784zC2 c24784zC2, AbstractC21163tD2.a aVar) {
                this.a = c24784zC2;
                this.b = aVar;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String string = this.a.S7().getString(GD5.gallery_bottom_sheet_max_selection_size_dialog_description, XY6.v(String.valueOf(this.b.a())));
                AbstractC13042fc3.h(string, "getString(...)");
                AbstractC19555qZ.e0(string, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        t(AbstractC21163tD2.a aVar) {
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC14603iB2 interfaceC14603iB2C = Q51.a.c();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(876067152, true, new a(C24784zC2.this, this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(660657768);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.GC2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24784zC2.t.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC14603iB2C, cVar, interfaceC18060o11E, cVar2, null, c1454b, (SA2) objB, GD5.gallery_bottom_sheet_notice_dialog_button, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.C1454b.b << 15), 16);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zC2$u */
    static final class u implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ C9663aL5 b;
        final /* synthetic */ SA2 c;

        u(SA2 sa2, C9663aL5 c9663aL5, SA2 sa22) {
            this.a = sa2;
            this.b = c9663aL5;
            this.c = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog, C9663aL5 c9663aL5, SA2 sa2) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c9663aL5, "$isCanceled");
            AbstractC13042fc3.i(sa2, "$onCancelSelection");
            dialog.dismiss();
            c9663aL5.a = true;
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(Dialog dialog, SA2 sa2) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(sa2, "$onDismissAlertDialog");
            dialog.dismiss();
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(C9663aL5 c9663aL5, SA2 sa2, DialogInterface dialogInterface) {
            AbstractC13042fc3.i(c9663aL5, "$isCanceled");
            AbstractC13042fc3.i(sa2, "$onDismissAlertDialog");
            if (c9663aL5.a) {
                return;
            }
            sa2.invoke();
        }

        public final void d(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            Q51 q51 = Q51.a;
            InterfaceC14603iB2 interfaceC14603iB2A = q51.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = q51.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            final C9663aL5 c9663aL5 = this.b;
            final SA2 sa2 = this.c;
            SA2 sa22 = new SA2() { // from class: ir.nasim.HC2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24784zC2.u.f(dialog, c9663aL5, sa2);
                }
            };
            int i2 = GD5.gallery_bottom_sheet_cancellation_dialog_positive_button;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(37088891);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.V(this.a);
            final SA2 sa23 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.IC2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24784zC2.u.h(dialog, sa23);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa22, i2, c1454b, (SA2) objB, GD5.gallery_bottom_sheet_cancellation_dialog_negative_button, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            final C9663aL5 c9663aL52 = this.b;
            final SA2 sa24 = this.a;
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.JC2
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    C24784zC2.u.i(c9663aL52, sa24, dialogInterface);
                }
            });
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.zC2$v */
    public static final class v extends AbstractC8614Ws3 implements UA2 {
        public v() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return KC2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.zC2$w */
    public static final class w extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.zC2$x */
    public static final class x extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.zC2$y */
    public static final class y extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.zC2$z */
    public static final class z extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C24784zC2() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new x(new w(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(NC2.class), new y(interfaceC9173Yu3B), new z(null, interfaceC9173Yu3B), new A(this, interfaceC9173Yu3B));
        this.smilePanel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.yC2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24784zC2.Fa(this.a);
            }
        });
        this.photoViewerInputBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.dC2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24784zC2.pa(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(C24784zC2 c24784zC2, C5227Il0 c5227Il0) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        AbstractC13042fc3.i(c5227Il0, "$bucket");
        c24784zC2.fa().u1(c5227Il0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ba(AbstractC21163tD2.a event) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(1194718529, true, new t(event)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ca(SA2 onCancelSelection, SA2 onDismissAlertDialog) {
        C9663aL5 c9663aL5 = new C9663aL5();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(1934695878, true, new u(onDismissAlertDialog, c9663aL5, onCancelSelection)), 4, null).show();
    }

    static /* synthetic */ void Da(C24784zC2 c24784zC2, SA2 sa2, SA2 sa22, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            sa22 = new SA2() { // from class: ir.nasim.sC2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24784zC2.Ea();
                }
            };
        }
        c24784zC2.Ca(sa2, sa22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ea() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SmilesPanelView Fa(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        SmilesPanelView smilesPanelView = new SmilesPanelView((Fragment) c24784zC2, c24784zC2.fa().k1(), false, false, (InterfaceC10258bL6) null, c24784zC2.ha(), 20, (ED1) null);
        smilesPanelView.setSmilesKeyboardListener(c24784zC2.Y9());
        return smilesPanelView;
    }

    private final void Ga(int selectedItemsCount, Integer previousSelectedItemsCount) {
        com.google.android.material.bottomsheet.a aVar = null;
        if (selectedItemsCount <= 0) {
            if (previousSelectedItemsCount == null || previousSelectedItemsCount.intValue() <= 0) {
                return;
            }
            qa();
            com.google.android.material.bottomsheet.a aVar2 = this.bottomSheetDialog;
            if (aVar2 == null) {
                AbstractC13042fc3.y("bottomSheetDialog");
            } else {
                aVar = aVar2;
            }
            aVar.o().I0(true);
            return;
        }
        if (previousSelectedItemsCount == null || previousSelectedItemsCount.intValue() <= 0) {
            qa();
            BottomSheetBehavior.f fVarW9 = W9();
            this.behaviorCallback = fVarW9;
            com.google.android.material.bottomsheet.a aVar3 = this.bottomSheetDialog;
            if (aVar3 == null) {
                AbstractC13042fc3.y("bottomSheetDialog");
            } else {
                aVar = aVar3;
            }
            BottomSheetBehavior bottomSheetBehaviorO = aVar.o();
            bottomSheetBehaviorO.W(fVarW9);
            bottomSheetBehaviorO.I0(false);
        }
    }

    private final void H9() {
        KC2 kc2Z9 = Z9();
        ea().setId(View.generateViewId());
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.u = 0;
        layoutParams.s = 0;
        layoutParams.k = 0;
        kc2Z9.getRoot().addView(ea(), layoutParams);
        ConstraintLayout constraintLayout = kc2Z9.j;
        AbstractC13042fc3.h(constraintLayout, "inputBarLayout");
        ViewGroup.LayoutParams layoutParams2 = constraintLayout.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
        layoutParams3.k = -1;
        layoutParams3.j = ea().getId();
        constraintLayout.setLayoutParams(layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ha(String caption, boolean candidateItemChanged) {
        if (candidateItemChanged || this.updateInputBarTextForCurrentCandidateItem) {
            EditText editText = Z9().d;
            Editable text = editText.getText();
            if (AbstractC13042fc3.d(text != null ? text.toString() : null, caption)) {
                return;
            }
            editText.removeTextChangedListener(this.doOnTextChanged);
            editText.setText(caption);
            editText.setSelection(caption != null ? caption.length() : 0);
            editText.addTextChangedListener(this.doOnTextChanged);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(C10173bC2 galleryAdapter, AbstractC22427vD2.b loadingState, AbstractC22427vD2.b previousState) {
        KC2 kc2Z9 = Z9();
        if (AbstractC13042fc3.d(loadingState, previousState)) {
            return;
        }
        ConstraintLayout constraintLayout = kc2Z9.j;
        AbstractC13042fc3.h(constraintLayout, "inputBarLayout");
        constraintLayout.setVisibility(8);
        ImageView imageView = kc2Z9.b;
        AbstractC13042fc3.h(imageView, "arrowImageView");
        imageView.setVisibility(8);
        ImageView imageView2 = kc2Z9.m;
        AbstractC13042fc3.h(imageView2, "optionImageView");
        imageView2.setVisibility(8);
        Group group = kc2Z9.n;
        AbstractC13042fc3.h(group, "placeHolderGroup");
        group.setVisibility(8);
        RecyclerView recyclerView = kc2Z9.g;
        AbstractC13042fc3.h(recyclerView, "galleryRecyclerView");
        recyclerView.setVisibility(0);
        qa();
        this.onBackPressedAction = new C24786b(fa());
        kc2Z9.r.setOnClickListener(null);
        kc2Z9.g.setNestedScrollingEnabled(false);
        galleryAdapter.C(X9());
    }

    private final void Ia(InterfaceC11562dD2 keyboardState) throws Resources.NotFoundException {
        KC2 kc2Z9 = Z9();
        if (AbstractC13042fc3.d(keyboardState, InterfaceC11562dD2.a.a)) {
            ea().setVisibility(8);
            Ta(0);
            Ma(kc2Z9, new SA2() { // from class: ir.nasim.oC2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24784zC2.Ja(this.a);
                }
            });
        } else if (keyboardState instanceof InterfaceC11562dD2.b) {
            fa().E1(false);
            InterfaceC11562dD2.b bVar = (InterfaceC11562dD2.b) keyboardState;
            Ua(bVar.b());
            ea().setVisibility(0);
            Ta(bVar.b());
            Ma(kc2Z9, new SA2() { // from class: ir.nasim.pC2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24784zC2.Ka(this.a);
                }
            });
        } else {
            if (!(keyboardState instanceof InterfaceC11562dD2.c)) {
                throw new NoWhenBranchMatchedException();
            }
            float dimension = S7().getResources().getDimension(UA5.keyboard_height);
            Integer numB = ((InterfaceC11562dD2.c) keyboardState).b();
            int iIntValue = numB != null ? numB.intValue() : (int) dimension;
            Ua(iIntValue);
            ea().setVisibility(0);
            Ta(iIntValue);
            Ma(kc2Z9, new SA2() { // from class: ir.nasim.qC2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24784zC2.La(this.a);
                }
            });
            ea().B();
        }
        kc2Z9.l.setImageResource(keyboardState.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(C10173bC2 galleryAdapter, final AbstractC22427vD2.c selectionState, AbstractC22427vD2.c previousState) throws Resources.NotFoundException {
        C9929an6 c9929an6D;
        KC2 kc2Z9 = Z9();
        if (previousState == null) {
            kc2Z9.m.setImageResource(AbstractC16981mB5.bubble_action_more);
            if (!kc2Z9.g.isNestedScrollingEnabled()) {
                kc2Z9.g.setNestedScrollingEnabled(true);
            }
            ImageView imageView = kc2Z9.b;
            AbstractC13042fc3.h(imageView, "arrowImageView");
            imageView.setVisibility(0);
        }
        kc2Z9.r.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fC2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24784zC2.K9(this.a, selectionState, view);
            }
        });
        if (previousState == null || selectionState.e() != previousState.e()) {
            kc2Z9.m.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.gC2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C24784zC2.L9(this.a, selectionState, view);
                }
            });
        }
        if (!AbstractC13042fc3.d(selectionState.c(), previousState != null ? previousState.c() : null)) {
            Ia(selectionState.c());
        }
        if (previousState == null || selectionState.e() != previousState.e() || selectionState.f() != previousState.f()) {
            Va(selectionState.e(), selectionState.f());
            Ga(selectionState.e(), previousState != null ? Integer.valueOf(previousState.e()) : null);
        }
        Oa(selectionState, previousState);
        if (true ^ selectionState.d().a().isEmpty()) {
            RecyclerView recyclerView = kc2Z9.g;
            AbstractC13042fc3.h(recyclerView, "galleryRecyclerView");
            recyclerView.setVisibility(0);
            Group group = kc2Z9.n;
            AbstractC13042fc3.h(group, "placeHolderGroup");
            group.setVisibility(8);
        } else {
            Group group2 = kc2Z9.n;
            AbstractC13042fc3.h(group2, "placeHolderGroup");
            group2.setVisibility(0);
            RecyclerView recyclerView2 = kc2Z9.g;
            AbstractC13042fc3.h(recyclerView2, "galleryRecyclerView");
            recyclerView2.setVisibility(8);
        }
        if (previousState == null || (c9929an6D = previousState.d()) == null || selectionState.d().b() != c9929an6D.b()) {
            Z9().s.setText(selectionState.d().c());
            galleryAdapter.C(null);
        }
        galleryAdapter.C(selectionState.d().a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ja(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        c24784zC2.fa().E1(true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(C24784zC2 c24784zC2, AbstractC22427vD2.c cVar, View view) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        AbstractC13042fc3.i(cVar, "$selectionState");
        c24784zC2.za(cVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ka(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        c24784zC2.fa().E1(true);
        c24784zC2.M9();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(C24784zC2 c24784zC2, AbstractC22427vD2.c cVar, View view) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        AbstractC13042fc3.i(cVar, "$selectionState");
        c24784zC2.ja(cVar.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 La(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        c24784zC2.ka();
        return C19938rB7.a;
    }

    private final Object M9() {
        EditText editText = Z9().d;
        if (Build.VERSION.SDK_INT < 30) {
            AbstractC13042fc3.f(editText);
            return Boolean.valueOf(ca(editText).hideSoftInputFromWindow(editText.getWindowToken(), 0));
        }
        WindowInsetsController windowInsetsController = editText.getWindowInsetsController();
        if (windowInsetsController == null) {
            return null;
        }
        windowInsetsController.hide(WindowInsets.Type.ime());
        return C19938rB7.a;
    }

    private static final void Ma(KC2 kc2, final SA2 sa2) {
        kc2.l.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nC2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24784zC2.Na(sa2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object N9(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = AbstractC6459Nq2.v(new C24788d(new C24787c(interfaceC10258bL6))).b(new e(new C12889fL5()), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(SA2 sa2, View view) {
        AbstractC13042fc3.i(sa2, "$block");
        sa2.invoke();
    }

    private final InterfaceC13730gj3 O9() {
        return AbstractC16751lo1.c(this, j.b.STARTED, new f(null));
    }

    private final void Oa(AbstractC22427vD2.c selectionState, AbstractC22427vD2.c previousState) {
        if (selectionState.c() instanceof InterfaceC11562dD2.c) {
            if ((previousState != null ? previousState.c() : null) instanceof InterfaceC11562dD2.c) {
                return;
            }
            this.onBackPressedAction = new SA2() { // from class: ir.nasim.iC2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24784zC2.Pa(this.a);
                }
            };
        } else if (selectionState.e() <= 0) {
            this.onBackPressedAction = new B(fa());
        } else if (previousState == null || previousState.e() <= 0 || (previousState.c() instanceof InterfaceC11562dD2.c)) {
            this.onBackPressedAction = new SA2() { // from class: ir.nasim.jC2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24784zC2.Qa(this.a);
                }
            };
        }
    }

    private final InterfaceC13730gj3 P9(C10173bC2 galleryAdapter) {
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        return AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new g(galleryAdapter, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Pa(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        c24784zC2.fa().E1(false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TC2 Q9(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        if (Build.VERSION.SDK_INT >= 33) {
            Serializable serializable = c24784zC2.R7().getSerializable("galleryConfig", TC2.class);
            AbstractC13042fc3.f(serializable);
            return (TC2) serializable;
        }
        Serializable serializable2 = c24784zC2.R7().getSerializable("galleryConfig");
        AbstractC13042fc3.g(serializable2, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.holder.bubble.album.gallery.data.model.GalleryConfig");
        return (TC2) serializable2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Qa(final C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        Da(c24784zC2, new SA2() { // from class: ir.nasim.rC2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24784zC2.Ra(this.a);
            }
        }, null, 2, null);
        return C19938rB7.a;
    }

    private final C10173bC2 R9(boolean isMultiSelect) {
        return new C10173bC2(isMultiSelect, ba(), new h(fa()), aa() instanceof TC2.d ? new i(this) : new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ra(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        c24784zC2.fa().g1();
        return C19938rB7.a;
    }

    private final C16996mD2 S9(boolean allowCaption, final List uiItems, PhotoViewerInterface photoViewerInstance, SA2 onSendButtonClicked) {
        return new C16996mD2(allowCaption, uiItems, new l(fa()), new k(fa()), new InterfaceC14603iB2() { // from class: ir.nasim.kC2
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C24784zC2.T9(uiItems, this, ((Integer) obj).intValue(), (String) obj2);
            }
        }, new UA2() { // from class: ir.nasim.lC2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C24784zC2.U9(uiItems, this, ((Integer) obj).intValue()));
            }
        }, new InterfaceC16978mB2() { // from class: ir.nasim.mC2
            @Override // ir.nasim.InterfaceC16978mB2
            public final Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                return C24784zC2.V9(uiItems, this, ((Integer) obj).intValue(), (String) obj2, (ir.nasim.tgwidgets.editor.messenger.H) obj3, (MediaController.l) obj4);
            }
        }, onSendButtonClicked, photoViewerInstance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa() {
        KC2 kc2Z9 = Z9();
        ConstraintLayout constraintLayout = kc2Z9.j;
        AbstractC13042fc3.h(constraintLayout, "inputBarLayout");
        if (constraintLayout.getVisibility() != 0) {
            RecyclerView recyclerView = kc2Z9.g;
            AbstractC13042fc3.h(recyclerView, "galleryRecyclerView");
            recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), 0);
            return;
        }
        ConstraintLayout constraintLayout2 = kc2Z9.j;
        AbstractC13042fc3.h(constraintLayout2, "inputBarLayout");
        if (!constraintLayout2.isLaidOut() || constraintLayout2.isLayoutRequested()) {
            constraintLayout2.addOnLayoutChangeListener(new C(kc2Z9, this));
            return;
        }
        RecyclerView recyclerView2 = kc2Z9.g;
        AbstractC13042fc3.h(recyclerView2, "galleryRecyclerView");
        recyclerView2.setPadding(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), recyclerView2.getPaddingRight(), constraintLayout2.getHeight() + kc2Z9.i.getHeight());
        ra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T9(List list, C24784zC2 c24784zC2, int i2, String str) {
        AbstractC13042fc3.i(list, "$uiItems");
        AbstractC13042fc3.i(c24784zC2, "this$0");
        C21837uD2 c21837uD2 = (C21837uD2) AbstractC15401jX0.t0(list, i2);
        if (c21837uD2 != null) {
            c24784zC2.fa().A1(c21837uD2, str);
        }
        return C19938rB7.a;
    }

    private final void Ta(int keyboardHeight) {
        KC2 kc2Z9 = Z9();
        ConstraintLayout constraintLayout = kc2Z9.j;
        AbstractC13042fc3.h(constraintLayout, "inputBarLayout");
        if (!constraintLayout.isLaidOut() || constraintLayout.isLayoutRequested()) {
            constraintLayout.addOnLayoutChangeListener(new D(kc2Z9, keyboardHeight, this));
            return;
        }
        int height = constraintLayout.getHeight() + kc2Z9.i.getHeight() + keyboardHeight;
        RecyclerView recyclerView = kc2Z9.g;
        AbstractC13042fc3.h(recyclerView, "galleryRecyclerView");
        recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), height);
        ra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U9(List list, C24784zC2 c24784zC2, int i2) {
        AbstractC13042fc3.i(list, "$uiItems");
        AbstractC13042fc3.i(c24784zC2, "this$0");
        C21837uD2 c21837uD2 = (C21837uD2) AbstractC15401jX0.t0(list, i2);
        if (c21837uD2 != null) {
            return c24784zC2.fa().F1(c21837uD2);
        }
        return false;
    }

    private final void Ua(int newHeight) {
        SmilesPanelView smilesPanelViewEa = ea();
        if (smilesPanelViewEa.getHeight() == newHeight || newHeight <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = smilesPanelViewEa.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = newHeight;
        smilesPanelViewEa.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V9(List list, C24784zC2 c24784zC2, int i2, String str, ir.nasim.tgwidgets.editor.messenger.H h2, MediaController.l lVar) {
        AbstractC13042fc3.i(list, "$uiItems");
        AbstractC13042fc3.i(c24784zC2, "this$0");
        AbstractC13042fc3.i(str, "path");
        C21837uD2 c21837uD2 = (C21837uD2) AbstractC15401jX0.t0(list, i2);
        if (c21837uD2 != null) {
            c24784zC2.fa().D1(c21837uD2, str, h2, lVar);
        }
        return C19938rB7.a;
    }

    private final void Va(int count, boolean showSendOptions) {
        KC2 kc2Z9 = Z9();
        kc2Z9.c.setCount(count, true);
        ImageView imageView = kc2Z9.m;
        AbstractC13042fc3.h(imageView, "optionImageView");
        imageView.setVisibility(showSendOptions && count > 0 ? 0 : 8);
    }

    private final BottomSheetBehavior.f W9() {
        return new m();
    }

    private final List X9() {
        RecyclerView.p layoutManager = Z9().g.getLayoutManager();
        AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        int iCeil = ((int) Math.ceil(((r0.getResources().getDisplayMetrics().heightPixels - r0.getY()) - (r0.getPaddingTop() + r0.getPaddingBottom())) / (((r0.getResources().getDisplayMetrics().widthPixels - (r0.getPaddingStart() + r0.getPaddingEnd())) * 1.0f) / r1))) * ((GridLayoutManager) layoutManager).c3();
        ArrayList arrayList = new ArrayList(iCeil);
        for (int i2 = 0; i2 < iCeil; i2++) {
            arrayList.add(null);
        }
        return arrayList;
    }

    private final CF6 Y9() {
        return new n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KC2 Z9() {
        return (KC2) this.binding.a(this, G1[0]);
    }

    private final TC2 aa() {
        return (TC2) this.config.getValue();
    }

    private final VI2 ba() {
        return (VI2) this.glideRequests.getValue();
    }

    private final InputMethodManager ca(View view) {
        Object systemService = view.getContext().getSystemService("input_method");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager) systemService;
    }

    private final C14864ic5 da() {
        return (C14864ic5) this.photoViewerInputBar.getValue();
    }

    private final SmilesPanelView ea() {
        return (SmilesPanelView) this.smilePanel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NC2 fa() {
        return (NC2) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VI2 ga(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        return OI2.d(c24784zC2);
    }

    private final boolean ha() {
        return ((Boolean) this.isComment.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ia(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        Bundle bundleE5 = c24784zC2.E5();
        if (bundleE5 != null) {
            return bundleE5.getBoolean("arg_is_comment", false);
        }
        return false;
    }

    private final void ja(int selectedItemsCount) {
        KC2 kc2Z9 = Z9();
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        AbstractC8081Ul1.b.k(bVar, GD5.gallery_bottom_sheet_context_menu_send_as_file, AbstractC16981mB5.gallery_bottom_sheet_context_menu_send_as_file, null, new p(this), 4, null);
        if (selectedItemsCount > 1) {
            AbstractC8081Ul1.b.k(bVar, GD5.gallery_bottom_sheet_context_menu_send_ungrouped, AbstractC16981mB5.gallery_bottom_sheet_context_menu_send_ungrouped, null, new q(this), 4, null);
        }
        ImageView imageView = kc2Z9.m;
        AbstractC13042fc3.h(imageView, "optionImageView");
        ConstraintLayout root = kc2Z9.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        AbstractC5462Jl1.f(new GY.a(imageView, root, null, 4, null).d(true).b(bVar), 0, 1, null);
    }

    private final boolean ka() {
        EditText editText = Z9().d;
        editText.requestFocus();
        AbstractC13042fc3.f(editText);
        return ca(editText).showSoftInput(editText, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void la(ir.nasim.C21837uD2 r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 1
            r0.updateInputBarTextForCurrentCandidateItem = r1
            boolean r2 = ir.nasim.C8386Vt0.d9()
            ir.nasim.features.media.components.PhotoViewerInterface r3 = ir.nasim.features.media.components.PhotoViewerAbs.getInstance(r2)
            ir.nasim.TC2 r2 = r17.aa()
            boolean r2 = r2.x()
            ir.nasim.bC2 r4 = r0.galleryAdapter
            r5 = 0
            if (r4 == 0) goto L27
            java.util.List r4 = r4.z()
            if (r4 == 0) goto L27
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.List r4 = ir.nasim.ZW0.n0(r4)
            goto L28
        L27:
            r4 = r5
        L28:
            if (r4 != 0) goto L2e
            java.util.List r4 = ir.nasim.ZW0.m()
        L2e:
            ir.nasim.AbstractC13042fc3.f(r3)
            ir.nasim.tC2 r6 = new ir.nasim.tC2
            r6.<init>()
            ir.nasim.mD2 r9 = r0.S9(r2, r4, r3, r6)
            r2 = r18
            ir.nasim.XV4 r2 = r9.a(r2)
            java.lang.Object r4 = r2.a()
            java.lang.Number r4 = (java.lang.Number) r4
            int r6 = r4.intValue()
            java.lang.Object r2 = r2.b()
            r4 = r2
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            ir.nasim.TC2 r2 = r17.aa()
            boolean r2 = r2.t()
            r2 = r2 ^ r1
            boolean r7 = r3 instanceof ir.nasim.C20171rb5
            if (r7 == 0) goto L62
            r7 = r3
            ir.nasim.rb5 r7 = (ir.nasim.C20171rb5) r7
            goto L63
        L62:
            r7 = r5
        L63:
            if (r7 == 0) goto L6f
            ir.nasim.TC2 r8 = r17.aa()
            boolean r8 = r8.v()
            r7.c = r8
        L6f:
            ir.nasim.ic5 r7 = r17.da()
            r3.setInputBar(r7)
            androidx.fragment.app.FragmentActivity r7 = r17.A5()
            r3.setParentActivity(r7)
            boolean r7 = r3 instanceof ir.nasim.features.media.components.PhotoViewerBridge
            if (r7 == 0) goto L84
            r5 = r3
            ir.nasim.features.media.components.PhotoViewerBridge r5 = (ir.nasim.features.media.components.PhotoViewerBridge) r5
        L84:
            if (r5 == 0) goto L9b
            ir.nasim.TC2 r5 = r17.aa()
            boolean r5 = r5 instanceof ir.nasim.TC2.a
            if (r5 == 0) goto L8f
            goto L9c
        L8f:
            ir.nasim.TC2 r1 = r17.aa()
            boolean r1 = r1.t()
            if (r1 != 0) goto L9b
            r1 = 2
            goto L9c
        L9b:
            r1 = r2
        L9c:
            ir.nasim.SC2 r2 = new ir.nasim.SC2
            ir.nasim.NC2 r5 = r17.fa()
            ir.nasim.d25 r11 = r5.k1()
            r15 = 14
            r16 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)
            java.lang.String r5 = "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>"
            ir.nasim.AbstractC13042fc3.g(r4, r5)
            r10 = 0
            r11 = 0
            r7 = 1
            r8 = 0
            r5 = r6
            r6 = r1
            r12 = r2
            r3.openPhotoForSelect(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24784zC2.la(ir.nasim.uD2):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ma(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        c24784zC2.Z9().q.performClick();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na(C21837uD2 item) {
        TC2 tc2Aa = aa();
        AbstractC13042fc3.g(tc2Aa, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.adapter.holder.bubble.album.gallery.data.model.GalleryConfig.StorySelect");
        TC2.d dVar = (TC2.d) tc2Aa;
        if (C8386Vt0.nb() || ((!C8386Vt0.jb() && item.b() == null) || !(item.b() == null || C8386Vt0.xb()))) {
            fa().v1(item, true);
            fa().x1();
            AbstractC10533bm0.d(AbstractC16751lo1.a(this), C12366eV1.b(), null, new r(item, null), 2, null);
            return;
        }
        this.updateInputBarTextForCurrentCandidateItem = true;
        PhotoViewerInterface photoViewerAbs = PhotoViewerAbs.getInstance(true);
        boolean zX = dVar.x();
        ArrayList arrayListG = AbstractC10360bX0.g(item);
        AbstractC13042fc3.f(photoViewerAbs);
        C16996mD2 c16996mD2S9 = S9(zX, arrayListG, photoViewerAbs, new SA2() { // from class: ir.nasim.uC2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C24784zC2.oa(this.a);
            }
        });
        XV4 xv4A = c16996mD2S9.a(item);
        int iIntValue = ((Number) xv4A.a()).intValue();
        ArrayList<Object> arrayList = (ArrayList) xv4A.b();
        int i2 = dVar.t() ? 0 : 99;
        PhotoViewerBridge photoViewerBridge = photoViewerAbs instanceof PhotoViewerBridge ? (PhotoViewerBridge) photoViewerAbs : null;
        if (photoViewerBridge != null) {
            FragmentActivity fragmentActivityQ7 = Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            photoViewerBridge.setParentActivity(fragmentActivityQ7);
            AbstractC13042fc3.g(arrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any>");
            photoViewerBridge.openPhotoForSelect(arrayList, iIntValue, i2, true, c16996mD2S9, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        c24784zC2.Z9().q.performClick();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14864ic5 pa(C24784zC2 c24784zC2) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        C11458d25 c11458d25K1 = c24784zC2.fa().k1();
        Context contextS7 = c24784zC2.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = c24784zC2.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        C14864ic5 c14864ic5 = new C14864ic5(c11458d25K1, contextS7, AbstractC19224pz3.a(interfaceC18633oz3P6), new C14864ic5.b(c24784zC2.Z9().d.getHint(), 4), null, null, 48, null);
        c14864ic5.k0();
        return c14864ic5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa() {
        BottomSheetBehavior.f fVar = this.behaviorCallback;
        if (fVar != null) {
            com.google.android.material.bottomsheet.a aVar = this.bottomSheetDialog;
            if (aVar == null) {
                AbstractC13042fc3.y("bottomSheetDialog");
                aVar = null;
            }
            aVar.o().r0(fVar);
            this.behaviorCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra() {
        RecyclerView recyclerView = Z9().g;
        RecyclerView.h adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount() - 1;
            RecyclerView.p layoutManager = recyclerView.getLayoutManager();
            GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
            if (gridLayoutManager != null && gridLayoutManager.e2() + gridLayoutManager.c3() >= itemCount) {
                recyclerView.smoothScrollToPosition(itemCount);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa() {
        fa().y1();
        fa().g1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta() {
        fa().z1();
        fa().g1();
    }

    private final void ua() {
        KC2 kc2Z9 = Z9();
        kc2Z9.d.setTypeface(C6011Lu2.k());
        kc2Z9.s.setTypeface(C6011Lu2.i());
        kc2Z9.p.setTypeface(C6011Lu2.i());
    }

    private final void va() {
        KC2 kc2Z9 = Z9();
        EditText editText = kc2Z9.d;
        AbstractC13042fc3.h(editText, "captionEditText");
        s sVar = new s();
        editText.addTextChangedListener(sVar);
        this.doOnTextChanged = sVar;
        kc2Z9.q.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.eC2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C24784zC2.wa(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(C24784zC2 c24784zC2, View view) {
        AbstractC13042fc3.i(c24784zC2, "this$0");
        c24784zC2.fa().x1();
        c24784zC2.fa().g1();
    }

    private final void xa() {
        CounterBadge counterBadge = Z9().c;
        counterBadge.setupStroke(AbstractC4043Dl1.c(counterBadge.getContext(), AbstractC24769zA5.color4), AbstractC8943Xx1.c(1));
    }

    private final void ya(C10173bC2 galleryAdapter) {
        RecyclerView recyclerView = Z9().g;
        recyclerView.addItemDecoration(new C20874sl(I1));
        recyclerView.setAdapter(galleryAdapter);
        recyclerView.setItemAnimator(null);
    }

    private final void za(List buckets) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        Drawable drawableD = AbstractC6713Oq7.d(contextS7, AbstractC16981mB5.gallery_bottom_sheet_place_holder_icon, AbstractC4043Dl1.c(S7(), AbstractC24769zA5.color6_3));
        AbstractC8081Ul1.a aVar = new AbstractC8081Ul1.a();
        Iterator it = buckets.iterator();
        while (it.hasNext()) {
            final C5227Il0 c5227Il0 = (C5227Il0) it.next();
            aVar.c(c5227Il0.e(), c5227Il0.c(), drawableD, c5227Il0.b(), new SA2() { // from class: ir.nasim.hC2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C24784zC2.Aa(this.a, c5227Il0);
                }
            });
        }
        LinearLayout linearLayout = Z9().r;
        AbstractC13042fc3.h(linearLayout, "titleContainer");
        ConstraintLayout root = Z9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        AbstractC5462Jl1.f(new GY.a(linearLayout, root, null, 4, null).g(new RS4(16.0f, 12.0f, 16.0f, 12.0f)).d(true).b(aVar), 0, 1, null);
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        o oVar = new o(S7(), AbstractC13444gE5.Theme_GalleryBottomSheet);
        this.bottomSheetDialog = oVar;
        return oVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        View viewInflate = inflater.inflate(FC5.gallery_bottom_sheet, container, false);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void T6() {
        KC2 kc2Z9 = Z9();
        da().E0();
        super.T6();
        this.galleryAdapter = null;
        kc2Z9.g.setAdapter(null);
        ea().setSmilesKeyboardListener(null);
        AbstractC6713Oq7.c();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        ua();
        va();
        H9();
        xa();
        C10173bC2 c10173bC2R9 = R9(aa().t());
        this.galleryAdapter = c10173bC2R9;
        ya(c10173bC2R9);
        P9(c10173bC2R9);
        O9();
    }

    @Override // com.google.android.material.bottomsheet.b, androidx.fragment.app.l
    public void u8() {
        fa().g1();
        super.u8();
    }

    @Override // androidx.fragment.app.l
    public void x8() {
        fa().g1();
        super.x8();
    }

    /* renamed from: ir.nasim.zC2$n */
    public static final class n implements CF6 {
        n() {
        }

        private final CharSequence h(String str, Paint paint) {
            return R62.W(str, paint.getFontMetricsInt(), AbstractC7426Rr.a.f(20.0f), false, null, null, 48, null);
        }

        @Override // ir.nasim.CF6
        public boolean a() {
            EditText editText = C24784zC2.this.Z9().d;
            Editable text = editText.getText();
            if (text == null || text.length() == 0) {
                return true;
            }
            editText.dispatchKeyEvent(new KeyEvent(0, 67));
            return true;
        }

        @Override // ir.nasim.CF6
        public void b(C23698xM6 c23698xM6, long j) {
            AbstractC13042fc3.i(c23698xM6, "sticker");
            throw new IllegalStateException();
        }

        @Override // ir.nasim.CF6
        public void f(String str) {
            AbstractC13042fc3.i(str, "emoji");
            EditText editText = C24784zC2.this.Z9().d;
            TextPaint paint = editText.getPaint();
            AbstractC13042fc3.h(paint, "getPaint(...)");
            CharSequence charSequenceH = h(str, paint);
            if (charSequenceH == null) {
                return;
            }
            int iMax = Math.max(editText.getSelectionEnd(), 0);
            Editable text = editText.getText();
            if (text != null) {
                text.insert(iMax, charSequenceH);
            }
            editText.setSelection(iMax + charSequenceH.length());
        }

        @Override // ir.nasim.CF6
        public void g(QG2 qg2) {
            AbstractC13042fc3.i(qg2, "gif");
        }

        @Override // ir.nasim.CF6
        public void c() {
        }

        @Override // ir.nasim.CF6
        public void d() {
        }

        @Override // ir.nasim.CF6
        public void e() {
        }
    }

    /* renamed from: ir.nasim.zC2$s */
    public static final class s implements TextWatcher {
        public s() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C24784zC2.this.fa().I1(charSequence != null ? charSequence.toString() : null);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
