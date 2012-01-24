package com.luc.analyzer;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.WhitespaceTokenizer;
import org.apache.lucene.util.Version;

import com.luc.filters.SSNFilter;

public class SSNAnalyzer extends Analyzer {
	
	@Override
	public TokenStream tokenStream(String fieldName, Reader reader) {	
		
		
		return new SSNFilter(false, new WhitespaceTokenizer(Version.LUCENE_35,reader));
		
	}

}
