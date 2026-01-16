package androidx.navigation;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.j;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 +2\u00020\u0001:\u0001\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ/\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010 \u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\"\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001e\u0010!\u001a\u0004\b\u001c\u0010\u0015R\u0019\u0010'\u001a\u0004\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010*\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010&¨\u0006,"}, d2 = {"Landroidx/navigation/NavBackStackEntryState;", "Landroid/os/Parcelable;", "Landroidx/navigation/d;", "entry", "<init>", "(Landroidx/navigation/d;)V", "Landroid/os/Parcel;", "inParcel", "(Landroid/os/Parcel;)V", "Landroid/content/Context;", "context", "Landroidx/navigation/i;", "destination", "Landroidx/lifecycle/j$b;", "hostLifecycleState", "Landroidx/navigation/f;", "viewModel", "c", "(Landroid/content/Context;Landroidx/navigation/i;Landroidx/lifecycle/j$b;Landroidx/navigation/f;)Landroidx/navigation/d;", "", "describeContents", "()I", "parcel", "i", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "id", TokenNames.I, "destinationId", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "args", "d", "getSavedState", "savedState", "e", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class NavBackStackEntryState implements Parcelable {

    /* renamed from: a, reason: from kotlin metadata */
    private final String id;

    /* renamed from: b, reason: from kotlin metadata */
    private final int destinationId;

    /* renamed from: c, reason: from kotlin metadata */
    private final Bundle args;

    /* renamed from: d, reason: from kotlin metadata */
    private final Bundle savedState;
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new a();

    public static final class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "inParcel");
            return new NavBackStackEntryState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavBackStackEntryState[] newArray(int i) {
            return new NavBackStackEntryState[i];
        }
    }

    public NavBackStackEntryState(d dVar) {
        AbstractC13042fc3.i(dVar, "entry");
        this.id = dVar.f();
        this.destinationId = dVar.e().A();
        this.args = dVar.c();
        Bundle bundle = new Bundle();
        this.savedState = bundle;
        dVar.i(bundle);
    }

    /* renamed from: a, reason: from getter */
    public final int getDestinationId() {
        return this.destinationId;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final d c(Context context, i destination, j.b hostLifecycleState, f viewModel) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(destination, "destination");
        AbstractC13042fc3.i(hostLifecycleState, "hostLifecycleState");
        Bundle bundle = this.args;
        if (bundle != null) {
            bundle.setClassLoader(context.getClassLoader());
        } else {
            bundle = null;
        }
        return d.o.a(context, destination, bundle, hostLifecycleState, viewModel, this.id, this.savedState);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        AbstractC13042fc3.i(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.destinationId);
        parcel.writeBundle(this.args);
        parcel.writeBundle(this.savedState);
    }

    public NavBackStackEntryState(Parcel parcel) {
        AbstractC13042fc3.i(parcel, "inParcel");
        String string = parcel.readString();
        AbstractC13042fc3.f(string);
        this.id = string;
        this.destinationId = parcel.readInt();
        this.args = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        Bundle bundle = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        AbstractC13042fc3.f(bundle);
        this.savedState = bundle;
    }
}
