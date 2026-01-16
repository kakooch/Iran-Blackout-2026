package android.gov.nist.javax.sdp.parser;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sdp.fields.ProtoVersionField;
import android.gov.nist.javax.sdp.fields.SDPField;
import java.text.ParseException;

/* loaded from: classes.dex */
public class ProtoVersionFieldParser extends SDPParser {
    public ProtoVersionFieldParser(String str) {
        this.lexer = new Lexer("charLexer", str);
    }

    @Override // android.gov.nist.javax.sdp.parser.SDPParser
    public SDPField parse() {
        return protoVersionField();
    }

    public ProtoVersionField protoVersionField() throws ParseException {
        try {
            this.lexer.match(SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER);
            this.lexer.SPorHT();
            this.lexer.match(61);
            this.lexer.SPorHT();
            ProtoVersionField protoVersionField = new ProtoVersionField();
            this.lexer.match(4095);
            protoVersionField.setProtoVersion(Integer.parseInt(this.lexer.getNextToken().getTokenValue()));
            this.lexer.SPorHT();
            return protoVersionField;
        } catch (Exception unused) {
            throw this.lexer.createParseException();
        }
    }
}
