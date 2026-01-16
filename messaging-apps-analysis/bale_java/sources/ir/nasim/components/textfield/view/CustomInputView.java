package ir.nasim.components.textfield.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.AbstractC11632dL0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14828iY7;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC24379yW7;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.C11637dL5;
import ir.nasim.C12765f98;
import ir.nasim.C15783k98;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20644sM5;
import ir.nasim.C23381wp3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.D20;
import ir.nasim.ED1;
import ir.nasim.EnumC11622dK;
import ir.nasim.EnumC12265eK;
import ir.nasim.F20;
import ir.nasim.InterfaceC12049dx1;
import ir.nasim.ME5;
import ir.nasim.SA2;
import ir.nasim.TC5;
import ir.nasim.UD5;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bP\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 þ\u00012\u00020\u00012\u00020\u0002:\u0001nB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u0013*\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\tJ\u000f\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\u00020\n*\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001e\u0010\u0018J\u001f\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014¢\u0006\u0004\b&\u0010%J\u0011\u0010'\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b*\u0010+J\r\u0010-\u001a\u00020,¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\nH\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00132\u0006\u00102\u001a\u00020\nH\u0016¢\u0006\u0004\b3\u00101J\u0017\u00105\u001a\u00020\u00132\u0006\u00104\u001a\u00020\nH\u0016¢\u0006\u0004\b5\u00101J\u0017\u00107\u001a\u00020\u00132\u0006\u00106\u001a\u00020\nH\u0016¢\u0006\u0004\b7\u00101J\u0017\u0010:\u001a\u00020\u00132\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010:\u001a\u00020\u00132\u0006\u00109\u001a\u00020\nH\u0016¢\u0006\u0004\b:\u00101J\u0019\u0010=\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\nH\u0016¢\u0006\u0004\b@\u00101J\u0019\u0010B\u001a\u00020\u00132\b\u0010A\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\bB\u0010>J\u0017\u0010C\u001a\u00020\u00132\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\bC\u0010;J\u0017\u0010C\u001a\u00020\u00132\u0006\u00109\u001a\u00020\nH\u0016¢\u0006\u0004\bC\u00101J\u0017\u0010E\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u001fH\u0016¢\u0006\u0004\bE\u0010FJ\u0019\u0010G\u001a\u00020\u00132\b\u0010A\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\bG\u0010>J\u0019\u0010I\u001a\u00020\u00132\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\bI\u0010>J\u0017\u0010J\u001a\u00020\u00132\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\bJ\u0010;J\u0017\u0010K\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u001fH\u0016¢\u0006\u0004\bK\u0010FJ\u0017\u0010L\u001a\u00020\u00132\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\bL\u0010;J\u0019\u0010O\u001a\u00020\u00132\b\u0010N\u001a\u0004\u0018\u00010MH\u0016¢\u0006\u0004\bO\u0010PJ\u0019\u0010Q\u001a\u00020\u00132\b\u00109\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0004\bQ\u0010;J\u0019\u0010R\u001a\u00020\u00132\b\u0010N\u001a\u0004\u0018\u00010MH\u0016¢\u0006\u0004\bR\u0010PJ\u0017\u0010S\u001a\u00020\u00132\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\bS\u0010;J\u0019\u0010T\u001a\u00020\u00132\b\u0010N\u001a\u0004\u0018\u00010MH\u0016¢\u0006\u0004\bT\u0010PJ\u0017\u0010U\u001a\u00020\u00132\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\bU\u0010;J\u0017\u0010W\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\nH\u0016¢\u0006\u0004\bW\u00101J\u0017\u0010Y\u001a\u00020\u00132\u0006\u0010X\u001a\u00020,H\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u00132\u0006\u0010_\u001a\u00020,H\u0016¢\u0006\u0004\b`\u0010ZJ\u0017\u0010b\u001a\u00020\u00132\u0006\u0010a\u001a\u00020\nH\u0016¢\u0006\u0004\bb\u00101J\u0017\u0010d\u001a\u00020\u00132\u0006\u0010c\u001a\u00020\nH\u0016¢\u0006\u0004\bd\u00101J\u0017\u0010e\u001a\u00020\u00132\u0006\u0010c\u001a\u00020\nH\u0016¢\u0006\u0004\be\u00101J\u0017\u0010h\u001a\u00020\u00132\u0006\u0010g\u001a\u00020fH\u0016¢\u0006\u0004\bh\u0010iJ\u0017\u0010l\u001a\u00020\u00132\u0006\u0010k\u001a\u00020jH\u0016¢\u0006\u0004\bl\u0010mJ\u0017\u0010n\u001a\u00020\u00132\u0006\u0010g\u001a\u00020fH\u0016¢\u0006\u0004\bn\u0010iJ\u000f\u0010p\u001a\u00020oH\u0016¢\u0006\u0004\bp\u0010qJ\u000f\u0010r\u001a\u00020\u0019H\u0016¢\u0006\u0004\br\u0010sJ\u000f\u0010t\u001a\u00020\u0019H\u0016¢\u0006\u0004\bt\u0010sJ\u0017\u0010w\u001a\u00020\u00132\u0006\u0010v\u001a\u00020uH\u0016¢\u0006\u0004\bw\u0010xJ\u0017\u0010z\u001a\u00020\u00132\u0006\u0010y\u001a\u00020jH\u0016¢\u0006\u0004\bz\u0010mJ\u0017\u0010{\u001a\u00020\u00132\u0006\u0010y\u001a\u00020jH\u0016¢\u0006\u0004\b{\u0010mJ\u0017\u0010|\u001a\u00020\u00132\u0006\u0010y\u001a\u00020jH\u0016¢\u0006\u0004\b|\u0010mJ\u0017\u0010~\u001a\u00020\u00132\u0006\u0010}\u001a\u00020\u0019H\u0017¢\u0006\u0004\b~\u0010>J\u0017\u0010\u007f\u001a\u00020\u00132\u0006\u0010}\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u007f\u0010>J\u0019\u0010\u0080\u0001\u001a\u00020\u00132\u0006\u0010}\u001a\u00020\u0019H\u0016¢\u0006\u0005\b\u0080\u0001\u0010>J\u0011\u0010\u0081\u0001\u001a\u00020\u0013H\u0016¢\u0006\u0005\b\u0081\u0001\u0010\u0018J\u001e\u0010\u0084\u0001\u001a\u00020\u00132\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001e\u0010\u0086\u0001\u001a\u00020\u00132\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0085\u0001J\u001a\u0010\u0088\u0001\u001a\u00020\u00132\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0016¢\u0006\u0005\b\u0088\u0001\u00101J\u001a\u0010\u008a\u0001\u001a\u00020\u00132\u0007\u0010\u0089\u0001\u001a\u00020,H\u0016¢\u0006\u0005\b\u008a\u0001\u0010ZJ\u001a\u0010\u008c\u0001\u001a\u00020\u00132\u0007\u0010\u008b\u0001\u001a\u00020,H\u0016¢\u0006\u0005\b\u008c\u0001\u0010ZR\u001b\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bn\u0010\u008e\u0001R\u001a\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bh\u0010\u0090\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u008e\u0001R\u001b\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0090\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u008e\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0090\u0001R\u0019\u0010\u009b\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009d\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009a\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009a\u0001R\u0019\u0010¡\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010\u009a\u0001R\u0019\u0010£\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010\u009a\u0001R\u0019\u0010¥\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010\u009a\u0001R\u001b\u0010¨\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010\u0090\u0001R\u0019\u0010¬\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010\u009a\u0001R\u001b\u0010®\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010\u0090\u0001R\u001a\u0010¯\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bl\u0010§\u0001R\u0018\u0010±\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b-\u0010°\u0001R\u001a\u0010²\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b!\u0010\u0090\u0001R\u001a\u0010³\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010§\u0001R\u001a\u0010´\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0016\u0010\u0090\u0001R\u001a\u0010µ\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0017\u0010§\u0001R\u0018\u0010¶\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001d\u0010°\u0001R\u001b\u0010¹\u0001\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001b\u0010»\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010§\u0001R\u001a\u0010¼\u0001\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010¸\u0001R\u001a\u0010½\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001e\u0010§\u0001R\u001a\u0010¾\u0001\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0014\u0010¸\u0001R\u001b\u0010À\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010§\u0001R\u001b\u0010Ã\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u001b\u0010Å\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010\u0090\u0001R\u0019\u0010Ç\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010\u009a\u0001R\u0018\u0010c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010\u009a\u0001R\u0019\u0010Ê\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010\u009a\u0001R\u0019\u0010Ì\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010°\u0001R\u0019\u0010Î\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010°\u0001R\u0019\u0010Ð\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010°\u0001R\u0019\u0010Ò\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010°\u0001R\u0019\u0010Ô\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010°\u0001R\u0019\u0010Ö\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010°\u0001R\u0019\u0010Ø\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010°\u0001R\u0019\u0010Ú\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010°\u0001R\u0019\u0010Ý\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u001e\u0010á\u0001\u001a\t\u0012\u0004\u0012\u00020\n0Þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u001a\u0010v\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001a\u0010ç\u0001\u001a\u00030ä\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001a\u0010ë\u0001\u001a\u00030è\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001a\u0010ï\u0001\u001a\u00030ì\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bí\u0001\u0010î\u0001R\u001a\u0010ñ\u0001\u001a\u00030è\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bð\u0001\u0010ê\u0001R\u001a\u0010õ\u0001\u001a\u00030ò\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bó\u0001\u0010ô\u0001R\u001a\u0010ù\u0001\u001a\u00030ö\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u001a\u0010û\u0001\u001a\u00030ö\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bú\u0001\u0010ø\u0001R\u001a\u0010ý\u0001\u001a\u00030ö\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bü\u0001\u0010ø\u0001¨\u0006ÿ\u0001"}, d2 = {"Lir/nasim/components/textfield/view/CustomInputView;", "Landroid/widget/LinearLayout;", "Lir/nasim/dx1;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/ViewGroup;", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", TokenNames.C, "(Landroid/view/ViewGroup;)Landroid/util/SparseArray;", "childViewStates", "Lir/nasim/rB7;", "B", "(Landroid/view/ViewGroup;Landroid/util/SparseArray;)V", "u", "v", "()V", "", "t", "(Ljava/lang/String;)I", "z", "w", "A", "", "px", "s", "(FLandroid/content/Context;)F", "container", "dispatchSaveInstanceState", "(Landroid/util/SparseArray;)V", "dispatchRestoreInstanceState", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "", "r", "()Z", "width", "setCardWidth", "(I)V", "height", "setCardHeight", "radius", "setCardCornerRadius", "elevation", "setCardElevation", "Landroid/content/res/ColorStateList;", "color", "setBackgroundTint", "(Landroid/content/res/ColorStateList;)V", "postfix", "setPostfix", "(Ljava/lang/String;)V", "visibility", "setHintVisibility", "hint", "setHint", "setHintTextColor", "size", "setHintSize", "(F)V", "setInputHint", ParameterNames.TEXT, "setText", "setTextColor", "setTextSize", "setInputHintColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setDrawableStart", "(Landroid/graphics/drawable/Drawable;)V", "setDrawableStartTint", "setDrawableEndFirst", "setDrawableEndFirstTint", "setDrawableEndSecond", "setDrawableEndSecondTint", "type", "setInputType", "show", TokenNames.M, "(Z)V", "Landroid/text/method/DigitsKeyListener;", "digitsKeyListener", "setKeyListener", "(Landroid/text/method/DigitsKeyListener;)V", "error", "setErrorStroke", "length", "setMaxLength", "lines", "setLines", "setMaxLines", "Landroid/text/TextWatcher;", "textWatcher", "b", "(Landroid/text/TextWatcher;)V", "Landroid/view/View$OnClickListener;", "onClickListener", "q", "(Landroid/view/View$OnClickListener;)V", "a", "Landroid/text/Editable;", "getText", "()Landroid/text/Editable;", "getInputHint", "()Ljava/lang/String;", "getHint", "Landroid/view/View$OnFocusChangeListener;", "focusChangeListener", "setFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "clickListener", "setDrawableStartClickListener", "setDrawableEndFirstClickListener", "setDrawableEndSecondClickListener", DialogEntity.COLUMN_MESSAGE, "setStartDrawableError", "setHintError", "setInputError", "c", "Landroid/graphics/Typeface;", "typeFace", "setHintTypeFace", "(Landroid/graphics/Typeface;)V", "setTextTypeFace", "index", "setSelection", "enabled", "setEnabled", "focusable", "setFocusable", "Lir/nasim/D20;", "Lir/nasim/D20;", "drawableStartTooltip", "Ljava/lang/String;", "drawableStartTooltipMessage", "hintTooltip", "d", "hintTooltipMessage", "e", "inputTooltip", "f", "inputTooltipMessage", "g", TokenNames.I, "widthAttr", "h", "heightAttr", "i", "cardCornerRadiusAttr", "j", "cardElevationAttr", "k", "cardStrokeWidthAttr", "l", "inputGravityAttr", "m", "Landroid/content/res/ColorStateList;", "backgroundTintAttr", "n", "postfixAttr", "o", "hintVisibilityAttr", "p", "hintAttr", "hintTextColorAttr", TokenNames.F, "hintSizeAttr", "inputHintAttr", "inputHintColorAttr", "textAttr", "textColorAttr", "textSizeAttr", "x", "Landroid/graphics/drawable/Drawable;", "drawableStartAttr", "y", "drawableStartTintAttr", "drawableEndFirstAttr", "drawableEndFirstTintAttr", "drawableEndSecondAttr", "D", "drawableEndSecondTintAttr", "G", "Ljava/lang/Integer;", "typeAttr", "H", "digitsAttr", "J", "maxLengthAttr", "z0", "A0", "maxLines", "B0", "inputMarginBottomAttr", "C0", "inputMarginTopAttr", "D0", "inputMarginRightAttr", "E0", "inputMarginLeftAttr", "F0", "hintMarginBottomAttr", "G0", "hintMarginTopAttr", "H0", "hintMarginRightAttr", "I0", "hintMarginLeftAttr", "J0", "Z", "isSourceInput", "Ljava/util/ArrayList;", "K0", "Ljava/util/ArrayList;", "types", "L0", "Landroid/view/View$OnFocusChangeListener;", "Lcom/google/android/material/card/MaterialCardView;", "M0", "Lcom/google/android/material/card/MaterialCardView;", "cardRoot", "Landroid/widget/TextView;", "N0", "Landroid/widget/TextView;", "hintTv", "Landroid/widget/EditText;", "O0", "Landroid/widget/EditText;", "inputEt", "P0", "postfixTxt", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Q0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mainLayout", "Landroid/widget/ImageView;", "R0", "Landroid/widget/ImageView;", "startDrawableImg", "S0", "endDrawableFirstImg", "T0", "endDrawableSecondImg", "U0", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class CustomInputView extends LinearLayout implements InterfaceC12049dx1 {

    /* renamed from: U0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int V0 = 8;

    /* renamed from: A, reason: from kotlin metadata */
    private ColorStateList drawableEndFirstTintAttr;

    /* renamed from: A0, reason: from kotlin metadata */
    private int maxLines;

    /* renamed from: B, reason: from kotlin metadata */
    private Drawable drawableEndSecondAttr;

    /* renamed from: B0, reason: from kotlin metadata */
    private float inputMarginBottomAttr;

    /* renamed from: C0, reason: from kotlin metadata */
    private float inputMarginTopAttr;

    /* renamed from: D, reason: from kotlin metadata */
    private ColorStateList drawableEndSecondTintAttr;

    /* renamed from: D0, reason: from kotlin metadata */
    private float inputMarginRightAttr;

    /* renamed from: E0, reason: from kotlin metadata */
    private float inputMarginLeftAttr;

    /* renamed from: F0, reason: from kotlin metadata */
    private float hintMarginBottomAttr;

    /* renamed from: G, reason: from kotlin metadata */
    private Integer typeAttr;

    /* renamed from: G0, reason: from kotlin metadata */
    private float hintMarginTopAttr;

    /* renamed from: H, reason: from kotlin metadata */
    private String digitsAttr;

    /* renamed from: H0, reason: from kotlin metadata */
    private float hintMarginRightAttr;

    /* renamed from: I0, reason: from kotlin metadata */
    private float hintMarginLeftAttr;

    /* renamed from: J, reason: from kotlin metadata */
    private int maxLengthAttr;

    /* renamed from: J0, reason: from kotlin metadata */
    private boolean isSourceInput;

    /* renamed from: K0, reason: from kotlin metadata */
    private final ArrayList types;

    /* renamed from: L0, reason: from kotlin metadata */
    private View.OnFocusChangeListener focusChangeListener;

    /* renamed from: M0, reason: from kotlin metadata */
    private MaterialCardView cardRoot;

    /* renamed from: N0, reason: from kotlin metadata */
    private TextView hintTv;

    /* renamed from: O0, reason: from kotlin metadata */
    private EditText inputEt;

    /* renamed from: P0, reason: from kotlin metadata */
    private TextView postfixTxt;

    /* renamed from: Q0, reason: from kotlin metadata */
    private ConstraintLayout mainLayout;

    /* renamed from: R0, reason: from kotlin metadata */
    private ImageView startDrawableImg;

    /* renamed from: S0, reason: from kotlin metadata */
    private ImageView endDrawableFirstImg;

    /* renamed from: T0, reason: from kotlin metadata */
    private ImageView endDrawableSecondImg;

    /* renamed from: a, reason: from kotlin metadata */
    private D20 drawableStartTooltip;

    /* renamed from: b, reason: from kotlin metadata */
    private String drawableStartTooltipMessage;

    /* renamed from: c, reason: from kotlin metadata */
    private D20 hintTooltip;

    /* renamed from: d, reason: from kotlin metadata */
    private String hintTooltipMessage;

    /* renamed from: e, reason: from kotlin metadata */
    private D20 inputTooltip;

    /* renamed from: f, reason: from kotlin metadata */
    private String inputTooltipMessage;

    /* renamed from: g, reason: from kotlin metadata */
    private int widthAttr;

    /* renamed from: h, reason: from kotlin metadata */
    private int heightAttr;

    /* renamed from: i, reason: from kotlin metadata */
    private int cardCornerRadiusAttr;

    /* renamed from: j, reason: from kotlin metadata */
    private int cardElevationAttr;

    /* renamed from: k, reason: from kotlin metadata */
    private int cardStrokeWidthAttr;

    /* renamed from: l, reason: from kotlin metadata */
    private int inputGravityAttr;

    /* renamed from: m, reason: from kotlin metadata */
    private ColorStateList backgroundTintAttr;

    /* renamed from: n, reason: from kotlin metadata */
    private String postfixAttr;

    /* renamed from: o, reason: from kotlin metadata */
    private int hintVisibilityAttr;

    /* renamed from: p, reason: from kotlin metadata */
    private String hintAttr;

    /* renamed from: q, reason: from kotlin metadata */
    private ColorStateList hintTextColorAttr;

    /* renamed from: r, reason: from kotlin metadata */
    private float hintSizeAttr;

    /* renamed from: s, reason: from kotlin metadata */
    private String inputHintAttr;

    /* renamed from: t, reason: from kotlin metadata */
    private ColorStateList inputHintColorAttr;

    /* renamed from: u, reason: from kotlin metadata */
    private String textAttr;

    /* renamed from: v, reason: from kotlin metadata */
    private ColorStateList textColorAttr;

    /* renamed from: w, reason: from kotlin metadata */
    private float textSizeAttr;

    /* renamed from: x, reason: from kotlin metadata */
    private Drawable drawableStartAttr;

    /* renamed from: y, reason: from kotlin metadata */
    private ColorStateList drawableStartTintAttr;

    /* renamed from: z, reason: from kotlin metadata */
    private Drawable drawableEndFirstAttr;

    /* renamed from: z0, reason: from kotlin metadata */
    private int lines;

    /* renamed from: ir.nasim.components.textfield.view.CustomInputView$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final Boolean a(String str) {
            int iG;
            AbstractC13042fc3.i(str, "number");
            if (str.length() != 16) {
                return null;
            }
            int i = 0;
            boolean z = true;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (z) {
                    iG = AbstractC11632dL0.g(cCharAt) * 2;
                    if (iG > 9) {
                        iG -= 9;
                    }
                } else {
                    iG = AbstractC11632dL0.g(cCharAt);
                }
                i += iG;
                z = !z;
            }
            int i3 = i % 10;
            return Boolean.valueOf(i3 + ((((i3 ^ 10) & ((-i3) | i3)) >> 31) & 10) == 0);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements View.OnTouchListener {
        final /* synthetic */ C11637dL5 b;

        b(C11637dL5 c11637dL5) {
            this.b = c11637dL5;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EditText editText = CustomInputView.this.inputEt;
            EditText editText2 = null;
            if (editText == null) {
                AbstractC13042fc3.y("inputEt");
                editText = null;
            }
            if (editText.hasFocus()) {
                CustomInputView customInputView = CustomInputView.this;
                EditText editText3 = customInputView.inputEt;
                if (editText3 == null) {
                    AbstractC13042fc3.y("inputEt");
                } else {
                    editText2 = editText3;
                }
                if (customInputView.t(editText2.getText().toString()) > this.b.a) {
                    AbstractC13042fc3.f(view);
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    AbstractC13042fc3.f(motionEvent);
                    if ((motionEvent.getAction() & 255) == 8) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomInputView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.widthAttr = -1;
        this.heightAttr = -2;
        this.cardCornerRadiusAttr = 5;
        this.cardElevationAttr = 5;
        this.cardStrokeWidthAttr = 2;
        this.hintSizeAttr = 14.0f;
        this.textSizeAttr = 14.0f;
        this.maxLengthAttr = -1;
        this.lines = 1;
        this.maxLines = 1;
        this.isSourceInput = true;
        this.types = new ArrayList();
        u(context, null);
    }

    private final void A() {
        this.types.add(1);
        this.types.add(2);
        this.types.add(129);
        this.types.add(18);
        this.types.add(3);
        this.types.add(147457);
    }

    private final void B(ViewGroup viewGroup, SparseArray sparseArray) {
        Iterator it = AbstractC24379yW7.b(viewGroup).iterator();
        while (it.hasNext()) {
            ((View) it.next()).restoreHierarchyState(sparseArray);
        }
    }

    private final SparseArray C(ViewGroup viewGroup) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        Iterator it = AbstractC24379yW7.b(viewGroup).iterator();
        while (it.hasNext()) {
            ((View) it.next()).saveHierarchyState(sparseArray);
        }
        return sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(final CustomInputView customInputView, String str) {
        AbstractC13042fc3.i(customInputView, "this$0");
        AbstractC13042fc3.i(str, "$message");
        Context context = customInputView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        D20.a aVar = new D20.a(context);
        aVar.Y1(str);
        Typeface typefaceK = C6011Lu2.k();
        AbstractC13042fc3.f(typefaceK);
        aVar.i2(typefaceK);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        aVar.a2(c5495Jo7.l2());
        aVar.f2(13.0f);
        aVar.m1(16.0f);
        aVar.R1(16);
        aVar.T1(16);
        aVar.l2(RecyclerView.UNDEFINED_DURATION);
        aVar.h1(c5495Jo7.J0());
        aVar.Z0(EnumC12265eK.a);
        aVar.Y0(EnumC11622dK.c);
        aVar.j1(F20.c);
        aVar.b1(0.8f);
        aVar.r1(false);
        aVar.t1(false);
        D20 d20A = aVar.a();
        customInputView.hintTooltip = d20A;
        if (d20A != null) {
            d20A.t0(new SA2() { // from class: ir.nasim.ox1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CustomInputView.E(this.a);
                }
            });
        }
        D20 d20 = customInputView.hintTooltip;
        if (d20 != null) {
            TextView textView = customInputView.hintTv;
            if (textView == null) {
                AbstractC13042fc3.y("hintTv");
                textView = null;
            }
            D20.K0(d20, textView, 100, 0, 4, null);
        }
        D20 d202 = customInputView.hintTooltip;
        if (d202 != null) {
            d202.t0(new SA2() { // from class: ir.nasim.fx1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CustomInputView.F(this.a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(CustomInputView customInputView) {
        AbstractC13042fc3.i(customInputView, "this$0");
        customInputView.c();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(CustomInputView customInputView) {
        AbstractC13042fc3.i(customInputView, "this$0");
        customInputView.hintTooltipMessage = null;
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(final CustomInputView customInputView, String str) {
        AbstractC13042fc3.i(customInputView, "this$0");
        AbstractC13042fc3.i(str, "$message");
        Context context = customInputView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        D20.a aVar = new D20.a(context);
        aVar.Y1(str);
        Typeface typefaceK = C6011Lu2.k();
        AbstractC13042fc3.f(typefaceK);
        aVar.i2(typefaceK);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        aVar.a2(c5495Jo7.l2());
        aVar.f2(13.0f);
        aVar.m1(16.0f);
        aVar.R1(16);
        aVar.T1(16);
        aVar.l2(RecyclerView.UNDEFINED_DURATION);
        aVar.h1(c5495Jo7.J0());
        aVar.Z0(EnumC12265eK.a);
        aVar.Y0(EnumC11622dK.c);
        aVar.j1(F20.c);
        aVar.b1(0.8f);
        aVar.r1(false);
        aVar.t1(false);
        D20 d20A = aVar.a();
        customInputView.inputTooltip = d20A;
        if (d20A != null) {
            d20A.t0(new SA2() { // from class: ir.nasim.kx1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CustomInputView.H(this.a);
                }
            });
        }
        D20 d20 = customInputView.inputTooltip;
        if (d20 != null) {
            EditText editText = customInputView.inputEt;
            if (editText == null) {
                AbstractC13042fc3.y("inputEt");
                editText = null;
            }
            D20.K0(d20, editText, 100, 0, 4, null);
        }
        D20 d202 = customInputView.inputTooltip;
        if (d202 != null) {
            d202.t0(new SA2() { // from class: ir.nasim.lx1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CustomInputView.I(this.a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(CustomInputView customInputView) {
        AbstractC13042fc3.i(customInputView, "this$0");
        customInputView.c();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(CustomInputView customInputView) {
        AbstractC13042fc3.i(customInputView, "this$0");
        customInputView.inputTooltipMessage = null;
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(final CustomInputView customInputView, String str) {
        AbstractC13042fc3.i(customInputView, "this$0");
        AbstractC13042fc3.i(str, "$message");
        Context context = customInputView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        D20.a aVar = new D20.a(context);
        aVar.Y1(str);
        Typeface typefaceK = C6011Lu2.k();
        AbstractC13042fc3.f(typefaceK);
        aVar.i2(typefaceK);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        aVar.a2(c5495Jo7.l2());
        aVar.f2(13.0f);
        aVar.m1(16.0f);
        aVar.R1(16);
        aVar.T1(16);
        aVar.l2(RecyclerView.UNDEFINED_DURATION);
        aVar.h1(c5495Jo7.J0());
        aVar.Z0(EnumC12265eK.a);
        aVar.Y0(EnumC11622dK.c);
        aVar.j1(F20.c);
        aVar.b1(0.5f);
        aVar.r1(false);
        aVar.t1(false);
        D20 d20A = aVar.a();
        customInputView.drawableStartTooltip = d20A;
        if (d20A != null) {
            d20A.t0(new SA2() { // from class: ir.nasim.mx1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CustomInputView.K(this.a);
                }
            });
        }
        D20 d20 = customInputView.drawableStartTooltip;
        if (d20 != null) {
            ImageView imageView = customInputView.startDrawableImg;
            if (imageView == null) {
                AbstractC13042fc3.y("startDrawableImg");
                imageView = null;
            }
            D20.K0(d20, imageView, 0, 0, 6, null);
        }
        D20 d202 = customInputView.drawableStartTooltip;
        if (d202 != null) {
            d202.t0(new SA2() { // from class: ir.nasim.nx1
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return CustomInputView.L(this.a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(CustomInputView customInputView) {
        AbstractC13042fc3.i(customInputView, "this$0");
        customInputView.c();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(CustomInputView customInputView) {
        AbstractC13042fc3.i(customInputView, "this$0");
        customInputView.drawableStartTooltipMessage = null;
        return C19938rB7.a;
    }

    private final float s(float px, Context context) {
        return px / (context.getResources().getDisplayMetrics().densityDpi / 160);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t(String str) {
        try {
            return ((String[]) new C20644sM5("\r\n|\r|\n").m(str, 0).toArray(new String[0])).length;
        } catch (Exception unused) {
            return -1;
        }
    }

    private final void u(Context context, AttributeSet attrs) {
        EditText editText;
        EditText editText2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        EditText editText3;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, ME5.CustomInputView);
            AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            if (attrs != null) {
                this.widthAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_cardWidth, -1);
                this.heightAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_cardHeight, -2);
                this.cardCornerRadiusAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_cardCornerRadius, 5);
                this.cardElevationAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_cardElevation, 5);
                this.cardStrokeWidthAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_cardStrokeWidth, 2);
                this.inputGravityAttr = typedArrayObtainStyledAttributes.getInt(ME5.CustomInputView_inputGravity, 0);
                this.inputGravityAttr = typedArrayObtainStyledAttributes.getInt(ME5.CustomInputView_inputGravity, 0);
                this.backgroundTintAttr = typedArrayObtainStyledAttributes.getColorStateList(ME5.CustomInputView_android_backgroundTint);
                this.postfixAttr = typedArrayObtainStyledAttributes.getString(ME5.CustomInputView_postfix);
                this.hintVisibilityAttr = typedArrayObtainStyledAttributes.getInt(ME5.CustomInputView_hintVisibility, 0);
                this.hintAttr = typedArrayObtainStyledAttributes.getString(ME5.CustomInputView_android_hint);
                this.hintTextColorAttr = typedArrayObtainStyledAttributes.getColorStateList(ME5.CustomInputView_android_textColorHint);
                this.hintSizeAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_hintSize, 14);
                this.inputHintAttr = typedArrayObtainStyledAttributes.getString(ME5.CustomInputView_inputHint);
                this.inputHintColorAttr = typedArrayObtainStyledAttributes.getColorStateList(ME5.CustomInputView_inputHintColor);
                this.textAttr = typedArrayObtainStyledAttributes.getString(ME5.CustomInputView_android_text);
                this.textColorAttr = typedArrayObtainStyledAttributes.getColorStateList(ME5.CustomInputView_android_textColor);
                this.textSizeAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_android_textSize, 14);
                this.drawableStartAttr = typedArrayObtainStyledAttributes.getDrawable(ME5.CustomInputView_drawableStart);
                this.drawableStartTintAttr = typedArrayObtainStyledAttributes.getColorStateList(ME5.CustomInputView_drawableStartTint);
                this.drawableEndFirstAttr = typedArrayObtainStyledAttributes.getDrawable(ME5.CustomInputView_drawableEndFirst);
                this.drawableEndFirstTintAttr = typedArrayObtainStyledAttributes.getColorStateList(ME5.CustomInputView_drawableEndFirstTint);
                this.drawableEndSecondAttr = typedArrayObtainStyledAttributes.getDrawable(ME5.CustomInputView_drawableEndSecond);
                this.drawableEndSecondTintAttr = typedArrayObtainStyledAttributes.getColorStateList(ME5.CustomInputView_drawableEndSecondTint);
                this.typeAttr = Integer.valueOf(typedArrayObtainStyledAttributes.getInt(ME5.CustomInputView_textInputType, 0));
                this.digitsAttr = typedArrayObtainStyledAttributes.getString(ME5.CustomInputView_android_digits);
                this.maxLengthAttr = typedArrayObtainStyledAttributes.getInt(ME5.CustomInputView_android_maxLength, -1);
                this.lines = typedArrayObtainStyledAttributes.getInt(ME5.CustomInputView_android_lines, -1);
                this.maxLines = typedArrayObtainStyledAttributes.getInt(ME5.CustomInputView_android_maxLines, -1);
                this.inputMarginBottomAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_inputMarginBottom, 0);
                this.inputMarginTopAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_inputMarginTop, 0);
                this.inputMarginRightAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_inputMarginRight, 0);
                this.inputMarginLeftAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_inputMarginLeft, 0);
                this.hintMarginBottomAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_hintMarginBottom, 0);
                this.hintMarginTopAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_hintMarginTop, 0);
                this.hintMarginRightAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_hintMarginRight, 0);
                this.hintMarginLeftAttr = typedArrayObtainStyledAttributes.getDimensionPixelSize(ME5.CustomInputView_hintMarginLeft, 0);
                this.isSourceInput = typedArrayObtainStyledAttributes.getBoolean(ME5.CustomInputView_isSourceInput, true);
            }
            View viewInflate = LayoutInflater.from(context).inflate(this.inputGravityAttr == 0 ? TC5.widget_top_custom_input_view : TC5.widget_bottom_custom_input_view, (ViewGroup) this, true);
            if (this.inputGravityAttr == 0) {
                C15783k98 c15783k98A = C15783k98.a(viewInflate);
                AbstractC13042fc3.h(c15783k98A, "bind(...)");
                this.cardRoot = c15783k98A.b;
                this.hintTv = c15783k98A.e;
                this.inputEt = c15783k98A.f;
                this.postfixTxt = c15783k98A.h;
                this.mainLayout = c15783k98A.g;
                this.startDrawableImg = c15783k98A.i;
                this.endDrawableFirstImg = c15783k98A.c;
                this.endDrawableSecondImg = c15783k98A.d;
            } else {
                C12765f98 c12765f98A = C12765f98.a(viewInflate);
                AbstractC13042fc3.h(c12765f98A, "bind(...)");
                this.cardRoot = c12765f98A.b;
                this.hintTv = c12765f98A.e;
                this.inputEt = c12765f98A.f;
                this.postfixTxt = c12765f98A.h;
                this.mainLayout = c12765f98A.g;
                this.startDrawableImg = c12765f98A.i;
                this.endDrawableFirstImg = c12765f98A.c;
                this.endDrawableSecondImg = c12765f98A.d;
            }
            MaterialCardView materialCardView = this.cardRoot;
            TextView textView4 = null;
            if (materialCardView == null) {
                AbstractC13042fc3.y("cardRoot");
                materialCardView = null;
            }
            materialCardView.setStrokeWidth(0);
            z();
            w();
            A();
            v();
            setCardWidth(this.widthAttr);
            setCardHeight(this.heightAttr);
            setCardCornerRadius(this.cardCornerRadiusAttr);
            setCardElevation(this.cardElevationAttr);
            ColorStateList colorStateList = this.backgroundTintAttr;
            if (colorStateList != null) {
                setBackgroundTint(colorStateList);
            }
            setPostfix(this.postfixAttr);
            setHint(this.hintAttr);
            setHintVisibility(this.hintVisibilityAttr);
            ColorStateList colorStateList2 = this.hintTextColorAttr;
            if (colorStateList2 != null) {
                setHintTextColor(colorStateList2);
            }
            setHintSize(s(this.hintSizeAttr, context));
            setInputHint(this.inputHintAttr);
            setText(this.textAttr);
            ColorStateList colorStateList3 = this.textColorAttr;
            if (colorStateList3 != null) {
                setTextColor(colorStateList3);
            }
            setTextSize(s(this.textSizeAttr, context));
            ColorStateList colorStateList4 = this.inputHintColorAttr;
            if (colorStateList4 != null) {
                setInputHintColor(colorStateList4);
            }
            setDrawableStart(this.drawableStartAttr);
            ColorStateList colorStateList5 = this.drawableStartTintAttr;
            if (colorStateList5 != null) {
                setDrawableStartTint(colorStateList5);
            }
            setDrawableEndFirst(this.drawableEndFirstAttr);
            ColorStateList colorStateList6 = this.drawableEndFirstTintAttr;
            if (colorStateList6 != null) {
                setDrawableEndFirstTint(colorStateList6);
            }
            setDrawableEndSecond(this.drawableEndSecondAttr);
            float f = this.inputMarginBottomAttr;
            if (f != 0.0f) {
                EditText editText4 = this.inputEt;
                if (editText4 == null) {
                    AbstractC13042fc3.y("inputEt");
                    editText3 = null;
                } else {
                    editText3 = editText4;
                }
                AbstractC14828iY7.k(editText3, null, null, null, Float.valueOf(f), 7, null);
            }
            float f2 = this.inputMarginTopAttr;
            if (f2 != 0.0f) {
                EditText editText5 = this.inputEt;
                if (editText5 == null) {
                    AbstractC13042fc3.y("inputEt");
                    editText = null;
                } else {
                    editText = editText5;
                }
                AbstractC14828iY7.k(editText, null, Float.valueOf(f2), null, null, 13, null);
            }
            float f3 = this.inputMarginRightAttr;
            if (f3 != 0.0f) {
                EditText editText6 = this.inputEt;
                if (editText6 == null) {
                    AbstractC13042fc3.y("inputEt");
                    editText2 = null;
                } else {
                    editText2 = editText6;
                }
                AbstractC14828iY7.k(editText2, null, null, Float.valueOf(f3), null, 11, null);
            }
            float f4 = this.inputMarginLeftAttr;
            if (f4 != 0.0f) {
                EditText editText7 = this.inputEt;
                if (editText7 == null) {
                    AbstractC13042fc3.y("inputEt");
                    editText7 = null;
                }
                AbstractC14828iY7.k(editText7, Float.valueOf(f4), null, null, null, 14, null);
            }
            float f5 = this.hintMarginBottomAttr;
            if (f5 != 0.0f) {
                TextView textView5 = this.hintTv;
                if (textView5 == null) {
                    AbstractC13042fc3.y("hintTv");
                    textView3 = null;
                } else {
                    textView3 = textView5;
                }
                AbstractC14828iY7.k(textView3, null, null, null, Float.valueOf(f5), 7, null);
            }
            float f6 = this.hintMarginTopAttr;
            if (f6 != 0.0f) {
                TextView textView6 = this.hintTv;
                if (textView6 == null) {
                    AbstractC13042fc3.y("hintTv");
                    textView = null;
                } else {
                    textView = textView6;
                }
                AbstractC14828iY7.k(textView, null, Float.valueOf(f6), null, null, 13, null);
            }
            float f7 = this.hintMarginRightAttr;
            if (f7 != 0.0f) {
                TextView textView7 = this.hintTv;
                if (textView7 == null) {
                    AbstractC13042fc3.y("hintTv");
                    textView2 = null;
                } else {
                    textView2 = textView7;
                }
                AbstractC14828iY7.k(textView2, null, null, Float.valueOf(f7), null, 11, null);
            }
            float f8 = this.hintMarginLeftAttr;
            if (f8 != 0.0f) {
                TextView textView8 = this.hintTv;
                if (textView8 == null) {
                    AbstractC13042fc3.y("hintTv");
                } else {
                    textView4 = textView8;
                }
                AbstractC14828iY7.k(textView4, Float.valueOf(f8), null, null, null, 14, null);
            }
            ColorStateList colorStateList7 = this.drawableEndSecondTintAttr;
            if (colorStateList7 != null) {
                setDrawableEndSecondTint(colorStateList7);
            }
            Integer num = this.typeAttr;
            if (num != null) {
                Object obj = this.types.get(num.intValue());
                AbstractC13042fc3.h(obj, "get(...)");
                setInputType(((Number) obj).intValue());
            }
            String str = this.digitsAttr;
            if (str != null) {
                DigitsKeyListener digitsKeyListener = DigitsKeyListener.getInstance(str);
                AbstractC13042fc3.h(digitsKeyListener, "getInstance(...)");
                setKeyListener(digitsKeyListener);
            }
            setMaxLength(this.maxLengthAttr);
            setLines(this.lines);
            setMaxLines(this.maxLines);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    private final void v() {
        C11637dL5 c11637dL5 = new C11637dL5();
        int i = this.maxLines;
        c11637dL5.a = i;
        if (i < 1) {
            c11637dL5.a = 1;
        }
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setOnTouchListener(new b(c11637dL5));
    }

    private final void w() {
        EditText editText = this.inputEt;
        ConstraintLayout constraintLayout = null;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.hx1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) throws Resources.NotFoundException {
                CustomInputView.x(this.a, view, z);
            }
        });
        ConstraintLayout constraintLayout2 = this.mainLayout;
        if (constraintLayout2 == null) {
            AbstractC13042fc3.y("mainLayout");
        } else {
            constraintLayout = constraintLayout2;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ix1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomInputView.y(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(CustomInputView customInputView, View view, boolean z) throws Resources.NotFoundException {
        AbstractC13042fc3.i(customInputView, "this$0");
        customInputView.setErrorStroke(false);
        MaterialCardView materialCardView = customInputView.cardRoot;
        EditText editText = null;
        if (materialCardView == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView = null;
        }
        materialCardView.setStrokeColor(C5495Jo7.a.M0());
        if (z) {
            MaterialCardView materialCardView2 = customInputView.cardRoot;
            if (materialCardView2 == null) {
                AbstractC13042fc3.y("cardRoot");
                materialCardView2 = null;
            }
            materialCardView2.setStrokeWidth((int) ((customInputView.cardStrokeWidthAttr * AbstractC3742Cd6.c()) + 0.5d));
        } else {
            MaterialCardView materialCardView3 = customInputView.cardRoot;
            if (materialCardView3 == null) {
                AbstractC13042fc3.y("cardRoot");
                materialCardView3 = null;
            }
            materialCardView3.setStrokeWidth(0);
        }
        View.OnFocusChangeListener onFocusChangeListener = customInputView.focusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z);
        }
        Companion companion = INSTANCE;
        EditText editText2 = customInputView.inputEt;
        if (editText2 == null) {
            AbstractC13042fc3.y("inputEt");
        } else {
            editText = editText2;
        }
        if (AbstractC13042fc3.d(companion.a(ZY6.a(editText.getText().toString())), Boolean.FALSE)) {
            String string = customInputView.getContext().getResources().getString(customInputView.isSourceInput ? UD5.card_payment_missing_source_card : UD5.card_payment_missing_destination_card);
            AbstractC13042fc3.h(string, "getString(...)");
            customInputView.setInputError(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(CustomInputView customInputView, View view) {
        AbstractC13042fc3.i(customInputView, "this$0");
        if (customInputView.isEnabled()) {
            EditText editText = customInputView.inputEt;
            EditText editText2 = null;
            if (editText == null) {
                AbstractC13042fc3.y("inputEt");
                editText = null;
            }
            editText.requestFocus();
            EditText editText3 = customInputView.inputEt;
            if (editText3 == null) {
                AbstractC13042fc3.y("inputEt");
            } else {
                editText2 = editText3;
            }
            C23381wp3.g(editText2);
        }
    }

    private final void z() {
        try {
            TextView textView = this.hintTv;
            TextView textView2 = null;
            if (textView == null) {
                AbstractC13042fc3.y("hintTv");
                textView = null;
            }
            textView.setTypeface(C6011Lu2.i());
            EditText editText = this.inputEt;
            if (editText == null) {
                AbstractC13042fc3.y("inputEt");
                editText = null;
            }
            editText.setTypeface(C6011Lu2.k());
            TextView textView3 = this.postfixTxt;
            if (textView3 == null) {
                AbstractC13042fc3.y("postfixTxt");
            } else {
                textView2 = textView3;
            }
            textView2.setTypeface(C6011Lu2.k());
        } catch (Exception unused) {
        }
    }

    public void M(boolean show) {
        EditText editText = this.inputEt;
        EditText editText2 = null;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        int selectionStart = editText.getSelectionStart();
        EditText editText3 = this.inputEt;
        if (editText3 == null) {
            AbstractC13042fc3.y("inputEt");
            editText3 = null;
        }
        int selectionEnd = editText3.getSelectionEnd();
        if (show) {
            EditText editText4 = this.inputEt;
            if (editText4 == null) {
                AbstractC13042fc3.y("inputEt");
                editText4 = null;
            }
            editText4.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            EditText editText5 = this.inputEt;
            if (editText5 == null) {
                AbstractC13042fc3.y("inputEt");
                editText5 = null;
            }
            editText5.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        EditText editText6 = this.inputEt;
        if (editText6 == null) {
            AbstractC13042fc3.y("inputEt");
        } else {
            editText2 = editText6;
        }
        editText2.setSelection(selectionStart, selectionEnd);
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public void a(TextWatcher textWatcher) {
        AbstractC13042fc3.i(textWatcher, "textWatcher");
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.removeTextChangedListener(textWatcher);
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public void b(TextWatcher textWatcher) {
        AbstractC13042fc3.i(textWatcher, "textWatcher");
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.addTextChangedListener(textWatcher);
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public void c() {
        try {
            setErrorStroke(false);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray container) {
        AbstractC13042fc3.i(container, "container");
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray container) {
        AbstractC13042fc3.i(container, "container");
        dispatchFreezeSelfOnly(container);
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public String getHint() {
        TextView textView = this.hintTv;
        if (textView == null) {
            AbstractC13042fc3.y("hintTv");
            textView = null;
        }
        return textView.getText().toString();
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public String getInputHint() {
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        return editText.getHint().toString();
    }

    public Editable getText() {
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        Editable text = editText.getText();
        AbstractC13042fc3.h(text, "getText(...)");
        return text;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("SPARSE_STATE_KEY");
            if (sparseParcelableArray != null) {
                B(this, sparseParcelableArray);
            }
            state = bundle.getParcelable("SUPER_STATE_KEY");
        }
        super.onRestoreInstanceState(state);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER_STATE_KEY", super.onSaveInstanceState());
        bundle.putSparseParcelableArray("SPARSE_STATE_KEY", C(this));
        return bundle;
    }

    public void q(View.OnClickListener onClickListener) {
        AbstractC13042fc3.i(onClickListener, "onClickListener");
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setOnClickListener(onClickListener);
    }

    public final boolean r() throws Resources.NotFoundException {
        Companion companion = INSTANCE;
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        if (AbstractC13042fc3.d(companion.a(ZY6.a(editText.getText().toString())), Boolean.TRUE)) {
            return true;
        }
        String string = getContext().getResources().getString(this.isSourceInput ? UD5.card_payment_missing_source_card : UD5.card_payment_missing_destination_card);
        AbstractC13042fc3.h(string, "getString(...)");
        setInputError(string);
        return false;
    }

    public void setBackgroundTint(ColorStateList color) {
        AbstractC13042fc3.i(color, "color");
        MaterialCardView materialCardView = this.cardRoot;
        if (materialCardView == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView = null;
        }
        materialCardView.setCardBackgroundColor(color);
    }

    public void setCardCornerRadius(int radius) {
        MaterialCardView materialCardView = this.cardRoot;
        if (materialCardView == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView = null;
        }
        materialCardView.setRadius((int) ((radius * AbstractC3742Cd6.c()) + 0.5d));
    }

    public void setCardElevation(int elevation) {
        MaterialCardView materialCardView = this.cardRoot;
        if (materialCardView == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView = null;
        }
        materialCardView.setElevation((int) ((elevation * AbstractC3742Cd6.c()) + 0.5d));
    }

    public void setCardHeight(int height) {
        MaterialCardView materialCardView = this.cardRoot;
        MaterialCardView materialCardView2 = null;
        if (materialCardView == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView = null;
        }
        ViewGroup.LayoutParams layoutParams = materialCardView.getLayoutParams();
        layoutParams.height = height;
        MaterialCardView materialCardView3 = this.cardRoot;
        if (materialCardView3 == null) {
            AbstractC13042fc3.y("cardRoot");
        } else {
            materialCardView2 = materialCardView3;
        }
        materialCardView2.setLayoutParams(layoutParams);
    }

    public void setCardWidth(int width) {
        MaterialCardView materialCardView = this.cardRoot;
        MaterialCardView materialCardView2 = null;
        if (materialCardView == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView = null;
        }
        ViewGroup.LayoutParams layoutParams = materialCardView.getLayoutParams();
        layoutParams.width = width;
        MaterialCardView materialCardView3 = this.cardRoot;
        if (materialCardView3 == null) {
            AbstractC13042fc3.y("cardRoot");
        } else {
            materialCardView2 = materialCardView3;
        }
        materialCardView2.setLayoutParams(layoutParams);
    }

    public void setDrawableEndFirst(Drawable drawable) {
        ImageView imageView = this.endDrawableFirstImg;
        ImageView imageView2 = null;
        if (imageView == null) {
            AbstractC13042fc3.y("endDrawableFirstImg");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            ImageView imageView3 = this.endDrawableFirstImg;
            if (imageView3 == null) {
                AbstractC13042fc3.y("endDrawableFirstImg");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(8);
            return;
        }
        ImageView imageView4 = this.endDrawableFirstImg;
        if (imageView4 == null) {
            AbstractC13042fc3.y("endDrawableFirstImg");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(0);
    }

    public void setDrawableEndFirstClickListener(View.OnClickListener clickListener) {
        AbstractC13042fc3.i(clickListener, "clickListener");
        ImageView imageView = this.endDrawableFirstImg;
        if (imageView == null) {
            AbstractC13042fc3.y("endDrawableFirstImg");
            imageView = null;
        }
        imageView.setOnClickListener(clickListener);
    }

    public void setDrawableEndFirstTint(ColorStateList color) {
        AbstractC13042fc3.i(color, "color");
        try {
            ImageView imageView = this.endDrawableFirstImg;
            if (imageView != null) {
                if (imageView == null) {
                    AbstractC13042fc3.y("endDrawableFirstImg");
                    imageView = null;
                }
                imageView.setColorFilter(color.getDefaultColor());
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public void setDrawableEndSecond(Drawable drawable) {
        ImageView imageView = this.endDrawableSecondImg;
        ImageView imageView2 = null;
        if (imageView == null) {
            AbstractC13042fc3.y("endDrawableSecondImg");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            ImageView imageView3 = this.endDrawableSecondImg;
            if (imageView3 == null) {
                AbstractC13042fc3.y("endDrawableSecondImg");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(8);
            return;
        }
        ImageView imageView4 = this.endDrawableSecondImg;
        if (imageView4 == null) {
            AbstractC13042fc3.y("endDrawableSecondImg");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(0);
    }

    public void setDrawableEndSecondClickListener(View.OnClickListener clickListener) {
        AbstractC13042fc3.i(clickListener, "clickListener");
        ImageView imageView = this.endDrawableSecondImg;
        if (imageView == null) {
            AbstractC13042fc3.y("endDrawableSecondImg");
            imageView = null;
        }
        imageView.setOnClickListener(clickListener);
    }

    public void setDrawableEndSecondTint(ColorStateList color) {
        AbstractC13042fc3.i(color, "color");
        try {
            ImageView imageView = this.endDrawableSecondImg;
            if (imageView != null) {
                if (imageView == null) {
                    AbstractC13042fc3.y("endDrawableSecondImg");
                    imageView = null;
                }
                imageView.setColorFilter(color.getDefaultColor());
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public void setDrawableStart(Drawable drawable) {
        ImageView imageView = this.startDrawableImg;
        ImageView imageView2 = null;
        if (imageView == null) {
            AbstractC13042fc3.y("startDrawableImg");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            ImageView imageView3 = this.startDrawableImg;
            if (imageView3 == null) {
                AbstractC13042fc3.y("startDrawableImg");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(8);
            return;
        }
        ImageView imageView4 = this.startDrawableImg;
        if (imageView4 == null) {
            AbstractC13042fc3.y("startDrawableImg");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(0);
    }

    public void setDrawableStartClickListener(View.OnClickListener clickListener) {
        AbstractC13042fc3.i(clickListener, "clickListener");
        ImageView imageView = this.startDrawableImg;
        if (imageView == null) {
            AbstractC13042fc3.y("startDrawableImg");
            imageView = null;
        }
        imageView.setOnClickListener(clickListener);
    }

    public void setDrawableStartTint(ColorStateList color) {
        ImageView imageView = null;
        if (color != null) {
            ImageView imageView2 = this.startDrawableImg;
            if (imageView2 == null) {
                AbstractC13042fc3.y("startDrawableImg");
            } else {
                imageView = imageView2;
            }
            imageView.setColorFilter(color.getDefaultColor());
            return;
        }
        ImageView imageView3 = this.startDrawableImg;
        if (imageView3 == null) {
            AbstractC13042fc3.y("startDrawableImg");
            imageView3 = null;
        }
        imageView3.setColorFilter((ColorFilter) null);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        int iG0 = enabled ? C5495Jo7.a.G0() : C5495Jo7.a.I0();
        MaterialCardView materialCardView = this.cardRoot;
        EditText editText = null;
        if (materialCardView == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView = null;
        }
        materialCardView.setCardBackgroundColor(iG0);
        setBackgroundColor(iG0);
        EditText editText2 = this.inputEt;
        if (editText2 == null) {
            AbstractC13042fc3.y("inputEt");
        } else {
            editText = editText2;
        }
        editText.setEnabled(enabled);
        super.setEnabled(enabled);
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public void setErrorStroke(boolean error) {
        D20 d20;
        D20 d202;
        D20 d203;
        MaterialCardView materialCardView = this.cardRoot;
        TextView textView = null;
        if (materialCardView == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView = null;
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        materialCardView.setStrokeColor(c5495Jo7.J0());
        if (error) {
            MaterialCardView materialCardView2 = this.cardRoot;
            if (materialCardView2 == null) {
                AbstractC13042fc3.y("cardRoot");
                materialCardView2 = null;
            }
            materialCardView2.setStrokeWidth((int) ((this.cardStrokeWidthAttr * AbstractC3742Cd6.c()) + 0.5d));
            TextView textView2 = this.hintTv;
            if (textView2 == null) {
                AbstractC13042fc3.y("hintTv");
                textView2 = null;
            }
            textView2.setTextColor(c5495Jo7.J0());
            EditText editText = this.inputEt;
            if (editText == null) {
                AbstractC13042fc3.y("inputEt");
                editText = null;
            }
            editText.setHintTextColor(c5495Jo7.J0());
            EditText editText2 = this.inputEt;
            if (editText2 == null) {
                AbstractC13042fc3.y("inputEt");
                editText2 = null;
            }
            editText2.setTextColor(c5495Jo7.J0());
            TextView textView3 = this.postfixTxt;
            if (textView3 == null) {
                AbstractC13042fc3.y("postfixTxt");
            } else {
                textView = textView3;
            }
            textView.setTextColor(c5495Jo7.J0());
            return;
        }
        Companion companion = INSTANCE;
        EditText editText3 = this.inputEt;
        if (editText3 == null) {
            AbstractC13042fc3.y("inputEt");
            editText3 = null;
        }
        if (AbstractC13042fc3.d(companion.a(ZY6.a(editText3.getText().toString())), Boolean.FALSE)) {
            return;
        }
        D20 d204 = this.drawableStartTooltip;
        if (d204 != null && d204.m0() && (d203 = this.drawableStartTooltip) != null) {
            d203.E();
        }
        D20 d205 = this.hintTooltip;
        if (d205 != null && d205.m0() && (d202 = this.hintTooltip) != null) {
            d202.E();
        }
        D20 d206 = this.inputTooltip;
        if (d206 != null && d206.m0() && (d20 = this.inputTooltip) != null) {
            d20.E();
        }
        MaterialCardView materialCardView3 = this.cardRoot;
        if (materialCardView3 == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView3 = null;
        }
        materialCardView3.setStrokeColor(c5495Jo7.M0());
        EditText editText4 = this.inputEt;
        if (editText4 == null) {
            AbstractC13042fc3.y("inputEt");
            editText4 = null;
        }
        if (editText4.hasFocus()) {
            MaterialCardView materialCardView4 = this.cardRoot;
            if (materialCardView4 == null) {
                AbstractC13042fc3.y("cardRoot");
                materialCardView4 = null;
            }
            materialCardView4.setStrokeWidth((int) ((this.cardStrokeWidthAttr * AbstractC3742Cd6.c()) + 0.5d));
        } else {
            MaterialCardView materialCardView5 = this.cardRoot;
            if (materialCardView5 == null) {
                AbstractC13042fc3.y("cardRoot");
                materialCardView5 = null;
            }
            materialCardView5.setStrokeWidth(0);
        }
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(c5495Jo7.o0());
        AbstractC13042fc3.h(colorStateListValueOf, "valueOf(...)");
        ColorStateList colorStateListValueOf2 = ColorStateList.valueOf(c5495Jo7.o0());
        AbstractC13042fc3.h(colorStateListValueOf2, "valueOf(...)");
        ColorStateList colorStateListValueOf3 = ColorStateList.valueOf(c5495Jo7.g0());
        AbstractC13042fc3.h(colorStateListValueOf3, "valueOf(...)");
        ColorStateList colorStateList = this.hintTextColorAttr;
        if (colorStateList != null) {
            colorStateListValueOf = colorStateList;
        }
        ColorStateList colorStateList2 = this.inputHintColorAttr;
        if (colorStateList2 != null) {
            colorStateListValueOf2 = colorStateList2;
        }
        ColorStateList colorStateList3 = this.textColorAttr;
        if (colorStateList3 != null) {
            colorStateListValueOf3 = colorStateList3;
        }
        TextView textView4 = this.hintTv;
        if (textView4 == null) {
            AbstractC13042fc3.y("hintTv");
            textView4 = null;
        }
        textView4.setTextColor(colorStateListValueOf);
        EditText editText5 = this.inputEt;
        if (editText5 == null) {
            AbstractC13042fc3.y("inputEt");
            editText5 = null;
        }
        editText5.setHintTextColor(colorStateListValueOf2);
        EditText editText6 = this.inputEt;
        if (editText6 == null) {
            AbstractC13042fc3.y("inputEt");
            editText6 = null;
        }
        editText6.setTextColor(colorStateListValueOf3);
        TextView textView5 = this.postfixTxt;
        if (textView5 == null) {
            AbstractC13042fc3.y("postfixTxt");
        } else {
            textView = textView5;
        }
        textView.setTextColor(colorStateListValueOf3);
    }

    public void setFocusChangeListener(View.OnFocusChangeListener focusChangeListener) {
        AbstractC13042fc3.i(focusChangeListener, "focusChangeListener");
        this.focusChangeListener = focusChangeListener;
    }

    @Override // android.view.View
    public void setFocusable(boolean focusable) {
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setEnabled(focusable);
        super.setFocusable(focusable);
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public void setHint(String hint) {
        TextView textView = this.hintTv;
        if (textView == null) {
            AbstractC13042fc3.y("hintTv");
            textView = null;
        }
        textView.setText(hint);
    }

    public void setHintError(final String message) {
        AbstractC13042fc3.i(message, DialogEntity.COLUMN_MESSAGE);
        try {
            if (AbstractC20153rZ6.E(this.hintTooltipMessage, message, false, 2, null)) {
                return;
            }
            this.hintTooltipMessage = message;
            D20 d20 = this.hintTooltip;
            if (d20 != null) {
                d20.E();
            }
            postDelayed(new Runnable() { // from class: ir.nasim.gx1
                @Override // java.lang.Runnable
                public final void run() {
                    CustomInputView.D(this.a, message);
                }
            }, 50L);
            setErrorStroke(true);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public void setHintSize(float size) {
        TextView textView = this.hintTv;
        if (textView == null) {
            AbstractC13042fc3.y("hintTv");
            textView = null;
        }
        textView.setTextSize(size);
    }

    public void setHintTextColor(ColorStateList color) {
        AbstractC13042fc3.i(color, "color");
        TextView textView = this.hintTv;
        if (textView == null) {
            AbstractC13042fc3.y("hintTv");
            textView = null;
        }
        textView.setTextColor(color);
    }

    public void setHintTypeFace(Typeface typeFace) {
        TextView textView = this.hintTv;
        if (textView == null) {
            AbstractC13042fc3.y("hintTv");
            textView = null;
        }
        textView.setTypeface(typeFace);
    }

    public void setHintVisibility(int visibility) {
        TextView textView = this.hintTv;
        if (textView == null) {
            AbstractC13042fc3.y("hintTv");
            textView = null;
        }
        textView.setVisibility(visibility);
    }

    public void setInputError(final String message) {
        AbstractC13042fc3.i(message, DialogEntity.COLUMN_MESSAGE);
        try {
            if (AbstractC20153rZ6.E(this.inputTooltipMessage, message, false, 2, null)) {
                return;
            }
            this.inputTooltipMessage = message;
            D20 d20 = this.inputTooltip;
            if (d20 != null) {
                d20.E();
            }
            postDelayed(new Runnable() { // from class: ir.nasim.jx1
                @Override // java.lang.Runnable
                public final void run() {
                    CustomInputView.G(this.a, message);
                }
            }, 50L);
            setErrorStroke(true);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public void setInputHint(String hint) {
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setHint(hint);
    }

    public void setInputHintColor(ColorStateList color) {
        AbstractC13042fc3.i(color, "color");
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setHintTextColor(color);
    }

    public void setInputType(int type) {
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setInputType(type);
    }

    public void setKeyListener(DigitsKeyListener digitsKeyListener) {
        AbstractC13042fc3.i(digitsKeyListener, "digitsKeyListener");
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setKeyListener(digitsKeyListener);
    }

    public void setLines(int lines) {
        if (lines > 0) {
            EditText editText = this.inputEt;
            if (editText == null) {
                AbstractC13042fc3.y("inputEt");
                editText = null;
            }
            editText.setLines(lines);
        }
    }

    public void setMaxLength(int length) {
        EditText editText = null;
        if (length > -1) {
            EditText editText2 = this.inputEt;
            if (editText2 == null) {
                AbstractC13042fc3.y("inputEt");
            } else {
                editText = editText2;
            }
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(length)});
            return;
        }
        EditText editText3 = this.inputEt;
        if (editText3 == null) {
            AbstractC13042fc3.y("inputEt");
        } else {
            editText = editText3;
        }
        editText.setFilters(new InputFilter[0]);
    }

    public void setMaxLines(int lines) {
        if (lines > 0) {
            EditText editText = this.inputEt;
            if (editText == null) {
                AbstractC13042fc3.y("inputEt");
                editText = null;
            }
            editText.setMaxLines(lines);
        }
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public void setPostfix(String postfix) {
        TextView textView = this.postfixTxt;
        if (textView == null) {
            AbstractC13042fc3.y("postfixTxt");
            textView = null;
        }
        textView.setText(postfix);
    }

    public void setSelection(int index) {
        try {
            EditText editText = this.inputEt;
            if (editText == null) {
                AbstractC13042fc3.y("inputEt");
                editText = null;
            }
            editText.setSelection(index);
        } catch (Exception unused) {
        }
    }

    public void setStartDrawableError(final String message) {
        AbstractC13042fc3.i(message, DialogEntity.COLUMN_MESSAGE);
        try {
            if (AbstractC20153rZ6.E(this.drawableStartTooltipMessage, message, false, 2, null)) {
                return;
            }
            this.drawableStartTooltipMessage = message;
            D20 d20 = this.drawableStartTooltip;
            if (d20 != null) {
                d20.E();
            }
            postDelayed(new Runnable() { // from class: ir.nasim.ex1
                @Override // java.lang.Runnable
                public final void run() {
                    CustomInputView.J(this.a, message);
                }
            }, 50L);
            setErrorStroke(true);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    @Override // ir.nasim.InterfaceC12049dx1
    public void setText(String text) {
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setText(text);
    }

    public void setTextColor(ColorStateList color) {
        AbstractC13042fc3.i(color, "color");
        EditText editText = this.inputEt;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setTextColor(color);
        TextView textView2 = this.postfixTxt;
        if (textView2 == null) {
            AbstractC13042fc3.y("postfixTxt");
        } else {
            textView = textView2;
        }
        textView.setTextColor(color);
    }

    public void setTextSize(float size) {
        EditText editText = this.inputEt;
        TextView textView = null;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setTextSize(size);
        TextView textView2 = this.postfixTxt;
        if (textView2 == null) {
            AbstractC13042fc3.y("postfixTxt");
        } else {
            textView = textView2;
        }
        textView.setTextSize(size);
    }

    public void setTextTypeFace(Typeface typeFace) {
        EditText editText = this.inputEt;
        if (editText == null) {
            AbstractC13042fc3.y("inputEt");
            editText = null;
        }
        editText.setTypeface(typeFace);
    }

    public void setBackgroundTint(int color) {
        MaterialCardView materialCardView = this.cardRoot;
        if (materialCardView == null) {
            AbstractC13042fc3.y("cardRoot");
            materialCardView = null;
        }
        materialCardView.setCardBackgroundColor(color);
    }

    public void setHintTextColor(int color) {
        TextView textView = this.hintTv;
        if (textView == null) {
            AbstractC13042fc3.y("hintTv");
            textView = null;
        }
        textView.setTextColor(color);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        this.widthAttr = -1;
        this.heightAttr = -2;
        this.cardCornerRadiusAttr = 5;
        this.cardElevationAttr = 5;
        this.cardStrokeWidthAttr = 2;
        this.hintSizeAttr = 14.0f;
        this.textSizeAttr = 14.0f;
        this.maxLengthAttr = -1;
        this.lines = 1;
        this.maxLines = 1;
        this.isSourceInput = true;
        this.types = new ArrayList();
        u(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.widthAttr = -1;
        this.heightAttr = -2;
        this.cardCornerRadiusAttr = 5;
        this.cardElevationAttr = 5;
        this.cardStrokeWidthAttr = 2;
        this.hintSizeAttr = 14.0f;
        this.textSizeAttr = 14.0f;
        this.maxLengthAttr = -1;
        this.lines = 1;
        this.maxLines = 1;
        this.isSourceInput = true;
        this.types = new ArrayList();
        u(context, attributeSet);
    }
}
