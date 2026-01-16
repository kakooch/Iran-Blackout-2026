package ir.nasim.features.payment.view.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.C15677jz2;
import ir.nasim.C19406qI3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C8563Wm6;
import ir.nasim.ED1;
import ir.nasim.WB5;
import ir.nasim.features.payment.data.model.SelectableOption;
import ir.nasim.features.payment.view.fragment.SelectableOptionsFragment;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

/* loaded from: classes6.dex */
public final class SelectableOptionsFragment extends com.google.android.material.bottomsheet.b {
    public static final a r1 = new a(null);
    public static final int s1 = 8;
    private static boolean t1;
    private Creator n1;
    private C15677jz2 o1;
    private C8563Wm6 p1;
    private C8563Wm6.a q1;

    public static final class a {
        private a() {
        }

        public final boolean a() {
            return SelectableOptionsFragment.t1;
        }

        public final SelectableOptionsFragment b(Creator creator) {
            AbstractC13042fc3.i(creator, "creator");
            SelectableOptionsFragment selectableOptionsFragment = new SelectableOptionsFragment(null);
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg_creator", creator);
            selectableOptionsFragment.a8(bundle);
            return selectableOptionsFragment;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ SelectableOptionsFragment(ED1 ed1) {
        this();
    }

    private final void S8() {
        ArrayList arrayListZ = this.p1.z();
        Creator creator = this.n1;
        if (creator == null) {
            AbstractC13042fc3.y("creator");
            creator = null;
        }
        arrayListZ.addAll(creator.getOptions());
        this.p1.C(this.q1);
    }

    private final void T8() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        C15677jz2 c15677jz2 = this.o1;
        if (c15677jz2 != null && (recyclerView2 = c15677jz2.c) != null) {
            recyclerView2.setAdapter(this.p1);
        }
        C15677jz2 c15677jz22 = this.o1;
        if (c15677jz22 == null || (recyclerView = c15677jz22.c) == null) {
            return;
        }
        recyclerView.setNestedScrollingEnabled(true);
    }

    private final void U8() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        C15677jz2 c15677jz2 = this.o1;
        if (c15677jz2 != null && (textView3 = c15677jz2.d) != null) {
            Creator creator = this.n1;
            if (creator == null) {
                AbstractC13042fc3.y("creator");
                creator = null;
            }
            textView3.setText(creator.getTitle());
        }
        C15677jz2 c15677jz22 = this.o1;
        if (c15677jz22 != null && (textView2 = c15677jz22.d) != null) {
            textView2.setTypeface(C6011Lu2.k());
        }
        C15677jz2 c15677jz23 = this.o1;
        if (c15677jz23 != null && (textView = c15677jz23.d) != null) {
            textView.setTextColor(C5495Jo7.a.o0());
        }
        T8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V8(SelectableOptionsFragment selectableOptionsFragment, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(selectableOptionsFragment, "this$0");
        try {
            Creator creator = selectableOptionsFragment.n1;
            if (creator == null) {
                AbstractC13042fc3.y("creator");
                creator = null;
            }
            if (creator.getFullExpandOpen()) {
                AbstractC13042fc3.g(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
                FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(WB5.design_bottom_sheet);
                AbstractC13042fc3.g(frameLayout, "null cannot be cast to non-null type android.view.View");
                BottomSheetBehavior.f0(frameLayout).J0(3);
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    @Override // androidx.fragment.app.l
    public int A8() {
        return AbstractC23035wE5.CrowdfundingBottomSheetTheme;
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle bundle) {
        Dialog dialogB8 = super.B8(bundle);
        AbstractC13042fc3.g(dialogB8, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogB8;
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.Zm6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SelectableOptionsFragment.V8(this.a, dialogInterface);
            }
        });
        return aVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            if (bundleE5.containsKey("arg_creator")) {
                Parcelable parcelable = bundleE5.getParcelable("arg_creator");
                AbstractC13042fc3.f(parcelable);
                this.n1 = (Creator) parcelable;
            } else {
                AbstractC16494lN1.a(this);
            }
        }
        t1 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        S8();
        C15677jz2 c15677jz2C = C15677jz2.c(layoutInflater, viewGroup, false);
        this.o1 = c15677jz2C;
        if (c15677jz2C != null) {
            return c15677jz2C.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this.o1 = null;
    }

    public final void W8(C8563Wm6.a aVar) {
        this.q1 = aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        U8();
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        AbstractC13042fc3.i(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        t1 = false;
    }

    private SelectableOptionsFragment() {
        this.p1 = new C8563Wm6();
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000eH×\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H×\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R'\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\"\u001a\u0004\b\u001c\u0010#¨\u0006$"}, d2 = {"Lir/nasim/features/payment/view/fragment/SelectableOptionsFragment$Creator;", "Landroid/os/Parcelable;", "", "title", "Ljava/util/ArrayList;", "Lir/nasim/features/payment/data/model/SelectableOption;", "Lkotlin/collections/ArrayList;", "options", "", "fullExpandOpen", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Z)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "Z", "()Z", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Creator implements Parcelable {
        public static final Parcelable.Creator<Creator> CREATOR = new a();

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final String title;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final ArrayList options;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        private final boolean fullExpandOpen;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Creator createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                String string = parcel.readString();
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(SelectableOption.CREATOR.createFromParcel(parcel));
                }
                return new Creator(string, arrayList, parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Creator[] newArray(int i) {
                return new Creator[i];
            }
        }

        public Creator(String str, ArrayList arrayList, boolean z) {
            AbstractC13042fc3.i(str, "title");
            AbstractC13042fc3.i(arrayList, "options");
            this.title = str;
            this.options = arrayList;
            this.fullExpandOpen = z;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getFullExpandOpen() {
            return this.fullExpandOpen;
        }

        /* renamed from: b, reason: from getter */
        public final ArrayList getOptions() {
            return this.options;
        }

        /* renamed from: c, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Creator)) {
                return false;
            }
            Creator creator = (Creator) other;
            return AbstractC13042fc3.d(this.title, creator.title) && AbstractC13042fc3.d(this.options, creator.options) && this.fullExpandOpen == creator.fullExpandOpen;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.options.hashCode()) * 31) + Boolean.hashCode(this.fullExpandOpen);
        }

        public String toString() {
            return "Creator(title=" + this.title + ", options=" + this.options + ", fullExpandOpen=" + this.fullExpandOpen + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeString(this.title);
            ArrayList arrayList = this.options;
            dest.writeInt(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((SelectableOption) it.next()).writeToParcel(dest, flags);
            }
            dest.writeInt(this.fullExpandOpen ? 1 : 0);
        }

        public /* synthetic */ Creator(String str, ArrayList arrayList, boolean z, int i, ED1 ed1) {
            this(str, arrayList, (i & 4) != 0 ? false : z);
        }
    }
}
