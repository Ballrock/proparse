/* TokenTypes.java
 * Created on Nov 20, 2003
 * John Green
 *
 * Copyright (C) 2003-2011 Joanju Software (www.joanju.com)
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.prorefactor.core;

import org.apache.commons.lang.StringUtils;
import org.prorefactor.treeparserbase.JPTreeParserTokenTypes;
import com.joanju.proparse.NodeTypes;

/**
 * This static class provides information about Proparse's token types
 * as well as all of the static, final names for each token type.
 * NOTE: Now that Proparse has been rolled into this Java library, this
 * class is largely redundant with com.joanju.proparse.NodeTypes.
 * @See com.joanju.proparse.NodeTypes.
 */
public class TokenTypes implements JPTreeParserTokenTypes, TokenTypesI {

	private static class TokenInfo {
		boolean isNatural = true;
		String keywordText = null;
	}

	private static TokenInfo getInfo(int tokenType) {
		if (tokenType < 1 || tokenType > Last_Token_Number)
			return null;
		String typeName = NodeTypes.getTypeName(tokenType);
		if (StringUtils.isEmpty(typeName))
			return null;
		TokenInfo info = new TokenInfo();
		info.isNatural = typeName.equals(typeName.toUpperCase());
		info.keywordText = NodeTypes.getFullText(tokenType);
		return info;
	}
	
	/** For integer token types that represent a keyword in the
	 * syntax, this returns the full keyword text/name.
	 * @return null if invalid token type or is not a keyword according to Proparse.
	 * @see #hasDefaultText(int)
	 */
	public static String getDefaultText(int tokenType) {
		return NodeTypes.getFullText(tokenType);
	}

	/** Implements TokenTypesI, calls getTokenName(). */
	public String getName(int tokenType) {
		return getTokenName(tokenType);
	}

	/** Get the token name for this token type.
	 * @return null if invalid token type.
	 */
	public static String getTokenName(int tokenType) {
		if (tokenType < 1 || tokenType > Last_Token_Number)
			return null;
		return NodeTypes.getTypeName(tokenType);
	}
	
	/** A "natural" node is one that represents a real token in the
	 * original source code. A "synthetic" token is one that was created
	 * by the parser just for syntax tree organization.
	 * By convention, a natural node has a node name that is ALLCAPS, and
	 * a synthetic node has a node name which is Mixed_Case.
	 */
	public static boolean isNatural(int tokenType) {
		String typeName = NodeTypes.getTypeName(tokenType);
		if (StringUtils.isEmpty(typeName))
			return false;
		return typeName.equals(typeName.toUpperCase());
	}
	
	/** Proparse tracks keywords that are part of the syntax, but does not
	 * track keywords that are only attribute/method names. DISPLAY is
	 * a keyword type, ID is not.
	 * See Proparse's node attribute documentation for NODE_TYPE_KEYWORD.
	 */
	public static boolean hasDefaultText(int tokenType) {
		if (tokenType < 1 || tokenType > Last_Token_Number)
			return false;
		return !StringUtils.isEmpty(NodeTypes.getFullText(tokenType));
	}
	
	/** Is the integer a valid token type? */
	public static boolean isValid(int tokenType) {
		return !StringUtils.isEmpty(NodeTypes.getTypeName(tokenType));
	}

}
