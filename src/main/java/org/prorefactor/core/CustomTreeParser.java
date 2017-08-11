package org.prorefactor.core;

import antlr.collections.AST;

public class CustomTreeParser extends antlr.TreeParser {

    @Override
    public void traceIn(String s, AST ast) {
        //super.traceIn(s, ast);
    }

    @Override
    public void traceOut(String s, AST ast) {
        //super.traceOut(s, ast);
    }
}