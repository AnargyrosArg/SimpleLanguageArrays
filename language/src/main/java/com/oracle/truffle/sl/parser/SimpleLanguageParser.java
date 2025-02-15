// Generated from SimpleLanguage.g4 by ANTLR 4.12.0
package com.oracle.truffle.sl.parser;

// DO NOT MODIFY - generated from SimpleLanguage.g4 using "mx create-sl-parser"


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;


import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.sl.SLLanguage;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.nodes.SLStatementNode;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		WS=32, COMMENT=33, LINE_COMMENT=34, ARRAY_LITERAL_INTERNAL=35, IDENTIFIER=36, 
		STRING_LITERAL=37, NUMERIC_LITERAL=38;
	public static final int
		RULE_simplelanguage = 0, RULE_function = 1, RULE_block = 2, RULE_statement = 3, 
		RULE_while_statement = 4, RULE_if_statement = 5, RULE_return_statement = 6, 
		RULE_expression = 7, RULE_logic_term = 8, RULE_logic_factor = 9, RULE_arithmetic = 10, 
		RULE_term = 11, RULE_factor = 12, RULE_member_expression = 13, RULE_array = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"simplelanguage", "function", "block", "statement", "while_statement", 
			"if_statement", "return_statement", "expression", "logic_term", "logic_factor", 
			"arithmetic", "term", "factor", "member_expression", "array"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'('", "','", "')'", "'{'", "'}'", "'break'", "';'", 
			"'continue'", "'debugger'", "'while'", "'if'", "'else'", "'return'", 
			"'||'", "'&&'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'+'", 
			"'-'", "'vec_add'", "'*'", "'/'", "'='", "'.'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
			"ARRAY_LITERAL_INTERNAL", "IDENTIFIER", "STRING_LITERAL", "NUMERIC_LITERAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpleLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private SLNodeFactory factory;
	private Source source;

	private static final class BailoutErrorListener extends BaseErrorListener {
	    private final Source source;
	    BailoutErrorListener(Source source) {
	        this.source = source;
	    }
	    @Override
	    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
	        throwParseError(source, line, charPositionInLine, (Token) offendingSymbol, msg);
	    }
	}

	public void SemErr(Token token, String message) {
	    assert token != null;
	    throwParseError(source, token.getLine(), token.getCharPositionInLine(), token, message);
	}

	private static void throwParseError(Source source, int line, int charPositionInLine, Token token, String message) {
	    int col = charPositionInLine + 1;
	    String location = "-- line " + line + " col " + col + ": ";
	    int length = token == null ? 1 : Math.max(token.getStopIndex() - token.getStartIndex(), 0);
	    throw new SLParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
	}

	public static Map<TruffleString, RootCallTarget> parseSL(SLLanguage language, Source source) {
	    SimpleLanguageLexer lexer = new SimpleLanguageLexer(CharStreams.fromString(source.getCharacters().toString()));
	    SimpleLanguageParser parser = new SimpleLanguageParser(new CommonTokenStream(lexer));
	    lexer.removeErrorListeners();
	    parser.removeErrorListeners();
	    BailoutErrorListener listener = new BailoutErrorListener(source);
	    lexer.addErrorListener(listener);
	    parser.addErrorListener(listener);
	    parser.factory = new SLNodeFactory(language, source);
	    parser.source = source;
	    parser.simplelanguage();
	    return parser.factory.getAllFunctions();
	}

	public SimpleLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimplelanguageContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(SimpleLanguageParser.EOF, 0); }
		public SimplelanguageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simplelanguage; }
	}

	public final SimplelanguageContext simplelanguage() throws RecognitionException {
		SimplelanguageContext _localctx = new SimplelanguageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_simplelanguage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			function();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(31);
				function();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public Token s;
		public BlockContext body;
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimpleLanguageParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimpleLanguageParser.IDENTIFIER, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__0);
			setState(40);
			((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(41);
			((FunctionContext)_localctx).s = match(T__1);
			 factory.startFunction(((FunctionContext)_localctx).IDENTIFIER, ((FunctionContext)_localctx).s); 
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(43);
				((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 factory.addFormalParameter(((FunctionContext)_localctx).IDENTIFIER); 
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(45);
					match(T__2);
					setState(46);
					((FunctionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
					 factory.addFormalParameter(((FunctionContext)_localctx).IDENTIFIER); 
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(55);
			match(T__3);
			setState(56);
			((FunctionContext)_localctx).body = block(false);
			 factory.finishFunction(((FunctionContext)_localctx).body.result); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public boolean inLoop;
		public SLStatementNode result;
		public Token s;
		public StatementContext statement;
		public Token e;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BlockContext(ParserRuleContext parent, int invokingState, boolean inLoop) {
			super(parent, invokingState);
			this.inLoop = inLoop;
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block(boolean inLoop) throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState(), inLoop);
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 factory.startBlock();
			                                                  List<SLStatementNode> body = new ArrayList<>(); 
			setState(60);
			((BlockContext)_localctx).s = match(T__4);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 516469841540L) != 0)) {
				{
				{
				setState(61);
				((BlockContext)_localctx).statement = statement(inLoop);
				 body.add(((BlockContext)_localctx).statement.result); 
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			((BlockContext)_localctx).e = match(T__5);
			 ((BlockContext)_localctx).result =  factory.finishBlock(body, ((BlockContext)_localctx).s.getStartIndex(), ((BlockContext)_localctx).e.getStopIndex() - ((BlockContext)_localctx).s.getStartIndex() + 1); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public boolean inLoop;
		public SLStatementNode result;
		public While_statementContext while_statement;
		public Token b;
		public Token c;
		public If_statementContext if_statement;
		public Return_statementContext return_statement;
		public ExpressionContext expression;
		public Token d;
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public StatementContext(ParserRuleContext parent, int invokingState, boolean inLoop) {
			super(parent, invokingState);
			this.inLoop = inLoop;
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement(boolean inLoop) throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState(), inLoop);
		enterRule(_localctx, 6, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(72);
				((StatementContext)_localctx).while_statement = while_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).while_statement.result; 
				}
				break;
			case T__6:
				{
				setState(75);
				((StatementContext)_localctx).b = match(T__6);
				 if (inLoop) { ((StatementContext)_localctx).result =  factory.createBreak(((StatementContext)_localctx).b); } else { SemErr(((StatementContext)_localctx).b, "break used outside of loop"); } 
				setState(77);
				match(T__7);
				}
				break;
			case T__8:
				{
				setState(78);
				((StatementContext)_localctx).c = match(T__8);
				 if (inLoop) { ((StatementContext)_localctx).result =  factory.createContinue(((StatementContext)_localctx).c); } else { SemErr(((StatementContext)_localctx).c, "continue used outside of loop"); } 
				setState(80);
				match(T__7);
				}
				break;
			case T__11:
				{
				setState(81);
				((StatementContext)_localctx).if_statement = if_statement(inLoop);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).if_statement.result; 
				}
				break;
			case T__13:
				{
				setState(84);
				((StatementContext)_localctx).return_statement = return_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).return_statement.result; 
				}
				break;
			case T__1:
			case T__29:
			case ARRAY_LITERAL_INTERNAL:
			case IDENTIFIER:
			case STRING_LITERAL:
			case NUMERIC_LITERAL:
				{
				setState(87);
				((StatementContext)_localctx).expression = expression();
				setState(88);
				match(T__7);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).expression.result; 
				}
				break;
			case T__9:
				{
				setState(91);
				((StatementContext)_localctx).d = match(T__9);
				 ((StatementContext)_localctx).result =  factory.createDebugger(((StatementContext)_localctx).d); 
				setState(93);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_statementContext extends ParserRuleContext {
		public SLStatementNode result;
		public Token w;
		public ExpressionContext condition;
		public BlockContext body;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((While_statementContext)_localctx).w = match(T__10);
			setState(97);
			match(T__1);
			setState(98);
			((While_statementContext)_localctx).condition = expression();
			setState(99);
			match(T__3);
			setState(100);
			((While_statementContext)_localctx).body = block(true);
			 ((While_statementContext)_localctx).result =  factory.createWhile(((While_statementContext)_localctx).w, ((While_statementContext)_localctx).condition.result, ((While_statementContext)_localctx).body.result); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_statementContext extends ParserRuleContext {
		public boolean inLoop;
		public SLStatementNode result;
		public Token i;
		public ExpressionContext condition;
		public BlockContext then;
		public BlockContext block;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public If_statementContext(ParserRuleContext parent, int invokingState, boolean inLoop) {
			super(parent, invokingState);
			this.inLoop = inLoop;
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement(boolean inLoop) throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState(), inLoop);
		enterRule(_localctx, 10, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			((If_statementContext)_localctx).i = match(T__11);
			setState(104);
			match(T__1);
			setState(105);
			((If_statementContext)_localctx).condition = expression();
			setState(106);
			match(T__3);
			setState(107);
			((If_statementContext)_localctx).then = ((If_statementContext)_localctx).block = block(inLoop);
			 SLStatementNode elsePart = null; 
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(109);
				match(T__12);
				setState(110);
				((If_statementContext)_localctx).block = block(inLoop);
				 elsePart = ((If_statementContext)_localctx).block.result; 
				}
			}

			 ((If_statementContext)_localctx).result =  factory.createIf(((If_statementContext)_localctx).i, ((If_statementContext)_localctx).condition.result, ((If_statementContext)_localctx).then.result, elsePart); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_statementContext extends ParserRuleContext {
		public SLStatementNode result;
		public Token r;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			((Return_statementContext)_localctx).r = match(T__13);
			 SLExpressionNode value = null; 
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 516469817348L) != 0)) {
				{
				setState(119);
				((Return_statementContext)_localctx).expression = expression();
				 value = ((Return_statementContext)_localctx).expression.result; 
				}
			}

			 ((Return_statementContext)_localctx).result =  factory.createReturn(((Return_statementContext)_localctx).r, value); 
			setState(125);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Logic_termContext logic_term;
		public Token op;
		public List<Logic_termContext> logic_term() {
			return getRuleContexts(Logic_termContext.class);
		}
		public Logic_termContext logic_term(int i) {
			return getRuleContext(Logic_termContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			((ExpressionContext)_localctx).logic_term = logic_term();
			 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).logic_term.result; 
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(129);
					((ExpressionContext)_localctx).op = match(T__14);
					setState(130);
					((ExpressionContext)_localctx).logic_term = logic_term();
					 ((ExpressionContext)_localctx).result =  factory.createBinary(((ExpressionContext)_localctx).op, _localctx.result, ((ExpressionContext)_localctx).logic_term.result); 
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_termContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Logic_factorContext logic_factor;
		public Token op;
		public List<Logic_factorContext> logic_factor() {
			return getRuleContexts(Logic_factorContext.class);
		}
		public Logic_factorContext logic_factor(int i) {
			return getRuleContext(Logic_factorContext.class,i);
		}
		public Logic_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_term; }
	}

	public final Logic_termContext logic_term() throws RecognitionException {
		Logic_termContext _localctx = new Logic_termContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logic_term);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((Logic_termContext)_localctx).logic_factor = logic_factor();
			 ((Logic_termContext)_localctx).result =  ((Logic_termContext)_localctx).logic_factor.result; 
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(140);
					((Logic_termContext)_localctx).op = match(T__15);
					setState(141);
					((Logic_termContext)_localctx).logic_factor = logic_factor();
					 ((Logic_termContext)_localctx).result =  factory.createBinary(((Logic_termContext)_localctx).op, _localctx.result, ((Logic_termContext)_localctx).logic_factor.result); 
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_factorContext extends ParserRuleContext {
		public SLExpressionNode result;
		public ArithmeticContext arithmetic;
		public Token op;
		public List<ArithmeticContext> arithmetic() {
			return getRuleContexts(ArithmeticContext.class);
		}
		public ArithmeticContext arithmetic(int i) {
			return getRuleContext(ArithmeticContext.class,i);
		}
		public Logic_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_factor; }
	}

	public final Logic_factorContext logic_factor() throws RecognitionException {
		Logic_factorContext _localctx = new Logic_factorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_logic_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			((Logic_factorContext)_localctx).arithmetic = arithmetic();
			 ((Logic_factorContext)_localctx).result =  ((Logic_factorContext)_localctx).arithmetic.result; 
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(151);
				((Logic_factorContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8257536L) != 0)) ) {
					((Logic_factorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(152);
				((Logic_factorContext)_localctx).arithmetic = arithmetic();
				 ((Logic_factorContext)_localctx).result =  factory.createBinary(((Logic_factorContext)_localctx).op, _localctx.result, ((Logic_factorContext)_localctx).arithmetic.result); 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticContext extends ParserRuleContext {
		public SLExpressionNode result;
		public TermContext term;
		public Token op;
		public ArrayContext array;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
		}
		public ArithmeticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic; }
	}

	public final ArithmeticContext arithmetic() throws RecognitionException {
		ArithmeticContext _localctx = new ArithmeticContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arithmetic);
		int _la;
		try {
			int _alt;
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				((ArithmeticContext)_localctx).term = term();
				 ((ArithmeticContext)_localctx).result =  ((ArithmeticContext)_localctx).term.result; 
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(159);
						((ArithmeticContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((ArithmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(160);
						((ArithmeticContext)_localctx).term = term();
						 ((ArithmeticContext)_localctx).result =  factory.createBinary(((ArithmeticContext)_localctx).op, _localctx.result, ((ArithmeticContext)_localctx).term.result); 
						}
						} 
					}
					setState(167);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				((ArithmeticContext)_localctx).array = array();
				 ((ArithmeticContext)_localctx).result =  ((ArithmeticContext)_localctx).array.result; 
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(170);
						((ArithmeticContext)_localctx).op = match(T__24);
						setState(171);
						((ArithmeticContext)_localctx).array = array();
						 ((ArithmeticContext)_localctx).result =  factory.createBinary(((ArithmeticContext)_localctx).op, _localctx.result, ((ArithmeticContext)_localctx).array.result); 
						}
						} 
					}
					setState(178);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public SLExpressionNode result;
		public FactorContext factor;
		public Token op;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_term);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			((TermContext)_localctx).factor = factor();
			 ((TermContext)_localctx).result =  ((TermContext)_localctx).factor.result; 
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(183);
					((TermContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__25 || _la==T__26) ) {
						((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(184);
					((TermContext)_localctx).factor = factor();
					 ((TermContext)_localctx).result =  factory.createBinary(((TermContext)_localctx).op, _localctx.result, ((TermContext)_localctx).factor.result); 
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Token IDENTIFIER;
		public Member_expressionContext member_expression;
		public Token STRING_LITERAL;
		public Token NUMERIC_LITERAL;
		public Token s;
		public ExpressionContext expr;
		public Token e;
		public TerminalNode IDENTIFIER() { return getToken(SimpleLanguageParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(SimpleLanguageParser.STRING_LITERAL, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(SimpleLanguageParser.NUMERIC_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Member_expressionContext member_expression() {
			return getRuleContext(Member_expressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(192);
				((FactorContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 SLExpressionNode assignmentName = factory.createStringLiteral(((FactorContext)_localctx).IDENTIFIER, false); 
				setState(198);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(194);
					((FactorContext)_localctx).member_expression = member_expression(null, null, assignmentName);
					 ((FactorContext)_localctx).result =  ((FactorContext)_localctx).member_expression.result; 
					}
					break;
				case 2:
					{
					 ((FactorContext)_localctx).result =  factory.createRead(assignmentName); 
					}
					break;
				}
				}
				break;
			case STRING_LITERAL:
				{
				setState(200);
				((FactorContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((FactorContext)_localctx).result =  factory.createStringLiteral(((FactorContext)_localctx).STRING_LITERAL, true); 
				}
				break;
			case NUMERIC_LITERAL:
				{
				setState(202);
				((FactorContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
				 ((FactorContext)_localctx).result =  factory.createNumericLiteral(((FactorContext)_localctx).NUMERIC_LITERAL); 
				}
				break;
			case T__1:
				{
				setState(204);
				((FactorContext)_localctx).s = match(T__1);
				setState(205);
				((FactorContext)_localctx).expr = expression();
				setState(206);
				((FactorContext)_localctx).e = match(T__3);
				 ((FactorContext)_localctx).result =  factory.createParenExpression(((FactorContext)_localctx).expr.result, ((FactorContext)_localctx).s.getStartIndex(), ((FactorContext)_localctx).e.getStopIndex() - ((FactorContext)_localctx).s.getStartIndex() + 1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Member_expressionContext extends ParserRuleContext {
		public SLExpressionNode r;
		public SLExpressionNode assignmentReceiver;
		public SLExpressionNode assignmentName;
		public SLExpressionNode result;
		public ExpressionContext expression;
		public Token e;
		public Token IDENTIFIER;
		public Member_expressionContext member_expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(SimpleLanguageParser.IDENTIFIER, 0); }
		public Member_expressionContext member_expression() {
			return getRuleContext(Member_expressionContext.class,0);
		}
		public Member_expressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Member_expressionContext(ParserRuleContext parent, int invokingState, SLExpressionNode r, SLExpressionNode assignmentReceiver, SLExpressionNode assignmentName) {
			super(parent, invokingState);
			this.r = r;
			this.assignmentReceiver = assignmentReceiver;
			this.assignmentName = assignmentName;
		}
		@Override public int getRuleIndex() { return RULE_member_expression; }
	}

	public final Member_expressionContext member_expression(SLExpressionNode r,SLExpressionNode assignmentReceiver,SLExpressionNode assignmentName) throws RecognitionException {
		Member_expressionContext _localctx = new Member_expressionContext(_ctx, getState(), r, assignmentReceiver, assignmentName);
		enterRule(_localctx, 26, RULE_member_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 SLExpressionNode receiver = r;
			                                                  SLExpressionNode nestedAssignmentName = null; 
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(212);
				match(T__1);
				 List<SLExpressionNode> parameters = new ArrayList<>();
				                                                  if (receiver == null) {
				                                                      receiver = factory.createRead(assignmentName);
				                                                  } 
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 516469817348L) != 0)) {
					{
					setState(214);
					((Member_expressionContext)_localctx).expression = expression();
					 parameters.add(((Member_expressionContext)_localctx).expression.result); 
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(216);
						match(T__2);
						setState(217);
						((Member_expressionContext)_localctx).expression = expression();
						 parameters.add(((Member_expressionContext)_localctx).expression.result); 
						}
						}
						setState(224);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(227);
				((Member_expressionContext)_localctx).e = match(T__3);
				 ((Member_expressionContext)_localctx).result =  factory.createCall(receiver, parameters, ((Member_expressionContext)_localctx).e); 
				}
				break;
			case T__27:
				{
				setState(229);
				match(T__27);
				setState(230);
				((Member_expressionContext)_localctx).expression = expression();
				 if (assignmentName == null) {
				                                                      SemErr((((Member_expressionContext)_localctx).expression!=null?(((Member_expressionContext)_localctx).expression.start):null), "invalid assignment target");
				                                                  } else if (assignmentReceiver == null) {
				                                                      ((Member_expressionContext)_localctx).result =  factory.createAssignment(assignmentName, ((Member_expressionContext)_localctx).expression.result);
				                                                  } else {
				                                                      ((Member_expressionContext)_localctx).result =  factory.createWriteProperty(assignmentReceiver, assignmentName, ((Member_expressionContext)_localctx).expression.result);
				                                                  } 
				}
				break;
			case T__28:
				{
				setState(233);
				match(T__28);
				 if (receiver == null) {
				                                                       receiver = factory.createRead(assignmentName);
				                                                  } 
				setState(235);
				((Member_expressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 nestedAssignmentName = factory.createStringLiteral(((Member_expressionContext)_localctx).IDENTIFIER, false);
				                                                  ((Member_expressionContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				}
				break;
			case T__29:
				{
				setState(237);
				match(T__29);
				 if (receiver == null) {
				                                                      receiver = factory.createRead(assignmentName);
				                                                  } 
				setState(239);
				((Member_expressionContext)_localctx).expression = expression();
				 nestedAssignmentName = ((Member_expressionContext)_localctx).expression.result;
				                                                  ((Member_expressionContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				setState(241);
				match(T__30);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(245);
				((Member_expressionContext)_localctx).member_expression = member_expression(_localctx.result, receiver, nestedAssignmentName);
				 ((Member_expressionContext)_localctx).result =  ((Member_expressionContext)_localctx).member_expression.result; 
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public SLExpressionNode result;
		public Token s;
		public Token NUMERIC_LITERAL;
		public Token e;
		public Token IDENTIFIER;
		public Member_expressionContext member_expression;
		public Token ARRAY_LITERAL_INTERNAL;
		public TerminalNode IDENTIFIER() { return getToken(SimpleLanguageParser.IDENTIFIER, 0); }
		public TerminalNode ARRAY_LITERAL_INTERNAL() { return getToken(SimpleLanguageParser.ARRAY_LITERAL_INTERNAL, 0); }
		public Member_expressionContext member_expression() {
			return getRuleContext(Member_expressionContext.class,0);
		}
		public List<TerminalNode> NUMERIC_LITERAL() { return getTokens(SimpleLanguageParser.NUMERIC_LITERAL); }
		public TerminalNode NUMERIC_LITERAL(int i) {
			return getToken(SimpleLanguageParser.NUMERIC_LITERAL, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
				{
				setState(250);
				((ArrayContext)_localctx).s = match(T__29);
				   ArrayList<BigInteger> values = new ArrayList<>();  
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMERIC_LITERAL) {
					{
					setState(252);
					((ArrayContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
					   values.add(new BigInteger(((ArrayContext)_localctx).NUMERIC_LITERAL.getText())); 
					setState(259);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(254);
						match(T__2);
						setState(255);
						((ArrayContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
						   values.add(new BigInteger(((ArrayContext)_localctx).NUMERIC_LITERAL.getText())); 
						}
						}
						setState(261);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(264);
				((ArrayContext)_localctx).e = match(T__30);
				   ((ArrayContext)_localctx).result =  factory.createArray(values,((ArrayContext)_localctx).s,((ArrayContext)_localctx).e); 
				}
				break;
			case IDENTIFIER:
				{
				setState(266);
				((ArrayContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				   SLExpressionNode assignmentName = factory.createStringLiteral(((ArrayContext)_localctx).IDENTIFIER, false); 
				setState(272);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(268);
					((ArrayContext)_localctx).member_expression = member_expression(null, null, assignmentName);
					 ((ArrayContext)_localctx).result =  ((ArrayContext)_localctx).member_expression.result; 
					}
					break;
				case 2:
					{
					 ((ArrayContext)_localctx).result =  factory.createRead(assignmentName); 
					}
					break;
				}
				}
				break;
			case ARRAY_LITERAL_INTERNAL:
				{
				setState(274);
				((ArrayContext)_localctx).ARRAY_LITERAL_INTERNAL = match(ARRAY_LITERAL_INTERNAL);
				   ((ArrayContext)_localctx).result =  factory.createArrayInternal(((ArrayContext)_localctx).ARRAY_LITERAL_INTERNAL);   
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u0117\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0005\u0000!\b\u0000\n\u0000\f\u0000$\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00011\b\u0001\n\u0001\f\u0001"+
		"4\t\u0001\u0003\u00016\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002A\b\u0002\n\u0002\f\u0002D\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003_\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005r\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006{\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0086\b\u0007\n\u0007\f\u0007\u0089\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0091\b\b\n\b"+
		"\f\b\u0094\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t"+
		"\u009c\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00a4"+
		"\b\n\n\n\f\n\u00a7\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0005\n\u00af\b\n\n\n\f\n\u00b2\t\n\u0003\n\u00b4\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00bc"+
		"\b\u000b\n\u000b\f\u000b\u00bf\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0003\f\u00c7\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00d2\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00dd\b\r\n"+
		"\r\f\r\u00e0\t\r\u0003\r\u00e2\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00f4\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u00f9"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u0102\b\u000e\n\u000e\f\u000e\u0105\t\u000e"+
		"\u0003\u000e\u0107\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0111\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0115\b\u000e\u0001\u000e\u0000\u0000"+
		"\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u0000\u0003\u0001\u0000\u0011\u0016\u0001\u0000\u0017\u0018"+
		"\u0001\u0000\u001a\u001b\u0129\u0000\u001e\u0001\u0000\u0000\u0000\u0002"+
		"\'\u0001\u0000\u0000\u0000\u0004;\u0001\u0000\u0000\u0000\u0006^\u0001"+
		"\u0000\u0000\u0000\b`\u0001\u0000\u0000\u0000\ng\u0001\u0000\u0000\u0000"+
		"\fu\u0001\u0000\u0000\u0000\u000e\u007f\u0001\u0000\u0000\u0000\u0010"+
		"\u008a\u0001\u0000\u0000\u0000\u0012\u0095\u0001\u0000\u0000\u0000\u0014"+
		"\u00b3\u0001\u0000\u0000\u0000\u0016\u00b5\u0001\u0000\u0000\u0000\u0018"+
		"\u00d1\u0001\u0000\u0000\u0000\u001a\u00d3\u0001\u0000\u0000\u0000\u001c"+
		"\u0114\u0001\u0000\u0000\u0000\u001e\"\u0003\u0002\u0001\u0000\u001f!"+
		"\u0003\u0002\u0001\u0000 \u001f\u0001\u0000\u0000\u0000!$\u0001\u0000"+
		"\u0000\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#%\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%&\u0005\u0000\u0000\u0001"+
		"&\u0001\u0001\u0000\u0000\u0000\'(\u0005\u0001\u0000\u0000()\u0005$\u0000"+
		"\u0000)*\u0005\u0002\u0000\u0000*5\u0006\u0001\uffff\uffff\u0000+,\u0005"+
		"$\u0000\u0000,2\u0006\u0001\uffff\uffff\u0000-.\u0005\u0003\u0000\u0000"+
		"./\u0005$\u0000\u0000/1\u0006\u0001\uffff\uffff\u00000-\u0001\u0000\u0000"+
		"\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000"+
		"\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u00005+\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"78\u0005\u0004\u0000\u000089\u0003\u0004\u0002\u00009:\u0006\u0001\uffff"+
		"\uffff\u0000:\u0003\u0001\u0000\u0000\u0000;<\u0006\u0002\uffff\uffff"+
		"\u0000<B\u0005\u0005\u0000\u0000=>\u0003\u0006\u0003\u0000>?\u0006\u0002"+
		"\uffff\uffff\u0000?A\u0001\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000"+
		"AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000CE\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000EF\u0005\u0006"+
		"\u0000\u0000FG\u0006\u0002\uffff\uffff\u0000G\u0005\u0001\u0000\u0000"+
		"\u0000HI\u0003\b\u0004\u0000IJ\u0006\u0003\uffff\uffff\u0000J_\u0001\u0000"+
		"\u0000\u0000KL\u0005\u0007\u0000\u0000LM\u0006\u0003\uffff\uffff\u0000"+
		"M_\u0005\b\u0000\u0000NO\u0005\t\u0000\u0000OP\u0006\u0003\uffff\uffff"+
		"\u0000P_\u0005\b\u0000\u0000QR\u0003\n\u0005\u0000RS\u0006\u0003\uffff"+
		"\uffff\u0000S_\u0001\u0000\u0000\u0000TU\u0003\f\u0006\u0000UV\u0006\u0003"+
		"\uffff\uffff\u0000V_\u0001\u0000\u0000\u0000WX\u0003\u000e\u0007\u0000"+
		"XY\u0005\b\u0000\u0000YZ\u0006\u0003\uffff\uffff\u0000Z_\u0001\u0000\u0000"+
		"\u0000[\\\u0005\n\u0000\u0000\\]\u0006\u0003\uffff\uffff\u0000]_\u0005"+
		"\b\u0000\u0000^H\u0001\u0000\u0000\u0000^K\u0001\u0000\u0000\u0000^N\u0001"+
		"\u0000\u0000\u0000^Q\u0001\u0000\u0000\u0000^T\u0001\u0000\u0000\u0000"+
		"^W\u0001\u0000\u0000\u0000^[\u0001\u0000\u0000\u0000_\u0007\u0001\u0000"+
		"\u0000\u0000`a\u0005\u000b\u0000\u0000ab\u0005\u0002\u0000\u0000bc\u0003"+
		"\u000e\u0007\u0000cd\u0005\u0004\u0000\u0000de\u0003\u0004\u0002\u0000"+
		"ef\u0006\u0004\uffff\uffff\u0000f\t\u0001\u0000\u0000\u0000gh\u0005\f"+
		"\u0000\u0000hi\u0005\u0002\u0000\u0000ij\u0003\u000e\u0007\u0000jk\u0005"+
		"\u0004\u0000\u0000kl\u0003\u0004\u0002\u0000lq\u0006\u0005\uffff\uffff"+
		"\u0000mn\u0005\r\u0000\u0000no\u0003\u0004\u0002\u0000op\u0006\u0005\uffff"+
		"\uffff\u0000pr\u0001\u0000\u0000\u0000qm\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0006\u0005\uffff\uffff"+
		"\u0000t\u000b\u0001\u0000\u0000\u0000uv\u0005\u000e\u0000\u0000vz\u0006"+
		"\u0006\uffff\uffff\u0000wx\u0003\u000e\u0007\u0000xy\u0006\u0006\uffff"+
		"\uffff\u0000y{\u0001\u0000\u0000\u0000zw\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0006\u0006\uffff\uffff"+
		"\u0000}~\u0005\b\u0000\u0000~\r\u0001\u0000\u0000\u0000\u007f\u0080\u0003"+
		"\u0010\b\u0000\u0080\u0087\u0006\u0007\uffff\uffff\u0000\u0081\u0082\u0005"+
		"\u000f\u0000\u0000\u0082\u0083\u0003\u0010\b\u0000\u0083\u0084\u0006\u0007"+
		"\uffff\uffff\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0081\u0001"+
		"\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u000f\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b\u0003"+
		"\u0012\t\u0000\u008b\u0092\u0006\b\uffff\uffff\u0000\u008c\u008d\u0005"+
		"\u0010\u0000\u0000\u008d\u008e\u0003\u0012\t\u0000\u008e\u008f\u0006\b"+
		"\uffff\uffff\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008c\u0001"+
		"\u0000\u0000\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0011\u0001"+
		"\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0003"+
		"\u0014\n\u0000\u0096\u009b\u0006\t\uffff\uffff\u0000\u0097\u0098\u0007"+
		"\u0000\u0000\u0000\u0098\u0099\u0003\u0014\n\u0000\u0099\u009a\u0006\t"+
		"\uffff\uffff\u0000\u009a\u009c\u0001\u0000\u0000\u0000\u009b\u0097\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u0013\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0003\u0016\u000b\u0000\u009e\u00a5\u0006"+
		"\n\uffff\uffff\u0000\u009f\u00a0\u0007\u0001\u0000\u0000\u00a0\u00a1\u0003"+
		"\u0016\u000b\u0000\u00a1\u00a2\u0006\n\uffff\uffff\u0000\u00a2\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a3\u009f\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a6\u00b4\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0003\u001c\u000e\u0000\u00a9\u00b0\u0006"+
		"\n\uffff\uffff\u0000\u00aa\u00ab\u0005\u0019\u0000\u0000\u00ab\u00ac\u0003"+
		"\u001c\u000e\u0000\u00ac\u00ad\u0006\n\uffff\uffff\u0000\u00ad\u00af\u0001"+
		"\u0000\u0000\u0000\u00ae\u00aa\u0001\u0000\u0000\u0000\u00af\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b3\u009d\u0001\u0000\u0000\u0000\u00b3\u00a8\u0001"+
		"\u0000\u0000\u0000\u00b4\u0015\u0001\u0000\u0000\u0000\u00b5\u00b6\u0003"+
		"\u0018\f\u0000\u00b6\u00bd\u0006\u000b\uffff\uffff\u0000\u00b7\u00b8\u0007"+
		"\u0002\u0000\u0000\u00b8\u00b9\u0003\u0018\f\u0000\u00b9\u00ba\u0006\u000b"+
		"\uffff\uffff\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b7\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u0017\u0001"+
		"\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005"+
		"$\u0000\u0000\u00c1\u00c6\u0006\f\uffff\uffff\u0000\u00c2\u00c3\u0003"+
		"\u001a\r\u0000\u00c3\u00c4\u0006\f\uffff\uffff\u0000\u00c4\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c7\u0006\f\uffff\uffff\u0000\u00c6\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7\u00d2\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0005%\u0000\u0000\u00c9\u00d2\u0006\f"+
		"\uffff\uffff\u0000\u00ca\u00cb\u0005&\u0000\u0000\u00cb\u00d2\u0006\f"+
		"\uffff\uffff\u0000\u00cc\u00cd\u0005\u0002\u0000\u0000\u00cd\u00ce\u0003"+
		"\u000e\u0007\u0000\u00ce\u00cf\u0005\u0004\u0000\u0000\u00cf\u00d0\u0006"+
		"\f\uffff\uffff\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00c0\u0001"+
		"\u0000\u0000\u0000\u00d1\u00c8\u0001\u0000\u0000\u0000\u00d1\u00ca\u0001"+
		"\u0000\u0000\u0000\u00d1\u00cc\u0001\u0000\u0000\u0000\u00d2\u0019\u0001"+
		"\u0000\u0000\u0000\u00d3\u00f3\u0006\r\uffff\uffff\u0000\u00d4\u00d5\u0005"+
		"\u0002\u0000\u0000\u00d5\u00e1\u0006\r\uffff\uffff\u0000\u00d6\u00d7\u0003"+
		"\u000e\u0007\u0000\u00d7\u00de\u0006\r\uffff\uffff\u0000\u00d8\u00d9\u0005"+
		"\u0003\u0000\u0000\u00d9\u00da\u0003\u000e\u0007\u0000\u00da\u00db\u0006"+
		"\r\uffff\uffff\u0000\u00db\u00dd\u0001\u0000\u0000\u0000\u00dc\u00d8\u0001"+
		"\u0000\u0000\u0000\u00dd\u00e0\u0001\u0000\u0000\u0000\u00de\u00dc\u0001"+
		"\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1\u00d6\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0005\u0004\u0000\u0000\u00e4\u00f4\u0006"+
		"\r\uffff\uffff\u0000\u00e5\u00e6\u0005\u001c\u0000\u0000\u00e6\u00e7\u0003"+
		"\u000e\u0007\u0000\u00e7\u00e8\u0006\r\uffff\uffff\u0000\u00e8\u00f4\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0005\u001d\u0000\u0000\u00ea\u00eb\u0006"+
		"\r\uffff\uffff\u0000\u00eb\u00ec\u0005$\u0000\u0000\u00ec\u00f4\u0006"+
		"\r\uffff\uffff\u0000\u00ed\u00ee\u0005\u001e\u0000\u0000\u00ee\u00ef\u0006"+
		"\r\uffff\uffff\u0000\u00ef\u00f0\u0003\u000e\u0007\u0000\u00f0\u00f1\u0006"+
		"\r\uffff\uffff\u0000\u00f1\u00f2\u0005\u001f\u0000\u0000\u00f2\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f3\u00d4\u0001\u0000\u0000\u0000\u00f3\u00e5\u0001"+
		"\u0000\u0000\u0000\u00f3\u00e9\u0001\u0000\u0000\u0000\u00f3\u00ed\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f8\u0001\u0000\u0000\u0000\u00f5\u00f6\u0003"+
		"\u001a\r\u0000\u00f6\u00f7\u0006\r\uffff\uffff\u0000\u00f7\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f5\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f9\u001b\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005"+
		"\u001e\u0000\u0000\u00fb\u0106\u0006\u000e\uffff\uffff\u0000\u00fc\u00fd"+
		"\u0005&\u0000\u0000\u00fd\u0103\u0006\u000e\uffff\uffff\u0000\u00fe\u00ff"+
		"\u0005\u0003\u0000\u0000\u00ff\u0100\u0005&\u0000\u0000\u0100\u0102\u0006"+
		"\u000e\uffff\uffff\u0000\u0101\u00fe\u0001\u0000\u0000\u0000\u0102\u0105"+
		"\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104"+
		"\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103"+
		"\u0001\u0000\u0000\u0000\u0106\u00fc\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109"+
		"\u0005\u001f\u0000\u0000\u0109\u0115\u0006\u000e\uffff\uffff\u0000\u010a"+
		"\u010b\u0005$\u0000\u0000\u010b\u0110\u0006\u000e\uffff\uffff\u0000\u010c"+
		"\u010d\u0003\u001a\r\u0000\u010d\u010e\u0006\u000e\uffff\uffff\u0000\u010e"+
		"\u0111\u0001\u0000\u0000\u0000\u010f\u0111\u0006\u000e\uffff\uffff\u0000"+
		"\u0110\u010c\u0001\u0000\u0000\u0000\u0110\u010f\u0001\u0000\u0000\u0000"+
		"\u0111\u0115\u0001\u0000\u0000\u0000\u0112\u0113\u0005#\u0000\u0000\u0113"+
		"\u0115\u0006\u000e\uffff\uffff\u0000\u0114\u00fa\u0001\u0000\u0000\u0000"+
		"\u0114\u010a\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000"+
		"\u0115\u001d\u0001\u0000\u0000\u0000\u0018\"25B^qz\u0087\u0092\u009b\u00a5"+
		"\u00b0\u00b3\u00bd\u00c6\u00d1\u00de\u00e1\u00f3\u00f8\u0103\u0106\u0110"+
		"\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}