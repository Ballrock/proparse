package com.joanju.proparse;

import antlr.ParserSharedInputState;
import antlr.TokenBuffer;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.collections.AST;

public class ProParserCust extends ProParser {

    protected ProParserCust(TokenBuffer tokenBuf, int k) {
        super(tokenBuf, k);
    }

    public ProParserCust(TokenBuffer tokenBuf) {
        super(tokenBuf);
    }

    protected ProParserCust(TokenStream lexer, int k) {
        super(lexer, k);
    }

    public ProParserCust(TokenStream lexer) {
        super(lexer);
    }

    public ProParserCust(ParserSharedInputState state) {
        super(state);
    }

    @Override
    public void traceIndent() {
        //super.traceIndent();
    }

    @Override
    public void traceIn(String s) throws TokenStreamException {
        //super.traceIn(s);
    }

    @Override
    public void traceOut(String s) throws TokenStreamException {
        //super.traceOut(s);
    }
}
